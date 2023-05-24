package ms.coleta.ic.inova;

import idw.model.IdwFacade;
import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;
import idw.webservices.MswsComEvt;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.model.IwsFacade;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAndonArgsDTO;
import injetws.webservices.dto.IwsAndonDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsInspecaoManualDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsModDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsReleDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDTO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.inova.dto.INovaAndonDTO;
import ms.coleta.ic.inova.dto.INovaEventoPendenteDTO;
import ms.coleta.ic.inova.dto.INovaListaMatPrimaDTO;
import ms.coleta.ic.inova.dto.INovaReleDTO;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.coleta.ic.inova.protocolo.Protocolo;
import ms.coleta.ic.inova.trataevento.TrataEvento;
import ms.coleta.ic.inova.trataevento.TrataEventoFactory;
import ms.coleta.ic.inova.trataretorno.TrataRetorno;
import ms.coleta.ic.inova.trataretorno.TrataRetornoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.util.UtilsThreads;
import ms.webservice.Msws;

public class MSInova implements IIC {

	private IcDTO msgerenciado;

	public List<INovaUpDTO> Ups;
	private List<INovaUpDTO> upsAtualizadas;
	public Socket tc = null;
	private BufferedOutputStream nsOut = null;
	public BufferedInputStream nsIn = null;
	private boolean conectado = false;
	public boolean isIniciando = true;
	public boolean monitora = true;

	public String sapDbDsn = "";
	public String sapDbUser = "";
	public String sapDbPass = "";

	private String[] VetorCMD = { "EVENTO", "LIDO", "OK", "NOP", "ERRO",
			"SYNC", "PING", "EXC66", "WAITRESP" };

	public boolean isAndonAtivo = false;
	public boolean isAndonPrcsftAtivo = false;
	public boolean isValidaPorDsUsuario = false;
	public String cdUserAlerQuali = "";
	private String lastRESP = null;

	public IwsInspecaoManualDTO ultimaInspecao = new IwsInspecaoManualDTO();
	private int timeoutRetrySAP = 60;
	private int timeoutAtualizaDOAL = 0;
	private boolean isConectadoSAP = true;

	private List<INovaAndonDTO> ultimosParamAndon;
	public Calendar dataHoraUltimoEvento = null;
	private int lccount = 0;
	private Calendar refereciaRetryDoal = Calendar.getInstance();
	public boolean isListaAndonInicializada = false;
	public String idupUltimaInspec = "";
	private int maquinaAtual = 0;
	private int ultimaMaquina = 0;
	public String TecnicoCIP = null;
	public List<INovaListaMatPrimaDTO> listaMateriaPrimaUps = new ArrayList<INovaListaMatPrimaDTO>();
	public List<IwsProdMateriaPrimaDTO> matPrimaParaApontar = new ArrayList<IwsProdMateriaPrimaDTO>();

	public IwsParadaDTO ParadaSendoInformada = new IwsParadaDTO();
	public IwsRefugoDTO RefugoSendoInformado = new IwsRefugoDTO();

	private String versaoColetor = null;
	private List<INovaUpDTO> listaMngmtAndon = new ArrayList<INovaUpDTO>();
	private static final String versaoDriver = "1";

	private IdwLogger log = null;
	private Integer idLog = null;

	public String ipColetor = null;
	private Integer portaColetor = null;
	private String ipSeparador = ":";

	public INovaUpDTO icupdto = null;
	public String[] icDadosRecebidos = null;

	public boolean isBufferDeSaidaComErro = false;
	public IwsDadosApontamentoDTO dadosApontamentoDTO = new IwsDadosApontamentoDTO();
	private MswsComEvt ms = new MswsComEvt();

	public MSInova(IcDTO msgerenciado) {
		this.msgerenciado = msgerenciado;

		String urlConexao = msgerenciado.getUrl_conexao();

		if (urlConexao.indexOf(ipSeparador) != -1) {
			ipColetor = urlConexao.split(ipSeparador)[0];
			portaColetor = Integer.parseInt(urlConexao.split(ipSeparador)[1]);
		} else {
			ipColetor = urlConexao;
			portaColetor = 1000;
		}
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		log = msgerenciado.getLog();
		idLog = log.getIdAleatorio();

		log.info(idLog, 0,
				"chamando inicializaColetorSemEvento de inicializaIC");
		/*
		 * Adicionado por amaury pois o método inicializaColetorSemEvento dava
		 * nullpointException ao usar log.info
		 */
		this.log = log;
		inicializaColetorSemEvento();

		log.info(idLog, 0,
				"finalizou chamada inicializaColetorSemEvento de inicializaIC");
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg)
			throws SemComunicacaoICException {
		
		EventosColetados eventos = new EventosColetados();

		if (Stubdelegate.getInstancia().getEventoPendengo() != null) {
			try {
				enviaEventoPendente();

				Stubdelegate.getInstancia().setEventoPendengo(null);
			} catch (SemSGBDException e) {
				log.info(idLog, 0, "Evento pendente continua: "
						+ Stubdelegate.getInstancia().getEventoPendengo()
								.getEvento());
			}

		} else {
			String[] DadoRecebido;

			try {
				conectado = tc.isConnected();
			} catch (Exception e) {
				conectado = false;
			}
			// Luiz 16/05/2017 deve checar se o socket esta fechado ou
			// desconectado.
			// Luiz 01/06/2017 o buffer de saida pode acumular erro, caso
			// aconteca a flag isBufferDeSaidaComErro e setada para true
			if (conectado == false || tc.isClosed() || isBufferDeSaidaComErro) {
				reConectar();
			}

			if (conectado == true) {

				int i = 10;
				int retries = 0;
				int countPerdas = 0;

				while ((i != 1) && (countPerdas < 10)) {
					if (retries <= 0) {
						leEvento();
						UtilsThreads.pausaNaThread(100); // era 200
						retries = 5;
					}
					retries--;

					DadoRecebido = Util.PegaArgumentos(Protocolo.getInstancia()
							.RecebeDado(tc, nsIn, conectado));
					i = idEventos(DadoRecebido);

					if (i == 0) {
						lastRESP = null;
						retries = 0;
						lccount++;

						EventoColetado eventoColetado = trataEventoParaDTO(DadoRecebido);

						if (eventoColetado != null)
							eventos.addEventoColetado(eventoColetado);
						break;
						// TODO: ANDON TRATADO NO RETORNO
						// if(isAndonAtivo == true) {
						// try {
						// processaListaAndon();
						// }
						// catch (Exception e) {
						// log.info(idLog, 0, "err_ProcessaListaAndon");
						// log.info(idLog, 1, e.getMessage());
						// log.info(idLog, 1, e.getStackTrace());
						// log.info(idLog, 1, "---------------------");
						// }
						// }
					} else if (i == 7) {
						retries = 0;
						lccount++;
						// TODO: verificar o que fazer
						// try
						// {
						// List<String> dadosLog = new List<String>();
						// dadosLog.Add("Evento 66 desprezado por ter ficado dentro de um per�odo sem conex�o do coletor");
						// dadosLog.Add("---------------------");
						// geraLog("err_EXC66", dadosLog);
						// } catch(Exception e) { // n�o faz nada
						// }
					} else if (i == 1) {
						maquinaAtual = Integer.parseInt(DadoRecebido[1]);
						lccount++;
						break;
					} else if (i == 10) {
						countPerdas++;
					}
				}

				// TODO: verificar como fazer isso
				if (i != 10) {
					if (lccount > 28) {
						VerificaColetorDthr();
						lccount = 0;
						// limpaWatchDog();
					}

					if (ultimaMaquina == 0)
						ultimaMaquina = maquinaAtual;
					else if (ultimaMaquina != maquinaAtual) {
						INovaUpDTO up = getUP(maquinaAtual);

						if (up.isStIntegracaoDoal()) {
							setDoal(up);
						}

						ultimaMaquina = maquinaAtual;
					}
				}
			}
		}

		return (eventos);
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return versaoDriver;
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return versaoColetor;
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
	}

	@Override
	public void setParametro(ParametroDTO parametro) {

		TrataRetorno tratador = TrataRetornoFactory.getInstancia().getTratador(
				parametro);
		tratador.setParametro(parametro);
		tratador.setLog(log);
		tratador.setIdLog(idLog);
		tratador.setIc(this);

		try {
			tratador.trataRetorno();
		} catch (SemSGBDException e) {
			// para de tratar o retorno
			log.info(idLog, 0, "Sem SGBD. evento: " + parametro.getTipoEvento());
			if (Stubdelegate.getInstancia().getEventoPendengo() != null)
				log.info(idLog, 0, "Evento Pendente: "
						+ Stubdelegate.getInstancia().getEventoPendengo()
								.getEvento());
		}

		// TODO: TODOS SERVICOS DO INOVA DEVEM CHAMAR O RETORNO, POIS AQUI TRATA
		// O ANDON
		if (isAndonAtivo == true) {
			try {
				processaListaAndon();
			} catch (Exception e) {
				log.info(idLog, 0, "err_ProcessaListaAndon");
				log.info(idLog, 1, e.getMessage());
				log.info(idLog, 1, e.getStackTrace());
				log.info(idLog, 1, "---------------------");
			}
		}
	}

	private void VerificaColetorDthr() {
		log.info(idLog, 0, "VerificaColetorDThr");
		enviaDado("GETDTHR");
		UtilsThreads.pausaNaThread(100);
	}

	private void leEvento() {
		isBufferDeSaidaComErro = !enviaDado("LEEVNT;1;");
		// util.WaitSleep(100);
	}

	public boolean enviaDado(String Dado) {
		boolean enviado = false;
		enviado = Protocolo.getInstancia().EnviaDado(Dado, nsOut);
		if (!enviado) {
			do {
				reConectar();
				enviado = Protocolo.getInstancia().EnviaDado(Dado, nsOut);
				UtilsThreads.pausaNaThread(1000);
			} while (!enviado);
		}
		return enviado;
	}

	/*
	 * public boolean enviaDadoDnc(byte[] Dado) {
	 * return(Protocolo.getInstancia().EnviaDadoDnc(Dado, nsOut, log, idLog)); }
	 */

	private void reConectar() {
		// System.out.println("reConectar");
		try {
			if (tc == null) {
				tc = new Socket(ipColetor, portaColetor);
			} else {
				tc.close();
				tc = new Socket(ipColetor, portaColetor);
				// Inicia a conex�o TCP com o servidor na porta referenciada
			}
		} catch (UnknownHostException e) {
			// System.out.println("Host desconhecido.");
			e.printStackTrace();
		} catch (IOException e) {
			// System.out.println("Erro de IO.");
			e.printStackTrace();
		}

		try {
			nsOut = new BufferedOutputStream(tc.getOutputStream());
			nsIn = new BufferedInputStream(tc.getInputStream());
			conectado = tc.isConnected();
		} catch (IOException e) {
			// System.out.println("Erro ao pegar streams.");
			e.printStackTrace();
			try {
				if (nsOut != null)
					nsOut.close();
				if (nsIn != null)
					nsIn.close();
				if (tc != null)
					tc.close();// linha adicionada para teste de perda de
								// conexao

				nsOut = null;
				nsIn = null;
				tc = null;
			} catch (Exception e1) {
				// N�o faz nada
			}
			conectado = false;
		}
	}

	private int idEventos(String[] DadoRecebido) {
		int i;

		if (DadoRecebido[0].equals(""))
			return 10;

		for (i = 0; i < 9; i++) {
			if (DadoRecebido[0].equals(VetorCMD[i])) {
				return i;// trata evento
			}
		}

		return 10;
	}

	public Calendar ObtemDatadeDado(String[] DadoRecebido) {
		// System.out.println("Obtem Data de Dados.");
		Calendar retorno = null;

		int dia, mes, ano, hor, min, seg, mseg;
		try {
			if (Integer.parseInt(DadoRecebido[1]) == 0) {
				// O evento 0 n�o passa a data e hora
				// data e hora do ultimo evento ser� apenas
				// setado como refer�ncia nesse momento
				dataHoraUltimoEvento = Calendar.getInstance();
				return dataHoraUltimoEvento;
			}

			dia = Integer.parseInt(DadoRecebido[3]);
			if (dia == 0 || dia > 31) {
				dia = dataHoraUltimoEvento.get(Calendar.DAY_OF_MONTH);
				log.info(idLog, 0,
						"Dado de Data Incorreto - ObtemDatadeDado Dia");
			}

			mes = Integer.parseInt(DadoRecebido[4]);
			if (mes == 0 || mes > 12) {
				mes = dataHoraUltimoEvento.get(Calendar.MONTH);
				log.info(idLog, 0,
						"Dado de Data Incorreto - ObtemDatadeDado M�s");
			}

			ano = Integer.parseInt(DadoRecebido[5]);
			if ((ano < 2012) || (ano > 2040)) {
				ano = dataHoraUltimoEvento.get(Calendar.YEAR);
				log.info(idLog, 0,
						"Dado de Data Incorreto - ObtemDatadeDado Ano");
			}

			hor = Integer.parseInt(DadoRecebido[6]);
			min = Integer.parseInt(DadoRecebido[7]);
			seg = Integer.parseInt(DadoRecebido[8]);
			mseg = Integer.parseInt(DadoRecebido[9]);

			try {
				// DateTime dataObtida = new DateTime(ano, mes, dia, hor, min,
				// seg, mseg);
				// retorno = dataObtida;

				retorno = Calendar.getInstance();
				retorno.set(ano, mes, dia, hor, min, seg);
				retorno.set(Calendar.MILLISECOND, mseg);

				dataHoraUltimoEvento = (Calendar) retorno.clone();
			} catch (Exception e) {
				log.info(idLog, 0,
						"N�o foi poss�vel converter Data - ObtemDatadeDado");
				retorno = dataHoraUltimoEvento;
			}
		} catch (Exception e) {
			// Verificar se Consegue aproveitar a hora do evento
			try {
				dia = Integer.parseInt(DadoRecebido[3]);
				hor = Integer.parseInt(DadoRecebido[6]);
				min = Integer.parseInt(DadoRecebido[7]);
				seg = Integer.parseInt(DadoRecebido[8]);
				mseg = Integer.parseInt(DadoRecebido[9]);

				if (dia == 0) {
					dia = dataHoraUltimoEvento.get(Calendar.DAY_OF_MONTH);
				}

				if (dataHoraUltimoEvento.get(Calendar.YEAR) < 2012)
					dataHoraUltimoEvento = Calendar.getInstance();

				// retorno = new DateTime(DataHoraUltimoEvento.Year,
				// DataHoraUltimoEvento.Month, dia,
				// hor, min, seg, mseg);

				retorno.set(dataHoraUltimoEvento.get(Calendar.YEAR),
						dataHoraUltimoEvento.get(Calendar.MONTH), dia, hor,
						min, seg);
				retorno.set(Calendar.MILLISECOND, mseg);

				return retorno;
			} catch (Exception e1) {
				log.info(idLog, 0,
						"N�o foi poss�vel converter Data - ObtemDatadeDado2");
			}

			if (dataHoraUltimoEvento.get(Calendar.YEAR) < 2012)
				dataHoraUltimoEvento = Calendar.getInstance();

			retorno = dataHoraUltimoEvento;
		}
		return retorno;
	}

	private EventoColetado trataEventoParaDTO(String[] DadoRecebido) {
		EventoColetado eventoColetado = new EventoColetado();

		Calendar DtHrEvento = ObtemDatadeDado(DadoRecebido);

		INovaUpDTO lcupdto = null;

		int tipoEvento = 0;
		// estrutura
		// Evento;tpevnto;idup;dia;mes;ano;hora;min;seg;milissegundo;dado1;dado2;dado3;dado4;dado5;dado6;dado7;dado8
		try {
			tipoEvento = Integer.parseInt(DadoRecebido[1]);
		} catch (Exception e) {
			// System.out.println("Erro ao obter tipo do evento");
			return null;
		}

		try {
			int nr_maquina = Integer.parseInt(DadoRecebido[2]);

			if (nr_maquina > 20) { // vlauria 20100305
				// Gera Log Que idsubcoletor nao pode ser tratado
				log.info(idLog, 0, "--ERRO ao OBTER UP---");
				log.info(idLog, 4, "--IP:" + msgerenciado.getUrl_conexao()
						+ "---");
				log.info(idLog, 4, "--SUBCOLETOR:" + DadoRecebido[2] + "---");
				// TODO: deixar passar?
			} else {
				lcupdto = getUP(nr_maquina); // vlauria 20100305
			}
		} catch (Exception e) {
			// gera log de que n�o pode obter UP
			// Despreza evento
			log.info(idLog, 0, "--ERRO ao OBTER UP---");
			log.info(idLog, 4, "--IP:" + msgerenciado.getUrl_conexao() + "---");
			log.info(idLog, 4, "--SUBCOLETOR:" + DadoRecebido[2] + "---");
			log.info(idLog, 4, "--Evento Desprezado---");

			e.printStackTrace();

			return (null);
		}

		TrataEvento trataEvento = TrataEventoFactory.getInstancia().getTratador(tipoEvento);
		trataEvento.setDadoRecebido(DadoRecebido);
		trataEvento.setLcup(new IcUpDTO());
		trataEvento.setDataEvento(DtHrEvento);
		trataEvento.setLog(log);
		trataEvento.setIdLog(idLog);

		switch (tipoEvento) {
		case TrataEventoFactory._PRE_INICIALIZAR:
			versaoColetor = DadoRecebido[11];
			break;

		default:
			break;
		}

		icDadosRecebidos = DadoRecebido;
		icupdto = lcupdto;

		// gerando new IcUpDTO() fake
		IcUpDTO icfake = new IcUpDTO();
		icfake.setUpDTO(new UpDTO());

		eventoColetado = trataEvento.trataEvento();
		eventoColetado.setIcUpDTO(icfake);
		eventoColetado.setLog(log);
		eventoColetado.setIdLog(idLog);
		eventoColetado.setExisteEvento(true);

		return (eventoColetado);
	}

	public INovaUpDTO getUP(String idUp) {
		INovaUpDTO retorno = new INovaUpDTO();
		for (INovaUpDTO up : Ups) {
			if (up.getIdUP().equals(idUp)) {
				retorno = up;
			}
		}

		return retorno;
	}

	public void setUP(int porta, INovaUpDTO uplc) {
		if (Ups != null) {
			int indiceI = Ups.size();
			int i;
			String saveNropestendido;

			for (i = 0; i < indiceI; i++) {
				if (Ups.get(i).getIdSubColetor() == uplc.getIdSubColetor()) {
					saveNropestendido = "";

					if (Ups.get(i).getCp() != null
							&& Ups.get(i).getCp().getNropestendido() != null
							&& !Ups.get(i).getCp().getNropestendido()
									.equals("")) {
						saveNropestendido = Ups.get(i).getCp()
								.getNropestendido();
					}

					Ups.set(i, uplc);
					if (Ups.get(i).getCp() != null)
						Ups.get(i).getCp().setNropestendido(saveNropestendido);
				}
			}
		}
	}

	private INovaUpDTO getUP(int porta) throws NumberFormatException {
		boolean pegouUP = false;

		INovaUpDTO retorno = new INovaUpDTO();
		for (INovaUpDTO up : Ups) {
			if (up.getIdSubColetor() == porta) {
				pegouUP = true;
				retorno = up;
			}
		}

		if (!pegouUP && Ups.size() == 1) {
			retorno = Ups.get(0);
		}

		return (retorno);
	}

	// public IcUpDTO getUP(String idUp) {
	// // setTraceAtual("getUpidup");
	//
	// IcUpDTO retorno = new IcUpDTO();
	//
	// List<IcUpDTO> listUpDto = msgerenciado.getMsIcUpDTOLocais();
	//
	// for(IcUpDTO up : listUpDto) {
	// if (up.getUrlConexao().equals(idUp)) {
	// retorno = up;
	// }
	// }
	//
	// return retorno;
	// }

	public boolean enviaSetDataHora(Calendar data) {
		String comando = "SETDTHR;" + data.get(Calendar.DAY_OF_MONTH) + ";"
				+ data.get(Calendar.MONTH) + ";" + data.get(Calendar.YEAR)
				+ ";" + data.get(Calendar.HOUR_OF_DAY) + ";"
				+ data.get(Calendar.MINUTE) + ";" + data.get(Calendar.SECOND);

		return (enviaDado(comando));
	}

	public void enviaSetPrUpColetor(INovaUpDTO lcup) {
		enviaSetPrUpColetor(lcup, false);
	}

	public void enviaSetPrUpColetor(INovaUpDTO lcup, boolean limpalista) {
		String Comando;
		boolean bispersist = false;
		boolean isOPGigante = false;

		// TODO Alessandre acrescimo do if para teste se lcup.cp.cicloPadrao =
		// null
		if (lcup.getCp() == null) {
			lcup.setCp(new IwsCpDTO());
			lcup.getCp().setCicloPadrao(1f);
		}
		// SETPRUP;0-idsubColetor;1-IdUP;2-stativa;3-iscomop;4-nrop;5-tpSessao;6-CdMaq;7-Descri�ao;
		// 8-IsoperLogado;9-isParada
		// ;10-TmpParadaAuto;11-tmPctCiclos;12-iscomparada;
		// 13-MotUltPara;14-19 DtHrUltPar;20-msUltpar;21-motUltRef
		// 22-27 dthrultmref;28-msUltref;29-iscomrefugo; 30-NumCic ;31 prod liq
		// ;32-isparadapersist
		// 33-Paradafechaciclo; 34-TmpTolerCicloParAuto; 35-isEmRegulagem;
		// 36-isComAlertaProblemaQualidade
		// TmpParaAutoStop = (Int32)Convert.ToFloat(lcup.cp.cicloPadrao);
		// 41-IsComIntegracaoDoal
		// 42-isMateriaApontada; 43-isOPGigante; 44-isMonitoraInsumo

		if (limpalista)
			Comando = "CLEANLST;";
		else
			Comando = "SETPRUP;";

		Comando += lcup.getIdSubColetor().toString() + ";" + lcup.getIdUP()
				+ ";";// 0 ;1

		if (lcup.getIsUpAtiva()) {
			Comando += "1;";// 2
		} else {
			Comando += "0;";// 2
			lcup.getDadosCIP().setIsEmCIP(false);
		}

		if ((lcup.getCp() != null) && (lcup.getCp().getNrop() != null)
				&& (lcup.getCp().getNrop().length() > 2))
			lcup.setIsSemPrograma(false);

		if (lcup.getIsSemPrograma())
			Comando += "0;";// 3
		else
			Comando += "1;";// 3

		if (lcup.getCp().getNropestendido() != null) {
			if (lcup.getCp().getNropestendido().length() > 16) {
				isOPGigante = true;
			}
			Comando += lcup.getCp().getNropestendido() + ";";// 4
		} else
			Comando += "Campo Vazio;";// 4

		Comando += lcup.getStCriacaoCP().toString() + ";" + lcup.getUp() + ";"
				+ "Maquina;";// 5;6;7

		if (lcup.getListaLoginsEmAberto() != null
				&& lcup.getListaLoginsEmAberto().size() > 0)
			Comando += "1;";// 8

		else
			Comando += "0;";// 8

		if (lcup.getIsParadaEmAberto() && !lcup.getIsSemPrograma())
			Comando += "1;";// 9
		else
			Comando += "0;";// 9

		Comando += lcup.getMsParadaAutoTimeout() + ";"
				+ lcup.getCp().getCfgTamanhoUmPacoteCiclos().intValue() + ";"; // 10;11

		if ((lcup.getUltimaParadaAtual() != null)
				&& (lcup.getUltimaParadaAtual().getCdParada() != null)
				&& (!lcup.getUltimaParadaAtual().getCdParada().equals(""))) {
			Comando += "1;";// 12

			Calendar dtHrIParada = Calendar.getInstance();
			dtHrIParada.setTime(lcup.getUltimaParadaAtual().getDthrIparada());

			Comando += lcup.getUltimaParadaAtual().getCdParada() + ";" + // 13
					dtHrIParada.get(Calendar.DAY_OF_MONTH) + ";" + // 14
					dtHrIParada.get(Calendar.MONTH) + ";" + // 15
					dtHrIParada.get(Calendar.YEAR) + ";" + // 16
					dtHrIParada.get(Calendar.HOUR_OF_DAY) + ";" + // 17
					dtHrIParada.get(Calendar.MINUTE) + ";" + // 18
					dtHrIParada.get(Calendar.SECOND) + ";" + // 19
					dtHrIParada.get(Calendar.MILLISECOND) + ";"; // 20
			bispersist = lcup.getUltimaParadaAtual().getIsPersistente();
		} else {
			Comando += "0;0;0;0;0;0;0;0;0;"; // 13;14;15;16;7;18;19;20
		} // 21

		if (lcup.getUltimoRefugoAtual() == null
				|| lcup.getUltimoRefugoAtual().getDthrUltRefugo() == null) {
			Comando += "0;0;0;0;0;0;0;0;0;"; // 21;22;23;24;25;26;28;29
		} else {
			Calendar dthrUltRefugo = Calendar.getInstance();
			dthrUltRefugo.setTime(lcup.getUltimoRefugoAtual()
					.getDthrUltRefugo());

			Comando += lcup.getUltimoRefugoAtual().getCdRefugo() + ";" + // 21
					dthrUltRefugo.get(Calendar.DAY_OF_MONTH) + ";" + // 22
					dthrUltRefugo.get(Calendar.MONTH) + ";" + // 23
					dthrUltRefugo.get(Calendar.YEAR) + ";" + // 24
					dthrUltRefugo.get(Calendar.HOUR_OF_DAY) + ";" + // 25
					dthrUltRefugo.get(Calendar.MINUTE) + ";" + // 26
					dthrUltRefugo.get(Calendar.SECOND) + ";" + // 27
					dthrUltRefugo.get(Calendar.MILLISECOND) + ";"; // 28

			// TODO ALessandre inclusao do teste null para cdRefugo
			if (lcup.getUltimoRefugoAtual().getCdRefugo() == null
					|| lcup.getUltimoRefugoAtual().getCdRefugo().equals(""))
				Comando += "0;"; // 29
			else
				Comando += "1;"; // 29
		}

		Comando += lcup.getNumeroDeCiclos().toString() + ";"
				+ lcup.getProducaoLiquida().intValue() + ";"; // 30;31

		if (lcup.getIsEmRegulagem() && bispersist) {
			Comando += "0;"; // 32
		} else {
			if (bispersist)
				Comando += "1;"; // 32
			else
				Comando += "0;"; // 32
		}

		if (lcup.getIsParadaFechaCiclo())
			Comando += "1;"; // 33
		else
			Comando += "0;"; // 33

		if (lcup.getCp().getCfgTolerTmpCicloParAuto() != 0)
			Comando += lcup.getCp().getCfgTolerTmpCicloParAuto() + ";"; // 34
		else
			Comando += "0;"; // 34

		if (lcup.getIsEmRegulagem())
			Comando += "1;"; // 35
		else
			Comando += "0;"; // 35

		if (lcup.getIsComAlertaProbQuali())
			Comando += "1;"; // 36
		else
			Comando += "0;";// 36

		if ((lcup.getIsApntSapAtivo() != null)
				&& (lcup.getIsApntSapAtivo().equals("1")))
			Comando += "1;"; // 37
		else
			Comando += "0;";// 37

		if (lcup.getStApntSap() != null) {
			if (lcup.getStApntSap().equals("1"))
				Comando += "1;"; // 38
			else
				Comando += "0;";// 38
		} else
			Comando += "0;";// 38

		if ((lcup.getUltimaParadaAtual() != null)
				&& (lcup.getUltimaParadaAtual().getCdParada() != null)
				&& (!lcup.getUltimaParadaAtual().getCdParada().equals(""))) {
			Comando += lcup.getUltimaParadaAtual().getDsParada() + ";";// 39
		} else {
			Comando += " ;";// 39
		}

		if (lcup.isStIntegracaoDoal() && lcup.isVisualizaTelaIntegDOal())
			Comando += "1;"; // 40
		else if (!lcup.isVisualizaTelaIntegDOal())
			Comando += "0;"; // 40
		else
			Comando += "0;"; // 40

		if (lcup.getIsSemPrograma() == false && lcup.isStAlimIntegracaoDoal())
			Comando += "1;"; // 41
		else
			Comando += "0"; // 41

		Comando += obtemFracaoDouble(lcup.getProducaoLiquida()) + ";"; // 42

		if (isOPGigante)
			Comando += "1;"; // 43
		else
			Comando += "0"; // 43

		if (lcup.getIsSemPrograma() == false
				&& lcup.getCp().getIsOpcomloteInsumo())
			Comando += "1;"; // 44
		else
			Comando += "0"; // 44
	// Luiz 20170807 PRUP padrao apenas para teste do JConcentrador	
	//	Comando = "SETPRUP;1;60000;1;1;1;2;EXT_RS6;Maquina;0;0;30000;452;1;999999;1;8;2017;14;59;3;653;;4;8;2017;10;0;57;897;0;9099.0;43964325;0;1;1000;0;0;0;0;PARADA NAO INFORMADA;0;0;060;0;0;1;0;;;";
		enviaDado(Comando);
		UtilsThreads.pausaNaThread(100);
		setCIP(lcup);
		setLISTPROD(lcup);
	}

	private String obtemFracaoDouble(Double valor) {
		try {
			// String retorno = String.Format("{0:0.000}",
			// valor).Replace(',','.').Split('.')[1];
			String retorno = String.format("%1$0.000tf", valor)
					.replace(",", ".").split(".")[1];

			return retorno;
		} catch (Exception e) {
			return "0";
		}
	}

	private void setCIP(INovaUpDTO lcup) {
		if (lcup.getDadosCIP() != null) {
		if (lcup.getDadosCIP().getIsEmCIP() == true
				|| lcup.getDadosCIP().getIsCIPPendente() == true) {

			Calendar dtHrInicio = Calendar.getInstance();
			dtHrInicio.setTime(lcup.getDadosCIP().getDtHrInicio());

			String Comando = "";
			Comando = "SETCIP;" + lcup.getIdSubColetor().toString() + ";";
			Comando += dtHrInicio.get(Calendar.DAY_OF_MONTH) + ";"
					+ dtHrInicio.get(Calendar.MONTH) + ";"
					+ dtHrInicio.get(Calendar.YEAR) + ";"
					+ dtHrInicio.get(Calendar.HOUR_OF_DAY) + ";"
					+ dtHrInicio.get(Calendar.MINUTE) + ";"
					+ dtHrInicio.get(Calendar.SECOND) + ";";

			if (lcup.getDadosCIP().getIsEmCIP() == true)
				Comando += "1;";
			else
				Comando += "0;";

			enviaDado(Comando);
			UtilsThreads.pausaNaThread(10);
		}
	}
		else {};
	}

	// private void setCIP(INovaUpDTO lcup) {
	// if(lcup.getisComCIP()) {
	// String Comando = "";
	// Comando = "SETCIP;" + lcup.getIdSubColetor().toString() + ";";
	//
	// Calendar dtHrIniCIP = Calendar.getInstance();
	// dtHrIniCIP.setTime(lcup.getDtHrIniCIP());
	//
	// Comando += dtHrIniCIP.get(Calendar.DAY_OF_MONTH) + ";" +
	// dtHrIniCIP.get(Calendar.MONTH) + ";" + dtHrIniCIP.get(Calendar.YEAR) +
	// ";" + dtHrIniCIP.get(Calendar.HOUR_OF_DAY) + ";" +
	// dtHrIniCIP.get(Calendar.MINUTE) + ";" + dtHrIniCIP.get(Calendar.SECOND);
	//
	// enviaDado(Comando);
	// UtilsThreads.pausaNaThread(10);
	// }
	// }

	private void setLISTPROD(INovaUpDTO lcup) {
		if (lcup.getIdSubColetor() != 1)
			return;

		String Comando = "";
		String limpaCdProd = "                              ";
		Comando = "LISTPROD;" + lcup.getIdSubColetor().toString() + ";";
		if (lcup.getCp() != null && lcup.getCp().getProdutos() != null
				&& lcup.getCp().getProdutos().size() > 0) {
			int refence = lcup.getCp().getProdutos().size();

			Comando += lcup.getCp().getProdutos().get(0).getCdProduto() + ";";

			if (refence > 1)
				Comando += lcup.getCp().getProdutos().get(1).getCdProduto()
						+ ";";
			else
				Comando += limpaCdProd + ";";

			if (refence > 2)
				Comando += lcup.getCp().getProdutos().get(2).getCdProduto()
						+ ";";
			else
				Comando += limpaCdProd + ";";

			if (refence > 3)
				Comando += lcup.getCp().getProdutos().get(3).getCdProduto()
						+ ";;";
			else
				Comando += limpaCdProd + ";;";
		} else {
			Comando += limpaCdProd + ";";
			Comando += limpaCdProd + ";";
			Comando += limpaCdProd + ";";
			Comando += limpaCdProd + ";;";
		}

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	public List<IwsProdMateriaPrimaDTO> buscaListaMateriaPrima(String idUp) {
		List<IwsProdMateriaPrimaDTO> prodMatPrimas = new ArrayList<IwsProdMateriaPrimaDTO>();

		IwsListaMatPrimaDTO listaMaterial = new IwsListaMatPrimaDTO();

		try {
			// listaMaterial = getMsWs().getTr_dadosIntegracaoDoal(idUp);
			listaMaterial = IwsFacade.getInstancia().getTr_dadosIntegracaoDoal(
					idUp);
		} catch (Exception e) {
			prodMatPrimas = null;
		}

		if (listaMaterial.isErro() == false) {
			try {
				List<IwsProdMateriaPrimaDTO> listProd = listaMaterial
						.getMateriasPrimas();
				for (IwsProdMateriaPrimaDTO prod : listProd) {
					IwsProdMateriaPrimaDTO materiaprima = new IwsProdMateriaPrimaDTO();
					// materiaprima.copyPrUpProdMatPrimaWS(prod);
					materiaprima = prod;
					prodMatPrimas.add(materiaprima);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				log.error(e.getStackTrace());
				log.error(e.getCause());
				log.error("---------------------");
			}
		} else {
			prodMatPrimas = null;
		}

		return (prodMatPrimas);
	}

	public void atualizaListaMatPrima(String idup,
			List<IwsProdMateriaPrimaDTO> lista) {
		if (lista != null) {
			if (listaMateriaPrimaUps != null && listaMateriaPrimaUps.size() > 0) {
				int indice1 = 0;

				for (int cont = 0; cont < listaMateriaPrimaUps.size(); cont++) {
					if (listaMateriaPrimaUps.get(cont).getIdup().equals(idup)) {
						indice1 = cont;
						break;
					}
				}

				INovaListaMatPrimaDTO listaAux = new INovaListaMatPrimaDTO();
				if (indice1 >= 0) {
					if (listaMateriaPrimaUps.get(indice1).getMateriasPrimas() != null
							&& listaMateriaPrimaUps.get(indice1)
									.getMateriasPrimas().size() > 0) {
						listaMateriaPrimaUps.get(indice1).getMateriasPrimas()
								.clear();
					} else {
						listaMateriaPrimaUps.get(indice1).setMateriasPrimas(
								new ArrayList<IwsProdMateriaPrimaDTO>());
					}
					listaMateriaPrimaUps.get(indice1).copyListMatPrima(lista);
					listaMateriaPrimaUps.get(indice1).setIdup(idup);
				} else {
					listaAux.copyListMatPrima(lista);
					listaAux.setIdup(idup);
					listaMateriaPrimaUps.add(listaAux);
				}
			} else {
				listaMateriaPrimaUps = new ArrayList<INovaListaMatPrimaDTO>();
				listaMateriaPrimaUps.add(new INovaListaMatPrimaDTO());
				listaMateriaPrimaUps.get(0).copyListMatPrima(lista);
				listaMateriaPrimaUps.get(0).setIdup(idup);
			}
		}
	}

	/*
	 * Envia um dado para o coletor, vinculado a uma maquina. sQualdado: 1 -
	 * TmpLimParNaoInf - Tempo limite de parada nao informada 2 -
	 * VlRefEficUltCiclo - Valor referencia de eficiencia do ultimo ciclo
	 */
	public void setDado(int idSubColetor, String sQualdado, String sDado) {
		String Comando = "";
		Comando = "SETDADO;" + idSubColetor + ";" + sQualdado + ";" + sDado;

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	public void setDoal(INovaUpDTO lcup) {
		String Comando = "";

		Comando = "SETDOAL;" + lcup.getIdSubColetor().toString() + ";";

		if ((lcup.isComSaldo() && (lcup.getUltimaMateriaPrimaAtual() != null))
				|| (!lcup.isComSaldo() && (lcup.getMatPrimaSaldoZero() != null))) {
			if (lcup.isComSaldo()) {
				// se estiver com saldo exibe a �ltima mat�ria prima alimentada
				Comando += lcup.getUltimaMateriaPrimaAtual().getDsProduto()
						+ ";";
				Comando += lcup.getUltimaMateriaPrimaAtual()
						.getDsMateriaPrima() + ";";
				Comando += lcup.getUltimaMateriaPrimaAtual().getUnidade() + ";";
				if (lcup.getUltimaMateriaPrimaAtual().getControlalote()
						|| ((lcup.getUltimaMateriaPrimaAtual().getLote() != null) && (lcup
								.getUltimaMateriaPrimaAtual().getLote()
								.length() > 1)))
					Comando += lcup.getUltimaMateriaPrimaAtual().getLote()
							+ ";";
				else
					Comando += "----;";

				Comando += lcup.getUltimaMateriaPrimaAtual().getEstoque() + ";";
				Comando += "1;";
				if (lcup.getCp() != null && lcup.getCp().getProdutos() != null
						&& lcup.getCp().getProdutos().size() > 1)
					Comando += "1;";
				else
					Comando += "0;";
				Comando += "1;";// is com Saldo
			} else {
				// Se estiver sem saldo exibe a mat�ria que est� com saldo
				// pendente.
				Comando += lcup.getMatPrimaSaldoZero().getDsProduto() + ";";
				Comando += lcup.getMatPrimaSaldoZero().getDsMateriaPrima()
						+ ";";
				Comando += lcup.getMatPrimaSaldoZero().getUnidade() + ";";

				if (lcup.getMatPrimaSaldoZero().getControlalote()
						|| ((lcup.getMatPrimaSaldoZero().getLote() != null) && (lcup
								.getMatPrimaSaldoZero().getLote().length() > 1)))
					Comando += lcup.getMatPrimaSaldoZero().getLote() + ";";
				else
					Comando += "----;";

				Comando += lcup.getMatPrimaSaldoZero().getEstoque() + ";";
				Comando += "1;";

				if (lcup.getCp() != null && lcup.getCp().getProdutos() != null
						&& lcup.getCp().getProdutos().size() > 1)
					Comando += "1;";
				else
					Comando += "0;";

				Comando += "0;"; // is sem saldo
			}
		} else {
			Comando += " ; ; ; ; ;0;";

			if (lcup.getCp() != null && lcup.getCp().getProdutos() != null
					&& lcup.getCp().getProdutos().size() > 1)
				Comando += "1;";
			else
				Comando += "0;";

			Comando += "1;";
		}

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	private void setRele(IwsReleDTO oRele) {
		setRele(oRele.getINF01(), oRele.getINF02(), oRele.getINF03(),
				oRele.getINF04(), oRele.getINF05());
	}

	private void setRele(String inf01, String inf02, String inf03,
			String inf04, String inf05) {
		String Comando = "";
		Comando = "SETRELE;" + inf01 + ";" + inf02 + ";" + inf03 + ";" + inf04
				+ ";" + inf05;

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	public void setSaida(IwsReleDTO oRele) {
		if (isAndonAtivo)
			setSaida(oRele.getINF01(), oRele.getINF02(), oRele.getINF03(),
					oRele.getINF04(), oRele.getINF05(), true);
		else
			setSaida(oRele.getINF01(), oRele.getINF02(), oRele.getINF03(),
					oRele.getINF04(), oRele.getINF05(), false);
	}

	public void setSaida(String inf01, String inf02, String inf03,
			String inf04, String inf05) {
		setSaida(inf01, inf02, inf03, inf04, inf05, false);
	}

	private void setSaida(String inf01, String inf02, String inf03,
			String inf04, String inf05, boolean isAndonConfig) {
		String Comando = "";

		Comando = "SETSAIDA;" + inf01 + ";" + inf02 + ";";

		if (!isAndonConfig) {
			if (inf03.equals("1"))
				Comando += "0";
			else
				Comando += "1";
		} else
			Comando += inf03;

		Comando += ";" + inf04 + ";" + inf05 + ";";

		if (isAndonConfig)
			Comando += "1";
		else
			Comando += "0";

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	private void setSaidaAdnonDoal(boolean stSaida8) {
		String Comando = "";
		Comando = "SETSAI8;";

		if (stSaida8)
			Comando += "1;";
		else
			Comando += "0;";

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	public List<String> verificaTxtMensagem(String text) {
		int tamanhoTxt = text.length();
		int numeroLinhas = tamanhoTxt / 20;
		List<String> linhas = new ArrayList<String>(4);
		String str = null;

		if (tamanhoTxt % 20 > 0)
			numeroLinhas++;

		// int k = 0;
		if (numeroLinhas >= 1) {
			if (tamanhoTxt >= 20) {
				str = text.substring(0, 20);
			} else {
				str = text.substring(0, tamanhoTxt);
			}

			linhas.add(str);
		}

		if (numeroLinhas >= 2) {
			if (tamanhoTxt >= 40) {
				str = text.substring(20, 20);
			} else {
				str = text.substring(20, tamanhoTxt - 20);
			}

			linhas.add(str);
		}

		if (numeroLinhas >= 3) {
			if (tamanhoTxt >= 60) {
				str = text.substring(40, 20);
			} else {
				str = text.substring(40, tamanhoTxt - 40);
			}

			linhas.add(str);
		}

		if (numeroLinhas >= 4) {
			if (tamanhoTxt >= 80) {
				str = text.substring(60, 20);
			} else {
				str = text.substring(60, tamanhoTxt - 60);
			}

			linhas.add(str);
		}

		return (linhas);
	}

	public void resetaContagemMatPrima(String idUp) {
		if (listaMateriaPrimaUps != null && listaMateriaPrimaUps.size() > 0) {
			int indice1 = 0;

			for (indice1 = 0; indice1 < listaMateriaPrimaUps.size(); indice1++) {
				if (listaMateriaPrimaUps.get(indice1).getIdup().equals(idUp) == true)
					break;
			}
			// indice1 =
			// listaMateriaPrimaUps.FindIndex(delegate(IwsListaMatPrimaUpDTO
			// prima)
			// {
			// return prima.getIdUp().Equals(idUp);
			// });

			listaMateriaPrimaUps.get(indice1).setUltimaMatPrimaLida(0);
		}
	}

	public IwsProdMateriaPrimaDTO buscaUltimaMatPrimaUsada(String idUp) {
		IwsProdMateriaPrimaDTO ultimaMatPrima = new IwsProdMateriaPrimaDTO();
		ultimaMatPrima.setErro(0);

		if (listaMateriaPrimaUps != null && listaMateriaPrimaUps.size() > 0) {
			int indice1 = 0;

			for (indice1 = 0; indice1 < listaMateriaPrimaUps.size(); indice1++) {
				if (listaMateriaPrimaUps.get(indice1).getIdup().equals(idUp) == true)
					break;
			}
			// indice1 =
			// listaMateriaPrimaUps.FindIndex(delegate(IwsListaMatPrimaUpDTO
			// prima)
			// {
			// return prima.getIdUp().Equals(idUp);
			// });

			if (indice1 >= 0) {
				int ultimaMatPrimaLida = listaMateriaPrimaUps.get(indice1)
						.getUltimaMatPrimaLida();

				if (ultimaMatPrimaLida < listaMateriaPrimaUps.get(indice1)
						.getMateriasPrimas().size()) {
					ultimaMatPrima = listaMateriaPrimaUps.get(indice1)
							.getMateriasPrimas().get(ultimaMatPrimaLida);
					listaMateriaPrimaUps.get(indice1).setUltimaMatPrimaLida(
							++ultimaMatPrimaLida);
				} else
					ultimaMatPrima = null;
			} else
				ultimaMatPrima.setErro(1);
		} else {
			ultimaMatPrima.setErro(2);
		}

		return (ultimaMatPrima);
	}

	public IcDTO getMsgerenciado() {
		return msgerenciado;
	}

	private void enviaEventoPendente() throws SemSGBDException {
		INovaEventoPendenteDTO eventoPendengo = Stubdelegate.getInstancia()
				.getEventoPendengo();

		INovaUpDTO lcupdto = getUP(eventoPendengo.getIdup());
		if (eventoPendengo.getEvento() == INovaEventoPendenteDTO._EVENTOPENDENTE_INICIO_PARADA) {
			try {
				ms.setTr_paradaInicio(
						eventoPendengo.getIdup(),
						eventoPendengo.getDthrevento().getTime(),
						eventoPendengo.isParadaauto(),
						eventoPendengo.isParadpersist(), false);

				lcupdto.setIsParadaEmAberto(true);
				setUP(lcupdto.getIdSubColetor(), lcupdto);
			} catch (Exception e) {
				// PerdaConexaoException e = new PerdaConexaoException();
				// e.EventoPendente = evento;
				// throw e;

				throw new SemSGBDException();
			}
		} else if (eventoPendengo.getEvento() == INovaEventoPendenteDTO._EVENTOPENDENTE_FIM_PARADA) {
			try {
				ms.setTr_paradaFim(
						eventoPendengo.getIdup(),
						eventoPendengo.getDthrevento().getTime());
				lcupdto.setIsParadaEmAberto(false);
			} catch (Exception e) {
				throw new SemSGBDException();
			}
		} else if (eventoPendengo.getEvento() == INovaEventoPendenteDTO._EVENTOPENDENTE_INICIO_CICLO) {
			// try {
			//	IdwFacade.getInstancia().setTr_CicloInicio(
			//			eventoPendengo.getIdup(),
			//			eventoPendengo.getDthrevento(),
			//			eventoPendengo.getDados());
			//	lcupdto.setIsParadaEmAberto(false);
			//	setUP(lcupdto.getIdSubColetor(), lcupdto);
			//} catch (Exception e) {
			//	throw new SemSGBDException();
			//}
		} else if (eventoPendengo.getEvento() == INovaEventoPendenteDTO._EVENTOPENDENTE_FIM_CICLO) {
			try {
				ms.setTr_CicloFim(
						eventoPendengo.getIdup(),
						eventoPendengo.getDthrevento().getTime(), this.dadosApontamentoDTO);
			} catch (Exception e) {
				throw new SemSGBDException();
			}
		}
	}

	public IwsProdMateriaPrimaDTO validaCodMatPrima(String idUp,
			String cdMateriaPrima, String cdProduto) {

		if (listaMateriaPrimaUps != null && listaMateriaPrimaUps.size() > 0) {
			int indice1 = 0;

			for (indice1 = 0; indice1 < listaMateriaPrimaUps.size(); indice1++) {
				if (listaMateriaPrimaUps.get(0).equals(idUp))
					break;
			}
			// indice1 =
			// listaMateriaPrimaUps.FindIndex(delegate(IwsListaMatPrimaUpDTO
			// matprima)
			// {
			// return matprima.getIdUp().Equals(idUp);
			// });

			if (indice1 >= 0) {
				List<IwsProdMateriaPrimaDTO> listaMateriasPrimas = listaMateriaPrimaUps
						.get(indice1).getMateriasPrimas();
				for (IwsProdMateriaPrimaDTO mp : listaMateriasPrimas) {
					if (mp.getCdProduto().equals(cdProduto)
							&& mp.getCdMateriaPrima().equals(cdMateriaPrima)) {
						return mp;
					}
				}
			} else
				return null;
		} else {
			atualizaListaMatPrima(idUp, Stubdelegate.getInstancia()
					.buscaListaMateriaPrima(idUp, log, idLog));
			if (listaMateriaPrimaUps != null && listaMateriaPrimaUps.size() > 0) {
				int indice1 = 0;

				for (indice1 = 0; indice1 < listaMateriaPrimaUps.size(); indice1++) {
					if (listaMateriaPrimaUps.get(0).equals(idUp))
						break;
				}
				// indice1 =
				// listaMateriaPrimaUps.FindIndex(delegate(IwsListaMatPrimaUpDTO
				// matprima)
				// {
				// return matprima.getIdUp().Equals(idUp);
				// });

				if (indice1 >= 0) {
					List<IwsProdMateriaPrimaDTO> listaMateriasPrimas = listaMateriaPrimaUps
							.get(indice1).getMateriasPrimas();
					for (IwsProdMateriaPrimaDTO mp : listaMateriasPrimas) {
						if (mp.getCdProduto().equals(cdProduto)
								&& mp.getCdMateriaPrima()
										.equals(cdMateriaPrima)) {
							return mp;
						}
					}
				} else
					return null;
			}
		}

		return null;
	}

	public void trataEventoHtBeat(String[] DadoRecebido) {

		Calendar DthrhtBeat = ObtemDatadeDado(DadoRecebido);

		try {
			versaoColetor = DadoRecebido[10];
			int coletorContaAtivas = Integer.parseInt(DadoRecebido[11]);
			maquinaAtual = Integer.parseInt(DadoRecebido[12]);
			int concentradorContaAtivas = 0;
			for (INovaUpDTO lcup : Ups) {
				if (lcup.getIsUpAtiva()) {
					// adicionar o tratamento de lista de materia prima aqui
					concentradorContaAtivas++;
				}
			}

			if (coletorContaAtivas != concentradorContaAtivas) {
				// seta coletor novamente
				for (INovaUpDTO lcup : Ups) {
					enviaSetPrUpColetor(lcup);
				}
			}
		} catch (Exception e) {
			String nomelog = "HeartBeat" + ipColetor;

			log.info(idLog, 0, nomelog);
			log.info(idLog, 1, e.getMessage());
			log.info(idLog, 1, e.getStackTrace());
			log.info(idLog, 1, "---------------------");
		}

		continuaVivo(DthrhtBeat);
	}

	private void continuaVivo(Calendar dthrBeat) {
		IwsHorarioDTO rtrnHorarioDTO = new IwsHorarioDTO();

		try {
			// if
			// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
			// == true)
			// rtrnHorarioDTO =
			// Stubdelegate.getInstancia().getMsWsLong().setUPBeatMac(lcIpAdd +
			// ":" + lcPorta, dthrBeat);
			// else
			// rtrnHorarioDTO =
			// Stubdelegate.getInstancia().getMsWsLong().setUPBeatMac(lcIpAdd,
			// dthrBeat);
			rtrnHorarioDTO = ms.setUPBeatMac(
					msgerenciado.getUrl_conexao(), dthrBeat.getTime());

			// tratar recebimento de dados em RtrnHorarioDTO.listaUpDTO
			if (rtrnHorarioDTO.getListaUpDTO() != null) {
				// vlauria 20100320
				// mantem uma copia local de ListaUPDTO para gerenciamento da
				// lista de eventos do Andon
				// if(rtrnHorarioDTO.getListaUpDTO().getStAndonConfiguravel() ==
				// true) {
				// armazenaListaUpdto(rtrnHorarioDTO.getListaUpDTO());
				// }

				// faz a verifica��o de ativa��o dos Andons Processoft e
				// Configur�vel
				// vlauria 20100318
				if (isAndonPrcsftAtivo == true) {
					if (rtrnHorarioDTO.getListaUpDTO().getStAndonProcessoft() == false
							|| (rtrnHorarioDTO.getListaUpDTO()
									.getStAndonConfiguravel() == true && rtrnHorarioDTO
									.getListaUpDTO().getStAndonProcessoft() == true)) {
						isAndonPrcsftAtivo = false;
						setSaida("8", "0", "0", "0", "0");// sombra da Sa�da 5
															// somente para uso
															// com Customiza��
															// DOAL
						setSaida("6", "0", "0", "0", "0");
						setSaida("5", "0", "0", "0", "0");
						setSaida("4", "0", "0", "0", "0");
					}
				} else {
					if (rtrnHorarioDTO.getListaUpDTO().getStAndonProcessoft() == true
							&& rtrnHorarioDTO.getListaUpDTO()
									.getStAndonConfiguravel() == false) {
						isAndonPrcsftAtivo = true;
					}
				}

				if (isAndonAtivo == true) {
					if (rtrnHorarioDTO.getListaUpDTO().getStAndonConfiguravel() == false) {
						isAndonAtivo = false;
						setRele("1", "0", "0", "0", "0");
						setRele("2", "0", "0", "0", "0");
						setRele("3", "0", "0", "0", "0");
						setRele("4", "0", "0", "0", "0");
						setRele("5", "0", "0", "0", "0");
						setRele("6", "0", "0", "0", "0");
						setRele("7", "0", "0", "0", "0");
						setRele("8", "0", "0", "0", "0");
						setSaida("0", "0", "0", "0", "0", true);
						setSaida("1", "0", "0", "0", "0", true);
						setSaida("2", "0", "0", "0", "0", true);
						setSaida("3", "0", "0", "0", "0", true);
						setSaida("4", "0", "0", "0", "0", true);
						setSaida("5", "0", "0", "0", "0", true);
						setSaida("6", "0", "0", "0", "0", true);
						setSaida("7", "0", "0", "0", "0", true);
						setSaida("8", "0", "0", "0", "0", true);// sombra da
																// Sa�da 5
																// somente para
																// uso com
																// Customiza��
																// DOAL
					}
				} else {
					if (rtrnHorarioDTO.getListaUpDTO().getStAndonConfiguravel() == true) {
						isAndonAtivo = true;
					}
				}
				// fim ativa��o/desativa��o dos Andons Processoft e Configur�vel

				// Verifica se uma UP foi desativada. Se foi, fechar
				// planejamento
				List<INovaUpDTO> listaups;
				if (rtrnHorarioDTO.getListaUpDTO().getUps() != null) {
					listaups = new ArrayList<INovaUpDTO>(rtrnHorarioDTO
							.getListaUpDTO().getUps().size());
				} else {
					listaups = new ArrayList<INovaUpDTO>();
				}

				for (INovaUpDTO updtoreg : Ups) {
					boolean isUpAindaNaLista = false;

					if (rtrnHorarioDTO.getListaUpDTO().getUps() != null) {
						List<IwsUpDTO> listaUps = rtrnHorarioDTO
								.getListaUpDTO().getUps();

						for (IwsUpDTO localupdto : listaUps) {
							if (updtoreg.getIdUP().equals(localupdto.getIdUP())
									&& localupdto.getIsUpAtiva())
								isUpAindaNaLista = true;
						}
					}

					if (isUpAindaNaLista == false) {
						// Finaliza planejamento
						updtoreg.setIsReiniciarUP(false);
						Stubdelegate.getInstancia().finalizaPlanejamento(
								updtoreg);
						updtoreg.limparUp();
						updtoreg.setIsUpAtiva(false);
						LimpaPRUPcolec(updtoreg);
					}
				}

				// Verifica se uma up foi reativada ou precisa ser reinciada
				if (rtrnHorarioDTO.getListaUpDTO().getUps() != null) {
					List<IwsUpDTO> listaUps = rtrnHorarioDTO.getListaUpDTO()
							.getUps();

					for (IwsUpDTO localupdto : listaUps) {
						INovaUpDTO upCorrente = new INovaUpDTO();
						upCorrente = getUP(localupdto.getIdUP());
						// Verifica se a UP deve reiniciar com um novo
						// planejamento
						if (localupdto.getIsReiniciarUP() == true) {
							// Sair com o planejamento atual
							// TODO finalizaPlanejamento retorno booleano
							// indicando se fechou ou nao
							// talvez seja necessario testar isso caso nao seja
							// possivel fechar o planejamento
							// no momento, tentando ate conseguir
							upCorrente.setIsReiniciarUP(false);
							upCorrente.limparUp();
							upCorrente.setIsUpAtiva(localupdto.getIsUpAtiva());
							// Sincronizar novamente o horario

							// obter data e hora do banco.
							IwsHorarioDTO horarioDTO = new IwsHorarioDTO();
							do {
								// horarioDTO =
								// getMsWs().getTr_sincronizaHorario();
								horarioDTO = ms
										.getTr_sincronizaHorario();
							} while (horarioDTO == null
									|| horarioDTO.getData() == null);

							Calendar calHorarioDTO = Calendar.getInstance();
							calHorarioDTO.setTime(horarioDTO.getData());

							setLimpaLstSetDthr(upCorrente, calHorarioDTO);
						} else if (localupdto.getIsfechaLogins()) {
							upCorrente
									.setListaLoginsEmAberto(new ArrayList<IwsModDTO>(
											0));
							upCorrente.setTemOperadorLogado(false);
							String Comando = "SETLOG;"
									+ upCorrente.getIdSubColetor().toString()
									+ ";0; ; ; ";
							enviaDado(Comando);
							UtilsThreads.pausaNaThread(10);
						}
						setUP(upCorrente.getIdSubColetor(), upCorrente);
						INovaUpDTO up = new INovaUpDTO();
						up.copyUpDTOWs(localupdto);
						listaups.add(up);
						// adicionar tratamento de saldo de materia prima.
					}
				}
				upsAtualizadas = listaups;
				AtualizaUps();
			} else {
				log.info(idLog, 0, "Lista Ups Vazia Sem Conex�o");
			}

			Stubdelegate.getInstancia().setSemComunicacaoWS(false);
			// wmCIPViewController.getInstancia().executaDelegateComComunicacaoWS();
			// System.Windows.Forms.MessageBox.Show(RtrnHorarioDTO.data.Date.ToString());
		} catch (Exception e) {
			// System.Windows.Forms.MessageBox.Show(e.Message);
			Stubdelegate.getInstancia().setSemComunicacaoWS(true);
			// wmCIPViewController.getInstancia().executaDelegateSemComunicacaoWS();
		}
	}

	// private void armazenaListaUpdto(IwsListaUpDTO listaAtualizada) {
	// //vlauria 20100320
	// List<IwsUpDTO> lclistaAtual = null;
	// //bool isListaOrganizada = false;
	// lclistaAtual = listaAtualizada.getUps();
	// List<INovaUpDTO> listaParaAdicionar = new ArrayList<INovaUpDTO>();
	//
	// listaParaAdicionar = new ArrayList<INovaUpDTO>(listaMngmtAndon.size());
	// listaParaAdicionar.addAll(listaMngmtAndon);
	//
	// List<INovaUpDTO> updtoArraytoList = new
	// ArrayList<INovaUpDTO>(lclistaAtual.size());
	//
	// log.info(idLog, 0, "LOG: inicio armazenaListaUpdto()");
	// //copia a lista de info.upDTO para o UpDTO local
	// //monta lista de novos dados de UPs
	// for(int i = 0; i < lclistaAtual.size(); i++) {
	// INovaUpDTO updtoAux = new INovaUpDTO();
	//
	// if(lclistaAtual.get(i).getListaAndonDTO() != null &&
	// lclistaAtual.get(i).getIsUpAtiva() == true) {
	// updtoAux.copyUpDTOWs(lclistaAtual.get(i));
	// updtoArraytoList.add(updtoAux);
	// }
	// }
	// //se a lista de gerenciamento ainda n�o for inicializada, n�o executa
	// sort
	// if(listaMngmtAndon.size() != 0) {
	// Collections.sort(listaMngmtAndon, new Comparator<INovaUpDTO>() {
	// public int compare(INovaUpDTO o1, INovaUpDTO o2) {
	// return(o1.getIdUP().compareTo(o2.getIdUP()));
	// };
	// });
	// // listaMngmtAndon.Sort(delegate(IwsUpDTO updto1, IwsUpDTO updto2)
	// // {
	// // return updto1.idUP.CompareTo(updto2.idUP);
	// // });
	// }
	//
	// //executa sort na lista de novas UPs
	// // updtoArraytoList.Sort(delegate(IwsUpDTO updto1, IwsUpDTO updto2)
	// // {
	// // return updto1.idUP.CompareTo(updto2.idUP);
	// // });
	// Collections.sort(updtoArraytoList, new Comparator<INovaUpDTO>() {
	// public int compare(INovaUpDTO o1, INovaUpDTO o2) {
	// return(o1.getIdUP().compareTo(o2.getIdUP()));
	// };
	// });
	//
	// //se a lista local j� foi inicializada, busca quais elementos foram
	// modificados
	// if(listaMngmtAndon.size() != 0 && (updtoArraytoList.size() >=
	// listaMngmtAndon.size())) {
	//
	// if(listaMngmtAndon.equals(updtoArraytoList) == false) {
	// //se as listas forem iguais, n�o faz nada
	// for(INovaUpDTO updtoAux : updtoArraytoList) {
	// INovaUpDTO lcupDTO = new INovaUpDTO();
	// int indLista = -1;
	//
	// for(int cont = 0; cont < listaMngmtAndon.size(); cont++) {
	// if(listaMngmtAndon.get(cont).getIdUP().equals(updtoAux.getIdUP()))
	// lcupDTO = listaMngmtAndon.get(cont);
	// }
	//
	// // lcupDTO = listaMngmtAndon.Find(
	// // delegate(IwsUpDTO updto1) { return updto1.idUP.Equals(updtoAux.idUP);
	// });
	//
	// if(lcupDTO != null) {
	// //se o heart beat n�o enviar atualiza��o da lista de andon: (lcupDTO ==
	// null)
	// //ent�o, n�o atualiza a lista de eventos de andon.
	// if(lcupDTO.getListaDadosAndon().equals(updtoAux.getListaDadosAndon()) ==
	// false) {
	//
	// for(int cont = 0; cont < listaMngmtAndon.size(); cont++) {
	// if(listaMngmtAndon.get(cont).getIdUP().equals(updtoAux.getIdUP()) ==
	// true) {
	// indLista = cont;
	// break;
	// }
	// }
	// // indLista = listaMngmtAndon.FindIndex(
	// // delegate(IwsUpDTO updto)
	// // {
	// // return updto.idUP.Equals(updtoAux.idUP);
	// // });
	//
	// if(indLista < 0) {
	// listaParaAdicionar.add(updtoAux);
	// indLista = 0;
	// }
	// else {
	// listaParaAdicionar.set(indLista, updtoAux);
	// }
	// }
	// }
	// else {
	// listaParaAdicionar.add(updtoAux);
	// }
	// }
	//
	// listaMngmtAndon = new ArrayList<INovaUpDTO>();
	// listaMngmtAndon.addAll(listaParaAdicionar);
	//
	// for(INovaUpDTO toSort : listaMngmtAndon) {
	//
	// Collections.sort(toSort.getListaDadosAndon(), new
	// Comparator<INovaAndonDTO>() {
	// public int compare(INovaAndonDTO o1, INovaAndonDTO o2) {
	// return(o1.getPrioridade().compareTo(o2.getPrioridade()));
	// };
	// });
	//
	// // toSort.ListaDadosAndon.Sort(
	// // delegate(IwsAndonDTO andondto1, INovaAndonDTO andondto2)
	// // {
	// // return andondto1.prioridade.CompareTo(andondto2.prioridade);
	// // });
	// }
	// }
	// }
	//
	// //se a lista local ainda n�o foi inicializada, copia toda a lista nova
	// para a local
	// else
	// {
	// listaMngmtAndon = new ArrayList<INovaUpDTO>();
	// listaMngmtAndon.addAll(updtoArraytoList);
	// }
	// isListaAndonInicializada = true;
	//
	// log.info(idLog, 0, "LOG: fim armazenaListaUpdto.");
	// }

	private void LimpaPRUPcolec(IwsUpDTO up) {
		if (conectado) {
			String LimpaPRUP = "SETPRUP;"
					+ up.getIdSubColetor()
					+ ";;0;0;;0;;;0;0;0;0;0;;0;0;0;0;0;0;0;;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0";
			enviaDado(LimpaPRUP);
		}
	}

	private void setLimpaLstSetDthr(INovaUpDTO lcup, Calendar datahr) {
		String Comando = "";
		// set data hora
		Comando = "SETDTHR;" + datahr.get(Calendar.DAY_OF_MONTH) + ";"
				+ datahr.get(Calendar.MONTH) + ";" + datahr.get(Calendar.YEAR)
				+ ";" + datahr.get(Calendar.HOUR_OF_DAY) + ";"
				+ datahr.get(Calendar.MINUTE) + ";"
				+ datahr.get(Calendar.SECOND);

		dataHoraUltimoEvento = datahr;
		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
		// set limpa lista
		enviaSetPrUpColetor(lcup, true);
	}

	private void AtualizaUps() {
		int i, j, indiceI = 0, indiceJ = 0;
		boolean isVerificaExclusao = true;
		boolean isComIntegDoal = false;
		int ContaAtivas = 0;

		int ContaAtivasOld = 0;
		INovaUpDTO updto = new INovaUpDTO();
		INovaUpDTO updtoNew = new INovaUpDTO();
		String Comando = "";
		// Boolean isReleSetado = false;
		if ((Ups != null) && (upsAtualizadas != null)) {

			indiceI = Ups.size();
			indiceJ = upsAtualizadas.size();

			for (i = 0; i < indiceI; i++) {
				updto = Ups.get(i);
				isVerificaExclusao = true;
				ContaAtivas = 0;

				if (updto.getIsUpAtiva()) {
					ContaAtivasOld++;
				}

				for (j = 0; j < indiceJ; j++) {
					updtoNew = upsAtualizadas.get(j);
					if (updtoNew.getIsUpAtiva()) {
						ContaAtivas++;
					}

					if (updto.getIdUP().equals(updtoNew.getIdUP())) {
						isVerificaExclusao = false;
						updto.setIsCicloAberto(updtoNew.getIsCicloAberto());
						updto.setCavidadesAtivas(updtoNew.getCavidadesAtivas());
						// Verifica se a up em memoria esta desativada e a up
						// recebida esta ativa
						// Se sim significa que a up foi reativada. Logo deve-se
						// enviar esses dados para o coletor
						if (updto.getIsUpAtiva() == false
								&& updtoNew.getIsUpAtiva() == true) {
							if (!isIniciando) {
								log.info(idLog, 0,
										"chamando inicializaColetorSemEvento de AtualizaUps1");
								inicializaColetorSemEvento();
								log.info(idLog, 0,
										"finalizou chamada de inicializaColetorSemEvento de AtualizaUps1");
							}
							// Se a up em memoria esta inativa e a nova up esta
							// ativa, entao considerar
							// que a nova up vai entrar sem programa
							updtoNew.setIsSemPrograma(true);
							updtoNew.getDadosCIP().setIsEmCIP(false);
							// SETPRUP
							enviaSetPrUpColetor(updtoNew);
						} else {
							INovaUpDTO tmpUpdto = verificaSeHouveAlteracaoUP(
									updto, updtoNew);

							if (tmpUpdto != null) {
								// Verifica se o PRUP foi modificada. Se sim,
								// envia novos dados da UP para o MCU
								updto = tmpUpdto;
								if ((updto.getCp() == null)
										|| (updto.getCp().getNrop() == null)
										|| (updto.getCp().getNrop().length() == 0)) {
									updto.setIsSemPrograma(true);
									updto.getDadosCIP().setIsEmCIP(false);
									// LimpaPRUPcolec(updto);
								}
								setUP(updto.getIdSubColetor(), updto);
								enviaSetPrUpColetor(updto);
							}
						}

						// if(updto.getProducaoLiquida() !=
						// updtoNew.getProducaoLiquida() ||
						// updto.getNumeroDeCiclos() !=
						// updtoNew.getNumeroDeCiclos()) {
						updto.setProducaoLiquida(updtoNew.getProducaoLiquida());
						updto.setNumeroDeCiclos(updtoNew.getNumeroDeCiclos());
						setProducao(updtoNew);
						// }

						updto.setDadosCIP(updtoNew.getDadosCIP());

						if (updto.getDadosCIP() != null)
							setCIP(updto);

						setUP(updto.getIdSubColetor(), updto); // POA2 Setado
																// apenas para
																// fixar que
																// est� com CIP

						if (updto.getIsComAlertaProbQuali() != updtoNew
								.getIsComAlertaProbQuali()) {
							// boolean qld001aberto = false;
							updto.setIsComAlertaProbQuali(updtoNew
									.getIsComAlertaProbQuali());

							// for(IwsAlertaDTO alertas :
							// updto.getListaAlertasAbertos()) {
							// if(alertas.getCdAlerta().equals("QLD001"))
							// qld001aberto = true;
							// }

							// if(!qld001aberto) {
							// IwsAlertaDTO alertaQld001 = new IwsAlertaDTO();
							// alertaQld001.setTpAlerta(1);
							// alertaQld001.setCdAlerta("QLD001");
							// updto.getListaAlertasAbertos().add(alertaQld001);
							// }

							setUP(updto.getIdSubColetor(), updto);
							enviaSetPrUpColetor(updtoNew);
						}

						if (updtoNew.getIsComInspecaoPendente() == true) {
							setUP(updto.getIdSubColetor(), updto);
							updto.setIsComInspecaoPendente(true);
						} else {
							setUP(updto.getIdSubColetor(), updto);
							updto.setIsComInspecaoPendente(false);
						}

						if (updtoNew.getResultadoUltimaInspecao() != updto
								.getResultadoUltimaInspecao()) {
							updto.setResultadoUltimaInspecao(updtoNew
									.getResultadoUltimaInspecao());
							setUP(updto.getIdSubColetor(), updto);
						}
						if (updtoNew.getIsApntSapAtivo() != null) {

							if (updtoNew.getIsApntSapAtivo().equals("1")) {
								updto.setIsApntSapAtivo("1");
								updto.setStApntSap(updtoNew.getStApntSap());
								enviaSetPrUpColetor(updto);
							} else {
								updto.setIsApntSapAtivo("0");
								updto.setStApntSap("0");
								enviaSetPrUpColetor(updto);
							}
						}

						// if(updtoNew.getListaLoginsEmAberto() != null) {
						// IwsModDTO loginsAtivos;
						// List<IwsModDTO> listaDeLoginsAtivos = new
						// ArrayList<IwsModDTO>();
						//
						// for(IwsModDTO moddto :
						// updtoNew.getListaLoginsEmAberto()) {
						// loginsAtivos = new IwsModDTO();
						// // loginsAtivos.copyModDTOWs(moddto);
						// loginsAtivos = moddto;
						// listaDeLoginsAtivos.add(loginsAtivos);
						// }

						updto.setListaAndonDTO(updtoNew.getListaAndonDTO());
						updto.setListaLoginsEmAberto(updtoNew
								.getListaLoginsEmAberto());

						if (updto.getListaLoginsEmAberto() != null
								&& updto.getListaLoginsEmAberto().size() > 0) {
							updto.setTemOperadorLogado(true);
							Comando = "SETLOG;"
									+ updto.getIdSubColetor().toString()
									+ ";1; ; ; ";
						} else {
							updto.setTemOperadorLogado(false);
							Comando = "SETLOG;"
									+ updto.getIdSubColetor().toString()
									+ ";0; ; ; ";
						}

						enviaDado(Comando);
						UtilsThreads.pausaNaThread(10);
						// }

						// setando reles - SETRELE;inf1;...
						if (isAndonPrcsftAtivo == true) { // vlauria 20100319

							if ((updtoNew != null)
									&& (updtoNew.getCp() != null)
									&& (updtoNew.getIsUpAtiva())
									&& ((updtoNew.getCp().getNrop() != null) && (updtoNew
											.getCp().getNrop().length() > 0))) {
								if (isAndonAtivo != true
										&& updtoNew.getStAndonConfiguravel() != true) {
									if (updtoNew.getLcRele01() != null)
										setRele(updtoNew.getLcRele01());
									if (updtoNew.getLcRele02() != null)
										setRele(updtoNew.getLcRele02());
									if (updtoNew.getLcRele03() != null)
										setRele(updtoNew.getLcRele03());
									if (updtoNew.getLcRele04() != null)
										setRele(updtoNew.getLcRele04());
									if (updtoNew.getLcRele05() != null)
										setRele(updtoNew.getLcRele05());
								}

								// TODO: adicionar tratativa do concentrador
								// setando andonprcsft
								if (updtoNew.getLcUpAndonPrcsftDTO() != null) {
									IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO = updtoNew
											.getLcUpAndonPrcsftDTO();

									if (oUpAndonPrcsftDTO.getstRele7SldZero() != null) {
										setSaida(
												"8",
												"0",
												"0",
												oUpAndonPrcsftDTO
														.gettmpRele7LigSldZero()
														.toString(),
												oUpAndonPrcsftDTO
														.gettmpRele7DesSldZero()
														.toString());
									}

									if (oUpAndonPrcsftDTO.getstRele6() != null)
										setSaida("6",
												oUpAndonPrcsftDTO.getstRele6(),
												"0", oUpAndonPrcsftDTO
														.gettmpRele6Lig()
														.toString(),
												oUpAndonPrcsftDTO
														.gettmpRele6Des()
														.toString());
									if (oUpAndonPrcsftDTO.getstRele7() != null)
										setSaida("5",
												oUpAndonPrcsftDTO.getstRele7(),
												"0", oUpAndonPrcsftDTO
														.gettmpRele7Lig()
														.toString(),
												oUpAndonPrcsftDTO
														.gettmpRele7Des()
														.toString());
									if (oUpAndonPrcsftDTO.getstRele8() != null)
										setSaida("4",
												oUpAndonPrcsftDTO.getstRele8(),
												"1", oUpAndonPrcsftDTO
														.gettmpRele8Lig()
														.toString(),
												oUpAndonPrcsftDTO
														.gettmpRele8Des()
														.toString());

									// transformando valor para inteiro, com
									// precisao de 2 casas decimais, para enviar
									// ao coletor
									if (oUpAndonPrcsftDTO
											.getdeveSetarLimitePar()) {
										int iTmpLimParNaoInf = oUpAndonPrcsftDTO
												.gettmpLimParNaoInf()
												.intValue() * 100;
										setDado(updtoNew.getIdSubColetor(),
												"1",
												String.valueOf(iTmpLimParNaoInf));
									}

									if (oUpAndonPrcsftDTO.getdeveSetarRefEfic()) {
										int iVlRefEficUltCiclo = oUpAndonPrcsftDTO
												.getvlRefEficUltCiclo()
												.intValue() * 100;
										setDado(updtoNew.getIdSubColetor(),
												"2",
												String.valueOf(iVlRefEficUltCiclo));
									}

								} // fim: setando andonprcsft

							}
						}

						if (updto.isVisualizaTelaIntegDOal() != updtoNew
								.isVisualizaTelaIntegDOal()) {
							updto.setVisualizaTelaIntegDOal(updtoNew
									.isVisualizaTelaIntegDOal());
							setUP(updto.getIdSubColetor(), updto);
							if (updto.isStIntegracaoDoal())
								enviaSetPrUpColetor(updto);
						}

						if (updto.isStIntegracaoDoal() != updtoNew
								.isStIntegracaoDoal()) {
							updto.setStIntegracaoDoal(updtoNew
									.isStIntegracaoDoal());
							setUP(updto.getIdSubColetor(), updto);
							if (updto.isVisualizaTelaIntegDOal())
								enviaSetPrUpColetor(updto);
						}

						if (updto.isStIntegracaoDoal()) {
							isComIntegDoal = true;
						}

						if (!(updtoNew.getIsUpAtiva())) {

							try {
								// verificar se realmente ? necess?rio finalizar
								// aqui, pois parece que jah foi finalizado
								// anteriormente
								if (!(updto.getIsSemPrograma())) {
									updto.setIsReiniciarUP(true);

									if (!Stubdelegate.getInstancia()
											.finalizaPlanejamento(updto))
										continue;
								}
								// Verificar se h� coincid�ncia de subcoletor
								// atrelado
								if (VerificaIntegridadeListaUP(updtoNew)) {
									LimpaPRUPcolec(updto);
								}

								Ups.remove(updto);
								i--;
								indiceI = Ups.size();
							} catch (Exception e) {
								e.printStackTrace();
								log.info(e.getMessage());
							}
						}
					}
				}

				if (isVerificaExclusao) {
					updto.setIsReiniciarUP(true);

					if (!Stubdelegate.getInstancia()
							.finalizaPlanejamento(updto)) {

						if (VerificaIntegridadeListaUP(updto)) {
							LimpaPRUPcolec(updto);
						}

						Ups.remove(updto);
						i--;
						indiceI = Ups.size();
					}
				}
			}

			// TODO: otmizar para obter a lista de todas as ops em hor�rioDTO
			boolean isDeveLigarSaida8 = false, integDoalTratada = false;

			if (isComIntegDoal
					&& Util.getVerificaElapsedTime(refereciaRetryDoal,
							timeoutAtualizaDOAL)
					&& (isConectadoSAP || Util.getVerificaElapsedTime(
							refereciaRetryDoal, timeoutRetrySAP))) {
				integDoalTratada = true;
				for (int indice = 0; indice < listaMateriaPrimaUps.size(); indice++) {
					List<IwsProdMateriaPrimaDTO> listamat = listaMateriaPrimaUps
							.get(indice).getMateriasPrimas();
					INovaUpDTO oUpdto = getUP(listaMateriaPrimaUps.get(indice)
							.getIdup());
					// /AtualizaUps Lista
					if (!oUpdto.getIsSemPrograma()) {
						atualizaListaMatPrima(
								oUpdto.getIdUP(),
								Stubdelegate.getInstancia()
										.buscaListaMateriaPrima(
												oUpdto.getIdUP(), log, idLog));
					} else {
						continue;
					}

					boolean isTheSame = false;

					if (maquinaAtual == oUpdto.getIdSubColetor())
						isTheSame = true;

					// if(obtemSaldodeMateriaPrima(ref oUpdto, ref listamat,
					// sapDbDsn, sapDbUser, sapDbPass, isTheSame))
					// TODO: saldoMateriaPrima
					// if(obtemSaldodeMateriaPrima(oUpdto, listamat, sapDbDsn,
					// sapDbUser, sapDbPass, isTheSame))
					// {
					// listaMateriaPrimaUps.get(indice).setMateriasPrimas(listamat);
					// if(!oUpdto.isComSaldo())
					// isDeveLigarSaida8 = true;
					// }
				}

				refereciaRetryDoal = Calendar.getInstance();

				if (isDeveLigarSaida8 && isAndonPrcsftAtivo)
					setSaidaAdnonDoal(true);
			}

			if ((integDoalTratada && !isDeveLigarSaida8) || !isComIntegDoal) {
				setSaidaAdnonDoal(false);
			}

			if ((ContaAtivasOld < ContaAtivas)) {
				if (!isIniciando) {
					log.info(idLog, 0,
							"chamando inicializaColetorSemEvento de AtualizaUps2");
					inicializaColetorSemEvento();
					log.info(idLog, 0,
							" finalizou chamada inicializaColetorSemEvento de AtualizaUps2");
				}

				for (INovaUpDTO up : Ups) {
					// SETPRUP
					enviaSetPrUpColetor(up);
				}
			}

			// Se tanto as Ups atualmente em memoria estiverem zeradas quanto as
			// novas ups que estao sendo ativadas
			// estiverem zeradas, ent?o mostra mensagem
			if (Ups.size() == 0 && upsAtualizadas.size() == 0) {
				UtilsThreads.pausaNaThread(100);

				// String mensagem;
				// if(GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
				// == true)
				// mensagem =
				// "Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
				// + lcIpAdd + ":" + lcPorta +
				// ").Entre em contato com o Administrador do sistema.";
				// else
				// mensagem =
				// "Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
				// + lcIpAdd +
				// ").Entre em contato com o Administrador do sistema.";

				log.info(
						idLog,
						0,
						"Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
								+ ipColetor
								+ ").Entre em contato com o Administrador do sistema.");

				UtilsThreads.pausaNaThread(2000);
			}

			// Se atualmente nenhuma UP estiver em memoria, mas a existe uma
			// nova relacao de ups para entrarem em memoria
			// entao a relacao atualiza de ups passa a compor a memoria e se
			// ativa no mcu as ups
			if (Ups.size() == 0 && upsAtualizadas.size() > 0) {
				// Ele soh entrar? nesse if qdo o gerenciador nao tiver em
				// memeoria a UP que esta entrando
				Ups = upsAtualizadas;

				if (!isIniciando) {
					log.info(idLog, 0,
							"chamando inicializaColetorSemEvento de AtualizaUps3");
					inicializaColetorSemEvento();
					log.info(idLog, 0,
							"finalizou chamada inicializaColetorSemEvento de AtualizaUps3");
				}

				for (INovaUpDTO up : Ups) {
					// SETPRUP
					enviaSetPrUpColetor(up);
				}
			}
		}
	}

/*	private void inicializaColetor(boolean comParadaSemConexao, Calendar dtHr) {
		boolean isInicializadoComSucesso = false;
		String idColetor = "";
		// if (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta ==
		// true)
		// idColetor = lcIpAdd + ":" + lcPorta;
		// else
		// idColetor = lcIpAdd;
		idColetor = ipColetor;

		while (isInicializadoComSucesso == false) {

			IwsListaUpDTO listaupdto = new IwsListaUpDTO();

			try {
				// listaupdto =
				// Stubdelegate.getInstancia().getMsWsLong().getTr_inicializacao(idColetor,
				// comParadaSemConexao, false, dtHr);
				listaupdto = IwsFacade.getInstancia().inicializacao(idColetor,
						comParadaSemConexao, false, dtHr.getTime());
				// ainda n�o foi definido como ir� se portar com parada Default
			} catch (Exception e) {
				listaupdto.setIsSGBDOnline(false);
			}

			int tentativa = 1;
			log.info(idLog, 0, "Conectando...");
			while (listaupdto.getIsSGBDOnline() == false) {
				log.info(idLog, 0, "Conectando:" + tentativa);
				UtilsThreads.pausaNaThread(100);

				String mensagem;

				log.info(idLog, 0, "IP Coletor:(" + idColetor
						+ "). Sem conex�o com o banco de dados. Tentativa "
						+ tentativa + ".");
				UtilsThreads.pausaNaThread(2000);

				try {
					// listaupdto =
					// Stubdelegate.getInstancia().getMsWsLong().getTr_inicializacao(idColetor,
					// comParadaSemConexao, false, dtHr); //ainda n�o foi
					// definido como ir� se portar com parada Default
					listaupdto = IwsFacade.getInstancia().inicializacao(
							idColetor, comParadaSemConexao, false,
							dtHr.getTime());
				} catch (Exception e) {
					e.printStackTrace();
					log.info(idLog, 0, e.getMessage());
				}
				tentativa++;
			}

			List<IwsUpDTO> upsWebService = listaupdto.getUps();

			tentativa = 1;
			log.info(idLog, 0, "Obtendo...");

			while (upsWebService == null || upsWebService.size() == 0) {
				log.info(idLog, 0, ":" + tentativa);
				UtilsThreads.pausaNaThread(100);

				String mensagem;
				mensagem = "Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
						+ idColetor
						+ ").Entre em contato com o Administrador do sistema. Tentativa "
						+ tentativa + ".";

				log.info(idLog, 0, mensagem);
				UtilsThreads.pausaNaThread(2000);

				if (!monitora)
					return;

				// TODO Quando o webservice parou o gerenciador parou na linha
				// abaixo
				// no entando deveria continuar sem interrupcoes.

				// listaupdto =
				// Stubdelegate.getInstancia().getMsWsLong().getTr_inicializacao(idColetor,
				// comParadaSemConexao, false, dtHr); //ainda n�o foi definido
				// como ir� se portar com parada Default
				listaupdto = IwsFacade.getInstancia().inicializacao(idColetor,
						comParadaSemConexao, false, dtHr.getTime());

				upsWebService = listaupdto.getUps();
				tentativa++;
			}

			boolean isUpBemDefinida = true;
			log.info(idLog, 0, "Sinc DB...");

			List<INovaUpDTO> ups = new ArrayList<INovaUpDTO>(
					upsWebService.size());
			for (IwsUpDTO updto : upsWebService) {
				INovaUpDTO up = new INovaUpDTO();
				up.copyUpDTOWs(updto);

				if (up.getStCriacaoCP() < 1 || up.getStCriacaoCP() > 9) {
					isUpBemDefinida = false;

					String mensagem;
					mensagem = "IP Coletor:("
							+ idColetor
							+ "). Tipo de Controle de Produ��o n�o definido para a UP ("
							+ up.getUp()
							+ ").Valor atual "
							+ up.getStCriacaoCP()
							+ ". Entre em contato com o Administrador do sistema.";
					log.info(idLog, 0, mensagem);
					UtilsThreads.pausaNaThread(2000);
				} else {
					try {
						ups.add(Stubdelegate.getInstancia().InicializaUp(up));
					} catch (SemComunicacaoICException e) {
						e.printStackTrace();
					}
				}
			}

			if (isUpBemDefinida)
				isInicializadoComSucesso = true;

			if (listaupdto.getStAndonConfiguravel() == true) {
				if (isAndonAtivo == false) {
					isAndonAtivo = true;
				}
			}
			if (listaupdto.getStAndonProcessoft() == true && !isAndonAtivo
					&& (isAndonPrcsftAtivo == false)) {
				isAndonPrcsftAtivo = true;
			}
			Ups = ups;
			// Application.DoEvents();
			isIniciando = false;
		}
	}*/

	private void inicializaColetorSemEvento() {
		
		boolean isInicializadoComSucesso = false;

		while (isInicializadoComSucesso == false) {

			IwsListaUpDTO listaupdto = new IwsListaUpDTO();

			try {
				// if(GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
				// == true)
				// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd + ":" +
				// lcPorta);
				// else
				// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd);
				listaupdto = ms.inicializacaoSemEvento(ipColetor);
			} catch (Exception e) {
				listaupdto.setIsSGBDOnline(false);
				log.info(idLog, 0, e.getMessage());
			}

			int tentativa = 1;
			log.info(idLog, 0, "Conectando...");
			while (listaupdto.getIsSGBDOnline() == false) {
				log.info(idLog, 0, "Conectando..." + tentativa);
				UtilsThreads.pausaNaThread(100);

				// String mensagem;
				// if
				// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
				// == true)
				// mensagem = util.ObtemDataLocalParaLog() + " - IP Coletor:(" +
				// lcIpAdd + ":" + lcPorta +
				// "). Sem conex�o com o banco de dados. Tentativa " + tentativa
				// + ".";
				// else
				// mensagem = util.ObtemDataLocalParaLog() + " - IP Coletor:(" +
				// lcIpAdd + "). Sem conex�o com o banco de dados. Tentativa " +
				// tentativa + ".";
				log.info(idLog, 0, "IP Coletor:(" + ipColetor
						+ "). Sem conex�o com o banco de dados. Tentativa "
						+ tentativa + ".");

				UtilsThreads.pausaNaThread(60000);

				try {
					// if
					// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
					// == true)
					// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd +
					// ":" + lcPorta);
					// else
					// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd);
					listaupdto = ms.inicializacaoSemEvento(ipColetor);
				} catch (Exception e) {
					e.printStackTrace();
					log.info(idLog, 0, e.getMessage());
				}
				tentativa++;
			}

			List<IwsUpDTO> upsWebService = listaupdto.getUps();
			tentativa = 1;
			log.info(idLog, 0, "Obtendo...");
			while (upsWebService == null || upsWebService.size() == 0) {
				log.info(idLog, 0, "Obtendo:" + tentativa);
				UtilsThreads.pausaNaThread(100);

				// String mensagem;
				// if
				// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
				// == true)
				// mensagem =
				// "Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
				// + lcIpAdd + ":" + lcPorta +
				// ").Entre em contato com o Administrador do sistema. Tentativa "
				// + tentativa + ".";
				// else
				// mensagem =
				// "Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
				// + lcIpAdd +
				// ").Entre em contato com o Administrador do sistema. Tentativa "
				// + tentativa + ".";

				log.info(
						idLog,
						0,
						"Nenhuma Unidade Produtiva (UP) definida para esse coletor ("
								+ ipColetor
								+ ").Entre em contato com o Administrador do sistema. Tentativa "
								+ tentativa + ".");

				UtilsThreads.pausaNaThread(60000);
				if (!monitora)
					return;

				// TODO Quando o webservice parou o gerenciador parou na linha
				// abaixo
				// no entando deveria continuar sem interrupcoes.
				try {
					// if
					// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
					// == true)
					// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd +
					// ":" + lcPorta);
					// else
					// listaupdto = getMsWs().inicializacaoSemEvento(lcIpAdd);
					listaupdto = ms.inicializacaoSemEvento(ipColetor);

					upsWebService = listaupdto.getUps();
				} catch (Exception e) {
					log.info(idLog, 0, e.getMessage());
					return;
				}
				tentativa++;
			}

			boolean isUpBemDefinida = true;
			log.info(idLog, 0, "Sinc DB...");
			List<INovaUpDTO> ups = new ArrayList<INovaUpDTO>(
					upsWebService.size());
			for (IwsUpDTO updto : upsWebService) {
				INovaUpDTO up = new INovaUpDTO();
				up.copyUpDTOWs(updto);

				if (up.getStCriacaoCP() < 1 || up.getStCriacaoCP() > 9) {
					isUpBemDefinida = false;

					// String mensagem;
					// if
					// (GerenciadorConcentrador.Gerente.getInstancia().AtivarIdIpPorta
					// == true)
					// mensagem = "IP Coletor:(" + lcIpAdd + ":" + lcPorta +
					// ").Tipo de Controle de Produ��o n�o definido para a UP ("
					// + up.up + "). Valor atual " + up.stCriacaoCP +
					// ". Entre em contato com o Administrador do sistema.";
					// else
					// mensagem = "IP Coletor:(" + lcIpAdd +
					// ").Tipo de Controle de Produ��o n�o definido para a UP ("
					// + up.up + "). Valor atual " + up.stCriacaoCP +
					// ". Entre em contato com o Administrador do sistema.";
					log.info(
							idLog,
							0,
							"IP Coletor:("
									+ ipColetor
									+ ").Tipo de Controle de Produ��o n�o definido para a UP ("
									+ up.getUp()
									+ "). Valor atual "
									+ up.getStCriacaoCP()
									+ ". Entre em contato com o Administrador do sistema.");
					UtilsThreads.pausaNaThread(60000);
				} else {
					try {
						ups.add(Stubdelegate.getInstancia().InicializaUp(up));
						atualizaListaMatPrima(
								up.getIdUP(),
								Stubdelegate.getInstancia()
										.buscaListaMateriaPrima(up.getIdUP(),
												log, idLog));
					} catch (SemComunicacaoICException e) {
						log.info(idLog, 0, e.getMessage());
					}
				}
			}

			if (isUpBemDefinida)
				isInicializadoComSucesso = true;

			isAndonAtivo = listaupdto.getStAndonConfiguravel();
			// if(listaupdto.getStAndonConfiguravel() == true) {
			// if(isAndonAtivo == false) {
			// isAndonAtivo = true;
			// }
			//
			// armazenaListaUpdto(listaupdto);
			// }

			if (listaupdto.getStAndonProcessoft() == true && !isAndonAtivo
					&& (isAndonPrcsftAtivo == false)) {
				isAndonPrcsftAtivo = true;
			}

			Ups = ups;
			isIniciando = false;
		}
	}

	private INovaUpDTO verificaSeHouveAlteracaoUP(INovaUpDTO updto,
			INovaUpDTO updtoNew) {
		INovaUpDTO retorno = null;
		if (updto.getStCriacaoCP() != updtoNew.getStCriacaoCP()
				|| !comparaCP(updto.getCp(), updtoNew.getCp())) {
			retorno = updto;
			retorno.setStCriacaoCP(updtoNew.getStCriacaoCP());
			if (updtoNew.getCp().getProdutos() == null)
				updtoNew.getCp().setProdutos(updto.getCp().getProdutos());
			retorno.setCp(updtoNew.getCp());
		}

		return retorno;
	}

	private boolean comparaCP(IwsCpDTO cp1, IwsCpDTO cp2) {
		if (cp2 == null || cp1 == null)
			return true;

		if (cp1.getCdestrutura() != cp2.getCdestrutura())
			return false;
		if (cp1.getCdmolde() != cp2.getCdmolde())
			return false;
		if (cp1.getCdProduto() != cp2.getCdProduto())
			return false;
		if (cp1.getCfgPercTmpCicloParAuto() != cp2.getCfgPercTmpCicloParAuto())
			return false;
		if (cp1.getCfgPercToleranciaSinalCiclo() != cp2
				.getCfgPercToleranciaSinalCiclo())
			return false;
		if (cp1.getCfgTamanhoUmPacoteCiclos() != cp2
				.getCfgTamanhoUmPacoteCiclos())
			return false;
		if (cp1.getCfgTolerTmpCicloParAuto() != cp2
				.getCfgTolerTmpCicloParAuto())
			return false;
		if (cp1.getCicloPadrao() != cp2.getCicloPadrao())
			return false;
		if (cp1.getDthrIPlanejamento() != cp2.getDthrIPlanejamento())
			return false;
		if (cp1.getIsProducaoValida() != cp2.getIsProducaoValida())
			return false;
		if (cp1.getIsSGBDOnline() != cp2.getIsSGBDOnline())
			return false;
		if (cp1.getNrop() != cp2.getNrop())
			return false;
		if (cp1.getNropestendido() != cp2.getNropestendido())
			return false;
		if (cp1.getCdmoldeestendido() != cp2.getCdmoldeestendido())
			return false;
		if (cp1.getProducaoPlanejada() != cp2.getProducaoPlanejada())
			return false;
		if (cp2.getProdutos() != null) {
			if (cp1.getProdutos() != cp2.getProdutos())
				return false;
		}
		if (cp1.getQtcavidades() != cp2.getQtcavidades())
			return false;
		if (cp1.getQtciclos() != cp2.getQtciclos())
			return false;
		if (cp1.getStCriacaoCP() != cp2.getStCriacaoCP())
			return false;

		return true;
	}

	private void setProducao(INovaUpDTO lcup) {
		BigDecimal nCicloS = lcup.getNumeroDeCiclos();
		Integer nProdLiq = lcup.getProducaoLiquida().intValue();

		// TODO: CONSIDERACICLOABERTO - TEM QUE PEGAR ESSA CONFIGURACAO
		// if(Gerente.getInstancia().ConsideraCicloEmAberto &&
		// lcup.getIsCicloAberto() && lcup.getCp() != null)
		// {
		// nProdLiq = new Double(lcup.getProducaoLiquida() +
		// (lcup.getCavidadesAtivas() *
		// lcup.getCp().getCfgTamanhoUmPacoteCiclos())).intValue();
		// nCicloS = lcup.getNumeroDeCiclos().add(new BigDecimal(1));
		//
		// }

		String Comando = "SETPROD;" + lcup.getIdSubColetor().toString() + ";"
				+ nCicloS.toString() + ";" + nProdLiq.toString() + ";"
				+ obtemFracaoDouble(lcup.getProducaoLiquida()) + ";";

		enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

	private boolean VerificaIntegridadeListaUP(IwsUpDTO updto1) {
		if ((upsAtualizadas != null)) {

			for (IwsUpDTO updto2 : upsAtualizadas) {

				if (updto1.getIdSubColetor() == updto2.getIdSubColetor()
						&& updto1.getIdUP() != updto2.getIdUP()) {
					if (updto2.getIsUpAtiva() == true) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public String setInsPec(INovaUpDTO lcupdto,
			IwsInspecaoManualDTO dadosInspecao) {
		// TODO: Arrumar tempo para fazer este m�todo de forma descente
		String retorno, Comando = "";
		retorno = "RESP;31;" + lcupdto.getIdSubColetor().toString() + ";1;"; // cabe�alho
																				// padr�o
		Comando = "SETINSPEC;" + lcupdto.getIdSubColetor().toString() + ";";

		if (dadosInspecao.getPrupexecinspecao().getDsParametro() == null)
			Comando += "N/A;";
		else
			Comando += dadosInspecao.getPrupexecinspecao().getDsParametro()
					+ ";";
		// Dado1 - dsparametro
		if (dadosInspecao.getPrupexecinspecao().getDsProduto() == null)
			Comando += "N/A;";
		else
			Comando += dadosInspecao.getPrupexecinspecao().getDsProduto() + ";";
		// Dado2 - dsproduto
		if (dadosInspecao.getPrupexecinspecao().getIdCavidade().intValue() != 0) {
			if (dadosInspecao.getPrupexecinspecao().getNmCavidade() == null)
				Comando += " ;";
			else
				Comando += dadosInspecao.getPrupexecinspecao().getNmCavidade()
						+ ";";
			// Dado3 - nmcavidade
		} else
			Comando += " ;";

		// Dado3 - nmcavidade
		Comando += dadosInspecao.getPrupexecinspecao().getTpParametro() + ";";
		// Dado4 - tpparametro
		Comando += dadosInspecao.getPrupexecinspecao().getIdExecInpecao() + ";";
		// Dado5 - idexecinspecao
		if (dadosInspecao.getPrupexecinspecao().getTpParametro() == '1') {
			Comando += dadosInspecao.getPrupexecinspecao().getTamAmostra()
					.toString()
					+ ";";
			// Dado6 - tamamostra
			Comando += "1;";
			// Dado7 - tpentradavlr

			Comando += "0;0;"; // dados 8 dado9
		} else {
			if (dadosInspecao.getPrupexecinspecao().getTpParametro() == '2') {
				Comando += dadosInspecao.getPrupexecinspecao().getAmostra()
						+ ";";
				// Dado6 - amostra

				if (dadosInspecao.getPrupexecinspecao().getTpEntradaVlr() == 2) {
					Comando += dadosInspecao.getPrupexecinspecao()
							.getTpEntradaVlr().toString()
							+ ";";
					// Dado7 - tpentradavlr

					if (dadosInspecao.getPrupexecinspecao().getIdDriver()
							.contains("MARPOSS_E4N")) {
						if (dadosInspecao.getPrupexecinspecao().getPorta() != null) {
							Comando += "1;";// Dado8 - iddriver
							Comando += dadosInspecao.getPrupexecinspecao()
									.getPorta() + ";";// Dado9 -Porta
						} else {
							retorno = "RESP;31;"
									+ lcupdto.getIdSubColetor().toString()
									+ ";0;25; ; ; ; ; ; ; ; ;";
						} // erro no driver
					} else if (dadosInspecao.getPrupexecinspecao()
							.getIdDriver().contains("MULTIPLEXADOR")) {
						if (dadosInspecao.getPrupexecinspecao().getPorta() != null) {
							Comando += "2;";// Dado8 - iddriver
							Comando += dadosInspecao.getPrupexecinspecao()
									.getPorta() + ";";// Dado9 -Porta

						} else {
							retorno = "RESP;31;"
									+ lcupdto.getIdSubColetor().toString()
									+ ";0;25; ; ; ; ; ; ; ; ;";
						} // erro no driver
					} else {
						retorno = "RESP;31;"
								+ lcupdto.getIdSubColetor().toString()
								+ ";0;26; ; ; ; ; ; ; ; ;";
					} // erro no driver
				} else if (dadosInspecao.getPrupexecinspecao()
						.getTpEntradaVlr() == 1) {
					Comando += dadosInspecao.getPrupexecinspecao()
							.getTpEntradaVlr().toString()
							+ ";";
					// Dado7 - tpentradavlr
				} else if (dadosInspecao.getPrupexecinspecao()
						.getTpEntradaVlr() == 0) {
					if (dadosInspecao.getPrupexecinspecao().getIdDriver() == null) {
						Comando += "1;";
						// Dado7 - tpentradavlr
						// se o modo de leitura for misto e o driver for NULL,
						// envia que tipo de leitura � manual
						// por n�o haver driver especificado
					} else {
						if (dadosInspecao.getPrupexecinspecao().getIdDriver()
								.equals("MARPOSS_E4N")) {
							if (dadosInspecao.getPrupexecinspecao().getPorta() != null) {
								Comando += "0;";// Dado7 - tpentradavlr
								Comando += "1;";// Dado8 - iddriver
								Comando += dadosInspecao.getPrupexecinspecao()
										.getPorta() + ";";// Dado9 -Porta
							} else {
								retorno = "RESP;31;"
										+ lcupdto.getIdSubColetor().toString()
										+ ";0;25; ; ; ; ; ; ; ; ;";
							} // erro no driver
						} else if (dadosInspecao.getPrupexecinspecao()
								.getIdDriver().contains("MULTIPLEXADOR")) {
							Comando += "0;";// Dado7 - tpentradavlr
							Comando += "2;";// Dado8 - iddriver
							Comando += dadosInspecao.getPrupexecinspecao()
									.getPorta() + ";";// Dado9 -Porta
						} else {
							retorno = "RESP;31;"
									+ lcupdto.getIdSubColetor().toString()
									+ ";0;26; ; ; ; ; ; ; ; ;";
						} // erro no driver
					}
				}
			} else {
				retorno = "RESP;31;" + lcupdto.getIdSubColetor().toString()
						+ ";0;21; ; ; ; ; ; ; ; ;";
			}
		}

		this.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
		return retorno;
	}

	private void processaListaAndon() {
		log.info(idLog, 0, "processaListaAndon");

		if (isListaAndonInicializada == false)
			return;

		INovaAndonDTO paramAndonAtual = new INovaAndonDTO();
		INovaReleDTO dadosRele = new INovaReleDTO();
		// INovaAndonDTO cleanAndonEvent = new INovaAndonDTO();

		List<INovaAndonDTO> lcDadosAndon = new ArrayList<INovaAndonDTO>();
		int contVezes = 0;
		if (isAndonAtivo == true) { // verifica se o andon est� ativo e se � do
									// tipo andon configur�vel
			log.info(idLog, 1, "LOG: inicio processaListaAndon()");

			for (INovaUpDTO updto : listaMngmtAndon) {
				int lcIdRele;
				List<INovaAndonDTO> currentUpRelayStatus = new ArrayList<INovaAndonDTO>();
				INovaAndonDTO currentRelay = new INovaAndonDTO();

				currentUpRelayStatus = estadoAtualUp(updto.getIdUP(),
						updto.getListaAndonDTO());

				if (contVezes != 0) {
					for (int i = 0; i < lcDadosAndon.size(); i++) {

						currentRelay = currentUpRelayStatus.get(i);
						lcIdRele = currentRelay.getIdrele().intValue();

						if (lcIdRele == 0)
							continue;

						paramAndonAtual = lcDadosAndon.get(lcIdRele - 1);

						if (currentRelay.getPrioridade().compareTo(
								paramAndonAtual.getPrioridade()) < 0) {
							paramAndonAtual = currentRelay;
							lcDadosAndon.set(lcIdRele - 1, paramAndonAtual);
						}
					}// for
				} else {
					lcDadosAndon = new ArrayList<INovaAndonDTO>(
							currentUpRelayStatus.size());
					lcDadosAndon.addAll(currentUpRelayStatus);
				}
				contVezes++;
			}// foreach

			// busca as ultimas configura��es para o rel� em quest�o
			// significa que h� novas configura��es para o rel�
			if (lcDadosAndon.size() > 0) {
				/*
				 * agora a lista possui 16 itens visto que podem ser utilizados
				 * 8 rel�s e 8 sa�das digitais
				 */
				for (int i = 0; i < 16; i++) {
					if (lcDadosAndon.get(i).getIdeventoandon() == ultimosParamAndon
							.get(i).getIdeventoandon()
							&& lcDadosAndon.get(i).getIdup()
									.equals(ultimosParamAndon.get(i).getIdup())) {
						dadosRele.copyAndonDTO(lcDadosAndon.get(i));
						// se o evento de parada ainda � o �ltimo evento em
						// execu��o para o rel�
						if (ultimosParamAndon.get(i).getTimerIniciado()
								&& ultimosParamAndon.get(i).getTpeventoandon()
										.intValue() == 1) {
							if (lcDadosAndon.get(i).getListaAndonArgsDTO() != null) {
								int j = 0;
								boolean trataisso = false;

								for (j = 0; j < lcDadosAndon.get(i)
										.getListaAndonArgsDTO().size(); j++) {
									if (lcDadosAndon.get(i)
											.getListaAndonArgsDTO().get(j)
											.getVlreferencianum() == 3) {
										trataisso = true;
										break;
									}
								}

								if (trataisso) {
									double difftime = Util
											.getTempoTranscorridoEmSegundos(
													ultimosParamAndon.get(i)
															.getDtHrInicio(),
													dataHoraUltimoEvento);

									boolean eventoParada = verificaEventoComIndicadores(
											lcDadosAndon.get(i)
													.getListaAndonArgsDTO()
													.get(j), difftime);

									if (eventoParada == true) {
										ultimosParamAndon.get(i)
												.setTimerIniciado(false);
										dadosRele
												.copyAndonDTO(ultimosParamAndon
														.get(i));
										setarSaidaAndonFlexivel(dadosRele);
									}
								}
							}
						}

						// se o evento de inspe��o ainda � o �ltimo evento em
						// execu��o para o rel� e o timer est� iniciado
						else if (ultimosParamAndon.get(i).getTimerIniciado()
								&& ultimosParamAndon.get(i).getTpeventoandon()
										.intValue() == 3) {
							double diffTime = Util
									.getTempoTranscorridoEmSegundos(
											ultimosParamAndon.get(i)
													.getDtHrInicio(), Calendar
													.getInstance());

							if (new Double(diffTime).intValue() > (ultimosParamAndon
									.get(i).getTmpliminspqld().intValue() * 60)) {
								ultimosParamAndon.get(i)
										.setTimerIniciado(false);
								lcDadosAndon.get(i).setStativo(
										new BigDecimal(0));
								dadosRele.copyAndonDTO(lcDadosAndon.get(i));
								setarSaidaAndonFlexivel(dadosRele);
							}
						}
						// se o evento de inspe��o ainda � o �ltimo evento em
						// execu��o para o rel� e o timer N�O est� iniciado
						else if (!ultimosParamAndon.get(i).getTimerIniciado()
								&& ultimosParamAndon.get(i).getTpeventoandon()
										.intValue() == 3) {
							ultimosParamAndon.get(i).setTimerIniciado(true);

							if (lcDadosAndon.get(i).getTmpliminspqld()
									.intValue() == 0) {
								ultimosParamAndon.get(i).setTmpliminspqld(
										new BigDecimal(4));
								lcDadosAndon.get(i).setTmpliminspqld(
										new BigDecimal(4)); // tempo padr�o: 4
															// minutos
							}

							ultimosParamAndon.get(i).setDtHrInicio(
									Calendar.getInstance());
							setarSaidaAndonFlexivel(dadosRele);
						}
						// se o evento ainda � o �ltimo em execu��o para o rel�
						// teve seus par�metros modificados
						else if (!lcDadosAndon
								.get(i)
								.getTmpsinalalto()
								.equals(ultimosParamAndon.get(i)
										.getTmpsinalalto())
								|| !lcDadosAndon
										.get(i)
										.getTmpsinalbaixo()
										.equals(ultimosParamAndon.get(i)
												.getTmpsinalbaixo())
								|| !lcDadosAndon
										.get(i)
										.getStintermitente()
										.equals(ultimosParamAndon.get(i)
												.getStintermitente())
								|| !lcDadosAndon
										.get(i)
										.getStativo()
										.equals(ultimosParamAndon.get(i)
												.getStativo())) {
							setarSaidaAndonFlexivel(dadosRele);
						}
						// do contr�rio, n�o faz nada
						else
							continue;

						ultimosParamAndon.set(i, lcDadosAndon.get(i));
					} else {
						dadosRele.copyAndonDTO(lcDadosAndon.get(i));
						// se os eventos s�o de parada ou de inspe��o, h�
						// necessidade de fazer execu��o com timer
						if ((lcDadosAndon.get(i).getTpeventoandon().intValue() == 3)
								|| (lcDadosAndon.get(i).getTpeventoandon()
										.intValue() == 1)
								|| (lcDadosAndon.get(i).getTpeventoandon()
										.intValue() == 14)
								|| (lcDadosAndon.get(i).getTpeventoandon()
										.intValue() == 15)
								|| (lcDadosAndon.get(i).getTpeventoandon()
										.intValue() == 17)) {
							if (lcDadosAndon.get(i).getTpeventoandon()
									.intValue() == 3
									&& ultimosParamAndon.get(i)
											.getTimerIniciado() == false) {
								ultimosParamAndon.get(i).setTimerIniciado(true);
								if (lcDadosAndon.get(i).getTmpliminspqld()
										.intValue() == 0) {
									ultimosParamAndon.get(i).setTmpliminspqld(
											new BigDecimal(4));
									lcDadosAndon.get(i).setTmpliminspqld(
											new BigDecimal(4)); // tempo padr�o:
																// 4 minutos
								}
								ultimosParamAndon.get(i).setDtHrInicio(
										Calendar.getInstance());
								setarSaidaAndonFlexivel(dadosRele);
							} else if (lcDadosAndon.get(i).getTpeventoandon()
									.intValue() == 1
									&& ultimosParamAndon.get(i)
											.getTimerIniciado() == false) {
								ultimosParamAndon.get(i).setTimerIniciado(true);
								INovaUpDTO localUp = getUP(lcDadosAndon.get(i)
										.getIdup());

								Calendar DthrIparada = Calendar.getInstance();
								DthrIparada.setTime(localUp
										.getUltimaParadaAtual()
										.getDthrIparada());

								ultimosParamAndon.get(i).setDtHrInicio(
										DthrIparada);

								dadosRele.copyAndonDTO(lcDadosAndon.get(i));
								dadosRele.setINF02("0");
								setarSaidaAndonFlexivel(dadosRele);
							} else if (lcDadosAndon.get(i).getTpeventoandon()
									.intValue() == 14
									&& ultimosParamAndon.get(i)
											.getTimerIniciado() == false) {
								ultimosParamAndon.get(i).setTimerIniciado(true);
								INovaUpDTO localUp = getUP(lcDadosAndon.get(i)
										.getIdup());

								Calendar DtHrIni = Calendar.getInstance();
								DtHrIni.setTime(localUp.getVariacaoRitmoDTO()
										.getDtHrIni());

								ultimosParamAndon.get(i).setDtHrInicio(DtHrIni);

								dadosRele.copyAndonDTO(lcDadosAndon.get(i));
								dadosRele.setINF02("0");
								setarSaidaAndonFlexivel(dadosRele);
							} else if (lcDadosAndon.get(i).getTpeventoandon()
									.intValue() == 15
									&& ultimosParamAndon.get(i)
											.getTimerIniciado() == false) {
								ultimosParamAndon.get(i).setTimerIniciado(true);
								INovaUpDTO localUp = getUP(lcDadosAndon.get(i)
										.getIdup());

								Calendar DtHrInicio = Calendar.getInstance();
								DtHrInicio.setTime(localUp.getDadosCIP()
										.getDtHrInicio());

								ultimosParamAndon.get(i).setDtHrInicio(
										DtHrInicio);

								dadosRele.copyAndonDTO(lcDadosAndon.get(i));
								dadosRele.setINF02("0");
								setarSaidaAndonFlexivel(dadosRele);
							} else if (lcDadosAndon.get(i).getTpeventoandon()
									.intValue() == 17
									&& ultimosParamAndon.get(i)
											.getTimerIniciado() == false) {
								ultimosParamAndon.get(i).setTimerIniciado(true);
								INovaUpDTO localUp = getUP(lcDadosAndon.get(i)
										.getIdup());

								Calendar dthrinialerta = Calendar.getInstance();
								dthrinialerta.setTime(localUp
										.getListaAlertasDiariodeBordo().get(0)
										.getdthrinialerta());

								ultimosParamAndon.get(i).setDtHrInicio(
										dthrinialerta);
								dadosRele.copyAndonDTO(lcDadosAndon.get(i));
								dadosRele.setINF02("0");
								setarSaidaAndonFlexivel(dadosRele);
							}
						}
						// do contr�rio, os outros eventos podem ser executados
						// diretamente
						else {
							setarSaidaAndonFlexivel(dadosRele);
						}
					}
					ultimosParamAndon.set(i, lcDadosAndon.get(i));
				}// for
			} else if (lcDadosAndon.size() <= 0) {
				INovaReleDTO rele = new INovaReleDTO();
				INovaAndonDTO turnOffRelay = new INovaAndonDTO();
				/*
				 * agora a lista possui 16 itens visto que podem ser utilizados
				 * 8 rel�s e 8 sa�das digitais
				 */
				for (int i = 0; i < 16; i++) {
					if (ultimosParamAndon.get(i).getStativo().intValue() != 0) {
						turnOffRelay.setIdrele(new BigDecimal(i + 1));
						turnOffRelay.setStativo(new BigDecimal(0));
						turnOffRelay.setStintermitente(new BigDecimal(0));
						turnOffRelay.setTmpsinalalto(new BigDecimal(0));
						turnOffRelay.setTmpsinalbaixo(new BigDecimal(0));
						rele.copyAndonDTO(turnOffRelay);
						setarSaidaAndonFlexivel(rele);
						ultimosParamAndon.set(i, turnOffRelay);
					}
				}
			}

			log.info(idLog, 0, "LOG: fim processaListaAndon()");
		}
	}

	private List<INovaAndonDTO> estadoAtualUp(String idup,
			List<IwsAndonDTO> localDadosAndon) {
		log.info(idLog, 0, "estadoAtualUp");
		INovaUpDTO localUp = new INovaUpDTO();
		INovaAndonDTO andonEventToExecute;
		List<INovaAndonDTO> andonEventsHighPriority = new ArrayList<INovaAndonDTO>();
		// inicializa a lista de eventos de maior prioridade a serem executados

		for (int i = 0; i < 16; i++) {
			andonEventsHighPriority.add(new INovaAndonDTO());
			andonEventsHighPriority.get(i).setIdup("");
			andonEventsHighPriority.get(i).setIdrele(new BigDecimal(i + 1));
			andonEventsHighPriority.get(i).setPrioridade(
					new BigDecimal(Integer.MAX_VALUE));
		}

		// busca UpDTO para trabalhar com os estados atuais da unidade produtiva
		localUp = getUP(idup);

		if (localDadosAndon == null || localUp.getListaAndonDTO() == null
				|| localUp.getIdUP() == null
				|| localUp.getIsSemPrograma() == true) {
			// controle de erro: caso a lista de eventos de ando n�o tenha sido
			// recebida ou inicializada
			return andonEventsHighPriority;
		}

		for (IwsAndonDTO dadosAndonWs : localDadosAndon) {
			// TODO: VERIFICAR ESSE CAST
			INovaAndonDTO dadosAndon = (INovaAndonDTO) dadosAndonWs;

			List<IwsAndonArgsDTO> listaArgumentos = new ArrayList<IwsAndonArgsDTO>();
			andonEventToExecute = new INovaAndonDTO();

			IwsAndonArgsDTO argumentoTp1 = new IwsAndonArgsDTO(); // ARGUMENTO
																	// DE
																	// REFER�NCIA
																	// PARA
																	// PARADA
			IwsAndonArgsDTO argumentoTp2 = new IwsAndonArgsDTO(); // ARGUMENTO
																	// DE
																	// REFER�NCIA
																	// PARA
																	// ALERTA
			IwsAndonArgsDTO argumentoTp3 = new IwsAndonArgsDTO(); // ARGUMENTO
																	// DE
																	// REFER�NCIA
																	// DE TEMPO
																	// PARA
																	// PARADA
			IwsAndonArgsDTO argumentoTp4 = new IwsAndonArgsDTO(); // ARGUMENTO
																	// DE
																	// REFER�NCIA
																	// PARA
																	// EVENTOS
																	// 9, 10, 11
																	// E 12

			// controle de erro: caso sejam definidos apenas eventos sem
			// argumentos (3, 4, 5, 6 e 7)
			if (dadosAndon.getListaAndonArgsDTO() != null
					|| dadosAndon.getListaAndonArgsDTO().size() > 0) {

				for (int j = 0; j < dadosAndon.getListaAndonArgsDTO().size(); j++) {

					try {
						if (dadosAndon.getListaAndonArgsDTO().get(j)
								.getTpvlreferencia().intValue() == 1) {
							argumentoTp1 = listaArgumentos.get(j);
							continue;
						}
						if (dadosAndon.getListaAndonArgsDTO().get(j)
								.getTpvlreferencia().intValue() == 2) {
							argumentoTp2 = listaArgumentos.get(j);
							continue;
						}
						if (dadosAndon.getListaAndonArgsDTO().get(j)
								.getTpvlreferencia().intValue() == 3) {
							argumentoTp3 = listaArgumentos.get(j);
							continue;
						}
						if (dadosAndon.getListaAndonArgsDTO().get(j)
								.getTpvlreferencia().intValue() == 4) {
							argumentoTp4 = listaArgumentos.get(j);
							continue;
						}
					} catch (Exception e) {
						log.info(idLog, 0, "err_estadoAtualUp");
						log.info(idLog, 0, e.getMessage());
						log.info(idLog, 0, e.getStackTrace());
						log.info(idLog, 0, e.getCause());
						log.info(idLog, 0, "---------------------");
					}
				}
			}

			try {
				switch (dadosAndon.getTpeventoandon().intValue()) {
				case 1: // evento de parada
					if (localUp.getIsParadaEmAberto()) {
						if (argumentoTp1 != null
								&& argumentoTp1.getVlreferenciastr() != null
								&& localUp.getUltimaParadaAtual() != null
								&& argumentoTp1.getVlreferenciastr().equals(
										localUp.getUltimaParadaAtual()
												.getCdParada())) {
							andonEventToExecute = dadosAndon;
							andonEventToExecute
									.setTmpliminspqld(new BigDecimal(
											argumentoTp3.getVlreferencianum()));
						}
					}
					break;
				case 2: // evento de alerta
					if (localUp.getListaAlertasEmAberto() != null) {
						for (IwsAlertaDTO alerta : localUp
								.getListaAlertasEmAberto()) {
							if (argumentoTp2 != null
									&& argumentoTp2.getVlreferenciastr() != null
									&& argumentoTp2.getVlreferenciastr()
											.equals(alerta.getCdAlerta())) {
								andonEventToExecute = dadosAndon;
								// break;
							}
						}
					}
					break;
				case 3: // evento de inspe��o pendente
					if (localUp.getIsComInspecaoPendente()) {
						andonEventToExecute = dadosAndon;
					}
					break;
				/*
				 * A vari�vel resultUltimaInspecao segue a seguinte l�gica: 0 -
				 * n�o h� resultado 1 - aprovado 2 - reprovado 3 - aprovado com
				 * restri��o 4 - usado apenas para determinar que esta vari�vel
				 * n�o foi modificada
				 */
				case 4: // evento de resultado de inspe��o
					if (localUp.getResultadoUltimaInspecao().equals(2)) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 5: // evento de resultado de inspe��o
					if (localUp.getResultadoUltimaInspecao().equals(3)) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 6: // evento de resultado de inspe��o
					if (localUp.getResultadoUltimaInspecao().equals(1)) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 7: // evento de m�quina trabalhando
					if ((localUp.getIsEmRegulagem() == false)
							&& (localUp.getIsParadaEmAberto() == false)
							&& (localUp.getIsSemPrograma() == false)) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 8: // evento de efici�ncia de ciclo
					if (verificaEventoComIndicadores(argumentoTp4,
							localUp.getvleficultciclo())) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 9: // evento de �ndice de parada
					if (verificaEventoComIndicadores(argumentoTp4,
							dadosAndon.getIndicadorASerUsado())) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 10: // evento de �ndice de refugo
					if (verificaEventoComIndicadores(argumentoTp4,
							dadosAndon.getIndicadorASerUsado())) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 11: // evento de OEE
					if (verificaEventoComIndicadores(argumentoTp4,
							dadosAndon.getIndicadorASerUsado())) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 12: // evento de efici�ncia de realiza��o
					if (verificaEventoComIndicadores(argumentoTp4,
							dadosAndon.getIndicadorASerUsado())) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 13: // evento de parada. ativa��o em qualquer parada aberta
					if (localUp.getIsParadaEmAberto() == true) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 14: // evento de Varia��o de Ritmo
					if (localUp.getVariacaoRitmoDTO() != null
							&& localUp.getVariacaoRitmoDTO()
									.getIsComVariacaoRitmoPend()) {
						andonEventToExecute = dadosAndon;
						andonEventToExecute.setTmpliminspqld(new BigDecimal(
								argumentoTp3.getVlreferencianum()));
					}
					break;
				case 15: // evento de Tempo limite de CIP extrapolado
					if (localUp.getDadosCIP() != null
							&& localUp.getDadosCIP().getIsEmCIP() == true) {
						andonEventToExecute = dadosAndon;
						andonEventToExecute.setTmpliminspqld(new BigDecimal(
								argumentoTp3.getVlreferencianum()));
					}
					break;
				case 16: // evento de apontamento pendente no Di�rio de bordo
					if ((localUp.getListaAlertasDiariodeBordo() != null)
							&& (localUp.getListaAlertasDiariodeBordo().size() > 0)) {
						andonEventToExecute = dadosAndon;
					}
					break;
				case 17: // evento de Extrapolamento de tempo no Di�rio de bordo
					if ((localUp.getListaAlertasDiariodeBordo() != null)
							&& (localUp.getListaAlertasDiariodeBordo().size() > 0)) {
						andonEventToExecute = dadosAndon;
						andonEventToExecute.setTmpliminspqld(new BigDecimal(
								argumentoTp3.getVlreferencianum()));
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				log.info(idLog, 0, "err_estadoAtualUp");
				log.info(idLog, 1, e.getMessage());
				log.info(idLog, 1, e.getStackTrace());
				log.info(idLog, 1, e.getCause());
				log.info(idLog, 0, "---------------------");
			}

			Integer indRele = andonEventToExecute.getIdrele().intValue();

			if (indRele > 0) {
				if (andonEventToExecute.getPrioridade().compareTo(
						andonEventsHighPriority.get(indRele - 1)
								.getPrioridade()) <= 0) {
					andonEventsHighPriority.set(indRele - 1,
							new INovaAndonDTO());
					andonEventsHighPriority.set(indRele - 1,
							andonEventToExecute);
				}
			}
		}
		return andonEventsHighPriority;
	}

	private boolean verificaEventoComIndicadores(IwsAndonArgsDTO argumento,
			Double parametro) {
		log.info(idLog, 0, "verificaEventoComIndicadores");

		if (argumento.getOperadorcalculo().length() > 1) {
			if (argumento.getOperadorcalculo().equals("<=") == true) {
				if (parametro <= argumento.getVlreferencianum()) {
					return true;
				}
			}

			if (argumento.getOperadorcalculo().equals(">=") == true) {
				if (parametro >= argumento.getVlreferencianum()) {
					return true;
				}
			}

			if (argumento.getOperadorcalculo().equals("<>") == true) {
				if (parametro != argumento.getVlreferencianum()) {
					return true;
				}
			}
		} else {
			if (argumento.getOperadorcalculo().equals(">") == true) {
				if (parametro > argumento.getVlreferencianum()) {
					return true;
				}
			}
			if (argumento.getOperadorcalculo().equals("<") == true) {
				if (parametro < argumento.getVlreferencianum()) {
					return true;
				}
			}
			if (argumento.getOperadorcalculo().equals("=") == true) {
				if (parametro == argumento.getVlreferencianum()) {
					return true;
				}
			}

		}
		return false;
	}

	private void setarSaidaAndonFlexivel(IwsReleDTO dadosRele) {
		log.info(idLog, 0, "setarSaidaAndonFlexivel");
		if (Integer.parseInt(dadosRele.getINF01()) <= 8) // se o IdRele estiver
															// entre 1 e 8,
															// significa que
															// evento ativa
															// rel�s
		{
			setRele(dadosRele);
		} else // se IdRele estiver acima de 8, entre 9 e 16, significa que
				// evento ativa sa�das digitais
		{
			if (isAndonPrcsftAtivo && isAndonAtivo)
				isAndonPrcsftAtivo = false;
			int idrele = Integer.parseInt(dadosRele.getINF01()) - 9;
			// sa�das digitais s�o numeradas de 0 a 7 (8 sa�das)
			setSaida(String.valueOf(idrele), dadosRele.getINF02(),
					dadosRele.getINF03(), dadosRele.getINF04(),
					dadosRele.getINF05(), true);
		}
	}

	public int getBatidasFromBarCode(String barcode) {
		int retorno = 1;
		try {
			retorno = Integer.parseInt(barcode.substring(24, 29));
		} catch (Exception e) {
		}
		return retorno;
	}

}

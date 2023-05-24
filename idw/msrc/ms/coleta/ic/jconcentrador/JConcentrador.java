package ms.coleta.ic.jconcentrador;

import idw.model.pojos.OmPt;
import idw.model.dao.DAOGenerico;
import idw.model.dao.OmPtDAO;
import idw.model.pojos.DwFolha;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.OmCfg;
import idw.model.pojos.PpCp;
import idw.model.rn.CpRN;
import idw.model.rn.FolhaRN;
import idw.util.IdwLogger;
import idw.webservices.MswsComEvt;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsUpDTO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.coleta.ic.sony.bd.LinhaArquivoSonyTPRODUCT;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class JConcentrador implements IIC{
	
	private static final String IC_THREAD_NAME = "JThread-%d";
	private static final int IC_THREADS_POOL = 1;
	private Integer idLog = null;
	private IdwLogger log = null;
	
	private IcDTO msgerenciado = new IcDTO();
	private String ipColetor = null;
	private Integer portaColetor = null;
	private String ipSeparador = ":";
	
	private ArrayList<String> listaDeMensagens = new ArrayList<String>();
	private Calendar dataHoraUltimoEvento = null;
	private String separador = ";";
	private String[] dadosRecebidos = null;
	private MswsComEvt ms = new MswsComEvt();
	private boolean monitora = true;
	
	private List<IcUpDTO> icupdtos;
	private IcUpDTO icup1;
	private IcUpDTO icup2;
	private IcUpDTO icup3;
	
	
	
	private final ExecutorService jThreadPool = Executors.newFixedThreadPool(IC_THREADS_POOL,
			new BasicThreadFactory.Builder()
			.namingPattern(IC_THREAD_NAME).build());
	
	private Map<String, EventoColetado> ultimosEventos = new HashMap<>();
	private Map<String, BigDecimal> timeOutUps = new HashMap<>();
	

	
	public JConcentrador(IcDTO msgerenciado) {
		this.msgerenciado = msgerenciado;

		String urlConexao = msgerenciado.getUrl_conexao();
		icupdtos = msgerenciado.getMsIcUpDTOLocais();

		if (urlConexao.indexOf(ipSeparador) != -1) {
			ipColetor = urlConexao.split(ipSeparador)[0];
			portaColetor = Integer.parseInt(urlConexao.split(ipSeparador)[1]);
		} else {
			ipColetor = urlConexao;
			portaColetor = 1000;
		}
	}

	private IcUpDTO acharParDeSinais(String parDeSinais) {
		IcUpDTO icupDTO = new IcUpDTO();
		int tamanho = icupdtos.size();
		for(int i=0; i<tamanho;i++){
			if (icupdtos.get(i).getUrlConexao().equals(parDeSinais)){
				icupDTO = icupdtos.get(i);
				return icupDTO;
			}
		}
		return icupDTO;
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) {
		EventosColetados retorno = new EventosColetados();
		if (!listaDeMensagens.isEmpty()){
			do {
				String mensagem = listaDeMensagens.get(0);
				listaDeMensagens.remove(0);
				System.gc();
				dadosRecebidos = mensagem.split(separador);
				
				List<EventoColetado> eventos = trataEventoParaDTO(dadosRecebidos, mensagem);
				if (eventos != null){
					retorno.addEventosColetados(eventos);
				}
			}while (listaDeMensagens.size() != 0);
		}
		return retorno;
	}

	@Override
	public void inicializaIC(IdwLogger idwlog) throws SemComunicacaoICException {
		this.log = msgerenciado.getLog();
		idLog = log.getIdAleatorio();
		this.log = idwlog;
		icup1 = acharParDeSinais("1");
		icup2 = acharParDeSinais("2");
		icup3 = acharParDeSinais("3");
		
		atualizaOpsDasUps();
		inicializaConcentradorSemEvento();
		JThread threadComunicacao = new JThread(ipColetor, portaColetor, listaDeMensagens, log);
		jThreadPool.execute(threadComunicacao);
		log.info(idLog, 0,
				"finalizou chamada inicializaColetorSemEvento de inicializaIC");
		
		TratadorHeartBeat t = new TratadorHeartBeat(icupdtos,this);
		t.setName("monitoraParadaAutomaticaHeartBeat JConcentrador");
		t.start();
	}

	public void atualizaOpsDasUps() {
	    for (IcUpDTO aux : icupdtos){
	        String cd_up = aux.getUpDTO().getCd_up();
	        
	        DAOGenerico dao = new DAOGenerico();
	        
	        OmPt omPt = null;
	        try {
	            dao.iniciaConexaoBanco();
	            OmPtDAO omPtDAO = new OmPtDAO(dao.getSession());
	            omPt = omPtDAO.getOmPtAtivoComUltimaRevisao(cd_up);
	            
	            if (omPt == null) {
	            	log.error("Em atualizaOpsDasUps, omPt == null");
	                continue;
	            }
	            
	            MsPtColeta msPtColeta = omPt.getMsPtColeta();
	            if (msPtColeta == null) {
	            	log.error("Em atualizaOpsDasUps, msPtColeta == null");          
	                continue;
	            }
	            
	            PpCp ppCp = null;
	            CpRN rn = new CpRN();
	            rn.setDaoSession(dao.getSession());
	            ppCp = rn.pesquisarPpCpByNrDocCdPt(msPtColeta.getNrop(), cd_up);
	            if (ppCp == null) {
	            	log.error("Em atualizaOpsDasUps, ppCp == null");
	                continue;
	            }
	            
	            FolhaRN frn = new FolhaRN();
	            frn.setDaoSession(dao.getSession());
	            
	            DwFolha dwfolha = frn.getDwFolhaAtiva(ppCp);
	            BigDecimal timeOut;
				if(dwfolha != null){
	            	timeOut = (dwfolha.getSegCiclopadrao().multiply(dwfolha.getSegCiclotimeout())).divide(new BigDecimal(100));
	                timeOutUps.put(cd_up,timeOut);
				}

	        } catch (Exception e) {            
	            dao.rollBackTransacaoSemException();
	            log.error("Excecao pega em atualizaOpsDasUps: " + e.toString());
	        } finally {
	            dao.finalizaConexaoBancoSemException();
	        }
	}
	}

	private void inicializaConcentradorSemEvento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "0.1";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}
	public Calendar ObtemDatadeDado(String[] DadoRecebido) {
		// System.out.println("Obtem Data de Dados.");
		Calendar retorno = null;

		int dia, mes, ano, hor, min, seg, mseg;
		try {
			if (Integer.parseInt(DadoRecebido[1]) == 0) {
				// O evento 0 nao passa a data e hora
				// data e hora do ultimo evento ser� apenas
				// setado como refer�ncia nesse momento
				dataHoraUltimoEvento = Calendar.getInstance();
				return dataHoraUltimoEvento;
			}

			dia = Integer.parseInt(DadoRecebido[3]);
			if (dia == 0 || dia > 31) {
				dia = dataHoraUltimoEvento.get(Calendar.DAY_OF_MONTH);
			//	log.info(idLog, 0,
			//			"Dado de Data Incorreto - ObtemDatadeDado Dia");
			}

			mes = Integer.parseInt(DadoRecebido[4]);
			if (mes == 0 || mes > 12) {
				mes = dataHoraUltimoEvento.get(Calendar.MONTH);
			//	log.info(idLog, 0,
			//			"Dado de Data Incorreto - ObtemDatadeDado M�s");
			} else {
				// Segundo a documentacao Java, os meses vao de 0 a 11, assim
				// precisamos decrementar em 1 quando os meses vao de 1 a 21
				mes = Integer.parseInt(DadoRecebido[4]) - 1;
			}

			ano = Integer.parseInt(DadoRecebido[5]);
			if ((ano < 2012) || (ano > 2040)) {
				ano = dataHoraUltimoEvento.get(Calendar.YEAR);
			//	log.info(idLog, 0,
			//			"Dado de Data Incorreto - ObtemDatadeDado Ano");
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
				
				dataHoraUltimoEvento  = (Calendar) retorno.clone();
			} catch (Exception e) {
			//	log.info(idLog, 0,
			//			"N�o foi poss�vel converter Data - ObtemDatadeDado");
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
				log.error("Nao foi possivel converter data, Excecao pega em ObtemDatadeDado: " + e1.toString());
			}

			if (dataHoraUltimoEvento.get(Calendar.YEAR) < 2012)
				dataHoraUltimoEvento = Calendar.getInstance();

			retorno = dataHoraUltimoEvento;
		}
		return retorno;
	}
	
	private List<EventoColetado> trataEventoParaDTO(String[] DadoRecebido, String mensagemOrigem) {
		List<EventoColetado> eventosColetados = new ArrayList<EventoColetado>();
		EventoColetado evento = new EventoColetado();
		String mensagemDeOrigem = mensagemOrigem;
		int idSubColetor = 0;

		Calendar DtHrEvento = ObtemDatadeDado(DadoRecebido);

		int tipoEvento = 0;
		// estrutura
		// Evento;tpevnto;idup;dia;mes;ano;hora;min;seg;milissegundo;dado1;dado2;dado3;dado4;dado5;dado6;dado7;dado8
		try {
			tipoEvento = Integer.parseInt(DadoRecebido[1]);
		} catch (Exception e) {
			log.error("Excecao pega em trataEventoParaDTO ao tentar obter tipoEvento: " + e.toString());
			return null;
		}
		try {
			idSubColetor = Integer.parseInt(DadoRecebido[2]);
		} catch (Exception e) {
			log.error("Excecao pega em trataEventoParaDTO ao tentar obter idSubColetor: " + e.toString());
			return null;
		}
		//Primeiro seta o icupdto do respectivo evento, dependendo do par de sinais que o coletor recebeu o evento
		switch (idSubColetor) {
		case 1:
			evento.setIcUpDTO(icup1);
			break;
			
		case 2:
			evento.setIcUpDTO(icup2);
			break;
			
		case 3:
			evento.setIcUpDTO(icup3);
			break;
			
		}
		//Depois seta os dados necessarios para o evento do coletor
		switch (tipoEvento) {
		case 7: 
			evento.setTipoEvento(ServicoFactory._FIM_CICLO); // evento para o ms
			evento.setDthrEvento(DtHrEvento.getTime());
			evento.setExisteEvento(true);
			evento.setOrigem(mensagemDeOrigem);
			if (evento.getIcUpDTO().getisParada()) {
				// Checa se a parada deve ser finalizada ou nao
				if (isParadaDeveFinalizar (evento)) {
					evento.getIcUpDTO().setisParada(false);
					// Gera evento fim de parada
					EventoColetado eventoFimDeParada = geraEventoFimDeParada(evento, DtHrEvento);
					eventoFimDeParada.setOrigem(mensagemDeOrigem);
					eventosColetados.add(eventoFimDeParada);
				} else {
					// Este break serve para impedir que o objeto evento seja adicionado a lista eventosColetados
					// no caso que a parada nao deve ser finalizada
					break;
				}
			}
			eventosColetados.add(evento);
			break;
		
		case 8:
			evento.setTipoEvento(ServicoFactory._INICIO_PARADA);
			evento.setDthrEvento(DtHrEvento.getTime());
			evento.setExisteEvento(true);
			evento.getIcUpDTO().setisParada(true);
			evento.setOrigem(mensagemDeOrigem);
			eventosColetados.add(evento);
			break;
			
		case 66:
			evento.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
			evento.setDthrEvento(DtHrEvento.getTime());
			evento.setExisteEvento(true);
			evento.setOrigem(mensagemDeOrigem);
			eventosColetados.add(evento);
			break;
			
			
		default:
			return null;
		}
		evento.setLog(log);
		evento.setIdLog(idLog);
		evento.setExisteEvento(true);
		
		this.log.info("JConcentrador: Evento tratado da UP" + evento.getUp() + "de origem: \n" +
				evento.getOrigem());
		
		if (evento.getIcUpDTO() != null && evento.getIcUpDTO().getUpDTO() != null &&
				evento.getIcUpDTO().getUpDTO().getCd_up()!= null){
		ultimosEventos.put(evento.getIcUpDTO().getUpDTO().getCd_up(), evento);
		}

		return (eventosColetados);
	}

	private boolean isParadaDeveFinalizar(EventoColetado evento) {
		// 1 - Checa se a maquina esta parada com parada que requer cancelamento
		String cd_up = evento.getUp();
		DAOGenerico dao = new DAOGenerico();
        
        OmPt omPt = null;
        try {
            dao.iniciaConexaoBanco();
            OmPtDAO omPtDAO = new OmPtDAO(dao.getSession());
            omPt = omPtDAO.getOmPtAtivoComUltimaRevisao(cd_up);
            
            if (omPt == null) {
            	log.error("Em atualizaOpsDasUps, omPt == null");
            	return true;
            }
            
            MsPtColeta msPtColeta = omPt.getMsPtColeta();
            if (msPtColeta == null) {
            	log.error("Em atualizaOpsDasUps, msPtColeta == null");
            	return true;
            }
            
            // Checa se a parada e de regulagem
            if (msPtColeta.getDwTParada() != null && msPtColeta.getDwTParada().getIsRegulagem() != null 
            		&& msPtColeta.getDwTParada().getIsRegulagem())
            	return false;
            
        } catch (Exception e) {            
            dao.rollBackTransacaoSemException();
            log.error("Excecao pega em isParadaDeveFinalizar: " + e.toString());
        } finally {
            dao.finalizaConexaoBancoSemException();
        }

		return true;
	}

	private EventoColetado geraEventoFimDeParada(EventoColetado evento, Calendar DtHrEvento) {
		EventoColetado eventoFimDeParada = new EventoColetado();
		eventoFimDeParada.setTipoEvento(ServicoFactory._FIM_PARADA);
		eventoFimDeParada.setDthrEvento(new Date(DtHrEvento.getTimeInMillis() - (long)10));
		eventoFimDeParada.setExisteEvento(true);
		eventoFimDeParada.setIcUpDTO(evento.getIcUpDTO());
		eventoFimDeParada.setOrigem("Parada fechada devido ao ciclo: " + evento.getOrigem());
		return eventoFimDeParada;
	}
	
	private void inicializaColetorSemEvento() {
		
		boolean isInicializadoComSucesso = false;

		while (isInicializadoComSucesso == false) {

			IwsListaUpDTO listaupdto = new IwsListaUpDTO();

			try {
				listaupdto = ms.inicializacaoSemEvento(ipColetor);
			} catch (Exception e) {
				listaupdto.setIsSGBDOnline(false);
				log.error(idLog, 0, "Excecao pega em inicializaColetorSemEvento ao tentar obter listaupdto - 1" + e.getMessage());	
			}

			int tentativa = 1;
			log.info(idLog, 0, "Conectando...");
			while (listaupdto.getIsSGBDOnline() == false) {
				log.info(idLog, 0, "Conectando..." + tentativa);
				UtilsThreads.pausaNaThread(100);

			
				log.info(idLog, 0, "IP Coletor:(" + ipColetor
						+ "). Sem conexao com o banco de dados. Tentativa "
						+ tentativa + ".");

				UtilsThreads.pausaNaThread(60000);

				try {

					listaupdto = ms.inicializacaoSemEvento(ipColetor);
				} catch (Exception e) {
					e.printStackTrace();
					log.error(idLog, 0, "Excecao pega em inicializaColetorSemEvento ao tentar obter listaupdto - 2" + e.getMessage());
				}
				tentativa++;
			}

			List<IwsUpDTO> upsWebService = listaupdto.getUps();
			tentativa = 1;
			log.info(idLog, 0, "Obtendo...");
			while (upsWebService == null || upsWebService.size() == 0) {
				log.info(idLog, 0, "Obtendo:" + tentativa);
				UtilsThreads.pausaNaThread(100);

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

				try {
					listaupdto = ms.inicializacaoSemEvento(ipColetor);
					upsWebService = listaupdto.getUps();
					
				} catch (Exception e) {
					log.info(idLog, 0, "Excecao pega em inicializaColetorSemEvento ao tentar obter listaupdto - 3" + e.getMessage());
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
					} catch (SemComunicacaoICException e) {
						log.error(idLog, 0, "Excecao pega em inicializaColetorSemEvento - SemComunicacaoICException " + e.getMessage());
					} catch (Exception e1) {
						log.info(idLog, 0, "Excecao pega em inicializaColetorSemEvento " + e1.getMessage());
					}
				}
			}

			if (isUpBemDefinida)
				isInicializadoComSucesso = true;
		}
	}
	
	void monitoraParadaAutomaticaHeartBeat(int tempoGenerico){
		Date agora = new Date();
		BigDecimal atual = new BigDecimal(agora.getTime());
		
		for(IcUpDTO icup : icupdtos){
			
			if ((ultimosEventos.containsKey(icup.getUpDTO().getCd_up())) &&
					(timeOutUps.containsKey(icup.getUpDTO().getCd_up()))) {
				
				if(ultimosEventos.get(icup.getUpDTO().getCd_up()).getTipoEvento() == ServicoFactory._FIM_CICLO) {
					
					BigDecimal momentoDoCiclo = new BigDecimal(ultimosEventos.get(icup.getUpDTO().getCd_up()).getDthrEvento().getTime());
					BigDecimal timeOut = (timeOutUps.get(icup.getUpDTO().getCd_up())).multiply(new BigDecimal(1000));
					
					if(atual.subtract(momentoDoCiclo).compareTo(timeOut) > 0) {
						Date horaParadaAutomatica = new Date (momentoDoCiclo.add(timeOut).longValue());
						geraEventoParadaAutomatica(icup, horaParadaAutomatica);		
					}
			}
		}
				
		}
		/*for(IcUpDTO icup : icupdtos){
			if (ultimosEventos.containsKey(icup.getUpDTO().getCd_up())) {
				if((ultimosEventos.get(icup.getUpDTO().getCd_up()).getTipoEvento() == ServicoFactory._FIM_CICLO)
						&& (atual - ultimosEventos.get(icup.getUpDTO().getCd_up()).getDthrEvento().getTime() >= timeOut)){
				Date horaParadaAutomatica = new Date (ultimosEventos.get(icup.getUpDTO().getCd_up()).getDthrEvento().getTime() + timeOut);
				geraEventoParadaAutomatica(icup, horaParadaAutomatica);		
				}
			}
		}*/
	}
	
protected void geraEventoParadaAutomatica(IcUpDTO updto, Date fileLastModifiedDate) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(fileLastModifiedDate);
	String eventoParada = "EVENTO;8;" + updto.getUrlConexao()+";";
	String ano = Integer.toString(cal.get(Calendar.YEAR)) + ";";
	String mes = Integer.toString(cal.get(Calendar.MONTH)+ 1)+ ";";
	String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+ ";";
	String hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY))+ ";";
	String min = Integer.toString(cal.get(Calendar.MINUTE))+ ";";
	String sec = Integer.toString(cal.get(Calendar.SECOND))+ ";";
	String mili = Integer.toString(cal.get(Calendar.MILLISECOND)) + ";";
	
	eventoParada = eventoParada + dia + mes + ano + hora + min + sec + mili + "1;PARADA AUTOMATICA;;;;;;";
	listaDeMensagens.add(eventoParada);
	
	String[] camposEvento = eventoParada.split(";");
	
	
	
	/*	EventoColetado eventoColetado = new EventoColetado();
		
		eventoColetado.setTipoEvento(ServicoFactory._INICIO_PARADA); // Fim de Ciclo
		eventoColetado.setDthrEvento(fileLastModifiedDate);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(updto);
		// eventoColetado.setOrigem("SonyWatcher: Parada Automatica Lancada Pela Coleta");
		eventoColetado.setOrigem("");
*/
		
		log.info("EventoLogJConcentrador: Gerou evento de Inicio de Parada:;"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(ObtemDatadeDado(camposEvento).getTime()) 
				+ ";");

	}

void geraEventoHeartBeat(){
	Calendar cal = Calendar.getInstance();
	for (IcUpDTO icup : icupdtos){
	//cal.setTime(fileLastModifiedDate);
	String eventoHeartBeat = "EVENTO;66;" + icup.getUrlConexao()+";";
	String ano = Integer.toString(cal.get(Calendar.YEAR)) + ";";
	String mes = Integer.toString(cal.get(Calendar.MONTH)+ 1)+ ";";
	String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+ ";";
	String hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY))+ ";";
	String min = Integer.toString(cal.get(Calendar.MINUTE))+ ";";
	String sec = Integer.toString(cal.get(Calendar.SECOND))+ ";";
	String mili = Integer.toString(cal.get(Calendar.MILLISECOND)) + ";";
	
	eventoHeartBeat = eventoHeartBeat + dia + mes + ano + hora + min + sec + mili + "1;HEART BEAT;;;;;;";
	listaDeMensagens.add(eventoHeartBeat);
}
}
}

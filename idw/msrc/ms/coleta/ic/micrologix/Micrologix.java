package ms.coleta.ic.micrologix;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemComunicacaoException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import modbus.ModBusIO;
import ms.coleta.dto.ColetaParametroDTO;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.ic.micrologix.defines.MicrologixDefines;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class Micrologix implements IIC {
	private IcDTO icdto;
	
	private int versaoIC = -1;
	private final static String[] dsEstado = { "IDEAL", "ACEIT�VEL", "CR�TICO", "SEM CONEX�O" };
	private final static int _NAODEFINIDO = -1;
	private final static int _EstadoOK = 0;
	private final static int _Aceitavel = 1;
	private final static int _Critico = 2;
	private final static int _SemConexao = 3;
	private final static int _NrPontosColeta = 4;
	private ModBusIO modbusio = null;
	private Date lastUpdate = null;
	private Date lastHeartBeat = null;
	
	private Date dthrObtencaoEvento = null;

	private DadosLocais[] dadosLocais = new DadosLocais[_NrPontosColeta + 1];
	private String ipColetor = null;
	private Integer portaColetor = null;
	private String ipSeparador = ":";

	private IdwLogger log = null;
	private Integer idLog = null;
	private boolean isConectado = false;

	private EventosColetados eventos = new EventosColetados();

	public Micrologix(IcDTO icdto) {
		super();
		
		this.icdto = icdto;

		String urlConexao = icdto.getUrl_conexao();

		if (urlConexao.indexOf(ipSeparador) != -1) {
			ipColetor = urlConexao.split(ipSeparador)[0];
			portaColetor = Integer.parseInt(urlConexao.split(ipSeparador)[1]);
		} else {
			ipColetor = urlConexao;
			portaColetor = 502;
		}
	}

	/* Metodo principal para obtencao dos eventos
	 * (non-Javadoc)
	 * @see ms.coleta.ic.IIC#getEventos(idw.model.pojos.OmCfg)
	 */
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		// Ailton 2019-02-11: Nao ha criticidade suficiente para esse servico
		// rodar com essa periodicidade
		// UtilsThreads.pausaNaThread(500); // Pausa de 1 segundo na Thread
		
		// Alessandre em 04-02-20 comentei o pauseThread pois nao faz muito sentido ele nesse metodo e é ate prejudicial pois o metodo eh chamado pela ICThread, causando
		// um acumulo grando de conexoes no banco. Essa pode ser uma das possiveis causas
		// em substituicao a atualizacao sera feita de 60 em 60 segundos
		//UtilsThreads.pausaNaThread(60 * 1000); // Pausa de 1 segundo na Thread
		Date dthrNow = new Date();
		if (dthrObtencaoEvento == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(dthrObtencaoEvento, dthrNow) > 60) {
			atualizaDadosDeFolhaMedTemp(); // Somente atualiza os dados se j� se
											// passaram mais de 10 segundos da
											// �ltima atualiza��o
			leDados();
			dthrObtencaoEvento = dthrNow;
		}
		verificaHeartBeat();
		
		EventosColetados retorno = eventos;
		
		eventos = new EventosColetados();
		
		return retorno;
	}


	/*
	 * Atualiza os dados de RN Para coleta de parametros Atualiza na primeira
	 * execu��o e a cada ~60 segundos ap�s isso
	 */
	private void atualizaDadosDeFolhaMedTemp() {
		int segIntervaloLeitura = 60; // esse valor deve vim da folha de medicao pois eh variavel
		
		// Se a ultima atualizacao foi feita a menos de 60 segundos, entao nao devemos atualizar novamente
		Date dthrNow = new Date();
		if (lastUpdate == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastUpdate, dthrNow) > segIntervaloLeitura) {
			if (icdto.getMsIcUpDTOLocais() == null) {
				log.info(idLog, 0, "Erro msICUpDTO Nulo");
				return;
			}
			for (Iterator<IcUpDTO> iICupdto = icdto.getMsIcUpDTOLocais().iterator(); iICupdto.hasNext(); ) {
				
				IcUpDTO lcupdto = iICupdto.next();
				
				if (lcupdto == null) {
					log.info(idLog, 0, "Erro lcupdto Nulo para " + ipColetor + ":" + portaColetor);
					continue;
				}
				if (lcupdto.getUpDTO() == null) {
					log.info(idLog, 0, "Erro UpDTo Nulo para " + ipColetor + ":" + portaColetor);
					continue;
				}
				String cdpt = lcupdto.getUpDTO().getCd_up();
				int indiceUP = 0;
				List<ColetaParametroDTO> parametrosColetadosDTO = new ArrayList<ColetaParametroDTO>();
				try {
					indiceUP = Integer.parseInt(lcupdto.getUrlConexao());
				} catch (Exception e) {
					log.info(idLog, 0, "Erro ao obter indice de urlConexao:" + lcupdto.getUrlConexao());
					log.info(idLog, 0, "Os dados nao serao setados ate que o erro seja corrigido " + ipColetor + ":" + portaColetor);
					continue;
				}
				try {
					parametrosColetadosDTO = IdwFacade.getInstancia().getDadosMedTempPorIdPt(cdpt);
					log.info(idLog, 0, "Para o posto " + cdpt + " com indiceUp=" + indiceUP + " - tamanho de parametrosColetadosDTO e: " + parametrosColetadosDTO.size());
					
					
					for (ColetaParametroDTO colParDTO : parametrosColetadosDTO) {
						if (colParDTO != null && colParDTO.getTpparametro().equals(DwFtParamTemplate.Type.TEMPERATURA)) {
							log.info(idLog, 0, "limiteCriticoInf= " + colParDTO.getLimInfTempCritico().doubleValue() + " - limiteCriticoSup= " + colParDTO.getLimSupTempCritico().doubleValue() );
							if (dadosLocais[indiceUP] == null)
								dadosLocais[indiceUP] = new DadosLocais();
							
							try {
								dadosLocais[indiceUP].limiteAceitavelInf = colParDTO.getLimInfTemp().doubleValue();
							} catch (NullPointerException e) {
								
							}
							dadosLocais[indiceUP].limiteCriticoInf = colParDTO.getLimInfTempCritico().doubleValue();
							dadosLocais[indiceUP].limiteAceitavelSup = colParDTO.getLimSupTemp().doubleValue();
							dadosLocais[indiceUP].limiteCriticoSup = colParDTO.getLimSupTempCritico().doubleValue();
							dadosLocais[indiceUP].tempoEntreAmostragens = colParDTO.getSegIntervaloLeitura().intValue() * 1000;
							dadosLocais[indiceUP].cdFolha = colParDTO.getCdFolha();
							dadosLocais[indiceUP].deveTratar = true;
							
						}
						if (colParDTO == null) {
							dadosLocais[indiceUP] = new DadosLocais();
						}
					}
					
					
				} catch (RegistroDesconhecidoException e) {
					log.info(idLog, 0, "Nao foi possivel encontrar Dados de coleta para o cdpt:" + cdpt);
				} catch (Exception exec) {
					log.info(idLog, 0, "Em atualizaDadosDeFolhaMedTemp/colParDTO para cdpt" + cdpt, exec);
				}

			}
			lastUpdate = dthrNow;
		}
	}

	/*
	 * Executa Heart-Beat Executa na primeira execu��o e a cada ~30 segundos
	 * ap�s isso
	 */
	private void verificaHeartBeat() {
		if (isConectado == false) { // N�o executa o heart-Beat por estar sem
									// conex�o
			log.info(idLog, 0, modbusio + ":HeartBeat n�o executado CLP sem conex�o!");
			return;
		}
		Date dthrNow = new Date();
		if (lastHeartBeat == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(lastHeartBeat, dthrNow) > 30) {
			EventoColetado ev = new EventoColetado();
			ev.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
			ev.setDthrEvento(dthrNow);
			ev.setLog(log);
			
			// Ailton 08-02-19
			// A principio, para essa coleta so existe uma UP para o IC
			if (icdto.getMsIcUpDTOLocais() != null && icdto.getMsIcUpDTOLocais().size() > 0) {
				ev.setIcUpDTO(icdto.getMsIcUpDTOLocais().get(0));
				eventos.addEventoColetado(ev);
				lastHeartBeat = dthrNow;
			}
		}
	}

	private void inicializaEvento(int i, int tpEvento, Date dthrevento) {
		
		for (IcUpDTO icupdto : icdto.getMsIcUpDTOLocais()) {
			try {
				
				if (Integer.valueOf(icupdto.getUrlConexao()).intValue() == i) {
					EventoColetado ev = new EventoColetado();
					ev.setTipoEvento(tpEvento);
					if (tpEvento != ServicoFactory._ALERTA_PERDA_CONEXAO) {
						ev.setParametroLido(new BigDecimal(dadosLocais[i].ultimaAmostragem).setScale(2, java.math.RoundingMode.HALF_UP));
					}
					if (tpEvento == ServicoFactory._ALERTA_TEMPERATURA) {
						ev.setForaFaixaInicial(String.valueOf(dadosLocais[i].limiteCriticoInf));
						ev.setForaFaixaFinal(String.valueOf(dadosLocais[i].limiteCriticoSup));
					}
					ev.setDthrEvento(dthrevento);
					ev.setIcUpDTO(icupdto);
					ev.setCdop(dadosLocais[i].cdFolha);
					ev.setLog(log);
					ev.setZona(new Integer(-1).byteValue());
					eventos.addEventoColetado(ev);
				}
			} catch (Exception e) {
				log.info(idLog, 0, " Erro ao vincular evento de:" + ipColetor + ":" + portaColetor + " urlConexao:"
						+ icupdto.getUrlConexao() + " com " + i);
			}
		}

	}

	private void validaMundancaEstado(int i, Date dthrLeitura) {
		log.info(idLog, 0, "validaMudancaEstado");
		// Valida Mudanca Estado(i)
		if (dadosLocais[i].estadoAferido != dadosLocais[i].ultimoestadoConsolidado) {
			if (dadosLocais[i].lastEstadoAferido != dadosLocais[i].estadoAferido)
				dadosLocais[i].countRetries = 0;

			dadosLocais[i].countRetries++;

			if (dadosLocais[i].countRetries >= dadosLocais[i].nrRetries) {
				log.info(idLog, 0, modbusio + ": mudanca de Estado para " + dsEstado[dadosLocais[i].estadoAferido] + " ap�s " + dadosLocais[i].nrRetries + " leituras");
				dadosLocais[i].ultimoestadoConsolidado = dadosLocais[i].estadoAferido;
				dadosLocais[i].countRetries = 0;
				if (dadosLocais[i].estadoAferido != _EstadoOK) {
					// Lan�a evento de Alerta Para estado N�o conforme
					if (dadosLocais[i].estadoAferido == _SemConexao) {
						inicializaEvento(i, ServicoFactory._ALERTA_PERDA_CONEXAO, dthrLeitura);
						inicializaEvento(i, ServicoFactory._MAQUINA_OFFLINE, dthrLeitura);
						// Lan�a alerta de Sem Conex�o
					} else {
						if (dadosLocais[i].estadoAferido == _Critico)
							inicializaEvento(i, ServicoFactory._ALERTA_TEMPERATURA, dthrLeitura);
						
						inicializaEvento(i, ServicoFactory._MEDICAO_TEMPERATURA, dthrLeitura);
						// Lan�a alerta de Zona Cr�tica de Monitoramento
					}
				}
			}
		}
		dadosLocais[i].lastEstadoAferido = dadosLocais[i].estadoAferido;
	}

	private void leDados() {

		eventos = new EventosColetados();
		Date dthrLeitura = new Date();
		try {
			List<Integer> listaResult = modbusio.leVetorHoldingRegister(MicrologixDefines.WORD_VERSAO, _NrPontosColeta + 1);
			isConectado = true;
			versaoIC = listaResult.get(0);
			
			for (int i = 1; i <= _NrPontosColeta; i++) {
				
				if (dadosLocais[i] == null || dadosLocais[i].deveTratar == false)
					continue;
				
				
				if (dadosLocais[i].estadoAferido == _NAODEFINIDO) {
					inicializaEvento(i, ServicoFactory._MAQUINA_ONLINE, dthrLeitura);
				}
				dadosLocais[i].ultimaAmostragem = ((double) listaResult.get(i)) / 10;
				if ((dadosLocais[i].ultimaAmostragem >= dadosLocais[i].limiteAceitavelInf) && (dadosLocais[i].ultimaAmostragem <= dadosLocais[i].limiteAceitavelSup)) {
					// Tuuudo bem Verde
					dadosLocais[i].estadoAferido = _EstadoOK;
				} else if ((dadosLocais[i].ultimaAmostragem >= dadosLocais[i].limiteCriticoInf) && (dadosLocais[i].ultimaAmostragem <= dadosLocais[i].limiteCriticoSup)) {
					// Zona Aceit�vel Amarela
					dadosLocais[i].estadoAferido = _Aceitavel;
				} else {
					log.info(idLog, 0, dadosLocais[i].ultimaAmostragem + " Vou enviar email para i=" + i + ". Entrou na zona critica <= " + dadosLocais[i].limiteCriticoInf + " ou >= " + dadosLocais[i].limiteCriticoSup);
					// Zona Cr�tica Vermelha
					dadosLocais[i].estadoAferido = _Critico;
				}
				// ValidaMudan�ca de estado para i
				validaMundancaEstado(i, dthrLeitura);
				if (DataHoraRN.getQuantidadeMilisegundosNoPeriodo(dadosLocais[i].dthrUltimaAmostragem, dthrLeitura) > dadosLocais[i].tempoEntreAmostragens) {
 					if (dadosLocais[i].ultimoestadoConsolidado == _SemConexao) {
						inicializaEvento(i, ServicoFactory._MAQUINA_ONLINE, dthrLeitura);
					}
					dadosLocais[i].dthrUltimaAmostragem = dthrLeitura;
					inicializaEvento(i, ServicoFactory._MEDICAO_TEMPERATURA, dthrLeitura);
				}
			}
		} catch (SemComunicacaoException e) {
			isConectado = false;
			log.info(idLog, 0, " Erro ao Varrer:" + ipColetor + ":" + portaColetor);
			
			for (int i = 1; i <= 4; i++) {
				if (dadosLocais[i] == null || dadosLocais[i].deveTratar == false)
					continue;
				dadosLocais[i].estadoAferido = _SemConexao;
				validaMundancaEstado(i, dthrLeitura);
			}
		}

	}

	@Override
	public void inicializaIC(IdwLogger logPar) throws SemComunicacaoICException {
		this.log = logPar;
		this.idLog = this.log.getIdAleatorio();
		log.info(idLog, 0, " InicializaIC:" + ipColetor + ":" + portaColetor);
		modbusio = new ModBusIO(ipColetor, portaColetor, log);
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		log = icdto.getLog();
		idLog = log.getIdAleatorio();
		modbusio = null;
		log.info(idLog, 0, " finalizaIC:" + ipColetor + ":" + portaColetor);

	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return String.valueOf(MicrologixVersaoDriver._VERSAODRIVER);
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		if (versaoIC == -1) {
			return "S";
		}
		return String.valueOf(versaoIC);
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {

	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {

	}

	@Override
	public void setParametro(ParametroDTO parametro) {

	}

}

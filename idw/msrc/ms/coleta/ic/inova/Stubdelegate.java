package ms.coleta.ic.inova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import idw.model.IdwFacade;
import idw.util.IdwLogger;
import idw.webservices.MswsComEvt;
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsInspecaoManualDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsReleDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import ms.coleta.ic.inova.dto.INovaEventoPendenteDTO;
import ms.coleta.ic.inova.dto.INovaReleDTO;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.coleta.ic.inova.dto.RetValidaEstLoteDTO;
import ms.excessao.SemComunicacaoICException;

public class Stubdelegate {
	
	private static Stubdelegate instancia = null;
	private boolean isSemComunicacaoWS = false;	
	private INovaEventoPendenteDTO eventoPendengo = null;
	private boolean isInjetAtivo = false; // esse flag sera setado para true no listener de importacao do Injet
	private MswsComEvt ms = new MswsComEvt();
	
	public static Stubdelegate getInstancia() {
		if(instancia == null)
			instancia = new Stubdelegate();
		return(instancia);
	}
	
	public boolean isSemComunicacaoWS() {
		return isSemComunicacaoWS;
	}
	public void setSemComunicacaoWS(boolean isSemComunicacaoWS) {
		this.isSemComunicacaoWS = isSemComunicacaoWS;
	}

	public INovaEventoPendenteDTO getEventoPendengo() {
		return eventoPendengo;
	}
	public void setEventoPendengo(INovaEventoPendenteDTO eventoPendengo) {
		this.eventoPendengo = eventoPendengo;
	}
	
	public INovaUpDTO InicializaUp(INovaUpDTO up) throws SemComunicacaoICException {
		// Carregar a lista de operadores logados na UP
//		IwsListModDTO operadoresLogados = null;
		
//		try {
////			operadoresLogados = getMsWs().getTr_operadoresLogados(up.getIdUP());
//			operadoresLogados = IwsFacade.getInstancia().getTr_operadoresLogados(up.getIdUP());
//		} catch (Exception e) {
//			throw new SemComunicacaoICException(e);
//		}
//		
//		if(operadoresLogados.isExisteModDTO()) {
//			if(operadoresLogados.getListModDTO() != null) {
//				for(IwsModDTO modWSDTO : operadoresLogados.getListModDTO()) {
//					IwsModDTO moddto = new IwsModDTO();
////					moddto.copyModDTOWs(modWSDTO);
//					moddto = modWSDTO;
//					up.addModDTO(moddto);
//				}
//			}
//		}
		
		if(up.getListaLoginsEmAberto() != null && up.getListaLoginsEmAberto().size() > 0)
			up.setTemOperadorLogado(true);
		
		//Carregar a lista de Alertas em aberto
		try {
//			IwsAlertaDTO[] AlertasAbertos = getMsWs().getTr_alertasAbertos(up.cdMaquina);
//			IwsListaAlertaDTO AlertasAbertos = IwsFacade.getInstancia().GetTr_pesquisaAlertasEmAberto(up.getCdMaquina());
//			
//			for(IwsAlertaDTO alertaDTO : AlertasAbertos.getAlertas()) {
//				IwsAlertaDTO alertadto = new IwsAlertaDTO();
////				alertadto.copyAlertaDTOWs(alertaDTO);
//				alertadto = alertaDTO;
//				up.addAlertaDTO(alertadto);
//			}
			IwsRefugoDTO refugoDados = new IwsRefugoDTO();
//			refugoDados = getMsWs().getInfoUltimoRefugo(up.idUP);
			refugoDados = ms.getInfoUltimoRefugo(up.getIdUP());
			up.getUltimoRefugoAtual().setMilissegundos(refugoDados.getMilissegundos());
			up.getUltimoRefugoAtual().setIdReduzidaProd(refugoDados.getIdReduzidaProd());
			up.getUltimoRefugoAtual().setCdRefugo(refugoDados.getCdRefugo());
			up.getUltimoRefugoAtual().setDthrUltRefugo(refugoDados.getDthrUltRefugo());
		} catch(Exception e) {
			e.printStackTrace();
			/// TODO: verificar se � necess�rio gerar logs aqui
		}
		
		try {
			if(up.getIsParadaEmAberto() && up.getUltimaParadaAtual() != null && up.getUltimaParadaAtual().getCdParada().equals("999999"))
				up.setPedirParada(true);
		} catch (Exception e) {
			e.printStackTrace();
			///verificar se � necess�rio gerar logs aqui
		}
		return up;
	}
	
	public boolean validaPlanejamento(INovaUpDTO up, IwsCpDTO cpEntrada, Calendar dtHrEvento) {
		IwsCpDTO cp = null;
		
		try {
//			cp = getMsWs().getTr_planejamento(up.idUP, cpEntrada, dtHrEvento);
			cp = IdwFacade.getInstancia().getTr_planejamento(up.getIdUP(), cpEntrada, dtHrEvento.getTime());
			if(cp.getIsProducaoValida() == true) {
				up.setCpTemp(cp); //inicializa coletor sincronizando prup
				return true;
			}
			
			if(cp.getTxtMensagem() != null)
				up.setTxtMsg(cp.getTxtMensagem());
			else
				up.setTxtMsg(" Nao realizado.     Sem Mensagem");
			
			return false;
		} catch(Exception e) {
			up.setTxtMsg("Falha na comunicacao com o WebService");
			return false;
		}
	}
	
	public void geraLogIntegracaoDoal(String idup, Calendar DtHrEvento, String msg, boolean fimValid) {
		IwsFacade.getInstancia().setTr_registroIntegracaoDoal(idup, DtHrEvento.getTime(), msg, fimValid);
	}
	
	public List<IwsProdMateriaPrimaDTO> buscaListaMateriaPrima(String idUp, INovaUpDTO up, Calendar dthr) {
		List<IwsProdMateriaPrimaDTO> prodMatPrimas = new ArrayList<IwsProdMateriaPrimaDTO>();
		
		IwsListaMatPrimaDTO listaMaterial = new IwsListaMatPrimaDTO();
		
		try {
//			listaMaterial = getMsWs().getTr_dadosIntegracaoDoal(idUp);
			listaMaterial = IwsFacade.getInstancia().getTr_dadosIntegracaoDoal(idUp);
		} catch (Exception e) {
			prodMatPrimas = null;
		}
		
		if(listaMaterial.isErro() == false) {
			for(IwsProdMateriaPrimaDTO prod : listaMaterial.getMateriasPrimas()) {
				IwsProdMateriaPrimaDTO materiaprima = new IwsProdMateriaPrimaDTO();
//				materiaprima.copyPrUpProdMatPrimaWS(prod);
				materiaprima = prod;
				prodMatPrimas.add(materiaprima);
			}
		}
		else {
			prodMatPrimas = null;
			confirmacaoOp(idUp, dthr, null, up);
		}
		
		return prodMatPrimas;
	}
	
	public boolean confirmacaoOp(String idUp, Calendar dtHr, String stApntSap, INovaUpDTO updto) {
		IwsCpDTO lcCpDto = new IwsCpDTO();
		
		try {
//			lcCpDto = getMsWs().setTr_confirmacaoOp(idUp, dtHr, stApntSap, updto.cpTmp);
			lcCpDto = IwsFacade.getInstancia().setTr_confirmacaoOp(idUp, dtHr.getTime(), stApntSap, updto.getCpTemp());
		} catch (Exception e) {
			return false;
		}
		
		if(lcCpDto != null) {
			updto.getCpTemp().setProdutos(lcCpDto.getProdutos());
			updto.getCpTemp().setNropestendido(lcCpDto.getNropestendido());
			updto.getCpTemp().setCdmoldeestendido(lcCpDto.getCdmoldeestendido());
			updto.getCpTemp().setNrop(lcCpDto.getNrop());
			
			return true;
		}
		else {
			updto.getCpTemp().setProdutos(null);
			return false;
		}
	}
	
	public boolean setTr_EvntFimPlanejamento(String Idup, Calendar DthrEvnt, IdwLogger log, int idLog) {
//		try {
//			getMsWs().setTr_fimplanejamento(Idup, DthrEvnt);
			IwsFacade.getInstancia().fimPlanejamento(Idup, DthrEvnt.getTime());
//			Stubdelegate.getInstancia().atualizaOperadoresLogados(Idup, log, idLog);
			return true;
//		} catch (RegistroDesconhecidoException e) {
//			return false;
//			//throw new RegistroDesconhecidoException();
//		} catch (SemComunicacaoICException e) {
//			return false;
//			//throw new SemComunicacaoException();
//		}
	}
	
//	public void atualizaOperadoresLogados(INovaUpDTO up, IdwLogger log, int idLog) throws SemComunicacaoICException {
//		IwsListModDTO operadoresLogados = null;
//		
//		try {
////			operadoresLogados = getMsWs().getTr_operadoresLogados(up.getIdUP());
//			operadoresLogados = IwsFacade.getInstancia().getTr_operadoresLogados(up.getIdUP());
//		} catch (Exception e) {
//			log.info(idLog, 0, "Erro-atualizaOperadoresLogados");
//			log.info(idLog, 0, e.getMessage());
//			log.info(idLog, 0, e.getStackTrace());
//			log.info(idLog, 0, "idUp: " + up.getIdUP());
//			log.info(idLog, 0, "---------------------");
//			throw new SemComunicacaoICException(e);
//		}
//		
//		List<IwsModDTO> lstModDTO = new ArrayList<IwsModDTO>();
//		
//		if (operadoresLogados.isExisteModDTO()) {
//			if(operadoresLogados.getListModDTO() != null) {
//				List<IwsModDTO> listModWSDTO = operadoresLogados.getListModDTO();
//				
//				for(IwsModDTO modWSDTO : listModWSDTO) {
//					IwsModDTO moddto = new IwsModDTO();
////					moddto.copyModDTOWs(modWSDTO);
//					moddto = modWSDTO;
//					lstModDTO.add(moddto);
//				}
//			}
//		}
//		
//		up.setListaOperadoresLogados(lstModDTO);
//		
//		if(up.getListaOperadoresLogados() != null && up.getListaOperadoresLogados().size() > 0)
//			up.setTemOperadorLogado(true);
//		
//	}
	
//	public void atualizaOperadoresLogados(String idUp, IdwLogger log, int idLog) throws SemComunicacaoICException {
//		IwsListModDTO operadoresLogados = null;
//		
//		try {
////			operadoresLogados = getMsWs().getTr_operadoresLogados(idUp);
//			operadoresLogados = IwsFacade.getInstancia().getTr_operadoresLogados(idUp);
//		} catch (Exception e) {
//			log.info(idLog, 0, "Erro-atualizaOperadoresLogados");
//			log.info(idLog, 0, e.getMessage());
//			log.info(idLog, 0, e.getStackTrace());
//			log.info(idLog, 0, "idUp: " + idUp);
//			log.info(idLog, 0, "---------------------");
//			throw new SemComunicacaoICException(e);
//		}
//		
//		List<IwsModDTO> lstModDTO = new ArrayList<IwsModDTO>();
//		
//		if(operadoresLogados.isExisteModDTO()) {
//			if(operadoresLogados.getListModDTO() != null) {
//				List<IwsModDTO> listModWSDTO = operadoresLogados.getListModDTO();
//				
//				for(IwsModDTO modWSDTO : listModWSDTO) {
//					IwsModDTO moddto = new IwsModDTO();
////					moddto.copyModDTOWs(modWSDTO);
//					moddto = modWSDTO;
//					lstModDTO.add(moddto);
//				}
//			}
//		}
//	
//	}
	
	public IwsCicloDTO setTr_EvntIniCic(String idup, Calendar dthrevnt, String oInfo) throws SemSGBDException {
		IwsCicloDTO dadosCiclo = new IwsCicloDTO();
		
		try {
//			dadosCiclo.copyCicloDtoWs(getMsWs().setTr_CicloInicio(idup, dthrevnt,oInfo));
			dadosCiclo = IwsFacade.getInstancia().setTr_CicloInicio(idup, dthrevnt.getTime(), oInfo);
		} catch (Exception e) {
//			PerdaConexaoException e = new PerdaConexaoException();
//			INovaEventoPendenteDTO evento = new INovaEventoPendenteDTO();
//			evento.setEvento(TrataEventoFactory.EVENTO_INICIO_CICLO);
//			evento.setDthrevento(dthrevnt);
//			evento.setIdup(idup);
//			evento.Oinfo = oInfo;
//			
//			e.EventoPendente = evento;
//			throw e;
			
			eventoPendengo = new INovaEventoPendenteDTO();
			eventoPendengo.setEvento(INovaEventoPendenteDTO._EVENTOPENDENTE_INICIO_CICLO);
			eventoPendengo.setDthrevento(dthrevnt);
			eventoPendengo.setIdup(idup);
			eventoPendengo.setOinfo(oInfo);
			
			throw new SemSGBDException();
		}
		
		return dadosCiclo;
	}
	
	public IwsCicloDTO setTr_LancaParada(String idup, Calendar dthrevnt, boolean isParadaAuto, boolean ispersistente, IdwLogger log, int idLog) throws SemSGBDException {
		boolean isParPeriodSemConex = false;
		//isParPeriodSemConex � sempre falso por que s� quem determina o lan�amento de parada sem conex�o � o webservice
		//a vari�vel foi declarada apenas para mostra o uso do �ltimo par�metro de setTr_paradaInicio
		IwsCicloDTO retorno = new IwsCicloDTO();
		IwsCicloDTO dadosCic = new IwsCicloDTO();
		try {
//			retorno = getMsWs().setTr_paradaInicio(idup, dthrevnt, qtdbatidas, isParadaAuto, ispersistente, isParPeriodSemConex);
			//retorno = IwsFacade.getInstancia().setTr_paradaInicio(idup, dthrevnt.getTime(), isParadaAuto, ispersistente, isParPeriodSemConex);
			//luiz testando o IdwFacade no lugar do IwsFacade
			retorno = IdwFacade.getInstancia().setTr_paradaInicio(idup, dthrevnt.getTime(), isParadaAuto, ispersistente, isParPeriodSemConex);

		} catch (Exception e) {
			log.info(idLog, 0, "ERRO GRAVE: " + e.getMessage());
			log.info(idLog, 1, e.getStackTrace());
			log.info(idLog, 1, e.getCause());
			log.info(idLog, 1, "---------------------");
			
//			PerdaConexaoException e = new PerdaConexaoException();
//			IwsEventoPendenteDTO evento = new IwsEventoPendenteDTO();
//			evento.Evento = IwsEventoPendenteDTO.EVENTO_INICIO_PARADA;
//			evento.Dthrevento = dthrevnt;
//			evento.Idup = idup;
//			evento.Qtbatidas = qtdbatidas;
//			evento.Isparadaauto = isParadaAuto;
//			evento.Isparadpersist = ispersistente;
//			e.EventoPendente = evento;
			
			eventoPendengo = new INovaEventoPendenteDTO();
			eventoPendengo.setEvento(INovaEventoPendenteDTO._EVENTOPENDENTE_INICIO_PARADA);
			eventoPendengo.setDthrevento(dthrevnt);
			eventoPendengo.setIdup(idup);
			eventoPendengo.setParadaauto(isParadaAuto);
			eventoPendengo.setParadpersist(ispersistente);
			
			throw new SemSGBDException();
		}
		
		dadosCic = retorno;
		
		return dadosCic;
	}
	
	public void setTr_FinalizaParada(String idup, Calendar dthrevnt) throws SemSGBDException {
		try {
//			getMsWs().setTr_paradaFim(idup, dthrevnt);
			IwsFacade.getInstancia().setTr_paradaFim(idup, dthrevnt.getTime());
		} catch(Exception e) {
//			PerdaConexaoException e = new PerdaConexaoException();
//			IwsEventoPendenteDTO evento = new IwsEventoPendenteDTO();
//			evento.Evento = IwsEventoPendenteDTO.EVENTO_FIM_PARADA;
//			evento.Dthrevento = dthrevnt;
//			evento.Idup = idup;
//			e.EventoPendente = evento;
			
			eventoPendengo = new INovaEventoPendenteDTO();
			eventoPendengo.setEvento(INovaEventoPendenteDTO._EVENTOPENDENTE_FIM_PARADA);
			eventoPendengo.setDthrevento(dthrevnt);
			eventoPendengo.setIdup(idup);
			
			throw new SemSGBDException();
		}
	}
	
	public INovaReleDTO setTr_EvntFimCic(String idup, Calendar dthrEvnt, String oInfo, IdwLogger log, int idLog) throws SemSGBDException {
		IwsReleDTO oRele8DTOWs = new IwsReleDTO();
		INovaReleDTO oRele8DTO = new INovaReleDTO();
		
		try {
//			oRele8DTOWs = getMsWs().setTr_CicloFim(idup, dthrEvnt, oInfo);			
			oRele8DTOWs = IwsFacade.getInstancia().setTr_CicloFim(idup, dthrEvnt.getTime(), null);
			
			if(oRele8DTOWs.geterro() == false) { // se nao tiver erro
				oRele8DTO.copyReleDTOWs(oRele8DTOWs);
			}
			else // se nao deu erro
				oRele8DTO = null;
		} catch (Exception e) {
			oRele8DTO = null;
			
			log.info(idLog, 0, "logZona4");
			log.info(idLog, 1, e.getMessage());
			log.info(idLog, 1, e.getStackTrace());
			log.info(idLog, 1, "---------------------");
		}
		
		if(oRele8DTO == null) {
			INovaEventoPendenteDTO eventoPendengo = new INovaEventoPendenteDTO();
			
			log.info(idLog, 0, "logErroInserirCiclo");
			log.info(idLog, 1, "Ciclo n�o pode ser inserido"+idup);
//			List<String> dadosLog = new List<String>();
//			dadosLog.Add("Ciclo n�o pode ser inserido"+idup);
			if(idup == null || idup.equals("")) {
				log.info(idLog, 1, "IDUP NULO");
//				dadosLog.Add("IDUP NULO");
			}
			else {
				eventoPendengo.setEvento(INovaEventoPendenteDTO._EVENTOPENDENTE_FIM_CICLO);
				eventoPendengo.setDthrevento(dthrEvnt);
				eventoPendengo.setIdup(idup);
			}
			log.info(idLog, 1, "---------------------");
//			dadosLog.Add("---------------------");
//			geraLog("logErroInserirCiclo", dadosLog);
//			PerdaConexaoException e = new PerdaConexaoException();
//			e.EventoPendente = evento;
//			throw e;
			
			throw new SemSGBDException();
		}
		
		return(oRele8DTO);
	}
	
	public String setZeroEsquerda(String sCod) {
		if(sCod.length() < 6)
			return (setZeroEsquerda("0" + sCod));
		
		return(sCod);
	}
	
	public IwsParadaDTO validaParada(INovaUpDTO up, String cdMotivo) throws SemComunicacaoICException, RegistroDesconhecidoException {
		IwsParadaDTO parada = null;
		
		try {
//			parada = getMsWs().getTr_TabParadaSetaCod(up.idUP, cdMotivo);
			parada = IwsFacade.getInstancia().getTr_TabParadaSetaCod(up.getIdUP(), cdMotivo);
		} catch(Exception e) {
			throw new SemComunicacaoICException(e);
		}
		
		if((parada == null) || (parada.getCdParada().equals("")))
			throw new RegistroDesconhecidoException();
		
		return parada;
	}
	
	public boolean setTr_MotivoParadaPreConfig(String Idup, Calendar DthrEvnt, String Codigo, String IdAcao, String IdCausa, String IdJustificativa, String IdTecnicoResponsavel, String IdTecnicoUm, String IdTecnicoDois, String idLocal, boolean isParadaRegulagem, String tipoParPreConfig) {
		try {
//			return getMsWs().setTr_paradaMotivoParPreConfig(Idup, DthrEvnt, Codigo, IdAcao, IdCausa, IdJustificativa, 
//					IdTecnicoResponsavel, IdTecnicoUm, IdTecnicoDois,idLocal, isParadaRegulagem, tipoParPreConfig);
			return(IwsFacade.getInstancia().setTr_paradaMotivo(Idup, DthrEvnt.getTime(), Codigo, IdAcao, IdCausa, IdJustificativa,
					IdTecnicoResponsavel, IdTecnicoUm, IdTecnicoDois, idLocal, isParadaRegulagem, tipoParPreConfig));
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean setTr_MotivoParada(String Idup, Calendar DthrEvnt, String Codigo, String IdAcao, String IdCausa, String IdJustificativa, String IdTecnicoResponsavel, String IdTecnicoUm, String IdTecnicoDois, String idLocal, boolean isParadaRegulagem, IdwLogger log, int idLog) {
		try {
//			return getMsWs().setTr_paradaMotivo(Idup, DthrEvnt, Codigo, IdAcao, IdCausa, IdJustificativa, 
//				IdTecnicoResponsavel, IdTecnicoUm, IdTecnicoDois,idLocal, isParadaRegulagem);
			return(IwsFacade.getInstancia().setTr_paradaMotivo(Idup, DthrEvnt.getTime(), Codigo, IdAcao, IdCausa, IdJustificativa,
					IdTecnicoResponsavel, IdTecnicoUm, IdTecnicoDois, idLocal, isParadaRegulagem, null));
		} catch (Exception e) {
			GeraLogRecusaParada("TimeOut de Conexao com WebService", Idup, Calendar.getInstance(), Codigo, log, idLog);
			// throw new SemComunicacaoException();
			return false;
		}
	}
	
	public void GeraLogRecusaParada(String motivo, String Idup, Calendar Dthrparada, String cdParada, IdwLogger log, int idLog) {
		log.info(idLog, 0, "RecusaMotivoDeParada");
		log.info(idLog, 1, "idup:"+Idup +" cdparada:"+cdParada +"-" + motivo + "-DtHrParada" + Dthrparada.get(Calendar.DAY_OF_MONTH) + "/" +
				Dthrparada.get(Calendar.MONTH) + "/" +
				Dthrparada.get(Calendar.YEAR) + " " +
				Dthrparada.get(Calendar.HOUR_OF_DAY) + ":" +
				Dthrparada.get(Calendar.MINUTE) + ":" +
				Dthrparada.get(Calendar.SECOND));
	}
	
	public IwsErroDTO validaCAJ(String Causa, String Acao, String Justificativa, String idUp, IwsParadaDTO paradaInformada) {
		boolean isCausa= true, isAcao = true, isJustificativa = true;
		String msg = "Valor errado: ";
		List<String> Lista = new ArrayList<String>(4);
		IwsErroDTO erro = new IwsErroDTO();
		String infoErro = "";
		
		Lista.add(msg);
		
		if(paradaInformada.getIsPedeCausa()) {
			
			isCausa = IwsFacade.getInstancia().validaCausa(Causa);
			
			if(!isCausa) {
				Lista.add("Causa");
			}
		}
		
		if(paradaInformada.getIsPedeAcao()) {
			isAcao = IwsFacade.getInstancia().validaAcao(Acao);
			
			if(!isAcao) {
				Lista.add("Acao");
			}
		}
		
		if(paradaInformada.getIsPedeJust()) {
			isJustificativa = IwsFacade.getInstancia().validaJustificativa(Justificativa);
			
			if(!isJustificativa) {
				Lista.add("Justificativa");
			}
		}
		
		if(isCausa && isAcao && isJustificativa) {
			erro.setSucesso(true);
			erro.setMensagem("");
			
			return erro;
		}
		else {
			//Pra formatar a informa�ao de erro no Coletor 
			infoErro = "";
			if(Lista.size() >= 1) infoErro += Lista.get(0) + ";";
			else infoErro += " ;";
			
			if(Lista.size() >= 2) infoErro += Lista.get(1) + ";";
			else infoErro += " ;";
			
			if(Lista.size() >= 3) infoErro += Lista.get(2) + ";";
			else infoErro += " ;";
			
			if(Lista.size() >= 4) infoErro += Lista.get(3) + ";";
			else infoErro += " ;";
			
			erro.setSucesso(false);
			erro.setMensagem(infoErro);
			
			return erro;
		}
	}
	
	public IwsReleDTO setTr_getRele8(String idup) {
		IwsReleDTO oReleDTOWS;
		INovaReleDTO oReleDTO = new INovaReleDTO();
		
		try {
//			oReleDTOWS = getMsWs().setTr_getRele8(idup);
			oReleDTOWS = IwsFacade.getInstancia().setTr_getRele8(idup);
		} catch(Exception e) {
			oReleDTOWS = null;
			oReleDTO = null;
		}
		
		if (oReleDTOWS != null && oReleDTOWS.geterro() == false) {
			oReleDTO.copyReleDTOWs(oReleDTOWS);
		}
		else {
			oReleDTO = null;
		}
		
		return(oReleDTO);
	}
	
	public IwsRefugoDTO validaRefugo(INovaUpDTO up, String cdRefugo) throws SemComunicacaoICException, RegistroDesconhecidoException {
		IwsRefugoDTO refugodto = null;
		
		try {
			refugodto = IwsFacade.getInstancia().getTr_TabValidaCodRefugo(up.getUp(),cdRefugo);
		} catch(Exception e) {
			throw new SemComunicacaoICException(e);
		}
		
		if (refugodto.getCdRefugo().equals(""))
			throw new RegistroDesconhecidoException();
		
		return refugodto;
	}
	
	public boolean setTr_ApagaUltimoRefugo(String cdRefugo, String IdRdzProduto, Calendar DtHrUltRefugo, String milisec , INovaUpDTO up, Calendar DtHrevento ) throws SemComunicacaoICException {
		boolean retorno = false;
		try {
//			retorno= getMsWs().setTr_ApagaUltimoRefugo(cdRefugo, IdRdzProduto, DtHrUltRefugo, milisec, up.idUP,DtHrevento);
			retorno = IwsFacade.getInstancia().setTr_ApagaUltimoRefugo(cdRefugo, IdRdzProduto, DtHrUltRefugo.getTime(), milisec, up.getIdUP(), DtHrevento.getTime());
		} catch(Exception e) {
			throw new SemComunicacaoICException(e);
		}
		return retorno;
	}
	
	public IwsAlertaDTO validaAlerta(INovaUpDTO up, String cdAlerta, Calendar dthrAlerta) {
		IwsAlertaDTO alerta = null;
		
		try {
//			alerta = getMsWs().getTr_TabAlertaSetaCod(cdAlerta);
			alerta = IwsFacade.getInstancia().getTr_TabAlertaSetaCod(cdAlerta);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return alerta;
	}
	
	public void alertaInicio(String idUp, String cdAlerta, Calendar dthrAlerta) throws SemSGBDException {
//		try {
//			getMsWs().setTr_alertaInicio(idUp, cdAlerta, dthrAlerta);
			IwsFacade.getInstancia().setTr_AlertaInicio(idUp, cdAlerta, dthrAlerta.getTime());
//		} catch(Exception e) {
//			throw new SemComunicacaoException();
//		}
	}
	
	public boolean FechaAlerta(String idUp, String cdAlerta, Calendar dthrAlerta) throws SemSGBDException {
		boolean resposta = false;
		
//		try {
//			resposta = getMsWs().setTr_alertaFim(idUp, cdAlerta, dthrAlerta);
			resposta = IwsFacade.getInstancia().setTr_AlertaFim(idUp, cdAlerta, dthrAlerta.getTime());
//		} catch (Exception e) {
//			throw new SemComunicacaoException();
//		}
		return resposta;
	}
	
	public IwsAutenticacaoDTO validaLogin(INovaUpDTO up, String login, String senha, Calendar DtHrevento, int TpUsuario,Boolean validaPorDsUsuario) throws SemSGBDException, RegistroDesconhecidoException {
		IwsAutenticacaoDTO autenticacao = null;
		
//		try {
//			autenticacao = getMsWs().getTr_Autorizacao(up.idUP, login, senha, TpUsuario, DtHrevento);
			autenticacao = IwsFacade.getInstancia().getTr_Autorizacao(up.getIdUP(), login, senha, TpUsuario, DtHrevento.getTime(),validaPorDsUsuario);
//		} catch(Exception e) {
//			throw new SemComunicacaoException();
//		}
		
		if(!autenticacao.getIsAutorizado())
			throw new RegistroDesconhecidoException();
		
		return autenticacao;
	}
	
	public IwsErroDTO setTr_EvntLogin(String Idup, String Codigo, Calendar DthrEvnt) {
//		try {
//			return getMsWs().setTr_operadorInicio(Idup, Codigo, DthrEvnt);
			return(IwsFacade.getInstancia().efetuaLogin(Idup, Codigo, DthrEvnt.getTime()));
//		} catch(RegistroDesconhecidoException e) {
//			throw new RegistroDesconhecidoException();
//		} catch(SemComunicacaoException e) {
//			throw new SemComunicacaoException();
//		}
	}
	
	public void setTr_EvntLogout(String Idup, String Codigo, Calendar DthrEvnt, Calendar DthrLogin) {
//		try {
//			getMsWs().setTr_operadorFim(Idup, Codigo, DthrEvnt, DthrLogin);
			IwsFacade.getInstancia().efetuaLogout(Idup, Codigo, DthrEvnt.getTime(), DthrLogin.getTime());
//		} catch (RegistroDesconhecidoException e) {
//			throw new RegistroDesconhecidoException();
//		} catch (SemComunicacaoException e) {
//			throw new SemComunicacaoException();
//		}
	}
	
	public IwsConsultaDTO setTr_Consulta(String cdConsulta,String idup, Calendar DtHrevento) {
		IwsConsultaDTO rspConsulta = new IwsConsultaDTO();
		
		rspConsulta.setResposta(false);
		
		try {
//			rspConsulta = getMsWs().setTr_Consula(cdConsulta, idup, DtHrevento);
			rspConsulta = IwsFacade.getInstancia().setTr_Consulta(cdConsulta, idup, DtHrevento.getTime());
		} catch(Exception e) {
			//responde com erro
			rspConsulta.setResposta(false);
		}
		
		return rspConsulta;
	}
	
	public boolean setTr_FimCIP(String idup, Calendar DtHrevento,String Tecnico) {
		boolean retorno =false;
		try {
//			retorno = getMsWs().setTr_trataFimCIP(idup, DtHrevento);
			retorno = IwsFacade.getInstancia().setTr_trataFimCIP(idup, DtHrevento.getTime(),Tecnico);
			return retorno;
		} catch(Exception e) {
			return false;
		}
	}
	
	public IwsInspecaoManualDTO getTr_InspecaoManual(String cdMaquina, Calendar DtHrevento) {
		IwsInspecaoManualDTO rspInspecaoManual = new IwsInspecaoManualDTO();
		
		try {
//			rspInspecaoManual = getMsWs().getTr_InspecaoManual(cdMaquina, DtHrevento);
			rspInspecaoManual = IwsFacade.getInstancia().getTr_InspecaoManual(cdMaquina, DtHrevento.getTime());
		} catch(Exception e) {
			rspInspecaoManual.setErro(true);
		}
		
		IwsInspecaoManualDTO oInspecaoManualLocal = new IwsInspecaoManualDTO();
//		oInspecaoManualLocal.copyDTOWs(rspInspecaoManual);
		oInspecaoManualLocal = rspInspecaoManual;
		
		// Verifica se as informacoes estao corretas
		if(!oInspecaoManualLocal.getErro()) {
			// se inf01 = 1, inf02 e inf03 devem estar preenchidas
			if(oInspecaoManualLocal.getInf01() != null) {
				
				if(Integer.parseInt(oInspecaoManualLocal.getInf01()) == 1) { // verificando inf01
					
					if(oInspecaoManualLocal.getInf02().length() == 0) // verificando inf02
						oInspecaoManualLocal.setErro(true);
					// inf03 eh uma string de data no formato YYYY-MM-DD HH:MM:SS
					/*System.Text.RegularExpressions.Regex rexDtHr = new System.Text.RegularExpressions.Regex(@"\d(4)-\d(2)-\d(2) \d(2):\d(2):\d(2)");
					if (!(rexDtHr.Match(oInspecaoManualLocal.inf03).Success)) // verificando inf03
						oInspecaoManualLocal.erro = true;*/
				}
				else {
					oInspecaoManualLocal.setErro(true);
				}
			}
			else {
				oInspecaoManualLocal.setErro(true);
			}
		}
		else {
			if(oInspecaoManualLocal.getIscomalertaprobqualidade() == true) {
				oInspecaoManualLocal.setInf01("22");
			}
		}
		
		return (oInspecaoManualLocal);
	}
	
	public boolean setTr_InspecaoManual(String idup, Calendar DtHrevento, String cdprod, String dthrale, String result) {
		try {
//			getMsWs().setTr_InspecaoManual(idup, DtHrevento, cdprod, dthrale, result);
			IwsFacade.getInstancia().setTr_InspecaoManual(idup, DtHrevento.getTime(), cdprod, dthrale, result);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean setTr_ApontamentoAramado(String idup, Calendar DtHrevento, String cdprod, String quantidade) {
		boolean retorno = false;
		
		try {
//			retorno = getMsWs().setTr_ApontamentoAramado(idup, DtHrevento, cdprod, quantidade);
			retorno = IwsFacade.getInstancia().setTr_ApontamentoAramado(idup, DtHrevento.getTime(), cdprod, quantidade);
			return retorno;
		} catch(Exception e) {
			return retorno;
		}
	}
	
	public IwsInspecaoManualDTO getTr_DadosInspecao(String idUp) {
		IwsInspecaoManualDTO rspInspecaoManual = new IwsInspecaoManualDTO();
		
		try {
//			rspInspecaoManual = getMsWs().getTr_ParametrosInspecao(idUp);
			rspInspecaoManual = IwsFacade.getInstancia().getTr_ParametrosInspecao(idUp);
		} catch(Exception e) {
			rspInspecaoManual = null;
		}
		
		if(rspInspecaoManual.getErro() == true) {
			rspInspecaoManual.setInf02("2");
		}
		
		return rspInspecaoManual;
	}
	
	public IwsInspecaoManualDTO getTr_SolicitaInspecaoManual(String idUp) {
		IwsInspecaoManualDTO rspInspecaoManual = new IwsInspecaoManualDTO();
		
		try {
//			rspInspecaoManual = getMsWs().getTr_VerificaExecInspecao(idUp);
			rspInspecaoManual = IwsFacade.getInstancia().getTr_VerificaExecInspecao(idUp);
		} catch (Exception e) {
			e.printStackTrace();
			rspInspecaoManual.setErro(true);
		}
		
		if(rspInspecaoManual.getErro() == true) {
			if(rspInspecaoManual.getIscomalertaprobqualidade() == true) {
				rspInspecaoManual.setInf01("22"); //c�digo de erro para Alerta de Problema de Qualidade
				return rspInspecaoManual;
			}
			
			if(rspInspecaoManual.getIsinspemandamento() == true) {
				rspInspecaoManual.setInf01("23"); //c�digo de erro para Inspe��o em Andamento
				return rspInspecaoManual;
			}
			else
				rspInspecaoManual.setInf01("21");
		}
		
		return rspInspecaoManual;
	}
	
	public IwsInspecaoManualDTO setTr_Inspecao(String idUp, Calendar dtHr) {
		IwsInspecaoManualDTO rspInspecaoManual = new IwsInspecaoManualDTO();
		
		try {
//			rspInspecaoManual = getMsWs().setTr_LancaEventoInspecao(idUp,dtHr);
			rspInspecaoManual = IwsFacade.getInstancia().setTr_LancaEventoInspecao(idUp, dtHr.getTime());
		} catch(Exception e) {
			rspInspecaoManual.setErro(true);
		}
		
		if(rspInspecaoManual != null) {
			
			if(rspInspecaoManual.getErro() == true) {
				
				if(rspInspecaoManual.getInf01() != null && rspInspecaoManual.getInf02() != null) {
					
					if(rspInspecaoManual.getInf01().equals("1") && rspInspecaoManual.getInf02().equals("1")) {
						rspInspecaoManual.setInf01("21");
					}
					else if(rspInspecaoManual.getIsinspemandamento() == true) {
						rspInspecaoManual.setErro(false);
					}
				}
				else {
					//utilizado para ativar o envio de mensagens customizadas para o coletor
					rspInspecaoManual.setInf02("1");
				}
			}
		}
		else
			rspInspecaoManual = new IwsInspecaoManualDTO();
		
		return rspInspecaoManual;
	}
	
	public IwsErroDTO finalizaInspecao(String idUp, Calendar dtHr, IwsInspecaoManualDTO resultado) {
//		try {
//			return getMsWs().setTr_fimInspecao(idUp, dtHr, resultado.prupexecinspecao);
			return(IwsFacade.getInstancia().setTr_LancaEventoFimInspecao(idUp, dtHr.getTime(), resultado.getPrupexecinspecao()));
//		} catch(Exception e) {
//			throw new SemComunicacaoException();
//		}
	}
	
	public IwsErroDTO setTr_lancaAberturaInspecao(String idUp, Calendar dtHr) { //vlauria 20100322
		IwsErroDTO retorno = new IwsErroDTO();
		try {
//			retorno = getMsWs().setTr_LancaAberturaInspecao(idUp, dtHr);
			retorno = IwsFacade.getInstancia().setTr_LancaAberturaInspecao(idUp, dtHr.getTime());
		} catch(Exception e) {
			retorno.setSucesso(false);
			retorno.setMensagem("Erro na comunica��o com Servi�os Web.");
		}
		
		return retorno;
	}
	
	public IwsErroDTO encerraAlertaProbQuali(String idUp, Calendar dtHr, String cdusuario) { //vlauria 20100323
		IwsErroDTO resposta = new IwsErroDTO();
		
		try {
//			resposta = getMsWs().setTr_encerraAlertaProbQuali(idUp,dtHr,cdusuario);
			resposta = IwsFacade.getInstancia().encerraAlertaProbQuali(idUp, dtHr.getTime(), cdusuario);
		} catch(Exception e) {
			resposta.setSucesso(false); //alerta de problema de qualidade n�o foi finalizado
			resposta.setMensagem("Erro na comunica��o com Servi�os Web.");
		}
		
		return resposta;
	}
	
	public IwsErroDTO buscaAlertaQualiAberto(String cdMaquina) { // vlauria 20100323
		IwsErroDTO retorno = new IwsErroDTO();
		try {
//			retorno = getMsWs().setTr_buscaAlertaProbQuali(cdMaquina);
			retorno = IwsFacade.getInstancia().setTr_buscaAleraProbQuali(cdMaquina);
		} catch(Exception e) {
			retorno.setSucesso(false);
			retorno.setMensagem("Erro na comunica��o com Servi�os Web.");
		}
		
		return retorno;
	}
	
	public void alteraStatusApntSap(String idUp, Calendar dtHr, String stApntSap) {
		try {
//			getMsWs().setTr_alteraStatusApntSap(idUp, dtHr, stApntSap);
			IwsFacade.getInstancia().setTr_alteraStatusApntSap(idUp, dtHr.getTime(), stApntSap);
		} catch(Exception e) {
		}
	}
	
	public String alteraCartoesKanban(String idUp, Calendar dtHr, String quantidade, boolean tipoAlter) {
		String resposta = "";
		
		try {
//			resposta = getMsWs().setTr_alteraCartoesKanban(idUp, dtHr, quantidade, tipoAlter);
			resposta = IwsFacade.getInstancia().setTr_alteraCartoesKanban(idUp, dtHr.getTime(), quantidade, tipoAlter);
		} catch(Exception e) {
			resposta = "Concentrador - Excecao na comunica��o com WebService";
		}
		
		return resposta;
	}
	
	public int validaDadosSap(String idup, Calendar DtHrEvento, INovaUpDTO lcupdto,
			String cdproduto, String cdmateriaprima, String estoque, String lote,
			Double quantidade, int stRegistro, boolean isComLote,
			String sapDbDsn, String sapDbUser, String sapDbPass)
	{
		int sapReturn = 0;
		String msgerro = "";
		
		if(stRegistro > 0) {
			stRegistro = 3;
			sapReturn = 1;
			
//			getMsWs().setTr_registroIntegracaoDoal(idup, DtHrEvento, "OPERADOR OPTOU POR N�O VALIDAR OS DADOS COM O BANCO SAP.", false);
			IwsFacade.getInstancia().setTr_registroIntegracaoDoal(idup, DtHrEvento.getTime(), "OPERADOR OPTOU POR N�O VALIDAR OS DADOS COM O BANCO SAP.", false);
		}
		else {
			RetValidaEstLoteDTO retorno = validaEstoqueLoteQntdMatPrimaSAP(cdmateriaprima, lote, estoque, quantidade, isComLote, msgerro,
				sapDbDsn, sapDbUser, sapDbPass);
			
			sapReturn = retorno.getResultado();
			msgerro = retorno.getMsgErro();
			
			lcupdto.setTxtMsg(msgerro);
			
			if(sapReturn == 2) {
				stRegistro = 2;
//				getMsWs().setTr_registroIntegracaoDoal(idup, DtHrEvento, "SAP OFFLINE", false);
				IwsFacade.getInstancia().setTr_registroIntegracaoDoal(idup, DtHrEvento.getTime(), "SAP OFFLINE", false);
			}
			else if(sapReturn == 1) {
				stRegistro = 1;
			}
		}
		
		if(sapReturn == 0) {
//			getMsWs().setTr_registroIntegracaoDoal(idup, DtHrEvento, msgerro, false);
			IwsFacade.getInstancia().setTr_registroIntegracaoDoal(idup, DtHrEvento.getTime(), msgerro, false);
			return 0;
		}
		
		return stRegistro;
	}
	
	private RetValidaEstLoteDTO validaEstoqueLoteQntdMatPrimaSAP(String materiaPrima, String lote, String estoque, double quantidade,
			boolean isComLote, String msgErro,
			String sapDbDsn, String sapDbUser, String sapDbPass)
	{
		
		// No momento estou retornando somente um boleano mas para passar as mensagens � necess�rio um DTO de retorno
		// contendo bool e uma String(mensagem de erro)
		// RETORNO: 0- ERRO; 1- VALIDO; 2- TIMEOUT
		RetValidaEstLoteDTO retorno = new RetValidaEstLoteDTO();
		
//		OdbcConnection dbCon;
//		OdbcCommand sqlCommand;
//		OdbcDataReader sqlReader;
		String qtdSAP = "0";
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:" + sapDbDsn + ";UID=" + sapDbUser + ";PWD=" + sapDbPass;
//			String strConnect = "DSN=" + sapDbDsn + ";UID=" + sapDbUser + ";PWD=" + sapDbPass;
			
			Connection dbCon = DriverManager.getConnection(url);
//			dbCon = new OdbcConnection(strConnect);
			
			try {
//				dbCon.Open();
//				sqlCommand = dbCon.CreateCommand();
//				sqlCommand.CommandText = "select count (*) from owhs where whsCode = '" + estoque + "' ";
//				sqlReader = sqlCommand.ExecuteReader();
				Statement stmt = dbCon.createStatement();
				String sQuery = "select count (*) from owhs where whsCode = '" + estoque + "' ";
				ResultSet result = stmt.executeQuery(sQuery);
				
				// display row values 
//				while(sqlReader.Read()) {
				while(result.next()) {
					if(Integer.parseInt(result.getString(0)) == 0) {
						// Log de erro de c�digo de estoque inv�lido
						
						msgErro = "CODIGO DE ESTOQUE INVALIDO. ESTOQUE= (" + estoque + ")";
						
						retorno.setMsgErro(msgErro);
						retorno.setResultado(0);
						return retorno;
					}
				}
				
				result.close();
//				sqlReader.Close();
//				sqlReader.Dispose();
				
				stmt = dbCon.createStatement();
//				sqlCommand = dbCon.CreateCommand();
				// execute sql
				if(isComLote) {
					sQuery = "select quantity from oibt where itemCode = '" + materiaPrima +
						"' and batchNum = '" + lote +
						"' and whsCode = '" + estoque + "' ";
//					sqlCommand.CommandText = "select quantity from oibt where itemCode = '" + materiaPrima +
//						"' and batchNum = '" + lote +
//						"' and whsCode = '" + estoque + "' ";
				}
				else {
					sQuery = "select onhand from oitw where itemCode = '" + materiaPrima +
						"' and whsCode = '" + estoque + "' ";
//					sqlCommand.CommandText = "select onhand from oitw where itemCode = '" + materiaPrima +
//						"' and whsCode = '" + estoque + "' ";
				}
				
				result = stmt.executeQuery(sQuery);
//				sqlReader = sqlCommand.ExecuteReader();
				
				// display row values 
				int i = 0;
//				while(sqlReader.Read()) {
				while(result.next()) {
					qtdSAP = result.getString(0);
					i++;
				}
				
				if(isComLote && i == 0) {
					// log de erro de lote inv�lido
					msgErro = "CODIGO DE LOTE INVALIDO. LOTE= (" + lote + ")";
					
					retorno.setMsgErro(msgErro);
					retorno.setResultado(0);
					return retorno;
				}
				
				if(i > 1) {
					//lan�a log de erro de inconsist�ncia pois ta retornando mais de uma linha 
					msgErro = "INCONSISTENCIA NOS DADOS: MAIS DE UM REGISTRO NO SISTEMA PARA OS PARAMETROS INFORMADOS. i=" + i;
					
					retorno.setMsgErro(msgErro);
					retorno.setResultado(0);
					return retorno;
				}
				
				result.close();
//				sqlReader.Close();
//				sqlCommand.Dispose();
				
				try {
					if(qtdSAP.startsWith(".") || qtdSAP.startsWith(","))
						qtdSAP = "0" + qtdSAP;
					
					qtdSAP.replace(",", ".");
					
					if(quantidade > Double.parseDouble(qtdSAP.split(".")[0]) || quantidade  == 0d) {
						//Quantidade insuficiente
						msgErro = "QUANTIDADE INVALIDA. QTD INFO= (" + quantidade + "); QTD DISP SAP= (" + qtdSAP + ")";
						
						retorno.setMsgErro(msgErro);
						retorno.setResultado(0);
						return retorno;
					}
				} catch(Exception e) {
					//gera log de erro na convers�o se String para float
					msgErro = "ERRO NO VALOR DE QUANTIDADE LIDO DO SAP. QtdSAP= (" + qtdSAP + ")";
					
					retorno.setMsgErro(msgErro);
					retorno.setResultado(0);
					return retorno;
				}
			} catch(SQLException e) {
				//gera log de erro
				msgErro = "ERRO NA COMUNICACAO COM O BANCO DE DADOS DO SAP. DSN=" + sapDbDsn + " USER=" + sapDbUser;
				
				retorno.setMsgErro(msgErro);
				retorno.setResultado(2);
				return retorno;
			} finally {
				if(dbCon != null) dbCon.close();
			}
		} catch(Exception e) {
			// erro inesperado
			msgErro = "ERRO GENERICO";
			
			retorno.setMsgErro(msgErro);
			retorno.setResultado(0);
			return retorno;
		}
		
		retorno.setResultado(1);
		return retorno;
	}
	
	public List<IwsProdMateriaPrimaDTO> buscaListaMateriaPrima(String idUp, IdwLogger log, int idLog) {
		List<IwsProdMateriaPrimaDTO> prodMatPrimas = new ArrayList<IwsProdMateriaPrimaDTO>();
		
		IwsListaMatPrimaDTO listaMaterial = new IwsListaMatPrimaDTO();
		
		try {
//			listaMaterial = getMsWs().getTr_dadosIntegracaoDoal(idUp);
//			listaMaterial = IwsFacade.getInstancia().getTr_dadosIntegracaoDoal(idUp);
			listaMaterial = ms.getTr_dadosIntegracaoDoal(idUp);
		} catch(Exception e) {
			prodMatPrimas = null;
		}
		
		if(listaMaterial.isErro() == false) {
			try {
				List<IwsProdMateriaPrimaDTO> listaMateriasPrimas = listaMaterial.getMateriasPrimas();
				
				for(IwsProdMateriaPrimaDTO prod : listaMateriasPrimas) {
					IwsProdMateriaPrimaDTO materiaprima = new IwsProdMateriaPrimaDTO();
					materiaprima = prod;
					prodMatPrimas.add(materiaprima);
				}
			} catch(Exception e) {
				log.info(idLog, 0, "\\ERRO_GRAVE4");
				log.info(idLog, 1, e.getMessage());
				log.info(idLog, 1, e.getStackTrace());
				log.info(idLog, 1, e.getLocalizedMessage());
				log.info(idLog, 1, e.getCause());
				log.info(idLog, 1, "---------------------");
			}
		}
		else {
			prodMatPrimas = null;
		}
		
		return prodMatPrimas;
	}
	
	public boolean enviaListaMatPrima(String idup, Calendar DtHrEvento, INovaUpDTO lcupdto, List<IwsProdMateriaPrimaDTO> listApontarMP ) {
		for(IwsProdMateriaPrimaDTO materia : listApontarMP ) {
			String cdproduto = materia.getCdProduto();
			String cdmateriaprima = materia.getCdMateriaPrima();
			String estoque = materia.getEstoque();
			String lote = materia.getLote();
			Double quantidade = materia.getQtd();
			int stRegistro = materia.getStregistro();
			
			try {
				if(lcupdto.getIsSemPrograma())
//					lcupdto.setUltimaMateriaPrimaAtual(getMsWs().setTr_lancaApntMateriaPrima(idup, DtHrEvento,
//					cdproduto, cdmateriaprima, estoque, lote, quantidade, stRegistro, lcupdto.cpTmp));
				lcupdto.setUltimaMateriaPrimaAtual(IwsFacade.getInstancia().setTr_lancaApntMateriaPrima(idup, DtHrEvento.getTime(), cdproduto, cdmateriaprima,
						estoque, lote, quantidade, stRegistro, lcupdto.getCpTemp()));
				else {
//					lcupdto.ultimaMateriaPrimaAtual = getMsWs().setTr_lancaApntMateriaPrima(idup, DtHrEvento,
//					cdproduto, cdmateriaprima, estoque, lote, quantidade, stRegistro, lcupdto.cp);
					lcupdto.setUltimaMateriaPrimaAtual(IwsFacade.getInstancia().setTr_lancaApntMateriaPrima(idup, DtHrEvento.getTime(), cdproduto, cdmateriaprima,
							estoque, lote, quantidade, stRegistro, lcupdto.getCp()));
				}
			} catch(Exception e) {
				lcupdto.setTxtMsg("FALHA NO APONTAMENTO DE MATERIA PRIMA");
				return false;
			}
		}
		
		return true;
	}
	
	public Boolean finalizaPlanejamento(INovaUpDTO up) {
		up.setIsSemPrograma(true);
		up.setStFuncionamento(INovaUpDTO.STATUS_FUNCIONAMENTO_SEMPROGRAMA);
		if(up.getCp() != null) up.getCp().setNrop(null);
		return true;
	}
	
	public IwsRefugoDTO setTr_LancaRefugo(INovaUpDTO up, Calendar DtHrevento, String cdRefugo, String cdCausa, String cdAcao, String Quantidade, String IdRdzProduto) throws SemComunicacaoICException {
		IwsRefugoDTO refugoDTO = new IwsRefugoDTO();
		IwsRefugoDTO retorno = new IwsRefugoDTO();
		
		try {
//			refugoDTO = getMsWs().setTr_LancaEventoRefugo(cdRefugo, cdCausa, cdAcao, Quantidade, up.idUP, IdRdzProduto, DtHrevento);
			refugoDTO = IwsFacade.getInstancia().setTr_LancaEventoRefugo(cdRefugo,  cdCausa,  cdAcao, Quantidade, up.getIdUP(), IdRdzProduto, DtHrevento.getTime());
			
			retorno.setIsRefugoValido(refugoDTO.getIsRefugoValido());
			retorno.setMilissegundos(refugoDTO.getMilissegundos());
			retorno.setDthrUltRefugo(refugoDTO.getDthrUltRefugo());
			retorno.setIdReduzidaProd(refugoDTO.getIdReduzidaProd());
			retorno.setCdRefugo(refugoDTO.getCdRefugo());
			
			return retorno;
		} catch(Exception e) {
			throw new SemComunicacaoICException(e);
		}
	}
	
	public boolean setTr_IniCIP(String idup, Calendar DtHrevento, String Tecnico) {
		boolean retorno = false;
		
		try {
//			retorno = getMsWs().setTr_trataInicioDeCIP(idup, DtHrevento);
			retorno = IwsFacade.getInstancia().setTr_trataInicioDeCIP(idup, DtHrevento.getTime(), Tecnico);
			return retorno;
		} catch(Exception e) {
			return false;
		}
	}
	
	// pega os dados da tabela PR_UP_ANDON_PRCSFT, dado uma IdUP
	public IwsUpAndonPrcsftDTO setTr_getPrUpAndonPrcsft(String idup) {
		IwsUpAndonPrcsftDTO oUpAndonPrcsftDTOWS;
		IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
		
		try {
//			oUpAndonPrcsftDTOWS = getMsWs().setTr_getPrUpAndonPrcsft(idup);
			oUpAndonPrcsftDTOWS = IwsFacade.getInstancia().setTr_getPrUpAndonPrcsft(idup);
		} catch(Exception e) {
			oUpAndonPrcsftDTOWS = null;
			oUpAndonPrcsftDTO = null;
		}
		
		if(oUpAndonPrcsftDTOWS != null && oUpAndonPrcsftDTOWS.geterro() == false) {
			oUpAndonPrcsftDTO = oUpAndonPrcsftDTOWS;
		}
		else {
			oUpAndonPrcsftDTO = null;
		}
		
		return (oUpAndonPrcsftDTO);
	}
	
	public boolean isInjetAtivo(){
		return this.isInjetAtivo;
	}
	
	public void setInjetAtivo(boolean isAtivo){
		this.isInjetAtivo = isAtivo;
	}
		
}

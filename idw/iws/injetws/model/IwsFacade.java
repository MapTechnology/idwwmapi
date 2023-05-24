package injetws.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.mws.DAOGenericoMws;
import idw.model.dao.tdba.DAOGenericoTdba;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.DiversosInjetRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ConfiguracaoConcentrador;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpExecinspecao;
import injetws.model.rn.InfoRN;
import injetws.model.rn.ModRN;
import injetws.model.rn.ParadaRN;
import injetws.model.rn.ProducaoRN;
import injetws.model.rn.QualidadeRN;
import injetws.model.rn.RefugoRN;
import injetws.model.rn.UtilRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaOPsRN;
import injetws.model.rn.injet.InjetAlertaRN;
import injetws.model.rn.injet.InjetInfoRN;
import injetws.model.rn.injet.InjetModRN;
import injetws.model.rn.injet.InjetParadaRN;
import injetws.model.rn.injet.InjetRefugoRN;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaOPsDTO;
import injetws.webservices.dto.IwsComplementaOP;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsDadosCCKDTO;
import injetws.webservices.dto.IwsDadosColetadosDTO;
import injetws.webservices.dto.IwsDadosIHMBalancaDTO;
import injetws.webservices.dto.IwsDadosInspDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsFitesaDTO;
import injetws.webservices.dto.IwsHorarioDTO;
import injetws.webservices.dto.IwsInspecaoManualDTO;
import injetws.webservices.dto.IwsListModDTO;
import injetws.webservices.dto.IwsListaAlertaDTO;
import injetws.webservices.dto.IwsListaDadosColetadosDTO;
import injetws.webservices.dto.IwsListaInspecoesAutoDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsPesoProdutoDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsRefugoComDefeitosDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsReleDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDncDTO;
import injetws.webservices.dto.IwsVariacaoRitmoDTO;
import injetws.webservices.dto.IwsVariacaoRitmoValidaDTO;

import ms.coleta.Stubedelegate;
import ms.coleta.ic.buffereventos.MSBufferEventosFacade;
import ms.coleta.ic.inova.Stubdelegate;

public class IwsFacade {
	
	private static IwsFacade oIwsFacade = null;
	private String realRootPath=null;
	private boolean isCdParadaPadraoInjet = true;
	
	public IwsFacade() {
	}	
	
	public static IwsFacade getInstancia(){
		if (oIwsFacade == null) {			
				oIwsFacade = new IwsFacade();			
		}
		return(oIwsFacade);
	}
	
	public boolean isCdParadaPadraoInjet() {
		return isCdParadaPadraoInjet;
	}

	public void setCdParadaPadraoInjet(boolean isCdParadaPadraoInjet) {
		this.isCdParadaPadraoInjet = isCdParadaPadraoInjet;
	}
	
	public static void setRealRootPath(String rRootPath){
		getInstancia().realRootPath=rRootPath;
	}
	
	public static String getRealRootPath(){
		return getInstancia().realRootPath;
	}
	
	public IwsListaAlertaDTO GetTr_pesquisaAlertasEmAberto(String cdMaquina){
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();
		
		log.info(idLog, 0,"Inicializando GetTr_pesquisaAlertasEmAberto() para maquina " + cdMaquina);
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetAlertaRN alertaRN = new InjetAlertaRN(daoInjet);
		IwsListaAlertaDTO retorno = new IwsListaAlertaDTO();
		try{
			alertaRN.iniciaConexaoBanco();
			retorno.setAlertas(alertaRN.pesquisaAlertasEmAberto(log, idLog, cdMaquina));
		} catch (Exception e){
			log.info("excessao" , e);
			e.printStackTrace();
		} finally {
			try{
				alertaRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				alertaRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando GetTr_pesquisaAlertasEmAberto() para maquina " + cdMaquina);
				alertaRN = null;
				daoInjet = null;				
			}
		}
		alertaRN = null;
		daoInjet = null;
		log.info(idLog, 0,"Finalizando GetTr_pesquisaAlertasEmAberto() para maquina " + cdMaquina);

		return retorno;
	}

	
	public boolean setTr_AlertaInicio(String idUp, String cdAlerta,Date DataHrAtual){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_AlertaInicio() para idup " + idUp+"e cdalerta:"+ cdAlerta);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		boolean retorno = false;
		try{			
			infoRN.iniciaConexaoBanco();
			cdAlerta = UtilRN.setZeroEsquerda(cdAlerta);			
			retorno = infoRN.setTr_AlertaInicio(log, idLog, idUp, cdAlerta, DataHrAtual);

		}catch (RegistroDesconhecidoException e){
			// n�o faz nada deixa o retorno ser false;
		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();				
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando setTr_AlertaInicio() para idup " + idUp+"e cdalerta:"+ cdAlerta);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_AlertaInicio() para idup " + idUp+"e cdalerta:"+ cdAlerta);
		daoInjet=null;
		daoPdba=null;
		infoRN = null;

		return retorno;
	}
	
	public boolean setTr_AlertaFim(String idUp, String cdAlerta,Date DataHrAtual){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_AlertaFim() para idup " + idUp+"e cdalerta:"+ cdAlerta);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		boolean retorno = false;
		try{			
			infoRN.iniciaConexaoBanco();
			cdAlerta = UtilRN.setZeroEsquerda(cdAlerta);			
			retorno = infoRN.setTr_AlertaFim(log, idLog, idUp, cdAlerta, DataHrAtual);

		}catch (RegistroDesconhecidoException e){
			// n�o faz nada deixa o retorno ser false;
		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();				
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando setTr_AlertaFim() para idup " + idUp+"e cdalerta:"+ cdAlerta);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_AlertaFim() para idup " + idUp+"e cdalerta:"+ cdAlerta);
		daoInjet=null;
		daoPdba=null;
		infoRN = null;

		return retorno;
	}
	
	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta){
		IdwLogger log = new IdwLogger("getTr_TabAlertaSetCod");
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Inicializando getTr_TabAlertaSetaCod() para Alerta " + cdAlerta);
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetAlertaRN alertaRN = new InjetAlertaRN( daoInjet);
		IwsAlertaDTO retorno = new IwsAlertaDTO();
		try{
			alertaRN.iniciaConexaoBanco();

			cdAlerta = UtilRN.setZeroEsquerda(cdAlerta);
			retorno = alertaRN.getTr_TabAlertaSetaCod(cdAlerta);
		}catch(RegistroDesconhecidoException exc){
			log.info(idLog, 0,"Registro desconhecido CdAlerta: " + cdAlerta);
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				alertaRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				alertaRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_TabAlertaSetaCod() para Alerta " + cdAlerta);
			}
		}
		alertaRN = null;
		daoInjet = null;
		log.info(idLog, 0,"Finalizando getTr_TabAlertaSetaCod() para Alerta " + cdAlerta);

		return retorno;
	}
	
	public IwsUpDncDTO getTr_DncTransferencia(String cdMaquina){
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_DncTransferencia() para maquina " + cdMaquina);		
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba = new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);	
		IwsUpDncDTO retorno = new IwsUpDncDTO();
		try{			
			infoRN.iniciaConexaoBanco();
			cdMaquina = UtilRN.setZeroEsquerda(cdMaquina);			
			retorno = infoRN.getTr_DncTransferencia( cdMaquina);

		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();				
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_DncTransferencia() para maquina " + cdMaquina);
			}
		}
		log.info(idLog, 0,"Finalizando getTr_DncTransferencia() para maquina " + cdMaquina);
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public IwsHorarioDTO getTr_sincronizaHorario() {
		IwsHorarioDTO horario = new IwsHorarioDTO();
		Date data = null;
		if (Stubdelegate.getInstancia().isInjetAtivo() == true)
			data = obtemDataHoraAtual();
		else
			data = DataHoraRN.getDataHoraAtual();
		
		horario.setData(data);

		return horario;
	}
	
	public Date obtemDataHoraAtual(){
		IdwLogger log = new IdwLogger("obtemDataHoraAtual");
		int idLog = log.getIdAleatorio();
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		Date retorno=null;
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.obtemDataHoraAtual();
		} catch (Exception e){
			log.info(idLog, 0,"-ERRO- Finalizando obtemDataHoraAtual() sem obter a data" );
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"-ERRO- Finalizando obtemDataHoraAtual Com erro");
			}
		}
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;		
	}
	
	public IwsListaUpDTO inicializacao(String mac,boolean comParadaSemConexao,boolean comParadaDefault, Date dtHr){
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando inicializacao() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsListaUpDTO retorno = new IwsListaUpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.inicializacao(log, idLog, mac,comParadaSemConexao, comParadaDefault,dtHr);			
			
		} catch (Exception e){			
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				infoRN.finalizaConexaoBanco();
				e2.printStackTrace();
				retorno.setIsSGBDOnline(false);
			}
		}
		log.info(idLog, 0,"Finalizando inicializacao() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}

	public IwsListaUpDTO inicializacaoColetaDiscreta(String mac){
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando inicializacaoColetaDiscreta() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsListaUpDTO retorno = new IwsListaUpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.inicializacaoColetaDiscreta(log, idLog, mac);		
			
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				infoRN.finalizaConexaoBanco();
				e2.printStackTrace();
				retorno.setIsSGBDOnline(false);
			}
		}
		log.info(idLog, 0,"Finalizando inicializacaoColetaDiscreta() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public IwsListaUpDTO inicializacaoSemEvento(String mac){
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando inicializacaoSemEvento() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsListaUpDTO retorno = new IwsListaUpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.inicializacaoSemEvento(log, idLog, mac);		
			
		} catch (Exception e){
			log.info("excessao", e);
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				infoRN.finalizaConexaoBanco();
				retorno.setIsSGBDOnline(false);
			}
		}
		log.info(idLog, 0,"Finalizando inicializacaoSemEvento() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public IwsConsultaDTO setTr_Consulta(String CdConsulta,String IdUp,Date DataHrAtual){
		IdwLogger log = new IdwLogger(IdUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_Consula() para idup " + IdUp+"e cdconsulta:"+ CdConsulta);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsConsultaDTO retorno = new IwsConsultaDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_Consula(log, idLog, CdConsulta, IdUp, DataHrAtual);		
			
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				infoRN.finalizaConexaoBanco();
				e2.printStackTrace();
				retorno.setResposta(false);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_Consula() para idup " + IdUp+"e cdconsulta:"+ CdConsulta);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public IwsHorarioDTO setUPBeatMac(String mac,Date dthrBeat){	
		return setUPBeatMac(mac, dthrBeat,false,false);
	}
	
	public IwsHorarioDTO setUPBeatMac(String mac,Date dthrBeat,boolean isLogoutNaViradaTurno,boolean isFechaParadaNaViradaTurno){		
		try {
			IwsListaUpDTO listaUpDTO = setUpBeat(mac, dthrBeat,isLogoutNaViradaTurno,isFechaParadaNaViradaTurno);
			IwsHorarioDTO retorno = getTr_sincronizaHorario();
			retorno.setListaUpDTO(listaUpDTO);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			return getTr_sincronizaHorario();
		}
	}
	
	public IwsListaUpDTO setUpBeat(String mac, Date dthrBeat,boolean isLogoutNaViradaTurno,boolean isFechaParadaNaViradaTurno){
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setUpBeat() para mac " + mac + " em "+ dthrBeat);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsListaUpDTO retorno = new IwsListaUpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.setUpBeat(log, idLog, mac, dthrBeat, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);	
			
		} catch (Exception e){
			log.info("excessao", e);
			// considera sem conex�o com o banco para n�o perder os dados atuais das UPs
			// retorno.setIsSGBDOnline(true);
			retorno.setIsSGBDOnline(false);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				infoRN.finalizaConexaoBanco();
				e2.printStackTrace();
				log.info(idLog, 0,"Finalizando setUpBeat() para mac " + mac + " em "+ dthrBeat);
				daoPdba=null;
				daoInjet=null;
				infoRN = null;
			}
		}
		log.info(idLog, 0,"Finalizando setUpBeat() para mac " + mac + " em "+ dthrBeat);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar ){
		IdwLogger log = new IdwLogger("getTr_ValidaLoginSenha");
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getTr_ValidaLoginSenha() para login " + login);
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetModRN modRN = new InjetModRN(daoInjet,daoPdba);
		boolean retorno = false;
		try{
			modRN.iniciaConexaoBanco();
			login = UtilRN.setZeroEsquerda(login);
			retorno = modRN.getTr_ValidaLoginSenha(login, senha, avaliar);	
		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				modRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				modRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_ValidaLoginSenha() para login " + login);
			}
		}
		log.info(idLog, 0,"Finalizando getTr_ValidaLoginSenha() para UP login " + login);

		daoInjet=null;
		modRN = null;

		return retorno;			
	}
	
	public IwsAutenticacaoDTO getTr_Autorizacao(String idUp, String login, String password, int avaliar,Date DataHrAtual,Boolean validaPorDsUsuario){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getTr_Autorizacao() para UP " + idUp + " login " + login);
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetModRN modRN = new InjetModRN(daoInjet,daoPdba);
		IwsAutenticacaoDTO retorno = null;
		try{
			modRN.iniciaConexaoBanco();
			if( validaPorDsUsuario==false)
				login = UtilRN.setZeroEsquerda(login);
			retorno = modRN.getTr_Autorizacao(log, idLog, idUp,login, password, avaliar, DataHrAtual, validaPorDsUsuario);		 

		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				modRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				modRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_Autorizacao() para UP " + idUp + " login " + login);
			}
		}
		log.info(idLog, 0,"Finalizando getTr_Autorizacao() para UP " + idUp + " login " + login);

		daoInjet=null;
		modRN = null;

		return retorno;		
	}
	
	public IwsAutenticacaoDTO getTr_AutorizacaoLogout(String idUp, String login, String password,Date DataHrAtual,Boolean validaPorDsUsuario){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getTr_AutorizacaoLogout() para UP " + idUp +"e Login:"+login);
		IwsAutenticacaoDTO retorno = null;
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetModRN imodrn = new InjetModRN(daoInjet,daoPdba);
		try{
			imodrn.iniciaConexaoBanco();
			if( validaPorDsUsuario==false)
				login = UtilRN.setZeroEsquerda(login);
			retorno = imodrn.getTr_Autorizacao(log, idLog, idUp, login, password,0, DataHrAtual,validaPorDsUsuario);

		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				imodrn.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				imodrn.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_AutorizacaoLogout() para UP " + idUp +"e Login:"+login);
				daoPdba=null;
				daoInjet=null;
				imodrn = null;
			}
		}
		log.info(idLog, 0,"Finalizando getTr_AutorizacaoLogout() para UP " + idUp +"e Login:"+login);

		daoPdba=null;
		daoInjet=null;
		imodrn = null;
		
		return retorno;
	}	
	
	public IwsCpDTO planejamento(String idUp, IwsCpDTO cpEntrada,Date dthr){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando planejamento() para up " + idUp);
		IwsCpDTO retorno = new IwsCpDTO();
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.planejamento(log, idLog, idUp, cpEntrada,dthr);

		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno.setIsSGBDOnline(false);
			}
		}
		log.info(idLog, 0,"Finalizando planejamento() para up " + idUp);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}	
	
	public boolean fimPlanejamento(String idUp, Date dthrfplanejamento){
		return fimPlanejamento(idUp, dthrfplanejamento, 0, false);
	}
	
	public boolean fimPlanejamento(String idUp, Date dthrfplanejamento,int batidas, boolean isParcial){
		IdwLogger log = new IdwLogger("FIM-PLANEJAMENTO");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando fimplanejamento() para up " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.fimPlanejamento(log, idLog, idUp, dthrfplanejamento, batidas, isParcial);

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				return false;
			}
		}
		log.info(idLog, 0,"Finalizando fimplanejamento() para up " + idUp);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return true;
	}
	
	public Boolean setTr_trataInicioDeCIP(String idup, Date DataReferencia,String Tecnico){
		IdwLogger log = new IdwLogger(idup);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando TratarInicioDeCIP() para up " + idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		Boolean retorno=false;
		try{
			infoRN.iniciaConexaoBanco();			
			infoRN.TratarInicioDeCIP(log, idLog, idup, DataReferencia, Tecnico);
			retorno=true;
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno=false;
			}
		}
		log.info(idLog, 0,"Finalizando TratarInicioDeCIP() para up " + idup);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public Boolean setTr_trataFimCIP(String idUp, Date dthrfim,String Tecnico){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando fimcip() para up " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		Boolean retorno=false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.trataFimCIP(log, idLog, idUp, dthrfim, Tecnico);

		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno=false;
			}
		}
		log.info(idLog, 0,"Finalizando fimcip() para up " + idUp);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public Boolean setTr_MCSemConexao(String mac, Date dthrBeat){
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_MCSemConexao() para mac " + mac + " dthr " + dthrBeat);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		Boolean retorno=false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.setTr_MCSemConexao(log, idLog, mac, dthrBeat);

		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno=false;
			}
		}
		log.info(idLog, 0,"Finalizando setTr_MCSemConexao() para mac " + mac + " dthr " + dthrBeat);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsReleDTO setTr_getRele8(String idup){
		IdwLogger log = new IdwLogger(idup);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_getRele8() para idup " + idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsReleDTO retorno=null;
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_getRele8(idup);
			if(retorno==null){
				retorno=new IwsReleDTO();
				retorno.seterro(true);
			}else{
				retorno.seterro(false);
			}
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno=new IwsReleDTO();
				retorno.seterro(true);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_getRele8() para idup " + idup);		
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	//TODO: validar o m�todo de setTr_getPrUpAndonPrcsft InjetInfoRN
	public IwsUpAndonPrcsftDTO setTr_getPrUpAndonPrcsft(String Idup){
		IdwLogger log = new IdwLogger(Idup);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_getPrUpAndonPrcsft() para Idup " + Idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsUpAndonPrcsftDTO retorno=null;
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_getPrUpAndonPrcsft(Idup);			
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno=new IwsUpAndonPrcsftDTO();
				retorno.seterro(true);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_getPrUpAndonPrcsft() para Idup " + Idup);		
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public boolean getStatusPrUpAndon(String idup,boolean tipo){ 
		IdwLogger log = new IdwLogger(idup);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getStatusPrUpAndoPrcsft() para idup " + idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		boolean retorno=false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.getStatusPrUpAndon(idup,tipo);		
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getStatusPrUpAndoPrcsft() para idup " + idup);		
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsInspecaoManualDTO getTr_VerificaExecInspecao (String idUp){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getTr_VerificaExecInspecao() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		
		IwsInspecaoManualDTO retorno=new IwsInspecaoManualDTO();		
		try{
			infoRN.iniciaConexaoBanco();
			
			PrUpExecinspecao resultadoExecInsp = infoRN.getTr_VerificaExecInspecao(idUp);
			if(resultadoExecInsp == null) {
				// n�o h� inspe��o em andamento
				IwsErroDTO isAlertaAberto = new IwsErroDTO();
				try {
					PrUp prup = infoRN.pesquisaPrup(log, idLog, idUp);
					isAlertaAberto = infoRN.setTr_buscaAleraProbQualiRet(log, idLog, prup.getCdmaquina());
				} catch (Exception e) {		
					e.printStackTrace();
				}
				if(isAlertaAberto.getSucesso() == true)
				{
					retorno.setErro(true);					
					retorno.setIscomalertaprobqualidade(true);
					retorno.setInf01("22"); 
				}
			}
			else { // ha inspecao em andamento				
				retorno.copyPrUpExecinspecao(resultadoExecInsp);				
				retorno.setInf02("2");
			}			
		}catch (SemSGBDException e) {
				retorno.setErro(true);
				retorno.setMsgErro("Sem Conex�o com o Banco de Dados"); 				
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessa", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		retorno.setIdUp(idUp);
		log.info(idLog, 0,"Finalizando getTr_VerificaExecInspecao() para idUP " + idUp);		
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}	
	
	public IwsInspecaoManualDTO setTr_LancaEventoInspecao (String idUp, Date DtHrAtual)  { 
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_LancaEventoInspecao() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsInspecaoManualDTO retorno=new IwsInspecaoManualDTO();		
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_LancaEventoInspecao(log, idLog, idUp, DtHrAtual);
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno.setErro(true);
				retorno.setMsgErro("Sem Conex�o com o Banco de Dados");
			}
		}
		retorno.setIdUp(idUp);
		log.info(idLog, 0,"Finalizando setTr_LancaEventoInspecao() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsInspecaoManualDTO getTr_ParametrosInspecao (String idUp) { 
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando getTr_ParametrosInspecao() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsInspecaoManualDTO retorno=new IwsInspecaoManualDTO();		
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.getTr_ParametrosInspecao(log, idLog, idUp);
		} catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno.setErro(true);
				retorno.setMsgErro("Sem Conex�o com o Banco de Dados");
			}
		}
		retorno.setIdUp(idUp);
		log.info(idLog, 0,"Finalizando getTr_ParametrosInspecao() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsErroDTO setTr_LancaEventoFimInspecao(String idUp, Date DtHrAtual, IwsDadosInspDTO resultados){ 
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_LancaEventoFimInspecao() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_LancaEventoFimInspecao(log, idLog, idUp, DtHrAtual, resultados);
		} catch (Exception e){
			log.info("excessao", e);
			retorno.setSucesso(false);
			retorno.setMensagem("Sem Conex�o com o Banco de Dados");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_LancaEventoFimInspecao() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
			
	public IwsErroDTO setTr_LancaAberturaInspecao(String idUp, Date dtHr) { 
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_LancaAberturaInspecao() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_LancaAberturaInspecao(log, idLog, idUp, dtHr);
		} catch (Exception e){
			log.info("excessao", e);
			retorno.setSucesso(false);
			retorno.setMensagem("Sem Conex�o com o Banco de Dados");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_LancaAberturaInspecao() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsErroDTO setTr_buscaAleraProbQuali(String cdMaquina){ 
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_buscaAleraProbQuali() para cdMaquina " + cdMaquina);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_buscaAleraProbQualiRet(log, idLog, cdMaquina);
		} catch (Exception e){
			log.info("excessao", e);
			retorno.setSucesso(false);
			retorno.setMensagem("Sem Conex�o com o Banco de Dados");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_buscaAleraProbQuali() para cdMaquina " + cdMaquina);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsErroDTO encerraAlertaProbQuali (String idUp, Date dtHr, String cdUsuario){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando encerraAlertaProbQuali() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.encerraAlertaProbQuali(log, idLog, idUp,dtHr,cdUsuario);
		} catch (Exception e){
			log.info("excessao", e);
			retorno.setSucesso(false);
			retorno.setMensagem("Sem Conex�o com o Banco de Dados");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando encerraAlertaProbQuali() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
		
	public void setTr_removeInspecoesInvalidas(String idUp) {
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_removeInspecoesInvalidas() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);		
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.removeInspecoesInvalidas(idUp);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_removeInspecoesInvalidas() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;	
	}
	
	public IwsCpDTO setTr_confirmacaoOp(String idUp, Date dthr, String stApntSap, IwsCpDTO cpdto){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_confirmacaoOp() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsCpDTO retorno = new IwsCpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_confirmacaoOp(log, idLog, idUp,dthr,stApntSap, cpdto);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_confirmacaoOp() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public void setTr_alteraStatusApntSap(String idUp, Date dthr, String stApntSap){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_alteraStatusApntSap() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.setTr_alteraStatusApntSap(log, idLog, idUp,dthr,stApntSap);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_alteraStatusApntSap() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
	}
	
	public String setTr_alteraCartoesKanban(String idUp, Date dthr, String quantidade, boolean tipoAlter){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_alteraCartoesKanban() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		String resposta = "";
		try{
			infoRN.iniciaConexaoBanco();
			if(tipoAlter == true) { //adicionar cartoes
				resposta = infoRN.setTr_adicionaCartoesKanban(log, idLog, idUp,dthr,quantidade);
			}
			else {
				resposta = infoRN.setTr_removeCartoesKanban(log, idLog, idUp,dthr,quantidade);
			}
		} catch (Exception e){
			log.info("erro", e);
			resposta = "";
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				resposta = "";
			}
		}
		log.info(idLog, 0,"Finalizando setTr_alteraCartoesKanban() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return resposta;
	}
	
	public void setTr_registroIntegracaoDoal(String idUp, Date dtHr, String txtMsg, boolean salvaAlimIntegDoal) {
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_registroIntegracaoDoal() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.setTr_registroIntegracaoDoal(log, idLog, idUp, dtHr, txtMsg, salvaAlimIntegDoal);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_registroIntegracaoDoal() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
	}
	
	public IwsListaMatPrimaDTO getTr_dadosIntegracaoDoal(String idUp){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_dadosIntegracaoDoal() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		List<IwsProdMateriaPrimaDTO> matprima = null;
		IwsListaMatPrimaDTO retorno = new IwsListaMatPrimaDTO();
		try{
			infoRN.iniciaConexaoBanco();
			matprima = infoRN.getTr_dadosIntegracaoDoal(log, idLog, idUp);
			retorno.setErro(false);
		} catch (Exception e){	
			log.info("erro", e);
			retorno.setErro(true);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
				retorno.setErro(true);
			}
		}
		if(matprima == null) 
			retorno.setErro(true);
		retorno.copyListMatPrima(matprima);
		log.info(idLog, 0,"Finalizando getTr_dadosIntegracaoDoal() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public IwsProdMateriaPrimaDTO setTr_lancaApntMateriaPrima(String idUp, Date dtHr,
			String cdproduto, String cdmateriaprima, String estoque, String lote, Double quantidade, int stregistro,
			IwsCpDTO cpdto){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_lancaApntMateriaPrima() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);		
		IwsProdMateriaPrimaDTO retorno = new IwsProdMateriaPrimaDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_lancaApntMateriaPrima(log, idLog, idUp, dtHr,
					cdproduto, cdmateriaprima, estoque, lote, quantidade, stregistro, cpdto);
		} catch (Exception e){	
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_lancaApntMateriaPrima() para idUP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public Boolean setTr_lancaEvento46(IwsVariacaoRitmoDTO oVar,String idUp ,Date dthrEvento){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_lancaEvento46() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		Boolean retorno =false;
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.lancaEvento46(log, idLog,  oVar, idUp , dthrEvento);
			retorno=true;
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_registroIntegracaoDoal() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public IwsVariacaoRitmoValidaDTO validaMotivoVariacaoRitmo(String idup,String cdMotivo){
		IdwLogger log = new IdwLogger(idup);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando validaMotivoVariacaoRitmo() para idUP " + idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsVariacaoRitmoValidaDTO retorno =new IwsVariacaoRitmoValidaDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.validaMotivoVariacaoRitmo( cdMotivo);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando validaMotivoVariacaoRitmo() para idUp " + idup);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}	
	
	public IwsHorarioDTO getUpsIHMhorario(String mac,Date dthrBeat){		
		try {
			IwsListaUpDTO listaUpDTO = getUpsIHM(mac, dthrBeat);
			IwsHorarioDTO retorno = getTr_sincronizaHorario();
			retorno.setListaUpDTO(listaUpDTO);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			return getTr_sincronizaHorario();
		}
	}
	
	public IwsListaUpDTO getUpsIHM(String mac, Date dthrBeat)throws SemSGBDException{
		IdwLogger log = new IdwLogger(mac);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getUpsIHM() para mac " + mac + " em "+ dthrBeat);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		IwsListaUpDTO retorno = new IwsListaUpDTO();
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.getUpsIHM(mac, dthrBeat, false);	
			
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
				e2.printStackTrace();
				log.info(idLog, 0,"Finalizando getUpsIHM() para mac " + mac + " em "+ dthrBeat);
				daoPdba=null;
				daoInjet=null;
				infoRN = null;
				throw new SemSGBDException();
			}
		}
		log.info(idLog, 0,"Finalizando getUpsIHM() para mac " + mac + " em "+ dthrBeat);

		daoPdba=null;
		daoInjet=null;
		infoRN = null;

		return retorno;
	}
	
	public boolean getStProdutoUsuario(String idUp){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getStProdutoUsuario() para idUP " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		Boolean retorno =false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.verificaModuloAtivo(idUp);
		} catch (Exception e){			
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getStProdutoUsuario() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public IwsListModDTO getTr_operadoresLogados(String idUP){
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_operadoresLogados() para a UP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ModRN modRN = new ModRN(daoInjet,daoPdba);
		IwsListModDTO retorno = new IwsListModDTO();
		try{
			modRN.iniciaConexaoBanco();
			retorno =  modRN.getTr_operadoresLogados(idUP);	 

		}catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				modRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				modRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando getTr_operadoresLogados() para UP " + idUP );				
			}
		}
		log.info(idLog, 0,"Finalizando getTr_operadoresLogados() para UP " + idUP );

		daoPdba=null;
		modRN = null;

		return retorno;
	}
	
	public IwsErroDTO efetuaLogin(String idUp, String login,Date DataHrAtual){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando efetualogin() para a UP " + idUp + " login " + login + " em " + DataHrAtual);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		IwsListModDTO usuarios = getTr_operadoresLogados(idUp);
		retorno.setSucesso(true);
		
		try{
			infoRN.iniciaConexaoBanco();
			login = UtilRN.setZeroEsquerda(login);
			retorno = infoRN.verificaOperadorLogado(idUp, login, DataHrAtual);
			//Verifica se usuário já está Logado
			for(int i = 0; i < usuarios.getListModDTO().size(); i++){
				if(usuarios.getListModDTO().get(i).getLogin().compareTo(login) == 0){
					retorno.setSucesso(false);
					retorno.setMensagem("Operador ja logado");
					break;
				}
			}
			if(retorno.getSucesso() == true){
				infoRN.efetuaLogin(log, idLog, idUp, login, DataHrAtual);
			}else{
				log.info(idLog, 0,retorno.getMensagem());
			}
		} catch (Exception e){
			log.info("erro", e);
			retorno.setSucesso(false);
			retorno.setMensagem("Ocorreu uma excessao");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando efetualogin() para idUp " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsErroDTO efetuaLogout(String idUp, String login,Date DataHrAtual,Date DthrLogin){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando efetualogout() para a UP " + idUp + " login " + login + " em " + DataHrAtual);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsErroDTO retorno = new IwsErroDTO();
		try{
			infoRN.iniciaConexaoBanco();
			login=UtilRN.setZeroEsquerda(login);
			infoRN.efetuaLogout(log, idLog, idUp, login, DataHrAtual, DthrLogin);
			retorno.setSucesso(true);
		} catch (Exception e){
			retorno.setSucesso(false);
			retorno.setMensagem("Ocorreu uma excessao");
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando efetualogout() para UP " + idUp + " login " + login + " em " + DataHrAtual);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		
		return retorno;
	}
	
	public IwsCicloDTO setTr_paradaInicio(String idUp,Date dthrInicio, Boolean isParadaAutomatica,Boolean isParadaPersistente,Boolean isParPeriodSemConex) {
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_paradaInicio() para a UP " + idUp );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ParadaRN pRN = new ParadaRN(daoInjet,daoPdba);		
		IwsCicloDTO retorno = new IwsCicloDTO();
		try{
			pRN.iniciaConexaoBanco();
			retorno = pRN.setTr_paradaInicio(log, idLog, idUp, dthrInicio,  isParadaAutomatica, isParPeriodSemConex);
			if(retorno != null){
				pRN.setTr_UltimaParadaInicio(log, idLog, idUp, dthrInicio, isParadaPersistente);
			}else{
				retorno = new IwsCicloDTO();
				retorno.setCicloValido(false);
			}
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
			retorno.setCicloValido(false);
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
				
		log.info(idLog, 0,"Finalizando setTr_paradaInicio() para UP " + idUp );	
		daoPdba=null;
		daoInjet=null;
		return retorno;
	}
	
	public boolean setTr_paradaFim(String idUp, Date dthr) {
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_paradaFim() para a UP " + idUp );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ParadaRN pRN = new ParadaRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			pRN.iniciaConexaoBanco();
			retorno = pRN.setTr_paradaFim(log, idLog, idUp, dthr);
			if(retorno){
				retorno = pRN.setTr_UltimaParadaFim(log, idLog, idUp, dthr);			
			}
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
			retorno=false;
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
				
		log.info(idLog, 0,"Finalizando setTr_paradaFim() para UP " + idUp );	
		daoPdba=null;
		daoInjet=null;
		return retorno;
	}
	
	public boolean setTr_paradaMotivo(String idUp,Date dthr,String idParada,String idAcao,String idCausa,String idJustificativa,
			String idTecnicoResponsavel,String idTecnicoUm,String idTecnicoDois,String idLocal,boolean isParadaRegulagem,
			String tipoParPreConfig){
		return setTr_paradaMotivo( idUp, dthr, idParada, idAcao, idCausa, idJustificativa,
				 idTecnicoResponsavel, idTecnicoUm, idTecnicoDois, idLocal, isParadaRegulagem,
				 tipoParPreConfig,0);
		
	}
	
	public boolean setTr_paradaMotivo(String idUp,Date dthr,String idParada,String idAcao,String idCausa,String idJustificativa,
			String idTecnicoResponsavel,String idTecnicoUm,String idTecnicoDois,String idLocal,boolean isParadaRegulagem,
			String tipoParPreConfig,int batidas){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_paradaMotivo() para a UP " + idUp );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ParadaRN pRN = new ParadaRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			pRN.iniciaConexaoBanco();
			retorno = pRN.setTr_paradaMotivo(log, idLog, idUp, dthr, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm, idTecnicoDois,idLocal, tipoParPreConfig,null,batidas);
			
			if(retorno){
				retorno = pRN.setTr_UltimaParadaMotivo(log, idLog, idUp, idParada, idAcao, idCausa, idJustificativa, idTecnicoResponsavel, idTecnicoUm, idTecnicoDois,idLocal, isParadaRegulagem);			
			}
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
			retorno=false;
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
				
		log.info(idLog, 0,"Finalizando setTr_paradaMotivo() para UP " + idUp );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public IwsParadaDTO getTr_TabParadaSetaCod(String idUP, String cdParada){
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_TabParadaSetaCod() para a UP " + idUP + " e parada " + cdParada);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetParadaRN pRN = new InjetParadaRN(daoInjet,daoPdba);		
		IwsParadaDTO retorno = new IwsParadaDTO();
		try{
			if(IwsFacade.getInstancia().isCdParadaPadraoInjet()==true){
				cdParada = UtilRN.setZeroEsquerda(cdParada);
			}
			pRN.iniciaConexaoBanco();
			retorno=pRN.getTr_TabParadaSetaCod(log, idLog, idUP, cdParada);
		} catch (RegistroDesconhecidoException e) {
			// coloquei esse catch apenas para remover o printstacktrace para essa excessao
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando getTr_TabParadaSetaCod() para UP " + idUP + " e parada " + cdParada );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
		
	}
	
	public boolean validaCausa(String cdCausa){
		IdwLogger log = new IdwLogger("validaCausa");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando validaCausa() para a cdCausa " + cdCausa );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetInfoRN pRN = new InjetInfoRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			cdCausa = UtilRN.setZeroEsquerda(cdCausa);
			pRN.iniciaConexaoBanco();
			retorno = pRN.validaCausa(cdCausa);			
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando validaCausa() para a cdCausa " + cdCausa  );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public boolean validaAcao(String cdAcao){
		IdwLogger log = new IdwLogger("validaacao");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando validaAcao() para a cdAcao " + cdAcao );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetInfoRN pRN = new InjetInfoRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			cdAcao = UtilRN.setZeroEsquerda(cdAcao);
			pRN.iniciaConexaoBanco();
			retorno = pRN.validaAcao(cdAcao);			
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando validaAcao() para a cdAcao " + cdAcao  );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public boolean validaJustificativa(String cdJust){
		IdwLogger log = new IdwLogger("validaJustificativa");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando validaJustificativa() para a cdJust " + cdJust );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetInfoRN pRN = new InjetInfoRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			cdJust = UtilRN.setZeroEsquerda(cdJust);
			pRN.iniciaConexaoBanco();
			retorno = pRN.validaJustificativa(cdJust);			
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando validaJustificativa() para a cdJust " + cdJust  );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public boolean validaLocalParada(String cdLocal){
		IdwLogger log = new IdwLogger("calidaLocaParada");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando validaLocalParada() para a cdLocal " + cdLocal );
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetParadaRN pRN = new InjetParadaRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{
			cdLocal = UtilRN.setZeroEsquerda(cdLocal);
			pRN.iniciaConexaoBanco();
			retorno = pRN.validaLocalParada(cdLocal);			
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando validaLocalParada() para a cdLocal " + cdLocal  );	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public Boolean setTr_InsereAnotacaoParada(String idup,String anotacao,Date dthrEvento) {
		if (Stubdelegate.getInstancia().isInjetAtivo() == false)
			return false;
		
		IdwLogger log = new IdwLogger(idup);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_InsereAnotacaoParada() para idUP " + idup);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ParadaRN pRN = new ParadaRN(daoInjet,daoPdba);		
		boolean retorno = false;
		try{			
			pRN.iniciaConexaoBanco();
			retorno=pRN.setTr_InsereAnotacaoParada(log, idLog, idup, anotacao, dthrEvento);		
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_InsereAnotacaoParada() para idUP " + idup);	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public IwsCicloDTO setTr_CicloInicio(String idUp, Date dthr,String oInfo){
		IwsDadosApontamentoDTO dados = new IwsDadosApontamentoDTO();
		dados.setInfoAdicional(oInfo);
		dados.setBatidas(0);
		return setTr_CicloInicio(idUp, dthr,dados);
		
	}
	
	public IwsCicloDTO setTr_CicloInicio(String idUp, Date dthr,IwsDadosApontamentoDTO dados){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		// deu um erro de nullpointer qdo o evento veio da coleta discreta
		try {
			log.info(idLog, 0,"Iniciando setTr_CicloInicio() para Up " + idUp +"-"+dados.getInfoAdicional());
		} catch (NullPointerException e) {
			
		}
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ProducaoRN pRN = new ProducaoRN(daoInjet,daoPdba);		
		IwsCicloDTO retorno = null;
		try{			
			pRN.iniciaConexaoBanco();
			retorno = pRN.setTr_CicloInicio(log, idLog, idUp, dthr,dados);			
		} catch (Exception e){
			log.info("erro", e);
			retorno = new IwsCicloDTO();
			retorno.setCicloValido(false);
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
				// Se o idw estiver ativo entao atualizar o idEvtInicioCicloAnterior com o idEvtInicioCiclo
				if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					// Obtem o UPDTO a partir de idUp
					Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO().atualizarIdEvtInicioCicloAnteriorAoFlush();
				}
			} catch (Exception e2){
				// Se o idw estiver ativo entao atualizar o idEvtInicioCicloAnterior com o idEvtInicioCiclo
				if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					// Obtem o UPDTO a partir de idUp
					Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO().desfazerIdEvetInicioCiclo();
				}

				log.info("erro", e2);
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}
		try {
			log.info(idLog, 0,"Finalizando setTr_CicloInicio() para Up " + idUp +"-"+dados.getInfoAdicional());
		} catch (NullPointerException e) {
			
		}
		daoPdba=null;
		daoInjet=null;
		return retorno;	
	}
	
	public IwsReleDTO setTr_CicloFim(String idUp, Date dthr,IwsDadosApontamentoDTO dados) throws SemSGBDException {
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_CicloFim() para Up " + idUp + " dthr = " + dthr+"-");
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ProducaoRN pRN = new ProducaoRN(daoInjet,daoPdba);	
		InfoRN iRN;
		IwsReleDTO oRele8DTO = new IwsReleDTO();
		IwsCicloDTO dadosCiclo = new IwsCicloDTO();
		try{			
			pRN.iniciaConexaoBanco(log, idLog);
			dadosCiclo = pRN.setTr_CicloFim(log, idLog, idUp, dthr, dados);			
			iRN = new InfoRN(pRN.getDaoInjet(),pRN.getDaoPdba());	
			oRele8DTO = iRN.setTr_getRele8Ciclo(log, idLog, idUp);
			if(oRele8DTO == null){
				oRele8DTO = new IwsReleDTO();
				oRele8DTO.setINF01("0");
				oRele8DTO.setINF02("0");
				oRele8DTO.setINF03("0");
				oRele8DTO.setINF04("0");
				oRele8DTO.setINF05("0");
			}
			oRele8DTO.setDadosUltCiclo(dadosCiclo);
			oRele8DTO.seterro(false);
			
		} catch (Exception e){
			// Se o idw estiver ativo entao voltar idEvtInicioCiclo com o idEvtInicioCicloAnterior 
			if (IdwFacade.getInstancia().isIDWAtivo() == true) {
				log.info(idLog, 0, "desfazendo inicio do ciclo na memoria1");
				Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO().desfazerIdEvetInicioCiclo();
			}

			log.info("erro", e);
			dadosCiclo.setCicloValido(false);
			oRele8DTO.setDadosUltCiclo(dadosCiclo);
			oRele8DTO.seterro(true);
			throw new SemSGBDException();
		} finally {
			try{
				pRN.finalizaConexaoBanco(log, idLog);
				// Se o idw estiver ativo entao atualizar o idEvtInicioCicloAnterior com o idEvtInicioCiclo
				if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					// Obtem o UPDTO a partir de idUp
					Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO().atualizarIdEvtInicioCicloAnteriorAoFlush();
				}
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				// Se o idw estiver ativo entao voltar idEvtInicioCiclo com o idEvtInicioCicloAnterior 
				if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					log.info(idLog, 0, "desfazendo inicio do ciclo na memoria");
					Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO().desfazerIdEvetInicioCiclo();
				}

				throw new SemSGBDException();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_CicloFim() para Up " + idUp +"-");
//		iRN=null;
		pRN=null;
		daoPdba=null;
		daoInjet=null;
		return oRele8DTO;	
	}
	
	public IwsInspecaoManualDTO getTr_InspecaoManual(String cdMaquina,Date dthrEvento) {
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_InspecaoManual() para Maquina " + cdMaquina);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN iRN =new InfoRN(daoInjet,daoPdba);
		QualidadeRN qRN;		
		IwsInspecaoManualDTO retorno = new IwsInspecaoManualDTO();
		IwsErroDTO erro;
		try{
			iRN.iniciaConexaoBanco();			
			erro = iRN.setTr_buscaAleraProbQualiRet(log, idLog, cdMaquina);			
			if(erro.getSucesso() == true)
			{
				retorno.setErro(true);
				retorno.setIscomalertaprobqualidade(true);
				retorno.setMsgErro("Com alerta de prob. de Qualidade"); 
			}
			else
			{	
				qRN=new QualidadeRN(log, iRN.getDaoInjet(), iRN.getDaoPdba());
				retorno = qRN.getTr_InspecaoManual(cdMaquina, dthrEvento);				
			}
					
		} catch (Exception e){
			log.info("erro", e);
			retorno.setErro(true);
			retorno.setMsgErro("Erro no Tratamento");
			e.printStackTrace();
		} finally {
			try{
				iRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				iRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando getTr_InspecaoManual() para Maquina " + cdMaquina);
		daoPdba=null;
		daoInjet=null;
		return retorno;			
	}
	
	public boolean setTr_InspecaoManual(String idUp, Date dthrEvento,String cdProd,String dthrAlerta,String result){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_InspecaoManual() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		boolean retorno= false;
		try{
			infoRN.iniciaConexaoBanco();
			infoRN.setTr_InspecaoManual(log, idLog, idUp, dthrEvento, cdProd, dthrAlerta, result);
			retorno=true;
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_InspecaoManual() para UP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public Boolean setTr_ApontamentoAramado(String idUp, Date dthrEvento,String cdProd,String quantidade){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_ApontamentoAramado() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		boolean retorno= false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_ApontamentoAramado(log, idLog, idUp, dthrEvento,cdProd,quantidade);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_ApontamentoAramado() para UP " + idUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public boolean setTr_ApagaUltimoRefugo(String cdRefugo, String idRdzProduto, Date DthrUltRefugo, String milisec, String IdUp,Date DataHrAtual){
		IdwLogger log = new IdwLogger(IdUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_ApagaUltimoRefugo() para cdRefugo:" +cdRefugo+" idRdzProduto:" + idRdzProduto+" e idUP:" + IdUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		boolean retorno= false;
		try{
			infoRN.iniciaConexaoBanco();
			cdRefugo = UtilRN.setZeroEsquerda(cdRefugo);
			retorno = infoRN.setTr_ApagaUltimoRefugo(log, idLog, cdRefugo, idRdzProduto, DthrUltRefugo, milisec, IdUp,DataHrAtual);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_ApagaUltimoRefugo() para cdRefugo:" +cdRefugo+" idRdzProduto:" + idRdzProduto+" e idUP:" + IdUp);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public IwsRefugoDTO getInfoUltimoRefugo(String IdUp){
		IdwLogger log = new IdwLogger(IdUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getInfoUltimoRefugo() para idUP:" + IdUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		RefugoRN rRN = new RefugoRN(log,daoInjet,daoPdba);
		IwsRefugoDTO retorno= new IwsRefugoDTO();
		try{
			rRN.iniciaConexaoBanco();
			retorno = rRN.getInfoUltimoRefugo(IdUp);
		} catch (Exception e){
			log.info("erro", e);
			retorno.setIsRefugoValido(false);
			e.printStackTrace();
		} finally {
			try{
				rRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				rRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando getInfoUltimoRefugo() para idUP:" + IdUp);	
		daoPdba=null;
		daoInjet=null;
		rRN = null;
		return retorno;
	}
	
	public IwsRefugoDTO setTr_LancaEventoRefugo(String cdRefugo, String cdCausa, String cdAcao, String Quantidade,
			String IdUp, String idRdzProduto, Date DataHrAtual) {
		IdwLogger log = new IdwLogger(IdUp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_LancaEventoRefugo() para cdRefugo:" +cdRefugo+" Causa:" + cdCausa+" Acao:"+cdAcao+" Qtd:"+ Quantidade +" e idUP:" + IdUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		IwsRefugoDTO retorno= new IwsRefugoDTO();
		try{
			infoRN.iniciaConexaoBanco();
			if(cdCausa == null)	cdCausa = new String();
			if(cdAcao == null)	cdAcao = new String();
			
			cdRefugo = UtilRN.setZeroEsquerda(cdRefugo);
			cdCausa = UtilRN.setZeroEsquerda(cdCausa);
			cdAcao = UtilRN.setZeroEsquerda(cdAcao);
			retorno = infoRN.setTr_LancaEventoRefugo(log, idLog, cdRefugo,  cdCausa,  cdAcao, Quantidade, IdUp, idRdzProduto, DataHrAtual);
		} catch (Exception e){
			log.info("erro", e);
			retorno.setIsRefugoValido(false);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				infoRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_LancaEventoRefugo() para cdRefugo:" +cdRefugo);	
		daoPdba=null;
		daoInjet=null;
		infoRN = null;
		return retorno;
	}
	
	public IwsRefugoDTO setTr_LancaEventoRefugoComDefeitos(IwsRefugoComDefeitosDTO refugoComDefeitosDTO, Date dthrRefugo){
		IdwLogger log = new IdwLogger(refugoComDefeitosDTO.getIdUP());
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_LancaEventoRefugoComDefeitos() para " + refugoComDefeitosDTO.getIdUP());
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		RefugoRN rRN = new RefugoRN(log,daoInjet,daoPdba);
		IwsRefugoDTO retorno= new IwsRefugoDTO();
		try{
			rRN.iniciaConexaoBanco();			
			retorno = rRN.setTr_LancaEventoRefugoComDefeitos(refugoComDefeitosDTO, dthrRefugo);
		} catch (Exception e){
			log.info("erro", e);
			retorno.setIsRefugoValido(false);
			e.printStackTrace();
		} finally {
			try{
				rRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				rRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando setTr_LancaEventoRefugoComDefeitos() para " + refugoComDefeitosDTO.getIdUP());
		daoPdba=null;
		daoInjet=null;
		rRN = null;
		return retorno;
	}
	
	public IwsRefugoDTO getTr_TabValidaCodRefugo(String cdMaquina,String cdRefugo) {
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_TabValidaCodRefugo() para refugo " + cdRefugo);
		IwsRefugoDTO retorno= new IwsRefugoDTO();
		
		//1908 isSairAntecipadamente
		boolean isSairAntecipadamente = false;
		if(cdMaquina==null || cdRefugo==null){
			isSairAntecipadamente = true;
		}
		if( (cdMaquina!=null && cdMaquina.trim().equals("") ) || (cdRefugo!=null && cdRefugo.trim().equals(""))){
			isSairAntecipadamente = true;
		}
		if(isSairAntecipadamente){
			retorno.setIsRefugoValido(false);
			retorno.setIsRefugoValido(false);
			retorno.setCdRefugo("");
			retorno.setPedeCausa(false);
			retorno.setPedeAcao(false);
			if (cdRefugo==null){cdRefugo="";}
			if (cdMaquina==null){cdMaquina="";}
			log.info(idLog, 0,"Finalizando getTr_TabValidaCodRefugo() Prematuramente para refugo " + cdRefugo + " e maquina " + cdMaquina);
			return retorno;
		}


		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetRefugoRN rRN = new InjetRefugoRN(daoInjet);
		
		try{
			rRN.iniciaConexaoBanco();
			cdRefugo = UtilRN.setZeroEsquerda(cdRefugo);
			retorno = rRN.getTr_TabValidaCodRefugo(cdMaquina,cdRefugo);
		} catch (Exception e){
			log.info("erro", e);
			retorno.setIsRefugoValido(false);
			retorno.setIsRefugoValido(false);
			retorno.setCdRefugo("");
			retorno.setPedeCausa(false);
			retorno.setPedeAcao(false);
			e.printStackTrace();
		} finally {
			try{
				rRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				rRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando getTr_TabValidaCodRefugo() para refugo " + cdRefugo);
		daoInjet=null;
		rRN = null;
		return retorno;
	}	
	
	public IwsColetaDiscretaListaOPsDTO getTr_OPsEmAbertoMaquina(String idUP){
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_OPsEmAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN instanciaRN = new ColetaDiscretaOPsRN(log,daoInjet,daoPdba);
		IwsColetaDiscretaListaOPsDTO  retorno = new IwsColetaDiscretaListaOPsDTO();
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_OPsEmAbertoMaquina(idUP);

		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				e2.printStackTrace();
				instanciaRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getTr_OPsEmAbertoMaquina() para idUP " + idUP);

		daoPdba = null;
		daoInjet = null;
		instanciaRN = null;

		return(retorno);
	}	
	
	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO){
		IdwLogger log = new IdwLogger(barcodeDTO.getIdlinha());
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setRegistroBarCode() Linha:"+ barcodeDTO.getIdlinha() +" Barcode:"+ barcodeDTO.getBarcode() );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		boolean retorno = false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.setRegistroBarCode(barcodeDTO);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setRegistroBarCode()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public boolean setDadosColetados(injetws.webservices.dto.IwsDadosColetadosDTO dadosDTO){
		IdwLogger log = new IdwLogger(dadosDTO.getCdMaquina());
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setDadosColetados() cdMaquina: "+dadosDTO.getCdMaquina()+
				" Valor:"+ dadosDTO.getValorLido() +" tipo:"+ dadosDTO.getIdCaracteristica() );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		boolean retorno = false;
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.setDadosColetados(dadosDTO);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();		
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setDadosColetados()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public boolean setListaDadosColetados(IwsListaDadosColetadosDTO dadosDTO){
		IdwLogger log = new IdwLogger("setListaDaddosColetados");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando IwsListaDadosColetadosDTO()" );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		boolean retorno = false;
		try{
			infoRN.iniciaConexaoBanco();
			for(IwsDadosColetadosDTO inspec:dadosDTO.getInspecoes()){
				infoRN.setDadosColetados(inspec);				
			}
			retorno=true;
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();		
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando IwsListaDadosColetadosDTO()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	//add to ph
	public injetws.webservices.dto.IwsListaMatPrimaDTO getTr_integracaoMws(String nrOp){
		IwsListaMatPrimaDTO  retorno = null;
		IdwLogger log = new IdwLogger("OP=" + nrOp);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_integracaoMws - " + " nrOp: "  + nrOp);
		
		DAOGenericoTdba  daoTdba = new DAOGenericoTdba();
		DAOGenericoMws daoMws = new DAOGenericoMws();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ms.model.rn.importacao.mws.InfoRnMWS infoRN = new ms.model.rn.importacao.mws.InfoRnMWS(log, daoMws, daoTdba, daoInjet);
		try{
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.getTr_integracaoMws(nrOp);
		} catch(Exception e){
			log.info("erro", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			}catch(Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getTr_integracaoMws - " + " nrOp: "  + nrOp);
		daoInjet = null;
		daoTdba = null;
		daoMws = null;
		infoRN = null;
		return retorno;
	}
	
	public  IwsErroDTO setTr_integracaoMws(BigDecimal idRegistro, String codBarraLido){
		IwsErroDTO erro = new IwsErroDTO();
		IdwLogger log = new IdwLogger("setTr_integracaoMws");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_integracaoMws: " + "idRegistro: " + idRegistro.toString() + " - CodBarraLido: "+ codBarraLido);
		
		DAOGenericoTdba  daoTdba = new DAOGenericoTdba();
		DAOGenericoMws daoMws = new DAOGenericoMws();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ms.model.rn.importacao.mws.InfoRnMWS infoRN = new ms.model.rn.importacao.mws.InfoRnMWS(log, daoMws, daoTdba, daoInjet);

		try{

			infoRN.iniciaConexaoBanco();
			erro = infoRN.setTr_integracaoMws(idRegistro, codBarraLido);

		}catch(Exception e){
			log.info("erro", e);
			erro.setSucesso(false);
			e.printStackTrace();
		}finally{
			try{
				infoRN.finalizaConexaoBanco();
			}catch(Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando setTr_integracaoMws: " + "idRegistro: " + idRegistro.toString() + " - CodBarraLido: "+ codBarraLido);
		daoInjet = null;
		daoTdba = null;
		daoMws = null;
		infoRN = null;
		
		return erro;
	}
	
	public IwsErroDTO verificaSeJaEfetouPesagem(String idUP){
		IwsErroDTO erro = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando verificaSeJaEfetouPesagem, para Idup: " + idUP );
		
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);		
		try{
			infoRN.iniciaConexaoBanco();
			erro=infoRN.verificaSeJaEfetouPesagem(log, idLog, idUP);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando verificaSeJaEfetouPesagem, para Idup: " + idUP );
		daoInjet = null;
		daoPdba = null;
		infoRN = null;
		
		return erro;
		
	}

	public IwsErroDTO lancaPesagemAmericaTampas(String idUP, BigDecimal valor,Date dthr) {
		IwsErroDTO erro = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando lancaPesagemAmericaTampas, para Idup: " + idUP +"valor: " + valor.toString() );
		
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);		
		try{
			infoRN.iniciaConexaoBanco();
			erro=infoRN.lancaPesagemAmericaTampas(log, idLog, idUP,valor.setScale(3,RoundingMode.HALF_UP),dthr);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando lancaPesagemAmericaTampas, para Idup: " + idUP +"valor: " + valor.toString() );
		daoInjet = null;
		daoPdba = null;
		infoRN = null;
		
		return erro;
	}

	public IwsErroDTO lancaPerdaResinaAmericaTampas(String idUP,BigDecimal valor,Date dthr) {
		IwsErroDTO erro = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando lancaPerdaResinaAmericaTampas, para Idup: " + idUP +"valor: " + valor.toString() );
		
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();			;
			erro=infoRN.lancaPerdaResinaAmericaTampas(log, idLog, idUP,valor.setScale(2,RoundingMode.HALF_UP),dthr);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando lancaPerdaResinaAmericaTampas, para Idup: " + idUP +"valor: " + valor.toString() );
		daoInjet = null;
		daoPdba = null;
		infoRN = null;
		
		return erro;
	}
	
	public IwsErroDTO mudancaCavidadesAtivasNomolde(String idUP,int valor,Date dthr) {
		IwsErroDTO erro = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando mudancaCavidadesAtivasNomolde, para Idup: " + idUP +"valor: " + valor );
		
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();			
			erro=infoRN.mudancaCavidadesAtivasNomolde(log, idLog, idUP,valor,dthr);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando mudancaCavidadesAtivasNomolde, para Idup: " + idUP +"valor: " + valor );
		daoInjet = null;
		daoPdba = null;
		infoRN = null;
		
		return erro;
	}
	
	
	
	public IwsListaInspecoesAutoDTO obtemListaDeVariaveisParaAferir(String idUP) {
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info("Iniciando obtemListaDeVariaveisParaAferir() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN iRN = new InfoRN( daoInjet, daoPdba);
		IwsListaInspecoesAutoDTO retorno  = new IwsListaInspecoesAutoDTO();
		
		try{
			iRN.iniciaConexaoBanco();
			retorno = iRN.obtemListaDeVariaveisParaAferir(log, idLog, idUP);

		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();
			
		} finally {
			try{
				iRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				log.info("erro", e2);
				iRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando obtemListaDeVariaveisParaAferir() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		iRN = null;
		
		return retorno;
	}
	public IwsErroDTO setValidaPesagem(String idUP,IwsRegistroBarCodeDTO dadosDTO,String peso) {
		IwsErroDTO retorno = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando lancaCicloValidaPesagem() UP:"+ idUP +" Barcode:"+ dadosDTO.getBarcode()+" Peso:"+peso);
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.setValidaPesagem(idUP,dadosDTO,peso);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando lancaCicloValidaPesagem()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}	
	
	public IwsPesoProdutoDTO getPesoProduto(String idUP,String Cdprod){
		IwsPesoProdutoDTO retorno = new IwsPesoProdutoDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getPesoProduto() UP:"+ idUP +"CdProd:"+ Cdprod);
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.getPesoProduto(log,idLog,idUP,Cdprod);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getPesoProduto()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public IwsFitesaDTO getDadosFitesa(String ip){
		IwsFitesaDTO retorno = new IwsFitesaDTO();
		IdwLogger log = new IdwLogger("Fitesa");
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getDadosFitesa() IP:"+ip );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InjetInfoRN infoRN = new InjetInfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.getDadosFitesa(ip);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("erro", e2);
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getDadosFitesa()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public IwsDadosIHMBalancaDTO getTr_SincronizaIHMBalanca(String ip){
		IwsDadosIHMBalancaDTO retorno = new IwsDadosIHMBalancaDTO();
		//int idLog = log.getIdAleatorio();
		//log.info(idLog, 0,"Iniciando SincronizaIHMBalanca() IP:" + ip );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.SincronizaIHMBalanca(ip);
		} catch (Exception e){
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				infoRN.finalizaConexaoBanco();
			}
		}
		//log.info(idLog, 0,"Finalizando SincronizaIHMBalanca()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public IwsComplementaOP getTr_verificaSePedeComplemento(String idUP,String nrop){
		IwsComplementaOP retorno = new IwsComplementaOP();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_verificaSePedeComplemento() IP:" + idUP );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.getTr_verificaSePedeComplemento(idUP,nrop,log,idLog);
		} catch (Exception e){
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando getTr_verificaSePedeComplemento()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public IwsErroDTO lancaIncProdPlan(String idUP,int quantidade,Date dthrevt){
		IwsErroDTO retorno = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando lancaIncProdPlan() idUP:" + idUP );
		DAOGenericoInjet  daoInjet = new DAOGenericoInjet();
		DAOGenerico daoPdba =new DAOGenerico();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);
		try{
			infoRN.iniciaConexaoBanco();
			retorno=infoRN.lancaIncProdPlan(idUP,quantidade,dthrevt,log,idLog);
		} catch (Exception e){
			e.printStackTrace();			
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				infoRN.finalizaConexaoBanco();
			}
		}
		log.info(idLog, 0,"Finalizando lancaIncProdPlan()" );
		daoInjet = null;
		infoRN = null;
		return retorno;
	}
	
	public IwsErroDTO setTr_ApontaConsumoCCK(String idUP,Date dthrEvento,IwsDadosCCKDTO dadosCCK) {
		IwsErroDTO retorno = new IwsErroDTO();
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando setTr_ApontaConsumoCCK() UP:"+ idUP );
		
		try{
			MSBufferEventosFacade.getInstancia().lancaEventosCCKFromInjet(idUP, dthrEvento, dadosCCK,log);
		} catch (Exception e){
			log.info("erro", e);
			e.printStackTrace();			
		} 
		log.info(idLog, 0,"Finalizando setTr_ApontaConsumoCCK()" );
				
		return retorno;
	}

	public IwsParadaDTO getTr_TabParadaSetaAnotacao(String idUP,  IwsParadaDTO paradaDTO){
		IdwLogger log = new IdwLogger(idUP);
		int idLog = log.getIdAleatorio();
		log.info(idLog, 0,"Iniciando getTr_TabParadaSetaAnotacao() para a UP " + idUP + " e parada " + paradaDTO.getCdParada());
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetParadaRN pRN = new InjetParadaRN(daoInjet,daoPdba);		
		IwsParadaDTO retorno = new IwsParadaDTO();
		try{
			pRN.iniciaConexaoBanco();
			retorno = pRN.getTr_TabParadaSetaAnotacao(log, idLog, paradaDTO);
			
		} catch (RegistroDesconhecidoException e) {
			// coloquei esse catch apenas para remover o printstacktrace para essa excessao
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				pRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				pRN.finalizaConexaoBanco();
			}
		}		
		log.info(idLog, 0,"Finalizando getTr_TabParadaSetaAnotacao() para UP " + idUP + " e parada " + paradaDTO.getCdParada());	
		daoPdba=null;
		daoInjet=null;
		return retorno;	
		
	}
	
	public Integer getIdEmpresaInjet(){
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		DiversosInjetRN ijRN = new DiversosInjetRN(daoInjet);		
		Integer retorno = 0;
		
		try{
			ijRN.iniciaConexaoBanco();
			retorno = ijRN.getIdEmpresaInjet();
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				ijRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				ijRN.finalizaConexaoBanco();
			}
		}		
		daoInjet=null;
		return retorno;			
	}	

	public boolean setTr_InformaLote(String idUp, String lote, Date dataHrAtual){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_InformaLote() para idup " + idUp + " e lote: " + lote);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		boolean retorno = false;
		try{			
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_InformaLote(log, idLog, idUp, lote, dataHrAtual);

		}catch (RegistroDesconhecidoException e){
			// n�o faz nada deixa o retorno ser false;
		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();				
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando setTr_InformaLote() para idup " + idUp+ " e lote: " + lote);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_InformaLote() para idup " + idUp+ " e lote: " + lote);
		daoInjet=null;
		daoPdba=null;
		infoRN = null;

		return retorno;
	}

	public boolean setTr_FinalizaLote(String idUp, String lote, Date dataHrAtual){
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();

		log.info(idLog, 0,"Iniciando setTr_FinalizaLote() para idup " + idUp+ " e lote: " + lote);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InfoRN infoRN = new InfoRN(daoInjet,daoPdba);	
		boolean retorno = false;
		try{			
			infoRN.iniciaConexaoBanco();
			retorno = infoRN.setTr_FinalizaLote(log, idLog, idUp, lote, dataHrAtual);

		}catch (RegistroDesconhecidoException e){
			// n�o faz nada deixa o retorno ser false;
		}catch (Exception e){
			log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				infoRN.finalizaConexaoBanco();
			} catch (Exception e2){
				log.info("excessao", e2);
				e2.printStackTrace();				
				infoRN.finalizaConexaoBanco();
				log.info(idLog, 0,"Finalizando setTr_FinalizaLote() para idup " + idUp+ " e lote: " + lote);
			}
		}
		log.info(idLog, 0,"Finalizando setTr_FinalizaLote() para idup " + idUp+ " e lote: " + lote);
		daoInjet=null;
		daoPdba=null;
		infoRN = null;

		return retorno;
	}
	
	public boolean getTr_validaCodigoParada(String idUp, String idParada) {
		boolean retorno = false;
		IdwLogger log = new IdwLogger(idUp);
		int idLog = log.getIdAleatorio();
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetParadaRN injparRN = new InjetParadaRN(daoInjet, daoPdba);
		IwsParadaDTO paradadto = null;
		
		// Verifica se o motivo da parada, causa, acao, justificativa existem
		try{
			injparRN.iniciaConexaoBanco();
			paradadto = injparRN.validaApontamento(log, idLog, idUp, idParada, "", "", "", "", "", "", "");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
				injparRN.finalizaConexaoBanco();
			} catch (Exception e2){
				e2.printStackTrace();
				injparRN.finalizaConexaoBanco();
			}
		}	
		
		if(paradadto!=null) {
			retorno = true;
		}
		
		return retorno;
	}



	public void salvarConfigConcentrador(ConfiguracaoConcentrador configuracao) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DiversosInjetRN rn = new DiversosInjetRN(dao);
		
		try {
			rn.iniciaConexaoBanco();
			rn.salvarConfigConcentrador(configuracao);	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		rn = null;

		dao.finalizaSessao();
	}
}



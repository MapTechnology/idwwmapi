package injetws.model;


import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import injetws.model.rn.ModRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaLoginRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaOPsRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaOperacaoRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaParadasRN;
import injetws.model.rn.coletadiscreta.ColetaDiscretaProducaoRN;
import injetws.webservices.dto.IwsColetaDiscretaListaLoginsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaOPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaParadaEmAbertoDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaUPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaLoginDTO;
import injetws.webservices.dto.IwsColetaDiscretaOperacaoDTO;
import injetws.webservices.dto.IwsColetaDiscretaParadaEmAbertoDTO;

import java.util.Date;

public class IwsFacadeColetaDiscreta {
	
	private static IwsFacadeColetaDiscreta oIwsFacade = null;
	private IdwLogger log=null;	
	
	public IwsFacadeColetaDiscreta() {
		if(log==null)
			this.log = new IdwLogger("IwsFacadeColetaDiscreta");
	}	
	
	public static IwsFacadeColetaDiscreta getInstancia(){
		if (oIwsFacade == null) {			
				oIwsFacade = new IwsFacadeColetaDiscreta();			
		}
		return(oIwsFacade);
	}
	
	public static IdwLogger getLog(){
		return getInstancia().log;
	}
	
	public IwsColetaDiscretaOperacaoDTO getTr_RecuperaOperacao(String idUP, String cdOperacao, String tpFuncOperacao) {

		log.info("Iniciando getTr_RecuperaOperacao() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOperacaoRN instanciaRN = new ColetaDiscretaOperacaoRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaOperacaoDTO retorno = new IwsColetaDiscretaOperacaoDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);
			retorno = instanciaRN.getTr_RecuperaOperacao(idUP, cdOperacao, tpFuncOperacao);

		} catch (Exception e){
			e.printStackTrace(); 
						
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_RecuperaOperacao() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		return(retorno);
	}
	
	public boolean getTr_ExisteParadaEmAbertoMaquina(String idUP)  {

		log.info("Iniciando getTr_ExistemParadasEmAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_ExisteParadaEmAbertoMaquina(idUP);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ExistemParadasEmAbertoMaquina() para idup " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		return(retorno);

	}
	
	public boolean getTr_ParadaJaAbertaMaquina(String idUP, String cdOperacao) {

		log.info("Iniciando getTr_ParadaJaAbertaMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			retorno = instanciaRN.getTr_ParadaJaAbertaMaquina(idUP, cdOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ParadaJaAbertaMaquina() para idup " + idUP);
		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);

	}
	
	public IwsColetaDiscretaListaParadaEmAbertoDTO getTr_UPsComParadaEmAbertoOperacaoInformada(String mac, String cdOperacao)  {

		log.info("Iniciando getTr_UPsComParAbertoOperacaoInformada() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaParadaEmAbertoDTO retorno = new IwsColetaDiscretaListaParadaEmAbertoDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			retorno = instanciaRN.getTr_UPsComParadaEmAbertoOperacaoInformada(mac,cdOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Iniciando getTr_UPsComParAbertoOperacaoInformada() para mac " + mac);
		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		return(retorno);

	}

	public IwsColetaDiscretaListaOPsDTO getTr_UPsSemParadaEmAberto(String mac)  {

		log.info("Iniciando getTr_UPsSemParadaEmAberto() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaOPsDTO retorno = new IwsColetaDiscretaListaOPsDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_UPsSemParadaEmAberto(mac);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Iniciando getTr_UPsSemParadaEmAberto() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		return(retorno);

	}

	public IwsColetaDiscretaParadaEmAbertoDTO getTr_ParadaEmAbertoMaquina(String idUP, String idOPemAberto) {

		log.info("Iniciando getTr_paradaEmAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaParadaEmAbertoDTO retorno = new IwsColetaDiscretaParadaEmAbertoDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_ParadaEmAbertoMaquina(idUP, idOPemAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Iniciando getTr_paradaEmAbertoMaquina() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);

	}
	
	public boolean getTr_ExisteOPCarregadaMaquina(String idUP)  {

		log.info("Iniciando getTr_ExisteOPCarregadaMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN  instanciaRN = new ColetaDiscretaOPsRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_ExisteOPCarregadaMaquina(idUP);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ExisteOPCarregadaMaquina() para idup " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		return(retorno);
	}
	
	public boolean getTr_OpCarregadaEmMaquina(String idUP, String nrOPEstendido)  {

		log.info("Iniciando getTr_OpCarregadaEmMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN  instanciaRN = new ColetaDiscretaOPsRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_OpCarregadaEmMaquina(idUP, nrOPEstendido);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_OpCarregadaEmMaquina() para idup " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);
	}
		
	public double getTr_OPQtdUltApont(String idOPEmAberto)  {

		log.info("Iniciando getTr_OPQtdUltApont() para OP " + idOPEmAberto);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaProducaoRN  instanciaRN = new ColetaDiscretaProducaoRN(log, daoInjet, daoPdba);
		double retorno = 0;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_OPQtdUltApont(idOPEmAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Iniciando getTr_OPQtdUltApont() para OP " + idOPEmAberto);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);
	}
		
	public String getTr_ApontaRefugoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdRefugada){

		log.info("Iniciando getTr_ApontaRefugoColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaProducaoRN instanciaRN = new ColetaDiscretaProducaoRN(log, daoInjet, daoPdba);				
		String retorno = "";
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			retorno = instanciaRN.getTr_ApontaRefugoColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, qtdRefugada);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ApontaRefugoColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);
	}
	
	public String getTr_ValidacaoNovaOPColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao) {

		log.info("Iniciando getTr_ValidacaoNovaOPColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN instanciaRN = new ColetaDiscretaOPsRN(log, daoInjet, daoPdba);			
		String retorno = "";
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);
			retorno = instanciaRN.getTr_ValidacaoNovaOPColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ValidacaoNovaOPColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);
	}	
	
	public void setTr_ApontaProducaoColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String qtdApontada)  {

		log.info("Iniciando setTr_ApontaProducaoColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaProducaoRN instanciaRN = new ColetaDiscretaProducaoRN(log, daoInjet, daoPdba);		

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaProducaoColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, qtdApontada);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaProducaoColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}
	
	public void setTr_ApontaAbertParadaColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String idOPEmAberto) {
		log.info("Iniciando setTr_ApontaAbertParadaColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaAbertParadaColetaDiscreta(idUp, dthrEvento, nrOP, cdOperacao, idOPEmAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaAbertParadaColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}
	
	public void setTr_ApontaFechamParadaColetaDiscreta(String idUp, Date dthrEvento, Date dtHrIParada, String nrOP, String cdOperacao, String idOPEmAberto) {
		log.info("Iniciando setTr_ApontaFechamParadaColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaFechamParadaColetaDiscreta(idUp, dthrEvento, dtHrIParada, nrOP, cdOperacao, idOPEmAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaFechamParadaColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}	
	
	public void setTr_ApontaAbertLoginColetaDiscreta(String idUp, Date dthrEvento, String cdOperacao, String cdOperador) {
		log.info("Iniciando setTr_ApontaAbertLoginColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaAbertLoginColetaDiscreta(idUp, dthrEvento, cdOperacao, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaAbertLoginColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}	
	
	public void setTr_FechaLoginColetaDiscreta(String idUp, Date dthrEvento, Date dtHrLogin, String cdOperacao, String cdOperador, String idLoginEmAberto) {
		log.info("Iniciando setTr_FechaLoginColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_FechaLoginColetaDiscreta(idUp, dthrEvento, dtHrLogin, cdOperacao, cdOperador, idLoginEmAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_FechaLoginColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}	
	
	public void setTr_FechaOPColetaDiscreta(String idUp, Date dthrEvento, String nrOP, Date dthrIniPlan, String cdOperacao, String  tpFuncOperacao, String qtdApontada, String idOPEmAberto){
		log.info("Iniciando setTr_FechaOPColetaDiscreta() para idup " + idUp);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN instanciaRN = new ColetaDiscretaOPsRN(log, daoInjet, daoPdba);

		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_FechaOPColetaDiscreta(idUp, dthrEvento, nrOP, dthrIniPlan, cdOperacao, tpFuncOperacao, qtdApontada, idOPEmAberto);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_FechaOPColetaDiscreta() para idup " + idUp);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
	}	
	
	public IwsColetaDiscretaListaOPsDTO getTr_OPsEmAbertoMaquina(String idUP) {

		log.info("Iniciando getTr_OPsEmAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOPsRN instanciaRN = new ColetaDiscretaOPsRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaOPsDTO  retorno = new IwsColetaDiscretaListaOPsDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_OPsEmAbertoMaquina(idUP);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_OPsEmAbertoMaquina() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


		return(retorno);

	}	
	
	public void setTr_ApontaAberturaParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao)  {

		log.info("Iniciando setTr_ApontaAberturaParadaColetaDiscretaTodasUPs() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaAberturaParadaColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaAberturaParadaColetaDiscretaTodasUPs() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


	}	

	public void setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao)  {

		log.info("Iniciando setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaParadasRN instanciaRN = new ColetaDiscretaParadasRN(log, daoInjet, daoPdba);
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;


	}	

	public void setTr_ApontaAberturaLoginColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao, String cdOperador){
		log.info("Iniciando setTr_ApontaAberturaLoginColetaDiscretaTodasUPs() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaAberturaLoginColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaAberturaLoginColetaDiscretaTodasUPs() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

	}

	public void setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao, String cdOperador) {
		log.info("Iniciando setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			instanciaRN.setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs(mac, dthrEvento, cdOperacao, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

	}

	public boolean setTr_ExisteLoginAbertoMaquina(String idUP, String cdOperador) {
		log.info("Iniciando setTr_ExisteLoginAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.setTr_ExisteLoginAbertoMaquina(idUP, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando setTr_ExisteLoginAbertoMaquina() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;
	}

	public IwsColetaDiscretaListaLoginsDTO getTr_UPsComLoginAbertoOperadorInformado(String mac, String cdOperacao, String cdOperador) {
		log.info("Iniciando getTr_UPsComLoginAbertoOperadorInformado() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaLoginsDTO retorno = new IwsColetaDiscretaListaLoginsDTO() ;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			retorno = instanciaRN.getTr_UPsComLoginAbertoOperadorInformado(mac, cdOperacao, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_UPsComLoginAbertoOperadorInformado() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;
	}

	public IwsColetaDiscretaListaUPsDTO getTr_UPsSemLoginOperadorInformado(String mac, String cdOperador)  {
		log.info("Iniciando getTr_UPsSemLoginOperadorInformado() para mac " + mac);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaUPsDTO retorno = new IwsColetaDiscretaListaUPsDTO();
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_UPsSemLoginOperadorInformado(mac, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_UPsSemLoginOperadorInformado() para mac " + mac);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;
	}
	
	public IwsColetaDiscretaListaLoginsDTO getTr_LoginsAbertosUP(String idUP) {
		log.info("Iniciando getTr_LoginsAbertosUP() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaListaLoginsDTO retorno = null;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_LoginsAbertosUP(idUP);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_LoginsAbertosUP() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;
	}
	public String GetNomeOperador(String login, String idUP) 
	{
		log.info("Iniciando GetNomeOperador() para usuario " + login);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ModRN instanciaRN = new ModRN(daoInjet, daoPdba);
		String retorno = null;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			log.info("TODO: Obter o nome do Operador ");
			retorno = "";//instanciaRN.GetNomeOperador(login, idUP);// TODO: SENOJ GetNomeOperador(pruploginemaberto.getCdusuario(),idUP)

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando GetNomeOperador() para cdOperador " + login);

		daoPdba=null;
		instanciaRN = null;

		
		return retorno;
	}
	
	public IwsColetaDiscretaLoginDTO getTr_LoginAbertoMaquina(String idUP, String cdOperador) {
		log.info("Iniciando getTr_LoginAbertoMaquina() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaLoginRN instanciaRN = new ColetaDiscretaLoginRN(log, daoInjet, daoPdba);
		IwsColetaDiscretaLoginDTO retorno = new IwsColetaDiscretaLoginDTO();		
		try{
			instanciaRN.iniciaConexaoBanco();
			retorno = instanciaRN.getTr_LoginAbertoMaquina(idUP, cdOperador);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_LoginAbertoMaquina() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;
	}

	public boolean getTr_ExisteOperacao (String idUP, String cdOperacao, String tpFuncOperacao) {
		log.info("Iniciando getTr_ExisteOperacao() para idUP " + idUP);
		DAOGenerico daoPdba = new DAOGenerico();
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		ColetaDiscretaOperacaoRN instanciaRN = new ColetaDiscretaOperacaoRN(log, daoInjet, daoPdba);
		boolean retorno = false;
		
		try{
			instanciaRN.iniciaConexaoBanco();
			cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

			retorno = instanciaRN.getTr_ExisteOperacao(idUP, cdOperacao, tpFuncOperacao);

		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			try{
				instanciaRN.finalizaConexaoBanco();
				
			} catch (Exception e2){
				instanciaRN.finalizaConexaoBanco();
				e2.printStackTrace();				
			}
		}
		log.info("Finalizando getTr_ExisteOperacao() para idUP " + idUP);

		daoPdba=null;
		daoInjet=null;
		instanciaRN = null;

		
		return retorno;

	}
				
}



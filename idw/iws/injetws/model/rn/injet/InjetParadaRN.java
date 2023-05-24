package injetws.model.rn.injet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijgrpinjpar;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijtblocalparada;
import idw.model.pojos.injet.Ijtbpar;
import idw.model.pojos.injet.Ijtbpardefctrlipro;
import idw.model.pojos.injet.Ijtbpardefsemcon;
import idw.model.pojos.injet.Ijtbparintrasa;
import idw.util.IdwLogger;
import idw.webservices.rest.dto.monitorizacao.injet.bi.ProdutoBIDTO;
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrUp;
import injetws.model.rn.InfoRN;
import injetws.model.rn.UtilRN;
import injetws.webservices.dto.IwsParadaDTO;
import ms.model.dao.AbstractPdbaInjetDAO;
import ms.util.ConversaoTipos;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.SQLQuery;


public class InjetParadaRN extends AbstractPdbaInjetDAO{
	
	public InjetParadaRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	
	public IwsParadaDTO getTr_TabParadaSetaCod(IdwLogger log, int idLog, String idup, String cdParada) throws RegistroDesconhecidoException {
		
		if(cdParada == null)
			throw new RegistroDesconhecidoException();
		
		IwsParadaDTO oParadaDTO = new IwsParadaDTO();
		
		if(cdParada.equals("999999")) {
			
			oParadaDTO.setCdParada("999999");
			oParadaDTO.setDsParada("Parada nao informada");
			oParadaDTO.setIsRegulagem(false);
			oParadaDTO.setIsPodeAlterarCdPar(true);
			oParadaDTO.setIsPedeCausa(false);
			oParadaDTO.setIsPedeAcao(false);
			oParadaDTO.setIsPedeJust(false);
			oParadaDTO.setIsPedeLocal(false);
			oParadaDTO.setQtMinimaTecnicos(0);
			oParadaDTO.setIsTecnicoArea(false);	
			oParadaDTO.setIsPersistente(false);
			oParadaDTO.setIsPesaCalculo(false);
			oParadaDTO.setIsExcessoPesa(false);
			oParadaDTO.setIsParadaAutomatica(false);
			oParadaDTO.setIsPedeFechamento(true);
			oParadaDTO.setIsPeriodoSemConexao(false);
			oParadaDTO.setIsPedeAnotacao(false);
			oParadaDTO.setTxtAnotacao("");	
			
			return(oParadaDTO);
		}
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, idLog, idup);	
		
		MapQuery q = new MapQuery(getDaoInjet().getSession());
		boolean isOPCritica=false;
		if(prup.isSemPrograma==false){
			try{
				q.novaConsulta();
				q.append("from Ijop where nrop = :nrop and OPCritica = '1'");
				q.defineParametro("nrop", prup.getNrop());		
				q.setMaxResults(1);
				Ijop ijop =(Ijop)q.uniqueResult();
				if(ijop!=null)
					isOPCritica=true;
			}
			catch(Exception e){
				isOPCritica=false;
			}				
		}
		
		q.novaConsulta();
		q.append("FROM Ijgrpinjpar ijgrpinjpar ");
		q.append("WHERE ijgrpinjpar.id.cdinjetora = :cdinjetora "); 	
		q.defineParametro("cdinjetora", prup.getCdmaquina());
		q.setMaxResults(1);		
		Ijgrpinjpar oijgrpinjpar =(Ijgrpinjpar)q.uniqueResult();
		
		q.novaConsulta();
		if(oijgrpinjpar==null){
			q.append("FROM Ijtbpar ijtbpar "); 
			q.append("WHERE ijtbpar.cdparada = :cdParada ");			
		}else{
			q.append("SELECT DISTINCT ijtbpar FROM Ijtbpar ijtbpar, Ijgrpdetpar ijgrpdetpar, Ijgrpinjpar ijgrpinjpar "); 
			q.append("WHERE ijtbpar.cdparada = ijgrpdetpar.id.cdparada ");
			q.append("AND ijtbpar.cdparada = :cdParada ");
			q.append("AND ijgrpdetpar.id.cdgrupopar = ijgrpinjpar.id.cdgrupopar ");
			q.append("AND ijgrpinjpar.id.cdinjetora = :cdinjetora "); 	
		}
		q.append("AND (ijtbpar.teprogramado IS NULL or ijtbpar.teprogramado = 1 ) ");
		if(isOPCritica)
			q.append("AND ijtbpar.saidademolde = 1 ");	
		
		q.defineParametro("cdParada", cdParada);
		q.defineParametro("cdinjetora", prup.getCdmaquina());			
		q.setMaxResults(1);		
		Ijtbpar oIjtbpar =(Ijtbpar)q.uniqueResult();
		if(oIjtbpar==null)
			throw new RegistroDesconhecidoException();
		
		// no banco do injet, a tabela de parada eh do contra, se tiver em 0
		// eh pq ta selecionado e 1 esta nao selecionado
		
		oParadaDTO.setCdParada(oIjtbpar.getCdparada());
		oParadaDTO.setDsParada(oIjtbpar.getDsparada());
		
		if (oIjtbpar.getPermitecorrecao().intValue() == 0)
			oParadaDTO.setIsPodeAlterarCdPar(true);
		else
			oParadaDTO.setIsPodeAlterarCdPar(false);
		
		if (oIjtbpar.getRequercausa().intValue() == 0)
			oParadaDTO.setIsPedeCausa(true);
		else
			oParadaDTO.setIsPedeCausa(false);
		
		if (oIjtbpar.getRequeracao().intValue() == 0)
			oParadaDTO.setIsPedeAcao(true);
		else
			oParadaDTO.setIsPedeAcao(false);
		
		if (oIjtbpar.getRequerjustificativ().intValue() == 0)
			oParadaDTO.setIsPedeJust(true);
		else
			oParadaDTO.setIsPedeJust(false);
		
		int qtMinTec = 0;
		if (oIjtbpar.getPededrttecnico1().intValue() == 0) qtMinTec++;
		if (oIjtbpar.getPededrttecnico2().intValue() == 0) qtMinTec+=2;
		
		oParadaDTO.setQtMinimaTecnicos(qtMinTec);
		
		if (oIjtbpar.getPededrtresponsa().intValue() == 0)
			oParadaDTO.setIsTecnicoArea(true);
		else
			oParadaDTO.setIsTecnicoArea(false);
		
		// Verifica se a parada eh do tipo de regulagem
		if (oIjtbpar.getRequercancelamento().intValue() == 0)
			oParadaDTO.setIsRegulagem(true);
		else
			oParadaDTO.setIsRegulagem(false);
		
		if (oIjtbpar.getParadapersistente() == '0')
			oParadaDTO.setIsPersistente(false);
		else
			oParadaDTO.setIsPersistente(true);
		
		// Verifica se a parada pesa na efici�ncia
		if(oIjtbpar.getSaidademolde().intValue() == 0)
			oParadaDTO.setIsPesaCalculo(true);
		else
			oParadaDTO.setIsPesaCalculo(false);
		
		oParadaDTO.setIsExcessoPesa(false);
		oParadaDTO.setIsParadaAutomatica(false);
		oParadaDTO.setIsPedeFechamento(true);
		
		q.novaConsulta();
		q.append("from Ijtbparintrasa ijtbparintrasa where ijtbparintrasa.cdparada = :cdParada");
		q.defineParametro("cdParada", cdParada);
		q.setMaxResults(1);
		Ijtbparintrasa oIjtbparIntRasa =(Ijtbparintrasa)q.uniqueResult();	
		if(oIjtbparIntRasa != null){
			oParadaDTO.setIsPedeLocal(oIjtbparIntRasa.getLocalparada() == '1' ? true : false);
			oParadaDTO.setIsPeriodoSemConexao(oIjtbparIntRasa.getSemconexao() == '1' ? true : false);
		}
		
		return(oParadaDTO);
	}	

	public Boolean validaLocalParada(String cdLocal){
		boolean retorno = false;
		cdLocal = UtilRN.getCodigoPadraoInjet(cdLocal);
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtblocalparada ijtblocal ");
		q.append("where (Ijtblocalparada.cdlocalparada = :cdLocal) and (Ijtblocalparada.stativo = '1')");
		q.defineParametro("cdLocal", cdLocal);
		q.setMaxResults(1);
				
		Ijtblocalparada oijtblocal = (Ijtblocalparada)q.uniqueResult();
		if(oijtblocal!=null)			
				retorno = true;
			
		return retorno;	
	}	
	
	public IwsParadaDTO validaApontamento(
			IdwLogger log, int idLog,
			String idUp,String cdParada,String cdCausa,String cdAcao,String cdJustificativa,
			String cdTecnicoUm, String cdTecnicoDois, String cdTecnicoResponsavel,String cdLocal){
		IwsParadaDTO retorno=null;
		if (cdParada != null && !cdParada.equals("")){
			if(IwsFacade.getInstancia().isCdParadaPadraoInjet()==true){
				cdParada = UtilRN.getCodigoPadraoInjet(cdParada);
			}
			try {
				retorno=getTr_TabParadaSetaCod(log, idLog, idUp, cdParada);
			} catch (RegistroDesconhecidoException e) {
				return null;
			}
		}
		
		InjetInfoRN iInfoRN = new InjetInfoRN(getDaoInjet(),getDaoPdba());
		
		// pesquisa causa
		if (cdCausa != null && !cdCausa.equals("")  && !cdCausa.equals(" ") && iInfoRN.validaCausa(cdCausa) == false)
			return null;
		if (cdAcao != null && !cdAcao.equals("")  && !cdAcao.equals(" ") && iInfoRN.validaAcao(cdAcao) == false)
			return null;
		if (cdJustificativa != null && !cdJustificativa.equals("") && !cdJustificativa.equals(" ") && iInfoRN.validaJustificativa(cdJustificativa) == false)
			return null;			
		if (cdLocal != null && !cdLocal.equals("")  && !cdLocal.equals(" ") && validaLocalParada(cdLocal)== false)
			return null;
		
		return retorno;
		
	}
	
	public String getTr_ParDefSemConexao(){
		String retorno=null;
		
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtbpardefsemcon ijtbpardefsemcon ");
		q.setMaxResults(1);
				
		Ijtbpardefsemcon oijtb = (Ijtbpardefsemcon)q.uniqueResult();
		if(oijtb!=null && oijtb.getCdparada()!=null){
			if(IwsFacade.getInstancia().isCdParadaPadraoInjet()==true){
				retorno = UtilRN.getCodigoPadraoInjet(oijtb.getCdparada());	
			}
			else{
				retorno=oijtb.getCdparada();
			}
		}	
		return retorno;
	}
	
	public String getTr_ParaDefCtrlIniProc(){
		String retorno=null;
		
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("from Ijtbpardefctrlipro ijtbpar ");
		q.setMaxResults(1);
				
		Ijtbpardefctrlipro oijtb = (Ijtbpardefctrlipro)q.uniqueResult();
		if(oijtb!=null && oijtb.getCdparada()!=null){
			if(IwsFacade.getInstancia().isCdParadaPadraoInjet()==true){
				retorno = UtilRN.getCodigoPadraoInjet(oijtb.getCdparada());	
			}
			else{
				retorno = oijtb.getCdparada();
			}
		}	
		return retorno;
	}

	public IwsParadaDTO getTr_TabParadaSetaAnotacao(IdwLogger log, int idLog, IwsParadaDTO paradaDTO) throws RegistroDesconhecidoException {
		String strSQL = "SELECT a.paradamanut FROM ijtbparManut a WHERE a.cdparada = '" + paradaDTO.getCdParada() + "'";
		SQLQuery q = getDaoInjet().getSession().createSQLQuery(strSQL);
		q.setMaxResults(1);
		Integer isPedeAnotacao = (Integer) q.uniqueResult();
				
		if (isPedeAnotacao != null) {
			paradaDTO.setIsPedeAnotacao(isPedeAnotacao.intValue() == 1 ? true : false);
		}
		
		return paradaDTO;
	}	
	
}

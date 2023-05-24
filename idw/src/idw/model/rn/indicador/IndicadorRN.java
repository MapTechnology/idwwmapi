package idw.model.rn.indicador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmCfgindDAO;
import idw.model.dao.OmIndgtDAO;
import idw.model.dao.OmIndptDAO;
import idw.model.dao.OmIndtpptDAO;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmIndgt;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.OmIndTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.rn.AbstractRN;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroIndCfg;
import idw.webservices.dto.IndicadorMinMetaMaxDTO;
import idw.webservices.dto.IndicadoresMinMetaMaxDTO;

public class IndicadorRN extends AbstractRN<DAOGenerico>{

	public IndicadorRN(){
		this(null);
	}
	
	public IndicadorRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public IndicadoresMinMetaMaxDTO buscaIndicadoresMinMetaMax(FiltroIndCfg filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "IndicadorRN.buscaIndicadoresMinMetaMax");
		log.info( idLog , 0, "IndicadorRN.buscaIndicadoresMinMetaMax filtro usado:" + filtro.toString());
		
		IndicadoresMinMetaMaxDTO retorno = new IndicadoresMinMetaMaxDTO();
		
		retorno.setListaIndicadorMinMetaMexDTOs(new ArrayList<IndicadorMinMetaMaxDTO>());
		
		List<OmIndpt> listaIndPts = buscaIndicadorMinMetaMaxPorPt(filtro.getOmPt());
		List<OmIndgt> listaIndGts = buscaIndicadorMinMetaMaxPorGt(filtro.getOmGt());
		List<OmCfgind> listaIndCfgs = buscaIndicadorMinMetaMaxPorCfg();
		
		Set<OmInd> listaIndicadoresIncluidos = new HashSet<OmInd>();
		
		if(!listaIndPts.isEmpty()){
			for(OmIndpt indPt : listaIndPts){
				if(!listaIndicadoresIncluidos.contains(indPt.getOmInd())){
					IndicadorMinMetaMaxDTO indicador = new IndicadorMinMetaMaxDTO(
							indPt.getOmInd().clone(false), indPt.getIndInferior(), 
							indPt.getIndSuperior(), indPt.getIndMeta());
					retorno.getListaIndicadorMinMetaMexDTOs().add(indicador);
					listaIndicadoresIncluidos.add(indPt.getOmInd());
				}
			}
		}

		if(!listaIndGts.isEmpty()){
			for(OmIndgt indGt : listaIndGts){
				if(!listaIndicadoresIncluidos.contains(indGt.getOmInd())){
					IndicadorMinMetaMaxDTO indicador = new IndicadorMinMetaMaxDTO(
							indGt.getOmInd().clone(false), indGt.getNumInf(), 
							indGt.getNumSuperior(), indGt.getNumMeta());
					retorno.getListaIndicadorMinMetaMexDTOs().add(indicador);
					listaIndicadoresIncluidos.add(indGt.getOmInd());
				}
			}
		}
		
		if(!listaIndCfgs.isEmpty()){
			for(OmCfgind indCfg : listaIndCfgs){
				if(!listaIndicadoresIncluidos.contains(indCfg.getOmInd())){
					IndicadorMinMetaMaxDTO indicador = new IndicadorMinMetaMaxDTO(
							indCfg.getOmInd().clone(false), indCfg.getIndInferior(), 
							indCfg.getIndSuperior(), indCfg.getIndMeta());
					retorno.getListaIndicadorMinMetaMexDTOs().add(indicador);
					listaIndicadoresIncluidos.add(indCfg.getOmInd());
				}
			}
		}
		log.mostrarAvaliacaoCompleta();
		return retorno;	
	}
	
	public List<OmIndpt> buscaIndicadorMinMetaMaxPorPt(OmPt pt){
		MapQuery q = new MapQuery(this.getDao().getSession());		
		q.append("select i ");
		q.append("from OmIndpt i ");
		q.append("where i.omPt = :pt ");
		
		q.defineParametro("pt", pt);
		List<OmIndpt> listaIndPts = q.list();
		
		return listaIndPts;
	}
	
	public List<OmIndgt> buscaIndicadorMinMetaMaxPorGt(OmGt gt){
		MapQuery q = new MapQuery(this.getDao().getSession());		
		q.append("select i ");
		q.append("from OmIndgt i ");
		q.append("where i.omGt = :gt ");
		
		q.defineParametro("gt", gt);		
		List<OmIndgt> listaIndGts = q.list();
		
		return listaIndGts;
	}
	
	public List<OmCfgind> buscaIndicadorMinMetaMaxPorCfg(){
		MapQuery q = new MapQuery(this.getDao().getSession());		
		q.append("select i ");
		q.append("from OmCfgind i ");
		
		List<OmCfgind> listaCfgInds = q.list();
		
		return listaCfgInds;
	}
	
	public IndicadorMinMetaMaxDTO buscarIndicadorMinMetaMaxDTOPorPtOuTpptOuGtOuCfg(OmGt omGt, OmPt omPt, OmTpptTemplate.Type tipoTppt, OmIndTemplate.Tipo tipoInd){
		
		if(omPt != null){
			OmIndptDAO omIndptDAO = new OmIndptDAO(getDaoSession());		
			OmIndpt omIndpt = omIndptDAO.getOmIndpt(tipoInd, omPt.getCdPt());
			if(omIndpt != null){
				return new IndicadorMinMetaMaxDTO(omIndpt.getOmInd().clone(false), omIndpt);
			}
		}
		
		if(tipoTppt != null){
			OmIndtpptDAO omIndtpptDAO = new OmIndtpptDAO(getDaoSession());		
			OmIndtppt omIndtppt = omIndtpptDAO.getOmIndtppt(tipoInd, tipoTppt);		
			if(omIndtppt != null){
				return new IndicadorMinMetaMaxDTO(omIndtppt.getOmInd().clone(false), omIndtppt);
			}		
				
		}		
		
		if(omGt != null){
			OmIndgtDAO omIndgtDAO = new OmIndgtDAO(getDaoSession());		
			OmIndgt omIndgt = omIndgtDAO.getOmIndGt(tipoInd, omGt.getCdGt());
			if(omIndgt != null){
				return new IndicadorMinMetaMaxDTO(omIndgt.getOmInd().clone(false), omIndgt);
			}		
		}
		
		OmCfgindDAO omCfgindDAO = new OmCfgindDAO(getDaoSession());		
		OmCfgind omCfgInd = omCfgindDAO.getOmCfgind(tipoInd);
		if(omCfgInd != null){
			return new IndicadorMinMetaMaxDTO(omCfgInd.getOmInd().clone(false), omCfgInd);
		}		
		
		return null;
	}
	
	public IndicadorValorDTO getIndicadorPorId(Long id){
		MapQuery q = new MapQuery(this.getDao().getSession());		
		q.append("SELECT i ");
		q.append("FROM OmInd i ");
		q.append("WHERE i.idInd = :id");
		q.defineParametro("id", id);
		OmInd ind = (OmInd) q.uniqueResult();
		IndicadorValorDTO dto = new IndicadorValorDTO();
		dto.setOmInd(ind.clone());
		return dto;
	}
}

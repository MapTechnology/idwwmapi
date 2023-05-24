package idw.model.rn.monitorizacao.injet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmInd;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.webservices.dto.DetalheAnaliseTurnoDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.IndicadoresDTO;
import idw.webservices.dto.ListaDetalheAnaliseTurnoDTO;

public class AnaliseTurnoInjetRN extends DetalheMonitorizacaoPTInjetRN{

	public AnaliseTurnoInjetRN() {
		super();
	}


	public AnaliseTurnoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}


	/**
	 * @param FiltroAnaliseTurnoDTO
	 * @return ListaDetalheAnaliseTurnoDTO
	 */
	public ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurno(FiltroProducaoDTO filtro) {

		ListaDetalheAnaliseTurnoDTO retorno = new ListaDetalheAnaliseTurnoDTO();
		byte tpId = DwConsolidTemplate.TpId.TURNO.getValue();

		try {
			List<DwConsolid> listadwconsolid = getDwConsolid(
					null, tpId, 
					filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,null, null , null, 
					true, false, 
					0, filtro.getOmGt(), filtro.getListaFiltroProducaoPtCp());
			
			if (listadwconsolid != null) {
				retorno = preecheValoresAnaliseTurno(listadwconsolid);
			} else {
				retorno = new ListaDetalheAnaliseTurnoDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setAnaliseTurnoPorMaquina(null);
			return retorno;
		}
		return retorno;
	}

	
	/***
	 * @param listaDwConsolid
	 * @return ListaDetalheAnaliseTurnoDTO
	 */
	private ListaDetalheAnaliseTurnoDTO preecheValoresAnaliseTurno(List<DwConsolid> listaDwConsolid) {
		ListaDetalheAnaliseTurnoDTO retorno = new ListaDetalheAnaliseTurnoDTO();
		retorno.setAnaliseTurnoPorMaquina(new ArrayList<DetalheAnaliseTurnoDTO>());
		retorno.setAnaliseTurnoTodasMaquinas(new DetalheAnaliseTurnoDTO());
		retorno.getAnaliseTurnoTodasMaquinas().setIndicadoresDTO(new IndicadoresDTO());

		
		MonitorizacaoInjetRN rnM = new MonitorizacaoInjetRN();
		List<OmInd> listaCfgInd = rnM.getCfgIndInjet(getDao());		

		OmCfg omcfg = new OmCfg();
		omcfg.setOmCfginds(new HashSet<OmCfgind>());
		
		for (OmInd ind : listaCfgInd) {
			OmCfgind cfgInd = ind.getOmCfginds().iterator().next();
			omcfg.getOmCfginds().add(cfgInd);
		}
		
		
		Map<OmPt, IndicadoresDTO> indicadoresPorMaquina = new HashMap<OmPt, IndicadoresDTO>();
		
		OmPt omptReferencia = null;
		for (DwConsolid dwci : listaDwConsolid) {
			omptReferencia = dwci.getOmPt();

			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();
			
			retorno.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO().getAgrupador().add(dwci, omcfg, daoVF);
			IndicadoresDTO indMaq = indicadoresPorMaquina.get(dwci.getOmPt());
			if (indMaq == null) {
				indMaq = new IndicadoresDTO();
				indicadoresPorMaquina.put(dwci.getOmPt(), indMaq);
			}
			
			indMaq.setEficienciaInstantanea(pegaEficienciaInstantanea(dwci.getOmPt(), dwci.getPpCp()));
			indMaq.getAgrupador().add(dwci, omcfg, daoVF);
			
			daoVF.finalizaSessao();
		}
		retorno.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO().getAgrupador().resultMerge(omcfg, omptReferencia);

		for (Iterator<OmPt> iterator = indicadoresPorMaquina.keySet().iterator(); iterator.hasNext();) {
			OmPt pt = iterator.next();
			IndicadoresDTO indicadorPorMaquina = indicadoresPorMaquina.get(pt);
			indicadorPorMaquina.getAgrupador().resultMerge(omcfg, pt);
			DetalheAnaliseTurnoDTO detalhePorMaquina = new DetalheAnaliseTurnoDTO();
			detalhePorMaquina.setOmPt(pt.clone(false));
			detalhePorMaquina.setIndicadoresDTO(indicadorPorMaquina);
			retorno.getAnaliseTurnoPorMaquina().add(detalhePorMaquina);
		}

		return retorno;
	}


}

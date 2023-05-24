package idw.model.rn.analiseturno;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.Util;
import idw.webservices.dto.DetalheAnaliseTurnoDTO;
import idw.webservices.dto.DetalheAnaliseTurnoGtDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.IndicadoresDTO;
import idw.webservices.dto.ListaDetalheAnaliseTurnoDTO;

public class AnaliseTurnoRN extends DetalheMonitorizacaoPTInsertRN{

	public AnaliseTurnoRN() {
		super();
	}


	public AnaliseTurnoRN(DAOGenerico dao) {
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
					filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,
					null, null , null, 
					null, null, true, false, false,
					0, filtro.getOmGt(), filtro.getListaFiltroProducaoPtCp(), false, false, false);
			
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
	
	public ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurnoPorGt(FiltroProducaoDTO filtro) {

		ListaDetalheAnaliseTurnoDTO retorno = new ListaDetalheAnaliseTurnoDTO();
		byte tpId = DwConsolidTemplate.TpId.TURNO.getValue();

		try {
			List<DwConsolid> listadwconsolid = getDwConsolid(
					null, tpId, 
					filtro.getDwTurno(), null, null, filtro.getDtReferencia(), null,
					null, null , null, 
					null, null, true, false, false,
					0, filtro.getOmGt(), null, false, false, false);
			
			if (listadwconsolid != null) {
				retorno = preecheValoresAnaliseTurnoPorGt(listadwconsolid);
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
	
	public ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurnoPorGt(DwTurno turno, Date dtReferencia, List<Long> idGts) {

		ListaDetalheAnaliseTurnoDTO retorno = new ListaDetalheAnaliseTurnoDTO();
		byte tpId = DwConsolidTemplate.TpId.TURNO.getValue();
		
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());

		try {
			List<DwConsolid> listadwconsolid = new ArrayList<DwConsolid>();
			for(Long idGt : idGts) {
				OmGt omGt = omGtDAO.getOmGtPorId(idGt);
				
				listadwconsolid.addAll(getDwConsolid(
						null, tpId, 
						turno, null, null, dtReferencia, null,
						null, null , null, 
						null, null, true, false, false,
						0, omGt, null, false, false, false));
			}
			if (listadwconsolid.size() > 0) {
				retorno = preecheValoresAnaliseTurnoPorGt(listadwconsolid);
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
		retorno.setAnaliseTurnoPorGt(new ArrayList<DetalheAnaliseTurnoGtDTO>());

		Map<OmPt, IndicadoresDTO> indicadoresPorMaquina = new HashMap<OmPt, IndicadoresDTO>();
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		OmPt omptReferencia = null;
		for (DwConsolid dwci : listaDwConsolid) {
			omptReferencia = dwci.getOmPt();
			retorno.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO().getAgrupador().add(dwci, omcfg, getDao());
			IndicadoresDTO indMaq = indicadoresPorMaquina.get(dwci.getOmPt());
			if (indMaq == null) {
				indMaq = new IndicadoresDTO();
				indicadoresPorMaquina.put(dwci.getOmPt(), indMaq);
			}
			
			indMaq.setEficienciaInstantanea(pegaEficienciaInstantanea(dwci.getOmPt()));
			indMaq.getAgrupador().add(dwci, omcfg, getDao());
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
	
	private ListaDetalheAnaliseTurnoDTO preecheValoresAnaliseTurnoPorGt(List<DwConsolid> listaDwConsolid) {
		ListaDetalheAnaliseTurnoDTO retorno = new ListaDetalheAnaliseTurnoDTO();

		retorno.setAnaliseTurnoPorMaquina(new ArrayList<DetalheAnaliseTurnoDTO>());
		retorno.setAnaliseTurnoTodasMaquinas(new DetalheAnaliseTurnoDTO());
		retorno.getAnaliseTurnoTodasMaquinas().setIndicadoresDTO(new IndicadoresDTO());
		retorno.setAnaliseTurnoPorGt(new ArrayList<DetalheAnaliseTurnoGtDTO>());

		Map<OmGt, IndicadoresDTO> indicadoresPorGt = new HashMap<OmGt, IndicadoresDTO>();
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		OmGt gt = null;
		for (DwConsolid dwci : listaDwConsolid) {
			gt = dwci.getOmPt().getOmObjs().iterator().next().getOmGtByIdGt();
			retorno.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO().getAgrupador().add(dwci, omcfg, getDao());
			IndicadoresDTO indicadorGt = indicadoresPorGt.get(gt);
			if (indicadorGt == null) {
				indicadorGt = new IndicadoresDTO();
				indicadoresPorGt.put(gt, indicadorGt);
			}
			
			// indicadoresGt.setEficienciaInstantanea(pegaEficienciaInstantanea(dwci.getOmPt()));
			indicadorGt.getAgrupador().add(dwci, omcfg, getDao());
		}
		
		retorno.getAnaliseTurnoTodasMaquinas().getIndicadoresDTO().getAgrupador().resultMerge(omcfg, null);

		for (Iterator<OmGt> iterator = indicadoresPorGt.keySet().iterator(); iterator.hasNext();) {
			OmGt i = iterator.next();
			IndicadoresDTO indicador = indicadoresPorGt.get(i);
			indicador.getAgrupador().resultMerge(omcfg, null);
			DetalheAnaliseTurnoGtDTO detalhePorGt = new DetalheAnaliseTurnoGtDTO();
			detalhePorGt.setOmGt(i.clone(false));
			detalhePorGt.setIndicadoresDTO(indicador);
			retorno.getAnaliseTurnoPorGt().add(detalhePorGt);
		}

		return retorno;
	}


}

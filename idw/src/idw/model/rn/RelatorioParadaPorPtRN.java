package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DetalheMonitorizacaoPTInjetDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.ItemParadaPorPtDTO;
import idw.webservices.dto.ParadaRelatorioDTO;
import idw.webservices.dto.RelatorioIndiceParadaPtDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import ms.util.ConversaoTipos;

public class RelatorioParadaPorPtRN extends AbstractRN<DAOGenerico> {
	
	private List<Object> listaFiltroArea = new ArrayList<Object>();
	private List<Object> listaFiltroParada = new ArrayList<Object>();
	private BigDecimal segHrsProdutivasTotal =  BigDecimal.ZERO;
	
	public RelatorioParadaPorPtRN() {
		this(null);
	}

	public RelatorioParadaPorPtRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioIndiceParadaPtDTO getDadosRelatorioParadasPorMaquina(FiltroRelatorioIndiceParadasDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioParadaPorPtRN.getDadosRelatorioParadasPorMaquina");
		log.info( idLog , 0, "RelatorioParadaPorPtRN.getDadosRelatorioParadasPorMaquina filtro usado:" + filtro.toString());
		
		preencherListaDeFiltros(filtro);
		
		Map<String, TemposResumo> temposMaquinas = getTemposMaquina2(filtro);
		
		List<DwConsolpa> listaConsolpa = getListaDwConsolpa(filtro);
		
		RelatorioIndiceParadaPtDTO retorno = montaEstrututaRelatorioParadasPorMaquina(listaConsolpa, temposMaquinas);
		
		log.mostrarAvaliacaoCompleta();
		
		return retorno; // montaEstrututaRelatorioParadasPorMaquina(listaConsolpa, temposMaquinas);
	
	}
	
	private void preencherListaDeFiltros(FiltroRelatorioIndiceParadasDTO filtro) {
		listaFiltroArea = new ArrayList<Object>();
		listaFiltroParada = new ArrayList<Object>();
		
		boolean isGerarListaFiltroTodasAsParadas = 
				filtro.getIsTodasParadas() == false 
				&& filtro.getDwTParadas() != null;
		if(isGerarListaFiltroTodasAsParadas) {
			for(DwTParada parada : filtro.getDwTParadas()) {
				this.listaFiltroParada.add(parada.getCdTparada());
			}
		}
		
		boolean isGerarListaFiltroTodasAsAreas = 
				filtro.getIsTodasAreas() == false 
				&& filtro.getDwTAreas() != null;
		if(isGerarListaFiltroTodasAsAreas) {
			for(DwTArea area : filtro.getDwTAreas()) {
				this.listaFiltroArea.add(area.getCdArea());
			}
		}
	}
	
	class TemposResumo {
		BigDecimal hrsProdutivas  = BigDecimal.ZERO;
		BigDecimal hrsDisponiveis = BigDecimal.ZERO;
	}
	
	//Marcos Sardinha: 2017-09-15 >>Defeito #4385
	private TemposResumo getTempoMaq(Map<String, TemposResumo> mapTempoAtivoMaq, String cdPt) {
		TemposResumo totais = new TemposResumo();
		totais = mapTempoAtivoMaq.get(cdPt);
		return totais;
	}
	
	//Marcos Sardinha: 2017-09-15 >> Defeito #4385
	private TemposResumo getTempoTotal(Map<String, TemposResumo> mapTempoAtivoMaq) {
		TemposResumo totais = new TemposResumo();

		Set<String> keysPT = mapTempoAtivoMaq.keySet();
		for(String pt : keysPT) {
			totais.hrsProdutivas = segHrsProdutivasTotal;
			totais.hrsDisponiveis = totais.hrsDisponiveis.add(mapTempoAtivoMaq.get(pt).hrsDisponiveis);
		}
				
		return totais;		
	}	
	
	private Map<String, TemposResumo> getTemposMaquina(FiltroRelatorioIndiceParadasDTO filtro) {
		IdwLogger log = new IdwLogger("RelAcompanhamentoProducao");
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		MapQuery q = new MapQuery(getDaoSession());
		
		Map <String, List<DwConsolid>> mapMaquinas = new HashMap<String, List<DwConsolid>>();
		Map<String, TemposResumo> mapTotais = new HashMap<String, TemposResumo>();
		
		List<DwConsolid> listaIdsTotal = new ArrayList<DwConsolid>();
		segHrsProdutivasTotal = BigDecimal.ZERO;
		
		q.novaConsulta();
		
		q.append("SELECT DISTINCT consolid.idConsolid ");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		
		q.append("JOIN consolid.dwFolha folha");

		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
		
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.stAtivo IS NULL");
		
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno <> 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramenta.idGrupoFerramenta = :idgpRap");
		}
		
		q.defineParametro("tpId", (byte) 1);		
		q.defineParametro("cdop", filtro.getCdop());
		
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
				
		List<Object> listaId = q.list();
		
		List<DwConsolid> lista;
		
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			q.novaConsulta();
			
			q.append("SELECT DISTINCT consolid ");
			q.append("FROM DwConsolid consolid");
			q.append("JOIN consolid.dwConsols consol");
			q.append("JOIN consolid.omPt pt");
			
			/*
			listaId.removeAll(listaId);
			// listaId.add(0, (long)19233);
			listaId.add(0, 19233);
			*/
			
			q.append("WHERE consolid.idConsolid in (:lista)");
			
			q.defineListaParametro("lista", listaId);
			
			// List<DwConsolid> lista = q.list();
			lista = q.list();
			
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			// ...
			
		}
		
		
		for (DwConsolid id : lista) {
			List<DwConsolid> listaIds = new ArrayList<DwConsolid>();
			
			if (mapMaquinas.containsKey(id.getOmPt().getCdPt()) == false) {
				listaIds = new ArrayList<DwConsolid>();
				listaIds.add(id);
				
			} else {
				listaIds = new ArrayList<DwConsolid>();
				listaIds = mapMaquinas.get(id.getOmPt().getCdPt());
				listaIds.add(id);					
			}
			mapMaquinas.put(id.getOmPt().getCd(), listaIds);

			//total geral
			listaIdsTotal.add(id);					
		}
		
		
		// trecho abaixo necessario por causa das horas produtivas (dependem do ciclo medio e tem que ser recalculada sempre)		
		Set<String> keysMaquinas = mapMaquinas.keySet();		
		for (String maq : keysMaquinas) {
			DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
			FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
			
			List<DwConsolid> listaIds = new ArrayList<>();
			listaIds.addAll(mapMaquinas.get(maq)); 
			
			//ordenar por id >> igual ao criterio do BI
			Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
				@Override
				public int compare(DwConsolid o1, DwConsolid o2) {
					Long str1 = o1.getIdConsolid();
					Long str2 = o2.getIdConsolid();
					return str1.compareTo(str2);
				}
			};
			Collections.sort(listaIds, comparator);				
			
			
			detalhes = new DetalheMonitorizacaoPTInjetDTO();
			filtroInd = new FiltroDetalhePTInjetDTO();
			filtroInd.setOmPt(mapMaquinas.get(maq).get(0).getOmPt());
			filtroInd.setOmGt(mapMaquinas.get(maq).get(0).getOmGt());

			IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
					log, omcfg, listaIds, false, // isRecuperarListaProdutos,
					false, // isRecuperarListaOperadores,
					false, // isRecuperarListaAlertas,
					false, // isRecuperarListaPerdas,
					false, // isRecuperarListaResumoDatas,
					false, // isRecuperarListaResumoTurnos,
					detalhes, filtroInd);

			rn.setResumoIndicadores();
			rn.setIndicadoresAdicionais();

			TemposResumo resumo = new TemposResumo();
			resumo.hrsDisponiveis = new BigDecimal(detalhes.getTempoAtivo());
			resumo.hrsProdutivas = new BigDecimal(detalhes.getTempoProdutivas());
			
			mapTotais.put(mapMaquinas.get(maq).get(0).getOmPt().getCdPt(), resumo);
		}
		
		
		// trecho abaixo necessario por causa do total geral relacionado a horas produtivas (soma das produtivas nao resolve por causa do ciclo medio dos filtros|		
		DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
		FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
		
		
		//ordenar por id >> igual ao criterio do BI
		Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
			@Override
			public int compare(DwConsolid o1, DwConsolid o2) {
				Long str1 = o1.getIdConsolid();
				Long str2 = o2.getIdConsolid();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(listaIdsTotal, comparator);				
		
		
		detalhes = new DetalheMonitorizacaoPTInjetDTO();
		filtroInd = new FiltroDetalhePTInjetDTO();
		filtroInd.setOmPt(null);
		filtroInd.setOmGt(null);

		IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
				log, omcfg, listaIdsTotal, false, // isRecuperarListaProdutos,
				false, // isRecuperarListaOperadores,
				false, // isRecuperarListaAlertas,
				false, // isRecuperarListaPerdas,
				false, // isRecuperarListaResumoDatas,
				false, // isRecuperarListaResumoTurnos,
				detalhes, filtroInd);

		rn.setResumoIndicadores();
		rn.setIndicadoresAdicionais();

		segHrsProdutivasTotal = new BigDecimal(detalhes.getTempoProdutivas());
		
		return mapTotais;
	}
	
	
	private Map<String, TemposResumo> getTemposMaquina2(FiltroRelatorioIndiceParadasDTO filtro) {
		IdwLogger log = new IdwLogger("RelAcompanhamentoProducao");
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		MapQuery q = new MapQuery(getDaoSession());
		
		Map <String, List<DwConsolid>> mapMaquinas = new HashMap<String, List<DwConsolid>>();
		Map<String, TemposResumo> mapTotais = new HashMap<String, TemposResumo>();
		
		List<DwConsolid> listaIdsTotal = new ArrayList<DwConsolid>();
		segHrsProdutivasTotal = BigDecimal.ZERO;
		
		q.novaConsulta();
		
		q.append("SELECT DISTINCT consolid ");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("join consolid.ppCp ppcp");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		
		q.append("JOIN consolid.dwFolha folha");

		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta grupoferramenta");
		
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.stAtivo IS NULL");
		
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno <> 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND pt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND grupoferramenta.idGrupoFerramenta = :idgpRap");
		}
		
		q.defineParametro("tpId", (byte) 1);		
		q.defineParametro("cdop", filtro.getCdop());
		
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpRap", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		
		
		if (filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null) {
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal", DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		
		List<DwConsolid> lista = q.list();
		
		
		for (DwConsolid id : lista) {
			
			List<DwConsolid> listaIds = new ArrayList<DwConsolid>();
			
			if (mapMaquinas.containsKey(id.getOmPt().getCdPt()) == false) {
				listaIds = new ArrayList<DwConsolid>();
				listaIds.add(id);
				
			} else {
				listaIds = new ArrayList<DwConsolid>();
				listaIds = mapMaquinas.get(id.getOmPt().getCdPt());
				listaIds.add(id);					
			}
			mapMaquinas.put(id.getOmPt().getCd(), listaIds);

			//total geral
			listaIdsTotal.add(id);					
		}
		
		
		// trecho abaixo necessario por causa das horas produtivas (dependem do ciclo medio e tem que ser recalculada sempre)		
		Set<String> keysMaquinas = mapMaquinas.keySet();
		
		for (String maq : keysMaquinas) {
			DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
			FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
			
			List<DwConsolid> listaIds = new ArrayList<>();
			listaIds.addAll(mapMaquinas.get(maq)); 
			
			//ordenar por id >> igual ao criterio do BI
			Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
				@Override
				public int compare(DwConsolid o1, DwConsolid o2) {
					Long str1 = o1.getIdConsolid();
					Long str2 = o2.getIdConsolid();
					return str1.compareTo(str2);
				}
			};
			Collections.sort(listaIds, comparator);				
			
			
			detalhes = new DetalheMonitorizacaoPTInjetDTO();
			filtroInd = new FiltroDetalhePTInjetDTO();
			filtroInd.setOmPt(mapMaquinas.get(maq).get(0).getOmPt());
			filtroInd.setOmGt(mapMaquinas.get(maq).get(0).getOmGt());

			IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
					log, omcfg, listaIds, false, // isRecuperarListaProdutos,
					false, // isRecuperarListaOperadores,
					false, // isRecuperarListaAlertas,
					false, // isRecuperarListaPerdas,
					false, // isRecuperarListaResumoDatas,
					false, // isRecuperarListaResumoTurnos,
					detalhes, filtroInd);
			
			rn.setResumoIndicadores();
			rn.setIndicadoresAdicionais();
			
			TemposResumo resumo = new TemposResumo();
			resumo.hrsDisponiveis = new BigDecimal(detalhes.getTempoAtivo());
			resumo.hrsProdutivas = new BigDecimal(detalhes.getTempoProdutivas());
			
			mapTotais.put(mapMaquinas.get(maq).get(0).getOmPt().getCdPt(), resumo);
		}
		
		
		// trecho abaixo necessario por causa do total geral relacionado a horas produtivas (soma das produtivas nao resolve por causa do ciclo medio dos filtros|		
		DetalheMonitorizacaoPTInjetDTO detalhes = new DetalheMonitorizacaoPTInjetDTO();
		FiltroDetalhePTInjetDTO filtroInd = new FiltroDetalhePTInjetDTO();
		
		
		//ordenar por id >> igual ao criterio do BI
		Comparator<DwConsolid> comparator = new Comparator<DwConsolid>() {
			@Override
			public int compare(DwConsolid o1, DwConsolid o2) {
				Long str1 = o1.getIdConsolid();
				Long str2 = o2.getIdConsolid();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(listaIdsTotal, comparator);				
		
		
		detalhes = new DetalheMonitorizacaoPTInjetDTO();
		filtroInd = new FiltroDetalhePTInjetDTO();
		filtroInd.setOmPt(null);
		filtroInd.setOmGt(null);

		IndicadoresDoDetalheRN rn = new IndicadoresDoDetalheRN(getDao(),
				log, omcfg, listaIdsTotal, false, // isRecuperarListaProdutos,
				false, // isRecuperarListaOperadores,
				false, // isRecuperarListaAlertas,
				false, // isRecuperarListaPerdas,
				false, // isRecuperarListaResumoDatas,
				false, // isRecuperarListaResumoTurnos,
				detalhes, filtroInd);

		rn.setResumoIndicadores();
		rn.setIndicadoresAdicionais();

		segHrsProdutivasTotal = new BigDecimal(detalhes.getTempoProdutivas());
		
		return mapTotais;
	}	
	
	
	public List<DwConsolpa> getListaDwConsolpa(FiltroRelatorioIndiceParadasDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.novaConsulta();
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN fetch consolid.dwConsols consol");
		q.append("JOIN fetch consolid.ppCp ppcp");		
		q.append("JOIN fetch consol.dwConsolpas consolpa");
		q.append("JOIN consolid.dwFolha folha");
		q.append("JOIN consolid.omPt pt");
		q.append("LEFT JOIN pt.omObjs omobj");
		q.append("LEFT JOIN ppcp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN fetch consolpa.dwTParada parada");
		q.append("LEFT JOIN parada.dwTArea area");		
		q.append("LEFT JOIN folha.dwFolharaps folharap");
		q.append("LEFT JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgp");
		q.append("LEFT JOIN rapgp.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpId");
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial AND :datafinal");
		}
		if (filtro.getCdop() != null) {
			q.append("AND ppcpproduto.nrDoc = :cdop");
		}
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if (filtro.getOmpt() != null) {
			q.append("AND consolid.omPt.idPt = :idpt");
		}
		if (filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idgt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getDwGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idgpFerramenta");
		}
		if(!listaFiltroParada.isEmpty()) {
			q.append("AND parada.cdTparada IN (:paradas)");
		}		
		if(!listaFiltroArea.isEmpty()) {
			q.append("AND area.cdArea IN (:areas)");
		}
		
		q.defineParametro("tpId", (byte) 1);		
		q.defineParametro("cdop", filtro.getCdop());
		
		if (filtro.getDwGrupoFerramenta() != null) {
			q.defineParametro("idgpFerramenta", filtro.getDwGrupoFerramenta().getIdGrupoFerramenta());
		}
		if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idgt", filtro.getOmgt().getIdGt());
		}
		if (filtro.getOmpt() != null) {
			q.defineParametro("idpt", filtro.getOmpt().getIdPt());
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if(!listaFiltroParada.isEmpty()) {
			q.defineListaParametro("paradas", listaFiltroParada);
		}
		if(!listaFiltroArea.isEmpty()) {
			q.defineListaParametro("areas", listaFiltroArea);
		}
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		
		List<DwConsolid> listaConsolid = q.list();
		List<DwConsolpa> listaConsolPa = new ArrayList<>();
		for(DwConsolid id : listaConsolid){
			for(DwConsol consol : id.getDwConsols()){
				listaConsolPa.addAll(consol.getDwConsolpas());
			}
		}
		
		return listaConsolPa;
	}
	
	private RelatorioIndiceParadaPtDTO montaEstrututaRelatorioParadasPorMaquina(List<DwConsolpa> listaConsolpa, Map<String, TemposResumo>  mapTotais) {
		
		RelatorioIndiceParadaPtDTO retorno = new RelatorioIndiceParadaPtDTO();
		retorno.setSubRelatorioIndiceParadas(new ArrayList<RelatorioIndiceParadaPtDTO>());
		retorno.setItensRelatorio(new ArrayList<ItemParadaPorPtDTO>());

		HashMap<Long, List<DwConsolpa>> mapListConsolpaPorPt = new HashMap<>();
		
		List<DwConsolid> consolids = new ArrayList<>();
		
		//SEPARANDO UMA LISTA DE DWCONSOLPA PRA CADA MAQUINA PARA FAZER OS CALCULOS
		for(DwConsolpa consolpa : listaConsolpa) {
			DwConsolid consolid = consolpa.getDwConsol().getDwConsolid();
			boolean isConsolidSalvoNaLista = false;
			for(DwConsolid consolidLista : consolids){
				if(consolidLista.getIdConsolid() == consolid.getIdConsolid()){
					isConsolidSalvoNaLista = true;
					break;
				}
			}
			if(isConsolidSalvoNaLista == false){
				consolids.add(consolid);
			}
			
			OmPt pt = consolpa.getDwConsol().getDwConsolid().getOmPt();
			List<DwConsolpa> lista = mapListConsolpaPorPt.get(pt.getIdPt());
			if(lista == null) {
				lista = new ArrayList<>();
				lista.add(consolpa);
				mapListConsolpaPorPt.put(pt.getIdPt(), lista);
			} else {
				lista.add(consolpa);
			}
		}

		//RODAPE FINAL - VALORES SETADOS POIS SÃO ENVIADOS POR RELATORIO VIA PARAMETRO.
		TemposResumo temposResumo = getTempoTotal(mapTotais);
		
		double totalTempoAtivo = temposResumo.hrsDisponiveis.doubleValue();
		double totalTempoProdutivo = temposResumo.hrsProdutivas.doubleValue();
		double totalTempoParada = 0;
		double totalTempoParadaSP = 0;
		double totalTempoParadaCP = 0;
		double totalSegMTTR = 0;
		double totalSegMTBF = 0;
		int qtdParadasComPeso = 0;
		int qtdMTTR_MTBF = 0;
		Double tempoTotalMTBF_MTTR = 0d;
		
		for(Long idPt : mapListConsolpaPorPt.keySet()) {
			List<DwConsolpa> lista = mapListConsolpaPorPt.get(idPt);
			RelatorioIndiceParadaPtDTO itemMaquinaComParadas = totalizaValoresDoPtParada(lista, mapTotais);
			
			//TOTALIZANDO INFORMAÇÕES PRO RODAPÉ FINAL
			totalTempoParada = totalTempoParada + itemMaquinaComParadas.getTempoParadas();
			totalTempoParadaSP = totalTempoParadaSP + itemMaquinaComParadas.getTempoParadasSP();
			totalTempoParadaCP = totalTempoParadaCP + itemMaquinaComParadas.getTempoParadasCP();
			qtdParadasComPeso = qtdParadasComPeso + itemMaquinaComParadas.getQtdOcorrenciasPPE();
			qtdMTTR_MTBF = qtdMTTR_MTBF + itemMaquinaComParadas.getQtdMTTR_MTBF();
			tempoTotalMTBF_MTTR = tempoTotalMTBF_MTTR + itemMaquinaComParadas.getTempoMTTR_MTBF();
			totalSegMTTR = totalSegMTTR + itemMaquinaComParadas.getSegMTTR();
			totalSegMTBF = totalSegMTBF + itemMaquinaComParadas.getSegMTBF();
			
			retorno.getSubRelatorioIndiceParadas().add(itemMaquinaComParadas);
		}	
		
		//MONTANDO LISTA DE OBJETOS PARADA O RELATORIO
		for(RelatorioIndiceParadaPtDTO itemMaquina : retorno.getSubRelatorioIndiceParadas()) {
			TemposResumo temposMaquina = getTempoMaq(mapTotais, itemMaquina.getMaquina());
			
			for(ParadaRelatorioDTO itemParada : itemMaquina.getListaParadasRelatorio()) {
				ItemParadaPorPtDTO item = new ItemParadaPorPtDTO();
				item.setHorasProdutivas(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(temposMaquina.hrsProdutivas.doubleValue()));
				item.setIndiceBA(itemParada.getIndiceBA());
				item.setIndiceCA(itemParada.getIndiceCA());
				//CALCULO INDICE CD
				item.setIndiceCD(getIndice(itemMaquina.getTempoParadas(), totalTempoParada));
				item.setMaquina(itemMaquina.getMaquina());
				item.setParada(itemParada.getParada());
				item.setQtdParada(String.valueOf(itemParada.getQuantidade()));
				item.setQtdParadasCP(String.valueOf(itemMaquina.getQtdOcorrenciasPPE()));
				item.setTempoAtivo(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(temposMaquina.hrsDisponiveis.doubleValue()));
				item.setTempoParada(DataHoraRN.formatSegundosParaHHMMSSmmm(itemParada.getTempoParada().doubleValue()));
				item.setTotalTempoParada(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(itemMaquina.getTempoParadas().doubleValue()));
				item.setTempoMTTR_MTBF(DataHoraRN.formatSegundosParaHHMMSSSemMilisegundos(itemMaquina.getTempoMTTR_MTBF().doubleValue()));
				item.setMinMTBF(ConversaoTipos.converteParaString(itemMaquina.getSegMTBF(), 2));
				item.setMinMTTR(ConversaoTipos.converteParaString(itemMaquina.getSegMTTR(), 2));
				item.setQtdMTTR_MTBF(String.valueOf(itemMaquina.getQtdMTTR_MTBF()));
				item.setDisponibilidade(ConversaoTipos.converteParaString(itemMaquina.getDisponibilidade(), 2)+"%");
				retorno.getItensRelatorio().add(item);
			}
		}
		
		//CALCULO INDICE ED
		String indiceED = getIndice(totalTempoParadaCP, totalTempoParada);
		
		double disponibilidade = 0d;
		if(totalTempoAtivo != 0){
			disponibilidade = (totalTempoAtivo - totalTempoParada) / totalTempoAtivo;
		}		
		disponibilidade = disponibilidade * 100;
		
		retorno.setTempoAtivo(totalTempoAtivo);
		retorno.setHorasProdutivas(totalTempoProdutivo);
		retorno.setTempoParadas(totalTempoParada);
		retorno.setTempoParadasCP(totalTempoParadaCP);
		retorno.setTempoParadasSP(totalTempoParadaSP);
		retorno.setQtdOcorrenciasPPE(qtdParadasComPeso);
		retorno.setQtdMTTR_MTBF(qtdMTTR_MTBF);
		retorno.setSegMTTR(totalSegMTTR);
		retorno.setSegMTBF(totalSegMTBF);
		retorno.setTempoMTTR_MTBF(tempoTotalMTBF_MTTR);
		retorno.setIndiceED(indiceED);
		retorno.setDisponibilidade(disponibilidade);
		
		return retorno;
	}
	
	/*
	 * percorrendo lista de consolpa por maquina
	 * nesse ponto podem existir mais de um registro com o mesmo tipo de parada, valores devem ser somados
	 * valores: qtdOcorrencias, tempo, cp, sp, qtd, ppe, qtdMTTR/MTBF, tempoMTTR/MTBF, MTTR/MTBF, minMTTR, minMTBF
	 */
	private RelatorioIndiceParadaPtDTO totalizaValoresDoPtParada(List<DwConsolpa> listaConsolpa, Map<String, TemposResumo> mapTotais) {
		
		RelatorioIndiceParadaPtDTO itemMaquina = new RelatorioIndiceParadaPtDTO();
		
		//abaixo é a parte referente as informações de uma maquina(*)
		TemposResumo resumo = getTempoTotal(mapTotais);
		
		double tempoTotalParada = 0;
		double tempoTotalProdutivo = resumo.hrsProdutivas.doubleValue();
		double tempoTotalAtivo = resumo.hrsDisponiveis.doubleValue();
		double tempoTotalComPeso = 0;
		double tempoTotalSemPeso = 0;
		int quantidadeComPeso = 0;
		
		HashMap<Long, DwConsol> mapConsol = new HashMap<>();
		
		//ABAIXO É A PARTE REFERENTE AS INFORMAÇÕES DE CADA PARADA DE UMA MAQUINA
		HashMap<Long, ParadaRelatorioDTO> mapConsolpaPorParada = new HashMap<>();
		for(DwConsolpa consolpa : listaConsolpa) {
			
			DwConsol consol = consolpa.getDwConsol();		
			
			//CALCULANDO TEMPO ATIVO DA MAQUINA
			DwConsol consolDistinct = mapConsol.get(consol.getIdConsol());
			if(consolDistinct == null) {
				mapConsol.put(consol.getIdConsol(), consol);
			}
			
			DwTParada parada = consolpa.getDwTParada();
			ParadaRelatorioDTO paradaDoPt = mapConsolpaPorParada.get(parada.getIdTparada());
						
			//CALCULANDO TEMPO TOTAL DAS PARADAS E QUANTIDADE DE PARADAS COM PESO
			double tempoParada = 0;
			int qtdParadaComPeso = 0;
			
			if (parada.getIsPesa() != null && parada.getIsPesa() == false) {
				double SegAutoTempoparadaSpUni = consolpa.getSegAutoTempoparadaSp() != null ? consolpa.getSegAutoTempoparadaSp().doubleValue() : 0d;
				double SegManuTempoparadaSpUni = consolpa.getSegManuTempoparadaSp() != null ? consolpa.getSegManuTempoparadaSp().doubleValue() : 0d;
				tempoParada = SegAutoTempoparadaSpUni + SegManuTempoparadaSpUni;
				tempoTotalSemPeso = tempoTotalSemPeso + tempoParada;
			} else {
	          	double segAutoTempoparadaCpUni = consolpa.getSegAutoTempoparadaCp() != null ? consolpa.getSegAutoTempoparadaCp().doubleValue() : 0d;
	          	double segManuTempoparadaCpUni = consolpa.getSegManuTempoparadaCp() != null ? consolpa.getSegManuTempoparadaCp().doubleValue() : 0d;		            		            
	          	tempoParada = segAutoTempoparadaCpUni + segManuTempoparadaCpUni;
	          	qtdParadaComPeso = 1;
	          	tempoTotalComPeso = tempoTotalComPeso + tempoParada;
			}
			
			//INCREMENTANDO QUANTIDADES E TEMPOS CASO OCORRA DE UM TIPO DE PARADA APARECER MAIS DE UMA VEZ
			int quantidadeOcorrencias = getQuantidadeOcorrencias(consolpa.getDwConsolpaocos());
			if(tempoParada > 0d && quantidadeOcorrencias > 0d) {
				if(paradaDoPt == null){
					ParadaRelatorioDTO itemParada = new ParadaRelatorioDTO();
					itemParada.setParada(parada.getCdTparada() + " - " +parada.getDsTparada());
					itemParada.setQuantidade(quantidadeOcorrencias);
					itemParada.setTempoParada(tempoParada);
					itemParada.setQtdParadaComPeso(qtdParadaComPeso);
					mapConsolpaPorParada.put(parada.getIdTparada(), itemParada);
				} else {
					int novaQuantidade = paradaDoPt.getQuantidade() + quantidadeOcorrencias;
					double novoTempoParada = paradaDoPt.getTempoParada() + tempoParada;
					paradaDoPt.setQuantidade(novaQuantidade);
					paradaDoPt.setTempoParada(novoTempoParada);
				}
			}			
		}
		
		//CALCULANDO INFORMAÇÕES PARA O RODAPÉ DE CADA MAQUINA
		List<ParadaRelatorioDTO> listaParadasPorPt = new ArrayList<>();
		for(Long idParada : mapConsolpaPorParada.keySet()){
			ParadaRelatorioDTO itemParada = mapConsolpaPorParada.get(idParada);
			tempoTotalParada = tempoTotalParada + itemParada.getTempoParada();
			quantidadeComPeso = quantidadeComPeso + itemParada.getQtdParadaComPeso();
			
			//CALCULO INDICE BA
			itemParada.setIndiceBA(getIndice(itemParada.getTempoParada(), tempoTotalAtivo));
			listaParadasPorPt.add(itemParada);
		}
		itemMaquina.setListaParadasRelatorio(listaParadasPorPt);
		
		//CALCULO INDICE CA
		for(Long idParada : mapConsolpaPorParada.keySet()){
			ParadaRelatorioDTO itemParada = mapConsolpaPorParada.get(idParada);
			itemParada.setIndiceCA(getIndice(tempoTotalParada, tempoTotalAtivo));
		}
		
		double disponibilidade = 0d;
		if(tempoTotalAtivo != 0){
			disponibilidade = (tempoTotalAtivo - tempoTotalParada) / tempoTotalAtivo;
		}		
		disponibilidade = disponibilidade * 100;
		
		itemMaquina.setMaquina(listaConsolpa.get(0).getDwConsol().getDwConsolid().getOmPt().getCdPt());
		itemMaquina.setTempoParadas(tempoTotalParada);
		itemMaquina.setTempoAtivo(tempoTotalAtivo);
		itemMaquina.setHorasProdutivas(tempoTotalProdutivo);
		itemMaquina.setTempoParadasCP(tempoTotalComPeso);
		itemMaquina.setTempoParadasSP(tempoTotalSemPeso);
		itemMaquina.setQtdOcorrenciasPPE(quantidadeComPeso);
		itemMaquina.setSegMTTR(getSegMTTR(mapConsol));
		itemMaquina.setSegMTBF(getSegMTBF(mapConsol));
		itemMaquina.setTempoMTTR_MTBF(getTempoMTTR_MTBF(mapConsol));
		itemMaquina.setQtdMTTR_MTBF(getQuantidadeMTTR_MTBF(mapConsol));
		itemMaquina.setDisponibilidade(disponibilidade);
		
		return itemMaquina;
	}
	
	public int getQuantidadeMTTR_MTBF(HashMap<Long, DwConsol> mapConsol) {
		int qtdMTBF = 0;
		for(Long idConsol : mapConsol.keySet()) {
			DwConsol consol = mapConsol.get(idConsol);
			qtdMTBF += consol.getQtAutoOcoparadamtbf() != null ? consol.getQtAutoOcoparadamtbf().intValue() : 0l;
            qtdMTBF += consol.getQtManuOcoparadamtbf() != null ? consol.getQtManuOcoparadamtbf().intValue() : 0l;
		}
		return qtdMTBF;
	}
	
	public double getTempoMTTR_MTBF(HashMap<Long, DwConsol> mapConsol) {
		double tempoMTBF = 0d;
		for(Long idConsol : mapConsol.keySet()) {
			DwConsol consol = mapConsol.get(idConsol);
			tempoMTBF += consol.getSegAutoTempoparadamtbf() != null ? consol.getSegAutoTempoparadamtbf().longValue() : 0l;
            tempoMTBF += consol.getSegManuTempoparadamtbf() != null ? consol.getSegManuTempoparadamtbf().longValue() : 0l;
		}
		return tempoMTBF;
	}
	
	public double getSegMTTR(HashMap<Long, DwConsol> mapConsol) {
		double tempoMTBF = 0;
		int ocoMTBF = 0; 
		for(Long idConsol : mapConsol.keySet()) {
			DwConsol consol = mapConsol.get(idConsol);
			tempoMTBF += consol.getSegAutoTempoparadamtbf() != null ? consol.getSegAutoTempoparadamtbf().longValue() : 0l;
			tempoMTBF += consol.getSegManuTempoparadamtbf() != null ? consol.getSegManuTempoparadamtbf().longValue() : 0l;
			ocoMTBF += consol.getQtAutoOcoparadamtbf() != null ? consol.getQtAutoOcoparadamtbf().intValue() : 0;
            ocoMTBF += consol.getQtManuOcoparadamtbf() != null ? consol.getQtManuOcoparadamtbf().intValue() : 0;
		}
		Float mttr = FormulasInjet.calcularMTTR(BigDecimal.valueOf(tempoMTBF), ocoMTBF);
		return Double.valueOf(mttr.toString());
	}
	
	public double getSegMTBF(HashMap<Long, DwConsol> mapConsol) {
		double tempoativo = 0;
		int ocoMTBF = 0;
		for(Long idConsol : mapConsol.keySet()) {
			DwConsol consol = mapConsol.get(idConsol);
			 tempoativo += consol.getSegAutoTempoativo() != null ? consol.getSegAutoTempoativo().longValue() : 0l;
             tempoativo += consol.getSegManuTempoativo() != null ? consol.getSegManuTempoativo().longValue() : 0l;
             ocoMTBF += consol.getQtAutoOcoparadamtbf() != null ? consol.getQtAutoOcoparadamtbf().intValue() : 0;
             ocoMTBF += consol.getQtManuOcoparadamtbf() != null ? consol.getQtManuOcoparadamtbf().intValue() : 0;
		}
		Float mtbf = FormulasInjet.calcularMTBF(BigDecimal.valueOf(tempoativo), ocoMTBF);
		return Double.valueOf(mtbf.toString());
	}
	
	/**
	 * Calculando indices valor1/valor2
	 * @param valor1
	 * @param valor2
	 * @return
	 */
	private String getIndice(double valor1, double valor2){
		if(valor2 == 0){
			return "0%";
		}
		double valor = (valor1 * 100) / valor2;
	    double arredondado = valor;
		arredondado *= (Math.pow(10, 2));
//		if (1 == 0) {
//			arredondado = Math.ceil(arredondado);
//		} else {
	        arredondado = Math.floor(arredondado);
//		}
		arredondado /= (Math.pow(10, 2));
	    return arredondado+"%";
	}

	
	private int getQuantidadeOcorrencias(Set<DwConsolpaoco> ocos){
		int contador = 0;
		for(DwConsolpaoco oco : ocos){
			if (oco.getDthrFparada() != null) {
				contador++;
			}
		}
		return contador;
	}
		
}
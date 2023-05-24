package idw.webservices.rest.idw.v2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwGrupoFerramentaDAO;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.GTRN;
import idw.model.rn.GrupoFerramentaRN;
import idw.model.rn.PTRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.FerramentaDTO;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.FiltroRelatorioPlanejamentoRealizadoDTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.RelatorioIndiceParadaPtDTO;
import idw.webservices.dto.RelatorioPlanejamentoRealizadoDTO;
import idw.webservices.dto.TurnoDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.idw.v2.dto.FiltroRelatoriosDTO;
import idw.webservices.rest.idw.v2.dto.GrupoFerramentasDTO2;
import idw.webservices.rest.idw.v2.dto.GtDTO2;
import idw.webservices.rest.idw.v2.dto.PtDTO2;
import idw.webservices.rest.idw.v2.dto.RapDTO;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import idw.model.rn.RelatorioParadaPorPtRN;
import idw.model.rn.RelatorioPlanejamentoRealizadoRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.Agrupamento;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoPeso;
import idw.model.rn.relatorios.consolidados.FiltroRelatorioConsolidadosDTO.TipoProducao;
import idw.model.rn.relatorios.consolidados.RelatorioConsolidadoDTO;
import idw.model.rn.relatorios.consolidados.RelatorioConsolidadosRN;

@Path("/v2/relatorios")
public class RelatoriosNIDWResource {
	
	@POST
	@Path("/indiceparadasporposto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndiceParadasPorPosto(@Context HttpServletRequest request, FiltroRelatoriosDTO filtroWeb) throws ParseException {
		TokenFilter.validarNIDW(request);
		
		RelatorioParadaPorPtRN rn = new RelatorioParadaPorPtRN();
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		RelatorioIndiceParadaPtDTO retorno = null;
		
		FiltroRelatorioIndiceParadasDTO filtro = new FiltroRelatorioIndiceParadasDTO();
		
		try {
			
			// Inicia sessão
			dao.iniciaSessao();
			
			// Prepara o filtro
			filtro = PreparaFiltroIndiceParadasPorPosto(filtroWeb, dao);
			
			// Seta o objeto "dao" da regra de negócio
			rn.setDao(dao);
			
			// Executa as consultas
			retorno = rn.getDadosRelatorioParadasPorMaquina(filtro);
			
			// Se retorno null...
			if (retorno == null) {
				throw new JsonException("Error");
			}
			
			// Monta retorno JSON
			String json = gson.toJson(retorno);
			
			// Retorna dados
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException e) {
			dao.finalizaSessaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			if (retorno == null) {
				responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}
			
		}
		
	}
	
	private FiltroRelatorioIndiceParadasDTO PreparaFiltroIndiceParadasPorPosto(FiltroRelatoriosDTO filtroWeb, DAOGenerico dao) throws ParseException {
		
		FiltroRelatorioIndiceParadasDTO filtro = new FiltroRelatorioIndiceParadasDTO();
		
		// OPs
		if (filtroWeb.getOp() != null && !filtroWeb.getOp().equals("")) {
			filtro.setCdop(filtroWeb.getOp());
		}
		
		
		// ----------------------------------------------------------------------------------------
		// Período
		// ----------------------------------------------------------------------------------------
		if (!filtroWeb.getDthrIni().equals("")) {
			filtro.setPeriodoInicial(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrIni()));	
		}
		if (!filtroWeb.getDthrFim().equals("")) {
			filtro.setPeriodoFinal(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrFim()));	
		}
		// ----------------------------------------------------------------------------------------
		
		
		// Turno
		if (filtroWeb.getCdTurno() != null && !filtroWeb.getCdTurno().equals("")) {
			
			TurnoRN rnTurno = new TurnoRN();
			rnTurno.setDao(dao);
			
			TurnoDTO2 turno2 = new TurnoDTO2();
			turno2 = rnTurno.getTurnoByCd(filtroWeb.getCdTurno());
			
			TurnoDTO turno = new TurnoDTO();
			DwTurno dwTurno = new DwTurno();
			dwTurno.setIdTurno(turno2.getIdTurno());
			dwTurno.setCdTurno(filtroWeb.getCdTurno());
			turno.setTurno(dwTurno);
			
			filtro.setTurnoDTO(turno);
			
		}
	
		
		// Posto
		if (filtroWeb.getCdPt() != null && !filtroWeb.getCdPt().equals("")) {
			
			PTRN rnPt = new PTRN();
			rnPt.setDao(dao);
			
			PtDTO2 pt2 = new PtDTO2();
			pt2 = rnPt.getPtByCd(filtroWeb.getCdPt());
			
			OmPt ompt = new OmPt();
			ompt.setIdPt(pt2.getIdPt());
			ompt.setCdPt(filtroWeb.getCdPt());
			
			filtro.setOmpt(ompt);
			
		}
		
	
		// Grupo de Trabalho
		if (filtroWeb.getCdGt() != null && !filtroWeb.getCdGt().equals("")) {
			
			OmGt omgt = new OmGt();
			
			GTRN rnGt = new GTRN();
			rnGt.setDao(dao);
			
			GtDTO2 gt = new GtDTO2();
			gt = rnGt.getGtByCd(filtroWeb.getCdGt());
			
			omgt.setIdGt(gt.getIdGt());
			omgt.setCdGt(filtroWeb.getCdGt());
			
			filtro.setOmgt(omgt);
			
		}
	
		
		// Ferramenta
		if (filtroWeb.getCdFerramenta() != null && !filtroWeb.getCdFerramenta().equals("")) {
			
			DwRap ferramenta = new DwRap();
			
			DwRapRN rnRap = new DwRapRN(dao);
			
			RapDTO rap = new RapDTO();
			rap = rnRap.getFerramentaByCd(filtroWeb.getCdFerramenta()); 
			
			ferramenta.setIdRap(rap.getIdFerramenta());
			ferramenta.setCdRap(filtroWeb.getCdFerramenta());
			
			filtro.setDwRap(ferramenta);
			
		}
		
		
		
		// Grupo de Ferramenta
		if (filtroWeb.getCdGrpFerramenta() != null && !filtroWeb.getCdGrpFerramenta().equals("")) {
			
			DwGrupoFerramenta grpFerramenta = new DwGrupoFerramenta();
			
			GrupoFerramentaRN rnGrpFerr = new GrupoFerramentaRN(dao);
			
			GrupoFerramentasDTO2 grpFerr = new GrupoFerramentasDTO2();
			grpFerr = rnGrpFerr.getGrpFerramentaByCd(filtroWeb.getCdGrpFerramenta());
			
			grpFerramenta.setIdGrupoFerramenta(grpFerr.getIdGrupoFerramenta());
			grpFerramenta.setCdGrupoFerramenta(filtroWeb.getCdGrpFerramenta());
			
			filtro.setDwGrupoFerramenta(grpFerramenta);
			
		}
		
		
		// Paradas
		if (!filtroWeb.getIsTodasParadas() && (filtroWeb.getListaCdParadas() != null)) {
			
			List<DwTParada> paradas = new ArrayList<DwTParada>();
			
			for (String cdParada : filtroWeb.getListaCdParadas()) {
				
				DwTParada parada = new DwTParada();
				parada.setCdTparada(cdParada);
				paradas.add(parada);
				
			}
			
			filtro.setDwTParadas(paradas);
			
		}
		
		// Todas as paradas?
		filtro.setIsTodasParadas(filtroWeb.getIsTodasParadas());
		
		
		
		// Áreas
		if (!filtroWeb.getIsTodasAreas() && (filtroWeb.getListaCdAreas() != null)) {
			
			List<DwTArea> areas = new ArrayList<DwTArea>();
			
			for (String cdArea : filtroWeb.getListaCdAreas()) {
				
				DwTArea area = new DwTArea();
				area.setCdArea(cdArea);
				areas.add(area);
				
			}
			
			filtro.setDwTAreas(areas);
			
		}
		
		// Todas as áreas?
		filtro.setIsTodasAreas(filtroWeb.getIsTodasAreas());
		

		return filtro;
		
	}
	
	@POST
	@Path("/planejadoxrealizado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlanejadoRealizado(@Context HttpServletRequest request, FiltroRelatoriosDTO filtroWeb) throws ParseException {
		TokenFilter.validarNIDW(request);
		
		RelatorioPlanejamentoRealizadoRN rn = new RelatorioPlanejamentoRealizadoRN();
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		RelatorioPlanejamentoRealizadoDTO retorno = null;
		
		FiltroRelatorioPlanejamentoRealizadoDTO filtro = new FiltroRelatorioPlanejamentoRealizadoDTO();
		
		try {
			
			// Inicia sessão
			dao.iniciaSessao();
			
			// Prepara o filtro
			filtro = PreparaFiltroPlanejadoRealizado(filtroWeb, dao);
			
			// Seta o objeto "dao" da regra de negócio
			rn.setDao(dao);
			
			// Executa as consultas
			retorno = rn.getRelatorioPlanejamentoRealizado(filtro);
			
			// Se retorno null...
			if (retorno == null) {
				throw new JsonException("Error");
			}
			
			// Monta retorno JSON
			String json = gson.toJson(retorno);
			
			// Retorna dados
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException e) {
			dao.finalizaSessaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			if (retorno == null) {
				responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}
			
		}
		
	}

	private FiltroRelatorioPlanejamentoRealizadoDTO PreparaFiltroPlanejadoRealizado(FiltroRelatoriosDTO filtroWeb, DAOGenerico dao) throws ParseException {
		
		FiltroRelatorioPlanejamentoRealizadoDTO filtro = new FiltroRelatorioPlanejamentoRealizadoDTO();
		
		// ----------------------------------------------------------------------------------------
		// Período (filtro obrigatório)
		// ----------------------------------------------------------------------------------------
		filtro.setPeriodoInicial(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrIni()));
		filtro.setPeriodoFinal(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrFim()));
		// ----------------------------------------------------------------------------------------
		
		// Data da emissão (obrigatório)
		filtro.setPeriodoEmissaoRelatorio(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDtEmissao()));
		
		// Posto
		if (filtroWeb.getCdPt() != null && !filtroWeb.getCdPt().equals("")) {
			
			PTRN rnPt = new PTRN();
			rnPt.setDao(dao);
			
			PtDTO2 pt2 = new PtDTO2();
			pt2 = rnPt.getPtByCd(filtroWeb.getCdPt());
			
			OmPt ompt = new OmPt();
			ompt.setIdPt(pt2.getIdPt());
			ompt.setCdPt(filtroWeb.getCdPt());
			
			filtro.setOmpt(ompt);
			
		}
		
	
		// Grupo de Trabalho
		if (filtroWeb.getCdGt() != null && !filtroWeb.getCdGt().equals("")) {
			
			OmGt omgt = new OmGt();
			
			GTRN rnGt = new GTRN();
			rnGt.setDao(dao);
			
			GtDTO2 gt = new GtDTO2();
			gt = rnGt.getGtByCd(filtroWeb.getCdGt());
			
			omgt.setIdGt(gt.getIdGt());
			omgt.setCdGt(filtroWeb.getCdGt());
			
			filtro.setOmgt(omgt);
			
		}
	
		
		// Ferramenta
		if (filtroWeb.getCdFerramenta() != null && !filtroWeb.getCdFerramenta().equals("")) {
			
			DwRap ferramenta = new DwRap();
			
			DwRapRN rnRap = new DwRapRN(dao);
			
			RapDTO rap = new RapDTO();
			rap = rnRap.getFerramentaByCd(filtroWeb.getCdFerramenta()); 
			
			ferramenta.setIdRap(rap.getIdFerramenta());
			ferramenta.setCdRap(filtroWeb.getCdFerramenta());
			
			filtro.setDwRap(ferramenta);
			
		}
		
		
		// Grupo de Ferramenta
		if (filtroWeb.getCdGrpFerramenta() != null && !filtroWeb.getCdGrpFerramenta().equals("")) {
			
			DwGrupoFerramenta grpFerramenta = new DwGrupoFerramenta();
			
			GrupoFerramentaRN rnGrpFerr = new GrupoFerramentaRN(dao);
			
			GrupoFerramentasDTO2 grpFerr = new GrupoFerramentasDTO2();
			grpFerr = rnGrpFerr.getGrpFerramentaByCd(filtroWeb.getCdGrpFerramenta());
			
			grpFerramenta.setIdGrupoFerramenta(grpFerr.getIdGrupoFerramenta());
			grpFerramenta.setCdGrupoFerramenta(filtroWeb.getCdGrpFerramenta());
			
			filtro.setDwGrupoFerramenta(grpFerramenta);
			
		}
		
		
		filtro.setPeca(filtroWeb.getIsProducaoEmPeca());
		filtro.setKilograma(filtroWeb.getIsPesoEmKg());
		filtro.setTonelada(filtroWeb.getIsPesoEmTon());
		
		
		return filtro;
		
	}

	@POST
	@Path("/consolidados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsolidados(@Context HttpServletRequest request, FiltroRelatoriosDTO filtroWeb) throws ParseException {
		TokenFilter.validarNIDW(request);
		
		RelatorioConsolidadosRN rn = new RelatorioConsolidadosRN();
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		RelatorioConsolidadoDTO retorno = null;
		
		FiltroRelatorioConsolidadosDTO filtro = new FiltroRelatorioConsolidadosDTO();
		
		try {
			
			// Inicia sessão
			dao.iniciaSessao();
			
			// Prepara o filtro
			filtro = PreparaFiltroConsolidados(filtroWeb, dao);
			
			// Seta o objeto "dao" da regra de negócio
			rn.setDao(dao);
			
			// Executa as consultas
			retorno = rn.getRelatorioConsolidados(filtro);
			
			// Se retorno null...
			if (retorno == null) {
				throw new JsonException("Error");
			}
			
			// Monta retorno JSON
			String json = gson.toJson(retorno);
			
			// Retorna dados
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException e) {
			dao.finalizaSessaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			dao.finalizaSessaoSemException();
			if (retorno == null) {
				responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "", "");
				throw new ResourceWebApplicationException(responseStatus, error);
			}
			
		}
		
	}
	
	private FiltroRelatorioConsolidadosDTO PreparaFiltroConsolidados(FiltroRelatoriosDTO filtroWeb, DAOGenerico dao) throws ParseException {
		
		FiltroRelatorioConsolidadosDTO filtro = new FiltroRelatorioConsolidadosDTO();
		
		// OPs
		if (filtroWeb.getOp() != null && !filtroWeb.getOp().equals("")) {
			filtro.setCdop(filtroWeb.getOp());
		}
		
		
		// ----------------------------------------------------------------------------------------
		// Período
		// ----------------------------------------------------------------------------------------
		if (!filtroWeb.getDthrIni().equals("")) {
			filtro.setPeriodoInicial(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrIni()));	
		}
		if (!filtroWeb.getDthrFim().equals("")) {
			filtro.setPeriodoFinal(DataHoraRN.toDateFrom("yyyy-MM-dd", filtroWeb.getDthrFim()));	
		}
		// ----------------------------------------------------------------------------------------
		
		
		// Turno
		if (filtroWeb.getCdTurno() != null && !filtroWeb.getCdTurno().equals("")) {
			
			TurnoRN rnTurno = new TurnoRN();
			rnTurno.setDao(dao);
			
			TurnoDTO2 turno2 = new TurnoDTO2();
			turno2 = rnTurno.getTurnoByCd(filtroWeb.getCdTurno());
			
			TurnoDTO turno = new TurnoDTO();
			DwTurno dwTurno = new DwTurno();
			dwTurno.setIdTurno(turno2.getIdTurno());
			dwTurno.setCdTurno(filtroWeb.getCdTurno());
			turno.setTurno(dwTurno);
			
			filtro.setTurnoDTO(turno);
			
		}
	
		
		// Posto
		if (filtroWeb.getCdPt() != null && !filtroWeb.getCdPt().equals("")) {
			
			PTRN rnPt = new PTRN();
			rnPt.setDao(dao);
			
			PtDTO2 pt2 = new PtDTO2();
			pt2 = rnPt.getPtByCd(filtroWeb.getCdPt());
			
			OmPt ompt = new OmPt();
			ompt.setIdPt(pt2.getIdPt());
			ompt.setCdPt(filtroWeb.getCdPt());
			
			filtro.setOmpt(ompt);
			
		}
		
	
		// Grupo de Trabalho
		if (filtroWeb.getCdGt() != null && !filtroWeb.getCdGt().equals("")) {
			
			OmGt omgt = new OmGt();
			
			GTRN rnGt = new GTRN();
			rnGt.setDao(dao);
			
			GtDTO2 gt = new GtDTO2();
			gt = rnGt.getGtByCd(filtroWeb.getCdGt());
			
			omgt.setIdGt(gt.getIdGt());
			omgt.setCdGt(filtroWeb.getCdGt());
			
			filtro.setOmgt(omgt);
			
		}
	
		
		// Ferramenta
		if (filtroWeb.getCdFerramenta() != null && !filtroWeb.getCdFerramenta().equals("")) {
			
			DwRap ferramenta = new DwRap();
			
			DwRapRN rnRap = new DwRapRN(dao);
			
			RapDTO rap = new RapDTO();
			rap = rnRap.getFerramentaByCd(filtroWeb.getCdFerramenta()); 
			
			ferramenta.setIdRap(rap.getIdFerramenta());
			ferramenta.setCdRap(filtroWeb.getCdFerramenta());
			
			filtro.setRap(ferramenta);
			
		}
		
		
		
		// Grupo de Ferramenta
		if (filtroWeb.getCdGrpFerramenta() != null && !filtroWeb.getCdGrpFerramenta().equals("")) {
			
			DwGrupoFerramenta grpFerramenta = new DwGrupoFerramenta();
			
			GrupoFerramentaRN rnGrpFerr = new GrupoFerramentaRN(dao);
			
			GrupoFerramentasDTO2 grpFerr = new GrupoFerramentasDTO2();
			grpFerr = rnGrpFerr.getGrpFerramentaByCd(filtroWeb.getCdGrpFerramenta());
			
			grpFerramenta.setIdGrupoFerramenta(grpFerr.getIdGrupoFerramenta());
			grpFerramenta.setCdGrupoFerramenta(filtroWeb.getCdGrpFerramenta());
			
			filtro.setDwGrupoFerramenta(grpFerramenta);
			
		}
		
		if (filtroWeb.getIsAgrupadoPorPt()) {
			filtro.setAgrupamento(Agrupamento.POSTO);
			
		} else if (filtroWeb.getIsAgrupadoPorFerramenta()) { 
			filtro.setAgrupamento(Agrupamento.FERRAMENTA);
			
		} else if (filtroWeb.getIsAgrupadoPorProduto()) {
			filtro.setAgrupamento(Agrupamento.PRODUTO);
			
		}
		
		
		if (filtroWeb.getIsProducaoEmPeca()) {
			filtro.setTipoProducao(TipoProducao.PECAS);
			
		} else if (filtroWeb.getIsProducaoEmPesoBruto()) {
			filtro.setTipoProducao(TipoProducao.PESO_BRUTO);
			
		} else if (filtroWeb.getIsProducaoEmPesoLiquido()) {
			filtro.setTipoProducao(TipoProducao.PESO_LIQUIDO);
			
		}

		
		if (filtroWeb.getIsPesoEmKg()) {
			filtro.setTipoPeso(TipoPeso.KG);
			
		} else if (filtroWeb.getIsPesoEmTon()) {
			filtro.setTipoPeso(TipoPeso.TON);
			
		}

		
		return filtro;
		
		
	}
	
}
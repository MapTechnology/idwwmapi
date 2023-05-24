package idw.webservices.rest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico; 
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParetoRefugoRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN; 
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO; 
import idw.model.rn.web.bi.BiWebRN;
import idw.model.rn.web.bi.BiWebRN.FiltroAgrupamentoBI;
import idw.model.rn.web.bi.BiWebRN.UnidadeExibicaoOuOrdenacaoQtdBI; 
import idw.webservices.dto.ErrorDTO; 
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.PtDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO; 
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiResumoDTO; 
import idw.webservices.rest.dto.monitorizacao.injet.bi.GrupoFerramentaBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.ProdutoBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.RapBIDTO; 

@Path("/v2/bi")
public class BiResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	


	private FiltroAgrupamentoBI getAgrupamento(int agrupamento) {
		FiltroAgrupamentoBI retorno = FiltroAgrupamentoBI.BI_TOTAL_GERAL;

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_GERAL.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_GERAL;
		}

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_ANO_MES.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_ANO_MES;
		}

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_DATA.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_DATA;
		}

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_TURNO.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_TURNO;
		}

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_MAQUINA;
		}

		if (agrupamento == FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO.getValor()) {
			retorno = FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO ;
		}

		return retorno;
	}
	
	private UnidadeExibicaoOuOrdenacaoQtdBI getUnidadeExibicaoOuOrdenacaoQtdBI(int ordenacao) {
		UnidadeExibicaoOuOrdenacaoQtdBI retorno = UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB;

		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB.getValor()) {
			retorno = UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UB;
		}

		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UM.getValor()) {
			retorno = UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_UM;
		}
		
		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_KG.getValor()) {
			retorno = UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_KG;
		}
		
		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_TON.getValor()) {
			retorno = UnidadeExibicaoOuOrdenacaoQtdBI.QTD_PARETO_PERDAS_BI_EM_TON;
		}

		if (ordenacao == UnidadeExibicaoOuOrdenacaoQtdBI.TEMPO.getValor()) {
			retorno = UnidadeExibicaoOuOrdenacaoQtdBI.TEMPO;
		}
		
		return retorno;		
	}
	
	@GET
	@Path("/filtrosBI/ferramentasAtivas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFerramentasAtivas(@Context HttpServletRequest request) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<RapBIDTO> ferramentasDTO = rn.getFerramentasAtivas();
			dao.commitaTransacao();
			if(ferramentasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(ferramentasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/filtrosBI/grupoFerramentasAtivas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoFerramentasAtivas(@Context HttpServletRequest request) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<GrupoFerramentaBIDTO> grupoFerramentasDTO = rn.getGrupoFerramentasAtivas();
			dao.commitaTransacao();
			if(grupoFerramentasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(grupoFerramentasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/filtrosBI/gtsAtivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGtsAtivos(@Context HttpServletRequest request) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<GtDTO> retorno = rn.getGtsAtivos();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/filtrosBI/ptsAtivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoPTsAtivos(@Context HttpServletRequest request) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<PtDTO> retorno = rn.getPtsAtivos();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@GET
	@Path("/filtrosBI/produtosAtivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutosAtivos(@Context HttpServletRequest request) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<ProdutoBIDTO> produtosDTO = rn.getProdutosAtivos();
			dao.commitaTransacao();
			if(produtosDTO  == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(produtosDTO );
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/filtrosBI/produtosPeriodo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutosPeriodo(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroAgrupamentoBI agrupamento = getAgrupamento(filtroBI.getAgrupamentoBI());	
			
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<ProdutoBIDTO> produtosDTO = rn.getListaProdutosPeriodo(filtroBI, agrupamento);
			dao.commitaTransacao();
			if(produtosDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(produtosDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/resumoBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResumoBI(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroAgrupamentoBI agrupamento = getAgrupamento(filtroBI.getAgrupamentoBI());
			BiWebRN rn = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			BiResumoDTO resuumoBIDTO = rn.resumoBI(filtroBI, agrupamento);
			dao.commitaTransacao();
			if(resuumoBIDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(resuumoBIDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	 
	 
	@POST
	@Path("/perdas/paretoRefugoBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoRefugoBI(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
	
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			GraficoParetoRefugoRN rn = new GraficoParetoRefugoRN(dao);
			GraficosParetoRefugosDTO retorno = rn.getGraficoParetoRefugoDTO(DetalheMonitorizacaoPTInsertRN.PERIODO_CONSOLIDACAO_TURNO, filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	

	// metodo monta pareto e pizza de area resp
	@POST
	@Path("/perdas/paretoParadaBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoParadaBI(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			GraficoParettoParadaRN rn = new GraficoParettoParadaRN(dao);
			GraficosParettoParadaDTO retorno = rn.getGraficoParettoParadaBIDTO(filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	
	/*
	@POST
	@Path("/perdas/pizzaAreaResponsavelParadaBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPizzaAreaResponsavelParadaBI(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			GraficoParettoParadaInjetRN rn = new GraficoParettoParadaInjetRN(dao);
			List<GraficoPizzaDTO> retorno = rn.getGraficoParettoParadaAreaRespBIDTO(filtroBI, filtroBI.getFiltroBIPizzaAreaRespPar().getIsComPeso());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	
	
	@POST
	@Path("/paretoperdas/refugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrafBIParetoPerdasRefugo(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasInjetRN rn = new BiWebGraficoPerdasInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoBIWebParetoDTO retorno = rn.getGrafBIParetoPerdasRefugo(filtroBI, filtroBI.getFiltroBIParetoRefugo().getCdRefugo());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/paretoperdas/parada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrafBIParetoPerdasParada(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasInjetRN rn = new BiWebGraficoPerdasInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoBIWebParetoDTO retorno = rn.getGrafBIParetoPerdasParada(filtroBI, filtroBI.getFiltroBIParetoPerdasParada().getIsComPeso(), filtroBI.getFiltroBIParetoPerdasParada().getCdAreaResp(), filtroBI.getFiltroBIParetoPerdasParada().getCdParada());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	


	@POST
	@Path("/paretoperdas/cavidadesinativas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrafBIParetoPerdasPCI(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasInjetRN rn = new BiWebGraficoPerdasInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoBIWebParetoDTO retorno = rn.getGrafBIParetoPerdasPCI(filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/paretoperdas/ciclos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrafBIParetoPerdasGanhosCiclo(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasInjetRN rn = new BiWebGraficoPerdasInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoBIWebParetoDTO retorno = rn.getGrafBIParetoPerdasGanhosCiclo(filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/paretoperdas/todas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrafBIParetoPerdasTodas(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasInjetRN rn = new BiWebGraficoPerdasInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoBIWebParetoDTO retorno = rn.getGrafBIParetoPerdas(filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}		

	@POST
	@Path("/paretoperdas/detalhes/refugo/produto") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasRefugoProDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			UnidadeExibicaoOuOrdenacaoQtdBI unidadeQtde = getUnidadeExibicaoOuOrdenacaoQtdBI(filtroBI.getAgrupamentoBI());
			
			BiWebGraficoPerdasRefugoDetInjetRN rn = new BiWebGraficoPerdasRefugoDetInjetRN(dao);
			BiParetoPerdasRefugoDetalheDTO retorno = rn.getParetoPerdasRefugoProDet(filtroBI, unidadeQtde, filtroBI.getFiltroBIPerdasRefugoProdDet().getCdRefugo(), filtroBI.getFiltroBIPerdasRefugoProdDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasRefugoProdDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/paretoperdas/detalhes/refugo/maquina") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasRefugoMaqDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasRefugoDetInjetRN rn = new BiWebGraficoPerdasRefugoDetInjetRN(dao);
			BiParetoPerdasRefugoDetalheDTO retorno = rn.getParetoPerdasRefugoMaqDet(filtroBI, filtroBI.getFiltroBIPerdasRefugoMaqDet().getCdRefugo(), filtroBI.getFiltroBIPerdasRefugoMaqDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasRefugoMaqDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}		

	@POST
	@Path("/paretoperdas/detalhes/parada/produto") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasParadaProDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			UnidadeExibicaoOuOrdenacaoQtdBI unidadeQtde = getUnidadeExibicaoOuOrdenacaoQtdBI(filtroBI.getFiltroBIPerdasParadaProdDet().getOrdenacaoPareto());
			
			BiWebGraficoPerdasParadaDetInjetRN rn = new BiWebGraficoPerdasParadaDetInjetRN(dao);
			BiParetoPerdasParadaDetalheDTO retorno = rn.getParetoPerdasParadaProDet(filtroBI, unidadeQtde, filtroBI.getFiltroBIPerdasParadaProdDet().getIsParComPeso(), filtroBI.getFiltroBIPerdasParadaProdDet().getCdParada(), filtroBI.getFiltroBIPerdasParadaProdDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasParadaProdDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/paretoperdas/detalhes/parada/maquina") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasParadaMaqDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasParadaDetInjetRN rn = new BiWebGraficoPerdasParadaDetInjetRN(dao);
			BiParetoPerdasParadaDetalheDTO retorno = rn.getParetoPerdasParadaMaqDet(filtroBI, filtroBI.getFiltroBIPerdasParadaMaqDet().getIsParComPeso(), filtroBI.getFiltroBIPerdasParadaMaqDet().getCdParada(), filtroBI.getFiltroBIPerdasParadaMaqDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasParadaMaqDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/paretoperdas/detalhes/arearesposavel") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasParadaAreaRespDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			UnidadeExibicaoOuOrdenacaoQtdBI unidadeQtde = getUnidadeExibicaoOuOrdenacaoQtdBI(filtroBI.getFiltroBIPerdasAreaRespDet().getOrdenacaoPareto());
			
			BiWebGraficoPerdasAreaRespParDetInjetRN rn = new BiWebGraficoPerdasAreaRespParDetInjetRN(dao);
			BiParetoPerdasAreaRespParadaDetalheDTO retorno = rn.getParetoPerdasParadaAreaRespDet (filtroBI, unidadeQtde, filtroBI.getFiltroBIPerdasAreaRespDet().getIsParComPeso(), filtroBI.getFiltroBIPerdasAreaRespDet().getCdArea(), filtroBI.getFiltroBIPerdasAreaRespDet().getCdParada(), filtroBI.getFiltroBIPerdasAreaRespDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasAreaRespDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	
	@POST
	@Path("/paretoperdas/detalhes/ciclo/produto") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasCicloProDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			UnidadeExibicaoOuOrdenacaoQtdBI unidadeQtde = getUnidadeExibicaoOuOrdenacaoQtdBI(filtroBI.getFiltroBIPerdasCicloProdDet().getOrdenacaoPareto());
			
			BiWebGraficoPerdasCicloDetInjetRN rn = new BiWebGraficoPerdasCicloDetInjetRN(dao);
			BiParetoPerdasCicloDetalheDTO retorno = rn.getParetoPerdasCicloProDet (filtroBI, unidadeQtde, filtroBI.getFiltroBIPerdasCicloProdDet().getCdPtSelecaoPareto() , filtroBI.getFiltroBIPerdasCicloProdDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/paretoperdas/detalhes/ciclo/maquina") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasCicloMaqDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			BiWebGraficoPerdasCicloDetInjetRN rn = new BiWebGraficoPerdasCicloDetInjetRN(dao);
			BiParetoPerdasCicloDetalheDTO retorno = rn.getParetoPerdasCicloMaqDet(filtroBI, filtroBI.getFiltroBIPerdasCicloMaqDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasCicloMaqDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/paretoperdas/detalhes/todas") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoPerdasTodasDet(@Context HttpServletRequest request, BiFiltroDTO filtroBI) {	
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			UnidadeExibicaoOuOrdenacaoQtdBI unidadeQtde = getUnidadeExibicaoOuOrdenacaoQtdBI(filtroBI.getFiltroBIPerdasTodasDet().getOrdenacaoPareto());
			
			BiWebGraficoPerdasTodasDetInjetRN rn = new BiWebGraficoPerdasTodasDetInjetRN(dao);
			BiParetoPerdasTodasDetalheDTO retorno = rn.getParetoPerdasTodasDet(filtroBI, unidadeQtde, filtroBI.getFiltroBIPerdasTodasDet().getCdPtSelecaoPareto(), filtroBI.getFiltroBIPerdasTodasDet().getCdProdutoSelecaoPareto());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

*/
}

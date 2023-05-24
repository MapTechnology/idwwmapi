package idw.webservices.rest.injet;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParetoRefugosDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficosParettoParadaDTO;
import idw.model.rn.monitorizacao.injet.GraficoParetoRefugoInjetRN;
import idw.model.rn.monitorizacao.injet.GraficoParettoParadaInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasAreaRespParDetInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasCicloDetInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasParadaDetInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasRefugoDetInjetRN;
import idw.model.rn.web.injet.bi.BiWebGraficoPerdasTodasDetInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN;
import idw.model.rn.web.injet.bi.BiWebInjetRN.FiltroAgrupamentoBI;
import idw.model.rn.web.injet.bi.BiWebInjetRN.UnidadeExibicaoOuOrdenacaoQtdBI;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.GtDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPizzaDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasAreaRespParadaDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasAreaRespParadaDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasCicloDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasCicloDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasParadaDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasParadaDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasRefugoDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasRefugoDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasTodasDetDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiParetoPerdasTodasDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiResumoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GraficoBIWebParetoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.GrupoFerramentaBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.ProdutoBIDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.RapBIDTO;

@Path("/injet/bi")
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
	
	
	
	@POST
	@Path("/filtrosBI/ferramentasAtivas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFerramentasAtivas() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<RapBIDTO> ferramentasDTO = rn.getFerramentasAtivas();
			dao.commitaTransacao();
			if(ferramentasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(ferramentasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/filtrosBI/grupoFerramentasAtivas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoFerramentasAtivas() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<GrupoFerramentaBIDTO> grupoFerramentasDTO = rn.getGrupoFerramentasAtivas();
			dao.commitaTransacao();
			if(grupoFerramentasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(grupoFerramentasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	//@POST
	@GET
	@Path("/filtrosBI/grupoPTsAtivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGrupoPTsAtivos() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<GtDTO> gtsFormatados = rn.getGrupoPTsAtivos();
			dao.commitaTransacao();
			if(gtsFormatados == null) {
				throw new JsonException("Error");
			}
			
			rootElement.add("gts", gson.toJsonTree(gtsFormatados));			
			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();	
			
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/filtrosBI/produtosAtivos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutosAtivos() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<ProdutoBIDTO> produtosDTO = rn.getProdutosAtivos();
			dao.commitaTransacao();
			if(produtosDTO  == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(produtosDTO );
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
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
	public Response getProdutosPeriodo(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			FiltroAgrupamentoBI agrupamento = getAgrupamento(filtroBI.getAgrupamentoBI());	
			
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			List<ProdutoBIDTO> produtosDTO = rn.getListaProdutosPeriodo(filtroBI, agrupamento);
			dao.commitaTransacao();
			if(produtosDTO == null) {
				throw new JsonException("Error");
			}
				
			String json = gson.toJson(produtosDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
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
	public Response getResumoBI(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			FiltroAgrupamentoBI agrupamento = getAgrupamento(filtroBI.getAgrupamentoBI());
			
			BiWebInjetRN rn = new BiWebInjetRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			BiResumoDTO resumoBIDTO = rn.resumoBI(filtroBI, agrupamento);
			dao.commitaTransacao();
			if(resumoBIDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(resumoBIDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
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
	public Response getParetoRefugoBI(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			GraficoParetoRefugoInjetRN rn = new GraficoParetoRefugoInjetRN(dao);
			GraficosParetoRefugosDTO retorno = rn.getGraficoParetoRefugoBiDTO(filtroBI);
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/perdas/paretoParadaBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParetoParadaBI(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			GraficoParettoParadaInjetRN rn = new GraficoParettoParadaInjetRN(dao);
			GraficosParettoParadaDTO retorno = rn.getGraficoParettoParadaBIDTO(filtroBI, filtroBI.getFiltroBIParetoParada().getIsComPeso(), filtroBI.getFiltroBIParetoParada().getCdAreaResp());
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/perdas/pizzaAreaResponsavelParadaBI")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPizzaAreaResponsavelParadaBI(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getGrafBIParetoPerdasRefugo(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getGrafBIParetoPerdasParada(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getGrafBIParetoPerdasPCI(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getGrafBIParetoPerdasGanhosCiclo(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getGrafBIParetoPerdasTodas(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasRefugoProDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasRefugoMaqDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasParadaProDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasParadaMaqDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasParadaAreaRespDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasCicloProDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasCicloMaqDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
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
	public Response getParetoPerdasTodasDet(BiFiltroDTO filtroBI) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
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
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

}

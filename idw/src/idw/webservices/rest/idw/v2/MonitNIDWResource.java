package idw.webservices.rest.idw.v2;

 

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import idw.model.WebFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.monitorizacao.detalhes.GraficoParettoParadaRN;
import idw.model.rn.web.bi.BiWebRN;
import idw.model.rn.web.bi.BiWebRN.FiltroAgrupamentoBI;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebCicloRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebParadaRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebProducaoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRefugoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.util.AritmeticaUtil;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.GraficoAreaRespParadaDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.monitorizacao.CicloParadaDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheCicloDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheOcorrenciasDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheProducaoHoraDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheParadaDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoEvolucaoCicloPadraoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficosDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaRefugoHora;
import idw.webservices.rest.dto.monitorizacao.UltimosCicloDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiFiltroDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiIndicadoresPTDTO;
import idw.webservices.rest.dto.monitorizacao.injet.bi.BiResumoDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoCiclosDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoDTO2;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoIndicadoresPTDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoParadasDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoProducaoDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoProducaoPTDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoQtdAlocDTO;
import idw.webservices.rest.idw.v2.dto.AnaliseTurnoRefugosDTO;
import idw.webservices.rest.idw.v2.dto.FiltroMonitDTO; 
import idw.webservices.rest.idw.v2.dto.FolhaDTO2; 
import idw.webservices.rest.idw.v2.dto.PtMonitDTO;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;
import ms.util.ConversaoTipos;

@Path("/v2/monitoramento")
public class MonitNIDWResource {
	
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	
	
	@GET
	@Path("/turnoAtual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnoAtual(@Context HttpServletRequest request, @QueryParam("cdGt") String cdGt) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			TurnoDTO turnoAtualDTO = rn.getTurnoAtual(cdGt);
			dao.commitaTransacao();
			String json = gson.toJson(turnoAtualDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (SemCalendarioException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@GET
	@Path("/turnosemcalativos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnosGt(@Context HttpServletRequest request) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			TurnoRN rn = new TurnoRN(dao);
			List<TurnoDTO2> turnosGT = rn.geTurnosCalAtivos();
			dao.commitaTransacao();
			String json = gson.toJson(turnosGT);
			return Response.status(responseStatus).entity(json).build();
		} catch (SemCalendarioException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/monitoramento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMonitoramento(@Context HttpServletRequest request, FiltroMonitDTO filtro) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			FiltroMonitorizacaoDTO filtroDTO = converteFiltro(filtro, dao);			
			MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtroDTO);
			monitorizacaoDTO = atualizaFiltroClickPt(monitorizacaoDTO);
			
			dao.commitaTransacao();
			if (monitorizacaoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(monitorizacaoDTO.getInfoPts());
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
	@Path("/detalhe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalhe(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);
		
		filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
		
		Response.Status responseStatus = Response.Status.OK;

		try {
			return WebFacade.getInstancia().getWEBDetalhe(filtro);
		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
		}
	}

 
	@POST
	@Path("/detalhe/grafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheProducao(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebProducaoRN rn = new DetalheMonitorizacaoWebProducaoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficosDTO graficoDTO = rn.getGraficos(filtro);
			dao.commitaTransacao();
			if (graficoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(graficoDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	
	@POST
	@Path("/detalhe/refugoHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebRefugoRN rn = new DetalheMonitorizacaoWebRefugoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRefugoDTO graficoDTO = rn.getDetalheRefugosHora(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			dao.commitaTransacao();
			if (graficoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(graficoDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	
	@POST
	@Path("/detalhe/paradaHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaHora(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DetalheMonitorizacaoWebParadaRN rn = new DetalheMonitorizacaoWebParadaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoParadaDTO paradasDTO = rn.getParadasHora(filtro);
			dao.commitaTransacao();
			if (paradasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(paradasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/detalhe/listaFiltroHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaFiltroHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebProducaoRN rn = new DetalheMonitorizacaoWebProducaoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<FiltroDetalhePostoDTO> lista = rn.getListaFiltroDetalhePostoHora(filtro);
			dao.commitaTransacao();
			if (lista == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(lista);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	
	@POST
	@Path("/detalhe/producaoHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheProducaoHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebProducaoRN rn = new DetalheMonitorizacaoWebProducaoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheProducaoHoraDTO detalhe = rn.getDetalheProducaoHora(filtro);
			dao.commitaTransacao();
			if (detalhe == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(detalhe);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

 

	@POST
	@Path("/detalhe/refugoOcorrencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoOcorrencia(@Context HttpServletRequest request, FiltroDetalheRefugoDTO filtro) {

		TokenFilter.validarNIDW(request);

		filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			
			DetalheMonitorizacaoWebRefugoRN rn = new DetalheMonitorizacaoWebRefugoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaRefugoHora> refugos = rn.getRefugoOcorrencia(filtro);
			dao.commitaTransacao();
			String json = gson.toJson(refugos);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/detalhe/refugoRecorrenciaPareto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoRecorrenciaPareto(@Context HttpServletRequest request, FiltroDetalheRefugoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebRefugoRN rn = new DetalheMonitorizacaoWebRefugoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRecorrenciaDTO grafico = rn.getRefugoRecorrenciaPareto(filtro);
			dao.commitaTransacao();
			String json = gson.toJson(grafico);
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
	@Path("/detalhe/refugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugo(@Context HttpServletRequest request, FiltroGraficoRefugoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebRefugoRN rn = new DetalheMonitorizacaoWebRefugoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRefugoDTO graficoDTO = rn.getDetalheRefugo(filtro);
			dao.commitaTransacao();
			if (graficoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(graficoDTO);
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
	@Path("/detalhe/parada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParada(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebParadaRN rn = new DetalheMonitorizacaoWebParadaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoParadaDTO paradasDTO = rn.getParadas(filtro);
			dao.commitaTransacao();
			if (paradasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(paradasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/detalhe/parada/arearesp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaAreaResp(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			GraficoParettoParadaRN rn = new GraficoParettoParadaRN(dao); 			
			GraficoAreaRespParadaDTO paradasDTO = rn.getGraficoAreaRespParada(
					filtro.getTpId(), 
					DataHoraRN.toDateFrom(FORMATO_DATA, filtro.getDtReferencia()), 
					DataHoraRN.toDateFrom(FORMATO_DATA, filtro.getDtReferencia()), 
					new BigDecimal(filtro.getIdTurno()), 
					filtro.getCdPosto(), 
					filtro.getCdCp(), 
					true, 
					false);
			
			dao.commitaTransacao();
			if (paradasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(paradasDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | ParseException  e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	

	@POST
	@Path("/detalhe/paradaOcorrencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaOcorrencia(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validarNIDW(request);

		filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaRN rn = new DetalheMonitorizacaoWebParadaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheOcorrenciasDTO ocorrencias = rn.getParadaOcorrencia(filtro);
			dao.commitaTransacao();
			String json = gson.toJson(ocorrencias);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/detalhe/paradaRecorrenciaPareto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaRecorrenciaPareto(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaRN rn = new DetalheMonitorizacaoWebParadaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRecorrenciaDTO grafico = rn.getParadaRecorrenciaPareto(filtro);
			dao.commitaTransacao();
			String json = gson.toJson(grafico);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/detalhe/ultimosCiclos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheUltimosCiclos(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			DetalheMonitorizacaoWebCicloRN rn = new DetalheMonitorizacaoWebCicloRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			UltimosCicloDTO ultimosCicloDTO = rn.getUltimosCiclos(filtro);
			dao.commitaTransacao();
			if (ultimosCicloDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(ultimosCicloDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

 
	@POST
	@Path("/detalhe/variacaoCiclo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVariacaoDeRitmo(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setDtReferencia(yyyyMMddTOddMMYYY(filtro.getDtReferencia()));
			
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCicloRN rn = new DetalheMonitorizacaoWebCicloRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<CicloParadaDTO> listaVariacaoCiclo = rn.getVariacaoDeRitmo(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			dao.commitaTransacao();
			rootElement.add("listaVariacaoCiclo", gson.toJsonTree(listaVariacaoCiclo));
			String json = gson.toJson(rootElement);
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
	
	// folhas de processos
	@GET
	@Path("/detalhe/folhasgt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolhasProcessosAtivas(@Context HttpServletRequest request, @QueryParam("cdGt") String cdGt) {
		TokenFilter.validarNIDW(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			FolhaRN rn = new FolhaRN();
			rn.setDao(dao);

			List<FolhaDTO2> retornoConsulta = rn.getFolhasGt(cdGt);
			dao.commitaTransacao();			
			String json = gson.toJson(retornoConsulta);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}
	
	@GET
	@Path("/detalhe/cicloPadrao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCicloPadrao(
			@Context HttpServletRequest request,
			@QueryParam("cdPt") String cdPt,
			@QueryParam("cdFolha") String cdFolha) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DetalheMonitorizacaoWebCicloRN rn = new DetalheMonitorizacaoWebCicloRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<GraficoEvolucaoCicloPadraoDTO> listaCicloPadrao = rn.getGraficoDaEvolucaoDoCicloPadrao(cdFolha, cdPt);
			dao.commitaTransacao();
			rootElement.add("listaCicloPadrao", gson.toJsonTree(listaCicloPadrao));
			String json = gson.toJson(rootElement);
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
	@Path("/turnos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnos(@Context HttpServletRequest request) {

		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TurnoDTO> turnos = rn.getTurnos();
			dao.commitaTransacao();
			rootElement.add("turnos", gson.toJsonTree(turnos));
			String json = gson.toJson(rootElement);
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
	@Path("/detalhe/ritmo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRitmo(@Context HttpServletRequest request, FiltroPerdaGanhoDTO filtro) {		
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebCicloRN rn = new DetalheMonitorizacaoWebCicloRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheCicloDTO detalhe = rn.getDetalheRitmo(filtro);
			dao.commitaTransacao();
			String json = gson.toJson(detalhe);
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
	@Path("/detalhe/ritmo/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRitmoTabela(@Context HttpServletRequest request, FiltroPerdaGanhoDTO filtro) {

		
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebCicloRN rn = new DetalheMonitorizacaoWebCicloRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PerdaGanhoDTO retorno = rn.getDetalheRitmoTabela(filtro);
			dao.commitaTransacao();
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

	private FiltroMonitorizacaoDTO converteFiltro(FiltroMonitDTO filtro, DAOGenerico dao) {
		FiltroMonitorizacaoDTO filtroDTO = new FiltroMonitorizacaoDTO();
		filtroDTO.setCdGt(filtro.getCdGt());
		
		if (filtro.getDtReferencia() != null) {
			filtroDTO.setDtReferencia(DataHoraRN.dateToStringDDMMYYYY(DataHoraRN.stringToDate(filtro.getDtReferencia(), "yyyy-MM-dd")));			
			filtroDTO.setIdTurno(filtro.getIdTurno());
		}
		
		filtroDTO.setFiltroOp(filtro.getFiltroOp());
		filtroDTO.setTurnoAtual(filtro.getTurnoAtual());
		
		OmGtDAO rn = new OmGtDAO(dao.getSession());
		OmGt gt = rn.getOmGtPorCdAtivo(filtro.getCdGt());
		filtroDTO.setListaFiltroIdGt(new ArrayList<Long>());
		filtroDTO.getListaFiltroIdGt().add(gt.getIdGt());
		rn = null;
		
		return filtroDTO;
	}
	
	private MonitorizacaoDTO atualizaFiltroClickPt(MonitorizacaoDTO monitorizacaoDTO) {
		for (FiltroDetalhePostoDTO filtroPt : monitorizacaoDTO.getFiltro().getListaFiltroPosto()) {
			
			// varre e atribui filtro
			for (PtMonitDTO pt : monitorizacaoDTO.getInfoPts()) {
				if (pt.getCdPt().equals(filtroPt.getCdPosto())) {
					pt.setFiltroClickPt(filtroPt);
					pt.getFiltroClickPt().setDtReferencia(ddMMyyyyTOyyyMMdd(pt.getFiltroClickPt().getDtReferencia()));
					break;
				}
			}
		}
		
		return monitorizacaoDTO;
	}
	
	private String ddMMyyyyTOyyyMMdd(String dtDMY) {
		return DataHoraRN.toStringYYYYMMDD(DataHoraRN.stringToDate(dtDMY, "dd/MM/yyyy"));
	}
	
	private String yyyyMMddTOddMMYYY(String dtYMD) {
		return DataHoraRN.dateToString(DataHoraRN.stringToDate(dtYMD, "yyyy-MM-dd"), "dd/MM/yyyy");
	}

	@POST
	@Path("/analiseturno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnaliseTurno(@Context HttpServletRequest request, FiltroMonitDTO filtro) {
		TokenFilter.validarNIDW(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			// recupera dados do tempo real 
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			FiltroMonitorizacaoDTO filtroDTO = converteFiltro(filtro, dao);			
			MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtroDTO);
			monitorizacaoDTO = atualizaFiltroClickPt(monitorizacaoDTO);
			if (monitorizacaoDTO == null) {
				throw new Exception("Error");
			}
			
			// recupera bi
			TurnoRN rnT = new TurnoRN(dao);
			DwTurno tur = rnT.getDwTurnoPorId(filtro.getIdTurno());
			
			FiltroAgrupamentoBI agrupamento = FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO;
			BiFiltroDTO filtroBI = new BiFiltroDTO();
			filtroBI.setAgrupamentoBI(FiltroAgrupamentoBI.BI_TOTAL_MAQUINA_ULTIMA_OP_TURNO.getValor());
			filtroBI.setDtIni(filtro.getDtReferencia());
			filtroBI.setDtFim(filtroBI.getDtIni());
			filtroBI.setCdTurno(tur.getCdTurno());
			filtroBI.setCdGt(filtro.getCdGt());
			
			BiWebRN rnBI = new BiWebRN(dao,FORMATO_DATA,FORMATO_DATA_HORA);
			BiResumoDTO resumoBIDTO = rnBI.resumoBI(filtroBI, agrupamento);
			dao.commitaTransacao();
			if(resumoBIDTO == null) {
				throw new Exception("Error");
			}
			
			rnT = null;
			rn = null;
			rnBI = null;
			 
			// junta info no DTO abaixo
			AnaliseTurnoDTO2 analiseTurno = setAnaliseTurno(monitorizacaoDTO, resumoBIDTO);
			
			dao.commitaTransacao();
			String json = gson.toJson(analiseTurno);
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
	
	private AnaliseTurnoDTO2 setAnaliseTurno(MonitorizacaoDTO monitorizacaoDTO, BiResumoDTO resumoBI) {
		AnaliseTurnoDTO2 retorno = new AnaliseTurnoDTO2();
		List<PtMonitDTO> infoPts = monitorizacaoDTO.getInfoPts();
		
		// guia producao
		retorno.setProducao(new AnaliseTurnoProducaoDTO());
		retorno.getProducao().setEfiRea(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiRea()).setScale(2, RoundingMode.HALF_UP));
		retorno.getProducao().setProdPlan(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getProdPlan()).setScale(0, RoundingMode.HALF_UP));
		retorno.getProducao().setProdPrev(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdPrev()).setScale(0, RoundingMode.HALF_UP));
		retorno.getProducao().setProdLiq(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdLiquida()).setScale(0, RoundingMode.HALF_UP));
		retorno.getProducao().setProdPerdas(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsPerdasTotal()).setScale(0, RoundingMode.HALF_UP));
		retorno.getProducao().setIndPerdas(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPerdas()).setScale(2, RoundingMode.HALF_UP));
		retorno.getProducao().setOee(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndOEE()).setScale(2, RoundingMode.HALF_UP));
		
		
		// guia paradas
		retorno.setParadas(new AnaliseTurnoParadasDTO());
		retorno.getParadas().setIndPar(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPar()).setScale(2, RoundingMode.HALF_UP));
		retorno.getParadas().setProdPerdasPar(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsPerdasParComPeso()).setScale(0, RoundingMode.HALF_UP)); 
		retorno.getParadas().setTempoPar(resumoBI.getIndicadores().getHrsParComPeso());
		
		// guia ciclos
		retorno.setCiclos(new AnaliseTurnoCiclosDTO());
		retorno.getCiclos().setEfic(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiCic()).setScale(2, RoundingMode.HALF_UP));
		retorno.getCiclos().setPerdasCic(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsRitmo()).setScale(0, RoundingMode.HALF_UP));
		
		// guia refugos
		retorno.setRefugos(new AnaliseTurnoRefugosDTO());
		retorno.getRefugos().setIndRef(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndRef()).setScale(2, RoundingMode.HALF_UP));
		retorno.getRefugos().setProdRef(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdRefugada()).setScale(0, RoundingMode.HALF_UP));
		
		// guia qtd aloca
		retorno.setAloc(new AnaliseTurnoQtdAlocDTO());
		retorno.getAloc().setIndQtdAloc(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPCA()).setScale(2, RoundingMode.HALF_UP));
		
		// det postos e grafico
		retorno.setDetalhesPts(new ArrayList<AnaliseTurnoProducaoPTDTO>());
		retorno.setGraficosPts(new ArrayList<AnaliseTurnoIndicadoresPTDTO>());
		
		for (BiIndicadoresPTDTO ptDet : resumoBI.getIndicadoresPt()) {
			AnaliseTurnoProducaoPTDTO det = new AnaliseTurnoProducaoPTDTO();
			det.setCdPt(ptDet.getCdPt());
			det.setEfiCic(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiCic()).setScale(2, RoundingMode.HALF_UP));
			det.setEfiRea(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiRea()).setScale(2, RoundingMode.HALF_UP));
			det.setIndQtdAloc(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPCA()).setScale(2, RoundingMode.HALF_UP));
			det.setProdBruta(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdBruta()).setScale(0, RoundingMode.HALF_UP));
			det.setProdPlan(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getProdPlan()).setScale(0, RoundingMode.HALF_UP));
			det.setProdPrev(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdPrev()).setScale(0, RoundingMode.HALF_UP));
			det.setProdRef(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getPcsProdRefugada()).setScale(0, RoundingMode.HALF_UP));
			retorno.getDetalhesPts().add(det);
			
			
			AnaliseTurnoIndicadoresPTDTO graf = new AnaliseTurnoIndicadoresPTDTO();
			graf.setCdPt(ptDet.getCdPt());
			graf.setEfiRea(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiRea()).setScale(2, RoundingMode.HALF_UP));
			graf.setEfiCic(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getEfiCic()).setScale(2, RoundingMode.HALF_UP));
			graf.setIndRef(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndRef()).setScale(2, RoundingMode.HALF_UP));
			graf.setIndPar(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPar()).setScale(2, RoundingMode.HALF_UP));
			graf.setIndQtdAloc(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndPCA()).setScale(2, RoundingMode.HALF_UP));
			graf.setOee(ConversaoTipos.converterParaBigDecimal(resumoBI.getIndicadores().getIndOEE()).setScale(2, RoundingMode.HALF_UP));
			
			// recupera info do click
			for (PtMonitDTO ptmon : infoPts) {
				if (ptmon.getCdPt().equals(graf.getCdPt())) {
					graf.setEfiInst(ptmon.getEfiInst());
					graf.setFiltroClick(ptmon.getFiltroClickPt());
					break;					
				}
			}
			
			retorno.getGraficosPts().add(graf);
		}

		// guia ciclos - media das efi inst
		// recupera info do click
		BigDecimal somaEficinst = BigDecimal.ZERO;
		BigDecimal efiInstMedia = BigDecimal.ZERO;
		for (PtMonitDTO ptmon : infoPts) {
			somaEficinst = AritmeticaUtil.somar(somaEficinst, ptmon.getEfiInst());
		}
		
		if (infoPts.size() > 0) {
			efiInstMedia = AritmeticaUtil.dividir(somaEficinst, new BigDecimal(infoPts.size()));
		}
		
		retorno.getCiclos().setEfiInst(efiInstMedia.setScale(2, RoundingMode.HALF_UP));
		
		
		// graf postos
		retorno.setMetaIndicadores(resumoBI.getMetaIndicadores());
		
		 
		
		return retorno;
	}
}

package idw.webservices.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
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
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.AreaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.RelatorioIndiceParadasRN;
import idw.model.rn.RelatorioProdutividadeR42RN;
import idw.model.rn.RelatorioProdutividadeRN;
import idw.model.rn.alimentacao.AlimentacaoRN;
import idw.model.rn.web.vf.monitorizacao.AnaliseGargaloWebRN;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.AnaliseTurnoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebCepRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebCicloRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebDefeitoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebMateriaPrimaRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebParadaRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebProducaoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRefugoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.model.rn.web.wm.ConsultasWebWmRN;
import idw.util.Util;
import idw.webservices.dto.AlimentacaoDTO;
import idw.webservices.dto.AlimentacoesDTO;
import idw.webservices.dto.DWParadaDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.DwTAreaDTO;
import idw.webservices.dto.DwTAreasDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.FiltroRelatorioIndiceParadasDTO;
import idw.webservices.dto.FiltroRelatorioProdutividadeR42DTO;
import idw.webservices.dto.ListaRelatorioIndiceParadaDTO;
import idw.webservices.dto.ListaRelatorioProdutividade;
import idw.webservices.dto.ParadasDTO;
import idw.webservices.dto.RelatorioProdutividadeR42DTO;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.TurnoDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseGargaloDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseTurnoDTO;
import idw.webservices.rest.dto.monitorizacao.CicloParadaDTO;
import idw.webservices.rest.dto.monitorizacao.ComboDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheCicloDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheOcorrenciasDTO;
import idw.webservices.rest.dto.monitorizacao.DetalheProducaoHoraDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheParadaDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroGraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMpDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepProcessoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoCepXDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoComponenteDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoEvolucaoCicloPadraoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPerdasMpDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaPerdaMateriaPrimaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficosDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.ParadasAbertasGtDTO;
import idw.webservices.rest.dto.monitorizacao.PerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaDetalheDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaRefugoHora;
import idw.webservices.rest.dto.monitorizacao.UltimosCicloDTO;
import idw.webservices.rest.dto.relatorios.AlimentacaoWebDTO;
import idw.webservices.rest.dto.relatorios.IndicadoresProdutividadeDTO;
import idw.webservices.rest.dto.relatorios.IndiceParadasDTO;
import idw.webservices.rest.dto.relatorios.ProdutividadeDTO;
import idw.webservices.rest.wm.dto.PtsGargaloDTO;
import idw.webservices.rest.wm.dto.PtsGargaloDinamicoDTO;
import idw.webservices.rest.wm.dto.PtsGargaloParadosDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.rn.IcRN;
import ms.model.rn.aoi.EventoAOIDTO;
import ms.model.rn.aoi.EventosAOIRN;
import ms.util.UtilsString;

@Path("/monitorizacao")
public class MonitorizacaoResource {

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

	@POST
	@Path("/postosativos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivos(@Context HttpServletRequest request, FiltroMonitorizacaoDTO filtro) {

		System.out.println(filtro);
		///202305 TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtro);
			dao.commitaTransacao();
			if (monitorizacaoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(monitorizacaoDTO);
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivosDEPRECATED(@Context HttpServletRequest request, FiltroMonitorizacaoDTO filtro) {

		System.out.println(filtro);
		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoWebRN rn = new MonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtro);
			dao.commitaTransacao();
			if (monitorizacaoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(monitorizacaoDTO);
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
	@Path("/analiseTurno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnaliseTurno(@Context HttpServletRequest request, FiltroMonitorizacaoDTO filtro) {

		System.out.println(filtro);
		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			AnaliseTurnoWebRN rn = new AnaliseTurnoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			AnaliseTurnoDTO analiseTurnoDTO = rn.getAnaliseTurno(filtro);
			dao.commitaTransacao();
			if (analiseTurnoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(analiseTurnoDTO);
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
	@Path("/analiseGargalo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnaliseGargalo(@Context HttpServletRequest request, FiltroMonitorizacaoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			AnaliseGargaloWebRN rn = new AnaliseGargaloWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			AnaliseGargaloDTO retorno = rn.getDetalhe(filtro);
			dao.commitaTransacao();
			if (retorno == null) {
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
	@Path("/detalhe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalhe(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);
		System.out.println(filtro);

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
	@Path("/detalheBKP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheBKP(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);
		System.out.println(filtro);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebRN rn = new DetalheMonitorizacaoWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PtMonitorizacaoDTO ptDTO = rn.getDetalhe(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			dao.commitaTransacao();
			if (ptDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(ptDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | PostoSemDadoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/detalhe/grafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheProducao(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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
	@Path("/detalhe/listaFiltroHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaFiltroHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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
	@Path("/detalhe/defeito")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheDefeito(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebDefeitoRN rn = new DetalheMonitorizacaoWebDefeitoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoDefeitoDTO graficoDTO = rn.getGraficosDefeitos(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
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
	@Path("/detalhe/defeito/componente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheDefeitoComponente(@Context HttpServletRequest request, FiltroDetalheDefeitoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();

		Gson gson = new Gson();

		Response.Status responseStatus = Response.Status.OK;

		try {

			dao.iniciaSessao();
			dao.iniciaTransacao();

			DetalheMonitorizacaoWebDefeitoRN rn = new DetalheMonitorizacaoWebDefeitoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);

			GraficoDefeitoComponenteDTO graficoDTO = rn.getGraficosDefeitosComponentes(filtro);

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
	@Path("/detalhe/defeito/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheDefeitoTabela(@Context HttpServletRequest request, FiltroDetalheDefeitoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebDefeitoRN rn = new DetalheMonitorizacaoWebDefeitoRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaDetalheDefeitoDTO> retorno = rn.getDetalheDefeitoTabela(filtro);
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

	@POST
	@Path("/detalhe/refugoOcorrencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoOcorrencia(@Context HttpServletRequest request, FiltroDetalheRefugoDTO filtro) {

		TokenFilter.validar(request);

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

		TokenFilter.validar(request);

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
	@Path("/detalhe/refugoHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);

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
	@Path("/detalhe/refugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugo(@Context HttpServletRequest request, FiltroGraficoRefugoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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

	// WM0
	@GET
	@Path("/paradasAberta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodasParadasAbertas(@Context HttpServletRequest request) {

		// TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaRN rn = new DetalheMonitorizacaoWebParadaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			ParadasAbertasGtDTO paradasDTO = rn.getTodasParadasAbertas();
			dao.commitaTransacao();
			if (paradasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(paradasDTO);
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

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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
	@Path("/detalhe/paradaHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaHora(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validar(request);

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
	@Path("/detalhe/paradaOcorrencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParadaOcorrencia(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {

		TokenFilter.validar(request);

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

		TokenFilter.validar(request);

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

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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
	@Path("/detalhe/materiaPrima")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheGraficoPerdas(@Context HttpServletRequest request, FiltroMpDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebMateriaPrimaRN rn = new DetalheMonitorizacaoWebMateriaPrimaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoPerdasMpDTO perdasMpDTO = rn.getPerdasMateriaPrima(filtro);
			dao.commitaTransacao();
			if (perdasMpDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(perdasMpDTO);
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
	@Path("/wm/detalhe/materiaPrima")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheMateriaPrima(@Context HttpServletRequest request, FiltroMpDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {

			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebMateriaPrimaRN drn = new DetalheMonitorizacaoWebMateriaPrimaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoPerdasMpDTO  perdasMpDTO = drn.getPerdasMateriaPrimaWM(filtro);
			
			
			dao.commitaTransacao();
			if (perdasMpDTO == null) {
				throw new JsonException("Error");
			}
			
			String json = gson.toJson(perdasMpDTO);
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
	@Path("/detalhe/materiaPrimaRecorrenciaPareto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheMateriaPrimaRecorrenciaPareto(@Context HttpServletRequest request, FiltroMpDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebMateriaPrimaRN rn = new DetalheMonitorizacaoWebMateriaPrimaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRecorrenciaPerdaMateriaPrimaDTO grafico = rn.getPerdasMateriaPrimaOcorrencia(filtro);
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
	@Path("/detalhe/variacaoCiclo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVariacaoDeRitmo(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
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
	
	@GET
	@Path("/detalhe/cicloPadrao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCicloPadrao(
			@Context HttpServletRequest request,
			@QueryParam("cdPt") String cdPt,
			@QueryParam("cdFolha") String cdFolha) {

		TokenFilter.validar(request);

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

		TokenFilter.validar(request);

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

	@GET
	@Path("/turnoAtual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnoAtual(@Context HttpServletRequest request, @QueryParam("cdGt") String cdGt) {

		TokenFilter.validar(request);

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
	@Path("/detalhe/cep/parametrosCep")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParametrosCEP(@Context HttpServletRequest request) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<ComboDTO> parametros = rn.getParametrosCEP();
			dao.commitaTransacao();
			rootElement.add("parametros", gson.toJsonTree(parametros));
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
	@Path("/detalhe/cep/graficoX")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCepGraficoX(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoCepXDTO grafico =
					rn.getGraficoCepX(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			// Dados da coleta KIC (Referência de temperatura das zonas)
			GraficoCepXDTO grafico2 =
					rn.getGraficoCepX2(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));

			dao.commitaTransacao();
			if (grafico == null) {
				throw new JsonException("Error");
			}
			if (grafico2 == null) {
				throw new JsonException("Error2");
			}

			String json = gson.toJson(grafico);
			json = json.substring(0, json.length() - 1);
			json = json.concat(",");

			String jsonAux = gson.toJson(grafico2);
			jsonAux = jsonAux.substring(1);
			jsonAux = jsonAux.replace("valores", "valores2");
			json = json.concat(jsonAux);

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
	@Path("/detalhe/cep/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaCep(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaCepDTO> tabela =
					rn.getCepTabela(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			dao.commitaTransacao();
			if (tabela == null) {
				throw new JsonException("Error");
			}
			rootElement.add("tabela", gson.toJsonTree(tabela));
			String json = gson.toJson(rootElement);
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
	@Path("/detalhe/cep/tabelagrafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaGraficoCep(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaGraficoCepDTO> tabela =
					rn.getCepTabelaGrafico(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			dao.commitaTransacao();
			if (tabela == null) {
				throw new JsonException("Error");
			}
			rootElement.add("tabela", gson.toJsonTree(tabela));
			String json = gson.toJson(rootElement);
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
	@Path("/detalhe/cep/graficoProcesso")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCepGraficoProcesso(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {

		TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<GraficoCepProcessoDTO> grafico = rn.getGraficoCepProcesso(filtro);
			dao.commitaTransacao();
			if (grafico == null) {
				throw new JsonException("Error");
			}
			rootElement.add("grafico", gson.toJsonTree(grafico));
			String json = gson.toJson(rootElement);
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
	@Path("/detalhe/ritmo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRitmo(@Context HttpServletRequest request, FiltroPerdaGanhoDTO filtro) {

		System.out.println(filtro);
		TokenFilter.validar(request);

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

		System.out.println(filtro);
		TokenFilter.validar(request);

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

	// WM1 -item4
	@GET
	@Path("/wm/linhasParadas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLinhasParadas(@Context HttpServletRequest request) {

		// TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebWmRN rn = new ConsultasWebWmRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			ParadasAbertasGtDTO paradasDTO = rn.getLinhasParadas();
			dao.commitaTransacao();
			if (paradasDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(paradasDTO);
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

	// WM2 -item1
	@GET
	@Path("/wm/maquinasGargaloParadas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaquinasGargaloParadas(@Context HttpServletRequest request) {

		// TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebWmRN rn = new ConsultasWebWmRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PtsGargaloParadosDTO retornoDTO = rn.getPtsGargaloParados();
			dao.commitaTransacao();
			if (retornoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retornoDTO);
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

	// WM3 -item2
	@GET
	@Path("/wm/maquinasGargaloDinamico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaquinasGargaloDinamico(@Context HttpServletRequest request) {

		// TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebWmRN rn = new ConsultasWebWmRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PtsGargaloDinamicoDTO retornoDTO = rn.getPtsGargaloDinamico();
			dao.commitaTransacao();
			if (retornoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retornoDTO);
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

	//
	// WM4 -item3
	@GET
	@Path("/wm/maquinasGargaloExtrapola5p")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPtsGargaloExtrapola5p(@Context HttpServletRequest request) {

		// TokenFilter.validar(request);

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebWmRN rn = new ConsultasWebWmRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PtsGargaloDTO retornoDTO = rn.getPtsGargaloExtrapola5p();
			dao.commitaTransacao();
			if (retornoDTO == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retornoDTO);
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
	@Path("/relatorioAlimentacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRelatorioAlimentacao(@Context HttpServletRequest request, AlimentacaoWebDTO filtro) {

		TokenFilter.validar(request);

		AlimentacaoRN rn = new AlimentacaoRN();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {

			AlimentacaoDTO alimentacao = new AlimentacaoDTO();
			alimentacao.setAlimentacao(new OmAlim());
			alimentacao.getAlimentacao().setIdAlim(0);
			alimentacao.getAlimentacao().setTpAlim(filtro.getTpAlim());
			alimentacao.getAlimentacao().setStAlim(filtro.getStAlim());
			alimentacao.getAlimentacao().setOmMapa(new OmMapa());
			alimentacao.getAlimentacao().setCdAlim("");
			alimentacao.getAlimentacao().setDsAlim("");
			alimentacao.getAlimentacao().getOmMapa().setOmPt(new OmPt());
			alimentacao.getAlimentacao().getOmMapa().getOmPt().setCdPt(filtro.getCdPt());
			alimentacao.getAlimentacao().getOmMapa().getOmPt().setDsPt(filtro.getCdPt());
			alimentacao.setCdGt(filtro.getCdGt());
			alimentacao.setDtILeitura(new Date(filtro.getDthrIni()));
			alimentacao.setDtFLeitura(new Date(filtro.getDthrFim()));
			alimentacao.getAlimentacao().getOmMapa().setCdMapa(filtro.getCdMapa());
			alimentacao.getAlimentacao().getOmMapa().setDsMapa(filtro.getCdMapa());
			alimentacao.getAlimentacao().setOmUsr(new OmUsr());
			alimentacao.getAlimentacao().getOmUsr().setCdUsr("");
			alimentacao.getAlimentacao().getOmUsr().setDsNome("");
			alimentacao.setCdProduto(filtro.getCdProduto());

			AlimentacoesDTO alimentacoes = null;
			rn.iniciaConexaoBanco();
			alimentacoes = rn.getAlimentacoesDTO(alimentacao);

			if (alimentacoes == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(alimentacoes);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	@POST
	@Path("/relatorioProdutividade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRelatorioProdutividade(@Context HttpServletRequest request, ProdutividadeDTO filtroWeb) {

		TokenFilter.validar(request);

		RelatorioProdutividadeRN rn = new RelatorioProdutividadeRN();
		ListaRelatorioProdutividade retorno = new ListaRelatorioProdutividade();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {

			DwConsolid filtro = new DwConsolid();
			filtro.setDthrFhora(new Date(filtroWeb.getDthrFim()));
			filtro.setDthrIhora(new Date(filtroWeb.getDthrIni()));
			filtro.setOmPt(new OmPt());
			filtro.getOmPt().setOmGt(new OmGt());
			filtro.getOmPt().getOmGt().setCdGt(filtroWeb.getLinha());
			filtro.getOmPt().getOmGt().setDsGt(filtroWeb.getLinha());
			// filtro.getOmPt().getOmGt().setOmGtfase(new OmGt());
			// filtro.getOmPt().getOmGt().getOmGtfase().setCdGt(filtroWeb.getFase());
			// filtro.getOmPt().getOmGt().getOmGtfase().setDsGt(filtroWeb.getFase());

			PpCpproduto cpproduto = new PpCpproduto();

			cpproduto.setNrDoc(filtroWeb.getOp());

			filtro.setPpCp(new PpCp());
			filtro.getPpCp().getPpCpprodutos().add(cpproduto);
			//
			// OmProduto produtoFinal = new OmProduto();
			// produtoFinal.setCdProduto(filtroWeb.getModelo());
			// produtoFinal.setDsProduto(filtroWeb.getModelo());
			//
			// filtro.getPpCp().getPpCpprodutos().iterator().next().setOmProduto(produtoFinal);

			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProdutividade(filtro);

			if (retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}

	}

	@POST
	@Path("/relatorioIndiceParadas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRelatorioIndiceParadas(@Context HttpServletRequest request, IndiceParadasDTO filtroWeb) {

		TokenFilter.validar(request);

		ParadaRN rnParada = new ParadaRN();
		ParadasDTO paradas = new ParadasDTO();
		List<DwTParada> paradasAux = new ArrayList<DwTParada>();
		AreaRN rnAreas = new AreaRN();
		DwTAreasDTO areas = new DwTAreasDTO();
		List<DwTArea> areasAux = new ArrayList<DwTArea>();
		RelatorioIndiceParadasRN rn = new RelatorioIndiceParadasRN();
		ListaRelatorioIndiceParadaDTO retorno = new ListaRelatorioIndiceParadaDTO();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		// Primeira etapa: obtenção das paradas ativas

		try {
			rnParada.iniciaConexaoBanco();
			paradas = rnParada.getListaParadasAtivas(new OmTppt());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rnParada.finalizaConexaoBanco();
		}
		rnParada = null;
		for (DWParadaDTO parada : paradas.getDwTParadas()) {
			paradasAux.add(parada.getDwTParada());
		}

		// Segunda etapa:Obtenção das áreas

		try {
			rnAreas.iniciaConexaoBanco();
			areas = rnAreas.getListaAreasAtivas();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rnAreas.finalizaConexaoBanco();
		}
		rnAreas = null;
		for (DwTAreaDTO area : areas.getListaAreasDTO()) {
			areasAux.add(area.getDwTArea());
		}
		OmPt ompt = new OmPt();
		// Terceira etapa: Obtenção do OmPt
		if (filtroWeb.getCdPt() != null && !filtroWeb.getCdPt().equals("")) {
			PTRN rnPt = new PTRN();
			try {
				rnPt.iniciaConexaoBanco();
				ompt = rnPt.pesquisarPtByCdPtStAtivo(filtroWeb.getCdPt());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rnPt.finalizaConexaoBanco();
				rnPt = null;
			}
		}

		// Por fim: construção do filtro e relização da consulta
		try {
			FiltroRelatorioIndiceParadasDTO filtro = new FiltroRelatorioIndiceParadasDTO();

			if (filtroWeb.getOp() != null && !filtroWeb.getOp().equals("")) {
				filtro.setCdop(filtroWeb.getOp());
			}

			if (!filtroWeb.getCdPt().equals("") && filtroWeb.getCdPt() != null) {
				filtro.setOmpt(ompt);
			}
			if (filtroWeb.getIsTodasAreas()) {
				filtro.setDwTAreas(areasAux);
			} else
				filtro.setDwTAreas(filtroWeb.getAreas());

			if (filtroWeb.getIsTodasParadas()) {
				filtro.setDwTParadas(paradasAux);
			} else
				filtro.setDwTParadas(filtroWeb.getParadas());

			filtro.setIsTodasAreas(filtroWeb.getIsTodasAreas());
			filtro.setIsTodasParadas(filtroWeb.getIsTodasParadas());
			filtro.setPeriodoFinal(new Date(filtroWeb.getDthrFim()));
			filtro.setPeriodoInicial(new Date(filtroWeb.getDthrIni()));
			filtro.setTipo(filtroWeb.getTipo());
			filtro.setTurnoDTO(filtroWeb.getTurno());
			filtro.setIsRetirarParadasPequenas(filtroWeb.getIsRetirarParadasPequenas());

			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioIndiceParadas(filtro);

			if (retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}

	}

	@POST
	@Path("/relatorioIndicadoresProdutividade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRelatorioIndicadoresProdutividade(@Context HttpServletRequest request, IndicadoresProdutividadeDTO filtroWeb) {

		TokenFilter.validar(request);

		RelatorioProdutividadeR42RN rn = new RelatorioProdutividadeR42RN();
		RelatorioProdutividadeR42DTO retorno = null;
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		OmPt ompt = new OmPt();
		if (filtroWeb.getCdPt() != null && !filtroWeb.getCdPt().equals("")) {
			PTRN rnPt = new PTRN();
			try {
				rnPt.iniciaConexaoBanco();
				ompt = rnPt.pesquisarPtByCdPtStAtivo(filtroWeb.getCdPt());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rnPt.finalizaConexaoBanco();
				rnPt = null;
			}
		}
		OmGt omgt = new OmGt();
		if (filtroWeb.getCdGt() != null && !filtroWeb.getCdGt().equals("")) {
			GTRN rnGt = new GTRN();
			try {
				rnGt.iniciaConexaoBanco();
				omgt = rnGt.getOmGtByCdGt(filtroWeb.getCdGt());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rnGt.finalizaConexaoBanco();
				rnGt = null;
			}
		}

		try {
			FiltroRelatorioProdutividadeR42DTO filtro = new FiltroRelatorioProdutividadeR42DTO();

			if (ompt.getCdPt() != null) {
				filtro.setOmpt(ompt);
			}
			if (omgt.getCdGt() != null) {
				filtro.setOmgt(omgt);
			}

			filtro.setPeriodoFinal(new Date(filtroWeb.getDthrFim()));
			filtro.setPeriodoInicial(new Date(filtroWeb.getDthrIni()));
			filtro.setTurnoDTO(filtroWeb.getTurno());

			rn.iniciaConexaoBanco();
			retorno = rn.getRelatorioProdutividadeR42DTO(filtro);

			if (retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	// Método para obter as Ops dos últimos 3 meses
	@GET
	@Path("/obterOps")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOps(@Context HttpServletRequest request) {

		TokenFilter.validar(request);

		CpRN rn = new CpRN();
		List<String> retorno = new ArrayList<>();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {

			rn.iniciaConexaoBanco();
			Date dataFim = new Date(System.currentTimeMillis());
			Date dataIni = new Date(System.currentTimeMillis() - 31536000000L);
			retorno = rn.pesquisarPpCpIntervaloDatas(dataIni, dataFim);

			if (retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}

	}

	@GET
	@Path("/coletorUp")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsup(@Context HttpServletRequest request) {

		String url = (String) request.getParameter("url");
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		IcRN rn = new IcRN();
		IcDTO retorno = new IcDTO();

		try {

			rn.iniciaConexaoBanco(null);
			retorno = rn.pesquisarMsIcPorUrlConexao(url);

			if (retorno == null) {
				throw new JsonException("Error");
			}
			List<String> aux = new ArrayList<String>();
			aux.add(retorno.getMsIcUpDTOLocais().get(0).getUrlConexao());
			aux.add(retorno.getMsIcUpDTOLocais().get(0).getUrlAuxiliar());
			aux.add(retorno.getMsIcUpDTOLocais().get(0).getUpDTO().getCd_up());
			aux.add(retorno.getCd_ic());
			
			// Alessandre em 21-01-20 enviar tambem a OP, codigo do produto e se o CB deve ser lido ou nao
			aux.add(retorno.getMsIcUpDTOLocais().get(0).getUpDTO().getNropestendido());
			aux.add(retorno.getMsIcUpDTOLocais().get(0).getUpDTO().getCdproduto());
			aux.add(String.valueOf(retorno.getMsIcUpDTOLocais().get(0).getUpDTO().isLerCB()));
			
			String json = gson.toJson(aux);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {

			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}
	}

	@GET
	@Path("/coletorHeartbeat")
	 @Produces(MediaType.APPLICATION_JSON)
	public Response sendHeartbeat(@Context HttpServletRequest request) {

		String ic = (String) request.getParameter("ic");
		Date data = new Date(System.currentTimeMillis());
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			EventoColetado eventoColetado = new EventoColetado();
			eventoColetado.setDthrEvento(data);
			eventoColetado.setIdentacao(0);
			MsFacade.getInstancia().icHeartBeat(0, ic, eventoColetado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = gson.toJson("OK");
		return Response.status(responseStatus).entity(json).build();
	}
	
	public static void main(String[] args) {
		EventosAOIRN rn = new EventosAOIRN();
		EventoAOIDTO retorno = null;
		String cdup=null,nrop=null,nomeArquivo=null,nomeMaquina,barcode,dataHora,sideCode,urlConexao;
		
		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		Date data = new Date(System.currentTimeMillis());
		EventoColetado eventos = new EventoColetado();
		Gson gson = new Gson();
		String status = "OK";

		if(status.equals("OK")){
			cdup = "AOIL12";
			nrop= "01176001005";
			nomeArquivo="teste.log";
			nomeMaquina = "AOIL12";
			sideCode = "";
			barcode = "B210927711";
			dataHora = DataHoraRN.getDataHoraAtualFormatada();
			urlConexao = "192.168.62.201:8080";
			
			data = UtilsString.dateTimeStringToDateOMRON(dataHora);
			
			eventos.setUp(cdup);
			eventos.setCdop(nrop);
			eventos.setOrigem(nomeArquivo);
			eventos.setCb(barcode);
			eventos.setDthrEvento(data);
			eventos.setTipoEvento(ServicoFactory._PASSAGEM);
			eventos.setIsCbConforme(true);
			
		}else{
			
			cdup = "AOIL12";
			nrop= "01176001005";
			nomeArquivo="teste.log";
			nomeMaquina = "AOIL12";
			sideCode = "";
			barcode = "B210927711";
			dataHora = DataHoraRN.getDataHoraAtualFormatada();
			urlConexao = "192.168.62.201:8080";
			
			data = UtilsString.dateTimeStringToDateOMRON(dataHora);
			
			eventos.setUp(cdup);
			eventos.setCdop(nrop);
			eventos.setOrigem(nomeArquivo);
			eventos.setCb(barcode);
			eventos.setDthrEvento(data);
			eventos.setTipoEvento(ServicoFactory._PASSAGEM);
			//Por enquanto toda passagem é com CB true
			//eventos.setIsCbConforme(false);
			eventos.setIsCbConforme(true);
			
			
						
		}										
		
		try {

			
			rn.iniciaConexaoBanco();
			retorno = rn.processaArquivoAoi(cdup, nrop, nomeArquivo, eventos,sideCode,nomeMaquina );
			

		} 
		catch (Exception e) {
		} finally {
			rn.finalizaConexaoBanco();
		}
	}
	
	@GET
	@Path("/coletorSendEvento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setEvento(@Context HttpServletRequest request) {

		EventosAOIRN rn = new EventosAOIRN();
		EventoAOIDTO retorno = null;
		String cdup=null,nrop=null,nomeArquivo=null,nomeMaquina,barcode,dataHora,sideCode,urlConexao;
		
		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		Date data = new Date(System.currentTimeMillis());
		EventoColetado eventos = new EventoColetado();
		Gson gson = new Gson();
		String status = (String) request.getParameter("statusPlaca");
		if(status.equals("OK")){
			cdup = (String) request.getParameter("cdup");
			nrop=(String) request.getParameter("nrop");
			nomeArquivo=(String) request.getParameter("nomeArquivo");
			nomeMaquina = (String) request.getParameter("nomeMaquina");
			sideCode = (String)request.getParameter("sideCode");
			barcode = (String) request.getParameter("barcode");
			try {
				dataHora = (String ) request.getParameter("data").replace("!", " ");
			} catch (Exception e) {
				dataHora = null;
			}
			urlConexao = (String)request.getParameter("urlConexao");
			
			if (dataHora == null || dataHora.equals(""))
				data = DataHoraRN.getDataHoraAtual();
			else
				data = UtilsString.dateTimeStringToDateOMRON(dataHora);
			
			eventos.setUp(cdup);
			eventos.setCdop(nrop);
			eventos.setOrigem(nomeArquivo);
			eventos.setCb(barcode);
			eventos.setDthrEvento(data);
			eventos.setTipoEvento(ServicoFactory._PASSAGEM);
			eventos.setIsCbConforme(true);
			
		}else{
			
			cdup = (String) request.getParameter("cdup");
			nrop=(String) request.getParameter("nrop");
			nomeArquivo=(String) request.getParameter("nomeArquivo");
			nomeMaquina = (String) request.getParameter("nomeMaquina");
			barcode = (String) request.getParameter("barcode");
			sideCode = (String)request.getParameter("sideCode");
			try {
				dataHora = (String ) request.getParameter("data").replace("!", " ");
			} catch (Exception e) {
				dataHora = null;
			}
			urlConexao = (String)request.getParameter("urlConexao");
			
			if (dataHora == null || dataHora.equals(""))
				data = DataHoraRN.getDataHoraAtual();
			else
				data = UtilsString.dateTimeStringToDateOMRON(dataHora);
			
			eventos.setUp(cdup);
			eventos.setCdop(nrop);
			eventos.setOrigem(nomeArquivo);
			eventos.setCb(barcode);
			eventos.setDthrEvento(data);
			eventos.setTipoEvento(ServicoFactory._PASSAGEM);
			//Por enquanto toda passagem é com CB true
			//eventos.setIsCbConforme(false);
			eventos.setIsCbConforme(true);
			
			
			Enumeration<String> params = request.getParameterNames();
			
			while(params.hasMoreElements()){
				
				String paramName = params.nextElement();
				if(paramName.contains("defeitos")){
				String def = request.getParameter(paramName);
				String[] linhaSplitadaDefeito = UtilsString.safeSplit(def, ",");
				DefeitoDTO defeito = new DefeitoDTO();
				defeito.setCdDefeito(linhaSplitadaDefeito[2]); //revisedFaultId
				defeito.setDthrDefeito(data);
				defeito.setCb(linhaSplitadaDefeito[1]); // codigo do componente partsArticleNo
				defeito.setPosicoes(linhaSplitadaDefeito[0]); // Posicao Mecanica 
				defeitos.add(defeito);
				}
			}
			eventos.setDefeitos(defeitos);
			
			
						
		}										
		
		Response.Status responseStatus = Response.Status.OK;
		IcRN rnIc = new IcRN();
		IcDTO icdto = new IcDTO();
		try{
			
			rnIc.iniciaConexaoBanco(null);
			icdto = rnIc.pesquisarMsIcPorUrlConexao(urlConexao);
			icdto.setEmailAoiNC(Util.getConfigGeral(rnIc.getDao().getSession()).getEmailaoi());
			eventos.setIcUpDTO(icdto.getMsIcUpDTOLocais().get(0));
			eventos.getIcUpDTO().getIc().setTp_ic(3);
			eventos.getIcUpDTO().getIc().setEmailAoiNC(icdto.getEmailAoiNC());
		}catch(Exception e){
			
		}finally{
			rnIc.finalizaConexaoBanco();
		}
		
		try {

			
			rn.iniciaConexaoBanco();
			retorno = rn.processaArquivoAoi(cdup, nrop, nomeArquivo, eventos,sideCode,nomeMaquina );
			

			if (retorno == null) {
				throw new JsonException("Error");
			}
			
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} 
		catch (JsonException e) {
			
			e.printStackTrace();
			retorno = new EventoAOIDTO();
			retorno.setStEnvio(EventoAOIDTO._ST_ENVIO._FALHA.getStEnvio());
			retorno.setCdParada(e.getMessage());
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			rn.finalizaConexaoBanco();
		}
	}
}

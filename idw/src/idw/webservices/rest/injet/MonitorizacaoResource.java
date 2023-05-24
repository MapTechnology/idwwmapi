package idw.webservices.rest.injet;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.rn.injet.TurnoInjetRN;
import idw.model.rn.monitorizacao.injet.TempoRealInjetRN;
import idw.model.rn.web.injet.monitorizacao.MonitorizacaoInjetWebRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.AnaliseTurnoWebInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebCepInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebCicloInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebParadaInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebProducaoInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.DetalheMonitorizacaoWebRefugoInjetRN;
import idw.model.rn.web.injet.monitorizacao.detalhe.FiltroWebInjetRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebCepRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebCicloRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebDefeitoRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebMateriaPrimaRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.FolhaCEPDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.TurnoDTO;
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
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoComponenteDetalheDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoEvolucaoCicloPadraoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoParadaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoPerdasMpDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRecorrenciaDTO;
import idw.webservices.rest.dto.monitorizacao.GraficoRefugoDTO;
import idw.webservices.rest.dto.monitorizacao.GraficosDTO;
import idw.webservices.rest.dto.monitorizacao.LegendaDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PerdaGanhoDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaDetalheDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaGraficoCepDTO;
import idw.webservices.rest.dto.monitorizacao.TabelaRefugoHora;
import idw.webservices.rest.dto.monitorizacao.UltimosCicloDTO;
import idw.webservices.rest.dto.monitorizacao.injet.FiltroTempoRealMaquinaSulbrasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealIHMWebDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealMaquinaSulbrasDTO;

@Path("/injet/monitorizacao")
public class MonitorizacaoResource {
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivos(FiltroMonitorizacaoDTO filtro) {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoInjetWebRN rn = new MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			MonitorizacaoDTO monitorizacaoDTO = rn.getMonitorizacao(filtro);
			dao.commitaTransacao();
			if(monitorizacaoDTO == null) {
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
	@Path("/injettemporealihmweb")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTempoRealIHMWeb(FiltroTempoRealMaquinaSulbrasDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			TempoRealInjetRN rn = new TempoRealInjetRN(dao);
			TempoRealIHMWebDTO tempoRealIHMWebDTO = rn.getTempoRealIHMWeb(filtro);
			dao.commitaTransacao();
			if(tempoRealIHMWebDTO.getCdMaquina().equals("")) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(tempoRealIHMWebDTO);
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

	/*
	@POST
	@Path("/injettemporealihmweb3")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTempoRealIHMWeb3(String urlIP) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico daoVF = new DAOGenerico();		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			TempoRealInjetRN rn = new TempoRealInjetRN(dao);
			MaquinasTempoRealIHMWebDTO tempoRealIHMWebDTO = rn.getTempoRealIHMWeb3(urlIP, daoVF);

			dao.commitaTransacao();
			daoVF.commitaTransacao();

			if(tempoRealIHMWebDTO.getMaquinas().size() == 0) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(tempoRealIHMWebDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
			daoVF.finalizaSessaoSemException();
		}
	}
	*/
	
	
	@POST
	@Path("/injetsmarttvweb")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTempoRealMaqSulbras(FiltroTempoRealMaquinaSulbrasDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			TempoRealInjetRN rn = new TempoRealInjetRN(dao);
			TempoRealMaquinaSulbrasDTO tempoRealMaqSulbrasDTO = rn.getTempoRealMaquinaSulbras(filtro);
			dao.commitaTransacao();
			if(tempoRealMaqSulbrasDTO.getCdMaquina().equals("")) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(tempoRealMaqSulbrasDTO);
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			AnaliseTurnoWebInjetRN rn = new AnaliseTurnoWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			AnaliseTurnoDTO analiseTurnoDTO = rn.getAnaliseTurno(filtro);
			dao.commitaTransacao();
			if(analiseTurnoDTO == null) {
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
	@Path("/detalhe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalhe(FiltroDetalhePostoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebInjetRN filtroRN = new FiltroWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebInjetRN rn = new DetalheMonitorizacaoWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			PtMonitorizacaoDTO ptDTO = rn.getDetalhe(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			dao.commitaTransacao();
			if(ptDTO == null) {
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
	@Path("/detalheLista")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheLista(FiltroMonitorizacaoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebInjetRN filtroRN = new FiltroWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebInjetRN rn = new DetalheMonitorizacaoWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			
			ArrayList<PtMonitorizacaoDTO> lista = new ArrayList<PtMonitorizacaoDTO>();
			
			if(filtro.getListaFiltroPosto() != null){
				
				for (int i = 0; i < filtro.getListaFiltroPosto().size();i++){
					
					if(filtro.getListaFiltroPosto() == null) {
						throw new JsonException("Error");
					}else{
						PtMonitorizacaoDTO ptDTO = rn.getDetalheLista(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getListaFiltroPosto().get(i)));
						if((ptDTO != null) && (!ptDTO.getAlertas().isEmpty() || ptDTO.getParadaResumo().getDataInicio() != "")){
							lista.add(ptDTO);
						}					
					}				
				
				}
				
			}
			
			
			dao.commitaTransacao();
			
			
			String json = gson.toJson(lista);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException | PostoSemDadoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			System.out.println(e);
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/detalhe/grafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheProducao(FiltroDetalhePostoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			DetalheMonitorizacaoWebProducaoInjetRN rn = new DetalheMonitorizacaoWebProducaoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficosDTO graficoDTO = rn.getGraficos(filtro);
			
			dao.commitaTransacao();
			
			if(graficoDTO == null) {
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			filtro.setTpId((byte) 1); 
			DetalheMonitorizacaoWebProducaoInjetRN rn = new DetalheMonitorizacaoWebProducaoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<FiltroDetalhePostoDTO> lista = rn.getListaFiltroDetalhePostoHora(filtro);
			
			dao.commitaTransacao();
			
			if(lista == null) {
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
				
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DetalheMonitorizacaoWebProducaoInjetRN rn = new DetalheMonitorizacaoWebProducaoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheProducaoHoraDTO detalhe = rn.getDetalheProducaoHora(filtro);
			
			dao.commitaTransacao();
			
			if(detalhe == null) {
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
	@Path("/detalhe/refugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugo(FiltroGraficoRefugoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebRefugoInjetRN rn = new DetalheMonitorizacaoWebRefugoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRefugoDTO graficoDTO = rn.getDetalheRefugo(filtro);
			dao.commitaTransacao();
			if(graficoDTO == null) {
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
	@Path("/detalhe/refugoHora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoHora(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebInjetRN filtroRN = new FiltroWebInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebRefugoInjetRN rn = new DetalheMonitorizacaoWebRefugoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoRefugoDTO graficoDTO = rn.getDetalheRefugosHora(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
			dao.commitaTransacao();
			if(graficoDTO == null) {
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
	@Path("/detalhe/refugoOcorrencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRefugoOcorrencia(@Context HttpServletRequest request, FiltroDetalheRefugoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebRefugoInjetRN rn = new DetalheMonitorizacaoWebRefugoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebRefugoInjetRN rn = new DetalheMonitorizacaoWebRefugoInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
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
	@Path("/detalhe/parada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheParada(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaInjetRN rn = new DetalheMonitorizacaoWebParadaInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoParadaDTO paradasDTO = rn.getParadas(filtro);
			dao.commitaTransacao();
			if(paradasDTO == null) {
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
	@Path("/detalhe/ultimosCiclos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheUltimosCiclos(FiltroDetalhePostoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico daoVF = new DAOGenerico();
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			DetalheMonitorizacaoWebCicloInjetRN rn = new DetalheMonitorizacaoWebCicloInjetRN(dao, daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			UltimosCicloDTO ultimosCicloDTO = rn.getUltimosCiclos(filtro);
			
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
			if(ultimosCicloDTO == null) {
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
	
	// perda de materia prima  nao existe no Injet (somente refugo)
	@POST
	@Path("/detalhe/materiaPrima")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheGraficoPerdas(FiltroMpDTO filtro) {
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebMateriaPrimaRN rn = new DetalheMonitorizacaoWebMateriaPrimaRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoPerdasMpDTO perdasMpDTO = rn.getPerdasMateriaPrima(filtro);
			dao.commitaTransacao();
			if(perdasMpDTO == null) {
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
	
	// variação de ritmo nao existe no Injet (somente refugo)
	@POST
	@Path("/detalhe/variacaoCiclo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVariacaoDeRitmo(FiltroDetalhePostoDTO filtro) {
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
			@QueryParam("cdPt") String cdPt,
			@QueryParam("cdFolha") String cdFolha) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico daoVF = new DAOGenerico();
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			DetalheMonitorizacaoWebCicloInjetRN rn = new DetalheMonitorizacaoWebCicloInjetRN(dao, daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			List<GraficoEvolucaoCicloPadraoDTO> listaCicloPadrao = rn.getGraficoDaEvolucaoDoCicloPadrao(cdFolha, cdPt);

			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
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
	public Response getTurnos() {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			TurnoInjetRN rn = new TurnoInjetRN(dao);
			List<TurnoDTO> turnos = rn.getTurnosInjetParaVF();
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
	public Response getTurnoAtual(@QueryParam("cdGt") String cdGt) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoInjetWebRN rn = new MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			TurnoDTO turnoAtualDTO = rn.getTurnoAtual();
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
	@Path("/turnoAtualColetas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnoAtualColetas(@QueryParam("cdGt") String cdGt) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MonitorizacaoInjetWebRN rn = new MonitorizacaoInjetWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			TurnoDTO turnoAtualDTO = rn.getTurnoAtualColetas();
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
	@Path("/turnoInjet")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnoInjet(@QueryParam("cdTurno") String cdTurno) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			TurnoInjetRN rn = new TurnoInjetRN(dao);
			TurnoDTO turnoAtualDTO = rn.getTurnoInjet(cdTurno);
			dao.commitaTransacao();
			String json = gson.toJson(turnoAtualDTO);
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
	
	
	// parametros CEP nao existe no Injet (somente refugo)
	@GET
	@Path("/detalhe/cep/parametrosCep")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParametrosCEP() {
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
	
	// parametros CEP nao existe no Injet (somente refugo)
	@POST
	@Path("/detalhe/cep/graficoX")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCepGraficoX(FiltroGraficoCepDTO filtro) {

		DAOGenericoInjet dao = new DAOGenericoInjet();
		DAOGenerico daoVF = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			FiltroWebRN filtroRN = new FiltroWebRN(daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepInjetRN rn = new DetalheMonitorizacaoWebCepInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoCepXDTO grafico = rn.getGraficoCepX(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			//grafico.setM(grafico.getValores().get(0).getValorMonetario());
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			if(grafico == null) {
				throw new JsonException("Error");
			}
	
			//rootElement.add("grafico", gson.toJsonTree(grafico));
			String json = gson.toJson(grafico);
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
	
	
	
	public List<GraficoCepProcessoDTO> getDetalheCepGraficoTesteX(FiltroGraficoCepDTO filtro) {
		
		
		//Este metodo retorna as últmias ocorrências por hora
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DAOGenerico daoVF = new DAOGenerico();
		
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DetalheMonitorizacaoWebCepInjetRN rnCep = new DetalheMonitorizacaoWebCepInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			Map<Long, FolhaCEPDTO> mapFolhas = rnCep.getLimitesCEP(filtro.getFiltroDetalhePosto().getCdPosto(), filtro.getFiltroDetalhePosto().getCdCp(), filtro.getParametro());			
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			List<GraficoCepProcessoDTO> grafico = rn.getGraficoCepProcesso(filtro);
			
			grafico = rnCep.atualizaLimites(grafico, mapFolhas.get(filtro.getParametro()));
			
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
			if(grafico == null) {
				throw new JsonException("Error");
			}
			return grafico;
			
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			daoVF.rollBackTransacaoSemException();
			
			return null;
			
		} finally {
			daoVF.finalizaSessaoSemException();
			dao.finalizaConexaoBancoSemException();
		}
		
	
	}
	/* era assim até 201808xx: agora existe no injet
	
	// parametros CEP nao existe no Injet (somente refugo)
	@POST
	@Path("/detalhe/cep/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaCep(FiltroGraficoCepDTO filtro) {
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebRN filtroRN = new FiltroWebRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaCepDTO> tabela = rn.getCepTabela(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			dao.commitaTransacao();
			if(tabela == null) {
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
	
	*/
	
	//AQUI
	@POST
	@Path("/detalhe/cep/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaCep(FiltroGraficoCepDTO filtro) {
		DAOGenerico daoVF = new DAOGenerico();
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			FiltroWebInjetRN  filtroRN = new FiltroWebInjetRN (dao, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepInjetRN rn = new DetalheMonitorizacaoWebCepInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaCepDTO> tabela = rn.getCepTabela(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			dao.commitaTransacao();
			if(tabela == null) {
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

	
	
	// parametros CEP nao existe no Injet (somente refugo)
	@POST
	@Path("/detalhe/cep/graficoProcesso")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheCepGraficoProcesso(FiltroGraficoCepDTO filtro) {
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DAOGenerico daoVF = new DAOGenerico();
		
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebCepInjetRN rnCep = new DetalheMonitorizacaoWebCepInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			Map<Long, FolhaCEPDTO> mapFolhas = rnCep.getLimitesCEP(filtro.getFiltroDetalhePosto().getCdPosto(), filtro.getFiltroDetalhePosto().getCdCp(), filtro.getParametro());			
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			DetalheMonitorizacaoWebCepRN rn = new DetalheMonitorizacaoWebCepRN(daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			List<GraficoCepProcessoDTO> grafico = rn.getGraficoCepProcesso(filtro);
			
			grafico = rnCep.atualizaLimites(grafico, mapFolhas.get(filtro.getParametro()));
			
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
			if(grafico == null) {
				throw new JsonException("Error");
			}
			rootElement.add("grafico", gson.toJsonTree(grafico));
			String json = gson.toJson(rootElement);
			return Response.status(responseStatus).entity(json).build();
			
		} catch (JsonException | RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			daoVF.rollBackTransacaoSemException();
			
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
			
		} finally {
			daoVF.finalizaSessaoSemException();
			dao.finalizaConexaoBancoSemException();
		}
		
	}

	@POST
	@Path("/detalhe/paradaHora")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response getDetalheParadaHora(@Context HttpServletRequest request, FiltroDetalheParadaDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			// exibe somente parada com peso - tem que manter a coerencia com a exibicao de valores e ocorrencias
			filtro.setMostrarParadaComPeso(true);
			filtro.setMostrarParadaSemPeso(false);
			
			DetalheMonitorizacaoWebParadaInjetRN rn = new DetalheMonitorizacaoWebParadaInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			GraficoParadaDTO paradasDTO = rn.getParadasHora(filtro);
			dao.commitaTransacao();
			if(paradasDTO == null) {
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaInjetRN rn = new DetalheMonitorizacaoWebParadaInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			DetalheMonitorizacaoWebParadaInjetRN rn = new DetalheMonitorizacaoWebParadaInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
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
	@Path("/detalhe/defeito")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheDefeito(@Context HttpServletRequest request, FiltroDetalhePostoDTO filtro) {
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
			if(graficoDTO == null) {
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
	@Path("/detalhe/ritmo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheRitmo(@Context HttpServletRequest request, FiltroPerdaGanhoDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico daoVF = new DAOGenerico();		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			DetalheMonitorizacaoWebCicloInjetRN rn = new DetalheMonitorizacaoWebCicloInjetRN(dao, daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheCicloDTO detalhe = rn.getDetalheRitmo(filtro);
			
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
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
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Response.Status responseStatus = Response.Status.OK;
		
		DAOGenerico daoVF = new DAOGenerico();		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			DetalheMonitorizacaoWebCicloInjetRN rn = new DetalheMonitorizacaoWebCicloInjetRN(dao, daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			PerdaGanhoDTO retorno = rn.getDetalheRitmoTabela(filtro);

			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
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
	@Path("/detalhe/defeito/componente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetalheDefeitoComponente(@Context HttpServletRequest request, FiltroDetalheDefeitoDTO filtro) {		
		Gson gson = new Gson();
		
		Response.Status responseStatus = Response.Status.OK;
		
		GraficoDefeitoComponenteDTO graficoDTO = new GraficoDefeitoComponenteDTO();
		graficoDTO.setLegenda(new ArrayList<LegendaDTO>());
		graficoDTO.setComponentes(new ArrayList<GraficoDefeitoComponenteDetalheDTO>());			
		String json = gson.toJson(graficoDTO);
		
		return Response.status(responseStatus).entity(json).build();
	}


	/*
	@POST
	@Path("/detalhe/cep/tabelagrafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaGraficoCep(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		List<TabelaGraficoCepDTO> tabela = new ArrayList<TabelaGraficoCepDTO>();
		rootElement.add("tabela", gson.toJsonTree(tabela));
		String json = gson.toJson(rootElement);
		return Response.status(responseStatus).entity(json).build();
	}
	*/
	
	@POST
	@Path("/detalhe/cep/tabelagrafico")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaGraficoCep(@Context HttpServletRequest request, FiltroGraficoCepDTO filtro) {
		DAOGenericoInjet dao = new DAOGenericoInjet();
		DAOGenerico daoVF = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			daoVF.iniciaSessao();
			daoVF.iniciaTransacao();
			
			FiltroWebRN filtroRN = new FiltroWebRN(daoVF, FORMATO_DATA, FORMATO_DATA_HORA);
			DetalheMonitorizacaoWebCepInjetRN rn = new DetalheMonitorizacaoWebCepInjetRN(dao, FORMATO_DATA, FORMATO_DATA_HORA);
			List<TabelaGraficoCepDTO> tabela = rn.getCepTabelaGrafico(filtro, filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro.getFiltroDetalhePosto()));
			
			dao.commitaTransacao();
			daoVF.commitaTransacao();
			
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
	
	
}


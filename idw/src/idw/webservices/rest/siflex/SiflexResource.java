package idw.webservices.rest.siflex;

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

import idw.model.dao.DAOGenerico;
import idw.model.rn.integracao.siflex.IntegracaoSiflexRN;
import idw.model.rn.web.vf.monitorizacao.MonitorizacaoWebRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenFilter;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexOcorrenciaParadaDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexPTDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexParadaDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexRAPDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;

@Path("/siflex")
public class SiflexResource {

	@GET
	@Path("/tabelaparadas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParadasAtivas(@Context HttpServletRequest request) {
		TokenFilter.validar(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			
			dao.iniciaSessao();
			dao.iniciaTransacao();
			IntegracaoSiflexRN rn = new IntegracaoSiflexRN(dao);
			List<IntegracaoSiflexParadaDTO> integracaosiflexparadaDTO = rn.paradasAtivas();
			dao.commitaTransacao();
			if(integracaosiflexparadaDTO ==null||integracaosiflexparadaDTO.isEmpty()) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(integracaosiflexparadaDTO);
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
	
	@GET
	@Path("/tabelamaquinas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaquinasAtivas(@Context HttpServletRequest request) {
		TokenFilter.validar(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			
			dao.iniciaSessao();
			dao.iniciaTransacao();
			IntegracaoSiflexRN rn = new IntegracaoSiflexRN(dao);
			List<IntegracaoSiflexPTDTO> integracaosiflexptDTO = rn.listaPTDTO(); 
			dao.commitaTransacao();
			if(integracaosiflexptDTO ==null||integracaosiflexptDTO.isEmpty()) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(integracaosiflexptDTO);
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
	
	@GET
	@Path("/tabelaraps")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTabelaRapsAtivos(@Context HttpServletRequest request) {
		TokenFilter.validar(request);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			
			dao.iniciaSessao();
			dao.iniciaTransacao();
			IntegracaoSiflexRN rn = new IntegracaoSiflexRN(dao);
			List<IntegracaoSiflexRAPDTO> integracaosiflexrapDTO = rn.listaRAPs();
			dao.commitaTransacao();
			if(integracaosiflexrapDTO ==null||integracaosiflexrapDTO.isEmpty()) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(integracaosiflexrapDTO);
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
	
	@GET
	@Path("/ocorrenciasparada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ocorrenciasParada(@Context HttpServletRequest request, @QueryParam("dthrIni") String dthrIni,
			@QueryParam("dthrFim") String dthrFim) {
		TokenFilter.validar(request);
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			IntegracaoSiflexRN rn = new IntegracaoSiflexRN(dao);
			List<IntegracaoSiflexOcorrenciaParadaDTO> integracaosiflexocorrenciaparadaDTO = rn.listaOcorrenciaParadaMaquina(dthrIni, dthrFim);
			dao.commitaTransacao();
			if(integracaosiflexocorrenciaparadaDTO ==null||integracaosiflexocorrenciaparadaDTO.isEmpty()) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(integracaosiflexocorrenciaparadaDTO);
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

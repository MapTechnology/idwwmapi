package idw.webservices.rest.taylormade;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.DAOGenerico;
import idw.model.rn.web.taylormade.ConsultasWebTaylorMadeRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.monitorizacao.FiltroPtCpDTO;
import idw.webservices.rest.taylormade.dto.OpInicioFimDTO;

@Path("/taylormade")
public class TaylorMadeResource {

	@POST
	@Path("/producao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducao(@Context HttpServletRequest request, FiltroPtCpDTO filtro) {	
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebTaylorMadeRN rn = new ConsultasWebTaylorMadeRN(dao);
			Long retorno = rn.getProducaoIdCpIdPt(filtro);
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
	@Path("/iniciofimop")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInicioFimOp(@Context HttpServletRequest request, FiltroPtCpDTO filtro) {	
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ConsultasWebTaylorMadeRN rn = new ConsultasWebTaylorMadeRN(dao);
			OpInicioFimDTO retorno = rn.getInicioFimCpIdCpIdPt(filtro);
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

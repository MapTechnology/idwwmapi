package idw.webservices.rest;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.util.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/config")
public class ConfigurationResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConfiguration() {
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			rootElement.addProperty("isIdwAtivo", gson.toJson(IdwFacade.IS_IDW_ATIVO));
			rootElement.addProperty("versaoIdwServidor", Util.getVersao());
			String json = gson.toJson(rootElement);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}
		
	}

}

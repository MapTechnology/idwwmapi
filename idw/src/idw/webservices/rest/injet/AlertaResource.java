package idw.webservices.rest.injet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.IdwFacade;
import idw.webservices.rest.AbstractResource;

@Path("/injet/alertas")
public class AlertaResource extends AbstractResource {
	
	@GET
	@Path("pesquisaAlertasByGalpao/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisaParadasByGalpao(@QueryParam("cdGalpao")String cdGalpao) throws Exception {
				
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(IdwFacade.getInstancia().pesquisaMaquinasEmAlertaPorGalpao(cdGalpao));
		return Response.status(responseStatus).entity(json).build();
	}
	
	

}

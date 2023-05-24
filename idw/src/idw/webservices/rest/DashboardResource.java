package idw.webservices.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.rn.dashboard.DashboardFlexRN;
import idw.webservices.rest.dto.dashboard.flex.DashboardFlexDTO;

@Path("/dashboard")
public class DashboardResource {
	
	@GET
	@Path("/flex/producao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducaoFlex(
			@DefaultValue("") @QueryParam("cdGt") String cdGt,
			@DefaultValue("") @QueryParam("dthr") String dthr) {
		
		DAOGenerico dao = new DAOGenerico();		
		Gson gson = new Gson();		
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DashboardFlexRN dashboardFlexRN = new DashboardFlexRN(dao);
			
			try {
				
				DashboardFlexDTO dashboardFlexDTO = dashboardFlexRN.producao(cdGt, dthr);
				
				dao.commitaTransacao(dao.getSession());
				
				responseStatus = Response.Status.OK;
				String json = gson.toJson(dashboardFlexDTO);
				return Response.status(responseStatus).entity(json).build();
			
			} catch (RegistroDesconhecidoException | SemCalendarioException e) {			
				throw new ResourceWebApplicationException(Status.NOT_FOUND, e.getMessage());
			}
			
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}
	
}

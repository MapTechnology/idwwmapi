package idw.webservices.rest.mfv;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwTArea;
import idw.model.rn.AreaRN;
import idw.webservices.rest.ResourceWebApplicationException;

@Path("/mfv/area")
public class AreaResource {


	//fa3getdsarea
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDsArea(@QueryParam("idArea") long idArea) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			AreaRN spRN = new AreaRN(dao);
			String ds = "";
			DwTArea dwtarea = null;
			dwtarea = spRN.getTArea(idArea);
			if(dwtarea!=null && dwtarea.getDsArea()!=null){
				ds = "AREA INDETERMINADA";
				if (!dwtarea.getDsArea().trim().equals("")){
					ds = dwtarea.getDsArea();
				}
			}

			List<JsonObject> listjsonoarea = new ArrayList<JsonObject>();
			JsonObject jsono = new JsonObject();
			jsono.addProperty("dsArea", ds);
			listjsonoarea.add(jsono);
			rootElement.add("area", gson.toJsonTree(listjsonoarea));

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

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

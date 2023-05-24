package idw.webservices.rest.mfv;

import java.math.BigDecimal;
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
import idw.model.dao.SpCatCausaDAO;
import idw.model.pojos.SpCatcausa;
import idw.model.pojos.SpCatcausads;
import idw.webservices.rest.ResourceWebApplicationException;

@Path("/mfv/categorias")
public class CategoriaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategorias(@QueryParam("idLingua") int idLingua) {
		//fa3getlistacategorias

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;
		BigDecimal bdLingua = new BigDecimal(idLingua);

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpCatCausaDAO spCatCausaDAO = new SpCatCausaDAO(dao.getSession());
			List<SpCatcausa> spCatcausas = spCatCausaDAO.getListaCategorias(idLingua);

			List<JsonObject> categorias = new ArrayList<JsonObject>();
			for(SpCatcausa spCatcausa : spCatcausas) {

				for(SpCatcausads spCatcausads : spCatcausa.getSpCatcausadses()) {
					if (spCatcausads.getSpLingua().getIdLingua().equals(bdLingua )){
						JsonObject categoria = new JsonObject();
						categoria.addProperty("id_catcausa", spCatcausa.getIdCatcausa());
						categoria.addProperty("cd_catcausa", spCatcausa.getCdCatcausa());
						categoria.addProperty("ds_catcausa", spCatcausads.getDsCatcausa());						
						categorias.add(categoria);
					}
				}
			}

			rootElement.add("categorias", gson.toJsonTree(categorias));

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

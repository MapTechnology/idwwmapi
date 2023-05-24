package idw.webservices.rest.mfv;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpObjDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.SpObj;
import idw.model.rn.SpObjRN;
import idw.webservices.rest.ResourceWebApplicationException;

@Path("/mfv/objetivos")
public class ObjetivoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaObjetivos(@QueryParam("idProblema") int idProblema) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpObjDAO spObjDAO = new SpObjDAO(dao.getSession());
			List<SpObj> objs = spObjDAO.getListaObjetivos(idProblema);

			List<JsonObject> objetivos = new ArrayList<JsonObject>();
			for(SpObj obj : objs) {
				JsonObject objetivo = new JsonObject();
				objetivo.addProperty("idobj", obj.getIdObj()); //id
				objetivo.addProperty("idproblema", obj.getSpProblema().getIdProblema());//idProblema
				objetivo.addProperty("textoobj", obj.getTextoobj());//texto

				objetivos.add(objetivo);
			}

			rootElement.add("objetivos", gson.toJsonTree(objetivos));

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

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarObjetivo(@QueryParam("idObj") int idObj) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpObjRN spObjRN = new SpObjRN(dao);
			SpObj obj = spObjRN.deletarObjetivo(idObj);

			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", obj.getIdObj());
			rootElement.add("objetivo", objetivo);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", 0);
			rootElement.add("objetivo", objetivo);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertObjetivo(
			@QueryParam("idObj") long idObj
			, @QueryParam("idProblema") long idProblema
			, @QueryParam("texto") String texto
			) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			SpObjRN spObjRN = new SpObjRN(dao);
			long idobj = spObjRN.insertObjetivo(idObj,idProblema, texto);

			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", idobj);
			rootElement.add("objetivo", objetivo);

			dao.commitaTransacao(dao.getSession());
			responseStatus = Response.Status.OK;

			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (RegistroDesconhecidoException e) {
			JsonObject objetivo = new JsonObject();
			objetivo.addProperty("id", 0);
			rootElement.add("objetivo", objetivo);
			String json = gson.toJson(rootElement);
			responseStatus = Response.Status.OK;
			return Response.status(responseStatus).entity(json).build();	
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

}

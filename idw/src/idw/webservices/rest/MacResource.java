package idw.webservices.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.rn.MacRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.dto.MacDTO;

@Path("/macs")
public class MacResource {
	
	public final static String FORMATO_DATA = "dd/MM/yyyy HH:mm:ss";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodos() {
		
		DAOGenerico dao = new DAOGenerico();
		MacRN rn = new MacRN(dao, FORMATO_DATA);
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			List<MacDTO> macs = rn.getAll();
			rootElement.add("macsRestantes", gson.toJsonTree(rn.getQuantidadeRestanteTotalMac(macs)));
			rootElement.add("macs", gson.toJsonTree(macs));
			dao.commitaTransacao();
			String json = gson.toJson(rootElement);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@GET
	@Path("/limiteGlobal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMacsLimiteGlobal() {
		
		DAOGenerico dao = new DAOGenerico();
		MacRN rn = new MacRN(dao, FORMATO_DATA);
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			List<MacDTO> macs = rn.getMacsLimiteGlobal();
			rootElement.add("macs", gson.toJsonTree(macs));
			dao.commitaTransacao();
			String json = gson.toJson(rootElement);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(MacDTO mac) {
		
		DAOGenerico dao = new DAOGenerico();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			MacRN rn = new MacRN(dao, FORMATO_DATA);
			rn.salvar(mac);
			dao.commitaTransacao();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
		
		return Response.status(responseStatus).build();
	}
	
}

package idw.webservices.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.OmPtDAO;
import idw.model.pojos.OmPt;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.rest.dto.PtDTO;

@Path("/pts")
public class PtResource {
	 
	@GET
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(ResourceUtils.MEDIA_TYPE_JSON_UTF8)
	public Response getPt(
			@DefaultValue("") @QueryParam("cd") String cdPt,  
			@DefaultValue("false") @QueryParam("apenas-checar") boolean isApenasChecar) {
		
		DAOGenerico dao = new DAOGenerico();		
		Gson gson = new Gson();		
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;
		
		try {
			dao.iniciaSessao();
			
			OmPtDAO omPtDAO = new OmPtDAO(dao.getSession());
			OmPt omPt = omPtDAO.getOmPtAtivoComUltimaRevisao(cdPt);
			
			if (omPt == null) {
				String msg = String.format("Posto de trabalho %s não encontrado.", cdPt);
				throw new ResourceWebApplicationException(Status.NOT_FOUND, msg);
			}
			
			if (!isApenasChecar) {
				omPt = omPt.clone(false);
				rootElement.add("pt", gson.toJsonTree(omPt));
			}
			
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
	
	@GET
	@Path("/ativos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivos() {
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			OmPtDAO ptDAO = new OmPtDAO(dao.getSession());
			List<OmPt> listaOmPt = ptDAO.getOmPtsAtivosOrderByCd();
			
			List<PtDTO> postosAtivos = new ArrayList<>();
			for(OmPt pt : listaOmPt) {
				PtDTO posto = new PtDTO();
				posto.setIdPt(pt.getIdPt());
				posto.setCdPt(pt.getCdPt());
				posto.setDsPt(pt.getDsPt());
				postosAtivos.add(posto);
			}
			
			rootElement.add("pts", gson.toJsonTree(postosAtivos));
			
			dao.commitaTransacao();
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
	@Path("getPpCpByCdPt/{ompt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPpCpByCdPt(@PathParam("ompt") String ompt) throws Exception {
		OmPt omPt = new OmPt();
		omPt.setCdPt(ompt);
		ListaCPDTO retorno = IdwFacade.getInstancia().getPpCpByCdPt(omPt);

		// A ExclusionStrategy e utilizada para reduzir o tamanho das respostas retornadas
		// por essa API
		// https://www.baeldung.com/gson-exclude-fields-serialization
		ExclusionStrategy strategy = new ExclusionStrategy() {
		    @Override
		    public boolean shouldSkipField(FieldAttributes field) {
		        if (field.getName().equals("cp")
		        		|| field.getName().equals("ppCpprodutos")
		        		|| field.getName().equals("nrDoc")
		        		|| field.getName().equals("idCp")
		        		|| field.getName().equals("listaCps")
		        		|| field.getName().equals("isIhmtrocaop")
		        		|| field.getName().equals("isPtSemop")) {
		            return false;
		        }
		        return true;
		    }
		 
		    @Override
		    public boolean shouldSkipClass(Class<?> clazz) {
		        return false;
		    }
		};
		
		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).create();
		Response.Status responseStatus = Response.Status.OK;
		
		String json = gson.toJson(retorno);
		return Response.status(responseStatus).entity(json).build();
	}
}

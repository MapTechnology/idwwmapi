package idw.webservices.rest;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.OmGt;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.dto.GtDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/gts")
public class GtResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGtsAtivos() {
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			OmGtDAO gtDAO = new OmGtDAO(dao.getSession());
			List<OmGt> gtsAtivos = gtDAO.getOmGtsAtivos();
			List<GtDTO> gtsFormatados = new ArrayList<>();
			for(OmGt gtAtivo : gtsAtivos) {
				gtsFormatados.add(converterGtPojoParaDTO(gtAtivo));
			}
			
			dao.commitaTransacao(dao.getSession());			
			responseStatus = Response.Status.OK;			
			rootElement.add("gts", gson.toJsonTree(gtsFormatados));			
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
	@Path("/monitorizacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGts() {
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			List<GtDTO> gts = new ArrayList<GtDTO>();
			OmGtDAO gtDAO = new OmGtDAO(dao.getSession());
			List<OmGt> listaOmGt = gtDAO.getGtsComLayout();
			for(OmGt gt : listaOmGt) {
				gts.add(converterGtPojoParaDTO(gt));
			}
			
			dao.commitaTransacao();
			rootElement.add("gts", gson.toJsonTree(gts));
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
	
	public static GtDTO converterGtPojoParaDTO(OmGt gt) {
		GtDTO dto = new GtDTO();
		dto.setIdGt(String.valueOf(gt.getIdGt()));
		dto.setCdGt(gt.getCdGt());
		dto.setDsGt(gt.getDsGt());
		if(gt.getDsGt() == null || gt.getDsGt().equals("")) {
			dto.setDsView(gt.getCdGt());
		} else {
			dto.setDsView(gt.getDsGt());
		}
		return dto;
	}
	
}

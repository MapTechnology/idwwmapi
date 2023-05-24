package idw.webservices.rest.injet;

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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.model.IdwFacade;
import idw.model.dao.OmPtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmPt;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.ResourceUtils;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.PtDTO;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.rn.UtilRN;
import injetws.model.rn.injet.InjetAlertaRN;
import injetws.webservices.dto.IwsAlertaDTO;

@Path("/injet/pts")
public class PtResource {
	 
	@GET
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(ResourceUtils.MEDIA_TYPE_JSON_UTF8)
	public Response getPt(
			@DefaultValue("") @QueryParam("cd") String cdPt,  
			@DefaultValue("false") @QueryParam("apenas-checar") boolean isApenasChecar) {
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();		
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;
		
		try {
			dao.iniciaSessao();
			
			OmPtDAO omPtDAO = new OmPtDAO(dao.getSession());
			OmPt omPt = omPtDAO.getOmPtAtivoComUltimaRevisaoInjet(dao, cdPt);
			
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
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			OmPtDAO ptDAO = new OmPtDAO(dao.getSession());
			List<OmPt> listaOmPt = ptDAO.getOmPtsAtivosOrderByCdInjet(dao);
			
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
	@Path("/ativoByGalpao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostosAtivosByGalpa(@QueryParam("gt") String cdGt) {
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			OmPtDAO ptDAO = new OmPtDAO(dao.getSession());
			List<OmPt> listaOmPt = ptDAO.getOmPtsAtivosByGt(dao,cdGt);
			
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
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		DAOGenericoInjet dao = new DAOGenericoInjet();
		dao.iniciaSessao();
		String json = gson.toJson(IdwFacade.getInstancia().getPpCpByCdPtInjet(dao, omPt));
		dao.finalizaSessao();
		return Response.status(responseStatus).entity(json).build();
	}
	
	// TODO: verificar se e mais apropriado mover esse endpoint para uma classe AlertaResource
	@GET
	@Path("iwsAlertaDTO/{cdAlerta}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIwsAlertaDTOByCdAlerta(@PathParam("cdAlerta") String cdAlerta) throws Exception {
		//getIwsAlertaDTOByCdAlerta
		DAOGenericoInjet daoInjet = new DAOGenericoInjet();
		InjetAlertaRN alertaRN = new InjetAlertaRN(daoInjet);
		IwsAlertaDTO retorno = null;
		try{
			alertaRN.iniciaConexaoBanco();

			cdAlerta = UtilRN.setZeroEsquerda(cdAlerta);
			retorno = alertaRN.getIwsAlertaDTOByCdAlerta(cdAlerta);
		}catch(RegistroDesconhecidoException exc){
			//log.info(idLog, 0,"Registro desconhecido CdAlerta: " + cdAlerta);
		} catch (Exception e){
			//log.info("excessao", e);
			e.printStackTrace();
		} finally {
			try{
				alertaRN.finalizaConexaoBanco();
			} catch (Exception e2){
				//log.info("excessao", e2);
				e2.printStackTrace();
				alertaRN.finalizaConexaoBanco();
				//log.info(idLog, 0,"Finalizando getTr_TabAlertaSetaCod() para Alerta " + cdAlerta);
			}
		}
		alertaRN = null;
		daoInjet = null;
	
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.NO_CONTENT;
		if (retorno != null)
			responseStatus = Response.Status.OK;
		String json = gson.toJson(retorno);
		return Response.status(responseStatus).entity(json).build();
	}
}

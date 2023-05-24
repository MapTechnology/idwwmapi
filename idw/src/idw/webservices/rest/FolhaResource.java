package idw.webservices.rest;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmPt;
import idw.model.rn.PTRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.webservices.dto.CicloDTO;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.dto.FolhaDTO;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/folhas")
public class FolhaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolhasDoPosto(@QueryParam("cdPt") String cdPt) {
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			PTRN ptRN = new PTRN(dao);
			OmPt pt = ptRN.getOmPt(cdPt);
			
			DetalheMonitorizacaoPTInsertRN rn = new DetalheMonitorizacaoPTInsertRN(dao);
			DwFolhasDTO folhasDTO = rn.getFolhasDoPt(pt);
			
			List<FolhaDTO> folhasDoPosto = new ArrayList<>();
			for(DwFolhaDTO folhaDTO : folhasDTO.getListaDwFolhaDTO()) {
				FolhaDTO folha = new FolhaDTO();
				folha.setIdFolha(folhaDTO.getDwFolha().getIdFolha());
				folha.setCdFolha(folhaDTO.getDwFolha().getCdFolha());
				folha.setDsFolha(folhaDTO.getDwFolha().getDsFolha());
				folhasDoPosto.add(folha);
			}
			
			rootElement.add("folhas", gson.toJsonTree(folhasDoPosto));
			
			dao.commitaTransacao();
			String json = gson.toJson(rootElement);
			return Response.status(responseStatus).entity(json).build();
		} catch (RegistroDesconhecidoException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "Posto desconhecido.");
			throw new ResourceWebApplicationException(responseStatus, error);
		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	
	@POST
	@Path("getCicloTimeoutEPadrao")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCicloTimeoutEPadrao(MultivaluedMap<String, String> params) throws Exception {
		Gson gson = new Gson();
		String nrOp = params.getFirst("op");
		String maquina = params.getFirst("cdPt");
		CicloDTO cicloDTO = null;
		try {
			cicloDTO = IdwFacade.getInstancia().getCicloTimeoutEPadrao(nrOp, maquina);
		} catch (Exception e) {
			e.printStackTrace();
			String retorno = e.getMessage();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retorno).build();
		}
		
		if (cicloDTO != null && cicloDTO.getCicloPadrao() != null 
				&& cicloDTO.getEficienciaCiclo()!=null) {
			String json = gson.toJson(cicloDTO);
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			String retorno = "{\"cicloPadrao\" : \"" + cicloDTO.getCicloPadrao() + "\" ,"
					+ " \"eficienciaCiclo\": \"" + cicloDTO.getEficienciaCiclo()+"\"}"; 
			 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retorno).build();
		}
	}
}

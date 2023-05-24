package idw.webservices.rest.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.rn.monitorizacao.injet.DetalheMonitorizacaoPTInjetRN;
import idw.webservices.dto.DwFolhaDTO;
import idw.webservices.dto.DwFolhasDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.FolhaDTO;

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

@Path("/injet/folhas")
public class FolhaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolhasDoPosto(@QueryParam("cdPt") String cdPt) {
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			
			DetalheMonitorizacaoPTInjetRN rn = new DetalheMonitorizacaoPTInjetRN(dao);
			DwFolhasDTO folhasDTO = rn.getFolhasDoPt(cdPt);
			
			
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
	
}

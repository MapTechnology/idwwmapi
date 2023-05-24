package idw.webservices.rest.injet;


import idw.model.IdwFacade;
import idw.model.pojos.OmTppt;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasRestDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/injet/refugo")
public class RefugoResource {

	@GET
	@Path("pesquisaRefugo/{cdRefugo}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisaDwTRefugo(@PathParam("cdRefugo") String cdRefugo, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdRefugo);
		
		// OmTppt ignorado no Injet
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		//
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTRefugoInjetToVF(pesquisaDTO)));
		return Response.status(responseStatus).entity(json).build();
	}
	
}

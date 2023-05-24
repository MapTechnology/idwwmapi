package idw.webservices.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.IdwFacade;
import idw.model.pojos.OmTppt;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasRestDTO;

@Path("/paradas")
public class ParadaResource extends AbstractResource{

	@GET
	@Path("pesquisaParada/{cdParada}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public Response pesquisaDwTParada(@PathParam("cdParada") String cdParada, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdParada);
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTParada(pesquisaDTO)));
		return Response.status(responseStatus).entity(json).build();
	}
}

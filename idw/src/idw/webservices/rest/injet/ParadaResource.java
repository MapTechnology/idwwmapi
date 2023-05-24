package idw.webservices.rest.injet;

import idw.model.IdwFacade;
import idw.model.pojos.OmTppt;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasRestDTO;
import idw.webservices.rest.AbstractResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/injet/paradas")
public class ParadaResource extends AbstractResource{

	@GET
	@Path("pesquisaParada/{cdParada}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public Response pesquisaDwTParada(@PathParam("cdParada") String cdParada, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdParada);
		
		// OmTppt ignorado no Injet
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		//
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTParadaInjetToVF(pesquisaDTO)));
		return Response.status(responseStatus).entity(json).build();
	}
	
	
	@GET
	@Path("pesquisaParadasByGalpao/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisaParadasByGalpao(@QueryParam("cdGalpao")String cdGalpao) throws Exception {
				
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(IdwFacade.getInstancia().pesquisaMaquinasParadasPorGalpao(cdGalpao));
		return Response.status(responseStatus).entity(json).build();
	}
	
	
	
	@GET
	@Path("pesquisaParadaCompleta/{cdParada}-{idTppt}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("application/json; charset=UTF-8")
	public Response pesquisaDwTParadaCompleta(@PathParam("cdParada") String cdParada, @PathParam("idTppt") String idTppt) throws Exception {
		PesquisaDTO pesquisaDTO = new PesquisaDTO();
		pesquisaDTO.setCodigo(cdParada);
		
		// OmTppt ignorado no Injet
		OmTppt omTppt = new OmTppt();
		omTppt.setIdTppt(Long.parseLong(idTppt));
		pesquisaDTO.setRegistro(omTppt);
		//
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		String json = gson.toJson(new PesquisasRestDTO(IdwFacade.getInstancia().pesquisaDwTParadaInjetToVFCompleto(pesquisaDTO)));
		return Response.status(responseStatus).entity(json).build();
	}
}

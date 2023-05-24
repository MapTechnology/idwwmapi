package idw.webservices.rest.conecthusstencil;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import idw.model.rn.alimentacao.AlimentacaoDTO;
import idw.model.rn.folhainspecaorap.FiltroFolhaInspecaoRapDTO;
import idw.model.rn.roteiroinspecao.RoteiroInspecaoDTO;
import idw.webservices.dto.DwRapDTO;
import idw.webservices.dto.GrupoFerramentaDTO;
import idw.webservices.rest.auth.TokenFilter;

@Path("/stencil")
public class ConsultasResource {
	
	

	@POST
	@Path("/getQtCiclosByMaquinaTurnoDataToken")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response pesquisarYByZ(@Context HttpServletRequest request, FiltroByCdMaqIdTurnoDataDTO filtro) {
		//counter thread.sleep
		TokenFilter.validar(request);
		return ConsultasFacade.getInstancia().getQtCiclosByMaquinaTurnoDataToken(request, filtro);
	}


	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response teste(@Context HttpServletRequest request) {
		return ConsultasFacade.getInstancia().getTeste(request);
	}
	
	/*
	@GET
	@Path("/pesquisarXByW")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarXByW(@Context HttpServletRequest request) {
		return ConsultasFacade.getInstancia().pesquisarXByW(request);
	}
	@GET
	@Path("/getR")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getR(@Context HttpServletRequest request) {
		return ConsultasFacade.getInstancia().getR(request);
	}
	*/

}

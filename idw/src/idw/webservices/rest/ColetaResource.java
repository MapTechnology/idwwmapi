package idw.webservices.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import idw.util.IdwLogger;

/* Alessandre esse arquivo possui apenas as assinaturas para o REST, transferindo a execucao para um singleton
 * 
 */
@Path("/coleta")
public class ColetaResource {
	
	@GET
	@Path("/fimCiclo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fimCiclo(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().fimCiclo(request);
	}
	@GET
	@Path("/getDtHrAtual")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDtHrAtual(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getDtHrAtual(request);
	}
	@GET
	@Path("/setUpBeat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setUpBeat(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setUpBeat(request);
	}
	@GET
	@Path("/getTr_Autorizacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_Autorizacao(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_Autorizacao(request);
	}
	@GET
	@Path("/setTr_operadorInicio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_operadorInicio(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_operadorInicio(request);
	}
	
	@GET
	@Path("/setTr_operadorFim")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_operadorFim(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_operadorFim(request);
	}

	@GET
	@Path("/getTr_TabAlertaSetaCod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_TabAlertaSetaCod(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_TabAlertaSetaCod(request);
	}
	
	@GET
	@Path("/setTr_alertaInicio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_alertaInicio(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_alertaInicio(request);
	}

	@GET
	@Path("/setTr_alertaFim")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_alertaFim(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_alertaFim(request);
	}


	@GET
	@Path("/setTr_Consula")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_Consula(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_Consula(request);
	}

	@GET
	@Path("/getTr_ValidaCodRefugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_ValidaCodRefugo(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_ValidaCodRefugo(request);
	}


	@GET
	@Path("/getTr_validaCausa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_validaCausa(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_validaCausa(request);
	}

	
	@GET
	@Path("/getTr_validaAcao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_validaAcao(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_validaAcao(request);
	}
	
	@GET
	@Path("/setTr_LancaEventoRefugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_LancaEventoRefugo(@Context HttpServletRequest request){
		return ColetaFacade.getInstancia().setTr_LancaEventoRefugo(request);
	}

	@GET
	@Path("/getTr_TabParadaSetaCod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_TabParadaSetaCod(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_TabParadaSetaCod(request);
	}

	@GET
	@Path("/setTr_paradaInicio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_paradaInicio(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_paradaInicio(request);
	}

	@GET
	@Path("/setTr_paradaFim")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_paradaFim(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_paradaFim(request);
	}


	@GET
	@Path("/setTr_paradaMotivo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_paradaMotivo(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_paradaMotivo(request);
	}

	@GET
	@Path("/getTr_validaJustificativa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_validaJustificativa(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_validaJustificativa(request);
	}

	@GET
	@Path("/getTr_planejamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTr_planejamento(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getTr_planejamento(request);
	}

	@GET
	@Path("/setTr_fimplanejamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_fimplanejamento(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_fimplanejamento(request);
	}

	@GET
	@Path("/setTr_ApagaUltimoRefugo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setTr_ApagaUltimoRefugo(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().setTr_ApagaUltimoRefugo(request);
	}

	@GET
	@Path("/paradasativaspt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaParadasAtivasPT(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getListaParadasAtivasPT(request);
	}

	@GET
	@Path("/dadostemporeal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDadosTempoReal(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().getDadosTempoReal(request);
	}
	
	@POST
	@Path("/enviaalteracaoparada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response enviaAlteracaoParada(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().enviaAlteracaoParada(request);
	}
	@GET
	@Path("/mapConsumirPesquisarUps")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarUps(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().pesquisarUps(request);
	}
	@GET
	@Path("/mapConsumirPesquisarIdsPendentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mapConsumirPesquisarIdsPendentes(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().mapConsumirPesquisarIdsPendentes(request);
	}
	@GET
	@Path("/mapConsumirPesquisarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mapConsumirPesquisarEvento(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().mapConsumirPesquisarEvento(request);
	}
	@GET
	@Path("/mapConsumirFinalizarEvento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mapConsumirFinalizarEvento(@Context HttpServletRequest request) {
		return ColetaFacade.getInstancia().mapConsumirFinalizarEvento(request);
	}
	
	@POST
	@Path("/testeimagem")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testeimagem(@Context HttpServletRequest request, String imagem) {
		System.out.println(imagem);
		IdwLogger log = new IdwLogger("imagem");
		log.info(imagem);
		String json = "resposta";
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).entity(json).build();
	}
}

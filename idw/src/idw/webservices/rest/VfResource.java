package idw.webservices.rest;

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

@Path("/vf")
public class VfResource {

	@POST
	@Path("/pesquisarFolhasInspecaoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarFolhasInspecaoRAP(@Context HttpServletRequest request, FiltroFolhaInspecaoRapDTO filtro) {
		return VfFacade.getInstancia().pesquisarFolhasInspecaoRAP(request, filtro);
	}

	@GET
	@Path("/pesquisarFolhaInspecaoRAPById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarFolhaInspecaoRAPById(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarFolhaInspecaoRAPById(request);
	}
	@GET
	@Path("/pesquisarVariavelMedicao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarVariavelMedicao(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarVariavelMedicao(request);
	}
	@DELETE
	@Path("/excluirFolhaInspecaoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirFolhaInspecaoRAP(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().excluirFolhaInspecaoRAP(request);
	}
	@GET
	@Path("/pesquisarTipoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarTipoRAP(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarTipoRAP(request);
	}
	@GET
	@Path("/pesquisarRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarRAP(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarRAP(request);
	}
	@GET
	@Path("/pesquisarGrupoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarGrupoRAP(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarGrupoRAP(request);
	}
	@POST
	@Path("/salvarFolhaInspecaoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarFolhaInspecaoRAP(@Context HttpServletRequest request, FiltroFolhaInspecaoRapDTO folhainspecaorap) {
		return VfFacade.getInstancia().salvarFolhaInspecaoRAP(request, folhainspecaorap);
	}
	@GET
	@Path("/pesquisarProdutos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarProdutos(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarProdutos(request);
	}
	
	@POST
	@Path("/salvarGrupoRAP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarGrupoRAP(@Context HttpServletRequest request, GrupoFerramentaDTO grupo) {
		return VfFacade.getInstancia().salvarGrupoRAP(request, grupo);
	}
	@GET
	@Path("/pesquisarGrupoRAPById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarGrupoRAPById(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarGrupoRAPById(request);
	}
	@DELETE
	@Path("/excluirGrupoRap")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirGrupoRap(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().excluirGrupoRap(request);
	}
	@GET
	@Path("/pesquisarTiposOs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarTiposOs(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarTiposOs(request);
	}
	@GET
	@Path("/pesquisarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarUsuarios(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarUsuarios(request);
	}
	
	@GET
	@Path("/pesquisarCC")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarCC(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarCC(request);
	}

	@POST
	@Path("/pesquisarFerramenta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarFerramenta(@Context HttpServletRequest request, DwRapDTO filtro) {
		return VfFacade.getInstancia().pesquisarFerramenta(request, filtro);
	}

	@GET
	@Path("/pesquisarFerramentaById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarFerramentaById(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarFerramentaById(request);
	}
	@POST
	@Path("/salvarFerramenta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarFerramenta(@Context HttpServletRequest request, DwRapDTO ferramenta) {
		return VfFacade.getInstancia().salvarFerramenta(request, ferramenta);
	}
	@DELETE
	@Path("/excluirFerramenta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirFerramenta(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().excluirFerramenta(request);
	}
	@GET
	@Path("/pesquisarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarCliente(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarCliente(request);
	}
	@GET
	@Path("/pesquisarGt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarGt(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarGt(request);
	}
	
	// Metodos do roteiro inspeção
	@POST
	@Path("/pesquisarRoteiroInspecao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarRoteiroInspecao(@Context HttpServletRequest request, RoteiroInspecaoDTO filtro) {
		return VfFacade.getInstancia().pesquisarRoteiroInspecao(request, filtro);
	}

	@GET
	@Path("/pesquisarRoteiroInspecaoById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarRoteiroInspecaoById(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarFerramentaById(request);
	}
	@POST
	@Path("/salvarRoteiroInspecao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarRoteiroInspecao(@Context HttpServletRequest request, RoteiroInspecaoDTO roteiro) {
		return VfFacade.getInstancia().salvarRoteiroInspecao(request, roteiro);
	}
	@DELETE
	@Path("/excluirRoteiroInspecao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirRoteiroInspecao(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().excluirFerramenta(request);
	}
	@GET
	@Path("/pesquisarTiposEstoque")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarTiposEstoque(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarTiposEstoque(request);
	}
	@GET
	@Path("/pesquisarEstoque")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarEstoque(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarEstoque(request);
	}

	@GET
	@Path("/pesquisarGrupoUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarGrupoUsuarios(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarUsuarios(request);
	}
	@GET
	@Path("/pesquisarFolhaInspecaoCdDs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarFolhaInspecaoCdDs(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarUsuarios(request);
	}
	@GET
	@Path("/isUsuarioAutorizadoLiberarCF")
	@Produces(MediaType.APPLICATION_JSON)
	public Response isUsuarioAutorizadoLiberarCF(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().isUsuarioAutorizadoLiberarCF(request);
	}

	@GET
	@Path("/pesquisarGtdeUmFaseQueTenhaPts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarGtdeUmFaseQueTenhaPts(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().pesquisarGtdeUmFaseQueTenhaPts(request);
	}
	
	@GET
	@Path("/getMonitorizacaoAlimComFiltro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMonitorizacaoAlimComFiltro(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getMonitorizacaoAlimComFiltro(request);
	}

	@GET
	@Path("/getRealimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRealimentacaoDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getRealimentacaoDTO(request);
	}

	@GET
	@Path("/setRealimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setRealimentacaoDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().setRealimentacaoDTO(request);
	}
	
	@GET
	@Path("/getAlimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlimentacaoDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getAlimentacaoDTO(request);
	}

	@GET
	@Path("/historicoAlimentacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response historicoAlimentacao(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().historicoAlimentacao(request);
	}

	@GET
	@Path("/getMapasAlimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMapasAlimentacaoDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getMapasAlimentacaoDTO(request);
	}


	@GET
	@Path("/getMapaAlimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMapaAlimentacaoDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getMapaAlimentacaoDTO(request);
	}
	
	
	@POST
	@Path("/setAlimentacaoDTO")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAlimentacaoDTO(@Context HttpServletRequest request, AlimentacaoDTO alimentacaodto) {
		return VfFacade.getInstancia().setAlimentacaoDTO(request, alimentacaodto);
	}

	@GET
	@Path("/getReelidDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReelidDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getReelidDTO(request);
	}

	@GET
	@Path("/getMapaCorrenteDTO")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMapaCorrenteDTO(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getMapaCorrenteDTO(request);
	}



	@POST
	@Path("/setConferenciaDTO")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConferenciaDTO(@Context HttpServletRequest request, AlimentacaoDTO alimentacaodto) {
		return VfFacade.getInstancia().setConferenciaDTO(request, alimentacaodto);
	}

	@GET
	@Path("/getMapasGT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMapasGT(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getMapasGT(request);
	}


	@GET
	@Path("/getOpsGT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOpsGT(@Context HttpServletRequest request) {
		return VfFacade.getInstancia().getOpsGT(request);
	}
}

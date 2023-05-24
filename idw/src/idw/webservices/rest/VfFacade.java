package idw.webservices.rest;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import idw.model.IdwFacade;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.PpCliente;
import idw.model.rn.alimentacao.AlimentacaoDTO;
import idw.model.rn.alimentacao.MapasDTO;
import idw.model.rn.alimentacao.RealimentacaoDTO;
import idw.model.rn.alimentacao.ReelidDTO;
import idw.model.rn.cc.CcsDTO;
import idw.model.rn.estoque.TiposEstoqueDTO;
import idw.model.rn.folhainspecaorap.FiltroFolhaInspecaoRapDTO;
import idw.model.rn.folhainspecaorap.FolhasInspecaoRapDTO;
import idw.model.rn.roteiroinspecao.RoteiroInspecaoDTO;
import idw.model.rn.roteiroinspecao.RoteirosInspecaoDTO;
import idw.model.rn.tipoos.TiposOSDTO;
import idw.webservices.dto.DwRapDTO;
import idw.webservices.dto.DwRapListDTO;
import idw.webservices.dto.DwTprapsDTO;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.dto.EstoquesDTO;
import idw.webservices.dto.GTsDTO;
import idw.webservices.dto.GrupoFerramentaDTO;
import idw.webservices.dto.GruposFerramentaDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.MapaCODTO;
import idw.webservices.dto.MapasCODTO;
import idw.webservices.dto.MonitorizacoesAlimsDTO;
import idw.webservices.dto.ParametrosDTO;
import idw.webservices.dto.PpClienteDTO;
import idw.webservices.dto.PpClientesDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.UsuarioCODTO;
import idw.webservices.dto.UsuariosDTO;
import ms.util.ConversaoTipos;

public class VfFacade {

	private static VfFacade instancia = null;

	private VfFacade() {
		super();
	}

	public static VfFacade getInstancia() {
		if (instancia == null) {
			instancia = new VfFacade();
		}
		return instancia;
	}

	public Response pesquisarFolhasInspecaoRAP(@Context HttpServletRequest request, FiltroFolhaInspecaoRapDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			FolhasInspecaoRapDTO retorno = IdwFacade.getInstancia().pesquisarFolhasInspecaoRAP(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarFolhaInspecaoRAPById(@Context HttpServletRequest request) {
		// obter parametros
		String idFolhainsrap = request.getParameter("idFolhainsrap");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Long id = null;
			if (idFolhainsrap != null)
				id = ConversaoTipos.converterParaLong(idFolhainsrap);

			FolhasInspecaoRapDTO retorno = IdwFacade.getInstancia().pesquisarFolhaInspecaoRAPById(id);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarVariavelMedicao(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			ParametrosDTO retorno = IdwFacade.getInstancia().pesquisarVariavelMedicao(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response excluirFolhaInspecaoRAP(@Context HttpServletRequest request) {
		// obter parametros
		String idFolhainsrap = request.getParameter("idFolhainsrap");
		String idUsr = request.getParameter("idUsr");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Long id = null;
			if (idFolhainsrap != null)
				id = ConversaoTipos.converterParaLong(idFolhainsrap);
			Long idusr = null;
			if (idUsr != null)
				idusr = ConversaoTipos.converterParaLong(idUsr);

			FolhasInspecaoRapDTO retorno = IdwFacade.getInstancia().excluirFolhaInspecaoRAP(id, idusr);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarTipoRAP(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			DwTprapsDTO retorno = IdwFacade.getInstancia().pesquisarTipoRAP(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarRAP(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			DwRapListDTO retorno = IdwFacade.getInstancia().pesquisarRAP(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarGrupoRAP(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			GruposFerramentaDTO retorno = IdwFacade.getInstancia().pesquisarGrupoRAP(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response salvarFolhaInspecaoRAP(@Context HttpServletRequest request, FiltroFolhaInspecaoRapDTO folhainspecaorap) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			// Chama RN
			FolhasInspecaoRapDTO retorno = IdwFacade.getInstancia().salvarFolhaInspecaoRAP(folhainspecaorap);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarProdutos(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			ProdutosDTO retorno = IdwFacade.getInstancia().pesquisarProdutos(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response salvarGrupoRAP(@Context HttpServletRequest request, GrupoFerramentaDTO grupo) {
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			// Chama RN
			GruposFerramentaDTO retorno = new GruposFerramentaDTO();
			GrupoFerramentaDTO result = IdwFacade.getInstancia().setDwGrupoFerramenta(grupo);
			retorno.setListaGruposFerramenta(new ArrayList<GrupoFerramentaDTO>());
			retorno.getListaGruposFerramenta().add(result);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarGrupoRAPById(@Context HttpServletRequest request) {
		// obter parametros
		String id = request.getParameter("id");

		GrupoFerramentaDTO filtro = new GrupoFerramentaDTO();
		DwGrupoFerramenta dwGrupoFerramenta = new DwGrupoFerramenta();
		dwGrupoFerramenta.setIdGrupoFerramenta(ConversaoTipos.converterParaLong(id));
		filtro.setDwGrupoFerramenta(dwGrupoFerramenta);
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			GruposFerramentaDTO retorno = IdwFacade.getInstancia().getDwGrupoFerramenta(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	public Response excluirGrupoRap(@Context HttpServletRequest request) {
		// obter parametros
		String id = request.getParameter("id");

		GrupoFerramentaDTO filtro = new GrupoFerramentaDTO();
		DwGrupoFerramenta dwGrupoFerramenta = new DwGrupoFerramenta();
		dwGrupoFerramenta.setIdGrupoFerramenta(ConversaoTipos.converterParaLong(id));
		filtro.setDwGrupoFerramenta(dwGrupoFerramenta);
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			GrupoFerramentaDTO dto = IdwFacade.getInstancia().excluirDwGrupoFerramenta(filtro);
			GruposFerramentaDTO retorno = new GruposFerramentaDTO();
			retorno.setListaGruposFerramenta(new ArrayList<GrupoFerramentaDTO>());
			retorno.getListaGruposFerramenta().add(dto);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	public Response pesquisarTiposOs(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			TiposOSDTO retorno = IdwFacade.getInstancia().pesquisarTiposOs(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response pesquisarTiposEstoque(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			TiposEstoqueDTO retorno = IdwFacade.getInstancia().pesquisarTiposEstoque(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response pesquisarEstoque(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			EstoquesDTO retorno = IdwFacade.getInstancia().pesquisarEstoque(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	public Response pesquisarUsuarios(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			UsuariosDTO retorno = IdwFacade.getInstancia().getUsuariosDTO(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	public Response pesquisarCC(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			CcsDTO retorno = IdwFacade.getInstancia().getOmCcPorLikeCdDs(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response pesquisarFerramenta(@Context HttpServletRequest request, DwRapDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			DwRapListDTO retorno = IdwFacade.getInstancia().pesquisarListaRAPDTO(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response pesquisarFerramentaById(@Context HttpServletRequest request) {
		// obter parametros
		String idPar = request.getParameter("id");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Long id = null;
			if (idPar != null)
				id = ConversaoTipos.converterParaLong(idPar);

			DwRapListDTO retorno = IdwFacade.getInstancia().pesquisarFerramentaById(id);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}




	public Response salvarFerramenta(@Context HttpServletRequest request, DwRapDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			DwRapDTO dto = IdwFacade.getInstancia().setRAPDTO(filtro);
			DwRapListDTO retorno = new DwRapListDTO();
			retorno.setDwRapDTO(new ArrayList<DwRapDTO>());
			retorno.getDwRapDTO().add(dto);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}


	public Response excluirFerramenta(@Context HttpServletRequest request) {
		// obter parametros
		String idPar = request.getParameter("id");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Long id = null;
			if (idPar != null)
				id = ConversaoTipos.converterParaLong(idPar);
			
			DwRapDTO filtro = new DwRapDTO();
			filtro.setIdRap(id);

			DwRapDTO dto = IdwFacade.getInstancia().setExclusaoRAPDTO(filtro);
			DwRapListDTO retorno = new DwRapListDTO();
			retorno.setDwRapDTO(new ArrayList<DwRapDTO>());
			retorno.getDwRapDTO().add(dto);


			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}



	public Response pesquisarCliente(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			PpClienteDTO filtro = new PpClienteDTO();
			PpCliente ppcliente = new PpCliente();
			ppcliente.setStAtivo((byte) 1);
			ppcliente.setCdCliente(variavel);
			filtro.setPpCliente(ppcliente);
			
			PpClientesDTO retorno = IdwFacade.getInstancia().getPpClientesDTO(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	
	public Response pesquisarGt(@Context HttpServletRequest request) {
		// obter parametros
		String variavel = request.getParameter("variavel");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			GTsDTO retorno = IdwFacade.getInstancia().pesquisaOmGtFase(variavel);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	
	// Abaixo metodos para roteiro de inspecao
	
	
	public Response pesquisarRoteiroInspecao(@Context HttpServletRequest request, RoteiroInspecaoDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			RoteirosInspecaoDTO retorno = IdwFacade.getInstancia().pesquisarRoteiroInspecao(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	
	public Response pesquisarRoteiroInspecaoById(@Context HttpServletRequest request) {
		// obter parametros
		String idPar = request.getParameter("id");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			Long id = null;
			if (idPar != null)
				id = ConversaoTipos.converterParaLong(idPar);

			RoteirosInspecaoDTO retorno = IdwFacade.getInstancia().pesquisarRoteiroInspecaoById(id);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}

	}

	public Response salvarRoteiroInspecao(@Context HttpServletRequest request, RoteiroInspecaoDTO filtro) {

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			RoteirosInspecaoDTO retorno = IdwFacade.getInstancia().salvarRoteiroInspecao(filtro);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response isUsuarioAutorizadoLiberarCF(@Context HttpServletRequest request) {
		String matricula = request.getParameter("matricula");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			UsuarioCODTO retorno = IdwFacade.getInstancia().isUsuarioAutorizadoLiberarCF(matricula);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response pesquisarGtdeUmFaseQueTenhaPts(@Context HttpServletRequest request) {
		String cdfase = request.getParameter("cdfase");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			GTsDTO retorno = IdwFacade.getInstancia().pesquisarGtdeUmFaseQueTenhaPts(cdfase);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}


	public Response getMonitorizacaoAlimComFiltro(@Context HttpServletRequest request) {
		String cdptOuGt = request.getParameter("cdgt");
		Boolean isMaisDeUmProduto = true;
		Boolean isGt = true;
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MonitorizacoesAlimsDTO retorno = IdwFacade.getInstancia().getMonitorizacaoAlimComFiltro(cdptOuGt, isMaisDeUmProduto, isGt);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
	
	
	
	public Response getRealimentacaoDTO(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		String cdmapa = request.getParameter("cdmapa");
		String cdpa = request.getParameter("cdpa");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			RealimentacaoDTO retorno = IdwFacade.getInstancia().getRealimentacaoDTO(cdpt, cdmapa, cdpa);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response setRealimentacaoDTO(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		String cdmapa = request.getParameter("cdmapa");
		String cdpa = request.getParameter("cdpa");
		String cdproduto = request.getParameter("cdproduto");
		String cbLido = request.getParameter("cblido");
		Double quantidade = ConversaoTipos.converteParaDouble(request.getParameter("quantidade"));
		Boolean isSucesso = request.getParameter("sucesso").equals("true");
		String matricula = request.getParameter("login");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			RealimentacaoDTO retorno = IdwFacade.getInstancia().setRealimentacaoDTO(cdpt, cdmapa, cdpa, cdproduto, cbLido, quantidade, isSucesso, matricula);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response getAlimentacaoDTO(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		String filtrar = request.getParameter("filtrar");

		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MonitorizacoesAlimsDTO retorno = IdwFacade.getInstancia().getAlimentacaoDTO(cdpt, filtrar);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	
	
	public Response historicoAlimentacao(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		String cdpa = request.getParameter("cdpa");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MonitorizacoesAlimsDTO retorno = IdwFacade.getInstancia().historicoAlimentacao(cdpt, cdpa);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}




	public Response getMapasAlimentacaoDTO(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MapasCODTO retorno = IdwFacade.getInstancia().getMapasAlimentacaoDTO(cdpt);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}





	public Response getMapaAlimentacaoDTO(@Context HttpServletRequest request) {
		String cdpt = request.getParameter("cdpt");
		String cdmapa = request.getParameter("cdmapa");
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MapaCODTO retorno = IdwFacade.getInstancia().getMapaAlimentacaoDTO(cdpt, cdmapa);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response setAlimentacaoDTO(@Context HttpServletRequest request, AlimentacaoDTO alimentacaodto) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MonitorizacoesAlimsDTO retorno = IdwFacade.getInstancia().setAlimentacaoDTO(alimentacaodto);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}





	public Response getReelidDTO(@Context HttpServletRequest request) {
		String reelid = request.getParameter("id");
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			ReelidDTO retorno = IdwFacade.getInstancia().getReelidDTO(reelid);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}

	public Response getMapaCorrenteDTO(@Context HttpServletRequest request) {
		String cdlinha = request.getParameter("cdlinha");
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MapasDTO retorno = IdwFacade.getInstancia().getMapaCorrenteDTO(cdlinha);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}




	public Response setConferenciaDTO(@Context HttpServletRequest request, AlimentacaoDTO alimentacaodto) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MonitorizacoesAlimsDTO retorno = IdwFacade.getInstancia().setConferenciaDTO(alimentacaodto);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response getMapasGT(@Context HttpServletRequest request) {
		String cdgt = request.getParameter("cdgt");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			MapasCODTO retorno = IdwFacade.getInstancia().getMapasGT(cdgt);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}



	public Response getOpsGT(@Context HttpServletRequest request) {
		String cdgt = request.getParameter("cdlinha");
		
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		try {
			ListaCPDTO retorno = IdwFacade.getInstancia().getOpsGT(cdgt);

			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();

		} catch (Exception e) {
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), ExceptionUtils.getStackTrace(e));
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			gson = null;
		}
	}
}

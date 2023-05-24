package idw.webservices.rest.injet;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.monitorizacao.injet.ManutencaoRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumuladosManutencaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.AcumuladosTempoDispSemParManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.CheckListsDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FerramentasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.FrequenciasManutDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.MaquinasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.MaquinasxFerramentasxProdutosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.RecursosDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.SetoresDTO;
import idw.webservices.rest.dto.monitorizacao.injet.manutencao.TarefasManutDTO;

@Path("/injet/manutencao")
public class ManutencaoResource {
	@POST
	@Path("/setores")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSetores() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			SetoresDTO retorno = rn.getSetores();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/maquinas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaquinas() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			MaquinasDTO retorno = rn.getMaquinas();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

	@POST
	@Path("/ferramentas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFerramentas() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			FerramentasDTO retorno = rn.getFerramentas();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}
	
	@POST
	@Path("/recursos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecursos() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			RecursosDTO retorno = rn.getRecursos();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/maquinaxFerrametaxProduto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaquinasxFerramentasxProdutos() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			MaquinasxFerramentasxProdutosDTO retorno = rn.getMaquinasxFerramentasxProdutos();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/tarefas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTarefas() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			TarefasManutDTO retorno = rn.getTarefas();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	
	@POST
	@Path("/checklists")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCheckLists() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			CheckListsDTO retorno = rn.getCheckLists();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/freqManutPrevMaq")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFreqManutPrevMaq() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			FrequenciasManutDTO retorno = rn.getFreqManutPrevMaq();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/freqManutPrevFerr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFreqManutPrevFerr() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			FrequenciasManutDTO retorno = rn.getFreqManutPrevFerr();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
	
	@POST
	@Path("/acumCicloTempoMaq")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcumCicloTempoMaq() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			AcumuladosManutencaoDTO retorno = rn.getAcumCicloTempoMaq();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/acumCicloTempoFerr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcumCicloTempoFerr() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			AcumuladosManutencaoDTO retorno = rn.getAcumCicloTempoFerr();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/acumTempoSemManutMaq")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcumTempoDispSemManutMaq() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			AcumuladosTempoDispSemParManutDTO  retorno = rn.getAcumTempoDispSemManutMaq();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	

	@POST
	@Path("/acumTempoSemManutFerr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAcumTempoDispSemManutFerr() {	
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			ManutencaoRN rn = new ManutencaoRN(dao);
			AcumuladosTempoDispSemParManutDTO retorno = rn.getAcumTempoDispSemManutFerr();
			dao.commitaTransacao();
			if(retorno == null) {
				throw new JsonException("Error");
			}
			String json = gson.toJson(retorno);
			return Response.status(responseStatus).entity(json).build();
		} catch (JsonException e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.BAD_REQUEST;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}	
}

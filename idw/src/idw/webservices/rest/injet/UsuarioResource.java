package idw.webservices.rest.injet;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmUsr;
import idw.model.rn.injet.UsuarioInjetRN;
import idw.model.rn.monitorizacao.injet.TempoRealInjetRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.JsonException;
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.dto.UsuarioDTO;
import idw.webservices.rest.dto.monitorizacao.injet.FiltroTempoRealMaquinaSulbrasDTO;
import idw.webservices.rest.dto.monitorizacao.injet.TempoRealIHMWebDTO;

@Path("/injet/usuarios")
public class UsuarioResource {

	@POST
	@Path("logar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logar(UsuarioDTO usuario) {
		
		System.out.println(usuario);
		
		DAOGenericoInjet dao = new DAOGenericoInjet();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			UsuarioInjetRN rn = new UsuarioInjetRN(dao);
			OmUsr usuarioPojo = null;
			if (usuario.getCdUsr() != null && !usuario.getCdUsr().equals("")
					&& usuario.getSenha() != null && !usuario.getSenha().equals("")
					&& (usuario.getLogin() == null || usuario.getLogin().equals(""))) {
				usuarioPojo = rn.getOperadorInjetAtivoPorCdUsuario(usuario.getCdUsr().toUpperCase(), usuario.getSenha().toUpperCase());
			} else {
				usuarioPojo = rn.getUsuarioInjet(usuario.getLogin().toUpperCase(), usuario.getSenha().toUpperCase());
			}
			dao.commitaTransacao();
			if(usuarioPojo == null) {
				throw new JsonException("Login ou senha inválido.");
			}
			String json = gson.toJson(converterParaDTOExcluindoSenha(usuarioPojo));
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
	
	private UsuarioDTO converterParaDTOExcluindoSenha(OmUsr usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCdUsr(usuario.getCdUsr());
		dto.setLogin(usuario.getLogin());
		dto.setDsApelido(usuario.getDsApelido());
		if(usuario.getOmGt() != null) {
			dto.setCdGtMonitorizacao(usuario.getOmGt().getCdGt());
		} else {
			dto.setCdGtMonitorizacao("");
		}		
		return dto;
	}
	
}

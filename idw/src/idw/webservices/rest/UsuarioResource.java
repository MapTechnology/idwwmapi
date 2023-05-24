package idw.webservices.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.rn.UsuarioRN;
import idw.webservices.dto.ErrorDTO;
import idw.webservices.rest.auth.TokenUtil;
import idw.webservices.rest.dto.UsuarioDTO;

@Path("/usuarios")
public class UsuarioResource {

	@POST
	@Path("logar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logar(UsuarioDTO usuario) {
		
		//System.out.println(usuario);
		
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;
		
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();
			UsuarioRN rn = new UsuarioRN(dao);
			OmUsr usuarioPojo = rn.getUsuario(usuario.getLogin(), usuario.getSenha());
			dao.commitaTransacao();
			if(usuarioPojo == null) {
				throw new JsonException("Login ou senha inválido.");
			}
			UsuarioDTO usuarioDTO = converterParaDTOExcluindoSenha(usuarioPojo);
			usuarioDTO.setToken(TokenUtil.create(usuario.getLogin()));
			String json = gson.toJson(usuarioDTO);
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {
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

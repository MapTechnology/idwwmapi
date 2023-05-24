package idw.webservices.rest.mfv;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.rn.UsuarioRN;
import idw.webservices.rest.ResourceWebApplicationException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/mfv/usuarios")
public class UsuarioResource {

	@GET
	///serve a dois tipos de chamadas @Path("/getusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		// fa3getusuario : passa parametros ; getlistausuarios : nao passa params
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UsuarioRN usuarioRN = new UsuarioRN(dao);

			if (login != null && senha != null && !login.trim().equals("")) {
				OmUsr usuario = usuarioRN.getOmUsrPorLoginSenha(login, senha);

				JsonObject usuarioJson = new JsonObject();

				if(usuario != null) {
					usuarioJson.addProperty("id_usr", usuario.getIdUsr());//id_usr
					usuarioJson.addProperty("ds_nome", usuario.getDsNome());//ds_nome
					usuarioJson.addProperty("idusr", usuario.getIdUsr());
					usuarioJson.addProperty("apelido", usuario.getDsApelido());
					usuarioJson.addProperty("login", usuario.getLogin());
					usuarioJson.addProperty("senha", usuario.getSenha());
					rootElement.add("usuario", gson.toJsonTree(usuarioJson));
				}
			} else {
				List<OmUsr> usuarios = usuarioRN.getTodosOmUsrAtivosOrdenadoPorNome("a3");
				List<JsonObject> usuariosFormatados = new ArrayList<>();
				for(OmUsr usuario : usuarios) {
					JsonObject usuarioJson = new JsonObject();
					usuarioJson.addProperty("id", usuario.getIdUsr());
					usuarioJson.addProperty("nome", usuario.getDsNome());
					if (usuario.getDsApelido() == null) {
						usuarioJson.addProperty("apelido", usuario.getDsNome());
					} else {						
						usuarioJson.addProperty("apelido", usuario.getDsApelido());
					}

					usuariosFormatados.add(usuarioJson);
				}
				rootElement.add("usuarios", gson.toJsonTree(usuariosFormatados));
			}


			dao.commitaTransacao(dao.getSession());			
			responseStatus = Response.Status.OK;
			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}
}

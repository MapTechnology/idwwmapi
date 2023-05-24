package idw.webservices.rest.idw.v2;

import java.util.ArrayList;

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
import idw.webservices.rest.ResourceWebApplicationException;
import idw.webservices.rest.auth.TokenUtilNIDW;
import idw.webservices.rest.idw.v2.dto.LoginDTO;
import idw.webservices.rest.idw.v2.dto.MenusAcessoDTO;

@Path("/v2/login")
public class LoginResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogin(LoginDTO login) {
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		Response.Status responseStatus = Response.Status.OK;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			UsuarioRN rn = new UsuarioRN();
			rn.setDao(dao);

			OmUsr usr = rn.getUsuario(login.getLogin(), login.getSenha());
			if (usr == null) {
				responseStatus = Response.Status.NOT_FOUND;
				ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "USUÁRIO OU SENHA INVÁLIDOS", "");
				String json = gson.toJson(error);
				return Response.status(responseStatus).entity(json).build();
			} else {
				LoginDTO retorno = new LoginDTO();
				retorno.setCdUsr(usr.getCdUsr());
				retorno.setDsUsr(usr.getDsNome());
				retorno.setLogin(usr.getLogin());
				retorno.setAcessos(new ArrayList<MenusAcessoDTO>());
				retorno.setToken(TokenUtilNIDW.create(retorno.getLogin()));

				// simulacao >>> serah preenchido no futuro
				MenusAcessoDTO menuPai = new MenusAcessoDTO();
				menuPai.setCdMenu("Acesso principal - teste");
				menuPai.setItensMenu(new ArrayList<MenusAcessoDTO>());

				MenusAcessoDTO menuFilho = new MenusAcessoDTO();
				menuFilho.setCdMenu("Teste 1");
				menuPai.getItensMenu().add(menuFilho);

				menuFilho = new MenusAcessoDTO();
				menuFilho.setCdMenu("Teste 2");
				menuPai.getItensMenu().add(menuFilho);

				retorno.getAcessos().add(menuPai);

				dao.commitaTransacao();
				if (retorno == null || retorno.getAcessos().size() == 0) {
					// throw new JsonException("Error");
					responseStatus = Response.Status.NOT_FOUND;
					ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), "0001", "");
					String json = gson.toJson(error);
					return Response.status(responseStatus).entity(json).build();

				} else {
					String json = gson.toJson(retorno);
					return Response.status(responseStatus).entity(json).build();
				}
			}

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
			ErrorDTO error = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), "");
			throw new ResourceWebApplicationException(responseStatus, error);
		} finally {
			dao.finalizaSessaoSemException();
		}
	}

}

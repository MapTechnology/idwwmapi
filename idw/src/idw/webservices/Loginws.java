package idw.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.model.pojos.OmCfg;
import idw.webservices.dto.LicencaIDWDTO;
import ms.model.MsFacade;

@WebService(name = "loginws", targetNamespace = "http://idw/loginws", serviceName = "loginws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Loginws {

	/* RETORNA A HORA ATUAL DO SERVIDOR QUE HOSPEDA OS WEBSERVICES */
	@WebMethod
	public idw.webservices.dto.UsuariosDTO getUsuariosDTO(idw.webservices.dto.UsuarioDTO usuario) {
		return IdwFacade.getInstancia().getUsuariosDTO(usuario);
	}
	
	@WebMethod
	public idw.webservices.dto.UsuarioDTO isUsuarioAutenticado(idw.webservices.dto.UsuarioDTO usuario){
		return IdwFacade.getInstancia().isUsuarioAutenticado(usuario);
	}

	@WebMethod
	public OmCfg pesquisarOmCfgAtual() {
		return IdwFacade.getInstancia().getConfiguracaoAtual();
	}
	@WebMethod
	public LicencaIDWDTO isLicenciado(LicencaIDWDTO dto) {
		return IdwFacade.getInstancia().isLicenciado(dto);
	}
	@WebMethod
	public idw.webservices.dto.UsuarioDTO isOperadorAutenticado(String login, String senha) {
		return MsFacade.getInstancia().isOperadorAutenticado(login, senha);
	}
	@WebMethod
	public idw.webservices.dto.UsuarioDTO isSupervisorCancelaEtiqueta(String login, String senha) {
		return MsFacade.getInstancia().isSupervisorCancelaEtiqueta(login, senha);
	}
	@WebMethod
	public idw.webservices.dto.UsuarioDTO isTecnicoTrocaOP(String login, String senha) {
		return MsFacade.getInstancia().isTecnicoTrocaOP(login, senha);
	}
}
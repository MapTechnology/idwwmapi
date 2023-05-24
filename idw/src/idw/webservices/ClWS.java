package idw.webservices;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.webservices.dto.ConfiguracaoCheckLevelDTO;
import idw.webservices.dto.ResultadoEntradaLocalProdutoDTO;
import idw.webservices.dto.UsuarioCODTO;


@WebService(name = "ClWS", targetNamespace = "http://cl/services", serviceName = "ClWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ClWS {
	
	
	@WebMethod
	public UsuarioCODTO isUsuarioAutorizadoLiberarCF(String matricula){
		return IdwFacade.getInstancia().isUsuarioAutorizadoLiberarCF(matricula);
	}	
	
	@WebMethod
	public UsuarioCODTO getUsuarioCODTO(String matricula) {
		return IdwFacade.getInstancia().getUsuarioCODTO(matricula);
	} 
	
	@WebMethod
	public ResultadoEntradaLocalProdutoDTO setEntradaLocalProduto(String cdProduto, String cdLocalDestino, int qtdEntrada,String usuario){	
		return IdwFacade.getInstancia().setEntradaLocalProduto(cdProduto, cdLocalDestino, qtdEntrada,usuario);		
	}
	
	@WebMethod
	public ResultadoEntradaLocalProdutoDTO setMovimentacaoLocalProduto(String cdLocalOrigem,String cdProduto, String cdLocalDestino, int qtdEntrada,String usuario) {	
		return IdwFacade.getInstancia().setMovimentacaoLocalProduto(cdLocalOrigem, cdProduto, cdLocalDestino, qtdEntrada,usuario);		
	}
	
	@WebMethod
	public ConfiguracaoCheckLevelDTO getConfiguracaoCheckLevel() {
		return IdwFacade.getInstancia().getConfiguracaoCheckLevel();
	}
	

		
	
	

}

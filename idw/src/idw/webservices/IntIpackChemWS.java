package idw.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.model.rn.integracao.ipackchem.dto.IpcOPDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcOPRet;
import idw.model.rn.integracao.ipackchem.dto.IpcProDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcProRet;

@WebService(name = "IntIpackChemWS", targetNamespace = "http://ipackchem/services", serviceName = "IntIpackChemWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class IntIpackChemWS 
{

	@WebMethod
	public IpcProRet importarProdutoIpcInj(IpcProDTO produto)
	{
		return IdwFacade.getInstancia().importarProdutoIpcInj(produto);
	}
	
	@WebMethod
	public IpcOPRet importarOPIpcInj(IpcOPDTO op)
	{
		return IdwFacade.getInstancia().importarOPIpcInj(op);
	}	
}

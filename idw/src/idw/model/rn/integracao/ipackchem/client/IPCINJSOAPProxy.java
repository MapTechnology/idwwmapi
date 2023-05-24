package idw.model.rn.integracao.ipackchem.client;

public class IPCINJSOAPProxy implements idw.model.rn.integracao.ipackchem.client.IPCINJSOAP {
  private String _endpoint = null;
  private idw.model.rn.integracao.ipackchem.client.IPCINJSOAP iPCINJSOAP = null;
  
  public IPCINJSOAPProxy() {
    _initIPCINJSOAPProxy();
  }
  
  public IPCINJSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initIPCINJSOAPProxy();
  }
  
  private void _initIPCINJSOAPProxy() {
    try {
      iPCINJSOAP = (new idw.model.rn.integracao.ipackchem.client.IPCINJLocator()).getIPCINJSOAP();
      if (iPCINJSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iPCINJSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iPCINJSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iPCINJSOAP != null)
      ((javax.xml.rpc.Stub)iPCINJSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public idw.model.rn.integracao.ipackchem.client.IPCINJSOAP getIPCINJSOAP() {
    if (iPCINJSOAP == null)
      _initIPCINJSOAPProxy();
    return iPCINJSOAP;
  }
  
  public idw.model.rn.integracao.ipackchem.client.XRET03 XLIBCERTIFICADO(idw.model.rn.integracao.ipackchem.client.XPAR03 XLST_PAR03) throws java.rmi.RemoteException{
    if (iPCINJSOAP == null)
      _initIPCINJSOAPProxy();
    return iPCINJSOAP.XLIBCERTIFICADO(XLST_PAR03);
  }
  
  public idw.model.rn.integracao.ipackchem.client.XRET01 XOPDTPREV(idw.model.rn.integracao.ipackchem.client.XPAR01 XLST_PAR01) throws java.rmi.RemoteException{
    if (iPCINJSOAP == null)
      _initIPCINJSOAPProxy();
    return iPCINJSOAP.XOPDTPREV(XLST_PAR01);
  }
  
  public idw.model.rn.integracao.ipackchem.client.XRET02 XPRODUCAO(idw.model.rn.integracao.ipackchem.client.XPAR02 XLST_PAR02) throws java.rmi.RemoteException{
    if (iPCINJSOAP == null)
      _initIPCINJSOAPProxy();
    return iPCINJSOAP.XPRODUCAO(XLST_PAR02);
  }
  
  
}
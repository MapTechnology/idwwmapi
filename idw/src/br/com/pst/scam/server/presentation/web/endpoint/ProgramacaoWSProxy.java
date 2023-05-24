package br.com.pst.scam.server.presentation.web.endpoint;

public class ProgramacaoWSProxy implements br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS {
  private String _endpoint = null;
  private br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS programacaoWS = null;
  
  public ProgramacaoWSProxy() {
    _initProgramacaoWSProxy();
  }
  
  public ProgramacaoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initProgramacaoWSProxy();
  }
  
  private void _initProgramacaoWSProxy() {
    try {
      programacaoWS = (new br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWSServiceLocator()).getProgramacaoWSPort();
      if (programacaoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)programacaoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)programacaoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (programacaoWS != null)
      ((javax.xml.rpc.Stub)programacaoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.pst.scam.server.presentation.web.endpoint.ProgramacaoWS getProgramacaoWS() {
    if (programacaoWS == null)
      _initProgramacaoWSProxy();
    return programacaoWS;
  }
  
  public java.lang.String getProgramacaosByMaquinaWS(java.lang.String usuarioMatricula, java.lang.String usuarioSenha, java.lang.String maquinaNome) throws java.rmi.RemoteException{
    if (programacaoWS == null)
      _initProgramacaoWSProxy();
    return programacaoWS.getProgramacaosByMaquinaWS(usuarioMatricula, usuarioSenha, maquinaNome);
  }
  
  public java.lang.String getProgramacaoCompletoWS(java.lang.String usuarioMatricula, java.lang.String usuarioSenha, java.lang.String programacaoId) throws java.rmi.RemoteException{
    if (programacaoWS == null)
      _initProgramacaoWSProxy();
    return programacaoWS.getProgramacaoCompletoWS(usuarioMatricula, usuarioSenha, programacaoId);
  }
  
  
}
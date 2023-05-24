package idw.idwws;

public class IdwwsProxy implements idw.idwws.Idwws_PortType {
  private String _endpoint = null;
  private idw.idwws.Idwws_PortType idwws_PortType = null;
  
  public IdwwsProxy() {
    _initIdwwsProxy();
  }
  
  public IdwwsProxy(String endpoint) {
    _endpoint = endpoint;
    _initIdwwsProxy();
  }
  
  private void _initIdwwsProxy() {
    try {
      idwws_PortType = (new idw.idwws.Idwws_ServiceLocator()).getidwwsPort();
      if (idwws_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)idwws_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)idwws_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (idwws_PortType != null)
      ((javax.xml.rpc.Stub)idwws_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public idw.idwws.Idwws_PortType getIdwws_PortType() {
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType;
  }
  
  public double getCicloPadrao(idw.idwws.DwFolha arg0, idw.idwws.OmPt arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getCicloPadrao(arg0, arg1);
  }
  
  public double getPcsPorCicloAtivas(idw.idwws.DwFolha arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPcsPorCicloAtivas(arg0);
  }
  
  public idw.idwws.PpClienteDTO[] getPpClientesDTO(idw.idwws.PpClienteDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPpClientesDTO(arg0);
  }
  
  public idw.idwws.PpClienteDTO setPpClienteDTO(idw.idwws.PpClienteDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setPpClienteDTO(arg0);
  }
  
  public idw.idwws.PpClienteDTO[] removePpClientesDTO(idw.idwws.PpClienteDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removePpClientesDTO(arg0);
  }
  
  public void salvarNovaPpCp(idw.idwws.PpCp arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.salvarNovaPpCp(arg0);
  }
  
  public idw.idwws.MsicupDTO[] getListaMsicup() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaMsicup();
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmpt(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmpt(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaArea(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaArea(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmpa(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmpa(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmgt(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmgt(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmcc(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmcc(arg0);
  }
  
  public idw.idwws.GtDTO[] getGTsDTO(idw.idwws.GtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGTsDTO(arg0);
  }
  
  public idw.idwws.GtDTO setGTDTO(idw.idwws.GtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setGTDTO(arg0);
  }
  
  public idw.idwws.GtDTO[] removeGTsDTO(idw.idwws.GtDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeGTsDTO(arg0);
  }
  
  public idw.idwws.GtDTO ativaGTDTO(idw.idwws.GtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaGTDTO(arg0);
  }
  
  public idw.idwws.PtDTO[] getPTsDTO(idw.idwws.PtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPTsDTO(arg0);
  }
  
  public idw.idwws.PtDTO setPtDTO(idw.idwws.PtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setPtDTO(arg0);
  }
  
  public idw.idwws.PtDTO[] removePTsDTO(idw.idwws.PtDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removePTsDTO(arg0);
  }
  
  public idw.idwws.PtDTO ativaPtDTO(idw.idwws.PtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaPtDTO(arg0);
  }
  
  public idw.idwws.PaDTO validarPaDTO(idw.idwws.PaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarPaDTO(arg0);
  }
  
  public boolean isMapaValido(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.isMapaValido(arg0, arg1);
  }
  
  public idw.idwws.LeiturasCODTO setCorrente(idw.idwws.LeiturasCODTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setCorrente(arg0);
  }
  
  public idw.idwws.LeiturasCODTO getCorrente(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getCorrente(arg0);
  }
  
  public idw.idwws.TurnoDTO[] getTurnosDTO(idw.idwws.TurnoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTurnosDTO(arg0);
  }
  
  public idw.idwws.TurnoDTO setTurnoDTO(idw.idwws.TurnoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTurnoDTO(arg0);
  }
  
  public idw.idwws.TAcaoDTO[] getTAcoesDTO(idw.idwws.TAcaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTAcoesDTO(arg0);
  }
  
  public idw.idwws.TAcaoDTO setTAcaoDTO(idw.idwws.TAcaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTAcaoDTO(arg0);
  }
  
  public idw.idwws.SessoesDTO heartBeat(java.lang.String arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.heartBeat(arg0, arg1);
  }
  
  public idw.idwws.LoginDTO setLoginDTO(idw.idwws.LoginDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setLoginDTO(arg0);
  }
  
  public idw.idwws.LogoutDTO setLogoutDTO(idw.idwws.LogoutDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setLogoutDTO(arg0);
  }
  
  public idw.idwws.EtapaDTO[] getEtapasDTO(idw.idwws.EtapaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEtapasDTO(arg0);
  }
  
  public idw.idwws.EtapaDTO setEtapaDTO(idw.idwws.EtapaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setEtapaDTO(arg0);
  }
  
  public idw.idwws.FolhasDTO getFolhasDTO(idw.idwws.FolhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getFolhasDTO(arg0);
  }
  
  public idw.idwws.FolhaDTO setFolhaDTO(idw.idwws.FolhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setFolhaDTO(arg0);
  }
  
  public idw.idwws.ChangeLogBDDTO[] getChangeLogsBDNaoExecutados() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getChangeLogsBDNaoExecutados();
  }
  
  public idw.idwws.ChangeLogBDDTO[] getChangeLogsBDExecutados() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getChangeLogsBDExecutados();
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmprodutoComponente(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmprodutoComponente(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmprodutoAgrupador(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmprodutoAgrupador(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwprocedimento(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwprocedimento(arg0);
  }
  
  public idw.idwws.GrupoUsuarioDTO[] removeGrupoUsuariosDTO(idw.idwws.GrupoUsuarioDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeGrupoUsuariosDTO(arg0);
  }
  
  public java.lang.Object soma(int n1, int n2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.soma(n1, n2);
  }
  
  public boolean ping() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ping();
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmprodutoExcessaoProdutoFinal(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmprodutoExcessaoProdutoFinal(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmprodutoComponenteComAgrupador(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmprodutoComponenteComAgrupador(arg0);
  }
  
  public idw.idwws.ConfiguracaoNecessidadeDTO[] pesquisaListaConfiguracaoNecessidadeDTO(idw.idwws.ConfiguracaoNecessidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaListaConfiguracaoNecessidadeDTO(arg0);
  }
  
  public idw.idwws.ConfiguracaoNecessidadeDTO setExclusaoConfiguracoesNecessidadesDTO(idw.idwws.ConfiguracaoNecessidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setExclusaoConfiguracoesNecessidadesDTO(arg0);
  }
  
  public idw.idwws.PtGtDTO pesquisarCentrosComCPsDeProdutosIguais(idw.idwws.OmProduto arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarCentrosComCPsDeProdutosIguais(arg0);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosDTO(long idpt, long idturno, java.lang.String dtreferencia) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePtandroidUltimosCiclosDTO(idpt, idturno, dtreferencia);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePtandroidUltimosCiclosBIDTO(long idgt, long idturno, java.lang.String dtreferencia) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePtandroidUltimosCiclosBIDTO(idgt, idturno, dtreferencia);
  }
  
  public idw.idwws.MsMs pesquisarMsMsPorURLConexaoComParametro(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarMsMsPorURLConexaoComParametro(arg0);
  }
  
  public idw.idwws.UsuarioDTO[] getUsuariosDTO(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUsuariosDTO(arg0);
  }
  
  public boolean executarChangeLogBD(idw.idwws.ChangeLogBDDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.executarChangeLogBD(arg0);
  }
  
  public idw.idwws.UsuarioDTO setUsuarioDTO(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setUsuarioDTO(arg0);
  }
  
  public idw.idwws.UsuarioDTO[] removeUsuariosDTO(idw.idwws.UsuarioDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeUsuariosDTO(arg0);
  }
  
  public idw.idwws.UsuarioDTO ativaUsuarioDTO(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaUsuarioDTO(arg0);
  }
  
  public idw.idwws.UsuarioDTO isUsuarioAutenticado(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.isUsuarioAutenticado(arg0);
  }
  
  public idw.idwws.UsuarioDTO getUsuarioDTO(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUsuarioDTO(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaTurno(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaTurno(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwFolha(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwFolha(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwEst(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwEst(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwCal(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwCal(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwPepro(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwPepro(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwFtParam(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwFtParam(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaGrupoProduto(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaGrupoProduto(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmgrpusr(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmgrpusr(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmusr(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmusr(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmresgui(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmresgui(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmimg(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmimg(arg0);
  }
  
  public idw.idwws.OmImg pesquisaOmimgLikeUrl(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmimgLikeUrl(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmCargo(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmCargo(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwGrpativ(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwGrpativ(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmEstoque(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmEstoque(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmgtFabrica(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmgtFabrica(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmtpgt(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmtpgt(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwTParada(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwTParada(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmtppt(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmtppt(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmproduto(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmproduto(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwRap(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwRap(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmfornecedor(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmfornecedor(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmprg(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmprg(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmmapa(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmmapa(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaOmcfgscrpimp(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaOmcfgscrpimp(arg0);
  }
  
  public idw.idwws.GrupoUsuarioDTO[] getGrupoUsuariosDTO(idw.idwws.GrupoUsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGrupoUsuariosDTO(arg0);
  }
  
  public idw.idwws.GrupoUsuarioDTO setGrupoUsuarioDTO(idw.idwws.GrupoUsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setGrupoUsuarioDTO(arg0);
  }
  
  public idw.idwws.GrupoUsuarioDTO ativaGrupoUsuarioDTO(idw.idwws.GrupoUsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaGrupoUsuarioDTO(arg0);
  }
  
  public idw.idwws.DireitoAcessoDTO validarRecursoGUI(idw.idwws.DireitoAcessoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarRecursoGUI(arg0);
  }
  
  public idw.idwws.MonitorizacaoHierarquicaDTO getGtsHierarquico(idw.idwws.OmGt arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGtsHierarquico(arg0);
  }
  
  public idw.idwws.GtDTO[] getGTsComLayoutDTO(idw.idwws.GtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGTsComLayoutDTO(arg0);
  }
  
  public idw.idwws.ProdutosDTO getProdutosDTO(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getProdutosDTO(arg0);
  }
  
  public idw.idwws.ProdutoDTO setProdutoDTO(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setProdutoDTO(arg0);
  }
  
  public idw.idwws.ProdutosDTO removeProdutosDTO(idw.idwws.ProdutosDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeProdutosDTO(arg0);
  }
  
  public idw.idwws.ProdutoDTO ativaProdutoDTO(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaProdutoDTO(arg0);
  }
  
  public idw.idwws.FornecedorDTO[] getFornecedoresDTO(idw.idwws.FornecedorDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getFornecedoresDTO(arg0);
  }
  
  public idw.idwws.FornecedorDTO setFornecedorDTO(idw.idwws.FornecedorDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setFornecedorDTO(arg0);
  }
  
  public idw.idwws.FornecedorDTO ativaFornecedorDTO(idw.idwws.FornecedorDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaFornecedorDTO(arg0);
  }
  
  public idw.idwws.PtDTO[] getAndroidPTsDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getAndroidPTsDTO();
  }
  
  public idw.idwws.PtDTO[] getPTsDeGtDTO(idw.idwws.PtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPTsDeGtDTO(arg0);
  }
  
  public idw.idwws.PaDTO[] geracaoAutomaticaPA(idw.idwws.PtDTO arg0, idw.idwws.WizPaDTO arg1, int arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.geracaoAutomaticaPA(arg0, arg1, arg2);
  }
  
  public idw.idwws.MapaPaDTO validarMapaPaDTO(idw.idwws.MapaPaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarMapaPaDTO(arg0);
  }
  
  public idw.idwws.AlimentacaoDTO[] getAlimentacoesDTO(idw.idwws.AlimentacaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getAlimentacoesDTO(arg0);
  }
  
  public idw.idwws.EtiquetaDTO[] getEtiquetasProduto(idw.idwws.ProdutosDTO arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEtiquetasProduto(arg0, arg1);
  }
  
  public idw.idwws.EtiquetaDTO[] getEtiquetasMapas(idw.idwws.MapaAlimentacaoDTO[] arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEtiquetasMapas(arg0, arg1);
  }
  
  public idw.idwws.EtiquetaDTO[] getEtiquetasPTs(idw.idwws.PtDTO[] arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEtiquetasPTs(arg0, arg1);
  }
  
  public idw.idwws.EtiquetaDTO[] getEtiquetasPAs(idw.idwws.PaDTO[] arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEtiquetasPAs(arg0, arg1);
  }
  
  public void importarPrograma(java.lang.String arg0, java.lang.String arg1, boolean arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.importarPrograma(arg0, arg1, arg2);
  }
  
  public idw.idwws.UsuarioCODTO getUsuarioCODTO(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUsuarioCODTO(arg0);
  }
  
  public idw.idwws.MapasCODTO getMapasCODTO(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getMapasCODTO(arg0);
  }
  
  public idw.idwws.PosicaoCODTO[] getPosicoesCODTO(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPosicoesCODTO(arg0, arg1);
  }
  
  public boolean setConferenciaOuPre(idw.idwws.LeiturasCODTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setConferenciaOuPre(arg0);
  }
  
  public boolean setRealimentacao(idw.idwws.LeiturasCODTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setRealimentacao(arg0);
  }
  
  public void assumePreConferencia(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.assumePreConferencia(arg0);
  }
  
  public boolean isRecursoAcessivel(int arg0, long arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.isRecursoAcessivel(arg0, arg1);
  }
  
  public idw.idwws.ParametroDTO[] getParametrosDTO(idw.idwws.ParametroDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getParametrosDTO(arg0);
  }
  
  public idw.idwws.ConfiguracoesDTO getConfiguracoesDTO(idw.idwws.ConfiguracaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getConfiguracoesDTO(arg0);
  }
  
  public idw.idwws.ParametroDTO setParametroDTO(idw.idwws.ParametroDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setParametroDTO(arg0);
  }
  
  public idw.idwws.ConfiguracaoDTO setConfiguracaoDTO(idw.idwws.ConfiguracaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setConfiguracaoDTO(arg0);
  }
  
  public idw.idwws.ParametroDTO[] removeParametrosDTO(idw.idwws.ParametroDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeParametrosDTO(arg0);
  }
  
  public idw.idwws.TurnoDTO[] removeTurnosDTO(idw.idwws.TurnoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTurnosDTO(arg0);
  }
  
  public idw.idwws.TurnoDTO ativaTurnoDTO(idw.idwws.TurnoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaTurnoDTO(arg0);
  }
  
  public idw.idwws.TDefeitoDTO[] getTDefeitosDTO(idw.idwws.TDefeitoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTDefeitosDTO(arg0);
  }
  
  public idw.idwws.TDefeitoDTO setTDefeitoDTO(idw.idwws.TDefeitoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTDefeitoDTO(arg0);
  }
  
  public idw.idwws.TDefeitoDTO[] removeTDefeitosDTO(idw.idwws.TDefeitoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTDefeitosDTO(arg0);
  }
  
  public idw.idwws.TDefeitoDTO ativaTDefeitoDTO(idw.idwws.TDefeitoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaTDefeitoDTO(arg0);
  }
  
  public idw.idwws.TAcaoDTO[] removeTAcoesDTO(idw.idwws.TAcaoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTAcoesDTO(arg0);
  }
  
  public idw.idwws.TAcaoDTO ativaTAcaoDTO(idw.idwws.TAcaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaTAcaoDTO(arg0);
  }
  
  public idw.idwws.GrupoProdutoDTO[] getGruposProdutoDTO(idw.idwws.GrupoProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGruposProdutoDTO(arg0);
  }
  
  public idw.idwws.GrupoProdutoDTO setGrupoProdutoDTO(idw.idwws.GrupoProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setGrupoProdutoDTO(arg0);
  }
  
  public idw.idwws.GrupoProdutoDTO ativaGrupoProdutoDTO(idw.idwws.GrupoProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaGrupoProdutoDTO(arg0);
  }
  
  public idw.idwws.CalendarioDTO[] getCalendariosDTO(idw.idwws.CalendarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getCalendariosDTO(arg0);
  }
  
  public idw.idwws.CalendarioDTO setCalendarioDTO(idw.idwws.CalendarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setCalendarioDTO(arg0);
  }
  
  public idw.idwws.CalendarioDTO[] removeCalendariosDTO(idw.idwws.CalendarioDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeCalendariosDTO(arg0);
  }
  
  public idw.idwws.CalendariosSemanaisDTO wizardCalendario(idw.idwws.CalendarioWizardDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.wizardCalendario(arg0);
  }
  
  public idw.idwws.SessoesDTO inicializacao(java.lang.String arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.inicializacao(arg0, arg1);
  }
  
  public idw.idwws.PassagemDTO postoPassagem(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.postoPassagem(arg0);
  }
  
  public idw.idwws.PassagemDTO postoTesteVisual(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.postoTesteVisual(arg0);
  }
  
  public idw.idwws.PassagemDTO postoReprocesso(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.postoReprocesso(arg0);
  }
  
  public idw.idwws.PassagemDTO postoMontagem(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.postoMontagem(arg0);
  }
  
  public idw.idwws.PassagemDTO verificaPassagem(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.verificaPassagem(arg0);
  }
  
  public idw.idwws.EtapaDTO[] removeEtapasDTO(idw.idwws.EtapaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeEtapasDTO(arg0);
  }
  
  public void updateFolhaDTO(idw.idwws.FolhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.updateFolhaDTO(arg0);
  }
  
  public idw.idwws.FolhasDTO removeFolhasDTO(idw.idwws.FolhasDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeFolhasDTO(arg0);
  }
  
  public idw.idwws.AcoplamentoDTO verificaAcoplamento(idw.idwws.AcoplamentoDTO arg0, idw.idwws.MontagensDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.verificaAcoplamento(arg0, arg1);
  }
  
  public idw.idwws.DefeitoDTO verificaDefeito(idw.idwws.DefeitoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.verificaDefeito(arg0);
  }
  
  public idw.idwws.ComponenteDTO verificaComponente(idw.idwws.ComponenteDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.verificaComponente(arg0);
  }
  
  public idw.idwws.RoteiroDTO[] getRoteirosDTO(idw.idwws.RoteiroDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getRoteirosDTO(arg0);
  }
  
  public idw.idwws.RoteiroDTO setRoteiroDTO(idw.idwws.RoteiroDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setRoteiroDTO(arg0);
  }
  
  public idw.idwws.RoteiroDTO[] removeRoteirosDTO(idw.idwws.RoteiroDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeRoteirosDTO(arg0);
  }
  
  public idw.idwws.ImgDTO[] getImgsRoteiroDTO(idw.idwws.ImgDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getImgsRoteiroDTO(arg0);
  }
  
  public idw.idwws.ObjsDTO getArvoreObjsGt(idw.idwws.GtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getArvoreObjsGt(arg0);
  }
  
  public idw.idwws.ObjDTO getOmObjInicializado() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmObjInicializado();
  }
  
  public idw.idwws.ObjsDTO getObjsRoteiroDTO(idw.idwws.ObjDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getObjsRoteiroDTO(arg0);
  }
  
  public void setObjsRoteiro(idw.idwws.DwRota arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.setObjsRoteiro(arg0);
  }
  
  public idw.idwws.PassagemDTO postoTesteFuncional(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.postoTesteFuncional(arg0);
  }
  
  public idw.idwws.DetalheColetaDTO[] detalheColeta(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.detalheColeta(arg0);
  }
  
  public idw.idwws.RelIndTesteFinalDTO getRelIndTesteFinal(idw.idwws.FiltroRelDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getRelIndTesteFinal(arg0);
  }
  
  public idw.idwws.FolhasDTO getFolhasporProduto(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getFolhasporProduto(arg0);
  }
  
  public idw.idwws.EstoquesDTO getEstoquesDTO(idw.idwws.EstoqueDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEstoquesDTO(arg0);
  }
  
  public idw.idwws.EstoqueDTO setEstoqueDTO(idw.idwws.EstoqueDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setEstoqueDTO(arg0);
  }
  
  public idw.idwws.EstoquesDTO removeEstoqueDTO(idw.idwws.EstoquesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeEstoqueDTO(arg0);
  }
  
  public idw.idwws.EstoqueDTO ativaEstoqueDTO(idw.idwws.EstoqueDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaEstoqueDTO(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwRota(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwRota(arg0);
  }
  
  public idw.idwws.DetalhePTSerieDTO detalheEtapasTeste(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.detalheEtapasTeste(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaCliente(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaCliente(arg0);
  }
  
  public idw.idwws.PpNecListDTO importarPlanilhas(idw.idwws.PpNecListDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarPlanilhas(arg0);
  }
  
  public idw.idwws.DwRapDTO[] pesquisaListaRAPDTO(idw.idwws.DwRapDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaListaRAPDTO(arg0);
  }
  
  public idw.idwws.DwRapDTO setExclusaoRAPDTO(idw.idwws.DwRapDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setExclusaoRAPDTO(arg0);
  }
  
  public idw.idwws.PlanoListDTO pesquisarPlanos(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPlanos(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisarPlanosBusca(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPlanosBusca(arg0);
  }
  
  public idw.idwws.PpTpplanoListDTO pesquisarTpPlanos(idw.idwws.PpTpplanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarTpPlanos(arg0);
  }
  
  public idw.idwws.PpNecListDTO pesquisarPpNecs(java.util.Calendar arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPpNecs(arg0);
  }
  
  public idw.idwws.PlanoDTO excluirRegistro(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.excluirRegistro(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwFolhaRap() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwFolhaRap();
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaProgramaIAC(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaProgramaIAC(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaProdutoIAC(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaProdutoIAC(arg0);
  }
  
  public idw.idwws.DwRotapasso getOmPtDwRotapasso(idw.idwws.DwRotapasso arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmPtDwRotapasso(arg0);
  }
  
  public idw.idwws.PlanoListDTO pesquisarPlanoECPs(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPlanoECPs(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisarPpCliente(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPpCliente(arg0);
  }
  
  public idw.idwws.SapEstoqueDTO[] getSapEstoquesDTO(idw.idwws.SapEstoqueDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getSapEstoquesDTO(arg0);
  }
  
  public idw.idwws.DwTurnosDTO pesquisarTurnos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarTurnos();
  }
  
  public java.lang.String[] getEspecializaApon() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getEspecializaApon();
  }
  
  public idw.idwws.MsTpevt[] pesquisarMsTpEvts() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarMsTpEvts();
  }
  
  public idw.idwws.OmTppt[] pesquisarOmTppts() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarOmTppts();
  }
  
  public idw.idwws.MsDetectorDTO[] pesquisarMsDetector(idw.idwws.MsDetectorDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarMsDetector(arg0);
  }
  
  public idw.idwws.MsDetectorDTO excluirMsDetectors(idw.idwws.MsDetectorDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.excluirMsDetectors(arg0);
  }
  
  public idw.idwws.PpCmDTO salvarCmEstrutura(idw.idwws.PpCmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarCmEstrutura(arg0);
  }
  
  public idw.idwws.FolhasDTO importarCiclos(idw.idwws.FolhasDTO arg0, idw.idwws.UsuarioDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarCiclos(arg0, arg1);
  }
  
  public idw.idwws.DwConsolidDTOs importarProducao(idw.idwws.DwConsolidDTOs arg0, idw.idwws.UsuarioDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarProducao(arg0, arg1);
  }
  
  public idw.idwws.PpCmDTO[] pesquisarPpCm(idw.idwws.PpCmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPpCm(arg0);
  }
  
  public idw.idwws.ResultadoImportacaoSapDTO importarPlanilhaSAP(idw.idwws.SapEstoqueDTO[] arg0, idw.idwws.UsuarioDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarPlanilhaSAP(arg0, arg1);
  }
  
  public idw.idwws.ListaCPDTO pesquisarCpComPedido(idw.idwws.PpCp arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarCpComPedido(arg0);
  }
  
  public idw.idwws.PtImgMonitorizacaoDTO getImgsPTsDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getImgsPTsDTO();
  }
  
  public idw.idwws.GtImgMonitorizacaoDTO getImgsGTsDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getImgsGTsDTO();
  }
  
  public idw.idwws.DwFolhaDTO[] getDwFolhasPorCod(idw.idwws.FolhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwFolhasPorCod(arg0);
  }
  
  public idw.idwws.ListaIcDTO getListaIcDTO(idw.idwws.IcDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaIcDTO(arg0);
  }
  
  public idw.idwws.ListaIhmDTO getListaIhmDTO(idw.idwws.IhmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaIhmDTO(arg0);
  }
  
  public idw.idwws.ListaMSDTO getListaMSDTO(idw.idwws.MsDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaMSDTO(arg0);
  }
  
  public idw.idwws.ListaUPDTO getTodosUPDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosUPDTO();
  }
  
  public idw.idwws.ListaIcDTO getTodosIcDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosIcDTO();
  }
  
  public idw.idwws.ListaIhmDTO getTodosIhmDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosIhmDTO();
  }
  
  public idw.idwws.ListaUPDTO getListaupDTO(idw.idwws.UpDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaupDTO(arg0);
  }
  
  public idw.idwws.ListaEvtDTO pesquisaListaEvtDTO(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaListaEvtDTO(arg0, arg1);
  }
  
  public boolean configuraWebXml(idw.idwws.WebXMLDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.configuraWebXml(arg0);
  }
  
  public idw.idwws.WebXMLDTO pesquisarWebXml() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarWebXml();
  }
  
  public idw.idwws.BcDTO[] pesquisarListaBcs(idw.idwws.BcDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarListaBcs(arg0);
  }
  
  public idw.idwws.ListaMSDTO importacaoManual(long arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importacaoManual(arg0, arg1);
  }
  
  public java.lang.String salvarIcSimplificado(idw.idwws.IcDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarIcSimplificado(arg0);
  }
  
  public idw.idwws.TempoRealDTO getUltimoTempoRealPt(idw.idwws.FiltroProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUltimoTempoRealPt(arg0);
  }
  
  public idw.idwws.DwEstlocalDTO[] getDwEstlocal(idw.idwws.DwEstlocalDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwEstlocal(arg0);
  }
  
  public idw.idwws.DwEstlocalDTO setDwEstlocal(idw.idwws.DwEstlocalDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setDwEstlocal(arg0);
  }
  
  public idw.idwws.DwEstlocalDTO removeDwEstlocal(idw.idwws.DwEstlocalDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeDwEstlocal(arg0);
  }
  
  public idw.idwws.DwEstlocalproDTO[] getDwEstlocalpros(idw.idwws.DwEstlocalproDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwEstlocalpros(arg0);
  }
  
  public idw.idwws.TurnoDTO[] getTodosOsTurnos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosOsTurnos();
  }
  
  public idw.idwws.ProdutosDTO getTodosProdutosDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosProdutosDTO();
  }
  
  public idw.idwws.MonitorizacaoAlimDTO[] getMonitorizacaoAlim() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getMonitorizacaoAlim();
  }
  
  public idw.idwws.DwRapDTO[] getTodosDwRap() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosDwRap();
  }
  
  public idw.idwws.CiclosDTO getUltimosCiclos(idw.idwws.FiltroCiclosDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUltimosCiclos(arg0);
  }
  
  public idw.idwws.TurnoAtualDTO getTurnoAtual(idw.idwws.OmPt arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTurnoAtual(arg0, arg1);
  }
  
  public idw.idwws.TurnoAtualDTO getPeriodoTurno(idw.idwws.FiltroTurnoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPeriodoTurno(arg0);
  }
  
  public idw.idwws.TurnoAtualDTO getTurnoAtualGt(idw.idwws.OmGt arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTurnoAtualGt(arg0, arg1);
  }
  
  public idw.idwws.TurnoAtualDTO getTurnoAtual1PTDTO(java.util.Calendar arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTurnoAtual1PTDTO(arg0);
  }
  
  public idw.idwws.TurnoAtualDTO getTurnoAtualDTO(idw.idwws.OmPt arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTurnoAtualDTO(arg0, arg1);
  }
  
  public idw.idwws.CpsDTO setAdiantamentoDTO(idw.idwws.AdiantamentoDTO arg0, idw.idwws.PlanoDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setAdiantamentoDTO(arg0, arg1);
  }
  
  public idw.idwws.DetalheAnaliseGargaloDTO getDetalheCelulas(idw.idwws.FiltroProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalheCelulas(arg0);
  }
  
  public idw.idwws.DwParadaDTO[] getParadasDTO(idw.idwws.FiltroRelatorioParadaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getParadasDTO(arg0);
  }
  
  public idw.idwws.DwTRefugoDTO[] getRefugosDTO(idw.idwws.FiltroRelatorioRefugoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getRefugosDTO(arg0);
  }
  
  public idw.idwws.UsuarioDTO[] getOMUsuariosDTO(idw.idwws.FiltroRelatorioUsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOMUsuariosDTO(arg0);
  }
  
  public idw.idwws.AlertaDTO[] getAlertasDTO(idw.idwws.FiltroRelatorioAlertaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getAlertasDTO(arg0);
  }
  
  public idw.idwws.AlertaDTO[] getTAlertasDTO(idw.idwws.AlertaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTAlertasDTO(arg0);
  }
  
  public idw.idwws.AlertaDTO setTAlertaDTO(idw.idwws.AlertaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTAlertaDTO(arg0);
  }
  
  public idw.idwws.AlertaDTO[] removeTAlertasDTO(idw.idwws.AlertaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTAlertasDTO(arg0);
  }
  
  public idw.idwws.DwTJustDTO[] getTJustificativa(idw.idwws.DwTJustDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTJustificativa(arg0);
  }
  
  public idw.idwws.DwTJustDTO setTJustificativa(idw.idwws.DwTJustDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTJustificativa(arg0);
  }
  
  public idw.idwws.DwTJustDTO[] removeTJustificativa(idw.idwws.DwTJustDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTJustificativa(arg0);
  }
  
  public idw.idwws.DwTRefugoDTO[] removeTRefugo(idw.idwws.DwTRefugoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTRefugo(arg0);
  }
  
  public idw.idwws.DwProcedimentoDTO[] getDwProcedimento(idw.idwws.DwProcedimentoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwProcedimento(arg0);
  }
  
  public idw.idwws.DwProcedimentoDTO setDwProcedimento(idw.idwws.DwProcedimentoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setDwProcedimento(arg0);
  }
  
  public idw.idwws.DwProcedimentoDTO[] removeDwProcedimento(idw.idwws.DwProcedimentoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeDwProcedimento(arg0);
  }
  
  public idw.idwws.DwGrpativDTO[] removeDwGrpativ(idw.idwws.DwGrpativDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeDwGrpativ(arg0);
  }
  
  public idw.idwws.OmCargoDTO[] removeOmCargo(idw.idwws.OmCargoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeOmCargo(arg0);
  }
  
  public idw.idwws.DwParadaDTO[] removeTParada(idw.idwws.DwParadaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTParada(arg0);
  }
  
  public idw.idwws.GtDTO[] getGTsDtoAtivos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGTsDtoAtivos();
  }
  
  public idw.idwws.ConsolpaDTO[] getConsolpasDTO(idw.idwws.FiltroRelatorioIndiceParadasDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getConsolpasDTO(arg0);
  }
  
  public idw.idwws.DwParadaDTO[] getListaParadas() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaParadas();
  }
  
  public idw.idwws.ProdutoDTO integracaoEstProduto(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.integracaoEstProduto(arg0);
  }
  
  public idw.idwws.ProdutosDTO integracaoEstoque(java.util.Calendar arg0, idw.idwws.UsuarioDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.integracaoEstoque(arg0, arg1);
  }
  
  public idw.idwws.RoteiroDTO sugestaoRoteiro(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.sugestaoRoteiro(arg0);
  }
  
  public idw.idwws.DadosRelatorioDTO relatorioTurnoHora(java.util.Calendar arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.relatorioTurnoHora(arg0);
  }
  
  public idw.idwws.ArquivoTrilhaDTO[] getArquivoTrilha(idw.idwws.FiltroExportacaoTrilhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getArquivoTrilha(arg0);
  }
  
  public void setEventoInsert(idw.idwws.EventoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.setEventoInsert(arg0);
  }
  
  public idw.idwws.CpDTO pesquisarMpFaltante(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarMpFaltante(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaDwFolhaTesteFuncional(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaDwFolhaTesteFuncional(arg0);
  }
  
  public idw.idwws.ProdutosDTO pesquisarProdutosFinaisNoTurno(java.util.Calendar arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarProdutosFinaisNoTurno(arg0, arg1);
  }
  
  public idw.idwws.AcoplamentoDTO verificaComponenteAcoplamento(idw.idwws.AcoplamentoDTO arg0, idw.idwws.MontagensDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.verificaComponenteAcoplamento(arg0, arg1);
  }
  
  public idw.idwws.ConfiguracaoNecessidadeDTO setConfiguracoesNecessidadesDTO(idw.idwws.ConfiguracaoNecessidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setConfiguracoesNecessidadesDTO(arg0);
  }
  
  public idw.idwws.PpNecListDTO pesquisaListaNecessidadesClientesDTO(idw.idwws.PpNecDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaListaNecessidadesClientesDTO(arg0);
  }
  
  public idw.idwws.PpNecDTO setExclusaoNecessidadesClientesDTO(idw.idwws.PpNecDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setExclusaoNecessidadesClientesDTO(arg0);
  }
  
  public idw.idwws.EstoqueDTO salvarPrevChegadaMateriaPrima(idw.idwws.EstoquesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarPrevChegadaMateriaPrima(arg0);
  }
  
  public idw.idwws.ProdutoDTO importarPlanilhaEstruturaProduto(idw.idwws.ProdutoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarPlanilhaEstruturaProduto(arg0);
  }
  
  public idw.idwws.PlanosIndisponibilidadesDTO pesquisarPlanoIndisponibilidade(idw.idwws.PlanoIndisponibilidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPlanoIndisponibilidade(arg0);
  }
  
  public idw.idwws.PlanoIndisponibilidadeDTO excluirPlanoIndisponibilidade(idw.idwws.PlanoIndisponibilidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.excluirPlanoIndisponibilidade(arg0);
  }
  
  public idw.idwws.PlanoListDTO pesquisarPlanosPlanejamentoProducao(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarPlanosPlanejamentoProducao(arg0);
  }
  
  public idw.idwws.PlanoAcompanhamentoDTOList pesquisarAcompanhamentosDoPlano(idw.idwws.PlanoAcompanhamentoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarAcompanhamentosDoPlano(arg0);
  }
  
  public idw.idwws.PpNecListDTO pesquisarTodosCpComPedidoAtivo() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarTodosCpComPedidoAtivo();
  }
  
  public idw.idwws.DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPtInjetDTO(idw.idwws.FiltroDetalhePTInjetDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalheMonitorizacaoPtInjetDTO(arg0);
  }
  
  public idw.idwws.ProdutosDTO pesquisarProdutosPaiDisponiveis(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarProdutosPaiDisponiveis(arg0);
  }
  
  public idw.idwws.ConfiguraHibernateDTO pesquisaConfiguracaoHibernate(int arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaConfiguracaoHibernate(arg0);
  }
  
  public idw.idwws.MonitorizacaoAlimDTO[] getMonitorizacaoAlimComFiltro(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getMonitorizacaoAlimComFiltro(arg0);
  }
  
  public idw.idwws.GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTOAndroid(long idpt, long idturno, java.lang.String dtreferencia, long idCp) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePtFornoDTOAndroid(idpt, idturno, dtreferencia, idCp);
  }
  
  public idw.idwws.ListaPerdasmpDTO getGraficoPerdasMateriaPrimaDTO(idw.idwws.FiltroGraficoDetalhePtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoPerdasMateriaPrimaDTO(arg0);
  }
  
  public idw.idwws.GtRtMonitorizacaoDTO getGtRtMonitorizacaoTmAndroidDTO(long idturno, long idgt, java.lang.String dtreferencia) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGtRtMonitorizacaoTmAndroidDTO(idturno, idgt, dtreferencia);
  }
  
  public idw.idwws.PpNecListDTO integracaoPlanoProducaoPeriodo(java.util.Calendar arg0, java.util.Calendar arg1, idw.idwws.UsuarioDTO arg2, boolean arg3) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.integracaoPlanoProducaoPeriodo(arg0, arg1, arg2, arg3);
  }
  
  public idw.idwws.DetalheMonitorizacaoPTInjetDTO getDetalheMonitorizacaoPTAndroid(java.lang.String dtreferencia, long iddwconsolid, java.lang.String dtreferenciainicial, java.lang.String dtreferenciafinal, long idturno, long iddwrap, long idpt, long idgt, long idproduto, java.lang.String cdCp) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalheMonitorizacaoPTAndroid(dtreferencia, iddwconsolid, dtreferenciainicial, dtreferenciafinal, idturno, iddwrap, idpt, idgt, idproduto, cdCp);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePTandroidDTO(long idpt, long idturno, long idfolha, java.lang.String dtReferencia, java.lang.String dtReferenciainicial, java.lang.String dtReferenciafinal, long idCp, java.lang.String tpId, int limiteMaxresult) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePTandroidDTO(idpt, idturno, idfolha, dtReferencia, dtReferenciainicial, dtReferenciafinal, idCp, tpId, limiteMaxresult);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePTandroidDTOPorHora(long idpt, java.lang.String dtReferenciainicial, java.lang.String dtReferenciafinal) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePTandroidDTOPorHora(idpt, dtReferenciainicial, dtReferenciafinal);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePTandroidBIDTO(long idgt, long idturno, long idfolha, java.lang.String dtReferencia, java.lang.String dtReferenciainicial, java.lang.String dtReferenciafinal) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePTandroidBIDTO(idgt, idturno, idfolha, dtReferencia, dtReferenciainicial, dtReferenciafinal);
  }
  
  public idw.idwws.DetalhamentoProducaoDTO getDetalhamentoProducaoDTOAndroid(long iddwconsolid, java.lang.String dtreferenciainicial, java.lang.String dtreferenciafinal, long idpt) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalhamentoProducaoDTOAndroid(iddwconsolid, dtreferenciainicial, dtreferenciafinal, idpt);
  }
  
  public idw.idwws.DwFolhaDTO[] getGraficoDetalhePadraoandroidDTO(long idpt, long idfolha, java.lang.String dtreferencia) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePadraoandroidDTO(idpt, idfolha, dtreferencia);
  }
  
  public idw.idwws.DwFolhaDTO[] getGraficoDetalhePadraoandroidBIDTO(long idgt, long idfolha, java.lang.String dtreferencia) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePadraoandroidBIDTO(idgt, idfolha, dtreferencia);
  }
  
  public idw.idwws.MonitorizacaoHierarquicaDTO getMonitorizacaoHierarquicaDTO(idw.idwws.FiltroProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getMonitorizacaoHierarquicaDTO(arg0);
  }
  
  public idw.idwws.DetalhamentoParadaDTO getOcorrenciaParettoParadaDTO(java.util.Calendar arg0, java.math.BigDecimal arg1, java.math.BigDecimal arg2, boolean arg3, boolean arg4, java.math.BigDecimal arg5, java.lang.String arg6) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOcorrenciaParettoParadaDTO(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public idw.idwws.DetalhamentoParadaDTO getOcorrenciaBIParettoParadaDTO(java.util.Calendar arg0, java.util.Calendar arg1, java.math.BigDecimal arg2, java.math.BigDecimal arg3, java.math.BigDecimal arg4, boolean arg5, boolean arg6, java.math.BigDecimal arg7, java.lang.String arg8) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOcorrenciaBIParettoParadaDTO(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }
  
  public idw.idwws.OmObjDTO[] obterMonitorizacaoVisaoRoteiro(java.util.Calendar arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.obterMonitorizacaoVisaoRoteiro(arg0, arg1, arg2);
  }
  
  public idw.idwws.GtDTO[] getAndroidGTsComLayoutDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getAndroidGTsComLayoutDTO();
  }
  
  public idw.idwws.FornecedorDTO[] removeFornecedoresDTO(idw.idwws.FornecedorDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeFornecedoresDTO(arg0);
  }
  
  public idw.idwws.MapaAlimentacaoDTO[] getMapasAlimentacaoDTO(idw.idwws.MapaAlimentacaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getMapasAlimentacaoDTO(arg0);
  }
  
  public idw.idwws.MapaAlimentacaoDTO setMapaAlimentacaoDTO(idw.idwws.MapaAlimentacaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setMapaAlimentacaoDTO(arg0);
  }
  
  public idw.idwws.MapaAlimentacaoDTO[] removeMapasAlimentacaoDTO(idw.idwws.MapaAlimentacaoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeMapasAlimentacaoDTO(arg0);
  }
  
  public idw.idwws.MapaAlimentacaoDTO ativaMapaAlimentacaoDTO(idw.idwws.MapaAlimentacaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.ativaMapaAlimentacaoDTO(arg0);
  }
  
  public idw.idwws.ComponenteDeParaDTO[] importarComponentesDePara(idw.idwws.ComponenteDeParaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarComponentesDePara(arg0);
  }
  
  public boolean isProdutoEAlternativo(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.isProdutoEAlternativo(arg0, arg1);
  }
  
  public idw.idwws.HomologacoesDTO validarHomologacoesUsrPt(idw.idwws.HomologacoesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarHomologacoesUsrPt(arg0);
  }
  
  public idw.idwws.HomologacoesDTO validarHomologacoesUsrGt(idw.idwws.HomologacoesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarHomologacoesUsrGt(arg0);
  }
  
  public idw.idwws.HomologacoesDTO validarHomologacoesGt(idw.idwws.HomologacoesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarHomologacoesGt(arg0);
  }
  
  public idw.idwws.HomologacoesDTO validarHomologacoesPt(idw.idwws.HomologacoesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarHomologacoesPt(arg0);
  }
  
  public idw.idwws.ConfiguracoesDTO removeConfiguracoesDTO(idw.idwws.ConfiguracoesDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeConfiguracoesDTO(arg0);
  }
  
  public idw.idwws.GrupoProdutoDTO[] removeGruposProdutoDTO(idw.idwws.GrupoProdutoDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeGruposProdutoDTO(arg0);
  }
  
  public idw.idwws.CalendarioPtsDTO validarCalendarioPtsDTO(idw.idwws.CalendarioPtsDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.validarCalendarioPtsDTO(arg0);
  }
  
  public idw.idwws.CalendariosSemanaisDTO getCalendariosSemanaisDTO(idw.idwws.CalendarioSemanalFiltroDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getCalendariosSemanaisDTO(arg0);
  }
  
  public idw.idwws.PassagemDTO obtemNaoConformidadesAtuais(idw.idwws.PassagemDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.obtemNaoConformidadesAtuais(arg0);
  }
  
  public idw.idwws.GtRtMonitorizacaoDTO getGtRtMonitorizacaoDTO(idw.idwws.GtRtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGtRtMonitorizacaoDTO(arg0);
  }
  
  public idw.idwws.GtRtMonitorizacaoDTO getGtRtMonitorizacaoAcum(idw.idwws.GtRtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGtRtMonitorizacaoAcum(arg0);
  }
  
  public idw.idwws.DetalhePTGraficoTesteFuncionalDTO getGraficoTesteFuncional(idw.idwws.FiltroDetalhePTDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoTesteFuncional(arg0);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaUnidadeMedida(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaUnidadeMedida(arg0);
  }
  
  public idw.idwws.PpNecimpurllogListDTO pesquisarAbasByUrlLog(idw.idwws.PpNecimpurllogListDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarAbasByUrlLog(arg0);
  }
  
  public idw.idwws.PpNecDTO setNecessidadesClientesDTO(idw.idwws.PpNecDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setNecessidadesClientesDTO(arg0);
  }
  
  public idw.idwws.IndicadorMinMetaMaxDTO[] buscarIndicadoresMinMetaMax(idw.idwws.FiltroIndCfg arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.buscarIndicadoresMinMetaMax(arg0);
  }
  
  public idw.idwws.PtGtDTO pesquisarCentrosTrabalho() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarCentrosTrabalho();
  }
  
  public idw.idwws.PlanoDTO salvarPlanoManipulacao(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarPlanoManipulacao(arg0);
  }
  
  public idw.idwws.EstoquesDTO pesquisarEstoqueMateriaPrima(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarEstoqueMateriaPrima(arg0, arg1, arg2);
  }
  
  public idw.idwws.SapConhecimentoDTO[] getSapConhecimentosDTO(idw.idwws.SapConhecimentoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getSapConhecimentosDTO(arg0);
  }
  
  public idw.idwws.PtDTO[] pesquisarOmPtsAtivosComGt() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarOmPtsAtivosComGt();
  }
  
  public idw.idwws.DwConsolidDTOs pesquisarApontamentoProducao(idw.idwws.DwConsolidDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarApontamentoProducao(arg0);
  }
  
  public idw.idwws.DwFolhaDTO[] pesquisaProdutoNaFolha(java.lang.String arg0, long arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaProdutoNaFolha(arg0, arg1);
  }
  
  public idw.idwws.DwConsolidDTO salvarApontamentoProducao(idw.idwws.DwConsolidDTOs arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarApontamentoProducao(arg0);
  }
  
  public idw.idwws.TmgConhecimentoDTO[] getTmgConhecimentosDTO(idw.idwws.TmgConhecimentoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTmgConhecimentosDTO(arg0);
  }
  
  public idw.idwws.MsDetectorDTO salvarAlertaPlanejamento(idw.idwws.MsDetectorDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarAlertaPlanejamento(arg0);
  }
  
  public idw.idwws.PlanoIndisponibilidadeDTO salvarPlanoIndisponibilidade(idw.idwws.PlanoIndisponibilidadeDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarPlanoIndisponibilidade(arg0);
  }
  
  public idw.idwws.ListaCPDTO pesquisaListaPredecessoraCP(long arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaListaPredecessoraCP(arg0);
  }
  
  public idw.idwws.CpsDTO pesquisarCpByProdutoFinal(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarCpByProdutoFinal(arg0);
  }
  
  public idw.idwws.ObjsLayoutRoteiroDTO getObjsLayoutRoteiroDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getObjsLayoutRoteiroDTO();
  }
  
  public idw.idwws.IcDTO pesquisarMsIcPorUrlConexao(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarMsIcPorUrlConexao(arg0);
  }
  
  public boolean salvarConfiguracoesHibernate(idw.idwws.ConfiguraHibernateDTO arg0, int arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarConfiguracoesHibernate(arg0, arg1);
  }
  
  public boolean salvarConfiguracaoLog4J(idw.idwws.Log4JDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarConfiguracaoLog4J(arg0);
  }
  
  public idw.idwws.Log4JDTO carregarPropriedadesLog4JDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.carregarPropriedadesLog4JDTO();
  }
  
  public boolean isUsuarioOperadorAutenticado(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.isUsuarioOperadorAutenticado(arg0, arg1, arg2);
  }
  
  public void carregaTabelasBasicas() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.carregaTabelasBasicas();
  }
  
  public idw.idwws.CiclosDTO getUltimosCiclosAndroid(long idpt, long idCp) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getUltimosCiclosAndroid(idpt, idCp);
  }
  
  public idw.idwws.GraficoDetalhePtDTO getGraficoDetalhePtDTO(idw.idwws.FiltroGraficoDetalhePtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePtDTO(arg0);
  }
  
  public idw.idwws.GraficoDetalhePtFornoDTO getGraficoDetalhePtFornoDTO(idw.idwws.FiltroGraficoDetalhePtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePtFornoDTO(arg0);
  }
  
  public idw.idwws.DwFolhaDTO[] getGraficoDetalhePadraoDTO(idw.idwws.FiltroGraficoDetalhePtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoDetalhePadraoDTO(arg0);
  }
  
  public idw.idwws.DetalhamentoProducaoDTO getDetalhamentoProducao(idw.idwws.FiltroDetalheProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalhamentoProducao(arg0);
  }
  
  public idw.idwws.ListaDetalheAnaliseTurnoDTO getDetalheAnaliseTurno(idw.idwws.FiltroProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalheAnaliseTurno(arg0);
  }
  
  public idw.idwws.DetalhamentoParadaDTO getDetalhamentoParada(idw.idwws.FiltroDetalhePTInjetDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDetalhamentoParada(arg0);
  }
  
  public idw.idwws.DwGrpativDTO[] getTodosDwGrpativAtivos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosDwGrpativAtivos();
  }
  
  public idw.idwws.OmCargoDTO[] getTodosOmCargosAtivos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosOmCargosAtivos();
  }
  
  public idw.idwws.DwFolhaDTO[] getTodasDwFolhasAtivas() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodasDwFolhasAtivas();
  }
  
  public idw.idwws.DwFolhaDTO[] getDwFolhaDoProcedimento(idw.idwws.DwProcedimento arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwFolhaDoProcedimento(arg0);
  }
  
  public void integrarEstoqueFuturo(idw.idwws.PeriodoDTO arg0, idw.idwws.UsuarioDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.integrarEstoqueFuturo(arg0, arg1);
  }
  
  public void integracaoApontamentoDiario(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.integracaoApontamentoDiario(arg0);
  }
  
  public idw.idwws.DadosRelatorioDTO relatorioPlanejadoRealizado(java.util.Calendar arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.relatorioPlanejadoRealizado(arg0, arg1);
  }
  
  public idw.idwws.DadosRelatorioDTO relatorioMapaEscadinha(idw.idwws.DadosRelatorioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.relatorioMapaEscadinha(arg0);
  }
  
  public idw.idwws.ProdutosDTO getListaProdutosFiltrosBIDTO(idw.idwws.FiltroDetalhePTInjetDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaProdutosFiltrosBIDTO(arg0);
  }
  
  public idw.idwws.GraficoBIParetoDTO getGrafBIParetoPerdas(idw.idwws.FiltroDetalhePTInjetDTO arg0, idw.idwws.DetalheMonitorizacaoPTInjetDTO arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGrafBIParetoPerdas(arg0, arg1);
  }
  
  public idw.idwws.GraficoBIItemRecorrenciaDTO[] getGraficoBIRecorrencia(idw.idwws.FiltroDetalhePTInjetDTO arg0, byte arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoBIRecorrencia(arg0, arg1, arg2);
  }
  
  public idw.idwws.GtDTO pesquisarOmGtPorIdOuCd(idw.idwws.OmGt arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarOmGtPorIdOuCd(arg0);
  }
  
  public idw.idwws.GraficosParettoParadaDTO getGraficoParettoParadaDTO(java.util.Calendar arg0, java.math.BigDecimal arg1, java.math.BigDecimal arg2, boolean arg3, boolean arg4, java.math.BigDecimal arg5) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoParettoParadaDTO(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public idw.idwws.GraficosParettoParadaDTO getGraficoParettoParadaBIDTO(java.util.Calendar arg0, java.util.Calendar arg1, java.math.BigDecimal arg2, java.math.BigDecimal arg3, java.math.BigDecimal arg4, boolean arg5, boolean arg6, java.math.BigDecimal arg7) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGraficoParettoParadaBIDTO(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public idw.idwws.PlanoDTO importarArquivoTrilha(idw.idwws.FiltroImportacaoTrilhaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarArquivoTrilha(arg0);
  }
  
  public idw.idwws.ImgDTO[] getImgsDTO(idw.idwws.ImgDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getImgsDTO(arg0);
  }
  
  public idw.idwws.ObjsDTO getObjsDTO(idw.idwws.ObjDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getObjsDTO(arg0);
  }
  
  public idw.idwws.GtRtDTO getGtRtDTO(idw.idwws.GtRtDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getGtRtDTO(arg0);
  }
  
  public idw.idwws.DetalhePTDTO detalhePT(idw.idwws.FiltroDetalhePTDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.detalhePT(arg0);
  }
  
  public idw.idwws.PpNecimplogListDTO buscarLogs(long arg0, int arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.buscarLogs(arg0, arg1);
  }
  
  public idw.idwws.DwRapDTO setRAPDTO(idw.idwws.DwRapDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setRAPDTO(arg0);
  }
  
  public idw.idwws.PlanoDTO salvarPlano(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarPlano(arg0);
  }
  
  public idw.idwws.PlanoDTO firmarPlano(idw.idwws.PlanoDTO arg0, boolean arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.firmarPlano(arg0, arg1);
  }
  
  public idw.idwws.PesquisaDTO[] pesquisaRAPs(idw.idwws.PesquisaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaRAPs(arg0);
  }
  
  public idw.idwws.PtDTO[] getPtsAtivos() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPtsAtivos();
  }
  
  public idw.idwws.MsInd[] pesquisaInds() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisaInds();
  }
  
  public idw.idwws.ResultadoImportacaoSapDTO importarSap(idw.idwws.UsuarioDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.importarSap(arg0);
  }
  
  public idw.idwws.PlanoDTO simularPlano(idw.idwws.PlanoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.simularPlano(arg0);
  }
  
  public idw.idwws.PpCmDTO removePpCm(idw.idwws.PpCmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removePpCm(arg0);
  }
  
  public idw.idwws.ListaIcDTO removeIcDTO(idw.idwws.IcDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeIcDTO(arg0);
  }
  
  public idw.idwws.ListaIhmDTO setihmDTO(idw.idwws.IhmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setihmDTO(arg0);
  }
  
  public idw.idwws.ListaIhmDTO removeIhmDTO(idw.idwws.IhmDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeIhmDTO(arg0);
  }
  
  public idw.idwws.ListaMSDTO setMSDTO(idw.idwws.MsDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setMSDTO(arg0);
  }
  
  public idw.idwws.ListaMSDTO removeMSDTO(idw.idwws.MsDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeMSDTO(arg0);
  }
  
  public idw.idwws.ListaUPDTO setupDTO(idw.idwws.UpDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setupDTO(arg0);
  }
  
  public idw.idwws.ListaUPDTO removeUpDTO(idw.idwws.UpDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeUpDTO(arg0);
  }
  
  public idw.idwws.ListaUPDTO getTodosPrUp() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTodosPrUp();
  }
  
  public java.lang.String pesquisarLog(java.math.BigDecimal arg0, java.math.BigDecimal arg1) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.pesquisarLog(arg0, arg1);
  }
  
  public idw.idwws.IwsConsultaDTO consulta(idw.idwws.EventoColetado arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.consulta(arg0);
  }
  
  public idw.idwws.ListaIcDTO getListaMsIC() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaMsIC();
  }
  
  public idw.idwws.ListaIcDTO salvarIcDTO(idw.idwws.IcDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.salvarIcDTO(arg0);
  }
  
  public idw.idwws.BcDTO[] getListBcDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListBcDTO();
  }
  
  public idw.idwws.ListaUPDTO getListaMsUP() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getListaMsUP();
  }
  
  public idw.idwws.OmTppt[] getOmTpptDTO() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmTpptDTO();
  }
  
  public idw.idwws.DwTCausaDTO[] getTCausa(idw.idwws.DwTCausaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTCausa(arg0);
  }
  
  public idw.idwws.DwTCausaDTO setTCausa(idw.idwws.DwTCausaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTCausa(arg0);
  }
  
  public idw.idwws.DwTCausaDTO[] removeTCausa(idw.idwws.DwTCausaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTCausa(arg0);
  }
  
  public idw.idwws.DwTRefugoDTO[] getTRefugo(idw.idwws.DwTRefugoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTRefugo(arg0);
  }
  
  public idw.idwws.DwTRefugoDTO setTRefugo(idw.idwws.DwTRefugoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTRefugo(arg0);
  }
  
  public idw.idwws.DwTAreaDTO[] getTArea(idw.idwws.DwTAreaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTArea(arg0);
  }
  
  public idw.idwws.DwTAreaDTO setTArea(idw.idwws.DwTAreaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTArea(arg0);
  }
  
  public idw.idwws.DwTAreaDTO[] removeTArea(idw.idwws.DwTAreaDTO[] arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.removeTArea(arg0);
  }
  
  public idw.idwws.DwGrpativDTO[] getDwGrpativ(idw.idwws.DwGrpativDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwGrpativ(arg0);
  }
  
  public idw.idwws.DwGrpativDTO setDwGrpativ(idw.idwws.DwGrpativDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setDwGrpativ(arg0);
  }
  
  public idw.idwws.OmCargoDTO[] getOmCargo(idw.idwws.OmCargoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmCargo(arg0);
  }
  
  public idw.idwws.OmCargoDTO setOmCargo(idw.idwws.OmCargoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setOmCargo(arg0);
  }
  
  public idw.idwws.DwParadaDTO[] getTParada(idw.idwws.DwParadaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getTParada(arg0);
  }
  
  public idw.idwws.DwParadaDTO setTParada(idw.idwws.DwParadaDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.setTParada(arg0);
  }
  
  public idw.idwws.FirmwareDTO[] getFirmwares() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getFirmwares();
  }
  
  public void integracaoCM() throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    idwws_PortType.integracaoCM();
  }
  
  public idw.idwws.DwRota getDwRota(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getDwRota(arg0);
  }
  
  public idw.idwws.OmProduto getOmProduto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmProduto(arg0);
  }
  
  public idw.idwws.IndicadoresDTO[] getProducaoBrutaPt(idw.idwws.FiltroProducaoDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getProducaoBrutaPt(arg0);
  }
  
  public idw.idwws.PtDTO getOmPtOuIdOuCd(idw.idwws.OmPt arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getOmPtOuIdOuCd(arg0);
  }
  
  public idw.idwws.PtDTO[] getPtsDoTtptDaFolha(idw.idwws.DwFolha arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getPtsDoTtptDaFolha(arg0);
  }
  
  public idw.idwws.MaquinasInjetDTO getIndicadoresInjet(idw.idwws.FiltroMaquinaInjetDTO arg0) throws java.rmi.RemoteException{
    if (idwws_PortType == null)
      _initIdwwsProxy();
    return idwws_PortType.getIndicadoresInjet(arg0);
  }
  
  
}
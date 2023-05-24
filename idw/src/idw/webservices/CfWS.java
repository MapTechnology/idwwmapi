package idw.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import idw.model.IdwFacade;
import idw.model.rn.estoque.LocalEstoqueDTO;
import idw.model.rn.folhainspecaorap.QqInsRapDTO;
import idw.webservices.dto.ConfiguracaoCheckFeederDTO;
import idw.webservices.dto.FerramentaDTO;
import idw.webservices.dto.GruposTrabalhoDTO;
import idw.webservices.dto.LeiturasCODTO;
import idw.webservices.dto.MapasCODTO;
import idw.webservices.dto.MateriaPrimaSemp;
import idw.webservices.dto.MonitorizacoesCheckFeederDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.PosicoesCODTO;
import idw.webservices.dto.SucessoDTO;
import idw.webservices.dto.UsuarioCODTO;

@WebService(name = "CfWS", targetNamespace = "http://cf/services", serviceName = "CfWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CfWS {
	
	@WebMethod
	public UsuarioCODTO getUsuarioCODTO(String matricula) {
		return IdwFacade.getInstancia().getUsuarioCODTO(matricula);
	}
	@WebMethod
	public UsuarioCODTO isUsuarioAutorizadoLiberarCF(String matricula){
		return IdwFacade.getInstancia().isUsuarioAutorizadoLiberarCF(matricula);
	}
	@WebMethod
	public Boolean setConferenciaOuPre(LeiturasCODTO leituras) {
		return IdwFacade.getInstancia().setConferenciaOuPre(leituras);
	}
		
	@WebMethod
	public MapasCODTO getMapasCODTO(String maquina){
		return IdwFacade.getInstancia().getMapasCODTO(maquina);
	}
	@WebMethod
	public Boolean setRealimentacao(LeiturasCODTO leituras) {
		return IdwFacade.getInstancia().setRealimentacao(leituras);
	}
	@WebMethod
	public PesquisasDTO pesquisaOmproduto(PesquisaDTO pesquisa) {
		return IdwFacade.getInstancia().pesquisaOmprodutoFinal(pesquisa);
	}
		
	@WebMethod
	public PesquisasDTO pesquisaOmprodutoComponente(PesquisaDTO pesquisa) {
		return IdwFacade.getInstancia().pesquisaOmprodutoComponente(pesquisa);
	}
	
	@WebMethod
	public Boolean getProdutoByCdEStAtivo(String cdProduto) {
			return IdwFacade.getInstancia().getProdutoByCdEStAtivo(cdProduto);
	}			
	@WebMethod
	public Boolean isMapaValido(String maquina, String mapa) {
		return IdwFacade.getInstancia().isMapaValido(maquina, mapa);
	}
	@WebMethod
	public LeiturasCODTO getCorrente(Long idAlimCorrente) {
		return IdwFacade.getInstancia().getCorrente(idAlimCorrente);
	}
	@WebMethod
	public PosicoesCODTO getPosicoesCODTO(String maquina, String mapa, Boolean isUsarEspelhamento) {
		//Luiz 20200220 Deve comentar o pojo ommapapa do posicoaodto quando for atualizar o pidion
		return IdwFacade.getInstancia().getPosicoesCODTO(maquina, mapa, isUsarEspelhamento);
	}	
	
	@WebMethod
	public PosicoesCODTO getPosicaoAlternativos(String maquina, String mapa) {
		return IdwFacade.getInstancia().getPosicaoAlternativos(maquina, mapa);
	}	

	
	@WebMethod
	public ConfiguracaoCheckFeederDTO getConfiguracaoCheckFeeder() {
		return IdwFacade.getInstancia().getConfiguracao();
	}
	
	@WebMethod
	public String validaPosicoes(PosicoesCODTO posicoes, String maquina, String mapa){
		return IdwFacade.getInstancia().validaPosicoes(posicoes,maquina, mapa);
		
	}
	
	@WebMethod
	public Boolean validaPosicaoEProdutoRealim(String posicao, String produto, String maquina, String mapa ){
		return IdwFacade.getInstancia().validaPosicaoEProdutoRealim( posicao,  produto,  maquina,  mapa);	
	}
		
	@WebMethod
	public LeiturasCODTO setCorrente(LeiturasCODTO leituras) {
		return IdwFacade.getInstancia().setCorrente(leituras);
	}
	@WebMethod
	public void assumePreConferencia(String maquina) {
		IdwFacade.getInstancia().assumePreConferencia(maquina);
	}
	@WebMethod
	public Boolean isProdutoEAlternativo(String cdProduto, String cdProdutoLido) {
		return IdwFacade.getInstancia().isProdutoEAlternativo(cdProduto,
				cdProdutoLido);
	}
	
	@WebMethod
	public MonitorizacoesCheckFeederDTO getMonitorizacaoCheckFeeder(String cdPt){
		return IdwFacade.getInstancia().getMonitorizacaoCheckFeeder(cdPt);
	}	 
	
	@WebMethod
	public void desalimentacao(String omPt){
		IdwFacade.getInstancia().desalimentacao(omPt, null);
	}

	@WebMethod
	public void desalimentacaoPt(String omPt,long usr){
		IdwFacade.getInstancia().desalimentacao(omPt,usr);
	}
	
	@WebMethod
	public int sendStatusSemp(String maquina, String stCheck, String stAlim, String stRealim ) {
		return IdwFacade.getInstancia().sendStatusSemp(maquina, stCheck, stAlim, stRealim);
	}
	
	@WebMethod
	public MateriaPrimaSemp getStatusSempMateriaPrima(String cdup, String op, String componente) {
		return IdwFacade.getInstancia().getStatusSempMateriaPrima(cdup, op, componente);	
	}
	
	@WebMethod
	public GruposTrabalhoDTO pesquisarTodosGtsSemPt() {
		return IdwFacade.getInstancia().getGTsDtoAtivosSemPt();
	}

	@WebMethod
	public FerramentaDTO pesquisarNCsFerramentaByCd(String cdrap) {
		return IdwFacade.getInstancia().pesquisarNCsFerramentaByCd(cdrap);
	}
	
	@WebMethod
	public LocalEstoqueDTO validarLocalEstoque(String cdlocalOrigem, String cdlocalDestino, String cdrap) {
		return IdwFacade.getInstancia().validarLocalEstoque(cdlocalOrigem,  cdlocalDestino, cdrap);
	}
	@WebMethod
	public SucessoDTO movimentarFerramenta(String cdLocalOrigem, String cdLocalDestino, String cdrap, String login) {
		return IdwFacade.getInstancia().movimentarFerramenta(cdLocalOrigem, cdLocalDestino, cdrap, login);
	}

	@WebMethod
	public QqInsRapDTO salvarInspecaoFerramenta(LocalEstoqueDTO local) {
		return IdwFacade.getInstancia().salvarInspecaoFerramenta(local);
	}
}

package ms.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.MsIhm;

@SuppressWarnings("serial")
public class IhmDTO implements Serializable{
	private Integer idIhm;
	private PortaEthernetDTO conexaoIHM;
	
	private Integer tipoRequisicaoIHM;
	private Integer tipoRequisicaoWS;
	private String cdIhm;
	private String url_Conexao;
	private String url_ConexaoAlternativo;
	private String url_Ip;
	private Date dthrCadastro;
	
	private Boolean isEvtPendente;
	private Boolean isEvtCicloFechado;
	private Boolean isEvtTrabalhando;
	private Boolean isEvtParada;
	private Boolean isEvtRefugo;
	private Boolean isEvtAlerta;
	private Boolean isEvtLogin;
	private Boolean isUpRegistrado;
	private Boolean isTodosEvt;
	
	private String loginUsuario;
	
	private List<EventoPrevistoDTO> tratamentoSinais;
	private List<EventoRealDTO> eventosPendentes = new ArrayList<EventoRealDTO>();
	
	private List<UpIhmDTO> ups = new ArrayList<UpIhmDTO>();


	private WsDTO wsDTO = new WsDTO();
	
	public IhmDTO() {
		
	}
	public IhmDTO(MsIhm msihm){
		this.cdIhm = msihm.getCdIhm();
		this.idIhm = msihm.getIdIhm().intValue();
		this.url_Conexao = msihm.getUrlConexao();
		this.url_Ip = msihm.getUrlIp();
		this.dthrCadastro = msihm.getDthrCadastro();
	}
	
	
	public Integer getIdIhm() {
		return idIhm;
	}
	public void setIdIhm(Integer idIhm) {
		this.idIhm = idIhm;
	}
	public Integer getTipoRequisicaoIHM() {
		return tipoRequisicaoIHM;
	}
	public void setTipoRequisicaoIHM(Integer tipoRequisicao) {
		this.tipoRequisicaoIHM = tipoRequisicao;
	}
	public List<EventoRealDTO> getEventosPendentes() {
		return eventosPendentes;
	}
	public void setEventosPendentes(List<EventoRealDTO> eventosPendentes) {
		this.eventosPendentes = eventosPendentes;
	}
	public WsDTO getWsDTO() {
		return wsDTO;
	}
	public void setWsDTO(WsDTO wsDTO) {
		this.wsDTO = wsDTO;
	}
	public Integer getTipoRequisicaoWS() {
		return tipoRequisicaoWS;
	}
	public void setTipoRequisicaoWS(Integer tipoRequisicaoWS) {
		this.tipoRequisicaoWS = tipoRequisicaoWS;
	}
	public PortaEthernetDTO getConexaoIHM() {
		return conexaoIHM;
	}
	public void setConexaoIHM(PortaEthernetDTO conexaoIHM) {
		this.conexaoIHM = conexaoIHM;
	}
	public List<EventoPrevistoDTO> getTratamentoSinais() {
		return tratamentoSinais;
	}
	public void setTratamentoSinais(List<EventoPrevistoDTO> tratamentoSinais) {
		this.tratamentoSinais = tratamentoSinais;
	}
	public void setUrl_Conexao(String url_Conexao) {
		this.url_Conexao = url_Conexao;
	}
	public String getUrl_Conexao() {
		return url_Conexao;
	}
	public void setUrl_Ip(String url_Ip) {
		this.url_Ip = url_Ip;
	}
	public String getUrl_Ip() {
		return url_Ip;
	}
	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	public Date getDthrCadastro() {
		return dthrCadastro;
	}
	public void setIsEvtPendente(Boolean isEvtPendente) {
		this.isEvtPendente = isEvtPendente;
	}
	public Boolean getIsEvtPendente() {
		return isEvtPendente;
	}
	public void setIsEvtCicloFechado(Boolean isEvtCicloFechado) {
		this.isEvtCicloFechado = isEvtCicloFechado;
	}
	public Boolean getIsEvtCicloFechado() {
		return isEvtCicloFechado;
	}
	public void setIsEvtTrabalhando(Boolean isEvtTrabalhando) {
		this.isEvtTrabalhando = isEvtTrabalhando;
	}
	public Boolean getIsEvtTrabalhando() {
		return isEvtTrabalhando;
	}
	public void setIsEvtParada(Boolean isEvtParada) {
		this.isEvtParada = isEvtParada;
	}
	public Boolean getIsEvtParada() {
		return isEvtParada;
	}
	public void setIsEvtRefugo(Boolean isEvtRefugo) {
		this.isEvtRefugo = isEvtRefugo;
	}
	public Boolean getIsEvtRefugo() {
		return isEvtRefugo;
	}
	public void setIsEvtAlerta(Boolean isEvtAlerta) {
		this.isEvtAlerta = isEvtAlerta;
	}
	public Boolean getIsEvtAlerta() {
		return isEvtAlerta;
	}
	public void setIsEvtLogin(Boolean isEvtLogin) {
		this.isEvtLogin = isEvtLogin;
	}
	public Boolean getIsEvtLogin() {
		return isEvtLogin;
	}
	public void setIsUpRegistrado(Boolean isUpRegistrado) {
		this.isUpRegistrado = isUpRegistrado;
	}
	public Boolean getIsUpRegistrado() {
		return isUpRegistrado;
	}
	public void setIsTodosEvt(Boolean isTodosEvt) {
		this.isTodosEvt = isTodosEvt;
	}
	public Boolean getIsTodosEvt() {
		return isTodosEvt;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public String getCdIhm() {
		return cdIhm;
	}
	public void setCdIhm(String cdIhm) {
		this.cdIhm = cdIhm;
	}
	public String getUrl_ConexaoAlternativo() {
		return url_ConexaoAlternativo;
	}
	public void setUrl_ConexaoAlternativo(String url_ConexaoAlternativo) {
		this.url_ConexaoAlternativo = url_ConexaoAlternativo;
	}
	public List<UpIhmDTO> getUps() {
		return ups;
	}
	public void setUps(List<UpIhmDTO> ups) {
		this.ups = ups;
	}
	
	
}

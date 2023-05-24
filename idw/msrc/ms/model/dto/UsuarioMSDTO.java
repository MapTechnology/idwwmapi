package ms.model.dto;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.MsUsr;

@SuppressWarnings("serial")
public class UsuarioMSDTO implements Serializable{

	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_USUARIO_JA_EXISTE = 1;
	private int ERRO_GRUPO_DESCONHECIDO = 2;
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDUSR_INVALIDO = 7;
	private int ERRO_LOGIN_INVALIDO = 8;
	private int ERRO_REATIVACAO_INDISPONIVEL = 8;
	
	private String login;
	private String senha;
	private String nome;
	private String cdusuario;
	private Date dthrLogin;
	private Long idUsr;
	private MsUsr msusr;
	private int resultadoEvento;
	
	
	
	public Long getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(Long idUsr) {
		this.idUsr = idUsr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDthrLogin() {
		return dthrLogin;
	}
	public void setDthrLogin(Date dthrLogin) {
		this.dthrLogin = dthrLogin;
	}
	public String getCdusuario() {
		return cdusuario;
	}
	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}
	public void setMsusr(MsUsr msusr) {
		this.msusr = msusr;
	}
	public MsUsr getMsusr() {
		return msusr;
	}
	public UsuarioMSDTO getUsuarioDTO(){
		return this;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setERRO_USUARIO_JA_EXISTE(int eRRO_USUARIO_JA_EXISTE) {
		ERRO_USUARIO_JA_EXISTE = eRRO_USUARIO_JA_EXISTE;
	}
	public int getERRO_USUARIO_JA_EXISTE() {
		return ERRO_USUARIO_JA_EXISTE;
	}
	public void setERRO_GRUPO_DESCONHECIDO(int eRRO_GRUPO_DESCONHECIDO) {
		ERRO_GRUPO_DESCONHECIDO = eRRO_GRUPO_DESCONHECIDO;
	}
	public int getERRO_GRUPO_DESCONHECIDO() {
		return ERRO_GRUPO_DESCONHECIDO;
	}
	public void setERRO_CC_DESCONHECIDO(int eRRO_CC_DESCONHECIDO) {
		ERRO_CC_DESCONHECIDO = eRRO_CC_DESCONHECIDO;
	}
	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRROUSUARIOREVISAODESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRROUSUARIOREVISAODESCONHECIDO;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRROUSUARIOSTATUSDESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRROUSUARIOSTATUSDESCONHECIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}
	public int getERRO_CDUSR_INVALIDO() {
		return ERRO_CDUSR_INVALIDO;
	}
	public void setERRO_CDUSR_INVALIDO(int eRROCDUSRINVALIDO) {
		ERRO_CDUSR_INVALIDO = eRROCDUSRINVALIDO;
	}
	public int getERRO_LOGIN_INVALIDO() {
		return ERRO_LOGIN_INVALIDO;
	}
	public void setERRO_LOGIN_INVALIDO(int eRROLOGININVALIDO) {
		ERRO_LOGIN_INVALIDO = eRROLOGININVALIDO;
	}
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	
	
}

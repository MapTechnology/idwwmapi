package ms.model.dto;

public class ConfiguraHibernateDTO {
	
	private String nomeBanco;
	private String nomeHost;
	private String instanciaBanco;
	private String portaBanco;
	private String usuario;
	private String senha;
	private Integer tipoBanco; //1-SQLServer, 0-Oracle
	private String caminhoArquivo;
	private String autenticacao;
	
	
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}
	public String getNomeHost() {
		return nomeHost;
	}
	public void setInstanciaBanco(String instanciaBanco) {
		this.instanciaBanco = instanciaBanco;
	}
	public String getInstanciaBanco() {
		return instanciaBanco;
	}
	public void setPortaBanco(String portaBanco) {
		this.portaBanco = portaBanco;
	}
	public String getPortaBanco() {
		return portaBanco;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public void setTipoBanco(Integer tipoBanco) {
		this.tipoBanco = tipoBanco;
	}
	public Integer getTipoBanco() {
		return tipoBanco;
	}
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}
	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}
	public String getAutenticacao() {
		return autenticacao;
	}

}

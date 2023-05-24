package injetws.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IwsUsuarioDTO implements Serializable {
	
	private String idregusuario;
	//private PrConexoesInjet prConexoesInjet;
	private String cdusuario;
	private String nome;
	private String senha;
	private char isoperador;
	private char istecnico;
	
	private boolean bErro;
	private char istecqualidade;
	
	public String getIdregusuario() {
		return idregusuario;
	}
	public void setIdregusuario(String idregusuario) {
		this.idregusuario = idregusuario;
	}
	
	/*public PrConexoesInjet getPrConexoesInjet() {
		return prConexoesInjet;
	}
	public void setPrConexoesInjet(PrConexoesInjet prConexoesInjet) {
		this.prConexoesInjet = prConexoesInjet;
	}*/
	
	public String getCdusuario() {
		return cdusuario;
	}
	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public char getIsoperador() {
		return isoperador;
	}
	public void setIsoperador(char isoperador) {
		this.isoperador = isoperador;
	}
	
	public char getIstecnico() {
		return istecnico;
	}
	public void setIstecnico(char istecnico) {
		this.istecnico = istecnico;
	}
	
	public char getIsTecQualidade() {
		return this.istecqualidade;
	}

	public void setIsTecQualidade(char isTecQualidade) {
		this.istecqualidade = isTecQualidade;
	}	
	
	
	public boolean isbErro() {
		return bErro;
	}
	public void setbErro(boolean bErro) {
		this.bErro = bErro;
	}
	
	
}

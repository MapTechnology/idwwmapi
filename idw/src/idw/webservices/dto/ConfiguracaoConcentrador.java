package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

public class ConfiguracaoConcentrador implements Serializable {
	private static final long serialVersionUID = 1;
	
	private String nomeServico;
	private int bloqFimOPProbQld;
	private int refugoPorPeso;
	private int somente1Login;
	private int loginPorMatricula;
	private List<String> listaColetores;
	
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public int getBloqFimOPProbQld() {
		return bloqFimOPProbQld;
	}
	public void setBloqFimOPProbQld(int bloqFimOPProbQld) {
		this.bloqFimOPProbQld = bloqFimOPProbQld;
	}
	public int getRefugoPorPeso() {
		return refugoPorPeso;
	}
	public void setRefugoPorPeso(int refugoPorPeso) {
		this.refugoPorPeso = refugoPorPeso;
	}
	public int getSomente1Login() {
		return somente1Login;
	}
	public void setSomente1Login(int somente1Login) {
		this.somente1Login = somente1Login;
	}
	public int getLoginPorMatricula() {
		return loginPorMatricula;
	}
	public void setLoginPorMatricula(int loginPorMatricula) {
		this.loginPorMatricula = loginPorMatricula;
	}
	public List<String> getListaColetores() {
		return listaColetores;
	}
	public void setListaColetores(List<String> listaColetores) {
		this.listaColetores = listaColetores;
	}
	
	
}

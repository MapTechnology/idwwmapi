package idw.model.rn.estoque;

import java.io.Serializable;

import idw.model.rn.folhainspecaorap.QqFolhaInsRapDTO;

public class LocalEstoqueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cdEstoque;
	private Boolean isInspecionar = true;
	private String status;
	private String title;
	
	private String cdLocalOrigem; // usado pelo app mobile para armazenar o local de origem
	private String cdLocalDestino; // usado pelo app mobile para armazenar o local de destino
	private String login; // usado pelo app mobile para armazenar o login do operador que realizou a movimentacao da ferrameenta
	private String cdRap; // usado pelo app mobile para armazenar o cb da ferramenta.
	
	// Abaixo atributo da folha de inspecao da ferramenta
	private QqFolhaInsRapDTO folhains;
	
	public String getCdEstoque() {
		return cdEstoque;
	}
	public void setCdEstoque(String cdEstoque) {
		this.cdEstoque = cdEstoque;
	}
	public Boolean getIsInspecionar() {
		return isInspecionar;
	}
	public void setIsInspecionar(Boolean isInspecionar) {
		this.isInspecionar = isInspecionar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public QqFolhaInsRapDTO getFolhains() {
		return folhains;
	}
	public void setFolhains(QqFolhaInsRapDTO folhains) {
		this.folhains = folhains;
	}
	public String getCdLocalOrigem() {
		return cdLocalOrigem;
	}
	public void setCdLocalOrigem(String cdLocalOrigem) {
		this.cdLocalOrigem = cdLocalOrigem;
	}
	public String getCdLocalDestino() {
		return cdLocalDestino;
	}
	public void setCdLocalDestino(String cdLocalDestino) {
		this.cdLocalDestino = cdLocalDestino;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
}

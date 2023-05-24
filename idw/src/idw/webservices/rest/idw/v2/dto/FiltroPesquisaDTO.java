package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtropesquisa")
public class FiltroPesquisaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String conteudoPesquisa = "";
	private int pagina = 1;
	private int registrosPorPagina = 10; 
	
	public String getConteudoPesquisa() {
		return conteudoPesquisa;
	}
	public void setConteudoPesquisa(String conteudoPesquisa) {
		this.conteudoPesquisa = conteudoPesquisa;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getRegistrosPorPagina() {
		return registrosPorPagina;
	}
	public void setRegistrosPorPagina(int registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}
	
	
}

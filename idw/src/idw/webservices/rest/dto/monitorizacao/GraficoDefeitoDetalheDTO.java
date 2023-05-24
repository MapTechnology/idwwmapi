package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoDefeitoDetalhe")
public class GraficoDefeitoDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cdDefeito;
	private String areaResponsavel;
	private String defeito;
	private String quantidade;
	private String indice;
	private String cor;
	
	public String getCdDefeito() {
		return cdDefeito;
	}
	public void setCdDefeito(String cdDefeito) {
		this.cdDefeito = cdDefeito;
	}
	public String getAreaResponsavel() {
		return areaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		this.areaResponsavel = areaResponsavel;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
	
	
}

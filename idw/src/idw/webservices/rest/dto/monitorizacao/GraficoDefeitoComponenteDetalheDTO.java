package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoDefeitoComponenteDetalhe")
public class GraficoDefeitoComponenteDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cdComponente;
	private String dsPosicaoMecanica;
	private String cdComponenteView;
	private String quantidade;
	private String indice;
	private String cor;
	
	public String getCdComponente() {
		return cdComponente;
	}
	public void setCdComponente(String cdComponente) {
		this.cdComponente = cdComponente;
	}
	public String getDsPosicaoMecanica() {
		return dsPosicaoMecanica;
	}
	public void setDsPosicaoMecanica(String dsPosicaoMecanica) {
		this.dsPosicaoMecanica = dsPosicaoMecanica;
	}
	public String getCdComponenteView() {
		return cdComponenteView;
	}
	public void setCdComponenteView(String cdComponenteView) {
		this.cdComponenteView = cdComponenteView;
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

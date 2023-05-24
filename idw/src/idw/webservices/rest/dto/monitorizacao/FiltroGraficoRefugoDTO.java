package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroGraficoRefugo")
public class FiltroGraficoRefugoDTO extends FiltroDetalhePostoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String quantidadeRefugada;

	public String getQuantidadeRefugada() {
		return quantidadeRefugada;
	}

	public void setQuantidadeRefugada(String quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}
	
}

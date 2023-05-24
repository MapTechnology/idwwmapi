package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoParadaDetalhe")
public class GraficoParadaDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdParada;
	private String dsParada;
	private String tempoParada;
	private String indiceParada;
	private String indiceParadaCor;
	
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	public String getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(String tempoParada) {
		this.tempoParada = tempoParada;
	}
	public String getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}
	public String getIndiceParadaCor() {
		return indiceParadaCor;
	}
	public void setIndiceParadaCor(String indiceParadaCor) {
		this.indiceParadaCor = indiceParadaCor;
	}
	
	
}

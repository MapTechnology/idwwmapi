package ms.coleta.dto;

import java.io.Serializable;

public class ParadaColetaComAndonDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String cdparada;
	String dsparada;
	Double tempoparada;
	
	public String getCdparada() {
		return cdparada;
	}
	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}
	public String getDsparada() {
		return dsparada;
	}
	public void setDsparada(String dsparada) {
		this.dsparada = dsparada;
	}
	public Double getTempoparada() {
		return tempoparada;
	}
	public void setTempoparada(Double tempoparada) {
		this.tempoparada = tempoparada;
	}

}

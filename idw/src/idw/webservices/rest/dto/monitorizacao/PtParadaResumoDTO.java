package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptParadaResumo")
public class PtParadaResumoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String indiceParada;
	private String tempoParada;
	private String ultimaParada;
	private String tempoUltimaParada;
	private String dataInicio;
	private String horaInicio;
	private String AreaResponsavel;
	private String mtbf;
	private String mttr;
	
	public String getIndiceParada() {
		return indiceParada;
	}
	public void setIndiceParada(String indiceParada) {
		this.indiceParada = indiceParada;
	}
	public String getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(String tempoParada) {
		this.tempoParada = tempoParada;
	}
	public String getUltimaParada() {
		return ultimaParada;
	}
	public void setUltimaParada(String ultimaParada) {
		this.ultimaParada = ultimaParada;
	}
	public String getTempoUltimaParada() {
		return tempoUltimaParada;
	}
	public void setTempoUltimaParada(String tempoUltimaParada) {
		this.tempoUltimaParada = tempoUltimaParada;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getAreaResponsavel() {
		return AreaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		AreaResponsavel = areaResponsavel;
	}
	public String getMtbf() {
		return mtbf;
	}
	public void setMtbf(String mtbf) {
		this.mtbf = mtbf;
	}
	public String getMttr() {
		return mttr;
	}
	public void setMttr(String mttr) {
		this.mttr = mttr;
	}
}

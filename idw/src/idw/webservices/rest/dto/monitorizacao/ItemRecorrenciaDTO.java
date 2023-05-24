package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="itemRecorrencia")
public class ItemRecorrenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dtHrInicio;
	private String dtHrFim;
	private String parada;
	private String tempoParadas;
	private String indice;
	private String indiceCor;
	private String pecas;
	private String pecasKg;
	private String pecasTon;
	private List<ItemRecorrenciaRefugoDTO> refugos;
	private List<ItemRecorrenciaParadaDTO> paradas;
	
	public String getDtHrInicio() {
		return dtHrInicio;
	}
	public void setDtHrInicio(String dtHrInicio) {
		this.dtHrInicio = dtHrInicio;
	}
	public String getDtHrFim() {
		return dtHrFim;
	}
	public void setDtHrFim(String dtHrFim) {
		this.dtHrFim = dtHrFim;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getTempoParadas() {
		return tempoParadas;
	}
	public void setTempoParadas(String tempoParadas) {
		this.tempoParadas = tempoParadas;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getIndiceCor() {
		return indiceCor;
	}
	public void setIndiceCor(String indiceCor) {
		this.indiceCor = indiceCor;
	}
	public String getPecas() {
		return pecas;
	}
	public void setPecas(String pecas) {
		this.pecas = pecas;
	}
	public String getPecasKg() {
		return pecasKg;
	}
	public void setPecasKg(String pecasKg) {
		this.pecasKg = pecasKg;
	}
	public String getPecasTon() {
		return pecasTon;
	}
	public void setPecasTon(String pecasTon) {
		this.pecasTon = pecasTon;
	}
	public List<ItemRecorrenciaRefugoDTO> getRefugos() {
		return refugos;
	}
	public void setRefugos(List<ItemRecorrenciaRefugoDTO> refugos) {
		this.refugos = refugos;
	}
	public List<ItemRecorrenciaParadaDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<ItemRecorrenciaParadaDTO> paradas) {
		this.paradas = paradas;
	}
	
	
	
	
}

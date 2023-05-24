package idw.webservices.rest.dto.monitorizacao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroDetalheParada")
public class FiltroDetalheParadaDTO extends FiltroDetalhePostoDTO {

	private static final long serialVersionUID = 1L;
	
	private boolean mostrarParadaSemPeso;
	private boolean mostrarParadaComPeso;
	private String cdParada;
	private String horasParadas;
	private String perdasParada;
	private String horasTodasParadas;
	private String cdArea;

	public boolean isMostrarParadaSemPeso() {
		return mostrarParadaSemPeso;
	}
	public void setMostrarParadaSemPeso(boolean mostrarParadaSemPeso) {
		this.mostrarParadaSemPeso = mostrarParadaSemPeso;
	}
	public boolean isMostrarParadaComPeso() {
		return mostrarParadaComPeso;
	}
	public void setMostrarParadaComPeso(boolean mostrarParadaComPeso) {
		this.mostrarParadaComPeso = mostrarParadaComPeso;
	}
	public String getCdParada() {
		return cdParada;
	}
	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}
	public String getHorasParadas() {
		return horasParadas;
	}
	public void setHorasParadas(String horasParadas) {
		this.horasParadas = horasParadas;
	}
	public String getPerdasParada() {
		return perdasParada;
	}
	public void setPerdasParada(String perdasParada) {
		this.perdasParada = perdasParada;
	}
	public String getHorasTodasParadas() {
		return horasTodasParadas;
	}
	public void setHorasTodasParadas(String horasTodasParadas) {
		this.horasTodasParadas = horasTodasParadas;
	}
	public String getCdArea() {
		return cdArea;
	}
	public void setCdArea(String cdArea) {
		this.cdArea = cdArea;
	}
	
	
	
	

}

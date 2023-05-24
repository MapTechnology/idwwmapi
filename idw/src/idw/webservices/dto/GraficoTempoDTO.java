package idw.webservices.dto;

import java.util.Date;

public class GraficoTempoDTO {
	
	private Double tempoprodutivas;
	private Double temporitmo;
	private Double tempoacurisoladas;
	private Double temporefugos;
	private Double tempocicloimprodutivos;
	private Double tempoparadas;
	private Double temponaodisponivel;
	private Double tempototal;
	private Date dtReferencia;
	
	
	
	public Double getTempototal() {
		return tempototal;
	}
	public void setTempototal(Double tempototal) {
		this.tempototal = tempototal;
	}
	public Double getTempoprodutivas() {
		return tempoprodutivas;
	}
	public void setTempoprodutivas(Double tempoprodutivas) {
		this.tempoprodutivas = tempoprodutivas;
	}
	public Double getTemporitmo() {
		return temporitmo;
	}
	public void setTemporitmo(Double temporitmo) {
		this.temporitmo = temporitmo;
	}
	public Double getTempoacurisoladas() {
		return tempoacurisoladas;
	}
	public void setTempoacurisoladas(Double tempoacurisoladas) {
		this.tempoacurisoladas = tempoacurisoladas;
	}
	public Double getTemporefugos() {
		return temporefugos;
	}
	public void setTemporefugos(Double temporefugos) {
		this.temporefugos = temporefugos;
	}
	public Double getTempocicloimprodutivos() {
		return tempocicloimprodutivos;
	}
	public void setTempocicloimprodutivos(Double tempocicloimprodutivos) {
		this.tempocicloimprodutivos = tempocicloimprodutivos;
	}
	public Double getTempoparadas() {
		return tempoparadas;
	}
	public void setTempoparadas(Double tempoparadas) {
		this.tempoparadas = tempoparadas;
	}
	public Double getTemponaodisponivel() {
		return temponaodisponivel;
	}
	public void setTemponaodisponivel(Double temponaodisponivel) {
		this.temponaodisponivel = temponaodisponivel;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	
	
	
}

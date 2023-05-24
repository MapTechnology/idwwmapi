package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="analiseTurnoGt")
public class AnaliseTurnoGtDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String gt;
	private PtIndicadorDTO indicadores;
	private FiltroMonitorizacaoDTO filtro;
	
	public String getGt() {
		return gt;
	}
	public void setGt(String gt) {
		this.gt = gt;
	}
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	public FiltroMonitorizacaoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroMonitorizacaoDTO filtro) {
		this.filtro = filtro;
	}
	

}

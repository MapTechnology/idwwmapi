package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="analiseTurnoPosto")
public class AnaliseTurnoPostoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String posto;
	private PtIndicadorDTO indicadores;
	private FiltroDetalhePostoDTO filtro;
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	public FiltroDetalhePostoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroDetalhePostoDTO filtro) {
		this.filtro = filtro;
	}
	
	

}

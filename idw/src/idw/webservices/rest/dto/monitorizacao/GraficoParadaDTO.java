package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoParada")
public class GraficoParadaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<LegendaDataHoraDTO> legendas;
	private List<GraficoParadaDetalheDTO> detalhes;
	private int limiteParadas;
	private int quantidadeTotalParadas;
	
	public List<LegendaDataHoraDTO> getLegendas() {
		return legendas;
	}
	public void setLegendas(List<LegendaDataHoraDTO> legendas) {
		this.legendas = legendas;
	}
	public List<GraficoParadaDetalheDTO> getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(List<GraficoParadaDetalheDTO> detalhes) {
		this.detalhes = detalhes;
	}
	public int getLimiteParadas() {
		return limiteParadas;
	}
	public void setLimiteParadas(int limiteParadas) {
		this.limiteParadas = limiteParadas;
	}
	public int getQuantidadeTotalParadas() {
		return quantidadeTotalParadas;
	}
	public void setQuantidadeTotalParadas(int quantidadeTotalParadas) {
		this.quantidadeTotalParadas = quantidadeTotalParadas;
	}
	
	
	
}

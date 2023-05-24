package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoRefugo")
public class GraficoRefugoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<LegendaDataHoraDTO> legendas;
	private List<GraficoRefugoDetalheDTO> detalhes;
	private String quantidadeRefugadaTotal;
	private MetaIndicadorDTO metaIndicador;
	
	public List<LegendaDataHoraDTO> getLegendas() {
		return legendas;
	}
	public void setLegendas(List<LegendaDataHoraDTO> legendas) {
		this.legendas = legendas;
	}
	public List<GraficoRefugoDetalheDTO> getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(List<GraficoRefugoDetalheDTO> detalhes) {
		this.detalhes = detalhes;
	}
	public MetaIndicadorDTO getMetaIndicador() {
		return metaIndicador;
	}
	public void setMetaIndicador(MetaIndicadorDTO metaIndicador) {
		this.metaIndicador = metaIndicador;
	}
	public String getQuantidadeRefugadaTotal() {
		return quantidadeRefugadaTotal;
	}
	public void setQuantidadeRefugadaTotal(String quantidadeRefugadaTotal) {
		this.quantidadeRefugadaTotal = quantidadeRefugadaTotal;
	}
	
	
}

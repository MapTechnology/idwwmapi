package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficos")
public class GraficosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LegendaMetaDTO legendaMeta;
	private List<MetaIndicadorDTO> metaIndicadores;
	private MetaIndicadorDTO cicloMetaIndicador;
	private List<GraficoProducaoDetalheDTO> producaoDetalhes;
	private List<CicloDetalheDTO> cicloDetalhes;
	private List<GraficoPizzaDTO> paradaAreaResponsavelDetalhes;
	private List<GraficoPizzaDTO> defeitoAreaResponsavelDetalhes;
	private GraficoParadaMTDTO paradaMT;
	
	public LegendaMetaDTO getLegendaMeta() {
		return legendaMeta;
	}
	public void setLegendaMeta(LegendaMetaDTO legendaMeta) {
		this.legendaMeta = legendaMeta;
	}
	public List<MetaIndicadorDTO> getMetaIndicadores() {
		return metaIndicadores;
	}
	public void setMetaIndicadores(List<MetaIndicadorDTO> metaIndicadores) {
		this.metaIndicadores = metaIndicadores;
	}
	public List<GraficoProducaoDetalheDTO> getProducaoDetalhes() {
		return producaoDetalhes;
	}
	public void setProducaoDetalhes(List<GraficoProducaoDetalheDTO> producaoDetalhes) {
		this.producaoDetalhes = producaoDetalhes;
	}
	public List<CicloDetalheDTO> getCicloDetalhes() {
		return cicloDetalhes;
	}
	public void setCicloDetalhes(List<CicloDetalheDTO> cicloDetalhes) {
		this.cicloDetalhes = cicloDetalhes;
	}
	public List<GraficoPizzaDTO> getParadaAreaResponsavelDetalhes() {
		return paradaAreaResponsavelDetalhes;
	}
	public void setParadaAreaResponsavelDetalhes(
			List<GraficoPizzaDTO> paradaAreaResponsavelDetalhes) {
		this.paradaAreaResponsavelDetalhes = paradaAreaResponsavelDetalhes;
	}
	public List<GraficoPizzaDTO> getDefeitoAreaResponsavelDetalhes() {
		return defeitoAreaResponsavelDetalhes;
	}
	public void setDefeitoAreaResponsavelDetalhes(
			List<GraficoPizzaDTO> defeitoAreaResponsavelDetalhes) {
		this.defeitoAreaResponsavelDetalhes = defeitoAreaResponsavelDetalhes;
	}
	public GraficoParadaMTDTO getParadaMT() {
		return paradaMT;
	}
	public void setParadaMT(GraficoParadaMTDTO paradaMT) {
		this.paradaMT = paradaMT;
	}
	public MetaIndicadorDTO getCicloMetaIndicador() {
		return cicloMetaIndicador;
	}
	public void setCicloMetaIndicador(MetaIndicadorDTO cicloMetaIndicador) {
		this.cicloMetaIndicador = cicloMetaIndicador;
	}
	
	
		
	
}

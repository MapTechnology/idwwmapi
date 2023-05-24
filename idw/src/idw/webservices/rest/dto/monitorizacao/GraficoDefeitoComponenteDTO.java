package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoDefeitoComponente")
public class GraficoDefeitoComponenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<LegendaDTO> legenda;
	private List<GraficoDefeitoComponenteDetalheDTO> componentes;
	
	public List<LegendaDTO> getLegenda() {
		return legenda;
	}
	public void setLegenda(List<LegendaDTO> legenda) {
		this.legenda = legenda;
	}
	public List<GraficoDefeitoComponenteDetalheDTO> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<GraficoDefeitoComponenteDetalheDTO> componentes) {
		this.componentes = componentes;
	}
	
	
}

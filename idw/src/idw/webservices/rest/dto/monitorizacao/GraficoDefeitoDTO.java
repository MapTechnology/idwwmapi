package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoDefeito")
public class GraficoDefeitoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<LegendaDTO> legenda;
	private List<GraficoDefeitoDetalheDTO> defeitos;
	
	public List<LegendaDTO> getLegenda() {
		return legenda;
	}
	public void setLegenda(List<LegendaDTO> legenda) {
		this.legenda = legenda;
	}
	public List<GraficoDefeitoDetalheDTO> getDefeitos() {
		return defeitos;
	}
	public void setDefeitos(List<GraficoDefeitoDetalheDTO> defeitos) {
		this.defeitos = defeitos;
	}
	
	
}

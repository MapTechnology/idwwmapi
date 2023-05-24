package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="detalheOcorrencias")
public class DetalheOcorrenciasDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String tempoTotalParadaView;
	private List<TabelaParadaHoraDTO> paradas;
	
	public String getTempoTotalParadaView() {
		return tempoTotalParadaView;
	}
	public void setTempoTotalParadaView(String tempoTotalParadaView) {
		this.tempoTotalParadaView = tempoTotalParadaView;
	}
	public List<TabelaParadaHoraDTO> getParadas() {
		return paradas;
	}
	public void setParadas(List<TabelaParadaHoraDTO> paradas) {
		this.paradas = paradas;
	}
	
	
}

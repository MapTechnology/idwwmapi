package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="legendaDataHora")
public class LegendaDataHoraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dataHoraInicio;
	private String dataHoraFim;
	private String legendaCor;
	
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public String getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public String getLegendaCor() {
		return legendaCor;
	}
	public void setLegendaCor(String legendaCor) {
		this.legendaCor = legendaCor;
	}	
	
}

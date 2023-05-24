package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoIndicadores")
public class GraficoIndicadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String data;
	private PtIndicadorDTO indicadores = new PtIndicadorDTO();
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	
	

}

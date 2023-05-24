package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="turnoIndicador")
public class TurnoIndicadorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String dsTurno;
	private PtIndicadorDTO indicadores;
	
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public PtIndicadorDTO getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(PtIndicadorDTO indicadores) {
		this.indicadores = indicadores;
	}
	
	
}

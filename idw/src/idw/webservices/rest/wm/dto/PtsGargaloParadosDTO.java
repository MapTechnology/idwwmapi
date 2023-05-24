package idw.webservices.rest.wm.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptsGargaloParados")
public class PtsGargaloParadosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PtGargaloParadoDTO> pts;

	public List<PtGargaloParadoDTO> getPts() {
		return pts;
	}
	public void setPts(List<PtGargaloParadoDTO> pts) {
		this.pts = pts;
	}
	
}

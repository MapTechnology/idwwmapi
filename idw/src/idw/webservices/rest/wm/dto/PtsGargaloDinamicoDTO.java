package idw.webservices.rest.wm.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptsGargaloDinamico")
public class PtsGargaloDinamicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PtGargaloDinamicoDTO> pts;

	public List<PtGargaloDinamicoDTO> getPts() {
		return pts;
	}
	public void setPts(List<PtGargaloDinamicoDTO> pts) {
		this.pts = pts;
	}
	
}

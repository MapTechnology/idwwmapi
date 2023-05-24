package idw.webservices.rest.wm.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptsGargaloDinamico")
public class PtsGargaloDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PtGargaloDTO> pts;

	public List<PtGargaloDTO> getPts() {
		return pts;
	}
	public void setPts(List<PtGargaloDTO> pts) {
		this.pts = pts;
	}
	
}

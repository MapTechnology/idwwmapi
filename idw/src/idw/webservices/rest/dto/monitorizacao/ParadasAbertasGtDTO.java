package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="paradasAbertasGt")
public class ParadasAbertasGtDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<GtParadaDTO> gts;

	public List<GtParadaDTO> getGts() {
		return gts;
	}

	public void setGts(List<GtParadaDTO> gts) {
		this.gts = gts;
	}
	
}

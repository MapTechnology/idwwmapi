package idw.webservices.rest.dto.monitorizacao.injet;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroTempoRealMaquinaSulbrasDTO")
public class FiltroTempoRealMaquinaSulbrasDTO  implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String idIHM;
	private String cdPt;
	
	public String getIdIHM() {
		return idIHM;
	}
	public void setIdIHM(String idIHM) {
		this.idIHM = idIHM;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	
}

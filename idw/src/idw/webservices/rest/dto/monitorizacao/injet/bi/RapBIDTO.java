package idw.webservices.rest.dto.monitorizacao.injet.bi;

import java.io.Serializable;

public class RapBIDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idRap;
	private String cdRap;
	private String cdRapView;
	private String dsRap;
	
	public long getIdRap() {
		return idRap;
	}
	public void setIdRap(long idRap) {
		this.idRap = idRap;
	}
	public String getCdRap() {
		return cdRap;
	}
	public void setCdRap(String cdRap) {
		this.cdRap = cdRap;
	}
	public String getCdRapView() {
		return cdRapView;
	}
	public void setCdRapView(String cdRapView) {
		this.cdRapView = cdRapView;
	}
	public String getDsRap() {
		return dsRap;
	}
	public void setDsRap(String dsRap) {
		this.dsRap = dsRap;
	}
	
	
}

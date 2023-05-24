package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroPtCp")
public class FiltroPtCpDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long idPt;
	private long idCp;
	private String cdCp;
	
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	public long getIdCp() {
		return idCp;
	}
	public void setIdCp(long idCp) {
		this.idCp = idCp;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	
	

}

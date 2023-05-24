package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gt")
public class GtDTO2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idGt;
	private String cdGt;
	private String dsGt; 
	private String cdUsrRev;
	private Integer stRegistro;
	private List<GtLayoutDTO> layout;
	
	public Long getIdGt() {
		return idGt;
	}
	public void setIdGt(Long idGt) {
		this.idGt = idGt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	public List<GtLayoutDTO> getLayout() {
		return layout;
	}
	public void setLayout(List<GtLayoutDTO> layout) {
		this.layout = layout;
	}
	
}

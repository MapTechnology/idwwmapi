package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cargo")
public class CargoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idCargo;
	private String cdCargo;
	private String dsCargo; 
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	public String getCdCargo() {
		return cdCargo;
	}
	public void setCdCargo(String cdCargo) {
		this.cdCargo = cdCargo;
	}
	public String getDsCargo() {
		return dsCargo;
	}
	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
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
	
	
	
}

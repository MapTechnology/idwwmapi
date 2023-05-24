package idw.webservices.rest.conecthusstencil;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="filtroByCdMaqIdTurnoDataDTO")
public class FiltroByCdMaqIdTurnoDataDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private String cdMaquina; //codigo pt
	private String idTurno; //id interna idw do turno
	private String data; // data no formato dd/mm/yyyy

	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public String getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

	
}

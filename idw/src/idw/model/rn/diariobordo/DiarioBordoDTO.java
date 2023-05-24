package idw.model.rn.diariobordo;

import java.io.Serializable;
import java.util.Date;

public class DiarioBordoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idObs;
	private Date dthrObs;
	private String obs;
	private String usuario;
	private String ns;
	private String posto;
	private Long idPosto;
	
	
	public Long getIdObs() {
		return idObs;
	}
	public void setIdObs(Long idObs) {
		this.idObs = idObs;
	}
	public Date getDthrObs() {
		return dthrObs;
	}
	public void setDthrObs(Date dthrObs) {
		this.dthrObs = dthrObs;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public Long getIdPosto() {
		return idPosto;
	}
	public void setIdPosto(Long idPosto) {
		this.idPosto = idPosto;
	}

	
	
}

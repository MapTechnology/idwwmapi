package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsAlertaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idAlerta;
	private String cdAlerta = "";
	private String dsAlerta;
	private Integer idRevisao;
	private Integer stAlerta;
	private Date dtHrIniAlerta;
	private double msDtHrIniAlerta;
	private Integer tpAlerta;
	private double tempolimite;
	
	public double getmsDtHrIniAlerta() {
		return msDtHrIniAlerta;
	}	

	public void setmsDtHrIniAlerta(double msDtHrIniAlerta) {
		this.msDtHrIniAlerta = msDtHrIniAlerta;
	}
	
	public String getCdAlerta() {
		return cdAlerta;
	}

	public void setCdAlerta(String cdAlerta) {
		this.cdAlerta = cdAlerta;
	}

	public String getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(String idAlerta) {
		this.idAlerta = idAlerta;
	}

	public Integer getIdRevisao() {
		return idRevisao;
	}

	public void setIdRevisao(Integer idRevisao) {
		this.idRevisao = idRevisao;
	}

	public Integer getStAlerta() {
		return stAlerta;
	}

	public void setStAlerta(Integer stAlerta) {
		this.stAlerta = stAlerta;
	}

	/**
	 * @return the dsAlerta
	 */
	public String getDsAlerta() {
		return dsAlerta;
	}

	/**
	 * @param dsAlerta the dsAlerta to set
	 */
	public void setDsAlerta(String dsAlerta) {
		this.dsAlerta = dsAlerta;
	}
	
	/**
	 * @return the dtHrIniAlerta
	 */
	public Date getdthrinialerta() {
		return dtHrIniAlerta;
	}
	/**
	 * @param dthrinialerta the dtHrIniAlerta to set
	 */
	public void setdthrinialerta(Date dtHrIniAlerta) {
		this.dtHrIniAlerta = dtHrIniAlerta;
	}
	//vlauria 20100322
	public void setTpAlerta(Integer tpAlerta) {
		this.tpAlerta = tpAlerta;
	}

	public Integer getTpAlerta() {
		return tpAlerta;
	}

	public double getTempolimite() {
		return tempolimite;
	}

	public void setTempolimite(double tempolimite) {
		this.tempolimite = tempolimite;
	}

}

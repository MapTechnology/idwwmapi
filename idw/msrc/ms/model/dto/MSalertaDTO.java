package ms.model.dto;

import injetws.model.pojos.PrUpAlertasEmAberto;
import injetws.webservices.dto.IwsAlertaDTO;

import java.util.Date;

public class MSalertaDTO {
	
	private String idAlerta;
	private String cdAlerta = "";
	private String dsAlerta;
	private Integer idRevisao;
	private Integer stAlerta;
	private Date dtHrIniAlerta;
	private double msDtHrIniAlerta;
	private Integer tpAlerta;
	
	public MSalertaDTO() {}
	
	public MSalertaDTO(PrUpAlertasEmAberto alertasEmAberto){
		this.idAlerta = alertasEmAberto.getIdalertaaberto();
		this.cdAlerta = alertasEmAberto.getCdalerta();
		this.dtHrIniAlerta = alertasEmAberto.getDthrinialerta();
		this.msDtHrIniAlerta = alertasEmAberto.getMsdthrinialerta();
	    this.tpAlerta = alertasEmAberto.getTpalerta();
	    
	    
	}
	
	public MSalertaDTO(IwsAlertaDTO alerta) {
		this.idAlerta = alerta.getIdAlerta();
		this.cdAlerta = alerta.getCdAlerta();
		this.dsAlerta = alerta.getDsAlerta();
		this.idRevisao = alerta.getIdRevisao();
		this.stAlerta = alerta.getStAlerta();
		this.dtHrIniAlerta = alerta.getdthrinialerta();
		this.msDtHrIniAlerta = alerta.getmsDtHrIniAlerta();
		this.tpAlerta = alerta.getTpAlerta();
	}
	
	public MSalertaDTO(MSalertaDTO alerta) {
		this.idAlerta = alerta.getIdAlerta();
		this.cdAlerta = alerta.getCdAlerta();
		this.dsAlerta = alerta.getDsAlerta();
		this.idRevisao = alerta.getIdRevisao();
		this.stAlerta = alerta.getStAlerta();
		this.dtHrIniAlerta = alerta.getdthrinialerta();
		this.msDtHrIniAlerta = alerta.getmsDtHrIniAlerta();
		this.tpAlerta = alerta.getTpAlerta();
	}
	
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
}

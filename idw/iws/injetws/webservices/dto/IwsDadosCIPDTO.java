package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;


public class IwsDadosCIPDTO implements Serializable{	
	private Date DtHrInicio;
	private Boolean isCIPPendente=false;
	private Boolean isEmCIP=false;
	private String cdmoldeantigo=null;
	
	private static final long serialVersionUID = 1L;
	/**
	 * @return the dtHrInicio
	 */
	public Date getDtHrInicio() {
		return DtHrInicio;
	}
	/**
	 * @param dtHrInicio the dtHrInicio to set
	 */
	public void setDtHrInicio(Date dtHrInicio) {
		DtHrInicio = dtHrInicio;
	}
	/**
	 * @return the isCIPPendente
	 */
	public Boolean getIsCIPPendente() {
		return isCIPPendente;
	}
	/**
	 * @param isCIPPendente the isCIPPendente to set
	 */
	public void setIsCIPPendente(Boolean isCIPPendente) {
		this.isCIPPendente = isCIPPendente;
	}
	/**
	 * @return the isEmCIP
	 */
	public Boolean getIsEmCIP() {
		return isEmCIP;
	}
	/**
	 * @param isEmCIP the isEmCIP to set
	 */
	public void setIsEmCIP(Boolean isEmCIP) {
		this.isEmCIP = isEmCIP;
	}
	public String getCdmoldeantigo() {
		return cdmoldeantigo;
	}
	public void setCdmoldeantigo(String cdmoldeantigo) {
		this.cdmoldeantigo = cdmoldeantigo;
	}
	
	
}

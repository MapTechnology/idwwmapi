package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class IwsInspecaoAutoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2127022386892422312L;
	private String cdgrpparam;
	private String idespecific;
	private BigDecimal ordemedicao;
	
	public String getCdgrpparam() {
		return cdgrpparam;
	}
	public void setCdgrpparam(String cdgrpparam) {
		this.cdgrpparam = cdgrpparam;
	}
	
	public String getIdespecific() {
		return idespecific;
	}
	public void setIdespecific(String idespecific) {
		this.idespecific = idespecific;
	}
	
	public BigDecimal getOrdemedicao() {
		return ordemedicao;
	}
	public void setOrdemedicao(BigDecimal ordemedicao) {
		this.ordemedicao = ordemedicao;
	}

}

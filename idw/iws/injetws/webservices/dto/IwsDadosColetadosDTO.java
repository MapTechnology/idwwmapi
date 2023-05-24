package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsDadosColetadosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6380462649386658311L;
	/**
	 * 
	 */

	private String cdMaquina;
	private double ValorLido;	
	private Date dtHrLeitura;
	private String idCaracteristica;
	private String cdgrpparam;
	
	public String getCdgrpparam() {
		return cdgrpparam;
	}
	public void setCdgrpparam(String cdgrpparam) {
		this.cdgrpparam = cdgrpparam;
	}
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public double getValorLido() {
		return ValorLido;
	}
	public void setValorLido(double valorLido) {
		ValorLido = valorLido;
	}
	public Date getDtHrLeitura() {
		return dtHrLeitura;
	}
	public void setDtHrLeitura(Date dtHrLeitura) {
		this.dtHrLeitura = dtHrLeitura;
	}
	public String getIdCaracteristica() {
		return idCaracteristica;
	}
	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}	
	
}

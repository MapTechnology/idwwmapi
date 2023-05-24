package injetws.webservices.dto;

import injetws.model.pojos.PrUpAndonIndicadores;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class IwsAndonIndicadorDTO implements Serializable {
	private double vlindicadorHora;
	private double vlindicadorTurno;
	private BigDecimal idindicador;	
	
	public double getVlindicadorHora() {
		return vlindicadorHora;
	}
	public void setVlindicadorHora(double vlindicadorHora) {
		this.vlindicadorHora = vlindicadorHora;
	}
	public double getVlindicadorTurno() {
		return vlindicadorTurno;
	}
	public void setVlindicadorTurno(double vlindicadorTurno) {
		this.vlindicadorTurno = vlindicadorTurno;
	}
	public BigDecimal getIdindicador() {
		return idindicador;
	}
	public void setIdindicador(BigDecimal idindicador) {
		this.idindicador = idindicador;
	}	
	
	public void setIwsAndonIndicadoresDTO(PrUpAndonIndicadores ovar){
		if(ovar.getId().getPeriodo().intValue()==(1))
			this.vlindicadorHora=ovar.getVlindicador();
		else
			this.vlindicadorTurno=ovar.getVlindicador();
		this.idindicador=ovar.getId().getIdindicador();		
	}

}

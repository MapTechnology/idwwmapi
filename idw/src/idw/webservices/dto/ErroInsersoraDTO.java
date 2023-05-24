package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ErroInsersoraDTO  implements Serializable{
	//Todas as informações da máquina referente a um erro
	
	private String feeder = "";
	private String componente = "";
	private String estagio = "";
	private String tipoErro = "";
	private String nozzle = "";
	private String nozzlePosition = "";
	private String feederLado = "";
	private String cabeca = "";
	private String qtErro;
	private String depara = "";
	
	
	public String getDepara() {
		return depara;
	}
	public void setDepara(String depara) {
		this.depara = depara;
	}
	public String getFeeder() {
		return feeder;
	}
	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public String getTipoErro() {
		return tipoErro;
	}
	public void setTipoErro(String tipoErro) {
		this.tipoErro = tipoErro;
	}
	public String getNozzle() {
		return nozzle;
	}
	public void setNozzle(String nozzle) {
		this.nozzle = nozzle;
	}
	public String getNozzlePosition() {
		return nozzlePosition;
	}
	public void setNozzlePosition(String nozzlePosition) {
		this.nozzlePosition = nozzlePosition;
	}
	public String getFeederLado() {
		
		return feederLado;
	}
	public void setFeederLado(String feederLado) {
		this.feederLado = feederLado;
	}
	public String getCabeca() {
		return cabeca;
	}
	public void setCabeca(String cabeca) {
		this.cabeca = cabeca;
	}
	public String getQtErro() {
		return qtErro;
	}
	public void setQtErro(String qtErro) {
		this.qtErro = qtErro;
	}
}

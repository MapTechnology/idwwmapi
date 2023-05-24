package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfiguracaoCheckFeederDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8140454421493827634L;
	private String mascara;
	private boolean isNivel;
	private String mascaraComponente;
	
	public String getMascara() {
		return mascara;
	}
	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	public boolean isNivel() {
		return isNivel;
	}
	public void setNivel(boolean isNivel) {
		this.isNivel = isNivel;
	}
	public String getMascaraComponente() {
		return mascaraComponente;
	}
	public void setMascaraComponente(String mascaraComponente) {
		this.mascaraComponente = mascaraComponente;
	}
}

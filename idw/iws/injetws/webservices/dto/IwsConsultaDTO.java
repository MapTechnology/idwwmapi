package injetws.webservices.dto;

import java.io.Serializable;

public class IwsConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String campoRSP1 = "";
	private String campoRSP2 = "";
	private String campoRSP3 = "";
	private String campoRSP4 = "";
	private String campoRSP5 = "";
	private String campoRSP6 = "";
	private String campoRSP7 = "";
	private String campoRSP8 = "";
	private boolean isResposta = false;

	public String getCampoRSP1() {
		return campoRSP1;
	}

	public void setCampoRSP1(String Campo1) {
		this.campoRSP1 = Campo1;
	}
	
	public void setCampoRSP2(String Campo2) {
		this.campoRSP2 = Campo2;
	}
	public String getCampoRSP2() {
		return campoRSP2;
	}

	public void setCampoRSP3(String Campo3) {
		this.campoRSP3 = Campo3;
	}
	public String getCampoRSP3() {
		return campoRSP3;
	}

	public void setCampoRSP4(String Campo4) {
		this.campoRSP4 = Campo4;
	}
	public String getCampoRSP4() {
		return campoRSP4;
	}

	public void setCampoRSP5(String Campo5) {
		this.campoRSP5 = Campo5;
	}
	public String getCampoRSP5() {
		return campoRSP5;
	}

	public void setCampoRSP6(String Campo6) {
		this.campoRSP6 = Campo6;
	}
	public String getCampoRSP6() {
		return campoRSP6;
	}

	public void setCampoRSP7(String Campo7) {
		this.campoRSP7 = Campo7;
	}
	public String getCampoRSP7() {
		return campoRSP7;
	}

	public void setCampoRSP8(String Campo8) {
		this.campoRSP8 = Campo8;
	}
	public String getCampoRSP8() {
		return campoRSP8;
	}

	public boolean getResposta() {
		return isResposta;
	}
	public void setResposta(boolean Resposta) {
		this.isResposta = Resposta;
	}
	

}

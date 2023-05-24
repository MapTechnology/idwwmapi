package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParadaInsersoraDTO implements Serializable{
	private String codigoParada = "";
	private String descricaoParada;
	private String subCodigoParada;
	public String getCodigoParada() {
		return codigoParada;
	}

	public void setCodigoParada(String codigoParada) {
		this.codigoParada = codigoParada;
	}

	public String getDescricaoParada() {
		return descricaoParada;
	}

	public void setDescricaoParada(String descricaoParada) {
		this.descricaoParada = descricaoParada;
	}

	public String getSubCodigoParada() {
		return subCodigoParada;
	}

	public void setSubCodigoParada(String subCodigoParada) {
		this.subCodigoParada = subCodigoParada;
	}
}

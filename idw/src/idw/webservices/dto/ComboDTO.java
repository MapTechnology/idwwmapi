package idw.webservices.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ComboDTO implements Serializable {

	private byte valor;
	private String descricao;
	
	public byte getValor() {
		return valor;
	}
	public void setValor(byte valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

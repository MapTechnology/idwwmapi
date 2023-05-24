package idw.model.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TipoAlgoritmoBalanceamentoDTO implements Serializable {
		
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

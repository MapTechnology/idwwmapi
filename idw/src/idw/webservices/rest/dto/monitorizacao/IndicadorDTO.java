package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="indicador")
public class IndicadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chave;
	private String valor;
	private String valorCor;
	
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getValorCor() {
		return valorCor;
	}
	public void setValorCor(String valorCor) {
		this.valorCor = valorCor;
	}
	
	
}

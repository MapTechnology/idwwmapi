package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="chaveValor")
public class ChaveValorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chave;
	private String valor;
	
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
	
	

}

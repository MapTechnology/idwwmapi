package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoCepValores")
public class GraficoCepValoresDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	private String valor;
	private String valorMonetario;
	private String parametro;
	private String meta;
	private String limInf;
	private String limSup;

	
	
	public String getLimInf() {
		return limInf;
	}
	public void setLimInf(String limInf) {
		this.limInf = limInf;
	}
	public String getLimSup() {
		return limSup;
	}
	public void setLimSup(String limSup) {
		this.limSup = limSup;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getValorMonetario() {
		return valorMonetario;
	}
	public void setValorMonetario(String valorMonetario) {
		this.valorMonetario = valorMonetario;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	
	
}

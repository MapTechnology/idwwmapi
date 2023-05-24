package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoCepProcesso")
public class GraficoCepProcessoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	private String valor;
	private String dataLeitura;
	private String cor;
	private String meta;
	private String limInf;
	private String limSup;	
	
	
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
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
	public String getDataLeitura() {
		return dataLeitura;
	}
	public void setDataLeitura(String dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}

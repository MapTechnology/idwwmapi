package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="legenda")
public class LegendaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cor;
	private String label;
	
	public LegendaDTO() {

	}
	
	public LegendaDTO(String cor, String label) {
		super();
		this.cor = cor;
		this.label = label;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	
}

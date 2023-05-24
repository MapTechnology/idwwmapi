package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="legendaMeta")
public class LegendaMetaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String metaHora;
	private String cavidadesAtivas;
	private String lse;
	private String meta;
	private String lie;
	
	public String getMetaHora() {
		return metaHora;
	}
	public void setMetaHora(String metaHora) {
		this.metaHora = metaHora;
	}
	public String getCavidadesAtivas() {
		return cavidadesAtivas;
	}
	public void setCavidadesAtivas(String cavidadesAtivas) {
		this.cavidadesAtivas = cavidadesAtivas;
	}
	public String getLse() {
		return lse;
	}
	public void setLse(String lse) {
		this.lse = lse;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getLie() {
		return lie;
	}
	public void setLie(String lie) {
		this.lie = lie;
	}
	
	
	
}

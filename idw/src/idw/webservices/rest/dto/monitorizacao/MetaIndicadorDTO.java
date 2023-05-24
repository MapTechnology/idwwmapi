package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metaIndicador")
public class MetaIndicadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cdIndicador;
	private String dsIndicador;

	private String valorLegendaSuperior;
	private String valorLegendaMeta;
	private String valorLegendaInferior;
	
	private String corLegendaSuperior;
	private String corLegendaMeta;
	private String corLegendaInferior;
	
	private boolean isMelhorAcimaMeta;

	public String getCdIndicador() {
		return cdIndicador;
	}

	public void setCdIndicador(String cdIndicador) {
		this.cdIndicador = cdIndicador;
	}

	public String getDsIndicador() {
		return dsIndicador;
	}

	public void setDsIndicador(String dsIndicador) {
		this.dsIndicador = dsIndicador;
	}

	public String getValorLegendaSuperior() {
		return valorLegendaSuperior;
	}

	public void setValorLegendaSuperior(String valorLegendaSuperior) {
		this.valorLegendaSuperior = valorLegendaSuperior;
	}

	public String getValorLegendaMeta() {
		return valorLegendaMeta;
	}

	public void setValorLegendaMeta(String valorLegendaMeta) {
		this.valorLegendaMeta = valorLegendaMeta;
	}

	public String getValorLegendaInferior() {
		return valorLegendaInferior;
	}

	public void setValorLegendaInferior(String valorLegendaInferior) {
		this.valorLegendaInferior = valorLegendaInferior;
	}

	public String getCorLegendaSuperior() {
		return corLegendaSuperior;
	}

	public void setCorLegendaSuperior(String corLegendaSuperior) {
		this.corLegendaSuperior = corLegendaSuperior;
	}

	public String getCorLegendaMeta() {
		return corLegendaMeta;
	}

	public void setCorLegendaMeta(String corLegendaMeta) {
		this.corLegendaMeta = corLegendaMeta;
	}

	public String getCorLegendaInferior() {
		return corLegendaInferior;
	}

	public void setCorLegendaInferior(String corLegendaInferior) {
		this.corLegendaInferior = corLegendaInferior;
	}

	public boolean isMelhorAcimaMeta() {
		return isMelhorAcimaMeta;
	}

	public void setMelhorAcimaMeta(boolean isMelhorAcimaMeta) {
		this.isMelhorAcimaMeta = isMelhorAcimaMeta;
	}	
	
	
}

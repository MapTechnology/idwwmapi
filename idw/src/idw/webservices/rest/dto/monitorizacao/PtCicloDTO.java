package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ptCiclo")
public class PtCicloDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String eficienciaDeCiclo;
	private String cicloPadrao;
	private String cicloMedio;
	private String ultimoCiclo;
	private String eficienciaUltimoCiclo;
	private String quantidadeCiclosExecutar;
	private String projecaoPCI;
	private String indiceCicloAtualCompleto;
	
	public String getEficienciaDeCiclo() {
		return eficienciaDeCiclo;
	}
	public void setEficienciaDeCiclo(String eficienciaDeCiclo) {
		this.eficienciaDeCiclo = eficienciaDeCiclo;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getCicloMedio() {
		return cicloMedio;
	}
	public void setCicloMedio(String cicloMedio) {
		this.cicloMedio = cicloMedio;
	}
	public String getUltimoCiclo() {
		return ultimoCiclo;
	}
	public void setUltimoCiclo(String ultimoCiclo) {
		this.ultimoCiclo = ultimoCiclo;
	}
	public String getEficienciaUltimoCiclo() {
		return eficienciaUltimoCiclo;
	}
	public void setEficienciaUltimoCiclo(String eficienciaUltimoCiclo) {
		this.eficienciaUltimoCiclo = eficienciaUltimoCiclo;
	}
	public String getQuantidadeCiclosExecutar() {
		return quantidadeCiclosExecutar;
	}
	public void setQuantidadeCiclosExecutar(String quantidadeCiclosExecutar) {
		this.quantidadeCiclosExecutar = quantidadeCiclosExecutar;
	}
	public String getProjecaoPCI() {
		return projecaoPCI;
	}
	public void setProjecaoPCI(String projecaoPCI) {
		this.projecaoPCI = projecaoPCI;
	}
	public String getIndiceCicloAtualCompleto() {
		return indiceCicloAtualCompleto;
	}
	public void setIndiceCicloAtualCompleto(String indiceCicloAtualCompleto) {
		this.indiceCicloAtualCompleto = indiceCicloAtualCompleto;
	}
	
	
}

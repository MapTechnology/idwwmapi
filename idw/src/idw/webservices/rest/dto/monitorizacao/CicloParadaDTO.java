package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cicloParada")
public class CicloParadaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String folha;
	private String inicioCiclo;
	private String finalCiclo;
	private String duracaoCiclo;
	private String duracaoParada;
	private String cicloMontagem;
	private String cicloPadrao;
	private String variacaoRitmo;
	
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
	}
	public String getInicioCiclo() {
		return inicioCiclo;
	}
	public void setInicioCiclo(String inicioCiclo) {
		this.inicioCiclo = inicioCiclo;
	}
	public String getFinalCiclo() {
		return finalCiclo;
	}
	public void setFinalCiclo(String finalCiclo) {
		this.finalCiclo = finalCiclo;
	}
	public String getDuracaoCiclo() {
		return duracaoCiclo;
	}
	public void setDuracaoCiclo(String duracaoCiclo) {
		this.duracaoCiclo = duracaoCiclo;
	}
	public String getDuracaoParada() {
		return duracaoParada;
	}
	public void setDuracaoParada(String duracaoParada) {
		this.duracaoParada = duracaoParada;
	}
	public String getCicloMontagem() {
		return cicloMontagem;
	}
	public void setCicloMontagem(String cicloMontagem) {
		this.cicloMontagem = cicloMontagem;
	}
	public String getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(String cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	public String getVariacaoRitmo() {
		return variacaoRitmo;
	}
	public void setVariacaoRitmo(String variacaoRitmo) {
		this.variacaoRitmo = variacaoRitmo;
	}
	
	
}

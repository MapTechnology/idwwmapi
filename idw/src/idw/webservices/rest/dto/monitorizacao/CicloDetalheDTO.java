package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="graficoCicloDetalhe")
public class CicloDetalheDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private String marcadorDs;
	private String marcadorCor;
	private boolean isMostrarMarcador;
	
	private String duracao;
	private String eficiencia;
	private String cicloPadrao;
	private String cicloMedio;
	private String dataHoraInicio;
	private String dataHoraFim;
	
	private String primeiraOcorrenciaDoDia;
	private String ultimaOcorrenciaDoDia;
	
	private String eficienciaCor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarcadorDs() {
		return marcadorDs;
	}

	public void setMarcadorDs(String marcadorDs) {
		this.marcadorDs = marcadorDs;
	}

	public String getMarcadorCor() {
		return marcadorCor;
	}

	public void setMarcadorCor(String marcadorCor) {
		this.marcadorCor = marcadorCor;
	}

	public boolean isMostrarMarcador() {
		return isMostrarMarcador;
	}

	public void setMostrarMarcador(boolean isMostrarMarcador) {
		this.isMostrarMarcador = isMostrarMarcador;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(String eficiencia) {
		this.eficiencia = eficiencia;
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

	public String getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public String getPrimeiraOcorrenciaDoDia() {
		return primeiraOcorrenciaDoDia;
	}

	public void setPrimeiraOcorrenciaDoDia(String primeiraOcorrenciaDoDia) {
		this.primeiraOcorrenciaDoDia = primeiraOcorrenciaDoDia;
	}

	public String getUltimaOcorrenciaDoDia() {
		return ultimaOcorrenciaDoDia;
	}

	public void setUltimaOcorrenciaDoDia(String ultimaOcorrenciaDoDia) {
		this.ultimaOcorrenciaDoDia = ultimaOcorrenciaDoDia;
	}

	public String getEficienciaCor() {
		return eficienciaCor;
	}

	public void setEficienciaCor(String eficienciaCor) {
		this.eficienciaCor = eficienciaCor;
	}

	
	
	
}

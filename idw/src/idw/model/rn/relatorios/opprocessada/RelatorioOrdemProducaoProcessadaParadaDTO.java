package idw.model.rn.relatorios.opprocessada;

public class RelatorioOrdemProducaoProcessadaParadaDTO {
	private String cdParada;
	private String dsParada;
	private Double tempoParada = 0d;
	private String tempoParadaFormatado;
	private boolean isPesa;

	public String getCdParada() {
		return cdParada;
	}

	public void setCdParada(String cdParada) {
		this.cdParada = cdParada;
	}

	public String getDsParada() {
		return dsParada;
	}

	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}

	public Double getTempoParada() {
		return tempoParada;
	}

	public void setTempoParada(Double tempoParada) {
		this.tempoParada = tempoParada;
	}

	public String getTempoParadaFormatado() {
		return tempoParadaFormatado;
	}

	public void setTempoParadaFormatado(String tempoParadaFormatado) {
		this.tempoParadaFormatado = tempoParadaFormatado;
	}

	public boolean isPesa() {
		return isPesa;
	}

	public void setPesa(boolean isPesa) {
		this.isPesa = isPesa;
	}
}


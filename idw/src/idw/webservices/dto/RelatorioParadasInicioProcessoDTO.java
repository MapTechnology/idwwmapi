package idw.webservices.dto;


public class RelatorioParadasInicioProcessoDTO {

	private String maquina;
	private String moldeSaida;
	private String moldeEntrada;
	private String tempoInicioProceso;
	private String parada;
	private String tempoParada;
	private Long idConsol;
	private Double segTempoInicioProcesso;
	private Double segTempoParada;
	
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getMoldeSaida() {
		return moldeSaida;
	}
	public void setMoldeSaida(String moldeSaida) {
		this.moldeSaida = moldeSaida;
	}
	public String getMoldeEntrada() {
		return moldeEntrada;
	}
	public void setMoldeEntrada(String moldeEntrada) {
		this.moldeEntrada = moldeEntrada;
	}
	public String getTempoInicioProceso() {
		return tempoInicioProceso;
	}
	public void setTempoInicioProceso(String tempoInicioProceso) {
		this.tempoInicioProceso = tempoInicioProceso;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(String tempoParada) {
		this.tempoParada = tempoParada;
	}

	public Double getSegTempoParada() {
		return segTempoParada;
	}
	public void setSegTempoParada(Double segTempoParada) {
		this.segTempoParada = segTempoParada;
	}
	public Double getSegTempoInicioProcesso() {
		return segTempoInicioProcesso;
	}
	public void setSegTempoInicioProcesso(Double segTempoInicioProcesso) {
		this.segTempoInicioProcesso = segTempoInicioProcesso;
	}
	public Long getIdConsol() {
		return idConsol;
	}
	public void setIdConsol(Long idConsol) {
		this.idConsol = idConsol;
	}
	
	
}

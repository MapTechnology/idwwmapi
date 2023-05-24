package idw.webservices.dto;

public class RelatorioOcorrenciaParadasDTO {
	
	private String maquina;
	private String parada;	
	private String dthrInicio;
	private String dthrFinal;
	private String causa;
    private String duracao;
    private Integer numeroLinhaRel;
	
    public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getDthrInicio() {
		return dthrInicio;
	}
	public void setDthrInicio(String dthrInicio) {
		this.dthrInicio = dthrInicio;
	}
	public String getDthrFinal() {
		return dthrFinal;
	}
	public void setDthrFinal(String dthrFinal) {
		this.dthrFinal = dthrFinal;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public Integer getNumeroLinhaRel() {
		return numeroLinhaRel;
	}
	public void setNumeroLinhaRel(Integer numeroLinhaRel) {
		this.numeroLinhaRel = numeroLinhaRel;
	}
    
}

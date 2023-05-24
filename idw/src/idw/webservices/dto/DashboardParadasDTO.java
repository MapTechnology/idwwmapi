package idw.webservices.dto;

public class DashboardParadasDTO {
	
	private String cdPt;
	private String parada;
	private String duracao;
	private String duracaoTotal;
	private Boolean isApontaParaGt;
	
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getParada() {
		return parada;
	}
	public void setParada(String parada) {
		this.parada = parada;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getDuracaoTotal() {
		return duracaoTotal;
	}
	public void setDuracaoTotal(String duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}
	public Boolean getIsApontaParaGt() {
		return isApontaParaGt;
	}
	public void setIsApontaParaGt(Boolean isApontaParaGt) {
		this.isApontaParaGt = isApontaParaGt;
	}

}
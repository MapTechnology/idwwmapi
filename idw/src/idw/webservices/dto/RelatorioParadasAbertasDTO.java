package idw.webservices.dto;

import java.math.BigDecimal;

public class RelatorioParadasAbertasDTO {
	
	private BigDecimal pcsProducaoplanejada;
	private BigDecimal gPesoBruto;
	private String maquina;
	private String dsMaquinaCurta;
	private String parada;	
	private String dthrInicio;
	private String areaResp;
    private String duracao;
    private Integer numeroLinhaRel;
	
	public BigDecimal getgPesoBruto() {
		return gPesoBruto;
	}
	public void setgPesoBruto(BigDecimal gPesoBruto) {
		this.gPesoBruto = gPesoBruto;
	}
	public BigDecimal getPcsProducaoplanejada() {
		return pcsProducaoplanejada;
	}
	public void setPcsProducaoplanejada(BigDecimal pcsProducaoplanejada) {
		this.pcsProducaoplanejada = pcsProducaoplanejada;
	}
	public String getDsMaquinaCurta() {
		return dsMaquinaCurta;
	}
	public void setDsMaquinaCurta(String dsMaquinaCurta) {
		this.dsMaquinaCurta = dsMaquinaCurta;
	}
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
	public String getAreaResp() {
		return areaResp;
	}
	public void setAreaResp(String areaResp) {
		this.areaResp = areaResp;
	}
    
}

package idw.webservices.dto;

import java.math.BigDecimal;

public class StatusProdutoSADTO {

	private long idProduto;
	private String cdProduto;
	private BigDecimal qtTotal;
	private BigDecimal qtAtiva;
	private Byte idredzproduto;
	private Long pcsProducaobruta;
	private Long pcsProducaorefugada;
		
	
	public StatusProdutoSADTO() {
	}
	
	public StatusProdutoSADTO(DadosProdutoSADTO obj) {
		setIdProduto(obj.getIdProduto());
		setCdProduto(obj.getCdProduto());
		setQtTotal(obj.getQtTotal());
		setQtAtiva(obj.getQtAtiva());
		setIdredzproduto(obj.getIdredzproduto());
		if(obj.getPcsProducaobruta() != null)
			setPcsProducaobruta(obj.getPcsProducaobruta().longValue());
		else
			setPcsProducaobruta(0l);
		if(obj.getPcsProducaorefugada() != null)
			obj.setPcsProducaorefugada(obj.getPcsProducaorefugada().longValue());
		else
			obj.setPcsProducaorefugada(0l);

	}

	public StatusProdutoSADTO(long idProduto, String cdProduto,
			BigDecimal qtTotal, BigDecimal qtAtiva, Byte idredzproduto,
			Long pcsProducaobruta, Long pcsProducaorefugada) {
		this.idProduto = idProduto;
		this.cdProduto = cdProduto;
		this.qtTotal = qtTotal;
		this.qtAtiva = qtAtiva;
		this.idredzproduto = idredzproduto;
		this.pcsProducaobruta = pcsProducaobruta;
		this.pcsProducaorefugada = pcsProducaorefugada;
	}
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public BigDecimal getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}
	public BigDecimal getQtAtiva() {
		return qtAtiva;
	}
	public void setQtAtiva(BigDecimal qtAtiva) {
		this.qtAtiva = qtAtiva;
	}
	public Byte getIdredzproduto() {
		return idredzproduto;
	}
	public void setIdredzproduto(Byte idredzproduto) {
		this.idredzproduto = idredzproduto;
	}
	public Long getPcsProducaobruta() {
		return pcsProducaobruta;
	}
	public void setPcsProducaobruta(Long pcsProducaobruta) {
		this.pcsProducaobruta = pcsProducaobruta;
	}
	public Long getPcsProducaorefugada() {
		return pcsProducaorefugada;
	}
	public void setPcsProducaorefugada(Long pcsProducaorefugada) {
		this.pcsProducaorefugada = pcsProducaorefugada;
	}
	
}

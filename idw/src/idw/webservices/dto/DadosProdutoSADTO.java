package idw.webservices.dto;

import java.math.BigDecimal;

public class DadosProdutoSADTO {

	private long idProduto;
	private String cdProduto;
	private BigDecimal qtTotal;
	private BigDecimal qtAtiva;
	private Byte idredzproduto;
	private BigDecimal pcsProducaobruta;
	private BigDecimal pcsProducaorefugada;
	private BigDecimal pcsProducaoplanejada;
	
	public DadosProdutoSADTO() {
	}
	
	public DadosProdutoSADTO(DadosProdutoSADTO obj) {
		this.idProduto = obj.idProduto;
		this.cdProduto = new String(obj.cdProduto);
		if(obj.qtTotal != null)
			this.qtTotal = new BigDecimal(obj.qtTotal.doubleValue());
		else
			this.qtTotal = new BigDecimal(0d);
		if(obj.qtAtiva != null)
			this.qtAtiva = new BigDecimal(obj.qtAtiva.doubleValue());
		else
			this.qtAtiva = new BigDecimal(0d);
		if(obj.idredzproduto != null)
			this.idredzproduto = new Byte(obj.idredzproduto);
		else
			this.idredzproduto = new Byte((byte)0);
		if(obj.pcsProducaobruta != null)
			this.pcsProducaobruta = new BigDecimal(obj.pcsProducaobruta.doubleValue());
		else
			this.pcsProducaobruta = new BigDecimal(0d);
		if(obj.pcsProducaorefugada != null)
			this.pcsProducaorefugada = new BigDecimal(obj.pcsProducaorefugada.doubleValue());
		else
			this.pcsProducaorefugada = new BigDecimal(0d);

	}

	public DadosProdutoSADTO(long idProduto, String cdProduto,
			BigDecimal qtTotal, BigDecimal qtAtiva, Byte idredzproduto,
			BigDecimal pcsProducaobruta, BigDecimal pcsProducaorefugada) {
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
	public BigDecimal getPcsProducaobruta() {
		return pcsProducaobruta;
	}
	public void setPcsProducaobruta(BigDecimal pcsProducaobruta) {
		this.pcsProducaobruta = pcsProducaobruta;
	}
	public void setPcsProducaobruta(Long pcsProducaobruta) {
		if(pcsProducaobruta != null)
			this.pcsProducaobruta = new BigDecimal(pcsProducaobruta);
		else
			this.pcsProducaobruta = new BigDecimal(0l);
	}
	public BigDecimal getPcsProducaorefugada() {
		return pcsProducaorefugada;
	}
	public void setPcsProducaorefugada(BigDecimal pcsProducaorefugada) {
		this.pcsProducaorefugada = pcsProducaorefugada;
	}
	public void setPcsProducaorefugada(Long pcsProducaorefugada) {
		if(pcsProducaorefugada != null)
			this.pcsProducaorefugada = new BigDecimal(pcsProducaorefugada);
		else
			this.pcsProducaorefugada = new BigDecimal(0l);
	}

	public BigDecimal getPcsProducaoplanejada() {
		return pcsProducaoplanejada;
	}

	public void setPcsProducaoplanejada(BigDecimal pcsProducaoplanejada) {
		this.pcsProducaoplanejada = pcsProducaoplanejada;
	}
	
}

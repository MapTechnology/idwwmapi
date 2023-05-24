package idw.webservices.dto;

public class RelatorioAlimentacaoDTO {
	private String dthrLeitura;
	private Byte tpAlim;
	private Byte stAlim;
	private Byte tpLeitura;
	private Byte stLeitura;	
	private String dsTpLeitura;
	private String dsStLeitura;
	private String posicao;
	private String cdProdutoPrevisto;
	private String dsProdutoPrevisto;
	private String cdProdutoLido;
	private String dsProdutoLido;
	private String cdUsr;
	private String dsUsr;
	private Integer qtd;

	public String getDthrLeitura() {
		return dthrLeitura;
	}

	public void setDthrLeitura(String dthrLeitura) {
		this.dthrLeitura = dthrLeitura;
	}
	
	public Byte getTpAlim() {
		return tpAlim;
	}

	public void setTpAlim(Byte tpAlim) {
		this.tpAlim = tpAlim;
	}

	public Byte getStAlim() {
		return stAlim;
	}

	public void setStAlim(Byte stAlim) {
		this.stAlim = stAlim;
	}

	public Byte getStLeitura() {
		return stLeitura;
	}

	public void setStLeitura(Byte stLeitura) {
		this.stLeitura = stLeitura;
	}

	public Byte getTpLeitura() {
		return tpLeitura;
	}

	public void setTpLeitura(Byte tpLeitura) {
		this.tpLeitura = tpLeitura;
	}

	public String getDsTpLeitura() {
		return dsTpLeitura;
	}

	public void setDsTpLeitura(String dsTpLeitura) {
		this.dsTpLeitura = dsTpLeitura;
	}

	public String getDsStLeitura() {
		return dsStLeitura;
	}

	public void setDsStLeitura(String dsStLeitura) {
		this.dsStLeitura = dsStLeitura;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getCdProdutoPrevisto() {
		return cdProdutoPrevisto;
	}

	public void setCdProdutoPrevisto(String cdProdutoPrevisto) {
		this.cdProdutoPrevisto = cdProdutoPrevisto;
	}

	public String getDsProdutoPrevisto() {
		return dsProdutoPrevisto;
	}

	public void setDsProdutoPrevisto(String dsProdutoPrevisto) {
		this.dsProdutoPrevisto = dsProdutoPrevisto;
	}

	public String getCdProdutoLido() {
		return cdProdutoLido;
	}

	public void setCdProdutoLido(String cdProdutoLido) {
		this.cdProdutoLido = cdProdutoLido;
	}

	public String getDsProdutoLido() {
		return dsProdutoLido;
	}

	public void setDsProdutoLido(String dsProdutoLido) {
		this.dsProdutoLido = dsProdutoLido;
	}

	public String getCdUsr() {
		return cdUsr;
	}

	public void setCdUsr(String cdUsr) {
		this.cdUsr = cdUsr;
	}

	public String getDsUsr() {
		return dsUsr;
	}

	public void setDsUsr(String dsUsr) {
		this.dsUsr = dsUsr;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

}

package idw.model.rn.integracao.ipackchem.dto;

import java.math.BigDecimal;
import java.util.Date;

public class IntIpackChemApontamentoProducaoDTO 
{

	private Long idRegistro;
	private String nropERP;
	private Integer origemApto;
	private Date dthrEntradaOP;
	private Date dthrSaidaOP;
	private BigDecimal qtdProdBruta;
	private BigDecimal qtdProdRefugada;
	private BigDecimal qtdProdRefEstorno;
	private Integer stRegistro;
	private String obsRegistro;
	private Date dthrRegistro;
	
	public Long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getNropERP() {
		return nropERP;
	}
	public void setNropERP(String nropERP) {
		this.nropERP = nropERP;
	}
	public Integer getOrigemApto() {
		return origemApto;
	}
	public void setOrigemApto(Integer origemApto) {
		this.origemApto = origemApto;
	}
	public Date getDthrEntradaOP() {
		return dthrEntradaOP;
	}
	public void setDthrEntradaOP(Date dthrEntradaOP) {
		this.dthrEntradaOP = dthrEntradaOP;
	}
	public Date getDthrSaidaOP() {
		return dthrSaidaOP;
	}
	public void setDthrSaidaOP(Date dthrSaidaOP) {
		this.dthrSaidaOP = dthrSaidaOP;
	}
	public BigDecimal getQtdProdBruta() {
		return qtdProdBruta;
	}
	public void setQtdProdBruta(BigDecimal qtdProdBruta) {
		this.qtdProdBruta = qtdProdBruta;
	}
	public BigDecimal getQtdProdRefugada() {
		return qtdProdRefugada;
	}
	public void setQtdProdRefugada(BigDecimal qtdProdRefugada) {
		this.qtdProdRefugada = qtdProdRefugada;
	}
	public BigDecimal getQtdProdRefEstorno() {
		return qtdProdRefEstorno;
	}
	public void setQtdProdRefEstorno(BigDecimal qtdProdRefEstorno) {
		this.qtdProdRefEstorno = qtdProdRefEstorno;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	public String getObsRegistro() {
		return obsRegistro;
	}
	public void setObsRegistro(String obsRegistro) {
		this.obsRegistro = obsRegistro;
	}
	public Date getDthrRegistro() {
		return dthrRegistro;
	}
	public void setDthrRegistro(Date dthrRegistro) {
		this.dthrRegistro = dthrRegistro;
	}
	
	
}

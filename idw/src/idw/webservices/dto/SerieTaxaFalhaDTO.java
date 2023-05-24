package idw.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class SerieTaxaFalhaDTO implements Serializable {
	
	private Date inicioIndice;
	private Date fimIndice;
	private BigDecimal producaoBruta;
	private BigDecimal qtdeFalhas;
	private Double indiceFalha;
	private String descricao;
	
	public Date getInicioIndice() {
		return inicioIndice;
	}
	public void setInicioIndice(Date inicioIndice) {
		this.inicioIndice = inicioIndice;
	}
	public Date getFimIndice() {
		return fimIndice;
	}
	public void setFimIndice(Date fimIndice) {
		this.fimIndice = fimIndice;
	}
	public BigDecimal getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(BigDecimal producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public BigDecimal getQtdeFalhas() {
		return qtdeFalhas;
	}
	public void setQtdeFalhas(BigDecimal qtdeFalhas) {
		this.qtdeFalhas = qtdeFalhas;
	}
	public Double getIndiceFalha() {
		return indiceFalha;
	}
	public void setIndiceFalha(Double indiceFalha) {
		this.indiceFalha = indiceFalha;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}

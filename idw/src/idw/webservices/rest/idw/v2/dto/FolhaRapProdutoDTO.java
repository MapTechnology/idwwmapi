package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="folharapproduto")
public class FolhaRapProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cdProduto;
	private String dsProduto;
	private Byte idReduzido;
	private BigDecimal qtTotal;
	private BigDecimal qtAlocada;
	
	public String getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public Byte getIdReduzido() {
		return idReduzido;
	}
	public void setIdReduzido(Byte idReduzido) {
		this.idReduzido = idReduzido;
	}
	public BigDecimal getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}
	public BigDecimal getQtAlocada() {
		return qtAlocada;
	}
	public void setQtAlocada(BigDecimal qtAlocada) {
		this.qtAlocada = qtAlocada;
	}
}

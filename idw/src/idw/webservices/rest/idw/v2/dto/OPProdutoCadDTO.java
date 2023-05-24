package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="opproduto")
public class OPProdutoCadDTO  implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private String cdFerramenta;
	private String cdProduto;
	private String dsProduto;
	private BigDecimal prodPlan;
	private BigDecimal prodPorCiclo;
	
	public String getCdFerramenta() {
		return cdFerramenta;
	}
	public void setCdFerramenta(String cdFerramenta) {
		this.cdFerramenta = cdFerramenta;
	}
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
	public BigDecimal getProdPlan() {
		return prodPlan;
	}
	public void setProdPlan(BigDecimal prodPlan) {
		this.prodPlan = prodPlan;
	}
	public BigDecimal getProdPorCiclo() {
		return prodPorCiclo;
	}
	public void setProdPorCiclo(BigDecimal prodPorCiclo) {
		this.prodPorCiclo = prodPorCiclo;
	}
	
 
}

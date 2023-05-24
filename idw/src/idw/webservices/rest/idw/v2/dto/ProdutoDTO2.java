package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="produto")
public class ProdutoDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idProduto;
	private String cdProduto;
	private String dsProduto;
	private String cdCliente;
	private Integer tpProduto;
	private Double custoUnitario;
	private Double pesoBruto;
	private Double pesoLiquido;
	private String classeABC;
	private String cdUsrRev;
	private Integer stRegistro;
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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
	public String getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(String cdCliente) {
		this.cdCliente = cdCliente;
	}
	public Integer getTpProduto() {
		return tpProduto;
	}
	public void setTpProduto(Integer tpProduto) {
		this.tpProduto = tpProduto;
	}
	public Double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(Double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public Double getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public String getClasseABC() {
		return classeABC;
	}
	public void setClasseABC(String classeABC) {
		this.classeABC = classeABC;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	
}

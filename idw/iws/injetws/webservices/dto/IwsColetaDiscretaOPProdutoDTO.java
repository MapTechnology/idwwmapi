package injetws.webservices.dto;

import java.io.Serializable;

public class IwsColetaDiscretaOPProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idopemaberto;
	private String cdproduto;
	private Character idreduzidaproduto;
	private Double qtplan;
	private double qtprodliqanterior;
	private String siglaumprodliqanterior;
	public String getIdopemaberto() {
		return idopemaberto;
	}
	public void setIdopemaberto(String idopemaberto) {
		this.idopemaberto = idopemaberto;
	}
	public String getCdproduto() {
		return cdproduto;
	}
	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}
	public char getIdreduzidaproduto() {
		return idreduzidaproduto;
	}
	public void setIdreduzidaproduto(char idreduzidaproduto) {
		this.idreduzidaproduto = idreduzidaproduto;
	}
	public Double getQtplan() {
		return qtplan;
	}
	public void setQtplan(Double qtplan) {
		this.qtplan = qtplan;
	}
	public double getQtprodliqanterior() {
		return qtprodliqanterior;
	}
	public void setQtprodliqanterior(double qtprodliqanterior) {
		this.qtprodliqanterior = qtprodliqanterior;
	}
	public String getSiglaumprodliqanterior() {
		return siglaumprodliqanterior;
	}
	public void setSiglaumprodliqanterior(String siglaumprodliqanterior) {
		this.siglaumprodliqanterior = siglaumprodliqanterior;
	}
	
	/*
	private String IDOPEMABERTO;
	private String CDPRODUTO;
	private char IDREDUZIDAPRODUTO;
	private Double QTPLAN;
	private double QTPRODLIQANTERIOR;
	private String SIGLAUMPRODLIQANTERIOR;
	
	public String getIdopemaberto() {
		return IDOPEMABERTO;
	}
	public void setIdopemaberto(String idopemaberto) {
		this.IDOPEMABERTO = idopemaberto;
	}
	public String getCdproduto() {
		return CDPRODUTO;
	}
	public void setCdproduto(String cdproduto) {
		this.CDPRODUTO = cdproduto;
	}
	public char getIdreduzidaproduto() {
		return IDREDUZIDAPRODUTO;
	}
	public void setIdreduzidaproduto(char idreduzidaproduto) {
		this.IDREDUZIDAPRODUTO = idreduzidaproduto;
	}
	public Double getQtplan() {
		return this.QTPLAN;
	}
	public void setQtplan(Double qtplan) {
		this.QTPLAN = qtplan;
	}
	public double getQtprodliqanterior() {
		return QTPRODLIQANTERIOR;
	}
	public void setQtprodliqanterior(double qtprodliqanterior) {
		this.QTPRODLIQANTERIOR = qtprodliqanterior;
	}
	public String getSiglaumprodliqanterior() {
		return SIGLAUMPRODLIQANTERIOR;
	}
	public void setSiglaumprodliqanterior(String siglaumprodliqanterior) {
		this.SIGLAUMPRODLIQANTERIOR = siglaumprodliqanterior;
	}
	
	*/
	
}

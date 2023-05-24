package idw.webservices.rest.mfv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="mfvA3Main")
public class A3MainDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
//big_decimal, string, string, timestamp, timestamp, string, big_decimal, big_decimal, big_decimal, string, timestamp, timestamp, string

	private BigDecimal idA3;//id_a3
	private String cdA3;//cd_a3
	private String dsA3;//ds_a3

	private Date dtIa3;//dt_ia3
	private Date dtFa3;//dt_fa3
	private String mainCdproduto;//maincd_produto

	private BigDecimal cachep3Ciclosbarraidgt;//cachep3_ciclosbarra_idgt
	private BigDecimal cachep3Pradaspizzaidgt;//cachep3_paradaspizza_idgt
	private BigDecimal cachep3Defeitosbarraidgt;//cachep3_defeitosbarra_idgt
	private String cachep3Paradasbarracdarea;//cachep3_paradasbarra_cdarea
	private Date cachep7Resultdti;//cachep7_result_dti
	private Date cachep7Resultdtf;//cachep7_result_dtf
	private String cdProduto;//cd_produto
	
	
	public A3MainDTO(
			BigDecimal idA3, 
			String cdA3, 
			String dsA3, 
			Date dtIa3, 
			Date dtFa3, 
			String mainCdproduto,
			BigDecimal cachep3Ciclosbarraidgt, 
			BigDecimal cachep3Pradaspizzaidgt, 
			BigDecimal cachep3Defeitosbarraidgt,
			String cachep3Paradasbarracdarea, 
			Date cachep7Resultdti, 
			Date cachep7Resultdtf, 
			String cdProduto) {
		//super();
		this.idA3 = idA3;
		this.cdA3 = cdA3;
		this.dsA3 = dsA3;
		this.dtIa3 = dtIa3;
		this.dtFa3 = dtFa3;
		this.mainCdproduto = mainCdproduto;
		this.cachep3Ciclosbarraidgt = cachep3Ciclosbarraidgt;
		this.cachep3Pradaspizzaidgt = cachep3Pradaspizzaidgt;
		this.cachep3Defeitosbarraidgt = cachep3Defeitosbarraidgt;
		this.cachep3Paradasbarracdarea = cachep3Paradasbarracdarea;
		this.cachep7Resultdti = cachep7Resultdti;
		this.cachep7Resultdtf = cachep7Resultdtf;
		this.cdProduto = cdProduto;
	}


	public BigDecimal getIdA3() {
		return idA3;
	}


	public void setIdA3(BigDecimal idA3) {
		this.idA3 = idA3;
	}


	public String getCdA3() {
		return cdA3;
	}


	public void setCdA3(String cdA3) {
		this.cdA3 = cdA3;
	}


	public String getDsA3() {
		return dsA3;
	}


	public void setDsA3(String dsA3) {
		this.dsA3 = dsA3;
	}


	public Date getDtIa3() {
		return dtIa3;
	}


	public void setDtIa3(Date dtIa3) {
		this.dtIa3 = dtIa3;
	}


	public Date getDtFa3() {
		return dtFa3;
	}


	public void setDtFa3(Date dtFa3) {
		this.dtFa3 = dtFa3;
	}


	public String getMainCdproduto() {
		return mainCdproduto;
	}


	public void setMainCdproduto(String mainCdproduto) {
		this.mainCdproduto = mainCdproduto;
	}


	public BigDecimal getCachep3Ciclosbarraidgt() {
		return cachep3Ciclosbarraidgt;
	}


	public void setCachep3Ciclosbarraidgt(BigDecimal cachep3Ciclosbarraidgt) {
		this.cachep3Ciclosbarraidgt = cachep3Ciclosbarraidgt;
	}


	public BigDecimal getCachep3Pradaspizzaidgt() {
		return cachep3Pradaspizzaidgt;
	}


	public void setCachep3Pradaspizzaidgt(BigDecimal cachep3Pradaspizzaidgt) {
		this.cachep3Pradaspizzaidgt = cachep3Pradaspizzaidgt;
	}


	public BigDecimal getCachep3Defeitosbarraidgt() {
		return cachep3Defeitosbarraidgt;
	}


	public void setCachep3Defeitosbarraidgt(BigDecimal cachep3Defeitosbarraidgt) {
		this.cachep3Defeitosbarraidgt = cachep3Defeitosbarraidgt;
	}


	public String getCachep3Paradasbarracdarea() {
		return cachep3Paradasbarracdarea;
	}


	public void setCachep3Paradasbarracdarea(String cachep3Paradasbarracdarea) {
		this.cachep3Paradasbarracdarea = cachep3Paradasbarracdarea;
	}


	public Date getCachep7Resultdti() {
		return cachep7Resultdti;
	}


	public void setCachep7Resultdti(Date cachep7Resultdti) {
		this.cachep7Resultdti = cachep7Resultdti;
	}


	public Date getCachep7Resultdtf() {
		return cachep7Resultdtf;
	}


	public void setCachep7Resultdtf(Date cachep7Resultdtf) {
		this.cachep7Resultdtf = cachep7Resultdtf;
	}


	public String getCdProduto() {
		return cdProduto;
	}


	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	
	

}

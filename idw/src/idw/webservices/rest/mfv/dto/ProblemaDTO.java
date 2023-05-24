package idw.webservices.rest.mfv.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="mfvProblema")
public class ProblemaDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
//big_decimal, string, string, timestamp, timestamp, string, big_decimal, big_decimal, big_decimal, string, timestamp, timestamp, string

	private BigDecimal idProblema;//id_problema
	private String dsProblema;//ds_problema
	private BigDecimal cachep3Ciclosbarraidgt;//cachep3_ciclosbarra_idgt
	private BigDecimal cachep3Pradaspizzaidgt;//cachep3_paradaspizza_idgt
	private BigDecimal cachep3Defeitosbarraidgt;//cachep3_defeitosbarra_idgt
	private BigDecimal cachep3Paradasbarraidarea;//cachep3_paradasbarra_cdarea
	private Date cachep7Resultdti;//cachep7_result_dti
	private Date cachep7Resultdtf;//cachep7_result_dtf
	
	
	public ProblemaDTO(
			BigDecimal idProblema, 
			String dsProblema, 
			BigDecimal cachep3Ciclosbarraidgt, 
			BigDecimal cachep3Pradaspizzaidgt, 
			BigDecimal cachep3Defeitosbarraidgt,
			BigDecimal cachep3Paradasbarraidarea, 
			Date cachep7Resultdti, 
			Date cachep7Resultdtf) {
		//super();
		this.idProblema = idProblema;
		this.dsProblema = dsProblema;
		this.cachep3Ciclosbarraidgt = cachep3Ciclosbarraidgt;
		this.cachep3Pradaspizzaidgt = cachep3Pradaspizzaidgt;
		this.cachep3Defeitosbarraidgt = cachep3Defeitosbarraidgt;
		this.cachep3Paradasbarraidarea = cachep3Paradasbarraidarea;
		this.cachep7Resultdti = cachep7Resultdti;
		this.cachep7Resultdtf = cachep7Resultdtf;
	}


	public BigDecimal getIdProblema() {
		return idProblema;
	}


	public void setIdProblema(BigDecimal idProblema) {
		this.idProblema = idProblema;
	}



	public String getDsProblema() {
		return dsProblema;
	}


	public void setDsProblema(String dsProblema) {
		this.dsProblema = dsProblema;
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


	public BigDecimal getCachep3Paradasbarraidarea() {
		return cachep3Paradasbarraidarea;
	}

	public void setCachep3Paradasbarraidarea(BigDecimal cachep3Paradasbarraidarea) {
		this.cachep3Paradasbarraidarea = cachep3Paradasbarraidarea;
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


	

}

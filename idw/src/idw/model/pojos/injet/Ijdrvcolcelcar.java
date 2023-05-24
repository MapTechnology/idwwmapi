package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijdrvcolcelcar generated by hbm2java
 */
@Entity
@Table(name = "IJDRVCOLCELCAR")
public class Ijdrvcolcelcar implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8325958762856278923L;
	private double idleituradrv;
	private String idmaquina;
	private String idcaracteristica;
	private double vllido;
	private Date dthrleitura;
	private char stleitura;
	private Date dthrstleitura;
	private BigDecimal cdmotregrecusado;
	private String cdgrpparam;

	public Ijdrvcolcelcar() {
	}	
	
	public Ijdrvcolcelcar(double idleituradrv, String idmaquina,
			String idcaracteristica, double vllido, Date dthrleitura,
			char stleitura, Date dthrstleitura) {
		this.idleituradrv = idleituradrv;
		this.idmaquina = idmaquina;
		this.idcaracteristica = idcaracteristica;
		this.vllido = vllido;
		this.dthrleitura = dthrleitura;
		this.stleitura = stleitura;
		this.dthrstleitura = dthrstleitura;
	}

	public Ijdrvcolcelcar(double idleituradrv, String idmaquina,
			String idcaracteristica, double vllido, Date dthrleitura,
			char stleitura, Date dthrstleitura, BigDecimal cdmotregrecusado,String cdgrpparam) {
		this.idleituradrv = idleituradrv;
		this.idmaquina = idmaquina;
		this.idcaracteristica = idcaracteristica;
		this.vllido = vllido;
		this.dthrleitura = dthrleitura;
		this.stleitura = stleitura;
		this.dthrstleitura = dthrstleitura;
		this.cdmotregrecusado = cdmotregrecusado;
		this.cdgrpparam = cdgrpparam;
	}

	@Id
	@Column(name = "IDLEITURADRV", unique = true, nullable = true, precision = 126, scale = 0)
	public double getIdleituradrv() {
		return this.idleituradrv;
	}

	public void setIdleituradrv(double idleituradrv) {
		this.idleituradrv = idleituradrv;
	}

	@Column(name = "IDMAQUINA", nullable = false, length = 50)
	public String getIdmaquina() {
		return this.idmaquina;
	}

	public void setIdmaquina(String idmaquina) {
		this.idmaquina = idmaquina;
	}

	@Column(name = "IDCARACTERISTICA", nullable = false, length = 50)
	public String getIdcaracteristica() {
		return this.idcaracteristica;
	}

	public void setIdcaracteristica(String idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}

	@Column(name = "VLLIDO", nullable = false, precision = 126, scale = 0)
	public double getVllido() {
		return this.vllido;
	}

	public void setVllido(double vllido) {
		this.vllido = vllido;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRLEITURA", nullable = false, length = 7)
	public Date getDthrleitura() {
		return this.dthrleitura;
	}

	public void setDthrleitura(Date dthrleitura) {
		this.dthrleitura = dthrleitura;
	}

	@Column(name = "STLEITURA", nullable = false, length = 1)
	public char getStleitura() {
		return this.stleitura;
	}

	public void setStleitura(char stleitura) {
		this.stleitura = stleitura;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRSTLEITURA", nullable = false, length = 7)
	public Date getDthrstleitura() {
		return this.dthrstleitura;
	}

	public void setDthrstleitura(Date dthrstleitura) {
		this.dthrstleitura = dthrstleitura;
	}

	@Column(name = "CDMOTREGRECUSADO", precision = 22, scale = 0)
	public BigDecimal getCdmotregrecusado() {
		return this.cdmotregrecusado;
	}

	public void setCdmotregrecusado(BigDecimal cdmotregrecusado) {
		this.cdmotregrecusado = cdmotregrecusado;
	}
	
	@Column(name = "CDGRPPARAM", nullable = true, length = 6)
	public String getCdgrpparam() {
		return this.cdgrpparam;
	}

	public void setCdgrpparam(String cdgrpparam) {
		this.cdgrpparam = cdgrpparam;
	}	

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ijtbusureqtec generated by hbm2java
 */
@Entity
@Table(name = "IJTBUSUREQTEC", uniqueConstraints = @UniqueConstraint(columnNames = "CDUSUARIO"))
public class Ijtbusureqtec implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -748366918061845368L;
	private double idregistro;
	private Ijtbusu ijtbusu;
	private BigDecimal pedetec1;
	private BigDecimal pedetec2;
	private BigDecimal pedetecresp;

	public Ijtbusureqtec() {
	}

	public Ijtbusureqtec(double idregistro, Ijtbusu ijtbusu,
			BigDecimal pedetec1, BigDecimal pedetec2, BigDecimal pedetecresp) {
		this.idregistro = idregistro;
		this.ijtbusu = ijtbusu;
		this.pedetec1 = pedetec1;
		this.pedetec2 = pedetec2;
		this.pedetecresp = pedetecresp;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(double idregistro) {
		this.idregistro = idregistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", unique = true, nullable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Column(name = "PEDETEC1", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPedetec1() {
		return this.pedetec1;
	}

	public void setPedetec1(BigDecimal pedetec1) {
		this.pedetec1 = pedetec1;
	}

	@Column(name = "PEDETEC2", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPedetec2() {
		return this.pedetec2;
	}

	public void setPedetec2(BigDecimal pedetec2) {
		this.pedetec2 = pedetec2;
	}

	@Column(name = "PEDETECRESP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPedetecresp() {
		return this.pedetecresp;
	}

	public void setPedetecresp(BigDecimal pedetecresp) {
		this.pedetecresp = pedetecresp;
	}

}

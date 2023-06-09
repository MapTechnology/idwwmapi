package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ijopstatusapterp generated by hbm2java
 */
@Entity
@Table(name = "IJOPSTATUSAPTERP")
public class Ijopstatusapterp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3094555019506325150L;
	private String nrop;
	private BigDecimal apontaerp;

	public Ijopstatusapterp() {
	}

	public Ijopstatusapterp(String nrop, BigDecimal apontaerp) {
		this.nrop = nrop;
		this.apontaerp = apontaerp;
	}

	@Id
	@Column(name = "NROP", unique = true, nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "APONTAERP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getApontaerp() {
		return this.apontaerp;
	}

	public void setApontaerp(BigDecimal apontaerp) {
		this.apontaerp = apontaerp;
	}

}

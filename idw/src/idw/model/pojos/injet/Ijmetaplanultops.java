package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ijmetaplanultops generated by hbm2java
 */
@Entity
@Table(name = "IJMETAPLANULTOPS")
public class Ijmetaplanultops implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6035812676896145861L;
	private double meta;

	public Ijmetaplanultops() {
	}

	public Ijmetaplanultops(double meta) {
		this.meta = meta;
	}

	@Id
	@Column(name = "META", nullable = false, precision = 126, scale = 0)
	public double getMeta() {
		return this.meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

}
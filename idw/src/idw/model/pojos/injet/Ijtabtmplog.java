package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ijtabtmplog generated by hbm2java
 */
@Entity
@Table(name = "IJTABTMPLOG")
public class Ijtabtmplog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -937004527524738857L;
	private String anomes;
	private Double sequencial;
	private String anomesdia;

	public Ijtabtmplog() {
	}

	public Ijtabtmplog(String anomes) {
		this.anomes = anomes;
	}

	public Ijtabtmplog(String anomes, Double sequencial, String anomesdia) {
		this.anomes = anomes;
		this.sequencial = sequencial;
		this.anomesdia = anomesdia;
	}

	@Id
	@Column(name = "ANOMES", unique = true, nullable = false, length = 6)
	public String getAnomes() {
		return this.anomes;
	}

	public void setAnomes(String anomes) {
		this.anomes = anomes;
	}

	@Column(name = "SEQUENCIAL", precision = 126, scale = 0)
	public Double getSequencial() {
		return this.sequencial;
	}

	public void setSequencial(Double sequencial) {
		this.sequencial = sequencial;
	}

	@Column(name = "ANOMESDIA", length = 10)
	public String getAnomesdia() {
		return this.anomesdia;
	}

	public void setAnomesdia(String anomesdia) {
		this.anomesdia = anomesdia;
	}

}

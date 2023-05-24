package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijtbslides generated by hbm2java
 */
@Entity
@Table(name = "IJTBSLIDES")
public class Ijtbslides implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1082885361000327299L;
	private String cdslide;
	private String dsslide;
	private BigDecimal tpslide;
	private Set<Ijtbslidesxmaq> ijtbslidesxmaqs = new HashSet<Ijtbslidesxmaq>(0);
	private Set<Ijtbapresxslides> ijtbapresxslideses = new HashSet<Ijtbapresxslides>(
			0);

	public Ijtbslides() {
	}

	public Ijtbslides(String cdslide, String dsslide, BigDecimal tpslide) {
		this.cdslide = cdslide;
		this.dsslide = dsslide;
		this.tpslide = tpslide;
	}

	public Ijtbslides(String cdslide, String dsslide, BigDecimal tpslide,
			Set<Ijtbslidesxmaq> ijtbslidesxmaqs,
			Set<Ijtbapresxslides> ijtbapresxslideses) {
		this.cdslide = cdslide;
		this.dsslide = dsslide;
		this.tpslide = tpslide;
		this.ijtbslidesxmaqs = ijtbslidesxmaqs;
		this.ijtbapresxslideses = ijtbapresxslideses;
	}

	@Id
	@Column(name = "CDSLIDE", unique = true, nullable = false, length = 6)
	public String getCdslide() {
		return this.cdslide;
	}

	public void setCdslide(String cdslide) {
		this.cdslide = cdslide;
	}

	@Column(name = "DSSLIDE", nullable = false, length = 40)
	public String getDsslide() {
		return this.dsslide;
	}

	public void setDsslide(String dsslide) {
		this.dsslide = dsslide;
	}

	@Column(name = "TPSLIDE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTpslide() {
		return this.tpslide;
	}

	public void setTpslide(BigDecimal tpslide) {
		this.tpslide = tpslide;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbslides")
	public Set<Ijtbslidesxmaq> getIjtbslidesxmaqs() {
		return this.ijtbslidesxmaqs;
	}

	public void setIjtbslidesxmaqs(Set<Ijtbslidesxmaq> ijtbslidesxmaqs) {
		this.ijtbslidesxmaqs = ijtbslidesxmaqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbslides")
	public Set<Ijtbapresxslides> getIjtbapresxslideses() {
		return this.ijtbapresxslideses;
	}

	public void setIjtbapresxslideses(Set<Ijtbapresxslides> ijtbapresxslideses) {
		this.ijtbapresxslideses = ijtbapresxslideses;
	}

}
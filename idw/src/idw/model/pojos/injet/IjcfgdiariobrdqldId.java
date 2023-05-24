package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcfgdiariobrdqldId generated by hbm2java
 */
@Embeddable
public class IjcfgdiariobrdqldId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5542348944645854760L;
	private BigDecimal cfgdiariobrdqld;
	private BigDecimal tempolimaptdbqld;

	public IjcfgdiariobrdqldId() {
	}

	public IjcfgdiariobrdqldId(BigDecimal cfgdiariobrdqld,
			BigDecimal tempolimaptdbqld) {
		this.cfgdiariobrdqld = cfgdiariobrdqld;
		this.tempolimaptdbqld = tempolimaptdbqld;
	}

	@Column(name = "CFGDIARIOBRDQLD", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCfgdiariobrdqld() {
		return this.cfgdiariobrdqld;
	}

	public void setCfgdiariobrdqld(BigDecimal cfgdiariobrdqld) {
		this.cfgdiariobrdqld = cfgdiariobrdqld;
	}

	@Column(name = "TEMPOLIMAPTDBQLD", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempolimaptdbqld() {
		return this.tempolimaptdbqld;
	}

	public void setTempolimaptdbqld(BigDecimal tempolimaptdbqld) {
		this.tempolimaptdbqld = tempolimaptdbqld;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcfgdiariobrdqldId))
			return false;
		IjcfgdiariobrdqldId castOther = (IjcfgdiariobrdqldId) other;

		return ((this.getCfgdiariobrdqld() == castOther.getCfgdiariobrdqld()) || (this
				.getCfgdiariobrdqld() != null
				&& castOther.getCfgdiariobrdqld() != null && this
				.getCfgdiariobrdqld().equals(castOther.getCfgdiariobrdqld())))
				&& ((this.getTempolimaptdbqld() == castOther
						.getTempolimaptdbqld()) || (this.getTempolimaptdbqld() != null
						&& castOther.getTempolimaptdbqld() != null && this
						.getTempolimaptdbqld().equals(
								castOther.getTempolimaptdbqld())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCfgdiariobrdqld() == null ? 0 : this.getCfgdiariobrdqld()
						.hashCode());
		result = 37
				* result
				+ (getTempolimaptdbqld() == null ? 0 : this
						.getTempolimaptdbqld().hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjclassificinfId generated by hbm2java
 */
@Embeddable
public class IjclassificinfId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6905183464406466098L;
	private String cdtipoinf;
	private String cdinf;

	public IjclassificinfId() {
	}

	public IjclassificinfId(String cdtipoinf, String cdinf) {
		this.cdtipoinf = cdtipoinf;
		this.cdinf = cdinf;
	}

	@Column(name = "CDTIPOINF", nullable = false, length = 6)
	public String getCdtipoinf() {
		return this.cdtipoinf;
	}

	public void setCdtipoinf(String cdtipoinf) {
		this.cdtipoinf = cdtipoinf;
	}

	@Column(name = "CDINF", nullable = false, length = 6)
	public String getCdinf() {
		return this.cdinf;
	}

	public void setCdinf(String cdinf) {
		this.cdinf = cdinf;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjclassificinfId))
			return false;
		IjclassificinfId castOther = (IjclassificinfId) other;

		return ((this.getCdtipoinf() == castOther.getCdtipoinf()) || (this
				.getCdtipoinf() != null && castOther.getCdtipoinf() != null && this
				.getCdtipoinf().equals(castOther.getCdtipoinf())))
				&& ((this.getCdinf() == castOther.getCdinf()) || (this
						.getCdinf() != null && castOther.getCdinf() != null && this
						.getCdinf().equals(castOther.getCdinf())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdtipoinf() == null ? 0 : this.getCdtipoinf().hashCode());
		result = 37 * result
				+ (getCdinf() == null ? 0 : this.getCdinf().hashCode());
		return result;
	}

}

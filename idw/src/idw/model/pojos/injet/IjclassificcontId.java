package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjclassificcontId generated by hbm2java
 */
@Embeddable
public class IjclassificcontId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522434425556440631L;
	private String cdtipoinf;
	private String cdcont;

	public IjclassificcontId() {
	}

	public IjclassificcontId(String cdtipoinf, String cdcont) {
		this.cdtipoinf = cdtipoinf;
		this.cdcont = cdcont;
	}

	@Column(name = "CDTIPOINF", nullable = false, length = 6)
	public String getCdtipoinf() {
		return this.cdtipoinf;
	}

	public void setCdtipoinf(String cdtipoinf) {
		this.cdtipoinf = cdtipoinf;
	}

	@Column(name = "CDCONT", nullable = false, length = 6)
	public String getCdcont() {
		return this.cdcont;
	}

	public void setCdcont(String cdcont) {
		this.cdcont = cdcont;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjclassificcontId))
			return false;
		IjclassificcontId castOther = (IjclassificcontId) other;

		return ((this.getCdtipoinf() == castOther.getCdtipoinf()) || (this
				.getCdtipoinf() != null && castOther.getCdtipoinf() != null && this
				.getCdtipoinf().equals(castOther.getCdtipoinf())))
				&& ((this.getCdcont() == castOther.getCdcont()) || (this
						.getCdcont() != null && castOther.getCdcont() != null && this
						.getCdcont().equals(castOther.getCdcont())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdtipoinf() == null ? 0 : this.getCdtipoinf().hashCode());
		result = 37 * result
				+ (getCdcont() == null ? 0 : this.getCdcont().hashCode());
		return result;
	}

}
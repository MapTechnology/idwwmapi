package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjficteccelId generated by hbm2java
 */
@Embeddable
public class IjficteccelId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2889708787748899259L;
	private String cdcelula;
	private Date dthrivalciccel;

	public IjficteccelId() {
	}

	public IjficteccelId(String cdcelula, Date dthrivalciccel) {
		this.cdcelula = cdcelula;
		this.dthrivalciccel = dthrivalciccel;
	}

	@Column(name = "CDCELULA", nullable = false, length = 6)
	public String getCdcelula() {
		return this.cdcelula;
	}

	public void setCdcelula(String cdcelula) {
		this.cdcelula = cdcelula;
	}

	@Column(name = "DTHRIVALCICCEL", nullable = false, length = 7)
	public Date getDthrivalciccel() {
		return this.dthrivalciccel;
	}

	public void setDthrivalciccel(Date dthrivalciccel) {
		this.dthrivalciccel = dthrivalciccel;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjficteccelId))
			return false;
		IjficteccelId castOther = (IjficteccelId) other;

		return ((this.getCdcelula() == castOther.getCdcelula()) || (this
				.getCdcelula() != null && castOther.getCdcelula() != null && this
				.getCdcelula().equals(castOther.getCdcelula())))
				&& ((this.getDthrivalciccel() == castOther.getDthrivalciccel()) || (this
						.getDthrivalciccel() != null
						&& castOther.getDthrivalciccel() != null && this
						.getDthrivalciccel().equals(
								castOther.getDthrivalciccel())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdcelula() == null ? 0 : this.getCdcelula().hashCode());
		result = 37
				* result
				+ (getDthrivalciccel() == null ? 0 : this.getDthrivalciccel()
						.hashCode());
		return result;
	}

}

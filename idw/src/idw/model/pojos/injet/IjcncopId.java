package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcncopId generated by hbm2java
 */
@Embeddable
public class IjcncopId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028193956914836929L;
	private String nrop;
	private String cditemcnc;

	public IjcncopId() {
	}

	public IjcncopId(String nrop, String cditemcnc) {
		this.nrop = nrop;
		this.cditemcnc = cditemcnc;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDITEMCNC", nullable = false, length = 6)
	public String getCditemcnc() {
		return this.cditemcnc;
	}

	public void setCditemcnc(String cditemcnc) {
		this.cditemcnc = cditemcnc;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcncopId))
			return false;
		IjcncopId castOther = (IjcncopId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getCditemcnc() == castOther.getCditemcnc()) || (this
						.getCditemcnc() != null
						&& castOther.getCditemcnc() != null && this
						.getCditemcnc().equals(castOther.getCditemcnc())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCditemcnc() == null ? 0 : this.getCditemcnc().hashCode());
		return result;
	}

}
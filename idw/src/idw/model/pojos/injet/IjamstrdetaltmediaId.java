package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjamstrdetaltmediaId generated by hbm2java
 */
@Embeddable
public class IjamstrdetaltmediaId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986947336561880677L;
	private double idctrlaltcgammedia;
	private double idctrlaltcgqamstr;

	public IjamstrdetaltmediaId() {
	}

	public IjamstrdetaltmediaId(double idctrlaltcgammedia,
			double idctrlaltcgqamstr) {
		this.idctrlaltcgammedia = idctrlaltcgammedia;
		this.idctrlaltcgqamstr = idctrlaltcgqamstr;
	}

	@Column(name = "IDCTRLALTCGAMMEDIA", nullable = false, precision = 126, scale = 0)
	public double getIdctrlaltcgammedia() {
		return this.idctrlaltcgammedia;
	}

	public void setIdctrlaltcgammedia(double idctrlaltcgammedia) {
		this.idctrlaltcgammedia = idctrlaltcgammedia;
	}

	@Column(name = "IDCTRLALTCGQAMSTR", nullable = false, precision = 126, scale = 0)
	public double getIdctrlaltcgqamstr() {
		return this.idctrlaltcgqamstr;
	}

	public void setIdctrlaltcgqamstr(double idctrlaltcgqamstr) {
		this.idctrlaltcgqamstr = idctrlaltcgqamstr;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjamstrdetaltmediaId))
			return false;
		IjamstrdetaltmediaId castOther = (IjamstrdetaltmediaId) other;

		return (this.getIdctrlaltcgammedia() == castOther
				.getIdctrlaltcgammedia())
				&& (this.getIdctrlaltcgqamstr() == castOther
						.getIdctrlaltcgqamstr());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdctrlaltcgammedia();
		result = 37 * result + (int) this.getIdctrlaltcgqamstr();
		return result;
	}

}

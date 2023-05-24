package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjctrlsmsId generated by hbm2java
 */
@Embeddable
public class IjctrlsmsId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6480097965531794744L;
	private String idmsgusu;
	private double idmsgsms;

	public IjctrlsmsId() {
	}

	public IjctrlsmsId(String idmsgusu, double idmsgsms) {
		this.idmsgusu = idmsgusu;
		this.idmsgsms = idmsgsms;
	}

	@Column(name = "IDMSGUSU", nullable = false, length = 10)
	public String getIdmsgusu() {
		return this.idmsgusu;
	}

	public void setIdmsgusu(String idmsgusu) {
		this.idmsgusu = idmsgusu;
	}

	@Column(name = "IDMSGSMS", nullable = false, precision = 126, scale = 0)
	public double getIdmsgsms() {
		return this.idmsgsms;
	}

	public void setIdmsgsms(double idmsgsms) {
		this.idmsgsms = idmsgsms;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjctrlsmsId))
			return false;
		IjctrlsmsId castOther = (IjctrlsmsId) other;

		return ((this.getIdmsgusu() == castOther.getIdmsgusu()) || (this
				.getIdmsgusu() != null && castOther.getIdmsgusu() != null && this
				.getIdmsgusu().equals(castOther.getIdmsgusu())))
				&& (this.getIdmsgsms() == castOther.getIdmsgsms());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdmsgusu() == null ? 0 : this.getIdmsgusu().hashCode());
		result = 37 * result + (int) this.getIdmsgsms();
		return result;
	}

}
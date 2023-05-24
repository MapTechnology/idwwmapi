package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbidrptId generated by hbm2java
 */
@Embeddable
public class IjtbidrptId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1407544727690685108L;
	private String cdmodulo;
	private String nmform;
	private String nmmenurpt;

	public IjtbidrptId() {
	}

	public IjtbidrptId(String cdmodulo, String nmform, String nmmenurpt) {
		this.cdmodulo = cdmodulo;
		this.nmform = nmform;
		this.nmmenurpt = nmmenurpt;
	}

	@Column(name = "CDMODULO", nullable = false, length = 6)
	public String getCdmodulo() {
		return this.cdmodulo;
	}

	public void setCdmodulo(String cdmodulo) {
		this.cdmodulo = cdmodulo;
	}

	@Column(name = "NMFORM", nullable = false, length = 40)
	public String getNmform() {
		return this.nmform;
	}

	public void setNmform(String nmform) {
		this.nmform = nmform;
	}

	@Column(name = "NMMENURPT", nullable = false, length = 40)
	public String getNmmenurpt() {
		return this.nmmenurpt;
	}

	public void setNmmenurpt(String nmmenurpt) {
		this.nmmenurpt = nmmenurpt;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbidrptId))
			return false;
		IjtbidrptId castOther = (IjtbidrptId) other;

		return ((this.getCdmodulo() == castOther.getCdmodulo()) || (this
				.getCdmodulo() != null && castOther.getCdmodulo() != null && this
				.getCdmodulo().equals(castOther.getCdmodulo())))
				&& ((this.getNmform() == castOther.getNmform()) || (this
						.getNmform() != null && castOther.getNmform() != null && this
						.getNmform().equals(castOther.getNmform())))
				&& ((this.getNmmenurpt() == castOther.getNmmenurpt()) || (this
						.getNmmenurpt() != null
						&& castOther.getNmmenurpt() != null && this
						.getNmmenurpt().equals(castOther.getNmmenurpt())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmodulo() == null ? 0 : this.getCdmodulo().hashCode());
		result = 37 * result
				+ (getNmform() == null ? 0 : this.getNmform().hashCode());
		result = 37 * result
				+ (getNmmenurpt() == null ? 0 : this.getNmmenurpt().hashCode());
		return result;
	}

}
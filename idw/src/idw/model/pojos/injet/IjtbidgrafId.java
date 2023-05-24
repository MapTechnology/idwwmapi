package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbidgrafId generated by hbm2java
 */
@Embeddable
public class IjtbidgrafId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 788524303547486014L;
	private String cdmodulo;
	private String nmform;
	private String nmformorigem;

	public IjtbidgrafId() {
	}

	public IjtbidgrafId(String cdmodulo, String nmform, String nmformorigem) {
		this.cdmodulo = cdmodulo;
		this.nmform = nmform;
		this.nmformorigem = nmformorigem;
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

	@Column(name = "NMFORMORIGEM", nullable = false, length = 40)
	public String getNmformorigem() {
		return this.nmformorigem;
	}

	public void setNmformorigem(String nmformorigem) {
		this.nmformorigem = nmformorigem;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbidgrafId))
			return false;
		IjtbidgrafId castOther = (IjtbidgrafId) other;

		return ((this.getCdmodulo() == castOther.getCdmodulo()) || (this
				.getCdmodulo() != null && castOther.getCdmodulo() != null && this
				.getCdmodulo().equals(castOther.getCdmodulo())))
				&& ((this.getNmform() == castOther.getNmform()) || (this
						.getNmform() != null && castOther.getNmform() != null && this
						.getNmform().equals(castOther.getNmform())))
				&& ((this.getNmformorigem() == castOther.getNmformorigem()) || (this
						.getNmformorigem() != null
						&& castOther.getNmformorigem() != null && this
						.getNmformorigem().equals(castOther.getNmformorigem())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmodulo() == null ? 0 : this.getCdmodulo().hashCode());
		result = 37 * result
				+ (getNmform() == null ? 0 : this.getNmform().hashCode());
		result = 37
				* result
				+ (getNmformorigem() == null ? 0 : this.getNmformorigem()
						.hashCode());
		return result;
	}

}

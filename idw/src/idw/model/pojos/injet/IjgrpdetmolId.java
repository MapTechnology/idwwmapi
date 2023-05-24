package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpdetmolId generated by hbm2java
 */
@Embeddable
public class IjgrpdetmolId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -210092754645071581L;
	private String cdgrpmol;
	private String cdmolde;

	public IjgrpdetmolId() {
	}

	public IjgrpdetmolId(String cdgrpmol, String cdmolde) {
		this.cdgrpmol = cdgrpmol;
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDGRPMOL", nullable = false, length = 6)
	public String getCdgrpmol() {
		return this.cdgrpmol;
	}

	public void setCdgrpmol(String cdgrpmol) {
		this.cdgrpmol = cdgrpmol;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpdetmolId))
			return false;
		IjgrpdetmolId castOther = (IjgrpdetmolId) other;

		return ((this.getCdgrpmol() == castOther.getCdgrpmol()) || (this
				.getCdgrpmol() != null && castOther.getCdgrpmol() != null && this
				.getCdgrpmol().equals(castOther.getCdgrpmol())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdgrpmol() == null ? 0 : this.getCdgrpmol().hashCode());
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		return result;
	}

}
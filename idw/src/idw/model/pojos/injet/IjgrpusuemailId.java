package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpusuemailId generated by hbm2java
 */
@Embeddable
public class IjgrpusuemailId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8136257996650277549L;
	private String cdgrpemail;
	private String cdusumail;

	public IjgrpusuemailId() {
	}

	public IjgrpusuemailId(String cdgrpemail, String cdusumail) {
		this.cdgrpemail = cdgrpemail;
		this.cdusumail = cdusumail;
	}

	@Column(name = "CDGRPEMAIL", nullable = false, length = 6)
	public String getCdgrpemail() {
		return this.cdgrpemail;
	}

	public void setCdgrpemail(String cdgrpemail) {
		this.cdgrpemail = cdgrpemail;
	}

	@Column(name = "CDUSUMAIL", nullable = false, length = 6)
	public String getCdusumail() {
		return this.cdusumail;
	}

	public void setCdusumail(String cdusumail) {
		this.cdusumail = cdusumail;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpusuemailId))
			return false;
		IjgrpusuemailId castOther = (IjgrpusuemailId) other;

		return ((this.getCdgrpemail() == castOther.getCdgrpemail()) || (this
				.getCdgrpemail() != null && castOther.getCdgrpemail() != null && this
				.getCdgrpemail().equals(castOther.getCdgrpemail())))
				&& ((this.getCdusumail() == castOther.getCdusumail()) || (this
						.getCdusumail() != null
						&& castOther.getCdusumail() != null && this
						.getCdusumail().equals(castOther.getCdusumail())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdgrpemail() == null ? 0 : this.getCdgrpemail()
						.hashCode());
		result = 37 * result
				+ (getCdusumail() == null ? 0 : this.getCdusumail().hashCode());
		return result;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpdetinjId generated by hbm2java
 */
@Embeddable
public class IjgrpdetinjId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1447767035873550872L;
	private String cdgrpinj;
	private String cdinjetora;

	public IjgrpdetinjId() {
	}

	public IjgrpdetinjId(String cdgrpinj, String cdinjetora) {
		this.cdgrpinj = cdgrpinj;
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDGRPINJ", nullable = false, length = 6)
	public String getCdgrpinj() {
		return this.cdgrpinj;
	}

	public void setCdgrpinj(String cdgrpinj) {
		this.cdgrpinj = cdgrpinj;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpdetinjId))
			return false;
		IjgrpdetinjId castOther = (IjgrpdetinjId) other;

		return ((this.getCdgrpinj() == castOther.getCdgrpinj()) || (this
				.getCdgrpinj() != null && castOther.getCdgrpinj() != null && this
				.getCdgrpinj().equals(castOther.getCdgrpinj())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdgrpinj() == null ? 0 : this.getCdgrpinj().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfamiliaxmaqId generated by hbm2java
 */
@Embeddable
public class IjfamiliaxmaqId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -871635602920039557L;
	private String cdfamilia;
	private String cdinjetora;

	public IjfamiliaxmaqId() {
	}

	public IjfamiliaxmaqId(String cdfamilia, String cdinjetora) {
		this.cdfamilia = cdfamilia;
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDFAMILIA", nullable = false, length = 8)
	public String getCdfamilia() {
		return this.cdfamilia;
	}

	public void setCdfamilia(String cdfamilia) {
		this.cdfamilia = cdfamilia;
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
		if (!(other instanceof IjfamiliaxmaqId))
			return false;
		IjfamiliaxmaqId castOther = (IjfamiliaxmaqId) other;

		return ((this.getCdfamilia() == castOther.getCdfamilia()) || (this
				.getCdfamilia() != null && castOther.getCdfamilia() != null && this
				.getCdfamilia().equals(castOther.getCdfamilia())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdfamilia() == null ? 0 : this.getCdfamilia().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpinjparId generated by hbm2java
 */
@Embeddable
public class IjgrpinjparId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8614904475132808176L;
	private String cdinjetora;
	private String cdgrupopar;

	public IjgrpinjparId() {
	}

	public IjgrpinjparId(String cdinjetora, String cdgrupopar) {
		this.cdinjetora = cdinjetora;
		this.cdgrupopar = cdgrupopar;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDGRUPOPAR", nullable = false, length = 6)
	public String getCdgrupopar() {
		return this.cdgrupopar;
	}

	public void setCdgrupopar(String cdgrupopar) {
		this.cdgrupopar = cdgrupopar;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpinjparId))
			return false;
		IjgrpinjparId castOther = (IjgrpinjparId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdgrupopar() == castOther.getCdgrupopar()) || (this
						.getCdgrupopar() != null
						&& castOther.getCdgrupopar() != null && this
						.getCdgrupopar().equals(castOther.getCdgrupopar())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37
				* result
				+ (getCdgrupopar() == null ? 0 : this.getCdgrupopar()
						.hashCode());
		return result;
	}

}

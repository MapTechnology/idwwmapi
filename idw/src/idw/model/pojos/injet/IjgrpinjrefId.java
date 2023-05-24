package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpinjrefId generated by hbm2java
 */
@Embeddable
public class IjgrpinjrefId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627891640433469533L;
	private String cdinjetora;
	private String cdgruporef;

	public IjgrpinjrefId() {
	}

	public IjgrpinjrefId(String cdinjetora, String cdgruporef) {
		this.cdinjetora = cdinjetora;
		this.cdgruporef = cdgruporef;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDGRUPOREF", nullable = false, length = 6)
	public String getCdgruporef() {
		return this.cdgruporef;
	}

	public void setCdgruporef(String cdgruporef) {
		this.cdgruporef = cdgruporef;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpinjrefId))
			return false;
		IjgrpinjrefId castOther = (IjgrpinjrefId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdgruporef() == castOther.getCdgruporef()) || (this
						.getCdgruporef() != null
						&& castOther.getCdgruporef() != null && this
						.getCdgruporef().equals(castOther.getCdgruporef())));
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
				+ (getCdgruporef() == null ? 0 : this.getCdgruporef()
						.hashCode());
		return result;
	}

}

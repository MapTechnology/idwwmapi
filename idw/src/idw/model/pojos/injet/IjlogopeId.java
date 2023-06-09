package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjlogopeId generated by hbm2java
 */
@Embeddable
public class IjlogopeId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2594434336985196858L;
	private Date dthrlogin;
	private String cdinjetora;
	private String cdusuario;

	public IjlogopeId() {
	}

	public IjlogopeId(Date dthrlogin, String cdinjetora, String cdusuario) {
		this.dthrlogin = dthrlogin;
		this.cdinjetora = cdinjetora;
		this.cdusuario = cdusuario;
	}

	@Column(name = "DTHRLOGIN", nullable = false, length = 7)
	public Date getDthrlogin() {
		return this.dthrlogin;
	}

	public void setDthrlogin(Date dthrlogin) {
		this.dthrlogin = dthrlogin;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDUSUARIO", nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjlogopeId))
			return false;
		IjlogopeId castOther = (IjlogopeId) other;

		return ((this.getDthrlogin() == castOther.getDthrlogin()) || (this
				.getDthrlogin() != null && castOther.getDthrlogin() != null && this
				.getDthrlogin().equals(castOther.getDthrlogin())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdusuario() == castOther.getCdusuario()) || (this
						.getCdusuario() != null
						&& castOther.getCdusuario() != null && this
						.getCdusuario().equals(castOther.getCdusuario())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDthrlogin() == null ? 0 : this.getDthrlogin().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getCdusuario() == null ? 0 : this.getCdusuario().hashCode());
		return result;
	}

}

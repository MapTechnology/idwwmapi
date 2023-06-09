package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjreapesoId generated by hbm2java
 */
@Embeddable
public class IjreapesoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -564533712053692732L;
	private String cdinjetora;
	private Date dthrpesagem;

	public IjreapesoId() {
	}

	public IjreapesoId(String cdinjetora, Date dthrpesagem) {
		this.cdinjetora = cdinjetora;
		this.dthrpesagem = dthrpesagem;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "DTHRPESAGEM", nullable = false, length = 7)
	public Date getDthrpesagem() {
		return this.dthrpesagem;
	}

	public void setDthrpesagem(Date dthrpesagem) {
		this.dthrpesagem = dthrpesagem;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjreapesoId))
			return false;
		IjreapesoId castOther = (IjreapesoId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getDthrpesagem() == castOther.getDthrpesagem()) || (this
						.getDthrpesagem() != null
						&& castOther.getDthrpesagem() != null && this
						.getDthrpesagem().equals(castOther.getDthrpesagem())));
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
				+ (getDthrpesagem() == null ? 0 : this.getDthrpesagem()
						.hashCode());
		return result;
	}

}

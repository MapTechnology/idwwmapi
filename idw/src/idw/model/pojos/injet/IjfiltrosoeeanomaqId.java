package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfiltrosoeeanomaqId generated by hbm2java
 */
@Embeddable
public class IjfiltrosoeeanomaqId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1795986394143522941L;
	private BigDecimal idfiltrooee;
	private String cdinjetora;
	private String ano;

	public IjfiltrosoeeanomaqId() {
	}

	public IjfiltrosoeeanomaqId(BigDecimal idfiltrooee, String cdinjetora,
			String ano) {
		this.idfiltrooee = idfiltrooee;
		this.cdinjetora = cdinjetora;
		this.ano = ano;
	}

	@Column(name = "IDFILTROOEE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdfiltrooee() {
		return this.idfiltrooee;
	}

	public void setIdfiltrooee(BigDecimal idfiltrooee) {
		this.idfiltrooee = idfiltrooee;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 20)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "ANO", nullable = false, length = 4)
	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfiltrosoeeanomaqId))
			return false;
		IjfiltrosoeeanomaqId castOther = (IjfiltrosoeeanomaqId) other;

		return ((this.getIdfiltrooee() == castOther.getIdfiltrooee()) || (this
				.getIdfiltrooee() != null && castOther.getIdfiltrooee() != null && this
				.getIdfiltrooee().equals(castOther.getIdfiltrooee())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getAno() == castOther.getAno()) || (this.getAno() != null
						&& castOther.getAno() != null && this.getAno().equals(
						castOther.getAno())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdfiltrooee() == null ? 0 : this.getIdfiltrooee()
						.hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getAno() == null ? 0 : this.getAno().hashCode());
		return result;
	}

}

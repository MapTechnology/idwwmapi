package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjficinjId generated by hbm2java
 */
@Embeddable
public class IjficinjId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175291080745675926L;
	private String cdinjetora;
	private String cditemcnc;
	private BigDecimal posicaoordinal;

	public IjficinjId() {
	}

	public IjficinjId(String cdinjetora, String cditemcnc,
			BigDecimal posicaoordinal) {
		this.cdinjetora = cdinjetora;
		this.cditemcnc = cditemcnc;
		this.posicaoordinal = posicaoordinal;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDITEMCNC", nullable = false, length = 6)
	public String getCditemcnc() {
		return this.cditemcnc;
	}

	public void setCditemcnc(String cditemcnc) {
		this.cditemcnc = cditemcnc;
	}

	@Column(name = "POSICAOORDINAL", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPosicaoordinal() {
		return this.posicaoordinal;
	}

	public void setPosicaoordinal(BigDecimal posicaoordinal) {
		this.posicaoordinal = posicaoordinal;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjficinjId))
			return false;
		IjficinjId castOther = (IjficinjId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCditemcnc() == castOther.getCditemcnc()) || (this
						.getCditemcnc() != null
						&& castOther.getCditemcnc() != null && this
						.getCditemcnc().equals(castOther.getCditemcnc())))
				&& ((this.getPosicaoordinal() == castOther.getPosicaoordinal()) || (this
						.getPosicaoordinal() != null
						&& castOther.getPosicaoordinal() != null && this
						.getPosicaoordinal().equals(
								castOther.getPosicaoordinal())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getCditemcnc() == null ? 0 : this.getCditemcnc().hashCode());
		result = 37
				* result
				+ (getPosicaoordinal() == null ? 0 : this.getPosicaoordinal()
						.hashCode());
		return result;
	}

}

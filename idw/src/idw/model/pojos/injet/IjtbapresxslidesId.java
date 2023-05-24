package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbapresxslidesId generated by hbm2java
 */
@Embeddable
public class IjtbapresxslidesId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4111048407324636009L;
	private String cdapresentacao;
	private BigDecimal ordemapresentacao;

	public IjtbapresxslidesId() {
	}

	public IjtbapresxslidesId(String cdapresentacao,
			BigDecimal ordemapresentacao) {
		this.cdapresentacao = cdapresentacao;
		this.ordemapresentacao = ordemapresentacao;
	}

	@Column(name = "CDAPRESENTACAO", nullable = false, length = 6)
	public String getCdapresentacao() {
		return this.cdapresentacao;
	}

	public void setCdapresentacao(String cdapresentacao) {
		this.cdapresentacao = cdapresentacao;
	}

	@Column(name = "ORDEMAPRESENTACAO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrdemapresentacao() {
		return this.ordemapresentacao;
	}

	public void setOrdemapresentacao(BigDecimal ordemapresentacao) {
		this.ordemapresentacao = ordemapresentacao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbapresxslidesId))
			return false;
		IjtbapresxslidesId castOther = (IjtbapresxslidesId) other;

		return ((this.getCdapresentacao() == castOther.getCdapresentacao()) || (this
				.getCdapresentacao() != null
				&& castOther.getCdapresentacao() != null && this
				.getCdapresentacao().equals(castOther.getCdapresentacao())))
				&& ((this.getOrdemapresentacao() == castOther
						.getOrdemapresentacao()) || (this
						.getOrdemapresentacao() != null
						&& castOther.getOrdemapresentacao() != null && this
						.getOrdemapresentacao().equals(
								castOther.getOrdemapresentacao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdapresentacao() == null ? 0 : this.getCdapresentacao()
						.hashCode());
		result = 37
				* result
				+ (getOrdemapresentacao() == null ? 0 : this
						.getOrdemapresentacao().hashCode());
		return result;
	}

}

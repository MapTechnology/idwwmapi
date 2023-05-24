package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfiltrosoeemesesId generated by hbm2java
 */
@Embeddable
public class IjfiltrosoeemesesId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7170053567000608958L;
	private BigDecimal idfiltrooee;
	private String ano;
	private String mes;

	public IjfiltrosoeemesesId() {
	}

	public IjfiltrosoeemesesId(BigDecimal idfiltrooee, String ano, String mes) {
		this.idfiltrooee = idfiltrooee;
		this.ano = ano;
		this.mes = mes;
	}

	@Column(name = "IDFILTROOEE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdfiltrooee() {
		return this.idfiltrooee;
	}

	public void setIdfiltrooee(BigDecimal idfiltrooee) {
		this.idfiltrooee = idfiltrooee;
	}

	@Column(name = "ANO", nullable = false, length = 4)
	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Column(name = "MES", nullable = false, length = 2)
	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfiltrosoeemesesId))
			return false;
		IjfiltrosoeemesesId castOther = (IjfiltrosoeemesesId) other;

		return ((this.getIdfiltrooee() == castOther.getIdfiltrooee()) || (this
				.getIdfiltrooee() != null && castOther.getIdfiltrooee() != null && this
				.getIdfiltrooee().equals(castOther.getIdfiltrooee())))
				&& ((this.getAno() == castOther.getAno()) || (this.getAno() != null
						&& castOther.getAno() != null && this.getAno().equals(
						castOther.getAno())))
				&& ((this.getMes() == castOther.getMes()) || (this.getMes() != null
						&& castOther.getMes() != null && this.getMes().equals(
						castOther.getMes())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdfiltrooee() == null ? 0 : this.getIdfiltrooee()
						.hashCode());
		result = 37 * result
				+ (getAno() == null ? 0 : this.getAno().hashCode());
		result = 37 * result
				+ (getMes() == null ? 0 : this.getMes().hashCode());
		return result;
	}

}

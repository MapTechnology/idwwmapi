package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjdetgraficoId generated by hbm2java
 */
@Embeddable
public class IjdetgraficoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7807616358674588139L;
	private String grafico;
	private String cdlingua;
	private BigDecimal serie;

	public IjdetgraficoId() {
	}

	public IjdetgraficoId(String grafico, String cdlingua, BigDecimal serie) {
		this.grafico = grafico;
		this.cdlingua = cdlingua;
		this.serie = serie;
	}

	@Column(name = "GRAFICO", nullable = false, length = 50)
	public String getGrafico() {
		return this.grafico;
	}

	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}

	@Column(name = "CDLINGUA", nullable = false, length = 6)
	public String getCdlingua() {
		return this.cdlingua;
	}

	public void setCdlingua(String cdlingua) {
		this.cdlingua = cdlingua;
	}

	@Column(name = "SERIE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getSerie() {
		return this.serie;
	}

	public void setSerie(BigDecimal serie) {
		this.serie = serie;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjdetgraficoId))
			return false;
		IjdetgraficoId castOther = (IjdetgraficoId) other;

		return ((this.getGrafico() == castOther.getGrafico()) || (this
				.getGrafico() != null && castOther.getGrafico() != null && this
				.getGrafico().equals(castOther.getGrafico())))
				&& ((this.getCdlingua() == castOther.getCdlingua()) || (this
						.getCdlingua() != null
						&& castOther.getCdlingua() != null && this
						.getCdlingua().equals(castOther.getCdlingua())))
				&& ((this.getSerie() == castOther.getSerie()) || (this
						.getSerie() != null && castOther.getSerie() != null && this
						.getSerie().equals(castOther.getSerie())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGrafico() == null ? 0 : this.getGrafico().hashCode());
		result = 37 * result
				+ (getCdlingua() == null ? 0 : this.getCdlingua().hashCode());
		result = 37 * result
				+ (getSerie() == null ? 0 : this.getSerie().hashCode());
		return result;
	}

}
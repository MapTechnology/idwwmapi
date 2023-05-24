package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Ijregultinspqld1frId generated by hbm2java
 */
@Embeddable
public class Ijregultinspqld1frId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1585758108933010273L;
	private String nrop;
	private String cdproduto;
	private double vlreferencia;

	public Ijregultinspqld1frId() {
	}

	public Ijregultinspqld1frId(String nrop, String cdproduto,
			double vlreferencia) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.vlreferencia = vlreferencia;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "VLREFERENCIA", nullable = false, precision = 126, scale = 0)
	public double getVlreferencia() {
		return this.vlreferencia;
	}

	public void setVlreferencia(double vlreferencia) {
		this.vlreferencia = vlreferencia;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Ijregultinspqld1frId))
			return false;
		Ijregultinspqld1frId castOther = (Ijregultinspqld1frId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& (this.getVlreferencia() == castOther.getVlreferencia());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result + (int) this.getVlreferencia();
		return result;
	}

}

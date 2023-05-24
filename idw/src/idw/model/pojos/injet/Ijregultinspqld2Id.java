package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Ijregultinspqld2Id generated by hbm2java
 */
@Embeddable
public class Ijregultinspqld2Id implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3581893733642980015L;
	private String nrop;
	private String cdproduto;
	private String cdgrpparam;

	public Ijregultinspqld2Id() {
	}

	public Ijregultinspqld2Id(String nrop, String cdproduto, String cdgrpparam) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.cdgrpparam = cdgrpparam;
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

	@Column(name = "CDGRPPARAM", nullable = false, length = 6)
	public String getCdgrpparam() {
		return this.cdgrpparam;
	}

	public void setCdgrpparam(String cdgrpparam) {
		this.cdgrpparam = cdgrpparam;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Ijregultinspqld2Id))
			return false;
		Ijregultinspqld2Id castOther = (Ijregultinspqld2Id) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getCdgrpparam() == castOther.getCdgrpparam()) || (this
						.getCdgrpparam() != null
						&& castOther.getCdgrpparam() != null && this
						.getCdgrpparam().equals(castOther.getCdgrpparam())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37
				* result
				+ (getCdgrpparam() == null ? 0 : this.getCdgrpparam()
						.hashCode());
		return result;
	}

}
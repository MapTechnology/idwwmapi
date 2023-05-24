package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrpdetproId generated by hbm2java
 */
@Embeddable
public class IjgrpdetproId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1007090822288054977L;
	private String cdgrppro;
	private String cdproduto;

	public IjgrpdetproId() {
	}

	public IjgrpdetproId(String cdgrppro, String cdproduto) {
		this.cdgrppro = cdgrppro;
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDGRPPRO", nullable = false, length = 6)
	public String getCdgrppro() {
		return this.cdgrppro;
	}

	public void setCdgrppro(String cdgrppro) {
		this.cdgrppro = cdgrppro;
	}

	@Column(name = "CDPRODUTO", unique = true, nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrpdetproId))
			return false;
		IjgrpdetproId castOther = (IjgrpdetproId) other;

		return ((this.getCdgrppro() == castOther.getCdgrppro()) || (this
				.getCdgrppro() != null && castOther.getCdgrppro() != null && this
				.getCdgrppro().equals(castOther.getCdgrppro())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdgrppro() == null ? 0 : this.getCdgrppro().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		return result;
	}

}

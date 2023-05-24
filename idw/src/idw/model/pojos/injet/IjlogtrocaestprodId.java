package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjlogtrocaestprodId generated by hbm2java
 */
@Embeddable
public class IjlogtrocaestprodId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8170655141690347391L;
	private String cdproduto;
	private String cdmolde;
	private Date dthrtroca;

	public IjlogtrocaestprodId() {
	}

	public IjlogtrocaestprodId(String cdproduto, String cdmolde, Date dthrtroca) {
		this.cdproduto = cdproduto;
		this.cdmolde = cdmolde;
		this.dthrtroca = dthrtroca;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "DTHRTROCA", nullable = false, length = 7)
	public Date getDthrtroca() {
		return this.dthrtroca;
	}

	public void setDthrtroca(Date dthrtroca) {
		this.dthrtroca = dthrtroca;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjlogtrocaestprodId))
			return false;
		IjlogtrocaestprodId castOther = (IjlogtrocaestprodId) other;

		return ((this.getCdproduto() == castOther.getCdproduto()) || (this
				.getCdproduto() != null && castOther.getCdproduto() != null && this
				.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getDthrtroca() == castOther.getDthrtroca()) || (this
						.getDthrtroca() != null
						&& castOther.getDthrtroca() != null && this
						.getDthrtroca().equals(castOther.getDthrtroca())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37 * result
				+ (getDthrtroca() == null ? 0 : this.getDthrtroca().hashCode());
		return result;
	}

}
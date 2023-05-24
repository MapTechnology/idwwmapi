package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjproxgrcarcrtctrlId generated by hbm2java
 */
@Embeddable
public class IjproxgrcarcrtctrlId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5565951129637388740L;
	private String cdproduto;
	private String cdgrproctrctrl;

	public IjproxgrcarcrtctrlId() {
	}

	public IjproxgrcarcrtctrlId(String cdproduto, String cdgrproctrctrl) {
		this.cdproduto = cdproduto;
		this.cdgrproctrctrl = cdgrproctrctrl;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDGRPROCTRCTRL", nullable = false, length = 6)
	public String getCdgrproctrctrl() {
		return this.cdgrproctrctrl;
	}

	public void setCdgrproctrctrl(String cdgrproctrctrl) {
		this.cdgrproctrctrl = cdgrproctrctrl;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjproxgrcarcrtctrlId))
			return false;
		IjproxgrcarcrtctrlId castOther = (IjproxgrcarcrtctrlId) other;

		return ((this.getCdproduto() == castOther.getCdproduto()) || (this
				.getCdproduto() != null && castOther.getCdproduto() != null && this
				.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getCdgrproctrctrl() == castOther.getCdgrproctrctrl()) || (this
						.getCdgrproctrctrl() != null
						&& castOther.getCdgrproctrctrl() != null && this
						.getCdgrproctrctrl().equals(
								castOther.getCdgrproctrctrl())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37
				* result
				+ (getCdgrproctrctrl() == null ? 0 : this.getCdgrproctrctrl()
						.hashCode());
		return result;
	}

}

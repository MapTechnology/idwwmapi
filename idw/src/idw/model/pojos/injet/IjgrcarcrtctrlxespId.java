package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgrcarcrtctrlxespId generated by hbm2java
 */
@Embeddable
public class IjgrcarcrtctrlxespId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 361073153395670573L;
	private String cdgrproctrctrl;
	private String idespecific;

	public IjgrcarcrtctrlxespId() {
	}

	public IjgrcarcrtctrlxespId(String cdgrproctrctrl, String idespecific) {
		this.cdgrproctrctrl = cdgrproctrctrl;
		this.idespecific = idespecific;
	}

	@Column(name = "CDGRPROCTRCTRL", nullable = false, length = 6)
	public String getCdgrproctrctrl() {
		return this.cdgrproctrctrl;
	}

	public void setCdgrproctrctrl(String cdgrproctrctrl) {
		this.cdgrproctrctrl = cdgrproctrctrl;
	}

	@Column(name = "IDESPECIFIC", nullable = false, length = 20)
	public String getIdespecific() {
		return this.idespecific;
	}

	public void setIdespecific(String idespecific) {
		this.idespecific = idespecific;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgrcarcrtctrlxespId))
			return false;
		IjgrcarcrtctrlxespId castOther = (IjgrcarcrtctrlxespId) other;

		return ((this.getCdgrproctrctrl() == castOther.getCdgrproctrctrl()) || (this
				.getCdgrproctrctrl() != null
				&& castOther.getCdgrproctrctrl() != null && this
				.getCdgrproctrctrl().equals(castOther.getCdgrproctrctrl())))
				&& ((this.getIdespecific() == castOther.getIdespecific()) || (this
						.getIdespecific() != null
						&& castOther.getIdespecific() != null && this
						.getIdespecific().equals(castOther.getIdespecific())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdgrproctrctrl() == null ? 0 : this.getCdgrproctrctrl()
						.hashCode());
		result = 37
				* result
				+ (getIdespecific() == null ? 0 : this.getIdespecific()
						.hashCode());
		return result;
	}

}

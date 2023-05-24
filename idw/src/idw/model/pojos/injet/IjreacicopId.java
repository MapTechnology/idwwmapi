package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjreacicopId generated by hbm2java
 */
@Embeddable
public class IjreacicopId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 456840007645349648L;
	private String nrop;
	private Date dthriciclo;

	public IjreacicopId() {
	}

	public IjreacicopId(String nrop, Date dthriciclo) {
		this.nrop = nrop;
		this.dthriciclo = dthriciclo;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "DTHRICICLO", nullable = false, length = 7)
	public Date getDthriciclo() {
		return this.dthriciclo;
	}

	public void setDthriciclo(Date dthriciclo) {
		this.dthriciclo = dthriciclo;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjreacicopId))
			return false;
		IjreacicopId castOther = (IjreacicopId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getDthriciclo() == castOther.getDthriciclo()) || (this
						.getDthriciclo() != null
						&& castOther.getDthriciclo() != null && this
						.getDthriciclo().equals(castOther.getDthriciclo())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37
				* result
				+ (getDthriciclo() == null ? 0 : this.getDthriciclo()
						.hashCode());
		return result;
	}

}

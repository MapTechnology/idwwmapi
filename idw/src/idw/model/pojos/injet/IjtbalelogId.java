package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbalelogId generated by hbm2java
 */
@Embeddable
public class IjtbalelogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5909422355262134708L;
	private String cdalerta;
	private String dsalerta;
	private Date dthrmanut;
	private String tpmanut;
	private String cdusuresp;

	public IjtbalelogId() {
	}

	public IjtbalelogId(String cdalerta, Date dthrmanut, String tpmanut,
			String cdusuresp) {
		this.cdalerta = cdalerta;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjtbalelogId(String cdalerta, String dsalerta, Date dthrmanut,
			String tpmanut, String cdusuresp) {
		this.cdalerta = cdalerta;
		this.dsalerta = dsalerta;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "CDALERTA", nullable = false, length = 6)
	public String getCdalerta() {
		return this.cdalerta;
	}

	public void setCdalerta(String cdalerta) {
		this.cdalerta = cdalerta;
	}

	@Column(name = "DSALERTA", length = 40)
	public String getDsalerta() {
		return this.dsalerta;
	}

	public void setDsalerta(String dsalerta) {
		this.dsalerta = dsalerta;
	}

	@Column(name = "DTHRMANUT", nullable = false, length = 7)
	public Date getDthrmanut() {
		return this.dthrmanut;
	}

	public void setDthrmanut(Date dthrmanut) {
		this.dthrmanut = dthrmanut;
	}

	@Column(name = "TPMANUT", nullable = false, length = 20)
	public String getTpmanut() {
		return this.tpmanut;
	}

	public void setTpmanut(String tpmanut) {
		this.tpmanut = tpmanut;
	}

	@Column(name = "CDUSURESP", nullable = false, length = 6)
	public String getCdusuresp() {
		return this.cdusuresp;
	}

	public void setCdusuresp(String cdusuresp) {
		this.cdusuresp = cdusuresp;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbalelogId))
			return false;
		IjtbalelogId castOther = (IjtbalelogId) other;

		return ((this.getCdalerta() == castOther.getCdalerta()) || (this
				.getCdalerta() != null && castOther.getCdalerta() != null && this
				.getCdalerta().equals(castOther.getCdalerta())))
				&& ((this.getDsalerta() == castOther.getDsalerta()) || (this
						.getDsalerta() != null
						&& castOther.getDsalerta() != null && this
						.getDsalerta().equals(castOther.getDsalerta())))
				&& ((this.getDthrmanut() == castOther.getDthrmanut()) || (this
						.getDthrmanut() != null
						&& castOther.getDthrmanut() != null && this
						.getDthrmanut().equals(castOther.getDthrmanut())))
				&& ((this.getTpmanut() == castOther.getTpmanut()) || (this
						.getTpmanut() != null && castOther.getTpmanut() != null && this
						.getTpmanut().equals(castOther.getTpmanut())))
				&& ((this.getCdusuresp() == castOther.getCdusuresp()) || (this
						.getCdusuresp() != null
						&& castOther.getCdusuresp() != null && this
						.getCdusuresp().equals(castOther.getCdusuresp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdalerta() == null ? 0 : this.getCdalerta().hashCode());
		result = 37 * result
				+ (getDsalerta() == null ? 0 : this.getDsalerta().hashCode());
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result
				+ (getTpmanut() == null ? 0 : this.getTpmanut().hashCode());
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}

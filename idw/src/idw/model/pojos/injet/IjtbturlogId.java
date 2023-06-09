package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbturlogId generated by hbm2java
 */
@Embeddable
public class IjtbturlogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6163321730316809958L;
	private String cdturno;
	private String dsturno;
	private Date dthrmanut;
	private char tpmanut;
	private String cdusuresp;

	public IjtbturlogId() {
	}

	public IjtbturlogId(String cdturno, Date dthrmanut, char tpmanut,
			String cdusuresp) {
		this.cdturno = cdturno;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjtbturlogId(String cdturno, String dsturno, Date dthrmanut,
			char tpmanut, String cdusuresp) {
		this.cdturno = cdturno;
		this.dsturno = dsturno;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "CDTURNO", nullable = false, length = 6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "DSTURNO", length = 20)
	public String getDsturno() {
		return this.dsturno;
	}

	public void setDsturno(String dsturno) {
		this.dsturno = dsturno;
	}

	@Column(name = "DTHRMANUT", nullable = false, length = 7)
	public Date getDthrmanut() {
		return this.dthrmanut;
	}

	public void setDthrmanut(Date dthrmanut) {
		this.dthrmanut = dthrmanut;
	}

	@Column(name = "TPMANUT", nullable = false, length = 1)
	public char getTpmanut() {
		return this.tpmanut;
	}

	public void setTpmanut(char tpmanut) {
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
		if (!(other instanceof IjtbturlogId))
			return false;
		IjtbturlogId castOther = (IjtbturlogId) other;

		return ((this.getCdturno() == castOther.getCdturno()) || (this
				.getCdturno() != null && castOther.getCdturno() != null && this
				.getCdturno().equals(castOther.getCdturno())))
				&& ((this.getDsturno() == castOther.getDsturno()) || (this
						.getDsturno() != null && castOther.getDsturno() != null && this
						.getDsturno().equals(castOther.getDsturno())))
				&& ((this.getDthrmanut() == castOther.getDthrmanut()) || (this
						.getDthrmanut() != null
						&& castOther.getDthrmanut() != null && this
						.getDthrmanut().equals(castOther.getDthrmanut())))
				&& (this.getTpmanut() == castOther.getTpmanut())
				&& ((this.getCdusuresp() == castOther.getCdusuresp()) || (this
						.getCdusuresp() != null
						&& castOther.getCdusuresp() != null && this
						.getCdusuresp().equals(castOther.getCdusuresp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdturno() == null ? 0 : this.getCdturno().hashCode());
		result = 37 * result
				+ (getDsturno() == null ? 0 : this.getDsturno().hashCode());
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result + this.getTpmanut();
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbjuplogId generated by hbm2java
 */
@Embeddable
public class IjtbjuplogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3318947751354709647L;
	private String cdjustparada;
	private String dsjustparada;
	private BigDecimal stativo;
	private Date dthrmanut;
	private char tpmanut;
	private String cdusuresp;

	public IjtbjuplogId() {
	}

	public IjtbjuplogId(String cdjustparada, BigDecimal stativo,
			Date dthrmanut, char tpmanut, String cdusuresp) {
		this.cdjustparada = cdjustparada;
		this.stativo = stativo;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjtbjuplogId(String cdjustparada, String dsjustparada,
			BigDecimal stativo, Date dthrmanut, char tpmanut, String cdusuresp) {
		this.cdjustparada = cdjustparada;
		this.dsjustparada = dsjustparada;
		this.stativo = stativo;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "CDJUSTPARADA", nullable = false, length = 6)
	public String getCdjustparada() {
		return this.cdjustparada;
	}

	public void setCdjustparada(String cdjustparada) {
		this.cdjustparada = cdjustparada;
	}

	@Column(name = "DSJUSTPARADA", length = 40)
	public String getDsjustparada() {
		return this.dsjustparada;
	}

	public void setDsjustparada(String dsjustparada) {
		this.dsjustparada = dsjustparada;
	}

	@Column(name = "STATIVO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStativo() {
		return this.stativo;
	}

	public void setStativo(BigDecimal stativo) {
		this.stativo = stativo;
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
		if (!(other instanceof IjtbjuplogId))
			return false;
		IjtbjuplogId castOther = (IjtbjuplogId) other;

		return ((this.getCdjustparada() == castOther.getCdjustparada()) || (this
				.getCdjustparada() != null
				&& castOther.getCdjustparada() != null && this
				.getCdjustparada().equals(castOther.getCdjustparada())))
				&& ((this.getDsjustparada() == castOther.getDsjustparada()) || (this
						.getDsjustparada() != null
						&& castOther.getDsjustparada() != null && this
						.getDsjustparada().equals(castOther.getDsjustparada())))
				&& ((this.getStativo() == castOther.getStativo()) || (this
						.getStativo() != null && castOther.getStativo() != null && this
						.getStativo().equals(castOther.getStativo())))
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

		result = 37
				* result
				+ (getCdjustparada() == null ? 0 : this.getCdjustparada()
						.hashCode());
		result = 37
				* result
				+ (getDsjustparada() == null ? 0 : this.getDsjustparada()
						.hashCode());
		result = 37 * result
				+ (getStativo() == null ? 0 : this.getStativo().hashCode());
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result + this.getTpmanut();
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}
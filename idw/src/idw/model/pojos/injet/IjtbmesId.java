package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbmesId generated by hbm2java
 */
@Embeddable
public class IjtbmesId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5415666937297945153L;
	private BigDecimal cdmes;
	private String cdlingua;

	public IjtbmesId() {
	}

	public IjtbmesId(BigDecimal cdmes, String cdlingua) {
		this.cdmes = cdmes;
		this.cdlingua = cdlingua;
	}

	@Column(name = "CDMES", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCdmes() {
		return this.cdmes;
	}

	public void setCdmes(BigDecimal cdmes) {
		this.cdmes = cdmes;
	}

	@Column(name = "CDLINGUA", nullable = false, length = 6)
	public String getCdlingua() {
		return this.cdlingua;
	}

	public void setCdlingua(String cdlingua) {
		this.cdlingua = cdlingua;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbmesId))
			return false;
		IjtbmesId castOther = (IjtbmesId) other;

		return ((this.getCdmes() == castOther.getCdmes()) || (this.getCdmes() != null
				&& castOther.getCdmes() != null && this.getCdmes().equals(
				castOther.getCdmes())))
				&& ((this.getCdlingua() == castOther.getCdlingua()) || (this
						.getCdlingua() != null
						&& castOther.getCdlingua() != null && this
						.getCdlingua().equals(castOther.getCdlingua())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmes() == null ? 0 : this.getCdmes().hashCode());
		result = 37 * result
				+ (getCdlingua() == null ? 0 : this.getCdlingua().hashCode());
		return result;
	}

}

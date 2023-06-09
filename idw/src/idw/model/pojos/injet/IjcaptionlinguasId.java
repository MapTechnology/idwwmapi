package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcaptionlinguasId generated by hbm2java
 */
@Embeddable
public class IjcaptionlinguasId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8202766684347700516L;
	private String cdmodulo;
	private String cdlingua;
	private String formname;
	private String controlname;
	private BigDecimal indice;

	public IjcaptionlinguasId() {
	}

	public IjcaptionlinguasId(String cdmodulo, String cdlingua,
			String formname, String controlname, BigDecimal indice) {
		this.cdmodulo = cdmodulo;
		this.cdlingua = cdlingua;
		this.formname = formname;
		this.controlname = controlname;
		this.indice = indice;
	}

	@Column(name = "CDMODULO", nullable = false, length = 6)
	public String getCdmodulo() {
		return this.cdmodulo;
	}

	public void setCdmodulo(String cdmodulo) {
		this.cdmodulo = cdmodulo;
	}

	@Column(name = "CDLINGUA", nullable = false, length = 6)
	public String getCdlingua() {
		return this.cdlingua;
	}

	public void setCdlingua(String cdlingua) {
		this.cdlingua = cdlingua;
	}

	@Column(name = "FORMNAME", nullable = false, length = 50)
	public String getFormname() {
		return this.formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	@Column(name = "CONTROLNAME", nullable = false, length = 50)
	public String getControlname() {
		return this.controlname;
	}

	public void setControlname(String controlname) {
		this.controlname = controlname;
	}

	@Column(name = "INDICE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIndice() {
		return this.indice;
	}

	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcaptionlinguasId))
			return false;
		IjcaptionlinguasId castOther = (IjcaptionlinguasId) other;

		return ((this.getCdmodulo() == castOther.getCdmodulo()) || (this
				.getCdmodulo() != null && castOther.getCdmodulo() != null && this
				.getCdmodulo().equals(castOther.getCdmodulo())))
				&& ((this.getCdlingua() == castOther.getCdlingua()) || (this
						.getCdlingua() != null
						&& castOther.getCdlingua() != null && this
						.getCdlingua().equals(castOther.getCdlingua())))
				&& ((this.getFormname() == castOther.getFormname()) || (this
						.getFormname() != null
						&& castOther.getFormname() != null && this
						.getFormname().equals(castOther.getFormname())))
				&& ((this.getControlname() == castOther.getControlname()) || (this
						.getControlname() != null
						&& castOther.getControlname() != null && this
						.getControlname().equals(castOther.getControlname())))
				&& ((this.getIndice() == castOther.getIndice()) || (this
						.getIndice() != null && castOther.getIndice() != null && this
						.getIndice().equals(castOther.getIndice())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmodulo() == null ? 0 : this.getCdmodulo().hashCode());
		result = 37 * result
				+ (getCdlingua() == null ? 0 : this.getCdlingua().hashCode());
		result = 37 * result
				+ (getFormname() == null ? 0 : this.getFormname().hashCode());
		result = 37
				* result
				+ (getControlname() == null ? 0 : this.getControlname()
						.hashCode());
		result = 37 * result
				+ (getIndice() == null ? 0 : this.getIndice().hashCode());
		return result;
	}

}

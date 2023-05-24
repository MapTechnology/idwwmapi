package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjacumprodId generated by hbm2java
 */
@Embeddable
public class IjacumprodId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 260963495369902571L;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalestru;
	private String nrop;
	private Date dthriacumprod;
	private Date dthrfacumprod;
	private Double qtinjnormal;
	private Double qtinjparada;
	private Double qtinjnaparada;
	private Double somatmpcicnormal;
	private Double somatmpcicparada;
	private Double somatmpcicnaparada;
	private Double somatmpsininjalto;
	private Double somatmpmolabe;

	public IjacumprodId() {
	}

	public IjacumprodId(String cdinjetora, String cdmolde, String cdestrutura,
			Date dthrivalestru, String nrop, Date dthriacumprod,
			Date dthrfacumprod, Double qtinjnormal, Double qtinjparada,
			Double qtinjnaparada, Double somatmpcicnormal,
			Double somatmpcicparada, Double somatmpcicnaparada,
			Double somatmpsininjalto, Double somatmpmolabe) {
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.nrop = nrop;
		this.dthriacumprod = dthriacumprod;
		this.dthrfacumprod = dthrfacumprod;
		this.qtinjnormal = qtinjnormal;
		this.qtinjparada = qtinjparada;
		this.qtinjnaparada = qtinjnaparada;
		this.somatmpcicnormal = somatmpcicnormal;
		this.somatmpcicparada = somatmpcicparada;
		this.somatmpcicnaparada = somatmpcicnaparada;
		this.somatmpsininjalto = somatmpsininjalto;
		this.somatmpmolabe = somatmpmolabe;
	}

	@Column(name = "CDINJETORA", length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDMOLDE", length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Column(name = "DTHRIVALESTRU", length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Column(name = "NROP", length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "DTHRIACUMPROD", length = 7)
	public Date getDthriacumprod() {
		return this.dthriacumprod;
	}

	public void setDthriacumprod(Date dthriacumprod) {
		this.dthriacumprod = dthriacumprod;
	}

	@Column(name = "DTHRFACUMPROD", length = 7)
	public Date getDthrfacumprod() {
		return this.dthrfacumprod;
	}

	public void setDthrfacumprod(Date dthrfacumprod) {
		this.dthrfacumprod = dthrfacumprod;
	}

	@Column(name = "QTINJNORMAL", precision = 126, scale = 0)
	public Double getQtinjnormal() {
		return this.qtinjnormal;
	}

	public void setQtinjnormal(Double qtinjnormal) {
		this.qtinjnormal = qtinjnormal;
	}

	@Column(name = "QTINJPARADA", precision = 126, scale = 0)
	public Double getQtinjparada() {
		return this.qtinjparada;
	}

	public void setQtinjparada(Double qtinjparada) {
		this.qtinjparada = qtinjparada;
	}

	@Column(name = "QTINJNAPARADA", precision = 126, scale = 0)
	public Double getQtinjnaparada() {
		return this.qtinjnaparada;
	}

	public void setQtinjnaparada(Double qtinjnaparada) {
		this.qtinjnaparada = qtinjnaparada;
	}

	@Column(name = "SOMATMPCICNORMAL", precision = 126, scale = 0)
	public Double getSomatmpcicnormal() {
		return this.somatmpcicnormal;
	}

	public void setSomatmpcicnormal(Double somatmpcicnormal) {
		this.somatmpcicnormal = somatmpcicnormal;
	}

	@Column(name = "SOMATMPCICPARADA", precision = 126, scale = 0)
	public Double getSomatmpcicparada() {
		return this.somatmpcicparada;
	}

	public void setSomatmpcicparada(Double somatmpcicparada) {
		this.somatmpcicparada = somatmpcicparada;
	}

	@Column(name = "SOMATMPCICNAPARADA", precision = 126, scale = 0)
	public Double getSomatmpcicnaparada() {
		return this.somatmpcicnaparada;
	}

	public void setSomatmpcicnaparada(Double somatmpcicnaparada) {
		this.somatmpcicnaparada = somatmpcicnaparada;
	}

	@Column(name = "SOMATMPSININJALTO", precision = 126, scale = 0)
	public Double getSomatmpsininjalto() {
		return this.somatmpsininjalto;
	}

	public void setSomatmpsininjalto(Double somatmpsininjalto) {
		this.somatmpsininjalto = somatmpsininjalto;
	}

	@Column(name = "SOMATMPMOLABE", precision = 126, scale = 0)
	public Double getSomatmpmolabe() {
		return this.somatmpmolabe;
	}

	public void setSomatmpmolabe(Double somatmpmolabe) {
		this.somatmpmolabe = somatmpmolabe;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjacumprodId))
			return false;
		IjacumprodId castOther = (IjacumprodId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getDthrivalestru() == castOther.getDthrivalestru()) || (this
						.getDthrivalestru() != null
						&& castOther.getDthrivalestru() != null && this
						.getDthrivalestru()
						.equals(castOther.getDthrivalestru())))
				&& ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
						&& castOther.getNrop() != null && this.getNrop()
						.equals(castOther.getNrop())))
				&& ((this.getDthriacumprod() == castOther.getDthriacumprod()) || (this
						.getDthriacumprod() != null
						&& castOther.getDthriacumprod() != null && this
						.getDthriacumprod()
						.equals(castOther.getDthriacumprod())))
				&& ((this.getDthrfacumprod() == castOther.getDthrfacumprod()) || (this
						.getDthrfacumprod() != null
						&& castOther.getDthrfacumprod() != null && this
						.getDthrfacumprod()
						.equals(castOther.getDthrfacumprod())))
				&& ((this.getQtinjnormal() == castOther.getQtinjnormal()) || (this
						.getQtinjnormal() != null
						&& castOther.getQtinjnormal() != null && this
						.getQtinjnormal().equals(castOther.getQtinjnormal())))
				&& ((this.getQtinjparada() == castOther.getQtinjparada()) || (this
						.getQtinjparada() != null
						&& castOther.getQtinjparada() != null && this
						.getQtinjparada().equals(castOther.getQtinjparada())))
				&& ((this.getQtinjnaparada() == castOther.getQtinjnaparada()) || (this
						.getQtinjnaparada() != null
						&& castOther.getQtinjnaparada() != null && this
						.getQtinjnaparada()
						.equals(castOther.getQtinjnaparada())))
				&& ((this.getSomatmpcicnormal() == castOther
						.getSomatmpcicnormal()) || (this.getSomatmpcicnormal() != null
						&& castOther.getSomatmpcicnormal() != null && this
						.getSomatmpcicnormal().equals(
								castOther.getSomatmpcicnormal())))
				&& ((this.getSomatmpcicparada() == castOther
						.getSomatmpcicparada()) || (this.getSomatmpcicparada() != null
						&& castOther.getSomatmpcicparada() != null && this
						.getSomatmpcicparada().equals(
								castOther.getSomatmpcicparada())))
				&& ((this.getSomatmpcicnaparada() == castOther
						.getSomatmpcicnaparada()) || (this
						.getSomatmpcicnaparada() != null
						&& castOther.getSomatmpcicnaparada() != null && this
						.getSomatmpcicnaparada().equals(
								castOther.getSomatmpcicnaparada())))
				&& ((this.getSomatmpsininjalto() == castOther
						.getSomatmpsininjalto()) || (this
						.getSomatmpsininjalto() != null
						&& castOther.getSomatmpsininjalto() != null && this
						.getSomatmpsininjalto().equals(
								castOther.getSomatmpsininjalto())))
				&& ((this.getSomatmpmolabe() == castOther.getSomatmpmolabe()) || (this
						.getSomatmpmolabe() != null
						&& castOther.getSomatmpmolabe() != null && this
						.getSomatmpmolabe()
						.equals(castOther.getSomatmpmolabe())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37
				* result
				+ (getCdestrutura() == null ? 0 : this.getCdestrutura()
						.hashCode());
		result = 37
				* result
				+ (getDthrivalestru() == null ? 0 : this.getDthrivalestru()
						.hashCode());
		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37
				* result
				+ (getDthriacumprod() == null ? 0 : this.getDthriacumprod()
						.hashCode());
		result = 37
				* result
				+ (getDthrfacumprod() == null ? 0 : this.getDthrfacumprod()
						.hashCode());
		result = 37
				* result
				+ (getQtinjnormal() == null ? 0 : this.getQtinjnormal()
						.hashCode());
		result = 37
				* result
				+ (getQtinjparada() == null ? 0 : this.getQtinjparada()
						.hashCode());
		result = 37
				* result
				+ (getQtinjnaparada() == null ? 0 : this.getQtinjnaparada()
						.hashCode());
		result = 37
				* result
				+ (getSomatmpcicnormal() == null ? 0 : this
						.getSomatmpcicnormal().hashCode());
		result = 37
				* result
				+ (getSomatmpcicparada() == null ? 0 : this
						.getSomatmpcicparada().hashCode());
		result = 37
				* result
				+ (getSomatmpcicnaparada() == null ? 0 : this
						.getSomatmpcicnaparada().hashCode());
		result = 37
				* result
				+ (getSomatmpsininjalto() == null ? 0 : this
						.getSomatmpsininjalto().hashCode());
		result = 37
				* result
				+ (getSomatmpmolabe() == null ? 0 : this.getSomatmpmolabe()
						.hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjacumparId generated by hbm2java
 */
@Embeddable
public class IjacumparId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268711220617355667L;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalestru;
	private String nrop;
	private Date dthriacumpar;
	private Date dthrfacumpar;
	private Double tempoparada;

	public IjacumparId() {
	}

	public IjacumparId(String cdinjetora, String cdmolde, String cdestrutura,
			Date dthrivalestru, String nrop, Date dthriacumpar,
			Date dthrfacumpar, Double tempoparada) {
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.nrop = nrop;
		this.dthriacumpar = dthriacumpar;
		this.dthrfacumpar = dthrfacumpar;
		this.tempoparada = tempoparada;
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

	@Column(name = "DTHRIACUMPAR", length = 7)
	public Date getDthriacumpar() {
		return this.dthriacumpar;
	}

	public void setDthriacumpar(Date dthriacumpar) {
		this.dthriacumpar = dthriacumpar;
	}

	@Column(name = "DTHRFACUMPAR", length = 7)
	public Date getDthrfacumpar() {
		return this.dthrfacumpar;
	}

	public void setDthrfacumpar(Date dthrfacumpar) {
		this.dthrfacumpar = dthrfacumpar;
	}

	@Column(name = "TEMPOPARADA", precision = 126, scale = 0)
	public Double getTempoparada() {
		return this.tempoparada;
	}

	public void setTempoparada(Double tempoparada) {
		this.tempoparada = tempoparada;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjacumparId))
			return false;
		IjacumparId castOther = (IjacumparId) other;

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
				&& ((this.getDthriacumpar() == castOther.getDthriacumpar()) || (this
						.getDthriacumpar() != null
						&& castOther.getDthriacumpar() != null && this
						.getDthriacumpar().equals(castOther.getDthriacumpar())))
				&& ((this.getDthrfacumpar() == castOther.getDthrfacumpar()) || (this
						.getDthrfacumpar() != null
						&& castOther.getDthrfacumpar() != null && this
						.getDthrfacumpar().equals(castOther.getDthrfacumpar())))
				&& ((this.getTempoparada() == castOther.getTempoparada()) || (this
						.getTempoparada() != null
						&& castOther.getTempoparada() != null && this
						.getTempoparada().equals(castOther.getTempoparada())));
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
				+ (getDthriacumpar() == null ? 0 : this.getDthriacumpar()
						.hashCode());
		result = 37
				* result
				+ (getDthrfacumpar() == null ? 0 : this.getDthrfacumpar()
						.hashCode());
		result = 37
				* result
				+ (getTempoparada() == null ? 0 : this.getTempoparada()
						.hashCode());
		return result;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcnsutdetrefavId generated by hbm2java
 */
@Embeddable
public class IjcnsutdetrefavId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658790588614517583L;
	private Date dthriniintervalo;
	private String cdinjetora;
	private String nrop;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalestru;
	private Date dthrivalcic;
	private char cdidentificacao;

	public IjcnsutdetrefavId() {
	}

	public IjcnsutdetrefavId(Date dthriniintervalo, String cdinjetora,
			String nrop, String cdmolde, String cdestrutura,
			Date dthrivalestru, Date dthrivalcic, char cdidentificacao) {
		this.dthriniintervalo = dthriniintervalo;
		this.cdinjetora = cdinjetora;
		this.nrop = nrop;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalestru = dthrivalestru;
		this.dthrivalcic = dthrivalcic;
		this.cdidentificacao = cdidentificacao;
	}

	@Column(name = "DTHRINIINTERVALO", nullable = false, length = 7)
	public Date getDthriniintervalo() {
		return this.dthriniintervalo;
	}

	public void setDthriniintervalo(Date dthriniintervalo) {
		this.dthriniintervalo = dthriniintervalo;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", nullable = false, length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Column(name = "DTHRIVALESTRU", nullable = false, length = 7)
	public Date getDthrivalestru() {
		return this.dthrivalestru;
	}

	public void setDthrivalestru(Date dthrivalestru) {
		this.dthrivalestru = dthrivalestru;
	}

	@Column(name = "DTHRIVALCIC", nullable = false, length = 7)
	public Date getDthrivalcic() {
		return this.dthrivalcic;
	}

	public void setDthrivalcic(Date dthrivalcic) {
		this.dthrivalcic = dthrivalcic;
	}

	@Column(name = "CDIDENTIFICACAO", nullable = false, length = 1)
	public char getCdidentificacao() {
		return this.cdidentificacao;
	}

	public void setCdidentificacao(char cdidentificacao) {
		this.cdidentificacao = cdidentificacao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcnsutdetrefavId))
			return false;
		IjcnsutdetrefavId castOther = (IjcnsutdetrefavId) other;

		return ((this.getDthriniintervalo() == castOther.getDthriniintervalo()) || (this
				.getDthriniintervalo() != null
				&& castOther.getDthriniintervalo() != null && this
				.getDthriniintervalo().equals(castOther.getDthriniintervalo())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
						&& castOther.getNrop() != null && this.getNrop()
						.equals(castOther.getNrop())))
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
				&& ((this.getDthrivalcic() == castOther.getDthrivalcic()) || (this
						.getDthrivalcic() != null
						&& castOther.getDthrivalcic() != null && this
						.getDthrivalcic().equals(castOther.getDthrivalcic())))
				&& (this.getCdidentificacao() == castOther.getCdidentificacao());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDthriniintervalo() == null ? 0 : this
						.getDthriniintervalo().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
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
		result = 37
				* result
				+ (getDthrivalcic() == null ? 0 : this.getDthrivalcic()
						.hashCode());
		result = 37 * result + this.getCdidentificacao();
		return result;
	}

}

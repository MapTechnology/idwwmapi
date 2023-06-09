package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IjfictecId generated by hbm2java
 */
@Embeddable
public class IjfictecId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7951244051511366031L;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrivalcic;

	public IjfictecId() {
	}

	public IjfictecId(String cdinjetora, String cdmolde, String cdestrutura,
			Date dthrivalcic) {
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrivalcic = dthrivalcic;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRIVALCIC", nullable = false, length = 7)
	public Date getDthrivalcic() {
		return this.dthrivalcic;
	}

	public void setDthrivalcic(Date dthrivalcic) {
		this.dthrivalcic = dthrivalcic;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfictecId))
			return false;
		IjfictecId castOther = (IjfictecId) other;

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
				&& ((this.getDthrivalcic() == castOther.getDthrivalcic()) || (this
						.getDthrivalcic() != null
						&& castOther.getDthrivalcic() != null && this
						.getDthrivalcic().equals(castOther.getDthrivalcic())));
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
				+ (getDthrivalcic() == null ? 0 : this.getDthrivalcic()
						.hashCode());
		return result;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CavidadesId generated by hbm2java
 */
@Embeddable
public class CavidadesId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223077280917092111L;
	private String cdmolde;
	private String cdestrutura;
	private Date dthrival;
	private BigDecimal cavtotais;
	private BigDecimal cavativas;

	public CavidadesId() {
	}

	public CavidadesId(String cdmolde, String cdestrutura, Date dthrival) {
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrival = dthrival;
	}

	public CavidadesId(String cdmolde, String cdestrutura, Date dthrival,
			BigDecimal cavtotais, BigDecimal cavativas) {
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthrival = dthrival;
		this.cavtotais = cavtotais;
		this.cavativas = cavativas;
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

	@Column(name = "DTHRIVAL", nullable = false, length = 7)
	public Date getDthrival() {
		return this.dthrival;
	}

	public void setDthrival(Date dthrival) {
		this.dthrival = dthrival;
	}

	@Column(name = "CAVTOTAIS", precision = 22, scale = 0)
	public BigDecimal getCavtotais() {
		return this.cavtotais;
	}

	public void setCavtotais(BigDecimal cavtotais) {
		this.cavtotais = cavtotais;
	}

	@Column(name = "CAVATIVAS", precision = 22, scale = 0)
	public BigDecimal getCavativas() {
		return this.cavativas;
	}

	public void setCavativas(BigDecimal cavativas) {
		this.cavativas = cavativas;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CavidadesId))
			return false;
		CavidadesId castOther = (CavidadesId) other;

		return ((this.getCdmolde() == castOther.getCdmolde()) || (this
				.getCdmolde() != null && castOther.getCdmolde() != null && this
				.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getDthrival() == castOther.getDthrival()) || (this
						.getDthrival() != null
						&& castOther.getDthrival() != null && this
						.getDthrival().equals(castOther.getDthrival())))
				&& ((this.getCavtotais() == castOther.getCavtotais()) || (this
						.getCavtotais() != null
						&& castOther.getCavtotais() != null && this
						.getCavtotais().equals(castOther.getCavtotais())))
				&& ((this.getCavativas() == castOther.getCavativas()) || (this
						.getCavativas() != null
						&& castOther.getCavativas() != null && this
						.getCavativas().equals(castOther.getCavativas())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37
				* result
				+ (getCdestrutura() == null ? 0 : this.getCdestrutura()
						.hashCode());
		result = 37 * result
				+ (getDthrival() == null ? 0 : this.getDthrival().hashCode());
		result = 37 * result
				+ (getCavtotais() == null ? 0 : this.getCavtotais().hashCode());
		result = 37 * result
				+ (getCavativas() == null ? 0 : this.getCavativas().hashCode());
		return result;
	}

}
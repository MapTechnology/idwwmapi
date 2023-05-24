package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjcelxmaqId generated by hbm2java
 */
@Embeddable
public class IjcelxmaqId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7428719708349384347L;
	private String cdcelula;
	private BigDecimal estagio;
	private String cdinjetora;
	private String cdmaqdestino;

	public IjcelxmaqId() {
	}

	public IjcelxmaqId(String cdcelula, BigDecimal estagio, String cdinjetora,
			String cdmaqdestino) {
		this.cdcelula = cdcelula;
		this.estagio = estagio;
		this.cdinjetora = cdinjetora;
		this.cdmaqdestino = cdmaqdestino;
	}

	@Column(name = "CDCELULA", nullable = false, length = 6)
	public String getCdcelula() {
		return this.cdcelula;
	}

	public void setCdcelula(String cdcelula) {
		this.cdcelula = cdcelula;
	}

	@Column(name = "ESTAGIO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getEstagio() {
		return this.estagio;
	}

	public void setEstagio(BigDecimal estagio) {
		this.estagio = estagio;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDMAQDESTINO", nullable = false, length = 6)
	public String getCdmaqdestino() {
		return this.cdmaqdestino;
	}

	public void setCdmaqdestino(String cdmaqdestino) {
		this.cdmaqdestino = cdmaqdestino;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjcelxmaqId))
			return false;
		IjcelxmaqId castOther = (IjcelxmaqId) other;

		return ((this.getCdcelula() == castOther.getCdcelula()) || (this
				.getCdcelula() != null && castOther.getCdcelula() != null && this
				.getCdcelula().equals(castOther.getCdcelula())))
				&& ((this.getEstagio() == castOther.getEstagio()) || (this
						.getEstagio() != null && castOther.getEstagio() != null && this
						.getEstagio().equals(castOther.getEstagio())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdmaqdestino() == castOther.getCdmaqdestino()) || (this
						.getCdmaqdestino() != null
						&& castOther.getCdmaqdestino() != null && this
						.getCdmaqdestino().equals(castOther.getCdmaqdestino())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdcelula() == null ? 0 : this.getCdcelula().hashCode());
		result = 37 * result
				+ (getEstagio() == null ? 0 : this.getEstagio().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37
				* result
				+ (getCdmaqdestino() == null ? 0 : this.getCdmaqdestino()
						.hashCode());
		return result;
	}

}

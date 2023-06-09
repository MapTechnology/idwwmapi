package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgalobjmtrzId generated by hbm2java
 */
@Embeddable
public class IjgalobjmtrzId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 581462423718534067L;
	private String cdgalpao;
	private String cdposto;
	private String cdinjetora;
	private BigDecimal coordlinha;
	private BigDecimal coordcoluna;

	public IjgalobjmtrzId() {
	}

	public IjgalobjmtrzId(String cdgalpao, BigDecimal coordlinha,
			BigDecimal coordcoluna) {
		this.cdgalpao = cdgalpao;
		this.coordlinha = coordlinha;
		this.coordcoluna = coordcoluna;
	}

	public IjgalobjmtrzId(String cdgalpao, String cdposto, String cdinjetora,
			BigDecimal coordlinha, BigDecimal coordcoluna) {
		this.cdgalpao = cdgalpao;
		this.cdposto = cdposto;
		this.cdinjetora = cdinjetora;
		this.coordlinha = coordlinha;
		this.coordcoluna = coordcoluna;
	}

	@Column(name = "CDGALPAO", nullable = false, length = 6)
	public String getCdgalpao() {
		return this.cdgalpao;
	}

	public void setCdgalpao(String cdgalpao) {
		this.cdgalpao = cdgalpao;
	}

	@Column(name = "CDPOSTO", length = 6)
	public String getCdposto() {
		return this.cdposto;
	}

	public void setCdposto(String cdposto) {
		this.cdposto = cdposto;
	}

	@Column(name = "CDINJETORA", length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "COORDLINHA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCoordlinha() {
		return this.coordlinha;
	}

	public void setCoordlinha(BigDecimal coordlinha) {
		this.coordlinha = coordlinha;
	}

	@Column(name = "COORDCOLUNA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCoordcoluna() {
		return this.coordcoluna;
	}

	public void setCoordcoluna(BigDecimal coordcoluna) {
		this.coordcoluna = coordcoluna;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgalobjmtrzId))
			return false;
		IjgalobjmtrzId castOther = (IjgalobjmtrzId) other;

		return ((this.getCdgalpao() == castOther.getCdgalpao()) || (this
				.getCdgalpao() != null && castOther.getCdgalpao() != null && this
				.getCdgalpao().equals(castOther.getCdgalpao())))
				&& ((this.getCdposto() == castOther.getCdposto()) || (this
						.getCdposto() != null && castOther.getCdposto() != null && this
						.getCdposto().equals(castOther.getCdposto())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCoordlinha() == castOther.getCoordlinha()) || (this
						.getCoordlinha() != null
						&& castOther.getCoordlinha() != null && this
						.getCoordlinha().equals(castOther.getCoordlinha())))
				&& ((this.getCoordcoluna() == castOther.getCoordcoluna()) || (this
						.getCoordcoluna() != null
						&& castOther.getCoordcoluna() != null && this
						.getCoordcoluna().equals(castOther.getCoordcoluna())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdgalpao() == null ? 0 : this.getCdgalpao().hashCode());
		result = 37 * result
				+ (getCdposto() == null ? 0 : this.getCdposto().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37
				* result
				+ (getCoordlinha() == null ? 0 : this.getCoordlinha()
						.hashCode());
		result = 37
				* result
				+ (getCoordcoluna() == null ? 0 : this.getCoordcoluna()
						.hashCode());
		return result;
	}

}

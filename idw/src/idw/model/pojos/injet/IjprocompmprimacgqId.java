package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjprocompmprimacgqId generated by hbm2java
 */
@Embeddable
public class IjprocompmprimacgqId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2584393503384090516L;
	private String cdproduto;
	private BigDecimal ordem;
	private Date dthrivalcompmprima;

	public IjprocompmprimacgqId() {
	}

	public IjprocompmprimacgqId(String cdproduto, BigDecimal ordem,
			Date dthrivalcompmprima) {
		this.cdproduto = cdproduto;
		this.ordem = ordem;
		this.dthrivalcompmprima = dthrivalcompmprima;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "ORDEM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrdem() {
		return this.ordem;
	}

	public void setOrdem(BigDecimal ordem) {
		this.ordem = ordem;
	}

	@Column(name = "DTHRIVALCOMPMPRIMA", nullable = false, length = 7)
	public Date getDthrivalcompmprima() {
		return this.dthrivalcompmprima;
	}

	public void setDthrivalcompmprima(Date dthrivalcompmprima) {
		this.dthrivalcompmprima = dthrivalcompmprima;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjprocompmprimacgqId))
			return false;
		IjprocompmprimacgqId castOther = (IjprocompmprimacgqId) other;

		return ((this.getCdproduto() == castOther.getCdproduto()) || (this
				.getCdproduto() != null && castOther.getCdproduto() != null && this
				.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getOrdem() == castOther.getOrdem()) || (this
						.getOrdem() != null && castOther.getOrdem() != null && this
						.getOrdem().equals(castOther.getOrdem())))
				&& ((this.getDthrivalcompmprima() == castOther
						.getDthrivalcompmprima()) || (this
						.getDthrivalcompmprima() != null
						&& castOther.getDthrivalcompmprima() != null && this
						.getDthrivalcompmprima().equals(
								castOther.getDthrivalcompmprima())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getOrdem() == null ? 0 : this.getOrdem().hashCode());
		result = 37
				* result
				+ (getDthrivalcompmprima() == null ? 0 : this
						.getDthrivalcompmprima().hashCode());
		return result;
	}

}
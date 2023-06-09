package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjroteiroprodhstId generated by hbm2java
 */
@Embeddable
public class IjroteiroprodhstId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3521737133110620024L;
	private Date dthrivroteiro;
	private String cdproduto;
	private BigDecimal estagio;
	private String cdoperacao;

	public IjroteiroprodhstId() {
	}

	public IjroteiroprodhstId(Date dthrivroteiro, String cdproduto,
			BigDecimal estagio, String cdoperacao) {
		this.dthrivroteiro = dthrivroteiro;
		this.cdproduto = cdproduto;
		this.estagio = estagio;
		this.cdoperacao = cdoperacao;
	}

	@Column(name = "DTHRIVROTEIRO", nullable = false, length = 7)
	public Date getDthrivroteiro() {
		return this.dthrivroteiro;
	}

	public void setDthrivroteiro(Date dthrivroteiro) {
		this.dthrivroteiro = dthrivroteiro;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "ESTAGIO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getEstagio() {
		return this.estagio;
	}

	public void setEstagio(BigDecimal estagio) {
		this.estagio = estagio;
	}

	@Column(name = "CDOPERACAO", nullable = false, length = 6)
	public String getCdoperacao() {
		return this.cdoperacao;
	}

	public void setCdoperacao(String cdoperacao) {
		this.cdoperacao = cdoperacao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjroteiroprodhstId))
			return false;
		IjroteiroprodhstId castOther = (IjroteiroprodhstId) other;

		return ((this.getDthrivroteiro() == castOther.getDthrivroteiro()) || (this
				.getDthrivroteiro() != null
				&& castOther.getDthrivroteiro() != null && this
				.getDthrivroteiro().equals(castOther.getDthrivroteiro())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getEstagio() == castOther.getEstagio()) || (this
						.getEstagio() != null && castOther.getEstagio() != null && this
						.getEstagio().equals(castOther.getEstagio())))
				&& ((this.getCdoperacao() == castOther.getCdoperacao()) || (this
						.getCdoperacao() != null
						&& castOther.getCdoperacao() != null && this
						.getCdoperacao().equals(castOther.getCdoperacao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDthrivroteiro() == null ? 0 : this.getDthrivroteiro()
						.hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getEstagio() == null ? 0 : this.getEstagio().hashCode());
		result = 37
				* result
				+ (getCdoperacao() == null ? 0 : this.getCdoperacao()
						.hashCode());
		return result;
	}

}

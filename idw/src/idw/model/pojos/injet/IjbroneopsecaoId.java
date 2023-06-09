package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjbroneopsecaoId generated by hbm2java
 */
@Embeddable
public class IjbroneopsecaoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2150215720482995876L;
	private double nropsecao;
	private String cdproduto;

	public IjbroneopsecaoId() {
	}

	public IjbroneopsecaoId(double nropsecao, String cdproduto) {
		this.nropsecao = nropsecao;
		this.cdproduto = cdproduto;
	}

	@Column(name = "NROPSECAO", nullable = false, precision = 126, scale = 0)
	public double getNropsecao() {
		return this.nropsecao;
	}

	public void setNropsecao(double nropsecao) {
		this.nropsecao = nropsecao;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjbroneopsecaoId))
			return false;
		IjbroneopsecaoId castOther = (IjbroneopsecaoId) other;

		return (this.getNropsecao() == castOther.getNropsecao())
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getNropsecao();
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		return result;
	}

}

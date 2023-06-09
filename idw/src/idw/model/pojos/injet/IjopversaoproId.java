package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjopversaoproId generated by hbm2java
 */
@Embeddable
public class IjopversaoproId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 297345628002987993L;
	private String cdinjetora;
	private String cdproduto;
	private String nrop;
	private String versaoproducao;

	public IjopversaoproId() {
	}

	public IjopversaoproId(String cdinjetora, String cdproduto, String nrop,
			String versaoproducao) {
		this.cdinjetora = cdinjetora;
		this.cdproduto = cdproduto;
		this.nrop = nrop;
		this.versaoproducao = versaoproducao;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "VERSAOPRODUCAO", nullable = false, length = 4)
	public String getVersaoproducao() {
		return this.versaoproducao;
	}

	public void setVersaoproducao(String versaoproducao) {
		this.versaoproducao = versaoproducao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjopversaoproId))
			return false;
		IjopversaoproId castOther = (IjopversaoproId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
						&& castOther.getNrop() != null && this.getNrop()
						.equals(castOther.getNrop())))
				&& ((this.getVersaoproducao() == castOther.getVersaoproducao()) || (this
						.getVersaoproducao() != null
						&& castOther.getVersaoproducao() != null && this
						.getVersaoproducao().equals(
								castOther.getVersaoproducao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37
				* result
				+ (getVersaoproducao() == null ? 0 : this.getVersaoproducao()
						.hashCode());
		return result;
	}

}

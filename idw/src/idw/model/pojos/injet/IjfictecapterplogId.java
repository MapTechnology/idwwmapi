package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfictecapterplogId generated by hbm2java
 */
@Embeddable
public class IjfictecapterplogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2804436199551425888L;
	private Date dthralteracao;
	private String cdusuario;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private String cdproduto;
	private BigDecimal apontaerp;

	public IjfictecapterplogId() {
	}

	public IjfictecapterplogId(Date dthralteracao, String cdusuario,
			String cdinjetora, String cdmolde, String cdestrutura,
			String cdproduto, BigDecimal apontaerp) {
		this.dthralteracao = dthralteracao;
		this.cdusuario = cdusuario;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.cdproduto = cdproduto;
		this.apontaerp = apontaerp;
	}

	@Column(name = "DTHRALTERACAO", nullable = false, length = 7)
	public Date getDthralteracao() {
		return this.dthralteracao;
	}

	public void setDthralteracao(Date dthralteracao) {
		this.dthralteracao = dthralteracao;
	}

	@Column(name = "CDUSUARIO", nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
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

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "APONTAERP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getApontaerp() {
		return this.apontaerp;
	}

	public void setApontaerp(BigDecimal apontaerp) {
		this.apontaerp = apontaerp;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfictecapterplogId))
			return false;
		IjfictecapterplogId castOther = (IjfictecapterplogId) other;

		return ((this.getDthralteracao() == castOther.getDthralteracao()) || (this
				.getDthralteracao() != null
				&& castOther.getDthralteracao() != null && this
				.getDthralteracao().equals(castOther.getDthralteracao())))
				&& ((this.getCdusuario() == castOther.getCdusuario()) || (this
						.getCdusuario() != null
						&& castOther.getCdusuario() != null && this
						.getCdusuario().equals(castOther.getCdusuario())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getApontaerp() == castOther.getApontaerp()) || (this
						.getApontaerp() != null
						&& castOther.getApontaerp() != null && this
						.getApontaerp().equals(castOther.getApontaerp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDthralteracao() == null ? 0 : this.getDthralteracao()
						.hashCode());
		result = 37 * result
				+ (getCdusuario() == null ? 0 : this.getCdusuario().hashCode());
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
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getApontaerp() == null ? 0 : this.getApontaerp().hashCode());
		return result;
	}

}
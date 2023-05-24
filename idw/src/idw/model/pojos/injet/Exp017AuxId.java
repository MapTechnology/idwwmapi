package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exp017AuxId generated by hbm2java
 */
@Embeddable
public class Exp017AuxId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611974474628898778L;
	private String cdinjetora;
	private Date dthrrefugo;
	private String cdrefugo;
	private String nrop;
	private String cdproduto;
	private double qtref;
	private String cancelado;

	public Exp017AuxId() {
	}

	public Exp017AuxId(String cdinjetora, Date dthrrefugo, String cdrefugo,
			String nrop, double qtref, String cancelado) {
		this.cdinjetora = cdinjetora;
		this.dthrrefugo = dthrrefugo;
		this.cdrefugo = cdrefugo;
		this.nrop = nrop;
		this.qtref = qtref;
		this.cancelado = cancelado;
	}

	public Exp017AuxId(String cdinjetora, Date dthrrefugo, String cdrefugo,
			String nrop, String cdproduto, double qtref, String cancelado) {
		this.cdinjetora = cdinjetora;
		this.dthrrefugo = dthrrefugo;
		this.cdrefugo = cdrefugo;
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.qtref = qtref;
		this.cancelado = cancelado;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "DTHRREFUGO", nullable = false, length = 7)
	public Date getDthrrefugo() {
		return this.dthrrefugo;
	}

	public void setDthrrefugo(Date dthrrefugo) {
		this.dthrrefugo = dthrrefugo;
	}

	@Column(name = "CDREFUGO", nullable = false, length = 6)
	public String getCdrefugo() {
		return this.cdrefugo;
	}

	public void setCdrefugo(String cdrefugo) {
		this.cdrefugo = cdrefugo;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDPRODUTO", length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "QTREF", nullable = false, precision = 126, scale = 0)
	public double getQtref() {
		return this.qtref;
	}

	public void setQtref(double qtref) {
		this.qtref = qtref;
	}

	@Column(name = "CANCELADO", nullable = false, length = 1)
	public String getCancelado() {
		return this.cancelado;
	}

	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exp017AuxId))
			return false;
		Exp017AuxId castOther = (Exp017AuxId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getDthrrefugo() == castOther.getDthrrefugo()) || (this
						.getDthrrefugo() != null
						&& castOther.getDthrrefugo() != null && this
						.getDthrrefugo().equals(castOther.getDthrrefugo())))
				&& ((this.getCdrefugo() == castOther.getCdrefugo()) || (this
						.getCdrefugo() != null
						&& castOther.getCdrefugo() != null && this
						.getCdrefugo().equals(castOther.getCdrefugo())))
				&& ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
						&& castOther.getNrop() != null && this.getNrop()
						.equals(castOther.getNrop())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& (this.getQtref() == castOther.getQtref())
				&& ((this.getCancelado() == castOther.getCancelado()) || (this
						.getCancelado() != null
						&& castOther.getCancelado() != null && this
						.getCancelado().equals(castOther.getCancelado())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37
				* result
				+ (getDthrrefugo() == null ? 0 : this.getDthrrefugo()
						.hashCode());
		result = 37 * result
				+ (getCdrefugo() == null ? 0 : this.getCdrefugo().hashCode());
		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result + (int) this.getQtref();
		result = 37 * result
				+ (getCancelado() == null ? 0 : this.getCancelado().hashCode());
		return result;
	}

}
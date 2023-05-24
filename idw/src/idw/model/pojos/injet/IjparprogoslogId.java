package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjparprogoslogId generated by hbm2java
 */
@Embeddable
public class IjparprogoslogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1188445548446093757L;
	private String cdinjetora;
	private Date dthrinicio;
	private String nros;
	private Date dtprevinimanut;
	private Date dtprevfimmanut;
	private Date dthralteracao;
	private String cdusuario;
	private BigDecimal tipolog;

	public IjparprogoslogId() {
	}

	public IjparprogoslogId(String cdinjetora, Date dthrinicio, String nros,
			Date dtprevinimanut, Date dtprevfimmanut, Date dthralteracao,
			String cdusuario, BigDecimal tipolog) {
		this.cdinjetora = cdinjetora;
		this.dthrinicio = dthrinicio;
		this.nros = nros;
		this.dtprevinimanut = dtprevinimanut;
		this.dtprevfimmanut = dtprevfimmanut;
		this.dthralteracao = dthralteracao;
		this.cdusuario = cdusuario;
		this.tipolog = tipolog;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "DTHRINICIO", nullable = false, length = 7)
	public Date getDthrinicio() {
		return this.dthrinicio;
	}

	public void setDthrinicio(Date dthrinicio) {
		this.dthrinicio = dthrinicio;
	}

	@Column(name = "NROS", nullable = false, length = 12)
	public String getNros() {
		return this.nros;
	}

	public void setNros(String nros) {
		this.nros = nros;
	}

	@Column(name = "DTPREVINIMANUT", nullable = false, length = 7)
	public Date getDtprevinimanut() {
		return this.dtprevinimanut;
	}

	public void setDtprevinimanut(Date dtprevinimanut) {
		this.dtprevinimanut = dtprevinimanut;
	}

	@Column(name = "DTPREVFIMMANUT", nullable = false, length = 7)
	public Date getDtprevfimmanut() {
		return this.dtprevfimmanut;
	}

	public void setDtprevfimmanut(Date dtprevfimmanut) {
		this.dtprevfimmanut = dtprevfimmanut;
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

	@Column(name = "TIPOLOG", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTipolog() {
		return this.tipolog;
	}

	public void setTipolog(BigDecimal tipolog) {
		this.tipolog = tipolog;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjparprogoslogId))
			return false;
		IjparprogoslogId castOther = (IjparprogoslogId) other;

		return ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
				.getCdinjetora() != null && castOther.getCdinjetora() != null && this
				.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getDthrinicio() == castOther.getDthrinicio()) || (this
						.getDthrinicio() != null
						&& castOther.getDthrinicio() != null && this
						.getDthrinicio().equals(castOther.getDthrinicio())))
				&& ((this.getNros() == castOther.getNros()) || (this.getNros() != null
						&& castOther.getNros() != null && this.getNros()
						.equals(castOther.getNros())))
				&& ((this.getDtprevinimanut() == castOther.getDtprevinimanut()) || (this
						.getDtprevinimanut() != null
						&& castOther.getDtprevinimanut() != null && this
						.getDtprevinimanut().equals(
								castOther.getDtprevinimanut())))
				&& ((this.getDtprevfimmanut() == castOther.getDtprevfimmanut()) || (this
						.getDtprevfimmanut() != null
						&& castOther.getDtprevfimmanut() != null && this
						.getDtprevfimmanut().equals(
								castOther.getDtprevfimmanut())))
				&& ((this.getDthralteracao() == castOther.getDthralteracao()) || (this
						.getDthralteracao() != null
						&& castOther.getDthralteracao() != null && this
						.getDthralteracao()
						.equals(castOther.getDthralteracao())))
				&& ((this.getCdusuario() == castOther.getCdusuario()) || (this
						.getCdusuario() != null
						&& castOther.getCdusuario() != null && this
						.getCdusuario().equals(castOther.getCdusuario())))
				&& ((this.getTipolog() == castOther.getTipolog()) || (this
						.getTipolog() != null && castOther.getTipolog() != null && this
						.getTipolog().equals(castOther.getTipolog())));
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
				+ (getDthrinicio() == null ? 0 : this.getDthrinicio()
						.hashCode());
		result = 37 * result
				+ (getNros() == null ? 0 : this.getNros().hashCode());
		result = 37
				* result
				+ (getDtprevinimanut() == null ? 0 : this.getDtprevinimanut()
						.hashCode());
		result = 37
				* result
				+ (getDtprevfimmanut() == null ? 0 : this.getDtprevfimmanut()
						.hashCode());
		result = 37
				* result
				+ (getDthralteracao() == null ? 0 : this.getDthralteracao()
						.hashCode());
		result = 37 * result
				+ (getCdusuario() == null ? 0 : this.getCdusuario().hashCode());
		result = 37 * result
				+ (getTipolog() == null ? 0 : this.getTipolog().hashCode());
		return result;
	}

}
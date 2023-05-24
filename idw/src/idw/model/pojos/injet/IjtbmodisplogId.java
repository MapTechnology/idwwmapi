package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbmodisplogId generated by hbm2java
 */
@Embeddable
public class IjtbmodisplogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5373030919779623588L;
	private Date dthroperacao;
	private BigDecimal tpoperacao;
	private Date dtturno;
	private String cdturno;
	private BigDecimal qtdmo;
	private String cdusuario;
	private String motivoalteracao;

	public IjtbmodisplogId() {
	}

	public IjtbmodisplogId(Date dthroperacao, BigDecimal tpoperacao,
			Date dtturno, String cdturno, BigDecimal qtdmo, String cdusuario) {
		this.dthroperacao = dthroperacao;
		this.tpoperacao = tpoperacao;
		this.dtturno = dtturno;
		this.cdturno = cdturno;
		this.qtdmo = qtdmo;
		this.cdusuario = cdusuario;
	}

	public IjtbmodisplogId(Date dthroperacao, BigDecimal tpoperacao,
			Date dtturno, String cdturno, BigDecimal qtdmo, String cdusuario,
			String motivoalteracao) {
		this.dthroperacao = dthroperacao;
		this.tpoperacao = tpoperacao;
		this.dtturno = dtturno;
		this.cdturno = cdturno;
		this.qtdmo = qtdmo;
		this.cdusuario = cdusuario;
		this.motivoalteracao = motivoalteracao;
	}

	@Column(name = "DTHROPERACAO", nullable = false, length = 7)
	public Date getDthroperacao() {
		return this.dthroperacao;
	}

	public void setDthroperacao(Date dthroperacao) {
		this.dthroperacao = dthroperacao;
	}

	@Column(name = "TPOPERACAO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTpoperacao() {
		return this.tpoperacao;
	}

	public void setTpoperacao(BigDecimal tpoperacao) {
		this.tpoperacao = tpoperacao;
	}

	@Column(name = "DTTURNO", nullable = false, length = 7)
	public Date getDtturno() {
		return this.dtturno;
	}

	public void setDtturno(Date dtturno) {
		this.dtturno = dtturno;
	}

	@Column(name = "CDTURNO", nullable = false, length = 6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "QTDMO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getQtdmo() {
		return this.qtdmo;
	}

	public void setQtdmo(BigDecimal qtdmo) {
		this.qtdmo = qtdmo;
	}

	@Column(name = "CDUSUARIO", nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@Column(name = "MOTIVOALTERACAO", length = 250)
	public String getMotivoalteracao() {
		return this.motivoalteracao;
	}

	public void setMotivoalteracao(String motivoalteracao) {
		this.motivoalteracao = motivoalteracao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbmodisplogId))
			return false;
		IjtbmodisplogId castOther = (IjtbmodisplogId) other;

		return ((this.getDthroperacao() == castOther.getDthroperacao()) || (this
				.getDthroperacao() != null
				&& castOther.getDthroperacao() != null && this
				.getDthroperacao().equals(castOther.getDthroperacao())))
				&& ((this.getTpoperacao() == castOther.getTpoperacao()) || (this
						.getTpoperacao() != null
						&& castOther.getTpoperacao() != null && this
						.getTpoperacao().equals(castOther.getTpoperacao())))
				&& ((this.getDtturno() == castOther.getDtturno()) || (this
						.getDtturno() != null && castOther.getDtturno() != null && this
						.getDtturno().equals(castOther.getDtturno())))
				&& ((this.getCdturno() == castOther.getCdturno()) || (this
						.getCdturno() != null && castOther.getCdturno() != null && this
						.getCdturno().equals(castOther.getCdturno())))
				&& ((this.getQtdmo() == castOther.getQtdmo()) || (this
						.getQtdmo() != null && castOther.getQtdmo() != null && this
						.getQtdmo().equals(castOther.getQtdmo())))
				&& ((this.getCdusuario() == castOther.getCdusuario()) || (this
						.getCdusuario() != null
						&& castOther.getCdusuario() != null && this
						.getCdusuario().equals(castOther.getCdusuario())))
				&& ((this.getMotivoalteracao() == castOther
						.getMotivoalteracao()) || (this.getMotivoalteracao() != null
						&& castOther.getMotivoalteracao() != null && this
						.getMotivoalteracao().equals(
								castOther.getMotivoalteracao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDthroperacao() == null ? 0 : this.getDthroperacao()
						.hashCode());
		result = 37
				* result
				+ (getTpoperacao() == null ? 0 : this.getTpoperacao()
						.hashCode());
		result = 37 * result
				+ (getDtturno() == null ? 0 : this.getDtturno().hashCode());
		result = 37 * result
				+ (getCdturno() == null ? 0 : this.getCdturno().hashCode());
		result = 37 * result
				+ (getQtdmo() == null ? 0 : this.getQtdmo().hashCode());
		result = 37 * result
				+ (getCdusuario() == null ? 0 : this.getCdusuario().hashCode());
		result = 37
				* result
				+ (getMotivoalteracao() == null ? 0 : this.getMotivoalteracao()
						.hashCode());
		return result;
	}

}
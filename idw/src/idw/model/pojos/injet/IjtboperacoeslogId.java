package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtboperacoeslogId generated by hbm2java
 */
@Embeddable
public class IjtboperacoeslogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1196789460090499672L;
	private String cdoperacao;
	private String dsoperacao;
	private String unidqtdproc;
	private BigDecimal tpoperacao;
	private BigDecimal reqfim;
	private BigDecimal reqqtd;
	private BigDecimal reqmaq;
	private BigDecimal reqop;
	private BigDecimal reqoper;
	private BigDecimal permiteopergrupo;
	private Date dthrmanut;
	private char tpmanut;
	private String cdusuresp;

	public IjtboperacoeslogId() {
	}

	public IjtboperacoeslogId(String cdoperacao, String dsoperacao,
			Date dthrmanut, char tpmanut, String cdusuresp) {
		this.cdoperacao = cdoperacao;
		this.dsoperacao = dsoperacao;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjtboperacoeslogId(String cdoperacao, String dsoperacao,
			String unidqtdproc, BigDecimal tpoperacao, BigDecimal reqfim,
			BigDecimal reqqtd, BigDecimal reqmaq, BigDecimal reqop,
			BigDecimal reqoper, BigDecimal permiteopergrupo, Date dthrmanut,
			char tpmanut, String cdusuresp) {
		this.cdoperacao = cdoperacao;
		this.dsoperacao = dsoperacao;
		this.unidqtdproc = unidqtdproc;
		this.tpoperacao = tpoperacao;
		this.reqfim = reqfim;
		this.reqqtd = reqqtd;
		this.reqmaq = reqmaq;
		this.reqop = reqop;
		this.reqoper = reqoper;
		this.permiteopergrupo = permiteopergrupo;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "CDOPERACAO", nullable = false, length = 6)
	public String getCdoperacao() {
		return this.cdoperacao;
	}

	public void setCdoperacao(String cdoperacao) {
		this.cdoperacao = cdoperacao;
	}

	@Column(name = "DSOPERACAO", nullable = false, length = 40)
	public String getDsoperacao() {
		return this.dsoperacao;
	}

	public void setDsoperacao(String dsoperacao) {
		this.dsoperacao = dsoperacao;
	}

	@Column(name = "UNIDQTDPROC", length = 6)
	public String getUnidqtdproc() {
		return this.unidqtdproc;
	}

	public void setUnidqtdproc(String unidqtdproc) {
		this.unidqtdproc = unidqtdproc;
	}

	@Column(name = "TPOPERACAO", precision = 22, scale = 0)
	public BigDecimal getTpoperacao() {
		return this.tpoperacao;
	}

	public void setTpoperacao(BigDecimal tpoperacao) {
		this.tpoperacao = tpoperacao;
	}

	@Column(name = "REQFIM", precision = 22, scale = 0)
	public BigDecimal getReqfim() {
		return this.reqfim;
	}

	public void setReqfim(BigDecimal reqfim) {
		this.reqfim = reqfim;
	}

	@Column(name = "REQQTD", precision = 22, scale = 0)
	public BigDecimal getReqqtd() {
		return this.reqqtd;
	}

	public void setReqqtd(BigDecimal reqqtd) {
		this.reqqtd = reqqtd;
	}

	@Column(name = "REQMAQ", precision = 22, scale = 0)
	public BigDecimal getReqmaq() {
		return this.reqmaq;
	}

	public void setReqmaq(BigDecimal reqmaq) {
		this.reqmaq = reqmaq;
	}

	@Column(name = "REQOP", precision = 22, scale = 0)
	public BigDecimal getReqop() {
		return this.reqop;
	}

	public void setReqop(BigDecimal reqop) {
		this.reqop = reqop;
	}

	@Column(name = "REQOPER", precision = 22, scale = 0)
	public BigDecimal getReqoper() {
		return this.reqoper;
	}

	public void setReqoper(BigDecimal reqoper) {
		this.reqoper = reqoper;
	}

	@Column(name = "PERMITEOPERGRUPO", precision = 22, scale = 0)
	public BigDecimal getPermiteopergrupo() {
		return this.permiteopergrupo;
	}

	public void setPermiteopergrupo(BigDecimal permiteopergrupo) {
		this.permiteopergrupo = permiteopergrupo;
	}

	@Column(name = "DTHRMANUT", nullable = false, length = 7)
	public Date getDthrmanut() {
		return this.dthrmanut;
	}

	public void setDthrmanut(Date dthrmanut) {
		this.dthrmanut = dthrmanut;
	}

	@Column(name = "TPMANUT", nullable = false, length = 1)
	public char getTpmanut() {
		return this.tpmanut;
	}

	public void setTpmanut(char tpmanut) {
		this.tpmanut = tpmanut;
	}

	@Column(name = "CDUSURESP", nullable = false, length = 6)
	public String getCdusuresp() {
		return this.cdusuresp;
	}

	public void setCdusuresp(String cdusuresp) {
		this.cdusuresp = cdusuresp;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtboperacoeslogId))
			return false;
		IjtboperacoeslogId castOther = (IjtboperacoeslogId) other;

		return ((this.getCdoperacao() == castOther.getCdoperacao()) || (this
				.getCdoperacao() != null && castOther.getCdoperacao() != null && this
				.getCdoperacao().equals(castOther.getCdoperacao())))
				&& ((this.getDsoperacao() == castOther.getDsoperacao()) || (this
						.getDsoperacao() != null
						&& castOther.getDsoperacao() != null && this
						.getDsoperacao().equals(castOther.getDsoperacao())))
				&& ((this.getUnidqtdproc() == castOther.getUnidqtdproc()) || (this
						.getUnidqtdproc() != null
						&& castOther.getUnidqtdproc() != null && this
						.getUnidqtdproc().equals(castOther.getUnidqtdproc())))
				&& ((this.getTpoperacao() == castOther.getTpoperacao()) || (this
						.getTpoperacao() != null
						&& castOther.getTpoperacao() != null && this
						.getTpoperacao().equals(castOther.getTpoperacao())))
				&& ((this.getReqfim() == castOther.getReqfim()) || (this
						.getReqfim() != null && castOther.getReqfim() != null && this
						.getReqfim().equals(castOther.getReqfim())))
				&& ((this.getReqqtd() == castOther.getReqqtd()) || (this
						.getReqqtd() != null && castOther.getReqqtd() != null && this
						.getReqqtd().equals(castOther.getReqqtd())))
				&& ((this.getReqmaq() == castOther.getReqmaq()) || (this
						.getReqmaq() != null && castOther.getReqmaq() != null && this
						.getReqmaq().equals(castOther.getReqmaq())))
				&& ((this.getReqop() == castOther.getReqop()) || (this
						.getReqop() != null && castOther.getReqop() != null && this
						.getReqop().equals(castOther.getReqop())))
				&& ((this.getReqoper() == castOther.getReqoper()) || (this
						.getReqoper() != null && castOther.getReqoper() != null && this
						.getReqoper().equals(castOther.getReqoper())))
				&& ((this.getPermiteopergrupo() == castOther
						.getPermiteopergrupo()) || (this.getPermiteopergrupo() != null
						&& castOther.getPermiteopergrupo() != null && this
						.getPermiteopergrupo().equals(
								castOther.getPermiteopergrupo())))
				&& ((this.getDthrmanut() == castOther.getDthrmanut()) || (this
						.getDthrmanut() != null
						&& castOther.getDthrmanut() != null && this
						.getDthrmanut().equals(castOther.getDthrmanut())))
				&& (this.getTpmanut() == castOther.getTpmanut())
				&& ((this.getCdusuresp() == castOther.getCdusuresp()) || (this
						.getCdusuresp() != null
						&& castOther.getCdusuresp() != null && this
						.getCdusuresp().equals(castOther.getCdusuresp())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdoperacao() == null ? 0 : this.getCdoperacao()
						.hashCode());
		result = 37
				* result
				+ (getDsoperacao() == null ? 0 : this.getDsoperacao()
						.hashCode());
		result = 37
				* result
				+ (getUnidqtdproc() == null ? 0 : this.getUnidqtdproc()
						.hashCode());
		result = 37
				* result
				+ (getTpoperacao() == null ? 0 : this.getTpoperacao()
						.hashCode());
		result = 37 * result
				+ (getReqfim() == null ? 0 : this.getReqfim().hashCode());
		result = 37 * result
				+ (getReqqtd() == null ? 0 : this.getReqqtd().hashCode());
		result = 37 * result
				+ (getReqmaq() == null ? 0 : this.getReqmaq().hashCode());
		result = 37 * result
				+ (getReqop() == null ? 0 : this.getReqop().hashCode());
		result = 37 * result
				+ (getReqoper() == null ? 0 : this.getReqoper().hashCode());
		result = 37
				* result
				+ (getPermiteopergrupo() == null ? 0 : this
						.getPermiteopergrupo().hashCode());
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result + this.getTpmanut();
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjviewparadasId generated by hbm2java
 */
@Embeddable
public class IjviewparadasId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1985321331241201041L;
	private String nrop;
	private String cdproduto;
	private String dsproduto;
	private String cdmaquina;
	private String cdmolde;
	private String cdestrutura;
	private Date dtturnoref;
	private String cdturno;
	private String cdparada;
	private String dsparada;
	private String cdarearesp;
	private String dsarearesp;
	private BigDecimal tmpparada;
	private BigDecimal qtdparadas;

	public IjviewparadasId() {
	}

	public IjviewparadasId(String nrop, String cdproduto, String cdmaquina,
			String cdmolde, String cdestrutura, Date dtturnoref,
			String cdturno, String cdparada, String cdarearesp) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.cdmaquina = cdmaquina;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dtturnoref = dtturnoref;
		this.cdturno = cdturno;
		this.cdparada = cdparada;
		this.cdarearesp = cdarearesp;
	}

	public IjviewparadasId(String nrop, String cdproduto, String dsproduto,
			String cdmaquina, String cdmolde, String cdestrutura,
			Date dtturnoref, String cdturno, String cdparada, String dsparada,
			String cdarearesp, String dsarearesp, BigDecimal tmpparada,
			BigDecimal qtdparadas) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.dsproduto = dsproduto;
		this.cdmaquina = cdmaquina;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dtturnoref = dtturnoref;
		this.cdturno = cdturno;
		this.cdparada = cdparada;
		this.dsparada = dsparada;
		this.cdarearesp = cdarearesp;
		this.dsarearesp = dsarearesp;
		this.tmpparada = tmpparada;
		this.qtdparadas = qtdparadas;
	}

	@Column(name = "NROP", nullable = false, length = 25)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "DSPRODUTO", length = 40)
	public String getDsproduto() {
		return this.dsproduto;
	}

	public void setDsproduto(String dsproduto) {
		this.dsproduto = dsproduto;
	}

	@Column(name = "CDMAQUINA", nullable = false, length = 8)
	public String getCdmaquina() {
		return this.cdmaquina;
	}

	public void setCdmaquina(String cdmaquina) {
		this.cdmaquina = cdmaquina;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 18)
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

	@Column(name = "DTTURNOREF", nullable = false, length = 7)
	public Date getDtturnoref() {
		return this.dtturnoref;
	}

	public void setDtturnoref(Date dtturnoref) {
		this.dtturnoref = dtturnoref;
	}

	@Column(name = "CDTURNO", nullable = false, length = 6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "CDPARADA", nullable = false, length = 6)
	public String getCdparada() {
		return this.cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	@Column(name = "DSPARADA", length = 40)
	public String getDsparada() {
		return this.dsparada;
	}

	public void setDsparada(String dsparada) {
		this.dsparada = dsparada;
	}

	@Column(name = "CDAREARESP", nullable = false, length = 6)
	public String getCdarearesp() {
		return this.cdarearesp;
	}

	public void setCdarearesp(String cdarearesp) {
		this.cdarearesp = cdarearesp;
	}

	@Column(name = "DSAREARESP", length = 40)
	public String getDsarearesp() {
		return this.dsarearesp;
	}

	public void setDsarearesp(String dsarearesp) {
		this.dsarearesp = dsarearesp;
	}

	@Column(name = "TMPPARADA", precision = 22, scale = 0)
	public BigDecimal getTmpparada() {
		return this.tmpparada;
	}

	public void setTmpparada(BigDecimal tmpparada) {
		this.tmpparada = tmpparada;
	}

	@Column(name = "QTDPARADAS", precision = 22, scale = 0)
	public BigDecimal getQtdparadas() {
		return this.qtdparadas;
	}

	public void setQtdparadas(BigDecimal qtdparadas) {
		this.qtdparadas = qtdparadas;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjviewparadasId))
			return false;
		IjviewparadasId castOther = (IjviewparadasId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getDsproduto() == castOther.getDsproduto()) || (this
						.getDsproduto() != null
						&& castOther.getDsproduto() != null && this
						.getDsproduto().equals(castOther.getDsproduto())))
				&& ((this.getCdmaquina() == castOther.getCdmaquina()) || (this
						.getCdmaquina() != null
						&& castOther.getCdmaquina() != null && this
						.getCdmaquina().equals(castOther.getCdmaquina())))
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getDtturnoref() == castOther.getDtturnoref()) || (this
						.getDtturnoref() != null
						&& castOther.getDtturnoref() != null && this
						.getDtturnoref().equals(castOther.getDtturnoref())))
				&& ((this.getCdturno() == castOther.getCdturno()) || (this
						.getCdturno() != null && castOther.getCdturno() != null && this
						.getCdturno().equals(castOther.getCdturno())))
				&& ((this.getCdparada() == castOther.getCdparada()) || (this
						.getCdparada() != null
						&& castOther.getCdparada() != null && this
						.getCdparada().equals(castOther.getCdparada())))
				&& ((this.getDsparada() == castOther.getDsparada()) || (this
						.getDsparada() != null
						&& castOther.getDsparada() != null && this
						.getDsparada().equals(castOther.getDsparada())))
				&& ((this.getCdarearesp() == castOther.getCdarearesp()) || (this
						.getCdarearesp() != null
						&& castOther.getCdarearesp() != null && this
						.getCdarearesp().equals(castOther.getCdarearesp())))
				&& ((this.getDsarearesp() == castOther.getDsarearesp()) || (this
						.getDsarearesp() != null
						&& castOther.getDsarearesp() != null && this
						.getDsarearesp().equals(castOther.getDsarearesp())))
				&& ((this.getTmpparada() == castOther.getTmpparada()) || (this
						.getTmpparada() != null
						&& castOther.getTmpparada() != null && this
						.getTmpparada().equals(castOther.getTmpparada())))
				&& ((this.getQtdparadas() == castOther.getQtdparadas()) || (this
						.getQtdparadas() != null
						&& castOther.getQtdparadas() != null && this
						.getQtdparadas().equals(castOther.getQtdparadas())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result
				+ (getDsproduto() == null ? 0 : this.getDsproduto().hashCode());
		result = 37 * result
				+ (getCdmaquina() == null ? 0 : this.getCdmaquina().hashCode());
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37
				* result
				+ (getCdestrutura() == null ? 0 : this.getCdestrutura()
						.hashCode());
		result = 37
				* result
				+ (getDtturnoref() == null ? 0 : this.getDtturnoref()
						.hashCode());
		result = 37 * result
				+ (getCdturno() == null ? 0 : this.getCdturno().hashCode());
		result = 37 * result
				+ (getCdparada() == null ? 0 : this.getCdparada().hashCode());
		result = 37 * result
				+ (getDsparada() == null ? 0 : this.getDsparada().hashCode());
		result = 37
				* result
				+ (getCdarearesp() == null ? 0 : this.getCdarearesp()
						.hashCode());
		result = 37
				* result
				+ (getDsarearesp() == null ? 0 : this.getDsarearesp()
						.hashCode());
		result = 37 * result
				+ (getTmpparada() == null ? 0 : this.getTmpparada().hashCode());
		result = 37
				* result
				+ (getQtdparadas() == null ? 0 : this.getQtdparadas()
						.hashCode());
		return result;
	}

}
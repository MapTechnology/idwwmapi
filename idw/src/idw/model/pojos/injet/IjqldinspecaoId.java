package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjqldinspecaoId generated by hbm2java
 */
@Embeddable
public class IjqldinspecaoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2497272469661601472L;
	private String nrop;
	private String cdinjetora;
	private String cdmolde;
	private String cdestrutura;
	private String cdproduto;
	private Date dthrival;
	private String cdrefugo;
	private String cdusuarioinspecao;
	private double qtpcsref;
	private Date dthrinspecao;
	private String observacao;
	private String nrrnc;
	private String cdusuariornc;
	private Date dthrrnc;
	private String cdusuariobaixa;
	private Date dthrbaixa;
	private String stbaixa;
	private String cdusuarioalteracao;
	private Date dthralteracao;
	private String cdusuarioexclusao;
	private Date dthrexclusao;
	private Date dthriniintervalo;

	public IjqldinspecaoId() {
	}

	public IjqldinspecaoId(String nrop, String cdinjetora, String cdmolde,
			String cdestrutura, String cdproduto, Date dthrival,
			String cdrefugo, String cdusuarioinspecao, double qtpcsref,
			Date dthrinspecao) {
		this.nrop = nrop;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.cdproduto = cdproduto;
		this.dthrival = dthrival;
		this.cdrefugo = cdrefugo;
		this.cdusuarioinspecao = cdusuarioinspecao;
		this.qtpcsref = qtpcsref;
		this.dthrinspecao = dthrinspecao;
	}

	public IjqldinspecaoId(String nrop, String cdinjetora, String cdmolde,
			String cdestrutura, String cdproduto, Date dthrival,
			String cdrefugo, String cdusuarioinspecao, double qtpcsref,
			Date dthrinspecao, String observacao, String nrrnc,
			String cdusuariornc, Date dthrrnc, String cdusuariobaixa,
			Date dthrbaixa, String stbaixa, String cdusuarioalteracao,
			Date dthralteracao, String cdusuarioexclusao, Date dthrexclusao,
			Date dthriniintervalo) {
		this.nrop = nrop;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.cdproduto = cdproduto;
		this.dthrival = dthrival;
		this.cdrefugo = cdrefugo;
		this.cdusuarioinspecao = cdusuarioinspecao;
		this.qtpcsref = qtpcsref;
		this.dthrinspecao = dthrinspecao;
		this.observacao = observacao;
		this.nrrnc = nrrnc;
		this.cdusuariornc = cdusuariornc;
		this.dthrrnc = dthrrnc;
		this.cdusuariobaixa = cdusuariobaixa;
		this.dthrbaixa = dthrbaixa;
		this.stbaixa = stbaixa;
		this.cdusuarioalteracao = cdusuarioalteracao;
		this.dthralteracao = dthralteracao;
		this.cdusuarioexclusao = cdusuarioexclusao;
		this.dthrexclusao = dthrexclusao;
		this.dthriniintervalo = dthriniintervalo;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
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

	@Column(name = "DTHRIVAL", nullable = false, length = 7)
	public Date getDthrival() {
		return this.dthrival;
	}

	public void setDthrival(Date dthrival) {
		this.dthrival = dthrival;
	}

	@Column(name = "CDREFUGO", nullable = false, length = 6)
	public String getCdrefugo() {
		return this.cdrefugo;
	}

	public void setCdrefugo(String cdrefugo) {
		this.cdrefugo = cdrefugo;
	}

	@Column(name = "CDUSUARIOINSPECAO", nullable = false, length = 6)
	public String getCdusuarioinspecao() {
		return this.cdusuarioinspecao;
	}

	public void setCdusuarioinspecao(String cdusuarioinspecao) {
		this.cdusuarioinspecao = cdusuarioinspecao;
	}

	@Column(name = "QTPCSREF", nullable = false, precision = 126, scale = 0)
	public double getQtpcsref() {
		return this.qtpcsref;
	}

	public void setQtpcsref(double qtpcsref) {
		this.qtpcsref = qtpcsref;
	}

	@Column(name = "DTHRINSPECAO", nullable = false, length = 7)
	public Date getDthrinspecao() {
		return this.dthrinspecao;
	}

	public void setDthrinspecao(Date dthrinspecao) {
		this.dthrinspecao = dthrinspecao;
	}

	@Column(name = "OBSERVACAO", length = 200)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "NRRNC", length = 20)
	public String getNrrnc() {
		return this.nrrnc;
	}

	public void setNrrnc(String nrrnc) {
		this.nrrnc = nrrnc;
	}

	@Column(name = "CDUSUARIORNC", length = 6)
	public String getCdusuariornc() {
		return this.cdusuariornc;
	}

	public void setCdusuariornc(String cdusuariornc) {
		this.cdusuariornc = cdusuariornc;
	}

	@Column(name = "DTHRRNC", length = 7)
	public Date getDthrrnc() {
		return this.dthrrnc;
	}

	public void setDthrrnc(Date dthrrnc) {
		this.dthrrnc = dthrrnc;
	}

	@Column(name = "CDUSUARIOBAIXA", length = 6)
	public String getCdusuariobaixa() {
		return this.cdusuariobaixa;
	}

	public void setCdusuariobaixa(String cdusuariobaixa) {
		this.cdusuariobaixa = cdusuariobaixa;
	}

	@Column(name = "DTHRBAIXA", length = 7)
	public Date getDthrbaixa() {
		return this.dthrbaixa;
	}

	public void setDthrbaixa(Date dthrbaixa) {
		this.dthrbaixa = dthrbaixa;
	}

	@Column(name = "STBAIXA", length = 1)
	public String getStbaixa() {
		return this.stbaixa;
	}

	public void setStbaixa(String stbaixa) {
		this.stbaixa = stbaixa;
	}

	@Column(name = "CDUSUARIOALTERACAO", length = 6)
	public String getCdusuarioalteracao() {
		return this.cdusuarioalteracao;
	}

	public void setCdusuarioalteracao(String cdusuarioalteracao) {
		this.cdusuarioalteracao = cdusuarioalteracao;
	}

	@Column(name = "DTHRALTERACAO", length = 7)
	public Date getDthralteracao() {
		return this.dthralteracao;
	}

	public void setDthralteracao(Date dthralteracao) {
		this.dthralteracao = dthralteracao;
	}

	@Column(name = "CDUSUARIOEXCLUSAO", length = 6)
	public String getCdusuarioexclusao() {
		return this.cdusuarioexclusao;
	}

	public void setCdusuarioexclusao(String cdusuarioexclusao) {
		this.cdusuarioexclusao = cdusuarioexclusao;
	}

	@Column(name = "DTHREXCLUSAO", length = 7)
	public Date getDthrexclusao() {
		return this.dthrexclusao;
	}

	public void setDthrexclusao(Date dthrexclusao) {
		this.dthrexclusao = dthrexclusao;
	}

	@Column(name = "DTHRINIINTERVALO", length = 7)
	public Date getDthriniintervalo() {
		return this.dthriniintervalo;
	}

	public void setDthriniintervalo(Date dthriniintervalo) {
		this.dthriniintervalo = dthriniintervalo;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjqldinspecaoId))
			return false;
		IjqldinspecaoId castOther = (IjqldinspecaoId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
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
				&& ((this.getDthrival() == castOther.getDthrival()) || (this
						.getDthrival() != null
						&& castOther.getDthrival() != null && this
						.getDthrival().equals(castOther.getDthrival())))
				&& ((this.getCdrefugo() == castOther.getCdrefugo()) || (this
						.getCdrefugo() != null
						&& castOther.getCdrefugo() != null && this
						.getCdrefugo().equals(castOther.getCdrefugo())))
				&& ((this.getCdusuarioinspecao() == castOther
						.getCdusuarioinspecao()) || (this
						.getCdusuarioinspecao() != null
						&& castOther.getCdusuarioinspecao() != null && this
						.getCdusuarioinspecao().equals(
								castOther.getCdusuarioinspecao())))
				&& (this.getQtpcsref() == castOther.getQtpcsref())
				&& ((this.getDthrinspecao() == castOther.getDthrinspecao()) || (this
						.getDthrinspecao() != null
						&& castOther.getDthrinspecao() != null && this
						.getDthrinspecao().equals(castOther.getDthrinspecao())))
				&& ((this.getObservacao() == castOther.getObservacao()) || (this
						.getObservacao() != null
						&& castOther.getObservacao() != null && this
						.getObservacao().equals(castOther.getObservacao())))
				&& ((this.getNrrnc() == castOther.getNrrnc()) || (this
						.getNrrnc() != null && castOther.getNrrnc() != null && this
						.getNrrnc().equals(castOther.getNrrnc())))
				&& ((this.getCdusuariornc() == castOther.getCdusuariornc()) || (this
						.getCdusuariornc() != null
						&& castOther.getCdusuariornc() != null && this
						.getCdusuariornc().equals(castOther.getCdusuariornc())))
				&& ((this.getDthrrnc() == castOther.getDthrrnc()) || (this
						.getDthrrnc() != null && castOther.getDthrrnc() != null && this
						.getDthrrnc().equals(castOther.getDthrrnc())))
				&& ((this.getCdusuariobaixa() == castOther.getCdusuariobaixa()) || (this
						.getCdusuariobaixa() != null
						&& castOther.getCdusuariobaixa() != null && this
						.getCdusuariobaixa().equals(
								castOther.getCdusuariobaixa())))
				&& ((this.getDthrbaixa() == castOther.getDthrbaixa()) || (this
						.getDthrbaixa() != null
						&& castOther.getDthrbaixa() != null && this
						.getDthrbaixa().equals(castOther.getDthrbaixa())))
				&& ((this.getStbaixa() == castOther.getStbaixa()) || (this
						.getStbaixa() != null && castOther.getStbaixa() != null && this
						.getStbaixa().equals(castOther.getStbaixa())))
				&& ((this.getCdusuarioalteracao() == castOther
						.getCdusuarioalteracao()) || (this
						.getCdusuarioalteracao() != null
						&& castOther.getCdusuarioalteracao() != null && this
						.getCdusuarioalteracao().equals(
								castOther.getCdusuarioalteracao())))
				&& ((this.getDthralteracao() == castOther.getDthralteracao()) || (this
						.getDthralteracao() != null
						&& castOther.getDthralteracao() != null && this
						.getDthralteracao()
						.equals(castOther.getDthralteracao())))
				&& ((this.getCdusuarioexclusao() == castOther
						.getCdusuarioexclusao()) || (this
						.getCdusuarioexclusao() != null
						&& castOther.getCdusuarioexclusao() != null && this
						.getCdusuarioexclusao().equals(
								castOther.getCdusuarioexclusao())))
				&& ((this.getDthrexclusao() == castOther.getDthrexclusao()) || (this
						.getDthrexclusao() != null
						&& castOther.getDthrexclusao() != null && this
						.getDthrexclusao().equals(castOther.getDthrexclusao())))
				&& ((this.getDthriniintervalo() == castOther
						.getDthriniintervalo()) || (this.getDthriniintervalo() != null
						&& castOther.getDthriniintervalo() != null && this
						.getDthriniintervalo().equals(
								castOther.getDthriniintervalo())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
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
				+ (getDthrival() == null ? 0 : this.getDthrival().hashCode());
		result = 37 * result
				+ (getCdrefugo() == null ? 0 : this.getCdrefugo().hashCode());
		result = 37
				* result
				+ (getCdusuarioinspecao() == null ? 0 : this
						.getCdusuarioinspecao().hashCode());
		result = 37 * result + (int) this.getQtpcsref();
		result = 37
				* result
				+ (getDthrinspecao() == null ? 0 : this.getDthrinspecao()
						.hashCode());
		result = 37
				* result
				+ (getObservacao() == null ? 0 : this.getObservacao()
						.hashCode());
		result = 37 * result
				+ (getNrrnc() == null ? 0 : this.getNrrnc().hashCode());
		result = 37
				* result
				+ (getCdusuariornc() == null ? 0 : this.getCdusuariornc()
						.hashCode());
		result = 37 * result
				+ (getDthrrnc() == null ? 0 : this.getDthrrnc().hashCode());
		result = 37
				* result
				+ (getCdusuariobaixa() == null ? 0 : this.getCdusuariobaixa()
						.hashCode());
		result = 37 * result
				+ (getDthrbaixa() == null ? 0 : this.getDthrbaixa().hashCode());
		result = 37 * result
				+ (getStbaixa() == null ? 0 : this.getStbaixa().hashCode());
		result = 37
				* result
				+ (getCdusuarioalteracao() == null ? 0 : this
						.getCdusuarioalteracao().hashCode());
		result = 37
				* result
				+ (getDthralteracao() == null ? 0 : this.getDthralteracao()
						.hashCode());
		result = 37
				* result
				+ (getCdusuarioexclusao() == null ? 0 : this
						.getCdusuarioexclusao().hashCode());
		result = 37
				* result
				+ (getDthrexclusao() == null ? 0 : this.getDthrexclusao()
						.hashCode());
		result = 37
				* result
				+ (getDthriniintervalo() == null ? 0 : this
						.getDthriniintervalo().hashCode());
		return result;
	}

}

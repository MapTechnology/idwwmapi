package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjoplogId generated by hbm2java
 */
@Embeddable
public class IjoplogId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2115727423855874548L;
	private String nrop;
	private String nrplano;
	private String cdinjetora;
	private double nrseq;
	private String cdmolde;
	private String cdestrutura;
	private Date dthriprevista;
	private Date dthrireal;
	private String stop;
	private Date dthrfprevista;
	private Date dthrsaida;
	private Date dthrpriciclo;
	private Character tpordemproducao;
	private Date dtentrega;
	private BigDecimal numsmnentrega;
	private String nropcoorp;
	private Character tpacabamento;
	private Character opcritica;
	private String nropestendido;
	private double toleranciaplano;
	private Date dthrmanut;
	private char tpmanut;
	private String cdusuresp;

	public IjoplogId() {
	}

	public IjoplogId(String nrop, String nrplano, String cdinjetora,
			double nrseq, String cdmolde, String cdestrutura,
			Date dthriprevista, String nropestendido, double toleranciaplano,
			Date dthrmanut, char tpmanut, String cdusuresp) {
		this.nrop = nrop;
		this.nrplano = nrplano;
		this.cdinjetora = cdinjetora;
		this.nrseq = nrseq;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthriprevista = dthriprevista;
		this.nropestendido = nropestendido;
		this.toleranciaplano = toleranciaplano;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	public IjoplogId(String nrop, String nrplano, String cdinjetora,
			double nrseq, String cdmolde, String cdestrutura,
			Date dthriprevista, Date dthrireal, String stop,
			Date dthrfprevista, Date dthrsaida, Date dthrpriciclo,
			Character tpordemproducao, Date dtentrega,
			BigDecimal numsmnentrega, String nropcoorp, Character tpacabamento,
			Character opcritica, String nropestendido, double toleranciaplano,
			Date dthrmanut, char tpmanut, String cdusuresp) {
		this.nrop = nrop;
		this.nrplano = nrplano;
		this.cdinjetora = cdinjetora;
		this.nrseq = nrseq;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dthriprevista = dthriprevista;
		this.dthrireal = dthrireal;
		this.stop = stop;
		this.dthrfprevista = dthrfprevista;
		this.dthrsaida = dthrsaida;
		this.dthrpriciclo = dthrpriciclo;
		this.tpordemproducao = tpordemproducao;
		this.dtentrega = dtentrega;
		this.numsmnentrega = numsmnentrega;
		this.nropcoorp = nropcoorp;
		this.tpacabamento = tpacabamento;
		this.opcritica = opcritica;
		this.nropestendido = nropestendido;
		this.toleranciaplano = toleranciaplano;
		this.dthrmanut = dthrmanut;
		this.tpmanut = tpmanut;
		this.cdusuresp = cdusuresp;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "NRPLANO", nullable = false, length = 10)
	public String getNrplano() {
		return this.nrplano;
	}

	public void setNrplano(String nrplano) {
		this.nrplano = nrplano;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "NRSEQ", nullable = false, precision = 126, scale = 0)
	public double getNrseq() {
		return this.nrseq;
	}

	public void setNrseq(double nrseq) {
		this.nrseq = nrseq;
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

	@Column(name = "DTHRIPREVISTA", nullable = false, length = 7)
	public Date getDthriprevista() {
		return this.dthriprevista;
	}

	public void setDthriprevista(Date dthriprevista) {
		this.dthriprevista = dthriprevista;
	}

	@Column(name = "DTHRIREAL", length = 7)
	public Date getDthrireal() {
		return this.dthrireal;
	}

	public void setDthrireal(Date dthrireal) {
		this.dthrireal = dthrireal;
	}

	@Column(name = "STOP", length = 1)
	public String getStop() {
		return this.stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	@Column(name = "DTHRFPREVISTA", length = 7)
	public Date getDthrfprevista() {
		return this.dthrfprevista;
	}

	public void setDthrfprevista(Date dthrfprevista) {
		this.dthrfprevista = dthrfprevista;
	}

	@Column(name = "DTHRSAIDA", length = 7)
	public Date getDthrsaida() {
		return this.dthrsaida;
	}

	public void setDthrsaida(Date dthrsaida) {
		this.dthrsaida = dthrsaida;
	}

	@Column(name = "DTHRPRICICLO", length = 7)
	public Date getDthrpriciclo() {
		return this.dthrpriciclo;
	}

	public void setDthrpriciclo(Date dthrpriciclo) {
		this.dthrpriciclo = dthrpriciclo;
	}

	@Column(name = "TPORDEMPRODUCAO", length = 1)
	public Character getTpordemproducao() {
		return this.tpordemproducao;
	}

	public void setTpordemproducao(Character tpordemproducao) {
		this.tpordemproducao = tpordemproducao;
	}

	@Column(name = "DTENTREGA", length = 7)
	public Date getDtentrega() {
		return this.dtentrega;
	}

	public void setDtentrega(Date dtentrega) {
		this.dtentrega = dtentrega;
	}

	@Column(name = "NUMSMNENTREGA", precision = 22, scale = 0)
	public BigDecimal getNumsmnentrega() {
		return this.numsmnentrega;
	}

	public void setNumsmnentrega(BigDecimal numsmnentrega) {
		this.numsmnentrega = numsmnentrega;
	}

	@Column(name = "NROPCOORP", length = 10)
	public String getNropcoorp() {
		return this.nropcoorp;
	}

	public void setNropcoorp(String nropcoorp) {
		this.nropcoorp = nropcoorp;
	}

	@Column(name = "TPACABAMENTO", length = 1)
	public Character getTpacabamento() {
		return this.tpacabamento;
	}

	public void setTpacabamento(Character tpacabamento) {
		this.tpacabamento = tpacabamento;
	}

	@Column(name = "OPCRITICA", length = 1)
	public Character getOpcritica() {
		return this.opcritica;
	}

	public void setOpcritica(Character opcritica) {
		this.opcritica = opcritica;
	}

	@Column(name = "NROPESTENDIDO", nullable = false, length = 25)
	public String getNropestendido() {
		return this.nropestendido;
	}

	public void setNropestendido(String nropestendido) {
		this.nropestendido = nropestendido;
	}

	@Column(name = "TOLERANCIAPLANO", nullable = false, precision = 126, scale = 0)
	public double getToleranciaplano() {
		return this.toleranciaplano;
	}

	public void setToleranciaplano(double toleranciaplano) {
		this.toleranciaplano = toleranciaplano;
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
		if (!(other instanceof IjoplogId))
			return false;
		IjoplogId castOther = (IjoplogId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getNrplano() == castOther.getNrplano()) || (this
						.getNrplano() != null && castOther.getNrplano() != null && this
						.getNrplano().equals(castOther.getNrplano())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& (this.getNrseq() == castOther.getNrseq())
				&& ((this.getCdmolde() == castOther.getCdmolde()) || (this
						.getCdmolde() != null && castOther.getCdmolde() != null && this
						.getCdmolde().equals(castOther.getCdmolde())))
				&& ((this.getCdestrutura() == castOther.getCdestrutura()) || (this
						.getCdestrutura() != null
						&& castOther.getCdestrutura() != null && this
						.getCdestrutura().equals(castOther.getCdestrutura())))
				&& ((this.getDthriprevista() == castOther.getDthriprevista()) || (this
						.getDthriprevista() != null
						&& castOther.getDthriprevista() != null && this
						.getDthriprevista()
						.equals(castOther.getDthriprevista())))
				&& ((this.getDthrireal() == castOther.getDthrireal()) || (this
						.getDthrireal() != null
						&& castOther.getDthrireal() != null && this
						.getDthrireal().equals(castOther.getDthrireal())))
				&& ((this.getStop() == castOther.getStop()) || (this.getStop() != null
						&& castOther.getStop() != null && this.getStop()
						.equals(castOther.getStop())))
				&& ((this.getDthrfprevista() == castOther.getDthrfprevista()) || (this
						.getDthrfprevista() != null
						&& castOther.getDthrfprevista() != null && this
						.getDthrfprevista()
						.equals(castOther.getDthrfprevista())))
				&& ((this.getDthrsaida() == castOther.getDthrsaida()) || (this
						.getDthrsaida() != null
						&& castOther.getDthrsaida() != null && this
						.getDthrsaida().equals(castOther.getDthrsaida())))
				&& ((this.getDthrpriciclo() == castOther.getDthrpriciclo()) || (this
						.getDthrpriciclo() != null
						&& castOther.getDthrpriciclo() != null && this
						.getDthrpriciclo().equals(castOther.getDthrpriciclo())))
				&& ((this.getTpordemproducao() == castOther
						.getTpordemproducao()) || (this.getTpordemproducao() != null
						&& castOther.getTpordemproducao() != null && this
						.getTpordemproducao().equals(
								castOther.getTpordemproducao())))
				&& ((this.getDtentrega() == castOther.getDtentrega()) || (this
						.getDtentrega() != null
						&& castOther.getDtentrega() != null && this
						.getDtentrega().equals(castOther.getDtentrega())))
				&& ((this.getNumsmnentrega() == castOther.getNumsmnentrega()) || (this
						.getNumsmnentrega() != null
						&& castOther.getNumsmnentrega() != null && this
						.getNumsmnentrega()
						.equals(castOther.getNumsmnentrega())))
				&& ((this.getNropcoorp() == castOther.getNropcoorp()) || (this
						.getNropcoorp() != null
						&& castOther.getNropcoorp() != null && this
						.getNropcoorp().equals(castOther.getNropcoorp())))
				&& ((this.getTpacabamento() == castOther.getTpacabamento()) || (this
						.getTpacabamento() != null
						&& castOther.getTpacabamento() != null && this
						.getTpacabamento().equals(castOther.getTpacabamento())))
				&& ((this.getOpcritica() == castOther.getOpcritica()) || (this
						.getOpcritica() != null
						&& castOther.getOpcritica() != null && this
						.getOpcritica().equals(castOther.getOpcritica())))
				&& ((this.getNropestendido() == castOther.getNropestendido()) || (this
						.getNropestendido() != null
						&& castOther.getNropestendido() != null && this
						.getNropestendido()
						.equals(castOther.getNropestendido())))
				&& (this.getToleranciaplano() == castOther.getToleranciaplano())
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

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getNrplano() == null ? 0 : this.getNrplano().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result + (int) this.getNrseq();
		result = 37 * result
				+ (getCdmolde() == null ? 0 : this.getCdmolde().hashCode());
		result = 37
				* result
				+ (getCdestrutura() == null ? 0 : this.getCdestrutura()
						.hashCode());
		result = 37
				* result
				+ (getDthriprevista() == null ? 0 : this.getDthriprevista()
						.hashCode());
		result = 37 * result
				+ (getDthrireal() == null ? 0 : this.getDthrireal().hashCode());
		result = 37 * result
				+ (getStop() == null ? 0 : this.getStop().hashCode());
		result = 37
				* result
				+ (getDthrfprevista() == null ? 0 : this.getDthrfprevista()
						.hashCode());
		result = 37 * result
				+ (getDthrsaida() == null ? 0 : this.getDthrsaida().hashCode());
		result = 37
				* result
				+ (getDthrpriciclo() == null ? 0 : this.getDthrpriciclo()
						.hashCode());
		result = 37
				* result
				+ (getTpordemproducao() == null ? 0 : this.getTpordemproducao()
						.hashCode());
		result = 37 * result
				+ (getDtentrega() == null ? 0 : this.getDtentrega().hashCode());
		result = 37
				* result
				+ (getNumsmnentrega() == null ? 0 : this.getNumsmnentrega()
						.hashCode());
		result = 37 * result
				+ (getNropcoorp() == null ? 0 : this.getNropcoorp().hashCode());
		result = 37
				* result
				+ (getTpacabamento() == null ? 0 : this.getTpacabamento()
						.hashCode());
		result = 37 * result
				+ (getOpcritica() == null ? 0 : this.getOpcritica().hashCode());
		result = 37
				* result
				+ (getNropestendido() == null ? 0 : this.getNropestendido()
						.hashCode());
		result = 37 * result + (int) this.getToleranciaplano();
		result = 37 * result
				+ (getDthrmanut() == null ? 0 : this.getDthrmanut().hashCode());
		result = 37 * result + this.getTpmanut();
		result = 37 * result
				+ (getCdusuresp() == null ? 0 : this.getCdusuresp().hashCode());
		return result;
	}

}

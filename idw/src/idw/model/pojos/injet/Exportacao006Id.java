package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exportacao006Id generated by hbm2java
 */
@Embeddable
public class Exportacao006Id implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 778493606007896902L;
	private String nrop;
	private String cdinjetora;
	private String cdmolde;
	private BigDecimal qtdciclos;
	private Date dthrfec;
	private String idplanta;
	private char idareaproducao;
	private char status;

	public Exportacao006Id() {
	}

	public Exportacao006Id(String nrop, String cdinjetora, String cdmolde,
			BigDecimal qtdciclos, String idplanta, char idareaproducao,
			char status) {
		this.nrop = nrop;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.qtdciclos = qtdciclos;
		this.idplanta = idplanta;
		this.idareaproducao = idareaproducao;
		this.status = status;
	}

	public Exportacao006Id(String nrop, String cdinjetora, String cdmolde,
			BigDecimal qtdciclos, Date dthrfec, String idplanta,
			char idareaproducao, char status) {
		this.nrop = nrop;
		this.cdinjetora = cdinjetora;
		this.cdmolde = cdmolde;
		this.qtdciclos = qtdciclos;
		this.dthrfec = dthrfec;
		this.idplanta = idplanta;
		this.idareaproducao = idareaproducao;
		this.status = status;
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

	@Column(name = "QTDCICLOS", nullable = false, precision = 30, scale = 15)
	public BigDecimal getQtdciclos() {
		return this.qtdciclos;
	}

	public void setQtdciclos(BigDecimal qtdciclos) {
		this.qtdciclos = qtdciclos;
	}

	@Column(name = "DTHRFEC", length = 7)
	public Date getDthrfec() {
		return this.dthrfec;
	}

	public void setDthrfec(Date dthrfec) {
		this.dthrfec = dthrfec;
	}

	@Column(name = "IDPLANTA", nullable = false, length = 3)
	public String getIdplanta() {
		return this.idplanta;
	}

	public void setIdplanta(String idplanta) {
		this.idplanta = idplanta;
	}

	@Column(name = "IDAREAPRODUCAO", nullable = false, length = 1)
	public char getIdareaproducao() {
		return this.idareaproducao;
	}

	public void setIdareaproducao(char idareaproducao) {
		this.idareaproducao = idareaproducao;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exportacao006Id))
			return false;
		Exportacao006Id castOther = (Exportacao006Id) other;

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
				&& ((this.getQtdciclos() == castOther.getQtdciclos()) || (this
						.getQtdciclos() != null
						&& castOther.getQtdciclos() != null && this
						.getQtdciclos().equals(castOther.getQtdciclos())))
				&& ((this.getDthrfec() == castOther.getDthrfec()) || (this
						.getDthrfec() != null && castOther.getDthrfec() != null && this
						.getDthrfec().equals(castOther.getDthrfec())))
				&& ((this.getIdplanta() == castOther.getIdplanta()) || (this
						.getIdplanta() != null
						&& castOther.getIdplanta() != null && this
						.getIdplanta().equals(castOther.getIdplanta())))
				&& (this.getIdareaproducao() == castOther.getIdareaproducao())
				&& (this.getStatus() == castOther.getStatus());
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
		result = 37 * result
				+ (getQtdciclos() == null ? 0 : this.getQtdciclos().hashCode());
		result = 37 * result
				+ (getDthrfec() == null ? 0 : this.getDthrfec().hashCode());
		result = 37 * result
				+ (getIdplanta() == null ? 0 : this.getIdplanta().hashCode());
		result = 37 * result + this.getIdareaproducao();
		result = 37 * result + this.getStatus();
		return result;
	}

}
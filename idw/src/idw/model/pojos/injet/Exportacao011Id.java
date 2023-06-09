package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exportacao011Id generated by hbm2java
 */
@Embeddable
public class Exportacao011Id implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5865006919121432991L;
	private String nrop;
	private Date dtturno;
	private String cdturno;
	private String cdinjetora;
	private String cdoperador;
	private String cdparada;
	private Date dthrinipar;
	private Date dthrfimpar;
	private double duracao;
	private String stpar;
	private Date dthrcriacao;
	private Date dthrleitura;
	private String stexportacao;

	public Exportacao011Id() {
	}

	public Exportacao011Id(String nrop, Date dtturno, String cdturno,
			String cdinjetora, String cdparada, Date dthrinipar,
			Date dthrfimpar, double duracao, String stpar, Date dthrcriacao,
			String stexportacao) {
		this.nrop = nrop;
		this.dtturno = dtturno;
		this.cdturno = cdturno;
		this.cdinjetora = cdinjetora;
		this.cdparada = cdparada;
		this.dthrinipar = dthrinipar;
		this.dthrfimpar = dthrfimpar;
		this.duracao = duracao;
		this.stpar = stpar;
		this.dthrcriacao = dthrcriacao;
		this.stexportacao = stexportacao;
	}

	public Exportacao011Id(String nrop, Date dtturno, String cdturno,
			String cdinjetora, String cdoperador, String cdparada,
			Date dthrinipar, Date dthrfimpar, double duracao, String stpar,
			Date dthrcriacao, Date dthrleitura, String stexportacao) {
		this.nrop = nrop;
		this.dtturno = dtturno;
		this.cdturno = cdturno;
		this.cdinjetora = cdinjetora;
		this.cdoperador = cdoperador;
		this.cdparada = cdparada;
		this.dthrinipar = dthrinipar;
		this.dthrfimpar = dthrfimpar;
		this.duracao = duracao;
		this.stpar = stpar;
		this.dthrcriacao = dthrcriacao;
		this.dthrleitura = dthrleitura;
		this.stexportacao = stexportacao;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
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

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "CDOPERADOR", length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "CDPARADA", nullable = false, length = 6)
	public String getCdparada() {
		return this.cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	@Column(name = "DTHRINIPAR", nullable = false, length = 7)
	public Date getDthrinipar() {
		return this.dthrinipar;
	}

	public void setDthrinipar(Date dthrinipar) {
		this.dthrinipar = dthrinipar;
	}

	@Column(name = "DTHRFIMPAR", nullable = false, length = 7)
	public Date getDthrfimpar() {
		return this.dthrfimpar;
	}

	public void setDthrfimpar(Date dthrfimpar) {
		this.dthrfimpar = dthrfimpar;
	}

	@Column(name = "DURACAO", nullable = false, precision = 126, scale = 0)
	public double getDuracao() {
		return this.duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	@Column(name = "STPAR", nullable = false, length = 1)
	public String getStpar() {
		return this.stpar;
	}

	public void setStpar(String stpar) {
		this.stpar = stpar;
	}

	@Column(name = "DTHRCRIACAO", nullable = false, length = 7)
	public Date getDthrcriacao() {
		return this.dthrcriacao;
	}

	public void setDthrcriacao(Date dthrcriacao) {
		this.dthrcriacao = dthrcriacao;
	}

	@Column(name = "DTHRLEITURA", length = 7)
	public Date getDthrleitura() {
		return this.dthrleitura;
	}

	public void setDthrleitura(Date dthrleitura) {
		this.dthrleitura = dthrleitura;
	}

	@Column(name = "STEXPORTACAO", nullable = false, length = 1)
	public String getStexportacao() {
		return this.stexportacao;
	}

	public void setStexportacao(String stexportacao) {
		this.stexportacao = stexportacao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exportacao011Id))
			return false;
		Exportacao011Id castOther = (Exportacao011Id) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getDtturno() == castOther.getDtturno()) || (this
						.getDtturno() != null && castOther.getDtturno() != null && this
						.getDtturno().equals(castOther.getDtturno())))
				&& ((this.getCdturno() == castOther.getCdturno()) || (this
						.getCdturno() != null && castOther.getCdturno() != null && this
						.getCdturno().equals(castOther.getCdturno())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& ((this.getCdoperador() == castOther.getCdoperador()) || (this
						.getCdoperador() != null
						&& castOther.getCdoperador() != null && this
						.getCdoperador().equals(castOther.getCdoperador())))
				&& ((this.getCdparada() == castOther.getCdparada()) || (this
						.getCdparada() != null
						&& castOther.getCdparada() != null && this
						.getCdparada().equals(castOther.getCdparada())))
				&& ((this.getDthrinipar() == castOther.getDthrinipar()) || (this
						.getDthrinipar() != null
						&& castOther.getDthrinipar() != null && this
						.getDthrinipar().equals(castOther.getDthrinipar())))
				&& ((this.getDthrfimpar() == castOther.getDthrfimpar()) || (this
						.getDthrfimpar() != null
						&& castOther.getDthrfimpar() != null && this
						.getDthrfimpar().equals(castOther.getDthrfimpar())))
				&& (this.getDuracao() == castOther.getDuracao())
				&& ((this.getStpar() == castOther.getStpar()) || (this
						.getStpar() != null && castOther.getStpar() != null && this
						.getStpar().equals(castOther.getStpar())))
				&& ((this.getDthrcriacao() == castOther.getDthrcriacao()) || (this
						.getDthrcriacao() != null
						&& castOther.getDthrcriacao() != null && this
						.getDthrcriacao().equals(castOther.getDthrcriacao())))
				&& ((this.getDthrleitura() == castOther.getDthrleitura()) || (this
						.getDthrleitura() != null
						&& castOther.getDthrleitura() != null && this
						.getDthrleitura().equals(castOther.getDthrleitura())))
				&& ((this.getStexportacao() == castOther.getStexportacao()) || (this
						.getStexportacao() != null
						&& castOther.getStexportacao() != null && this
						.getStexportacao().equals(castOther.getStexportacao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getDtturno() == null ? 0 : this.getDtturno().hashCode());
		result = 37 * result
				+ (getCdturno() == null ? 0 : this.getCdturno().hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37
				* result
				+ (getCdoperador() == null ? 0 : this.getCdoperador()
						.hashCode());
		result = 37 * result
				+ (getCdparada() == null ? 0 : this.getCdparada().hashCode());
		result = 37
				* result
				+ (getDthrinipar() == null ? 0 : this.getDthrinipar()
						.hashCode());
		result = 37
				* result
				+ (getDthrfimpar() == null ? 0 : this.getDthrfimpar()
						.hashCode());
		result = 37 * result + (int) this.getDuracao();
		result = 37 * result
				+ (getStpar() == null ? 0 : this.getStpar().hashCode());
		result = 37
				* result
				+ (getDthrcriacao() == null ? 0 : this.getDthrcriacao()
						.hashCode());
		result = 37
				* result
				+ (getDthrleitura() == null ? 0 : this.getDthrleitura()
						.hashCode());
		result = 37
				* result
				+ (getStexportacao() == null ? 0 : this.getStexportacao()
						.hashCode());
		return result;
	}

}

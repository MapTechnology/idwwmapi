package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exportacao016Id generated by hbm2java
 */
@Embeddable
public class Exportacao016Id implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1652679457821467078L;
	private String cdbarrasproduto;
	private String cdbarrascaixa;
	private char stapontamento;
	private char stregistro;
	private Date dthrcriacao;
	private Date dthrleitura;

	public Exportacao016Id() {
	}

	public Exportacao016Id(String cdbarrasproduto, String cdbarrascaixa,
			char stapontamento, char stregistro, Date dthrcriacao) {
		this.cdbarrasproduto = cdbarrasproduto;
		this.cdbarrascaixa = cdbarrascaixa;
		this.stapontamento = stapontamento;
		this.stregistro = stregistro;
		this.dthrcriacao = dthrcriacao;
	}

	public Exportacao016Id(String cdbarrasproduto, String cdbarrascaixa,
			char stapontamento, char stregistro, Date dthrcriacao,
			Date dthrleitura) {
		this.cdbarrasproduto = cdbarrasproduto;
		this.cdbarrascaixa = cdbarrascaixa;
		this.stapontamento = stapontamento;
		this.stregistro = stregistro;
		this.dthrcriacao = dthrcriacao;
		this.dthrleitura = dthrleitura;
	}

	@Column(name = "CDBARRASPRODUTO", nullable = false, length = 50)
	public String getCdbarrasproduto() {
		return this.cdbarrasproduto;
	}

	public void setCdbarrasproduto(String cdbarrasproduto) {
		this.cdbarrasproduto = cdbarrasproduto;
	}

	@Column(name = "CDBARRASCAIXA", nullable = false, length = 50)
	public String getCdbarrascaixa() {
		return this.cdbarrascaixa;
	}

	public void setCdbarrascaixa(String cdbarrascaixa) {
		this.cdbarrascaixa = cdbarrascaixa;
	}

	@Column(name = "STAPONTAMENTO", nullable = false, length = 1)
	public char getStapontamento() {
		return this.stapontamento;
	}

	public void setStapontamento(char stapontamento) {
		this.stapontamento = stapontamento;
	}

	@Column(name = "STREGISTRO", nullable = false, length = 1)
	public char getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(char stregistro) {
		this.stregistro = stregistro;
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

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exportacao016Id))
			return false;
		Exportacao016Id castOther = (Exportacao016Id) other;

		return ((this.getCdbarrasproduto() == castOther.getCdbarrasproduto()) || (this
				.getCdbarrasproduto() != null
				&& castOther.getCdbarrasproduto() != null && this
				.getCdbarrasproduto().equals(castOther.getCdbarrasproduto())))
				&& ((this.getCdbarrascaixa() == castOther.getCdbarrascaixa()) || (this
						.getCdbarrascaixa() != null
						&& castOther.getCdbarrascaixa() != null && this
						.getCdbarrascaixa()
						.equals(castOther.getCdbarrascaixa())))
				&& (this.getStapontamento() == castOther.getStapontamento())
				&& (this.getStregistro() == castOther.getStregistro())
				&& ((this.getDthrcriacao() == castOther.getDthrcriacao()) || (this
						.getDthrcriacao() != null
						&& castOther.getDthrcriacao() != null && this
						.getDthrcriacao().equals(castOther.getDthrcriacao())))
				&& ((this.getDthrleitura() == castOther.getDthrleitura()) || (this
						.getDthrleitura() != null
						&& castOther.getDthrleitura() != null && this
						.getDthrleitura().equals(castOther.getDthrleitura())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdbarrasproduto() == null ? 0 : this.getCdbarrasproduto()
						.hashCode());
		result = 37
				* result
				+ (getCdbarrascaixa() == null ? 0 : this.getCdbarrascaixa()
						.hashCode());
		result = 37 * result + this.getStapontamento();
		result = 37 * result + this.getStregistro();
		result = 37
				* result
				+ (getDthrcriacao() == null ? 0 : this.getDthrcriacao()
						.hashCode());
		result = 37
				* result
				+ (getDthrleitura() == null ? 0 : this.getDthrleitura()
						.hashCode());
		return result;
	}

}

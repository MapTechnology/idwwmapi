package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exportacao018AuxId generated by hbm2java
 */
@Embeddable
public class Exportacao018AuxId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4978243746168985006L;
	private String dtrefturno;
	private char cdturno;
	private String cdoperador;
	private String cdmaquina;
	private String cdproduto;
	private Date dthriparada;

	public Exportacao018AuxId() {
	}

	public Exportacao018AuxId(String dtrefturno, char cdturno,
			String cdoperador, String cdmaquina, String cdproduto,
			Date dthriparada) {
		this.dtrefturno = dtrefturno;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.cdmaquina = cdmaquina;
		this.cdproduto = cdproduto;
		this.dthriparada = dthriparada;
	}

	@Column(name = "DTREFTURNO", nullable = false, length = 8)
	public String getDtrefturno() {
		return this.dtrefturno;
	}

	public void setDtrefturno(String dtrefturno) {
		this.dtrefturno = dtrefturno;
	}

	@Column(name = "CDTURNO", nullable = false, length = 1)
	public char getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(char cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "CDOPERADOR", nullable = false, length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "CDMAQUINA", nullable = false, length = 6)
	public String getCdmaquina() {
		return this.cdmaquina;
	}

	public void setCdmaquina(String cdmaquina) {
		this.cdmaquina = cdmaquina;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "DTHRIPARADA", nullable = false, length = 7)
	public Date getDthriparada() {
		return this.dthriparada;
	}

	public void setDthriparada(Date dthriparada) {
		this.dthriparada = dthriparada;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exportacao018AuxId))
			return false;
		Exportacao018AuxId castOther = (Exportacao018AuxId) other;

		return ((this.getDtrefturno() == castOther.getDtrefturno()) || (this
				.getDtrefturno() != null && castOther.getDtrefturno() != null && this
				.getDtrefturno().equals(castOther.getDtrefturno())))
				&& (this.getCdturno() == castOther.getCdturno())
				&& ((this.getCdoperador() == castOther.getCdoperador()) || (this
						.getCdoperador() != null
						&& castOther.getCdoperador() != null && this
						.getCdoperador().equals(castOther.getCdoperador())))
				&& ((this.getCdmaquina() == castOther.getCdmaquina()) || (this
						.getCdmaquina() != null
						&& castOther.getCdmaquina() != null && this
						.getCdmaquina().equals(castOther.getCdmaquina())))
				&& ((this.getCdproduto() == castOther.getCdproduto()) || (this
						.getCdproduto() != null
						&& castOther.getCdproduto() != null && this
						.getCdproduto().equals(castOther.getCdproduto())))
				&& ((this.getDthriparada() == castOther.getDthriparada()) || (this
						.getDthriparada() != null
						&& castOther.getDthriparada() != null && this
						.getDthriparada().equals(castOther.getDthriparada())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDtrefturno() == null ? 0 : this.getDtrefturno()
						.hashCode());
		result = 37 * result + this.getCdturno();
		result = 37
				* result
				+ (getCdoperador() == null ? 0 : this.getCdoperador()
						.hashCode());
		result = 37 * result
				+ (getCdmaquina() == null ? 0 : this.getCdmaquina().hashCode());
		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37
				* result
				+ (getDthriparada() == null ? 0 : this.getDthriparada()
						.hashCode());
		return result;
	}

}

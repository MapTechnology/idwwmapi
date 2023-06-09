package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ijinjcfgmetamonit generated by hbm2java
 */
@Entity
@Table(name = "IJINJCFGMETAMONIT", uniqueConstraints = @UniqueConstraint(columnNames = "CDINJETORA"))
public class Ijinjcfgmetamonit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1717923599278248579L;
	private double idregistro;
	private Ijtbinj ijtbinj;
	private double eficrealizacao;
	private double eficciclo;

	public Ijinjcfgmetamonit() {
	}

	public Ijinjcfgmetamonit(double idregistro, Ijtbinj ijtbinj,
			double eficrealizacao, double eficciclo) {
		this.idregistro = idregistro;
		this.ijtbinj = ijtbinj;
		this.eficrealizacao = eficrealizacao;
		this.eficciclo = eficciclo;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(double idregistro) {
		this.idregistro = idregistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", unique = true, nullable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Column(name = "EFICREALIZACAO", nullable = false, precision = 126, scale = 0)
	public double getEficrealizacao() {
		return this.eficrealizacao;
	}

	public void setEficrealizacao(double eficrealizacao) {
		this.eficrealizacao = eficrealizacao;
	}

	@Column(name = "EFICCICLO", nullable = false, precision = 126, scale = 0)
	public double getEficciclo() {
		return this.eficciclo;
	}

	public void setEficciclo(double eficciclo) {
		this.eficciclo = eficciclo;
	}

}

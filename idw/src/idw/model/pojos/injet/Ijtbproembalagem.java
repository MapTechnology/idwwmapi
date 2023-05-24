package idw.model.pojos.injet;

// Generated 31/08/2013 11:49:38 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbproembalagem generated by hbm2java
 */
@Entity
@Table(name = "IJTBPROEMBALAGEM")
public class Ijtbproembalagem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -256622207708837345L;
	private BigDecimal idregistro;
	private Ijtbpro ijtbpro;
	private double taraembalagem;
	private double liminfpesoproduto;
	private double limsuppesoproduto;

	public Ijtbproembalagem() {
	}

	public Ijtbproembalagem(BigDecimal idregistro, Ijtbpro ijtbpro,
			double taraembalagem, double liminfpesoproduto,
			double limsuppesoproduto) {
		this.idregistro = idregistro;
		this.ijtbpro = ijtbpro;
		this.taraembalagem = taraembalagem;
		this.liminfpesoproduto = liminfpesoproduto;
		this.limsuppesoproduto = limsuppesoproduto;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(BigDecimal idregistro) {
		this.idregistro = idregistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@Column(name = "TARAEMBALAGEM", nullable = false, precision = 126, scale = 0)
	public double getTaraembalagem() {
		return this.taraembalagem;
	}

	public void setTaraembalagem(double taraembalagem) {
		this.taraembalagem = taraembalagem;
	}

	@Column(name = "LIMINFPESOPRODUTO", nullable = false, precision = 126, scale = 0)
	public double getLiminfpesoproduto() {
		return this.liminfpesoproduto;
	}

	public void setLiminfpesoproduto(double liminfpesoproduto) {
		this.liminfpesoproduto = liminfpesoproduto;
	}

	@Column(name = "LIMSUPPESOPRODUTO", nullable = false, precision = 126, scale = 0)
	public double getLimsuppesoproduto() {
		return this.limsuppesoproduto;
	}

	public void setLimsuppesoproduto(double limsuppesoproduto) {
		this.limsuppesoproduto = limsuppesoproduto;
	}

}

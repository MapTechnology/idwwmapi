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
 * Ijdeparapro generated by hbm2java
 */
@Entity
@Table(name = "IJDEPARAPRO", uniqueConstraints = @UniqueConstraint(columnNames = "CDPRODUTO"))
public class Ijdeparapro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5102056438048752005L;
	private String cdprodutoauxiliar;
	private Ijtbpro ijtbpro;

	public Ijdeparapro() {
	}

	public Ijdeparapro(String cdprodutoauxiliar) {
		this.cdprodutoauxiliar = cdprodutoauxiliar;
	}

	public Ijdeparapro(String cdprodutoauxiliar, Ijtbpro ijtbpro) {
		this.cdprodutoauxiliar = cdprodutoauxiliar;
		this.ijtbpro = ijtbpro;
	}

	@Id
	@Column(name = "CDPRODUTOAUXILIAR", unique = true, nullable = false, length = 30)
	public String getCdprodutoauxiliar() {
		return this.cdprodutoauxiliar;
	}

	public void setCdprodutoauxiliar(String cdprodutoauxiliar) {
		this.cdprodutoauxiliar = cdprodutoauxiliar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", unique = true)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

}
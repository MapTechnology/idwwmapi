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
 * Ijtbinjauxdrvcelc generated by hbm2java
 */
@Entity
@Table(name = "IJTBINJAUXDRVCELC", uniqueConstraints = @UniqueConstraint(columnNames = "IDAUXDRIVERCELCAR"))
public class Ijtbinjauxdrvcelc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4998001091488881303L;
	private String cdinjetora;
	private Ijtbinj ijtbinj;
	private String idauxdrivercelcar;

	public Ijtbinjauxdrvcelc() {
	}

	public Ijtbinjauxdrvcelc(String cdinjetora, Ijtbinj ijtbinj,
			String idauxdrivercelcar) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
		this.idauxdrivercelcar = idauxdrivercelcar;
	}

	@Id
	@Column(name = "CDINJETORA", unique = true, nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Column(name = "IDAUXDRIVERCELCAR", unique = true, nullable = false, length = 50)
	public String getIdauxdrivercelcar() {
		return this.idauxdrivercelcar;
	}

	public void setIdauxdrivercelcar(String idauxdrivercelcar) {
		this.idauxdrivercelcar = idauxdrivercelcar;
	}

}
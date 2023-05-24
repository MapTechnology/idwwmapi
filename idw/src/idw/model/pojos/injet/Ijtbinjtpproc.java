package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbinjtpproc generated by hbm2java
 */
@Entity
@Table(name = "IJTBINJTPPROC")
public class Ijtbinjtpproc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046307169514831549L;
	private String cdinjetora;
	private Ijtbtpproc ijtbtpproc;
	private Ijtbinj ijtbinj;

	public Ijtbinjtpproc() {
	}

	public Ijtbinjtpproc(String cdinjetora, Ijtbtpproc ijtbtpproc,
			Ijtbinj ijtbinj) {
		this.cdinjetora = cdinjetora;
		this.ijtbtpproc = ijtbtpproc;
		this.ijtbinj = ijtbinj;
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
	@JoinColumn(name = "CDTPPROC", nullable = false)
	public Ijtbtpproc getIjtbtpproc() {
		return this.ijtbtpproc;
	}

	public void setIjtbtpproc(Ijtbtpproc ijtbtpproc) {
		this.ijtbtpproc = ijtbtpproc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

}
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
 * Ijtbinjsincparprog generated by hbm2java
 */
@Entity
@Table(name = "IJTBINJSINCPARPROG")
public class Ijtbinjsincparprog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5295292532886166786L;
	private String cdinjetora;
	private Ijtbinj ijtbinj;
	private char stsincronismo;

	public Ijtbinjsincparprog() {
	}

	public Ijtbinjsincparprog(String cdinjetora, Ijtbinj ijtbinj,
			char stsincronismo) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
		this.stsincronismo = stsincronismo;
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

	@Column(name = "STSINCRONISMO", nullable = false, length = 1)
	public char getStsincronismo() {
		return this.stsincronismo;
	}

	public void setStsincronismo(char stsincronismo) {
		this.stsincronismo = stsincronismo;
	}

}
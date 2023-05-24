package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijctrlultturmaq generated by hbm2java
 */
@Entity
@Table(name = "IJCTRLULTTURMAQ")
public class Ijctrlultturmaq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5542247531225783845L;
	private String cdinjetora;
	private Ijtbinj ijtbinj;
	private Date dtturno;
	private String cdturno;
	private Date dthriturno;
	private Date dthrfturno;

	public Ijctrlultturmaq() {
	}

	public Ijctrlultturmaq(String cdinjetora, Ijtbinj ijtbinj) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
	}

	public Ijctrlultturmaq(String cdinjetora, Ijtbinj ijtbinj, Date dtturno,
			String cdturno, Date dthriturno, Date dthrfturno) {
		this.cdinjetora = cdinjetora;
		this.ijtbinj = ijtbinj;
		this.dtturno = dtturno;
		this.cdturno = cdturno;
		this.dthriturno = dthriturno;
		this.dthrfturno = dthrfturno;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "DTTURNO", length = 7)
	public Date getDtturno() {
		return this.dtturno;
	}

	public void setDtturno(Date dtturno) {
		this.dtturno = dtturno;
	}

	@Column(name = "CDTURNO", length = 6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRITURNO", length = 7)
	public Date getDthriturno() {
		return this.dthriturno;
	}

	public void setDthriturno(Date dthriturno) {
		this.dthriturno = dthriturno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFTURNO", length = 7)
	public Date getDthrfturno() {
		return this.dthrfturno;
	}

	public void setDthrfturno(Date dthrfturno) {
		this.dthrfturno = dthrfturno;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijparprog generated by hbm2java
 */
@Entity
@Table(name = "IJPARPROG")
public class Ijparprog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923609899682415760L;
	private IjparprogId id;
	private Ijtbinj ijtbinj;
	private Date dthrfinal;
	private String dsparprog;
	private BigDecimal origemparprog;
	private Set<Ijparprogos> ijparprogoses = new HashSet<Ijparprogos>(0);

	public Ijparprog() {
	}

	public Ijparprog(IjparprogId id, Ijtbinj ijtbinj, BigDecimal origemparprog) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.origemparprog = origemparprog;
	}

	public Ijparprog(IjparprogId id, Ijtbinj ijtbinj, Date dthrfinal,
			String dsparprog, BigDecimal origemparprog,
			Set<Ijparprogos> ijparprogoses) {
		this.id = id;
		this.ijtbinj = ijtbinj;
		this.dthrfinal = dthrfinal;
		this.dsparprog = dsparprog;
		this.origemparprog = origemparprog;
		this.ijparprogoses = ijparprogoses;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "dthrinicio", column = @Column(name = "DTHRINICIO", nullable = false, length = 7)) })
	public IjparprogId getId() {
		return this.id;
	}

	public void setId(IjparprogId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFINAL", length = 7)
	public Date getDthrfinal() {
		return this.dthrfinal;
	}

	public void setDthrfinal(Date dthrfinal) {
		this.dthrfinal = dthrfinal;
	}

	@Column(name = "DSPARPROG", length = 60)
	public String getDsparprog() {
		return this.dsparprog;
	}

	public void setDsparprog(String dsparprog) {
		this.dsparprog = dsparprog;
	}

	@Column(name = "ORIGEMPARPROG", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrigemparprog() {
		return this.origemparprog;
	}

	public void setOrigemparprog(BigDecimal origemparprog) {
		this.origemparprog = origemparprog;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijparprog")
	public Set<Ijparprogos> getIjparprogoses() {
		return this.ijparprogoses;
	}

	public void setIjparprogoses(Set<Ijparprogos> ijparprogoses) {
		this.ijparprogoses = ijparprogoses;
	}

}
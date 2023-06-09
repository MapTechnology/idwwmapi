package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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

/**
 * Ijpdcaparticipproj generated by hbm2java
 */
@Entity
@Table(name = "IJPDCAPARTICIPPROJ")
public class Ijpdcaparticipproj implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1831206541354286558L;
	private IjpdcaparticipprojId id;
	private Ijtbusu ijtbusu;
	private Ijtbusumail ijtbusumail;
	private Ijpdcaprojeto ijpdcaprojeto;
	private String nmparticipprojeto;
	private BigDecimal tpparticipante;
	private BigDecimal participadm;
	private Set<Ijpdcaagndacmp> ijpdcaagndacmps = new HashSet<Ijpdcaagndacmp>(0);
	private Set<Ijpdcaagndacmpeft> ijpdcaagndacmpefts = new HashSet<Ijpdcaagndacmpeft>(
			0);

	public Ijpdcaparticipproj() {
	}

	public Ijpdcaparticipproj(IjpdcaparticipprojId id,
			Ijpdcaprojeto ijpdcaprojeto, String nmparticipprojeto) {
		this.id = id;
		this.ijpdcaprojeto = ijpdcaprojeto;
		this.nmparticipprojeto = nmparticipprojeto;
	}

	public Ijpdcaparticipproj(IjpdcaparticipprojId id, Ijtbusu ijtbusu,
			Ijtbusumail ijtbusumail, Ijpdcaprojeto ijpdcaprojeto,
			String nmparticipprojeto, BigDecimal tpparticipante,
			BigDecimal participadm, Set<Ijpdcaagndacmp> ijpdcaagndacmps,
			Set<Ijpdcaagndacmpeft> ijpdcaagndacmpefts) {
		this.id = id;
		this.ijtbusu = ijtbusu;
		this.ijtbusumail = ijtbusumail;
		this.ijpdcaprojeto = ijpdcaprojeto;
		this.nmparticipprojeto = nmparticipprojeto;
		this.tpparticipante = tpparticipante;
		this.participadm = participadm;
		this.ijpdcaagndacmps = ijpdcaagndacmps;
		this.ijpdcaagndacmpefts = ijpdcaagndacmpefts;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrprojeto", column = @Column(name = "NRPROJETO", nullable = false, length = 10)),
			@AttributeOverride(name = "idparticipante", column = @Column(name = "IDPARTICIPANTE", nullable = false, precision = 22, scale = 0)) })
	public IjpdcaparticipprojId getId() {
		return this.id;
	}

	public void setId(IjpdcaparticipprojId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUMODTM")
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUMODINJETMAIL")
	public Ijtbusumail getIjtbusumail() {
		return this.ijtbusumail;
	}

	public void setIjtbusumail(Ijtbusumail ijtbusumail) {
		this.ijtbusumail = ijtbusumail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NRPROJETO", nullable = false, insertable = false, updatable = false)
	public Ijpdcaprojeto getIjpdcaprojeto() {
		return this.ijpdcaprojeto;
	}

	public void setIjpdcaprojeto(Ijpdcaprojeto ijpdcaprojeto) {
		this.ijpdcaprojeto = ijpdcaprojeto;
	}

	@Column(name = "NMPARTICIPPROJETO", nullable = false, length = 60)
	public String getNmparticipprojeto() {
		return this.nmparticipprojeto;
	}

	public void setNmparticipprojeto(String nmparticipprojeto) {
		this.nmparticipprojeto = nmparticipprojeto;
	}

	@Column(name = "TPPARTICIPANTE", precision = 22, scale = 0)
	public BigDecimal getTpparticipante() {
		return this.tpparticipante;
	}

	public void setTpparticipante(BigDecimal tpparticipante) {
		this.tpparticipante = tpparticipante;
	}

	@Column(name = "PARTICIPADM", precision = 22, scale = 0)
	public BigDecimal getParticipadm() {
		return this.participadm;
	}

	public void setParticipadm(BigDecimal participadm) {
		this.participadm = participadm;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijpdcaparticipproj")
	public Set<Ijpdcaagndacmp> getIjpdcaagndacmps() {
		return this.ijpdcaagndacmps;
	}

	public void setIjpdcaagndacmps(Set<Ijpdcaagndacmp> ijpdcaagndacmps) {
		this.ijpdcaagndacmps = ijpdcaagndacmps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijpdcaparticipproj")
	public Set<Ijpdcaagndacmpeft> getIjpdcaagndacmpefts() {
		return this.ijpdcaagndacmpefts;
	}

	public void setIjpdcaagndacmpefts(Set<Ijpdcaagndacmpeft> ijpdcaagndacmpefts) {
		this.ijpdcaagndacmpefts = ijpdcaagndacmpefts;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijcfgandmaqevt generated by hbm2java
 */
@Entity
@Table(name = "IJCFGANDMAQEVT")
public class Ijcfgandmaqevt implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 556125634855281207L;
	private double ideventoandon;
	private Ijtbrele ijtbrele;
	private Ijtbinj ijtbinj;
	private Ijtbtpeventoandon ijtbtpeventoandon;
	private BigDecimal prioridade;
	private BigDecimal stintermitente;
	private BigDecimal tmpsinalalto;
	private BigDecimal tmpsinalbaixo;
	private BigDecimal stativo;
	private BigDecimal stexclusao;
	private char stsincronismo;
	private Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon2 = new HashSet<Ijcfgandonagrup>(
			0);
	private Set<Ijcfgandmaqevtarg> ijcfgandmaqevtargs = new HashSet<Ijcfgandmaqevtarg>(
			0);
	private Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon = new HashSet<Ijcfgandonagrup>(
			0);

	public Ijcfgandmaqevt() {
	}

	public Ijcfgandmaqevt(double ideventoandon, Ijtbrele ijtbrele,
			Ijtbinj ijtbinj, Ijtbtpeventoandon ijtbtpeventoandon,
			BigDecimal prioridade, BigDecimal stintermitente,
			BigDecimal stativo, BigDecimal stexclusao, char stsincronismo) {
		this.ideventoandon = ideventoandon;
		this.ijtbrele = ijtbrele;
		this.ijtbinj = ijtbinj;
		this.ijtbtpeventoandon = ijtbtpeventoandon;
		this.prioridade = prioridade;
		this.stintermitente = stintermitente;
		this.stativo = stativo;
		this.stexclusao = stexclusao;
		this.stsincronismo = stsincronismo;
	}

	public Ijcfgandmaqevt(double ideventoandon, Ijtbrele ijtbrele,
			Ijtbinj ijtbinj, Ijtbtpeventoandon ijtbtpeventoandon,
			BigDecimal prioridade, BigDecimal stintermitente,
			BigDecimal tmpsinalalto, BigDecimal tmpsinalbaixo,
			BigDecimal stativo, BigDecimal stexclusao, char stsincronismo,
			Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon2,
			Set<Ijcfgandmaqevtarg> ijcfgandmaqevtargs,
			Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon) {
		this.ideventoandon = ideventoandon;
		this.ijtbrele = ijtbrele;
		this.ijtbinj = ijtbinj;
		this.ijtbtpeventoandon = ijtbtpeventoandon;
		this.prioridade = prioridade;
		this.stintermitente = stintermitente;
		this.tmpsinalalto = tmpsinalalto;
		this.tmpsinalbaixo = tmpsinalbaixo;
		this.stativo = stativo;
		this.stexclusao = stexclusao;
		this.stsincronismo = stsincronismo;
		this.ijcfgandonagrupsForIdeventoandon2 = ijcfgandonagrupsForIdeventoandon2;
		this.ijcfgandmaqevtargs = ijcfgandmaqevtargs;
		this.ijcfgandonagrupsForIdeventoandon = ijcfgandonagrupsForIdeventoandon;
	}

	@Id
	@Column(name = "IDEVENTOANDON", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdeventoandon() {
		return this.ideventoandon;
	}

	public void setIdeventoandon(double ideventoandon) {
		this.ideventoandon = ideventoandon;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDRELE", nullable = false)
	public Ijtbrele getIjtbrele() {
		return this.ijtbrele;
	}

	public void setIjtbrele(Ijtbrele ijtbrele) {
		this.ijtbrele = ijtbrele;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TPEVENTOANDON", nullable = false)
	public Ijtbtpeventoandon getIjtbtpeventoandon() {
		return this.ijtbtpeventoandon;
	}

	public void setIjtbtpeventoandon(Ijtbtpeventoandon ijtbtpeventoandon) {
		this.ijtbtpeventoandon = ijtbtpeventoandon;
	}

	@Column(name = "PRIORIDADE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(BigDecimal prioridade) {
		this.prioridade = prioridade;
	}

	@Column(name = "STINTERMITENTE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStintermitente() {
		return this.stintermitente;
	}

	public void setStintermitente(BigDecimal stintermitente) {
		this.stintermitente = stintermitente;
	}

	@Column(name = "TMPSINALALTO", precision = 22, scale = 0)
	public BigDecimal getTmpsinalalto() {
		return this.tmpsinalalto;
	}

	public void setTmpsinalalto(BigDecimal tmpsinalalto) {
		this.tmpsinalalto = tmpsinalalto;
	}

	@Column(name = "TMPSINALBAIXO", precision = 22, scale = 0)
	public BigDecimal getTmpsinalbaixo() {
		return this.tmpsinalbaixo;
	}

	public void setTmpsinalbaixo(BigDecimal tmpsinalbaixo) {
		this.tmpsinalbaixo = tmpsinalbaixo;
	}

	@Column(name = "STATIVO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStativo() {
		return this.stativo;
	}

	public void setStativo(BigDecimal stativo) {
		this.stativo = stativo;
	}

	@Column(name = "STEXCLUSAO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStexclusao() {
		return this.stexclusao;
	}

	public void setStexclusao(BigDecimal stexclusao) {
		this.stexclusao = stexclusao;
	}

	@Column(name = "STSINCRONISMO", nullable = false, length = 1)
	public char getStsincronismo() {
		return this.stsincronismo;
	}

	public void setStsincronismo(char stsincronismo) {
		this.stsincronismo = stsincronismo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijcfgandmaqevtByIdeventoandon2")
	public Set<Ijcfgandonagrup> getIjcfgandonagrupsForIdeventoandon2() {
		return this.ijcfgandonagrupsForIdeventoandon2;
	}

	public void setIjcfgandonagrupsForIdeventoandon2(
			Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon2) {
		this.ijcfgandonagrupsForIdeventoandon2 = ijcfgandonagrupsForIdeventoandon2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijcfgandmaqevt")
	public Set<Ijcfgandmaqevtarg> getIjcfgandmaqevtargs() {
		return this.ijcfgandmaqevtargs;
	}

	public void setIjcfgandmaqevtargs(Set<Ijcfgandmaqevtarg> ijcfgandmaqevtargs) {
		this.ijcfgandmaqevtargs = ijcfgandmaqevtargs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijcfgandmaqevtByIdeventoandon")
	public Set<Ijcfgandonagrup> getIjcfgandonagrupsForIdeventoandon() {
		return this.ijcfgandonagrupsForIdeventoandon;
	}

	public void setIjcfgandonagrupsForIdeventoandon(
			Set<Ijcfgandonagrup> ijcfgandonagrupsForIdeventoandon) {
		this.ijcfgandonagrupsForIdeventoandon = ijcfgandonagrupsForIdeventoandon;
	}

}

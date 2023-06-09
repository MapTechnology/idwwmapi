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
 * Ijtbpar generated by hbm2java
 */
@Entity
@Table(name = "IJTBPAR")
public class Ijtbpar implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6487389779781500276L;
	private String cdparada;
	private Ijareres ijareres;
	private String dsparada;
	private BigDecimal teprogramado;
	private BigDecimal requercancelamento;
	private BigDecimal requerjustificativ;
	private BigDecimal requercausa;
	private BigDecimal requeracao;
	private BigDecimal permitecorrecao;
	private BigDecimal trocademolde;
	private BigDecimal saidademolde;
	private BigDecimal entradademolde;
	private BigDecimal pededrtresponsa;
	private BigDecimal pededrttecnico1;
	private BigDecimal pededrttecnico2;
	private BigDecimal requisicaonova01;
	private BigDecimal reqparadaprep;
	private BigDecimal reqparadasetup;
	private double tempolimite;
	private BigDecimal paradaprevista;
	private Character pcta;
	private Character pao;
	private Character pa;
	private Character ptp;
	private Character scp;
	private Character fds;
	private Character mdo;
	private Character monittmplimite;
	private char calcmtbfmttr;
	private char fechaloginoperador;
	private char paradapersistente;
	private Set<Ijtbparaux> ijtbparauxes = new HashSet<Ijtbparaux>(0);
	private Set<Ijgrpdetpar> ijgrpdetpars = new HashSet<Ijgrpdetpar>(0);
	private Set<Ijtbpardefctrlipro> ijtbpardefctrlipros = new HashSet<Ijtbpardefctrlipro>(
			0);
	private Set<Ijtbpardefsemcon> ijtbpardefsemcons = new HashSet<Ijtbpardefsemcon>(
			0);
	private Set<Ijtbparintrasa> ijtbparintrasas = new HashSet<Ijtbparintrasa>(0);
	private Set<Exportacao003> exportacao003s = new HashSet<Exportacao003>(0);
	private Set<Ijtbparreqtecespec> ijtbparreqtecespecs = new HashSet<Ijtbparreqtecespec>(
			0);
	private Set<Ijopintrasa> ijopintrasas = new HashSet<Ijopintrasa>(0);
	private Set<Ijlogcorrreq> ijlogcorrreqs = new HashSet<Ijlogcorrreq>(0);
	private Set<Exportacao001> exportacao001s = new HashSet<Exportacao001>(0);
	private Set<Ijtbinj> ijtbinjs = new HashSet<Ijtbinj>(0);
	private Set<Ijpdcapadrao> ijpdcapadraos = new HashSet<Ijpdcapadrao>(0);
	private Set<Ijreapar> ijreapars = new HashSet<Ijreapar>(0);

	public Ijtbpar() {
	}

	public Ijtbpar(String cdparada, Ijareres ijareres, double tempolimite,
			char calcmtbfmttr, char fechaloginoperador, char paradapersistente) {
		this.cdparada = cdparada;
		this.ijareres = ijareres;
		this.tempolimite = tempolimite;
		this.calcmtbfmttr = calcmtbfmttr;
		this.fechaloginoperador = fechaloginoperador;
		this.paradapersistente = paradapersistente;
	}

	public Ijtbpar(String cdparada, Ijareres ijareres, String dsparada,
			BigDecimal teprogramado, BigDecimal requercancelamento,
			BigDecimal requerjustificativ, BigDecimal requercausa,
			BigDecimal requeracao, BigDecimal permitecorrecao,
			BigDecimal trocademolde, BigDecimal saidademolde,
			BigDecimal entradademolde, BigDecimal pededrtresponsa,
			BigDecimal pededrttecnico1, BigDecimal pededrttecnico2,
			BigDecimal requisicaonova01, BigDecimal reqparadaprep,
			BigDecimal reqparadasetup, double tempolimite,
			BigDecimal paradaprevista, Character pcta, Character pao,
			Character pa, Character ptp, Character scp, Character fds,
			Character mdo, Character monittmplimite, char calcmtbfmttr,
			char fechaloginoperador, char paradapersistente,
			Set<Ijtbparaux> ijtbparauxes, Set<Ijgrpdetpar> ijgrpdetpars,
			Set<Ijtbpardefctrlipro> ijtbpardefctrlipros,
			Set<Ijtbpardefsemcon> ijtbpardefsemcons,
			Set<Ijtbparintrasa> ijtbparintrasas,
			Set<Exportacao003> exportacao003s,
			Set<Ijtbparreqtecespec> ijtbparreqtecespecs,
			Set<Ijopintrasa> ijopintrasas, Set<Ijlogcorrreq> ijlogcorrreqs,
			Set<Exportacao001> exportacao001s, Set<Ijtbinj> ijtbinjs,
			Set<Ijpdcapadrao> ijpdcapadraos, Set<Ijreapar> ijreapars) {
		this.cdparada = cdparada;
		this.ijareres = ijareres;
		this.dsparada = dsparada;
		this.teprogramado = teprogramado;
		this.requercancelamento = requercancelamento;
		this.requerjustificativ = requerjustificativ;
		this.requercausa = requercausa;
		this.requeracao = requeracao;
		this.permitecorrecao = permitecorrecao;
		this.trocademolde = trocademolde;
		this.saidademolde = saidademolde;
		this.entradademolde = entradademolde;
		this.pededrtresponsa = pededrtresponsa;
		this.pededrttecnico1 = pededrttecnico1;
		this.pededrttecnico2 = pededrttecnico2;
		this.requisicaonova01 = requisicaonova01;
		this.reqparadaprep = reqparadaprep;
		this.reqparadasetup = reqparadasetup;
		this.tempolimite = tempolimite;
		this.paradaprevista = paradaprevista;
		this.pcta = pcta;
		this.pao = pao;
		this.pa = pa;
		this.ptp = ptp;
		this.scp = scp;
		this.fds = fds;
		this.mdo = mdo;
		this.monittmplimite = monittmplimite;
		this.calcmtbfmttr = calcmtbfmttr;
		this.fechaloginoperador = fechaloginoperador;
		this.paradapersistente = paradapersistente;
		this.ijtbparauxes = ijtbparauxes;
		this.ijgrpdetpars = ijgrpdetpars;
		this.ijtbpardefctrlipros = ijtbpardefctrlipros;
		this.ijtbpardefsemcons = ijtbpardefsemcons;
		this.ijtbparintrasas = ijtbparintrasas;
		this.exportacao003s = exportacao003s;
		this.ijtbparreqtecespecs = ijtbparreqtecespecs;
		this.ijopintrasas = ijopintrasas;
		this.ijlogcorrreqs = ijlogcorrreqs;
		this.exportacao001s = exportacao001s;
		this.ijtbinjs = ijtbinjs;
		this.ijpdcapadraos = ijpdcapadraos;
		this.ijreapars = ijreapars;
	}

	@Id
	@Column(name = "CDPARADA", unique = true, nullable = false, length = 6)
	public String getCdparada() {
		return this.cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDAREA", nullable = false)
	public Ijareres getIjareres() {
		return this.ijareres;
	}

	public void setIjareres(Ijareres ijareres) {
		this.ijareres = ijareres;
	}

	@Column(name = "DSPARADA", length = 40)
	public String getDsparada() {
		return this.dsparada;
	}

	public void setDsparada(String dsparada) {
		this.dsparada = dsparada;
	}

	@Column(name = "TEPROGRAMADO", precision = 22, scale = 0)
	public BigDecimal getTeprogramado() {
		return this.teprogramado;
	}

	public void setTeprogramado(BigDecimal teprogramado) {
		this.teprogramado = teprogramado;
	}

	@Column(name = "REQUERCANCELAMENTO", precision = 22, scale = 0)
	public BigDecimal getRequercancelamento() {
		return this.requercancelamento;
	}

	public void setRequercancelamento(BigDecimal requercancelamento) {
		this.requercancelamento = requercancelamento;
	}

	@Column(name = "REQUERJUSTIFICATIV", precision = 22, scale = 0)
	public BigDecimal getRequerjustificativ() {
		return this.requerjustificativ;
	}

	public void setRequerjustificativ(BigDecimal requerjustificativ) {
		this.requerjustificativ = requerjustificativ;
	}

	@Column(name = "REQUERCAUSA", precision = 22, scale = 0)
	public BigDecimal getRequercausa() {
		return this.requercausa;
	}

	public void setRequercausa(BigDecimal requercausa) {
		this.requercausa = requercausa;
	}

	@Column(name = "REQUERACAO", precision = 22, scale = 0)
	public BigDecimal getRequeracao() {
		return this.requeracao;
	}

	public void setRequeracao(BigDecimal requeracao) {
		this.requeracao = requeracao;
	}

	@Column(name = "PERMITECORRECAO", precision = 22, scale = 0)
	public BigDecimal getPermitecorrecao() {
		return this.permitecorrecao;
	}

	public void setPermitecorrecao(BigDecimal permitecorrecao) {
		this.permitecorrecao = permitecorrecao;
	}

	@Column(name = "TROCADEMOLDE", precision = 22, scale = 0)
	public BigDecimal getTrocademolde() {
		return this.trocademolde;
	}

	public void setTrocademolde(BigDecimal trocademolde) {
		this.trocademolde = trocademolde;
	}

	@Column(name = "SAIDADEMOLDE", precision = 22, scale = 0)
	public BigDecimal getSaidademolde() {
		return this.saidademolde;
	}

	public void setSaidademolde(BigDecimal saidademolde) {
		this.saidademolde = saidademolde;
	}

	@Column(name = "ENTRADADEMOLDE", precision = 22, scale = 0)
	public BigDecimal getEntradademolde() {
		return this.entradademolde;
	}

	public void setEntradademolde(BigDecimal entradademolde) {
		this.entradademolde = entradademolde;
	}

	@Column(name = "PEDEDRTRESPONSA", precision = 22, scale = 0)
	public BigDecimal getPededrtresponsa() {
		return this.pededrtresponsa;
	}

	public void setPededrtresponsa(BigDecimal pededrtresponsa) {
		this.pededrtresponsa = pededrtresponsa;
	}

	@Column(name = "PEDEDRTTECNICO1", precision = 22, scale = 0)
	public BigDecimal getPededrttecnico1() {
		return this.pededrttecnico1;
	}

	public void setPededrttecnico1(BigDecimal pededrttecnico1) {
		this.pededrttecnico1 = pededrttecnico1;
	}

	@Column(name = "PEDEDRTTECNICO2", precision = 22, scale = 0)
	public BigDecimal getPededrttecnico2() {
		return this.pededrttecnico2;
	}

	public void setPededrttecnico2(BigDecimal pededrttecnico2) {
		this.pededrttecnico2 = pededrttecnico2;
	}

	@Column(name = "REQUISICAONOVA01", precision = 22, scale = 0)
	public BigDecimal getRequisicaonova01() {
		return this.requisicaonova01;
	}

	public void setRequisicaonova01(BigDecimal requisicaonova01) {
		this.requisicaonova01 = requisicaonova01;
	}

	@Column(name = "REQPARADAPREP", precision = 22, scale = 0)
	public BigDecimal getReqparadaprep() {
		return this.reqparadaprep;
	}

	public void setReqparadaprep(BigDecimal reqparadaprep) {
		this.reqparadaprep = reqparadaprep;
	}

	@Column(name = "REQPARADASETUP", precision = 22, scale = 0)
	public BigDecimal getReqparadasetup() {
		return this.reqparadasetup;
	}

	public void setReqparadasetup(BigDecimal reqparadasetup) {
		this.reqparadasetup = reqparadasetup;
	}

	@Column(name = "TEMPOLIMITE", nullable = false, precision = 126, scale = 0)
	public double getTempolimite() {
		return this.tempolimite;
	}

	public void setTempolimite(double tempolimite) {
		this.tempolimite = tempolimite;
	}

	@Column(name = "PARADAPREVISTA", precision = 22, scale = 0)
	public BigDecimal getParadaprevista() {
		return this.paradaprevista;
	}

	public void setParadaprevista(BigDecimal paradaprevista) {
		this.paradaprevista = paradaprevista;
	}

	@Column(name = "PCTA", length = 1)
	public Character getPcta() {
		return this.pcta;
	}

	public void setPcta(Character pcta) {
		this.pcta = pcta;
	}

	@Column(name = "PAO", length = 1)
	public Character getPao() {
		return this.pao;
	}

	public void setPao(Character pao) {
		this.pao = pao;
	}

	@Column(name = "PA", length = 1)
	public Character getPa() {
		return this.pa;
	}

	public void setPa(Character pa) {
		this.pa = pa;
	}

	@Column(name = "PTP", length = 1)
	public Character getPtp() {
		return this.ptp;
	}

	public void setPtp(Character ptp) {
		this.ptp = ptp;
	}

	@Column(name = "SCP", length = 1)
	public Character getScp() {
		return this.scp;
	}

	public void setScp(Character scp) {
		this.scp = scp;
	}

	@Column(name = "FDS", length = 1)
	public Character getFds() {
		return this.fds;
	}

	public void setFds(Character fds) {
		this.fds = fds;
	}

	@Column(name = "MDO", length = 1)
	public Character getMdo() {
		return this.mdo;
	}

	public void setMdo(Character mdo) {
		this.mdo = mdo;
	}

	@Column(name = "MONITTMPLIMITE", length = 1)
	public Character getMonittmplimite() {
		return this.monittmplimite;
	}

	public void setMonittmplimite(Character monittmplimite) {
		this.monittmplimite = monittmplimite;
	}

	@Column(name = "CALCMTBFMTTR", nullable = false, length = 1)
	public char getCalcmtbfmttr() {
		return this.calcmtbfmttr;
	}

	public void setCalcmtbfmttr(char calcmtbfmttr) {
		this.calcmtbfmttr = calcmtbfmttr;
	}

	@Column(name = "FECHALOGINOPERADOR", nullable = false, length = 1)
	public char getFechaloginoperador() {
		return this.fechaloginoperador;
	}

	public void setFechaloginoperador(char fechaloginoperador) {
		this.fechaloginoperador = fechaloginoperador;
	}

	@Column(name = "PARADAPERSISTENTE", nullable = false, length = 1)
	public char getParadapersistente() {
		return this.paradapersistente;
	}

	public void setParadapersistente(char paradapersistente) {
		this.paradapersistente = paradapersistente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbparaux> getIjtbparauxes() {
		return this.ijtbparauxes;
	}

	public void setIjtbparauxes(Set<Ijtbparaux> ijtbparauxes) {
		this.ijtbparauxes = ijtbparauxes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijgrpdetpar> getIjgrpdetpars() {
		return this.ijgrpdetpars;
	}

	public void setIjgrpdetpars(Set<Ijgrpdetpar> ijgrpdetpars) {
		this.ijgrpdetpars = ijgrpdetpars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbpardefctrlipro> getIjtbpardefctrlipros() {
		return this.ijtbpardefctrlipros;
	}

	public void setIjtbpardefctrlipros(
			Set<Ijtbpardefctrlipro> ijtbpardefctrlipros) {
		this.ijtbpardefctrlipros = ijtbpardefctrlipros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbpardefsemcon> getIjtbpardefsemcons() {
		return this.ijtbpardefsemcons;
	}

	public void setIjtbpardefsemcons(Set<Ijtbpardefsemcon> ijtbpardefsemcons) {
		this.ijtbpardefsemcons = ijtbpardefsemcons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbparintrasa> getIjtbparintrasas() {
		return this.ijtbparintrasas;
	}

	public void setIjtbparintrasas(Set<Ijtbparintrasa> ijtbparintrasas) {
		this.ijtbparintrasas = ijtbparintrasas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Exportacao003> getExportacao003s() {
		return this.exportacao003s;
	}

	public void setExportacao003s(Set<Exportacao003> exportacao003s) {
		this.exportacao003s = exportacao003s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbparreqtecespec> getIjtbparreqtecespecs() {
		return this.ijtbparreqtecespecs;
	}

	public void setIjtbparreqtecespecs(
			Set<Ijtbparreqtecespec> ijtbparreqtecespecs) {
		this.ijtbparreqtecespecs = ijtbparreqtecespecs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijopintrasa> getIjopintrasas() {
		return this.ijopintrasas;
	}

	public void setIjopintrasas(Set<Ijopintrasa> ijopintrasas) {
		this.ijopintrasas = ijopintrasas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijlogcorrreq> getIjlogcorrreqs() {
		return this.ijlogcorrreqs;
	}

	public void setIjlogcorrreqs(Set<Ijlogcorrreq> ijlogcorrreqs) {
		this.ijlogcorrreqs = ijlogcorrreqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Exportacao001> getExportacao001s() {
		return this.exportacao001s;
	}

	public void setExportacao001s(Set<Exportacao001> exportacao001s) {
		this.exportacao001s = exportacao001s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijtbinj> getIjtbinjs() {
		return this.ijtbinjs;
	}

	public void setIjtbinjs(Set<Ijtbinj> ijtbinjs) {
		this.ijtbinjs = ijtbinjs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijpdcapadrao> getIjpdcapadraos() {
		return this.ijpdcapadraos;
	}

	public void setIjpdcapadraos(Set<Ijpdcapadrao> ijpdcapadraos) {
		this.ijpdcapadraos = ijpdcapadraos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbpar")
	public Set<Ijreapar> getIjreapars() {
		return this.ijreapars;
	}

	public void setIjreapars(Set<Ijreapar> ijreapars) {
		this.ijreapars = ijreapars;
	}

}

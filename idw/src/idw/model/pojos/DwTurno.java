package idw.model.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.DwTurnoTemplate;

/**
 * DwTurno generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_turno")
public class DwTurno extends DwTurnoTemplate implements java.io.Serializable {

	private long idTurno;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdTurno;
	private Long revisao;
	private String dsTurno;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private String cor;
	
	private Boolean isImprodutivo;
	
	private Set<OmProturno> omProturnos = new HashSet<OmProturno>(0);
	private Set<DwConsolid> dwConsolids = new HashSet<DwConsolid>(0);
	private Set<DwRt> dwRts = new HashSet<DwRt>(0);
	private Set<DwCalsem> dwCalsems = new HashSet<DwCalsem>(0);
	private Set<DwCalavu> dwCalavus = new HashSet<DwCalavu>(0);
	private Set<DwConsolestlocalpro> dwConsolestlocalpros = new HashSet<DwConsolestlocalpro>(0);

	public DwTurno() {
	}

	public DwTurno(long idTurno, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idTurno = idTurno;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public DwTurno(long idTurno, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdTurno, Long revisao,
			String dsTurno, Date dtRevisao, Date dtStativo, Byte stAtivo,
			String cor, Set<DwConsolid> dwConsolids, Set<DwRt> dwRts,
			Set<DwCalsem> dwCalsems, Set<DwCalavu> dwCalavus) {
		this.idTurno = idTurno;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdTurno = cdTurno;
		this.revisao = revisao;
		this.dsTurno = dsTurno;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.cor = cor;
		this.dwConsolids = dwConsolids;
		this.dwRts = dwRts;
		this.dwCalsems = dwCalsems;
		this.dwCalavus = dwCalavus;
	}

	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_TURNO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_TURNO_SEQ", sequenceName = "DW_TURNO_SEQ")
	@Column(name = "id_turno", nullable = false)
	public long getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_turno", length = 30)
	public String getCdTurno() {
		return this.cdTurno;
	}

	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_turno", length = 100)
	public String getDsTurno() {
		return this.dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 23)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "cor", length = 11)
	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<DwConsolid> getDwConsolids() {
		return this.dwConsolids;
	}

	public void setDwConsolids(Set<DwConsolid> dwConsolids) {
		this.dwConsolids = dwConsolids;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<DwRt> getDwRts() {
		return this.dwRts;
	}

	public void setDwRts(Set<DwRt> dwRts) {
		this.dwRts = dwRts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<DwCalsem> getDwCalsems() {
		return this.dwCalsems;
	}

	public void setDwCalsems(Set<DwCalsem> dwCalsems) {
		this.dwCalsems = dwCalsems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<DwCalavu> getDwCalavus() {
		return this.dwCalavus;
	}

	public void setDwCalavus(Set<DwCalavu> dwCalavus) {
		this.dwCalavus = dwCalavus;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<OmProturno> getOmProturnos() {
		return this.omProturnos;
	}

	public void setOmProturnos(Set<OmProturno> omProturnos) {
		this.omProturnos = omProturnos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTurno")
	public Set<DwConsolestlocalpro> getDwConsolestlocalpros() {
		return this.dwConsolestlocalpros;
	}

	public void setDwConsolestlocalpros(Set<DwConsolestlocalpro> dwConsolestlocalpros) {
		this.dwConsolestlocalpros = dwConsolestlocalpros;
	}

	
	@Column(name = "IS_IMPRODUTIVO", precision = 1)
	public Boolean getIsImprodutivo() {
		return isImprodutivo;
	}

	public void setIsImprodutivo(Boolean isImprodutivo) {
		this.isImprodutivo = isImprodutivo;
	}
}
package idw.model.pojos;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import idw.model.pojos.template.DwTOrigemTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "dw_t_origem", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_tppt", "cd_origem", "revisao" }))
public class DwTOrigem extends DwTOrigemTemplate implements java.io.Serializable {

	private long idOrigem;
	private OmTppt omTppt;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdOrigem;
	private Long revisao;
	private String dsOrigem;
	private Date dtRevisao;
	private Byte stAtivo;
	private Date dtStativo;
	//private Set<DwConsolrelog> dwConsolrelogs = new HashSet<DwConsolrelog>(0);
	//private Set<DwConsolpalog> dwConsolpalogs = new HashSet<DwConsolpalog>(0);
	//private Set<DwConsolpaoco> dwConsolpaocos = new HashSet<DwConsolpaoco>(0);
	
	public DwTOrigem() {
	}

	public DwTOrigem(long idOrigem, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idOrigem = idOrigem;
		this.omTppt = omTppt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public DwTOrigem(long idOrigem, OmTppt omTppt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdOrigem, Long revisao,
			String dsOrigem, Date dtRevisao, Byte stAtivo, Date dtStativo){ 
			//, 
			//Set<DwConsolrelog> dwConsolrelogs, Set<DwConsolpalog> dwConsolpalogs,
			//Set<DwConsolpaoco> dwConsolpaocos) {
		this.idOrigem = idOrigem;
		this.omTppt = omTppt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdOrigem = cdOrigem;
		this.revisao = revisao;
		this.dsOrigem = dsOrigem;
		this.dtRevisao = dtRevisao;
		this.stAtivo = stAtivo;
		this.dtStativo = dtStativo;
		//this.dwConsolrelogs = dwConsolrelogs;
		//this.dwConsolpalogs = dwConsolpalogs;
		//this.dwConsolpaocos = dwConsolpaocos;
	}

	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_T_ORIGEM_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_T_ORIGEM_SEQ", sequenceName = "DW_T_ORIGEM_SEQ")
	@Column(name = "id_origem", nullable = false)
	public long getIdOrigem() {
		return this.idOrigem;
	}

	public void setIdOrigem(long idOrigem) {
		this.idOrigem= idOrigem;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tppt", nullable = false)
	public OmTppt getOmTppt() {
		return this.omTppt;
	}

	@Override
	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	@Override
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	@Override
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_origem", length = 60)
	public String getCdOrigem() {
		return this.cdOrigem;
	}

	public void setCdOrigem(String cdOrigem) {
		this.cdOrigem= cdOrigem;
	}

	@Override
	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	@Override
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_origem", length = 100)
	public String getDsOrigem() {
		return this.dsOrigem;
	}

	public void setDsOrigem(String dsOrigem) {
		this.dsOrigem = dsOrigem;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 23)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	@Override
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Override
	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	@Override
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	@Override
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTOrigem")
	public Set<DwConsolrelog> getDwConsolrelogs() {
		return this.dwConsolrelogs;
	}

	public void setDwConsolrelogs(Set<DwConsolrelog> dwConsolrelogs) {
		this.dwConsolrelogs = dwConsolrelogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTOrigem")
	public Set<DwConsolpalog> getDwConsolpalogs() {
		return this.dwConsolpalogs;
	}

	public void setDwConsolpalogs(Set<DwConsolpalog> dwConsolpalogs) {
		this.dwConsolpalogs = dwConsolpalogs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwTOrigem")
	public Set<DwConsolpaoco> getDwConsolpaocos() {
		return this.dwConsolpaocos;
	}

	public void setDwConsolpaocos(Set<DwConsolpaoco> dwConsolpaocos) {
		this.dwConsolpaocos = dwConsolpaocos;
	}
	*/
}

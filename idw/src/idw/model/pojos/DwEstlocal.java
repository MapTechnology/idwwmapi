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

import idw.model.pojos.template.DwEstlocalTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "dw_estlocal")
public class DwEstlocal extends DwEstlocalTemplate implements java.io.Serializable {

	private Long idEstlocal;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private DwEst dwEst;
	private OmGt omGt;
	private OmPt omPt;
	private String cdLocal;
	private Long revisao;
	private String dsLocal;
	private Date dtRevisao;
	private Date dtStAtivo;
	private Byte stAtivo;
	private Boolean isAutomatico;
	private Byte tpLocalEstoque;
	private Set<DwEstlocalpro> dwEstlocalpros = new HashSet<DwEstlocalpro>(0);
	private OmPa omPa;

	public DwEstlocal() {
	}

	public DwEstlocal(Long idEstlocal, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idEstlocal = idEstlocal;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public DwEstlocal(Long idEstlocal, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, DwEst dwEst, String cdLocal,
			Long revisao, String dsLocal, Date dtRevisao, Date dtAtivo,
			Byte stAtivo, Set<DwEstlocalpro> dwEstlocalpros,
			Boolean isAutomatico, Byte tpLocalEstoque) {
		this.idEstlocal = idEstlocal;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.dwEst = dwEst;
		this.cdLocal = cdLocal;
		this.revisao = revisao;
		this.dsLocal = dsLocal;
		this.dtRevisao = dtRevisao;
		this.dtStAtivo = dtAtivo;
		this.stAtivo = stAtivo;
		this.dwEstlocalpros = dwEstlocalpros;
		this.isAutomatico = isAutomatico;
		this.tpLocalEstoque = tpLocalEstoque;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_ESTLOCAL_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_ESTLOCAL_SEQ", sequenceName = "DW_ESTLOCAL_SEQ")
	@Column(name = "id_estlocal", unique = true, nullable = false)	
	public Long getIdEstlocal() {
		return this.idEstlocal;
	}

	public void setIdEstlocal(Long idEstlocal) {
		this.idEstlocal = idEstlocal;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_est")
	public DwEst getDwEst() {
		return this.dwEst;
	}

	public void setDwEst(DwEst dwEst) {
		this.dwEst = dwEst;
	}

	@Column(name = "cd_local", length = 60)
	public String getCdLocal() {
		return this.cdLocal;
	}

	public void setCdLocal(String cdLocal) {
		this.cdLocal = cdLocal;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_local", length = 256)
	public String getDsLocal() {
		return this.dsLocal;
	}

	public void setDsLocal(String dsLocal) {
		this.dsLocal = dsLocal;
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
		return this.dtStAtivo;
	}

	public void setDtStativo(Date dtAtivo) {
		this.dtStAtivo = dtAtivo;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwEstlocal")
	public Set<DwEstlocalpro> getDwEstlocalpros() {
		return this.dwEstlocalpros;
	}

	public void setDwEstlocalpros(Set<DwEstlocalpro> dwEstlocalpros) {
		this.dwEstlocalpros = dwEstlocalpros;
	}
	
	@Column(name = "is_automatico")
	public Boolean getAutomatico() {
		return this.isAutomatico;
	}

	public void setAutomatico(Boolean isAutomatico) {
		this.isAutomatico = isAutomatico;
	}
	
	@Column(name = "tp_localestoque")
	public Byte getTpLocalEstoque() {
		return this.tpLocalEstoque;
	}

	public void setTpLocalEstoque(Byte tpLocalEstoque) {
		this.tpLocalEstoque = tpLocalEstoque;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gt")
	public OmGt getOmGt() {
		return this.omGt;
	}

	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt")
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pa")
	public OmPa getOmPa() {
		return this.omPa;
	}

	public void setOmPa(OmPa omPa) {
		this.omPa = omPa;
	}
}

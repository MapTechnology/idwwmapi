package idw.model.pojos;

import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

// Generated 11/01/2010 15:35:09 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmGtTemplate;


/**
 * OmGt generated by hbm2java
 */
@XmlRootElement
@SuppressWarnings("serial")
@Entity
@Table(name = "om_gt")
public class OmGt extends OmGtTemplate implements java.io.Serializable, Cloneable {
	
	@Expose private Long idGt;
	@Expose private OmUsr omUsrByIdUsrstativo;
	@Expose private OmUsr omUsrByIdUsrrevisao;
	@Expose private OmTpgt omTpgt;
	@Expose private OmImg omImg;
	@Expose private OmCc omCc;
	@Expose private String cdGt;
	@Expose private Long revisao;
	@Expose private String dsGt;
	@Expose private Date dtRevisao;
	@Expose private Date dtStativo;
	@Expose private Byte stAtivo;
	@Expose private Byte tpAlgoabc;

	private String cb;
	
	@Expose private String dsCurta;	@Expose private BigDecimal largura;
	@Expose private BigDecimal altura;
	@Expose private BigDecimal gridx;
	@Expose private BigDecimal gridy;
	@Expose private BigDecimal segX;
	@Expose private BigDecimal segY;
	@Expose private BigDecimal segZ;	
	@Expose private BigDecimal tensaoMin;	
	@Expose private BigDecimal tensaoNom;
	@Expose private BigDecimal tensaoMax;
	@Expose private BigDecimal indOee;
	@Expose private String depara;
	@Expose private OmGt omGtfase;
	@Expose private String cor;
	@Expose private Set<OmHomogt> omHomogts = new HashSet<OmHomogt>(0);
	@Expose private Set<OmIndgt> omIndgts = new HashSet<OmIndgt>(0);
	@Expose private Set<DwRota> dwRotas = new HashSet<DwRota>(0);
	@Expose private Set<OmPt> omPts = new HashSet<OmPt>(0);
	@Expose private Set<OmUsr> omUsrs = new HashSet<OmUsr>(0);
	@Expose private Set<DwFolhateste> dwFolhatestes = new HashSet<DwFolhateste>(0);
	@Expose private Set<DwFolha> dwFolhas = new HashSet<DwFolha>(0);
	@Expose private Set<DwConsolmolog> dwConsolmologs = new HashSet<DwConsolmolog>(0);
	@Expose private Set<OmObj> omObjsForIdGt = new HashSet<OmObj>(0);
	@Expose private Set<OmObj> omObjsForIdGtfilho = new HashSet<OmObj>(0);
	@Expose private Set<PpCp> ppCps = new HashSet<PpCp>(0);
	@Expose private Set<PpPlanptgt> ppPlanptgts = new HashSet<PpPlanptgt>(0);
	@Expose private Set<DwEstlocal> dwEstlocals = new HashSet<DwEstlocal>(0);	
	@Expose private Set<DwMacrange> dwMacranges = new HashSet<DwMacrange>(0);
	
	public OmGt() {
	}

	public OmGt(Long idGt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, OmTpgt omTpgt, OmImg omImg, OmCc omCc) {
		this.idGt = idGt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omTpgt = omTpgt;
		this.omImg = omImg;
		this.omCc = omCc;
	}

	public OmGt(Long idGt, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, OmTpgt omTpgt, OmImg omImg, OmCc omCc,
			String cdGt, Long revisao, String dsGt, Date dtRevisao,
			Date dtStativo, Byte stAtivo, String dsCurta,
			BigDecimal largura, BigDecimal altura, BigDecimal gridx,
			BigDecimal gridy, BigDecimal segX, BigDecimal segY,
			BigDecimal segZ, Set<DwFolha> dwFolhas, Set<OmIndgt> omIndgts,
			Set<DwRota> dwRotas, Set<DwFolhateste> dwFolhatestes,
			Set<DwConsolmolog> dwConsolmologs, Set<OmHomogt> omHomogts,
			Set<OmObj> omObjsForIdGt, Set<OmPt> omPts,
			Set<OmObj> omObjsForIdGtfilho) {
		this.idGt = idGt;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.omTpgt = omTpgt;
		this.omImg = omImg;
		this.omCc = omCc;
		this.cdGt = cdGt;
		this.revisao = revisao;
		this.dsGt = dsGt;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.dsCurta = dsCurta;
		this.largura = largura;
		this.altura = altura;
		this.gridx = gridx;
		this.gridy = gridy;
		this.segX = segX;
		this.segY = segY;
		this.segZ = segZ;
		this.dwFolhas = dwFolhas;
		this.omIndgts = omIndgts;
		this.dwRotas = dwRotas;
		this.dwFolhatestes = dwFolhatestes;
		this.dwConsolmologs = dwConsolmologs;
		this.omHomogts = omHomogts;
		this.omObjsForIdGt = omObjsForIdGt;
		this.omPts = omPts;
		this.omObjsForIdGtfilho = omObjsForIdGtfilho;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_GT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_GT_SEQ", sequenceName = "OM_GT_SEQ")
	@Column(name = "id_gt", nullable = false)
	public Long getIdGt() {
		return this.idGt;
	}

	public void setIdGt(Long idGt) {
		this.idGt = idGt;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tpgt", nullable = false)
	public OmTpgt getOmTpgt() {
		return this.omTpgt;
	}

	public void setOmTpgt(OmTpgt omTpgt) {
		this.omTpgt = omTpgt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_img", nullable = false)
	public OmImg getOmImg() {
		return this.omImg;
	}

	public void setOmImg(OmImg omImg) {
		this.omImg = omImg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cc", nullable = true)
	public OmCc getOmCc() {
		return this.omCc;
	}

	public void setOmCc(OmCc omCc) {
		this.omCc = omCc;
	}

	@Column(name = "cd_gt", length = 30)
	public String getCdGt() {
		return this.cdGt;
	}

	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
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

	@Column(name = "ds_gt", length = 100)
	public String getDsGt() {
		return this.dsGt;
	}

	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	@Override
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
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

	@Column(name = "ds_curta", length = 10)
	public String getDsCurta() {
		return this.dsCurta;
	}

	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}
	
	

	@Column(name = "cb", length = 2)
	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	@Column(name = "largura", precision = 8, scale = 4)
	public BigDecimal getLargura() {
		return this.largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	@Column(name = "altura", precision = 8, scale = 4)
	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	@Column(name = "gridx", precision = 8, scale = 4)
	public BigDecimal getGridx() {
		return this.gridx;
	}

	public void setGridx(BigDecimal gridx) {
		this.gridx = gridx;
	}

	@Column(name = "gridy", precision = 8, scale = 4)
	public BigDecimal getGridy() {
		return this.gridy;
	}

	public void setGridy(BigDecimal gridy) {
		this.gridy = gridy;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<OmHomogt> getOmHomogts() {
		return this.omHomogts;
	}

	public void setOmHomogts(Set<OmHomogt> omHomogts) {
		this.omHomogts = omHomogts;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omGtByIdGt")
	public Set<OmObj> getOmObjsForIdGt() {
		return this.omObjsForIdGt;
	}

	public void setOmObjsForIdGt(Set<OmObj> omObjsForIdGt) {
		this.omObjsForIdGt = omObjsForIdGt;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGtByIdGtfilho")
	public Set<OmObj> getOmObjsForIdGtfilho() {
		return this.omObjsForIdGtfilho;
	}

	public void setOmObjsForIdGtfilho(Set<OmObj> omObjsForIdGtfilho) {
		this.omObjsForIdGtfilho = omObjsForIdGtfilho;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<OmIndgt> getOmIndgts() {
		return this.omIndgts;
	}

	public void setOmIndgts(Set<OmIndgt> omIndgts) {
		this.omIndgts = omIndgts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwRota> getDwRotas() {
		return this.dwRotas;
	}

	public void setDwRotas(Set<DwRota> dwRotas) {
		this.dwRotas = dwRotas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<OmPt> getOmPts() {
		return this.omPts;
	}

	public void setOmPts(Set<OmPt> omPts) {
		this.omPts = omPts;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<OmUsr> getOmUsrs() {
		return omUsrs;
	}

	public void setOmUsrs(Set<OmUsr> omUsrs) {
		this.omUsrs = omUsrs;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwFolhateste> getDwFolhatestes() {
		return this.dwFolhatestes;
	}

	public void setDwFolhatestes(Set<DwFolhateste> dwFolhatestes) {
		this.dwFolhatestes = dwFolhatestes;
	}

	@Column(name = "seg_x", precision = 20, scale = 10)
	public BigDecimal getSegX() {
		return this.segX;
	}

	public void setSegX(BigDecimal segX) {
		this.segX = segX;
	}

	@Column(name = "seg_y", precision = 20, scale = 10)
	public BigDecimal getSegY() {
		return this.segY;
	}

	public void setSegY(BigDecimal segY) {
		this.segY = segY;
	}

	@Column(name = "seg_z", precision = 20, scale = 10)
	public BigDecimal getSegZ() {
		return this.segZ;
	}

	public void setSegZ(BigDecimal segZ) {
		this.segZ = segZ;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwFolha> getDwFolhas() {
		return this.dwFolhas;
	}

	public void setDwFolhas(Set<DwFolha> dwFolhas) {
		this.dwFolhas = dwFolhas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwConsolmolog> getDwConsolmologs() {
		return this.dwConsolmologs;
	}

	public void setDwConsolmologs(Set<DwConsolmolog> dwConsolmologs) {
		this.dwConsolmologs = dwConsolmologs;
	}
	@Column(name = "tensao_min", precision = 10, scale = 3)
	public BigDecimal getTensaoMin() {
		return this.tensaoMin;
	}

	public void setTensaoMin(BigDecimal minimoTensao) {
		this.tensaoMin = minimoTensao;
	}
	@Column(name = "tensao_nom", precision = 10, scale = 3)
	public BigDecimal getTensaoNom() {
		return this.tensaoNom;
	}

	public void setTensaoNom(BigDecimal minimoTensao) {
		this.tensaoNom = minimoTensao;
	}
	@Column(name = "tensao_max", precision = 10, scale = 3)
	public BigDecimal getTensaoMax() {
		return this.tensaoMax;
	}

	public void setTensaoMax(BigDecimal minimoTensao) {
		this.tensaoMax = minimoTensao;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<PpCp> getPpCps() {
		return this.ppCps;
	}

	public void setPpCps(Set<PpCp> ppCps) {
		this.ppCps = ppCps;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<PpPlanptgt> getPpPlanptgts() {
		return this.ppPlanptgts;
	}

	public void setPpPlanptgts(Set<PpPlanptgt> ppPlanptgts) {
		this.ppPlanptgts = ppPlanptgts;
	}
	@Column(name = "depara", length = 40)
	public String getDepara() {
		return this.depara;
	}

	public void setDepara(String depara) {
		this.depara = depara;
	}
	@Column(name = "IND_OEE", precision = 6, scale = 3)
	public BigDecimal getIndOee() {
		return this.indOee;
	}

	public void setIndOee(BigDecimal indOee) {
		this.indOee = indOee;
	}
	
	@Column(name = "cor", length = 11)
	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwEstlocal> getDwEstlocals() {
		return this.dwEstlocals;
	}

	public void setDwEstlocals(Set<DwEstlocal> dwEstlocals) {
		this.dwEstlocals = dwEstlocals;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gtfase")
	public OmGt getOmGtfase() {
		return this.omGtfase;
	}

	public void setOmGtfase(OmGt omGt) {
		this.omGtfase = omGt;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGt")
	public Set<DwMacrange> getDwMacranges() {
		return this.dwMacranges;
	}

	public void setDwMacranges(Set<DwMacrange> dwMacranges) {
		this.dwMacranges = dwMacranges;
	}
	
	@Column(name = "tp_algoabc")
	public Byte getTpAlgoabc() {
		return this.tpAlgoabc;
	}

	public void setTpAlgoabc(Byte tpAlgoabc) {
		this.tpAlgoabc = tpAlgoabc;
	}
}

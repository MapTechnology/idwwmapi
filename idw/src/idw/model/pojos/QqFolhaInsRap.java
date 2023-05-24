package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.QqFolhaInsRapTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_FOLHA_INS_RAP")
public class QqFolhaInsRap extends QqFolhaInsRapTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idFolhainsrap;
	private String cdFolhainsrap;
	private Long revisao;
	private String dsFolhainsrap;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	
	// FKs
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private DwRap dwRap;
	private DwGrupoFerramenta dwGrupoFerramenta;
	private OmProduto omProduto;
	private DwTprap dwTprap;
	
	// Tabelas dependentes
	private Set<QqFolhaInsAtiv> qqFolhaInsAtivs = new HashSet<QqFolhaInsAtiv>(0);
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_FOLHA_INS_RAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_FOLHA_INS_RAP_SEQ", sequenceName = "QQ_FOLHA_INS_RAP_SEQ")
	@Column(name = "ID_FOLHAINSRAP", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdFolhainsrap() {
		return idFolhainsrap;
	}
	public void setIdFolhainsrap(Long idFolhainsrap) {
		this.idFolhainsrap = idFolhainsrap;
	}
	
	@Column(name = "CD_FOLHAINSRAP", length = 60)
	public String getCdFolhainsrap() {
		return cdFolhainsrap;
	}
	public void setCdFolhainsrap(String cdFolhainsrap) {
		this.cdFolhainsrap = cdFolhainsrap;
	}

	
	@Override
	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}
	
	@Column(name = "DS_FOLHAINSRAP", length = 256)
	public String getDsFolhainsrap() {
		return dsFolhainsrap;
	}
	public void setDsFolhainsrap(String dsFolhainsrap) {
		this.dsFolhainsrap = dsFolhainsrap;
	}
	
	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_REVISAO", length = 23)
	public Date getDtRevisao() {
		return dtRevisao;
	}
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_STATIVO", length = 23)
	public Date getDtStativo() {
		return dtStativo;
	}
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Override
	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return omUsrByIdUsrstativo;
	}
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRREVISAO", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return omUsrByIdUsrrevisao;
	}
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAP", nullable = true)
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GRUPO_FERRAMENTA", nullable = true)
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}
	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO", nullable = false)
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPRAP", nullable = false)
	public DwTprap getDwTprap() {
		return dwTprap;
	}
	public void setDwTprap(DwTprap dwTprap) {
		this.dwTprap = dwTprap;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqFolhaInsRap")
	public Set<QqFolhaInsAtiv> getQqFolhaInsAtivs() {
		return qqFolhaInsAtivs;
	}
	public void setQqFolhaInsAtivs(Set<QqFolhaInsAtiv> qqFolhaInsAtivs) {
		this.qqFolhaInsAtivs = qqFolhaInsAtivs;
	}
}

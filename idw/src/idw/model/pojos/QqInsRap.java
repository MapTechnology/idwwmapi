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

import idw.model.pojos.template.QqInsRapTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_INS_RAP")
public class QqInsRap extends QqInsRapTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idInsRap;
	private String cdInspecao;
	private Long revisao;
	private Date dtRevisao;
	private Byte stAtivo;
	private Date dtStativo;
	private String dsInspecao;
	private OmUsr omUsrByIdUsrrevisao;
	private OmUsr omUsrByIdUsrstativo;
	private Byte stInspecao;
	
	private DwRap dwRap;
	private MmOsInsRap mmOsInsRap;
	
	
	private Set<QqInsrapFt> qqInsrapFts = new HashSet<QqInsrapFt>(0);

	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_INS_RAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_INS_RAP_SEQ", sequenceName = "QQ_INS_RAP_SEQ")
	@Column(name = "ID_INS_RAP", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdInsRap() {
		return idInsRap;
	}
	public void setIdInsRap(Long idInsRap) {
		this.idInsRap = idInsRap;
	}
	
	@Column(name = "CD_INSPECAO", length = 60)
	public String getCdInspecao() {
		return cdInspecao;
	}
	public void setCdInspecao(String cdInspecao) {
		this.cdInspecao = cdInspecao;
	}
	
	@Override
	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
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
	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}
	
	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_STATIVO", length = 7)
	public Date getDtStativo() {
		return dtStativo;
	}
	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}
	
	@Column(name = "DS_INSPECAO", length = 256)
	public String getDsInspecao() {
		return dsInspecao;
	}
	public void setDsInspecao(String dsInspecao) {
		this.dsInspecao = dsInspecao;
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
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return omUsrByIdUsrstativo;
	}
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}
	
	@Column(name = "ST_INSPECAO", length = 1)
	public Byte getStInspecao() {
		return stInspecao;
	}
	public void setStInspecao(Byte stInspecao) {
		this.stInspecao = stInspecao;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAP", nullable = false)
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqInsRap")
	public Set<QqInsrapFt> getQqInsrapFts() {
		return qqInsrapFts;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OSINSRAP", nullable = false)
	public MmOsInsRap getMmOsInsRap() {
		return mmOsInsRap;
	}

	public void setMmOsInsRap(MmOsInsRap mmOsInsRap) {
		this.mmOsInsRap = mmOsInsRap;
	}
	public void setQqInsrapFts(Set<QqInsrapFt> qqInsrapFts) {
		this.qqInsrapFts = qqInsrapFts;
	}
}

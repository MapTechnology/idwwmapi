package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.MmOsTemplate;

@XmlRootElement
@Entity
@Table(name = "MM_OS")
public class MmOs extends MmOsTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idOs;
	private String cdOs;
	private Long revisao;
	private Date dtRevisao;
	private Byte stAtivo;
	private Date dtStativo;
	private String dsOs;
	private OmUsr omUsrByIdUsrrevisao;
	private OmUsr omUsrByIdUsrstativo;
	private Byte stOs;
	
	private MmOsInsRap mmOsInsRap;
	private MmTpos mmTpos;
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MM_OS_SEQ")
	@javax.persistence.SequenceGenerator(name = "MM_OS_SEQ", sequenceName = "MM_OS_SEQ")
	@Column(name = "ID_OS", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdOs() {
		return idOs;
	}
	public void setIdOs(Long idOs) {
		this.idOs = idOs;
	}
	
	@Column(name = "CD_OS", length = 60)
	public String getCdOs() {
		return cdOs;
	}
	public void setCdOs(String cdOs) {
		this.cdOs = cdOs;
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
	
	@Column(name = "DS_OS", length = 256)
	public String getDsOs() {
		return dsOs;
	}
	public void setDsOs(String dsOs) {
		this.dsOs = dsOs;
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
	
	@Column(name = "ST_OS", length = 1)
	public Byte getStOs() {
		return stOs;
	}
	public void setStOs(Byte stOs) {
		this.stOs = stOs;
	}

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OS", nullable = true)
	public MmOsInsRap getMmOsInsRap() {
		return mmOsInsRap;
	}
	public void setMmOsInsRap(MmOsInsRap mmOsInsRap) {
		this.mmOsInsRap = mmOsInsRap;
	}

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPOS", nullable = true)
	public MmTpos getMmTpos() {
		return mmTpos;
	}
	public void setMmTpos(MmTpos mmTpos) {
		this.mmTpos = mmTpos;
	}
}

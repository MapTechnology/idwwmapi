package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.MmTposTemplate;

@Entity
@Table(name = "mm_tpos")
public class MmTpos extends MmTposTemplate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idTpos;
	private String cdTpos;
	private Long revisao;
	private String dsTpos;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;

	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	
	public MmTpos() {
		super();
	}
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MM_TPOS_SEQ")
	@javax.persistence.SequenceGenerator(name = "MM_TPOS_SEQ", sequenceName = "MM_TPOS_SEQ")
	@Column(name = "id_tpos", unique = true, nullable = false)
	public Long getIdTpos() {
		return this.idTpos;
	}

	public void setIdTpos(Long id) {
		this.idTpos = id;
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

	@Column(name = "cd_tpos", length = 60)
	public String getCdTpos() {
		return this.cdTpos;
	}

	public void setCdTpos(String cd) {
		this.cdTpos = cd;
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

	@Column(name = "ds_tpos", length = 100)
	public String getDsTpos() {
		return this.dsTpos;
	}

	public void setDsTpos(String ds) {
		this.dsTpos = ds;
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

}

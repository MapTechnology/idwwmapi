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

import idw.model.pojos.template.DwTprapTemplate;

@Entity
@Table(name = "dw_tprap")
public class DwTprap extends DwTprapTemplate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idTprap;
	private String cdTprap;
	private Long revisao;
	private String dsTprap;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;

	
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_TPRAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_TPRAP_SEQ", sequenceName = "DW_TPRAP_SEQ")
	@Column(name = "id_tprap", unique = true, nullable = false)
	public Long getIdTprap() {
		return idTprap;
	}
	public void setIdTprap(Long idTprap) {
		this.idTprap = idTprap;
	}
	
	
	@Column(name = "CD_TPRAP", length = 60)
	public String getCdTprap() {
		return cdTprap;
	}
	public void setCdTprap(String cdTprap) {
		this.cdTprap = cdTprap;
	}

	@Override
	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return revisao;
	}
	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}
	
	@Column(name = "DS_TPRAP", length = 256)
	public String getDsTprap() {
		return dsTprap;
	}
	public void setDsTprap(String dsTprap) {
		this.dsTprap = dsTprap;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_REVISAO", length = 23)
	public Date getDtRevisao() {
		return dtRevisao;
	}
	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

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

	
	
}


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

import idw.model.pojos.template.DwFtGrupoTemplate;

/**
 * DwFtGrupo generated by hbm2java
 */
@Entity
@Table(name = "dw_ft_grupo")
public class DwFtGrupo extends DwFtGrupoTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1503912830512346926L;
	private Long idFtgrupo;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdFtgrupo;
	private Long revisao;
	private Byte stAtivo;
	private Date dtStativo;
	private Date dtRevisao;
	private String dsFtgrupo;
	private Set<DwFtParam> dwFtParams = new HashSet<DwFtParam>(0);

	public DwFtGrupo() {
	}

	public DwFtGrupo(Long idFtgrupo, OmUsr omUsrByIdUsrStativo,
			OmUsr omUsrByIdUsrRevisao) {
		this.idFtgrupo = idFtgrupo;
		this.omUsrByIdUsrstativo = omUsrByIdUsrStativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrRevisao;
	}

	public DwFtGrupo(Long idFtgrupo, OmUsr omUsrByIdUsrStativo,
			OmUsr omUsrByIdUsrRevisao, String cdFtgrupo, Long revisao,
			Byte stAtivo, Date dtStativo, Date dtRevisao, String dsFtgrupo,
			Set<DwFtParam> dwFtParams) {
		this.idFtgrupo = idFtgrupo;
		this.omUsrByIdUsrstativo = omUsrByIdUsrStativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrRevisao;
		this.cdFtgrupo = cdFtgrupo;
		this.revisao = revisao;
		this.stAtivo = stAtivo;
		this.dtStativo = dtStativo;
		this.dtRevisao = dtRevisao;
		this.dsFtgrupo = dsFtgrupo;
		this.dwFtParams = dwFtParams;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "DW_FT_GRUPO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_FT_GRUPO_SEQ", sequenceName = "DW_FT_GRUPO_SEQ")
	@Column(name = "id_ftgrupo", unique = true, nullable = false)
	public Long getIdFtgrupo() {
		return this.idFtgrupo;
	}

	public void setIdFtgrupo(Long idFtgrupo) {
		this.idFtgrupo = idFtgrupo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrStativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrStativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrStativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrRevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrRevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrRevisao;
	}

	
	@Column(name = "cd_ftgrupo", length = 60)
	public String getCdFtgrupo() {
		return this.cdFtgrupo;
	}

	public void setCdFtgrupo(String cdFtgrupo) {
		this.cdFtgrupo = cdFtgrupo;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 23)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 23)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Column(name = "ds_ftgrupo", length = 256)
	public String getDsFtgrupo() {
		return this.dsFtgrupo;
	}

	public void setDsFtgrupo(String dsFtgrupo) {
		this.dsFtgrupo = dsFtgrupo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwFtGrupo")
	public Set<DwFtParam> getDwFtParams() {
		return this.dwFtParams;
	}

	public void setDwFtParams(Set<DwFtParam> dwFtParams) {
		this.dwFtParams = dwFtParams;
	}


}
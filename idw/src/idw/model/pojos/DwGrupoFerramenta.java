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

// Generated 10/12/2014 11:50:58 by Hibernate Tools 4.0.0

import idw.model.pojos.template.DwGrupoFerramentaTemplate;

/**
 * DwGrupoFerramenta generated by hbm2java
 */
@Entity
@Table(name = "dw_grupo_ferramenta")
public class DwGrupoFerramenta extends DwGrupoFerramentaTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idGrupoFerramenta;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdGrupoFerramenta;
	private String dsGrupoFerramenta;
	private Long revisao;
	private Date dtRevisao;
	private Byte stAtivo;
	private Date dtStativo;
	private Set<DwRapGrupo> dwRapGrupos = new HashSet<DwRapGrupo>(0);
	private Set<DwGfTpos> dwGfTposes = new HashSet<DwGfTpos>(0);
	
	public DwGrupoFerramenta() {
	}

	public DwGrupoFerramenta(Long idGrupoFerramenta, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao) {
		this.idGrupoFerramenta = idGrupoFerramenta;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_GRUPO_FERRAMENTA_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_GRUPO_FERRAMENTA_SEQ", sequenceName = "DW_GRUPO_FERRAMENTA_SEQ")
	@Column(name = "id_grupo_ferramenta", unique = true, nullable = false)
	public Long getIdGrupoFerramenta() {
		return this.idGrupoFerramenta;
	}

	public void setIdGrupoFerramenta(Long idGrupoFerramenta) {
		this.idGrupoFerramenta = idGrupoFerramenta;
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

	@Column(name = "cd_grupo_ferramenta", length = 60)
	public String getCdGrupoFerramenta() {
		return this.cdGrupoFerramenta;
	}

	public void setCdGrupoFerramenta(String cdGrupoFerramenta) {
		this.cdGrupoFerramenta = cdGrupoFerramenta;
	}

	@Column(name = "ds_grupo_ferramenta", length = 100)
	public String getDsGrupoFerramenta() {
		return this.dsGrupoFerramenta;
	}

	public void setDsGrupoFerramenta(String dsGrupoFerramenta) {
		this.dsGrupoFerramenta = dsGrupoFerramenta;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_revisao", length = 10)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_stativo", length = 10)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwGrupoFerramenta")
	public Set<DwRapGrupo> getDwRapGrupos() {
		return this.dwRapGrupos;
	}

	public void setDwRapGrupos(Set<DwRapGrupo> dwRapGrupos) {
		this.dwRapGrupos = dwRapGrupos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwGrupoFerramenta")
	public Set<DwGfTpos> getDwGfTposes() {
		return dwGfTposes;
	}

	public void setDwGfTposes(Set<DwGfTpos> dwGfTposes) {
		this.dwGfTposes = dwGfTposes;
	}
}

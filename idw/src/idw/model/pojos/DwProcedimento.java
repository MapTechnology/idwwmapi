package idw.model.pojos;

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

import idw.model.pojos.template.DwProcedimentoTemplate;

@XmlRootElement
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_procedimento")
public class DwProcedimento extends DwProcedimentoTemplate implements java.io.Serializable {

	private Long idProcedimento;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdProcedimento;
	private Long revisao;
	private String dsProcedimento;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private String obs;
	private Set<DwProcativ> dwProcativs = new HashSet<DwProcativ>(0);
	private Set<DwProcarhom> dwProcarhoms = new HashSet<DwProcarhom>(0);
	private Set<DwProrea> dwProreas = new HashSet<DwProrea>(0);
	private Set<DwFolha> dwFolhas = new HashSet<DwFolha>(0);

	public DwProcedimento() {
	}

	public DwProcedimento(Long idProcedimento, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idProcedimento = idProcedimento;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public DwProcedimento(Long idProcedimento, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdProcedimento, Long revisao,
			String dsProcedimento, Date dtRevisao, Date dtStativo,
			Byte stAtivo, Set<DwProcativ> dwProcativs,Set<DwProcarhom> dwProcarhoms) {
		this.idProcedimento = idProcedimento;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdProcedimento = cdProcedimento;
		this.revisao = revisao;
		this.dsProcedimento = dsProcedimento;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.dwProcativs = dwProcativs;
		this.dwProcarhoms = dwProcarhoms;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_PROCEDIMENTO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_PROCEDIMENTO_SEQ", sequenceName = "DW_PROCEDIMENTO_SEQ")
	@Column(name = "id_procedimento", unique = true, nullable = false)
	public Long getIdProcedimento() {
		return this.idProcedimento;
	}

	public void setIdProcedimento(Long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}
	
	@Column(name = "obs")
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrRevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_procedimento", length = 60)
	public String getCdProcedimento() {
		return this.cdProcedimento;
	}

	public void setCdProcedimento(String cdProcedimento) {
		this.cdProcedimento = cdProcedimento;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_procedimento", length = 256)
	public String getDsProcedimento() {
		return this.dsProcedimento;
	}

	public void setDsProcedimento(String dsProcedimento) {
		this.dsProcedimento = dsProcedimento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_revisao", length = 10)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_stativo", length = 10)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwProcedimento")
	public Set<DwProcativ> getDwProcativs() {
		return this.dwProcativs;
	}

	public void setDwProcativs(Set<DwProcativ> dwProcativs) {
		this.dwProcativs = dwProcativs;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwProcedimento")
	public Set<DwProcarhom> getDwProcarhoms() {
		return this.dwProcarhoms;
	}

	public void setDwProcarhoms(Set<DwProcarhom> dwProcarhoms) {
		this.dwProcarhoms = dwProcarhoms;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwProcedimento")
	public Set<DwFolha> getDwFolhas() {
		return this.dwFolhas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwProcedimento")
	public void setDwFolhas(Set<DwFolha> dwFolhas) {
		this.dwFolhas = dwFolhas;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwProcedimento")
	public Set<DwProrea> getDwProreas() {
		return this.dwProreas;
	}

	public void setDwProreas(Set<DwProrea> dwProreas) {
		this.dwProreas = dwProreas;
	}

}

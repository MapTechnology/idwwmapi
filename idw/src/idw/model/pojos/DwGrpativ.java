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

import idw.model.pojos.template.DwGrpativTemplate;

/**
 * DwGrpativ generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_grpativ")
public class DwGrpativ extends DwGrpativTemplate implements java.io.Serializable {

	private long idGrpativ;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdGrpativ;
	private Long revisao;
	private String dsGrpativ;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private Set<DwProcativ> dwProcativs = new HashSet<DwProcativ>(0);

	public DwGrpativ() {
	}

	public DwGrpativ(long idGrpativ, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idGrpativ = idGrpativ;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public DwGrpativ(long idGrpativ, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdGrpativ, Long revisao,
			String dsGrpativ, Date dtRevisao, Date dtStativo, Byte stAtivo,
			Set<DwProcativ> dwProcativs) {
		this.idGrpativ = idGrpativ;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdGrpativ = cdGrpativ;
		this.revisao = revisao;
		this.dsGrpativ = dsGrpativ;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.dwProcativs = dwProcativs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_GRPATIV_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_GRPATIV_SEQ", sequenceName = "DW_GRPATIV_SEQ")
	@Column(name = "id_grpativ", unique = true, nullable = false)
	public long getIdGrpativ() {
		return this.idGrpativ;
	}

	public void setIdGrpativ(long idGrpativ) {
		this.idGrpativ = idGrpativ;
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
	@JoinColumn(name = "id_usrRevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}
	

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "cd_grpativ", length = 60)
	public String getCdGrpativ() {
		return this.cdGrpativ;
	}

	public void setCdGrpativ(String cdGrpativ) {
		this.cdGrpativ = cdGrpativ;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_grpativ", length = 256)
	public String getDsGrpativ() {
		return this.dsGrpativ;
	}

	public void setDsGrpativ(String dsGrpativ) {
		this.dsGrpativ = dsGrpativ;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwGrpativ")
	public Set<DwProcativ> getDwProcativs() {
		return this.dwProcativs;
	}

	public void setDwProcativs(Set<DwProcativ> dwProcativs) {
		this.dwProcativs = dwProcativs;
	}


		

}

package idw.model.pojos;
// Generated 15/05/2018 16:00:51 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.SpCatcausaTemplate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SpCatcausa generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SP_CATCAUSA")
public class SpCatcausa extends SpCatcausaTemplate implements java.io.Serializable {

	private BigDecimal idCatcausa;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdCatcausa;
	private BigDecimal stAtivo;
	private BigDecimal revisao;
	private Date dtStativo;
	private Date dtRevisao;
	private Set<SpCatcausads> spCatcausadses = new HashSet<SpCatcausads>(0);
	private Set<SpCausaefeito> spCausaefeitos = new HashSet<SpCausaefeito>(0);

	public SpCatcausa() {
	}

	public SpCatcausa(BigDecimal idCatcausa, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao) {
		this.idCatcausa = idCatcausa;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	public SpCatcausa(BigDecimal idCatcausa, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdCatcausa, BigDecimal stAtivo,
			BigDecimal revisao, Date dtStativo, Date dtRevisao,
			Set<SpCatcausads> spCatcausadses, Set<SpCausaefeito> spCausaefeitos) {
		this.idCatcausa = idCatcausa;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdCatcausa = cdCatcausa;
		this.stAtivo = stAtivo;
		this.revisao = revisao;
		this.dtStativo = dtStativo;
		this.dtRevisao = dtRevisao;
		this.spCatcausadses = spCatcausadses;
		this.spCausaefeitos = spCausaefeitos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATCAUSA", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdCatcausa() {
		return this.idCatcausa;
	}

	public void setIdCatcausa(BigDecimal idCatcausa) {
		this.idCatcausa = idCatcausa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRSTATIVO", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USRREVISAO", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Column(name = "CD_CATCAUSA", length = 30)
	public String getCdCatcausa() {
		return this.cdCatcausa;
	}

	public void setCdCatcausa(String cdCatcausa) {
		this.cdCatcausa = cdCatcausa;
	}

	@Column(name = "ST_ATIVO", precision = 22, scale = 0)
	public BigDecimal getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(BigDecimal stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "REVISAO", precision = 22, scale = 0)
	public BigDecimal getRevisao() {
		return this.revisao;
	}

	public void setRevisao(BigDecimal revisao) {
		this.revisao = revisao;
	}

	@Column(name = "DT_STATIVO")
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "DT_REVISAO")
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "spCatcausa")
	public Set<SpCatcausads> getSpCatcausadses() {
		return this.spCatcausadses;
	}

	public void setSpCatcausadses(Set<SpCatcausads> spCatcausadses) {
		this.spCatcausadses = spCatcausadses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "spCatcausa")
	public Set<SpCausaefeito> getSpCausaefeitos() {
		return this.spCausaefeitos;
	}

	public void setSpCausaefeitos(Set<SpCausaefeito> spCausaefeitos) {
		this.spCausaefeitos = spCausaefeitos;
	}

}

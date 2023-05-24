package idw.model.pojos;

// default package
// Generated 10/01/2011 10:46:16 by Hibernate Tools 3.3.0.GA


import java.math.BigDecimal;
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

import idw.model.pojos.template.MsUpihmTemplate;

/**
 * MsUpihm generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MS_UPIHM")
public class MsUpihm extends MsUpihmTemplate implements java.io.Serializable {

	private BigDecimal idUpihm;
	private MsIhm msIhm;
	private MsUp msUp;
	private String urlConexao;
	private Date dthrCadastro;
	private Set<MsEvt> msEvts = new HashSet<MsEvt>(0);

	public MsUpihm() {
	}

	public MsUpihm(BigDecimal idUpihm, MsIhm msIhm, MsUp msUp) {
		this.idUpihm = idUpihm;
		this.msIhm = msIhm;
		this.msUp = msUp;
	}

	public MsUpihm(BigDecimal idUpihm, MsIhm msIhm, MsUp msUp,
			Date dthrCadastro) {
		this.idUpihm = idUpihm;
		this.msIhm = msIhm;
		this.msUp = msUp;
		this.dthrCadastro = dthrCadastro;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_UPIHM_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_UPIHM_SEQ", sequenceName = "MS_UPIHM_SEQ")
	@Column(name = "ID_UPIHM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUpihm() {
		return this.idUpihm;
	}

	public void setIdUpihm(BigDecimal idUpihm) {
		this.idUpihm = idUpihm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_IHM", nullable = false)
	public MsIhm getMsIhm() {
		return this.msIhm;
	}

	public void setMsIhm(MsIhm msIhm) {
		this.msIhm = msIhm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UP", nullable = false)
	public MsUp getMsUp() {
		return this.msUp;
	}

	public void setMsUp(MsUp msUp) {
		this.msUp = msUp;
	}

	@Column(name = "DTHR_CADASTRO")
	public Date getDthrCadastro() {
		return this.dthrCadastro;
	}

	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	@Column(name = "URL_CONEXAO", length = 100)
	public String getUrlConexao() {
		return this.urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "msUpihm")
	public Set<MsEvt> getMsEvts() {
		return this.msEvts;
	}

	public void setMsEvts(Set<MsEvt> msEvts) {
		this.msEvts = msEvts;
	}
}

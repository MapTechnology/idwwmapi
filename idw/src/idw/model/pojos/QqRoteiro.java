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
import javax.persistence.UniqueConstraint;

import idw.model.pojos.template.QqRoteiroTemplate;

@Entity
@Table(name = "qq_roteiro", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "cd_roteiro", "revisao" }),
		@UniqueConstraint(columnNames = { "id_produto" }) })
public class QqRoteiro extends QqRoteiroTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRoteiro;
	private String cdRoteiro;
	private Long revisao;
	private String dsRoteiro;
	private Date dtRevisao;
	private Byte stAtivo;
	private Date dtStativo;

	private OmProduto omProduto;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	
	private Set<QqRoteiroMov> qqRoteiroMovs = new HashSet<QqRoteiroMov>(0);

	
	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_ROTEIRO_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_ROTEIRO_SEQ", sequenceName = "QQ_ROTEIRO_SEQ")
	@Column(name = "id_roteiro", nullable = false)
	public Long getIdRoteiro() {
		return this.idRoteiro;
	}

	public void setIdRoteiro(Long idRota) {
		this.idRoteiro = idRota;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@Column(name = "cd_roteiro", length = 60)
	public String getCdRoteiro() {
		return this.cdRoteiro;
	}

	public void setCdRoteiro(String cdRota) {
		this.cdRoteiro = cdRota;
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
	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	@Override
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
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

	@Column(name = "ds_roteiro", length = 100)
	public String getDsRoteiro() {
		return this.dsRoteiro;
	}

	public void setDsRoteiro(String dsRota) {
		this.dsRoteiro = dsRota;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqRoteiro")
	public Set<QqRoteiroMov> getQqRoteiroMovs() {
		return this.qqRoteiroMovs;
	}

	public void setQqRoteiroMovs(Set<QqRoteiroMov> mov) {
		this.qqRoteiroMovs = mov;
	}
}

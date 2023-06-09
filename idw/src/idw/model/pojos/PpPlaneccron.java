package idw.model.pojos;

import java.math.BigDecimal;
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

import idw.model.pojos.template.PpPlaneccronTemplate;

/**
 * PpPlaneccron generated by hbm2java
 */
@Entity
@Table(name = "PP_PLANECCRON")
public class PpPlaneccron extends PpPlaneccronTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8695335806664296106L;
	private Long idPlaneccron;
	private PpPlano ppPlano;
	private PpNeccron ppNeccron;
	private OmProduto omProduto;
	private Date dthrNecessaria;
	private BigDecimal qtNecessaria;
	private BigDecimal qtAcumprir;
	private BigDecimal qtEstoque;
	private Integer ordem;
	private Boolean isAntecipacao;

	private Set<PpCpneccron> ppCpneccrons = new HashSet<PpCpneccron>(0);

	public PpPlaneccron() {
	}

	public PpPlaneccron(Long idPlaneccron, PpPlano ppPlano,
			PpNeccron ppNeccron, OmProduto omProduto) {
		this.idPlaneccron = idPlaneccron;
		this.ppPlano = ppPlano;
		this.ppNeccron = ppNeccron;
		this.omProduto = omProduto;
	}

	public PpPlaneccron(Long idPlaneccron, PpPlano ppPlano,
			PpNeccron ppNeccron, OmProduto omProduto, Date dthrNecessaria,
			BigDecimal qtNecessaria) {
		this.idPlaneccron = idPlaneccron;
		this.ppPlano = ppPlano;
		this.ppNeccron = ppNeccron;
		this.omProduto = omProduto;
		this.dthrNecessaria = dthrNecessaria;
		this.qtNecessaria = qtNecessaria;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_PLANECCRON_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_PLANECCRON_SEQ", sequenceName = "PP_PLANECCRON_SEQ")
	@Column(name = "ID_PLANECCRON", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdPlaneccron() {
		return this.idPlaneccron;
	}

	public void setIdPlaneccron(Long idPlaneccron) {
		this.idPlaneccron = idPlaneccron;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PLANO", nullable = false)
	public PpPlano getPpPlano() {
		return this.ppPlano;
	}

	public void setPpPlano(PpPlano ppPlano) {
		this.ppPlano = ppPlano;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NECCRON", nullable = false)
	public PpNeccron getPpNeccron() {
		return this.ppNeccron;
	}

	public void setPpNeccron(PpNeccron ppNeccron) {
		this.ppNeccron = ppNeccron;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO", nullable = false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_NECESSARIA")
	public Date getDthrNecessaria() {
		return this.dthrNecessaria;
	}

	public void setDthrNecessaria(Date dthrNecessaria) {
		this.dthrNecessaria = dthrNecessaria;
	}

	@Column(name = "QT_NECESSARIA", precision = 63, scale = 0)
	public BigDecimal getQtNecessaria() {
		return this.qtNecessaria;
	}

	public void setQtNecessaria(BigDecimal qtNecessaria) {
		this.qtNecessaria = qtNecessaria;
	}
	@Column(name = "ORDEM")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	@Column(name = "QT_ESTOQUE", precision = 63, scale = 0)
	public BigDecimal getQtEstoque() {
		return this.qtEstoque;
	}

	public void setQtEstoque(BigDecimal qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ppPlaneccron")
	public Set<PpCpneccron> getPpCpneccrons() {
		return this.ppCpneccrons;
	}

	public void setPpCpneccrons(Set<PpCpneccron> ppCpneccrons) {
		this.ppCpneccrons = ppCpneccrons;
	}

	@Column(name = "QT_ACUMPRIR", precision = 63, scale = 0)
	public BigDecimal getQtAcumprir() {
		return this.qtAcumprir;
	}

	public void setQtAcumprir(BigDecimal qtAcumprir) {
		this.qtAcumprir = qtAcumprir;
	}
	@Column(name = "IS_ANTECIPACAO")
	public Boolean getIsAntecipacao() {
		return this.isAntecipacao;
	}

	public void setIsAntecipacao(Boolean isAntecipacao) {
		this.isAntecipacao = isAntecipacao;
	}
}

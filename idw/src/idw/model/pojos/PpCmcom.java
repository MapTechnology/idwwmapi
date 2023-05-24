package idw.model.pojos;
// Generated 16/11/2011 13:46:36 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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

import idw.model.pojos.template.PpCmcomTemplate;

/**
 * PpCmcom generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_CMCOM")
public class PpCmcom extends PpCmcomTemplate implements java.io.Serializable {

	private Long idCmcom;
	private PpCm ppCm;
	private OmProduto omProdutoByFinal;
	private OmProduto omProdutoByIdProdutosai;
	private OmProduto omProdutoByIdProdutoentra;
	private Date dthrVigor;
	private Integer isConsumirmp;
	private BigDecimal qtSai;
	private BigDecimal qtEntra;
	private String obs;
	private String posicao;
	private Date dthrSai;

	public PpCmcom() {
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_CMCOM_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_CMCOM_SEQ", sequenceName = "PP_CMCOM_SEQ")
	@Column(name = "ID_CMCOM", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdCmcom() {
		return this.idCmcom;
	}

	public void setIdCmcom(Long idCmcom) {
		this.idCmcom = idCmcom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CM", nullable = false)
	public PpCm getPpCm() {
		return this.ppCm;
	}

	public void setPpCm(PpCm ppCm) {
		this.ppCm = ppCm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTOFINAL", nullable = false)
	public OmProduto getOmProdutoByFinal() {
		return this.omProdutoByFinal;
	}

	public void setOmProdutoByFinal(OmProduto omProdutoByIdProduto) {
		this.omProdutoByFinal = omProdutoByIdProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTOSAI", nullable = true)
	public OmProduto getOmProdutoByIdProdutosai() {
		return this.omProdutoByIdProdutosai;
	}

	public void setOmProdutoByIdProdutosai(OmProduto omProdutoByIdProdutosai) {
		this.omProdutoByIdProdutosai = omProdutoByIdProdutosai;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTOENTRA", nullable = true)
	public OmProduto getOmProdutoByIdProdutoentra() {
		return this.omProdutoByIdProdutoentra;
	}

	public void setOmProdutoByIdProdutoentra(OmProduto omProdutoByIdProdutoentra) {
		this.omProdutoByIdProdutoentra = omProdutoByIdProdutoentra;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_VIGOR", length = 7)
	public Date getDthrVigor() {
		return this.dthrVigor;
	}

	public void setDthrVigor(Date dthrVigor) {
		this.dthrVigor = dthrVigor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_SAI", length = 7)
	public Date getDthrSai() {
		return this.dthrSai;
	}

	public void setDthrSai(Date dthrSai) {
		this.dthrSai = dthrSai;
	}
	
	@Column(name = "IS_CONSUMIRMP", precision = 22, scale = 0)
	public Integer getIsConsumirmp() {
		return this.isConsumirmp;
	}

	public void setIsConsumirmp(Integer isConsumirmp) {
		this.isConsumirmp = isConsumirmp;
	}

	@Column(name = "QT_SAI", precision = 14, scale = 4)
	public BigDecimal getQtSai() {
		return this.qtSai;
	}

	public void setQtSai(BigDecimal qtSaiP) {
		this.qtSai = qtSaiP;
	}
	@Column(name = "QT_ENTRA", precision = 14, scale = 4)
	public BigDecimal getQtEntra() {
		return this.qtEntra;
	}

	public void setQtEntra(BigDecimal qtEntraP) {
		this.qtEntra = qtEntraP;
	}


	@Column(name = "POSICAO", length = 100)
	public String getPosicao() {
		return this.posicao;
	}

	public void setPosicao(String dsPt) {
		this.posicao = dsPt;
	}

	@Column(name = "OBS", length = 256)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String dsPt) {
		this.obs = dsPt;
	}

}
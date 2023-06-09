package idw.model.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.PpPlanptgtTemplate;

/**
 * PpPlanptgt generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_PLANPTGT")
public class PpPlanptgt extends PpPlanptgtTemplate implements java.io.Serializable {

	private Long idPlanptgt;
	private PpPlano ppPlano;
	private OmGt omGt;
	private OmPt omPt;
	private BigDecimal linha;
	private BigDecimal coluna;
	private Boolean isCoordenadarelativa;
	private String aba;

	public PpPlanptgt() {
	}

	public PpPlanptgt(Long idPlanptgt, PpPlano ppPlano) {
		this.idPlanptgt = idPlanptgt;
		this.ppPlano = ppPlano;
	}

	public PpPlanptgt(Long idPlanptgt, PpPlano ppPlano, OmGt omGt,
			OmPt omPt, BigDecimal linha, BigDecimal coluna) {
		this.idPlanptgt = idPlanptgt;
		this.ppPlano = ppPlano;
		this.omGt = omGt;
		this.omPt = omPt;
		this.linha = linha;
		this.coluna = coluna;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_PLANPTGT_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_PLANPTGT_SEQ", sequenceName = "PP_PLANPTGT_SEQ")
	@Column(name = "ID_PLANPTGT", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdPlanptgt() {
		return this.idPlanptgt;
	}

	public void setIdPlanptgt(Long idPlanptgt) {
		this.idPlanptgt = idPlanptgt;
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
	@JoinColumn(name = "ID_GT")
	public OmGt getOmGt() {
		return this.omGt;
	}

	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT")
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Column(name = "LINHA", precision = 8, scale = 4)
	public BigDecimal getLinha() {
		return this.linha;
	}

	public void setLinha(BigDecimal linha) {
		this.linha = linha;
	}
	@Column(name = "ABA")
	public String getAba() {
		return this.aba;
	}

	public void setAba(String aba) {
		this.aba = aba;
	}

	@Column(name = "COLUNA", precision = 8, scale = 4)
	public BigDecimal getColuna() {
		return this.coluna;
	}

	public void setColuna(BigDecimal coluna) {
		this.coluna = coluna;
	}
	
	@Column(name = "IS_COORDENADARELATIVA", precision = 22, scale = 0)
	public Boolean getIsCoordenadarelativa() {
		return this.isCoordenadarelativa;
	}

	public void setIsCoordenadarelativa(Boolean isCoordenadarelativa) {
		this.isCoordenadarelativa = isCoordenadarelativa;
	}

}

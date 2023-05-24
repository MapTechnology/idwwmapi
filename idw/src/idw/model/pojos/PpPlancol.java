package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.PpPlancolTemplate;

/**
 * PpPlancol generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_PLANCOL")
public class PpPlancol extends PpPlancolTemplate implements java.io.Serializable {

	private Long idPlancol;
	private PpPlano ppPlano;
	private Boolean isId;
	private Boolean isRoteiro;
	private Boolean isProduto;
	private Boolean isQtdmagaz;
	private Boolean isNcjt;
	private Boolean isQtplan;
	private Boolean isQtcjt;
	private Boolean isSt;
	private Boolean isProdhora;
	private Boolean isTmpestim;
	private Boolean isAcuml;
	private Boolean isInicio;
	private Boolean isFim;
	private Boolean isTurno;
	private Boolean isDtcobertura;
	private Boolean isProducao;
	private Boolean isSaldoproduzir;
	private Boolean isIniciosaldo;
	private Boolean isApAberta;

	public PpPlancol() {
	}

	public PpPlancol(Long idPlancol, PpPlano ppPlano) {
		this.idPlancol = idPlancol;
		this.ppPlano = ppPlano;
	}

	public PpPlancol(Long idPlancol, PpPlano ppPlano,
			Boolean isRoteiro, Boolean isProduto, Boolean isQtdmagaz,
			Boolean isNcjt, Boolean isQtplan, Boolean isQtcjt,
			Boolean isSt, Boolean isProdhora, Boolean isTmpestim,
			Boolean isAcuml, Boolean isInicio, Boolean isFim,
			Boolean isTurno, Boolean isDtcobertura) {
		this.idPlancol = idPlancol;
		this.ppPlano = ppPlano;
		this.isRoteiro = isRoteiro;
		this.isProduto = isProduto;
		this.isQtdmagaz = isQtdmagaz;
		this.isNcjt = isNcjt;
		this.isQtplan = isQtplan;
		this.isQtcjt = isQtcjt;
		this.isSt = isSt;
		this.isProdhora = isProdhora;
		this.isTmpestim = isTmpestim;
		this.isAcuml = isAcuml;
		this.isInicio = isInicio;
		this.isFim = isFim;
		this.isTurno = isTurno;
		this.isDtcobertura = isDtcobertura;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "PP_PLANCOL_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_PLANCOL_SEQ", sequenceName = "PP_PLANCOL_SEQ")
	@Column(name = "ID_PLANCOL", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdPlancol() {
		return this.idPlancol;
	}

	public void setIdPlancol(Long idPlancol) {
		this.idPlancol = idPlancol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PLANO", nullable = false)
	public PpPlano getPpPlano() {
		return this.ppPlano;
	}

	public void setPpPlano(PpPlano ppPlano) {
		this.ppPlano = ppPlano;
	}

	@Column(name = "IS_ROTEIRO", precision = 22, scale = 0)
	public Boolean getIsRoteiro() {
		return this.isRoteiro;
	}

	public void setIsRoteiro(Boolean isRoteiro) {
		this.isRoteiro = isRoteiro;
	}

	@Column(name = "IS_PRODUTO", precision = 22, scale = 0)
	public Boolean getIsProduto() {
		return this.isProduto;
	}

	public void setIsProduto(Boolean isProduto) {
		this.isProduto = isProduto;
	}

	@Column(name = "IS_QTDMAGAZ", precision = 22, scale = 0)
	public Boolean getIsQtdmagaz() {
		return this.isQtdmagaz;
	}

	public void setIsQtdmagaz(Boolean isQtdmagaz) {
		this.isQtdmagaz = isQtdmagaz;
	}

	@Column(name = "IS_NCJT", precision = 22, scale = 0)
	public Boolean getIsNcjt() {
		return this.isNcjt;
	}

	public void setIsNcjt(Boolean isNcjt) {
		this.isNcjt = isNcjt;
	}

	@Column(name = "IS_QTPLAN", precision = 22, scale = 0)
	public Boolean getIsQtplan() {
		return this.isQtplan;
	}

	public void setIsQtplan(Boolean isQtplan) {
		this.isQtplan = isQtplan;
	}

	@Column(name = "IS_QTCJT", precision = 22, scale = 0)
	public Boolean getIsQtcjt() {
		return this.isQtcjt;
	}

	public void setIsQtcjt(Boolean isQtcjt) {
		this.isQtcjt = isQtcjt;
	}

	@Column(name = "IS_ST", precision = 22, scale = 0)
	public Boolean getIsSt() {
		return this.isSt;
	}

	public void setIsSt(Boolean isSt) {
		this.isSt = isSt;
	}

	@Column(name = "IS_PRODHORA", precision = 22, scale = 0)
	public Boolean getIsProdhora() {
		return this.isProdhora;
	}

	public void setIsProdhora(Boolean isProdhora) {
		this.isProdhora = isProdhora;
	}

	@Column(name = "IS_TMPESTIM", precision = 22, scale = 0)
	public Boolean getIsTmpestim() {
		return this.isTmpestim;
	}

	public void setIsTmpestim(Boolean isTmpestim) {
		this.isTmpestim = isTmpestim;
	}

	@Column(name = "IS_ACUML", precision = 22, scale = 0)
	public Boolean getIsAcuml() {
		return this.isAcuml;
	}

	public void setIsAcuml(Boolean isAcuml) {
		this.isAcuml = isAcuml;
	}

	@Column(name = "IS_INICIO", precision = 22, scale = 0)
	public Boolean getIsInicio() {
		return this.isInicio;
	}

	public void setIsInicio(Boolean isInicio) {
		this.isInicio = isInicio;
	}

	@Column(name = "IS_FIM", precision = 22, scale = 0)
	public Boolean getIsFim() {
		return this.isFim;
	}

	public void setIsFim(Boolean isFim) {
		this.isFim = isFim;
	}

	@Column(name = "IS_TURNO", precision = 22, scale = 0)
	public Boolean getIsTurno() {
		return this.isTurno;
	}

	public void setIsTurno(Boolean isTurno) {
		this.isTurno = isTurno;
	}

	@Column(name = "IS_DTCOBERTURA", precision = 22, scale = 0)
	public Boolean getIsDtcobertura() {
		return this.isDtcobertura;
	}

	public void setIsDtcobertura(Boolean isDtcobertura) {
		this.isDtcobertura = isDtcobertura;
	}

	@Column(name = "IS_IDCP", precision = 22, scale = 0)
	public Boolean getIsId() {
		return isId;
	}
	public void setIsId(Boolean isId) {
		this.isId = isId;
	}

	@Column(name = "IS_PRODUCAO")
	public Boolean getIsProducao() {
		return isProducao;
	}
	public void setIsProducao(Boolean isProducao) {
		this.isProducao = isProducao;
	}

	@Column(name = "IS_SALDOPRODUZIR")
	public Boolean getIsSaldoproduzir() {
		return isSaldoproduzir;
	}
	public void setIsSaldoproduzir(Boolean isSaldo) {
		this.isSaldoproduzir = isSaldo;
	}

	@Column(name = "IS_INICIOSALDO")
	public Boolean getIsIniciosaldo() {
		return isIniciosaldo;
	}
	public void setIsIniciosaldo(Boolean isIniciosaldo) {
		this.isIniciosaldo = isIniciosaldo;
	}

	@Column(name = "IS_AP_ABERTA")
	public Boolean getIsApAberta() {
		return isApAberta;
	}

	public void setIsApAberta(Boolean isApAberta) {
		this.isApAberta = isApAberta;
	}
}

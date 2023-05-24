package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ijopagrupintbet generated by hbm2java
 */
@Entity
@Table(name = "IJOPAGRUPINTBET", uniqueConstraints = @UniqueConstraint(columnNames = {
		"NROP", "NR_ORD_PROD", "OP_CODIGO", "SEQUENCIA", "CDPRODUTO" }))
public class Ijopagrupintbet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8249742813828167149L;
	private double idregistro;
	private String nrop;
	private String nrOrdProd;
	private String opCodigo;
	private String sequencia;
	private String cdproduto;
	private double qtOrdem;
	private double qtProdLiquida;
	private BigDecimal stagrupamento;
	private BigDecimal stexportadofimop;
	private double idregfilakanban;
	private String cdfamilia;
	private String cdmolde;
	private String cdestrutura;

	public Ijopagrupintbet() {
	}

	public Ijopagrupintbet(double idregistro, String nrop, String nrOrdProd,
			String opCodigo, String sequencia, String cdproduto,
			double qtOrdem, double qtProdLiquida, BigDecimal stagrupamento,
			BigDecimal stexportadofimop, double idregfilakanban,
			String cdfamilia) {
		this.idregistro = idregistro;
		this.nrop = nrop;
		this.nrOrdProd = nrOrdProd;
		this.opCodigo = opCodigo;
		this.sequencia = sequencia;
		this.cdproduto = cdproduto;
		this.qtOrdem = qtOrdem;
		this.qtProdLiquida = qtProdLiquida;
		this.stagrupamento = stagrupamento;
		this.stexportadofimop = stexportadofimop;
		this.idregfilakanban = idregfilakanban;
		this.cdfamilia = cdfamilia;
	}

	public Ijopagrupintbet(double idregistro, String nrop, String nrOrdProd,
			String opCodigo, String sequencia, String cdproduto,
			double qtOrdem, double qtProdLiquida, BigDecimal stagrupamento,
			BigDecimal stexportadofimop, double idregfilakanban,
			String cdfamilia, String cdmolde, String cdestrutura) {
		this.idregistro = idregistro;
		this.nrop = nrop;
		this.nrOrdProd = nrOrdProd;
		this.opCodigo = opCodigo;
		this.sequencia = sequencia;
		this.cdproduto = cdproduto;
		this.qtOrdem = qtOrdem;
		this.qtProdLiquida = qtProdLiquida;
		this.stagrupamento = stagrupamento;
		this.stexportadofimop = stexportadofimop;
		this.idregfilakanban = idregfilakanban;
		this.cdfamilia = cdfamilia;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(double idregistro) {
		this.idregistro = idregistro;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "NR_ORD_PROD", nullable = false, length = 10)
	public String getNrOrdProd() {
		return this.nrOrdProd;
	}

	public void setNrOrdProd(String nrOrdProd) {
		this.nrOrdProd = nrOrdProd;
	}

	@Column(name = "OP_CODIGO", nullable = false, length = 6)
	public String getOpCodigo() {
		return this.opCodigo;
	}

	public void setOpCodigo(String opCodigo) {
		this.opCodigo = opCodigo;
	}

	@Column(name = "SEQUENCIA", nullable = false, length = 4)
	public String getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "QT_ORDEM", nullable = false, precision = 126, scale = 0)
	public double getQtOrdem() {
		return this.qtOrdem;
	}

	public void setQtOrdem(double qtOrdem) {
		this.qtOrdem = qtOrdem;
	}

	@Column(name = "QT_PROD_LIQUIDA", nullable = false, precision = 126, scale = 0)
	public double getQtProdLiquida() {
		return this.qtProdLiquida;
	}

	public void setQtProdLiquida(double qtProdLiquida) {
		this.qtProdLiquida = qtProdLiquida;
	}

	@Column(name = "STAGRUPAMENTO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStagrupamento() {
		return this.stagrupamento;
	}

	public void setStagrupamento(BigDecimal stagrupamento) {
		this.stagrupamento = stagrupamento;
	}

	@Column(name = "STEXPORTADOFIMOP", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStexportadofimop() {
		return this.stexportadofimop;
	}

	public void setStexportadofimop(BigDecimal stexportadofimop) {
		this.stexportadofimop = stexportadofimop;
	}

	@Column(name = "IDREGFILAKANBAN", nullable = false, precision = 126, scale = 0)
	public double getIdregfilakanban() {
		return this.idregfilakanban;
	}

	public void setIdregfilakanban(double idregfilakanban) {
		this.idregfilakanban = idregfilakanban;
	}

	@Column(name = "CDFAMILIA", nullable = false, length = 8)
	public String getCdfamilia() {
		return this.cdfamilia;
	}

	public void setCdfamilia(String cdfamilia) {
		this.cdfamilia = cdfamilia;
	}

	@Column(name = "CDMOLDE", length = 6)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

}
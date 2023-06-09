package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijfilakanbanintbet generated by hbm2java
 */
@Entity
@Table(name = "IJFILAKANBANINTBET")
public class Ijfilakanbanintbet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2412487326474932985L;
	private double idregistro;
	private Ijtbpro ijtbpro;
	private Ijtbfamiliamaq ijtbfamiliamaq;
	private String cdmolde;
	private String cdestrutura;
	private String nrOrdProd;
	private String opCodigo;
	private String sequencia;
	private double qtOrdem;
	private BigDecimal stregistro;

	public Ijfilakanbanintbet() {
	}

	public Ijfilakanbanintbet(double idregistro, Ijtbpro ijtbpro,
			Ijtbfamiliamaq ijtbfamiliamaq, String nrOrdProd, String opCodigo,
			String sequencia, double qtOrdem, BigDecimal stregistro) {
		this.idregistro = idregistro;
		this.ijtbpro = ijtbpro;
		this.ijtbfamiliamaq = ijtbfamiliamaq;
		this.nrOrdProd = nrOrdProd;
		this.opCodigo = opCodigo;
		this.sequencia = sequencia;
		this.qtOrdem = qtOrdem;
		this.stregistro = stregistro;
	}

	public Ijfilakanbanintbet(double idregistro, Ijtbpro ijtbpro,
			Ijtbfamiliamaq ijtbfamiliamaq, String cdmolde, String cdestrutura,
			String nrOrdProd, String opCodigo, String sequencia,
			double qtOrdem, BigDecimal stregistro) {
		this.idregistro = idregistro;
		this.ijtbpro = ijtbpro;
		this.ijtbfamiliamaq = ijtbfamiliamaq;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.nrOrdProd = nrOrdProd;
		this.opCodigo = opCodigo;
		this.sequencia = sequencia;
		this.qtOrdem = qtOrdem;
		this.stregistro = stregistro;
	}

	@Id
	@Column(name = "IDREGISTRO", unique = true, nullable = false, precision = 126, scale = 0)
	public double getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(double idregistro) {
		this.idregistro = idregistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPRODUTO", nullable = false)
	public Ijtbpro getIjtbpro() {
		return this.ijtbpro;
	}

	public void setIjtbpro(Ijtbpro ijtbpro) {
		this.ijtbpro = ijtbpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDFAMILIA", nullable = false)
	public Ijtbfamiliamaq getIjtbfamiliamaq() {
		return this.ijtbfamiliamaq;
	}

	public void setIjtbfamiliamaq(Ijtbfamiliamaq ijtbfamiliamaq) {
		this.ijtbfamiliamaq = ijtbfamiliamaq;
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

	@Column(name = "QT_ORDEM", nullable = false, precision = 126, scale = 0)
	public double getQtOrdem() {
		return this.qtOrdem;
	}

	public void setQtOrdem(double qtOrdem) {
		this.qtOrdem = qtOrdem;
	}

	@Column(name = "STREGISTRO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(BigDecimal stregistro) {
		this.stregistro = stregistro;
	}

}

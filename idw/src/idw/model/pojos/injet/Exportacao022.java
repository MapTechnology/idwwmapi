package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exportacao022 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_022")
public class Exportacao022 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 468139986890128280L;
	private Exportacao022Id id;
	private String nrop;
	private String cdproduto;
	private String cdmaquina;
	private String cdmolde;
	private String cdestrutura;
	private Date dtiniciclo;
	private Date hriniciclo;
	private Date dtfimciclo;
	private Date hrfimciclo;
	private double qtproduzida;
	private double cdturno;
	private String cdoperador;
	private String stregistro;
	private String obs;
	private String cdcentrocusto;

	public Exportacao022() {
	}

	public Exportacao022(Exportacao022Id id, String nrop, String cdproduto,
			String cdmaquina, String cdmolde, String cdestrutura,
			Date dtiniciclo, Date hriniciclo, Date dtfimciclo, Date hrfimciclo,
			double qtproduzida, double cdturno, String cdoperador,
			String stregistro) {
		this.id = id;
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.cdmaquina = cdmaquina;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dtiniciclo = dtiniciclo;
		this.hriniciclo = hriniciclo;
		this.dtfimciclo = dtfimciclo;
		this.hrfimciclo = hrfimciclo;
		this.qtproduzida = qtproduzida;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.stregistro = stregistro;
	}

	public Exportacao022(Exportacao022Id id, String nrop, String cdproduto,
			String cdmaquina, String cdmolde, String cdestrutura,
			Date dtiniciclo, Date hriniciclo, Date dtfimciclo, Date hrfimciclo,
			double qtproduzida, double cdturno, String cdoperador,
			String stregistro, String obs, String cdcentrocusto) {
		this.id = id;
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.cdmaquina = cdmaquina;
		this.cdmolde = cdmolde;
		this.cdestrutura = cdestrutura;
		this.dtiniciclo = dtiniciclo;
		this.hriniciclo = hriniciclo;
		this.dtfimciclo = dtfimciclo;
		this.hrfimciclo = hrfimciclo;
		this.qtproduzida = qtproduzida;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.stregistro = stregistro;
		this.obs = obs;
		this.cdcentrocusto = cdcentrocusto;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idregistro", column = @Column(name = "IDREGISTRO", nullable = false, length = 14)),
			@AttributeOverride(name = "idempresa", column = @Column(name = "IDEMPRESA", nullable = false, length = 2)) })
	public Exportacao022Id getId() {
		return this.id;
	}

	public void setId(Exportacao022Id id) {
		this.id = id;
	}

	@Column(name = "NROP", nullable = false, length = 25)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "CDMAQUINA", nullable = false, length = 8)
	public String getCdmaquina() {
		return this.cdmaquina;
	}

	public void setCdmaquina(String cdmaquina) {
		this.cdmaquina = cdmaquina;
	}

	@Column(name = "CDMOLDE", nullable = false, length = 18)
	public String getCdmolde() {
		return this.cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	@Column(name = "CDESTRUTURA", nullable = false, length = 4)
	public String getCdestrutura() {
		return this.cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINICICLO", nullable = false, length = 7)
	public Date getDtiniciclo() {
		return this.dtiniciclo;
	}

	public void setDtiniciclo(Date dtiniciclo) {
		this.dtiniciclo = dtiniciclo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HRINICICLO", nullable = false, length = 7)
	public Date getHriniciclo() {
		return this.hriniciclo;
	}

	public void setHriniciclo(Date hriniciclo) {
		this.hriniciclo = hriniciclo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTFIMCICLO", nullable = false, length = 7)
	public Date getDtfimciclo() {
		return this.dtfimciclo;
	}

	public void setDtfimciclo(Date dtfimciclo) {
		this.dtfimciclo = dtfimciclo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HRFIMCICLO", nullable = false, length = 7)
	public Date getHrfimciclo() {
		return this.hrfimciclo;
	}

	public void setHrfimciclo(Date hrfimciclo) {
		this.hrfimciclo = hrfimciclo;
	}

	@Column(name = "QTPRODUZIDA", nullable = false, precision = 126, scale = 0)
	public double getQtproduzida() {
		return this.qtproduzida;
	}

	public void setQtproduzida(double qtproduzida) {
		this.qtproduzida = qtproduzida;
	}

	@Column(name = "CDTURNO", nullable = false, precision = 126, scale = 0)
	public double getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(double cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "CDOPERADOR", nullable = false, length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "STREGISTRO", nullable = false, length = 1)
	public String getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(String stregistro) {
		this.stregistro = stregistro;
	}

	@Column(name = "OBS", length = 2)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Column(name = "CDCENTROCUSTO", length = 10)
	public String getCdcentrocusto() {
		return this.cdcentrocusto;
	}

	public void setCdcentrocusto(String cdcentrocusto) {
		this.cdcentrocusto = cdcentrocusto;
	}

}

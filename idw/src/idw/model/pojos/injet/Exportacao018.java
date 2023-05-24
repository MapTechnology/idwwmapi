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
 * Exportacao018 generated by hbm2java
 */
@Entity
@Table(name = "EXPORTACAO_018")
public class Exportacao018 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8252849070656868164L;
	private Exportacao018Id id;
	private String dtrefturno;
	private char cdturno;
	private String cdoperador;
	private String cdmaquina;
	private String cdproduto;
	private Date dthrlogin;
	private String dtinicio;
	private String hrinicio;
	private String dtfim;
	private String hrfim;
	private double qtproduzida;
	private char stregistro;
	private Date dthrstregistro;

	public Exportacao018() {
	}

	public Exportacao018(Exportacao018Id id, String dtrefturno, char cdturno,
			String cdoperador, String cdmaquina, String cdproduto,
			Date dthrlogin, String dtinicio, String hrinicio,
			double qtproduzida, char stregistro, Date dthrstregistro) {
		this.id = id;
		this.dtrefturno = dtrefturno;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.cdmaquina = cdmaquina;
		this.cdproduto = cdproduto;
		this.dthrlogin = dthrlogin;
		this.dtinicio = dtinicio;
		this.hrinicio = hrinicio;
		this.qtproduzida = qtproduzida;
		this.stregistro = stregistro;
		this.dthrstregistro = dthrstregistro;
	}

	public Exportacao018(Exportacao018Id id, String dtrefturno, char cdturno,
			String cdoperador, String cdmaquina, String cdproduto,
			Date dthrlogin, String dtinicio, String hrinicio, String dtfim,
			String hrfim, double qtproduzida, char stregistro,
			Date dthrstregistro) {
		this.id = id;
		this.dtrefturno = dtrefturno;
		this.cdturno = cdturno;
		this.cdoperador = cdoperador;
		this.cdmaquina = cdmaquina;
		this.cdproduto = cdproduto;
		this.dthrlogin = dthrlogin;
		this.dtinicio = dtinicio;
		this.hrinicio = hrinicio;
		this.dtfim = dtfim;
		this.hrfim = hrfim;
		this.qtproduzida = qtproduzida;
		this.stregistro = stregistro;
		this.dthrstregistro = dthrstregistro;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idregistro", column = @Column(name = "IDREGISTRO", nullable = false, length = 13)),
			@AttributeOverride(name = "idplanta", column = @Column(name = "IDPLANTA", nullable = false, length = 4)),
			@AttributeOverride(name = "idarea", column = @Column(name = "IDAREA", nullable = false, length = 10)) })
	public Exportacao018Id getId() {
		return this.id;
	}

	public void setId(Exportacao018Id id) {
		this.id = id;
	}

	@Column(name = "DTREFTURNO", nullable = false, length = 8)
	public String getDtrefturno() {
		return this.dtrefturno;
	}

	public void setDtrefturno(String dtrefturno) {
		this.dtrefturno = dtrefturno;
	}

	@Column(name = "CDTURNO", nullable = false, length = 1)
	public char getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(char cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name = "CDOPERADOR", nullable = false, length = 6)
	public String getCdoperador() {
		return this.cdoperador;
	}

	public void setCdoperador(String cdoperador) {
		this.cdoperador = cdoperador;
	}

	@Column(name = "CDMAQUINA", nullable = false, length = 6)
	public String getCdmaquina() {
		return this.cdmaquina;
	}

	public void setCdmaquina(String cdmaquina) {
		this.cdmaquina = cdmaquina;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRLOGIN", nullable = false, length = 7)
	public Date getDthrlogin() {
		return this.dthrlogin;
	}

	public void setDthrlogin(Date dthrlogin) {
		this.dthrlogin = dthrlogin;
	}

	@Column(name = "DTINICIO", nullable = false, length = 8)
	public String getDtinicio() {
		return this.dtinicio;
	}

	public void setDtinicio(String dtinicio) {
		this.dtinicio = dtinicio;
	}

	@Column(name = "HRINICIO", nullable = false, length = 8)
	public String getHrinicio() {
		return this.hrinicio;
	}

	public void setHrinicio(String hrinicio) {
		this.hrinicio = hrinicio;
	}

	@Column(name = "DTFIM", length = 8)
	public String getDtfim() {
		return this.dtfim;
	}

	public void setDtfim(String dtfim) {
		this.dtfim = dtfim;
	}

	@Column(name = "HRFIM", length = 8)
	public String getHrfim() {
		return this.hrfim;
	}

	public void setHrfim(String hrfim) {
		this.hrfim = hrfim;
	}

	@Column(name = "QTPRODUZIDA", nullable = false, precision = 126, scale = 0)
	public double getQtproduzida() {
		return this.qtproduzida;
	}

	public void setQtproduzida(double qtproduzida) {
		this.qtproduzida = qtproduzida;
	}

	@Column(name = "STREGISTRO", nullable = false, length = 1)
	public char getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(char stregistro) {
		this.stregistro = stregistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHRSTREGISTRO", nullable = false, length = 7)
	public Date getDthrstregistro() {
		return this.dthrstregistro;
	}

	public void setDthrstregistro(Date dthrstregistro) {
		this.dthrstregistro = dthrstregistro;
	}

}

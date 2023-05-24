package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ijfilaopmontagem generated by hbm2java
 */
@Entity
@Table(name = "IJFILAOPMONTAGEM")
public class Ijfilaopmontagem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8657274508294821227L;
	private String nrop;
	private String cdproduto;
	private String prioridade;
	private double qtplanejada;
	private double tempociclo;
	private Date dthriniplan;
	private Date dthrfimplan;

	public Ijfilaopmontagem() {
	}

	public Ijfilaopmontagem(String nrop, String cdproduto, double qtplanejada,
			double tempociclo, Date dthriniplan, Date dthrfimplan) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.qtplanejada = qtplanejada;
		this.tempociclo = tempociclo;
		this.dthriniplan = dthriniplan;
		this.dthrfimplan = dthrfimplan;
	}

	public Ijfilaopmontagem(String nrop, String cdproduto, String prioridade,
			double qtplanejada, double tempociclo, Date dthriniplan,
			Date dthrfimplan) {
		this.nrop = nrop;
		this.cdproduto = cdproduto;
		this.prioridade = prioridade;
		this.qtplanejada = qtplanejada;
		this.tempociclo = tempociclo;
		this.dthriniplan = dthriniplan;
		this.dthrfimplan = dthrfimplan;
	}

	@Id
	@Column(name = "NROP", unique = true, nullable = false, length = 10)
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

	@Column(name = "PRIORIDADE", length = 1)
	public String getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	@Column(name = "QTPLANEJADA", nullable = false, precision = 126, scale = 0)
	public double getQtplanejada() {
		return this.qtplanejada;
	}

	public void setQtplanejada(double qtplanejada) {
		this.qtplanejada = qtplanejada;
	}

	@Column(name = "TEMPOCICLO", nullable = false, precision = 126, scale = 0)
	public double getTempociclo() {
		return this.tempociclo;
	}

	public void setTempociclo(double tempociclo) {
		this.tempociclo = tempociclo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRINIPLAN", nullable = false, length = 7)
	public Date getDthriniplan() {
		return this.dthriniplan;
	}

	public void setDthriniplan(Date dthriniplan) {
		this.dthriniplan = dthriniplan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRFIMPLAN", nullable = false, length = 7)
	public Date getDthrfimplan() {
		return this.dthrfimplan;
	}

	public void setDthrfimplan(Date dthrfimplan) {
		this.dthrfimplan = dthrfimplan;
	}

}

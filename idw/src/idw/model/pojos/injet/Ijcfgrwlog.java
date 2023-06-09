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
 * Ijcfgrwlog generated by hbm2java
 */
@Entity
@Table(name = "IJCFGRWLOG")
public class Ijcfgrwlog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4565513640161583016L;
	private Date dthrlog;
	private String cdusuario;
	private String motivoalteracao;
	private double qtdmaxhrssemana;
	private double qtdmediahrssemana;

	public Ijcfgrwlog() {
	}

	public Ijcfgrwlog(Date dthrlog, String cdusuario, String motivoalteracao,
			double qtdmaxhrssemana, double qtdmediahrssemana) {
		this.dthrlog = dthrlog;
		this.cdusuario = cdusuario;
		this.motivoalteracao = motivoalteracao;
		this.qtdmaxhrssemana = qtdmaxhrssemana;
		this.qtdmediahrssemana = qtdmediahrssemana;
	}

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRLOG", unique = true, nullable = false, length = 7)
	public Date getDthrlog() {
		return this.dthrlog;
	}

	public void setDthrlog(Date dthrlog) {
		this.dthrlog = dthrlog;
	}

	@Column(name = "CDUSUARIO", nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@Column(name = "MOTIVOALTERACAO", nullable = false, length = 100)
	public String getMotivoalteracao() {
		return this.motivoalteracao;
	}

	public void setMotivoalteracao(String motivoalteracao) {
		this.motivoalteracao = motivoalteracao;
	}

	@Column(name = "QTDMAXHRSSEMANA", nullable = false, precision = 126, scale = 0)
	public double getQtdmaxhrssemana() {
		return this.qtdmaxhrssemana;
	}

	public void setQtdmaxhrssemana(double qtdmaxhrssemana) {
		this.qtdmaxhrssemana = qtdmaxhrssemana;
	}

	@Column(name = "QTDMEDIAHRSSEMANA", nullable = false, precision = 126, scale = 0)
	public double getQtdmediahrssemana() {
		return this.qtdmediahrssemana;
	}

	public void setQtdmediahrssemana(double qtdmediahrssemana) {
		this.qtdmediahrssemana = qtdmediahrssemana;
	}

}

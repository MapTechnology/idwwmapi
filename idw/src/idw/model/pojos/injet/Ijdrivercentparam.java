package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijdrivercentparam generated by hbm2java
 */
@Entity
@Table(name = "IJDRIVERCENTPARAM")
public class Ijdrivercentparam implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3965932264283375523L;
	private IjdrivercentparamId id;
	private Ijdrivercent ijdrivercent;
	private String dsparametro;
	private String parametro;

	public Ijdrivercentparam() {
	}

	public Ijdrivercentparam(IjdrivercentparamId id, Ijdrivercent ijdrivercent,
			String dsparametro, String parametro) {
		this.id = id;
		this.ijdrivercent = ijdrivercent;
		this.dsparametro = dsparametro;
		this.parametro = parametro;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "iddrivercentral", column = @Column(name = "IDDRIVERCENTRAL", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "ordemparametro", column = @Column(name = "ORDEMPARAMETRO", nullable = false, precision = 22, scale = 0)) })
	public IjdrivercentparamId getId() {
		return this.id;
	}

	public void setId(IjdrivercentparamId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDDRIVERCENTRAL", nullable = false, insertable = false, updatable = false)
	public Ijdrivercent getIjdrivercent() {
		return this.ijdrivercent;
	}

	public void setIjdrivercent(Ijdrivercent ijdrivercent) {
		this.ijdrivercent = ijdrivercent;
	}

	@Column(name = "DSPARAMETRO", nullable = false, length = 60)
	public String getDsparametro() {
		return this.dsparametro;
	}

	public void setDsparametro(String dsparametro) {
		this.dsparametro = dsparametro;
	}

	@Column(name = "PARAMETRO", nullable = false)
	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

}

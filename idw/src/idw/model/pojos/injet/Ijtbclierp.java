package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbclierp generated by hbm2java
 */
@Entity
@Table(name = "IJTBCLIERP")
public class Ijtbclierp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120256176416785931L;
	private String cdcliente;
	private Ijtbcli ijtbcli;

	public Ijtbclierp() {
	}

	public Ijtbclierp(String cdcliente, Ijtbcli ijtbcli) {
		this.cdcliente = cdcliente;
		this.ijtbcli = ijtbcli;
	}

	@Id
	@Column(name = "CDCLIENTE", unique = true, nullable = false, length = 6)
	public String getCdcliente() {
		return this.cdcliente;
	}

	public void setCdcliente(String cdcliente) {
		this.cdcliente = cdcliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDCLIENTE", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbcli getIjtbcli() {
		return this.ijtbcli;
	}

	public void setIjtbcli(Ijtbcli ijtbcli) {
		this.ijtbcli = ijtbcli;
	}

}
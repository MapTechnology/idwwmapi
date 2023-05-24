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
 * Ijcomequipcent generated by hbm2java
 */
@Entity
@Table(name = "IJCOMEQUIPCENT")
public class Ijcomequipcent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7216892687132578260L;
	private String cdequipamento;
	private Ijtbequipamentos ijtbequipamentos;
	private Ijtbcentinsp ijtbcentinsp;
	private String portacomunic;

	public Ijcomequipcent() {
	}

	public Ijcomequipcent(String cdequipamento,
			Ijtbequipamentos ijtbequipamentos, Ijtbcentinsp ijtbcentinsp,
			String portacomunic) {
		this.cdequipamento = cdequipamento;
		this.ijtbequipamentos = ijtbequipamentos;
		this.ijtbcentinsp = ijtbcentinsp;
		this.portacomunic = portacomunic;
	}

	@Id
	@Column(name = "CDEQUIPAMENTO", unique = true, nullable = false, length = 6)
	public String getCdequipamento() {
		return this.cdequipamento;
	}

	public void setCdequipamento(String cdequipamento) {
		this.cdequipamento = cdequipamento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDEQUIPAMENTO", nullable = false)
	public Ijtbequipamentos getIjtbequipamentos() {
		return this.ijtbequipamentos;
	}

	public void setIjtbequipamentos(Ijtbequipamentos ijtbequipamentos) {
		this.ijtbequipamentos = ijtbequipamentos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDCENTINSP", nullable = false)
	public Ijtbcentinsp getIjtbcentinsp() {
		return this.ijtbcentinsp;
	}

	public void setIjtbcentinsp(Ijtbcentinsp ijtbcentinsp) {
		this.ijtbcentinsp = ijtbcentinsp;
	}

	@Column(name = "PORTACOMUNIC", nullable = false, length = 12)
	public String getPortacomunic() {
		return this.portacomunic;
	}

	public void setPortacomunic(String portacomunic) {
		this.portacomunic = portacomunic;
	}

}

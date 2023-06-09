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
 * Ijopopermaq generated by hbm2java
 */
@Entity
@Table(name = "IJOPOPERMAQ")
public class Ijopopermaq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5559200164354147630L;
	private String nrop;
	private Ijop ijop;
	private String operacao;

	public Ijopopermaq() {
	}

	public Ijopopermaq(String nrop, Ijop ijop, String operacao) {
		this.nrop = nrop;
		this.ijop = ijop;
		this.operacao = operacao;
	}

	@Id
	@Column(name = "NROP", unique = true, nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@Column(name = "OPERACAO", nullable = false, length = 4)
	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

}

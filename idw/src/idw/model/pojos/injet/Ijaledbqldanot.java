package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Ijaledbqldanot generated by hbm2java
 */
@Entity
@Table(name = "IJALEDBQLDANOT", uniqueConstraints = @UniqueConstraint(columnNames = {
		"IDREGDBQLD", "DTHRANOTACAO", "CDUSUARIO" }))
public class Ijaledbqldanot implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8119019851461191452L;
	private double idregistro;
	private Ijaledbqld ijaledbqld;
	private Ijtbusu ijtbusu;
	private Date dthranotacao;
	private String anotacao;

	public Ijaledbqldanot() {
	}

	public Ijaledbqldanot(double idregistro, Ijaledbqld ijaledbqld,
			Ijtbusu ijtbusu, Date dthranotacao, String anotacao) {
		this.idregistro = idregistro;
		this.ijaledbqld = ijaledbqld;
		this.ijtbusu = ijtbusu;
		this.dthranotacao = dthranotacao;
		this.anotacao = anotacao;
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
	@JoinColumn(name = "IDREGDBQLD", nullable = false)
	public Ijaledbqld getIjaledbqld() {
		return this.ijaledbqld;
	}

	public void setIjaledbqld(Ijaledbqld ijaledbqld) {
		this.ijaledbqld = ijaledbqld;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", nullable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHRANOTACAO", nullable = false, length = 7)
	public Date getDthranotacao() {
		return this.dthranotacao;
	}

	public void setDthranotacao(Date dthranotacao) {
		this.dthranotacao = dthranotacao;
	}

	@Column(name = "ANOTACAO", nullable = false)
	public String getAnotacao() {
		return this.anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

}

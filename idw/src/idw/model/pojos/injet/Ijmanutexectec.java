package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijmanutexectec generated by hbm2java
 */
@Entity
@Table(name = "IJMANUTEXECTEC")
public class Ijmanutexectec implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8775327357435849198L;
	private IjmanutexectecId id;
	private Ijmanutexec ijmanutexec;
	private Ijtbusu ijtbusu;
	private double qtdhrs;

	public Ijmanutexectec() {
	}

	public Ijmanutexectec(IjmanutexectecId id, Ijmanutexec ijmanutexec,
			Ijtbusu ijtbusu, double qtdhrs) {
		this.id = id;
		this.ijmanutexec = ijmanutexec;
		this.ijtbusu = ijtbusu;
		this.qtdhrs = qtdhrs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nros", column = @Column(name = "NROS", nullable = false, length = 12)),
			@AttributeOverride(name = "seqitem", column = @Column(name = "SEQITEM", nullable = false, precision = 126, scale = 0)),
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", nullable = false, length = 6)) })
	public IjmanutexectecId getId() {
		return this.id;
	}

	public void setId(IjmanutexectecId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "NROS", referencedColumnName = "NROS", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "SEQITEM", referencedColumnName = "SEQITEM", nullable = false, insertable = false, updatable = false) })
	public Ijmanutexec getIjmanutexec() {
		return this.ijmanutexec;
	}

	public void setIjmanutexec(Ijmanutexec ijmanutexec) {
		this.ijmanutexec = ijmanutexec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", nullable = false, insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Column(name = "QTDHRS", nullable = false, precision = 126, scale = 0)
	public double getQtdhrs() {
		return this.qtdhrs;
	}

	public void setQtdhrs(double qtdhrs) {
		this.qtdhrs = qtdhrs;
	}

}

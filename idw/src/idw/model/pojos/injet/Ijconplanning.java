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
 * Ijconplanning generated by hbm2java
 */
@Entity
@Table(name = "IJCONPLANNING")
public class Ijconplanning implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7749447142377014823L;
	private String cdusuario;
	private Ijtbusu ijtbusu;
	private char zoomgantt;
	private char legendacoresgantt;

	public Ijconplanning() {
	}

	public Ijconplanning(String cdusuario, Ijtbusu ijtbusu, char zoomgantt,
			char legendacoresgantt) {
		this.cdusuario = cdusuario;
		this.ijtbusu = ijtbusu;
		this.zoomgantt = zoomgantt;
		this.legendacoresgantt = legendacoresgantt;
	}

	@Id
	@Column(name = "CDUSUARIO", unique = true, nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDUSUARIO", unique = true, nullable = false, insertable = false, updatable = false)
	public Ijtbusu getIjtbusu() {
		return this.ijtbusu;
	}

	public void setIjtbusu(Ijtbusu ijtbusu) {
		this.ijtbusu = ijtbusu;
	}

	@Column(name = "ZOOMGANTT", nullable = false, length = 1)
	public char getZoomgantt() {
		return this.zoomgantt;
	}

	public void setZoomgantt(char zoomgantt) {
		this.zoomgantt = zoomgantt;
	}

	@Column(name = "LEGENDACORESGANTT", nullable = false, length = 1)
	public char getLegendacoresgantt() {
		return this.legendacoresgantt;
	}

	public void setLegendacoresgantt(char legendacoresgantt) {
		this.legendacoresgantt = legendacoresgantt;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbrejeitoimp generated by hbm2java
 */
@Entity
@Table(name = "IJTBREJEITOIMP")
public class Ijtbrejeitoimp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8637725123757333747L;
	private IjtbrejeitoimpId id;

	public Ijtbrejeitoimp() {
	}

	public Ijtbrejeitoimp(IjtbrejeitoimpId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdimplementacao", column = @Column(name = "CDIMPLEMENTACAO", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "cdtabelaimp", column = @Column(name = "CDTABELAIMP", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "dthrimportacao", column = @Column(name = "DTHRIMPORTACAO", nullable = false, length = 7)),
			@AttributeOverride(name = "registro", column = @Column(name = "REGISTRO", length = 250)) })
	public IjtbrejeitoimpId getId() {
		return this.id;
	}

	public void setId(IjtbrejeitoimpId id) {
		this.id = id;
	}

}
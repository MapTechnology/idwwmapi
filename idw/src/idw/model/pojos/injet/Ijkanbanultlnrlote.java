package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijkanbanultlnrlote generated by hbm2java
 */
@Entity
@Table(name = "IJKANBANULTLNRLOTE")
public class Ijkanbanultlnrlote implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1572997245057788631L;
	private IjkanbanultlnrloteId id;

	public Ijkanbanultlnrlote() {
	}

	public Ijkanbanultlnrlote(IjkanbanultlnrloteId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ano", column = @Column(name = "ANO", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "mes", column = @Column(name = "MES", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "sequencial", column = @Column(name = "SEQUENCIAL", nullable = false, precision = 126, scale = 0)) })
	public IjkanbanultlnrloteId getId() {
		return this.id;
	}

	public void setId(IjkanbanultlnrloteId id) {
		this.id = id;
	}

}

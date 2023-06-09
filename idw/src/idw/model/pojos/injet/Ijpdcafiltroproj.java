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
 * Ijpdcafiltroproj generated by hbm2java
 */
@Entity
@Table(name = "IJPDCAFILTROPROJ")
public class Ijpdcafiltroproj implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2165105337389555697L;
	private IjpdcafiltroprojId id;
	private Ijpdcaprojeto ijpdcaprojeto;

	public Ijpdcafiltroproj() {
	}

	public Ijpdcafiltroproj(IjpdcafiltroprojId id, Ijpdcaprojeto ijpdcaprojeto) {
		this.id = id;
		this.ijpdcaprojeto = ijpdcaprojeto;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nrprojeto", column = @Column(name = "NRPROJETO", nullable = false, length = 10)),
			@AttributeOverride(name = "idfiltro", column = @Column(name = "IDFILTRO", nullable = false, length = 20)),
			@AttributeOverride(name = "conteudofiltro", column = @Column(name = "CONTEUDOFILTRO", nullable = false, length = 40)) })
	public IjpdcafiltroprojId getId() {
		return this.id;
	}

	public void setId(IjpdcafiltroprojId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NRPROJETO", nullable = false, insertable = false, updatable = false)
	public Ijpdcaprojeto getIjpdcaprojeto() {
		return this.ijpdcaprojeto;
	}

	public void setIjpdcaprojeto(Ijpdcaprojeto ijpdcaprojeto) {
		this.ijpdcaprojeto = ijpdcaprojeto;
	}

}

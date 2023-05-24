package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Viewtbprousu generated by hbm2java
 */
@Entity
@Table(name = "VIEWTBPROUSU")
public class Viewtbprousu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6303870061695524935L;
	private ViewtbprousuId id;

	public Viewtbprousu() {
	}

	public Viewtbprousu(ViewtbprousuId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "cdusuario", column = @Column(name = "CDUSUARIO", nullable = false, length = 6)),
			@AttributeOverride(name = "datatini", column = @Column(name = "DATATINI", nullable = false, length = 7)),
			@AttributeOverride(name = "datafim", column = @Column(name = "DATAFIM", nullable = false, length = 7)),
			@AttributeOverride(name = "dataatual", column = @Column(name = "DATAATUAL", length = 8)) })
	public ViewtbprousuId getId() {
		return this.id;
	}

	public void setId(ViewtbprousuId id) {
		this.id = id;
	}

}

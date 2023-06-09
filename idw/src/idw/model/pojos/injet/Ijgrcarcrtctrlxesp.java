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
 * Ijgrcarcrtctrlxesp generated by hbm2java
 */
@Entity
@Table(name = "IJGRCARCRTCTRLXESP")
public class Ijgrcarcrtctrlxesp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5228665537484277756L;
	private IjgrcarcrtctrlxespId id;
	private Ijgrcarcrtctrl ijgrcarcrtctrl;
	private Ijparaminspec ijparaminspec;

	public Ijgrcarcrtctrlxesp() {
	}

	public Ijgrcarcrtctrlxesp(IjgrcarcrtctrlxespId id,
			Ijgrcarcrtctrl ijgrcarcrtctrl, Ijparaminspec ijparaminspec) {
		this.id = id;
		this.ijgrcarcrtctrl = ijgrcarcrtctrl;
		this.ijparaminspec = ijparaminspec;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdgrproctrctrl", column = @Column(name = "CDGRPROCTRCTRL", nullable = false, length = 6)),
			@AttributeOverride(name = "idespecific", column = @Column(name = "IDESPECIFIC", nullable = false, length = 20)) })
	public IjgrcarcrtctrlxespId getId() {
		return this.id;
	}

	public void setId(IjgrcarcrtctrlxespId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDGRPROCTRCTRL", nullable = false, insertable = false, updatable = false)
	public Ijgrcarcrtctrl getIjgrcarcrtctrl() {
		return this.ijgrcarcrtctrl;
	}

	public void setIjgrcarcrtctrl(Ijgrcarcrtctrl ijgrcarcrtctrl) {
		this.ijgrcarcrtctrl = ijgrcarcrtctrl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDESPECIFIC", nullable = false, insertable = false, updatable = false)
	public Ijparaminspec getIjparaminspec() {
		return this.ijparaminspec;
	}

	public void setIjparaminspec(Ijparaminspec ijparaminspec) {
		this.ijparaminspec = ijparaminspec;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgalobjgalmtrzId generated by hbm2java
 */
@Embeddable
public class IjgalobjgalmtrzId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -25074411077588043L;
	private String cdgalpaoobj;
	private String cdgalpao;

	public IjgalobjgalmtrzId() {
	}

	public IjgalobjgalmtrzId(String cdgalpaoobj, String cdgalpao) {
		this.cdgalpaoobj = cdgalpaoobj;
		this.cdgalpao = cdgalpao;
	}

	@Column(name = "CDGALPAOOBJ", nullable = false, length = 6)
	public String getCdgalpaoobj() {
		return this.cdgalpaoobj;
	}

	public void setCdgalpaoobj(String cdgalpaoobj) {
		this.cdgalpaoobj = cdgalpaoobj;
	}

	@Column(name = "CDGALPAO", nullable = false, length = 6)
	public String getCdgalpao() {
		return this.cdgalpao;
	}

	public void setCdgalpao(String cdgalpao) {
		this.cdgalpao = cdgalpao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgalobjgalmtrzId))
			return false;
		IjgalobjgalmtrzId castOther = (IjgalobjgalmtrzId) other;

		return ((this.getCdgalpaoobj() == castOther.getCdgalpaoobj()) || (this
				.getCdgalpaoobj() != null && castOther.getCdgalpaoobj() != null && this
				.getCdgalpaoobj().equals(castOther.getCdgalpaoobj())))
				&& ((this.getCdgalpao() == castOther.getCdgalpao()) || (this
						.getCdgalpao() != null
						&& castOther.getCdgalpao() != null && this
						.getCdgalpao().equals(castOther.getCdgalpao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCdgalpaoobj() == null ? 0 : this.getCdgalpaoobj()
						.hashCode());
		result = 37 * result
				+ (getCdgalpao() == null ? 0 : this.getCdgalpao().hashCode());
		return result;
	}

}

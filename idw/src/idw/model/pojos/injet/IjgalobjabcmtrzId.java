package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjgalobjabcmtrzId generated by hbm2java
 */
@Embeddable
public class IjgalobjabcmtrzId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8407808574717442703L;
	private String cdgalpao;
	private String tpcfg;

	public IjgalobjabcmtrzId() {
	}

	public IjgalobjabcmtrzId(String cdgalpao, String tpcfg) {
		this.cdgalpao = cdgalpao;
		this.tpcfg = tpcfg;
	}

	@Column(name = "CDGALPAO", nullable = false, length = 6)
	public String getCdgalpao() {
		return this.cdgalpao;
	}

	public void setCdgalpao(String cdgalpao) {
		this.cdgalpao = cdgalpao;
	}

	@Column(name = "TPCFG", nullable = false, length = 1)
	public String getTpcfg() {
		return this.tpcfg;
	}

	public void setTpcfg(String tpcfg) {
		this.tpcfg = tpcfg;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjgalobjabcmtrzId))
			return false;
		IjgalobjabcmtrzId castOther = (IjgalobjabcmtrzId) other;

		return ((this.getCdgalpao() == castOther.getCdgalpao()) || (this
				.getCdgalpao() != null && castOther.getCdgalpao() != null && this
				.getCdgalpao().equals(castOther.getCdgalpao())))
				&& ((this.getTpcfg() == castOther.getTpcfg()) || (this
						.getTpcfg() != null && castOther.getTpcfg() != null && this
						.getTpcfg().equals(castOther.getTpcfg())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdgalpao() == null ? 0 : this.getCdgalpao().hashCode());
		result = 37 * result
				+ (getTpcfg() == null ? 0 : this.getTpcfg().hashCode());
		return result;
	}

}

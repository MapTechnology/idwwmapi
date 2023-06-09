package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbpadId generated by hbm2java
 */
@Embeddable
public class IjtbpadId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1235883564026066229L;
	private String campo01;
	private String campo02;

	public IjtbpadId() {
	}

	public IjtbpadId(String campo01, String campo02) {
		this.campo01 = campo01;
		this.campo02 = campo02;
	}

	@Column(name = "CAMPO01", nullable = false, length = 6)
	public String getCampo01() {
		return this.campo01;
	}

	public void setCampo01(String campo01) {
		this.campo01 = campo01;
	}

	@Column(name = "CAMPO02", nullable = false, length = 6)
	public String getCampo02() {
		return this.campo02;
	}

	public void setCampo02(String campo02) {
		this.campo02 = campo02;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbpadId))
			return false;
		IjtbpadId castOther = (IjtbpadId) other;

		return ((this.getCampo01() == castOther.getCampo01()) || (this
				.getCampo01() != null && castOther.getCampo01() != null && this
				.getCampo01().equals(castOther.getCampo01())))
				&& ((this.getCampo02() == castOther.getCampo02()) || (this
						.getCampo02() != null && castOther.getCampo02() != null && this
						.getCampo02().equals(castOther.getCampo02())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCampo01() == null ? 0 : this.getCampo01().hashCode());
		result = 37 * result
				+ (getCampo02() == null ? 0 : this.getCampo02().hashCode());
		return result;
	}

}

package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjtbleaderId generated by hbm2java
 */
@Embeddable
public class IjtbleaderId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4295561462985801814L;
	private String campo1;
	private String campo2;
	private String campo3;

	public IjtbleaderId() {
	}

	public IjtbleaderId(String campo1, String campo2, String campo3) {
		this.campo1 = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
	}

	@Column(name = "CAMPO1", nullable = false, length = 100)
	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	@Column(name = "CAMPO2", nullable = false, length = 8)
	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	@Column(name = "CAMPO3", nullable = false, length = 30)
	public String getCampo3() {
		return this.campo3;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjtbleaderId))
			return false;
		IjtbleaderId castOther = (IjtbleaderId) other;

		return ((this.getCampo1() == castOther.getCampo1()) || (this
				.getCampo1() != null && castOther.getCampo1() != null && this
				.getCampo1().equals(castOther.getCampo1())))
				&& ((this.getCampo2() == castOther.getCampo2()) || (this
						.getCampo2() != null && castOther.getCampo2() != null && this
						.getCampo2().equals(castOther.getCampo2())))
				&& ((this.getCampo3() == castOther.getCampo3()) || (this
						.getCampo3() != null && castOther.getCampo3() != null && this
						.getCampo3().equals(castOther.getCampo3())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCampo1() == null ? 0 : this.getCampo1().hashCode());
		result = 37 * result
				+ (getCampo2() == null ? 0 : this.getCampo2().hashCode());
		result = 37 * result
				+ (getCampo3() == null ? 0 : this.getCampo3().hashCode());
		return result;
	}

}

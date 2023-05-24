package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfictecautorizusuId generated by hbm2java
 */
@Embeddable
public class IjfictecautorizusuId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4127067450178965470L;
	private String nrsolicmodificcic;
	private String cdusuarioaut;

	public IjfictecautorizusuId() {
	}

	public IjfictecautorizusuId(String nrsolicmodificcic, String cdusuarioaut) {
		this.nrsolicmodificcic = nrsolicmodificcic;
		this.cdusuarioaut = cdusuarioaut;
	}

	@Column(name = "NRSOLICMODIFICCIC", nullable = false, length = 12)
	public String getNrsolicmodificcic() {
		return this.nrsolicmodificcic;
	}

	public void setNrsolicmodificcic(String nrsolicmodificcic) {
		this.nrsolicmodificcic = nrsolicmodificcic;
	}

	@Column(name = "CDUSUARIOAUT", nullable = false, length = 6)
	public String getCdusuarioaut() {
		return this.cdusuarioaut;
	}

	public void setCdusuarioaut(String cdusuarioaut) {
		this.cdusuarioaut = cdusuarioaut;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfictecautorizusuId))
			return false;
		IjfictecautorizusuId castOther = (IjfictecautorizusuId) other;

		return ((this.getNrsolicmodificcic() == castOther
				.getNrsolicmodificcic()) || (this.getNrsolicmodificcic() != null
				&& castOther.getNrsolicmodificcic() != null && this
				.getNrsolicmodificcic()
				.equals(castOther.getNrsolicmodificcic())))
				&& ((this.getCdusuarioaut() == castOther.getCdusuarioaut()) || (this
						.getCdusuarioaut() != null
						&& castOther.getCdusuarioaut() != null && this
						.getCdusuarioaut().equals(castOther.getCdusuarioaut())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNrsolicmodificcic() == null ? 0 : this
						.getNrsolicmodificcic().hashCode());
		result = 37
				* result
				+ (getCdusuarioaut() == null ? 0 : this.getCdusuarioaut()
						.hashCode());
		return result;
	}

}
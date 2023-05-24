package injetws.model.pojos;

// default package
// Generated 15/01/2010 14:33:32 by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrUpParadasEmAbertoId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class PrUpParadasEmAbertoId implements java.io.Serializable {

	private String idup;
	private String idopemaberto;

	public PrUpParadasEmAbertoId() {
	}

	public PrUpParadasEmAbertoId(String idup, String idopemaberto) {
		this.idup = idup;
		this.idopemaberto = idopemaberto;
	}

	@Column(name = "IDUP", nullable = false, length = 36)
	public String getIdup() {
		return this.idup;
	}

	public void setIdup(String idup) {
		this.idup = idup;
	}

	@Column(name = "IDOPEMABERTO", nullable = false, length = 36)
	public String getIdopemaberto() {
		return this.idopemaberto;
	}

	public void setIdopemaberto(String idopemaberto) {
		this.idopemaberto = idopemaberto;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrUpParadasEmAbertoId))
			return false;
		PrUpParadasEmAbertoId castOther = (PrUpParadasEmAbertoId) other;

		return ((this.getIdup() == castOther.getIdup()) || (this.getIdup() != null
				&& castOther.getIdup() != null && this.getIdup().equals(
				castOther.getIdup())))
				&& ((this.getIdopemaberto() == castOther.getIdopemaberto()) || (this
						.getIdopemaberto() != null
						&& castOther.getIdopemaberto() != null && this
						.getIdopemaberto().equals(castOther.getIdopemaberto())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdup() == null ? 0 : this.getIdup().hashCode());
		result = 37
				* result
				+ (getIdopemaberto() == null ? 0 : this.getIdopemaberto()
						.hashCode());
		return result;
	}

}
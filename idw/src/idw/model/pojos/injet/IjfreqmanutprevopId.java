package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjfreqmanutprevopId generated by hbm2java
 */
@Embeddable
public class IjfreqmanutprevopId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3889211096364251543L;
	private String nrop;
	private String idrecurso;
	private String tprecurso;
	private String idchklst;

	public IjfreqmanutprevopId() {
	}

	public IjfreqmanutprevopId(String nrop, String idrecurso, String tprecurso,
			String idchklst) {
		this.nrop = nrop;
		this.idrecurso = idrecurso;
		this.tprecurso = tprecurso;
		this.idchklst = idchklst;
	}

	@Column(name = "NROP", nullable = false, length = 10)
	public String getNrop() {
		return this.nrop;
	}

	public void setNrop(String nrop) {
		this.nrop = nrop;
	}

	@Column(name = "IDRECURSO", nullable = false, length = 6)
	public String getIdrecurso() {
		return this.idrecurso;
	}

	public void setIdrecurso(String idrecurso) {
		this.idrecurso = idrecurso;
	}

	@Column(name = "TPRECURSO", nullable = false, length = 2)
	public String getTprecurso() {
		return this.tprecurso;
	}

	public void setTprecurso(String tprecurso) {
		this.tprecurso = tprecurso;
	}

	@Column(name = "IDCHKLST", nullable = false, length = 15)
	public String getIdchklst() {
		return this.idchklst;
	}

	public void setIdchklst(String idchklst) {
		this.idchklst = idchklst;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjfreqmanutprevopId))
			return false;
		IjfreqmanutprevopId castOther = (IjfreqmanutprevopId) other;

		return ((this.getNrop() == castOther.getNrop()) || (this.getNrop() != null
				&& castOther.getNrop() != null && this.getNrop().equals(
				castOther.getNrop())))
				&& ((this.getIdrecurso() == castOther.getIdrecurso()) || (this
						.getIdrecurso() != null
						&& castOther.getIdrecurso() != null && this
						.getIdrecurso().equals(castOther.getIdrecurso())))
				&& ((this.getTprecurso() == castOther.getTprecurso()) || (this
						.getTprecurso() != null
						&& castOther.getTprecurso() != null && this
						.getTprecurso().equals(castOther.getTprecurso())))
				&& ((this.getIdchklst() == castOther.getIdchklst()) || (this
						.getIdchklst() != null
						&& castOther.getIdchklst() != null && this
						.getIdchklst().equals(castOther.getIdchklst())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrop() == null ? 0 : this.getNrop().hashCode());
		result = 37 * result
				+ (getIdrecurso() == null ? 0 : this.getIdrecurso().hashCode());
		result = 37 * result
				+ (getTprecurso() == null ? 0 : this.getTprecurso().hashCode());
		result = 37 * result
				+ (getIdchklst() == null ? 0 : this.getIdchklst().hashCode());
		return result;
	}

}

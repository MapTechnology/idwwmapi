package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Exportacao024Id generated by hbm2java
 */
@Embeddable
public class Exportacao024Id implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3586508785952192192L;
	private String idregistro;
	private String idempresa;

	public Exportacao024Id() {
	}

	public Exportacao024Id(String idregistro, String idempresa) {
		this.idregistro = idregistro;
		this.idempresa = idempresa;
	}

	@Column(name = "IDREGISTRO", nullable = false, length = 14)
	public String getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(String idregistro) {
		this.idregistro = idregistro;
	}

	@Column(name = "IDEMPRESA", nullable = false, length = 2)
	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Exportacao024Id))
			return false;
		Exportacao024Id castOther = (Exportacao024Id) other;

		return ((this.getIdregistro() == castOther.getIdregistro()) || (this
				.getIdregistro() != null && castOther.getIdregistro() != null && this
				.getIdregistro().equals(castOther.getIdregistro())))
				&& ((this.getIdempresa() == castOther.getIdempresa()) || (this
						.getIdempresa() != null
						&& castOther.getIdempresa() != null && this
						.getIdempresa().equals(castOther.getIdempresa())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdregistro() == null ? 0 : this.getIdregistro()
						.hashCode());
		result = 37 * result
				+ (getIdempresa() == null ? 0 : this.getIdempresa().hashCode());
		return result;
	}

}

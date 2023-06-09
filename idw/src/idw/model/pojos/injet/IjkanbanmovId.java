package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjkanbanmovId generated by hbm2java
 */
@Embeddable
public class IjkanbanmovId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1824533628882333868L;
	private String idcartaokanban;
	private Date dthrmovimentacao;

	public IjkanbanmovId() {
	}

	public IjkanbanmovId(String idcartaokanban, Date dthrmovimentacao) {
		this.idcartaokanban = idcartaokanban;
		this.dthrmovimentacao = dthrmovimentacao;
	}

	@Column(name = "IDCARTAOKANBAN", nullable = false, length = 50)
	public String getIdcartaokanban() {
		return this.idcartaokanban;
	}

	public void setIdcartaokanban(String idcartaokanban) {
		this.idcartaokanban = idcartaokanban;
	}

	@Column(name = "DTHRMOVIMENTACAO", nullable = false, length = 7)
	public Date getDthrmovimentacao() {
		return this.dthrmovimentacao;
	}

	public void setDthrmovimentacao(Date dthrmovimentacao) {
		this.dthrmovimentacao = dthrmovimentacao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjkanbanmovId))
			return false;
		IjkanbanmovId castOther = (IjkanbanmovId) other;

		return ((this.getIdcartaokanban() == castOther.getIdcartaokanban()) || (this
				.getIdcartaokanban() != null
				&& castOther.getIdcartaokanban() != null && this
				.getIdcartaokanban().equals(castOther.getIdcartaokanban())))
				&& ((this.getDthrmovimentacao() == castOther
						.getDthrmovimentacao()) || (this.getDthrmovimentacao() != null
						&& castOther.getDthrmovimentacao() != null && this
						.getDthrmovimentacao().equals(
								castOther.getDthrmovimentacao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdcartaokanban() == null ? 0 : this.getIdcartaokanban()
						.hashCode());
		result = 37
				* result
				+ (getDthrmovimentacao() == null ? 0 : this
						.getDthrmovimentacao().hashCode());
		return result;
	}

}

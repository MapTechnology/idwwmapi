package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjpdcafiltroprojId generated by hbm2java
 */
@Embeddable
public class IjpdcafiltroprojId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181963896323934022L;
	private String nrprojeto;
	private String idfiltro;
	private String conteudofiltro;

	public IjpdcafiltroprojId() {
	}

	public IjpdcafiltroprojId(String nrprojeto, String idfiltro,
			String conteudofiltro) {
		this.nrprojeto = nrprojeto;
		this.idfiltro = idfiltro;
		this.conteudofiltro = conteudofiltro;
	}

	@Column(name = "NRPROJETO", nullable = false, length = 10)
	public String getNrprojeto() {
		return this.nrprojeto;
	}

	public void setNrprojeto(String nrprojeto) {
		this.nrprojeto = nrprojeto;
	}

	@Column(name = "IDFILTRO", nullable = false, length = 20)
	public String getIdfiltro() {
		return this.idfiltro;
	}

	public void setIdfiltro(String idfiltro) {
		this.idfiltro = idfiltro;
	}

	@Column(name = "CONTEUDOFILTRO", nullable = false, length = 40)
	public String getConteudofiltro() {
		return this.conteudofiltro;
	}

	public void setConteudofiltro(String conteudofiltro) {
		this.conteudofiltro = conteudofiltro;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjpdcafiltroprojId))
			return false;
		IjpdcafiltroprojId castOther = (IjpdcafiltroprojId) other;

		return ((this.getNrprojeto() == castOther.getNrprojeto()) || (this
				.getNrprojeto() != null && castOther.getNrprojeto() != null && this
				.getNrprojeto().equals(castOther.getNrprojeto())))
				&& ((this.getIdfiltro() == castOther.getIdfiltro()) || (this
						.getIdfiltro() != null
						&& castOther.getIdfiltro() != null && this
						.getIdfiltro().equals(castOther.getIdfiltro())))
				&& ((this.getConteudofiltro() == castOther.getConteudofiltro()) || (this
						.getConteudofiltro() != null
						&& castOther.getConteudofiltro() != null && this
						.getConteudofiltro().equals(
								castOther.getConteudofiltro())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNrprojeto() == null ? 0 : this.getNrprojeto().hashCode());
		result = 37 * result
				+ (getIdfiltro() == null ? 0 : this.getIdfiltro().hashCode());
		result = 37
				* result
				+ (getConteudofiltro() == null ? 0 : this.getConteudofiltro()
						.hashCode());
		return result;
	}

}

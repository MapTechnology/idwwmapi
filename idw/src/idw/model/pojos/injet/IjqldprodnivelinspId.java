package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjqldprodnivelinspId generated by hbm2java
 */
@Embeddable
public class IjqldprodnivelinspId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4967389626338212382L;
	private String cdproduto;
	private double tamminlote;
	private double tammaxlote;
	private double tamamostra;
	private double nivelnormalact;
	private double nivelseveraact;
	private char nivelinspaaplicar;

	public IjqldprodnivelinspId() {
	}

	public IjqldprodnivelinspId(String cdproduto, double tamminlote,
			double tammaxlote, double tamamostra, double nivelnormalact,
			double nivelseveraact, char nivelinspaaplicar) {
		this.cdproduto = cdproduto;
		this.tamminlote = tamminlote;
		this.tammaxlote = tammaxlote;
		this.tamamostra = tamamostra;
		this.nivelnormalact = nivelnormalact;
		this.nivelseveraact = nivelseveraact;
		this.nivelinspaaplicar = nivelinspaaplicar;
	}

	@Column(name = "CDPRODUTO", nullable = false, length = 20)
	public String getCdproduto() {
		return this.cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	@Column(name = "TAMMINLOTE", nullable = false, precision = 126, scale = 0)
	public double getTamminlote() {
		return this.tamminlote;
	}

	public void setTamminlote(double tamminlote) {
		this.tamminlote = tamminlote;
	}

	@Column(name = "TAMMAXLOTE", nullable = false, precision = 126, scale = 0)
	public double getTammaxlote() {
		return this.tammaxlote;
	}

	public void setTammaxlote(double tammaxlote) {
		this.tammaxlote = tammaxlote;
	}

	@Column(name = "TAMAMOSTRA", nullable = false, precision = 126, scale = 0)
	public double getTamamostra() {
		return this.tamamostra;
	}

	public void setTamamostra(double tamamostra) {
		this.tamamostra = tamamostra;
	}

	@Column(name = "NIVELNORMALACT", nullable = false, precision = 126, scale = 0)
	public double getNivelnormalact() {
		return this.nivelnormalact;
	}

	public void setNivelnormalact(double nivelnormalact) {
		this.nivelnormalact = nivelnormalact;
	}

	@Column(name = "NIVELSEVERAACT", nullable = false, precision = 126, scale = 0)
	public double getNivelseveraact() {
		return this.nivelseveraact;
	}

	public void setNivelseveraact(double nivelseveraact) {
		this.nivelseveraact = nivelseveraact;
	}

	@Column(name = "NIVELINSPAAPLICAR", nullable = false, length = 1)
	public char getNivelinspaaplicar() {
		return this.nivelinspaaplicar;
	}

	public void setNivelinspaaplicar(char nivelinspaaplicar) {
		this.nivelinspaaplicar = nivelinspaaplicar;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjqldprodnivelinspId))
			return false;
		IjqldprodnivelinspId castOther = (IjqldprodnivelinspId) other;

		return ((this.getCdproduto() == castOther.getCdproduto()) || (this
				.getCdproduto() != null && castOther.getCdproduto() != null && this
				.getCdproduto().equals(castOther.getCdproduto())))
				&& (this.getTamminlote() == castOther.getTamminlote())
				&& (this.getTammaxlote() == castOther.getTammaxlote())
				&& (this.getTamamostra() == castOther.getTamamostra())
				&& (this.getNivelnormalact() == castOther.getNivelnormalact())
				&& (this.getNivelseveraact() == castOther.getNivelseveraact())
				&& (this.getNivelinspaaplicar() == castOther
						.getNivelinspaaplicar());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCdproduto() == null ? 0 : this.getCdproduto().hashCode());
		result = 37 * result + (int) this.getTamminlote();
		result = 37 * result + (int) this.getTammaxlote();
		result = 37 * result + (int) this.getTamamostra();
		result = 37 * result + (int) this.getNivelnormalact();
		result = 37 * result + (int) this.getNivelseveraact();
		result = 37 * result + this.getNivelinspaaplicar();
		return result;
	}

}

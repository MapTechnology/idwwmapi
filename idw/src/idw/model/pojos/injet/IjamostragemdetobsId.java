package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjamostragemdetobsId generated by hbm2java
 */
@Embeddable
public class IjamostragemdetobsId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420619342049297405L;
	private String idamostragem;
	private BigDecimal amostra;
	private Date dthralteracao;

	public IjamostragemdetobsId() {
	}

	public IjamostragemdetobsId(String idamostragem, BigDecimal amostra,
			Date dthralteracao) {
		this.idamostragem = idamostragem;
		this.amostra = amostra;
		this.dthralteracao = dthralteracao;
	}

	@Column(name = "IDAMOSTRAGEM", nullable = false, length = 12)
	public String getIdamostragem() {
		return this.idamostragem;
	}

	public void setIdamostragem(String idamostragem) {
		this.idamostragem = idamostragem;
	}

	@Column(name = "AMOSTRA", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAmostra() {
		return this.amostra;
	}

	public void setAmostra(BigDecimal amostra) {
		this.amostra = amostra;
	}

	@Column(name = "DTHRALTERACAO", nullable = false, length = 7)
	public Date getDthralteracao() {
		return this.dthralteracao;
	}

	public void setDthralteracao(Date dthralteracao) {
		this.dthralteracao = dthralteracao;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjamostragemdetobsId))
			return false;
		IjamostragemdetobsId castOther = (IjamostragemdetobsId) other;

		return ((this.getIdamostragem() == castOther.getIdamostragem()) || (this
				.getIdamostragem() != null
				&& castOther.getIdamostragem() != null && this
				.getIdamostragem().equals(castOther.getIdamostragem())))
				&& ((this.getAmostra() == castOther.getAmostra()) || (this
						.getAmostra() != null && castOther.getAmostra() != null && this
						.getAmostra().equals(castOther.getAmostra())))
				&& ((this.getDthralteracao() == castOther.getDthralteracao()) || (this
						.getDthralteracao() != null
						&& castOther.getDthralteracao() != null && this
						.getDthralteracao()
						.equals(castOther.getDthralteracao())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdamostragem() == null ? 0 : this.getIdamostragem()
						.hashCode());
		result = 37 * result
				+ (getAmostra() == null ? 0 : this.getAmostra().hashCode());
		result = 37
				* result
				+ (getDthralteracao() == null ? 0 : this.getDthralteracao()
						.hashCode());
		return result;
	}

}

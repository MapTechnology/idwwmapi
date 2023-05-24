package injetws.model.pojos;

// Generated 21/08/2012 17:15:13 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrUpAndonIndicadoresId generated by hbm2java
 */
@Embeddable
public class PrUpAndonIndicadoresId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784305039739646696L;
	private BigDecimal idindicador;
	private String idup;
	private BigDecimal periodo;

	public PrUpAndonIndicadoresId() {
	}

	public PrUpAndonIndicadoresId(BigDecimal idindicador, String idup,
			BigDecimal periodo) {
		this.idindicador = idindicador;
		this.idup = idup;
		this.periodo = periodo;
	}

	@Column(name = "IDINDICADOR", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdindicador() {
		return this.idindicador;
	}

	public void setIdindicador(BigDecimal idindicador) {
		this.idindicador = idindicador;
	}

	@Column(name = "IDUP", nullable = false, length = 36)
	public String getIdup() {
		return this.idup;
	}

	public void setIdup(String idup) {
		this.idup = idup;
	}

	@Column(name = "PERIODO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(BigDecimal periodo) {
		this.periodo = periodo;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrUpAndonIndicadoresId))
			return false;
		PrUpAndonIndicadoresId castOther = (PrUpAndonIndicadoresId) other;

		return ((this.getIdindicador() == castOther.getIdindicador()) || (this
				.getIdindicador() != null && castOther.getIdindicador() != null && this
				.getIdindicador().equals(castOther.getIdindicador())))
				&& ((this.getIdup() == castOther.getIdup()) || (this.getIdup() != null
						&& castOther.getIdup() != null && this.getIdup()
						.equals(castOther.getIdup())))
				&& ((this.getPeriodo() == castOther.getPeriodo()) || (this
						.getPeriodo() != null && castOther.getPeriodo() != null && this
						.getPeriodo().equals(castOther.getPeriodo())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdindicador() == null ? 0 : this.getIdindicador()
						.hashCode());
		result = 37 * result
				+ (getIdup() == null ? 0 : this.getIdup().hashCode());
		result = 37 * result
				+ (getPeriodo() == null ? 0 : this.getPeriodo().hashCode());
		return result;
	}

}
package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IjlogdiariobordoId generated by hbm2java
 */
@Embeddable
public class IjlogdiariobordoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6088944654552603379L;
	private Date dthrevento;
	private String cdinjetora;
	private char tipoevento;
	private Date dthrapontamento;
	private String cdusuario;
	private char tipoapontamento;

	public IjlogdiariobordoId() {
	}

	public IjlogdiariobordoId(Date dthrevento, String cdinjetora,
			char tipoevento, Date dthrapontamento, String cdusuario,
			char tipoapontamento) {
		this.dthrevento = dthrevento;
		this.cdinjetora = cdinjetora;
		this.tipoevento = tipoevento;
		this.dthrapontamento = dthrapontamento;
		this.cdusuario = cdusuario;
		this.tipoapontamento = tipoapontamento;
	}

	@Column(name = "DTHREVENTO", nullable = false, length = 7)
	public Date getDthrevento() {
		return this.dthrevento;
	}

	public void setDthrevento(Date dthrevento) {
		this.dthrevento = dthrevento;
	}

	@Column(name = "CDINJETORA", nullable = false, length = 6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name = "TIPOEVENTO", nullable = false, length = 1)
	public char getTipoevento() {
		return this.tipoevento;
	}

	public void setTipoevento(char tipoevento) {
		this.tipoevento = tipoevento;
	}

	@Column(name = "DTHRAPONTAMENTO", nullable = false, length = 7)
	public Date getDthrapontamento() {
		return this.dthrapontamento;
	}

	public void setDthrapontamento(Date dthrapontamento) {
		this.dthrapontamento = dthrapontamento;
	}

	@Column(name = "CDUSUARIO", nullable = false, length = 6)
	public String getCdusuario() {
		return this.cdusuario;
	}

	public void setCdusuario(String cdusuario) {
		this.cdusuario = cdusuario;
	}

	@Column(name = "TIPOAPONTAMENTO", nullable = false, length = 1)
	public char getTipoapontamento() {
		return this.tipoapontamento;
	}

	public void setTipoapontamento(char tipoapontamento) {
		this.tipoapontamento = tipoapontamento;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IjlogdiariobordoId))
			return false;
		IjlogdiariobordoId castOther = (IjlogdiariobordoId) other;

		return ((this.getDthrevento() == castOther.getDthrevento()) || (this
				.getDthrevento() != null && castOther.getDthrevento() != null && this
				.getDthrevento().equals(castOther.getDthrevento())))
				&& ((this.getCdinjetora() == castOther.getCdinjetora()) || (this
						.getCdinjetora() != null
						&& castOther.getCdinjetora() != null && this
						.getCdinjetora().equals(castOther.getCdinjetora())))
				&& (this.getTipoevento() == castOther.getTipoevento())
				&& ((this.getDthrapontamento() == castOther
						.getDthrapontamento()) || (this.getDthrapontamento() != null
						&& castOther.getDthrapontamento() != null && this
						.getDthrapontamento().equals(
								castOther.getDthrapontamento())))
				&& ((this.getCdusuario() == castOther.getCdusuario()) || (this
						.getCdusuario() != null
						&& castOther.getCdusuario() != null && this
						.getCdusuario().equals(castOther.getCdusuario())))
				&& (this.getTipoapontamento() == castOther.getTipoapontamento());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDthrevento() == null ? 0 : this.getDthrevento()
						.hashCode());
		result = 37
				* result
				+ (getCdinjetora() == null ? 0 : this.getCdinjetora()
						.hashCode());
		result = 37 * result + this.getTipoevento();
		result = 37
				* result
				+ (getDthrapontamento() == null ? 0 : this.getDthrapontamento()
						.hashCode());
		result = 37 * result
				+ (getCdusuario() == null ? 0 : this.getCdusuario().hashCode());
		result = 37 * result + this.getTipoapontamento();
		return result;
	}

}

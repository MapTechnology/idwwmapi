package idw.model.pojos;
// Generated 15/05/2018 16:00:51 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.SpCausadsTemplate;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SpCausads generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SP_CAUSADS")
public class SpCausads extends SpCausadsTemplate implements java.io.Serializable {

	private BigDecimal idCausads;
	private SpLingua spLingua;
	private SpCausa spCausa;
	private String dsCausa;

	public SpCausads() {
	}

	public SpCausads(BigDecimal idCausads, SpLingua spLingua, SpCausa spCausa) {
		this.idCausads = idCausads;
		this.spLingua = spLingua;
		this.spCausa = spCausa;
	}

	public SpCausads(BigDecimal idCausads, SpLingua spLingua, SpCausa spCausa,
			String dsCausa) {
		this.idCausads = idCausads;
		this.spLingua = spLingua;
		this.spCausa = spCausa;
		this.dsCausa = dsCausa;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAUSADS", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdCausads() {
		return this.idCausads;
	}

	public void setIdCausads(BigDecimal idCausads) {
		this.idCausads = idCausads;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LINGUA", nullable = false)
	public SpLingua getSpLingua() {
		return this.spLingua;
	}

	public void setSpLingua(SpLingua spLingua) {
		this.spLingua = spLingua;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CAUSA", nullable = false)
	public SpCausa getSpCausa() {
		return this.spCausa;
	}

	public void setSpCausa(SpCausa spCausa) {
		this.spCausa = spCausa;
	}

	@Column(name = "DS_CAUSA", length = 60)
	public String getDsCausa() {
		return this.dsCausa;
	}

	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
	}

}

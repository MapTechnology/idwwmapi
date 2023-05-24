package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijtbprolog generated by hbm2java
 */
@Entity
@Table(name = "IJTBPROLOG")
public class Ijtbprolog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2377293907560908259L;
	private IjtbprologId id;

	public Ijtbprolog() {
	}

	public Ijtbprolog(IjtbprologId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdproduto", column = @Column(name = "CDPRODUTO", nullable = false, length = 20)),
			@AttributeOverride(name = "dsproduto", column = @Column(name = "DSPRODUTO", length = 40)),
			@AttributeOverride(name = "unproduto", column = @Column(name = "UNPRODUTO", length = 10)),
			@AttributeOverride(name = "cor", column = @Column(name = "COR", length = 20)),
			@AttributeOverride(name = "tpproduto", column = @Column(name = "TPPRODUTO", precision = 22, scale = 0)),
			@AttributeOverride(name = "vlproduto", column = @Column(name = "VLPRODUTO", precision = 126, scale = 0)),
			@AttributeOverride(name = "pliquidomedio", column = @Column(name = "PLIQUIDOMEDIO", precision = 126, scale = 0)),
			@AttributeOverride(name = "pbrutomedio", column = @Column(name = "PBRUTOMEDIO", precision = 126, scale = 0)),
			@AttributeOverride(name = "temperaturaminestu", column = @Column(name = "TEMPERATURAMINESTU", precision = 126, scale = 0)),
			@AttributeOverride(name = "temperaturamaxestu", column = @Column(name = "TEMPERATURAMAXESTU", precision = 126, scale = 0)),
			@AttributeOverride(name = "tempominestufagem", column = @Column(name = "TEMPOMINESTUFAGEM", precision = 126, scale = 0)),
			@AttributeOverride(name = "tempomaxestufagem", column = @Column(name = "TEMPOMAXESTUFAGEM", precision = 126, scale = 0)),
			@AttributeOverride(name = "fatorconversao", column = @Column(name = "FATORCONVERSAO", precision = 126, scale = 0)),
			@AttributeOverride(name = "idproduto", column = @Column(name = "IDPRODUTO", length = 6)),
			@AttributeOverride(name = "espessura", column = @Column(name = "ESPESSURA", length = 5)),
			@AttributeOverride(name = "acabamento", column = @Column(name = "ACABAMENTO", length = 25)),
			@AttributeOverride(name = "tpinspqld", column = @Column(name = "TPINSPQLD", length = 1)),
			@AttributeOverride(name = "tmpliminspqld", column = @Column(name = "TMPLIMINSPQLD", precision = 22, scale = 0)),
			@AttributeOverride(name = "tmptrocaprdt", column = @Column(name = "TMPTROCAPRDT", precision = 22, scale = 0)),
			@AttributeOverride(name = "tmptrocapstc", column = @Column(name = "TMPTROCAPSTC", precision = 22, scale = 0)),
			@AttributeOverride(name = "tamlotekanban", column = @Column(name = "TAMLOTEKANBAN", precision = 22, scale = 0)),
			@AttributeOverride(name = "classificacao", column = @Column(name = "CLASSIFICACAO", length = 1)),
			@AttributeOverride(name = "unidmedsap", column = @Column(name = "UNIDMEDSAP", length = 3)),
			@AttributeOverride(name = "perclotekanban", column = @Column(name = "PERCLOTEKANBAN", precision = 126, scale = 0)),
			@AttributeOverride(name = "tampulmaopadrao", column = @Column(name = "TAMPULMAOPADRAO", precision = 126, scale = 0)),
			@AttributeOverride(name = "tampulmaomax", column = @Column(name = "TAMPULMAOMAX", precision = 126, scale = 0)),
			@AttributeOverride(name = "tampulmaomin", column = @Column(name = "TAMPULMAOMIN", precision = 126, scale = 0)),
			@AttributeOverride(name = "dthrmanut", column = @Column(name = "DTHRMANUT", nullable = false, length = 7)),
			@AttributeOverride(name = "tpmanut", column = @Column(name = "TPMANUT", nullable = false, length = 1)),
			@AttributeOverride(name = "cdusuresp", column = @Column(name = "CDUSURESP", length = 6)) })
	public IjtbprologId getId() {
		return this.id;
	}

	public void setId(IjtbprologId id) {
		this.id = id;
	}

}

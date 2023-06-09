package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijcncturno generated by hbm2java
 */
@Entity
@Table(name = "IJCNCTURNO")
public class Ijcncturno implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3425517763455663647L;
	private IjcncturnoId id;
	private Ijestmol ijestmol;
	private Ijtbtur ijtbtur;
	private Ijop ijop;
	private Ijtbinj ijtbinj;
	private Ijtbitemcnc ijtbitemcnc;
	private Double qtdleituras;
	private Double vlacumulado;

	public Ijcncturno() {
	}

	public Ijcncturno(IjcncturnoId id, Ijestmol ijestmol, Ijtbtur ijtbtur,
			Ijop ijop, Ijtbinj ijtbinj, Ijtbitemcnc ijtbitemcnc) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbtur = ijtbtur;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbitemcnc = ijtbitemcnc;
	}

	public Ijcncturno(IjcncturnoId id, Ijestmol ijestmol, Ijtbtur ijtbtur,
			Ijop ijop, Ijtbinj ijtbinj, Ijtbitemcnc ijtbitemcnc,
			Double qtdleituras, Double vlacumulado) {
		this.id = id;
		this.ijestmol = ijestmol;
		this.ijtbtur = ijtbtur;
		this.ijop = ijop;
		this.ijtbinj = ijtbinj;
		this.ijtbitemcnc = ijtbitemcnc;
		this.qtdleituras = qtdleituras;
		this.vlacumulado = vlacumulado;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dtrefturno", column = @Column(name = "DTREFTURNO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdturno", column = @Column(name = "CDTURNO", nullable = false, length = 6)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "cditemcnc", column = @Column(name = "CDITEMCNC", nullable = false, length = 6)) })
	public IjcncturnoId getId() {
		return this.id;
	}

	public void setId(IjcncturnoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CDMOLDE", referencedColumnName = "CDMOLDE", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CDESTRUTURA", referencedColumnName = "CDESTRUTURA", nullable = false, insertable = false, updatable = false) })
	public Ijestmol getIjestmol() {
		return this.ijestmol;
	}

	public void setIjestmol(Ijestmol ijestmol) {
		this.ijestmol = ijestmol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDTURNO", nullable = false, insertable = false, updatable = false)
	public Ijtbtur getIjtbtur() {
		return this.ijtbtur;
	}

	public void setIjtbtur(Ijtbtur ijtbtur) {
		this.ijtbtur = ijtbtur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NROP", nullable = false, insertable = false, updatable = false)
	public Ijop getIjop() {
		return this.ijop;
	}

	public void setIjop(Ijop ijop) {
		this.ijop = ijop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDINJETORA", nullable = false, insertable = false, updatable = false)
	public Ijtbinj getIjtbinj() {
		return this.ijtbinj;
	}

	public void setIjtbinj(Ijtbinj ijtbinj) {
		this.ijtbinj = ijtbinj;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDITEMCNC", nullable = false, insertable = false, updatable = false)
	public Ijtbitemcnc getIjtbitemcnc() {
		return this.ijtbitemcnc;
	}

	public void setIjtbitemcnc(Ijtbitemcnc ijtbitemcnc) {
		this.ijtbitemcnc = ijtbitemcnc;
	}

	@Column(name = "QTDLEITURAS", precision = 126, scale = 0)
	public Double getQtdleituras() {
		return this.qtdleituras;
	}

	public void setQtdleituras(Double qtdleituras) {
		this.qtdleituras = qtdleituras;
	}

	@Column(name = "VLACUMULADO", precision = 126, scale = 0)
	public Double getVlacumulado() {
		return this.vlacumulado;
	}

	public void setVlacumulado(Double vlacumulado) {
		this.vlacumulado = vlacumulado;
	}

}

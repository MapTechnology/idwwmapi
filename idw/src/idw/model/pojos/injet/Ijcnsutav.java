package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ijcnsutav generated by hbm2java
 */
@Entity
@Table(name = "IJCNSUTAV")
public class Ijcnsutav implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1888270266531976100L;
	private IjcnsutavId id;
	private Double qtinjnormal;
	private Double tmpcicnormal;
	private Double tmpparadas;
	private Double tmpparadassempeso;
	private Double tmpparadaprep;
	private Double qtparadaprep;
	private Double tmpparprev;
	private Double tmpparnaoprev;
	private Double tmppcta;
	private Double tmppao;
	private Double tmppa;
	private Double tmpptp;

	public Ijcnsutav() {
	}

	public Ijcnsutav(IjcnsutavId id) {
		this.id = id;
	}

	public Ijcnsutav(IjcnsutavId id, Double qtinjnormal, Double tmpcicnormal,
			Double tmpparadas, Double tmpparadassempeso, Double tmpparadaprep,
			Double qtparadaprep, Double tmpparprev, Double tmpparnaoprev,
			Double tmppcta, Double tmppao, Double tmppa, Double tmpptp) {
		this.id = id;
		this.qtinjnormal = qtinjnormal;
		this.tmpcicnormal = tmpcicnormal;
		this.tmpparadas = tmpparadas;
		this.tmpparadassempeso = tmpparadassempeso;
		this.tmpparadaprep = tmpparadaprep;
		this.qtparadaprep = qtparadaprep;
		this.tmpparprev = tmpparprev;
		this.tmpparnaoprev = tmpparnaoprev;
		this.tmppcta = tmppcta;
		this.tmppao = tmppao;
		this.tmppa = tmppa;
		this.tmpptp = tmpptp;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "dthriniintervalo", column = @Column(name = "DTHRINIINTERVALO", nullable = false, length = 7)),
			@AttributeOverride(name = "cdinjetora", column = @Column(name = "CDINJETORA", nullable = false, length = 6)),
			@AttributeOverride(name = "nrop", column = @Column(name = "NROP", nullable = false, length = 10)),
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)),
			@AttributeOverride(name = "dthrivalestru", column = @Column(name = "DTHRIVALESTRU", nullable = false, length = 7)),
			@AttributeOverride(name = "dthrivalcic", column = @Column(name = "DTHRIVALCIC", nullable = false, length = 7)) })
	public IjcnsutavId getId() {
		return this.id;
	}

	public void setId(IjcnsutavId id) {
		this.id = id;
	}

	@Column(name = "QTINJNORMAL", precision = 126, scale = 0)
	public Double getQtinjnormal() {
		return this.qtinjnormal;
	}

	public void setQtinjnormal(Double qtinjnormal) {
		this.qtinjnormal = qtinjnormal;
	}

	@Column(name = "TMPCICNORMAL", precision = 126, scale = 0)
	public Double getTmpcicnormal() {
		return this.tmpcicnormal;
	}

	public void setTmpcicnormal(Double tmpcicnormal) {
		this.tmpcicnormal = tmpcicnormal;
	}

	@Column(name = "TMPPARADAS", precision = 126, scale = 0)
	public Double getTmpparadas() {
		return this.tmpparadas;
	}

	public void setTmpparadas(Double tmpparadas) {
		this.tmpparadas = tmpparadas;
	}

	@Column(name = "TMPPARADASSEMPESO", precision = 126, scale = 0)
	public Double getTmpparadassempeso() {
		return this.tmpparadassempeso;
	}

	public void setTmpparadassempeso(Double tmpparadassempeso) {
		this.tmpparadassempeso = tmpparadassempeso;
	}

	@Column(name = "TMPPARADAPREP", precision = 126, scale = 0)
	public Double getTmpparadaprep() {
		return this.tmpparadaprep;
	}

	public void setTmpparadaprep(Double tmpparadaprep) {
		this.tmpparadaprep = tmpparadaprep;
	}

	@Column(name = "QTPARADAPREP", precision = 126, scale = 0)
	public Double getQtparadaprep() {
		return this.qtparadaprep;
	}

	public void setQtparadaprep(Double qtparadaprep) {
		this.qtparadaprep = qtparadaprep;
	}

	@Column(name = "TMPPARPREV", precision = 126, scale = 0)
	public Double getTmpparprev() {
		return this.tmpparprev;
	}

	public void setTmpparprev(Double tmpparprev) {
		this.tmpparprev = tmpparprev;
	}

	@Column(name = "TMPPARNAOPREV", precision = 126, scale = 0)
	public Double getTmpparnaoprev() {
		return this.tmpparnaoprev;
	}

	public void setTmpparnaoprev(Double tmpparnaoprev) {
		this.tmpparnaoprev = tmpparnaoprev;
	}

	@Column(name = "TMPPCTA", precision = 126, scale = 0)
	public Double getTmppcta() {
		return this.tmppcta;
	}

	public void setTmppcta(Double tmppcta) {
		this.tmppcta = tmppcta;
	}

	@Column(name = "TMPPAO", precision = 126, scale = 0)
	public Double getTmppao() {
		return this.tmppao;
	}

	public void setTmppao(Double tmppao) {
		this.tmppao = tmppao;
	}

	@Column(name = "TMPPA", precision = 126, scale = 0)
	public Double getTmppa() {
		return this.tmppa;
	}

	public void setTmppa(Double tmppa) {
		this.tmppa = tmppa;
	}

	@Column(name = "TMPPTP", precision = 126, scale = 0)
	public Double getTmpptp() {
		return this.tmpptp;
	}

	public void setTmpptp(Double tmpptp) {
		this.tmpptp = tmpptp;
	}

}

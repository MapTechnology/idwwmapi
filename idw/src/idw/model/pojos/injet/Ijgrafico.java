package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijgrafico generated by hbm2java
 */
@Entity
@Table(name = "IJGRAFICO")
public class Ijgrafico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3420336954537015630L;
	private IjgraficoId id;
	private Ijlinguas ijlinguas;
	private String titulo;
	private Set<Ijdetgrafico> ijdetgraficos = new HashSet<Ijdetgrafico>(0);

	public Ijgrafico() {
	}

	public Ijgrafico(IjgraficoId id, Ijlinguas ijlinguas) {
		this.id = id;
		this.ijlinguas = ijlinguas;
	}

	public Ijgrafico(IjgraficoId id, Ijlinguas ijlinguas, String titulo,
			Set<Ijdetgrafico> ijdetgraficos) {
		this.id = id;
		this.ijlinguas = ijlinguas;
		this.titulo = titulo;
		this.ijdetgraficos = ijdetgraficos;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "grafico", column = @Column(name = "GRAFICO", nullable = false, length = 50)),
			@AttributeOverride(name = "cdlingua", column = @Column(name = "CDLINGUA", nullable = false, length = 6)) })
	public IjgraficoId getId() {
		return this.id;
	}

	public void setId(IjgraficoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDLINGUA", nullable = false, insertable = false, updatable = false)
	public Ijlinguas getIjlinguas() {
		return this.ijlinguas;
	}

	public void setIjlinguas(Ijlinguas ijlinguas) {
		this.ijlinguas = ijlinguas;
	}

	@Column(name = "TITULO", length = 50)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijgrafico")
	public Set<Ijdetgrafico> getIjdetgraficos() {
		return this.ijdetgraficos;
	}

	public void setIjdetgraficos(Set<Ijdetgrafico> ijdetgraficos) {
		this.ijdetgraficos = ijdetgraficos;
	}

}

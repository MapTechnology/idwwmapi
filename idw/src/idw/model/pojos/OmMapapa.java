package idw.model.pojos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Generated 05/01/2010 11:04:20 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmMapapaTemplate;


/**
 * OmMapapa generated by hbm2java
 */
@Entity
@Table(name = "om_mapapa")
public class OmMapapa extends OmMapapaTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idMapapa;
	private OmPa omPa;
	private OmProduto omProduto;
	private OmMapa omMapa;
	private Boolean isCiclounico;
	private BigDecimal qtUsada;
	private Set<OmAlimrea> omAlimreas = new HashSet<OmAlimrea>(0);
	private Set<OmPapro> omPapros = new HashSet<OmPapro>(0);
	private Set<OmMapapaproalt> omMapapaproalts = new HashSet<OmMapapaproalt>();

	public OmMapapa() {
	}

	public OmMapapa(long idMapapa, OmPa omPa, OmProduto omProduto, OmMapa omMapa, BigDecimal qtUsada) {
		this.idMapapa = idMapapa;
		this.omPa = omPa;
		this.omProduto = omProduto;
		this.omMapa = omMapa;
		this.qtUsada = qtUsada;
	}

	public OmMapapa(long idMapapa, OmPa omPa, OmProduto omProduto,
			BigDecimal qtUsada, OmMapa omMapa, Set<OmAlimrea> omAlimreas) {
		this.idMapapa = idMapapa;
		this.omPa = omPa;
		this.omProduto = omProduto;
		this.omMapa = omMapa;
		this.qtUsada = qtUsada;
		this.omAlimreas = omAlimreas;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_MAPAPA_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_MAPAPA_SEQ", sequenceName = "OM_MAPAPA_SEQ")
	@Column(name = "id_mapapa", unique = true, nullable = false)
	public long getIdMapapa() {
		return this.idMapapa;
	}

	public void setIdMapapa(long idMapapa) {
		this.idMapapa = idMapapa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pa", nullable = false)
	public OmPa getOmPa() {
		return this.omPa;
	}

	public void setOmPa(OmPa omPa) {
		this.omPa = omPa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mapa", nullable = false)
	public OmMapa getOmMapa() {
		return this.omMapa;
	}

	public void setOmMapa(OmMapa omMapa) {
		this.omMapa = omMapa;
	}
	
	@Column(name = "qt_usada", precision = 14, scale = 4)
	public BigDecimal getQtUsada() {
		return this.qtUsada;
	}

	public void setQtUsada(BigDecimal qtUsada) {
		this.qtUsada = qtUsada;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omMapapa")
	public Set<OmAlimrea> getOmAlimreas() {
		return this.omAlimreas;
	}

	public void setOmAlimreas(Set<OmAlimrea> omAlimreas) {
		this.omAlimreas = omAlimreas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omMapapa")
	public Set<OmPapro> getOmPapros() {
		return this.omPapros;
	}

	public void setOmPapros(Set<OmPapro> omPapros) {
		this.omPapros = omPapros;
	}
	
	@Column(name = "is_ciclounico")
	public Boolean getIsCiclounico() {
		return isCiclounico;
	}

	public void setIsCiclounico(Boolean isValor) {
		this.isCiclounico = isValor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omMapapa")
	public Set<OmMapapaproalt> getOmMapapaproalts() {
		return omMapapaproalts;
	}

	public void setOmMapapaproalts(Set<OmMapapaproalt> omMapapaproalts) {
		this.omMapapaproalts = omMapapaproalts;
	}

}

package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmPtPaMapaTemplate;

@Entity
@Table(name = "om_pt_pa_mapa")
public class OmPtPaMapa extends OmPtPaMapaTemplate implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long idPtPaMapa;
	private OmPtPa omPtPa;
	private OmMapa omMapa;
	private Integer ordemInicial;

	public OmPtPaMapa() {
		super();
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "OM_PT_PA_MAPA_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PT_PA_MAPA_SEQ", sequenceName = "OM_PT_PA_MAPA_SEQ")
	@Column(name = "id_pt_pa_mapa", unique = true, nullable = false)
	public Long getIdPtPaMapa() {
		return this.idPtPaMapa;
	}

	public void setIdPtPaMapa(Long valor) {
		this.idPtPaMapa = valor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt", nullable = false)
	public OmPtPa getOmPtPa() {
		return this.omPtPa;
	}

	public void setOmPtPa(OmPtPa valor) {
		this.omPtPa = valor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mapa")
	public OmMapa getOmMapa() {
		return this.omMapa;
	}

	public void setOmMapa(OmMapa valor) {
		this.omMapa = valor;
	}

	@Column(name = "ordem_inicial")
	public Integer getOrdemInicial() {
		return this.ordemInicial;
	}

	public void setOrdemInicial(Integer valor) {
		this.ordemInicial = valor;
	}
}

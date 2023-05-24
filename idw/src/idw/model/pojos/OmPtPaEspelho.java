package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmPtPaEspelhoTemplate;

@Entity
@Table(name = "om_pt_pa_espelho")
public class OmPtPaEspelho extends OmPtPaEspelhoTemplate implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long idPtPaEspelho;
	private OmPtPa omPtPa;
	private OmPa omPa;
	private Integer ordem;

	public OmPtPaEspelho() {
		super();
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "OM_PT_PA_ESPELHO_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PT_PA_ESPELHO_SEQ", sequenceName = "OM_PT_PA_ESPELHO_SEQ")
	@Column(name = "id_pt_pa_espelho", unique = true, nullable = false)
	public Long getIdPtPaEspelho() {
		return this.idPtPaEspelho;
	}

	public void setIdPtPaEspelho(Long valor) {
		this.idPtPaEspelho = valor;
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
	@JoinColumn(name = "id_pa")
	public OmPa getOmPa() {
		return this.omPa;
	}

	public void setOmPa(OmPa valor) {
		this.omPa = valor;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer valor) {
		this.ordem = valor;
	}
}

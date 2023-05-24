package idw.model.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import idw.model.pojos.template.OmPtPaTemplate;

/**
 * MsPtColeta generated by hbm2java
 */
@Entity
@Table(name = "om_pt_pa")
public class OmPtPa extends OmPtPaTemplate implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long idPt;
	private String dsEspelho;
	private String cdMesa;
	private Integer ordemInicial;

	private OmPt omPt;

	private Set<OmPtPaEspelho> omPtPaEspelhos = new HashSet<>(0);
	private Set<OmPtPaMapa> omPtPaMapas = new HashSet<>(0);

	public OmPtPa() {
		super();
	}

	@Id
	@Column(name = "id_pt", unique = true, nullable = false)
	public Long getIdPt() {
		return this.idPt;
	}

	public void setIdPt(Long idPt) {
		this.idPt = idPt;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Column(name = "ds_espelho", length = 100)
	public String getDsEspelho() {
		return this.dsEspelho;
	}

	public void setDsEspelho(String valor) {
		this.dsEspelho = valor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omPtPa")
	public Set<OmPtPaEspelho> getOmPtPaEspelhos() {
		return this.omPtPaEspelhos;
	}

	public void setOmPtPaEspelhos(Set<OmPtPaEspelho> valor) {
		this.omPtPaEspelhos = valor;
	}

	@Column(name = "ordem_inicial")
	public Integer getOrdemInicial() {
		return ordemInicial;
	}

	public void setOrdemInicial(Integer valor) {
		this.ordemInicial = valor;
	}

	@Column(name = "cd_mesa")
	public String getCdMesa() {
		return cdMesa;
	}

	public void setCdMesa(String cdMesa) {
		this.cdMesa = cdMesa;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omPtPa")
	public Set<OmPtPaMapa> getOmPtPaMapas() {
		return omPtPaMapas;
	}

	public void setOmPtPaMapas(Set<OmPtPaMapa> omPtPaMapas) {
		this.omPtPaMapas = omPtPaMapas;
	}



}

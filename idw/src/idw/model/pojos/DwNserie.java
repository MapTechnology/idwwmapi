package idw.model.pojos;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Generated 29/01/2010 13:18:21 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.DwNserieTemplate;


/**
 * DwNserie generated by hbm2java
 */
@Entity
@Table(name = "dw_nserie")
public class DwNserie extends DwNserieTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idNserie;
	private DwPassagem dwPassagem;
	private DwPassagem dwPassagemtf;
	private OmProduto omProduto;
	private DwEst dwEst;
	private String cb;
	private String cbserial;
	private String ns;
	private Integer sequencial;
	private Boolean isConsumido;
	private Date dthrBatismobc;
	private String idBatismobc;
	
	private OmProrange omProrange;
	
	private Set<DwPassagem> dwPassagems = new HashSet<DwPassagem>(0);
	private Set<PpCpnserie> ppCpnseries = new HashSet<PpCpnserie>(0);
	private Set<DwNserieobs> dwNserieobses = new HashSet<DwNserieobs>(0);
	
	private Set<DwNsMp> dwNsMps = new HashSet<DwNsMp>(0);

	public DwNserie() {
	}

	public DwNserie(long idNserie) {
		this.idNserie = idNserie;
	}

	public DwNserie(long idNserie, DwPassagem dwPassagem, OmProduto omProduto,
			DwEst dwEst, String cb, String ns, Set<DwPassagem> dwPassagems) {
		this.idNserie = idNserie;
		this.dwPassagem = dwPassagem;
		this.omProduto = omProduto;
		this.dwEst = dwEst;
		this.cb = cb;
		this.ns = ns;
		this.dwPassagems = dwPassagems;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_NSERIE_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_NSERIE_SEQ", sequenceName = "DW_NSERIE_SEQ")
	@Column(name = "id_nserie", unique = true, nullable = false)
	public long getIdNserie() {
		return this.idNserie;
	}

	public void setIdNserie(long idNserie) {
		this.idNserie = idNserie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_passagem")
	public DwPassagem getDwPassagem() {
		return this.dwPassagem;
	}

	public void setDwPassagem(DwPassagem dwPassagem) {
		this.dwPassagem = dwPassagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_passagemtf")
	public DwPassagem getDwPassagemtf() {
		return this.dwPassagemtf;
	}

	public void setDwPassagemtf(DwPassagem dwPassagemtf) {
		this.dwPassagemtf = dwPassagemtf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_est")
	public DwEst getDwEst() {
		return this.dwEst;
	}

	public void setDwEst(DwEst dwEst) {
		this.dwEst = dwEst;
	}
	
	@Column(name = "cb")
	public String getCb() {
		return this.cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	@Column(name = "ns")
	public String getNs() {
		return this.ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}
	
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwNserie")
	public Set<DwPassagem> getDwPassagems() {
		return this.dwPassagems;
	}

	public void setDwPassagems(Set<DwPassagem> dwPassagems) {
		this.dwPassagems = dwPassagems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwNserie")
	public Set<PpCpnserie> getPpCpnseries() {
		return this.ppCpnseries;
	}

	public void setPpCpnseries(Set<PpCpnserie> ppCpnseries) {
		this.ppCpnseries = ppCpnseries;
	}
	@Column(name = "sequencial")
	public Integer getSequencial() {
		return this.sequencial;
	}

	public void setSequencial(Integer valor) {
		this.sequencial = valor;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwNserie")
	public Set<DwNserieobs> getDwNserieobses() {
		return this.dwNserieobses;
	}

	public void setDwNserieobses(Set<DwNserieobs> valor) {
		this.dwNserieobses = valor;
	}

	@Column(name= "cbserial")
	public String getCbserial() {
		return cbserial;
	}

	public void setCbserial(String cbserial) {
		this.cbserial = cbserial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prorange")
	public OmProrange getOmProrange() {
		return omProrange;
	}

	public void setOmProrange(OmProrange omProrange) {
		this.omProrange = omProrange;
	}

	@Column(name = "is_consumido")
	public Boolean getIsConsumido() {
		return isConsumido;
	}

	public void setIsConsumido(Boolean isConsumido) {
		this.isConsumido = isConsumido;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_BATISMOBC")
	public Date getDthrBatismobc() {
		return dthrBatismobc;
	}

	public void setDthrBatismobc(Date dthrBatismobc) {
		this.dthrBatismobc = dthrBatismobc;
	}

	@Column(name = "id_batismobc")
	public String getIdBatismobc() {
		return idBatismobc;
	}

	public void setIdBatismobc(String idBatismobc) {
		this.idBatismobc = idBatismobc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwNserie")
	public Set<DwNsMp> getDwNsMps() {
		return dwNsMps;
	}

	public void setDwNsMps(Set<DwNsMp> dwNsMps) {
		this.dwNsMps = dwNsMps;
	}
}
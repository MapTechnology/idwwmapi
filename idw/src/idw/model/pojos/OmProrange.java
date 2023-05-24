package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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

import idw.model.pojos.template.OmProrangeTemplate;

@Entity
@Table(name = "om_prorange")
public class OmProrange extends OmProrangeTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long idProrange;
	private Byte tpRegra;
	private String nsInicial;
	private String nsFinal;
	
	
	private DwMacrange dwMacrange;
	private OmProduto omProduto;
	private BigDecimal consumoporciclo;
	private BigDecimal qtConsumida;
	private BigDecimal qtTotal;
	private Byte stAtivo;
	private Boolean isExclusivo;
	
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;

	private Date dthrRevisao;
	private Date dthrStativo;
	
	private Set<DwNserie> dwnseries = new HashSet<>();
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PRORANGE_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PRORANGE_SEQ", sequenceName = "OM_PRORANGE_SEQ")
	@Column(name = "id_prorange", unique = true, nullable = false)
	public Long getIdProrange() {
		return idProrange;
	}
	public void setIdProrange(Long idProrange) {
		this.idProrange = idProrange;
	}
	
	
	@Column(name = "tp_regra")
	public Byte getTpRegra() {
		return tpRegra;
	}
	public void setTpRegra(Byte tpRange) {
		this.tpRegra = tpRange;
	}
	
	
	
	@Column(name = "ns_inicial")
	public String getNsInicial() {
		return nsInicial;
	}
	public void setNsInicial(String nsInicial) {
		this.nsInicial = nsInicial;
	}
	
	
	@Column(name = "ns_final")
	public String getNsFinal() {
		return nsFinal;
	}
	public void setNsFinal(String nsFinal) {
		this.nsFinal = nsFinal;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_macrange", nullable = true)
	public DwMacrange getDwMacrange() {
		return dwMacrange;
	}
	public void setDwMacrange(DwMacrange dwMacrange) {
		this.dwMacrange = dwMacrange;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = true)
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
	
	
	@Column(name = "consumoporciclo")
	public BigDecimal getConsumoporciclo() {
		return consumoporciclo;
	}
	public void setConsumoporciclo(BigDecimal consumoPorCiclo) {
		this.consumoporciclo = consumoPorCiclo;
	}
	
	@Column(name = "qt_consumida")
	public BigDecimal getQtConsumida() {
		return qtConsumida;
	}
	public void setQtConsumida(BigDecimal qtConsumida) {
		this.qtConsumida = qtConsumida;
	}
	
	@Column(name = "qt_total")
	public BigDecimal getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return stAtivo;
	}
	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omProrange")
	public Set<DwNserie> getDwnseries() {
		return dwnseries;
	}
	public void setDwnseries(Set<DwNserie> dwnseries) {
		this.dwnseries = dwnseries;
	}
	
	
	@Column(name = "is_exclusivo")
	public Boolean getIsExclusivo() {
		return isExclusivo;
	}
	public void setIsExclusivo(Boolean isExclusivo) {
		this.isExclusivo = isExclusivo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_revisao", length = 23)
	public Date getDthrRevisao() {
		return dthrRevisao;
	}
	public void setDthrRevisao(Date dthrRevisao) {
		this.dthrRevisao = dthrRevisao;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_stativo", length = 23)
	public Date getDthrStativo() {
		return dthrStativo;
	}
	public void setDthrStativo(Date dthrStativo) {
		this.dthrStativo = dthrStativo;
	}

}

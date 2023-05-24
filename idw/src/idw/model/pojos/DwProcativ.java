package idw.model.pojos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.DwProcativTemplate;

@XmlRootElement
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_procativ")
public class DwProcativ extends DwProcativTemplate implements java.io.Serializable {

	private long idProcativ;
	private DwTArea dwTArea;
	private DwProcedimento dwProcedimento;
	private DwGrpativ dwGrpativ;
	private String dsProcativ;
	private BigDecimal segTempopadrao;
	private Integer ordemGrupo;
	private Integer ordemProcativ;
	private Set<DwDetativ> dwDetativs = new HashSet<DwDetativ>(0);

	public DwProcativ() {
	}

	public DwProcativ(long idProcativ, DwProcedimento dwProcedimento,
			DwGrpativ dwGrpativ) {
		this.idProcativ = idProcativ;
		this.dwProcedimento = dwProcedimento;
		this.dwGrpativ = dwGrpativ;
	}

	public DwProcativ(long idProcativ, DwProcedimento dwProcedimento,
			DwGrpativ dwGrpativ, String dsProcativ, BigDecimal segTempopadrao,
			Integer ordemGrupo, Integer ordemProcativ, Set<DwDetativ> dwDetativs) {
		this.idProcativ = idProcativ;
		this.dwProcedimento = dwProcedimento;
		this.dwGrpativ = dwGrpativ;
		this.dsProcativ = dsProcativ;
		this.segTempopadrao = segTempopadrao;
		this.ordemGrupo = ordemGrupo;
		this.ordemProcativ = ordemProcativ;
		this.dwDetativs = dwDetativs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_PROCATIV_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_PROCATIV_SEQ", sequenceName = "DW_PROCATIV_SEQ")
	@Column(name = "id_procativ", unique = true, nullable = false)
	public long getIdProcativ() {
		return this.idProcativ;
	}

	public void setIdProcativ(long idProcativ) {
		this.idProcativ = idProcativ;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_procedimento", nullable = false)
	public DwProcedimento getDwProcedimento() {
		return this.dwProcedimento;
	}

	public void setDwProcedimento(DwProcedimento dwProcedimento) {
		this.dwProcedimento = dwProcedimento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grpativ", nullable = false)
	public DwGrpativ getDwGrpativ() {
		return this.dwGrpativ;
	}

	public void setDwGrpativ(DwGrpativ dwGrpativ) {
		this.dwGrpativ = dwGrpativ;
	}

	@Column(name = "ds_procativ", length = 256)
	public String getDsProcativ() {
		return this.dsProcativ;
	}

	public void setDsProcativ(String dsProcativ) {
		this.dsProcativ = dsProcativ;
	}

	@Column(name = "seg_tempopadrao", precision = 20, scale = 10)
	public BigDecimal getSegTempopadrao() {
		return this.segTempopadrao;
	}

	public void setSegTempopadrao(BigDecimal segTempopadrao) {
		this.segTempopadrao = segTempopadrao;
	}

	@Column(name = "ordem_grupo")
	public Integer getOrdemGrupo() {
		return this.ordemGrupo;
	}

	public void setOrdemGrupo(Integer ordemGrupo) {
		this.ordemGrupo = ordemGrupo;
	}

	@Column(name = "ordem_procativ")
	public Integer getOrdemProcativ() {
		return this.ordemProcativ;
	}

	public void setOrdemProcativ(Integer ordemProcativ) {
		this.ordemProcativ = ordemProcativ;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwProcativ")
	public Set<DwDetativ> getDwDetativs() {
		return this.dwDetativs;
	}

	public void setDwDetativs(Set<DwDetativ> dwDetativs) {
		this.dwDetativs = dwDetativs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area")
	public DwTArea getDwTArea() {
		return this.dwTArea;
	}

	public void setDwTArea(DwTArea dwTArea) {
		this.dwTArea = dwTArea;
	}
}

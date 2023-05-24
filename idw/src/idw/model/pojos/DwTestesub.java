package idw.model.pojos;

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

// Generated 29/01/2010 13:18:21 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.DwTestesubTemplate;


/**
 * DwTestesub generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_testesub")
public class DwTestesub extends DwTestesubTemplate implements java.io.Serializable {

	private long idTestesub;
	private DwFtSub dwFtSub;
	private DwFolhateste dwFolhateste;
	private Integer ordem;
	private Integer qtMedSeg;
	private Integer qtMedSegPosFalha;
	private Integer msCapMedPosFalha;
	private Boolean isSalvar;
	private Integer ordemEtapa;
	private Integer acenderLampada;
	private Set<DwTestesubetapa> dwTestesubetapas = new HashSet<DwTestesubetapa>(
			0);

	public DwTestesub() {
	}

	public DwTestesub(long idTestesub, DwFtSub dwFtSub,
			DwFolhateste dwFolhateste) {
		this.idTestesub = idTestesub;
		this.dwFtSub = dwFtSub;
		this.dwFolhateste = dwFolhateste;
	}

	public DwTestesub(long idTestesub, DwFtSub dwFtSub,
			DwFolhateste dwFolhateste, Integer ordem, Integer qtMedSeg,
			Integer qtMedSegPosFalha, Integer msCapMedPosFalha,
			Boolean isSalvar, Integer ordemEtapa, Integer acenderLampada,
			Set<DwTestesubetapa> dwTestesubetapas) {
		this.idTestesub = idTestesub;
		this.dwFtSub = dwFtSub;
		this.dwFolhateste = dwFolhateste;
		this.ordem = ordem;
		this.qtMedSeg = qtMedSeg;
		this.qtMedSegPosFalha = qtMedSegPosFalha;
		this.msCapMedPosFalha = msCapMedPosFalha;
		this.isSalvar = isSalvar;
		this.ordemEtapa = ordemEtapa;
		this.acenderLampada = acenderLampada;
		this.dwTestesubetapas = dwTestesubetapas;
	}

	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_TESTESUB_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_TESTESUB_SEQ", sequenceName = "DW_TESTESUB_SEQ")
	@Column(name = "id_testesub", nullable = false)
	public long getIdTestesub() {
		return this.idTestesub;
	}

	public void setIdTestesub(long idTestesub) {
		this.idTestesub = idTestesub;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ft_sub", nullable = false)
	public DwFtSub getDwFtSub() {
		return this.dwFtSub;
	}

	public void setDwFtSub(DwFtSub dwFtSub) {
		this.dwFtSub = dwFtSub;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folhateste", nullable = false)
	public DwFolhateste getDwFolhateste() {
		return this.dwFolhateste;
	}

	public void setDwFolhateste(DwFolhateste dwFolhateste) {
		this.dwFolhateste = dwFolhateste;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Column(name = "qt_med_seg")
	public Integer getQtMedSeg() {
		return this.qtMedSeg;
	}

	public void setQtMedSeg(Integer qtMedSeg) {
		this.qtMedSeg = qtMedSeg;
	}

	@Column(name = "qt_med_seg_pos_falha")
	public Integer getQtMedSegPosFalha() {
		return this.qtMedSegPosFalha;
	}

	public void setQtMedSegPosFalha(Integer qtMedSegPosFalha) {
		this.qtMedSegPosFalha = qtMedSegPosFalha;
	}

	@Column(name = "ms_cap_med_pos_falha")
	public Integer getMsCapMedPosFalha() {
		return this.msCapMedPosFalha;
	}

	public void setMsCapMedPosFalha(Integer msCapMedPosFalha) {
		this.msCapMedPosFalha = msCapMedPosFalha;
	}

	@Column(name = "is_salvar")
	public Boolean getIsSalvar() {
		return this.isSalvar;
	}

	public void setIsSalvar(Boolean isSalvar) {
		this.isSalvar = isSalvar;
	}

	@Column(name = "ordemEtapa")
	public Integer getOrdemEtapa() {
		return this.ordemEtapa;
	}

	public void setOrdemEtapa(Integer ordemEtapa) {
		this.ordemEtapa = ordemEtapa;
	}
	
	@Column(name = "acenderLampada")
	public Integer getAcenderLampada() {
		return this.acenderLampada;
	}

	public void setAcenderLampada(Integer acenderLampada) {
		this.acenderLampada = acenderLampada;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwTestesub")
	public Set<DwTestesubetapa> getDwTestesubetapas() {
		return this.dwTestesubetapas;
	}

	public void setDwTestesubetapas(Set<DwTestesubetapa> dwTestesubetapas) {
		this.dwTestesubetapas = dwTestesubetapas;
	}

}

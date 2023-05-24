package idw.model.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated 11/01/2010 15:35:09 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.DwRpPredecessoraTemplate;


/**
 * DwRpPredecessora generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dw_rp_predecessora")
public class DwRpPredecessora extends DwRpPredecessoraTemplate implements java.io.Serializable {

	private long idRpPredecessora;
	private DwRotapasso dwRotapassoByIdRotapassoFilho;
	private DwRotapasso dwRotapassoByIdRotapassoPai;
	private Boolean isAceitaSeNc;
	private Boolean isAceitaSeC;
	private Boolean isEspelho;

	public DwRpPredecessora() {
	}

	public DwRpPredecessora(long idRpPredecessora,
			DwRotapasso dwRotapassoByIdRotapassoFilho) {
		this.idRpPredecessora = idRpPredecessora;
		this.dwRotapassoByIdRotapassoFilho = dwRotapassoByIdRotapassoFilho;
	}

	public DwRpPredecessora(long idRpPredecessora,
			DwRotapasso dwRotapassoByIdRotapassoFilho,
			DwRotapasso dwRotapassoByIdRotapassoPai, Boolean isAceitaSeNc,
			Boolean isAceitaSeC) {
		this.idRpPredecessora = idRpPredecessora;
		this.dwRotapassoByIdRotapassoFilho = dwRotapassoByIdRotapassoFilho;
		this.dwRotapassoByIdRotapassoPai = dwRotapassoByIdRotapassoPai;
		this.isAceitaSeNc = isAceitaSeNc;
		this.isAceitaSeC = isAceitaSeC;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_RP_PREDECESSORA_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_RP_PREDECESSORA_SEQ", sequenceName = "DW_RP_PREDECESSORA_SEQ")
	@Column(name = "id_rp_predecessora", unique = true, nullable = false)
	public long getIdRpPredecessora() {
		return this.idRpPredecessora;
	}

	public void setIdRpPredecessora(long idRpPredecessora) {
		this.idRpPredecessora = idRpPredecessora;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rotapassoFilho", nullable = false)
	public DwRotapasso getDwRotapassoByIdRotapassoFilho() {
		return this.dwRotapassoByIdRotapassoFilho;
	}

	public void setDwRotapassoByIdRotapassoFilho(
			DwRotapasso dwRotapassoByIdRotapassoFilho) {
		this.dwRotapassoByIdRotapassoFilho = dwRotapassoByIdRotapassoFilho;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rotapassoPai")
	public DwRotapasso getDwRotapassoByIdRotapassoPai() {
		return this.dwRotapassoByIdRotapassoPai;
	}

	public void setDwRotapassoByIdRotapassoPai(
			DwRotapasso dwRotapassoByIdRotapassoPai) {
		this.dwRotapassoByIdRotapassoPai = dwRotapassoByIdRotapassoPai;
	}

	@Column(name = "is_aceitaSeNC")
	public Boolean getIsAceitaSeNc() {
		return this.isAceitaSeNc;
	}

	public void setIsAceitaSeNc(Boolean isAceitaSeNc) {
		this.isAceitaSeNc = isAceitaSeNc;
	}

	@Column(name = "is_aceitaSeC")
	public Boolean getIsAceitaSeC() {
		return this.isAceitaSeC;
	}

	public void setIsAceitaSeC(Boolean isAceitaSeC) {
		this.isAceitaSeC = isAceitaSeC;
	}
	@Column(name = "is_espelho")
	public Boolean getIsEspelho() {
		return this.isEspelho;
	}

	public void setIsEspelho(Boolean isEspelho) {
		this.isEspelho = isEspelho;
	}
}
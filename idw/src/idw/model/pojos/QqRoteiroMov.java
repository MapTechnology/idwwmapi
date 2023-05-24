package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.QqRoteiroMovTemplate;

@Entity
@Table(name = "qq_roteiro_mov")
public class QqRoteiroMov extends QqRoteiroMovTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idRoteiromov;
	private QqRoteiro qqRoteiro;
	private DwTpest dwTpestentrada;
	private DwTpest dwTpestsaida;
	private QqFolhaInsRap qqFolhainsrap;
	private DwEst dwEstentrada;
	private DwEst dwEstsaida;
	
	private Set<QqRoteiroPre> qqRoteiroPres = new HashSet<QqRoteiroPre>();
	private Set<QqRoteiroUsr> qqRoteiroUsrs = new HashSet<QqRoteiroUsr>();
	
	
	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_ROTEIRO_MOV_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_ROTEIRO_MOV_SEQ", sequenceName = "QQ_ROTEIRO_MOV_SEQ")
	@Column(name = "id_roteiromov", nullable = false)
	public Long getIdRoteiromov() {
		return idRoteiromov;
	}
	public void setIdRoteiromov(Long idRoteiromov) {
		this.idRoteiromov = idRoteiromov;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_roteiro")
	public QqRoteiro getQqRoteiro() {
		return qqRoteiro;
	}
	public void setQqRoteiro(QqRoteiro qqRoteiro) {
		this.qqRoteiro = qqRoteiro;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tpestentrada")
	public DwTpest getDwTpestentrada() {
		return dwTpestentrada;
	}
	public void setDwTpestentrada(DwTpest dwTpestentrada) {
		this.dwTpestentrada = dwTpestentrada;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tpestsaida")
	public DwTpest getDwTpestsaida() {
		return dwTpestsaida;
	}
	public void setDwTpestsaida(DwTpest dwTpestsaida) {
		this.dwTpestsaida = dwTpestsaida;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folhainsrap")
	public QqFolhaInsRap getQqFolhainsrap() {
		return qqFolhainsrap;
	}
	public void setQqFolhainsrap(QqFolhaInsRap qqFolhainsrap) {
		this.qqFolhainsrap = qqFolhainsrap;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estentrada")
	public DwEst getDwEstentrada() {
		return dwEstentrada;
	}
	public void setDwEstentrada(DwEst dwEstentrada) {
		this.dwEstentrada = dwEstentrada;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estsaida")
	public DwEst getDwEstsaida() {
		return dwEstsaida;
	}
	public void setDwEstsaida(DwEst dwEstsaida) {
		this.dwEstsaida = dwEstsaida;
	}

	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqRoteiroMov")
	public Set<QqRoteiroPre> getQqRoteiroPres() {
		return qqRoteiroPres;
	}
	public void setQqRoteiroPres(Set<QqRoteiroPre> qqRoteiroPres) {
		this.qqRoteiroPres = qqRoteiroPres;
	}
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqRoteiroMov")
	public Set<QqRoteiroUsr> getQqRoteiroUsrs() {
		return qqRoteiroUsrs;
	}
	public void setQqRoteiroUsrs(Set<QqRoteiroUsr> qqRoteiroUsrs) {
		this.qqRoteiroUsrs = qqRoteiroUsrs;
	}
	
	
}

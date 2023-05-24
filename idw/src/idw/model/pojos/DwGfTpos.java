package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.DwGfTposTemplate;

@Entity
@Table(name = "dw_gf_tpos")
public class DwGfTpos extends DwGfTposTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idGftpos;
	private BigDecimal qtCiclos;
	private BigDecimal segIntervalo;
	
	private DwGrupoFerramenta dwGrupoFerramenta;
	private MmTpos mmTpos;
	
	
	private Set<DwGfEmail> dwGfEmails = new HashSet<DwGfEmail>(0);
	
	public DwGfTpos() {
		super();
	}


	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_GF_TPOS_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_GF_TPOS_SEQ", sequenceName = "DW_GF_TPOS_SEQ")
	@Column(name = "id_gftpos", unique = true, nullable = false)
	public Long getIdGftpos() {
		return idGftpos;
	}


	public void setIdGftpos(Long idGftpos) {
		this.idGftpos = idGftpos;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupo_ferramenta", nullable = false)
	public DwGrupoFerramenta getDwGrupoFerramenta() {
		return dwGrupoFerramenta;
	}


	public void setDwGrupoFerramenta(DwGrupoFerramenta dwGrupoFerramenta) {
		this.dwGrupoFerramenta = dwGrupoFerramenta;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tpos", nullable = false)
	public MmTpos getMmTpos() {
		return mmTpos;
	}


	public void setMmTpos(MmTpos mmTpos) {
		this.mmTpos = mmTpos;
	}


	@Column(name = "QT_CICLOS", precision = 14, scale = 4)
	public BigDecimal getQtCiclos() {
		return qtCiclos;
	}


	public void setQtCiclos(BigDecimal qtCiclos) {
		this.qtCiclos = qtCiclos;
	}


	@Column(name = "SEG_INTERVALO", precision = 20, scale = 10)
	public BigDecimal getSegIntervalo() {
		return segIntervalo;
	}


	public void setSegIntervalo(BigDecimal segIntervalo) {
		this.segIntervalo = segIntervalo;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dwGfTpos")
	public Set<DwGfEmail> getDwGfEmails() {
		return dwGfEmails;
	}
	public void setDwGfEmails(Set<DwGfEmail> dwGfEmails) {
		this.dwGfEmails = dwGfEmails;
	}
	
	
	
	
}

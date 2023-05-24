package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.DwNsMpTemplate;

@Entity
@Table(name = "dw_ns_mp")
public class DwNsMp extends DwNsMpTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idNsmp;
	private String nrop;
	private Date dthrCadastro;
	
	private DwNserie dwNserie;
	private OmGt omGt;
	private OmPt omPt;
	private OmAlimrea omAlimrea;
	private OmProduto omProduto;
	
	public DwNsMp() {
		super();
	}
	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_NS_MP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_NS_MP_SEQ", sequenceName = "DW_NS_MP_SEQ")
	@Column(name = "id_nsmp", unique = true, nullable = false)
	public Long getIdNsmp() {
		return idNsmp;
	}
	public void setIdNsmp(Long idNsmp) {
		this.idNsmp = idNsmp;
	}
	
	@Column(name = "nrop")
	public String getNrop() {
		return nrop;
	}
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nserie", nullable = false)
	public DwNserie getDwNserie() {
		return dwNserie;
	}
	public void setDwNserie(DwNserie dwNserie) {
		this.dwNserie = dwNserie;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gt", nullable = false)
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pt", nullable = false)
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimrea", nullable = false)
	public OmAlimrea getOmAlimrea() {
		return omAlimrea;
	}
	public void setOmAlimrea(OmAlimrea omAlimrea) {
		this.omAlimrea = omAlimrea;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}



	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_cadastro", length = 23)
	public Date getDthrCadastro() {
		return dthrCadastro;
	}



	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	
	
}

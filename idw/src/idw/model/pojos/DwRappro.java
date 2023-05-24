package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.DwRapproTemplate;

@Entity
@Table(name = "DW_RAPPRO")
public class DwRappro extends DwRapproTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idRappro;
	private DwRap dwRap;
	private OmProduto omProduto;
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_RAPPRO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_RAPPRO_SEQ", sequenceName = "DW_RAPPRO_SEQ")
	@Column(name = "ID_RAPPRO", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdRappro() {
		return idRappro;
	}
	public void setIdRappro(Long idRappro) {
		this.idRappro = idRappro;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAP")
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO")
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
}

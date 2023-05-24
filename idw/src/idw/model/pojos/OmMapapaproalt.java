package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmMapapaproaltTemplate;

@Entity
@Table(name = "om_mapapaproalt")
public class OmMapapaproalt extends OmMapapaproaltTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idMapapaproalt;
	
	private OmMapapa omMapapa;
	private OmProduto omProduto;
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_MAPAPAPROALT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_MAPAPAPROALT_SEQ", sequenceName = "OM_MAPAPAPROALT_SEQ")
	@Column(name = "id_mapapaproalt", unique = true, nullable = false)
	public Long getIdMapapaproalt() {
		return idMapapaproalt;
	}
	public void setIdMapapaproalt(Long idMapapaproalt) {
		this.idMapapaproalt = idMapapaproalt;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mapapa", nullable = false)
	public OmMapapa getOmMapapa() {
		return omMapapa;
	}
	public void setOmMapapa(OmMapapa omMapapa) {
		this.omMapapa = omMapapa;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return omProduto;
	}
	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}
}

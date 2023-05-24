package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmPrgposproaltTemplate;

@Entity
@Table(name = "om_prgposproalt")
public class OmPrgposproalt extends OmPrgposproaltTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idPrgposproalt;
	
	private OmPrgpos omPrgpos;
	private OmProduto omProduto;

	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PRGPOSPROALT_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PRGPOSPROALT_SEQ", sequenceName = "OM_PRGPOSPROALT_SEQ")
	@Column(name = "id_mapapaproalt", unique = true, nullable = false)
	public Long getIdPrgposproalt() {
		return idPrgposproalt;
	}
	public void setIdPrgposproalt(Long idPrgposproalt) {
		this.idPrgposproalt = idPrgposproalt;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prgpos", nullable = false)
	public OmPrgpos getOmPrgpos() {
		return omPrgpos;
	}
	public void setOmPrgpos(OmPrgpos omPrgpos) {
		this.omPrgpos = omPrgpos;
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

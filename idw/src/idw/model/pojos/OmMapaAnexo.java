package idw.model.pojos;
// default package
// Generated 11/10/2011 08:52:14 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmMapaAnexoTemplate;

@Entity
@Table(name = "OM_MAPA_ANEXO")
public class OmMapaAnexo extends OmMapaAnexoTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idMapaAnexo;
	private OmMapa omMapaByIdMapa;
	private OmMapa omMapaByIdMapaFilho;

	public OmMapaAnexo() {
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_MAPA_ANEXO_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_MAPA_ANEXO_SEQ", sequenceName = "OM_MAPA_ANEXO_SEQ")
	@Column(name = "ID_MAPA_ANEXO", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getIdMapaAnexo() {
		return this.idMapaAnexo;
	}

	public void setIdMapaAnexo(Long id) {
		this.idMapaAnexo = id;
	}

	
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MAPA", nullable = false)
	public OmMapa getOmMapaByIdMapa() {
		return this.omMapaByIdMapa;
	}

	public void setOmMapaByIdMapa(OmMapa valor) {
		this.omMapaByIdMapa = valor;
	}


	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MAPA_FILHO")
	public OmMapa getOmMapaByIdMapaFilho() {
		return this.omMapaByIdMapaFilho;
	}

	public void setOmMapaByIdMapaFilho(OmMapa valor) {
		this.omMapaByIdMapaFilho = valor;
	}



}

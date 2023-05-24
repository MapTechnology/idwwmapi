package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.OmRegrasTagsTemplate;

@Entity
@Table(name = "om_regras_tags")
public class OmRegrasTags extends OmRegrasTagsTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idRegrasTags;
	private OmTags omTags;
	private OmRegrasNscb omRegrasNscb;
	private String complemento;
	private Integer ordem;

	public OmRegrasTags() {
	}

	public OmRegrasTags(Long idRegrasTags) {
		this.idRegrasTags = idRegrasTags;
	}

	public OmRegrasTags(Long idRegrasTags, OmTags omTags,
			OmRegrasNscb omRegrasNscb, String complemento, Integer ordem) {
		this.idRegrasTags = idRegrasTags;
		this.omTags = omTags;
		this.omRegrasNscb = omRegrasNscb;
		this.complemento = complemento;
		this.ordem = ordem;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_REGREAS_TAGS_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_REGREAS_TAGS_SEQ", sequenceName = "OM_REGREAS_TAGS_SEQ")
	@Column(name = "id_regras_tags", unique = true, nullable = false)
	public Long getIdRegrasTags() {
		return this.idRegrasTags;
	}

	public void setIdRegrasTags(Long idRegrasTags) {
		this.idRegrasTags = idRegrasTags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tags")
	public OmTags getOmTags() {
		return this.omTags;
	}

	public void setOmTags(OmTags omTags) {
		this.omTags = omTags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regras_nscb")
	public OmRegrasNscb getOmRegrasNscb() {
		return this.omRegrasNscb;
	}

	public void setOmRegrasNscb(OmRegrasNscb omRegrasNscb) {
		this.omRegrasNscb = omRegrasNscb;
	}

	@Column(name = "complemento", length = 40)
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
}

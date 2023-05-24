package idw.model.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import idw.model.pojos.template.OmTagsTemplate;

/**
 * OmTags generated by hbm2java
 */
@Entity
@Table(name = "om_tags")
public class OmTags extends OmTagsTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTags;
	private String cdTags;
	private String dsTags;
	private Set<OmRegrasTags> omRegrasTagses = new HashSet<OmRegrasTags>(0);

	public OmTags() {
	}

	public OmTags(Long idTags) {
		this.idTags = idTags;
	}

	public OmTags(Long idTags, String cdTags, String dsTags,
			Set<OmRegrasTags> omRegrasTagses) {
		this.idTags = idTags;
		this.cdTags = cdTags;
		this.dsTags = dsTags;
		this.omRegrasTagses = omRegrasTagses;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_TAGS_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_TAGS_SEQ", sequenceName = "OM_TAGS_SEQ")
	@Column(name = "id_tags", unique = true, nullable = false)
	public Long getIdTags() {
		return this.idTags;
	}

	public void setIdTags(Long idTags) {
		this.idTags = idTags;
	}

	@Column(name = "cd_tags", length = 60)
	public String getCdTags() {
		return this.cdTags;
	}

	public void setCdTags(String cdTags) {
		this.cdTags = cdTags;
	}

	@Column(name = "ds_tags", length = 100)
	public String getDsTags() {
		return this.dsTags;
	}

	public void setDsTags(String dsTags) {
		this.dsTags = dsTags;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omTags")
	public Set<OmRegrasTags> getOmRegrasTagses() {
		return this.omRegrasTagses;
	}

	public void setOmRegrasTagses(Set<OmRegrasTags> omRegrasTagses) {
		this.omRegrasTagses = omRegrasTagses;
	}

}

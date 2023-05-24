package idw.model.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Generated 11/01/2010 15:35:09 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmAlgocorTemplate;

/**
 * OmAlgocor generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "om_algocor")
public class OmAlgocor extends OmAlgocorTemplate implements java.io.Serializable {

	private long idAlgocor;
	private String dsAlgocor;
	private Set<OmTppt> omTppts = new HashSet<OmTppt>(0);
	private Set<OmCfg> omCfgs = new HashSet<OmCfg>(0);

	public OmAlgocor() {
	}

	public OmAlgocor(long idAlgocor) {
		this.idAlgocor = idAlgocor;
	}

	public OmAlgocor(long idAlgocor, String dsAlgocor, Set<OmTppt> omTppts
			, Set<OmCfg> omCfgs) {
		this.idAlgocor = idAlgocor;
		this.dsAlgocor = dsAlgocor;
		this.omTppts = omTppts;
		this.omCfgs = omCfgs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_ALGOCOR_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_ALGOCOR_SEQ", sequenceName = "OM_ALGOCOR_SEQ")
	@Column(name = "id_algocor", unique = true, nullable = false)
	public long getIdAlgocor() {
		return this.idAlgocor;
	}

	public void setIdAlgocor(long idAlgocor) {
		this.idAlgocor = idAlgocor;
	}

	@Column(name = "ds_algocor", length = 40)
	public String getDsAlgocor() {
		return this.dsAlgocor;
	}

	public void setDsAlgocor(String dsAlgocor) {
		this.dsAlgocor = dsAlgocor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omAlgocor")
	public Set<OmTppt> getOmTppts() {
		return this.omTppts;
	}

	public void setOmTppts(Set<OmTppt> omTppts) {
		this.omTppts = omTppts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omAlgocor")
	public Set<OmCfg> getOmCfgs() {
		return this.omCfgs;
	}

	public void setOmCfgs(Set<OmCfg> omCfgs) {
		this.omCfgs = omCfgs;
	}	
}

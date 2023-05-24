package idw.model.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OmModuloRecurso generated by hbm2java
 */
@Entity
@Table(name = "om_modulo_recurso")
public class OmModuloRecurso implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idModuloRecurso;
	private String dsModuloRecurso;
	private Set<OmLicmodrec> omLicmodrecs = new HashSet<OmLicmodrec>(0);

	public OmModuloRecurso() {
	}

	public OmModuloRecurso(Long idModuloRecurso) {
		this.idModuloRecurso = idModuloRecurso;
	}

	public OmModuloRecurso(Long idModuloRecurso, String dsModuloRecurso, Set<OmLicmodrec> omLicmodrecs) {
		this.idModuloRecurso = idModuloRecurso;
		this.dsModuloRecurso = dsModuloRecurso;
		this.omLicmodrecs = omLicmodrecs;
	}

	@Id

	@Column(name = "id_modulo_recurso", unique = true, nullable = false)
	public Long getIdModuloRecurso() {
		return this.idModuloRecurso;
	}

	public void setIdModuloRecurso(Long idModuloRecurso) {
		this.idModuloRecurso = idModuloRecurso;
	}

	@Column(name = "ds_modulo_recurso", length = 256)
	public String getDsModuloRecurso() {
		return this.dsModuloRecurso;
	}

	public void setDsModuloRecurso(String dsModuloRecurso) {
		this.dsModuloRecurso = dsModuloRecurso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omModuloRecurso")
	public Set<OmLicmodrec> getOmLicmodrecs() {
		return this.omLicmodrecs;
	}

	public void setOmLicmodrecs(Set<OmLicmodrec> omLicmodrecs) {
		this.omLicmodrecs = omLicmodrecs;
	}

}
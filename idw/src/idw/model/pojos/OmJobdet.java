package idw.model.pojos;
// Generated 12/09/2011 09:05:50 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
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

import idw.model.pojos.template.OmJobdetTemplate;

@Entity
@Table(name = "OM_JOBDET")
public class OmJobdet extends OmJobdetTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idJobdet;
	private String urlOrigem;
	private Integer ordem;

	private OmJob omJob;
	private OmJobRecurso omJobRecurso;
	
	private Set<OmJobdetlog> omJobdetlogs = new HashSet<OmJobdetlog>(0);

	
	public OmJobdet() {
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_JOBDET_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_JOBDET_SEQ", sequenceName = "OM_JOBDET_SEQ")
	@Column(name = "ID_JOBDET", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdJobdet() {
		return this.idJobdet;
	}

	public void setIdJobdet(Long id) {
		this.idJobdet = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JOB", nullable = false)
	public OmJob getOmJob() {
		return this.omJob;
	}

	public void setOmJob(OmJob omjob) {
		this.omJob = omjob;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JOB_RECURSO", nullable = false)
	public OmJobRecurso getOmJobRecurso() {
		return this.omJobRecurso;
	}

	public void setOmJobRecurso(OmJobRecurso omJobRecurso) {
		this.omJobRecurso = omJobRecurso;
	}
	
	@Column(name = "URL_ORIGEM", length = 256)
	public String getUrlOrigem() {
		return this.urlOrigem;
	}

	public void setUrlOrigem(String valor) {
		this.urlOrigem = valor;
	}

	@Column(name = "ORDEM")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer valor) {
		this.ordem = valor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "omJobdet")
	public Set<OmJobdetlog> getOmJobdetlogs() {
		return this.omJobdetlogs;
	}

	public void setOmJobdetlogs(Set<OmJobdetlog> dets) {
		this.omJobdetlogs = dets;
	}
}

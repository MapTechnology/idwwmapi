package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijtbjup generated by hbm2java
 */
@Entity
@Table(name = "IJTBJUP")
public class Ijtbjup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2363039086978476089L;
	private String cdjustparada;
	private String dsjustparada;
	private Integer stativo;
	private Set<Ijlogcorrreq> ijlogcorrreqs = new HashSet<Ijlogcorrreq>(0);
	private Set<Ijreapar> ijreapars = new HashSet<Ijreapar>(0);

	public Ijtbjup() {
	}

	public Ijtbjup(String cdjustparada, Integer stativo) {
		this.cdjustparada = cdjustparada;
		this.stativo = stativo;
	}

	public Ijtbjup(String cdjustparada, String dsjustparada,
			Integer stativo, Set<Ijlogcorrreq> ijlogcorrreqs,
			Set<Ijreapar> ijreapars) {
		this.cdjustparada = cdjustparada;
		this.dsjustparada = dsjustparada;
		this.stativo = stativo;
		this.ijlogcorrreqs = ijlogcorrreqs;
		this.ijreapars = ijreapars;
	}

	@Id
	@Column(name = "CDJUSTPARADA", unique = true, nullable = false, length = 6)
	public String getCdjustparada() {
		return this.cdjustparada;
	}

	public void setCdjustparada(String cdjustparada) {
		this.cdjustparada = cdjustparada;
	}

	@Column(name = "DSJUSTPARADA", length = 40)
	public String getDsjustparada() {
		return this.dsjustparada;
	}

	public void setDsjustparada(String dsjustparada) {
		this.dsjustparada = dsjustparada;
	}

	@Column(name = "STATIVO", nullable = false, precision = 22, scale = 0)
	public Integer getStativo() {
		return this.stativo;
	}

	public void setStativo(Integer stativo) {
		this.stativo = stativo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbjup")
	public Set<Ijlogcorrreq> getIjlogcorrreqs() {
		return this.ijlogcorrreqs;
	}

	public void setIjlogcorrreqs(Set<Ijlogcorrreq> ijlogcorrreqs) {
		this.ijlogcorrreqs = ijlogcorrreqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijtbjup")
	public Set<Ijreapar> getIjreapars() {
		return this.ijreapars;
	}

	public void setIjreapars(Set<Ijreapar> ijreapars) {
		this.ijreapars = ijreapars;
	}

}

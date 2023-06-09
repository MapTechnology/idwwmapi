package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// default package

// Generated 01/03/2010 08:56:42 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmCfgptdetcoletaTemplate;


/**
 * OmCfgptdetcoleta generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OM_CFGPTDETCOLETA")
public class OmCfgptdetcoleta extends OmCfgptdetcoletaTemplate implements java.io.Serializable {

	private long idCfgptdetcoleta;
	private OmCfg omCfg;
	private OmPt omPt;

	public OmCfgptdetcoleta() {
	}

	public OmCfgptdetcoleta(long idCfgptdetcoleta, OmCfg omCfg, OmPt omPt) {
		this.idCfgptdetcoleta = idCfgptdetcoleta;
		this.omCfg = omCfg;
		this.omPt = omPt;
	}

	@Id	
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFGPTDETCOLETA_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFGPTDETCOLETA_SEQ", sequenceName = "OM_CFGPTDETCOLETA_SEQ")
	@Column(name = "ID_CFGPTDETCOLETA", nullable = false)
	public long getIdCfgptdetcoleta() {
		return this.idCfgptdetcoleta;
	}

	public void setIdCfgptdetcoleta(long idCfgptdetcoleta) {
		this.idCfgptdetcoleta = idCfgptdetcoleta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CFG", nullable = false)
	public OmCfg getOmCfg() {
		return this.omCfg;
	}

	public void setOmCfg(OmCfg omCfg) {
		this.omCfg = omCfg;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT", nullable = false)
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

}

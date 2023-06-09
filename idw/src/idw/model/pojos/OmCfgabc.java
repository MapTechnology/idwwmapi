package idw.model.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.xml.bind.CycleRecoverable;

import idw.model.pojos.template.OmCfgabcTemplate;

/**
 * OmCfgabc generated by hbm2java
 */
@Entity
@Table(name = "om_cfgabc")
public class OmCfgabc extends OmCfgabcTemplate implements java.io.Serializable, CycleRecoverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCfgabc;
	private OmUsr omUsrByIdUsrstativo;
	private OmUsr omUsrByIdUsrrevisao;
	private String cdCfgabc;
	private Long revisao;
	private String dsCfgabc;
	private Date dtRevisao;
	private Date dtStativo;
	private Byte stAtivo;
	private String obs;
	private Set<OmCfgabclim> omCfgabclims = new HashSet<OmCfgabclim>(0);
	private Set<OmCfg> omCfgs = new HashSet<OmCfg>(0);

	public OmCfgabc() {
	}

	public OmCfgabc(Long idCfgabc) {
		this.idCfgabc = idCfgabc;
	}

	public OmCfgabc(Long idCfgabc, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, String cdCfgabc, Long revisao,
			String dsCfgabc, Date dtRevisao, Date dtStativo, Byte stAtivo,
			String obs, Set<OmCfgabclim> omCfgabclims, Set<OmCfg> omCfgs) {
		super();
		this.idCfgabc = idCfgabc;
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
		this.cdCfgabc = cdCfgabc;
		this.revisao = revisao;
		this.dsCfgabc = dsCfgabc;
		this.dtRevisao = dtRevisao;
		this.dtStativo = dtStativo;
		this.stAtivo = stAtivo;
		this.obs = obs;
		this.omCfgabclims = omCfgabclims;
		this.omCfgs = omCfgs;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFGABC_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFGABC_SEQ", sequenceName = "OM_CFGABC_SEQ")
	@Column(name = "id_cfgabc", unique = true, nullable = false)
	public Long getIdCfgabc() {
		return this.idCfgabc;
	}

	public void setIdCfgabc(Long idCfgabc) {
		this.idCfgabc = idCfgabc;
	}

	@Column(name = "cd_cfgabc", length = 60)
	public String getCdCfgabc() {
		return this.cdCfgabc;
	}

	public void setCdCfgabc(String cdCfgabc) {
		this.cdCfgabc = cdCfgabc;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "ds_cfgabc", length = 100)
	public String getDsCfgabc() {
		return this.dsCfgabc;
	}

	public void setDsCfgabc(String dsCfgabc) {
		this.dsCfgabc = dsCfgabc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_revisao", length = 10)
	public Date getDtRevisao() {
		return this.dtRevisao;
	}

	public void setDtRevisao(Date dtRevisao) {
		this.dtRevisao = dtRevisao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_stativo", length = 10)
	public Date getDtStativo() {
		return this.dtStativo;
	}

	public void setDtStativo(Date dtStativo) {
		this.dtStativo = dtStativo;
	}

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "obs", length = 256)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omCfgabc")
	public Set<OmCfgabclim> getOmCfgabclims() {
		return this.omCfgabclims;
	}

	public void setOmCfgabclims(Set<OmCfgabclim> omCfgabclims) {
		this.omCfgabclims = omCfgabclims;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omCfgabc")
	public Set<OmCfg> getOmCfgs() {
		return this.omCfgs;
	}

	public void setOmCfgs(Set<OmCfg> omCfgs) {
		this.omCfgs = omCfgs;
	}
		
	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrrevisao", nullable = false)
	public OmUsr getOmUsrByIdUsrrevisao() {
		return this.omUsrByIdUsrrevisao;
	}

	@Override	
	public void setOmUsrByIdUsrrevisao(OmUsr omUsrByIdUsrrevisao) {
		this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
	}

	@Override	
	public void setOmUsrByIdUsrstativo(OmUsr omUsrByIdUsrstativo) {
		this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
	}	
	
	@Override
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usrstativo", nullable = false)
	public OmUsr getOmUsrByIdUsrstativo() {
		return this.omUsrByIdUsrstativo;
	}

	@Override
	public Object onCycleDetected(Context arg0) {
		OmCfgabc abc = new OmCfgabc();
		abc.setIdCfgabc(this.idCfgabc);
		return abc;
	}

}

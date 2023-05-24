package idw.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated 05/01/2010 11:04:20 by Hibernate Tools 3.2.4.GA

import idw.model.pojos.template.OmCfgscrpimpTemplate;


/**
 * OmCfgscrpimp generated by hbm2java
 */
@Entity
@Table(name = "om_cfgscrpimp")
public class OmCfgscrpimp extends OmCfgscrpimpTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCfgscrpimp;
	private OmCfg omCfg;
	private String cdScrp;
	private String dsScrp;
	private String scriptimpressao;
	private Long revisao;
	private Byte stativo;

	public OmCfgscrpimp() {
	}

	public OmCfgscrpimp(Long idCfgscrpimp, OmCfg omCfg) {
		this.idCfgscrpimp = idCfgscrpimp;
		this.omCfg = omCfg;
	}

	public OmCfgscrpimp(Long idCfgscrpimp, OmCfg omCfg, String cdScrp,
			String dsScrp, String scriptimpressao, Long revisao, Byte stativo) {
		this.idCfgscrpimp = idCfgscrpimp;
		this.omCfg = omCfg;
		this.cdScrp = cdScrp;
		this.dsScrp = dsScrp;
		this.scriptimpressao = scriptimpressao;
		this.revisao = revisao;
		this.stativo = stativo;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFGSCRPIMP_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFGSCRPIMP_SEQ", sequenceName = "OM_CFGSCRPIMP_SEQ")
	@Column(name = "id_cfgscrpimp", unique = true, nullable = false)
	public Long getIdCfgscrpimp() {
		return this.idCfgscrpimp;
	}

	public void setIdCfgscrpimp(Long idCfgscrpimp) {
		this.idCfgscrpimp = idCfgscrpimp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cfg", nullable = false)
	public OmCfg getOmCfg() {
		return this.omCfg;
	}

	public void setOmCfg(OmCfg omCfg) {
		this.omCfg = omCfg;
	}

	@Column(name = "cd_scrp", length = 30)
	public String getCdScrp() {
		return this.cdScrp;
	}

	public void setCdScrp(String cdScrp) {
		this.cdScrp = cdScrp;
	}

	@Column(name = "ds_scrp", length = 100)
	public String getDsScrp() {
		return this.dsScrp;
	}

	public void setDsScrp(String dsScrp) {
		this.dsScrp = dsScrp;
	}

	@Column(name = "scriptimpressao")
	public String getScriptimpressao() {
		return this.scriptimpressao;
	}

	public void setScriptimpressao(String scriptimpressao) {
		this.scriptimpressao = scriptimpressao;
	}

	@Column(name = "revisao")
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Column(name = "stativo")
	public Byte getStativo() {
		return this.stativo;
	}

	public void setStativo(Byte stativo) {
		this.stativo = stativo;
	}

}

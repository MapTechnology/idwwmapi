package idw.model.pojos;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.xml.bind.CycleRecoverable;

import idw.model.pojos.template.OmCfgabclimTemplate;

// TODO milton 12/02/17 - remover campos em desuso:  limiteSupClasse, limiteInfMeta, limiteSupMeta. Classe e tabela.
// TODO milton 12/02/17 - Renomear campo limiteInfClasse para limiteClasse. Este campo é usado como parametro para definir o tipo da classe. 
@Entity
@Table(name = "om_cfgabclim")
public class OmCfgabclim extends OmCfgabclimTemplate implements java.io.Serializable, CycleRecoverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCfgabclim;
	private OmCfgabc omCfgabc;
	private OmInd omInd;
	private Short classe;
	private BigDecimal limiteInfClasse;
	private BigDecimal limiteSupClasse;//desnecessario
	private BigDecimal limiteInf;
	private BigDecimal limiteSup;
	private BigDecimal limiteInfMeta;//desnecessario
	private BigDecimal limiteSupMeta;//desnecessario
	private String corClasse;

	public OmCfgabclim() {
	}

	public OmCfgabclim(Long idCfgabclim, OmCfgabc omCfgabc, OmInd omInd) {
		this.idCfgabclim = idCfgabclim;
		this.omCfgabc = omCfgabc;
		this.omInd = omInd;
	}

	public OmCfgabclim(Long idCfgabclim, OmCfgabc omCfgabc, OmInd omInd, Short classe, BigDecimal limiteInfClasse,
			BigDecimal limiteSupClasse, BigDecimal limiteInf, BigDecimal limiteSup, BigDecimal limiteInfMeta,
			BigDecimal limiteSupMeta, String corClasse) {
		this.idCfgabclim = idCfgabclim;
		this.omCfgabc = omCfgabc;
		this.omInd = omInd;
		this.classe = classe;
		this.limiteInfClasse = limiteInfClasse;
		this.limiteSupClasse = limiteSupClasse;
		this.limiteInf = limiteInf;
		this.limiteSup = limiteSup;
		this.limiteInfMeta = limiteInfMeta;
		this.limiteSupMeta = limiteSupMeta;
		this.corClasse = corClasse;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_CFGABCLIM_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_CFGABCLIM_SEQ", sequenceName = "OM_CFGABCLIM_SEQ")
	@Column(name = "id_cfgabclim", unique = true, nullable = false)
	public Long getIdCfgabclim() {
		return this.idCfgabclim;
	}

	public void setIdCfgabclim(Long idCfgabclim) {
		this.idCfgabclim = idCfgabclim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cfgabc", nullable = false)
	public OmCfgabc getOmCfgabc() {
		return this.omCfgabc;
	}

	public void setOmCfgabc(OmCfgabc omCfgabc) {
		this.omCfgabc = omCfgabc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ind", nullable = false)
	public OmInd getOmInd() {
		return this.omInd;
	}

	public void setOmInd(OmInd omInd) {
		this.omInd = omInd;
	}

	@Column(name = "classe")
	public Short getClasse() {
		return this.classe;
	}

	public void setClasse(Short classe) {
		this.classe = classe;
	}
	
	@Column(name = "limite_inf_classe", precision = 7, scale = 3)
	public BigDecimal getLimiteInfClasse() {
		return this.limiteInfClasse;
	}

	public void setLimiteInfClasse(BigDecimal limiteInfClasse) {
		this.limiteInfClasse = limiteInfClasse;
	}

	@Column(name = "limite_sup_classe", precision = 7, scale = 3)
	public BigDecimal getLimiteSupClasse() {
		return this.limiteSupClasse;
	}

	public void setLimiteSupClasse(BigDecimal limiteSupClasse) {
		this.limiteSupClasse = limiteSupClasse;
	}

	@Column(name = "limite_inf", precision = 7, scale = 3)
	public BigDecimal getLimiteInf() {
		return this.limiteInf;
	}

	public void setLimiteInf(BigDecimal limiteInf) {
		this.limiteInf = limiteInf;
	}

	@Column(name = "limite_sup", precision = 7, scale = 3)
	public BigDecimal getLimiteSup() {
		return this.limiteSup;
	}

	public void setLimiteSup(BigDecimal limiteSup) {
		this.limiteSup = limiteSup;
	}

	@Column(name = "limite_inf_meta", precision = 7, scale = 3)
	public BigDecimal getLimiteInfMeta() {
		return this.limiteInfMeta;
	}

	public void setLimiteInfMeta(BigDecimal limiteInfMeta) {
		this.limiteInfMeta = limiteInfMeta;
	}

	@Column(name = "limite_sup_meta", precision = 7, scale = 3)
	public BigDecimal getLimiteSupMeta() {
		return this.limiteSupMeta;
	}

	public void setLimiteSupMeta(BigDecimal limiteSupMeta) {
		this.limiteSupMeta = limiteSupMeta;
	}

	@Column(name = "corClasse", length = 11)
	public String getCorClasse() {
		return this.corClasse;
	}

	public void setCorClasse(String corClasse) {
		this.corClasse = corClasse;
	}

	@Override
	public Object onCycleDetected(Context arg0) {
		OmCfgabclim lim = new OmCfgabclim();
		lim.setIdCfgabclim(this.getIdCfgabclim());
		return lim;
	}

}

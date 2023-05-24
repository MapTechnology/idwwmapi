package idw.model.pojos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Generated 18/01/2013 16:12:16 by Hibernate Tools 3.4.0.CR1

import idw.model.pojos.template.MsIndTemplate;

/**
 * MsInd generated by hbm2java
 */
@Entity
@Table(name = "MS_IND")
public class MsInd  extends MsIndTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1949568214194192105L;
	private BigDecimal idInd;
	private String dsInd;
	private String dsCalculo;
	private String dsUnidade;
	private Set<MsTrigger> msTriggers = new HashSet<MsTrigger>(0);

	public MsInd() {
	}

	public MsInd(BigDecimal idInd) {
		this.idInd = idInd;
	}

	public MsInd(BigDecimal idInd, String dsInd, String dsCalculo,
			String dsUnidade, Set<MsTrigger> msTriggers) {
		this.idInd = idInd;
		this.dsInd = dsInd;
		this.dsCalculo = dsCalculo;
		this.dsUnidade = dsUnidade;
		this.msTriggers = msTriggers;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MS_IND_SEQ")
	@javax.persistence.SequenceGenerator(name = "MS_IND_SEQ", sequenceName = "MS_IND_SEQ")
	@Column(name = "ID_IND", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdInd() {
		return this.idInd;
	}

	public void setIdInd(BigDecimal idInd) {
		this.idInd = idInd;
	}

	@Column(name = "DS_IND", length = 100)
	public String getDsInd() {
		return this.dsInd;
	}

	public void setDsInd(String dsInd) {
		this.dsInd = dsInd;
	}

	@Column(name = "DS_CALCULO", length = 256)
	public String getDsCalculo() {
		return this.dsCalculo;
	}

	public void setDsCalculo(String dsCalculo) {
		this.dsCalculo = dsCalculo;
	}

	@Column(name = "DS_UNIDADE", length = 60)
	public String getDsUnidade() {
		return this.dsUnidade;
	}

	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "msInd")
	public Set<MsTrigger> getMsTriggers() {
		return this.msTriggers;
	}

	public void setMsTriggers(Set<MsTrigger> msTriggers) {
		this.msTriggers = msTriggers;
	}

}
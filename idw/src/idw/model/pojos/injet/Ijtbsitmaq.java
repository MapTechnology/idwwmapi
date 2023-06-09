package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ijtbsitmaq generated by hbm2java
 */
@Entity
@Table(name = "IJTBSITMAQ")
public class Ijtbsitmaq implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 272782984467347607L;
	private IjtbsitmaqId id;
	private Ijlinguas ijlinguas;
	private String dssitmaq;
	private String cdcor;
	private String expressao;

	public Ijtbsitmaq() {
	}

	public Ijtbsitmaq(IjtbsitmaqId id, Ijlinguas ijlinguas, String dssitmaq) {
		this.id = id;
		this.ijlinguas = ijlinguas;
		this.dssitmaq = dssitmaq;
	}

	public Ijtbsitmaq(IjtbsitmaqId id, Ijlinguas ijlinguas, String dssitmaq,
			String cdcor, String expressao) {
		this.id = id;
		this.ijlinguas = ijlinguas;
		this.dssitmaq = dssitmaq;
		this.cdcor = cdcor;
		this.expressao = expressao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdsitmaq", column = @Column(name = "CDSITMAQ", nullable = false, length = 6)),
			@AttributeOverride(name = "cdlingua", column = @Column(name = "CDLINGUA", nullable = false, length = 6)) })
	public IjtbsitmaqId getId() {
		return this.id;
	}

	public void setId(IjtbsitmaqId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDLINGUA", nullable = false, insertable = false, updatable = false)
	public Ijlinguas getIjlinguas() {
		return this.ijlinguas;
	}

	public void setIjlinguas(Ijlinguas ijlinguas) {
		this.ijlinguas = ijlinguas;
	}

	@Column(name = "DSSITMAQ", nullable = false, length = 80)
	public String getDssitmaq() {
		return this.dssitmaq;
	}

	public void setDssitmaq(String dssitmaq) {
		this.dssitmaq = dssitmaq;
	}

	@Column(name = "CDCOR", length = 6)
	public String getCdcor() {
		return this.cdcor;
	}

	public void setCdcor(String cdcor) {
		this.cdcor = cdcor;
	}

	@Column(name = "EXPRESSAO")
	public String getExpressao() {
		return this.expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

}

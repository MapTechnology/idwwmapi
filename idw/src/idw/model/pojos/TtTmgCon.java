package idw.model.pojos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.TtTmgConTemplate;

/**
 * TtTmgCon generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TT_TMG_CON")
public class TtTmgCon extends TtTmgConTemplate implements java.io.Serializable {

	private BigDecimal idTmgcon;
	private String conhecimento;
	private String globalcode;
	private BigDecimal qtMaterial;
	private Date dtPrevistaEntrada;
	private Boolean isTransito;
	private Date dthrReferencia;
	private Boolean isImportado;
	private String dsErro;
	private String centro;

	public TtTmgCon() {
	}

	public TtTmgCon(BigDecimal idTmgcon) {
		this.idTmgcon = idTmgcon;
	}

	public TtTmgCon(BigDecimal idTmgcon, String conhecimento,
			String globalcode, BigDecimal qtMaterial, Date dtPrevistaEntrada,
			Boolean isTransito, Date dthrReferencia, Boolean isImportado,
			String dsErro, String centro) {
		this.idTmgcon = idTmgcon;
		this.conhecimento = conhecimento;
		this.globalcode = globalcode;
		this.qtMaterial = qtMaterial;
		this.dtPrevistaEntrada = dtPrevistaEntrada;
		this.isTransito = isTransito;
		this.dthrReferencia = dthrReferencia;
		this.isImportado = isImportado;
		this.dsErro = dsErro;
		this.centro = centro;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "TT_TMG_CON_SEQ")
	@javax.persistence.SequenceGenerator(name = "TT_TMG_CON_SEQ", sequenceName = "TT_TMG_CON_SEQ")
	@Column(name = "ID_TMGCON", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdTmgcon() {
		return this.idTmgcon;
	}

	public void setIdTmgcon(BigDecimal idTmgcon) {
		this.idTmgcon = idTmgcon;
	}

	@Column(name = "CONHECIMENTO", length = 30)
	public String getConhecimento() {
		return this.conhecimento;
	}

	public void setConhecimento(String conhecimento) {
		this.conhecimento = conhecimento;
	}

	@Column(name = "GLOBALCODE", length = 30)
	public String getGlobalcode() {
		return this.globalcode;
	}

	public void setGlobalcode(String globalcode) {
		this.globalcode = globalcode;
	}

	@Column(name = "QT_MATERIAL", precision = 13, scale = 3)
	public BigDecimal getQtMaterial() {
		return this.qtMaterial;
	}

	public void setQtMaterial(BigDecimal qtMaterial) {
		this.qtMaterial = qtMaterial;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_PREVISTA_ENTRADA", length = 7)
	public Date getDtPrevistaEntrada() {
		return this.dtPrevistaEntrada;
	}

	public void setDtPrevistaEntrada(Date dtPrevistaEntrada) {
		this.dtPrevistaEntrada = dtPrevistaEntrada;
	}

	@Column(name = "IS_TRANSITO", precision = 22, scale = 0)
	public Boolean getIsTransito() {
		return this.isTransito;
	}

	public void setIsTransito(Boolean isTransito) {
		this.isTransito = isTransito;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_REFERENCIA", length = 7)
	public Date getDthrReferencia() {
		return this.dthrReferencia;
	}

	public void setDthrReferencia(Date dthrReferencia) {
		this.dthrReferencia = dthrReferencia;
	}

	@Column(name = "IS_IMPORTADO", precision = 22, scale = 0)
	public Boolean getIsImportado() {
		return this.isImportado;
	}

	public void setIsImportado(Boolean isImportado) {
		this.isImportado = isImportado;
	}

	@Column(name = "DS_ERRO", length = 256)
	public String getDsErro() {
		return this.dsErro;
	}

	public void setDsErro(String dsErro) {
		this.dsErro = dsErro;
	}

	@Column(name = "CENTRO", length = 10)
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	
}

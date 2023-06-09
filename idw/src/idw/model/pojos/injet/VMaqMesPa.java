package idw.model.pojos.injet;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import idw.model.pojos.injet.template.VMaqMesPaTemplate;

/**
 * VMaqMesPa generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="v_maq_mes_pa"
	, uniqueConstraints = @UniqueConstraint(columnNames={"ano_referencia", "mes_referencia", "cdturno", "cdinjetora", "cdparada"}) 
)
public class VMaqMesPa extends VMaqMesPaTemplate implements java.io.Serializable {


	private long idMaqMesPa;
	private Long anoReferencia;
	private Long mesReferencia;
	private String cdturno;
	private String cdinjetora;
	private String cdparada;
	private String dsTurno;
	private String dsMaquina;
	private String dsparada;
	private BigDecimal segTempoparada;
	private String paradaPesa;

	public VMaqMesPa() {
	}


	public VMaqMesPa(long idMaqMesPa, String cdturno, String cdinjetora, String cdparada) {
		this.idMaqMesPa = idMaqMesPa;
		this.cdturno = cdturno;
		this.cdinjetora = cdinjetora;
		this.cdparada = cdparada;
	}
	public VMaqMesPa(long idMaqMesPa, Long anoReferencia, Long mesReferencia, String cdturno, String cdinjetora, String cdparada, String dsTurno, String dsMaquina, String dsparada, BigDecimal segTempoparada, String paradaPesa) {
		this.idMaqMesPa = idMaqMesPa;
		this.anoReferencia = anoReferencia;
		this.mesReferencia = mesReferencia;
		this.cdturno = cdturno;
		this.cdinjetora = cdinjetora;
		this.cdparada = cdparada;
		this.dsTurno = dsTurno;
		this.dsMaquina = dsMaquina;
		this.dsparada = dsparada;
		this.segTempoparada = segTempoparada;
		this.paradaPesa = paradaPesa;
	}

	@Id 
	@javax.persistence.GeneratedValue(strategy=GenerationType.AUTO, generator = "VMAQMESPA_SEQ")
	@SequenceGenerator(name = "VMAQMESPA_SEQ", sequenceName = "vmaqmespa_seq")
	@Column(name="id_maq_mes_pa", unique=true, nullable=false)
	public long getIdMaqMesPa() {
		return this.idMaqMesPa;
	}

	public void setIdMaqMesPa(long idMaqMesPa) {
		this.idMaqMesPa = idMaqMesPa;
	}

	@Column(name="ano_referencia")
	public Long getAnoReferencia() {
		return this.anoReferencia;
	}

	public void setAnoReferencia(Long anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	@Column(name="mes_referencia")
	public Long getMesReferencia() {
		return this.mesReferencia;
	}

	public void setMesReferencia(Long mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	@Column(name="cdturno", nullable=false, length=6)
	public String getCdturno() {
		return this.cdturno;
	}

	public void setCdturno(String cdturno) {
		this.cdturno = cdturno;
	}

	@Column(name="cdinjetora", nullable=false, length=6)
	public String getCdinjetora() {
		return this.cdinjetora;
	}

	public void setCdinjetora(String cdinjetora) {
		this.cdinjetora = cdinjetora;
	}

	@Column(name="cdparada", nullable=false, length=6)
	public String getCdparada() {
		return this.cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	@Column(name="dsTurno", length=40)
	public String getDsTurno() {
		return this.dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	@Column(name="dsMaquina", length=40)
	public String getDsMaquina() {
		return this.dsMaquina;
	}

	public void setDsMaquina(String dsMaquina) {
		this.dsMaquina = dsMaquina;
	}

	@Column(name="dsparada", length=40)
	public String getDsparada() {
		return this.dsparada;
	}

	public void setDsparada(String dsparada) {
		this.dsparada = dsparada;
	}

	@Column(name="seg_tempoparada", precision=20, scale=10)
	public BigDecimal getSegTempoparada() {
		return this.segTempoparada;
	}

	public void setSegTempoparada(BigDecimal segTempoparada) {
		this.segTempoparada = segTempoparada;
	}

	@Column(name="paradaPesa", length=6)
	public String getParadaPesa() {
		return this.paradaPesa;
	}

	public void setParadaPesa(String paradaPesa) {
		this.paradaPesa = paradaPesa;
	}




}



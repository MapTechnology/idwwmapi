package idw.model.pojos;
// Generated 04/12/2014 17:29:48 by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.TeTarifasTemplate;

/**
 * TeTarifas generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "te_tarifas")
public class TeTarifas extends TeTarifasTemplate implements java.io.Serializable {

	private long idTarifas;
	private TeTipoConsumidor teTipoConsumidor;
	private TeConcessionaria teConcessionaria;
	private TeLei teLei;
	private Date dtInicioTarifa;
	private Date dtFimTarifa;
	private Set<TeTarifasemanal> teTarifasemanals = new HashSet<TeTarifasemanal>(0);

	public TeTarifas() {
	}

	public TeTarifas(long idTarifas) {
		this.idTarifas = idTarifas;
	}

	public TeTarifas(long idTarifas, TeTipoConsumidor teTipoConsumidor,
			TeConcessionaria teConcessionaria, TeLei teLei,
			Date dtInicioTarifa, Date dtFimTarifa,
			Set<TeTarifasemanal> teTarifasemanals) {
		this.idTarifas = idTarifas;
		this.teTipoConsumidor = teTipoConsumidor;
		this.teConcessionaria = teConcessionaria;
		this.teLei = teLei;
		this.dtInicioTarifa = dtInicioTarifa;
		this.dtFimTarifa = dtFimTarifa;
		this.teTarifasemanals = teTarifasemanals;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "TE_TARIFAS_SEQ")
	@javax.persistence.SequenceGenerator(name = "TE_TARIFAS_SEQ", sequenceName = "TE_TARIFAS_SEQ")
	@Column(name = "id_tarifas", unique = true, nullable = false)
	public long getIdTarifas() {
		return this.idTarifas;
	}

	public void setIdTarifas(long idTarifas) {
		this.idTarifas = idTarifas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_consumidor")
	public TeTipoConsumidor getTeTipoConsumidor() {
		return this.teTipoConsumidor;
	}

	public void setTeTipoConsumidor(TeTipoConsumidor teTipoConsumidor) {
		this.teTipoConsumidor = teTipoConsumidor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_concessionaria")
	public TeConcessionaria getTeConcessionaria() {
		return this.teConcessionaria;
	}

	public void setTeConcessionaria(TeConcessionaria teConcessionaria) {
		this.teConcessionaria = teConcessionaria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lei")
	public TeLei getTeLei() {
		return this.teLei;
	}

	public void setTeLei(TeLei teLei) {
		this.teLei = teLei;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicioTarifa", length = 23)
	public Date getDtInicioTarifa() {
		return this.dtInicioTarifa;
	}

	public void setDtInicioTarifa(Date dtInicioTarifa) {
		this.dtInicioTarifa = dtInicioTarifa;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fimTarifa", length = 23)
	public Date getDtFimTarifa() {
		return this.dtFimTarifa;
	}

	public void setDtFimTarifa(Date dtFimTarifa) {
		this.dtFimTarifa = dtFimTarifa;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teTarifas")
	public Set<TeTarifasemanal> getTeTarifasemanals() {
		return this.teTarifasemanals;
	}

	public void setTeTarifasemanals(Set<TeTarifasemanal> teTarifasemanals) {
		this.teTarifasemanals = teTarifasemanals;
	}

	
}

package idw.model.pojos;
// Generated 28/07/2011 10:26:23 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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

/**
 * OmGarantia generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OM_GARANTIA")
public class OmGarantia implements java.io.Serializable {

	private Long idGarantia;
	private OmContato omContato;
	private String cdGarantia;
	private Long revisao;
	private Date dthrRevisao;
	private Date dthrStativo;
	private Byte stAtivo;
	private String dsGarantia;
	private String docCliente;
	private Date dthrIniciovalidade;
	private Date dthrFimvalidade;
	private BigDecimal vlLicencas;
	private BigDecimal vlContratomanu;
	private Set<OmGarpro> omGarpros = new HashSet<OmGarpro>(0);

	public OmGarantia() {
	}

	public OmGarantia(Long idGarantia) {
		this.idGarantia = idGarantia;
	}

	public OmGarantia(Long idGarantia, OmContato omContato,
			String cdGarantia, Long revisao, Date dthrRevisao,
			Date dthrStativo, Byte stAtivo, String dsGarantia,
			String docCliente, Date dthrIniciovalidade, Date dthrFimvalidade,
			BigDecimal vlLicencas, BigDecimal vlContratomanu,
			Set<OmGarpro> omGarpros) {
		this.idGarantia = idGarantia;
		this.omContato = omContato;
		this.cdGarantia = cdGarantia;
		this.revisao = revisao;
		this.dthrRevisao = dthrRevisao;
		this.dthrStativo = dthrStativo;
		this.stAtivo = stAtivo;
		this.dsGarantia = dsGarantia;
		this.docCliente = docCliente;
		this.dthrIniciovalidade = dthrIniciovalidade;
		this.dthrFimvalidade = dthrFimvalidade;
		this.vlLicencas = vlLicencas;
		this.vlContratomanu = vlContratomanu;
		this.omGarpros = omGarpros;
	}

	@Id
	@Column(name = "ID_GARANTIA", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdGarantia() {
		return this.idGarantia;
	}

	public void setIdGarantia(Long idGarantia) {
		this.idGarantia = idGarantia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTATO")
	public OmContato getOmContato() {
		return this.omContato;
	}

	public void setOmContato(OmContato omContato) {
		this.omContato = omContato;
	}

	@Column(name = "CD_GARANTIA", length = 30)
	public String getCdGarantia() {
		return this.cdGarantia;
	}

	public void setCdGarantia(String cdGarantia) {
		this.cdGarantia = cdGarantia;
	}

	@Column(name = "REVISAO", precision = 63, scale = 0)
	public Long getRevisao() {
		return this.revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_REVISAO", length = 7)
	public Date getDthrRevisao() {
		return this.dthrRevisao;
	}

	public void setDthrRevisao(Date dthrRevisao) {
		this.dthrRevisao = dthrRevisao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_STATIVO", length = 7)
	public Date getDthrStativo() {
		return this.dthrStativo;
	}

	public void setDthrStativo(Date dthrStativo) {
		this.dthrStativo = dthrStativo;
	}

	@Column(name = "ST_ATIVO", length = 1)
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "DS_GARANTIA", length = 256)
	public String getDsGarantia() {
		return this.dsGarantia;
	}

	public void setDsGarantia(String dsGarantia) {
		this.dsGarantia = dsGarantia;
	}

	@Column(name = "DOC_CLIENTE", length = 10)
	public String getDocCliente() {
		return this.docCliente;
	}

	public void setDocCliente(String docCliente) {
		this.docCliente = docCliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_INICIOVALIDADE", length = 7)
	public Date getDthrIniciovalidade() {
		return this.dthrIniciovalidade;
	}

	public void setDthrIniciovalidade(Date dthrIniciovalidade) {
		this.dthrIniciovalidade = dthrIniciovalidade;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTHR_FIMVALIDADE", length = 7)
	public Date getDthrFimvalidade() {
		return this.dthrFimvalidade;
	}

	public void setDthrFimvalidade(Date dthrFimvalidade) {
		this.dthrFimvalidade = dthrFimvalidade;
	}

	@Column(name = "VL_LICENCAS", precision = 22, scale = 0)
	public BigDecimal getVlLicencas() {
		return this.vlLicencas;
	}

	public void setVlLicencas(BigDecimal vlLicencas) {
		this.vlLicencas = vlLicencas;
	}

	@Column(name = "VL_CONTRATOMANU", precision = 22, scale = 0)
	public BigDecimal getVlContratomanu() {
		return this.vlContratomanu;
	}

	public void setVlContratomanu(BigDecimal vlContratomanu) {
		this.vlContratomanu = vlContratomanu;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "omGarantia")
	public Set<OmGarpro> getOmGarpros() {
		return this.omGarpros;
	}

	public void setOmGarpros(Set<OmGarpro> omGarpros) {
		this.omGarpros = omGarpros;
	}

}

package idw.model.pojos;

import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

import idw.model.pojos.template.DwEstlocalproTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "dw_estlocalpro", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_estpro", "id_estlocal", "id_cp" }))
public class DwEstlocalpro extends DwEstlocalproTemplate implements java.io.Serializable {

	private long idEstlocalpro;
	private DwEstlocal dwEstlocal;
	private DwEstpro dwEstpro;
	private PpCp ppCp;
	private BigDecimal qtEntrada;
	private BigDecimal qtSaida;
	private BigDecimal qtAjuste;
	private BigDecimal qtTotal;
	
	private Set<DwDesalimpendcontag> dwDesalimpendcontags = new HashSet<DwDesalimpendcontag>(0);
	private Set<DwConsolestlocalpro> dwConsolestlocalpros = new HashSet<DwConsolestlocalpro>(0);
	
	public DwEstlocalpro() {
	}

	public DwEstlocalpro(long idEstlocalpro) {
		this.idEstlocalpro = idEstlocalpro;
	}

	public DwEstlocalpro(long idEstlocalpro, DwEstlocal dwEstlocal,
			DwEstpro dwEstpro, PpCp ppCp, BigDecimal qtEntrada,
			BigDecimal qtSaida, BigDecimal qtAjuste, BigDecimal qtTotal) {
		this.idEstlocalpro = idEstlocalpro;
		this.dwEstlocal = dwEstlocal;
		this.dwEstpro = dwEstpro;
		this.ppCp = ppCp;
		this.qtEntrada = qtEntrada;
		this.qtSaida = qtSaida;
		this.qtAjuste = qtAjuste;
		this.qtTotal = qtTotal;

	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_ESTLOCALPRO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_ESTLOCALPRO_SEQ", sequenceName = "DW_ESTLOCALPRO_SEQ")
	@Column(name = "id_estlocalpro", unique = true, nullable = false)	
	public long getIdEstlocalpro() {
		return this.idEstlocalpro;
	}

	public void setIdEstlocalpro(long idEstlocalpro) {
		this.idEstlocalpro = idEstlocalpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocal")
	public DwEstlocal getDwEstlocal() {
		return this.dwEstlocal;
	}

	public void setDwEstlocal(DwEstlocal dwEstlocal) {
		this.dwEstlocal = dwEstlocal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estpro")
	public DwEstpro getDwEstpro() {
		return this.dwEstpro;
	}

	public void setDwEstpro(DwEstpro dwEstpro) {
		this.dwEstpro = dwEstpro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cp")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}

	@Column(name = "qt_entrada", precision = 14, scale = 4)
	public BigDecimal getQtEntrada() {
		return this.qtEntrada;
	}

	public void setQtEntrada(BigDecimal qtEntrada) {
		this.qtEntrada = qtEntrada;
	}

	@Column(name = "qt_saida", precision = 14, scale = 4)
	public BigDecimal getQtSaida() {
		return this.qtSaida;
	}

	public void setQtSaida(BigDecimal qtSaida) {
		this.qtSaida = qtSaida;
	}

	@Column(name = "qt_ajuste", precision = 14, scale = 4)
	public BigDecimal getQtAjuste() {
		return this.qtAjuste;
	}

	public void setQtAjuste(BigDecimal qtAjuste) {
		this.qtAjuste = qtAjuste;
	}

	@Column(name = "qt_total", precision = 14, scale = 4)
	public BigDecimal getQtTotal() {
		return this.qtTotal;
	}

	public void setQtTotal(BigDecimal qtTotal) {
		this.qtTotal = qtTotal;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwEstlocalpro")
	public Set<DwDesalimpendcontag> getDwDesalimpendcontags() {
		return this.dwDesalimpendcontags;
	}

	public void setDwDesalimpendcontags(Set<DwDesalimpendcontag> dwDesalimpendcontags) {
		this.dwDesalimpendcontags = dwDesalimpendcontags;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwEstlocalpro")
	public Set<DwConsolestlocalpro> getDwConsolestlocalpros() {
		return this.dwConsolestlocalpros;
	}

	public void setDwConsolestlocalpros(Set<DwConsolestlocalpro> dwConsolestlocalpros) {
		this.dwConsolestlocalpros = dwConsolestlocalpros;
	}

}

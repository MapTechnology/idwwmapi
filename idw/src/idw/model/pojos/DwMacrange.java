package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import idw.model.pojos.template.DwMacrangeTemplate;

@Entity
@Table(name = "DW_MACRANGE")
public class DwMacrange extends DwMacrangeTemplate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idMacrange;
	private String cdMacInicial;
	private String cdMacFinal;
	private OmUsr omUsr;
	private OmGt omGt;
	private String cdModelo;
	private int qtPorpeca;
	private int tpRegra;
	private int stMacrange;
	private Date dthrCadastro;
	private String cdUltimomacusado;
	private Date dthrUltimomacusado;
	
	private DwMacrange dwMacrangepai;
	
	public DwMacrange() {
		
	}
	
	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "DW_MACRANGE_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_MACRANGE_SEQ", sequenceName = "DW_MACRANGE_SEQ")
	@Column(name = "ID_MACRANGE", unique = true, nullable = false, precision = 63, scale = 0)	
	public Long getIdMacrange() {
		return idMacrange;
	}
	public void setIdMacrange(Long idMacrange) {
		this.idMacrange = idMacrange;
	}
	
	@Column(name = "CD_MACINICIAL", length = 12)
	public String getCdMacInicial() {
		return cdMacInicial;
	}
	public void setCdMacInicial(String cdMacInicial) {
		this.cdMacInicial = cdMacInicial;
	}
	
	@Column(name = "CD_MACFINAL", length = 12)
	public String getCdMacFinal() {
		return cdMacFinal;
	}
	public void setCdMacFinal(String cdMacFinal) {
		this.cdMacFinal = cdMacFinal;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USR", nullable = true)
	public OmUsr getOmUsr() {
		return omUsr;
	}
	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GT", nullable = true)
	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	
	@Column(name = "CD_MODELO", length = 30)
	public String getCdModelo() {
		return cdModelo;
	}
	public void setCdModelo(String cdModelo) {
		this.cdModelo = cdModelo;
	}
	
	@Column(name = "QT_PORPECA", precision = 22, scale = 0)
	public int getQtPorpeca() {
		return qtPorpeca;
	}
	public void setQtPorpeca(int qtPorpeca) {
		this.qtPorpeca = qtPorpeca;
	}
	
	@Column(name = "TP_REGRA", precision = 22, scale = 0)
	public int getTpRegra() {
		return tpRegra;
	}
	public void setTpRegra(int tpRegra) {
		this.tpRegra = tpRegra;
	}
	@Column(name = "ST_MACRANGE", precision = 22, scale = 0)
	public int getStMacrange() {
		return stMacrange;
	}
	public void setStMacrange(int stMacrange) {
		this.stMacrange = stMacrange;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_CADASTRO")	
	public Date getDthrCadastro() {
		return dthrCadastro;
	}
	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}
	
	@Column(name = "CD_ULTIMOMACUSADO", length = 12)
	public String getCdUltimomacusado() {
		return cdUltimomacusado;
	}
	public void setCdUltimomacusado(String cdUltimomacusado) {
		this.cdUltimomacusado = cdUltimomacusado;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_ULTIMOMACUSADO")
	public Date getDthrUltimomacusado() {
		return dthrUltimomacusado;
	}
	public void setDthrUltimomacusado(Date dthrUltimomacusado) {
		this.dthrUltimomacusado = dthrUltimomacusado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_macrangepai")
	public DwMacrange getDwMacrangepai() {
		return dwMacrangepai;
	}

	public void setDwMacrangepai(DwMacrange dwMacrangepai) {
		this.dwMacrangepai = dwMacrangepai;
	}
}

package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import idw.model.pojos.template.QqFolhainsftTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_FOLHAINSFT")
public class QqFolhainsft extends QqFolhainsftTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFolhainsft;
	private BigDecimal minimo;
	private BigDecimal meta;
	private BigDecimal maximo;
	
	private Integer st;
	
	private QqFolhaInsAtiv qqFolhaInsAtiv;
	private DwFtParam dwFtParam;
	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_FOLHAINSFT_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_FOLHAINSFT_SEQ", sequenceName = "QQ_FOLHAINSFT_SEQ")
	@Column(name = "id_folhainsft", unique = true, nullable = false)
	public Long getIdFolhainsft() {
		return idFolhainsft;
	}
	public void setIdFolhainsft(Long idFolhainsft) {
		this.idFolhainsft = idFolhainsft;
	}
	
	@Column(name = "MINIMO")
	public BigDecimal getMinimo() {
		return minimo;
	}
	public void setMinimo(BigDecimal minimo) {
		this.minimo = minimo;
	}
	
	@Column(name = "META")
	public BigDecimal getMeta() {
		return meta;
	}
	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}
	
	@Column(name = "MAXIMO")
	public BigDecimal getMaximo() {
		return maximo;
	}
	public void setMaximo(BigDecimal maximo) {
		this.maximo = maximo;
	}

	@Column(name = "ST")
	public Integer getSt() {
		return st;
	}
	public void setSt(Integer st) {
		this.st = st;
	}
	
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHAINSATIV")
	public QqFolhaInsAtiv getQqFolhaInsAtiv() {
		return qqFolhaInsAtiv;
	}
	public void setQqFolhaInsAtiv(QqFolhaInsAtiv qqFolhaInsAtiv) {
		this.qqFolhaInsAtiv = qqFolhaInsAtiv;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FT_PARAM")
	public DwFtParam getDwFtParam() {
		return dwFtParam;
	}
	public void setDwFtParam(DwFtParam dwFtParam) {
		this.dwFtParam = dwFtParam;
	}
}

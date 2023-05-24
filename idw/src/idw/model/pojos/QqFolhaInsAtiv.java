package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.QqFolhaInsAtivTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_FOLHA_INS_ATIV")
public class QqFolhaInsAtiv extends QqFolhaInsAtivTemplate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idFolhainsativ;
	private Integer ordem;
	private String dsFolhainsativ;
	private BigDecimal segDuracaoesperada;

	// FK
	private QqFolhaInsRap qqFolhaInsRap;

	
	// Dependentes
	private Set<QqFolhaInsMed> qqFolhaInsMeds = new HashSet<QqFolhaInsMed>(0);
	private Set<QqFolhainsft> qqFolhainsfts = new HashSet<QqFolhainsft>(0);
	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_FOLHAINSFT_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_FOLHAINSFT_SEQ", sequenceName = "QQ_FOLHAINSFT_SEQ")
	@Column(name = "ID_FOLHAINSATIV", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdFolhainsativ() {
		return idFolhainsativ;
	}

	public void setIdFolhainsativ(Long idFolhainsativ) {
		this.idFolhainsativ = idFolhainsativ;
	}

	@Column(name = "ORDEM")
	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Column(name = "DS_FOLHAINSATIV", length = 256)
	public String getDsFolhainsativ() {
		return dsFolhainsativ;
	}

	public void setDsFolhainsativ(String dsFolhainsativ) {
		this.dsFolhainsativ = dsFolhainsativ;
	}

	@Column(name = "SEG_DURACAOESPERADA")
	public BigDecimal getSegDuracaoesperada() {
		return segDuracaoesperada;
	}

	public void setSegDuracaoesperada(BigDecimal segDuracaoesperada) {
		this.segDuracaoesperada = segDuracaoesperada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHAINSRAP")
	public QqFolhaInsRap getQqFolhaInsRap() {
		return qqFolhaInsRap;
	}

	public void setQqFolhaInsRap(QqFolhaInsRap qqFolhaInsRap) {
		this.qqFolhaInsRap = qqFolhaInsRap;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqFolhaInsAtiv")
	public Set<QqFolhaInsMed> getQqFolhaInsMeds() {
		return qqFolhaInsMeds;
	}

	public void setQqFolhaInsMeds(Set<QqFolhaInsMed> qqFolhaInsMeds) {
		this.qqFolhaInsMeds = qqFolhaInsMeds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qqFolhaInsAtiv")
	public Set<QqFolhainsft> getQqFolhainsfts() {
		return qqFolhainsfts;
	}

	public void setQqFolhainsfts(Set<QqFolhainsft> qqFolhainsfts) {
		this.qqFolhainsfts = qqFolhainsfts;
	}
	
	
}

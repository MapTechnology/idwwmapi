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

import idw.model.pojos.template.QqInsrapFtTemplate;

@XmlRootElement
@Entity
@Table(name = "QQ_INSRAP_FT")
public class QqInsrapFt extends QqInsrapFtTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idInsrapft;
	private BigDecimal vlMedido;
	private Byte stMedido;
	
	private QqInsRap qqInsRap;
	private QqFolhainsft qqFolhainsft;
	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_INSRAP_FT_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_INSRAP_FT_SEQ", sequenceName = "QQ_INSRAP_FT_SEQ")
	@Column(name = "ID_INSRAPFT", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdInsrapft() {
		return idInsrapft;
	}
	public void setIdInsrapft(Long idInsrapft) {
		this.idInsrapft = idInsrapft;
	}
	
	@Column(name = "VL_MEDIDO")
	public BigDecimal getVlMedido() {
		return vlMedido;
	}
	public void setVlMedido(BigDecimal vl_medido) {
		this.vlMedido = vl_medido;
	}
	@Column(name = "ST_MEDIDO")
	public Byte getStMedido() {
		return stMedido;
	}
	public void setStMedido(Byte st_medido) {
		this.stMedido = st_medido;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INS_RAP", nullable = false)
	public QqInsRap getQqInsRap() {
		return qqInsRap;
	}
	public void setQqInsRap(QqInsRap qqInsRap) {
		this.qqInsRap = qqInsRap;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHAINSFT", nullable = false)
	public QqFolhainsft getQqFolhainsft() {
		return qqFolhainsft;
	}
	public void setQqFolhainsft(QqFolhainsft qqFolhainsft) {
		this.qqFolhainsft = qqFolhainsft;
	}
}

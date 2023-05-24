package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.QqRoteiroPreTemplate;

@Entity
@Table(name = "qq_roteiro_pre")
public class QqRoteiroPre extends QqRoteiroPreTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idRoteiropre;
	
	private QqRoteiroMov qqRoteiroMov;
	private QqRoteiroMov qqRoteiroMovpre;
	
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "QQ_ROTEIRO_PRE_SEQ")
	@javax.persistence.SequenceGenerator(name = "QQ_ROTEIRO_PRE_SEQ", sequenceName = "QQ_ROTEIRO_PRE_SEQ")
	@Column(name = "id_roteiropre", unique = true, nullable = false)
	public Long getIdRoteiropre() {
		return idRoteiropre;
	}
	public void setIdRoteiropre(Long idRoteiropre) {
		this.idRoteiropre = idRoteiropre;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_roteiromov", nullable = false)
	public QqRoteiroMov getQqRoteiroMov() {
		return qqRoteiroMov;
	}
	public void setQqRoteiroMov(QqRoteiroMov qqRoteiroMov) {
		this.qqRoteiroMov = qqRoteiroMov;
	}

	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_roteiromov_pre", nullable = false)
	public QqRoteiroMov getQqRoteiroMovpre() {
		return qqRoteiroMovpre;
	}
	public void setQqRoteiroMovpre(QqRoteiroMov qqRoteiroMovpre) {
		this.qqRoteiroMovpre = qqRoteiroMovpre;
	}
	
	
}

package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.MmOsInsRapTemplate;

@XmlRootElement
@Entity
@Table(name = "MM_OS_INS_RAP")
public class MmOsInsRap  extends MmOsInsRapTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idOsinsrap;
	
	private DwRap dwRap;
	private DwEstmovRap dwEstmovRap;
	private QqFolhaInsRap qqFolhaInsRap;
	
	private MmOs mmOs;
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "MM_OS_INS_RAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "MM_OS_INS_RAP_SEQ", sequenceName = "MM_OS_INS_RAP_SEQ")
	@Column(name = "ID_OSINSRAP", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdOsinsrap() {
		return idOsinsrap;
	}
	public void setIdOsinsrap(Long idOs) {
		this.idOsinsrap = idOs;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RAP", nullable = false)
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTMOVRAP", nullable = false)
	public DwEstmovRap getDwEstmovRap() {
		return dwEstmovRap;
	}
	public void setDwEstmovRap(DwEstmovRap dwEstmovRap) {
		this.dwEstmovRap = dwEstmovRap;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOLHAINSRAP", nullable = false)
	public QqFolhaInsRap getQqFolhaInsRap() {
		return qqFolhaInsRap;
	}
	public void setQqFolhaInsRap(QqFolhaInsRap qqFolhaInsRap) {
		this.qqFolhaInsRap = qqFolhaInsRap;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OS", nullable = false)
	public MmOs getMmOs() {
		return mmOs;
	}
	public void setMmOs(MmOs mmOs) {
		this.mmOs = mmOs;
	}


}

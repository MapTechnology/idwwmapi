package idw.model.pojos;

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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("serial")
@Entity
@Table(name = "PP_CPENTSAI")
public class PpCpentsai implements java.io.Serializable {

	private Long idCpentsai;
	private PpCp ppCp;
	private OmPt omPt;
	private Date dthrInicio;
	private Date dthrFim;

	public PpCpentsai() {
	}

	public PpCpentsai(Long idCpentsai, PpCp ppCp, OmPt omPt, Date dthrInicio, Date dthrFim) {
		this.idCpentsai = idCpentsai;
		this.ppCp = ppCp;
		this.omPt = omPt;
		this.dthrInicio = dthrInicio;
		this.dthrFim = dthrFim;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "PP_CPENTSAI_SEQ")
	@javax.persistence.SequenceGenerator(name = "PP_CPENTSAI_SEQ", sequenceName = "PP_CPENTSAI_SEQ")
	@Column(name = "ID_CPENTSAI", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdCpentsai() {
		return this.idCpentsai;
	}

	public void setIdCpentsai(Long idCpentsai) {
		this.idCpentsai = idCpentsai;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP")
	public PpCp getPpCp() {
		return this.ppCp;
	}

	public void setPpCp(PpCp ppCp) {
		this.ppCp = ppCp;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT", nullable = true)
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_FIM")
	public Date getDthrFim() {
		return this.dthrFim;
	}

	public void setDthrFim(Date dthrFim) {
		this.dthrFim = dthrFim;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_INICIO")
	public Date getDthrInicio() {
		return this.dthrInicio;
	}

	public void setDthrInicio(Date dthrInicio) {
		this.dthrInicio = dthrInicio;
	}

}

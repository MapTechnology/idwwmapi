package idw.model.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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

import idw.model.pojos.template.DwDesalimpendcontagTemplate;

@SuppressWarnings("serial")
@Entity
@Table(name = "dw_desalimpendcontag")
public class DwDesalimpendcontag extends DwDesalimpendcontagTemplate implements Serializable {

	private long idDesalimpendcontag;
	private DwEstlocalpro dwEstlocalpro;
	private Date dthrDesalim;
	private BigDecimal qtDesalim;

	public DwDesalimpendcontag() {
	}

	public DwDesalimpendcontag(long idDesalimpendcontag, Date dthrDesalim, BigDecimal qtDesalim) {
		this.idDesalimpendcontag = idDesalimpendcontag;
		this.dthrDesalim = dthrDesalim;
		this.qtDesalim = qtDesalim;
	}

	public DwDesalimpendcontag(long idDesalimpendcontag, DwEstlocalpro dwEstlocalpro, Date dthrDesalim, 
			BigDecimal qtDesalim) {
		this.idDesalimpendcontag = idDesalimpendcontag;
		this.dwEstlocalpro = dwEstlocalpro;
		this.dthrDesalim = dthrDesalim;
		this.qtDesalim = qtDesalim;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_DESALIMPENDCONTAG_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_DESALIMPENDCONTAG_SEQ", sequenceName = "DW_DESALIMPENDCONTAG_SEQ")
	@Column(name = "id_desalimpendcontag", unique = true, nullable = false)
	public long getIdDesalimpendcontag() {
		return this.idDesalimpendcontag;
	}

	public void setIdDesalimpendcontag(long idDesalimpendcontag) {
		this.idDesalimpendcontag = idDesalimpendcontag;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocalpro")
	public DwEstlocalpro getDwEstlocalpro() {
		return this.dwEstlocalpro;
	}

	public void setDwEstlocalpro(DwEstlocalpro dwEstlocalpro) {
		this.dwEstlocalpro = dwEstlocalpro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_desalim", nullable = false, length = 23)
	public Date getDthrDesalim() {
		return this.dthrDesalim;
	}

	public void setDthrDesalim(Date dthrDesalim) {
		this.dthrDesalim = dthrDesalim;
	}

	@Column(name = "qt_desalim", nullable = false, precision = 14, scale = 4)
	public BigDecimal getQtDesalim() {
		return this.qtDesalim;
	}

	public void setQtDesalim(BigDecimal qtDesalim) {
		this.qtDesalim = qtDesalim;
	}

}

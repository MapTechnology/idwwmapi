package idw.model.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.DwConsolreocoTemplate;

/**
 * DwConsolreoco generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "DW_CONSOLREOCO")
public class DwConsolreoco extends DwConsolreocoTemplate implements java.io.Serializable {

	private long idConsolreoco;
	private DwConsolrelog dwConsolrelog;
	private DwConsolre dwConsolre;

	public DwConsolreoco() {
	}

	public DwConsolreoco(long idConsolreoco) {
		this.idConsolreoco = idConsolreoco;
	}

	public DwConsolreoco(long idConsolreoco, DwConsolrelog dwConsolrelog,
			DwConsolre dwConsolre) {
		this.idConsolreoco = idConsolreoco;
		this.dwConsolrelog = dwConsolrelog;
		this.dwConsolre = dwConsolre;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLREOCO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLREOCO_SEQ", sequenceName = "DW_CONSOLREOCO_SEQ")
	@Column(name = "ID_CONSOLREOCO", unique = true, nullable = false)
	public long getIdConsolreoco() {
		return this.idConsolreoco;
	}

	public void setIdConsolreoco(long idConsolreoco) {
		this.idConsolreoco = idConsolreoco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONSOLRELOG")
	public DwConsolrelog getDwConsolrelog() {
		return this.dwConsolrelog;
	}

	public void setDwConsolrelog(DwConsolrelog dwConsolrelog) {
		this.dwConsolrelog = dwConsolrelog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONSOLRE")
	public DwConsolre getDwConsolre() {
		return this.dwConsolre;
	}

	public void setDwConsolre(DwConsolre dwConsolre) {
		this.dwConsolre = dwConsolre;
	}

}
package idw.model.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.DwConsolpalogtecTemplate;

@Entity
@Table(name = "DW_CONSOLPALOGTEC")
public class DwConsolpalogtec extends DwConsolpalogtecTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 806871003684735147L;
	private Long idConsolpalogtec;
	private DwConsolpalog dwConsolpalog;
	private OmUsr omUsr;
	
	private Byte tpUsuario;

	public DwConsolpalogtec() {
	}

	public DwConsolpalogtec(Long idConsolpalogtec) {
		this.idConsolpalogtec = idConsolpalogtec;
	}

	public DwConsolpalogtec(Long idConsolpalogtec,
			DwConsolpalog dwConsolpalog, OmUsr omUsr) {
		this.idConsolpalogtec = idConsolpalogtec;
		this.dwConsolpalog = dwConsolpalog;
		this.omUsr = omUsr;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_CONSOLPALOGTEC_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_CONSOLPALOGTEC_SEQ", sequenceName = "DW_CONSOLPALOGTEC_SEQ")			
	@Column(name = "ID_CONSOLPALOGTEC", unique = true, nullable = false, precision = 63, scale = 0)
	public Long getIdConsolpalogtec() {
		return this.idConsolpalogtec;
	}

	public void setIdConsolpalogtec(Long idConsolpalogtec) {
		this.idConsolpalogtec = idConsolpalogtec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONSOLPALOG")
	public DwConsolpalog getDwConsolpalog() {
		return this.dwConsolpalog;
	}

	public void setDwConsolpalog(DwConsolpalog dwConsolpalog) {
		this.dwConsolpalog = dwConsolpalog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USR")
	public OmUsr getOmUsr() {
		return this.omUsr;
	}

	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}

	@Column(name = "tp_usuario", nullable = false)
	public Byte getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(Byte tp) {
		this.tpUsuario = tp;
	}
}

package idw.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import idw.model.pojos.template.DwGfEmailTemplate;

@Entity
@Table(name = "dw_gf_email")
public class DwGfEmail extends DwGfEmailTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idGfemail;
	
	private OmUsr omUsr;
	private DwGfTpos dwGfTpos;
	
	
	public DwGfEmail() {
		super();
	}
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_GF_EMAIL_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_GF_EMAIL_SEQ", sequenceName = "DW_GF_EMAIL_SEQ")
	@Column(name = "id_gfemail", unique = true, nullable = false)
	public Long getIdGfemail() {
		return idGfemail;
	}
	public void setIdGfemail(Long idGfEmail) {
		this.idGfemail = idGfEmail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr", nullable = false)
	public OmUsr getOmUsr() {
		return omUsr;
	}
	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gftpos", nullable = false)
	public DwGfTpos getDwGfTpos() {
		return dwGfTpos;
	}
	public void setDwGfTpos(DwGfTpos dwGfTpos) {
		this.dwGfTpos = dwGfTpos;
	}
	
	
}

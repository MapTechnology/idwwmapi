package idw.model.pojos;

import java.io.Serializable;
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

import idw.model.pojos.template.DwMacusoTemplate;

@Entity
@Table(name = "DW_MACUSO")
public class DwMacuso extends DwMacusoTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idMacuso;
	private String cdMac;
	private Date dthrUso;
	private Integer grupo;
	
	private DwMacrange dwMacrange;

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "DW_MACUSO_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_MACUSO_SEQ", sequenceName = "DW_MACUSO_SEQ")
	@Column(name = "ID_MACUSO", unique = true, nullable = false, precision = 63, scale = 0)	
	public Long getIdMacuso() {
		return idMacuso;
	}
	public void setIdMacuso(Long idMacuso) {
		this.idMacuso = idMacuso;
	}
	
	@Column(name = "CD_MAC", length = 12)
	public String getCdMac() {
		return cdMac;
	}
	public void setCdMac(String cdMac) {
		this.cdMac = cdMac;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_USO")	
	public Date getDthrUso() {
		return dthrUso;
	}
	public void setDthrUso(Date dthrUso) {
		this.dthrUso = dthrUso;
	}

	
	@Column(name = "GRUPO", precision = 22, scale = 0)
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_macrange")
	public DwMacrange getDwMacrange() {
		return dwMacrange;
	}
	public void setDwMacrange(DwMacrange dwMacrange) {
		this.dwMacrange = dwMacrange;
	}
}
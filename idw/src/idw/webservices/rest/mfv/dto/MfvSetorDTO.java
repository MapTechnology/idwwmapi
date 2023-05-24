package idw.webservices.rest.mfv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="mfvSetor")
public class MfvSetorDTO implements Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;

	private BigDecimal idsetor;
	private Long idgt;
	private String cdsetor;
	private String dssetor;
	private BigDecimal tpsetor;
	private BigDecimal ordem;
	private BigDecimal leadtime;
	private BigDecimal cicletime;
	private BigDecimal percoee;
	
	public MfvSetorDTO(BigDecimal idsetor, Long idgt, String cdsetor, String dssetor, BigDecimal tpsetor, BigDecimal ordem,
			BigDecimal leadtime, BigDecimal cicletime, BigDecimal percoee) {
		super();
		this.idsetor = idsetor;
		this.idgt = idgt;
		this.cdsetor = cdsetor;
		this.dssetor = dssetor;
		this.tpsetor = tpsetor;
		this.ordem = ordem;
		this.leadtime = leadtime;
		this.cicletime = cicletime;
		this.percoee = percoee;
	}
	
	
	public BigDecimal getIdsetor() {
		return idsetor;
	}
	public void setIdsetor(BigDecimal idsetor) {
		this.idsetor = idsetor;
	}
	public Long getIdgt() {
		return idgt;
	}
	public void setIdgt(Long idgt) {
		this.idgt = idgt;
	}
	public String getCdsetor() {
		return cdsetor;
	}
	public void setCdsetor(String cdsetor) {
		this.cdsetor = cdsetor;
	}
	public String getDssetor() {
		return dssetor;
	}
	public void setDssetor(String dssetor) {
		this.dssetor = dssetor;
	}
	public BigDecimal getTpsetor() {
		return tpsetor;
	}
	public void setTpsetor(BigDecimal tpsetor) {
		this.tpsetor = tpsetor;
	}
	public BigDecimal getOrdem() {
		return ordem;
	}
	public void setOrdem(BigDecimal ordem) {
		this.ordem = ordem;
	}
	public BigDecimal getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(BigDecimal leadtime) {
		this.leadtime = leadtime;
	}
	public BigDecimal getCicletime() {
		return cicletime;
	}
	public void setCicletime(BigDecimal cicletime) {
		this.cicletime = cicletime;
	}
	public BigDecimal getPercoee() {
		return percoee;
	}
	public void setPercoee(BigDecimal percoee) {
		this.percoee = percoee;
	}


}

package idw.webservices.rest.mfv.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="mfvCausaEfeito")
public class CausaEfeitoDTO implements Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	private BigDecimal idCatcausa;
	private String dsCatcausa;
	private BigDecimal idCausaefeito;
	private BigDecimal idCausaefeitopai;
	private BigDecimal idCausapai;
	private String dsCausapai;
	private BigDecimal idCausa;
	private String dsCausa;
	/**
	 * 
	 */
	private BigDecimal idProblema;
	
	

	public CausaEfeitoDTO
	(
			BigDecimal idProblema,
			BigDecimal idCatcausa,
			String dsCatcausa,
			BigDecimal idCausaefeito,
			BigDecimal idCausaefeitopai,
			BigDecimal idCausapai,
			String dsCausapai,
			BigDecimal idCausa,
			String dsCausa
	)
	{
		this.idProblema = idProblema;
		this.idCatcausa = idCatcausa;
		this.dsCatcausa = dsCatcausa;
		this.idCausaefeito = idCausaefeito;
		this.idCausaefeitopai = idCausaefeitopai;
		this.idCausapai = idCausapai;
		this.dsCausapai = dsCausapai;
		this.idCausa = idCausa;
		this.dsCausa = dsCausa;
	}
	

	public CausaEfeitoDTO
	(
			
			BigDecimal idCatcausa,
			String dsCatcausa,
			BigDecimal idCausaefeito,
			BigDecimal idCausaefeitopai,
			BigDecimal idCausapai,
			String dsCausapai,
			BigDecimal idCausa,
			String dsCausa
	)
	{
		this.idCatcausa = idCatcausa;
		this.dsCatcausa = dsCatcausa;
		this.idCausaefeito = idCausaefeito;
		this.idCausaefeitopai = idCausaefeitopai;
		this.idCausapai = idCausapai;
		this.dsCausapai = dsCausapai;
		this.idCausa = idCausa;
		this.dsCausa = dsCausa;
	}
	
	public BigDecimal getIdCatcausa() {
		return idCatcausa;
	}
	public void setIdCatcausa(BigDecimal idCatcausa) {
		this.idCatcausa = idCatcausa;
	}
	public String getDsCatcausa() {
		return dsCatcausa;
	}
	public void setDsCatcausa(String dsCatcausa) {
		this.dsCatcausa = dsCatcausa;
	}
	public BigDecimal getIdCausaefeito() {
		return idCausaefeito;
	}
	public void setIdCausaefeito(BigDecimal idCausaefeito) {
		this.idCausaefeito = idCausaefeito;
	}
	public BigDecimal getIdCausaefeitopai() {
		return idCausaefeitopai;
	}
	public void setIdCausaefeitopai(BigDecimal idCausaefeitopai) {
		this.idCausaefeitopai = idCausaefeitopai;
	}
	public BigDecimal getIdCausapai() {
		return idCausapai;
	}
	public void setIdCausapai(BigDecimal idCausapai) {
		this.idCausapai = idCausapai;
	}
	public String getDsCausapai() {
		return dsCausapai;
	}
	public void setDsCausapai(String dsCausapai) {
		this.dsCausapai = dsCausapai;
	}
	public BigDecimal getIdCausa() {
		return idCausa;
	}
	public void setIdCausa(BigDecimal idCausa) {
		this.idCausa = idCausa;
	}
	public String getDsCausa() {
		return dsCausa;
	}
	public void setDsCausa(String dsCausa) {
		this.dsCausa = dsCausa;
	}


	public BigDecimal getIdProblema() {
		return idProblema;
	}


	public void setIdProblema(BigDecimal idProblema) {
		this.idProblema = idProblema;
	}

	
}

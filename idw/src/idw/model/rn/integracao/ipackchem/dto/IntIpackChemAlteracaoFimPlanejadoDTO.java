package idw.model.rn.integracao.ipackchem.dto;

import java.util.Date;

public class IntIpackChemAlteracaoFimPlanejadoDTO 
{
	private Long idRegistro;
	private String cdMaquina;
	private String nropERP;
	private Date dtFimPlan;
	private Integer stRegistro;
	private String obsRegistro;
	private Date dthrRegistro;
	
	public Long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}
	
	public String getCdMaquina() {
		return cdMaquina;
	}
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	public String getNropERP() {
		return nropERP;
	}
	public void setNropERP(String nropERP) {
		this.nropERP = nropERP;
	}
	public Date getDtFimPlan() {
		return dtFimPlan;
	}
	public void setDtFimPlan(Date dtFimPlan) {
		this.dtFimPlan = dtFimPlan;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
	public String getObsRegistro() {
		return obsRegistro;
	}
	public void setObsRegistro(String obsRegistro) {
		this.obsRegistro = obsRegistro;
	}
	public Date getDthrRegistro() {
		return dthrRegistro;
	}
	public void setDthrRegistro(Date dthrRegistro) {
		this.dthrRegistro = dthrRegistro;
	}
	
	
}

package idw.model.rn.integracao.ipackchem.dto;

import java.util.Date;

public class IntIpackChemCGQLiberadoDTO 
{

	private Long idRegistro;
	private String nropERP;
	private Integer stRegistro;
	private String obsRegistro;
	private Date dthrRegistro;
	
	public Long getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getNropERP() {
		return nropERP;
	}
	public void setNropERP(String nropERP) {
		this.nropERP = nropERP;
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

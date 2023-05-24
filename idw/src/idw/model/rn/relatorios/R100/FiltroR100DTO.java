package idw.model.rn.relatorios.R100;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FiltroR100DTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<GtR100DTO> listaCdGt;
	private Date dtIReferencia;
	private Date dtFReferencia;
	
	private Integer qtParadas;
	
	
	
	public Date getDtIReferencia() {
		return dtIReferencia;
	}
	public void setDtIReferencia(Date dtIReferencia) {
		this.dtIReferencia = dtIReferencia;
	}
	public Date getDtFReferencia() {
		return dtFReferencia;
	}
	public void setDtFReferencia(Date dtFReferencia) {
		this.dtFReferencia = dtFReferencia;
	}
	public Integer getQtParadas() {
		return qtParadas;
	}
	public void setQtParadas(Integer qtParadas) {
		this.qtParadas = qtParadas;
	}
	public List<GtR100DTO> getListaCdGt() {
		return listaCdGt;
	}
	public void setListaCdGt(List<GtR100DTO> listaCdGt) {
		this.listaCdGt = listaCdGt;
	}
	@Override
	public String toString() {
		return "FiltroR100DTO [listaCdGt=" + listaCdGt + ", dtIReferencia=" + dtIReferencia + ", dtFReferencia=" + dtFReferencia + ", qtParadas=" + qtParadas + "]";
	}
	
	
}

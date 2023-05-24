package idw.webservices.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.PpNec;
@XmlRootElement
public class DadosRelatorioDTO {
	
	List<RelatoriosDTO> listaRelatorios;	
    Date dateInicioApont;
    Date dateFimApont;
    Date dateInicioPlan;
    Date dateFimPlan;
    PpNec ppnec;
    
	ResultadoDTO result = new ResultadoDTO();

	public List<RelatoriosDTO> getListaRelatorios() {
		return listaRelatorios;
	}

	public void setListaRelatorios(List<RelatoriosDTO> listaRelatorios) {
		this.listaRelatorios = listaRelatorios;
	}

	public ResultadoDTO getResult() {
		return result;
	}

	public void setResult(ResultadoDTO result) {
		this.result = result;
	}

	public Date getDateInicioApont() {
		return dateInicioApont;
	}

	public void setDateInicioApont(Date dateInicioApont) {
		this.dateInicioApont = dateInicioApont;
	}

	public Date getDateFimApont() {
		return dateFimApont;
	}

	public void setDateFimApont(Date dateFimApont) {
		this.dateFimApont = dateFimApont;
	}

	public Date getDateInicioPlan() {
		return dateInicioPlan;
	}

	public void setDateInicioPlan(Date dateInicioPlan) {
		this.dateInicioPlan = dateInicioPlan;
	}

	public Date getDateFimPlan() {
		return dateFimPlan;
	}

	public void setDateFimPlan(Date dateFimPlan) {
		this.dateFimPlan = dateFimPlan;
	}

	public PpNec getPpnec() {
		return ppnec;
	}

	public void setPpnec(PpNec ppnec) {
		this.ppnec = ppnec;
	}

}

package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.PpCp;

@XmlRootElement
public class CpsDTO {
	
	private List<PpCp> listaCp = new ArrayList<PpCp>();
	private ResultadoDTO resultadoDTO;
	
	public List<PpCp> getListaCp() {
		return listaCp;
	}
	public void setListaCp(List<PpCp> listaCp) {
		this.listaCp = listaCp;
	}
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
}

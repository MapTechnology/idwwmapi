package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;

@SuppressWarnings("unused")
public class PtGtDTO {
	
	private List<OmPt> listaPt;
	private List<OmGt> listaGt;
	private ResultadoDTO resultadoDTO;
	
	
	public void setListaPt(List<OmPt> listaPt) {
		this.listaPt = listaPt;
	}
	public List<OmPt> getListaPt() {
		return listaPt;
	}
	
	public void setListaGt(List<OmGt> listaGt) {
		this.listaGt = listaGt;
	}
	public List<OmGt> getListaGt() {
		return listaGt;
	}
	
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

}

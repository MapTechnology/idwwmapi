package ms.model.dto;

import injetws.model.pojos.PrUp;

import java.util.ArrayList;

public class ListaUPDTO {
	
	private ArrayList<UpDTO> listaUPDTO;
	private ResultadoMSDTO resultadoDTO;
	private ArrayList<PrUp> prUps = new ArrayList<PrUp>();
	
	public void setListaUPDTO(ArrayList<UpDTO> listaUPDTO) {
		this.listaUPDTO = listaUPDTO;
	}
	public ArrayList<UpDTO> getListaUPDTO() {
		return listaUPDTO;
	}
	
	public void setResultadoDTO(ResultadoMSDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoMSDTO getResultadoDTO() {
		return resultadoDTO;
	}
	public void setPrUps(ArrayList<PrUp> prUps) {
		this.prUps = prUps;
	}
	public ArrayList<PrUp> getPrUps() {
		return prUps;
	}
}

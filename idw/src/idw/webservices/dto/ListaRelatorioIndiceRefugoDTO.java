package idw.webservices.dto;

import java.util.List;

public class ListaRelatorioIndiceRefugoDTO {

	private	List<RelatorioIndiceRefugoDTO> listaRelatorioIndiceRefugo;
	private Double totalPoduzido;
	
	public List<RelatorioIndiceRefugoDTO> getListaRelatorioIndiceRefugo() {
		return listaRelatorioIndiceRefugo;
	}
	
	public void setListaRelatorioIndiceRefugo(List<RelatorioIndiceRefugoDTO> listaRelatorioIndiceRefugo) {
		this.listaRelatorioIndiceRefugo = listaRelatorioIndiceRefugo;
	}
	
	public Double getTotalPoduzido() {
		return totalPoduzido;
	}
	
	public void setTotalPoduzido(Double totalPoduzido) {
		this.totalPoduzido = totalPoduzido;
	}

}
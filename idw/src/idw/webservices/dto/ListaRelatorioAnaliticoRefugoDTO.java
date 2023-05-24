package idw.webservices.dto;

import java.util.Date;
import java.util.List;

public class ListaRelatorioAnaliticoRefugoDTO {
	
	private List<RelatorioAnaliticoRefugoDTO> listaRelatorioAnaliticoRefugo ;
	private List<Date> listaDatas;
	
	public List<RelatorioAnaliticoRefugoDTO> getListaRelatorioAnaliticoRefugo() {
		return listaRelatorioAnaliticoRefugo;
	}

	public void setListaRelatorioAnaliticoRefugo(
			List<RelatorioAnaliticoRefugoDTO> listaRelatorioAnaliticoRefugo) {
		this.listaRelatorioAnaliticoRefugo = listaRelatorioAnaliticoRefugo;
	}

	public List<Date> getListaDatas() {
		return listaDatas;
	}

	public void setListaDatas(List<Date> listaDatas) {
		this.listaDatas = listaDatas;
	}

}

package idw.relatorio.analiseproducaoeficiencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaDTOAnaliseProducaoEficienciaHoraAHora implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<AnaliseProducaoEficienciaHoraAHoraDTO> listaDTOs = new ArrayList<AnaliseProducaoEficienciaHoraAHoraDTO>();

	public List<AnaliseProducaoEficienciaHoraAHoraDTO> getListaDTOs() {
		return listaDTOs;
	}

	public void setListaDTOs(List<AnaliseProducaoEficienciaHoraAHoraDTO> listaDTOs) {
		this.listaDTOs = listaDTOs;
	}

}

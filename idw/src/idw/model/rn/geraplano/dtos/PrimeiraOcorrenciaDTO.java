package idw.model.rn.geraplano.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrimeiraOcorrenciaDTO {

	private List<Date> listaOcorrencia;

	public PrimeiraOcorrenciaDTO(){
		if (listaOcorrencia == null)
			listaOcorrencia = new ArrayList<Date>();
	}
	public List<Date> getListaOcorrencia() {
		return listaOcorrencia;
	}

	public void setListaOcorrencia(List<Date> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}
	
	public void addListaOcorrencia(Date data){
		this.listaOcorrencia.add(data);
	}
}

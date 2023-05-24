package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.MsMonitor;

public class ListaMonitorDTO {
    private List<MsMonitor> lista;
    private ResultadoDTO resultado;
    
	public void setLista(List<MsMonitor> lista) {
		this.lista = lista;
		
	}

	public List<MsMonitor> getLista() {
		return lista;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}
    
}

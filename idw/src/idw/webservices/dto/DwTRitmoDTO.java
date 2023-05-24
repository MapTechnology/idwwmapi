package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTRitmo;

@SuppressWarnings("serial")
public class DwTRitmoDTO implements Serializable{

	private DwTRitmo dwTRitmo;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public DwTRitmo getDwTRitmo() {
		return dwTRitmo;
	}
	public void setDwTRitmo(DwTRitmo dwTRitmo) {
		this.dwTRitmo = dwTRitmo;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}	
	
}

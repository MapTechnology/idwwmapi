package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTOrigem;

@SuppressWarnings("serial")
public class DwTOrigemDTO implements Serializable {

	private DwTOrigem dwTOrigem;
	private ResultadoDTO resultado = new ResultadoDTO();

	public DwTOrigem getDwTOrigem() {
		return dwTOrigem;
	}

	public void setDwTOrigem(DwTOrigem dwTOrigem) {
		this.dwTOrigem = dwTOrigem;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "DwTOrigemDTO [";
		
		retorno += "dwTOrigem=";
		
		if (this.dwTOrigem != null) {
			retorno += this.dwTOrigem.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "resultado=" + this.resultado.toString() + "]";
		
		return retorno;
		
		/*return "DwTOrigemDTO [dwTOrigem=" + dwTOrigem + ", resultado=" + resultado + "]";*/
	}
	
}
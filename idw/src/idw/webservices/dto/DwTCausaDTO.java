package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTCausa;

@SuppressWarnings("serial")
public class DwTCausaDTO implements Serializable {

	private DwTCausa dwTCausa;
	private ResultadoDTO resultado = new ResultadoDTO();

	public DwTCausa getDwTCausa() {
		return dwTCausa;
	}

	public void setDwTCausa(DwTCausa dwTCausa) {
		this.dwTCausa = dwTCausa;
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
		
		retorno = "DwTCausaDTO [";
		
		retorno += "dwTArea=";
		
		if (this.dwTCausa != null) {
			retorno += this.dwTCausa.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "resultado=" + this.resultado.toString() + "]";
		
		return retorno;
		
		/*return "DwTCausaDTO [dwTCausa=" + dwTCausa + ", resultado=" + resultado + "]";*/
	}
	
}
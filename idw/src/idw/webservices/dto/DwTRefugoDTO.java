package idw.webservices.dto;

import java.io.Serializable;
//Esta classe esta com o nome DwTRefugoDTO, pois estava dando conflito de nomes ao atualizar webservice

import idw.model.pojos.DwTRefugo;

@SuppressWarnings("serial")
public class DwTRefugoDTO implements Serializable {
	private DwTRefugo dwTRefugo;
	private ResultadoDTO resultado = new ResultadoDTO();

	public DwTRefugo getDwTRefugo() {
		return dwTRefugo;
	}

	public void setDwTRefugo(DwTRefugo dwTRefugo) {
		this.dwTRefugo = dwTRefugo;
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
		
		retorno = "DwTRefugoDTO [";
		
		retorno += "dwTRefugo=";
		
		if (this.dwTRefugo != null) {
			retorno += this.dwTRefugo.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "resultado=" + this.resultado + "]";
		
		return retorno;
		
		/*return "DwTRefugoDTO [dwTRefugo=" + dwTRefugo + ", resultado=" + resultado + "]";*/
	}
	
}

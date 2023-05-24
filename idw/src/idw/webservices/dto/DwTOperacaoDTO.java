package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTOperacao;

@SuppressWarnings("serial")
public class DwTOperacaoDTO implements Serializable {

	private DwTOperacao dwTOperacao;
	private ResultadoDTO resultado = new ResultadoDTO();
	
	public DwTOperacao getDwTOperacao() {
		return dwTOperacao;
	}
	public void setDwTOperacao(DwTOperacao dwTOperacao) {
		this.dwTOperacao = dwTOperacao;
	}
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
	
}

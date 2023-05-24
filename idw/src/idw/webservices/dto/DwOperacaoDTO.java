package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwOperacao;

@SuppressWarnings("serial")
public class DwOperacaoDTO implements Serializable {

	private DwOperacao dwOperacao;

	public DwOperacaoDTO(){

	}

	public DwOperacaoDTO(DwOperacao operacao){
		this.dwOperacao = operacao;
	}
	
	public DwOperacao getDwOperacao() {
		return dwOperacao;
	}

	public void setDwOperacao(DwOperacao dwOperacao) {
		this.dwOperacao = dwOperacao;
	}


}

package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmCargo;

@SuppressWarnings("serial")
public class OmCargoDTO  implements Serializable{
	
	private int EVENTO_BEM_SUCEDIDO = 0;

	private int ERRO_REATIVACAO_INDISPONIVEL = 7;
	
	private int resultadoEvento;
	
	private OmCargo omCargo;
	
	//20160928FVA:
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int eRROREATIVACAOINDISPONIVEL) {
		//ERRO_REATIVACAO_INDISPONIVEL = eRROREATIVACAOINDISPONIVEL;
	}
	

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public OmCargo getOmCargo() {
		return omCargo;
	}

	public void setOmCargo(OmCargo omCargo) {
		this.omCargo = omCargo;
	}
}

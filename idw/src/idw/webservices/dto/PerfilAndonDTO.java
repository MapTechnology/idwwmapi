package idw.webservices.dto;

import idw.model.pojos.MsPerfilandon;

public class PerfilAndonDTO {
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_CD_INVALIDO = 1;
	private int ERRO_CD_JA_CADASTRADO = 2;
	private int ERRO_DS_INVALIDO = 3;
	private int ERRO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 5;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 6;
	private int resultadoEvento;
	
	private MsPerfilandon msPerfilandon;

	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_CD_INVALIDO() {
		return ERRO_CD_INVALIDO;
	}

	public void setERRO_CD_INVALIDO(int eRRO_CD_INVALIDO) {
		ERRO_CD_INVALIDO = eRRO_CD_INVALIDO;
	}

	public int getERRO_CD_JA_CADASTRADO() {
		return ERRO_CD_JA_CADASTRADO;
	}

	public void setERRO_CD_JA_CADASTRADO(int eRRO_CD_JA_CADASTRADO) {
		ERRO_CD_JA_CADASTRADO = eRRO_CD_JA_CADASTRADO;
	}

	public int getERRO_DS_INVALIDO() {
		return ERRO_DS_INVALIDO;
	}

	public void setERRO_DS_INVALIDO(int eRRO_DS_INVALIDO) {
		ERRO_DS_INVALIDO = eRRO_DS_INVALIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int eRRO_USUARIO_REVISAO_DESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(int eRRO_USUARIO_STATUS_DESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public MsPerfilandon getMsPerfilandon() {
		return msPerfilandon;
	}

	public void setMsPerfilandon(MsPerfilandon msPerfilandon) {
		this.msPerfilandon = msPerfilandon;
	}
	
}

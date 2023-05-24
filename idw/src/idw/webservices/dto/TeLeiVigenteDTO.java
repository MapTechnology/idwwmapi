package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TeLei;

@SuppressWarnings("serial")
public class TeLeiVigenteDTO  implements Serializable{
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_LEI_JA_EXISTE = 1;
	private int ERRO_CDLEI_INVALIDO = 2;
	private int ERRO_DESCONHECIDO = 3;

	private int resultadoEvento;

	private TeLei teLei;

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getERRO_CDLEI_INVALIDO() {
		return ERRO_CDLEI_INVALIDO;
	}

	public void setERRO_CDLEI_INVALIDO(int eRRO_CDLEI_INVALIDO) {
		ERRO_CDLEI_INVALIDO = eRRO_CDLEI_INVALIDO;
	}

	public int getERRO_LEI_JA_EXISTE() {
		return ERRO_LEI_JA_EXISTE;
	}

	public void setERRO_LEI_JA_EXISTE(int eRRO_LEI_JA_EXISTE) {
		ERRO_LEI_JA_EXISTE = eRRO_LEI_JA_EXISTE;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public TeLei getTeLei() {
		return teLei;
	}

	public void setTeLei(TeLei teLei) {
		this.teLei = teLei;
	}
}

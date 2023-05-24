package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TeTipoConsumidor;

@SuppressWarnings("serial")
public class TeTipoConsumidorDTO  implements Serializable{
	
	private TeTipoConsumidor teTipoConsumidor;
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_CDCONSUMIDOR_INVALIDO = 1;
	private int ERRO_CONSUMIDOR_JA_EXISTE = 2;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO =3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_DESCONHECIDO = 5;
	private int resultadoEvento;
	
	public TeTipoConsumidor getTeTipoConsumidor() {
		return teTipoConsumidor;
	}

	public void setTeTipoConsumidor(TeTipoConsumidor teTipoConsumidor) {
		this.teTipoConsumidor = teTipoConsumidor;
	}
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_CDCONSUMIDOR_INVALIDO() {
		return ERRO_CDCONSUMIDOR_INVALIDO;
	}

	public void setERRO_CDCONSUMIDOR_INVALIDO(int eRRO_CDCONSUMIDOR_INVALIDO) {
		ERRO_CDCONSUMIDOR_INVALIDO = eRRO_CDCONSUMIDOR_INVALIDO;
	}

	public int getERRO_CONSUMIDOR_JA_EXISTE() {
		return ERRO_CONSUMIDOR_JA_EXISTE;
	}

	public void setERRO_CONSUMIDOR_JA_EXISTE(int eRRO_CONSUMIDOR_JA_EXISTE) {
		ERRO_CONSUMIDOR_JA_EXISTE = eRRO_CONSUMIDOR_JA_EXISTE;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int eRRO_USUARIO_STATUS_DESCONHECIDO) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = eRRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int eRRO_USUARIO_REVISAO_DESCONHECIDO) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = eRRO_USUARIO_REVISAO_DESCONHECIDO;
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
	
}
package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.TeTarifas;

@SuppressWarnings("serial")
public class TeTarifaDTO  implements Serializable{
	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_TARIFA_JA_EXISTE = 1;
	private int ERRO_CDLEI_INVALIDO = 2;
	private int ERRO_CDTIPOCONSUMIDOR_INVALIDA = 3;
	private int ERRO_CDCONCESSIONARIA_INVALIDA = 4;
	private int ERRO_TARIFASEMANAL_INVALIDA =5;
	private int ERRO_DESCONHECIDO = 6;
	private int resultadoEvento;
	private TeTarifasemanaisDTO tarifasSemanaisExcluidas;
	private TeTarifas teTarifa;
	
	public TeTarifaDTO(){
		
	}

	public TeTarifasemanaisDTO getTarifasSemanaisExcluidas() {
		return tarifasSemanaisExcluidas;
	}

	public void setTarifasSemanaisExcluidas(
			TeTarifasemanaisDTO tarifasSemanaisExcluidas) {
		this.tarifasSemanaisExcluidas = tarifasSemanaisExcluidas;
	}

	public TeTarifas getTeTarifa() {
		return teTarifa;
	}

	public void setTeTarifa(TeTarifas teTarifa) {
		this.teTarifa = teTarifa;
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

	public void setERRO_TARIFA_JA_EXISTE(int eRRO_TARIFA_JA_EXISTE) {
		ERRO_TARIFA_JA_EXISTE = eRRO_TARIFA_JA_EXISTE;
	}

	public int getERRO_TARIFA_JA_EXISTE() {
		return ERRO_TARIFA_JA_EXISTE;
	}
	
	public int getERRO_CDLEI_INVALIDO() {
		return ERRO_CDLEI_INVALIDO;
	}

	public void setERRO_CDLEI_INVALIDO(int eRRO_CDLEI_INVALIDO) {
		ERRO_CDLEI_INVALIDO = eRRO_CDLEI_INVALIDO;
	}

	public int getERRO_CDTIPOCONSUMIDOR_INVALIDA() {
		return ERRO_CDTIPOCONSUMIDOR_INVALIDA;
	}

	public void setERRO_CDTIPOCONSUMIDOR_INVALIDA(int eRRO_CDTIPOCONSUMIDOR_INVALIDA) {
		ERRO_CDTIPOCONSUMIDOR_INVALIDA = eRRO_CDTIPOCONSUMIDOR_INVALIDA;
	}

	public int getERRO_CDCONCESSIONARIA_INVALIDA() {
		return ERRO_CDCONCESSIONARIA_INVALIDA;
	}

	public void setERRO_CDCONCESSIONARIA_INVALIDA(int eRRO_CDCONCESSIONARIA_INVALIDA) {
		ERRO_CDCONCESSIONARIA_INVALIDA = eRRO_CDCONCESSIONARIA_INVALIDA;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}
	public int getERRO_TARIFASEMANAL_INVALIDA() {
		return ERRO_TARIFASEMANAL_INVALIDA;
	}

	public void setERRO_TARIFASEMANAL_INVALIDA(int eRRO_TARIFASEMANAL_INVALIDA) {
		ERRO_TARIFASEMANAL_INVALIDA = eRRO_TARIFASEMANAL_INVALIDA;
	}

}
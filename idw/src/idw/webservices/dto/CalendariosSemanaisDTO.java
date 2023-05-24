/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class CalendariosSemanaisDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_DURACAO_INVALIDA = 2;
	private int ERRO_TURNO_DESCONHECIDO = 3;
	private int ERRO_DIASEMANA_INVALIDO = 4;
	private int ERRO_INICIOTURNO_INVALIDO = 5;
	private int ERRO_FIMTURNO_INVALIDO = 6;
	private int ERRO_INTERVALO_INVALIDO = 7;
	private int ERRO_INTERVALOMULTIPLO_DURACAO = 8;
	private int ERRO_TOLERANCIA_INVALIDA = 9;
	private int ERRO_TPREFERENCIA_INVALIDA = 10;
	
	
	private List<CalendarioSemanalDTO> calendariosSemanais;
    private CalendarioPtsDTO calendarioPts;

    private int resultadoEvento;

	public List<CalendarioSemanalDTO> getCalendariosSemanais() {
		return calendariosSemanais;
	}

	public void setCalendariosSemanais(List<CalendarioSemanalDTO> calendariosSemanais) {
		this.calendariosSemanais = calendariosSemanais;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public int getERRO_DURACAO_INVALIDA() {
		return ERRO_DURACAO_INVALIDA;
	}

	public void setERRO_DURACAO_INVALIDA(int eRRODURACAOINVALIDA) {
		ERRO_DURACAO_INVALIDA = eRRODURACAOINVALIDA;
	}

	public int getERRO_TURNO_DESCONHECIDO() {
		return ERRO_TURNO_DESCONHECIDO;
	}

	public void setERRO_TURNO_DESCONHECIDO(int eRROTURNODESCONHECIDO) {
		ERRO_TURNO_DESCONHECIDO = eRROTURNODESCONHECIDO;
	}

	public int getERRO_DIASEMANA_INVALIDO() {
		return ERRO_DIASEMANA_INVALIDO;
	}

	public void setERRO_DIASEMANA_INVALIDO(int eRRODIASEMANAINVALIDO) {
		ERRO_DIASEMANA_INVALIDO = eRRODIASEMANAINVALIDO;
	}

	public int getERRO_INICIOTURNO_INVALIDO() {
		return ERRO_INICIOTURNO_INVALIDO;
	}

	public void setERRO_INICIOTURNO_INVALIDO(int eRROINICIOTURNOINVALIDO) {
		ERRO_INICIOTURNO_INVALIDO = eRROINICIOTURNOINVALIDO;
	}

	public int getERRO_FIMTURNO_INVALIDO() {
		return ERRO_FIMTURNO_INVALIDO;
	}

	public void setERRO_FIMTURNO_INVALIDO(int eRROFIMTURNOINVALIDO) {
		ERRO_FIMTURNO_INVALIDO = eRROFIMTURNOINVALIDO;
	}

	public int getERRO_INTERVALO_INVALIDO() {
		return ERRO_INTERVALO_INVALIDO;
	}

	public void setERRO_INTERVALO_INVALIDO(int eRROINTERVALOINVALIDO) {
		ERRO_INTERVALO_INVALIDO = eRROINTERVALOINVALIDO;
	}

	public int getERRO_INTERVALOMULTIPLO_DURACAO() {
		return ERRO_INTERVALOMULTIPLO_DURACAO;
	}

	public void setERRO_INTERVALOMULTIPLO_DURACAO(int eRROINTERVALOMULTIPLODURACAO) {
		ERRO_INTERVALOMULTIPLO_DURACAO = eRROINTERVALOMULTIPLODURACAO;
	}

	public int getERRO_TOLERANCIA_INVALIDA() {
		return ERRO_TOLERANCIA_INVALIDA;
	}

	public void setERRO_TOLERANCIA_INVALIDA(int eRROTOLERANCIAINVALIDA) {
		ERRO_TOLERANCIA_INVALIDA = eRROTOLERANCIAINVALIDA;
	}

	public int getERRO_TPREFERENCIA_INVALIDA() {
		return ERRO_TPREFERENCIA_INVALIDA;
	}

	public void setERRO_TPREFERENCIA_INVALIDA(int eRROTPREFERENCIAINVALIDA) {
		ERRO_TPREFERENCIA_INVALIDA = eRROTPREFERENCIAINVALIDA;
	}
	public CalendarioPtsDTO getCalendarioPts() {
		return calendarioPts;
	}
	public void setCalendarioPts(CalendarioPtsDTO calendarioPts) {
		this.calendarioPts = calendarioPts;
	}

				    
}
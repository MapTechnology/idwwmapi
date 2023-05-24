package idw.webservices.dto;

import idw.model.pojos.DwTurno;

public class DwTurnoDTO {
    
	private static final int _BEM_SUCEDIDO = 1;
	private static final int _NENHUM_RESULTADO_ENCONTRADO = 0;
	
	private DwTurno dwTurno;
	
	private int resultadoEvento;

	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}

	public DwTurno getDwTurno() {
		return dwTurno;
	}

	public static int getBemSucedido() {
		return _BEM_SUCEDIDO;
	}

	public static int getNenhumResultadoEncontrado() {
		return _NENHUM_RESULTADO_ENCONTRADO;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}
}

package idw.webservices.dto;

import java.util.List;

public class DwTurnosDTO {
	
	private  int _BEM_SUCEDIDO = 1;
	private  int _NENHUM_RESULTADO_ENCONTRADO = 0;
	private int resultadoEvento;
    
	List<DwTurnoDTO> listaDwTurnoDTO;

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}

	public List<DwTurnoDTO> getListaDwTurnoDTO() {
		return listaDwTurnoDTO;
	}

	public void setListaDwTurnoDTO(List<DwTurnoDTO> listaDwTurnoDTO) {
		this.listaDwTurnoDTO = listaDwTurnoDTO;
	}

	public int getBemSucedido() {
		return _BEM_SUCEDIDO;
	}

	public  int getNenhumResultadoEncontrado() {
		return _NENHUM_RESULTADO_ENCONTRADO;
	}
	
	
}

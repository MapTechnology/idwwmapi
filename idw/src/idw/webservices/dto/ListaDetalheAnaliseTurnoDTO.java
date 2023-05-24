package idw.webservices.dto;

import java.util.List;

public class ListaDetalheAnaliseTurnoDTO {
	
	private DetalheAnaliseTurnoDTO analiseTurnoTodasMaquinas;
	private List<DetalheAnaliseTurnoDTO> analiseTurnoPorMaquina;
	private List<DetalheAnaliseTurnoGtDTO> analiseTurnoPorGt;
	
	public DetalheAnaliseTurnoDTO getAnaliseTurnoTodasMaquinas() {
		return analiseTurnoTodasMaquinas;
	}
	public void setAnaliseTurnoTodasMaquinas(
			DetalheAnaliseTurnoDTO analiseTurnoTodasMaquinas) {
		this.analiseTurnoTodasMaquinas = analiseTurnoTodasMaquinas;
	}
	public List<DetalheAnaliseTurnoDTO> getAnaliseTurnoPorMaquina() {
		return analiseTurnoPorMaquina;
	}
	public void setAnaliseTurnoPorMaquina(
			List<DetalheAnaliseTurnoDTO> analiseTurnoPorMaquina) {
		this.analiseTurnoPorMaquina = analiseTurnoPorMaquina;
	}
	public List<DetalheAnaliseTurnoGtDTO> getAnaliseTurnoPorGt() {
		return analiseTurnoPorGt;
	}
	public void setAnaliseTurnoPorGt(
			List<DetalheAnaliseTurnoGtDTO> analiseTurnoPorGt) {
		this.analiseTurnoPorGt = analiseTurnoPorGt;
	}

	

}

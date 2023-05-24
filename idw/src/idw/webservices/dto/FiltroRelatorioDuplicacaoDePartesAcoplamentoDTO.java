package idw.webservices.dto;

import java.util.Date;

public class FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO {

	private TurnoDTO turnoDTO;
	private Date periodoInicial;
	private Date periodoFinal;

	public TurnoDTO getTurnoDTO() {
		return turnoDTO;
	}

	public void setTurnoDTO(TurnoDTO turnoDTO) {
		this.turnoDTO = turnoDTO;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	@Override
	public String toString() {
		String retorno;
		
		retorno = "FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO [";
		
		retorno += "turnoDTO=";

		if (this.turnoDTO != null) {
			retorno += this.turnoDTO.getTurno().getCdTurno()  + ", ";
		} else {
			retorno += "null, ";
		}

		retorno += "periodoInicial=" + this.periodoInicial + ", " +
				   "periodoFinal=" + this.periodoFinal + "]";
		
		return retorno;
		/*		
		return "FiltroRelatorioDuplicacaoDePartesAcoplamentoDTO [turnoDTO=" + turnoDTO + ", periodoInicial=" + periodoInicial
				+ ", periodoFinal=" + periodoFinal + "]";
		*/
	}

}

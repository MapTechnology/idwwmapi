package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class AcumuladosManutencaoDTO {
	private List<AcumuladoManutencaoDTO> acumulados;

	public List<AcumuladoManutencaoDTO> getAcumulados() {
		return acumulados;
	}

	public void setAcumulados(List<AcumuladoManutencaoDTO> acumulados) {
		this.acumulados = acumulados;
	}
}

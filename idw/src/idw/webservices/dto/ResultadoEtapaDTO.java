package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoEtapaDTO {
	private long idEtapa;
	private int ordemEtapa;
	private List<ResultadoSubetapaDTO> subetapas = new ArrayList<ResultadoSubetapaDTO>();

	public int getOrdemEtapa() {
		return ordemEtapa;
	}
	public void setOrdemEtapa(int ordemEtapa) {
		this.ordemEtapa = ordemEtapa;
	}
	public long getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(long idEtapa) {
		this.idEtapa = idEtapa;
	}
	public List<ResultadoSubetapaDTO> getSubetapas() {
		return subetapas;
	}
	public void setSubetapas(List<ResultadoSubetapaDTO> subetapas) {
		this.subetapas = subetapas;
	}
}

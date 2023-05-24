package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ResultadoTesteDTO implements Serializable{
	private long idReceita;
	private boolean isReceitaFinalizada;
	private List<ResultadoEtapaDTO> etapas = new ArrayList<ResultadoEtapaDTO>();

	
	public boolean isReceitaFinalizada() {
		return isReceitaFinalizada;
	}
	public void setReceitaFinalizada(boolean isReceitaFinalizada) {
		this.isReceitaFinalizada = isReceitaFinalizada;
	}
	public long getIdReceita() {
		return idReceita;
	}
	public void setIdReceita(long idReceita) {
		this.idReceita = idReceita;
	}
	public List<ResultadoEtapaDTO> getEtapas() {
		return etapas;
	}
	public void setEtapas(List<ResultadoEtapaDTO> etapas) {
		this.etapas = etapas;
	}
}

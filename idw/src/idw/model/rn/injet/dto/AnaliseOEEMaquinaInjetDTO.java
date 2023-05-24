package idw.model.rn.injet.dto;


import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class AnaliseOEEMaquinaInjetDTO implements Serializable{
	List<AOGalpaoInjetDTO> galpoes;
	List<AODetalheInjetDTO> acumulado;
	List<String> meses;
	/**
	 * @return the meses
	 */
	public List<String> getMeses() {
		return meses;
	}
	/**
	 * @param meses the meses to set
	 */
	public void setMeses(List<String> meses) {
		this.meses = meses;
	}
	/**
	 * @return the galpoes
	 */
	public List<AOGalpaoInjetDTO> getGalpoes() {
		return galpoes;
	}
	/**
	 * @param galpoes the galpoes to set
	 */
	public void setGalpoes(List<AOGalpaoInjetDTO> galpoes) {
		this.galpoes = galpoes;
	}
	/**
	 * @return the acumulado
	 */
	public List<AODetalheInjetDTO> getAcumulado() {
		return acumulado;
	}
	/**
	 * @param acumulado the acumulado to set
	 */
	public void setAcumulado(List<AODetalheInjetDTO> acumulado) {
		this.acumulado = acumulado;
	}
}

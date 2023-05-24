package idw.model.rn.injet.dto;

import java.util.ArrayList;
import java.util.List;

public class OEEGalpoesInjetDTO {
	private int maxLinha;
	private int maxColuna;
	private List<OEETotalGalpaoInjetDTO> galpoes = new ArrayList<OEETotalGalpaoInjetDTO>();
	public int getMaxLinha() {
		return maxLinha;
	}
	public void setMaxLinha(int maxLinha) {
		this.maxLinha = maxLinha;
	}
	public int getMaxColuna() {
		return maxColuna;
	}
	public void setMaxColuna(int maxColuna) {
		this.maxColuna = maxColuna;
	}
	public List<OEETotalGalpaoInjetDTO> getGalpoes() {
		return galpoes;
	}
	public void setGalpoes(List<OEETotalGalpaoInjetDTO> galpoes) {
		this.galpoes = galpoes;
	}
	
	
}

package idw.model.rn.geraplano.dtos;

import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.PpCp;

public class InsercaoCPDTO {

	private List<NecessidadePredecessoraDTO> listaNecessidadePredecessoras = new ArrayList<NecessidadePredecessoraDTO>();
	private double qtNecessaria;
	private PpCp ppcpIncluida;
	private List<PpCp> ppcpAjustadas = new ArrayList<PpCp>();
	
	
	public List<PpCp> getPpcpAjustadas() {
		return ppcpAjustadas;
	}
	public void setPpcpAjustadas(List<PpCp> ppcpAjustadas) {
		this.ppcpAjustadas = ppcpAjustadas;
	}
	public PpCp getPpcpIncluida() {
		return ppcpIncluida;
	}
	public void setPpcpIncluida(PpCp ppcpIncluida) {
		this.ppcpIncluida = ppcpIncluida;
	}
	public List<NecessidadePredecessoraDTO> getListaNecessidadePredecessoras() {
		return listaNecessidadePredecessoras;
	}
	public void setListaNecessidadePredecessoras(
			List<NecessidadePredecessoraDTO> listaNecessidadePredecessoras) {
		this.listaNecessidadePredecessoras = listaNecessidadePredecessoras;
	}
	public double getQtNecessaria() {
		return qtNecessaria;
	}
	public void setQtNecessaria(double qtNecessaria) {
		this.qtNecessaria = qtNecessaria;
	}
	
	
}

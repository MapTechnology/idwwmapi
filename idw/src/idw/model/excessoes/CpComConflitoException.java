package idw.model.excessoes;

import java.util.List;

import idw.model.pojos.PpCp;

@SuppressWarnings("serial")
public class CpComConflitoException extends Exception{
	List<PpCp> listaCpEmConflito = null;
	double qtNecessaria = 0d;
	
	public List<PpCp> getListaCpEmConflito() {
		return listaCpEmConflito;
	}

	public void setListaCpEmConflito(List<PpCp> listaCpEmConflito) {
		this.listaCpEmConflito = listaCpEmConflito;
	}

	public double getQtNecessaria() {
		return qtNecessaria;
	}

	public void setQtNecessaria(double qtNecessaria) {
		this.qtNecessaria = qtNecessaria;
	}
	
}

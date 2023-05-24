package idw.model.rn.indicador;

import idw.model.pojos.OmInd;

public class IndicadorValorDTO {
	OmInd omInd;
	double valor;
	
	public OmInd getOmInd() {
		return omInd;
	}
	public void setOmInd(OmInd omInd) {
		this.omInd = omInd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}

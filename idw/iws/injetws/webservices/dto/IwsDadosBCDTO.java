package injetws.webservices.dto;


import injetws.model.pojos.PrUpDadosBc;

import java.io.Serializable;

public class IwsDadosBCDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double qtdProducaoLiquida=0d;	
	private int totalCavAtivas=1;
	
	public void copyPrUpDadosBC(PrUpDadosBc prupdadosbc) {
		if(prupdadosbc.getQtdProducaoLiquida()!=null)
			this.qtdProducaoLiquida=prupdadosbc.getQtdProducaoLiquida();
		if(prupdadosbc.getTotalCavAtivas()!=null){
			this.totalCavAtivas=prupdadosbc.getTotalCavAtivas().intValue();		
		}		
	}
	
	public IwsDadosBCDTO(Double qtdProducaoLiquida, int totalCavAtivas) {		
		this.qtdProducaoLiquida = qtdProducaoLiquida;
		this.totalCavAtivas = totalCavAtivas;
	}
	
	public IwsDadosBCDTO() {		
	}

	public Double getQtdProducaoLiquida() {
		return qtdProducaoLiquida;
	}
	public void setQtdProducaoLiquida(Double qtdProducaoLiquida) {
		this.qtdProducaoLiquida = qtdProducaoLiquida;
	}
	public int getTotalCavAtivas() {
		return totalCavAtivas;
	}
	public void setTotalCavAtivas(int totalCavAtivas) {
		this.totalCavAtivas = totalCavAtivas;
	}
	

}

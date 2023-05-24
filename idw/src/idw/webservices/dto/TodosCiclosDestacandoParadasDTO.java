package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TodosCiclosDestacandoParadasDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CicloDestacandoParadas> ciclos = new ArrayList<>();
	private Integer qtCiclosProdutivos;
	private Double segCicloProdutivos;

	public List<CicloDestacandoParadas> getCiclos() {
		return ciclos;
	}

	public void setCiclos(List<CicloDestacandoParadas> ciclos) {
		this.ciclos = ciclos;
	}

	public Integer getQtCiclosProdutivos() {
		return qtCiclosProdutivos;
	}

	public void setQtCiclosProdutivos(Integer qtCiclosProdutivos) {
		this.qtCiclosProdutivos = qtCiclosProdutivos;
	}

	public Double getSegCicloProdutivos() {
		return segCicloProdutivos;
	}

	public void setSegCicloProdutivos(Double segCicloProdutivos) {
		this.segCicloProdutivos = segCicloProdutivos;
	}
	
}

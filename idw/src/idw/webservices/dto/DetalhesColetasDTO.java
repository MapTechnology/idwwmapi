package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class DetalhesColetasDTO implements Serializable{
	private List<DetalheColetaDTO> detalhesColetas = new ArrayList<DetalheColetaDTO>();

	public List<DetalheColetaDTO> getDetalhesColetas() {
		return detalhesColetas;
	}

	public void setDetalhesColetas(List<DetalheColetaDTO> detalhesColetas) {
		this.detalhesColetas = detalhesColetas;
	}
	
	public void addDetalhe(DetalheColetaDTO detalhe){
		this.detalhesColetas.add(detalhe);
	}
}

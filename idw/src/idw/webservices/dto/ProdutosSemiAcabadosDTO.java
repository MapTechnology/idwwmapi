package idw.webservices.dto;

import java.util.List;

public class ProdutosSemiAcabadosDTO {
	
	private List<ProdutoSemiAcabadoDTO> semiAcabadoDTOs;

	public List<ProdutoSemiAcabadoDTO> getOrdemProducaoDTO() {
		return semiAcabadoDTOs;
	}

	public void setOrdemProducaoDTO(List<ProdutoSemiAcabadoDTO> semiAcabadoDTOs) {
		this.semiAcabadoDTOs = semiAcabadoDTOs;
	}

}
package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.PpCp;

public class CpDTO {

	private PpCp cp;
	private List<OrdemProducaoProdutoDTO> ordensProducaoProdutoDTO;
	private ResultadoDTO resultadoDTO;
	
	public void setCp(PpCp cp) {
		this.cp = cp;
	}
	public PpCp getCp() {
		return cp;
	}
	public List<OrdemProducaoProdutoDTO> getOrdensProducaoProdutoDTO() {
		return ordensProducaoProdutoDTO;
	}
	public void setOrdensProducaoProdutoDTO(
			List<OrdemProducaoProdutoDTO> ordensProducaoProdutoDTO) {
		this.ordensProducaoProdutoDTO = ordensProducaoProdutoDTO;
	}
	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

}

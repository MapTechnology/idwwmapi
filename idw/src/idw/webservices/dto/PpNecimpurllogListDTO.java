package idw.webservices.dto;

import java.util.ArrayList;
import java.util.List;


public class PpNecimpurllogListDTO {
	
	private List<PpNecimpurllogDTO> listaPpNecimpurllogDTO = new ArrayList<PpNecimpurllogDTO>();
	private List<String> listaArquivos;
	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	

	public void setListaPpNecimpurllogDTO(List<PpNecimpurllogDTO> listaPpNecimpurllogDTO) {
		this.listaPpNecimpurllogDTO = listaPpNecimpurllogDTO;
	}

	public List<PpNecimpurllogDTO> getListaPpNecimpurllogDTO() {
		return listaPpNecimpurllogDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setListaArquivos(List<String> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

	public List<String> getListaArquivos() {
		return listaArquivos;
	}
	
}

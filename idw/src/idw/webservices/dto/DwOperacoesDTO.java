package idw.webservices.dto;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("serial")
public class DwOperacoesDTO implements Serializable {

	private List<DwOperacaoDTO> listaOperacoesDTO;
	private ResultadoDTO resultadoDTO;

	public List<DwOperacaoDTO> getListaOperacoesDTO() {
		return listaOperacoesDTO;
	}

	public void setListaOperacoesDTO(List<DwOperacaoDTO> listaOperacoesDTO) {
		this.listaOperacoesDTO = listaOperacoesDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	
	
	
	
}

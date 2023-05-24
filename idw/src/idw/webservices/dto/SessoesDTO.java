package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class SessoesDTO implements Serializable {
	
	private List<SessaoDTO> listaSessao = new ArrayList<SessaoDTO>();
	private ResultadoDTO resultado = new ResultadoDTO();
	
	
	public List<SessaoDTO> getListaSessao() {
		return listaSessao;
	}
	public void setListaSessao(List<SessaoDTO> listaSessao) {
		this.listaSessao = listaSessao;
	}
	public void addSessaoDTO(SessaoDTO oSessaoDTO) {
		listaSessao.add(oSessaoDTO);
	}
	
	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	
	
}

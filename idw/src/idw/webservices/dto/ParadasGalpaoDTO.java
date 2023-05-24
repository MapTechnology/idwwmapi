package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class ParadasGalpaoDTO implements Serializable {
	
	private List<ParadaGalpaoDTO> paradasGalpao;

	public List<ParadaGalpaoDTO> getParadasGalpao() {
		return paradasGalpao;
	}

	public void setParadasGalpao(List<ParadaGalpaoDTO> paradasGalpao) {
		this.paradasGalpao = paradasGalpao;
	}
	
	
	

}

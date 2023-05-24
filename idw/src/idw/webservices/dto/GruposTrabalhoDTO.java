package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gruposTrabalhoDTO")
public class GruposTrabalhoDTO extends SucessoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<GrupoTrabalhoDTO> gruposTrabalho = new ArrayList<GrupoTrabalhoDTO>();
	
	public List<GrupoTrabalhoDTO> getGruposTrabalho() {
		return gruposTrabalho;
	}

	public void setGruposTrabalho(List<GrupoTrabalhoDTO> gruposTrabalho) {
		this.gruposTrabalho = gruposTrabalho;
	}
	
	
}

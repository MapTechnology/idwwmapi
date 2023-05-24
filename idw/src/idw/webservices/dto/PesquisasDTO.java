package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author lineker
*/
@XmlRootElement
public class PesquisasDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PesquisaDTO> pesquisa;

	public List<PesquisaDTO> getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(List<PesquisaDTO> pesquisa) {
		this.pesquisa = pesquisa;
	}
    
    

}

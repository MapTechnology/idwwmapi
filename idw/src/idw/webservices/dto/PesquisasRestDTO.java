package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class PesquisasRestDTO implements Serializable {

	private List<PesquisaRestDTO> pesquisas;

	public PesquisasRestDTO() {
	}

	public PesquisasRestDTO(PesquisasDTO pesquisasDTO) {
		pesquisas = new ArrayList<PesquisaRestDTO>();

		for (PesquisaDTO pesquisa : pesquisasDTO.getPesquisa()) {
			pesquisas.add(new PesquisaRestDTO(pesquisa));
		}

	}

	public List<PesquisaRestDTO> getPesquisa() {
		return pesquisas;
	}

	public void setPesquisa(List<PesquisaRestDTO> pesquisas) {
		this.pesquisas = pesquisas;
	}

}

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
*
* @author fredson
*/
@SuppressWarnings("serial")

public class SapConhecimentosDTO implements Serializable {
	private List<SapConhecimentoDTO> sapconhecimentos;

	public List<SapConhecimentoDTO> getSapconhecimentos() {
		return sapconhecimentos;
	}

	public void setSapconhecimentos(List<SapConhecimentoDTO> sapconhecimentos) {
		this.sapconhecimentos = sapconhecimentos;
	}

}

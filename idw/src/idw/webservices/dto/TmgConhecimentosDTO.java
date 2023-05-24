package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class TmgConhecimentosDTO  implements Serializable {
	private List<TmgConhecimentoDTO> tmgconhecimentos;

	public List<TmgConhecimentoDTO> getTmgconhecimentos() {
		return tmgconhecimentos;
	}

	public void setTmgconhecimentos(List<TmgConhecimentoDTO> tmgconhecimentos) {
		this.tmgconhecimentos = tmgconhecimentos;
	}

}

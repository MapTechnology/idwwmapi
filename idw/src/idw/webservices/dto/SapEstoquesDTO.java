package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class SapEstoquesDTO implements Serializable {
	private List<SapEstoqueDTO> sapestoques;

	public List<SapEstoqueDTO> getSapestoques() {
		return sapestoques;
	}

	public void setSapestoques(List<SapEstoqueDTO> sapestoques) {
		this.sapestoques = sapestoques;
	}
}

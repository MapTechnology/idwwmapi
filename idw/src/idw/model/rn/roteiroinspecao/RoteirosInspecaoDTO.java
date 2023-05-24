package idw.model.rn.roteiroinspecao;

import java.io.Serializable;
import java.util.List;

public class RoteirosInspecaoDTO extends RetornoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RoteiroInspecaoDTO> roteiros;

	public List<RoteiroInspecaoDTO> getRoteiros() {
		return roteiros;
	}

	public void setRoteiros(List<RoteiroInspecaoDTO> roteiros) {
		this.roteiros = roteiros;
	}
	
	
}

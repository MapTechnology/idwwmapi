package idw.model.rn.folhainspecaorap;

import java.io.Serializable;
import java.util.List;

import idw.model.rn.roteiroinspecao.RetornoDTO;

public class FolhasInspecaoRapDTO extends RetornoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private List<FolhaInspecaoRapDTO> folhas;

	
	public FolhasInspecaoRapDTO() {
		super();
	}
	
	
	public List<FolhaInspecaoRapDTO> getFolhas() {
		return folhas;
	}

	public void setFolhas(List<FolhaInspecaoRapDTO> folhas) {
		this.folhas = folhas;
	}
	
	
}

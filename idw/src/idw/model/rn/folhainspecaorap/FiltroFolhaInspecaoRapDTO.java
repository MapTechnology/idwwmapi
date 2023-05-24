package idw.model.rn.folhainspecaorap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.QqFolhaInsRap;
import idw.model.rn.roteiroinspecao.RetornoDTO;

@XmlRootElement(name="filtroFolhaInspecaoRapDTO")
public class FiltroFolhaInspecaoRapDTO extends RetornoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QqFolhaInsRap folhainsrap;
	
	public QqFolhaInsRap getFolhainsrap() {
		return folhainsrap;
	}

	public void setFolhainsrap(QqFolhaInsRap folhainsrap) {
		this.folhainsrap = folhainsrap;
	}
	
	
}

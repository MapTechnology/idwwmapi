package idw.model.rn.folhainspecaorap;

import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.QqFolhaInsRap;
import idw.webservices.dto.SucessoDTO;

@XmlRootElement(name="folhaInspecaoRapDTO")
public class FolhaInspecaoRapDTO extends SucessoDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QqFolhaInsRap qqFolhaInsRap;

	public QqFolhaInsRap getQqFolhaInsRap() {
		return qqFolhaInsRap;
	}

	public void setQqFolhaInsRap(QqFolhaInsRap qqFolhaInsRap) {
		this.qqFolhaInsRap = qqFolhaInsRap;
	}
}

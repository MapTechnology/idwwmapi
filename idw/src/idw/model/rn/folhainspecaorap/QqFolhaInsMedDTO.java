package idw.model.rn.folhainspecaorap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

public class QqFolhaInsMedDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFolhainsmed;
	private String dsFolhainsmed;
	private byte[] media;
	private Integer ordem;
	private String nomearquivo;
	
	public Long getIdFolhainsmed() {
		return idFolhainsmed;
	}
	public void setIdFolhainsmed(Long idFolhainsmed) {
		this.idFolhainsmed = idFolhainsmed;
	}
	public String getDsFolhainsmed() {
		return dsFolhainsmed;
	}
	public void setDsFolhainsmed(String dsFolhainsmed) {
		this.dsFolhainsmed = dsFolhainsmed;
	}
	@XmlTransient
	public byte[] getMedia() {
		return media;
	}
	public void setMedia(byte[] media) {
		this.media = media;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getNomearquivo() {
		return nomearquivo;
	}
	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	
}

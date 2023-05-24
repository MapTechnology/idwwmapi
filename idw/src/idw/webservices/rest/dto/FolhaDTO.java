package idw.webservices.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="folha")
public class FolhaDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	private long idFolha;
	private String cdFolha;
	private String dsFolha;
	
	public long getIdFolha() {
		return idFolha;
	}
	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public String getDsFolha() {
		return dsFolha;
	}
	public void setDsFolha(String dsFolha) {
		this.dsFolha = dsFolha;
	}
	
	
}

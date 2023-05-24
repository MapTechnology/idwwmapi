package idw.webservices.rest.idw.v2.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="grupoFerramenta")
public class GrupoFerramentasDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idGrupoFerramenta;
	private String cdGrupoFerramenta;
	private String dsGrupoFerramenta; 
	private String cdUsrRev;
	private Integer stRegistro;
	public Long getIdGrupoFerramenta() {
		return idGrupoFerramenta;
	}
	public void setIdGrupoFerramenta(Long idGrupoFerramenta) {
		this.idGrupoFerramenta = idGrupoFerramenta;
	}
	public String getCdGrupoFerramenta() {
		return cdGrupoFerramenta;
	}
	public void setCdGrupoFerramenta(String cdGrupoFerramenta) {
		this.cdGrupoFerramenta = cdGrupoFerramenta;
	}
	public String getDsGrupoFerramenta() {
		return dsGrupoFerramenta;
	}
	public void setDsGrupoFerramenta(String dsGrupoFerramenta) {
		this.dsGrupoFerramenta = dsGrupoFerramenta;
	}
	public String getCdUsrRev() {
		return cdUsrRev;
	}
	public void setCdUsrRev(String cdUsrRev) {
		this.cdUsrRev = cdUsrRev;
	}
	public Integer getStRegistro() {
		return stRegistro;
	}
	public void setStRegistro(Integer stRegistro) {
		this.stRegistro = stRegistro;
	}
}

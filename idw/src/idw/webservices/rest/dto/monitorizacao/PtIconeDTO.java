package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="icone")
public class PtIconeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String caminhoIcone;
	private List<String> listaIconesAdicionais;
	private String corTriangulo;
	private String corBorda;
	
	public String getCaminhoIcone() {
		return caminhoIcone;
	}
	public void setCaminhoIcone(String caminhoIcone) {
		this.caminhoIcone = caminhoIcone;
	}
	public List<String> getListaIconesAdicionais() {
		return listaIconesAdicionais;
	}
	public void setListaIconesAdicionais(List<String> listaIconesAdicionais) {
		this.listaIconesAdicionais = listaIconesAdicionais;
	}
	public String getCorTriangulo() {
		return corTriangulo;
	}
	public void setCorTriangulo(String corTriangulo) {
		this.corTriangulo = corTriangulo;
	}
	public String getCorBorda() {
		return corBorda;
	}
	public void setCorBorda(String corBorda) {
		this.corBorda = corBorda;
	}
	
	
	
	
}

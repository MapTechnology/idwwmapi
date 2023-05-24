package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="perdaGanho")
public class PerdaGanhoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ResumoPerdaGanhoCicloDTO resumo;
	private List<TabelaPerdaGanhoCicloDTO> detalheCiclos;
	private List<TabelaPerdaGanhoTodosDTO> detalheTodos;
	
	public ResumoPerdaGanhoCicloDTO getResumo() {
		return resumo;
	}
	public void setResumo(ResumoPerdaGanhoCicloDTO resumo) {
		this.resumo = resumo;
	}
	public List<TabelaPerdaGanhoCicloDTO> getDetalheCiclos() {
		return detalheCiclos;
	}
	public void setDetalheCiclos(List<TabelaPerdaGanhoCicloDTO> detalheCiclos) {
		this.detalheCiclos = detalheCiclos;
	}
	public List<TabelaPerdaGanhoTodosDTO> getDetalheTodos() {
		return detalheTodos;
	}
	public void setDetalheTodos(List<TabelaPerdaGanhoTodosDTO> detalheTodos) {
		this.detalheTodos = detalheTodos;
	}
	
	
	
}

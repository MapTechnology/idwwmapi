package idw.webservices.rest.dto.monitorizacao;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tabelagraficoCep")
public class TabelaGraficoCepDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TabelaCepDTO tabelaCepDTO;
	private FiltroGraficoCepDTO filtro;
	
	
	public TabelaCepDTO getTabelaCepDTO() {
		return tabelaCepDTO;
	}
	public void setTabelaCepDTO(TabelaCepDTO tabelaCepDTO) {
		this.tabelaCepDTO = tabelaCepDTO;
	}
	public FiltroGraficoCepDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroGraficoCepDTO filtro) {
		this.filtro = filtro;
	}

}

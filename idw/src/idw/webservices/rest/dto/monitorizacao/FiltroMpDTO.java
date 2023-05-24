package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filtroMp")
public class FiltroMpDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private FiltroDetalhePostoDTO filtro; 
	private List<MpBrutaPostoDTO> listaMpBruta;
	
	public FiltroDetalhePostoDTO getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroDetalhePostoDTO filtro) {
		this.filtro = filtro;
	}
	public List<MpBrutaPostoDTO> getListaMpBruta() {
		return listaMpBruta;
	}
	public void setListaMpBruta(List<MpBrutaPostoDTO> listaMpBruta) {
		this.listaMpBruta = listaMpBruta;
	}

	
}

package idw.model.rn.alimentacao;

import java.io.Serializable;
import java.util.List;

import idw.webservices.dto.SucessoDTO;

public class MapasDTO extends SucessoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cdgt;
	private List<MapaDTO> mapas;

	
	public String getCdgt() {
		return cdgt;
	}

	public void setCdgt(String cdgt) {
		this.cdgt = cdgt;
	}

	public List<MapaDTO> getMapas() {
		return mapas;
	}

	public void setMapas(List<MapaDTO> mapas) {
		this.mapas = mapas;
	}
	
	
}

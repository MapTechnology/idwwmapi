/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class MapasAlimentacaoDTO implements Serializable {
    private List<MapaAlimentacaoDTO> mapas;

	public List<MapaAlimentacaoDTO> getMapas() {
		return mapas;
	}

	public void setMapas(List<MapaAlimentacaoDTO> mapas) {
		this.mapas = mapas;
	}

	

    
}
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
public class MapaPAsDTO implements Serializable {
    private List<MapaPaDTO> mapaPas;

	public List<MapaPaDTO> getMapaPas() {
		return mapaPas;
	}

	public void setMapaPas(List<MapaPaDTO> mapaPas) {
		this.mapaPas = mapaPas;
	}

	
    
}
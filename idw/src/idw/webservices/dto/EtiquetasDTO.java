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
public class EtiquetasDTO implements Serializable {
    private List<EtiquetaDTO> etiquetas;

	public List<EtiquetaDTO> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<EtiquetaDTO> etiquetas) {
		this.etiquetas = etiquetas;
	}

	
	
    
}
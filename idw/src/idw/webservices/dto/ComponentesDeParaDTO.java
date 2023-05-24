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
public class ComponentesDeParaDTO implements Serializable {
    private List<ComponenteDeParaDTO> componentes;

	public List<ComponenteDeParaDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteDeParaDTO> componentes) {
		this.componentes = componentes;
	}

	
    
}
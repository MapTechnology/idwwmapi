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
public class EtapasDTO implements Serializable {
    private List<EtapaDTO> etapas;

	public List<EtapaDTO> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<EtapaDTO> etapas) {
		this.etapas = etapas;
	}
			    
}
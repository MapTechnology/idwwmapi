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
public class RoteirosDTO implements Serializable {
    private List<RoteiroDTO> roteiros;

	public List<RoteiroDTO> getRoteiros() {
		return roteiros;
	}

	public void setRoteiros(List<RoteiroDTO> roteiros) {
		this.roteiros = roteiros;
	}

			    
}
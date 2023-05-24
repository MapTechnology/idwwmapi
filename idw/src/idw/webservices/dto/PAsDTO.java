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
public class PAsDTO implements Serializable {
    private List<PaDTO> pas;

	public List<PaDTO> getPas() {
		return pas;
	}

	public void setPas(List<PaDTO> pas) {
		this.pas = pas;
	}

    
}
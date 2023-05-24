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
public class TDefeitosDTO implements Serializable {
    private List<TDefeitoDTO> defeitos;

	public List<TDefeitoDTO> getDefeitos() {
		return defeitos;
	}

	public void setDefeitos(List<TDefeitoDTO> defeitos) {
		this.defeitos = defeitos;
	}
			    
}
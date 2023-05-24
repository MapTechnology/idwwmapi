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
public class TAcoesDTO implements Serializable {
    private List<TAcaoDTO> acoes;

	public List<TAcaoDTO> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<TAcaoDTO> acoes) {
		this.acoes = acoes;
	}

				    
}
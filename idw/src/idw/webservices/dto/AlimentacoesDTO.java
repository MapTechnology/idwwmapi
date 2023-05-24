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
public class AlimentacoesDTO implements Serializable {
    private List<AlimentacaoDTO> alimentacoes;

	public List<AlimentacaoDTO> getAlimentacoes() {
		return alimentacoes;
	}

	public void setAlimentacoes(List<AlimentacaoDTO> alimentacoes) {
		this.alimentacoes = alimentacoes;
	}

    
}
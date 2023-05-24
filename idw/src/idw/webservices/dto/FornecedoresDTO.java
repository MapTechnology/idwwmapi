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
public class FornecedoresDTO implements Serializable {
    private List<FornecedorDTO> fornecedores;

	public List<FornecedorDTO> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorDTO> fornecedores) {
		this.fornecedores = fornecedores;
	}

	    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sardinha
 */
public class ProdutosResumoFichaMaqDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private List<ProdutoResumoFichaMaqDTO> produtos;

	public List<ProdutoResumoFichaMaqDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoResumoFichaMaqDTO> produtos) {
		this.produtos = produtos;
	}   
}
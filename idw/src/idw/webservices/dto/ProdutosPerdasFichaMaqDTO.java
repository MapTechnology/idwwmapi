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
public class ProdutosPerdasFichaMaqDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private List<ProdutoPerdasFichaMaqDTO> produtos;

	public List<ProdutoPerdasFichaMaqDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoPerdasFichaMaqDTO> produtos) {
		this.produtos = produtos;
	}   
}
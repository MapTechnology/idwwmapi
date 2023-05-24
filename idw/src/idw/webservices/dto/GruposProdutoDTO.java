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
public class GruposProdutoDTO implements Serializable {
    private List<GrupoProdutoDTO> gruposProduto;

	public List<GrupoProdutoDTO> getGruposProduto() {
		return gruposProduto;
	}

	public void setGruposProduto(List<GrupoProdutoDTO> gruposProduto) {
		this.gruposProduto = gruposProduto;
	}
					    
}
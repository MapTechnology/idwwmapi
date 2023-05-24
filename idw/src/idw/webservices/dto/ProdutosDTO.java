/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

import idw.model.pojos.DwFolha;
import idw.model.pojos.OmProduto;

/**
 *
 * @author lineker
 */
@SuppressWarnings("serial")
public class ProdutosDTO implements Serializable {
	
	private CamposEmUsoOmCfgDTO camposEmUsoOmCfg;
    private List<ProdutoDTO> produtos;
    private ResultadoDTO resultado;
    private DwFolha dwfolha;

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	public void addOmProduto(OmProduto omproduto) {
		ProdutoDTO produto = new ProdutoDTO();
		produto.setProduto(omproduto);
		boolean isExiste = false;
		for (ProdutoDTO dto : this.produtos){
			if (dto.getProduto().getCdProduto().equals(omproduto.getCdProduto())) {
				isExiste = true;
				break;
			}
		}
		if (isExiste == false)
			this.produtos.add(produto);

	}

	public CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg() {
		return camposEmUsoOmCfg;
	}

	public void setCamposEmUsoOmCfg(CamposEmUsoOmCfgDTO camposEmUsoOmCfg) {
		this.camposEmUsoOmCfg = camposEmUsoOmCfg;
	}

	public DwFolha getDwfolha() {
		return dwfolha;
	}

	public void setDwfolha(DwFolha dwfolha) {
		this.dwfolha = dwfolha;
	}
}
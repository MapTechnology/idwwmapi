package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ConfiguracoesDTO implements Serializable {
	
    private List<ConfiguracaoDTO> configuracoes;
    private ProdutosDTO produtosSemConsumo;
    private ResultadoDTO resultado = new ResultadoDTO();
    
    
	public List<ConfiguracaoDTO> getConfiguracoes() {
		return configuracoes;
	}

	public void setConfiguracoes(List<ConfiguracaoDTO> configuracoes) {
		this.configuracoes = configuracoes;
	}
	
	public ProdutosDTO getProdutosSemConsumo() {
		return produtosSemConsumo;
	}

	public void setProdutosSemConsumo(ProdutosDTO produtosSemConsumo) {
		this.produtosSemConsumo = produtosSemConsumo;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

}
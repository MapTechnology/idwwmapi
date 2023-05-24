package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwProdutoconjugado;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.ProdutoConjugadoRN;

public class ArquivoTrilhaConjugados extends ArquivoTrilha {
	private final ProdutoConjugadoRN produtoConjugadoRN;
	private final Map<String, OmProduto> mapTodosProdutos;
	private final Map<String, Integer> mapEstagioProduto;
	private final Map<String, BigDecimal> mapMultiplicidadeProduto;
	
	public ArquivoTrilhaConjugados(DAOGenerico daoGenerico, Map<String, OmProduto> mapTodosProdutos, Map<String, Integer> mapEstagioProduto, Map<String, BigDecimal> mapMultiplicidadeProduto) {
		this.mapTodosProdutos = mapTodosProdutos;
		this.mapEstagioProduto = mapEstagioProduto;
		this.mapMultiplicidadeProduto = mapMultiplicidadeProduto;
		this.produtoConjugadoRN = new ProdutoConjugadoRN(daoGenerico);
	}
	
	@Override
	protected String getFileName() {
		return "CONJUGADAS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("AcabadoCod","ItemCod","EstagioIni","EstagioFim","Multiplicidade");
	}

	@Override
	protected String getBody() {
		
		StringBuilder sb = new StringBuilder();
		
		List<DwProdutoconjugado> listaProdutoconjugado = this.produtoConjugadoRN.getTodosProdutosConjugados();
		
		for(DwProdutoconjugado dwProdutoconjugado: listaProdutoconjugado){
			OmProduto produtoPai = dwProdutoconjugado.getOmProdutoByIdProdutopai();
			OmProduto produtoFilho = dwProdutoconjugado.getOmProdutoByIdProdutofilho();
			
			if(mapTodosProdutos.containsKey(produtoFilho.getCdProduto())){
				if(OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(produtoFilho.getTpProduto())){
					
					if(mapTodosProdutos.containsKey(produtoPai.getCdProduto())){
						sb.append(geraLinhaProdutoConjugado(dwProdutoconjugado));
					}
					
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
				}
				
			}
		}
		
		return sb.toString();
	}
	
	private String geraLinhaProdutoConjugado(DwProdutoconjugado dwProdutoconjugado){
		
		String cdProdutoPai = dwProdutoconjugado.getOmProdutoByIdProdutopai().getCdProduto();
		String cdProdutoFilho = dwProdutoconjugado.getOmProdutoByIdProdutofilho().getCdProduto();
				
		Integer estagio = ObjectUtils.defaultIfNull(mapEstagioProduto.get(cdProdutoFilho), 1);
		
		BigDecimal multiciplicadade = ObjectUtils.defaultIfNull(mapMultiplicidadeProduto.get(cdProdutoFilho), BigDecimal.ONE);
		String estagioString = new Integer(estagio.intValue()).toString();
		String multiplicidadeString = new Integer(multiciplicadade.intValue()).toString();
		
		return ArquivoTrilhaUtils.gerarLinha(cdProdutoPai, cdProdutoFilho, estagioString, estagioString, multiplicidadeString);
		
	}
	
}

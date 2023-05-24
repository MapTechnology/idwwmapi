package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.List;
import java.util.Map;

import idw.model.pojos.OmProaltglo;
import idw.model.pojos.OmProduto;

public class ArquivoTrilhaComponentesAlternativos extends ArquivoTrilha {
	private final Map<String, OmProduto> mapTodosProdutos;
	private final List<OmProaltglo> listAlternativoDireto;
	
	public ArquivoTrilhaComponentesAlternativos(Map<String, OmProduto> mapTodosProdutos, List<OmProaltglo> listAlternativoDireto){
		this.mapTodosProdutos = mapTodosProdutos;
		this.listAlternativoDireto = listAlternativoDireto;
	}
	
	@Override
	protected String getFileName() {
		return "COMPONENTES_ALTERNATIVOS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemPaiCod", "ItemFilhoOriginalCod", 
				"ComponenciaOriginal", "ItemFilhoAlternativo", "ComponenciaAlternativo", "Prioridade");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();
		
		try{
			
			for(OmProaltglo omProaltglo : this.listAlternativoDireto){
				
				// Item alternativo deve fazer parte dos produtos do planejamento
				if(mapTodosProdutos.get(omProaltglo.getOmProdutoBySemiacabado().getCdProduto()) != null){
					
					sb.append(gerarLinhaComponenteAlternativo(omProaltglo));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
			
				}
				
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	private String gerarLinhaComponenteAlternativo(OmProaltglo omProaltglo){
		OmProduto produtoOriginal = omProaltglo.getOmProdutoByIdProdutoMae();
		OmProduto produtoAlternativo = omProaltglo.getOmProdutoByIdProdutoFilho();
		String componencia = "-1";
		if(omProaltglo.getQt() != null){
			componencia = ArquivoTrilhaUtils.formataBigDecimal(omProaltglo.getQt());
		}
		
		String prioridade = "0";					
		if(produtoAlternativo.getVlCustounit() != null){
			prioridade = ArquivoTrilhaUtils.formataBigDecimal(produtoAlternativo.getVlCustounit(), 6);
		}
		
		String linha = ArquivoTrilhaUtils.gerarLinha(
				omProaltglo.getOmProdutoBySemiacabado().getCdProduto(), 
				produtoOriginal.getCdProduto(), 
				componencia, 
				produtoAlternativo.getCdProduto(),
				componencia, 
				prioridade);
		
		return linha;
	}

}

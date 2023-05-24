package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;

public class ArquivoTrilhaComponentes extends ArquivoTrilha {
	
	private final Map<String, OmProduto> mapTodosProdutos;
	
	public ArquivoTrilhaComponentes(Map<String, OmProduto> mapTodosProdutos){
		this.mapTodosProdutos = mapTodosProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "COMPONENTES.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "Origem", "CustoUnitario");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();

		Set<String> produtosJaTratados = new HashSet<String>();
		
		for (OmProduto omproduto : this.mapTodosProdutos.values()){
			
			if(produtosJaTratados.add(omproduto.getCdProduto())){
			
				if(OmProdutoTemplate.TpProduto.COMPONENTE.equals(omproduto.getTpProduto())){
				
					sb.append(gerarLinhaComponente(omproduto));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
					
				}

			}
		}

		return sb.toString();
	}

	
	private String gerarLinhaComponente(OmProduto omProduto){
		
		String tpOrigem = "-1";
		if (omProduto.getTpOrigem() != null) {
			
			if (omProduto.getTpOrigem() == OmProdutoTemplate.TpOrigem.IMPORTADO.getId())
				tpOrigem = "I";
			else if (omProduto.getTpOrigem() == OmProdutoTemplate.TpOrigem.NACIONAL.getId())
				tpOrigem = "N";
			else if (omProduto.getTpOrigem() == OmProdutoTemplate.TpOrigem.LOCAL.getId())
				tpOrigem = "L";
			
		}	
		
		
		String vlCustoUnit = "0";
		if(omProduto.getVlCustounit() != null){
			vlCustoUnit = ArquivoTrilhaUtils.formataBigDecimal(omProduto.getVlCustounit(), 6);// custounitario 6 casas decimais	
		}
		
		return ArquivoTrilhaUtils.gerarLinha(ArquivoTrilhaUtils.formatarRegistro(omProduto.getCdProduto()), tpOrigem, vlCustoUnit);
		
	}
	
}

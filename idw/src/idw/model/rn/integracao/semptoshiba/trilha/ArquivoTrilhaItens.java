package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;

public class ArquivoTrilhaItens extends ArquivoTrilha {
	private final Map<String, OmProduto> mapTodosProdutos;
	
	public ArquivoTrilhaItens(Map<String, OmProduto> mapTodosProdutos){
		this.mapTodosProdutos = mapTodosProdutos;		
	}
	
	@Override
	protected String getFileName() {	
		return "ITENS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("Codigo", "Descricao", "Unidade", "TipoItemCod");
	}

	@Override
	protected String getBody() {
		
		StringBuilder sb = new StringBuilder();
		
		Set<String> produtosJaTratados = new HashSet<String>();

		for (OmProduto omproduto : this.mapTodosProdutos.values()) {
			
			if (produtosJaTratados.add(omproduto.getCdProduto())) {
				
				sb.append(gerarLinhaItens(omproduto));
				sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
				
			}
		}
		
		return sb.toString();
		
	}
	
	private String gerarLinhaItens(OmProduto omproduto){
		
		String cdProduto = ArquivoTrilhaUtils.formatarRegistro(omproduto.getCdProduto());
		String dsProduto = ArquivoTrilhaUtils.formatarRegistro(omproduto.getDsProduto());
		String unidMedida = "-1";
		if (omproduto.getOmUnidmedida() != null){
			unidMedida = ArquivoTrilhaUtils.formatarRegistro(omproduto.getOmUnidmedida().getCdUnidmedida());
		}
		
		String tpProduto = "-1";
		
		if (OmProdutoTemplate.TpProduto.COMPONENTE.equals(omproduto.getTpProduto())){
			tpProduto = "1"; //materia-prima
		}else if (OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omproduto.getTpProduto())){
			tpProduto = "3"; // semi-acabado
		}else if (OmProdutoTemplate.TpProduto.PRODUTO_FINAL.equals(omproduto.getTpProduto())){
			tpProduto = "0"; // acabado
        }else if (OmProdutoTemplate.TpProduto.AGRUPADOR.equals(omproduto.getTpProduto())){
        	tpProduto = "2"; // fantasma
        }
		
		return ArquivoTrilhaUtils.gerarLinha(cdProduto, dsProduto, unidMedida, tpProduto);
	}
	
	
}

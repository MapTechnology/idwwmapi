package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ArquivoTrilhaRecursos extends ArquivoTrilha {	
	private final List<String> listPtsComOperacoesSorted = new ArrayList<String>();
	
	public ArquivoTrilhaRecursos(Collection<String> listPtsComOperacoes) {
		listPtsComOperacoesSorted.addAll(listPtsComOperacoes);
		Collections.sort(listPtsComOperacoesSorted);
	}
	
	@Override
	protected String getFileName() {
		return "RECURSOS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("Codigo","Descricao","AreaCod","CentroCod","GrupoMaquinaCod");
	}
	
	
	@Override
	protected String getBody() {

		StringBuilder sb = new StringBuilder();

		
		for (String cdProduto : this.listPtsComOperacoesSorted) {
			
			sb.append(gerarLinhaTipoOperacoes(cdProduto));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		}
		
		return sb.toString();
		
	}
	
	
	private String gerarLinhaTipoOperacoes(String codigo){
		return ArquivoTrilhaUtils.gerarLinha(codigo, ArquivoTrilhaUtils.formatarRegistro(codigo), "-1", "-1", "-1");
	}

}

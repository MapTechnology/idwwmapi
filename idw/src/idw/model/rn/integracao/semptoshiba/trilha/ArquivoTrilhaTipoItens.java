package idw.model.rn.integracao.semptoshiba.trilha;


public class ArquivoTrilhaTipoItens extends ArquivoTrilha {	
	
	public ArquivoTrilhaTipoItens() {
	}
	
	@Override
	protected String getFileName() {
		return "TIPO_ITENS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("Codigo","Descricao");
	}
	
	
	@Override
	protected String getBody() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(gerarLinhaTiposItens("0","PRODUTO FINAL"));
		sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		sb.append(gerarLinhaTiposItens("1","MATERIA-PRIMA"));
		sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		sb.append(gerarLinhaTiposItens("2","FANTASMA"));
		sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		sb.append(gerarLinhaTiposItens("3","SEMIACABADO"));
		sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);		
		return sb.toString();
		
	}
	
	private String gerarLinhaTiposItens(String codigo, String descricao){
		return ArquivoTrilhaUtils.gerarLinha(codigo, descricao);
	}
	
}

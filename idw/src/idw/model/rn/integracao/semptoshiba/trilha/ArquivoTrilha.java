package idw.model.rn.integracao.semptoshiba.trilha;


public abstract class ArquivoTrilha {
	
	protected abstract String getFileName();	
	protected abstract String getHeader();
	protected abstract String getBody();
	
	public ArquivoTrilhaDTO getArquivoTrilhaDTO(){
		return ArquivoTrilhaUtils.getArquivoTrilhaDTO(this);
	}
//	
//	protected String gerarLinha(String... campos){
//		return ArquivoTrilhaUtils.gerarLinha(campos);
//		
//	}
//	
//	protected String formataDecimal(Double decimal) {
//		return ArquivoTrilhaUtils.formataDecimal(decimal);
//	}
//
//	protected String formataBigDecimal(BigDecimal decimal, int casasDecimais) {
//		return ArquivoTrilhaUtils.formataBigDecimal(decimal, casasDecimais);
//	}
//	
//	protected String formatarRegistro(String string) {
//		return ArquivoTrilhaUtils.formatarRegistro(string);
//	}
//
//	protected String formataBigDecimal(BigDecimal decimal) {		
//		return ArquivoTrilhaUtils.formataBigDecimal(decimal, 2);
//	}
	
}

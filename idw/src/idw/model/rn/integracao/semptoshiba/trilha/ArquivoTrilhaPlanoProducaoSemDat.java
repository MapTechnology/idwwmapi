package idw.model.rn.integracao.semptoshiba.trilha;

public class ArquivoTrilhaPlanoProducaoSemDat extends ArquivoTrilha {
	public String linhasPlanoProducaoSemDat;
	public String header;
	
	public ArquivoTrilhaPlanoProducaoSemDat(String linhasPlanoProducaoSemDat, String header){
		this.linhasPlanoProducaoSemDat = linhasPlanoProducaoSemDat;
		this.header = header;
	}
		
	@Override
	protected String getFileName() {
		return "PLANO_PRODUCAO.txt";
	}

	@Override
	protected String getHeader() {
		return header;
	}

	@Override
	protected String getBody() {
		return linhasPlanoProducaoSemDat;
	}

}

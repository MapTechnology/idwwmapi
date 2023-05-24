package idw.model.rn.integracao.semptoshiba.trilha;

public class ArquivoTrilhaPlanoProducaoComDat extends ArquivoTrilha {
	public String linhasPlanoProducaoComDat;
	public String header;
	
	public ArquivoTrilhaPlanoProducaoComDat(String linhasPlanoProducaoComDat, String header){
		this.linhasPlanoProducaoComDat = linhasPlanoProducaoComDat;
		this.header = header;
	}
		
	@Override
	protected String getFileName() {
		return "PLANO_PRODUCAO_DAT.txt";
	}

	@Override
	protected String getHeader() {
		return header;
	}

	@Override
	protected String getBody() {
		return linhasPlanoProducaoComDat;
	}

}

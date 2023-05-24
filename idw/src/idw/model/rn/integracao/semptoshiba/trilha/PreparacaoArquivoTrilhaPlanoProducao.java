package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.List;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;

public class PreparacaoArquivoTrilhaPlanoProducao {
	private final List<PpPlano> listPlanosProducao;
	private String linhasPlanoProducaoSemDat = "";
	private String linhasPlanoProducaoComDat = "";
	
	public PreparacaoArquivoTrilhaPlanoProducao(final List<PpPlano> listPlanosProducao){
		this.listPlanosProducao = listPlanosProducao;
		prepararLinhasPlanoProducao();
	}
	
	public String getLinhasArquivoTrilhaPlanoProducaoSemDat(){
		return linhasPlanoProducaoSemDat;
	}
	

	public String getLinhasArquivoTrilhaPlanoProducaoComDat(){
		return linhasPlanoProducaoComDat;
	}
	
	public String getHeader(){
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "DataEntrega", "Quantidade", "CentroCustoCod");
	}
	
	private String gerarLinhaPlanoProducao(PpPlanec ppplanec , PpNeccron ppneccron, boolean isProdutoDAT){

		String cdProduto = ppplanec.getPpNec().getOmProduto().getCdProduto();
		
		String dataEntrega  = DataHoraRN.dateToString(ppneccron.getDtDesejada(), "dd/MM/yyyy");

		String qtDesejada = ArquivoTrilhaUtils.formataDecimal(ppneccron.getQtDesejada());
		
		// centrocustocod
		String centroCustoCod = ArquivoTrilhaUtils.SEM_VALOR;
		if(isProdutoDAT == false){
			if (ppplanec.getPpNec().getOmPt() != null){
				if(ppplanec.getPpNec().getOmPt().getIdPt() != null){
					centroCustoCod = ppplanec.getPpNec().getOmPt().getCdPt(); 
				}
			}
		}
		
		return ArquivoTrilhaUtils.gerarLinha(cdProduto, dataEntrega, qtDesejada, centroCustoCod);
	}
	
	private void prepararLinhasPlanoProducao(){
		StringBuilder sbPlanoProducao = new StringBuilder();
		StringBuilder sbPlanoProducaoDat = new StringBuilder();
		
		for (PpPlano ppPlano : this.listPlanosProducao) {
			for (PpPlanec ppplanec : ppPlano.getPpPlanecs()){
				for (PpNeccron ppneccron : ppplanec.getPpNec().getPpNeccrons()) {
					
					StringBuilder sb = null;
					//boolean isProdutoDAT = OmProdutoTemplate.TpProduto.PRODUTO_FINAL.equals(ppplanec.getPpNec().getOmProduto().getTpProduto());
					OmProduto omProduto = ppplanec.getPpNec().getOmProduto();
					boolean isProdutoDAT = (omProduto.getIsDat() != null) && omProduto.getIsDat();
					
					if(isProdutoDAT){
						sb = sbPlanoProducaoDat;
					}else{
						sb = sbPlanoProducao;
					}
					
					sb.append(gerarLinhaPlanoProducao(ppplanec, ppneccron, isProdutoDAT));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
					
				}
			}
		}

		linhasPlanoProducaoSemDat = sbPlanoProducao.toString();
		linhasPlanoProducaoComDat = sbPlanoProducaoDat.toString();

	}
	
	
}

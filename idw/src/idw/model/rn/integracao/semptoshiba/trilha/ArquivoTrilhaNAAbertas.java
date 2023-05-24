package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.List;
import java.util.Map;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCmcom;
import idw.model.rn.DataHoraRN;

public class ArquivoTrilhaNAAbertas extends ArquivoTrilha {
	
	private final Map<String, OmProduto> mapTodosProdutos;
	private final List<PpCmcom> listAlternativoNA;
	
	public ArquivoTrilhaNAAbertas(final List<PpCmcom> listAlternativoNA, final Map<String, OmProduto> mapTodosProdutos){
		this.listAlternativoNA = listAlternativoNA;
		this.mapTodosProdutos = mapTodosProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "NA_ABERTAS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("NACod", "ItemPaiCod", "ItemFilhoOriginalCod", "ComponenciaOriginal", 
				"ItemFilhoAlternativoCod", "ComponenciaAlternativo", "DataEntrada", "DataSaida", "Prioridade");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();

		try{
			
			for(PpCmcom ppCmcom: this.listAlternativoNA){
				
				// Item alternativo deve fazer parte dos produtos do planejamento
				if(mapTodosProdutos.get(ppCmcom.getOmProdutoByFinal().getCdProduto()) != null){
					
					sb.append(gerarLinhaNAAberta(ppCmcom));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);

				}
				
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return sb.toString();
	}

	
	private String gerarLinhaNAAberta(PpCmcom ppCmcom){
		
		String dataEntra = "";
		if(ppCmcom.getPpCm().getDthrVigor() != null){
			dataEntra =DataHoraRN.dateToString(ppCmcom.getPpCm().getDthrVigor(), "dd/MM/yyyy");
		}
			
		String dataSai = "";
		if(ppCmcom.getPpCm().getDthrSai() != null){
			dataSai =DataHoraRN.dateToString(ppCmcom.getPpCm().getDthrSai(), "dd/MM/yyyy");
		}
		
		String cdItemEntra = "";
		if(ppCmcom.getOmProdutoByIdProdutoentra() != null){
			cdItemEntra = ppCmcom.getOmProdutoByIdProdutoentra().getCdProduto();
		}
		
		String cdItemSai = "";
		if(ppCmcom.getOmProdutoByIdProdutosai() != null){
			cdItemSai = ppCmcom.getOmProdutoByIdProdutosai().getCdProduto();
		}
		
		return ArquivoTrilhaUtils.gerarLinha(
				ppCmcom.getPpCm().getCdCm(), 
				ppCmcom.getOmProdutoByFinal().getCdProduto(),
				cdItemSai,
				ArquivoTrilhaUtils.formataBigDecimal(ppCmcom.getQtSai()),							
				cdItemEntra,
				ArquivoTrilhaUtils.formataBigDecimal(ppCmcom.getQtEntra()), 
				dataEntra,
				dataSai,
				"1");
	}
	
}

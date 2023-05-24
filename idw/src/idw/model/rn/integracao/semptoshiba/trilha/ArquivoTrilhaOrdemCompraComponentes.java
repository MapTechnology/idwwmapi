package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.estoque.EstoqueRN;

public class ArquivoTrilhaOrdemCompraComponentes extends ArquivoTrilha {
	private final OmCfg omCfg;
	private final DAOGenerico daoGenerico;
	private final Map<String, OmProduto> mapTodosProdutos;
	
	public ArquivoTrilhaOrdemCompraComponentes(OmCfg omCfg, DAOGenerico daoGenerico, Map<String, OmProduto> mapTodosProdutos){
		this.omCfg = omCfg;
		this.daoGenerico = daoGenerico;
		this.mapTodosProdutos = mapTodosProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "ORDENS_COMPRA_COMPONENTES.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "DataEntrega", "Quantidade");
	}

	@Override
	protected String getBody() {
		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		
		StringBuilder sb = new StringBuilder();

		DwEst dwEstMP = omCfg.getDwEstByIdEstmp();
		
		EstoqueRN estoqueRN = new EstoqueRN(daoGenerico);
	
		if(dwEstMP != null){
			
			Set<String> produtosJaTratados = new HashSet<String>();
			
			List<DwEstmov> listaDwEstMov = estoqueRN.getDwEstmovPeriodo(dwEstMP, dthrAtual, null);
			
			for(DwEstmov dwEstmov: listaDwEstMov){
				
				OmProduto omProduto = dwEstmov.getDwEstpro().getOmProduto();
				
				if(mapTodosProdutos.get(omProduto.getCdProduto()) != null){
				
					if(OmProdutoTemplate.TpProduto.COMPONENTE.equals(omProduto.getTpProduto())
							|| OmProdutoTemplate.TpProduto.AGRUPADOR.equals(omProduto.getTpProduto()) ){
						
						if (produtosJaTratados.add(omProduto.getCdProduto())){
							
							if(DataHoraRN.after(dwEstmov.getDthrMov(), dthrAtual)){
	
								sb.append(gerarLinhaOrdemCompraComponente(omProduto, dwEstmov));
								sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
							}
							
						}					
					}
				}
			}
		}

		return sb.toString();
	}

	private String gerarLinhaOrdemCompraComponente(OmProduto omProduto, DwEstmov dwEstmov) {
		String cdProduto = ArquivoTrilhaUtils.formatarRegistro(omProduto.getCdProduto());
		String dataEntrega = DataHoraRN.dateToString(dwEstmov.getDthrMov(), "dd/MM/yyyy");
		
		String quantidade = ArquivoTrilhaUtils.formataBigDecimal(dwEstmov.getQtAjuste());
		return ArquivoTrilhaUtils.gerarLinha(cdProduto, dataEntrega, quantidade);
	}	
}

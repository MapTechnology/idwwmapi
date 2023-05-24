package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.List;
import java.util.Map;

import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmProduto;
import idw.model.rn.integracao.semptoshiba.dao.ApAbertaDao;
import idw.model.rn.integracao.semptoshiba.pojos.ApAberta;

public class ArquivoTrilhaApsAbertas extends ArquivoTrilha {	
	private final Map<String, OmProduto> mapTodosProdutos;
	
	public ArquivoTrilhaApsAbertas(Map<String, OmProduto> mapTodosProdutos) {
		this.mapTodosProdutos = mapTodosProdutos;
	}
	
	@Override
	protected String getFileName() {
		return "AP_ABERTAS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ApCod","PlacaCod","Qtd","TipoApDat");
	}

	@Override
	protected String getBody() {
		
		StringBuilder sb = new StringBuilder();
		
		DAOGenericoErp daoGenericoErp =  new DAOGenericoErp();
		
		try{
			daoGenericoErp.iniciaConexaoBanco(null);
		
			ApAbertaDao apAbertaDao = new ApAbertaDao(daoGenericoErp);
			
			List<ApAberta> listaProdutoconjugado = apAbertaDao.getApsAbertas();
			
			for(ApAberta apAberta: listaProdutoconjugado){
				
				if(mapTodosProdutos.containsKey(apAberta.getCodModelo())){
					
					if((apAberta.getSaldoProduzir() > 0) && (apAberta.getIsLiberado())){
						
						sb.append(geraLinhaApAberta(apAberta));
						sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
						
					}
					
				}
			}
			
			daoGenericoErp.commitaTransacao(daoGenericoErp.getSession());
			
		}catch(Exception e){
			e.printStackTrace();
			daoGenericoErp.rollBackTransacaoSemException();
		}finally{
			daoGenericoErp.finalizaConexaoBancoSemException();
		}
		
		return sb.toString();
	}
	
	private String geraLinhaApAberta(ApAberta apAberta){
		
		String tipoDat = (apAberta.getIsDat() ? "1" : "0");
		String saldo = new Integer(apAberta.getSaldoProduzir().intValue()).toString();
		
		return ArquivoTrilhaUtils.gerarLinha(apAberta.getNumAp(), apAberta.getCodModelo(), saldo, tipoDat);
		
	}
	
}

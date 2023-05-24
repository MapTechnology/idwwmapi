package idw.model.rn.integracao.semptoshiba.trilha;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmProduto;
import idw.model.pojos.template.DwFolhaTemplate.TpFolha;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmTpptTemplate.Type;
import idw.model.rn.FolhaRN;
import idw.model.rn.RoteiroRN;

public class ArquivoTrilhaPlacas extends ArquivoTrilha {
	private final Map<String, OmProduto> mapTodosProdutos;
	private final DAOGenerico daoGenerico;
	private final Map<String, BigDecimal> mapMulticiplicidadeProduto = new HashMap<String, BigDecimal>();
	private static int ESTOQUE_SEGURANCA_PADRAO = 0;
	
	public ArquivoTrilhaPlacas(DAOGenerico daoGenerico, Map<String, OmProduto> mapTodosProdutos){
		this.daoGenerico = daoGenerico;
		this.mapTodosProdutos = mapTodosProdutos;		
	}
	
	@Override
	protected String getFileName() {
		return "PLACAS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "Multiplicidade", "EstoqueSeg");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();
		
		Set<String> listaCdPlacasJaTratadas = new HashSet<String>();
		

		RoteiroRN rn = new RoteiroRN();
		rn.setDaoSession(daoGenerico.getSession());
		
		FolhaRN folhaRN = new FolhaRN(daoGenerico); 
		
		for(OmProduto omProduto: this.mapTodosProdutos.values()){
			
			if(OmProdutoTemplate.TpProduto.SEMI_ACABADO.equals(omProduto.getTpProduto())){
				if(listaCdPlacasJaTratadas.add(omProduto.getCdProduto())){
					sb.append(gerarLinhaPlaca(folhaRN, omProduto));
					sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);					
				}
			}
			
		}
		
		return sb.toString();

	}

	public Map<String, BigDecimal> getMapMulticiplicidadeProduto(){
		return this.mapMulticiplicidadeProduto;
	}
	
	private String gerarLinhaPlaca(FolhaRN folhaRN, OmProduto omProduto){
		BigDecimal multiplicidade = folhaRN.getPcsPorCicloAtivasEmDwFolhaIACComTpFolhaETpPt(omProduto.getCdProduto(), TpFolha.PROGRAMA_IAC, Type.IAC);
		
		if(multiplicidade == null || multiplicidade.compareTo(BigDecimal.ONE) < 0){
			multiplicidade = BigDecimal.ONE;
		}
		String multiplicidadeString = ArquivoTrilhaUtils.formataBigDecimal(multiplicidade);
		
		this.mapMulticiplicidadeProduto.put(omProduto.getCdProduto(), multiplicidade);
		
		String indPerdaProducao = String.valueOf(ESTOQUE_SEGURANCA_PADRAO);
		if(omProduto.getIndPerdaproducao() != null){
			indPerdaProducao = ArquivoTrilhaUtils.formataBigDecimal(omProduto.getIndPerdaproducao());
		}
		

		return ArquivoTrilhaUtils.gerarLinha(ArquivoTrilhaUtils.formatarRegistro(omProduto.getCdProduto()), multiplicidadeString, indPerdaProducao);
	}
}

package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.Map;

import idw.model.pojos.OmProduto;

public class ArquivoTrilhaAcabados extends ArquivoTrilha {
	
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos;
	
	public ArquivoTrilhaAcabados(Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos){
		this.mapProdutosFinaisDoPlanoProducaoTodos = mapProdutosFinaisDoPlanoProducaoTodos;
	}
	
	@Override
	protected String getFileName() {
		return "ACABADOS.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("ItemCod", "GrupoCod", "FamiliaCod", "LeadTime", "MargemUnitaria");
	}

	@Override
	protected String getBody() {
		StringBuilder sb = new StringBuilder();
		
		for(OmProduto omproduto: mapProdutosFinaisDoPlanoProducaoTodos.values()){
				
			sb.append(gerarLinhaAcabado(omproduto));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
			
		}

		return sb.toString();
	}
	
	private String gerarLinhaAcabado(OmProduto omproduto){

		String cliente = ArquivoTrilhaUtils.SEM_VALOR;
		if (omproduto.getPpCliente() != null) {
			cliente = omproduto.getPpCliente().getCdCliente();
		}
		
		String familia = ArquivoTrilhaUtils.SEM_VALOR;
		if (omproduto.getOmProgrp() != null) {
			familia = omproduto.getOmProgrp().getCdProgrp();
		}

		String leadTime = "0";
		if (omproduto.getHrLeadtimesaida() != null) {
			leadTime = ArquivoTrilhaUtils.formataBigDecimal(omproduto.getHrLeadtimesaida());
		}
		
		return ArquivoTrilhaUtils.gerarLinha(ArquivoTrilhaUtils.formatarRegistro(omproduto.getCdProduto()), cliente, familia, leadTime, ArquivoTrilhaUtils.SEM_VALOR); 
	}
}

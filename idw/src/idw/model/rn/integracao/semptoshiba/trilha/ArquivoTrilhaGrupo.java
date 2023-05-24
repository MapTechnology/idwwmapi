package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmProgrpDAO;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.PpCliente;
import idw.model.rn.integracao.semptoshiba.IntegracaoEstruturaProduto;

public class ArquivoTrilhaGrupo extends ArquivoTrilha {
	private final DAOGenerico daoGenerico; 
	private final Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos;
	
	public ArquivoTrilhaGrupo(DAOGenerico daoGenerico, Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos){
		this.daoGenerico = daoGenerico;
		this.mapProdutosFinaisDoPlanoProducaoTodos = mapProdutosFinaisDoPlanoProducaoTodos;		
	}
	
	@Override
	protected String getFileName() {
		return "GRUPOS.txt";
	}

	@Override
	protected String getHeader() {		
		return ArquivoTrilhaUtils.gerarLinha("Codigo","Descricao");
	}
	
	
	@Override
	protected String getBody() {
		if(IntegracaoEstruturaProduto.USAR_GRUPO_PRODUTO_PELA_TABELA_CLIENTE){
			return getArquivoGruposDePpCliente();
		}else{
			return getBodyFromDwOmProgrp();
		}		
	}

	private String gerarLinhaGrupo(String codigo, String descricao){
		return ArquivoTrilhaUtils.gerarLinha(codigo, descricao);
	}

	private String getBodyFromDwOmProgrp() {
		
		OmProgrpDAO omProgrpDAO = new OmProgrpDAO(daoGenerico.getSession()); 
		
		List<OmProgrp> listaOmProgrp = omProgrpDAO.getTodosOmProgrpExcetoPadrao();

		StringBuilder sb = new StringBuilder();
		
		for (OmProgrp omProgrp : listaOmProgrp) {
			sb.append(gerarLinhaGrupo(omProgrp.getCdProgrp(), omProgrp.getDsProgrp()));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		}
		return sb.toString();
	}
	

	private String getArquivoGruposDePpCliente() {
		
		StringBuilder sb = new StringBuilder();
		
		Collection<PpCliente> listaPpCliente = getClientesProdutosFinalPlano(mapProdutosFinaisDoPlanoProducaoTodos);
		
		for (PpCliente ppCliente : listaPpCliente) {
			sb.append(gerarLinhaGrupo(ppCliente.getCdCliente(), ppCliente.getNmCliente()));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		}

		return sb.toString();
	}	
	
	private Collection<PpCliente> getClientesProdutosFinalPlano(Map<String, OmProduto> mapProdutosFinaisDoPlanoProducaoTodos){
		Map<String, PpCliente> clientes = new HashMap<String, PpCliente>();
		
		for(OmProduto omProduto: mapProdutosFinaisDoPlanoProducaoTodos.values()){
			PpCliente ppCliente = omProduto.getPpCliente();
			if(ppCliente != null){
				clientes.put(ppCliente.getCdCliente(), ppCliente);	
			}
		}
		return clientes.values();
	}

}

package idw.model.rn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.util.Util;
import idw.webservices.dto.AcoplamentoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import injetws.model.excessoes.SemSGBDException;


public class VerificaAcoplamentoRN extends DAOGenerico {
	
	public AcoplamentoDTO verificaAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagensOriginal) {
		AcoplamentoDTO retorno = new AcoplamentoDTO();
		
		// instancia o ProdutoRN
		ProdutoRN oProdutoRN = new ProdutoRN();
		oProdutoRN.getDao().setSession(getDao().getSession());
		
		// pegando configuracao geral do sistema
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(getDao().getSession());
		if(oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getSEM_CONFIGURACAO());
			return retorno;
		}
		
		// extrai codigo do produto do codigo de barras
		// produto = acoplamento.cb usando om_cfg.mascaraCdProdutoFilho
		String cdProduto = Util.extraiPorMascara(acoplamento.getCb(), oOmCfg.getMascaracdprodutomp());
		
		// verifica se o produto filho (componente) existe
		OmProduto oOmProduto = null;
		try {
			oOmProduto = oProdutoRN.getOmProduto(cdProduto);
		} catch (RegistroDesconhecidoException e){
			oOmProduto = null;
		}
		// se n�o existir registro
		if(oOmProduto == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
			return(retorno);
		}
		else { // se existir
			retorno.setIdProduto(oOmProduto.getIdProduto()); // = id_produto do 1o registro encontrado
		}
		
		// Obtem o omproduto para o componente esperado
		OmProduto omprodutoEsperado = oProdutoRN.getDao().findById(OmProduto.class, acoplamento.getIdProduto(), false);
		
		// verifica se o produto filho (componente) pode ser acoplado ao produto pai
		DwFolhamon oDwFolhamon = null;
		oDwFolhamon = this.verificaProdutoAcoplaPai(acoplamento.getIdFolha());
		
		if(oDwFolhamon == null) {
			//System.out.println("Folha " + acoplamento.getIdFolha() + " nao tem montagem.");
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO());
			return(retorno);
		}
		
		retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_NAO_ACEITO());
		
		
		// Verifica se o produto acoplado eh o mesmo esperado. se for diferente retornor produto nao aceito
		// As linhas abaixo foram comentadas pq o produto esperado pode ser um de uma lista de possiveis
//		if (acoplamento.getIdProduto() != oOmProduto.getIdProduto())
//			return retorno;
		
		// Verifica se o produto acoplado eh um da lista de produtos possiveis para o mesmo agrupador
		boolean isExiste = false;
		List<Long> idsAgrup = new ArrayList<Long>();
		for (DwFolhamoncomp dwfolhamoncomp : oDwFolhamon.getDwFolhamoncomps()){
			if (!idsAgrup.contains(dwfolhamoncomp.getOmProduto().getOmProdutoByIdProdutoagru().getIdProduto())){
				idsAgrup.add(dwfolhamoncomp.getOmProduto().getOmProdutoByIdProdutoagru().getIdProduto());
			}
			if (dwfolhamoncomp.getOmProduto().getIdProduto() == oOmProduto.getIdProduto() &&
					dwfolhamoncomp.getOmProduto().getOmProdutoByIdProdutoagru().getIdProduto() == omprodutoEsperado.getOmProdutoByIdProdutoagru().getIdProduto()) {
				isExiste = true;
			}
		}
		if (isExiste == false){
			return retorno;
		}
		
		
		retorno.setIdProduto(oOmProduto.getIdProduto());
		retorno.setIdProdutoAcoplado(oOmProduto.getIdProduto());
		retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());

		// varrer dw_folhamoncomp
//		for(DwFolhamoncomp oDwFolhamoncomp : oDwFolhamon.getDwFolhamoncomps()) {
//			// se existir produto = om_produto.depara
//			if(cdProduto.equals(oDwFolhamoncomp.getOmProduto().getDepara())) {
//				retorno.setIdProduto(oDwFolhamoncomp.getOmProduto().getIdProduto());
//				retorno.setIdProdutoAcoplado(oDwFolhamoncomp.getOmProduto().getIdProduto());
//				retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
//			}
//			else { //se n�o, verificar se pode ser um alternativo
//				// se dw_folhamoncomp.is_aceitarALter {
//				if(oDwFolhamoncomp.getIsAceitarAlter() == true) {
//					// varrer lista em om_proaltglo (select acima)
//					for(OmProaltglo oOmProaltglo : oDwFolhamoncomp.getOmProduto().getOmProaltglosForIdProdutoMae()) {
//						// se produto = om_produto.depara(com alias A)
//						if(cdProduto.equals(oOmProaltglo.getOmProdutoByIdProdutoFilho().getDepara())) {
//							retorno.setIdProduto(oOmProaltglo.getOmProdutoByIdProdutoFilho().getIdProduto());
//							retorno.setIdProdutoAcoplado(oOmProaltglo.getOmProdutoByIdProdutoFilho().getIdProduto());
//							retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
//						}
//					}
//					
//				}
//			}
//		}
		
		// se for encontrado um produto valido, entao verificar se � o ultimo produto filho a ser lido (retorno.id_mensagem = COM SUCESSO) {
		if(retorno.getResultado().getIdmensagem() == retorno.getResultado().getCOM_SUCESSO()) {
			
			// adicionar om_produto.id_produto em ListaDeMontagemOriginal
			MontagemDTO oMontagemDTO = new MontagemDTO();
			oMontagemDTO.setIdProdutoEsperado(oOmProduto.getIdProduto());
			
			montagensOriginal.getListaMontagem().add(oMontagemDTO);
			
			// Verifica se eh o ultimo produto
			if (idsAgrup.size() == montagensOriginal.getListaMontagem().size() ) {
				retorno.getResultado().setIdmensagem(retorno.getResultado().getACOPLAMENTO_FINALIZADO());
			}
			
		}
		
		return(retorno);
	}
	
	private DwFolhamon verificaProdutoAcoplaPai(Long idFolha) {
		String hql = "";
		
		//select * 
		//from dw_folhamon 
		//	join dw_folhamoncomp on dw_folhamoncomp.id_folhamon = dw_folhamon.id_folhamon
		//	join om_produto on om_produto.id_produto = dw_folhamoncomp.id_produto
		//	left join om_proaltglo on om_proaltglo.id_produtoMae = om_produto.id_produto
		//	left join om_produto A on A.id_produto = om_proaltglo.id_produtoFilho
		//where dw_folhamon.id_folha = acoplamento.id_folha
		
		hql += "SELECT dwfolhamon ";
		hql += "FROM DwFolhamon dwfolhamon ";
		hql += "JOIN dwfolhamon.dwFolhamoncomps dwfolhamoncomps ";
		hql += "JOIN dwfolhamoncomps.omProduto omproduto ";
		hql += "LEFT JOIN omproduto.omProaltglosForIdProdutoMae proaltglomae ";
		hql += "LEFT JOIN proaltglomae.omProdutoByIdProdutoFilho prodfilho ";
		hql += "WHERE (dwfolhamon.dwFolha.idFolha = ::idFolha)";
		
		hql = hql.replaceAll("::idFolha", idFolha.toString());
		
		DwFolhamon oDwFolhamon = null;
		try {
			oDwFolhamon = Util.getDadosBanco(new DwFolhamon(), getDao().getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: papoco do trovao, ??????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwFolhamon = null; // soh para reforcar
		}
		
		return(oDwFolhamon);
	}
	
	public AcoplamentoDTO verificaComponenteAcoplamento(AcoplamentoDTO acoplamento, MontagensDTO montagensOriginal) {
		AcoplamentoDTO retorno = new AcoplamentoDTO();
		
		// instancia o ProdutoRN
		ProdutoRN oProdutoRN = new ProdutoRN();
		oProdutoRN.getDao().setSession(this.getDao().getSession());
		
		// pegando configuracao geral do sistema
		OmCfg oOmCfg = null;
		oOmCfg = Util.getConfigGeral(this.getDao().getSession());
		if(oOmCfg == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getERROR_SEM_CALENDARIO());
			return retorno;
		}
		
		// extrai codigo do produto do codigo de barras
		// produto = acoplamento.cb usando om_cfg.mascaraCdProdutoFilho
		String cdProduto = Util.extraiPorMascara(acoplamento.getCb(), oOmCfg.getMascaracdprodutomp());
		
		// verifica se o produto filho (componente) existe
		OmProduto oOmProduto = null;
		oOmProduto = oProdutoRN.getProdutoByDepara(cdProduto);
		
		// se n�o existir registro
		if(oOmProduto == null) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
			return(retorno);
		}
		else { // se existir
			retorno.setIdProduto(oOmProduto.getIdProduto()); // = id_produto do 1o registro encontrado
		}
		
		retorno.setIdProduto(oOmProduto.getIdProduto());
		retorno.setIdProdutoAcoplado(oOmProduto.getIdProduto());
		retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());

		// Obtenho o numero de serie do cbProduto
		// Obtenho a ultima montagem para o numero de serie
		// Verifico se o produto lido pertence a ultima montagem
		// Se n�o pertencer, produto nao pertence a estrutura original do produto
		// Se pertencer retorna com sucesso.
		PostoMontagemRN prn = new PostoMontagemRN();
		prn.setSession(getDao().getSession());
		
		DwNserie nserie = null;
		NumeroSerieRN rn = new NumeroSerieRN();
		rn.setDaoSession(getDao().getSession());
		try {
			nserie = rn.getDwNserieCb(acoplamento.getCdProduto());
		} catch (NumeroSerieIrregularException e){
			retorno.getResultado().setIdmensagem(retorno.getResultado().getPRODUTO_DESCONHECIDO());
			return(retorno);
		}
		DwPassagem passagem = nserie.getDwPassagem();
		Set<DwPassmon> montagem = passagem.getDwPassmons();
		boolean isExiste = false;
		for (DwPassmon dwpassmon : montagem){
			if (dwpassmon.getOmProduto().getIdProduto() == oOmProduto.getIdProduto()){
				isExiste = true;
				break;
			}
		}
		if (isExiste == false){
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOMPONENTE_NAO_PERTENCE_AO_PRODUTO());
		}
		return(retorno);
	}
}

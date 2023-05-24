package idw.model.rn.integracao.semptoshiba;

import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwEst;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwEstMovTemplate.TpOrigem;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.integracao.semptoshiba.api.Apontamento;
import idw.model.rn.integracao.semptoshiba.api.SPApontamento;
import idw.model.rn.integracao.semptoshiba.api.SPGravarLeituraApont;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.UsuarioDTO;

public final class IntegracaoApontamentoDiario {
	
	private final IdwLogger log = new IdwLogger("IntegracaoApontamentoDiario");
	private final DAOGenericoErp daoSempToshiba;
	private final DAOGenerico daoIdw;
	
	public IntegracaoApontamentoDiario(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba){
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
	}
	
	public void integracaoApontamentoAposTesteEletrico(UsuarioDTO usrlogado){
		OmCfg omCfg = Util.getConfigGeral(daoIdw.getSession());

		UsuarioRN usuarioRN = new UsuarioRN(daoIdw);
		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogado.getUsuario().getCdUsr());
		Date dataHoraAtual = DataHoraRN.getDataHoraAtual();
		
		log.info("Solicitado apontamento pendente de leitura ");
		
		SPApontamento spApontamento = new SPApontamento(daoSempToshiba);
		List<Apontamento> listaApontamento = spApontamento.getResultado();
		
		log.info("Encontrado " + listaApontamento.size() + " apontamentos pendentes para integra��o");
					
		for(Apontamento apontamento: listaApontamento){
			
			try{
				abaterQuantidadeEstoqueProducaoAposTesteEletricoIAC(apontamento, omusr, daoIdw, omCfg);
				log.info("Integra��o de apontamento realizada. " + apontamento.toString());
			}catch(RegistroDesconhecidoException e){
				log.info("Integra��o de apontamento n�o foi realizada, produto n�o encontrado. " + apontamento.toString());
			}
			
			// Marca como lido
			SPGravarLeituraApont spGravarLeituraApont = new SPGravarLeituraApont(daoSempToshiba, apontamento.getId());
			spGravarLeituraApont.execute();
		}
		
		// Guarda �ltima leitura do estoque liberado, que ser� usado como base para a pr�xima leitura
		omCfg.setDthrEstliberado(dataHoraAtual);
		
	}
	
//	/**
//	 * @deprecated usar agora  
//	 * @param usrlogado
//	 */
//	public void integracaoApotamentoDiario(UsuarioDTO usrlogado){
//
//			
//		OmCfg omCfg = Util.getConfigGeral(daoIdw.getSession());
//
//		UsuarioRN usuarioRN = new UsuarioRN(daoIdw);
//		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogado.getUsuario().getCdUsr());
//		
//		Date inicio = omCfg.getDthrEstliberado();
//		Date fim = DataHoraRN.getDataHoraAtual();
//		fim = DataHoraRN.getDataSemHora(fim);
//		
//		if(inicio == null){
//			inicio = fim;
//		}
//		
//		log.info("Solicitado apontamento diario do per�odo " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(inicio) + "  " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(fim));
//		
//		List<ApontamentoDia> listaApontamentoDia = SPApontamentoDia.getResultado(daoSempToshiba, inicio, fim); 
//		
//		log.info("Encontrado " + listaApontamentoDia.size() + " apontamentos di�rios para integra��o");
//					
//		for(ApontamentoDia apontamentoDia: listaApontamentoDia){
//			
//			try{
//				abaterQuantidadeEstoqueProducaoPorDia(apontamentoDia, omusr, fim, daoIdw, omCfg);
//				log.info("Integra��o de apontamento realizada. " + apontamentoDia.toString());
//			}catch(RegistroDesconhecidoException e){
//				log.info("Integra��o de apontamento n�o foi realizada, produto n�o encontrado. " + apontamentoDia.toString());
//			}catch(DataApontamentoDiarioInferiorDataUltimaSaidaDiaException e){
//				log.info("Integra��o de apontamento n�o foi realizada. Data �ltimo leitura de sa�da � maior que do apontamento. " + apontamentoDia.toString());
//			}
//			
//			
//		}
//		
//		// Guarda �ltima leitura do estoque liberado, que ser� usado como base para a pr�xima leitura
//		omCfg.setDthrEstliberado(fim);
//						
//	}
	
	
//	private void abaterQuantidadeEstoqueProducaoPorDia(ApontamentoDia apontamentoDia, OmUsr omusr, Date dtFimRef, DAOGenerico daoEstoqueProducao, OmCfg omCfg) throws RegistroDesconhecidoException, DataApontamentoDiarioInferiorDataUltimaSaidaDiaException{
//		EstoqueRN estoqueRN = new EstoqueRN(daoEstoqueProducao);
//		ProdutoRN produtoRN = new ProdutoRN(daoEstoqueProducao);
//		
//		OmProduto omProduto = produtoRN.getOmProduto(apontamentoDia.getCdPlaca());
//
//		DwEst dwEstProducao = omCfg.getDwEstByIdEstproducao();
//		
//		
//		if(omProduto != null && dwEstProducao != null ){
//			
//			DwEstpro dwEstpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, dwEstProducao);
//			
//			BigDecimal qtUltimaSaidaDia = Util.getBigDecimalDefault(ObjectUtils.defaultIfNull(dwEstpro.getQtSaida(), BigDecimal.ZERO));
//			
//						
//			Date dtUltimaSaidaDia = null;
//			if(dwEstpro.getDthrSaida() != null){
//				dtUltimaSaidaDia = DataHoraRN.getDataSemHora(dwEstpro.getDthrSaida());
//			}
//			
//			if(dtUltimaSaidaDia == null || apontamentoDia.getDataProducaoSemHora().compareTo(dtUltimaSaidaDia) >= 0){
//				
//				//BigDecimal qtDiff = apontamentoDia.getQtdProduzido();
//				
//				if(dtUltimaSaidaDia == null
//						|| (dtUltimaSaidaDia.equals(apontamentoDia.getDataProducaoSemHora()) 
//								&&  Util.isEquals(qtUltimaSaidaDia, apontamentoDia.getQtdProduzido()) == false)){
//	
//					BigDecimal qtDiff = apontamentoDia.getQtdProduzido().subtract(qtUltimaSaidaDia);
//					estoqueRN.setEstoqueProdutoTrataSeTotalFicarMenorZero(omProduto, dwEstpro.getDwEst(), 
//							null, null, qtDiff, apontamentoDia.getDataProducaoSemHora(), omusr, true, TpOrigem.INTEGRADO);	
//									
//				}else if(dtUltimaSaidaDia.before(apontamentoDia.getDataProducaoSemHora())){
//					
//					if(Util.isEquals(qtUltimaSaidaDia, BigDecimal.ZERO) == false){
//						// Passa o que tem no dia anterior para ajuste. QtSaida s� deve ter quantidade que saiu no dia.
//						estoqueRN.setEstoqueProdutoTrataSeTotalFicarMenorZero(omProduto, dwEstpro.getDwEst(), 
//								qtUltimaSaidaDia.negate(), null, qtUltimaSaidaDia.negate(), dwEstpro.getDthrSaida(), omusr, true, TpOrigem.INTEGRADO);
//					}
//					
//					estoqueRN.setEstoqueProdutoTrataSeTotalFicarMenorZero(omProduto, dwEstpro.getDwEst(), 
//							null, null, apontamentoDia.getQtdProduzido(), apontamentoDia.getDataProducaoSemHora(), omusr, true, TpOrigem.INTEGRADO);
//
//				}
//				
//				
//			}else{
//				throw new DataApontamentoDiarioInferiorDataUltimaSaidaDiaException();
//			}
//			
//		}
//
//	}

	private void abaterQuantidadeEstoqueProducaoAposTesteEletricoIAC(Apontamento apontamentoAposTesteEletricoIAC, OmUsr omusr, DAOGenerico daoEstoqueProducao, OmCfg omCfg) throws RegistroDesconhecidoException{
		EstoqueRN estoqueRN = new EstoqueRN(daoEstoqueProducao);
		ProdutoRN produtoRN = new ProdutoRN(daoEstoqueProducao);
		
		OmProduto omProduto = produtoRN.getOmProduto(apontamentoAposTesteEletricoIAC.getCdPlaca());

		DwEst dwEstProducao = omCfg.getDwEstByIdEstproducao();
		
		
		if(omProduto != null && dwEstProducao != null ){

			estoqueRN.addEstoqueProduto(omProduto,dwEstProducao, 
					null, null, apontamentoAposTesteEletricoIAC.getQtdProduzido(), apontamentoAposTesteEletricoIAC.getDataApontamento(), omusr, true, TpOrigem.INTEGRADO);

		}

	}
	
	public static void main(String[] args){
		
//		IntegracaoApontamentoDiario integracaoApontamentoDiario = new IntegracaoApontamentoDiario(null, null);
//				
//		BigDecimal qtProduzido = new BigDecimal(5);
//		Date dtProducao = DataHoraRN.getData(2014, 2, 6);
//		Date dtFimRef = DataHoraRN.getData(2014, 2, 6);
//		String cdPlaca = "515654";
//		ApontamentoDia apontamentoDia = new ApontamentoDia(cdPlaca, qtProduzido, dtProducao, null, qtProduzido, null, null, null);
//		//System.out.println("Inicio teste " + apontamentoDia.toString());
//		try {
//			integracaoApontamentoDiario.abaterQuantidadeEstoqueProducaoComNovaTransacao(apontamentoDia, "0", dtFimRef);
//		} catch (RegistroDesconhecidoException e) {
//			e.printStackTrace();
//		} catch (DataApontamentoDiarioInferiorDataUltimaSaidaDia e) {
//			e.printStackTrace();
//		}
		UsuarioDTO usrlogado = new UsuarioDTO();
		usrlogado.setUsuario(new OmUsr());
		usrlogado.getUsuario().setId(1L);
		usrlogado.getUsuario().setCdUsr("0");
		IdwFacade.getInstancia().integracaoApontamentoDiario(usrlogado);
		//System.out.println("Fim teste");
		
	}
}

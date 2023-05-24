package idw.model.rn.integracao.semptoshiba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.TipoPostoDesconhecidoException;
import idw.model.excessoes.UsuarioDesconhecidoException;
import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwTOperacao;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.pojos.template.PpPlanoTemplate;
import idw.model.rn.PTRN;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.RoteiroRN;
import idw.model.rn.TpptRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.integracao.IntegracaoJaRealizadaException;
import idw.model.rn.integracao.semptoshiba.APISempToshiba.OperacaoProduto;
import idw.model.rn.integracao.semptoshiba.trilha.ExportacaoTrilha;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public final class IntegracaoOperacao {
	
	private static final String DS_OPERACAO_IMC = "IMC";
	
	private final DAOGenericoErp daoSempToshiba;
	private final DAOGenerico daoIdw;
	private final IdwLogger log = new IdwLogger("Integra��oOpera��o");
	
	
	private Map<String, OmPt> cacheOmPtLidos = new HashMap<String, OmPt>();
	private Map<String, OmProduto> cacheOmProdutoLidos = new HashMap<String, OmProduto>();
	private Map<String, DwTOperacao> cacheDwTOperacaoLidos = new HashMap<String, DwTOperacao>();
	private Set<Integer> listaKeyOperacaoProdutoJaIntegrado =  new HashSet<Integer>();
	
	private final RoteiroRN roteiroRN;
	private final PTRN ptRN;
	private final ProdutoRN produtoRN;
	private final OmTpptTemplate.Type tpTpPadraoType = OmTpptTemplate.Type.PVE;
	private final OmTppt omTppt;
	private final OmUsr omUsr;
	
	
	public IntegracaoOperacao(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba, OmUsr omUsr) throws TipoPostoDesconhecidoException, UsuarioDesconhecidoException {
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
		this.roteiroRN = new RoteiroRN(daoIdw);
		this.ptRN = new PTRN(daoIdw);
		this.produtoRN = new ProdutoRN(this.daoIdw);
		
		TpptRN tpptRN = new TpptRN(daoIdw);
		OmTppt omTpptFiltro = new OmTppt();
		omTpptFiltro.setCdTppt(tpTpPadraoType.toString());
		this.omTppt = tpptRN.getOmTpptDTO(omTpptFiltro);
		if(this.omTppt == null){
			throw new TipoPostoDesconhecidoException("Tipo posto " + tpTpPadraoType.toString() + "  precisa ser cadastrado");
		}
		
		this.omUsr = omUsr;	
		if(this.omUsr == null){
			throw new UsuarioDesconhecidoException("Usu�rio n�o pode ser nulo");
		}
		
	}
	
	private void apagarOperacoes(OmProduto omProdutoFiltro){
		
		// Apagar todas as opera��es do IMC do produto acabado
		roteiroRN.apagarOperacoesTempoPadrao(omProdutoFiltro);
		if(omProdutoFiltro == null){
			log.info("todos as opera��es removidadas");
		}else{
			log.info("todos as opera��es removidadas do produto " + omProdutoFiltro.getCdProduto());
		}		
	}
	
	public static void integrarOperacaoIMCDeListaProdutosPlanosProducaoComTransacaoInterna(OmUsr omUsr, Set<String> listaCdProdutosAcabados, Set<String> listaCdProdutosDAT){

		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoOperacao integracaoOperacao = new IntegracaoOperacao(daoIdw, daoSempToshiba, omUsr);
			
			integracaoOperacao.integrarOperacaoIMCDeListaProdutosPlanosProducao(listaCdProdutosAcabados, listaCdProdutosDAT);
		
		}catch(Exception e){
			e.printStackTrace();			
			
		}finally{

			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();				
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}
		
	}
	
	public void integrarOperacaoIMCDeListaProdutosPlanosProducao(Set<String> listaCdProdutosAcabados, Set<String> listaCdProdutosDAT ) throws Exception{
				
		apagarOperacoes(null);		
		
		List<OperacaoProduto> listaOperacaoProduto = null;
		try {
			listaOperacaoProduto = APISempToshiba.SPOperacao.getResultado(this.daoSempToshiba);				
		} catch (SQLGrammarException e) {
			listaOperacaoProduto = new ArrayList<>();
		}
		log.info("Encontrado " + listaOperacaoProduto.size() + " operacoes para integracao");
		
		for(OperacaoProduto operacaoProduto: listaOperacaoProduto){
			
			try {
				
				integracaoOperacaoProduto(operacaoProduto, listaCdProdutosAcabados, listaCdProdutosDAT);
				
			} catch (ProdutoNaoFazPartePlanoProducaoException e) {
				escreveLogParaExceptionOperacao(e, operacaoProduto);
			} catch (RegistroDesconhecidoException e) {
				escreveLogParaExceptionOperacao(e, operacaoProduto);
			}catch (IntegracaoJaRealizadaException e) {
				escreveLogParaExceptionOperacao(e, operacaoProduto);			
			}catch(Exception e){
				e.printStackTrace();
				escreveLogParaExceptionOperacao(e, operacaoProduto);
				throw e;
			}
			
		}
		
		log.info("Integra��o de opera��o conclu�da");
		
	}
	
	private void escreveLogParaExceptionOperacao(Exception e, OperacaoProduto operacaoProduto){
		log.info("Opera��o n�o integrada - " + operacaoProduto.toString() + " - " + e.getMessage());
	}
		
	private void integracaoOperacaoProduto(OperacaoProduto operacaoProduto, Set<String> listaProdutosAcabados, Set<String> listaProdutosDAT) throws RegistroDesconhecidoException, IntegracaoJaRealizadaException, ProdutoNaoFazPartePlanoProducaoException {
				
		boolean isProdutoFazPartePlanoProducao = true;
		
		if(listaProdutosDAT != null){			
			String cdProdutoComDAT = IntegracaoEstruturaProduto.adicionarComplementoDATEmCdProduto(operacaoProduto.getProdutoSemiAcabado());
			isProdutoFazPartePlanoProducao = listaProdutosDAT.contains(cdProdutoComDAT);
		}
		
		
		if(isProdutoFazPartePlanoProducao == false){
			if(listaProdutosAcabados != null){			
				isProdutoFazPartePlanoProducao = listaProdutosAcabados.contains(operacaoProduto.getProdutoAcabado());
			}
		}
		
		if(isProdutoFazPartePlanoProducao == false){
			Set<String> cdProdutos = new HashSet<String>();
			Collections.addAll(cdProdutos, operacaoProduto.getProdutoAcabado(), operacaoProduto.getProdutoSemiAcabado());
			throw new ProdutoNaoFazPartePlanoProducaoException(cdProdutos);
		}
		
		OmPt omPt = getOmPtDoCache(operacaoProduto.getLinha());
		
		OmProduto produtoAcabado = null;
		try {
			produtoAcabado = getOmProdutoDoCache(operacaoProduto.getProdutoAcabado());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Produto acabado " + operacaoProduto.getProdutoAcabado() + " n�o existe ");
		}
		
		OmProduto produtoSemiAcabado = null;
		try {
			produtoSemiAcabado = getOmProdutoDoCache(operacaoProduto.getProdutoSemiAcabado());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Produto semiacabado" + operacaoProduto.getProdutoSemiAcabado() + " n�o existe ");
		}
		
		BigDecimal tempoPadrao = operacaoProduto.getTempoPadraoEmHoras(); // .multiply(new BigDecimal(3600));
		
		String dsOperacao = DS_OPERACAO_IMC;
				
		DwTOperacao dwTOperacao = getDwTOperacao(dsOperacao);
		
		// Se opera��o j� foi integrada, n�o precisa integrar novamente
		int key = getKeyOperacaoProduto(operacaoProduto);
		
		if(listaKeyOperacaoProdutoJaIntegrado.add(key) == false){
			throw new IntegracaoJaRealizadaException("Opera��o j� integrada");
		}
				
		DwOperacao dwOperacao = new DwOperacao();
		dwOperacao.setDwTOperacao(dwTOperacao);
		dwOperacao.setOmProdutoByIdProdutoacabado(produtoAcabado);
		dwOperacao.setOmProdutoByIdProdutosemiacabado(produtoSemiAcabado);
		dwOperacao.setOmPt(omPt);
		dwOperacao.setSegCiclopadrao(tempoPadrao);
		
		this.daoIdw.makePersistent(dwOperacao);
		
		log.info("Opera��o integrada - " + operacaoProduto.toString());
		
	}
	
	private int getKeyOperacaoProduto( OperacaoProduto operacaoProduto){
		List<String> list = new ArrayList<String>();
		list.add(operacaoProduto.getLinha());
		list.add(operacaoProduto.getProdutoAcabado());
		list.add(operacaoProduto.getProdutoSemiAcabado());
		list.add(operacaoProduto.getFase());		
		return list.hashCode();
	}
	
	private OmPt getOmPtDoCache(String linha){
		OmPt omPt = cacheOmPtLidos.get(linha);
		if(omPt == null){
			
			try {
				omPt = ptRN.getOmPtCriaSeNaoExistir(linha, omTppt, omUsr, "inserido automaticamente ao integrar opera��o", ExportacaoTrilha.ISPLANGT_PARA_GERAR_ARQUIVO_RECURSOS);
				cacheOmPtLidos.put(linha, omPt);
			} catch (UsuarioDesconhecidoException e){
				// Usu�rio deve existe. Isso j� foi tratados no construtor da classe
			}catch (TipoPostoDesconhecidoException e){
				// Tipo posto deve existe. Isso j� foi tratados no construtor da classe
			}
		}
		
		return omPt;
	}
	
	
	private OmProduto getOmProdutoDoCache(String cdProduto) throws RegistroDesconhecidoException{
		OmProduto omProduto = cacheOmProdutoLidos.get(cdProduto);
		if(omProduto == null){
			omProduto = produtoRN.getOmProduto(cdProduto);
			cacheOmProdutoLidos.put(cdProduto, omProduto);
		}
		
		return omProduto;
		
	}
	
	private DwTOperacao getDwTOperacao(String operacao){
		DwTOperacao dwTOperacao = cacheDwTOperacaoLidos.get(operacao);
		if(dwTOperacao == null){
			dwTOperacao = roteiroRN.getDwTOperacaoCriaSenaoExistir(operacao);
			cacheDwTOperacaoLidos.put(operacao, dwTOperacao);
		}
		return dwTOperacao;
	}
	
	public static void main(String[] args){
		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			UsuarioRN usuarioRN = new UsuarioRN(daoIdw);
			
			OmUsr omUsr = usuarioRN.getOmUsr(1);
			
			PlanejamentoProducaoRN planejamentoProducaoRN = new PlanejamentoProducaoRN(daoIdw);
			
			PlanoDTO planoDTO = new PlanoDTO();
			planoDTO.setStPlano(PpPlanoTemplate.TpPlano.CADASTRADO.getId());
			Map<String, OmProduto> listProdutosFinaisDoPlanoProducao = planejamentoProducaoRN.getProdutosFinaisDosPlanosAtivos(planoDTO, false, false, false, false, 0, false);
			
			
			Set<String> listaCdProdutos = new HashSet<String>();
			listaCdProdutos.addAll(listProdutosFinaisDoPlanoProducao.keySet());
			
			IntegracaoOperacao integracaoOperacao = new IntegracaoOperacao(daoIdw, daoSempToshiba, omUsr);
			
			integracaoOperacao.getOmPtDoCache("111.02-0");
			
			integracaoOperacao.integrarOperacaoIMCDeListaProdutosPlanosProducao(listaCdProdutos, new HashSet<String>());
		
		}catch(Exception e){
			e.printStackTrace();			
			
		}finally{

			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();				
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
			
			//System.out.println("FIM");
		
		}
		
	}
	
}

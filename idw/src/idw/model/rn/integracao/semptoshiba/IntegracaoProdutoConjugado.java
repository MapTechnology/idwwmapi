package idw.model.rn.integracao.semptoshiba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.TipoPostoDesconhecidoException;
import idw.model.excessoes.UsuarioDesconhecidoException;
import idw.model.pojos.DwProdutoconjugado;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.PpPlanoTemplate;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.ProdutoConjugadoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.integracao.IntegracaoJaRealizadaException;
import idw.model.rn.integracao.semptoshiba.APISempToshiba.ProdutoConjugado;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public final class IntegracaoProdutoConjugado {
	
	private final DAOGenericoErp daoSempToshiba;
	private final DAOGenerico daoIdw;
	private final IdwLogger log = new IdwLogger("Integra��oProdu��oSimultanea");
	
	
	private Map<String, OmProduto> cacheOmProdutoLidos = new HashMap<String, OmProduto>();
	private Set<Integer> listaKeyProducaoSimultaneaJaIntegrada =  new HashSet<Integer>();
	
	private final ProdutoRN produtoRN;
	private final OmUsr omUsr;
	private final ProdutoConjugadoRN produtoConjugadoRN;
	
	public IntegracaoProdutoConjugado(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba, OmUsr omUsr) throws TipoPostoDesconhecidoException, UsuarioDesconhecidoException {
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
		this.produtoRN = new ProdutoRN(this.daoIdw);
		this.produtoConjugadoRN = new ProdutoConjugadoRN(this.daoIdw);
		this.omUsr = omUsr;	
		if(this.omUsr == null){
			throw new UsuarioDesconhecidoException("Usu�rio n�o pode ser nulo");
		}
		
		
	}
	
	public static void integrarProducaoSimultaneaDeListaProdutosPlanosProducaoComTransacaoInterna(OmUsr omUsr, Set<String> listaCdProdutosAcabados, Set<String> listaCdProdutosDAT){

		final DAOGenerico daoIdw = new DAOGenerico();
		final DAOGenericoErp daoSempToshiba = new DAOGenericoErp();
		
		try{
			daoIdw.iniciaConexaoBanco();
			daoSempToshiba.iniciaConexaoBanco();
			IntegracaoProdutoConjugado integracaoProducaoSimultanea = new IntegracaoProdutoConjugado(daoIdw, daoSempToshiba, omUsr);
			
			integracaoProducaoSimultanea.integrarProdutoConjugadoDeListaProdutosPlanosProducao(listaCdProdutosAcabados, listaCdProdutosDAT);
		
		}catch(Exception e){
			e.printStackTrace();			
			
		}finally{

			daoIdw.finalizaConexaoBancoSemException();
			daoSempToshiba.finalizaConexaoBancoSemException();				
			daoIdw.finalizaSessaoSemException();
			daoSempToshiba.finalizaSessaoSemException();
		}
		
	}

	
	private void apagarProdutoConjugados(OmProduto omProdutoFiltro){
		
		produtoConjugadoRN.apagarApagarProdutosConjugados(omProdutoFiltro);
		
		if(omProdutoFiltro == null){
			log.info("todos os produtos conjugados foram removidos");
		}else{
			log.info("todos as produtos conjugados do produto " + omProdutoFiltro.getCdProduto() + " foram removidos");
		}		
	}
	

	
	public void integrarProdutoConjugadoDeListaProdutosPlanosProducao(Set<String> listaCdProdutosAcabados, Set<String> listaCdProdutosDAT ) throws Exception{
				
		apagarProdutoConjugados(null);		
		
		List<ProdutoConjugado> listaProdutoConjugado = APISempToshiba.SPProdutoConjugado.getResultado(this.daoSempToshiba);				
		log.info("Encontrado " + listaProdutoConjugado.size() + " opera��es para integra��o");
		
		for(ProdutoConjugado produtoConjugado: listaProdutoConjugado){
			
			try {
				
				integracaoProdutoConjugado(produtoConjugado, listaCdProdutosAcabados, listaCdProdutosDAT);
				
			} catch (ProdutoNaoFazPartePlanoProducaoException e) {
				escreveLogParaExceptionOperacao(e, produtoConjugado);
			} catch (RegistroDesconhecidoException e) {
				escreveLogParaExceptionOperacao(e, produtoConjugado);
			}catch (IntegracaoJaRealizadaException e) {
				escreveLogParaExceptionOperacao(e, produtoConjugado);			
			}catch(Exception e){
				e.printStackTrace();
				escreveLogParaExceptionOperacao(e, produtoConjugado);
				throw e;
			}
			
		}
		
		log.info("Integra��o de opera��o conclu�da");
		
	}
	
	private void escreveLogParaExceptionOperacao(Exception e, ProdutoConjugado produtoConjugado){
		log.info("Produto Conjugado n�o integrado - " + produtoConjugado.toString() + " - " + e.getMessage());
	}

	private void integracaoProdutoConjugado(ProdutoConjugado produtoConjugado, Set<String> listaProdutosAcabados, Set<String> listaProdutosDAT) throws RegistroDesconhecidoException, IntegracaoJaRealizadaException, ProdutoNaoFazPartePlanoProducaoException {
				
		boolean isProdutoFazPartePlanoProducao = true;
		
		if(listaProdutosDAT != null){			
			String cdProdutoComDAT = IntegracaoEstruturaProduto.adicionarComplementoDATEmCdProduto(produtoConjugado.getCdProdutoFilho());
			isProdutoFazPartePlanoProducao = listaProdutosDAT.contains(cdProdutoComDAT);
		}
		
		
		if(isProdutoFazPartePlanoProducao == false){
			if(listaProdutosAcabados != null){			
				isProdutoFazPartePlanoProducao = listaProdutosAcabados.contains(produtoConjugado.getCdProdutoPai());
			}
		}
		
		if(isProdutoFazPartePlanoProducao == false){
			Set<String> cdProdutos = new HashSet<String>();
			Collections.addAll(cdProdutos, produtoConjugado.getCdProdutoPai(), produtoConjugado.getCdProdutoFilho());
			throw new ProdutoNaoFazPartePlanoProducaoException(cdProdutos);
		}
		
		OmProduto produtoAcabado = null;
		try {
			produtoAcabado = getOmProdutoDoCache(produtoConjugado.getCdProdutoPai());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Produto acabado " + produtoConjugado.getCdProdutoPai() + " n�o existe ");
		}
		
		OmProduto produtoSemiAcabado = null;
		try {
			produtoSemiAcabado = getOmProdutoDoCache(produtoConjugado.getCdProdutoFilho());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Produto semiacabado" + produtoConjugado.getCdProdutoFilho() + " n�o existe ");
		}
		
		
		// Se opera��o j� foi integrada, n�o precisa integrar novamente
		int key = getKeyProdutoConjugado(produtoConjugado);
		
		if(listaKeyProducaoSimultaneaJaIntegrada.add(key) == false){
			throw new IntegracaoJaRealizadaException("Opera��o j� integrada");
		}
		
		DwProdutoconjugado dwProdutoconjugado = new DwProdutoconjugado();
		dwProdutoconjugado.setOmProdutoByIdProdutopai(produtoAcabado);
		dwProdutoconjugado.setOmProdutoByIdProdutofilho(produtoSemiAcabado);
		
		this.daoIdw.makePersistent(dwProdutoconjugado);
		
		log.info("Produto conjugado integrado - " + produtoConjugado.toString());
		
	}
	
	private int getKeyProdutoConjugado(ProdutoConjugado produtoConjugado){
		List<String> list = new ArrayList<String>();
		list.add(produtoConjugado.getCdProdutoPai());
		list.add(produtoConjugado.getCdProdutoFilho());		
		ObjectUtils.hashCodeMulti(produtoConjugado.getCdProdutoPai(), produtoConjugado.getCdProdutoFilho());
		return list.hashCode();
	}
	
	
	private OmProduto getOmProdutoDoCache(String cdProduto) throws RegistroDesconhecidoException{
		OmProduto omProduto = cacheOmProdutoLidos.get(cdProduto);
		if(omProduto == null){
			omProduto = produtoRN.getOmProduto(cdProduto);
			cacheOmProdutoLidos.put(cdProduto, omProduto);
		}
		
		return omProduto;
		
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
			
			IntegracaoProdutoConjugado integracaoProdutoConjugado = new IntegracaoProdutoConjugado(daoIdw, daoSempToshiba, omUsr);
			
			
			integracaoProdutoConjugado.integrarProdutoConjugadoDeListaProdutosPlanosProducao(listaCdProdutos, new HashSet<String>());
		
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

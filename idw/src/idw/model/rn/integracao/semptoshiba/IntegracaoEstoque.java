package idw.model.rn.integracao.semptoshiba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.dao.DAOGenerico;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TtSapEstmppa;
import idw.model.pojos.template.DwEstMovTemplate;
import idw.model.pojos.template.PpPlanoTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.EmpresaRN;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.ProdutoAlternativoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.integracao.semptoshiba.APISempToshiba.EstoqueProduto;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.dto.SapEstoqueDTO;
import idw.webservices.dto.SapEstoquesDTO;
import idw.webservices.dto.UsuarioDTO;

public final class IntegracaoEstoque {
	
	private final DAOGenericoErp daoSempToshiba;
	private final DAOGenerico daoIdw;
	private final IdwLogger log;	
	private final Map<String, OmProduto> mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos;
	private final EstoqueRN estoqueRN;
	private final OmCfg omCfg;

	public IntegracaoEstoque(DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba) throws SemPlanejamentoException{
		this(new IdwLogger("IntegraçãoEstoque"), daoIdw, daoSempToshiba);
	}
	
	private IntegracaoEstoque(IdwLogger log, DAOGenerico daoIdw, DAOGenericoErp daoSempToshiba) throws SemPlanejamentoException{
		this.log = log;
		this.daoIdw = daoIdw;
		this.daoSempToshiba = daoSempToshiba;
		
		omCfg = Util.getConfigGeral(daoIdw.getSession());
		
		PlanejamentoProducaoRN planejamentoProducaoRN = new PlanejamentoProducaoRN(this.daoIdw);
		PlanoDTO planoDTO = new PlanoDTO();
		planoDTO.setStPlano(PpPlanoTemplate.TpPlano.CADASTRADO.getId());
		Map<String, OmProduto> listProdutosFinaisDoPlanoProducao = planejamentoProducaoRN.getProdutosFinaisDosPlanosAtivos(planoDTO, false, false, false, true, 5, false);
		
		
		if(listProdutosFinaisDoPlanoProducao.isEmpty()){
			throw new SemPlanejamentoException("Plano de produção com situa��o cadastrado, Não foi encontrado");
		}
		
		ProdutoRN produtoRN = new ProdutoRN(daoIdw);
		List<OmProduto> listProdutosEstruturaDoPlanoProducao = produtoRN.getProdutosComEstruturas(listProdutosFinaisDoPlanoProducao.values(), null);
		this.mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos = ProdutoRN.getListaProdutoIndexCdProduto(listProdutosEstruturaDoPlanoProducao);
		
		ProdutoAlternativoRN produtoAlternativoRN = new ProdutoAlternativoRN(daoIdw);
		Map<String, OmProduto> mapProdutosAlternativos = produtoAlternativoRN.getTodosProdutosAlternativosDoPlanoProducao(mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos);
		
		this.mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos.putAll(mapProdutosAlternativos);
		
		this.estoqueRN = new EstoqueRN(this.daoIdw);
		
	}
	
	public void integrarPrevisaoEstoque(PeriodoDTO periodoDTO, UsuarioDTO usrlogado) throws RegistroDesconhecidoException{
				
		DwEst dwEstMP = omCfg.getDwEstByIdEstmp();
		
		if(dwEstMP == null){
			throw new RegistroDesconhecidoException("Estoque para matéria-prima Não encontrado. Por favor, defini na configuração geral, item Estoque MP");
		}

		estoqueRN.apagarMovimentacaoEstoque(dwEstMP);
		estoqueRN.zerarEstoqueProdutos(dwEstMP);
		
		UsuarioRN usuarioRN = new UsuarioRN(daoIdw);		
		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogado.getUsuario().getCdUsr());
		
		List<APISempToshiba.PedidoProduto> listaPedidoProduto = APISempToshiba.SPPedido.getResultado(daoSempToshiba, periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim());
		for(APISempToshiba.PedidoProduto pedidoProduto: listaPedidoProduto){
			
			final OmProduto omProduto = mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos.get(pedidoProduto.getCdProduto().trim());

			if(omProduto == null){				
				log.info("Produto (" + pedidoProduto.getCdProduto() + "). Não faz parte da estrutura dos planos de produção, não será integrada. " + ToStringBuilder.reflectionToString(pedidoProduto, ToStringStyle.SIMPLE_STYLE));
			}else{
							
				// TODO guardar dwEstpro em cache Map para otimizar o processo. Procura primeiro no cache, se Não encontrar consulta no banco
				DwEstpro dwEstpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, dwEstMP);
				BigDecimal qtEntrada = pedidoProduto.getQtdPrevista();
				DwEstmov dwEstmov = DwEstMovTemplate.newDwEstMovAjuste(DataHoraRN.getDataHoraAtual(), pedidoProduto.getDtPrevista(), dwEstpro, null, omusr,  qtEntrada, null, qtEntrada, null, DwEstMovTemplate.TpOrigem.INTEGRADO);

				daoIdw.makePersistent(dwEstmov);
				
			}
			
		}
			
	}

	/**
	 * 
	 * @param dtReferencia
	 * @param usrlogado
	 * @return
	 * @throws RegistroDesconhecidoException 
	 */
	public ProdutosDTO integrarSaldoInicial(Date dtReferencia, UsuarioDTO usrlogado) throws RegistroDesconhecidoException{

		DwEst dwEstLiberado = omCfg.getDwEstByIdEstliberado();
		
		if(dwEstLiberado == null){
			throw new RegistroDesconhecidoException("Estoque liberação não encontrado. Por favor, defini na configuração geral, item Estoque liberação");
		}
		
		ProdutosDTO produtosDesconhecidos = new ProdutosDTO();
		produtosDesconhecidos.setResultado(new ResultadoDTO());
		produtosDesconhecidos.setProdutos(new ArrayList<ProdutoDTO>());
		produtosDesconhecidos.getResultado().setIdmensagem(produtosDesconhecidos.getResultado().getCOM_SUCESSO());

		SapEstoquesDTO retorno = new SapEstoquesDTO();
		retorno.setSapestoques(new ArrayList<SapEstoqueDTO>());
		
		estoqueRN.apagarMovimentacaoEstoque(dwEstLiberado);
		estoqueRN.apagarEstoqueProdutos(dwEstLiberado);
		
		int ano = DataHoraRN.getApenasAno(dtReferencia);
		int mes = DataHoraRN.getApenasMes(dtReferencia);
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(daoIdw.getSession());
		boolean isEmpresaSemp = EmpresaRN.isEmpresaSemp(omCfg);
		
		try {  
			List<EstoqueProduto> listaEstoqueProduto = 
					APISempToshiba.SPSaldoInicial.getResultado(daoSempToshiba, isEmpresaSemp, mes, ano);
			
			  for(EstoqueProduto estoqueProduto: listaEstoqueProduto){
				  	final TtSapEstmppa pojo = new TtSapEstmppa();
				  	
					final SapEstoqueDTO sapestoquedto = new SapEstoqueDTO();
					
					pojo.setGlobalcode(estoqueProduto.getCdProduto());
					pojo.setQtEstoque(estoqueProduto.getQtEstoque());
			        
			        if (pojo.getQtEstoque().compareTo(BigDecimal.ZERO) == 1){		                
			            sapestoquedto.setDwconsolid(new DwConsolid());
			            sapestoquedto.getDwconsolid().setDtReferencia(dtReferencia);
			            sapestoquedto.setAjustarEstoque(false);
			            sapestoquedto.setFechamentoMes(true);
			            sapestoquedto.setSapestoque(pojo);
			            retorno.getSapestoques().add(sapestoquedto);
			            
			            final OmProduto omproduto = mapProdutosComEstruturaEAlternativosDosPlanosProducaoAtivos.get(pojo.getGlobalcode());
			            OmProduto omProdutoInvalido = null;
			            
			            if (omproduto == null) {
			            	omProdutoInvalido = new OmProduto();
			            	omProdutoInvalido.setCdProduto(pojo.getGlobalcode() + "- Não faz parte do plano de produção");

			            }
			            
			            // Se produto for inválido vai para o próximo item
			            if(omProdutoInvalido == null){
			            	
			            	DwEstpro dwestpro = DwEstpro.newDwEstpro(dwEstLiberado, omproduto,  estoqueProduto.getQtEstoque());

			            	dwestpro.setQtAjuste(estoqueProduto.getQtEstoque());
			            	dwestpro.setQtTotal(estoqueProduto.getQtEstoque());
			            	
			            	daoIdw.makePersistent(dwestpro);
			            	
			            }else{
			            	ProdutoDTO p = new ProdutoDTO();
			            	p.setProduto(omProdutoInvalido);
			            	produtosDesconhecidos.getProdutos().add(p);			            	
							
			            }
			            
			        }

			  }

			  
		} catch (Exception e) {  
			e.printStackTrace();
			produtosDesconhecidos.getResultado().setIdmensagem(produtosDesconhecidos.getResultado().getERRO_DESCONHECIDO());
		} 
		
		
		return produtosDesconhecidos;
	}
	

}

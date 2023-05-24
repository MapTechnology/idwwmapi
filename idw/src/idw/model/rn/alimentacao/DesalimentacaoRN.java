package idw.model.rn.alimentacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwDesalimpendcontagDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.dao.DwEstproDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.OmUsrDAO;
import idw.model.dao.OmpaproDao;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwDesalimpendcontag;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwEstlocalTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConfiguracaoRN;
import idw.model.rn.PerdampRN;
import idw.model.rn.consolidacao.estoque.ConsolidacaoLocalEstoque;
import idw.model.rn.estoque.EntradaNaoEncontradaException;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.estoque.LocalDestinoNaoEncontradoException;
import idw.model.rn.estoque.LocalEstoquePaRN;
import idw.model.rn.estoque.LocalEstoqueRN;
import idw.model.rn.estoque.LocalOrigemNaoEncontradoException;
import idw.model.rn.estoque.MovimentacaoLocalEstoque;
import idw.model.rn.produto.ProdutoInvalidoException;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwDesalimpendcontagsDTO;
import idw.webservices.dto.FiltroDesalimentacaoContagem;
import idw.webservices.dto.ResultadoMovimentacaoLocalEstoqueDTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.excessao.UsuarioDesconhecidoException;

public class DesalimentacaoRN extends AbstractRN<DAOGenerico>{
	
	public DesalimentacaoRN(){
		this(null);
	}
	
	public DesalimentacaoRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public static void main(String[] args) {
		DesalimentacaoRN rn = new DesalimentacaoRN();
		rn.iniciaConexaoBanco();
		
		rn.desalimentaPontosAlimentacaoDoPT("CM602-2_L7", 1l);
		
		rn.finalizaConexaoBanco();
	}

	
	/* Metodo principal de desalimentacao */
	public void desalimentaPontosAlimentacaoDoPT(String cdPt, Long usuarioCorrenteLeitor) {
		
		IdwLogger log = new IdwLogger("desalimentaPontosAlimentacaoDoPT");
		int idLog = log.getIdAleatorio();
		
		OmPtDAO consultaOmPtPorCdPt = new OmPtDAO(getDaoSession());
		
		OmPt omPt = consultaOmPtPorCdPt.getConsultaOmPtbyCdMaquina(cdPt);

		OmCfg omCfg = Util.getConfigGeral(getDaoSession());
		
		Date dataAtual = new Date();
		
		OmUsr omUsuarioCorrente = null;
		
		if(usuarioCorrenteLeitor == null){
		
			omUsuarioCorrente = omCfg.getOmUsrimpprog();
		
		}else{
			
			OmUsrDAO omUsrDAO = new OmUsrDAO(getDaoSession());
			omUsuarioCorrente = omUsrDAO.getOmUsrPorId(usuarioCorrenteLeitor);
			
			if(omUsuarioCorrente == null){
				omUsuarioCorrente = omCfg.getOmUsrimpprog();
			}
			
		}
		
		
		movimentarOmPaproParaLocalDesalimentacao(omPt, omCfg, omUsuarioCorrente, dataAtual);
		
		// Nos testes, apareceu algumas quantidades ainda nos locais de alimenta��oo.
		// Ent�o por garantia, passar TODOS os estoques no PA do PT para a desalimenta��oo
		movimentarTodosLocaisAlimentacaoDoPtParaDesalimentacao(log, idLog, omPt, omCfg, omUsuarioCorrente, dataAtual);
		
		retiraProdutosDosPontosAlimentacaoDoPt(omPt);
		
	}


	private void salvarDesalimentacaoPendenteContagem(DwEstlocalpro dwEstlocalpro, Date data, BigDecimal qtd){
		DwDesalimpendcontag dwDesalimpendcontag = new DwDesalimpendcontag();
		dwDesalimpendcontag.setDwEstlocalpro(dwEstlocalpro);
		dwDesalimpendcontag.setDthrDesalim(data);
		dwDesalimpendcontag.setQtDesalim(qtd);
		getDao().makePersistent(dwDesalimpendcontag);
	}
	
	public DwDesalimpendcontagsDTO getDesalimentacoes(FiltroDesalimentacaoContagem filtro){
		DwDesalimpendcontagDAO dao = new DwDesalimpendcontagDAO(getDaoSession());
		List<DwDesalimpendcontag> lista = dao.getDwDesalimpendcontags(filtro.getDwEstlocal(), filtro.getOmPt(), filtro.getOmProduto());
		DwDesalimpendcontagsDTO retorno = new DwDesalimpendcontagsDTO();
		retorno.setDesalimpendcontags(new ArrayList<DwDesalimpendcontag>());
		
		for(DwDesalimpendcontag item : lista){
			
			DwEstlocalpro dwEstlocalpro = item.getDwEstlocalpro().clone(false);
			DwEstlocal dwEstlocal = item.getDwEstlocalpro().getDwEstlocal().clone(false);
			DwEst dwEst = item.getDwEstlocalpro().getDwEstpro().getDwEst().clone(false);			
			DwEstpro dwEstpro = item.getDwEstlocalpro().getDwEstpro().clone(false);
			dwEstlocal.setOmPt(item.getDwEstlocalpro().getDwEstlocal().getOmPt().clone(false));
			dwEstlocal.setOmPa(item.getDwEstlocalpro().getDwEstlocal().getOmPa().clone(false));
			dwEstpro.setDwEst(dwEst);
			dwEstpro.setOmProduto(item.getDwEstlocalpro().getDwEstpro().getOmProduto().clone(false));

			DwDesalimpendcontag itemRetorno = item.clone(false);
			itemRetorno.setDwEstlocalpro(dwEstlocalpro);
			itemRetorno.getDwEstlocalpro().setDwEstlocal(dwEstlocal);
			itemRetorno.getDwEstlocalpro().setDwEstpro(dwEstpro);
			
			retorno.getDesalimpendcontags().add(itemRetorno);
		}
		
		return retorno;
	}
	
	
	
	public ResultadoMovimentacaoLocalEstoqueDTO realizarAjusteDesalimentacao(
			DwDesalimpendcontag desalimentacao, int novaQuantidade, int diferenca, 
			String justificativa, String cdPa, OmUsr usuario, Date dthrDesalimentacao) {
		
		IdwLogger log = new IdwLogger("realizarAjusteDesalimentacao");
		int idLog = log.getIdAleatorio();
		
		Date dataOperacao = new Date();
		
		PerdampRN perdampRN = new PerdampRN();
		perdampRN.setDaoSession(getDaoSession());
		
		ResultadoMovimentacaoLocalEstoqueDTO retorno = new ResultadoMovimentacaoLocalEstoqueDTO();
		retorno.setOk(false);
		
		DwEstpro estPro = null;
		if(desalimentacao.getDwEstlocalpro().getDwEstpro().getIdEstpro() != null){
			DwEstproDAO estproDAO = new DwEstproDAO(getDaoSession());
			estPro = estproDAO.getDwEstproPorId(desalimentacao.getDwEstlocalpro().getDwEstpro().getIdEstpro());
		}
		
		DwEstlocalproDAO estlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstlocalpro localproOrigem = estlocalproDAO.getDwEstlocalproPorId(desalimentacao.getDwEstlocalpro().getIdEstlocalpro());
		
		DwEstlocalDAO estlocalDAO = new DwEstlocalDAO(getDaoSession());
		DwEstlocal dwEstlocal = estlocalDAO.getDwEstlocalPorId(desalimentacao.getDwEstlocalpro().getDwEstlocal().getIdEstlocal());
		
		OmProdutoDAO produtoDAO = new OmProdutoDAO(getDaoSession());
		OmProduto omProduto = produtoDAO.getOmProdutoPorId(desalimentacao.getDwEstlocalpro().getDwEstpro().getOmProduto().getIdProduto());
		
		ConfiguracaoRN configRN = new ConfiguracaoRN();
		configRN.setDao(getDao());
		OmCfg configuracao = Util.getConfigGeral(getDao().getSession());
		
		EstoqueRN estoqueRN = new EstoqueRN();
		estoqueRN.setDao(getDao());
		
		if(localproOrigem == null){
			estPro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, dwEstlocal.getDwEst());
			LocalEstoqueRN localEstoqueRN = new LocalEstoqueRN();
			localEstoqueRN.setDao(getDao());
			localproOrigem = localEstoqueRN.getDwEstlocalproCriaSenaoExistir(dwEstlocal, estPro, omProduto);
		}

		BigDecimal qtdAjuste = BigDecimal.ZERO;
		qtdAjuste = new BigDecimal(novaQuantidade).subtract(localproOrigem.getQtTotal());
	
		ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
		TurnoAtualDTO turnoAtualDTO = null;
		try {
			turnoAtualDTO = consolidacaoLocalEstoque.getTurnoAtualDTO(dwEstlocal, dataOperacao);
		} catch (SemCalendarioException ex) {
			ex.printStackTrace();
		}
		
		if(qtdAjuste.intValue() != 0){
			consolidacaoLocalEstoque.consolidarLocalEstoqueAjuste(log, idLog, turnoAtualDTO, configuracao, localproOrigem, qtdAjuste, dataOperacao, usuario);
		}
		
		MovimentacaoLocalEstoque movimentacao = new MovimentacaoLocalEstoque(getDao());

		try {
			if(novaQuantidade >=0){
				movimentacao.movimentarQtdEntreLocaisProdutosFazAjusteSeSaidaMaiorQueTotal(log, idLog, dwEstlocal, omProduto, 
						configuracao.getDwEstlocalorigalim(), novaQuantidade,
						usuario, dataOperacao);
			}
			MapQuery q = new MapQuery(getDaoSession());
			q.append("DELETE FROM DwDesalimpendcontag desalimentacao");
			q.append("WHERE desalimentacao.idDesalimpendcontag = :idDesalimpendcontag");
			q.defineParametro("idDesalimpendcontag", desalimentacao.getIdDesalimpendcontag());
			
			q.query().executeUpdate();
			getDao().flushReiniciandoTransacao();
//			removerContagemPendente(desalimentacao);
		} catch (LocalOrigemNaoEncontradoException e) {
			retorno.setLocalOrigemNaoEncontrado(true);			
		} catch (LocalDestinoNaoEncontradoException e) {
			retorno.setLocalDestinoNaoEncontrado(true);
		} catch (ProdutoInvalidoException e) {
			retorno.setProdutoNaoEncontrado(true);
		} catch (UsuarioDesconhecidoException e) {
			retorno.setUsuarioNaoEncontrado(true);
		} catch (EntradaNaoEncontradaException e) {
			retorno.setEntradaNaoEncontrada(true);
		} catch (SemCalendarioException e) {
			retorno.setCalendarioNaoEncontrado(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		// Alessandre: em 27-1-15 o trecho abaixo foi comentado para evitar de lancar a diferenca da desalimenta��o como perda de compoente
		// Se houver necessidade de voltar com o codigo � bom criar uma configuracao geral para habilitar desabilitar essa funcionalidade
		// pois pode haver clientes que queiram e outros n�o.
		/*
		if(diferenca > 0){	//só cria um MS_EVT se a diferença for maior que ZERO
			String cdPrg = dwEstlocal.getOmPt().getOmAlimByIdAlim().getOmMapa().getOmPrg().getCdPrg();
			String idTperdamp = String.valueOf(dwTPerdamp.getIdTperdamp());
			
			EventoParaMsEvtRN eventoParaMsEvtRN = new EventoParaMsEvtRN();
			eventoParaMsEvtRN.setDao(getDao());
			eventoParaMsEvtRN.trataEvento(montaDTOAjustePerdamp(dwEstlocal.getOmPt(), omProduto.getCdProduto(), cdPrg, cdPa, justificativa, diferenca, idTperdamp, dthrDesalimentacao));
		}*/
		
		retorno.setOk(true);

		return retorno;
	}
	
	private void movimentarOmPaproParaLocalDesalimentacao(OmPt omPt, OmCfg omCfg, OmUsr omUsuarioCorrente, Date dataAtual) {
		IdwLogger log = new IdwLogger("desalimentacao");
		int idLog = log.getIdAleatorio();
		
		OmpaproDao ompaproDao = new OmpaproDao(getDaoSession()); 
		List<OmPapro> listaOmpapro =  ompaproDao.getTodosProdutosDoPaDoPt(omPt);
		
		EstoqueRN estoqueRN = new EstoqueRN(getDao());
		LocalEstoquePaRN localEstoquePaRN = new LocalEstoquePaRN(getDao());
		
		log.info(idLog, 0, "Qtde a serem desalimentadas = " + listaOmpapro.size());
		
		for (OmPapro omPaProAlimentado : listaOmpapro) {
			
			log.info(idLog, 0, "desalimentando " + omPaProAlimentado.toString(omPaProAlimentado));

			if (omPaProAlimentado.getQtAtual().intValue() != 0) {
				
				OmPa omPa = omPaProAlimentado.getOmPa();
				OmProduto omProduto = omPaProAlimentado.getOmProduto();
				
				DwEstpro dwEstpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, omCfg.getDwEstByIdEstAlimentacao());
				
				DwEstlocal localEstAlimentacao = localEstoquePaRN.getDwEstlocalAlimentacaoCriaSenaoExistir(omCfg.getDwEstByIdEstAlimentacao(), omPt, omPa, omUsuarioCorrente, dataAtual);

				DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
				
				DwEstlocalpro dwEstLocalProAlimentacao = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(localEstAlimentacao, dwEstpro, null);
				
				DwEstlocal localEstDesalimentacao = localEstoquePaRN.getDwEstlocalDesalimentacaoCriaSenaoExistir(omCfg.getDwEstByIdEstAlimentacao(), omPt, omPaProAlimentado.getOmPa(), omUsuarioCorrente, dataAtual); 
				
				
				DwEstlocalpro dwEstLocalProDesalimentacao = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(localEstDesalimentacao, dwEstpro, null);
				
				try {
					movimentarQtdDeLocalEstProAlimParaLocalEstProDesalim(
							log, idLog,
							dwEstLocalProAlimentacao, dwEstLocalProDesalimentacao, 
							omProduto, omUsuarioCorrente, dataAtual, omCfg, omPaProAlimentado.getQtAtual());
					
				} catch (UsuarioDesconhecidoException e) {
					log.info(idLog, 0, "Nao desalimentou devido", e);
				} catch (SemCalendarioException e) {
					log.info(idLog, 0, "Nao desalimentou devido", e);
				} catch (EntradaNaoEncontradaException e) {
					log.info(idLog, 0, "2Nao desalimentou pois qtAtual = 0");
				}
			} else {
				log.info(idLog, 0, "Nao desalimentou pois qtAtual = 0");
			}
		}
		log.info(idLog, 0, "Desalimentou " + listaOmpapro.size());
	}

	private void movimentarTodosLocaisAlimentacaoDoPtParaDesalimentacao(IdwLogger log, int idLog, OmPt omPt, OmCfg omCfg, OmUsr omUsuarioCorrente, Date dataAtual) {

		LocalEstoquePaRN localEstoquePaRN = new LocalEstoquePaRN(getDao());
		
		DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		
		List<DwEstlocalpro> listaEstlocalpro = dwEstlocalproDAO.getDwEstlocalprosDoPt(omPt, DwEstlocalTemplate.TpLocalEstoque.ALIMENTACAO, true, true);
		
		for(DwEstlocalpro dwEstLocalProAlimentacao: listaEstlocalpro ){
			
			BigDecimal qtTotal = dwEstLocalProAlimentacao.getQtTotal();
			
			if(CompareUtils.compareTo(qtTotal, BigDecimal.ZERO) > 0){
				
				DwEstlocal dwEstlocalAlimentacao = dwEstLocalProAlimentacao.getDwEstlocal();
				OmPa omPa= dwEstlocalAlimentacao.getOmPa();
				
				if(omPa != null){
					DwEstpro dwEstpro =dwEstLocalProAlimentacao.getDwEstpro(); 
					OmProduto omProduto = dwEstpro.getOmProduto();
	
					DwEstlocal localEstDesalimentacao = localEstoquePaRN.getDwEstlocalDesalimentacaoCriaSenaoExistir(omCfg.getDwEstByIdEstAlimentacao(), omPt, omPa, omUsuarioCorrente, dataAtual); 
					DwEstlocalpro dwEstLocalProDesalimentacao = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(localEstDesalimentacao, dwEstpro, null);
					
					try {
						movimentarQtdDeLocalEstProAlimParaLocalEstProDesalim(
								log, idLog,
								dwEstLocalProAlimentacao, dwEstLocalProDesalimentacao, 
								omProduto, omUsuarioCorrente, dataAtual, omCfg, qtTotal);

					} catch (UsuarioDesconhecidoException e) {
						// N�o deve cair neste ponto pois o usuário está preenchido
						e.printStackTrace();
					} catch (SemCalendarioException e) {
						e.printStackTrace();
					} catch (EntradaNaoEncontradaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private void movimentarQtdDeLocalEstProAlimParaLocalEstProDesalim(
			IdwLogger log, int idLog,
			DwEstlocalpro dwEstLocalProAlimentacao, DwEstlocalpro dwEstLocalProDesalimentacao, OmProduto omProduto,
			OmUsr omUsuarioCorrente, Date dataAtual, OmCfg omCfg, BigDecimal qtd) 
					throws UsuarioDesconhecidoException, SemCalendarioException, EntradaNaoEncontradaException{
		
		MovimentacaoLocalEstoque movimentacaoLocalEstoque = new MovimentacaoLocalEstoque(getDao());

		movimentacaoLocalEstoque.movimentarQtdEntreLocaisProdutosComDwEstlocalproFazAjusteSeSaidaMaiorQueTotal(
				log, idLog,
				omProduto, dwEstLocalProAlimentacao, dwEstLocalProDesalimentacao, 
				qtd.intValue() , omUsuarioCorrente, dataAtual, omCfg);
		
		salvarDesalimentacaoPendenteContagem(dwEstLocalProDesalimentacao, dataAtual, qtd);
		
	}
	
	private void retiraProdutosDosPontosAlimentacaoDoPt(OmPt omPt) {
		OmpaproDao omPaproDao = new OmpaproDao(getDaoSession());
		omPaproDao.removerTodosProdutosDoPaDoPt(omPt);	
	}
	
	
}

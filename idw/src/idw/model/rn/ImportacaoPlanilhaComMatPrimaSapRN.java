package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwEstsalma;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TtSapEstmppa;
import idw.model.pojos.template.DwEstMovTemplate;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutosDTO;
import idw.webservices.dto.ResultadoImportacaoSapDTO;
import idw.webservices.dto.SapEstoqueDTO;
import idw.webservices.dto.SapEstoquesDTO;
import idw.webservices.dto.UsuarioDTO;

public class ImportacaoPlanilhaComMatPrimaSapRN extends SapEstoquesDTO implements IDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient DAOGenerico dao; //para MapQuery
	private boolean isIntegrar = false;
	private ProdutosDTO produtosDesconhecidos = new ProdutosDTO();
	
	public ImportacaoPlanilhaComMatPrimaSapRN() {
		this.dao = new DAOGenerico();
	}
	public ImportacaoPlanilhaComMatPrimaSapRN(DAOGenerico dao) {
		this.dao = dao;
	}
	/*
	 * Esse metodo eh chamado originalmente pela importacao do estoque, nesse caso apagar o estoque = true
	 */
	public ResultadoImportacaoSapDTO importarPlanilha(UsuarioDTO usrlogadodto){
		produtosDesconhecidos.setProdutos(new ArrayList<ProdutoDTO>());
		return importarPlanilha(usrlogadodto, true);		
	}
	
	public ResultadoImportacaoSapDTO importarPlanilha(UsuarioDTO usrlogadodto, boolean isApagarEstoque, boolean integrar){
		isIntegrar = integrar;
		produtosDesconhecidos.setProdutos(new ArrayList<ProdutoDTO>());
		return importarPlanilha(usrlogadodto, isApagarEstoque);
	}
	
	/*
	 * Esse metodo pode ser chamado pelo metodo acima ou pela importacao da producao. Qdo for importacao da producao
	 * o estoque nao sera apagado
	 */
	public ResultadoImportacaoSapDTO importarPlanilha(UsuarioDTO usrlogadodto, boolean isApagarEstoque){
		
		IdwLogger log = new IdwLogger("PlanilhaComMatPrimaSap");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		log.iniciaAvaliacao(idLog, "PlanilhaEstoqueSap");
		if (isIntegrar){
			log.info(idLog, 0, "Iniciando integracaoEstoqueSAP");
		}else{
			log.info(idLog, 0, "Iniciando importacaoEstoqueSAP");
		}
		
		ResultadoImportacaoSapDTO retorno = new ResultadoImportacaoSapDTO();
		ProdutoRN produtoRN = new ProdutoRN(dao);
		
		produtosDesconhecidos.setProdutos(new ArrayList<ProdutoDTO>());
	
		/*
		 * Atencao, esse metodo tambem eh chamado pela importacao da producao
		 * nessa situacao nao se deve apagar o estoque atual
		 */
		if (isApagarEstoque == true) {
			// Ao importar o estoque inicial do mes, devemos limpar todos os registros de ajustes de estoque, pq nao devemos 
			MapQuery qApagarMov = null;
			qApagarMov = new MapQuery(dao.getSession());
			qApagarMov.append("delete from DwEstmov");
			qApagarMov.query().executeUpdate();
			
			// Limpar tambem as ocorrencias em dwestpro, visto que pode ter resquisios da situacao anterior e o
			// que vale eh essa importacao
			MapQuery qApagaEst = null;
			qApagaEst = new MapQuery(dao.getSession());
			qApagaEst.append("delete from DwEstpro");
			qApagaEst.query().executeUpdate();
		}
		
		MapQuery qEstoqueAjuste = null;
		qEstoqueAjuste = new MapQuery(dao.getSession());
		
		qEstoqueAjuste.append("from DwEstpro dwestpro");
		qEstoqueAjuste.append("join fetch dwestpro.dwEstmovs dwestmov");
		qEstoqueAjuste.append("where dwestpro = :dwestpro");
		qEstoqueAjuste.append("and dwestmov.lancamento = :lancamento");
		qEstoqueAjuste.append("and dwestmov.dthrMov = :dt");

		// NEsse pontos, antes de comecarmos a importar os dados da planilha, devemos completa-lo com os dados cadastrados para os itens que nao estao vindo pela
		// planilha
		Date dtreferencia;
		
		if (getSapestoques() != null && getSapestoques().size() > 0)
			dtreferencia = getSapestoques().get(0).getDwconsolid().getDtReferencia();// getSapestoque().getDthrReferencia();
		else
			dtreferencia = DataHoraRN.getDataHoraAtual();
		
		MapQuery qEstoqueAvulso = null;
		qEstoqueAvulso = new MapQuery(dao.getSession());
		
		qEstoqueAvulso.append("from DwEstsalma dwestsalma");
		qEstoqueAvulso.append("join fetch dwestsalma.omProduto omproduto");
		qEstoqueAvulso.append("where dwestsalma.dtReferencia = :dtReferencia");
		
		qEstoqueAvulso.defineParametro("dtReferencia", dtreferencia);
		List<DwEstsalma> listaSalma = qEstoqueAvulso.list();
		
		int ano = DataHoraRN.getApenasAno(dtreferencia);
		int mes = DataHoraRN.getApenasMes(dtreferencia);
		
		for (DwEstsalma dwestsalma : listaSalma){
			SapEstoqueDTO dto = new SapEstoqueDTO();
			TtSapEstmppa sap = new TtSapEstmppa();
			DwConsolid dwconsolid = new DwConsolid();
			
			sap.setGlobalcode(dwestsalma.getOmProduto().getCdProduto());
			sap.setQtEstoque(dwestsalma.getQtSaldofinalmes());
			sap.setDthrReferencia(dtreferencia);
			
			dwconsolid.setAno(ano);
			dwconsolid.setMes(mes);
			dwconsolid.setDwTurno(null);
			
			dto.setAjustarEstoque(false);
			dto.setDwconsolid(dwconsolid);
			dto.setFechamentoMes(true);
			dto.setSapestoque(sap);
			
			getSapestoques().add(dto);
			
		}

        for (SapEstoqueDTO p : getSapestoques()) {
        	if (p.getSapestoque().getGlobalcode().equals("1RE1TG1381LB-CO")) {
        		log.info(idLog, identacao, "ATUALIZANDO ESTOQUE " + p.getSapestoque().getGlobalcode() + " qtde " + p.getSapestoque().getQtEstoque().longValue());
        		if (p.getSapestoque().getQtEstoque().equals(new BigDecimal(2256))){
        			log.info(idLog, identacao, "DEBUG");
        		}
        	}
        }


		OmCfg omcfg = Util.getConfigGeral(dao.getSession());
		DwEst dwEst = omcfg.getDwEstByIdEstmp();
		
		// Obtem instancia do usuario logado
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(dao.getSession());
		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogadodto.getUsuario().getCdUsr());

		EstoqueRN estoqueRN = new EstoqueRN(dao);
		
		
		// Varre todos os itens para efetuar um lancamento de ajuste no dwestmov
		for (SapEstoqueDTO est: this.getSapestoques()){
			
			// Se a quantidade for null passar para o proximo item
			if (est.getSapestoque().getQtEstoque() == null)
				continue;
			
			// 1a coisa eh colocar o valor do ajuste para 4 casas decimais
			try {
				est.getSapestoque().setQtEstoque(est.getSapestoque().getQtEstoque().divide(BigDecimal.ONE,4, BigDecimal.ROUND_HALF_DOWN));
			} catch (NullPointerException e){
				e.printStackTrace();
			}
			// Pesquisa o produto, se nao existir incluir
			OmProduto omproduto = produtoRN.getProdutoByCdEStAtivo(est.getSapestoque().getGlobalcode());
			
			if (omproduto == null){
				log.info("Produto desconhecido " + est.getSapestoque().getGlobalcode());
			}
			ProdutoDTO produtoDTO = new ProdutoDTO();
			OmProduto prod = new OmProduto();
			prod.setCdProduto(est.getSapestoque().getGlobalcode());
			produtoDTO.setProduto(prod);
			
			if(omproduto == null){
				produtosDesconhecidos.getProdutos().add(produtoDTO);
				log.info(idLog, 5, "DESCARTANDO produto " + est.getSapestoque().getGlobalcode() + " pois nao existe em uma estrutura.");
				continue;
			}

			if (omproduto.getCdProduto().equals("493277")) {
				log.info(idLog, 5, "Produto " + omproduto.getCdProduto() + " encontrado. Qtde " + est.getSapestoque().getQtEstoque() );
				if (est.getSapestoque().getQtEstoque().equals(new BigDecimal(2256)))
					log.info("DEBUG");
			}
			
			BigDecimal ajuste = null;
			
			// Pesquisa se o produto tem entrada em estoque, se n�o, lancar primeira entrada
			DwEstpro dwestpro = new DwEstpro();
			dwestpro.setOmProduto(omproduto);
			dwestpro = estoqueRN.pesquisarDwEstproByIdProduto(dwestpro);
			if (dwestpro == null){
				dwestpro = new DwEstpro();
				dwestpro.setIdEstpro(null);
				dwestpro.setOmProduto(omproduto);
				dwestpro.setPpCliente(omproduto.getPpCliente());
				dwestpro.setDwEst(dwEst);
				dwestpro.setQtAjuste(est.getSapestoque().getQtEstoque());
				dwestpro.setQtEntrada(BigDecimal.ZERO);
				dwestpro.setQtReservada(BigDecimal.ZERO);
				dwestpro.setQtSaida(BigDecimal.ZERO);

	        	dao.makePersistent(dwestpro);
	        	
	        	ajuste = dwestpro.getQtAjuste();
	        	
			} else {
				// Calcula ajuste
				BigDecimal saldo = dwestpro.getQtEntrada().subtract(dwestpro.getQtSaida());
				saldo = saldo.add(dwestpro.getQtAjuste()); //.round(mc);
				
				if (est.isFechamentoMes() == true)
					ajuste = est.getSapestoque().getQtEstoque();
				else {
					// Alessandre: comentei as 3 linhas abaixo pq se o valor for negativo e eu usar o subtract
					// ele vai somar. E o add em seguida subtrai qdo o valor eh negativo e soma qdo +
//					if (est.getSapestoque().getQtEstoque().intValue() < 0)
//						ajuste = saldo.subtract(est.getSapestoque().getQtEstoque());
//					else
						ajuste = saldo.add(est.getSapestoque().getQtEstoque());
				}
				
				// Altera o saldo do produto no estoque
				dwestpro.setQtAjuste(ajuste);
				
				dao.makePersistent(dwestpro);

			}
			

			// DwEstmov deve ser gerado mesmo que dwestpro seja gerado um novo
			log.info(idLog, 5, "Ajustando saldo estoque para produto " + omproduto.getCdProduto() + " com qt. " + dwestpro.getQtAjuste());

			// Incluir lancamento de ajuste do estoque do item caso ja existe um saldo de estoque
			DwEstmov dwestmov = new DwEstmov();
			dwestmov.setDthrCadastro(DataHoraRN.getDataHoraAtual());
			if (est.getSapestoque() != null && est.getSapestoque().getDthrReferencia() != null)
				dwestmov.setDthrMov(est.getSapestoque().getDthrReferencia());
			else
				dwestmov.setDthrMov(est.getDwconsolid().getDtReferencia());
			
			dwestmov.setAno(est.getDwconsolid().getAno());
			dwestmov.setMes(est.getDwconsolid().getMes());
			dwestmov.setDwEstpro(dwestpro);
			dwestmov.setIdEstmov(null);
			dwestmov.setIsEfetivado(true);
			dwestmov.setOmUsr(omusr);
			if (est.isAjustarEstoque() == true && est.isFechamentoMes() == false)
				dwestmov.setLancamento(DwEstMovTemplate.TpLancamento.AJUSTE.getDs());
			else if (est.isFechamentoMes() == true){
				dwestmov.setLancamento(DwEstMovTemplate.TpLancamento.FINAL_MES.getDs());
			} else {
				dwestmov.setOmPt(est.getDwconsolid().getOmPt());
				dwestmov.setOmGt(est.getDwconsolid().getOmGt());
			}
			
			dwestmov.setDwTurno(est.getDwconsolid().getDwTurno());
			
			dwestmov.setQtAjuste(ajuste);
				
			dwestmov.setQtEntradaAnt(dwestpro.getQtEntrada());
			dwestmov.setQtReservadaAnt(dwestpro.getQtReservada());
			dwestmov.setQtSaidaAnt(dwestpro.getQtSaida());
			dwestmov.setTpMov(DwEstMovTemplate.TpMov.AJUSTE.getId()); // ajuste
			if(isIntegrar){
				dwestmov.setTpOrigem(DwEstMovTemplate.TpOrigem.INTEGRADO.getId()); // integrar
			}else{
				dwestmov.setTpOrigem(DwEstMovTemplate.TpOrigem.IMPORTADO.getId()); // importacao
			}
			dwestmov.setQtAjusteAnt(est.getSapestoque().getQtEstoque()); // Alessandre: quero salvar o fator de + ou - dwestpro.getQtAjuste());

			boolean isIncluirDwEstmov = true;
			
			// Alessandre; 17-01-13 acho que nao sera necessario verificar se existe, pois
			// os registros sao excluidos anteriormente. Para ter dois somente se tiver erro na fonte
			// com o item repetido.
//			if (est.isFechamentoMes() == true){
//				// Antes de inserir verificar se ja nao existe. Se existir com a mesma quantidade, ignorar, senao incluir um novo
//				qEstoqueAjuste.defineParametro("dwestpro", dwestpro);
//				qEstoqueAjuste.defineParametro("lancamento", "FINAL MES");
//				qEstoqueAjuste.defineParametroData("dt", dwestmov.getDthrMov());
//				
//				DwEstpro dwestproEncontrado = (DwEstpro) qEstoqueAjuste.uniqueResult();
//				
//				
//				if (dwestproEncontrado != null) {
//					isIncluirDwEstmov = false;
//					// Verifica se o valor da movimentacao � o mesmo
//					for (DwEstmov d : dwestproEncontrado.getDwEstmovs()){
//						if (d.getQtAjuste().doubleValue() != dwestmov.getQtAjuste().doubleValue()) {
//							d.setQtAjuste(dwestmov.getQtAjuste());
//							dao.makePersistent(d);
//							break;
//						}
//					}
//					
//				}
//			}
			
			if (isIncluirDwEstmov == true) {
				dao.makePersistent(dwestmov);
				dao.flushReiniciandoTransacao();
			}

		}
		retorno.setResultadoEvento(0);
		log.paraAvaliacao(dao);
		log.info(idLog, 0, log.getAvaliacaoCompleta());
		return retorno;
	}
	
	public ProdutosDTO getProdutosDesconhecidos() {
		return produtosDesconhecidos;
	}
	public void setProdutosDesconhecidos(ProdutosDTO produtosDesconhecidos) {
		this.produtosDesconhecidos = produtosDesconhecidos;
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}
}
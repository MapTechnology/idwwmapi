package idw.model.rn.geraplano;

import java.util.List;
import java.util.SortedMap;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.model.rn.geraplano.passos.tipoA.TipoAAbateEstoques;
import idw.model.rn.geraplano.passos.tipoA.TipoAAgrupaProdutoNoCT;
import idw.model.rn.geraplano.passos.tipoA.TipoAAjustaBranches;
import idw.model.rn.geraplano.passos.tipoA.TipoAAlocacaoEmMaquina;
import idw.model.rn.geraplano.passos.tipoA.TipoAAntecipaSeDer;
import idw.model.rn.geraplano.passos.tipoA.TipoAAvaliandoMateriaPrima;
import idw.model.rn.geraplano.passos.tipoA.TipoABalanceamento;
import idw.model.rn.geraplano.passos.tipoA.TipoACpsMinimo8h;
import idw.model.rn.geraplano.passos.tipoA.TipoADesfragmentaCPs;
import idw.model.rn.geraplano.passos.tipoA.TipoAGeraLayout;
import idw.model.rn.geraplano.passos.tipoA.TipoAGeraLogs;
import idw.model.rn.geraplano.passos.tipoA.TipoAGeraNecessidade;
import idw.model.rn.geraplano.passos.tipoA.TipoAIndisponibilidade;
import idw.model.rn.geraplano.passos.tipoA.TipoAInsereCPs;
import idw.model.rn.geraplano.passos.tipoA.TipoAPrimeiroPasso;
import idw.model.rn.geraplano.passos.tipoA.TipoARemoveConflitoInclusivePre;
import idw.model.rn.geraplano.passos.tipoA.TipoATempoSetup;
import idw.model.rn.geraplano.passos.tipoA.TipoAUnirComMesmaDtFinal;
import idw.model.rn.geraplano.passos.tipoA.TipoAUnirTempoInferior8h;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class GeraPlanoProducaoTipoA extends GeraAbstractPlanoFactory implements IDao{

	private DAOGenerico dao;
	
	public GeraPlanoProducaoTipoA(DAOGenerico dao){
		this.dao = dao;
	}
	@Override
	public PlanoDTO processaPlano(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr) {
		// Ao entrar nesse metodo o plano ja foi verificado e está apto para ser processado
		PlanoDTO retorno = new PlanoDTO(ppplano, dao);
		
		TipoAPrimeiroPasso primeiroRN = new TipoAPrimeiroPasso(dao);
		retorno = primeiroRN.geraPrimeiroPasso(log, idLog, identacao, ppplano, omusr);
		log.info(idLog, identacao, "geraPrimeiroPasso");
		
		// Se houver acontecido algum problema no 1o passo retornar
		if (retorno.getResultadoDTO().isComSucesso() == false || (retorno.getMensagem() != null && retorno.getMensagem().equals("") == false) ){
			return retorno;
		}

		// Define ano e mes de referencia
		int anoReferencia = DataHoraRN.getApenasAno(retorno.getDtReferenciaAntecipacao());
		int mesReferencia = DataHoraRN.getApenasMes(retorno.getDtReferenciaAntecipacao());
		
		
		SortedMap<ProdutoComparable, List<PassosDTO>> alocacaoProduto = null;
		SortedMap<IdCtDTO, CtDTO> alocacaoCT = null;

		// Passo 3: Gera as CPs para atendimento de todos os PpPlaNecCron
		// As cps dever�o considerar o calendario, limitacao dos pts, quantidade de dias para atendimento do plano
		TipoAGeraLogs geraLog = new TipoAGeraLogs();
		
		log.iniciaAvaliacao(idLog, "processaPlano.geraCpsParaNecessidade");
		TipoAGeraNecessidade necRN = new TipoAGeraNecessidade(dao);
		alocacaoProduto = necRN.geraCpsParaNecessidade(log, idLog, identacao, ppplano, omusr, retorno);
		log.paraAvaliacao(dao);
		if (alocacaoProduto == null)
			return retorno;
		log.info(idLog, identacao, "geraCpsParaNecessidade");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		
		
		// Mostrar as cps virtuais
		// Analisa cada produto da lista de cps virtuais
		TipoAUnirComMesmaDtFinal unirDtFinalRN = new TipoAUnirComMesmaDtFinal();
		alocacaoProduto = unirDtFinalRN.geraCpsConsolidadasQueTenhamMesmaDataFinal(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsConsolidadas");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Remove das quantidades necessarias o estoque do produto, considerando apenas os produtos pai na estrutura
		// nao removendo predecessoras
		TipoAAbateEstoques abateRN = new TipoAAbateEstoques(dao);
		abateRN.inicializaSaldoProdutosConformeRegraDaMonitorizacaoPPRN(log, idLog, identacao, ppplano, omusr, alocacaoProduto, anoReferencia, mesReferencia);
		alocacaoProduto = abateRN.geraCpsAbatendoEstoque(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAbatendoEstoqueDosNiveisPais");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		
		// Agora remove a producao apontada ate o momento dos produtos do roteiro e suas predecessoras
		/* Alessandre: Esse passo deixou de ser necessário quando passamos a usar os dados de saldo de estoque e producao da tela de monitorizacao.
		 * Logo tudo esta sendo feito no passo anterior
		abateRN.inicializaSaldoProdutos(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		alocacaoProduto = abateRN.geraCpsAbatendoEstoque(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAbatendoEstoque");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		 */
		
		// Concatena as cps para obter ao menos 8h de producao
		TipoACpsMinimo8h minimoRN = new TipoACpsMinimo8h();
		alocacaoProduto = minimoRN.geraCpsComNoMinimo8Horas(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsComNoMinimo8Horas");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Concatena as CPs que ainda esta com menos de 8h de producao com outras
		TipoAUnirTempoInferior8h oitoRN = new TipoAUnirTempoInferior8h();
		alocacaoProduto = oitoRN.geraCpsConcatenandoAsInferiores8horas(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsConcatenandoAsInferiores8horas");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Ajusta as quantidades com o multiplo dos branches
		TipoAAjustaBranches branchRN = new TipoAAjustaBranches();
		alocacaoProduto = branchRN.geraCpsAjustandoBranches(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAjustandoBranches");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		
		// Quero analisar nesse ponto quais os produtos que mais consumirao maquina, dentro das necessidades definidas
		geraLog.mostrarProdutosOrdenadosDesTmpEst(log, idLog, identacao, alocacaoProduto);

		// Aloca em CT as CPs existentes
		TipoAAlocacaoEmMaquina alocaRN = new TipoAAlocacaoEmMaquina();
		alocacaoCT = alocaRN.geraCpsAlocandoEmMaquina(log, idLog, identacao, ppplano, omusr, alocacaoProduto, retorno);
		if(alocacaoCT == null)
			return retorno;
		log.info(idLog, identacao, "geraCpsAlocandoEmMaquina");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Inicializa os periodos de indisponibilidade dos CTs
		TipoAIndisponibilidade indRN = new TipoAIndisponibilidade(dao);
		indRN.geraIndisponibilidade(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraIndisponibilidade");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Chama o passo abaixo para recalcular todas as datas de inicio e fim dos passos
		// apos a inicialização das indisponibilidades, pois existe a possibilidade dos passos posterioores
		// nao necessitarem realizar (forcar) esse recalculo, entao eh melhor forcar aqui em um passo especifico
	/*	TipoAForcaCalculoDatasAposIndisponibilidadeInicializada forcaRN = new TipoAForcaCalculoDatasAposIndisponibilidadeInicializada();
		forcaRN.geraCpsForcandoRecalculoDatas(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAjustandoBranches");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);*/

		/*
		 * Alessandre: estou avaliando um calculo errado no proximo passo. O passo quer a ordernacao dos CTs das SMDs a ILHOIS, mas isso eh errado pois
		 * o SMD nao necessariamente eh o ultimo passo. O ultimo passo pode ser uma linha de IMC
		 */
		TipoARemoveConflitoInclusivePre semconfRN = new TipoARemoveConflitoInclusivePre();
		alocacaoCT = semconfRN.geraCpsSemConflitoRecalculandoPredecessoras(log, idLog, identacao, ppplano, omusr, alocacaoCT, true);
		log.info(idLog, identacao, "geraCpsSemConflitoRecalculandoPredecessoras");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

//		TipoARemoveConflitoSemPre sempreRN = new TipoARemoveConflitoSemPre();
//		sempreRN.geraCpsSemConflitoNAORecalculandoPredecessoras(log, idLog, 10, ppplano, omusr);
//		log.info(idLog, 10, "geraCpsSemConflitoNAORecalculandoPredecessoras");
//		geraCp.mostrarPassosCTSemPredecessora(log, idLog, 10, geraCp.getAlocacaoCTsSemConflito2());

		TipoAAgrupaProdutoNoCT def1RN = new TipoAAgrupaProdutoNoCT();
		alocacaoCT = def1RN.geraCpsAgrupandoProdutosQdoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		TipoAAntecipaSeDer antecipaRN = new TipoAAntecipaSeDer();
		alocacaoCT = antecipaRN.geraCpsAntecipandoQuandoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAntecipandoQuandoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		TipoABalanceamento balancoRN = new TipoABalanceamento();
		alocacaoCT = balancoRN.geraCpsBalanceandoMaquinas(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsBalanceandoMaquinas");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// aqui passo acrescentando producao a mais
		
		// aqui passo acrescentando o tempo de setup
		TipoATempoSetup setupRN = new TipoATempoSetup();
		alocacaoCT = setupRN.geraCpsIncluindoTempoSetup(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsIncluindoTempoSetup");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Depois que acrescentar o tempo de setup, remover os conflitos se houverem
		alocacaoCT = semconfRN.geraCpsSemConflitoRecalculandoPredecessoras(log, idLog, identacao, ppplano, omusr, alocacaoCT,false);
		log.info(idLog, identacao, "geraCpsSemConflitoRecalculandoPredecessoras");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Vamos executar novamente o agrupamento quando der
		alocacaoCT = def1RN.geraCpsAgrupandoProdutosQdoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer-2x");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Remove qq espaco vago para as maquinas
		TipoADesfragmentaCPs desfragRN = new TipoADesfragmentaCPs();
		alocacaoCT = desfragRN.geraCpsDesfragmentadas(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
		log.info(idLog, identacao, "geraCpsDefrag");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		
		// Nesse ponto, separar as CPs que atendem o proximo periodo e marcar as que atendem apenas o proximo periodo
		alocacaoCT = semconfRN.geraCpsSemConflitoRecalculandoPredecessoras(log, idLog, identacao, ppplano, omusr, alocacaoCT,false);
		log.info(idLog, identacao, "geraCpsSemConflitoRecalculandoPredecessoras");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Nesse ponto, marcar as Cps que nao tiverem materia-prima suficiente
		if (ppplano != null && ppplano.getIsConsiderarmp() != null && ppplano.getIsConsiderarmp() == true) {
			TipoAAvaliandoMateriaPrima mpRN = new TipoAAvaliandoMateriaPrima(dao);
			alocacaoCT = mpRN.geraCpsAvaliandoMP(log, idLog, identacao, ppplano, omusr, alocacaoCT);
			log.info(idLog, identacao, "geraCpsAvaliandoMP");
			geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		}
		
		// Antes de inserir, devemos ajustar o inicio de cada CP para comecar no inicio do turno
//		TipoAAjustaInicioCPParaInicioTurno aiRN = new TipoAAjustaInicioCPParaInicioTurno();
//		alocacaoCT = aiRN.geraCpsAjustandoInicioCp(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
//		log.info(idLog, identacao, "geraCpsAvaliandoMP");
//		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Finalizar o procedimento inserindo no banco as cps
		TipoAInsereCPs insertRN = new TipoAInsereCPs(dao);
		insertRN.inserirCpsNaBase(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		insertRN.inserirCpsPrecessoras(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		insertRN.inserirCpsAtuaisDoPlanoFirmado(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		
		// Gera layout para o plano simulado.
		TipoAGeraLayout layoutRN = new TipoAGeraLayout(dao);
		layoutRN.geraLayout(ppplano);
		
		// Nesse momento marca tb o plano como processado
		ppplano.setIsSimular(false);
		dao.makePersistent(ppplano);
		 		
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getCOM_SUCESSO());
		
		return retorno;
	}

	
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}
}

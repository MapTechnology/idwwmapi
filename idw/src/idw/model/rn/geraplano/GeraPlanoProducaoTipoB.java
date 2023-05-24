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
import idw.model.rn.geraplano.passos.tipoB.TipoBAbateEstoques;
import idw.model.rn.geraplano.passos.tipoB.TipoBAgrupaProdutoNoCT;
import idw.model.rn.geraplano.passos.tipoB.TipoBAjustaBranches;
import idw.model.rn.geraplano.passos.tipoB.TipoBAlocacaoEmMaquina;
import idw.model.rn.geraplano.passos.tipoB.TipoBAntecipaSeDer;
import idw.model.rn.geraplano.passos.tipoB.TipoBAvaliandoMateriaPrima;
import idw.model.rn.geraplano.passos.tipoB.TipoBCpsMinimo8h;
import idw.model.rn.geraplano.passos.tipoB.TipoBDesfragmentaCPs;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraLayout;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraLogs;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraNecessidade;
import idw.model.rn.geraplano.passos.tipoB.TipoBIndisponibilidade;
import idw.model.rn.geraplano.passos.tipoB.TipoBInsereCPs;
import idw.model.rn.geraplano.passos.tipoB.TipoBPrimeiroPasso;
import idw.model.rn.geraplano.passos.tipoB.TipoBUnirTempoInferior8h;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class GeraPlanoProducaoTipoB extends GeraAbstractPlanoFactory implements IDao{

	private DAOGenerico dao;
	
	public GeraPlanoProducaoTipoB(DAOGenerico dao){
		this.dao = dao;
	}
	@Override
	public PlanoDTO processaPlano(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr) {
		// Ao entrar nesse metodo o plano ja foi verificado e está apto para ser processado
		PlanoDTO retorno = new PlanoDTO(ppplano, dao);

		
		// O primeiro passo limpa a simulacao anterior, determina se eh uma antecipacao, etc
		TipoBPrimeiroPasso primeiroRN = new TipoBPrimeiroPasso(dao);
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
		// As cps deverão considerar o calendario, limitacao dos pts, quantidade de dias para atendimento do plano
		TipoBGeraLogs geraLog = new TipoBGeraLogs();
		
		log.iniciaAvaliacao(idLog, "processaPlano.geraCpsParaNecessidade");
		TipoBGeraNecessidade necRN = new TipoBGeraNecessidade(dao);
		alocacaoProduto = necRN.geraCpsParaNecessidade(log, idLog, identacao, ppplano, omusr, retorno);
		log.paraAvaliacao(dao);
		if (alocacaoProduto == null)
			return retorno;		
		log.info(idLog, identacao, "geraCpsParaNecessidade");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		
		
		// Remove das quantidades necessarias o estoque do produto, considerando apenas os produtos pai na estrutura
		// nao removendo predecessoras
		TipoBAbateEstoques abateRN = new TipoBAbateEstoques(dao);
		abateRN.inicializaSaldoEstoque(log, idLog, identacao, ppplano, omusr, alocacaoProduto, anoReferencia, mesReferencia);
		alocacaoProduto = abateRN.geraCpsAbatendoEstoque(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAbatendoEstoqueDosNiveisPais");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Concatena as cps para obter ao menos 8h de producao
		TipoBCpsMinimo8h minimoRN = new TipoBCpsMinimo8h();
		alocacaoProduto = minimoRN.geraCpsComNoMinimo8Horas(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsComNoMinimo8Horas");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Concatena as CPs que ainda esta com menos de 8h de producao com outras
		TipoBUnirTempoInferior8h oitoRN = new TipoBUnirTempoInferior8h();
		alocacaoProduto = oitoRN.geraCpsConcatenandoAsInferiores8horas(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsConcatenandoAsInferiores8horas");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		
		// Ajusta as quantidades com o multiplo dos branches
		TipoBAjustaBranches branchRN = new TipoBAjustaBranches();
		alocacaoProduto = branchRN.geraCpsAjustandoBranches(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAjustandoBranches");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);
		
		// Quero analisar nesse ponto quais os produtos que mais consumirao maquina, dentro das necessidades definidas
		geraLog.mostrarProdutosOrdenadosDesTmpEst(log, idLog, identacao, alocacaoProduto);

		// Alessandre: Em 3-2-13 a alocacao das maquinas mudou em relacao ao tipo A (que aloca do futuro para o presente), agora a alocacao eh feita do
		// presente para o futuro
		// Aloca em CT as CPs existentes
		TipoBAlocacaoEmMaquina alocaRN = new TipoBAlocacaoEmMaquina(dao);
		alocacaoCT = alocaRN.geraCpsAlocandoEmMaquina(log, idLog, identacao, ppplano, omusr, alocacaoProduto, retorno, TipoBAlocacaoEmMaquina._SOMENTE_CTS_COM_CP);
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		alocacaoCT = alocaRN.geraCpsAlocandoEmMaquina(log, idLog, identacao, ppplano, omusr, alocacaoProduto, retorno, TipoBAlocacaoEmMaquina._SOMENTE_CTS_EXCLUSIVOS);
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		alocacaoCT = alocaRN.geraCpsAlocandoEmMaquina(log, idLog, identacao, ppplano, omusr, alocacaoProduto, retorno, TipoBAlocacaoEmMaquina._SOMENTE_COM_MAIS_DE_UM_CT);
		if(alocacaoCT == null)
			return retorno;
		log.info(idLog, identacao, "geraCpsAlocandoEmMaquina");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Inicializa os periodos de indisponibilidade dos CTs
		TipoBIndisponibilidade indRN = new TipoBIndisponibilidade(dao);
		indRN.geraIndisponibilidade(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraIndisponibilidade");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		
		TipoBAgrupaProdutoNoCT def1RN = new TipoBAgrupaProdutoNoCT();
		alocacaoCT = def1RN.geraCpsAgrupandoProdutosQdoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		TipoBAntecipaSeDer antecipaRN = new TipoBAntecipaSeDer();
		alocacaoCT = antecipaRN.geraCpsAntecipandoQuandoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAntecipandoQuandoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Depois de antecipar, vamos tentar agrupar novamente
		TipoBAgrupaProdutoNoCT def2RN = new TipoBAgrupaProdutoNoCT();
		alocacaoCT = def2RN.geraCpsAgrupandoProdutosQdoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Remove qq espaco vago para as maquinas
		TipoBDesfragmentaCPs desfragRN = new TipoBDesfragmentaCPs();
		alocacaoCT = desfragRN.geraCpsDesfragmentadas(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
		log.info(idLog, identacao, "geraCpsDefrag");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Depois de antecipar, vamos tentar agrupar novamente
		TipoBAgrupaProdutoNoCT def3RN = new TipoBAgrupaProdutoNoCT();
		alocacaoCT = def3RN.geraCpsAgrupandoProdutosQdoDer(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsAgrupandoProdutosQdoDer");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Remove novamente pq podemos ter SMD como predecessora da RH
		TipoBDesfragmentaCPs desfrag2RN = new TipoBDesfragmentaCPs();
		alocacaoCT = desfrag2RN.geraCpsDesfragmentadas(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
		log.info(idLog, identacao, "geraCpsDefrag");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Remove novamente pq podemos ter SMD como predecessora da RH
		TipoBDesfragmentaCPs desfrag3RN = new TipoBDesfragmentaCPs();
		alocacaoCT = desfrag3RN.geraCpsDesfragmentadas(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
		log.info(idLog, identacao, "geraCpsDefrag");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Nesse ponto, marcar as Cps que nao tiverem materia-prima suficiente
		if (ppplano != null && ppplano.getIsConsiderarmp() != null && ppplano.getIsConsiderarmp() == true) {
			TipoBAvaliandoMateriaPrima mpRN = new TipoBAvaliandoMateriaPrima(dao);
			alocacaoCT = mpRN.geraCpsAvaliandoMP(log, idLog, identacao, ppplano, omusr, alocacaoCT);
			log.info(idLog, identacao, "geraCpsAvaliandoMP");
			geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		}
		
		// Finalizar o procedimento inserindo no banco as cps
		TipoBInsereCPs insertRN = new TipoBInsereCPs(dao);
		insertRN.inserirCpsNaBase(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		insertRN.inserirCpsPrecessoras(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		// Alessandre: Em 3-2-13 nesse algotirmo removi o passo abaixo pois a alocacao dos CTs deve prever as cps atuais
//		insertRN.inserirCpsAtuaisDoPlanoFirmado(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		
		// Gera layout para o plano simulado.
		TipoBGeraLayout layoutRN = new TipoBGeraLayout(dao);
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

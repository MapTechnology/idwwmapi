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
import idw.model.rn.geraplano.passos.tipoA.TipoAInsereCPs;
import idw.model.rn.geraplano.passos.tipoB.TipoBAbateEstoques;
import idw.model.rn.geraplano.passos.tipoB.TipoBAjustaBranches;
import idw.model.rn.geraplano.passos.tipoB.TipoBAlocacaoEmMaquina;
import idw.model.rn.geraplano.passos.tipoB.TipoBDesfragmentaCPs;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraLayout;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraLogs;
import idw.model.rn.geraplano.passos.tipoB.TipoBGeraNecessidade;
import idw.model.rn.geraplano.passos.tipoB.TipoBIndisponibilidade;
import idw.model.rn.geraplano.passos.tipoB.TipoBPrimeiroPasso;
import idw.model.rn.geraplano.passos.tipoC.TipoCAdiantandoCPsParaAmanha;
import idw.model.rn.geraplano.passos.tipoC.TipoCForcaCalculoDatasAposIndisponibilidadeInicializada;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class GeraPlanoProducaoTipoC extends GeraAbstractPlanoFactory implements IDao{

	private DAOGenerico dao;

	public GeraPlanoProducaoTipoC(DAOGenerico dao){
		this.dao = dao;
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
		//geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);


		// Ajusta as quantidades com o multiplo dos branches
		TipoBAjustaBranches branchRN = new TipoBAjustaBranches();
		alocacaoProduto = branchRN.geraCpsAjustandoBranches(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAjustandoBranches");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Colocar a data de inicio para amanha
		TipoCAdiantandoCPsParaAmanha adiantaRN = new TipoCAdiantandoCPsParaAmanha(dao);
		alocacaoProduto = adiantaRN.geraCpsAdiantandoParaAmanha(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		log.info(idLog, identacao, "geraCpsAdiantandoParaAmanha");
		geraLog.mostrarPassosSemPredecessora(log, idLog, identacao + 10, alocacaoProduto);

		// Definir quais os CTs deverão executar os procedimentos
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

		
		// Inicializa os periodos de indisponibilidade dos CTs, mas nao recalcula os finais com base na indisponibilidade
		TipoBIndisponibilidade indRN = new TipoBIndisponibilidade(dao);
		indRN.geraIndisponibilidade(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraIndisponibilidade");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);

		// Recalcula datas conforme indisponibilidade

		TipoCForcaCalculoDatasAposIndisponibilidadeInicializada recalRN = new TipoCForcaCalculoDatasAposIndisponibilidadeInicializada();
		recalRN.geraCpsForcandoRecalculoDatas(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		log.info(idLog, identacao, "geraCpsForcandoRecalculoDatas");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao, alocacaoCT);

		// Remove qq espaco vago para as maquinas
		TipoBDesfragmentaCPs desfragRN = new TipoBDesfragmentaCPs();
		alocacaoCT = desfragRN.geraCpsDesfragmentadas(log, idLog, identacao, ppplano, omusr, alocacaoCT, dao);
		log.info(idLog, identacao, "geraCpsDefrag");
		geraLog.mostrarPassosCTSemPredecessora(log, idLog, identacao + 10, alocacaoCT);
		
		// Finalizar o procedimento inserindo no banco as cps
		TipoAInsereCPs insertRN = new TipoAInsereCPs(dao);
		insertRN.inserirCpsNaBase(log, idLog, identacao, ppplano, omusr, alocacaoCT);
		insertRN.inserirCpsPrecessoras(log, idLog, identacao, ppplano, omusr, alocacaoProduto);
		
		
		
		// Gera layout para o plano simulado.
		TipoBGeraLayout layoutRN = new TipoBGeraLayout(dao);
		layoutRN.geraLayout(ppplano);
		
		// Nesse momento marca tb o plano como processado
		ppplano.setIsSimular(false);
		dao.makePersistent(ppplano);
		 		
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getCOM_SUCESSO());
		
		return retorno;
	}
}

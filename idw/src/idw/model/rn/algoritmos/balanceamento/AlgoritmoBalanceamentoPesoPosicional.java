package idw.model.rn.algoritmos.balanceamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.DwOperacao;
import idw.model.pojos.DwOperacaopredecessora;
import idw.util.IdwLogger;
import idw.webservices.dto.FaseDTO;
import idw.webservices.dto.OperacaoDTO;
import idw.webservices.dto.PostoBalanceamentoDTO;

public class AlgoritmoBalanceamentoPesoPosicional {
	
	private IdwLogger log;
	private int idLog;
	
	private Map<String, OperacaoDTO> todasOperacoes = new HashMap<>();
	
	private List<FaseDTO> fasesOrdenadas;

	/*Metodo principal para balanceamento da linha utilizando o algoritmo peso propocional.
	 * 1. Calcular C (Takt-time) = Tempo disponivel / producao planejada
	 * 2. Calcular N (nro de postos) = Soma dos tempos das operações / C (takt-time)
	 * 3. Para cada fase, ordernar decrescentemente as operacores pelo seu tempos agrupando as que forem do mesmo grupo. Para serem do mesmo grupo devem ser continuas
	 * 4. Atribuir a 1a operacao (maior tempo) para o 1o posto, mas caso tenha predecessora, comecar com a predecessora e repetir essa passo 4. (ate nao houver predecessora)
	 * 5. Passar para a proxima operacao que ainda não foi alocada e repetir o passo 4
	 */
	public List<FaseDTO> balancear(long taktTime, List<DwOperacao> operacoes, IdwLogger log, int idLog) {
		
		this.log = log;
		this.idLog = idLog;
		
		log.info(idLog, 0, "AlgoritmoBalanceamentoPesoPosicional.balancear");
		
		// Inicializacao das fases com as operacoes de cada fase
		log.info(idLog, 0, "Inicializando as fases");
		List<FaseDTO> fases = getListaContendoTodasAsFases(operacoes);
		
		// O metodo abaixo analisa as fases e define as ordens
		analisarOrdemFases(fases);

		/* Ordenar as fases por ordem crescente */
		Collections.sort(fases, new Comparator<FaseDTO>() {
			@Override
			public int compare(FaseDTO o1, FaseDTO o2) {
				return o1.getOrdemFase().compareTo(o2.getOrdemFase());
			}
		});
		
		this.fasesOrdenadas = fases;
		
		for (FaseDTO fase : fases) {
			this.log.info(this.idLog, 0, fase.getOrdemFase() + "a. Fase " + fase.getFase().getCdGt() + " tempo " + fase.getSegSomaDasOperacoesDaFase());
			for (OperacaoDTO operacaodto : fase.getOperacoes()) {
				
				// Inicializa o map das operacoes que serao usadas na recursividade do balanceamento das predecessoras
				todasOperacoes.put(operacaodto.getCdOperacao(), operacaodto);
				
				this.log.info(this.idLog, 5, "Operacao " + operacaodto.getCdOperacao() + " tempo " + operacaodto.getSegTempoOperacao());
				for (DwOperacao pre : operacaodto.getPredecessoras() ) {
					this.log.info(this.idLog, 10, "predecessora " + pre.getCdOperacao());
				}
				if (operacaodto.getOperacoes().size() > 1) {
					for (DwOperacao grupo : operacaodto.getOperacoes()) {
						this.log.info(this.idLog, 10, " no mesmo grupo " + grupo.getCdOperacao() + " grupo=" + grupo.getGrupooperacoes() + " tempo=" + grupo.getSegCiclopadrao());
					}
				}
			}
		}
		
		
		
		for (FaseDTO fase : fases) {
			balancearFase(fase, taktTime);
		}
		
		return fases;
		
	}
	
	/* O metodo abaixo tem como objetivo analisar as fases e ordena-las conforme o desenho do diagrama
	 * O algoritmo vai 1o identificar a primeira fase. São aquelas que não possuem predecessoras. podemos ter varias fases sem predecessoras isso ocorre quando são fases paralelas
	 */
	private void analisarOrdemFases(List<FaseDTO> fases) {
		
		// Identificar as fases iniciais (que nao tem predecessoras)
		identificarAsFasesIniciais(fases);
		
		// Varre as fases iniciais e encontrar as fases que tem ela como predecessora
		for (FaseDTO fase : fases) {
			if (fase.getOrdemFase() == 1) {
				identificaProximaFase(fases, fase, 2);
			}
		}
	}
	
	// Esse metodo sera chamado recursivamente para inicializacao da ordem de cada fase
	private void identificaProximaFase(List<FaseDTO> fases, FaseDTO faseAnterior, int ordemFase) {
		// Varre as fases que ainda não tem ordem
		// As que nao tiverem ordem, verificamos se alguma operacao tem como predecessora alguma opercao de faseAnteior
		// se tiver entao definimos a ordem da fase
		// apos definir a ordem chamaremos o mesmo metodo para a fase seguinte
		for (FaseDTO fase : fases) {
			if (fase.getOrdemFase() == null || fase.getOrdemFase() == 0) {
				
				// Verifica se alguma operacao tem como predecessora alguma operacao da faseanteiror
				boolean isExiste = false;
				for (OperacaoDTO operacaodto : fase.getOperacoes()) {
					for (DwOperacao predecessora : operacaodto.getPredecessoras()) {
						
						// varre as operacoes da fase anterior para ver alguma eh predecessora
						for (OperacaoDTO operacaoanterior : faseAnterior.getOperacoes()) {
							// Se alguma operacao anterior for predecessora entao encontramos a fase anterior
							if (operacaoanterior.getCdOperacao().equals(predecessora.getCdOperacao()))
								isExiste = true;
						}
					}
				}
				
				if (isExiste) {
					fase.setOrdemFase(ordemFase);
					identificaProximaFase(fases, fase, ordemFase+1);
				}
			}
		}
	}
	
	private void identificarAsFasesIniciais(List<FaseDTO> fases) {
		for (FaseDTO fase : fases) {
			boolean isFaseInicial = false;
			
			for (OperacaoDTO operacaodto : fase.getOperacoes()) {
				if (operacaodto.getPredecessoras().isEmpty()) {
					isFaseInicial = true;
					break;
				}
			}
			if (isFaseInicial) {
				fase.setOrdemFase(1);
			}
		}
	}
	
	/* Para balancear uma fase devemos seguir os passos
	 * 1. Ordenar decrescentemente as operacoes pelos tempos
	 */
	private void balancearFase(FaseDTO fase, long takttime) {
		List<OperacaoDTO> operacoes = fase.getOperacoes();
		
		// Ordena decrescentemente as operacoes pelo tempo
		Collections.sort(operacoes, new Comparator<OperacaoDTO>() {
			@Override
			public int compare(OperacaoDTO o1, OperacaoDTO o2) {
				return o1.getSegTempoOperacao().compareTo(o2.getSegTempoOperacao()) * -1;
			}
		});
		
		// Mostra as operacoes apos o ordenamento
		log.info(idLog, 0, "Operacoes apos reordenacao da fase " + fase.getOrdemFase() + "a. " + fase.getFase().getCdGt());
		for (OperacaoDTO operacaodto : operacoes) {
			log.info(idLog, 5, "Operacao " + operacaodto.getCdOperacao() + " tempo " + operacaodto.getSegTempoOperacao() + " da fase " + fase.getFase().getCdGt());
		}
		
		for (OperacaoDTO operacaodto : operacoes) {
			balancearOperacao(fase, operacaodto, takttime);
		}
	}

	/* Metodo para balancear operacao especifica, se houverem predecessoras, deve-se chamar o metodo
	 * recursivamente para as predecessoras
	 */
	private void balancearOperacao(FaseDTO fase, OperacaoDTO operacao, long takttime) {

		log.info(idLog, 0, "Balanceando a operacao " + operacao.getCdOperacao());
		
		// Se houverem predecessoras entao priorizar as predecsoroas
		for (DwOperacao pre : operacao.getPredecessoras()) {
			log.info(idLog, 0, "antes balancear a predecessora " + pre.getCdOperacao());
			
			// Encontrar a opepracao na lista geral de operacoes
			OperacaoDTO predto = todasOperacoes.get(pre.getCdOperacao());
			
			// Se for null a causa deve ser pq a operacao faz parte de um grupo, assim devemos encontrar qual a operacao 
			// que agrupou todas elas
			if (predto ==  null) {
				for (String cdoperacao : todasOperacoes.keySet()) {
					OperacaoDTO dto = todasOperacoes.get(cdoperacao);
					for (DwOperacao dwoperacao : dto.getOperacoes()) {
						if (dwoperacao.getCdOperacao().equals(pre.getCdOperacao())) {
							predto = dto;
							break;
						}
					}
				}
			}
			// A operacao predecessora deve ser balanceada apenas se for da mesma fase
			if (predto.getCdFase().equals(fase.getFase().getCdGt()))
				balancearOperacao(fase, predto, takttime);
		}
		
		// Balancear a operacao dentro da fase
		// Verifica se a operacao já foi alocada
		boolean isExiste = false;
		log.info(idLog, 0, "Verificando se a operacao " + operacao.getCdOperacao() + " foi alocada.");
		for (PostoBalanceamentoDTO posto : fase.getPostos() ) {
			for (DwOperacao dwoperacao : posto.getOperacoes() ) {
				if (dwoperacao.getIdOperacao().equals(operacao.getIdOperacao())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste)
				break;
		}
		
		
		// Se nao foi alocada, alocar no 1o posto seguinte as predecessoras com tempo disponivel
		if (isExiste == false) {

			// Encontrar a maior ordem da ultima predecessora alocada
			int ordemPredecessora = getMaiorOrdemDasPrecessorasJaAlocadasNaFase(fase, operacao);
			
			// se ordemPredecessora for 0 então eh a 1a vez com alocacao de operacao na fase, assim devemos utilizar como 1a ordem
			// a ultima ordem da fase anteiror
			if (ordemPredecessora == 0)
				ordemPredecessora = getMaiorOrdemDasPredecessorasJaAlocadasNaFaseAnterior(fase) + 1;
			
			// Obter o posto com a ordem seguinte a encontrada no passo anterior que tenha om mesmo omttp. Se nao existir criar o proximo posto com ultima ordem + 1
			int ordemDisponivelParaAlocacao = getOrdemDisponivelParaAlocacao(fase, operacao, ordemPredecessora, takttime);
			
			log.info(idLog, 0, "Alocando a operacao " + operacao.getCdOperacao() + " na ordem " + ordemDisponivelParaAlocacao + " considerando que a maior ordem das predecessoras eh  " + ordemPredecessora);
			
			PostoBalanceamentoDTO posto = new PostoBalanceamentoDTO();
			
			posto.setCicloPadrao(operacao.getSegTempoOperacao());
			posto.setOmTppt(operacao.getOmtppt());
			posto.getOperacoes().addAll(operacao.getOperacoes());
			posto.setOrdem(ordemDisponivelParaAlocacao);
	
			// verificar se ja existe antes de incluir
			fase.addPosto(posto);
		} else {
			log.info(idLog, 0, "Operação " + operacao.getCdOperacao() + " já alocada anteriormente.");
		}
		
	}
	
	
	/* O objetivo desse metodo eh encontrar a proxima ordem disponivel que tenha o mesmo omtppt/pt considerando a ordem da predecessora
	 * 
	 */
	private int getOrdemDisponivelParaAlocacao(FaseDTO fase, OperacaoDTO operacao, int ordemPredecessora, long takttime) {
		int retorno = 1;
		
		for (PostoBalanceamentoDTO posto : fase.getPostos()) {
			BigDecimal segTempoPostoMaisOperacao = posto.getCicloPadrao();
			segTempoPostoMaisOperacao = segTempoPostoMaisOperacao.add(operacao.getSegTempoOperacao());
			if (segTempoPostoMaisOperacao.compareTo(new BigDecimal(takttime)) <= 0 && posto.getOrdem() >= ordemPredecessora && posto.getOmTppt().getIdTppt() == operacao.getOmtppt().getIdTppt())
				break;
			
			retorno++;
		}
		
		
		return retorno;
	}
	
	/* O objetivo desse metodo eh encontrar a maior ordem das predecessoras da operacao em questão. Essa ordem sera usada como base para alocacao da operacao.
	 * que poderá ser na mesma ordem ou em subsequente
	 */
	private int getMaiorOrdemDasPrecessorasJaAlocadasNaFase(FaseDTO fase, OperacaoDTO operacao) {
		int retorno = 0;
		
		for (DwOperacao pre : operacao.getPredecessoras()) {
			for (PostoBalanceamentoDTO posto : fase.getPostos()) {
				for (DwOperacao opaloc : posto.getOperacoes()) {
					if (opaloc.getOmGt().getCdGt().equals(fase.getFase().getCdGt()) && opaloc.getIdOperacao().equals(pre.getIdOperacao()))
						if (posto.getOrdem() > retorno)
							retorno = (int) posto.getOrdem();
				}
			}
		}
		
		return retorno;
	}
	
	
	private int getMaiorOrdemDasPredecessorasJaAlocadasNaFaseAnterior(FaseDTO fase) {
		int retorno = 0;
		
		for (FaseDTO faseaux : this.fasesOrdenadas) {
			if (faseaux.getOrdemFase() > fase.getOrdemFase())
				continue;
			
			
			for (PostoBalanceamentoDTO posto : faseaux.getPostos()) {
				if (( (int) posto.getOrdem() ) > retorno)
					retorno = (int) posto.getOrdem();
			}
			
		}
		
		
		return retorno;
	}
	/* Metodo para retorno de uma lista das operacaoes predecessoras imediatas da operacao
	 * 
	 */
	private List<DwOperacao> getPredecessorasImediatas(DwOperacao operacao) {
		List<DwOperacao> retorno = new ArrayList<>();
		
		for (DwOperacaopredecessora pre : operacao.getDwOperacaopredecessorasForIdOperacao()) {
			// A predecessora só será valida se estiver em um grupo diferente da operacao avaliada.
			// pois se tiver no mesmo grupo elas serão como uma só não sendo necessário ser predecessora
			// se for o caso a predecessora da operacao será a predecessora anterior
			if (
					operacao.getGrupooperacoes() == 0 || 
					pre.getDwOperacaoByIdOperacao().getGrupooperacoes() == 0 || 
					operacao.getGrupooperacoes().equals(pre.getDwOperacaoByIdOperacao().getGrupooperacoes()) == false)
				retorno.add(pre.getDwOperacaoByIdOperacaoanterior());
			else {
				retorno.addAll(getPredecessorasImediatas(pre.getDwOperacaoByIdOperacaoanterior()));
			}
		}
		
		return retorno;
	}
	
	/* Metodo de preparacao do FaseDTO
	 * O objetivo é criar uma lista por Fase, com as operacoes de OperacaoDTO e suas predecessoras
	 */
	private List<FaseDTO> getListaContendoTodasAsFases(List<DwOperacao> operacoes) {
		List<FaseDTO> fases = new ArrayList<>();
		
		for (DwOperacao operacao : operacoes) {
			boolean isExiste = false;
			for (FaseDTO fase : fases) {
				if (fase.getFase().getIdGt().equals(operacao.getOmGt().getIdGt())) {
					isExiste = true;
					OperacaoDTO operacaodto = new OperacaoDTO(operacao);
					operacaodto.setCdFase(fase.getFase().getCdGt());
					operacaodto.setPredecessoras(getPredecessorasImediatas(operacao));
					fase.addOperacaoDTO(operacaodto);
					
					break;
				}
			}
			if (isExiste == false) {
				FaseDTO fase = new FaseDTO();
				fase.setFase(operacao.getOmGt());
				fase.setPostos(new ArrayList<PostoBalanceamentoDTO>());
				
				OperacaoDTO operacaodto = new OperacaoDTO(operacao);
				operacaodto.setCdFase(fase.getFase().getCdGt());

				operacaodto.setPredecessoras(getPredecessorasImediatas(operacao));
				fase.addOperacaoDTO(operacaodto);
				fases.add(fase);
			}
		}
		return fases;
	}

}

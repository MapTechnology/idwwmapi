package idw.model.rn.geraplano.passos.tipoA;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlaneccron;
import idw.model.pojos.PpPlano;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PlanoProducaoRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.RoteiroRN;
import idw.model.rn.geraplano.dtos.IdentificacaoNecessidadeDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class TipoAPrimeiroPasso {

	private DAOGenerico dao;
	
	public TipoAPrimeiroPasso(DAOGenerico dao){
		this.dao = dao;
	}
	
	public PlanoDTO geraPrimeiroPasso(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr){
		
		List<String> folhaSemPrograma = new ArrayList<String>();
		
		PlanoDTO retorno = new PlanoDTO();
		
		Date dtReferenciaParaAntecipacao = null; // quaquer necessidade com data superior a essa data de referencia sera considerada como uma antecipacao
		
		log.info(idLog, identacao, "Ordenando as necessidades pela prioridade da menor para maior");
		// Ordernar as necessidades por ordem de prioridade
		List<PpPlanec> listaPpPlanec = new ArrayList<PpPlanec>(ppplano.getPpPlanecs());
		Collections.sort(listaPpPlanec, new Comparator<PpPlanec>() {
			@Override
			public int compare(PpPlanec p1, PpPlanec p2) {
				// Deve-se ordenar as necessidades das menos prioritarias as mais prioritarias
				// as menos prioritarias ficarão na frente pois serão produzidas em datas mais proximas a entrega
				return p1.getPrioridade() < p2.getPrioridade() ? -1 : (p1.getPrioridade() > p2.getPrioridade() ? +1 : 0);
			}
		});
		
		RoteiroRN rotRN = new RoteiroRN();
//		rotRN.setSession(dao.getSession());
		rotRN.setDaoSession(dao.getSession());
		ProdutoRN proRN = new ProdutoRN(dao);
		
		// Elimina toda a simulacao do plano feita anteriormente
		log.info(idLog, identacao, "Excluindo os dados da ultima simulação do plano se houver.");
		PlanoProducaoRN planoRN = new PlanoProducaoRN(dao);
		planoRN.excluirTodosOsPpPlaneccron(ppplano);
		planoRN.excluirTodosAsCps(ppplano);
		planoRN.limparTodasAsReservasNoEstoque();
		
		//Map<OmProduto, PrimeiraOcorrenciaDTO> primeiraOcorrenciaNoMes = new HashMap<OmProduto, PrimeiraOcorrenciaDTO>();
		// Interage sobre as necessidade de produção associadas ao plano
		log.info(idLog, identacao, "Varrendo todas as necessidade definidas para o plano da menor prioridade a maior prioridade");
		log.iniciaAvaliacao(idLog, "processaPlano.geraNecessidadeSemiproduto");
		List<PpPlaneccron> todosPlaneccronIncluidos = new ArrayList<PpPlaneccron>();
		Map<IdentificacaoNecessidadeDTO, BigDecimal> listaAcumprir = new HashMap<IdentificacaoNecessidadeDTO, BigDecimal>();
		
		// Encontra a menor data para ser atendida entre as necessidades selecionadas. Essa data sera usada para se saber quando uma ordem sera de antecipacao
		//
		for (PpPlanec pplanec : listaPpPlanec) {
			for (PpNeccron neccron : pplanec.getPpNec().getPpNeccrons()){
				if (dtReferenciaParaAntecipacao == null)
					dtReferenciaParaAntecipacao = neccron.getDtDesejada();
				
				if (DataHoraRN.before(neccron.getDtDesejada(), dtReferenciaParaAntecipacao))
					dtReferenciaParaAntecipacao = neccron.getDtDesejada();
			}
		}
		
		// Obtem o ultimo dia do mes da data de referencia (usada para saber se uma necessidade eh antecipacao ou nao
		dtReferenciaParaAntecipacao = DataHoraRN.getUltimoDiaDoMesDaData(dtReferenciaParaAntecipacao);
		dtReferenciaParaAntecipacao = DataHoraRN.setHoraNaData(dtReferenciaParaAntecipacao, 23, 59, 59, 999);
		
		for (PpPlanec ppplanec : listaPpPlanec) {
			log.info(idLog, identacao, "Processando pplanec com id " + ppplanec.getIdPlanec());
			
			// Obtendo a necessidade que será processada
			PpNec ppnec = ppplanec.getPpNec();
			log.info(idLog, identacao, "A necessidade " + ppnec.getIdNec() + "/" + ppnec.getCdNec() + " será processada.");
			if (ppnec.getCdNec().equals("101.24-0-1/2013-922425")){
				log.info("DEBUG");
			}
			// Obtendo o produto definido na necessidade
			OmProduto omproduto = ppnec.getOmProduto(); // encotnra o produto para descobrir as definicoes de lead-time
			log.info(idLog, identacao, "O produto " + omproduto.getIdProduto() + "/" + omproduto.getCdProduto() + " sera processado.");

			// Obtendo a rota do produto
			DwRota dwrota = rotRN.pesquisarDwRotaByIdProduto(omproduto, false); // encontra o roteiro para descobrir o que deve ser produzido e as definicoes da folha
			log.info(idLog, identacao, "O roteiro " + dwrota.getIdRota() + "/" + dwrota.getCdRota() + " será processado");
			
			// varre os passos do roteiro para os passos que nao sao predecessoras de nenhum outro passo
			List<DwRotapasso> ultimosPassos = rotRN.obterUltimosPassos(log, idLog, dwrota);
			
			if (ultimosPassos == null || ultimosPassos.size() <= 0){
				// Nao existe nenhum passo que nao tenha predecessora
				log.info(idLog, identacao, "Abortando geracao plano. Não existe ultimos passos. Favor rever o roteiro do produto " + omproduto.getCdProduto());
				retorno = new PlanoDTO();
				retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getROTEIRO_INCONSISTENTE());
				log.paraAvaliacao(dao);
				return retorno;
			}
			// Ordenas necessidades por ordem de data desejada
			log.info(idLog, identacao, "Ordenando cronologicamente o cronograma das entregas das necessidades");
			List<PpNeccron> listaNeccron = new ArrayList<PpNeccron>(ppnec.getPpNeccrons());
			Collections.sort(listaNeccron, new Comparator<PpNeccron>() {

				@Override
				public int compare(PpNeccron p1, PpNeccron p2) {
					return DataHoraRN.before(p1.getDtDesejada(), p2.getDtDesejada()) ? -1 : (DataHoraRN.after(p1.getDtDesejada(), p2.getDtDesejada()) ? +1 :
						p1.getPpNec().getIdNec().longValue() < p2.getPpNec().getIdNec().longValue() ? -1 : p1.getPpNec().getIdNec().longValue() > p2.getPpNec().getIdNec().longValue() ? +1 : 0 
						);
				}
			});
			for (PpNeccron ppneccron : listaNeccron){
				// Considerar 06h da manha como referencia para entrega ao cliente
				ppneccron.setDtDesejada(DataHoraRN.setHoraNaData(ppneccron.getDtDesejada(), 6, 0, 0, 0));
				
				log.info(idLog, identacao, "Processando cronograma da data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(ppneccron.getDtDesejada()) + " com quantidade " + ppneccron.getQtDesejada());
				// Nesse momento existem duas situações quanto a quantidade necessaria para produzir:
				// 1a: o produto solicitado NÃO será produzido diretamente, apenas sub-produtos que irão compor o mesmo
				// 2a: o produto solicitado SERÁ produzido diretamente
				// Como o cliente pana está na 1a situação, o algoritmo não irá prever a 2a situação, que futuramente
				// poderá ser implementada.
				
				// 1o PASSO: A partir do roteiro para o produto e de sua necessidade, gerar as necessidades de entrega dos sub-acabados
				for (DwRotapasso passo : ultimosPassos){
					log.info(idLog, identacao, "Analisando o passo-principal idRotaPasso = " + passo.getIdRotapasso());

					// Encontrar o produto da folha
					ConsolidaRN crn = new ConsolidaRN(dao);
					OmProduto omprodutoSemiAcabado = crn.obtemPrimeirProduto(passo.getDwFolha());
					
					if (omprodutoSemiAcabado.getCdProduto().equals("0")){
						if (folhaSemPrograma.contains(passo.getDwFolha().getCdFolha()) == false){
							retorno.setMensagem(retorno.getMensagem() + "A Folha " + passo.getDwFolha().getCdFolha() + " est� com o produto 0 na aba Programa IAC. Plano para " + omproduto.getCdProduto() + ".\n");
							folhaSemPrograma.add(passo.getDwFolha().getCdFolha());
						}
					}
					log.info(idLog, identacao, "Folha encontrada. idProduto = " + omprodutoSemiAcabado.getIdProduto());
					
					PpPlaneccron planeccron = new PpPlaneccron();
					planeccron.setIdPlaneccron(null);
					
					int leadTime = 0;
					if (ppnec.getHrLeadtime() != null){ // Se a necessidade tiver leadtime o mesmo terá prioridade em relacao ao leadtime do produto
						leadTime = ppnec.getHrLeadtime().intValue();
						log.info(idLog, identacao, "Usando o lead-time " + leadTime + " definido na necessidade ao inves do leadtime do produto");
					} else {
						if (omproduto.getHrLeadtimesaida() != null) {
							leadTime = omproduto.getHrLeadtimesaida().intValue();
							log.info(idLog, identacao, "Usando o lead-time " + leadTime + " definido no produto");
						} else {
							leadTime = 0;
							log.info(idLog, identacao, "O produto " + omproduto.getCdProduto() + " não tem lead-time saida definido. Considerando zero.");
						}
					}
					planeccron.setDthrNecessaria(
							DataHoraRN.subtraiHorasDaData(
									ppneccron.getDtDesejada(), 
									leadTime) ); // A data em que o produto deve estar disponivel é a data desejada do pedido - o leadtime do produto desejado pelo cliente (no momento nao sera considerado o calendario)
					log.info(idLog, identacao, "Data encontrada foi " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(planeccron.getDthrNecessaria()));
					// Tirar o milisegundo da data, pois no sql salva essa informacao e impacta na hora de pegar os intervalos de datas
					planeccron.setDthrNecessaria(DataHoraRN.setMiliNaData(planeccron.getDthrNecessaria(), 0));
					
					
					planeccron.setOmProduto(omprodutoSemiAcabado); // Semi-produto que deve ser fabricado
					planeccron.setPpNeccron(ppneccron);
					planeccron.setPpPlano(ppplano);
					planeccron.setOrdem(ppplanec.getPrioridade());
					
					planeccron.setIsAntecipacao(DataHoraRN.after(ppneccron.getDtDesejada(), dtReferenciaParaAntecipacao));
					
					OmProcomest est = null;
					
					try {
						est = proRN.obtemEstruturaProduto(log, idLog, 30, omproduto, planeccron.getOmProduto());
						if (est != null)
							log.info(idLog, identacao, "Estrutura do produto idprocomest = " + est.getIdProcomest() + " encontrou quantidade = " + est.getQtUsada());
						else {
							retorno = new PlanoDTO();
							retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getPRODUTO_NAO_ACEITO());
							log.paraAvaliacao(dao);
							return retorno;
						}
					} catch (NullPointerException e){
						retorno = new PlanoDTO();
						retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getPRODUTO_NAO_ACEITO());
						log.paraAvaliacao(dao);
						return retorno;
					}

					double qtNecessaria = ppneccron.getQtDesejada().doubleValue() * est.getQtUsada().doubleValue();

					
					planeccron.setQtNecessaria( new BigDecimal(qtNecessaria) ); // A quantidade � a quantidade desejada pelo cliente * a quantidade do semi-produto na estrtuura do MODELO
					planeccron.setQtEstoque(BigDecimal.ZERO);
					
					if (planeccron.getOmProduto().getCdProduto().equals("922425"))
						log.info(idLog, identacao, "Quantidade neccessaria " + planeccron.getQtNecessaria() + " para data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(planeccron.getDthrNecessaria()) + " para produto " + planeccron.getOmProduto().getCdProduto() + " da necessidade " + planeccron.getPpNeccron().getPpNec().getCdNec());

					dao.makePersistent(planeccron);
					
					todosPlaneccronIncluidos.add(planeccron);
					
					// atualiza vetor com o total ate o momento do produto para a necessidade
					IdentificacaoNecessidadeDTO id = new IdentificacaoNecessidadeDTO();
					id.setIdProduto(planeccron.getOmProduto().getIdProduto());
					id.setIdNec(planeccron.getPpNeccron().getPpNec().getIdNec());
					
					if (listaAcumprir.containsKey(id) == false){
						log.info(idLog, identacao, "Acrescentando " + planeccron.getQtNecessaria() +  " para chave de idProduto = " + id.getIdProduto() + " e neccron = " + id.getIdNec());
						listaAcumprir.put(id, planeccron.getQtNecessaria());
					} else {
						double valor = listaAcumprir.get(id).doubleValue();
						log.info(idLog, identacao, "Atualizando valor " + valor + " somando " + qtNecessaria + " para chave de idProduto = " + id.getIdProduto() + " e neccron = " + id.getIdNec() + " para o valor " + (valor + planeccron.getQtNecessaria().doubleValue()));
						valor += planeccron.getQtNecessaria().doubleValue();
						listaAcumprir.put(id, new BigDecimal(valor));
					}
				}
			}
		}
		log.paraAvaliacao(dao);

		// Passo intermediario: Atualizar a coluna qt_acumprir em ppplaneccron. Essa coluna terá a quantidade a cumprir a partir da data avaliada, por exemplo
		/*
		 * Necessidades do Produto X
		 * 				Dia 1		Dia 2		Dia 3		Dia4
		 * qtnec		100			200			300			400
		 * acumprir		900			700			400			0
		 */
		// Ordena a lista com os ppneccron pela ordem de neccessidade e produto
		Collections.sort(todosPlaneccronIncluidos, new Comparator<PpPlaneccron>() {

			@Override
			public int compare(PpPlaneccron o1, PpPlaneccron o2) {
				int ordem =
					/* ordena pelo id da necessidade */
					(o1.getPpNeccron().getPpNec().getIdNec() < o2.getPpNeccron().getPpNec().getIdNec() ?  -1 : 
						(o1.getPpNeccron().getPpNec().getIdNec() > o2.getPpNeccron().getPpNec().getIdNec() ? +1 : 
						
							/* ordena o id do produto */
							(o1.getOmProduto().getIdProduto() < o2.getOmProduto().getIdProduto() ? -1 : (o1.getOmProduto().getIdProduto() > o2.getOmProduto().getIdProduto() ? +1 : 
								
							/* ordena pela data */
							(DataHoraRN.before(o1.getDthrNecessaria(), o2.getDthrNecessaria()) ? -1 : (DataHoraRN.after(o1.getDthrNecessaria(), o2.getDthrNecessaria()) ? +1 : 0) ) ) )
							
						 ) ); 
				return ordem;
			}
		});
		
		
		// interage sobre cada produto para atualizar o campo qtAcumprir de ppplaneccron, conforme explicacao acima
		for (PpPlaneccron p : todosPlaneccronIncluidos){
			log.info(idLog, identacao, "Avaliando nec " + p.getPpNeccron().getPpNec().getIdNec() + " e o produto " + p.getOmProduto().getIdProduto() + " na data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(p.getDthrNecessaria()));
			IdentificacaoNecessidadeDTO id = new IdentificacaoNecessidadeDTO();
			id.setIdProduto(p.getOmProduto().getIdProduto());
			id.setIdNec(p.getPpNeccron().getPpNec().getIdNec());
			
			double total = listaAcumprir.get(id).doubleValue();
			
			total -= p.getQtNecessaria().doubleValue();
			
			p.setQtAcumprir(new BigDecimal(total));
			
			dao.makePersistent(p);
			
			listaAcumprir.put(id, new BigDecimal(total));
		}

		String mensagem = retorno.getMensagem();
		
		retorno = new PlanoDTO(ppplano, dao);
		retorno.getResultadoDTO().setIdmensagem(retorno.getResultadoDTO().getCOM_SUCESSO());
		retorno.setMensagem(mensagem);
		retorno.setDtReferenciaAntecipacao(dtReferenciaParaAntecipacao);

		return retorno;
	}
}

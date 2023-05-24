package idw.model.rn.geraplano.passos.tipoB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpPlaneccron;
import idw.model.pojos.PpPlano;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.InsercaoCPDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;

public class TipoBGeraNecessidade implements IDao{
	protected DAOGenerico dao;
	
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

	
	public TipoBGeraNecessidade(DAOGenerico dao){
		this.dao = dao;
	}
	
	private SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais = new TreeMap<ProdutoComparable, List<PassosDTO>>();

	/* Metodo principal para geracao de todas as cps
	 * 
	 */
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsParaNecessidade(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, PlanoDTO planoErrorResult){
		
		// 1o PASSO: Define a quantidade de dias em que sera feito o planejamento conjunto
		int diasPlanejamento = 3;
		
		// 2o PASSO: Determina a interacoes que deverao ser feitas para o planejamento = qtd de datas <> / qtde de dias
		int blocosDeDatas = 0;
		MapQuery q = new MapQuery(dao.getSession());
		
		// o hql abaixo deve considerar apenas a data do campo dthrNecessaria
		// isso eh importante para o vetor listaDatas ter apenas uma data de cada sem repeticao
		q.append("select crono.dthrNecessaria, count(*) from PpPlaneccron crono where crono.ppPlano = :plano group by crono.dthrNecessaria order by crono.dthrNecessaria");
		q.defineParametro("plano", ppplano);
		List<Object[]> lDatas = null;
		lDatas = q.list();
		List<Date> listaDatas = new ArrayList<Date>();
		
		// Gera logs com as datas coletadas e consolida sem repeticao de datas
		for (Object[] linha : lDatas){
			log.info(idLog, identacao, "Data necessaria " + linha[0] + " - quantidade " + linha[1]);
			Date dtSemHora = DataHoraRN.getDataSemHora((Date) linha[0]);
			if (listaDatas.contains(dtSemHora) == false){
				listaDatas.add(dtSemHora);
			}
		}
		
		// Mostra os logs pra confirmar se esta tudo certo
		for (Date dts : listaDatas){
			log.info(idLog, identacao, "Data " + dts);
		}
		
		blocosDeDatas = listaDatas.size();
		blocosDeDatas /= diasPlanejamento;
		blocosDeDatas++;
		// 3o PASSO: Interage sobre os blocos de dias
		for (int blocoAvaliado = 1; blocoAvaliado <= blocosDeDatas ; blocoAvaliado++){
			//3.1 PASSO: Obtem a lista das necessidades do blocoAvaliado
			// calcula o intervalo de datas
			int inicioBloco;
			int fimBloco;
			
			inicioBloco = (blocoAvaliado - 1) * diasPlanejamento;
			fimBloco = inicioBloco + (diasPlanejamento - 1);
			
			// Se o ultimo indice for maior que os disponiveis, entao usar o ultimo
			if (fimBloco > (listaDatas.size()-1)){
				fimBloco = listaDatas.size() - 1;
				log.info(idLog, identacao, "Ajustando fimBloco para tamanho da listaDatas - 1= " + fimBloco);
			}
			
			if (inicioBloco > (listaDatas.size()-1)){
				log.info(idLog, identacao, "O inicio do bloco ultrapassou a listaDatas, então saindo do processamento de blocos");
				continue;
			}
			
			Date dtInicial = listaDatas.get(inicioBloco);
			Date dtFinal = listaDatas.get(fimBloco);

			// Seta as horas das duas datas, com o objetivo de pegar todas as ocorrencias do dia
			dtInicial = DataHoraRN.setHoraNaData(dtInicial, 0, 0, 0, 0);
			dtFinal = DataHoraRN.setHoraNaData(dtFinal, 23, 59, 59, 999);
			log.info(idLog, identacao, "Inicio Avaliacao Bloco: " + blocoAvaliado + " inicioBloco=" + inicioBloco + " fimBloco=" + fimBloco + " são as datas " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtInicial) + " até " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtFinal));

			// pesquisa ppPlaneccron usando o intervalo de datas
			q.novaConsulta();
			q.append("select distinct crono");
			q.append("from PpPlaneccron crono ");
			q.append("join fetch crono.ppNeccron ppneccron");
			q.append("join fetch ppneccron.ppNec ppnec");
			q.append("where crono.ppPlano = :plano and crono.dthrNecessaria between :dt1 and :dt2");
			// Os ppplaneccron devem ser ordenados pela prioridade do pedido no plano de producao (pp_planec) que é representado pelo campo pplaneccron.ordem
			// e alfabeticamente pelo codigo do produto.
			q.append("order by crono.dthrNecessaria, crono.ordem, crono.omProduto");

			q.defineParametro("plano", ppplano);
			q.defineParametroData("dt1", dtInicial);
			q.defineParametroTimestamp("dt2", dtFinal); // Esse timestamp tem que ter pq iremos considerar ate as 24h do dia
			
			List<PpPlaneccron> lista = q.list();
			
						
			//3.2 PASSO: Varre a lista de necessidade
			for (PpPlaneccron cron : lista){
				
				log.info(idLog, identacao, "Processando pplaneccron.id = " + cron.getIdPlaneccron() + " com prod.plan. = " + cron.getQtNecessaria());
				
				log.info(idLog, identacao, 
						"Bloco: " + blocoAvaliado + 
						" para a data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(cron.getDthrNecessaria()) + 
						" para o produto " + cron.getOmProduto().getCdProduto() +
						" na quantidade " + cron.getQtNecessaria() +
						" necessidade " + cron.getPpNeccron().getPpNec().getCdNec());
				

				OmProduto omproduto = cron.getOmProduto();
				if(cron.getOmProduto().getCdProduto().equals("TP7NA5596CE-ILH")==true){
					log.info("DEBUG");
				}

				//3.2.1: Encontra a folha a ser usada
				q.novaConsulta();
				// o order by abaixo foi acrescentado para se identificar a ultima rota para o produto, vi que foi cadastrado mais de uma rota par determinado produto
				q.append("from DwRota dwrota where dwrota.stAtivo = 1 and dwrota.omProduto = :produto order by dwrota.idRota desc");
				q.defineParametro("produto", cron.getPpNeccron().getPpNec().getOmProduto());
				q.setMaxResults(1);
				DwRota dwrota = null;
				dwrota = (DwRota) q.uniqueResult();
				log.info(idLog, identacao + 10, "Encontrou a rota " + dwrota.getIdRota() + "/" + dwrota.getCdRota());
				
				// Dentro dos passos da rota, procurar a folha do produto a ser fabricado
				DwFolha dwfolha = null;
				DwRotapasso dwrotapasso = null;
				for (DwRotapasso passo : dwrota.getDwRotapassos()){
					ConsolidaRN crn = new ConsolidaRN(dao);
					OmProduto omprodutoSemiacabado = crn.obtemPrimeirProduto(passo.getDwFolha());

					if (cron.getOmProduto() == null){
						log.info(idLog, identacao + 10, "Produto de cron " + cron.getIdPlaneccron() + " está nulo");
					}
					if (omprodutoSemiacabado.getIdProduto() == cron.getOmProduto().getIdProduto()){
						dwfolha = passo.getDwFolha();
						dwrotapasso = passo;
						break;
					}
				}
				log.info(idLog, identacao + 10, "Encontrou a folha " + dwfolha.getIdFolha() +  "/" + dwfolha.getCdFolha() + " e o dwrotapasso " + dwrotapasso.getIdRotapasso() + " para a rota acima.");
				// Nesse momento devemos ter a dwfolha

				// Gera a CP para a necessidade em questao
//				log.info(idLog, identacao, "Vou chamar gerarCps para pplaneccron.id = " + cron.getIdPlaneccron() + " com prod.plan. = " + cron.getQtNecessaria());
				log.iniciaAvaliacao(idLog, "geraCps para o produto" + omproduto.getCdProduto());
				geraCps(log, idLog, identacao + 10, cron, ppplano, omusr, omproduto, dwrota, dwrotapasso, dwfolha, cron.getQtNecessaria(), cron.getDthrNecessaria(), null, false, null, planoErrorResult);
				log.paraAvaliacao(dao);
				if (planoErrorResult.getResultadoDTO().getIdmensagem() == planoErrorResult.getResultadoDTO().getERROR_CICLO_PADRAO()) {
	                return null;
				}
				// Finaliza gerand log
				log.info(idLog, identacao + 10, "FIM - Bloco : " + blocoAvaliado + " para a data " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(cron.getDthrNecessaria()) + " para o produto " + cron.getOmProduto().getCdProduto());
			}
			log.info(idLog, identacao, "FIM Bloco: " + blocoAvaliado + " inicioBloco=" + inicioBloco + " fimBloco=" + fimBloco + " são as datas " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtInicial) + " até " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtFinal));
		}
		
		return cpsVirtuais;
	}
	
	private void geraCps(
			IdwLogger log, 
			int idLog, 
			int identacao, 
			PpPlaneccron cron, 
			PpPlano ppplano, 
			OmUsr omusr, 
			OmProduto omproduto, 
			DwRota dwrota, 
			DwRotapasso dwrotapasso, 
			DwFolha dwfolha, 
			BigDecimal producaoPlanejada, // Se espera que a producao planejada seja com o lote minimo (8hrs)
			Date dtReferencia,
			PpCp ppcpPai,
			boolean isPredecessora, 
			InsercaoCPDTO paisAjustados,
			PlanoDTO planoErrorResult){

		ProdutoComparable pc = new ProdutoComparable();
		pc.setOmproduto(omproduto);
		// Encontra o tempo necessario para produzir o passo e suas predecessoras
		List<PassosDTO> passos = new ArrayList<PassosDTO>();
		PassosDTO ultimoPasso = new PassosDTO(ppplano);
		ultimoPasso.setOmproduto(pc);
		ultimoPasso.setProducaoPlanejada(producaoPlanejada.doubleValue());
		ultimoPasso.setDwfolha(dwfolha);
		ultimoPasso.setDwrota(dwrota);
		ultimoPasso.setDwrotapasso(dwrotapasso);
		ultimoPasso.getListaPpplaneccron().add(cron);
		ultimoPasso.setDwcal(null);	
		//MENSAGEM DE ALERTA: FOLHAS QUE NÃO POSSUEM CICLO PADRÃO
		try{
			@SuppressWarnings("unused")
			BigDecimal ciclo= ultimoPasso.getCicloPadrao();					
		}catch (Exception e) {
			planoErrorResult.setMensagem(ultimoPasso.getDwfolha().getCdFolha());
			planoErrorResult.getResultadoDTO().setIdmensagem(planoErrorResult.getResultadoDTO().getERROR_CICLO_PADRAO());
			return ;
		}
		ultimoPasso.calculaDatasInicioFim(log, idLog, identacao, dtReferencia);
		
		if (omproduto.getCdProduto().equals("S9LB-IAC"))
			log.info(idLog, identacao, "Identifica pq nao encontra corretamente os cts limitados para o idrotapasso " + dwrotapasso.getIdRotapasso());
		
		ultimoPasso.defineCtsDisponiveis(dwrotapasso, log, idLog, identacao, dao);
		passos.add(ultimoPasso);
		log.info(idLog, identacao, "Procurando predecessoras para o produto " + omproduto.getCdProduto());
		setPassosPredecessores(log, idLog, identacao + 10, ppplano, ultimoPasso, dwrota, dwrotapasso, producaoPlanejada, ultimoPasso.getInicio(), cron);
		
		// Insere as CPS virtuais
		for (PassosDTO p : passos){
			// Insere a CP virtual
			List<PassosDTO> passosProduto = null;
			PpCp ppcp = new PpCp();
			ppcp.setDthrFinal(p.getFim());
			ppcp.setDthrInicio(p.getInicio());
			p.setPpcpAposInclusao(ppcp);
			if (cpsVirtuais.containsKey(p.getOmproduto()) == true){
				passosProduto = cpsVirtuais.get(p.getOmproduto());
			} else {
				passosProduto = new ArrayList<PassosDTO>();
			}
			passosProduto.add(p);
			
			cpsVirtuais.put(p.getOmproduto(), passosProduto);
		}
	}

	/*
	 * Esse metodo ira setar os passos predecessores para o passo principal
	 */
	private void setPassosPredecessores(IdwLogger log, int idLog, int identacao, PpPlano ppplano, PassosDTO passoPai, DwRota dwrota, DwRotapasso dwrotapasso, BigDecimal producaoPlanejada, Date dtReferencia, PpPlaneccron ppplaneccron){
		for (DwRpPredecessora pre : dwrotapasso.getDwRpPredecessorasForIdRotapassoPai()){
			DwRotapasso dwrotapassoPredecessora = pre.getDwRotapassoByIdRotapassoFilho();
			
			// Encontra a folha do passo da predecessora
			DwFolha dwfolhaPredecessora = null;
			dwfolhaPredecessora = dwrotapassoPredecessora.getDwFolha();
			
			// Encontra o produto
			ConsolidaRN crn = new ConsolidaRN(dao);
			OmProduto omprodutoPredecessora = null;
			omprodutoPredecessora = crn.obtemPrimeirProduto(dwfolhaPredecessora);
			ProdutoComparable pc = new ProdutoComparable();
			pc.setOmproduto(omprodutoPredecessora);

			log.info(idLog, identacao, "A predecessora é o produto " + omprodutoPredecessora.getCdProduto());

			PassosDTO passoPre = new PassosDTO(ppplano);
			passoPre.setOmproduto(pc);
			passoPre.setProducaoPlanejada(producaoPlanejada.doubleValue());
			passoPre.setDwfolha(dwfolhaPredecessora);
			passoPre.setDwrota(dwrota);
			passoPre.setDwrotapasso(dwrotapassoPredecessora);
			passoPre.setDwcal(null);
			passoPre.getListaPpplaneccron().add(ppplaneccron);
			passoPre.setEspelho(pre.getIsEspelho() == null ? false : pre.getIsEspelho());
			passoPre.calculaDatasInicioFim(log, idLog, identacao, dtReferencia);
			passoPre.defineCtsDisponiveis(dwrotapassoPredecessora, log, idLog, identacao, dao);

			passoPai.getPassosPredecessoras().add(passoPre);
			
			// Recursivamente pega as mesmas informacoes para as predecessoras
			log.info(idLog, identacao, "Procurando predecessoras para o produto " + omprodutoPredecessora.getCdProduto());
			setPassosPredecessores(log, idLog, identacao + 10, ppplano, passoPre, dwrota, dwrotapassoPredecessora, producaoPlanejada, passoPre.getInicio(), ppplaneccron);
		}
	}

}

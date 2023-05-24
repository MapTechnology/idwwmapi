package idw.model.rn.geraplano.passos.tipoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.MonitorizacaoPPRN;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoAcompanhamentoDTO;
import idw.webservices.dto.PlanoAcompanhamentoDTOList;
import idw.webservices.dto.PlanoDTO;

public class TipoAAbateEstoques {
	// saldoProdutos deixa de guardar apenas o Integer (com saldo estoque) para passar a conter PlanoAcompanhamento que vem de MonitorizacaoPPRN
	// assim poderemos dispor do Falta/Sobra tambem
	private Map<OmProduto, PlanoAcompanhamentoDTO> saldoProdutos = null;
	private DAOGenerico dao;

	public TipoAAbateEstoques(DAOGenerico dao){
		this.dao = dao;
	}
	
	/*
	 * Esse metodo tem como objetivo remover as necessidade que ja tiverem em estoque
	 */
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsAbatendoEstoque(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable p : cpsVirtuais.keySet()){
			List<PassosDTO> listaOrdenada = cpsVirtuais.get(p);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			// Ordena pela data inicio pq o estoque deve abater as primeiras ordens
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0));
				}
			});
			
			for (PassosDTO pa : listaOrdenada){
				PlanoAcompanhamentoDTO saldoEstoqueDTO = null;
				
				// Verifica se existe estoque para o produto
				if (saldoProdutos.containsKey(pa.getOmproduto().getOmproduto()) == true){
					saldoEstoqueDTO = saldoProdutos.get(pa.getOmproduto().getOmproduto());
					Integer saldoEstoque = saldoEstoqueDTO.getSaldoRealEstoque(); //getKitTotal().intValue();
					// Se tiver saldo e o mesmo cobrir a producao planejada, entao atualizar o saldo e eliminar o passo
					if (saldoEstoque > 0 && pa.getProducaoPlanejada() <= saldoEstoque){
						log.info(idLog, identacao, "Saldo para o produto " + pa.getOmproduto() + " � " + saldoEstoque);
						// Ja que tem estoque disponivel, entao o passo � descartado e o estoque atualizado
						saldoEstoque -= (int) pa.getProducaoPlanejada();

						if (p.getOmproduto().getCdProduto().equals("REA4783F-IAC")){
							log.info(idLog, identacao, "Saldo para o produto " + pa.getOmproduto() + " foi para " + saldoEstoque + " apos atender o passo " + pa);
							log.info(idLog, identacao, "Descartando o passo " + pa);
						}
						
						// O pa é descartado marcando como excluido, evitando assim que ele va para a lista de consolidadas
						pa.setExcluida(true);
						
						saldoEstoqueDTO.setSaldoRealEstoque(saldoEstoque);
						// atualiza saldo do produto
						saldoProdutos.put(pa.getOmproduto().getOmproduto(), saldoEstoqueDTO);
					} else {
						// Nesse ponto, sabemos que o estoque nao atende totalmente a producaoplanejada
						// entao verificar se o estque pode atender parcialmente a producaoplanjeada
						if (saldoEstoque > 0){
							double producaoPlanejadaAntesDaMudanca = pa.getProducaoPlanejada();
							
							if (p.getOmproduto().getCdProduto().equals("REA4783F-IAC")){
								log.info(idLog, identacao, "Saldo para o produto " + pa.getOmproduto() + " foi para zero devido o passo " + pa);
							}
							
							pa.setProducaoPlanejada(pa.getProducaoPlanejada() - saldoEstoque);
							pa.calculaDatasInicioFim(log, idLog, identacao, pa.getFim());
							
							saldoEstoqueDTO.setSaldoRealEstoque(0);
							saldoProdutos.put(pa.getOmproduto().getOmproduto(), saldoEstoqueDTO);
							if (p.getOmproduto().getCdProduto().equals("REA4783F-IAC")){
								log.info(idLog, identacao, "Producao planejada para o produto " + pa.getOmproduto() + " foi para " + pa.getProducaoPlanejada() + " antes era " + producaoPlanejadaAntesDaMudanca);
							}
						} else {
							if (p.getOmproduto().getCdProduto().equals("REA4783F-IAC")){
								log.info(idLog, identacao, "Saldo para o produto " + pa.getOmproduto() + " esta zerado entao o passo nao foi alterado " + pa);
							}
						}
					}
					
				} else {
					if (p.getOmproduto().getCdProduto().equals("REA4783F-IAC")){
						log.info(idLog, identacao, "Saldo DESCONHECIDO  para produto " + pa.getOmproduto());
					}
				}
				
				// Independente se o passo foi excluido ou teve sua producao planejada reduzida, suas predecessoras devem tambem reduzir o estoque
				// total ou parcialmente
				// Pode ser que haja estoque para o produto predecessor
				// Nesse caso a ordem do predecessor pode sumir ou ser menor
				avaliarEstoqueParaAsPredecessoras(log, idLog, identacao, pa);

				
				// se o passo nao foi excluido entao avaliar suas predecessoras
				if (pa.isExcluida() == false){
					
					log.info(idLog, identacao, "Considerando para o proximo passo o passo " + pa);
					listaConsolidada.add(pa);
				}
				
				// Debugando produto especifico
				if (pa.getOmproduto().getOmproduto().getCdProduto().equals("1RH1TG1381LB-IA") && pa.getPassosPredecessoras().size() == 0)
					log.info(idLog, identacao, "Debugando o produto " + pa.getOmproduto().getOmproduto().getCdProduto());
				

			}

			// Atualizar a lista de cps que serao retornadas pelo metodo
			cpsConsolidadas.put(p, listaConsolidada);
		}
		log.info(idLog, identacao, "Fim geraCpsAbatendoEstoque");
		
		return cpsConsolidadas;
	}

	/*
	 * Esse metodo tem como objetivo servir de auxilio a rotina de abatimento do estoque das predecessoras
	 * Apos a mudanca no algoritmo de inicializacao do saldo do estoque que passou a utilizar a MOnitorizacaoPPRN
	 * o metodo abaixo nao ira utilizar o saldo de estoque dos produtos predecessores.
	 * Ser� considerada a quantidade Falta/sobra se a mesma for negativa. Entretanto, iremos somar a esse
	 * valor a diferenca entre da Falta/sobra do item do ultimo passo - a QtdePlanejada (que eh a qt da OP)
	 * Teoricamente poderia se assumir logo o Falta/Sobra da precessora, mas acontece do ultimo passo adiantar
	 * producao, nesse caso as predecessoras devem adiantar tambem.
	 */
	private void avaliarEstoqueParaAsPredecessoras(IdwLogger log, int idLog, int identacao, PassosDTO passo){
		for (PassosDTO pre : passo.getPassosPredecessoras()){

			// A 1a coisa a ser feita � ajustar a producao planejada da predecessora com a producao do pai
			// Huumm, tiver problemas em setar essa producao, que foi a producao do pai ser ajustada para
			// menor e setando aqui, o estoque da predecessora nao vai ser abatido com o valor da predecessora
			// mas sim do pai, ou seja, vai sobrar estoque e nao sera gerada a cp
			//pre.setProducaoPlanejada(passo.getProducaoPlanejada());
			
			/* Alessandre: Removi o if abaixo a forma de calcular nao pode considerar o faltaSobra, pois
			 * o faltaSobre contem informacoes totalizadas para o produto e no momento
			 * se esta avaliando apenas um passo do produto
			 * Possivelmente, terei que corrigir considerando o estoque do produto - 
			 * o estoque do passo pai
			 * 
			 */
			// Se existir saldo para o produto predecessor
			if (saldoProdutos.containsKey(pre.getOmproduto().getOmproduto()) == true){
				PlanoAcompanhamentoDTO saldoProdutosDTO = saldoProdutos.get(pre.getOmproduto().getOmproduto());
				Integer saldoDisponivel = saldoProdutosDTO.getSaldoRealEstoque();  // getKitTotal().intValue();
				pre.getOmproduto().getOmproduto().getCdProduto();
				// Calcula novo saldo
				if (saldoDisponivel > 0 && pre.getProducaoPlanejada() <= saldoDisponivel){
					saldoDisponivel -= (int) pre.getProducaoPlanejada();
					pre.setExcluida(true);
					
					saldoProdutosDTO.setSaldoRealEstoque(saldoDisponivel);
					saldoProdutos.put(pre.getOmproduto().getOmproduto(), saldoProdutosDTO);
					
					if (pre.getOmproduto().getOmproduto().getCdProduto().equals("REN4783F-RAD"))
						log.info(idLog, identacao, "Saldo do produto REN4783F-RAD foi para " + saldoDisponivel + " apos abater o passo " + pre);


				} else {
					// Nesse ponto, sabemos que o estoque nao atende totalmente a producaoplanejada
					// entao verificar se o estque pode atender parcialmente a producaoplanjeada
					if (saldoDisponivel > 0){
						pre.setProducaoPlanejada(pre.getProducaoPlanejada() - saldoDisponivel);
						//pa.calculaDatasInicioFim(log, idLog, identacao, pa.getFim());
						
						saldoProdutosDTO.setSaldoRealEstoque(0);
						saldoProdutos.put(pre.getOmproduto().getOmproduto(), saldoProdutosDTO);
						if (pre.getOmproduto().getOmproduto().getCdProduto().equals("REN4783F-RAD"))
							log.info(idLog, identacao, "Saldo do produto REN4783F-RAD foi para zero apos abater o passo " + pre );
					}
				}
			}

			// deve-se sempre abater o estoque das predecessoras, por isso o if foi comentado
			//if (pre.isExcluida() == false ){
				// Se n�o existir saldo e apos abater o estoque, avaliar as predecessoras do passo predecessor
				avaliarEstoqueParaAsPredecessoras(log, idLog, identacao, pre);
			//}
		}
		
		// Verifica se as predecessoras foram excluidas. Se sim, entao setar new para  set do passo
		boolean isExistePredecessora = false;
		for (PassosDTO passopredec : passo.getPassosPredecessoras()){
			if (passopredec.isExcluida() == false)
				isExistePredecessora = true;
		}
		if (isExistePredecessora == false)
			passo.setPassosPredecessoras(new ArrayList<PassosDTO>());

	}


	

	/*
	 * Esse metodo foi criado com o objetivo de inicializar o SaldoProduto usado para o processamento do planejamento a partir dos dados apresentados na
	 * monitorizacaoPPRN
	 */
	public void inicializaSaldoProdutosConformeRegraDaMonitorizacaoPPRN(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> alocacaoProduto, int anoreferencia, int mesreferencia){
		MonitorizacaoPPRN mRN = new MonitorizacaoPPRN(dao);
		PlanoAcompanhamentoDTOList retorno;
		PlanoAcompanhamentoDTO planoAcomp = new PlanoAcompanhamentoDTO();
		PlanoDTO planodto = new PlanoDTO();
		planodto.setIdPlano(ppplano.getIdPlano());

		planoAcomp.setAnoReferencia(anoreferencia);
		planoAcomp.setMesReferencia(mesreferencia);
		planoAcomp.setPlanoDTO(planodto);
		planoAcomp.setDiaReferencia(1);

		retorno = mRN.capturarAcompanhamentos(planoAcomp);

		// Atualiza saldoProduto com os valores obtidos
		this.saldoProdutos = new HashMap<OmProduto, PlanoAcompanhamentoDTO>();
		
		for (PlanoAcompanhamentoDTO pacomp : retorno.getAcompanhamentos()){
			if (saldoProdutos.containsKey(pacomp.obtemOmproduto()) == false){
				this.saldoProdutos.put(pacomp.obtemOmproduto(), pacomp);
			}
		}
	}
}

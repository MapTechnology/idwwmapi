package idw.model.rn.geraplano.passos.tipoB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;

public class TipoBAbateEstoques {
	// saldoProdutos deixa de guardar apenas o Integer (com saldo estoque) para passar a conter PlanoAcompanhamento que vem de MonitorizacaoPPRN
	// assim poderemos dispor do Falta/Sobra tambem
	// voltou a ser integer (double) pois nao vinha nada qdo o plano nunca havia sido processado
	// avaliar a questao da sobra
	private Map<OmProduto, Double> saldoProdutos = null;
	private DAOGenerico dao;

	public TipoBAbateEstoques(DAOGenerico dao){
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
			
			// Ordena pela data fim cronologicamente por ordem crescente, nao usei o inicio pois dependendo da quantidade um inicio anterior pode atender
			// uma data fim maior
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getFim(), o2.getFim()) ? -1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? +1 : 0));
				}
			});
			
			for (PassosDTO pa : listaOrdenada){
				// Verifica se existe estoque para o produto
				try {
				if (saldoProdutos.containsKey(pa.getOmproduto().getOmproduto()) == true){
					Double saldoEstoque = saldoProdutos.get(pa.getOmproduto().getOmproduto());
					
					log.info("Saldo de estoque para produto " + pa.getOmproduto().getOmproduto().getCdProduto() + " = " + saldoEstoque);
					
					// Se tiver saldo e o mesmo cobrir a producao planejada, entao atualizar o saldo e eliminar o passo
					if (saldoEstoque > 0 && pa.getProducaoPlanejada() <= saldoEstoque){
						// Ja que tem estoque disponivel, entao o passo � descartado e o estoque atualizado
						saldoEstoque -= (int) pa.getProducaoPlanejada();
						// O pa � descartado marcando como excluido, evitando assim que ele va para a lista de consolidadas
						pa.setExcluida(true);
						saldoProdutos.put(pa.getOmproduto().getOmproduto(), saldoEstoque);
					} else {
						// Nesse ponto, sabemos que o estoque nao atende totalmente a producaoplanejada
						// entao verificar se o estque pode atender parcialmente a producaoplanjeada
						if (saldoEstoque > 0){
							pa.setProducaoPlanejada(pa.getProducaoPlanejada() - saldoEstoque);
							pa.calculaDatasInicioFim(log, idLog, identacao, pa.getFim());
							saldoProdutos.put(pa.getOmproduto().getOmproduto(), 0d);
						}
					}
				}
				} catch (NullPointerException e){
					e.printStackTrace();
				}
				
				// se o passo nao foi excluido entao avaliar suas predecessoras
				if (pa.isExcluida() == false){
					// Independente se o passo foi excluido ou teve sua producao planejada reduzida, suas predecessoras devem tambem reduzir o estoque
					// total ou parcialmente
					// Pode ser que haja estoque para o produto predecessor
					// Nesse caso a ordem do predecessor pode sumir ou ser menor
					// CORRIGINDO: Nao faz sentido avaliar as predecessoras de um passo principal
					// se o mesmo for eliminado, pois ele sendo eliminado suas predecessoras devem tb ser
					// por isso essa avaliacao voltou para o if
					avaliarEstoqueParaAsPredecessoras(log, idLog, identacao, pa);
					listaConsolidada.add(pa);
				}
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
			// Huumm, tive problemas em setar essa producao, que foi a producao do pai ser ajustada para
			// menor e setando aqui, o estoque da predecessora nao vai ser abatido com o valor da predecessora
			// mas sim do pai, ou seja, vai sobrar estoque e nao sera gerada a cp.
			// Alessandre: Em 3-2-13 reavaliei a questao de setar a producao da predecessora. Agora acredito ser necessario
			// pois o pai pode ter tido reducao na quantidade planejada. Entretanto, acredito que a producao da predecessora deva considerar a qt usada
			// para fazer o pai, ou seja se passo.getProducaoPlanejada = 1000 e sendo necessrias 2 predecessora, entao
			// a quantidade da predecessora a ser setada deve ser 1000 * 2, mas acho que nao tenho essa utilizacao, entao por enquando as producao ficam iguais
			pre.setProducaoPlanejada(passo.getProducaoPlanejada());
			
			/* Alessandre: Removi o if abaixo a forma de calcular nao pode considerar o faltaSobra, pois
			 * o faltaSobre contem informacoes totalizadas para o produto e no momento
			 * se esta avaliando apenas um passo do produto
			 * Possivelmente, terei que corrigir considerando o estoque do produto - 
			 * o estoque do passo pai
			 * 
			 */
			// Se existir saldo para o produto predecessor
			if (saldoProdutos.containsKey(pre.getOmproduto().getOmproduto()) == true){
				Double saldoDisponivel = saldoProdutos.get(pre.getOmproduto().getOmproduto());
				pre.getOmproduto().getOmproduto().getCdProduto();
				// Calcula novo saldo
				if (saldoDisponivel > 0 && pre.getProducaoPlanejada() <= saldoDisponivel){
					saldoDisponivel -= (int) pre.getProducaoPlanejada();
					pre.setExcluida(true);
					saldoProdutos.put(pre.getOmproduto().getOmproduto(), saldoDisponivel);
				} else {
					// Nesse ponto, sabemos que o estoque nao atende totalmente a producaoplanejada
					// entao verificar se o estque pode atender parcialmente a producaoplanjeada
					if (saldoDisponivel > 0){
						pre.setProducaoPlanejada(pre.getProducaoPlanejada() - saldoDisponivel);
						saldoProdutos.put(pre.getOmproduto().getOmproduto(), 0d);
					}
				}
			}

			// se a predecessora foi excluida, entao tudo que vem abaixo dela deve deixar de existir pois nao eh mais necessario sua producao
			if (pre.isExcluida() == false ){
				// Se n�o existir saldo e apos abater o estoque, avaliar as predecessoras do passo predecessor
				avaliarEstoqueParaAsPredecessoras(log, idLog, identacao, pre);
			} else {
				pre.setPassosPredecessoras(new ArrayList<PassosDTO>());
			}
		}
		
		// Remover do passo as predecessoras excluidas atraves de um Iterator
		Iterator<PassosDTO> iterator = passo.getPassosPredecessoras().iterator();
		while (iterator.hasNext() == true) {
			PassosDTO passoParaExclusao = iterator.next();
			if (passoParaExclusao.isExcluida() == true){
				iterator.remove();
			}
		}
	}


	public void inicializaSaldoEstoque(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> alocacaoProduto, int anoReferencia, int mesReferencia){
		// O Saldo do estoque deve ser o saldo do estoque na virada do mes + o apontamento de producao do mes
		if (saldoProdutos == null)
			saldoProdutos = new HashMap<OmProduto, Double>();
		

		
		// Query para descobrir o saldo no inicio do mes
		MapQuery qEstoque = new MapQuery(dao.getSession());
		qEstoque.append("select dwestmov");
		qEstoque.append("from DwEstmov dwestmov");
		qEstoque.append("join fetch dwestmov.dwEstpro dwestpro");
		qEstoque.append("join fetch dwestpro.omProduto omproduto");
		qEstoque.append("where dwestmov.dthrMov = :dt and dwestmov.lancamento = 'FINAL MES'");
		
		Date dt = DataHoraRN.getData(anoReferencia, mesReferencia, 1);
		dt = DataHoraRN.subtraiDiasDaData(dt, 1);
		dt = DataHoraRN.getUltimoDiaDoMesDaData(dt);
		dt = DataHoraRN.getDataSemHora(dt);
		qEstoque.defineParametroData("dt", dt);
		
		// Varrer todos os produtos do estoque
		List<DwEstmov> lista = qEstoque.list();
		for (DwEstmov dwestmov : lista){
			DwEstpro dwestpro = dwestmov.getDwEstpro();
			
			// Se o item existir no estoque ele sera diferente de null
			if (dwestpro != null){
				// Se existir uma movimentacao do tipo FINAL MES, entao usada
				saldoProdutos.put(dwestpro.getOmProduto(), dwestmov.getQtAjuste().doubleValue());
			}
		}

		// Query para descobrir a producao no mes
		MapQuery qApont = new MapQuery(dao.getSession());
		qApont.append("select dwconsolid");
		qApont.append("from DwConsolid dwconsolid");
		qApont.append("join fetch dwconsolid.dwFolha dwfolha");
		qApont.append("join fetch dwfolha.dwFolhaiacs dwfolhaiac");
		qApont.append("join fetch dwfolhaiac.omProduto omproduto");
		qApont.append("join fetch dwconsolid.dwConsols dwconsol");
		qApont.append("where dwconsolid.ano = :ano");
		qApont.append("and dwconsolid.mes = :mes");
		qApont.defineParametro("ano", anoReferencia);
		qApont.defineParametro("mes", mesReferencia);
	
		List<DwConsolid> listaApon = qApont.list();
		
		for (DwConsolid dwconsolid : listaApon){
			double producaoManuBruta = 0d;
			for (DwConsol dwconsol : dwconsolid.getDwConsols()){
				if (dwconsol.getPcsManuProducaobruta() != null)
					producaoManuBruta += dwconsol.getPcsManuProducaobruta().doubleValue();
			}
			
			// Veriicar se o produto esta na lista
			DwFolhaiac dwfolhaiac = (DwFolhaiac) dwconsolid.getDwFolha().getDwFolhaiacs().iterator().next();
			OmProduto omproduto = dwfolhaiac.getOmProduto();
			
			if (saldoProdutos.containsKey(omproduto) == true){
				producaoManuBruta += saldoProdutos.get(omproduto);
			}
			
			saldoProdutos.put(omproduto, producaoManuBruta);
		}
	}
}

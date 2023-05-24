package idw.model.rn.geraplano.passos.tipoB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;

public class TipoBGeraLogs {
	
	private String cdProdutoParaOLog = "498156";
	private String cdProduto2ParaOLog = "";
	
	public void mostrarPassosSemPredecessora(IdwLogger log, int idLog, int identacao, SortedMap<ProdutoComparable, List<PassosDTO>> lista){
		for (ProdutoComparable omproduto : lista.keySet()){
			for (PassosDTO passo : lista.get(omproduto)){
				log.info(idLog, identacao, passo);
				mostrarPassosSemPredecessora(log, idLog, identacao, passo);
			}
		}
	}
	private void mostrarPassosSemPredecessora(IdwLogger log, int idLog, int identacao, PassosDTO passo){
		if (passo == null) {
			log.info(idLog, 20, "O passo esta nulo.");
		}else if (passo.getDwrotapasso() == null)
			log.info(idLog, 20, "RotaPasso esta nulo.");
		else  if (passo.getDwrotapasso().getPasso() == null)
			log.info(idLog, 20, "Passo esta nulo. Para o dwrotapass com id " + passo.getDwrotapasso().getIdRotapasso());
		
		if (passo.getDwrotapasso().getPasso().intValue() > 1 && passo.getPassosPredecessoras() != null && passo.getPassosPredecessoras().size() <= 0)
			log.info(idLog, 20, "Passo deveria ter predecessora mas nao tem " + passo);
		else {
			if (passo.isEspelho() == true)
				log.info(idLog, identacao, "É ESPELHO " + passo);

			for (PassosDTO passoPredecessor : passo.getPassosPredecessoras()){
				// Gerand um log especifico para o produto ...
				log.info(idLog, identacao, "PREDECESSORA " + passoPredecessor);
				

				// Se o final da predecessora for <> do inicio do passo, entao analisar o log e descobrir a causa, pois as espelhos deveriam ser iguais
				if (DataHoraRN.equals(passoPredecessor.getFim(), passo.getInicio()) == false) {
					log.info(idLog, identacao, "FIM predecessora <> PASSO " + passoPredecessor);
				}
				mostrarPassosSemPredecessora(log, idLog, identacao + 10, passoPredecessor);
			}
		}
	}
	public void mostrarPassosCTSemPredecessora(IdwLogger log, int idLog, int identacao, SortedMap<IdCtDTO, CtDTO> lista){
		for (IdCtDTO id : lista.keySet()){
			CtDTO ct = lista.get(id);
			for (PassosDTO passo : ct.getPassosAlocadosJaOrdenadosPeloFimComEspelhoAjustado(log, idLog, identacao)){
				log.info(passo);
				mostrarPassosSemPredecessora(log, idLog, identacao, passo);
			}
		}
	}

	public void mostrarProdutosOrdenadosDesTmpEst(IdwLogger log, int idLog, int identacao, SortedMap<ProdutoComparable, List<PassosDTO>> lista){
		
		for (ProdutoComparable omproduto : lista.keySet()){
			double somaTmpEst = 0d;
			for (PassosDTO passo : lista.get(omproduto)){
				somaTmpEst += passo.getTempoEstimadoSegundos();
			}
			omproduto.getOmproduto().mudaTmpEstimado(somaTmpEst);
		}

		
		// Ordena os produtos pelo maior tempo estimado ao menor
		List<ProdutoComparable> listaProduto = null;

		listaProduto = new ArrayList<ProdutoComparable>(lista.keySet());
		
		Collections.sort(listaProduto, new Comparator<ProdutoComparable>() {

			@Override
			public int compare(ProdutoComparable o1, ProdutoComparable o2) {
				return (o1.getOmproduto().obtemTmpEstimado() < o2.getOmproduto().obtemTmpEstimado() ? +1 : o1.getOmproduto().obtemTmpEstimado() > o2.getOmproduto().obtemTmpEstimado() ? -1 : 0);
			}
		});

		// Mostra no log a avaliacao
		for (ProdutoComparable op : listaProduto){
			log.debug(idLog, identacao, op.getOmproduto().getCdProduto() + " tempo est " + op.getOmproduto().obtemTmpEstimado());
		}
	}
}

package idw.model.rn.geraplano.passos.tipoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.util.IdwLogger;

public class TipoAAjustaBranches {
	
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsAjustandoBranches(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable pr : cpsVirtuais.keySet()){
			List<PassosDTO> listaOrdenada = cpsVirtuais.get(pr);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			// Ordena pela data inicio pq o estoque deve abater as primeiras ordens
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0));
				}
			});

			listaConsolidada = getListaConsolidadaComBlancksCorrigidos(log, idLog, identacao, listaOrdenada);
			
			cpsConsolidadas.put(pr, listaConsolidada);
		}
		log.info(idLog, 20, "Fim geraCpsAjustandoBranches");
		
		return cpsConsolidadas;
	}

	
	private List<PassosDTO> getListaConsolidadaComBlancksCorrigidos(IdwLogger log, int idLog, int identacao, List<PassosDTO> listaOrdenada){
		List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
		
		for (PassosDTO p : listaOrdenada){
			double qtAtiva = p.getQtCavAtivas();

			if (p.getOmproduto().getOmproduto().getCdProduto().equals("RENX0886JZ-AXI") && qtAtiva <= 1)
				log.info(idLog, identacao, "Debugar o passo " + p);

			if (qtAtiva > 1){
				double qtNecessaria = p.getProducaoPlanejada();
				
				// Recalcular branches
				if (qtNecessaria % qtAtiva > 0){
					if (p.getOmproduto().getOmproduto().getCdProduto().equals("RENX0886JZ-AXI"))
						log.info(idLog, identacao, "Debugar o passo " + p);
					
					qtNecessaria = (int)(qtNecessaria / qtAtiva);
					qtNecessaria += 1;
					qtNecessaria *= qtAtiva;
					
					p.setProducaoPlanejada(qtNecessaria);
				}
			}
			
			// Avalia predecessoras do passo
			if (p.getPassosPredecessoras() != null && p.getPassosPredecessoras().size() > 0){
				p.setPassosPredecessoras(getListaConsolidadaComBlancksCorrigidos(log, idLog, identacao, p.getPassosPredecessoras()));
			}
			
			listaConsolidada.add(p);
		}

		return listaConsolidada;
	}
}

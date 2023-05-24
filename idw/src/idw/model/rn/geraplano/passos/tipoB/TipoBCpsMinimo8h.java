package idw.model.rn.geraplano.passos.tipoB;

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

public class TipoBCpsMinimo8h {
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsComNoMinimo8Horas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsComNoMinimo8horas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable p : cpsConsolidadas.keySet()){
			List<PassosDTO> listaOrdenada = cpsConsolidadas.get(p);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			// Ordernar crescente pela data inicio
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getInicio(), o2.getInicio()) ? -1 : (DataHoraRN.after(o1.getInicio(), o2.getInicio()) ? +1 : 0));
				}
			});
			
			
			PassosDTO paAvaliado = null;
			for (PassosDTO pa : listaOrdenada){
				if (pa.getTempoEstimadoSegundos() > ( 8 * 3600) ) {
					if (paAvaliado != null) {
						listaConsolidada.add(paAvaliado);
						paAvaliado = null;
					}
					listaConsolidada.add(pa);
					continue; // passa para o proximo pois ja esta com 8horas
				}
				
				if (paAvaliado == null)
					paAvaliado = pa;
				else {
					// Verifica quanto ficara o tempo estimado unindo os dois passos
					double tempoEstimado = paAvaliado.getTempoEstimadoSegundos() + pa.getTempoEstimadoSegundos();
					if (tempoEstimado < ( 9 * 3600 ) ){
						// Atencao, pode ocorrer o caso em que a soma dos tempo ultrapasse a data final de entrega do passo incorporado
						// no momento n�o existe a preocupacao de resolver essa questao, visto que os tempos sao curtos e os lead-times sao altos.
						paAvaliado.acumulaPassosComPredecessorasModificandoFim(pa);
					} else {
						listaConsolidada.add(paAvaliado);
						paAvaliado = pa;
					}
				}
			}

			if (paAvaliado != null)
				listaConsolidada.add(paAvaliado);

			cpsComNoMinimo8horas.put(p, listaConsolidada);
		}
		log.info(idLog, 20, "Fim geraCpsComNoMinimo8Horas");

		return cpsComNoMinimo8horas;
	}
}

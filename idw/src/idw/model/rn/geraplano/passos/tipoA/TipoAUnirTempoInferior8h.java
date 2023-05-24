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

public class TipoAUnirTempoInferior8h {
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsConcatenandoAsInferiores8horas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsComNoMinimo8horas){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConcatenandoInferiores4horas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable p : cpsComNoMinimo8horas.keySet()){
			List<PassosDTO> listaOrdenada = cpsComNoMinimo8horas.get(p);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			if (p.getOmproduto().getCdProduto().equals("922381"))
				log.info(idLog, identacao, "por algum motivo predecessoras sumiram, analisar.");
			
			/*
			 * Ao contrario do procedimento anterior que ordenava crescentemente pela data de inicio
			 * Esse passo irá ordenar descrescente pela data final, pois, o procedimenteo anterior "teoricamente"
			 * ja concatenou as ops para terem mais de 8horas, entao devemos fazer o caminho contrario para antecipar
			 * as ops muito rapidas
			 */
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0));
				}
			});
			
			PassosDTO paAvaliado = null;
			for (PassosDTO pa : listaOrdenada){
				if (paAvaliado != null && paAvaliado.getTempoEstimadoSegundos() < ( 8 * 3600) ) { // Se o tempo estimado ja for maior que 8h entao desconsiderar
					// Obs importante
					// Como estamos percorrendo o list da data mais no futuro para a menos no futuro
					// quem irá receber o acumulo sera o pa
					pa.acumulaPassosComPredecessorasModificandoFim(paAvaliado);
					paAvaliado = null;
					pa.getTempoEstimadoSegundos();
					pa.getTempoEstimadoHoras();
					DataHoraRN.getQuantidadeHorasNoPeriodo(pa.getInicio(), pa.getFim());
				} else if (paAvaliado != null){
					listaConsolidada.add(paAvaliado);
				}
				paAvaliado = pa;
			}

			if (paAvaliado != null)
				listaConsolidada.add(paAvaliado);

			cpsConcatenandoInferiores4horas.put(p, listaConsolidada);
		}
		log.info(idLog, 20, "Fim geraCpsConcatenandoAsInferiores8horas");

		return cpsConcatenandoInferiores4horas;
	}

}

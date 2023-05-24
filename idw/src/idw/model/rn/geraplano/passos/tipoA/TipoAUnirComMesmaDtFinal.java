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

public class TipoAUnirComMesmaDtFinal {
	/* Este metodo tem como objetivo avaliar para cada produto se existem conflitos de entrega dos mesmos
	 * Se existir, os conflitos devem ser acumulados recalculando a data de inicio do passo e as datas das predecessoras
	 */
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsConsolidadasQueTenhamMesmaDataFinal(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable p : cpsVirtuais.keySet()){
			List<PassosDTO> listaOrdenada = cpsVirtuais.get(p);
			List<PassosDTO> listaConsolidada = new ArrayList<PassosDTO>();
			
			// Ordenando pela data de fim descrescente, pois esta se unindo os passo que tem a mesma data de fim
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0));
				}
			});
			PassosDTO paAnterior = null;
			for (PassosDTO pa : listaOrdenada){
				if (paAnterior != null){
					if (DataHoraRN.equals(paAnterior.getFim(), pa.getFim())){
						paAnterior.acumulaPassosComPredecessorasModificandoInicio(pa);
					} else {
						listaConsolidada.add(paAnterior);
						paAnterior = pa;
					}
				} else {
					paAnterior = pa;
				}
			}
			// o passoAnterior deve ser incluido no map do produto consolidado
			if (paAnterior != null)
				listaConsolidada.add(paAnterior);
			
			cpsConsolidadas.put(p, listaConsolidada);
		}
		log.info(idLog, 20, "Fim geraCpsConsolidadas");
		
		return cpsConsolidadas;
	}
}

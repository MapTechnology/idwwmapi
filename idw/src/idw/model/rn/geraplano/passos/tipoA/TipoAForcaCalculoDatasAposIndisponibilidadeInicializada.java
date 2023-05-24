package idw.model.rn.geraplano.passos.tipoA;

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

public class TipoAForcaCalculoDatasAposIndisponibilidadeInicializada {
	
	public SortedMap<ProdutoComparable, List<PassosDTO>> geraCpsForcandoRecalculoDatas(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<ProdutoComparable, List<PassosDTO>> cpsVirtuais){
		
		SortedMap<ProdutoComparable, List<PassosDTO>> cpsConsolidadas = new TreeMap<ProdutoComparable, List<PassosDTO>>();
		
		// Consolida a producao do produto que termina na mesma data, recalculando a data de inicio (para as predecessora tb)
		for (ProdutoComparable pr : cpsVirtuais.keySet()){

			if (pr.getOmproduto().getCdProduto().equals("BUPGF589RUK-IAC"))
				log.info("DEBUG");
			
			List<PassosDTO> listaOrdenada = cpsVirtuais.get(pr);
			
			Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.compareTo(o1.getFim(), o2.getFim()) * -1;
				}
			});

			for (PassosDTO pa : listaOrdenada){

				if(pa.getOmproduto().getOmproduto().getCdProduto().equals("TP7NA5596CE-ILH")){
					log.info("DEBUG");
				}
				
				// Recalcula usando o CT escolhido como referencia de ciclo padrao
				// todo definir o ciclo padrao real para o recalculo abaixo
				
				pa.calculaDatasInicioFim(log, idLog, identacao, pa.getFim()); // o false nao foi passado pois as datas das predecessoras devem ser recalculadas, apenas no proximo passo que removerosconflitos nao devemos considerar o recalculo das predecessoras
				log.info("DEBUG");
			}
			
			cpsConsolidadas.put(pr, listaOrdenada);
		}
		log.info(idLog, 20, "Fim geraCpsForcandoRecalculoDatas");
		
		return cpsConsolidadas;
	}
}

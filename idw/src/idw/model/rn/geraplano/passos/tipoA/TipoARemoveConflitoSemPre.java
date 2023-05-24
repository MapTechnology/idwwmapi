package idw.model.rn.geraplano.passos.tipoA;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;

public class TipoARemoveConflitoSemPre {
	public SortedMap<IdCtDTO, CtDTO> geraCpsSemConflitoNAORecalculandoPredecessoras(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr, SortedMap<IdCtDTO, CtDTO> alocacaoCTsSemConflito){
		
		SortedMap<IdCtDTO, CtDTO> alocacaoCTsSemConflito2 = new TreeMap<IdCtDTO, CtDTO>();
		
		for (IdCtDTO idctdto : alocacaoCTsSemConflito.keySet()){
			// Ordena da maior data de fim para a menor data de fim
			CtDTO ctdto = alocacaoCTsSemConflito.get(idctdto);
			List<PassosDTO> listaordenada = ctdto.getPassosAlocados();
			Collections.sort(listaordenada, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0);
				}
			});
			
			// Varre as CPs removendo os conflitos colocando uma das duas para um periodo anterior
			PassosDTO pAnterior = null;
			log.info(idLog, identacao, "Removendo conflito para o CT " + ctdto);
			
			if (ctdto.toString().equals("Pt JVK-2") == true){
				log.info(idLog, identacao, "Debugar JVK-2 para o recalculo dos espelhos");
			}
			for (PassosDTO p : listaordenada){
				
				if (pAnterior == null)
					pAnterior = p;
				else {
					log.info(idLog, identacao, (p.isConflitaCom(pAnterior) ? "CONFLITA " : "NAO CONFLITA ") + p + " com anterior " + pAnterior);
					if (p.isEspelho() == true || (p.isConflitaCom(pAnterior) == true || DataHoraRN.after(p.getInicio(), pAnterior.getFim()))){
						// Recalcula o passo avaliado
						p.calculaDatasInicioFim(log, idLog, identacao, pAnterior.getInicio(), false);
						log.info(idLog, identacao + 10, "Recalculou datas para " + p);
					}
					pAnterior = p;
				}
			}
			
			// sera necessario jogar novamente a lista para o SortedMap? avaliar...NAO eh necessario jogar para o map novamente.
			CtDTO ctdto2 = new CtDTO(ctdto);
			ctdto2.setPassosAlocados(listaordenada);
			alocacaoCTsSemConflito2.put(ctdto2.getId(), ctdto2);
		}
		
		return alocacaoCTsSemConflito2;
	}
}

package idw.model.rn.geraplano.passos.tipoB;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpPlano;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;

public class TipoBAjustaInicioCPParaInicioTurno {

	public SortedMap<IdCtDTO, CtDTO> geraCpsAjustandoInicioCp(IdwLogger log, int idLog, int identacao, PpPlano ppplano, OmUsr omusr,  SortedMap<IdCtDTO, CtDTO> listaParaProcessamento, DAOGenerico dao){

		// Inicializa rn para encontrar o inicio do turno
		TurnoRN tRN = new TurnoRN(dao);
		
		for (IdCtDTO idctdto : listaParaProcessamento.keySet()){
			CtDTO ctdto = listaParaProcessamento.get(idctdto);

			// Obter uma lista com todas as CPs ordenadas cronologicamente
			List<PassosDTO> todosOsPassos = ctdto.getPassosAlocados();
			// Ordena cronologicamente pela data inicial
			
			Collections.sort(todosOsPassos, new Comparator<PassosDTO>() {
				@Override
				public int compare(PassosDTO o1, PassosDTO o2) {
					return (DataHoraRN.compareTo(o1.getInicio(), o2.getInicio()));
				}
			});

			for (PassosDTO p : todosOsPassos) {

				TurnoAtualDTO turno = null;
				if (ctdto.getId().getOmptEscolhido() != null ){
					turno = tRN.getTurnoAtualDTOComClone(ctdto.getId().getOmptEscolhido(), p.getInicio());
				}else if(ctdto.getId().getOmgtEscolhido() != null ){
					//turno = tRN.getTurnoAtual(ctdto.getId().getOmgtEscolhido().getIdGt(), p.getInicio());
				}
				
				if (turno != null && turno.getDtHrITurno() != null){
					p.mudaInicioSemConsiderarIndisponibilidade(turno.getDtHrITurno());
					
				}
					
				break;
			}
		}
		
		return listaParaProcessamento;
	}
}

package idw.model.pojos.template;

import java.util.HashSet;

import idw.model.pojos.PpCpData;
import idw.model.pojos.PpCpTurno;

public class PpCpDataTemplate extends AbstractTemplate<PpCpData> {

	@Override
	protected PpCpData atribuir(PpCpData from, PpCpData to, boolean isCopiarFK) {
		if(to == null) {
			to = new PpCpData();
		}
		
		to.setIdCpData(from.getIdCpData());
		to.setDtPlanejada(from.getDtPlanejada());
		to.setPcsProducaoprevista(from.getPcsProducaoprevista());
		
		if(isCopiarFK) {
			if(from.getPpCpTurnos() != null) {
				to.setPpCpTurnos(new HashSet<PpCpTurno>());
				for(PpCpTurno turno : from.getPpCpTurnos()) {
					to.getPpCpTurnos().add(turno.clone());
				}
			}
		}
		
		to.setPpCpproduto(null);
		
		return to;
	}
	
}

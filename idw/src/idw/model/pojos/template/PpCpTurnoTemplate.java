package idw.model.pojos.template;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.pojos.DwCalavu;
import idw.model.pojos.PpCpTurno;

public class PpCpTurnoTemplate extends AbstractTemplate<PpCpTurno> {

	@Override
	protected PpCpTurno atribuir(PpCpTurno from, PpCpTurno to,
			boolean isCopiarFK) {
		if(to == null) {
			to = new PpCpTurno();
		}
		
		to.setIdCpTurno(from.getIdCpTurno());
		to.setPcsProducaoprevista(from.getPcsProducaoprevista());
		
		if(isCopiarFK) {
			if(from.getDwCalavu() != null) {
				try {
					to.setDwCalavu((DwCalavu)from.getDwCalavu().clone());
				}catch(SessionException e) {
					to.setDwCalavu(null);
				}catch(LazyInitializationException e) {
					to.setDwCalavu(null);
				}
			}
			
			if(from.getDwTurno() != null) {
				to.setDwTurno(from.getDwTurno().clone(false));
			}
		}
		
		to.setPpCpData(null);
		
		return to;
	}

}

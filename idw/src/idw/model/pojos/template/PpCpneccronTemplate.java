package idw.model.pojos.template;

import idw.model.pojos.PpCpneccron;

public class PpCpneccronTemplate extends AbstractTemplate<PpCpneccron> {

	@Override
	protected PpCpneccron atribuir(PpCpneccron from, PpCpneccron to,
			boolean isCopiarFK) {
		
		if(to == null) {
			to = new PpCpneccron();
		}
		
		to.setIdCpneccron(from.getIdCpneccron());
		to.setQtAtendida(from.getQtAtendida());
		to.setPpPlaneccron(from.getPpPlaneccron().clone(false));
		to.setPpCp(null);
		
		return to;
	}

}

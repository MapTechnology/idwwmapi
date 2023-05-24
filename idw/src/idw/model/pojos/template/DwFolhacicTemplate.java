package idw.model.pojos.template;

import idw.model.pojos.DwFolhacic;

public class DwFolhacicTemplate extends AbstractTemplate<DwFolhacic> {

	@Override
	protected DwFolhacic atribuir(DwFolhacic from, DwFolhacic to, boolean isCopiarFK) {
		
		if(to == null) {
			to = new DwFolhacic();
		}
		
		to.setIdFolhacic(from.getIdFolhacic());
		
		if (from.getOmGt() != null)
			to.setOmGt(from.getOmGt().clone());
		if (from.getOmPt() != null)
			to.setOmPt(from.getOmPt().clone());
		
		to.setSegCiclopadrao(from.getSegCiclopadrao());
		to.setQtFatorcontagem(from.getQtFatorcontagem());
		to.setQtPacoteciclo(from.getQtPacoteciclo());
		return to;
	}

}

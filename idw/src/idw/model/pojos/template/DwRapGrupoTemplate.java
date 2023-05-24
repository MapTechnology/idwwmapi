package idw.model.pojos.template;

import idw.model.pojos.DwRapGrupo;

public abstract class DwRapGrupoTemplate extends AbstractTemplate<DwRapGrupo>{

	@Override
	protected DwRapGrupo atribuir(DwRapGrupo from, DwRapGrupo to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwRapGrupo();
		}
		
		to.setIdRapGrupo(from.getIdRapGrupo());

		if (isCopiarFK == true){
			to.setDwGrupoFerramenta(from.getDwGrupoFerramenta().clone(false));			
			if(from.getDwRap() != null) {
				to.setDwRap(from.getDwRap().clone(false));
			}
		}

		return to;
	}
}

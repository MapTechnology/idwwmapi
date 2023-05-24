package idw.model.pojos.template;

import idw.model.pojos.DwFolhamedtemphorcfg;

public class DwFolhamedtemphorcfgTemplate extends AbstractTemplate<DwFolhamedtemphorcfg> {

	@Override
	protected DwFolhamedtemphorcfg atribuir(DwFolhamedtemphorcfg from, DwFolhamedtemphorcfg to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhamedtemphorcfg();
		}
		
		to.setIdFolhamedtemphorcfg(from.getIdFolhamedtemphorcfg());
		to.setDsCfg(from.getDsCfg());
		to.setCorIntervalo(from.getCorIntervalo());
		to.setLimInfTemp(from.getLimInfTemp());
		to.setLimSupTemp(from.getLimSupTemp());
		
		if (isCopiarFK == true)
		{
			try
			{
				to.setDwFolhamedtemhor(from.getDwFolhamedtemhor().clone(false));
			}
			catch (Exception e) 
			{
				to.setDwFolhamedtemhor(null);
			}
		}
		
		return to;
	}

}

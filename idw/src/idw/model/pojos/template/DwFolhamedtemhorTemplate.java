package idw.model.pojos.template;

import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemphorcfg;

public class DwFolhamedtemhorTemplate extends AbstractTemplate<DwFolhamedtemhor> {

	@Override
	protected DwFolhamedtemhor atribuir(DwFolhamedtemhor from, DwFolhamedtemhor to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhamedtemhor();
		}
		
		to.setIdFolhamedtemphorario(from.getIdFolhamedtemphorario());
		to.setDiasemini(from.getDiasemini());
		to.setDiasemfim(from.getDiasemfim());
		to.setHrini(from.getHrini());
		to.setHrinigui(from.getHrinigui());
		to.setHrfim(from.getHrfim());
		to.setHrfimgui(from.getHrfimgui());	
		to.setDwFtParam(from.getDwFtParam());
		to.setSegIntervaloLeitura(from.getSegIntervaloLeitura());
		
		
		if (isCopiarFK == true) {
			if (from.getDwFtParam() != null)
				to.setDwFtParam(from.getDwFtParam().clone(false));
			else
				to.setDwFtParam(null);
			
			Set<DwFolhamedtemphorcfg> lista  = new HashSet<DwFolhamedtemphorcfg>();
			for (DwFolhamedtemphorcfg cfg : from.getDwFolhamedtemphorcfgs()) {
				lista.add(cfg.clone(false));
			}
			to.setDwFolhamedtemphorcfgs(lista);		
			try
			{
				to.setDwFolhamedtemp(from.getDwFolhamedtemp().clone(false));
			}
			catch (Exception e) 
			{
				to.setDwFolhamedtemp(null);
			}
		}
		
		return to;
	}	

}

package idw.model.pojos.template;

import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.DwFolhamedtemhor;
import idw.model.pojos.DwFolhamedtemp;

public class DwFolhamedtempTemplate extends AbstractTemplate<DwFolhamedtemp> {
	
	@Override
	protected DwFolhamedtemp atribuir(DwFolhamedtemp from, DwFolhamedtemp to, boolean isCopiarFK) {
		if(to == null) {
			to = new DwFolhamedtemp();
		}
		
		to.setIdFolhamedtemp(from.getIdFolhamedtemp());
		to.setTpArmazenamento(from.getTpArmazenamento());
		to.setQtArmazenamento(from.getQtArmazenamento());
		to.setSegIntervaloLeitura(from.getSegIntervaloLeitura());
		Set<DwFolhamedtemhor> lista = new HashSet<DwFolhamedtemhor>();
		
		if (isCopiarFK == true)
		{
			for (DwFolhamedtemhor hor :  from.getDwFolhamedtemhors())
			{
				lista.add(hor.clone());
			}		
			to.setDwFolhamedtemhors(lista);
			
			try
			{
				to.setDwFolha(from.getDwFolha().clone(false));
			}
			catch (Exception e) 
			{
				to.setDwFolha(null);
			}
		}
		
		return to;
	}		

}

package idw.model.rn;

import java.util.List;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.pojos.MsCck;
import idw.model.pojos.cck.CampoMemoria;
import idw.model.pojos.cck.MemoriaMassa;

public class MsCckRN extends AbstractRN<AbstractDAOGenerico> {

	public MsCckRN(AbstractDAOGenerico dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	public void setMsCck(MsCck msCck, List<MemoriaMassa> listaMassas){
		
		MsCck cck = new MsCck();
		
		cck.setIdCampo(msCck.getIdCampo());
		cck.setDatahora(listaMassas.get(listaMassas.size() -1).getId().getDatahora());
		getDao().makePersistent(cck);
		
	}

	public void setValoresMsCck(CampoMemoria campo,
		List<MemoriaMassa> listaMassas) {
				
		MsCck cck = new MsCck();
		
		cck.setIdCampo(campo.getIdCampoMemoria());
		cck.setDatahora(listaMassas.get(listaMassas.size() -1).getId().getDatahora());
		getDao().makePersistent(cck);
	}


}

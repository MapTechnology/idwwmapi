package idw.model.rn.cp;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.PpCp;
import ms.model.dto.EventoColetado;

public interface IObtemOP {
	
	public PpCp obtem(EventoColetado evento, DAOGenerico dao);

}

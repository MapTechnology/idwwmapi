package ms.coleta.andon;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonTodasParadas implements IAndon {
	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
		
	    if (UpDTO.isUpParada() && !UpDTO.getCdParada().equals(""))
	    {
            return true;
	    }
	    return false;
	}
}

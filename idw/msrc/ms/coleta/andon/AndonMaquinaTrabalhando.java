package ms.coleta.andon;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonMaquinaTrabalhando implements IAndon {

	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
        if ((UpDTO.isUpTrabalhando()) && (UpDTO.getIsComOP() == true))
        {
        	return true;
        }
		return false;
	}
}

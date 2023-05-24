package ms.coleta.andon;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonInspecaoPendente implements IAndon {

	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
        if (UpDTO.getIsInspecaoPendenteExecucao())
        {        	
        	return true; 
        }
		return false;
	}

}

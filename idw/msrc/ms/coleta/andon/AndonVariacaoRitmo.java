package ms.coleta.andon;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonVariacaoRitmo implements IAndon {
	
	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
				
	    if (UpDTO.getIsComVariacaoRitmoPend())
	    {
            return true;
	    }
	    return false;
	}
}

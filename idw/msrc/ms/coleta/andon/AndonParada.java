package ms.coleta.andon;

import ms.coleta.dto.AndonArgsDTO;
import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonParada implements IAndon {
	
	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
		
		AndonArgsDTO argumento = andondto.getAndonArgs().get(0);
	    if (UpDTO.isUpParada() && argumento.validaValorReferenciaString(UpDTO.getCdParada()))
	    {
            return true;
	    }
	    return false;
	}
}

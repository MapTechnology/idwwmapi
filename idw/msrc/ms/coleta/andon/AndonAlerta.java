package ms.coleta.andon;

import ms.coleta.dto.AndonArgsDTO;
import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;
import ms.model.dto.MSalertaDTO;

public class AndonAlerta implements IAndon {

	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
        if (UpDTO.getListaAlertasEmAberto() != null)
        {
        	AndonArgsDTO argumentoAndon = andondto.getAndonArgs().get(0);
            for (MSalertaDTO alerta : UpDTO.getListaAlertasEmAberto())
            {
                if (argumentoAndon.validaValorReferenciaString(alerta.getCdAlerta()))
                {
                    return true;                    
                }                                
            }
        }
		return false;
	}

}

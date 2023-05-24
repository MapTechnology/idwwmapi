package ms.coleta.andon;

import ms.excessao.*;
import ms.model.dto.UpDTO;
import ms.coleta.dto.*;

public interface IAndon {
	
	boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException; 
}

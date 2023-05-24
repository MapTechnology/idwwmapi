package ms.coleta.ic.flex.teste24gadsl;

import ms.coleta.ic.flex.ICFlex;
import ms.model.dto.IcDTO;

public class ICFlex24gadsl  extends ICFlex{
	
	public ICFlex24gadsl(IcDTO icdto) {
		super(icdto, new WatcherTrigger24gadsl(), false); //_TP_AVALIACAO_ARQUIVOS._SOMENTESUBDIRETORIOS);
	}
}

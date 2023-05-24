package ms.coleta.ic.flex.teste24g;

import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.model.dto.IcDTO;

public class ICFlex24g  extends ICFlexADWatcher{
	
	public ICFlex24g(IcDTO icdto) {
		super(icdto, new WatcherTrigger24g(), false); //_TP_AVALIACAO_ARQUIVOS._SOMENTESUBDIRETORIOS);
	}
}

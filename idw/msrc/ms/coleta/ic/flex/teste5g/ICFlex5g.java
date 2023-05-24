package ms.coleta.ic.flex.teste5g;

import ms.coleta.ic.flex.ICFlex;
import ms.coleta.ic.flex.ICFlexADWatcher;
import ms.model.dto.IcDTO;

public class ICFlex5g  extends ICFlexADWatcher{
	public ICFlex5g(IcDTO icdto) {
		super(icdto, new WatcherTrigger5g(), false); // , _TP_AVALIACAO_ARQUIVOS._SOMENTESUBDIRETORIOS);
	}
}

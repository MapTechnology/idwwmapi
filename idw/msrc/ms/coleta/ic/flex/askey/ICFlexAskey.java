package ms.coleta.ic.flex.askey;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexAskey extends ICFlexSemWatcher{

	//public ICFlexAskey(IcDTO icdto, AbstractWatcherTrigger rn, _TP_AVALIACAO_ARQUIVOS tpAval) {
	public ICFlexAskey(IcDTO icdto) {
		super(icdto, new WatcherTriggerAskey(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}

}

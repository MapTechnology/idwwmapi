package ms.coleta.ic.flex.rx;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexRx  extends ICFlexSemWatcher{
	public ICFlexRx(IcDTO icdto) {
		super(icdto, new WatcherTriggerRx(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}
}

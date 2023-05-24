package ms.coleta.ic.flex.tx;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexTx  extends ICFlexSemWatcher	 {
	public ICFlexTx(IcDTO icdto) {
		super(icdto, new WatcherTriggerTx(), _TP_AVALIACAO_ARQUIVOS._ARVOREDIRETORIOS);
	}
}

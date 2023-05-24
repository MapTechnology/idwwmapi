package ms.coleta.ic.flex.pt;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexPt  extends ICFlexSemWatcher {
	
	public ICFlexPt(IcDTO icdto) {
		super(icdto, new WatcherTriggerPt(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}
}

package ms.coleta.ic.flex.ssid;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexSSID  extends ICFlexSemWatcher{
	
	public ICFlexSSID(IcDTO icdto) {
		super(icdto, new WatcherTriggerSSID(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}
}

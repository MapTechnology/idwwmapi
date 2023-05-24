package ms.coleta.ic.flex.pk;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

public class ICFlexPk  extends ICFlexSemWatcher{

	public ICFlexPk(IcDTO icdto) {
		super(icdto, new WatcherTriggerPk(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}
}

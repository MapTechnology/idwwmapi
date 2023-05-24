package ms.coleta.ic.flex.ftp;

import ms.coleta.ic.flex.ICFlexSemWatcher;
import ms.coleta.ic.flex.ThreadDiretoriosFlex._TP_AVALIACAO_ARQUIVOS;
import ms.model.dto.IcDTO;

/* Estou usando o SemWatcher pois existem poucos arquivos no direotorio e o com watcher está abrindo muitas threads
 * 
 */
public class ICFlexftp  extends ICFlexSemWatcher {
	public ICFlexftp(IcDTO icdto) {
		super(icdto, new WatcherTriggerFtp(), _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS);
	}
}

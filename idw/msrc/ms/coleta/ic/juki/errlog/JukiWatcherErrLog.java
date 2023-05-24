package ms.coleta.ic.juki.errlog;

import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.juki.JukiWatcher;
import ms.coleta.ic.juki.TratadorHeartBeat;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;

public class JukiWatcherErrLog extends JukiWatcher {
	
	public JukiWatcherErrLog(IdwLogger log, ICJuki ic) {
		super(ic, log);
	}

	@Override
	public void iniciarWatcher() {
		// DefaultFileMonitor fm = getFm();
		log.info("Iniciando watcher");

		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("JukiWatcherErrLog: excecao ao obter fsManager: ", e);
			e.printStackTrace();
		}
		
		fm = new DefaultFileMonitor(new TrataArquivoErrLogGerandoEventos(log, getIcUpDTOList(), getIc()));
		fm.setRecursive(true);

		// Debounce 1
		// Garante que o FileMonitor nao seja ativado repetidas vezes seguidas
		// e garante um tempo para o arquivo terminar de ser escrito
		// fm.setDelay(10 * 1000);
		fm.setDelay(1 * 1000);
		setFm(fm);
		
		setUrlsAMonitorar(fm, fsManager);

		fm.start();
		
		// Lanca HeartBeats
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraHeartBeatJuki");
		addTratadorHeartBeat(t);
		t.start();
		
	}// Fim do iniciarWatcher()

	void setUrlsAMonitorar(DefaultFileMonitor fm, FileSystemManager fsManager) {
		// Informa ao watcher todos os arquivos a serem monitorizados
		for (String caminho : getCaminhos()) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
			} catch (FileSystemException e) {
				e.printStackTrace();
				log.info("JukiWatcherErrLog: ", e);
			}
			fm.addFile(listendir);
		}
	}

}

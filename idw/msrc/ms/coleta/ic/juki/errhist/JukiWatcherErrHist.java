package ms.coleta.ic.juki.errhist;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.juki.JukiWatcher;

public class JukiWatcherErrHist extends JukiWatcher {

	public JukiWatcherErrHist(IdwLogger log, ICJuki icJuki) {
		super(icJuki, log);
	}

	@Override
	public void iniciarWatcher() {
		DefaultFileMonitor fm = getFm();
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("JukiWatcherErrHist: excecao ao obter fsManager: ", e);
			e.printStackTrace();
		}
		
		fm = new DefaultFileMonitor(new TrataArquivoErrHistGerandoEventos(log, getIcUpDTOList(), getIc()));
		fm.setRecursive(true);

		// Debounce 1
		// Garante que o FileMonitor nao seja ativado repetidas vezes seguidas
		// e garante um tempo para o arquivo terminar de ser escrito
		fm.setDelay(10 * 1000);
		setFm(fm);
		
		// Informa ao watcher todos os arquivos a serem monitorizados
		for (String caminho : getCaminhos()) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
			} catch (FileSystemException e) {
				e.printStackTrace();
				log.info("JukiWatcherErrHist: ", e);
			}
			fm.addFile(listendir);
		}

		fm.start();
	}// Fim do iniciarWatcher()

}

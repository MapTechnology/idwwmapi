package ms.coleta.ic.mitrastar.ssid;

import java.io.File;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;

public class MitraStarSSIDWatcher {

	private DefaultFileMonitor fm = null;
	private List<File> caminhos;
	private IdwLogger log;
	private final TrataArquivoMitraStarSSID trataArquivoMitraStarSSID;
	private static final String CLASS_NAME = MitraStarSSIDWatcher.class.getSimpleName();

	
	private boolean isIniciado = false;
	
	public MitraStarSSIDWatcher(TrataArquivoMitraStarSSID trataArquivoMitraStarSSID, IdwLogger log, List<File> caminhos) {
		super();
		this.trataArquivoMitraStarSSID = trataArquivoMitraStarSSID;
		this.log = log;
		this.caminhos = caminhos;
	}

	public void iniciarWatcher() {
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
			fm = new DefaultFileMonitor(trataArquivoMitraStarSSID);
			fm.setRecursive(false);

			for (File caminho : caminhos) {
				log.info("incluindo watcher para " + caminho.getPath());
				FileObject listendir = fsManager.resolveFile(caminho.getPath());
				fm.addFile(listendir);
			}
			
			fm.start();
			isIniciado = true;
		} catch (FileSystemException e) {
			log.error(e.getMessage(), e);

		}

	}

	public void finalizar() {
		log.info(CLASS_NAME + " Finalizando watcher");
		fm.stop();
		isIniciado = false;
	}

	public boolean isIniciado() {
		return isIniciado;
	}
}

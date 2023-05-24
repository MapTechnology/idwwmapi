package ms.coleta.ic.alcatel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class AlcatelWatcher {

	private DefaultFileMonitor fm = null;
	private AlcatelBufferedEventos bufferEventos;
	private List<String> caminhos = new ArrayList<>();
	private IdwLogger log;
	
	public AlcatelWatcher(AlcatelBufferedEventos bufferEventos, IdwLogger log) {
		super();
		this.bufferEventos = bufferEventos;
		this.log = log;
	}
	
	public void addDiretorio(String caminho) {
		log.info("adicionando " + caminho);
		caminhos.add(caminho);
	}

	public void iniciarWatcher() {
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("Excessao1:", e);
			e.printStackTrace();
		}

		fm = new DefaultFileMonitor(new TrataArquivoGerandoEventos(bufferEventos, log));
		fm.setRecursive(true);

		// Informa ao watcher todos os arquivos a serem monitorizados
		for (String caminho : caminhos) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
				fm.addFile(listendir);
			} catch (FileSystemException e) {
				System.out.println("Em AlcatelWatcher (" + DataHoraRN.getDataHoraAtualFormatada() + "): " + e.getMessage());
				log.info("Excessao: ", e);
			}
		}
		
		fm.start();
	}
	
	
	public void finalizar() {
		log.info("Finalizando watcher");
		fm.stop();
	}
}

package ms.coleta.ic.fuji.fujiflexa;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;

import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.MapFileMonitor;
import ms.coleta.ic.fuji.FujiWatcher;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.ic.fuji.TratadorHeartBeat;

public class FujiWatcherFujiFlexa extends FujiWatcher{

	public FujiWatcherFujiFlexa(IdwLogger log, ICFuji ic) {
		super(log, ic);
	}

	@Override
	public void iniciarWatcher() {
		log.info("Iniciando watcher FujiWatcherFujiFlexa");
		
		FileSystemManager fsManager = null;
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException e) {
			log.info("FujiWatcherFujiFlexa: excecao ao obter fsManager: ", e);
			e.printStackTrace();
		}
		
		// O MapFileMonitor tem como diferenca e vantagem sobre o DefaultFileMonitor ter limitacao de profundidade
		// dos arquivos. Apenas o primeiro subnivel e monitorado
		// fm = new DefaultFileMonitor(new TrataArquivosFujiFlexaGerandoEventos(log, getIcUpDTOList(), getIc()));
		fm = new MapFileMonitor(new TrataArquivosFujiFlexaGerandoEventos(log, getIcUpDTOList(), getIc()));
		fm.setRecursive(true);
		
		
		// Debounce 1
		// Garante que o FileMonitor nao seja ativado repetidas vezes seguidas
		// e garante um tempo para o arquivo terminar de ser escrito
		fm.setDelay(1 * 1000);

		setUrlsAMonitorar(fm, fsManager);

		fm.start();

		// Lanca HeartBeats
		TratadorHeartBeat t = new TratadorHeartBeat(getIcUpDTOList(), this);
		t.setName("monitoraHeartBeatFuji");
		addTratadorHeartBeat(t);
		t.start();
	}
	
	void setUrlsAMonitorar(MapFileMonitor fm, FileSystemManager fsManager) {
		// Informa ao watcher todos os arquivos a serem monitorizados
		// for (String caminho : getCaminhos()) {
		for (String caminho : caminhos) {
			FileObject listendir = null;
			try {
				listendir = fsManager.resolveFile(caminho);
			} catch (FileSystemException e) {
				e.printStackTrace();
				log.info(e);
			}
			fm.addFile(listendir);
		}
	}

}

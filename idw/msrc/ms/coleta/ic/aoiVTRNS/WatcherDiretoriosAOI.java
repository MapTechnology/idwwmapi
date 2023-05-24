package ms.coleta.ic.aoiVTRNS;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class WatcherDiretoriosAOI extends Thread{
	
	private final IdwLogger log;
	private final int idLog;
	
	private WatchService watcher = null;
	private final Map<WatchKey, Path> keys;
	
	private boolean isExecutandoWatcher = true;

	private IcUpDTO icup;
	
	private final Path dir;
	private final TratadorArquivos tratador;
	
	// public WatcherDiretoriosAOI(IcUpDTO icup, Path dir, boolean isIncluirSubdiretorios, AbstractWatcherTrigger rn, IdwLogger log, int idLog) throws ServicoFalhouException{
	public WatcherDiretoriosAOI(IcUpDTO icup, Path dir, IdwLogger log, int idLog, TratadorArquivos tratador) throws ServicoFalhouException{
		super();

		this.keys = new HashMap<WatchKey, Path>();
		this.icup = icup;
		this.log = log;
		this.idLog = idLog;

		this.icup = icup;
		this.dir = dir;
		
		this.tratador = tratador;
		
		try {
			this.watcher = FileSystems.getDefault().newWatchService();
			register(dir);
		} catch (Exception e) {
			try {
				if (this.watcher != null)
					this.watcher.close();
			} catch (Exception e1) {
			}
			throw new ServicoFalhouException(e);
		}
		log.info(idLog, 0, "fim do registro de diretorios");
		
	}
	
	// Registra apenas o diretorio principal
	private void register(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		log.info(idLog, 0, "Para UP " + icup.getUpDTO().getCd_up() + " registrando diretorio " + dir.toString());
		keys.put(key, dir);
	}
	
	@Override
	public void run() {
		
		while (isExecutandoWatcher) {
			// wait for key to be signalled
			WatchKey key;
			try {
				if (keys.values().isEmpty()) {
					log.info(idLog, 0, "Nenhum arquivo sendo ouvido");
					// Nesse caso devemos registrar novamente o diretorio
					log.info("tentando recuperar watcher do arquivo " + dir.toString());
					try {
						register(dir);
					} catch (IOException e) {
						log.info("Excessao", e);
						e.printStackTrace();
						UtilsThreads.pausaNaThread(10000);
						continue;
					}

				} else {
					log.info(idLog, 0, "Esperando alteração no arquivo");
				}
				// for (Path kaux : keys.values()) {
				// log.info("ouvindo " + kaux.toString());
				// }
				key = watcher.take();
			} catch (Exception x) {
				log.info(idLog, 0, "Erro", x);
				x.printStackTrace();
				return;
			}
			
			// validacao
			Path dir = keys.get(key);
			if (dir == null) {
				log.info("dir == null, continue");
				continue;
			}
			
			// A pausa abaixo previne o mesmo arquivo ser detectado duas vezes. Uma para o conteudo modificado outra pela data
			UtilsThreads.pausaNaThread(50);
			
			List<WatchEvent<?>> eventos = key.pollEvents();
			for (WatchEvent<?> event : eventos) {
				log.info("entrando no for para o poolEvents. Size pollEventos=" + eventos.size());
				WatchEvent.Kind kind = event.kind();

				// TBD - provide example of how OVERFLOW event is handled
				if (kind == StandardWatchEventKinds.OVERFLOW) {
					log.info("ocorreu um overflow");
					continue;
				} 

				// Context for directory entry event is the file name of entry
				WatchEvent<Path> ev = cast(event);
				Path name = ev.context();
				Path child = dir.resolve(name);
				
				if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
					log.info("Arquivo moficado: " + name.toFile().getAbsolutePath());
				} else if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					log.info("Arquivo criado: " + name.toFile().getAbsolutePath());
					continue;
				} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
					log.info("Arquivo deletado: " + name.toFile().getAbsolutePath());
					continue;
				}
				
				// print out event
				log.info("chamando o trataArquivo");
				try {
					//rn.tratarArquivo(event.kind(), child);
					tratador.doJob(child);
				} catch (Exception e) {
					log.info("Excessao", e);
				}
				// So se deve tratar uma aleracao no arquivo por vez
				break;
			} // fim do for
			
			// reset key and remove from set if directory no longer accessible
			boolean valid = key.reset();
			if (!valid) {

				// Nao se pode remover o diretorio, por isso comentei. Se remover deixar de copiar o arquivo
				Path pathASerRemovido = keys.get(key);

				key.cancel();

				keys.remove(key);

				if (pathASerRemovido != null) {
					log.info("tentando recuperar watcher do arquivo " + pathASerRemovido.toString());
					try {
						register(pathASerRemovido);
					} catch (IOException e) {
						log.info("Excessao", e);
						e.printStackTrace();
					}

				} else
					log.info("pathASerRemovido é null");

				// all directories are inaccessible
				if (keys.isEmpty()) {
					continue; // continua no while para ver outros arquivos
				}
			}

			UtilsThreads.pausaNaThread(1000);
		} // fim do while
		
		log.info("saindo do watcher");
	}
	
	@SuppressWarnings("unchecked")
    private static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }

}

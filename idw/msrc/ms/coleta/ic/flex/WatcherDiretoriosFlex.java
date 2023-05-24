package ms.coleta.ic.flex;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

/*
 * @Depracated substituida por ThreadDiretoriosFlex. O watcher em algumas situações não está funcionando adequadamente
 * a) quando o computador tem uma arvore de diretorios muito extensa como é o caso da coleta TX
 * b) em algumas situacoes qdo a arvore é extensa ocorre um erro BIOS
 * 
 * Deixou de ser depracated pois o 5g e 24g ainda usam devido a grande qtde de arquivos. Como
 * em algumas situacoes o watcher nao da erro mas não detecta as mudancas devido a perda de mapeamento
 * alteramos o heartbeat do driver para acessar o arquivo e manter o mapeamento
 */
public class WatcherDiretoriosFlex extends Thread implements IWatcherDiretoriosFlex{

	private final IdwLogger log;
	private final int idLog;
	
	private WatchService watcher = null;
	private final Map<WatchKey, Path> keys;
	private final boolean isIncluirsubdiretorios;
	
	private boolean isExecutandoWatcher = true;
	private final AbstractWatcherTrigger rn;

	private final IcUpDTO icup;
	
	private final Path dir;
	
	public WatcherDiretoriosFlex(IcUpDTO icup, Path dir, boolean isIncluirSubdiretorios, AbstractWatcherTrigger rn, IdwLogger log, int idLog) throws ServicoFalhouException{
		super();
		

		this.keys = new HashMap<WatchKey, Path>();
		this.isIncluirsubdiretorios = isIncluirSubdiretorios;
		this.rn = rn;
		this.icup = icup;
		this.log = log;
		this.idLog = idLog;
		
		this.rn.setIcUpDTO(icup, log, idLog);
		this.dir = dir;
		
		try {
			this.watcher = FileSystems.getDefault().newWatchService();
			
			if (this.isIncluirsubdiretorios) {
				registerAll(dir);
			} else {
				register(dir);
			}
		} catch (Exception e) {
			try {
				if (this.watcher != null)
					this.watcher.close();
				log.error(e);
			} catch (Exception e1) {
			}
			throw new ServicoFalhouException(e);
		}
		setName("WatcherDiretoriosFlex-" + icup.getUpDTO().getCd_up());
		log.info(idLog, 0, "fim do registro de diretorios");
	}

	// Registras todos os subdiretorios
	private void registerAll(final Path start) throws IOException {
		// register directory and sub-directories
		
		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				register(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	// Registra apenas o diretorio principal
	private void register(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		log.info(idLog, 0, "Para UP " + icup.getUpDTO().getCd_up() + " registrando diretorio " + dir.toString());
		keys.put(key, dir);
	}

	// Metodo princpal para tratamento do arquivo
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
					log.info(idLog, 0, "Esperando alteração no arquivo " + dir.toString());
				}
//				for (Path kaux : keys.values()) {
//					log.info("ouvindo " + kaux.toString());
//				}
				key = watcher.take();
			} catch (Exception x) {
				log.info(idLog, 0, "Erro", x);
				x.printStackTrace();
				return;
			}

			Path dir = keys.get(key);
			if (dir == null) {
				log.info("dir == null, continue");
				continue;
			}
			log.info(idLog, 0, "Arquivo alterado no " + dir);
			// A pausa abaixo previne o mesmo arquivo ser detectado duas vezes. Uma para o conteudo modificado outra pela data
			UtilsThreads.pausaNaThread(50);
			
			List<WatchEvent<?>> eventos = key.pollEvents();
			if (eventos.isEmpty()) {
				log.info(idLog, 0, "pool de eventos vazio");
			}
			for (WatchEvent<?> event : eventos) {
				log.info(idLog, 0, "entrando no for para o poolEvents. Size pollEventos=" + eventos.size());
				WatchEvent.Kind<?> kind = event.kind();

				// TBD - provide example of how OVERFLOW event is handled
				if (kind == StandardWatchEventKinds.OVERFLOW) {
					log.info(idLog, 0, "ocorreu um overflow");
					continue;
				}

				// Context for directory entry event is the file name of entry
				WatchEvent<Path> ev = cast(event);
				Path name = ev.context();
				Path child = dir.resolve(name);

				// print out event
				log.info(idLog, 0, "chamando o trataArquivo " + name.getFileName().toString());
				
				
				if (child == null)
					log.info(idLog, 0, "child null para name = " + name + " and dir=" + dir);
				else
					log.info(idLog, 0, child.toString());
				
				try {
					rn.tratarArquivo(event.kind(), child.toString());
				} catch (Exception e) {
					log.info(idLog, 0, "Excessao watcherDiretorioFlex", e);
				}
				// if directory is created, and watching recursively, then
				// register it and its sub-directories
				if (this.isIncluirsubdiretorios && (kind == StandardWatchEventKinds.ENTRY_CREATE)) {
					try {
						if (Files.isDirectory(child, LinkOption.NOFOLLOW_LINKS)) {
							registerAll(child);
						}
					} catch (IOException x) {
						// ignore to keep sample readbale
						log.info(idLog, 0, "Excessao io", x);
					}
				}
			}
			log.info(idLog, 0, "fim do for");

			// reset key and remove from set if directory no longer accessible
			boolean valid = key.reset();
			if (!valid) {
				
				// Nao se pode remover o diretorio, por isso comentei. Se remover deixar d ecopiar o arquivo
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
		}
		log.info(idLog, 0, "saindo do watcher");
	}

	
	@SuppressWarnings("unchecked")
    private static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }

	public void finalizarWatcher() {
		log.info(idLog, 0, "Finalizando Watcher");
		isExecutandoWatcher = false;
		// cancelando os watchers
		for (WatchKey chave : keys.keySet()) {
			chave.cancel();
		}
		try {
			watcher.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(idLog, 0, "Watcher finalizado");
	}
}

package ms.coleta.ic.flex;

import java.io.IOException;
import java.net.MalformedURLException;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import jcifs.CIFSContext;
import jcifs.FileNotifyInformation;
import jcifs.SmbWatchHandle;
import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

/**
 * @author Ailton
 *
 */
public class WatcherADFlex extends Thread implements IWatcherDiretoriosFlex{
	//private int timeout = 30;
	private int timeout = 15;
	//private int timeout = 2;
	private final IdwLogger log;
	private final int idLog;
	
	private SmbFile root;
	//private WatchService watcher = null;
	private SmbWatchHandle watcher = null;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private Future <List<FileNotifyInformation>> future = null;
	private boolean isConectado = true;
	
	private final boolean isIncluirsubdiretorios;
	
	private boolean isExecutandoWatcher = true;
	private final AbstractWatcherTrigger rn;

	private final IcUpDTO icup;
	
	private final String dir;
	
	public WatcherADFlex(IcUpDTO icup, String dir, boolean isIncluirSubdiretorios, AbstractWatcherTrigger rn, IdwLogger log, int idLog) throws ServicoFalhouException{
		super();
		this.isIncluirsubdiretorios = isIncluirSubdiretorios;
		this.rn = rn;
		this.icup = icup;
		this.log = log;
		this.idLog = idLog;
		this.rn.setIcUpDTO(icup, log, idLog);
		
		String url = ArquivosDiretorios.ajustaPathSMB(dir.toString());
		if (!url.endsWith("/"))
			url = url + "/";
		this.dir = url;
		
		
		CIFSContext base = SingletonContext.getInstance();
		CIFSContext authed1 = base.withCredentials(new NtlmPasswordAuthenticator(icup.getIc().getLoginAD(), icup.getIc().getSernhaAD()));
		 
		try {
			root = new SmbFile(this.dir.toString(), authed1);
			
			watcher = root.watch(
					 FileNotifyInformation.FILE_NOTIFY_CHANGE_FILE_NAME 
					 | FileNotifyInformation.FILE_NOTIFY_CHANGE_ATTRIBUTES 
					 | FileNotifyInformation.FILE_NOTIFY_CHANGE_LAST_WRITE
					 | FileNotifyInformation.FILE_NOTIFY_CHANGE_DIR_NAME
					 , isIncluirSubdiretorios);
			
		} catch (SmbException e) {
			log.error("Excecao SmbException ao inicializar watcher: " + icup.getIc().getCd_ic() + " "+ e.toString());
			isConectado = false;
		} catch (Exception e) {
			log.error("Excecao ao inicializar watcher: " + icup.getIc().getCd_ic() + " "+ e.toString());
			e.printStackTrace();
			isConectado = false;
		}

		log.info(idLog, 0, "fim do registro de diretorios");
	}
	
	private void setupWatch () throws Exception {
		boolean canceled = false;
		if ( future != null ) {
			canceled = future.cancel(true);
		}
		future = executor.submit(watcher);

		Thread.sleep(1000);
	}
	
		// Metodo princpal para tratamento do arquivo
		@Override
		public void run() {
			List<FileNotifyInformation> notifications = null;
			Map<String, Date> ultimosFileNamesVerificados = new HashMap<String, Date>();
			Thread.currentThread().setName("WactherADFlex-" + icup.getUpDTO().getCd_up());
			// Inicia o watcher
			try {
				setupWatch ();
			} catch (Exception e1) {
				log.error(String.format("Erro ao executar setupWatch() na thread %s", "WactherADFlex-" + icup.getUpDTO().getCd_up()));
				log.info(idLog, 0, "Excecao ocorrida: ", e1);
				isConectado = false;
				isExecutandoWatcher = false;
			}
			
			while (isExecutandoWatcher) {
				// wait for a notification to be signalled
				try {
					log.info(idLog, 0, "Aguardando modificacao no " + dir);
					notifications = future.get(timeout, TimeUnit.MINUTES);
					//notifications.addAll(future.get(timeout, TimeUnit.MINUTES));
					setupWatch();
				} catch (Exception x) {
					log.error(String.format("Erro ao obter o notifications na thread %s", "WactherADFlex-" + icup.getUpDTO().getCd_up()));
					log.info(idLog, 0, "Excecao ocorrida: ", x);
					isConectado = false;
					isExecutandoWatcher = false;
					break;
				}
				isConectado = true;
				
				log.info(idLog, 0, "Arquivos alterados no dir = " + dir);
				log.info(idLog, 0, "entrando no for para o notifications. Size notifications=" + notifications.size());
				for (FileNotifyInformation fi : notifications ) {
					int kind = fi.getAction();
					if (kind == 2 && kind == 1) {
						log.info(idLog, 0, "Arquivo "+ fi.getFileName() +" ignorado por kind == 2 (arquivo excluido) || kind == 1 (arquivo criado)");
						continue;
					}
					
					if (ultimosFileNamesVerificados.containsKey(fi.getFileName())) {
						Date dataAtual = new Date();
						Date dataUltimaVerificacao = ultimosFileNamesVerificados.get(fi.getFileName());
						long difference = dataAtual.getTime() - dataUltimaVerificacao.getTime();
						if (difference < 10000) { // se a diferenca entre datas for menor que 10s
							log.info(idLog, 0, fi.getFileName() + " ja foi tratado no loop atual de notificacoes. dataUltimaVerificacao= " 
									+ dataUltimaVerificacao + " dataAtual= " + dataAtual);
							continue;
						}
					}
					String child = root.getPath() + "//" + fi.getFileName();
					log.info(idLog, 0, "chamando o trataArquivo " + child);
					try {
						// kind = 3; arquivo modificado
						// kind = 2; arquivo excluido
						// kind = 1; arquivo criado
						log.info(idLog, 0, "rn.tratarArquivo(" + kind + ", " + child + ");");
						if (ultimosFileNamesVerificados.size() > 50)
							ultimosFileNamesVerificados = new HashMap<String, Date>();
						rn.tratarArquivo(kind, child, icup);
						ultimosFileNamesVerificados.put(fi.getFileName(), new Date());
					} catch (Exception e) {
						log.info(idLog, 0, "Excessao na secao do rn.tratarArquivo do watcherDiretorioFlex", e);
					}
			    }
				log.info(idLog, 0, "fim do for");
				UtilsThreads.pausaNaThread(1000);
			}
			log.info(idLog, 0, "saindo do watcher");
		}
		

		public void finalizarWatcher() {
			log.info(idLog, 0, "Finalizando Watcher");
			isExecutandoWatcher = false;
			// cancelando os watchers
			try {
				if (watcher != null)
					watcher.close();
				
				if (executor != null)
					//executor.shutdown();
					shutdownAndAwaitTermination(executor);
				if (future != null )
	                future.cancel(true);
				log.info(idLog, 0, "Watcher finalizado");
			} catch (Exception e) {
				Date date = new Date();
				log.error(String.format("Erro ao finalizar o o watcher da thread %s", "WactherADFlex-" + icup.getUpDTO().getCd_up()));
				System.out.println(String.format("%s - Erro ao finalizar o o watcher da thread %s", date.toLocaleString(), "WactherADFlex-" + icup.getUpDTO().getCd_up()));
				e.printStackTrace();
			}
		}
		
		// https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
		void shutdownAndAwaitTermination(ExecutorService pool) {
			pool.shutdown(); // Disable new tasks from being submitted
			try {
				// Wait a while for existing tasks to terminate
				if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
					pool.shutdownNow(); // Cancel currently executing tasks
					// Wait a while for tasks to respond to being cancelled
					if (!pool.awaitTermination(60, TimeUnit.SECONDS))
						System.err.println("Pool did not terminate");
				}
			} catch (InterruptedException ie) {
				// (Re-)Cancel if current thread also interrupted
				pool.shutdownNow();
				// Preserve interrupt status
				Thread.currentThread().interrupt();
			}
		}

		public boolean isConectado() {
			return isConectado;
		}

		public void setConectado(boolean isConectado) {
			this.isConectado = isConectado;
		}

}

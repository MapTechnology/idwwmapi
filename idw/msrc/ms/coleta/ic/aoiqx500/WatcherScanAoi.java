package ms.coleta.ic.aoiqx500;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;


public class WatcherScanAoi extends Thread  {
	
	private final IdwLogger log;
	private final int idLog;
	private boolean isExecutandoWatcher = true;
	private IcUpDTO icUp;
	private BufferedEventos bufferEventos;
	private String urlConexao;
	private Date ultimaLeitura;
	
	
	
	public WatcherScanAoi(IdwLogger log, int idLog, IcUpDTO icup, String urlConexao ){
		
		this.log = log;
		this.idLog = idLog;
		this.icUp = icup;
		this.urlConexao = urlConexao;
		this.ultimaLeitura = new Date(System.currentTimeMillis());
		
		
	}
	
	@Override
	public void run(){				
						
		while(isExecutandoWatcher){
				
			File diretorio = new File(urlConexao);
			File[] listaArquivos = diretorio.listFiles();	
			
			//Arrays.sort(listaArquivos);
			
			String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
			diretorioDestino += "ColetaAoiQX500/";
			//Path pathArquivoDestino = Paths.get(diretorioDestino);
			File diretorioServidor = new File(diretorioDestino);
			
			if(!diretorioServidor.exists()){
				diretorioServidor.mkdirs();
			}
			log.info("Iniciando a varredura de arquivos no diretório: " + urlConexao);
			for(File arquivo:listaArquivos){
				String destino = diretorioDestino + arquivo.getName();
				Path pathArquivoDestino = Paths.get(destino);
				try{Files.copy(arquivo.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
				if(arquivo.delete()){
					log.info("Arquivo " + arquivo.getName() + " foi deletado");
				}else 
					log.info("Arquivo " + arquivo.getName() + " NÃO foi deletado");
				
				}catch(Exception e){
					log.info("Erro ao copiar o arquivo " + arquivo.getName()+ ", " + e);
				}
			}
						
			listaArquivos = diretorioServidor.listFiles();
			try{	
															
				for(File arquivo:listaArquivos){
					
					
					
					TrataArquivoRNAoi rn = new TrataArquivoRNAoi(
							arquivo.getParent().toString(),
							icUp,
							ColetaFileType.MITRASTAR_24G,
							log,
							idLog);	
					Boolean delFile = false;
					try {
						rn.setBufferEvento(this.bufferEventos);
						delFile = rn.processaUmArquivoDaMaquina(arquivo);
						if(delFile){											
							if(arquivo.delete()){
								log.info("Arquivo " + arquivo.getName() + " foi deletado no servidor");
							}else log.info("Arquivo " + arquivo.getName() + " NÃO foi deletado no servidor");
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.info("WatcherScanAoi: Erro ao processar um arquivo, " + e);
					
					}
				}
				//Tentativa de controle de leitura por data	
				//ultimaLeitura = new Date(listaArquivos[listaArquivos.length-1].lastModified());							
						
				
				log.info("Varredura finalizada. Pausa de 20 segundos");
				UtilsThreads.pausaNaThread(20000);
				
			
							
			}catch(Exception e){
				e.printStackTrace();
				log.info("Erro no tratamento de dados. Exceção em WatcherScan: " + e);
			}
					
		}
		
	}
	
	public void setBufferedEventos(BufferedEventos bev) {
		this.bufferEventos = bev;
	}
	
	public void finalizaWatcher(){
		this.isExecutandoWatcher = false;
		log.info("Parando a execução do watcher");		
		
	}
	
		

	
	
	
	
}

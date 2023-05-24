package ms.coleta.ic.sony.bd;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivoGerandoEventosBD implements FileListener {

	private ICSony ic;
	
	// private TCopiaArquivoBD tCopiaArquivo;
	private List<IcUpDTO> icUpDTOList;

	private IdwLogger log;
	
	// Controle
	boolean podeProcessar = true;
	// long tempoDebounce = 2 * 60 * 1000;
	long tempoDebounce = 1 * 60 * 1000;
	//long tempoDebounce =  1000;
	private Map<String, Thread> execucoesThreads = new HashMap<>();
	
	
	// long tempoEntreExecucoes = 6 * 60 * 1000;
	// private Map<String, Date> execucoes = new HashMap<>();
	

	// Construtor
	public TrataArquivoGerandoEventosBD(IdwLogger log, List<IcUpDTO> icUpDTOList, ICSony ic) {
		super();
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
	}
	
	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo criado=" + arg0.getFile().getName().getBaseName());
		gerenteExecucao (arg0);
	}

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo modificado=" + arg0.getFile().getName().getBaseName());		
		gerenteExecucao (arg0);

	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo excluido=" + arg0.getFile().getName().getBaseName());
		
		for (String caminhos : ic.getWatcher().getCaminhos()) {

			File arquivo = new File(arg0.getFile().getName().getPath());
			String absolutePath = arquivo.getAbsolutePath();
			// if (arg0.getFile().getName().getBaseName().equals("LinkSimbolicoWrapper")) {
			// if (caminhos.replace("\\","/").contains(arg0.getFile().getName().getPath())) {
			if (caminhos.equals(absolutePath)) {
				// File removedFile = new File(arg0.getFile().getName().getPath());
				// removedFile.mkdirs();

				FileSystemManager fsManager = null;
				try {
					fsManager = VFS.getManager();
				} catch (FileSystemException e) {
					log.error("TrataArquivoGerandoEventosBD: excecao ao obter fsManager: ", e);
					e.printStackTrace();
				}
				FileObject listendir = null;
				// Removendo todos os diretorio monitorados
				for (String caminho : ic.getWatcher().getCaminhos()) {
					try {
						listendir = fsManager.resolveFile(caminho);
					} catch (FileSystemException e) {
						e.printStackTrace();
						log.info("TrataArquivoGerandoEventosBD: ", e);
					}
					ic.getWatcher().getFm().removeFile(listendir);
					try {
						File removedFile = new File(caminho);
						removedFile.mkdirs();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("TrataArquivoGerandoEventosBD: nao foi possivel criar diretorios excluidos - " 
								+ e.toString());
					}
				}

				// Thread para reinserir diretorios monitorados
				Thread t = new Thread() {
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						FileSystemManager fsManager = null;
						try {
							fsManager = VFS.getManager();
						} catch (FileSystemException e) {
							log.info("TrataArquivoGerandoEventosBD: excecao ao obter fsManager: ", e);
							e.printStackTrace();
						}
						log.info("Reinserindo os diretorios a serem monitorados");
						FileObject listendir = null;
						for (String caminho : ic.getWatcher().getCaminhos()) {
							try {
								listendir = fsManager.resolveFile(caminho);
							} catch (FileSystemException e) {
								e.printStackTrace();
								log.info("TrataArquivoGerandoEventosBD: ", e);
							}
							ic.getWatcher().getFm().addFile(listendir);
						}
					}
				};
				t.start();
				break;
			}
		}
	}

	
	private void criaDiretorioSeNaoExistir(String urlDiretorio) {
		File dir = new File(urlDiretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	/**
	 * Faz o debouncer para que o arquivo so seja tratado depois de ser totalmente 
	 * tratado pela coleta. O debouncer e feito por estado da Thread
	 * @param arg0
	 */
	private void gerenteExecucao (final FileChangeEvent arg0) {
		String caminhoArquivo = arg0.getFile().getName().getPath();
		boolean executar = false;
		
		if (!deveTratarArquivo(arg0))
			return;
		
		Thread t = new Thread() {
		    public void run() {
		    	doJob(arg0);
		    }
		};
		
		if (execucoesThreads.containsKey(caminhoArquivo)) {
			// Checa se a thread esta morta, caso positivo, permite o tratamento do arquivo
			if (!execucoesThreads.get(caminhoArquivo).isAlive()) {
				executar = true;
				execucoesThreads.put(caminhoArquivo, t);
			}
		}
		else {
			executar = true;
			execucoesThreads.put(caminhoArquivo, t);
		}
			
		if (executar) {
			executar = false;
			t.setName("doJob " + caminhoArquivo.toLowerCase());
			t.start();
		}
		
	}
	
	private boolean deveTratarArquivo(FileChangeEvent arg0) {
		if (arg0.getFile().getName().getExtension().equals("csv"))	 {
			return true;
		}
		return false;
	}
	
	private void doJob(FileChangeEvent arg0) {
		// Quando um arquivo for criado/modificado no diretorio,
		// Realiza a copia do arquivo e o tratamento dele
		
		// Debouncer 2
		// Espera pelo fim da escrita do arquivo antes de trata-lo
		try {
			Thread.sleep(tempoDebounce);
		} catch (InterruptedException ex) {
			System.out.println("Erro ao dar sleep na thread\n");
		}

		// Validacao 1
		// Tratar apenas se for um arquivo .csv
		// if (!arg0.getFile().getName().getExtension().equals("csv"))
		if (!deveTratarArquivo(arg0))
			return;

		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
		File arquivo = new File(arg0.getFile().getName().getPath());
		String absolutePath = arquivo.getAbsolutePath();
		String pathTratado = Paths.get(absolutePath).getParent().toString();

		// Pesquisa o icupDTO a partir da url de conexao
		// que é o diretorio pai do arquivo que teve modificacao/criacao
		IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(pathTratado);

		if (icUpDTO != null) {
			String nomeMaquina = icUpDTO.getUpDTO().getCd_up();
			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
			// Prepara o diretorio onde vao ficar as copias dos logs
			String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
			diretorioDestino += "//ColetaSony//";
			criaDiretorioSeNaoExistir(diretorioDestino);
			log.info("urlDiretorio " + diretorioDestino);
			// -------
			 TCopiaArquivoBD tCopiaArquivo = new TCopiaArquivoBD(nomeMaquina, diretorioDestino, log, ic);

			// Copia e carrega o arquivo na memoria
			// ArquivoSony é uma classe abstract
			// Dependendo do tipo do arquivo tratada um ArquivoSony diferente
			// e retornado
			ArquivoSony arquivoCopia = tCopiaArquivo.doJob(arquivo);
			
			// Antes de realizar esse tratamento, e necessario processar o arquivo downtime
			ArquivoSony arquivoCopiaTDOWNTIME = tCopiaArquivo.doJob("TDOWNTIME", arquivo);
			
			List<EventoColetado> eventosParada = null;
			if (arquivoCopiaTDOWNTIME != null) {
				arquivoCopiaTDOWNTIME.setIcUpDTO(icUpDTO);
				eventosParada = arquivoCopiaTDOWNTIME.obtemEvento(ic);
			}

			// Trata as linhas do arquivo copiado
			if (arquivoCopia != null) {
				arquivoCopia.setIcUpDTO(icUpDTO);
				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
				List<EventoColetado> eventosIntermediarios = new ArrayList<>();
				
				if (eventosParada != null)
					eventosIntermediarios.addAll(eventosParada);
				if (eventos != null)
					eventosIntermediarios.addAll(eventos);
				
				ic.getBufferEventos().addEventos(ordenaEventos(eventosIntermediarios));
			} else {
				log.error("TrataArquivoGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
			}
		} else {
			log.error("TrataArquivoGerandoEventos: ICUPDTO == null");
		}
		
	}
	
	private List<EventoColetado>  ordenaEventos(List<EventoColetado> eventosIntermediarios) {
		List<EventoColetado> retorno = eventosIntermediarios;
		// Ordenacao
		Collections.sort(retorno, new Comparator<EventoColetado>() {
			@Override
			public int compare(EventoColetado o1, EventoColetado o2) {
				int comparacao = o1.getDthrEvento().compareTo(o2.getDthrEvento());
				return comparacao;
			}
		});
		return retorno;
		
	}

	private IcUpDTO getIcUpDTOFromUrlConexao(String urlConexao) {
		for (IcUpDTO icUpDTOAux : icUpDTOList) {
			if (icUpDTOAux.getUrlConexao().equals(urlConexao)) {
				return icUpDTOAux;
			}
		}
		return null;
	}
	
	
	// ***************** LEGADO OU METODOS NAO MAIS UTILZIADOS ************************
	
	/**
	 * Faz o debouncer para que o arquivo so seja tratado depois de ser totalmente copiado
	 * pelo script da Sony. O debouncer e feito por data
	 * @param arg0
	 */
//	private void gerenteExecucao (final FileChangeEvent arg0) {
//		String caminhoArquivo = arg0.getFile().getName().getPath();
//		Date date = new Date();
//		boolean executar = false;
//		
//		if (execucoes.containsKey(caminhoArquivo)) {
//			// Checa se esta na hora de tratar o arquivo novamente
//			if (execucoes.get(caminhoArquivo).compareTo(date) < 0) {
//				if ( (date.getTime() - execucoes.get(caminhoArquivo).getTime()) >= tempoEntreExecucoes) {
//					executar = true;
//					execucoes.put(caminhoArquivo, date);
//				}
//			}
//		}
//		else {
//			executar = true;
//			execucoes.put(caminhoArquivo, date);
//		}
//			
//		if (executar) {
//			executar = false;
//			
//			Thread t = new Thread() {
//			    public void run() {
//			    	doJob(arg0);
//			    }
//			};
//			t.setName(caminhoArquivo);
//			t.start();
//		}
//	}
	
	
}

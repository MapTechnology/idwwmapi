package ms.coleta.ic.juki.errlog;

import idw.util.IdwLogger;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.coleta.ic.juki.ArquivoJuki;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.juki.TCopiaArquivo;
import ms.coleta.ic.juki.juki00.TCopiaArquivoJuki00;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;


public class TrataArquivoErrLogGerandoEventos implements FileListener {
	// Prerequisitos
	private ICJuki ic;
	private List<IcUpDTO> icUpDTOList;
	
	// Log
	private IdwLogger log;
	
	// Controle
	// long tempoDebounce = 1 * 10 * 1000; //10s
	long tempoDebounce =  2 * 1000; //2s
	private Map<String, Thread> execucoesThreads = new HashMap<>();

	public TrataArquivoErrLogGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICJuki ic) {
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
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo apagado=" + arg0.getFile().getName().getBaseName());
		
		if (!deveTratarArquivo(arg0)) {
			return;
		}
		
		for (String caminhos : ic.getWatcherErrLog().getCaminhos()) {

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
					log.info("JukiWatcherErrLog: excecao ao obter fsManager: ", e);
					e.printStackTrace();
				}
				FileObject listendir = null;
				// Removendo todos os diretorio monitorados
				for (String caminho : ic.getWatcherErrLog().getCaminhos()) {
					try {
						listendir = fsManager.resolveFile(caminho);
					} catch (FileSystemException e) {
						e.printStackTrace();
						log.info("JukiWatcherErrLog: ", e);
					}
					ic.getWatcherErrLog().getFm().removeFile(listendir);
					File removedFile = new File(caminho);
					removedFile.mkdirs();
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
							log.info("JukiWatcherErrLog: excecao ao obter fsManager: ", e);
							e.printStackTrace();
						}
						log.info("Reinserindo os diretorios a serem monitorados");
						FileObject listendir = null;
						for (String caminho : ic.getWatcherErrLog().getCaminhos()) {
							try {
								listendir = fsManager.resolveFile(caminho);
							} catch (FileSystemException e) {
								e.printStackTrace();
								log.info("JukiWatcherErrLog: ", e);
							}
							ic.getWatcherErrLog().getFm().addFile(listendir);
						}
					}
				};
				t.start();
				break;
			}
		}
	}

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo modificado=" + arg0.getFile().getName().getBaseName());
		gerenteExecucao (arg0);
	}

	private boolean deveTratarArquivo(FileChangeEvent arg0) {
		if (!arg0.getFile().getName().toString().contains("ErrLog")
				&& !arg0.getFile().getName().toString().contains("Juki.00")) {
			return false;
		}
		return true;
	}
	/**
	 * Faz o debouncer para que o arquivo so seja tratado depois de ser totalmente 
	 * tratado pela coleta. O debouncer e feito por estado da Thread
	 * @param arg0
	 */
	private void gerenteExecucao (final FileChangeEvent arg0) {
		String caminhoArquivo = arg0.getFile().getName().getPath();
		boolean executar = false;

		// Validacao 1
		// Tratar apenas se for um arquivo relacionado a ErrLog ou Juki.00
//		if (!arg0.getFile().getName().toString().contains("ErrLog")
//				&& !arg0.getFile().getName().toString().contains("Juki.00")) {
//			return;
//		}
		if (!deveTratarArquivo(arg0)) {
			return;
		}
			
		
		Thread t = new Thread() {
		    public void run() {
		    	doJob(arg0);
		    }
		};
		
		if (execucoesThreads.containsKey(caminhoArquivo)) {
			// Checa se a thread esta morta, caso positivo, permite o tratamento do arquivo
			if (!execucoesThreads.get(caminhoArquivo).isAlive()) {
				executar = true;
			}
		}
		else {
			executar = true;
		}
			
		if (executar) {
			executar = false;
			t.setName("doJob " + caminhoArquivo.toLowerCase());
			execucoesThreads.put(caminhoArquivo, t);
			t.start();
		}
		
	}
	
	/**
	 * Quando um arquivo e modificado ou criado,
	 * se for um que devem ser monitorados, faz uma
	 * copia e tratamento do mesmo
	 * @param arg0
	 */
	private void doJob(FileChangeEvent arg0) {
		// Validacao 2
		// Tratar apenas se for um arquivo ErrLog.txt
		if (!arg0.getFile().getName().toString().contains("ErrLog.txt")
				// && !arg0.getFile().getName().toString().contains("Juki.00"))
				// Segundo o documento KE-2050_2060_Troubleshooting_E_Rev02
				// os arquivos Juki.00 sao reescritos quando acontece mudanca
				// de OP a partir do Juki.0001
				&& !arg0.getFile().getName().toString().contains("Juki.0001"))
			return;
					
		// Debouncer
		// Espera pelo fim da escrita do arquivo antes de trata-lo
		try {
			Thread.sleep(tempoDebounce);
		} catch (InterruptedException ex) {
			log.error("TrataArquivoErrLogGerandoEventos.doJob(): "
					+ "Erro ao dar sleep na thread\n");
		}

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
			diretorioDestino += "//ColetaJuki//";
			criaDiretorioSeNaoExistir(diretorioDestino);
			log.info("urlDiretorio " + diretorioDestino);
			// -------
			TCopiaArquivo tCopiaArquivo = null;
			if (arg0.getFile().getName().toString().contains("ErrLog.txt")) {
				tCopiaArquivo = new TCopiaArquivoErrLog(nomeMaquina, diretorioDestino, log);
			} else {
				tCopiaArquivo = new TCopiaArquivoJuki00(nomeMaquina, diretorioDestino, log, ic);
			}
			
			// Copia e carrega o arquivo na memoria
			ArquivoJuki arquivoCopia = tCopiaArquivo.doJob(arquivo);
			
			// Trata as linhas do arquivo copiado
			if (arquivoCopia != null) {
				arquivoCopia.setIcUpDTO(icUpDTO);
				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
				if (eventos != null)				
					ic.getBufferEventos().addEventos(ordenaEventos(eventos));
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
			//if (icUpDTOAux.getUrlConexao().equals(urlConexao)) {
			if (urlConexao.contains(icUpDTOAux.getUrlConexao())) {
				return icUpDTOAux;
			}
		}
		return null;
	}
	
	private void criaDiretorioSeNaoExistir(String urlDiretorio) {
		File dir = new File(urlDiretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
}// Fim da classe

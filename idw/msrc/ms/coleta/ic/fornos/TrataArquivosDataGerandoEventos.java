package ms.coleta.ic.fornos;

import java.io.File;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.TCopiaArquivo;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivosDataGerandoEventos implements FileListener{
	
	// Prerequisitos
	private ICForno ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;
	
	private Map<String, TratadorLog> execucoesThreads = new HashMap<>();
	
	// Usado para se obter o ano corrente fazer a validacao dos arquivos a serem tratados
	// Ailton 2018-08-17 instanciar o calendar aqui trazia um erro
	// a data do calenda era sempre a de quando a coleta iniciava 
	// Assim, antes de ser utilizado, ele deve ser atualizado
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	public TrataArquivosDataGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICForno ic) {
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
	}

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo modificado=" + arg0.getFile().getName().getBaseName());		
		gerenteExecucao (arg0);
	}

	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo criado=" + arg0.getFile().getName().getBaseName());		
		gerenteExecucao (arg0);
	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
		log.info("Arquivo apagado=" + arg0.getFile().getName().getBaseName());	
		
		for (String caminhos : ic.getFornoWatcher().getCaminhos()) {

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
				for (String caminho : ic.getFornoWatcher().getCaminhos()) {
					try {
						listendir = fsManager.resolveFile(caminho);
					} catch (FileSystemException e) {
						e.printStackTrace();
						log.info("TrataArquivoDataGerandoEventos: ", e);
					}
					ic.getFornoWatcher().getFm().removeFile(listendir);
					try {
						File removedFile = new File(caminho);
						//removedFile.mkdirs();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("TrataArquivoDataGerandoEventos: nao foi possivel criar diretorios excluidos - " 
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
							log.info("TrataArquivoDataGerandoEventos: excecao ao obter fsManager: ", e);
							e.printStackTrace();
						}
						log.info("Reinserindo os diretorios a serem monitorados");
						FileObject listendir = null;
						for (String caminho : ic.getFornoWatcher().getCaminhos()) {
							try {
								listendir = fsManager.resolveFile(caminho);
							} catch (FileSystemException e) {
								e.printStackTrace();
								log.info("TrataArquivoDataGerandoEventos: ", e);
							}
							ic.getFornoWatcher().getFm().addFile(listendir);
						}
					}
				};
				t.start();
				break;
			}
		}
	}
	
	private void gerenteExecucao (final FileChangeEvent arg0) {
		String caminhoArquivo = arg0.getFile().getName().getPath();
		boolean executar = false;
		
		if(!deveTratarArquivo(arg0)) {
			log.info("!deveTratarArquivo(arg0) retornou false para: " + caminhoArquivo);
			return;
		}
		
		TratadorLog tratador = new TratadorLog(log, icUpDTOList, ic, arg0, "doJob " + caminhoArquivo.toLowerCase());
		
		if (execucoesThreads.containsKey(caminhoArquivo)) {
			// Checa se a thread esta morta, caso positivo, permite o tratamento do arquivo
			if (execucoesThreads.get(caminhoArquivo).isTerminated()) {
				executar = true;
				execucoesThreads.put(caminhoArquivo, tratador);
			}
		} else {
			executar = true;
			execucoesThreads.put(caminhoArquivo, tratador);
		}
			
		if (executar) {
			executar = false;
			ic.getExecutor().execute(tratador);
		}	
	}
	
	private boolean deveTratarArquivo(FileChangeEvent arg0) {
		// Validacao 1
		// Tratar apenas se for um arquivo MCRELOAD
		// if (arg0.getFile().getName().toString().contains("data"))
		Formatter fmt = new Formatter(Locale.ENGLISH);
	    fmt.format("%tb", calendar);
	    String shortNameMonth = fmt.toString();
	    calendar = Calendar.getInstance(TimeZone.getDefault());
	    // Apr 20 2017 data
		if ((arg0.getFile().getName().getPath().contains(shortNameMonth + " "
				+ calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR) 
    			+ " data.txt")) 
				// Ailton: 2019-02-01
				// Quando dia < 10, calendar.get(Calendar.DAY_OF_MONTH) retorna um numero de 1 digito
				// Ex: 1, 2 ou 3; quando na verdade o esperado e 01, 02, 03; String.format cuida disso
				|| (arg0.getFile().getName().getPath().contains(shortNameMonth + " "
						+ String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) + " " + calendar.get(Calendar.YEAR) 
		    			+ " data.txt")))
			return true;
		return false;
	}

}

class TratadorLog implements Runnable {

	private ICForno ic;
	private List<IcUpDTO> icUpDTOList;
	private IdwLogger log;
	private FileChangeEvent arg0;
	private String name;
	private boolean isTerminated = false;
	
	long tempoDebounce = 2 * 1000; // 2s
	
	
	public TratadorLog (IdwLogger log, List<IcUpDTO> icUpDTOList, ICForno ic, FileChangeEvent arg0, String name) {
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
		this.arg0 = arg0;
		this.name = name;
	}
	
	
	@Override
	public void run() {
		doJob(arg0);
		isTerminated = true;
	}
	
	private void doJob(FileChangeEvent arg0) {
		// Debouncer
		// Espera pelo fim da escrita do arquivo antes de trata-lo
		try {
			Thread.sleep(tempoDebounce);
		} catch (InterruptedException ex) {
			log.error("TrataArquivosDataGerandoEventos.doJob(): "
					+ "Erro ao dar sleep na thread\n");
		}

		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
		File arquivo = new File(arg0.getFile().getName().getPath());
		
		String absolutePath = arquivo.getAbsolutePath();
		String pathTratado = Paths.get(absolutePath).getParent().toString();

		// Pesquisa o icupDTO a partir da url de conexao
		// que é o diretorio pai do arquivo que teve modificacao/criacao
		// IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(pathTratado);
		IcUpDTO icUpDTO = getIcUpDTOFromUrlConexaoLazy(pathTratado);
		if (icUpDTO != null) {
			String nomeMaquina = icUpDTO.getUpDTO().getCd_up();
			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
			// Prepara o diretorio onde vao ficar as copias dos logs
			String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
			diretorioDestino += "//ColetaFornos//";
			criaDiretorioSeNaoExistir(diretorioDestino);
			log.info("urlDiretorio " + diretorioDestino);

			TCopiaArquivoData tCopiaArquivo = new TCopiaArquivoData(nomeMaquina, diretorioDestino, log);
			// Ailton 2018-06-28 e necessario passar o arg0 para que seja feita
			// a resolucao e copia correta do arquivo pela rede
			//ArquivoData arquivoCopia = tCopiaArquivo.doJob(arquivo);
			ArquivoData arquivoCopia = tCopiaArquivo.doJob(arquivo, arg0);
			if (arquivoCopia != null) {
				arquivoCopia.setIcUpDTO(icUpDTO);
				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
				if (eventos != null)
					ic.getBufferEventos().addEventos(ordenaEventos(eventos));
			} else {
				log.error("TrataArquivoDataGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
			}
			
		} else {
			log.error("TrataArquivosDataGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
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

	private IcUpDTO getIcUpDTOFromUrlConexaoLazy(String urlConexao) {
		// Se nao for um caminho do windows, usa a versao tradicional
		if (!urlConexao.contains("\\"))
			return getIcUpDTOFromUrlConexao(urlConexao);
		
//		String[] vetorUrlConexaoResumida = urlConexao.split("\\");
//		String urlConexaoResumida = vetorUrlConexaoResumida[vetorUrlConexaoResumida.length - 1];
		String urlConexaoResumida = new File(urlConexao).getName();
		for (IcUpDTO icUpDTOAux : icUpDTOList) {
			if (icUpDTOAux.getUrlConexao().contains(urlConexaoResumida)) {
				return icUpDTOAux;
			}
		}
		return null;
	}
	private IcUpDTO getIcUpDTOFromUrlConexao(String urlConexao) {
		for (IcUpDTO icUpDTOAux : icUpDTOList) {
			if (icUpDTOAux.getUrlConexao().equals(urlConexao)) {
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isTerminated() {
		return isTerminated;
	}


	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
}

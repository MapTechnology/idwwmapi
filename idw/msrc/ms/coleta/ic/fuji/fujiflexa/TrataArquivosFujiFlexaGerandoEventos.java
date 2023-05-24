package ms.coleta.ic.fuji.fujiflexa;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.ArquivoFuji;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.ic.fuji.TCopiaArquivo;
import ms.coleta.ic.juki.errhist.ArquivoErrHist;
import ms.coleta.ic.juki.errhist.TCopiaArquivoErrHist;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivosFujiFlexaGerandoEventos implements FileListener{
	
	// Prerequisitos
	private ICFuji ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;
	// Controle
	long tempoDebounce = 2 * 1000; // 2s
	// private Map<String, Thread> execucoesThreads = new HashMap<>();
	private Map<String, TratadorLog> execucoesThreads = new HashMap<>();
	
	public TrataArquivosFujiFlexaGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICFuji ic) {
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
	}
	
	/**
	 * Faz o debouncer para que o arquivo so seja tratado depois de ser totalmente 
	 * tratado pela coleta. O debouncer e feito por estado da Thread
	 * @param arg0
	 */
	private void gerenteExecucao (final FileChangeEvent arg0) {
		String caminhoArquivo = arg0.getFile().getName().getPath();
		boolean executar = false;
		
		if(!deveTratarArquivo(arg0))
			return;
		
//		Thread t = new Thread() {
//		    public void run() {
//		    	doJob(arg0);
//		    }
//		};
		TratadorLog tratador = new TratadorLog(log, icUpDTOList, ic, arg0, "doJob " + caminhoArquivo.toLowerCase());
		
		if (execucoesThreads.containsKey(caminhoArquivo)) {
			// Checa se a thread esta morta, caso positivo, permite o tratamento do arquivo
			if (execucoesThreads.get(caminhoArquivo).isTerminated()) {
				executar = true;
				execucoesThreads.put(caminhoArquivo, tratador);
			}
		}
		else {
			executar = true;
			execucoesThreads.put(caminhoArquivo, tratador);
		}
			
		if (executar) {
			executar = false;
			ic.getExecutor().execute(tratador);
//			t.setName("doJob " + caminhoArquivo.toLowerCase());
//			t.start();
		}
		
	}
	
	private boolean deveTratarArquivo(FileChangeEvent arg0) {
		// Validacao 1
		// Tratar apenas se for um arquivo MCRELOAD
		if (arg0.getFile().getName().toString().contains("MCRELOAD"))
			return true;
		return false;
	}
	
//	private void doJob(FileChangeEvent arg0) {
//		// Debouncer
//		// Espera pelo fim da escrita do arquivo antes de trata-lo
//		try {
//			Thread.sleep(tempoDebounce);
//		} catch (InterruptedException ex) {
//			log.error("TrataArquivosFujiFlexaGerandoEventos.doJob(): "
//					+ "Erro ao dar sleep na thread\n");
//		}
//
//		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
//		File arquivo = new File(arg0.getFile().getName().getPath());
//		
//		// Resolve problema da ausencia do diretorio raiz na hora de converter
//		// fileObject para file
////		String rootPartition = System.getenv("SystemDrive"); 
////		if (rootPartition != null && rootPartition.equals("/"))
////				arquivo = new File(rootPartition + arg0.getFile().getName().getPath());
//		
//		String absolutePath = arquivo.getAbsolutePath();
//		String pathTratado = Paths.get(absolutePath).getParent().toString();
//
//		// Pesquisa o icupDTO a partir da url de conexao
//		// que é o diretorio pai do arquivo que teve modificacao/criacao
//		// IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(pathTratado);
//		IcUpDTO icUpDTO = getIcUpDTOFromUrlConexaoLazy(pathTratado);
//		if (icUpDTO != null) {
//			String nomeMaquina = icUpDTO.getUpDTO().getCd_up();
//			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
//			// Prepara o diretorio onde vao ficar as copias dos logs
//			String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
//			diretorioDestino += "//ColetaFujiFlex//";
//			criaDiretorioSeNaoExistir(diretorioDestino);
//			log.info("urlDiretorio " + diretorioDestino);
//
//			TCopiaArquivo tCopiaArquivo = new TCopiaArquivoFujiFlexa(nomeMaquina, diretorioDestino, log);
//			// Copia e carrega o arquivo na memoria
//			ArquivoFuji arquivoCopia = tCopiaArquivo.doJob(arquivo);
//			// Trata as linhas do arquivo copiado
//			if (arquivoCopia != null) {
//				arquivoCopia.setIcUpDTO(icUpDTO);
//				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
//				if (eventos != null)
//					ic.getBufferEventos().addEventos(ordenaEventos(eventos));
//			} else {
//				log.error("TrataArquivoGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
//			}
//		} else {
//			log.error("TrataArquivoGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
//		}
//	}
	
//	private List<EventoColetado>  ordenaEventos(List<EventoColetado> eventosIntermediarios) {
//		List<EventoColetado> retorno = eventosIntermediarios;
//		// Ordenacao
//		Collections.sort(retorno, new Comparator<EventoColetado>() {
//			@Override
//			public int compare(EventoColetado o1, EventoColetado o2) {
//				int comparacao = o1.getDthrEvento().compareTo(o2.getDthrEvento());
//				return comparacao;
//			}
//		});
//		return retorno;		
//	}
//
//	private IcUpDTO getIcUpDTOFromUrlConexaoLazy(String urlConexao) {
//		// Se nao for um caminho do windows, usa a versao tradicional
//		if (!urlConexao.contains("\\"))
//			return getIcUpDTOFromUrlConexao(urlConexao);
//		
////		String[] vetorUrlConexaoResumida = urlConexao.split("\\");
////		String urlConexaoResumida = vetorUrlConexaoResumida[vetorUrlConexaoResumida.length - 1];
//		String urlConexaoResumida = new File(urlConexao).getName();
//		for (IcUpDTO icUpDTOAux : icUpDTOList) {
//			if (icUpDTOAux.getUrlConexao().contains(urlConexaoResumida)) {
//				return icUpDTOAux;
//			}
//		}
//		return null;
//	}
//	private IcUpDTO getIcUpDTOFromUrlConexao(String urlConexao) {
//		for (IcUpDTO icUpDTOAux : icUpDTOList) {
//			if (icUpDTOAux.getUrlConexao().equals(urlConexao)) {
//				return icUpDTOAux;
//			}
//		}
//		return null;
//	}
//	private void criaDiretorioSeNaoExistir(String urlDiretorio) {
//		File dir = new File(urlDiretorio);
//		if (!dir.exists()) {
//			dir.mkdir();
//		}
//	}
}

class TratadorLog implements Runnable {

	private ICFuji ic;
	private List<IcUpDTO> icUpDTOList;
	private IdwLogger log;
	private FileChangeEvent arg0;
	private String name;
	private boolean isTerminated = false;
	
	long tempoDebounce = 2 * 1000; // 2s
	
	
	public TratadorLog (IdwLogger log, List<IcUpDTO> icUpDTOList, ICFuji ic, FileChangeEvent arg0, String name) {
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
			log.error("TrataArquivosFujiFlexaGerandoEventos.doJob(): "
					+ "Erro ao dar sleep na thread\n");
		}

		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
		File arquivo = new File(arg0.getFile().getName().getPath());
		
		// Resolve problema da ausencia do diretorio raiz na hora de converter
		// fileObject para file
//		String rootPartition = System.getenv("SystemDrive"); 
//		if (rootPartition != null && rootPartition.equals("/"))
//				arquivo = new File(rootPartition + arg0.getFile().getName().getPath());
		
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
			diretorioDestino += "//ColetaFujiFlex//";
			criaDiretorioSeNaoExistir(diretorioDestino);
			log.info("urlDiretorio " + diretorioDestino);

			TCopiaArquivo tCopiaArquivo = new TCopiaArquivoFujiFlexa(nomeMaquina, diretorioDestino, log);
			// Copia e carrega o arquivo na memoria
			ArquivoFuji arquivoCopia = tCopiaArquivo.doJob(arquivo);
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
			log.error("TrataArquivoGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
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

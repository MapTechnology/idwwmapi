package ms.coleta.ic.juki.errhist;

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
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.juki.errlog.ArquivoErrLog;
import ms.coleta.ic.juki.errlog.TCopiaArquivoErrLog;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivoErrHistGerandoEventos implements FileListener {
	// Prerequisitos
	private ICJuki ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;
	// Controle
	long tempoDebounce = 1 * 10 * 1000; // 10s
	private Map<String, Thread> execucoesThreads = new HashMap<>();

	public TrataArquivoErrHistGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICJuki ic) {
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
		if (arg0.getFile().getName().getBaseName().contains("ErrLog_Y")) {
			File removedFile = new File(arg0.getFile().getName().getPath());
			removedFile.getParentFile().mkdirs();
		}
	}
	
	/**
	 * Metodo mantem a coesao na analise de arquivos que sao
	 * modificados varias vezes em um curto espaco de tempo;
	 * Reponsalvel por acionar o doJob()
	 * @param arg0 FileChangeEvent
	 */
	private void gerenteExecucao (final FileChangeEvent arg0) {
		// Arquivo que teve modificacao
		String caminhoArquivo = arg0.getFile().getName().getPath();
		boolean executar = false;
		
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
		// Debouncer
		// Espera pelo fim da escrita do arquivo antes de trata-lo
		try {
			Thread.sleep(tempoDebounce);
		} catch (InterruptedException ex) {
			log.error("TrataArquivoErrHistGerandoEventos.doJob(): "
					+ "Erro ao dar sleep na thread\n");
		}
		
		// Validacao 1
		// Tratar apenas se for um arquivo ErrLog.txt
		if (!arg0.getFile().getName().toString().contains("ErrLog_Y"))
			return;
		
		log.info("Lendo arquivo =" + arg0.getFile().getName().getBaseName());
		File arquivo = new File(arg0.getFile().getName().getPath());
		String absolutePath = arquivo.getAbsolutePath();
		String pathTratado = Paths.get(absolutePath).getParent().toString();
		
		// Pesquisa o icupDTO a partir da url de conexao
		// que é o diretorio pai do arquivo que teve modificacao/criacao
		IcUpDTO icUpDTO = getIcUpDTOFromUrlAuxiliar(pathTratado);
		if (icUpDTO != null) {
			String nomeMaquina = icUpDTO.getUpDTO().getCd_up();
			File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
			// Prepara o diretorio onde vao ficar as copias dos logs
			String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
			diretorioDestino += "//ColetaJuki//";
			criaDiretorioSeNaoExistir(diretorioDestino);
			log.info("urlDiretorio " + diretorioDestino);
			
			TCopiaArquivoErrHist tCopiaArquivo = new TCopiaArquivoErrHist(nomeMaquina, diretorioDestino, log);
			// Copia e carrega o arquivo na memoria
			ArquivoErrHist arquivoCopia = tCopiaArquivo.doJob(arquivo);
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
	
	private IcUpDTO getIcUpDTOFromUrlAuxiliar(String urlAuxiliar) {
		for (IcUpDTO icUpDTOAux : icUpDTOList) {
			if (icUpDTOAux.getUrlAuxiliar().equals(urlAuxiliar)) {
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
}

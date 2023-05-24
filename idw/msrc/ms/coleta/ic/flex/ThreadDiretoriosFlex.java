package ms.coleta.ic.flex;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import jcifs.CIFSContext;
import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import ms.coleta.Stubedelegate;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class ThreadDiretoriosFlex {

	public enum _TP_AVALIACAO_ARQUIVOS {
		_SOMENTEARQUIVOS(0), _SOMENTESUBDIRETORIOS(1), _ARVOREDIRETORIOS(2);

		private final int value;

		private _TP_AVALIACAO_ARQUIVOS(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

	}

	private final IcUpDTO icup;
	private final Path diretorioRaiz;

	private final _TP_AVALIACAO_ARQUIVOS tipoAvalicaoDietorio;

	private final AbstractWatcherTrigger rn;
	private final IdwLogger log;
	private final int idLog;

	private boolean isExecutando = true;
	private long dthrUltimoDirProcessado = DataHoraRN.subtraiDiasDaData(DataHoraRN.getDataHoraAtual(), 1).getTime();

	// Armazena todos os arquivos encontrados no diretorio e seus subdiretorios. CAso algum arquivo sofra alteração ou algum novo arquivo
	// seja criado, o mesmo sera tratado
	private Map<String, Date> todosOsArquivoDetectados = new HashMap<>();

	public ThreadDiretoriosFlex(
			IcUpDTO icup,
			Path dir,
			_TP_AVALIACAO_ARQUIVOS tpaval,
			AbstractWatcherTrigger rn,
			IdwLogger log,
			int idLog) throws IOException {
		
		
		super();
		
//		this.setName("ThreadDireotrioFlex-" + icup.getUpDTO().getCd_up());

		this.icup = icup;
		this.diretorioRaiz = dir;
		this.tipoAvalicaoDietorio = tpaval;
		this.rn = rn;
		this.log = log;
		this.idLog = idLog;

		this.rn.setIcUpDTO(icup, log, idLog);

	}

	public void run() {
		log.info(idLog, 0, "Iniciando threadDiretoriosFlex para " + icup.getUpDTO().getCd_up());
		while (isExecutando) {
			log.info(idLog, 0, "avaliarDiretorios - inicio");
			avaliarDiretorios(diretorioRaiz); // diretorio inicial
			log.info(idLog, 0, "avaliarDiretorios - fim");
			UtilsThreads.pausaNaThread(15000);
		}
		log.info(idLog, 0, "Finalizando threadDIretoriosFles para " + icup.getUpDTO().getCd_up());
	}

	public void finalizar() {
		this.isExecutando = false;
	}
	
	/* Metodo para avaliar quais arquivos foram alterados */
	public void avaliarDiretorios(Path diretorio) {
		try {
			if (tipoAvalicaoDietorio == _TP_AVALIACAO_ARQUIVOS._SOMENTEARQUIVOS) {
				avaliarApenasArquivos(diretorio);
			} else if (tipoAvalicaoDietorio == _TP_AVALIACAO_ARQUIVOS._ARVOREDIRETORIOS) {
				avaliarArquivosESubDiretorios(diretorio);
			} else if (tipoAvalicaoDietorio == _TP_AVALIACAO_ARQUIVOS._SOMENTESUBDIRETORIOS) {
				avaliarApenasSubdiretorios(diretorio);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excessao", e);
			return;
		}

	}

	private FileFilter onlyDirectories = new FileFilter() {
		@Override
		public boolean accept(File file) {
			boolean isok = file.isDirectory() && (file.lastModified() > dthrUltimoDirProcessado || dthrUltimoDirProcessado == 0);
			return isok;
		}
	};
	private Comparator<File> ordenaUltimaModificacaoDesc = new Comparator<File>() {
		public int compare(File f1, File f2) {
			// desc order(maior para o menor)
			return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
		}
	};

	private void avaliarApenasSubdiretorios(final Path start) throws IOException {
		log.iniciaAvaliacao("listFiles para diretorio:" + start.toString());
		log.info(idLog, 0, "listFiles para diretorio:" + start.toString());
		File[] dirOrigem = start.toFile().listFiles(onlyDirectories);
		List<File> recentDirs = Arrays.asList(dirOrigem);
		Collections.sort(recentDirs, ordenaUltimaModificacaoDesc);
		log.mostrarAvaliacaoCompleta();

		if (recentDirs.isEmpty() == false) {
			log.info(idLog, 0, "Quantidade de dir encontrados " + recentDirs.size());
			File ultimoDirAtualizado = recentDirs.get(0);

			// avaliar o diretorio criado

			// Percorrer os arquivos apenas do diretorio dir
			String[] arquivos = ArquivosDiretorios.getArquivosNoDiretorio(ultimoDirAtualizado.toPath().toString());
			if (arquivos != null) {
				for (String fileName : arquivos) {
					String dirDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
					/*
					 * Verifica se o arquivo já existe no diretorio destino, pois se existir entao ele já foi processado e não requer novo
					 * processamento
					 */
					String arquivoDestino = dirDestino + icup.getUpDTO().getCd_up() + "/" + icup.getUpDTO().getCd_up() + "-" + fileName + ".txt";
					boolean isExisteNoDestino = ArquivosDiretorios.isExisteArquivo(arquivoDestino);

					if (isExisteNoDestino)
						break;

					fileName = ultimoDirAtualizado.toPath().toString() + "\\" + fileName;
					rn.tratarArquivo(null, fileName);

					dthrUltimoDirProcessado = ultimoDirAtualizado.lastModified();
					log.info(idLog, 0, ultimoDirAtualizado.getName() + " - dthrUltimoDirProcessado=" + dthrUltimoDirProcessado);
				}
			}
		} else {
			log.info(idLog, 0, "sem subdiretorios em " + start.toString());
		}
	}

	
	// Metodo recursivo para ler todos os arquivos, subdiretorios rr
	private void avaliarSMBRecursivamente(String path) {
		path = ArquivosDiretorios.ajustaPathSMB(path);
		if (!path.endsWith("/"))
			path = path + "/";
		// NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
		// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
		NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(null, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
		SmbFile baseDir;
		try {
			// baseDir = new SmbFile(path, auth);
			// Ailton 2019-06-27: atualizacao do jcifs para jcifs-ng
			CIFSContext base = SingletonContext.getInstance();
			CIFSContext authed1 = base.withCredentials(auth);
			baseDir = new SmbFile(path, authed1);
						
			SmbFile[] files = baseDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				SmbFile file = files[i];
				if (file.isDirectory()) {
					avaliarSMBRecursivamente(file.toString());
				} else {
					execarq(file.toString());
				}
			}
		} catch (MalformedURLException | SmbException e) {
			e.printStackTrace();
		}
	}

	// Registras todos os subdiretorios
	private void avaliarArquivosESubDiretorios(final Path start) throws IOException {

		if (ArquivosDiretorios.isICUsaAD(this.icup)) {
			avaliarSMBRecursivamente(start.toString());
		} else {
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dirAux, BasicFileAttributes attrs) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					execarq(file.getParent().toString() + "\\" + file.getFileName().toString());
					return FileVisitResult.CONTINUE;
				}
			});
		}
	}
	
	private void execarq(String fileName) {
		Date dthrAlteracao;
		if (ArquivosDiretorios.isICUsaAD(this.icup)) {
			dthrAlteracao = ArquivosDiretorios.getDtHrModificacao(fileName, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
		} else {
			dthrAlteracao = ArquivosDiretorios.getDtHrModificacao(fileName);
		}

		// Verifica se ja existe no mapeamento
		if (todosOsArquivoDetectados.containsKey(fileName)) {
			Date dthrAnterior = todosOsArquivoDetectados.get(fileName);
			if (DataHoraRN.equals(dthrAnterior, dthrAlteracao) == false) {
				log.info(idLog, 0, fileName + " - dthrAnt=" + dthrAnterior + " novaDthr=" + dthrAlteracao);
				if (ArquivosDiretorios.isICUsaAD(this.icup)) {
					rn.tratarArquivo(0, fileName, this.icup);
				} else {
					rn.tratarArquivo(null, fileName);
				}
				
			}
		}
		todosOsArquivoDetectados.put(fileName, dthrAlteracao);

		UtilsThreads.pausaNaThread(10l);

	}

	private void avaliarApenasArquivos(Path dir) throws IOException {
		// Percorrer os arquivos apenas do diretorio dir
		String[] arquivos;
		if (ArquivosDiretorios.isICUsaAD(this.icup)) {
			arquivos = ArquivosDiretorios.getArquivosNoDiretorio(dir.toString(), this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
		} else {
			arquivos = ArquivosDiretorios.getArquivosNoDiretorio(dir.toString());
		}
		if (arquivos != null) {
			for (String fileName : arquivos) {
				fileName = dir.toString() + "\\" + fileName;

				Date dthrAlteracao;
				if (ArquivosDiretorios.isICUsaAD(this.icup)) {
					dthrAlteracao = ArquivosDiretorios.getDtHrModificacao(fileName, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
				} else {
					dthrAlteracao = ArquivosDiretorios.getDtHrModificacao(fileName);
				}
				// Verifica se ja existe no mapeamento
				if (todosOsArquivoDetectados.containsKey(fileName)) {
					Date dthrAnterior = todosOsArquivoDetectados.get(fileName);
					if (dthrAnterior != null) {
						if (DataHoraRN.equal(dthrAlteracao, dthrAnterior) == false) {
							log.info(idLog, 0, "Arquivo " + fileName + " leitura anterior em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrAnterior) + " essa leitura em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrAlteracao));
							//rn.tratarArquivo(null, fileName);
							if (ArquivosDiretorios.isICUsaAD(this.icup)) {
								rn.tratarArquivo(0, fileName, this.icup);
							} else {
								rn.tratarArquivo(null, fileName);
							}
						}
					} else {
						log.info(idLog, 0, "infoAux null");
					}
				} else {
					log.info(idLog, 0, "Novo arquivo a ser analisada dthr alteracao " + fileName);
				}
				todosOsArquivoDetectados.put(fileName, dthrAlteracao);

				UtilsThreads.pausaNaThread(10l);
			}
			log.info(idLog, 0, "Avaliou todos os arquivos size=" + arquivos.length);
		} else {
			log.info(idLog, 0, "Sem arquivos no diretorio " + dir.toString());
		}
	}
}

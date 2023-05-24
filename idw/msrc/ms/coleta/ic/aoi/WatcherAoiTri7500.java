package ms.coleta.ic.aoi;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.mail.EmailException;

import idw.model.rn.DataHoraRN;
import idw.util.EnviarEmail;
import idw.util.IdwLogger;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class WatcherAoiTri7500 {

	private final IdwLogger log;
	private final int idLog;

	private boolean isExecutandoWatcher = true;

	private IcUpDTO icup;

	private final Path dir;
	private final TrataArquivosAoiTri7500GerandoEventos tratador;

	private int tempoDeMonitoramentoDaThreadEmMs = 20000;

	private boolean isEnviouEmail = false; // controle para enviar email apenas uma vez a cada problema

	public WatcherAoiTri7500(IcUpDTO icup, Path dir, IdwLogger log, int idLog, TrataArquivosAoiTri7500GerandoEventos tratador) {
		super();

		this.icup = icup;
		this.log = log;
		this.idLog = idLog;

		this.icup = icup;
		this.dir = dir;

		this.tratador = tratador;
	}

	// Avalia o direotrio para processar os arquivos
	public void avaliarDiretorios() {
		List<ArquivoAoiTri7500> listaDeArquivos = new ArrayList<ArquivoAoiTri7500>();
		if (dir.toFile().exists()) {
			File[] arqs = dir.toFile().listFiles();
			if (arqs.length > 0) {
				log.info(idLog, 0, "Varrendo os arquivos do diretorio: " + dir.toString());
			} else {
				log.info(idLog, 0,
						"Nenhum arquivo foi encontrado. Volto a processar em :" + this.tempoDeMonitoramentoDaThreadEmMs + "milisegundos");
				UtilsThreads.pausaNaThread(this.tempoDeMonitoramentoDaThreadEmMs);
				return;
			}
		} else {
			log.info(idLog, 0, "Diretorio : " + dir.toString() + " Não existe. Pausando a thread por 20 segundos.");
			UtilsThreads.pausaNaThread(20000);

			// Talvez aqui enviar uma parada para o INOVA

			// Enviando email pois o direotrio está indisponivel
			List<String> emails = idw.util.UtilsString.quebrarStringEmVetor(icup.getIc().getEmailsScriptPadraoNC(), ";");
			if (this.isEnviouEmail == false && emails.isEmpty() == false
					&& icup.getIc().getEmailsScriptPadraoNC().trim().equals("") == false) {
				StringBuilder msg = new StringBuilder();
				msg.append("O diretorio ");
				msg.append(dir.toString());
				msg.append(
						" está inacessível.\nEsse e-mail será enviado novamente somente quando o sistema conseguir conectar ao arquivo e perder o acesso novamente.");

				try {
					EnviarEmail.enviarEmail(
							emails,
							"Não conformidade no posto " + icup.getUpDTO().getCd_up() + " em " + DataHoraRN.getDataHoraAtualFormatada(),
							msg.toString(),
							"semArq",
							"semArq");
					this.isEnviouEmail = true;
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.info(idLog, 0, "EnviarEmail em WatcherAoiOmron", e);
				}
			}

			return;
		}

		/*
		 * Ordena os arquivos dos mais antigos aos mais novos *
		 * 
		 */
		this.isEnviouEmail = false;
		File[] arqs = dir.toFile().listFiles();
		Arrays.sort(arqs, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				Long dthr1 = o1.lastModified();
				Long dthr2 = o2.lastModified();
				return dthr1.compareTo(dthr2) * -1;
			}
		});
		for (File arq : arqs) {
			log.info(idLog, 0, "Chamando tratador para o arquivo: " + arq.toString());
			ArquivoAoiTri7500 arquivo = this.tratador.doJobSemGerarEvento(arq.getAbsoluteFile().toPath());
			if (arquivo != null) {
				listaDeArquivos.add(arquivo);
			}
		}
		if (listaDeArquivos.size() > 0) {
			this.tratador.trataTodosOsArquivos(listaDeArquivos);
		}

	}

	public boolean arquivoPossuiSufixoDaLista(String sufixo, List<String> lista) {
		for (String texto : lista) {
			if (texto.contains(sufixo)) {
				return true;
			}
		}
		return false;
	}

	public boolean arquivoPossuiSufixoDaLista(File sufixo, List<String> lista) {
		for (String texto : lista) {
			if (sufixo.getName().contains(texto)) {
				return true;
			}
		}
		return false;
	}

	public String getSufixo(File arq) {
		return arq.getName().substring(arq.getName().length() - 18);
	}

	public boolean isExecutandoWatcher() {
		return isExecutandoWatcher;
	}

	public void setExecutandoWatcher(boolean isWatcherExecutando) {
		this.isExecutandoWatcher = isWatcherExecutando;
	}

	public void finalizar() {

	}
}

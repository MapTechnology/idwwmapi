package ms.coleta.ic.aoi;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//import org.apache.commons.mail.EmailException;

import idw.model.rn.DataHoraRN;
import idw.util.EnviarEmail;
import idw.util.IdwLogger;
import ms.model.dto.IcUpDTO;

public class WatcherAoiOmron {

	private final IdwLogger log;
	private final int idLog;

	private boolean isExecutandoWatcher = true;

	private IcUpDTO icup;

	private final Path dir;
	private final TratadorArquivos tratador;

	private int tempoDeMonitoramentoDaThreadEmMs = 5000;

	private boolean isEnviouEmail = false; // controle para enviar email apenas uma vez a cada problema

	public WatcherAoiOmron(IcUpDTO icup, Path dir, IdwLogger log, int idLog, TratadorArquivos tratador) {
		super();

		this.icup = icup;
		this.log = log;
		this.idLog = idLog;

		this.icup = icup;
		this.dir = dir;

		this.tratador = tratador;
	}
	
	public static void main(String[] args) {
		IcUpDTO icup = new IcUpDTO();
		IdwLogger log = new IdwLogger("teste");
		Path dir = (new File("\\\\192.168.62.220\\Folder_Lan\\Report\\Linha 6")).toPath();
		TratadorArquivos tratador = new TratadorArquivos() {
			
			@Override
			public void doJob(Path path) {
				// TODO Auto-generated method stub
				
			}
		};
		WatcherAoiOmron rn = new WatcherAoiOmron(icup, dir, log, 0, tratador);
		rn.avaliarDiretorios();
	}

	// Avalia o direotrio para processar os arquivos
	public void avaliarDiretorios() {
		
		log.info(idLog, 0, "Avaliando dir [" + dir.toString() + "] se existe=" + dir.toFile().exists());
		System.out.println("Avaliando dir [" + dir.toString() + "] se existe=" + dir.toFile().exists());
		if (dir.toFile().exists()) {
			File[] arqs = dir.toFile().listFiles();
			if (arqs.length > 0) {
				log.info(idLog, 0, "Varrendo os arquivos do diretorio: " + dir.toString());
			} else {
				log.info(idLog, 0,
						"Nenhum arquivo foi encontrado. Volto a processar em :" + this.tempoDeMonitoramentoDaThreadEmMs + " milisegundos");
				return;
			}
		} else {
			log.info(idLog, 0, "WatcherAoiOmron.Diretorio : " + dir.toString() + " Não existe. Pausando a thread por 20 segundos.");

			// Talvez aqui enviar uma parada para o INOVA

			// Enviando email pois o direotrio está indisponivel
			List<String> emails = idw.util.UtilsString.quebrarStringEmVetor(icup.getIc().getEmailAoiNC(), ";");
			if (this.isEnviouEmail == false && emails.isEmpty() == false && icup.getIc().getEmailAoiNC().trim().equals("") == false) {
				StringBuilder msg = new StringBuilder();
				msg.append("O diretorio ");
				msg.append(dir.toString());
				msg.append(
						" está inacessível.\nEsse e-mail será enviado novamente somente quando o sistema conseguir conectar ao arquivo e perder o acesso novamente.");

				try {
					EnviarEmail.enviarEmail(
							emails,
							"NC posto " + icup.getUpDTO().getCd_up() + " em " + DataHoraRN.getDataHoraAtualFormatada(),
							msg.toString(),
							"semArq",
							"semArq");
					this.isEnviouEmail = true;
				} catch (Exception e) {
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
			log.info("Chamando tratador para o arquivo: " + arq.toString());
			this.tratador.doJob(arq.getAbsoluteFile().toPath());
		}

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

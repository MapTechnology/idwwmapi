package ms.coleta.ic.mitrastar.ssid;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.MSListener;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

// TODO milton - marcar último arquivo tratado
// TODO milton - marcar última linha lida do último arquivo tratado, fazendo que que a leitura do arquivo continue de onde parou
/**
 * Driver para a leitura dos log do posto de SSID da MitraStar.<br>
 *
 * Veja os detalhes da estrutura do arquivo em {@link LinhaArquivoMitraStarSSID}
 *
 * @author Milton
 *
 */
public class ICMitraStarSSID implements IIC{

	private MitraStarSSIDBufferedEventos bufferEventos = new MitraStarSSIDBufferedEventos();
	private MitraStarSSIDWatcher watcher = null;
	private final IcDTO icdto;
	private final String pathCacheColeta;
	private String pathCacheColetaIC;

	public static final String LOG_EXTENSIONTXT = "txt";
	public static final String LOG_EXTENSIONLOG = "log";

	private long DELAY_TRATA_CADA_ARQUIVO = 100L;
	
	private Date dthrUltimaLinhaTratada = null;
	private boolean isResetouWatcher = false; // Sera true qdo o watcher for resetado. Qdo dthrUltimaLinhaTratada for modificado entao volta pra false
	private Date dthrResetWatcher = null;
	private TrataArquivoMitraStarSSID trataArquivoMitraStarSSID;
	private IdwLogger log;
	private static final String CLASS_NAME = ICMitraStarSSID.class.getSimpleName();

	private final FileFilter ONLY_VALID_FILES = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isFile() && file.getName().toLowerCase().endsWith("." + LOG_EXTENSIONTXT);
		}
	};


	private final Comparator<File> ORDER_FILE_BY_NAME_ASC = new Comparator<File>() {
		@Override
		public int compare(File o1, File o2) {
			String fileName1 = o1.getName().toLowerCase();
			String fileName2 = o2.getName().toLowerCase();
			return fileName1.compareTo(fileName2);
		};
	};


	public ICMitraStarSSID() {
		super();
		icdto = null;
		pathCacheColeta = null;
	}
	
	public ICMitraStarSSID(IcDTO icdto) {
		super();
		this.icdto = icdto;
		this.pathCacheColeta = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		
		// Quando o evento for solicitado, devemos analisar se o watcher ainda é valida ou se foi iniciado
		boolean is5MinSemEventos = analisaElapsedTimeUltimoEvento();
		if (watcher == null || (watcher != null && watcher.isIniciado() == false) || is5MinSemEventos) {
			boolean isPathCachLogValido = isPathCacheLogValido(); 
			if (isPathCachLogValido) {

				this.pathCacheColetaIC = createPathCacheColetaIC();

				trataArquivoMitraStarSSID = new TrataArquivoMitraStarSSID(icdto, bufferEventos, log, pathCacheColetaIC);

				if (watcher != null)
					watcher.finalizar();

				List<File> caminhos = getCaminhos(log);

				//quando o metodo abaixo eh chamado o arquivo completo eh reprocessado, como se nao existisse a ultima linha salva
				//tratarTodosArquivos(log, caminhos);

				watcher = new MitraStarSSIDWatcher(trataArquivoMitraStarSSID, log, caminhos);
				watcher.iniciarWatcher();
				this.isResetouWatcher = true;
				this.dthrResetWatcher = DataHoraRN.getDataHoraAtual();
				
				if (log != null) {
					log.info("Watcher recriado em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrResetWatcher));
				} else {
					System.out.println("Watcher recriado em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrResetWatcher));
				}
			} else {
				if (log != null) {
					if (this.pathCacheColeta == null)
						log.info("Watcher nao recriado. Path invalido. pathCacheColeta Nao definido no web.xml");
					else
						log.info("Watcher nao recriado. Path invalido " + this.pathCacheColeta);
				} else
					System.out.println("log is null");
			}
		}
		
		EventosColetados retorno = bufferEventos.obtemEventosELimpa();
		
		if (retorno.isExisteEvento()) {
			this.dthrUltimaLinhaTratada = retorno.getEventosColetados().get(retorno.getEventosColetados().size() - 1).getDthrEvento();
			this.dthrResetWatcher = null;
			this.isResetouWatcher = false;
		}
		
		return retorno;
	}

	private boolean analisaElapsedTimeUltimoEvento() {
		Date dthrReferencia = DataHoraRN.getDataHoraAtual();
		dthrReferencia = DataHoraRN.subtraiSegundosDaData(dthrReferencia, 300);
		
		return this.dthrUltimaLinhaTratada != null &&
				DataHoraRN.before(this.dthrUltimaLinhaTratada, dthrReferencia) && 
				this.isResetouWatcher == false;
	}
	
	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.log = log;
		log.info("Iniciando " + CLASS_NAME + getVersaoDriver());

		if (isPathCacheLogValido()) {

			this.pathCacheColetaIC = createPathCacheColetaIC();

			trataArquivoMitraStarSSID = new TrataArquivoMitraStarSSID(icdto, bufferEventos, log, pathCacheColetaIC);

			if (watcher != null)
				watcher.finalizar();

			List<File> caminhos = getCaminhos(log);

			//tratarTodosArquivos(log, caminhos);

			watcher = new MitraStarSSIDWatcher(trataArquivoMitraStarSSID, log, caminhos);
			watcher.iniciarWatcher();

		} else {
			log.info("Watcher nao iniciado. Path invalido " + this.pathCacheColeta);
		}

	}

	private String createPathCacheColetaIC() {
		String path = pathCacheColeta + File.separator + icdto.getCd_ic();
		ArquivosDiretorios.criarDiretorioSeNaoexistir(path);
		return path;
	}

	private boolean isPathCacheLogValido() {
		try {
			Path path = Paths.get(this.pathCacheColeta);
			if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
				throw new IOException();
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				log.error("ic=" + icdto.getCd_ic() + " Caminho para cache dos logs inválido (" + this.pathCacheColeta + "). " +
					" Ajuste o parametro [" + MSListener.PATH_CACHE_COLETA_PARAMETER + "] em web.xml.", e);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	/*
	 * MEtodo deprecated como existe apenas um arquivo para ser processado não é necessário
	 * chama-lo quando o watcher executar pois nao primeira alteracao o arquivo sera reprocessado
	 */
	@Deprecated
	private void tratarTodosArquivos(IdwLogger log, List<File> caminhos) throws SemComunicacaoICException {
		List<File> files = new ArrayList<File>();

		for(File caminho: caminhos) {
			List<File> filesFromDirectory = Arrays.asList(caminho.listFiles(ONLY_VALID_FILES));
			files.addAll(filesFromDirectory);
		}

		Collections.sort(files, ORDER_FILE_BY_NAME_ASC);


		for (File file : files){
			
			// Para o SSID devemos tratar apenas o arquivo LogMAP.txt. Se nao for esse arquivo devemos desconsiderar
			// Acredito que se pegar outro arquivo a ultima linha sera perdida e o arquivo sera reprocessado novamente
			// Por isso esse metodo esta depracated
			if (file.toString().toUpperCase().contains("LOGMAP.TXT") == false)
				continue;
			
			try {

				trataArquivoMitraStarSSID.trataArquivo(file);

				Thread.sleep(DELAY_TRATA_CADA_ARQUIVO);

			} catch (InterruptedException e) {
				throw new SemComunicacaoICException(e);
			} catch (Exception e) {
				throw new SemComunicacaoICException(e);
			}
		}
	}

	private List<File> getCaminhos(IdwLogger log) {
		List<File> caminhos = new ArrayList<File>();

		for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {

			String caminho = updto.getUrlConexao();
			File file = new File(caminho);

			if (!file.exists()){
				log.info(CLASS_NAME +   " caminho não existe. " + caminho);
			}else if (!file.isDirectory()) {
				log.info(CLASS_NAME +   " caminho não é um diretório. " + caminho);
			} else {
				log.info(CLASS_NAME +   " caminho monitorado. " + caminho);
				caminhos.add(file);
			}

		}

		return caminhos;
	}

	
	public static void main(String[] args) {
		ICMitraStarSSID rn = new ICMitraStarSSID();
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(DataHoraRN.subtraiSegundosDaData(DataHoraRN.getDataHoraAtual(), 300));
		rn.bufferEventos.addEvento(evento);
		for (int i = 0; i < 3; i++) {
			try {
				rn.getEventos(null);
			} catch (SemComunicacaoICException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
		log.info("Finalizando DRIVER " + CLASS_NAME + getVersaoDriver());
		watcher.finalizar();
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
	}

}

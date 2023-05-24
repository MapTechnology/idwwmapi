package ms.coleta.ic.mitrastar.ssid;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmPt;
import idw.model.rn.PTRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.webservices.dto.MontagemDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.model.rn.UpRN;
import ms.util.UtilsThreads;

public class TrataArquivoMitraStarSSID implements FileListener {

	private static final int ORDEM_MONTAGEM_SERIAL_PLACA = 1;
	private static final int ORDEM_MONTAGEM_SERIAL_PRODUTO = 2;
	private static final int DELAY_CADA_LINHA = 100;

	private MitraStarSSIDBufferedEventos bufferEventos;

	private final IcUpDTO icUpDTO;
	private final String pathCacheColetaIC;
	private final IdwLogger log;

	/**
	 * Flag indicando se guarda eventos em buffer, que serão processados posteriormente no serviço. Ou se, lança evento aqui mesmo, usando
	 * uma transação para cada um deles.
	 */
	private final boolean LANCAR_EVENTOS_PELO_SERVICO_EVENTOS_IC = false;

	// private String ultimoArquivoTratado = null;
	private String ultimaLinhaTratada = null;
	private int contadorLinha = 0;
	
	public TrataArquivoMitraStarSSID() {
		super();
		icUpDTO = new IcUpDTO();
		icUpDTO.setUpDTO(new UpDTO());
		icUpDTO.getUpDTO().setCd_up("teste3");
		bufferEventos = null;
		pathCacheColetaIC = null;
		log = null;
	}

	public TrataArquivoMitraStarSSID(IcDTO icdto, MitraStarSSIDBufferedEventos bufferEventos, IdwLogger log, String pathCacheColetaIC) {
		super();
		this.icUpDTO = icdto.getMsIcUpDTOLocais().get(0);
		this.bufferEventos = bufferEventos;
		this.pathCacheColetaIC = pathCacheColetaIC;
		this.log = log;
	}

	public synchronized void trataArquivo(File file) throws Exception {
		trataArquivo(file.getName(), new FileInputStream(file));
	}
	
	public static void main(String[] args) {
		TrataArquivoMitraStarSSID rn = new TrataArquivoMitraStarSSID();
		try {
			rn.trataArquivo("C:/alessandre/temporario/LogMAP.LOG", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void trataArquivo(String fileName, InputStream is) throws Exception {

		log.info("Tratando arquivo " + fileName);
		RandomAccessFile reader = null;
		try {
			
			// Se a ultima linha estiver nula entao tentar obter do arquivo txt
			if (ultimaLinhaTratada == null) {
				obtemUltimaLinha();
			}

			File file = cacheFile(fileName, is);

			reader = new RandomAccessFile(file, "r");

			String line;
			boolean isProcessarLinha = false;
			
			while (isProcessarLinha == false) {
				if (ultimaLinhaTratada == null || (ultimaLinhaTratada != null && ultimaLinhaTratada.equals("null"))) {
					reader.seek(0l);
					log.info("Indo para inicio do arquivo");
				}

				if (ultimaLinhaTratada != null && contadorLinha > 0) {
					// Pula para o ultimo registro
					// Pego a linha anterior para verificar se eh a utlima processada, somo com 2 para pular o CR LF
					reader.seek( (contadorLinha-1) * (ultimaLinhaTratada.length() + 2));
					log.info("Pulando para a linha " + contadorLinha);
				}
				

				while ((line = reader.readLine()) != null) {
					log.info("lendo linha " + line);
					if (line == null || line.trim().equals("")) {
						log.info("linha vazia, ignorando");
						continue;
					}
	
					
					// Se a ultima linha estiver vazia é pq nenhuma linha foi prcessada, nesse caso processar a linha
					if (ultimaLinhaTratada == null || (ultimaLinhaTratada != null && ultimaLinhaTratada.equals("null"))) {
						isProcessarLinha = true;
						log.info("isProcessaLinha foi para true pois ultimaLinhaTratada = "  + ultimaLinhaTratada);
					}
	
					// Se a ultima linha for igual a linha corrente é pq encontramos a linha processada, nesse caso a proxima linha deve ser
					// processada
					if (ultimaLinhaTratada != null && ultimaLinhaTratada.equals(line)) {
						isProcessarLinha = true;
						log.info("isProcessaLinha true pois encontrou a ultima linha " + ultimaLinhaTratada);
						continue; // pegar proxima linha
					}
	
					contadorLinha++;
	
					// isProcessarLinha sera true qdo for a proxima linha valida do arquivo a ser processada. Ou seja, as linhas anterioes já
					// foram processadas
					if (isProcessarLinha) {
						ultimaLinhaTratada = line;
						LinhaArquivoMitraStarSSID linhaArquivo = new LinhaArquivoMitraStarSSID(line);
						processarLinha(linhaArquivo);
						salvaUltimaLInha();
					}
					
	
					Thread.sleep(DELAY_CADA_LINHA);
				}
	
				// Apos ter processado todo o arquivo e nao teve nenhuma linha valida entao da proxima vez devemos processar todo o arquivo.
				// Para isso a ultima linha deve ser null
				if (isProcessarLinha == false) {
					ultimaLinhaTratada = null;
					contadorLinha = 0;
					salvaUltimaLInha();
				}
				
				Thread.sleep(DELAY_CADA_LINHA);

			}

		} catch (MitraStarSSIDParseException e) {
			// Caso ocorra uma excesssao desse tipo possivelmente a linha está inconsistente, então ela deve ser descartada no proximo processamento
			// para isso devemo salvar essa referencia
			salvaUltimaLInha();
			e.printStackTrace();
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage(), e);
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
			log.info("Fim trataArquivo");
		}
	}

	private void processarLinha(LinhaArquivoMitraStarSSID linhaArquivo) {
		UpRN upRN = new UpRN();
		DAOGenerico dao = new DAOGenerico();
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			upRN.setDaoPdba(dao);

			OmPt omPt = new PTRN(dao).getOmPt(this.icUpDTO.getUpDTO().getCd_up());

			EventoColetado eventoColetado = createEventoColetado(linhaArquivo, omPt);

			if (LANCAR_EVENTOS_PELO_SERVICO_EVENTOS_IC) {
				bufferEventos.addEvento(eventoColetado);
			} else {
				upRN.registrarPassagem(log.getIdAleatorio(), 0, eventoColetado);
			}

			dao.commitaTransacao(dao.getSession());
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
			log.info("Errro processarLinha:", e);
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	/**
	 * Faz copia o arquivo para o diretório {@link #pathCacheColetaIC}
	 * 
	 * @param fileName
	 * @param inputStreamOrigem
	 * @return {@link File} do arquivo na nova pasta
	 * @throws IOException
	 */
	private File cacheFile(String fileName, InputStream inputStreamOrigem) throws IOException {
		// Antes de copiar da um tempo de 1s para evitar concorrencia
		UtilsThreads.pausaNaThread(1000);
		File targetFile = new File(pathCacheColetaIC + File.separator + fileName);
		FileUtils.copyInputStreamToFile(inputStreamOrigem, targetFile);
		return targetFile;
	}

	private EventoColetado createEventoColetado(LinhaArquivoMitraStarSSID linhaArquivo, OmPt omPt) {

		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._PASSAGEM);
		evento.setIcUpDTO(this.icUpDTO);
		evento.setCb(linhaArquivo.getMac());
		evento.setNumeroSerie(evento.getCb());
		evento.setDthrEvento(linhaArquivo.getDataHora());
		evento.setLog(this.log);

		List<MontagemDTO> montagens = new ArrayList<MontagemDTO>();

		montagens.add(createMontagemSerialPlaca(linhaArquivo));

		// O campo serial pode ter o mesmo número mac.
		// Quando for diferente indica que tem que o produto tem, além do MAC, o número série de identificação dele.
		if (linhaArquivo.getSerial().equals(linhaArquivo.getMac()) == false) {
			montagens.add(createMontagemSerialProduto(linhaArquivo));
		}

		evento.setMontagem(montagens);

		// Indica de qual OP o evento pertence, evitando que isso seja buscado em ms_evt
		if (omPt.getPpCp() != null) {
			evento.setCdop(omPt.getPpCp().getCdCp());
		}

		return evento;

	}

	private MontagemDTO createMontagemSerialPlaca(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSerialPlaca());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SERIAL_PLACA);
		return montagemDTO;
	}

	private MontagemDTO createMontagemSerialProduto(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSerial());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SERIAL_PRODUTO);
		return montagemDTO;
	}

	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		trataArquivo(arg0);
	}

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		trataArquivo(arg0);
	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
	}

	private void trataArquivo(FileChangeEvent arg0) throws Exception {
		String fileName = arg0.getFile().getName().getBaseName();

		if (fileName.toLowerCase().endsWith("." + ICMitraStarSSID.LOG_EXTENSIONTXT) || fileName.toLowerCase().endsWith("." + ICMitraStarSSID.LOG_EXTENSIONLOG)) {
			trataArquivo(fileName, arg0.getFile().getContent().getInputStream());
		} else {
			log.info("Arquivo desconsiderado: " + fileName);
		}

	}

	private boolean obtemUltimaLinha() {
		boolean retorno = false;

		String fileName = pathCacheColetaIC + icUpDTO.getUpDTO().getCd_up() + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaTratada = reader.readLine();
                this.contadorLinha = Integer.parseInt(reader.readLine());

				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Erro obtemUlltimaLinha", e);
			}
		}
		log.info("Obtendo ultima linha " + retorno);
		return retorno;
	}

	private void salvaUltimaLInha() {
		try {
			String fileName = pathCacheColetaIC + icUpDTO.getUpDTO().getCd_up() + ".txt";
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaTratada);
			writer.println(contadorLinha);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Erro salvaUltimaLinha", e);
		}
	}
}

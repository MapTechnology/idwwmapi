package ms.coleta.ic.flex.teste24gadsl;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.Date;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.MSThread;
import ms.coleta.Stubedelegate;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.util.UtilsThreads;

public class TrataArquivoRN24Gadsl extends TrataArquivoRN {

	private long posicaoArquivo = 0l;
	private boolean isTratando = false;
	
	public TrataArquivoRN24Gadsl(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}
	
	/* avaliarndo o seek que nao esta indo para o local esperado
	 * 
	 */
	public static void main(String[] args) {
		IcUpDTO dto = new IcUpDTO();
		UpDTO updto = new UpDTO();
		updto.setCd_up("teste");
		dto.setUpDTO(updto);
		IdwLogger log = new IdwLogger("teste");
		Stubedelegate.getInstancia().setMsthread(new MSThread("c:/idwtemp/"));
		TrataArquivoRN24Gadsl rn = new TrataArquivoRN24Gadsl("C:/enviando/", dto, null, log, 0);
		File arq = new File("C:/alessandre/temporario/teste24lin01voltandoarquivo/Log_All.txt");
		rn.processar(arq);
	}
	
	/* Metodo principal e exclusivo para processar o arquivo 24g adsl
	 * (non-Javadoc)
	 * @see ms.coleta.ic.flex.TrataArquivoRN#processaUmaLinhaDoArquivoCustom(java.io.File, java.lang.String, int, java.lang.String)
	 */
	public void processar(File arquivoOriginal) {
		// Copia o arquivo original para o servidor e trata a partir do arquivo no servidor
		Path destino = null;
		destino = getArquivoDestivo(arquivoOriginal.toPath());
		boolean isCopiou = false;
		do {
			try {
				Date inicio = DataHoraRN.getDataHoraAtual();
				
				/* Alessandre em 10-07-19 pode ocorrer do arquivo nao existir mais. Nesse caso descartar o processament
				 * 
				 */
				log.info(idLog, 0, "Verificando existendo do arquivo " + arquivoOriginal.getPath());
				if (ArquivosDiretorios.isExisteArquivo(arquivoOriginal.getPath()) == false)
					return;
				
				
				Files.copy(arquivoOriginal.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
				Date fim = DataHoraRN.getDataHoraAtual();
				log.info(idLog, 0, "Copiou arquivo " + arquivoOriginal.getName() + " em mili=" + DataHoraRN.getQuantidadeMilisegundosNoPeriodo(inicio, fim));
				isCopiou = true;
			} catch (Exception e1) {
				UtilsThreads.pausaNaThread(1000l);
				log.info(idLog, 0, "Falha na copia do arquivo, tentando novamente.", e1);
			}
		} while (isCopiou == false);
		
		try (RandomAccessFile reader = new RandomAccessFile(destino.toFile() /*arquivoOriginal.getPath()*/, "r")) {
			
			// O arqivo comecou a ser alterado pelo teste, então vamos esperar um tempo com o objetivo do teste finalizar
			UtilsThreads.pausaNaThread(1000l);
			
			
			// Obtem a ultima posicao varrida no arquivo
			obtemInformacoesNecessarias(arquivoOriginal.getName());

			ultimoArquivoProcessado = arquivoOriginal.getName();
			
			// Ir para a ultima coordenada processada. Se nao existir comecar do inicio
			log.info(idLog, 0, "Posicionando ponteiro em " + posicaoArquivo);
			reader.seek(posicaoArquivo);
			log.info(idLog, 0, "arquivo na posicao " + reader.getFilePointer());
						
			String linhaArquivo = "";
			
			boolean isPrimeiraVez = true;
			
			String nsPlaca = "";
			String dthr = "";
			String resultado = "";
			
			boolean isParar = false;
			
			do {
				isTratando = true;
				
				UtilsThreads.pausaNaThread(2l);

				try {
					// por algum motivo a leitura da linha retorna null e nao deveria. para efeito de avaliacao
					// foi incluido 3 tentativas para leitura da linha
					int nTentativas = 0;
					do {
						linhaArquivo = reader.readLine();
						nTentativas++;
					} while (linhaArquivo == null && nTentativas < 2);
				} catch (Exception e) {
					e.printStackTrace();
					isParar = true;
					log.info(idLog, 0, e);
				}
				if (isPrimeiraVez) {
					isPrimeiraVez = false;
					if (linhaArquivo == null) {
						log.info(idLog, 0, "linhaArquivo null, indo para inicio do arquivo a partir da posicao " + reader.getFilePointer());
						reader.seek(0);
						lineCounter = 0;
						continue;
					}
				}
				// linhas nulas devem ser desconsideradas
				if (linhaArquivo == null) {
					break; 
				}
				
				lineCounter++;
				// Varre o arquivo e procura pela frase "Serial number:". Se encontrar obtem no resto da linha o NS da placa
				if (linhaArquivo.startsWith("Serial number:")) {
					nsPlaca = linhaArquivo.substring(15);
				}
				
				if (linhaArquivo.contains("**** P A S S ****")) {
					resultado = "passou";
				} if (linhaArquivo.contains("**** F A I L ****")) {
					resultado = "erro";
				}
				if (linhaArquivo.contains("End:")) {
					dthr = linhaArquivo;
					String cdUp = icupdto.getUpDTO().getCd_up();
					Date horaPassagem;
					try {
						dthr = dthr.substring(6);
						horaPassagem = DataHoraRN.toDateFrom("yyyy/MM/dd HH:mm:ss", dthr);
					} catch (ParseException e) {
						nsPlaca = "";
						resultado = "";
						dthr = "";
						continue;
					}
					Integer stTeste = resultado.equals("erro") ? 0 : 1;
					
					// Se a hora for anterior a data e hora atual - 12h, ignorar
					Date dtReferencia = DataHoraRN.getDataHoraAtual();
					dtReferencia = DataHoraRN.subtraiHorasDaData(dtReferencia, 8);
					if (DataHoraRN.after(horaPassagem, dtReferencia)) {
						log.info(idLog, 0, "Lancando passagem para " + nsPlaca + " resultado=" + stTeste);
						if (nsPlaca != null && nsPlaca.trim().equals("") == false)
							IdwFacade.getInstancia().regristrarTesteSimples(cdUp, null, nsPlaca, horaPassagem, stTeste, "1");
						else
							log.info(idLog, 0, "ns em branco no horario " + horaPassagem);
					} else {
						log.info(idLog, 0, "Data " + horaPassagem + " anterior a " + dtReferencia);
					}
				}
				
				posicaoArquivo = reader.getFilePointer();
				ultimaLinhaProcessada = linhaArquivo;

				// Salva ultima posicao varrida
				salvaInformacoesNecessarias(arquivoOriginal.getName());
				
				
			} while (isParar == false);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, e);
		}
		isTratando = false;
		log.info(idLog, 0, "Finalizou tratamento arquivo 2.4");
		// apos encontrar o NS da placa procura o resultado **** P A S S **** ou **** F A I L ****
		
		
		// apos encontrar o resultado do teste, pegar a data e hora na tag "End:"
		
		
		// repetir o ciclo e ao final salvar a posicao do arquivo por ultimo processada
		
	}
	
	public boolean isTratando() {
		return this.isTratando;
	}
	
	
	protected Path getArquivoDestivo(Path arquivo) {
		String origem = arquivo.getFileName().toString();
		String destino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
		
		if (destino == null || destino.equals("")) {
			log.info(idLog, 0, "getArquivoDestivo: Nao foi possivel obter o caminho destino para arquivo" + arquivo.toString());
		}

		destino = destino + icupdto.getUpDTO().getCd_up();

		ArquivosDiretorios.criarDiretorioSeNaoexistir(destino);
		
		destino = destino +  "/" + origem;
		
		Path retorno = Paths.get(destino);
		
		return retorno;
	}

	
	
	
	

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		return false;
	}
	
	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;
		String destino;
		try {
			destino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
		} catch(NullPointerException e) {
			destino = "c:/idwtemp";
		}
		String fileName = destino + maquina + "/" + arquivoProcessado +  ".ultimalinha";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaProcessada = reader.readLine();
				this.lineCounter = Integer.parseInt(reader.readLine());
				this.ultimoArquivoProcessado = reader.readLine();
				this.posicaoArquivo = Long.parseLong(reader.readLine());
				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, e);
			}
		}
		return retorno;
	}

	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String destino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
			String fileName = destino + maquina + "/" + arquivoProcessado + ".ultimalinha";
//			log.info(idLog, 0, "Salvando ultimaLinhaProcessada " + posicaoArquivo + " em " + fileName + " - " + ultimaLinhaProcessada);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.println(posicaoArquivo);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "salvarInformacoesNececssarias", e);
		}
	}


	
	/* Metodo é utilizado para avaliar se a falha foi lancada. Nao sera lancada quando o arquivo CSV nao tiver o motivo, nesse caso devemos lancar com codigo de defeito generico
	 * 
	 */
	@Override
	protected void tratativaFinalDoArquivo() {
	}
}

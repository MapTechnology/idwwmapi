package ms.coleta.ic.printerDEK;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class TrataArquivoRNPrinterDek extends TrataArquivoRN {

	private BufferedEventos bufferEvento;
	
	public TrataArquivoRNPrinterDek(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}


	@Override
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		LinhaArquivoPrinterDek linha = new LinhaArquivoPrinterDek(log, icupdto, linhaArquivo);
		List<EventoColetado> ev = linha.obtemEvento();
		if (ev.isEmpty() == false)
			bufferEvento.addEventos(ev);
		return false;
	}

	private long posicaoArquivo = 0l;
	private boolean isTratando = false;
		
	/* avaliarndo o seek que nao esta indo para o local esperado */
	
	/* Metodo principal e exclusivo para processar o arquivo 24g adsl */
	public void processar(File arquivoOriginal) {
		// Copia o arquivo original para o servidor e trata a partir do arquivo no servidor
		Path destino = null;
		destino = getArquivoDestivo(arquivoOriginal.toPath());
		boolean isCopiou = false;
		do {
			try {
				
				Files.copy(arquivoOriginal.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
				
				log.info(idLog, 0, "Copiou arquivo " + arquivoOriginal.getName());
				isCopiou = true;
			} catch (Exception e1) {
				UtilsThreads.pausaNaThread(800l);
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
			log.info("Ultima linha processada obtida: " + ultimaLinhaProcessada);
			reader.seek(posicaoArquivo);
						
			String linhaArquivo = "";
			
			boolean isPrimeiraVez = true;
			if (ultimaLinhaProcessada != null){
				isPrimeiraVez = false;
				
			}
			
			log.info("Valor do ponteiro e da booleana: " + posicaoArquivo + "-" + isPrimeiraVez );		
			boolean isParar = false;
			
			do {
				isTratando = true;
				
				UtilsThreads.pausaNaThread(15);

				try {
					linhaArquivo = reader.readLine();
					log.info("Processando a linha do arquivo: " + linhaArquivo);
					LinhaArquivoPrinterDek linha = new LinhaArquivoPrinterDek(log, icupdto, linhaArquivo);
					List<EventoColetado> ev = linha.obtemEvento();
					if (ev.isEmpty() == false)
						bufferEvento.addEventos(ev);
				} catch (Exception e) {
					e.printStackTrace();
					isParar = true;
					log.info("Erro ao ler o arquivo em TrataArquivoRNPrinterDek: " + e);
				}
				if (isPrimeiraVez) {
					isPrimeiraVez = false;
					if (linhaArquivo == null) {
						reader.seek(0);
						lineCounter = 0;
						continue;
					}
				}
				// linhas nulas devem ser desconsideradas
				if (linhaArquivo == null) {
					isParar = true;
					break; 
				}
				
				lineCounter++;
								
				posicaoArquivo = reader.getFilePointer();
				ultimaLinhaProcessada = linhaArquivo;

				// Salva ultima posicao varrida
				salvaInformacoesNecessarias(arquivoOriginal.getName());
				
				
			} while (isParar == false);
			
			//salvaInformacoesNecessarias(arquivoOriginal.getName());
			//reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Erro ao abrir o arquivo em TrataArquivoRNPrinterDek: " + e);
		}
		isTratando = false;
		log.info(idLog, 0, "Finalizou tratamento arquivo da Printer DEK");
				
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
	
	public void setBufferEvento(BufferedEventos bufferEvento) {
		this.bufferEvento = bufferEvento;
	}
	
	@Override
	protected void tratativaFinalDoArquivo() {
	}
}

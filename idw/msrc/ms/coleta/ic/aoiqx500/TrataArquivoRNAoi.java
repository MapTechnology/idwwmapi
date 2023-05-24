package ms.coleta.ic.aoiqx500;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

public class TrataArquivoRNAoi extends TrataArquivoRN {

	private BufferedEventos bufferEvento;
	private LinhaArquivoAoiQx500 linha = null;
	private boolean isDados = false;
	
	public TrataArquivoRNAoi(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}


	@Override
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		
		LinhaArquivoAoiQx500 linha = new LinhaArquivoAoiQx500(log, icupdto, linhaArquivo, file.getName());
		List<EventoColetado> ev = linha.obtemEvento();
		if (ev.isEmpty() == false)
			bufferEvento.addEventos(ev);
				
		
		
		
		return true;
	}
	
	@Override
	public boolean processaUmArquivoDaMaquina(File file) {
		
		log.info("Iniciando o processaUmArquivoDaMaquina(" + file.getPath() + ")");
		boolean retorno = false;		
		String linhaArquivo = "";
		
		try (RandomAccessFile reader = new RandomAccessFile(file.getPath(), "r")) {
			
			linhaArquivo = reader.readLine();
			boolean pararDeProcessarArquivo = false;
			do {
				
				byte[] b = new byte [800];
				
				int l = reader.read(b);
				String linha = new String(b);
				if (linha != null) {														
					
					try {
						if (linha.length() > 100) {
							log.info(idLog, 0, "processando linha " + "(" + linha + ")");
							pararDeProcessarArquivo = processaUmaLinhaDoArquivo(file, file.getName(), lineCounter, linha, fileType);
							
							retorno = true;
							
						}
					} catch (PararDeProcessarArquivoSemSalvarLinhaException e) {
						log.info(idLog, 0, "TrataArquivoRN erro0: excecao ao executar: linhaArquivo = reader.readLine(); ou linhas seguintes ", e);
						pararDeProcessarArquivo = true;
						retorno = true;
						break;
					} catch (Exception e) {
						log.info(idLog, 0, "TrataArquivoRN erro1: excecao ao executar: linhaArquivo = reader.readLine(); ou linhas seguintes ", e);
						retorno = false;
					}

				}
				UtilsThreads.pausaNaThread(10l);
			} while (linhaArquivo != null && pararDeProcessarArquivo == false);
			
		}catch (Exception e) {
			log.info("TrataArquivoRN erro2:" + e);
			e.printStackTrace();
			retorno = false;
		}
		
		log.info("Finalizou processaUmArquivoDaMaquina. Retorno=" + retorno);
		return retorno;
		
	}


	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info("Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excessao", e);
		}
	}


	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;

		/* A ultima linha processada da maquina deve considerar tambem o nome do arquivo
		 * que está sendo processado, pois enquanto o arquivo principal é criado, outros arqruivos
		 * que não interessam também são, e esses arquivos.
		 */
		String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaProcessada = reader.readLine();
				this.lineCounter = Integer.parseInt(reader.readLine());
				this.ultimoArquivoProcessado = reader.readLine();
				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, "Excessao", e);
			}
		}
		return retorno;
	}

	@Override
	protected void tratativaFinalDoArquivo() {
	}
	
	
	public void setBufferEvento(BufferedEventos bufferEvento) {
		this.bufferEvento = bufferEvento;
	}
}

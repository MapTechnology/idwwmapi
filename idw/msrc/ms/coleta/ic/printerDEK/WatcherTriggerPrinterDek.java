package ms.coleta.ic.printerDEK;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import idw.util.ArquivosDiretorios;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerPrinterDek extends AbstractWatcherTrigger {

	private BufferedEventos bufferEventos;
	
	private TrataArquivoRNPrinterDek rn =  null;
	
	public WatcherTriggerPrinterDek() {
		super();
		this.isCopiarArquivo = true;
	}

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return arquivo.toString().toUpperCase().contains("EVENT.DAT");
	}
	
	public void setBufferedEventos(BufferedEventos bev) {
		this.bufferEventos = bev;
	}

	/*
	 * Trata arquivo copiado
	 * 
	 */
	@Override
	protected void tratarArquivo(Path arquivo) {
						
		File arq = null;
		boolean isAbriuArquivo = false;
		do {
			try {
				arq = arquivo.toFile();
				isAbriuArquivo = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, "Nova tentativa de abertura do arquivo "+ arquivo.toString() + " em 500ms", e);
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		// Se já estiver trantando o arquivo então nao se deve tratar novamente. Aguardar até o mesmo ser finalizado
		if (rn != null && rn.isTratando()) {
			return;
		}
		rn = new TrataArquivoRNPrinterDek(arquivo.getParent().toString(), icup, ColetaFileType.MITRASTAR_24G, log, idLog);
		try {
			rn.setBufferEvento(this.bufferEventos);
			rn.processar(arq);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, e);
		}
				
		}

	@Override
	protected void copiarArquivo(String arquivo, Path destino) throws IOException {
		String nomeDiretorioOrigem = arquivo.toString();
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = arquivo.toString();
			nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", ".csv");
		}
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = arquivo.toString();
		}
		Files.copy(Paths.get(nomeDiretorioOrigem), destino, StandardCopyOption.REPLACE_EXISTING);
	}
}

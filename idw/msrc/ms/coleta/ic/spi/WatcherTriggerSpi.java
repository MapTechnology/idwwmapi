package ms.coleta.ic.spi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerSpi extends AbstractWatcherTrigger {

	private BufferedEventos bufferEventos;

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return arquivo.toString().toUpperCase().contains(".TXT") && !arquivo.toString().toUpperCase().contains("ERR") ;
	}
	
	public void setBufferedEventos(BufferedEventos bev) {
		this.bufferEventos = bev;
	}

	/*
	 * Trata arquivo copiado
	 * 
	 */
	@Override
	protected void tratarArquivo(Path destino) {
		Boolean delFile = false;

		File arq = null;
		boolean isAbriuArquivo = false;
		do {
			try {
				arq = destino.toFile();
				isAbriuArquivo = true;
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, e);
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRNSpi rn = new TrataArquivoRNSpi(
				destino.getParent().toString(),
				icup,
				ColetaFileType.MITRASTAR_24G,
				log,
				idLog);

		try {
			rn.setBufferEvento(this.bufferEventos);
			delFile = rn.processaUmArquivoDaMaquina(arq);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, e);
		}
		try {
			if (delFile == true) {
				arq.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, e);
		}
	}

	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		String nomeDiretorioOrigem = origem.toString();
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = origem.toString();
			nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", ".csv");
		}
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = origem.toString();
		}
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
}

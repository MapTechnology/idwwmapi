package ms.coleta.ic.flex.pt;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerPt extends AbstractWatcherTrigger {

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return ArquivosDiretorios.isDiretorio(arquivo, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD()) == false && 
				arquivo.toString().toUpperCase().contains(".LOG");
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
				log.info("arquivo aberto " + arq.getName());
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Excessao0:", e);
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRNPT rn = new TrataArquivoRNPT(destino.getParent().toString(), icup, ColetaFileType.MITRASTAR_PT, log, idLog);
		try {
			log.info(idLog, 0, "chamando processaUmArquivoDaMaquina");
			delFile = rn.processaUmArquivoDaMaquina(arq);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Excessao:", e);
		}
		try {
			if (delFile == true) {
				log.info("deletando arquivo " + arq.getName());
				arq.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Excessao2:", e);

		}
	}

	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
}

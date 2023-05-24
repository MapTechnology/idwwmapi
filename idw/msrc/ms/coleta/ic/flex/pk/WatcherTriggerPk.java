package ms.coleta.ic.flex.pk;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

/* As classes WatcherTrigger serão disparadas quando houver uma alteracao em algum arquivo
 * 
 */
public class WatcherTriggerPk extends AbstractWatcherTrigger {
	
	// Somente arquivos TXT são validos. Um arquivo .log é gerado depois renomeado para txt
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
			} catch (Exception e) {
				e.printStackTrace();
				log.info(idLog, 0, "Execessao toFile", e);
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRNPK rn = new TrataArquivoRNPK(destino.getParent().toString(), icup, ColetaFileType.MITRASTAR_PK, log, idLog);
		try {
			delFile = rn.processaUmArquivoDaMaquina(arq);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excessao processamento:", e);
		}
		try {
			if (delFile == true) {
				arq.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excessao del file:", e);
		}
	}

	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
}

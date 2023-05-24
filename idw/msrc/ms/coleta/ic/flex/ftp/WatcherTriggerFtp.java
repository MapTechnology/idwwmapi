package ms.coleta.ic.flex.ftp;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerFtp extends AbstractWatcherTrigger {
	
	@Override
	protected boolean isArquivoValido(String arquivo) {
		return ArquivosDiretorios.isDiretorio(arquivo, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD()) == false;
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
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRNFTP rn = new TrataArquivoRNFTP(destino.getParent().toString(), icup, ColetaFileType.MITRASTAR_FTP, log, idLog);
		try {
			delFile = rn.processaUmArquivoDaMaquina(arq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (delFile == true) {
				arq.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException{
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
}

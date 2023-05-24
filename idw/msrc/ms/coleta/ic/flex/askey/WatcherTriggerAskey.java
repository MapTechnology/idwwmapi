package ms.coleta.ic.flex.askey;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerAskey extends AbstractWatcherTrigger {

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return ArquivosDiretorios.isDiretorio(arquivo, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD()) == false;
	}

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
		
		TrataArquivoRNAskey rn = new TrataArquivoRNAskey(destino.getParent().toString(), icup, ColetaFileType.ASKEY, log, idLog);
		
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
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}

}

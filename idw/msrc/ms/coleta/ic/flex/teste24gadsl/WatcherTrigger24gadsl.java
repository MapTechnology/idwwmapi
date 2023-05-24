package ms.coleta.ic.flex.teste24gadsl;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import idw.util.ArquivosDiretorios;
import idw.util.UtilsString;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTrigger24gadsl extends AbstractWatcherTrigger {

	private TrataArquivoRN24Gadsl rn =  null;
	
	public WatcherTrigger24gadsl() {
		super();
		this.isCopiarArquivo = false;
	}
	
	@Override
	protected boolean isArquivoValido(String arquivo) {
		List<String> quebra = UtilsString.quebrarStringEmVetor(arquivo, "\\");
		if (quebra.isEmpty() == false) {
			return quebra.get(quebra.size()-1).toUpperCase().equals("LOG_ALL.TXT");
		}
		return false;
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
				if (arquivo == null)
					log.info(idLog, 0, "arquivo null");
				else
					log.info(idLog, 0, "arquivo = " + arquivo.toString());
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
		rn = new TrataArquivoRN24Gadsl(arquivo.getParent().toString(), icup, ColetaFileType.MITRASTAR_24G, log, idLog);
		try {
			rn.processar(arq);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, e);
		}
	}

	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		ArquivosDiretorios.copiarArquivo(origem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}

}

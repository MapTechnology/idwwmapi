package ms.coleta.ic.flex.wc;

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

public class WatcherTriggerWcZTE extends AbstractWatcherTrigger {

	private BufferedEventos bufferEventos;

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return arquivo.toUpperCase().contains("STATION");
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

		TrataArquivoRNWcZTE rn = new TrataArquivoRNWcZTE(
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
	protected void copiarArquivo(String arquivo, Path destino) throws IOException {
		String nomeDiretorioOrigem = arquivo.toString();
		if (icup.getIc().getIsAutenticacao() 
				&& icup.getIc().getLoginAD() != null && !icup.getIc().getLoginAD().equals("") 
				&& icup.getIc().getSernhaAD() != null && !icup.getIc().getSernhaAD().equals("")) {
			String loginAD = icup.getIc().getLoginAD();
			String senhaAD = icup.getIc().getSernhaAD();
			
//			if (ArquivosDiretorios.isExisteArquivoSMB(nomeDiretorioOrigem, loginAD, senhaAD) == false) {
//				nomeDiretorioOrigem = arquivo.toString();
//			}
			ArquivosDiretorios.copiarArquivo(nomeDiretorioOrigem, destino, loginAD, senhaAD);
		} else {
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
}

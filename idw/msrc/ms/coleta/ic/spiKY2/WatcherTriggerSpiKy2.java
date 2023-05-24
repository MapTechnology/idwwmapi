package ms.coleta.ic.spiKY2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.aoiVTRNSSQL.ArquivoUltimoID;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.model.dto.IcDTO;
import ms.util.UtilsThreads;

public class WatcherTriggerSpiKy2 extends AbstractWatcherTrigger {

	private BufferedEventos bufferEventos;
	private ArquivoUltimoID ultimoID;
	private IcDTO icdto;
	
	
	@Override
	protected boolean isArquivoValido(String arquivo) {
		return arquivo.toString().toUpperCase().contains(".TXT") && !arquivo.toString().toUpperCase().contains("ERR") && !arquivo.toString().toUpperCase().contains("SCALE");
	}
	
	public void setBufferedEventos(BufferedEventos bev, IcDTO icdto) {
		this.bufferEventos = bev;
		this.icdto = icdto;
	}
	
	public void setArquivoUltimoID(ArquivoUltimoID ultimoID) {
		this.ultimoID = ultimoID;
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

		TrataArquivoRNSpiKy2 rn = new TrataArquivoRNSpiKy2(
				destino.getParent().toString(),
				icdto,
				icup,
				ColetaFileType.MITRASTAR_24G,
				log,
				idLog);

		try {
			rn.setBufferEvento(this.bufferEventos, this.ultimoID);
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

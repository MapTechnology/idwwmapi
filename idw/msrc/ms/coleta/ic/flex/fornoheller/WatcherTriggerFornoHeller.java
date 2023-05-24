package ms.coleta.ic.flex.fornoheller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTriggerFornoHeller extends AbstractWatcherTrigger{
	
	private BufferedEventos bufferEventos;

	@Override
	protected boolean isArquivoValido(String arquivo) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Formatter fmt = new Formatter(Locale.ENGLISH);
	    fmt.format("%tb", calendar);
	    String shortNameMonth = fmt.toString();
	    fmt.close();
	    
	    StringBuilder dt1 = new StringBuilder();
	    dt1.append(shortNameMonth);
	    dt1.append(" ");
	    dt1.append(calendar.get(Calendar.DAY_OF_MONTH));
	    dt1.append(" ");
	    dt1.append(calendar.get(Calendar.YEAR));
		dt1.append(" data.txt");

		StringBuilder dt2 = new StringBuilder();
		dt2.append(shortNameMonth);
		dt2.append(" ");
		dt2.append(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));
		dt2.append(" ");
		dt2.append(calendar.get(Calendar.YEAR));
		dt2.append(" data.txt");
		
	    // Apr 20 2017 data
		return (arquivo.contains(dt1.toString())
				// Ailton: 2019-02-01
				// Quando dia < 10, calendar.get(Calendar.DAY_OF_MONTH) retorna um numero de 1 digito
				// Ex: 1, 2 ou 3; quando na verdade o esperado e 01, 02, 03; String.format cuida disso
				|| arquivo.contains(dt2.toString()) );
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
				log.info(idLog, 0, e);
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRNFornoHeller rn = new TrataArquivoRNFornoHeller(
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
		ArquivosDiretorios.copiarArquivo(nomeDiretorioOrigem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
		
	}

	public BufferedEventos getBufferEventos() {
		return bufferEventos;
	}

	public void setBufferedEventos(BufferedEventos bufferEventos) {
		this.bufferEventos = bufferEventos;
	}
}

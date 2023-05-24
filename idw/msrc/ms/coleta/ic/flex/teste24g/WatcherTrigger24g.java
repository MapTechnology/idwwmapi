package ms.coleta.ic.flex.teste24g;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import idw.util.ArquivosDiretorios;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTrigger24g extends AbstractWatcherTrigger {

	@Override
	protected boolean isArquivoValido(String arquivo) {
		return arquivo.toString().toUpperCase().endsWith("_PASS.TXT") || arquivo.toString().toUpperCase().endsWith("_FAIL.TXT");
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

		TrataArquivoRN24G rn = new TrataArquivoRN24G(destino.getParent().toString(), icup, ColetaFileType.MITRASTAR_24G, log, idLog);
		try {
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
		// O Watcher do 5g esta avaliando apenas os arquivos gerados no diretorio indicado na url_conexao
		// entretanto nesse dir é gerado apenas o arquivo _PASS.txt ou _FAIL.txt
		// Mas para tratar os dados é necessário o arquivo _PASS.csv ou _FAIL.csv. Esses arquivos estarao em um subdiretorio com o mesmo nome do arquivo _PASS.txt ou _FAIL.txt
		// entao a origem da copia abaixo deve ser modificada para copiar o csv.
		String nomeDiretorioOrigem = origem.toString();
		// Remover *RUN*.txt do nome para obter o diretorio
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll("_RUN", "");
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", "");
		nomeDiretorioOrigem = nomeDiretorioOrigem + "\\" + origem.toString();
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll("_RUN", "");
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", ".csv");
		
		/* avaliar se existe o arquivo de origem existe. Para o 24G do HPNA nao eh criado um diretorio, mas o arquivo é colocado no dir corrente com o padrao RUN_PASS.csv ou RUN_FAIL.csv
		 * 
		 */
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = origem.toString();
			nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", ".csv");
		}
		if (ArquivosDiretorios.isExisteArquivo(nomeDiretorioOrigem) == false) {
			nomeDiretorioOrigem = origem.toString();
		}
		
		ArquivosDiretorios.copiarArquivo(nomeDiretorioOrigem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
}

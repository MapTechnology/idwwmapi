package ms.coleta.ic.flex.teste5g;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import idw.util.ArquivosDiretorios;
import idw.util.UtilsString;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.flex.AbstractWatcherTrigger;
import ms.util.UtilsThreads;

public class WatcherTrigger5g extends AbstractWatcherTrigger {
	

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
				log.info(idLog, 0, "Excessao wt5g-0", e);
				e.printStackTrace();
				UtilsThreads.pausaNaThread(500);
			}
		} while (isAbriuArquivo == false);

		TrataArquivoRN5G rn = new TrataArquivoRN5G(destino.getParent().toString(), icup, ColetaFileType.MITRASTAR_24G, log, idLog);
		try {
			delFile = rn.processaUmArquivoDaMaquina(arq);
		} catch (Exception e) {
			log.info(idLog, 0, "Excessao wt5g", e);
			e.printStackTrace();
		}
		try {
			if (delFile == true) {
				arq.delete();
			}
		} catch (Exception e) {
			log.info(idLog, 0, "Excessao wt5g-2", e);
			e.printStackTrace();

		}
	}
	
	@Override
	protected void copiarArquivo(String origem, Path destino) throws IOException {
		// O Watcher do 5g esta avaliando apenas os arquivos gerados no diretorio indicado na url_conexao
		// entretanto nesse dir é gerado apenas o arquivo _PASS.txt ou _FAIL.txt
		// Mas para tratar os dados é necessário o arquivo _PASS.csv ou _FAIL.csv. Esses arquivos estarao em um subdiretorio com o mesmo nome do arquivo _PASS.txt ou _FAIL.txt
		// entao a origem da copia abaixo deve ser modificada para copiar o csv.
		String nomeDiretorioOrigem = correcaoNomeArquivo(origem.toString());
		// Remover *RUN*.txt do nome para obter o diretorio
		log.info(idLog, 0, "Copiando 5g de " + nomeDiretorioOrigem + " para " + destino);
		ArquivosDiretorios.copiarArquivo(nomeDiretorioOrigem, destino, this.icup.getIc().getLoginAD(), this.icup.getIc().getSernhaAD());
	}
	
	public String correcaoNomeArquivo(String origem) {
		// Se a origem possui o protocolo SMB, transforma a URL para o formato padrao
		String origemOriginal = origem;
		if (origemOriginal.contains("smb:")) {
			origem = origem.replace("smb:" , "").replaceAll("/", "\\\\");
		}
		
		String nomeDiretorioOrigem = origem;
		List<String> origemquebrada = UtilsString.quebrarStringEmVetor(origem, "\\");
		String apenasNomeArquivo = origemquebrada.get(origemquebrada.size() - 1) ;
		log.info(idLog, 0, "apenas arquivo = " + apenasNomeArquivo);
		log.info(idLog, 0, "Corrigindo " + nomeDiretorioOrigem);
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll("_RUN", "");
		log.info(idLog, 0, "1a corr " + nomeDiretorioOrigem);
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", "");
		log.info(idLog, 0, "2a corr " + nomeDiretorioOrigem);
		nomeDiretorioOrigem = nomeDiretorioOrigem + "\\" + apenasNomeArquivo;
		log.info(idLog, 0, "3a corr " + nomeDiretorioOrigem);
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll("_RUN", "");
		log.info(idLog, 0, "4a corr " + nomeDiretorioOrigem);
		nomeDiretorioOrigem = nomeDiretorioOrigem.replaceAll(".txt", ".csv");
		log.info(idLog, 0, "5a corr " + nomeDiretorioOrigem);
		
		// Se a origem possuia o protocolo SMB, usa-se o msmo padrao para a URL final
		if (origemOriginal.contains("smb:")) {
			nomeDiretorioOrigem = ArquivosDiretorios.ajustaPathSMB(nomeDiretorioOrigem);
		}
		
		return nomeDiretorioOrigem;
	}
}

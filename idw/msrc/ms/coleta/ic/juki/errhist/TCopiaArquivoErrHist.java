package ms.coleta.ic.juki.errhist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.juki.errlog.ArquivoErrLog;
import ms.coleta.ic.juki.errlog.TCopiaArquivoErrLog;

public class TCopiaArquivoErrHist {
	
	private String nomeMaquina;
	private String pathDestino = "";
	
	private IdwLogger log;

	public TCopiaArquivoErrHist(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		pathDestino = diretorioDestino;
		this.log = log;
	}

	public ArquivoErrHist doJob(File arquivo) {
		if (isErrHist(arquivo)) {
			return trataArquivoErrHist(arquivo);
		}
		return null;
	}

	private ArquivoErrHist trataArquivoErrHist(File arquivoOrigem) {
		String nomeArquivoDestino = "errHist-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		
		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error("TCopiaArquivo: Erro ao copiar arquivo: " + arquivoOrigem.getName() + " Erro foi: " + e.toString());
			return null;
		}
		
		ArquivoErrHist retorno = new ArquivoErrHist(log);
		
		retorno.setNomeArquivo(nomeArquivoDestino);
		retorno.setPathArquivo(pathDestino);
		carregaLinhasTratadas(retorno);
		
		retorno.setDataUltimaModificacao(new Date());
		log.info("TCopiaArquivoErrLog: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}

	/**
	 * O arquivo e lido e carregado em memoria
	 * Apenas as linhas ue comecam com um espaco sao carregadas
	 * Linhas que comecam com mais espacos sao detalhamentos
	 * @param retorno
	 */
	private void carregaLinhasTratadas(ArquivoErrHist arquivo) {
		List<String> retorno = new ArrayList<String>();
		String loc = arquivo.getPathArquivo() + arquivo.getNomeArquivo();
		File arq = new File(loc);
		if (arq.exists()) {
			BufferedReader br = null;
			String linha = "";
			try {
				br = new BufferedReader(new FileReader(loc));
				while ((linha = br.readLine()) != null) {
					// Linha inicia com " 2017"
					if ( !linha.equals("\r\n") && linha.length() > 3 
							&& (linha.substring(0, 3).equals(" 20"))) {
						retorno.add(linha);
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				retorno = null;
				log.error("Excecao em TCopiaArquivoErrLog: " + e);
			} catch (IOException e) {
				retorno = null;
				log.error("Excecao em TCopiaArquivoErrLog: " + e);
			}
		}
		arquivo.setLinhas(retorno);
	}

	private boolean isErrHist(File arquivo) {
		// TODO acrescentar validacoes
		if (arquivo.getName().contains("ErrLog_Y")) {
			return true;
		}
		return false;
	}

}

package ms.coleta.ic.juki.errlog;

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
import ms.coleta.ic.juki.TCopiaArquivo;

public class TCopiaArquivoErrLog extends TCopiaArquivo {
	
	public TCopiaArquivoErrLog(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		super(nomeMaquina, diretorioDestino, log);
	}

	public ArquivoErrLog doJob(File arquivoOrigem) {

		if (isErrLog(arquivoOrigem)) {
			return trataArquivoErrLog(arquivoOrigem);
		}
		return null;
	}

	private ArquivoErrLog trataArquivoErrLog(File arquivoOrigem) {
		String nomeArquivoDestino = "errLog-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error("TCopiaArquivo: Erro ao copiar arquivo: " + arquivoOrigem.getName() + " Erro foi: " + e.toString());
			return null;
		}
		
		ArquivoErrLog retorno = new ArquivoErrLog(log);
		retorno.setNomeArquivo(nomeArquivoDestino);
		retorno.setPathArquivo(pathDestino);
		carregaLinhasTratadas(retorno);
		
		retorno.setDataUltimaModificacao(new Date());
		log.info("TCopiaArquivoErrLog: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}

	/**
	 * Le o arquivo em disco, carregando as linhas em memoria
	 * Linhas vazias sao desconsideradas
	 * @param arquivo
	 */
	private void carregaLinhasTratadas(ArquivoErrLog arquivo) {
		List<String> retorno = new ArrayList<String>();
		String loc = arquivo.getPathArquivo() + arquivo.getNomeArquivo();
		File arq = new File(loc);
		if (arq.exists()) {
			BufferedReader br = null;
			String linha = "";
			try {
				br = new BufferedReader(new FileReader(loc));
				while ((linha = br.readLine()) != null) {
					if (!linha.equals("\r\n")) {
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

	private boolean isErrLog(File arquivoOrigem) {
		// TODO acrescentar validacoes
		if(arquivoOrigem.getName().contains("ErrLog.txt")) {
			return true;
		}
		return false;
	}

}

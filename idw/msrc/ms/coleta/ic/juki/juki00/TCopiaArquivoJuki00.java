package ms.coleta.ic.juki.juki00;

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
import ms.coleta.ic.juki.ArquivoJuki;
import ms.coleta.ic.juki.ICJuki;
import ms.coleta.ic.juki.TCopiaArquivo;

public class TCopiaArquivoJuki00 extends TCopiaArquivo{

	public TCopiaArquivoJuki00(String nomeMaquina, String diretorioDestino, IdwLogger log, ICJuki ic) {
		super(nomeMaquina, diretorioDestino, log, ic);
	}

	public ArquivoJuki00 doJob(File arquivoOrigem) {
		return trataArquivoJuki00(arquivoOrigem);
	}

	private ArquivoJuki00 trataArquivoJuki00(File arquivoOrigem) {
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error("TCopiaArquivo: Erro ao copiar arquivo: " + arquivoOrigem.getName() + " Erro foi: " + e.toString());
			return null;
		}
		
		ArquivoJuki00 retorno = new ArquivoJuki00(log);
		retorno.setNomeArquivo(nomeArquivoDestino);
		retorno.setPathArquivo(pathDestino);
		carregaLinhasTratadas(retorno);
		
		retorno.setDataUltimaModificacao(new Date());
		log.info("TCopiaArquivoJuki00: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}

	/**
	 * Le o arquivo em disco, carregando as linhas em memoria
	 * Linhas vazias sao desconsideradas
	 * @param arquivo
	 */
	private void carregaLinhasTratadas(ArquivoJuki00 arquivo) {
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
				log.error("Excecao em TCopiaArquivoJuki00: " + e);
			} catch (IOException e) {
				retorno = null;
				log.error("Excecao em TCopiaArquivoJuki00: " + e);
			}
		}
		arquivo.setLinhas(retorno);
	}

}

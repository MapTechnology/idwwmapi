package ms.coleta.ic.aoiVTRNS;

import java.io.BufferedReader;
import java.io.File;
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

public class TCopiaArquivoAoiVTRNS {
	protected IdwLogger log;
	protected String nomeMaquina;
	protected String pathDestino = "";

	public TCopiaArquivoAoiVTRNS(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
	}

	public ArquivoAoiOmron doJob(File arquivo) {
		if (isAoi(arquivo))
			return trataArquivoAoiOmron(arquivo);
		return null;
	}

	public boolean isAoi(File arquivoOrigem) {
		if (arquivoOrigem.getName().contains("CSV"))
			return true;
		return false;
	}

	private ArquivoAoiOmron trataArquivoAoiOmron(File arquivoOrigem) {
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);

		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.error("Excecao em TCopiaArquivoAoiVTRNS no método TCopiaArquivoAoiVTRNS:" + e);
			return null;
		}

		ArquivoAoiOmron retorno = new ArquivoAoiOmron(log, nomeArquivoDestino, pathDestino);
		carregaLinhasTratadas(retorno);

		log.info("TCopiaArquivoAoiVTRNS: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: "
				+ nomeMaquina + " as:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));

		return retorno;
	}

	private void carregaLinhasTratadas(ArquivoAoiOmron arquivo) {
		List<String> retorno = new ArrayList<String>();
		String loc = arquivo.getPathArquivo() + arquivo.getNomeArquivo();

		File arq = new File(loc);

		if (arq.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			String linhaAtual = "";
			try {
				fr = new FileReader(loc);
				br = new BufferedReader(fr);
				
				// cabecalho deve ser ignorado
				br.readLine();
				while ((linhaAtual = br.readLine()) != null) {
					retorno.add(linhaAtual);
				}
			} catch (IOException e) {
				log.error("TCopiaArquivoAoiVTRNS: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
						+ " variavel linhaAtual: " + linhaAtual + e);
			} finally {
				try {
					if (br != null) {
						br.close();
					}
					if (fr != null) {
						fr.close();
					}
				} catch (IOException ex) {
					log.error("TCopiaArquivoAoiVTRNS: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
							+ " " + ex);
				}
			}
		}
		arquivo.setLinhas(retorno);
	}

}


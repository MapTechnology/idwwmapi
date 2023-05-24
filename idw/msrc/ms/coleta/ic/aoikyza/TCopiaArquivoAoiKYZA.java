package ms.coleta.ic.aoikyza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class TCopiaArquivoAoiKYZA {
	protected IdwLogger log;
	protected String nomeMaquina;
	protected String pathDestino = "";

	public TCopiaArquivoAoiKYZA(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino; 
		this.log = log;
	}

	public ArquivoAoiKYZA doJob(File arquivo) {
		if (isAoi(arquivo))
			return trataArquivoAoiKYZA(arquivo);
		return null;
	}

	public boolean isAoi(File arquivoOrigem) {
		if (arquivoOrigem.getName().contains("csv"))
			return true;
		return false;
	}

	private ArquivoAoiKYZA trataArquivoAoiKYZA(File arquivoOrigem) {
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);

		try {
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			log.info("Excecao em TCopiaArquivoAoiKYZA no método TCopiaArquivoAoiKYZA:" + e);
			return null;
		}

		ArquivoAoiKYZA retorno = new ArquivoAoiKYZA(log, nomeArquivoDestino, pathDestino, arquivoOrigem.getName(), arquivoOrigem.getAbsolutePath());
		carregaLinhasTratadas(retorno);

		log.info("TCopiaArquivoAoiKYZA: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: "
				+ nomeMaquina + " as:" + DataHoraRN.getDataHoraAtualFormatada() );

		return retorno;
	}

	private void carregaLinhasTratadas(ArquivoAoiKYZA arquivo) {
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
				log.info("TCopiaArquivoAoiKYZA: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
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
					log.info("TCopiaArquivoAoiKYZA: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
							+ " " + ex);
				}
			}
		}
		arquivo.setLinhas(retorno);
	}

}

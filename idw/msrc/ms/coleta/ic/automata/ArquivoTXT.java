package ms.coleta.ic.automata;

import idw.util.IdwLogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArquivoTXT {
	
	public static final String ULTIMA_LINHA_PROCESSADA_TXT="-ultimalinhaprocessada.txt";
	public static final String ULTIMO_ARQUIVO_PROCESSADO_TXT="ultimo-arquivo-processado.txt";
	
	private IdwLogger log;
	private String caminho;
	
	public ArquivoTXT(IdwLogger log, String caminho) {
		this.log = log;
		this.caminho = caminho;
	}
	
	public String getUltimaLinhaProcessada(String nomeArquivo) {
		String arquivoUltimaLinha = caminho + "//" + nomeArquivo + ULTIMA_LINHA_PROCESSADA_TXT;
		File arq = new File(arquivoUltimaLinha);
		String retorno = null;
		if (arq.exists()) {
			retorno = getPrimeiraLinhaDoArquivo(arquivoUltimaLinha);
		}
		return retorno;
	}
	
	public void setUltimaLinhaProcessada(String nomeArquivo, String novaUltimaLinha) {
		String arquivoUltimaLinha = caminho + "//" + nomeArquivo + ULTIMA_LINHA_PROCESSADA_TXT;
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoUltimaLinha));
			br.append(novaUltimaLinha);
			br.close();
		} catch (Exception e) {
			log.error("ArquivoLogAutomata: Erro ao obter ultima linha: " + e.toString());
		}
	}
	
	public String getUltimoArquivoLido() {
		String ultimoArquivoLido = caminho + "//" + ULTIMO_ARQUIVO_PROCESSADO_TXT;
		File arq = new File(ultimoArquivoLido);
		String retorno = null;
		if (arq.exists()) {
			retorno = getPrimeiraLinhaDoArquivo(ultimoArquivoLido);
		}
		return retorno;
	}
	
	public void setUltimoArquivoLido(String novoUltimoArquivoLido) {
		String ultimoArquivo = caminho + "//" + ULTIMO_ARQUIVO_PROCESSADO_TXT;
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(ultimoArquivo));
			br.append(novoUltimoArquivoLido);
			br.close();
		} catch (Exception e) {
			log.error("ArquivoLogAutomata: Erro ao obter ultima linha: " + e.toString());
		}
	}
	
	private String getPrimeiraLinhaDoArquivo(String arquivo) {
		String retorno = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = br.readLine()) != null) {
				retorno = linha;
			}
			br.close();

		} catch (Exception e) {
			log.error("ArquivoLogAutomata: Erro ao obter ultima linha: " + e.toString());
		}
		return retorno;
	}
}

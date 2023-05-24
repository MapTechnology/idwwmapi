package ms.coleta.ic.automata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;

public class LerArquivo {

	private File arquivo = null;
	private String caminho = "";

	private int idLog;
	private IdwLogger log;	
	
	public LerArquivo(
			File arquivo,
			String caminho,
			IdwLogger log) {
		
		this.arquivo = arquivo;
		this.caminho = caminho;
		
		this.log = log;
		this.idLog = log.getIdAleatorio();
	}

	public ArquivoAutomata lerGerandoArquivoAutomata() {
		ArquivoAutomata retorno = null;
		List<String> fileLinhas = new ArrayList<String>();

		// Carrega arquivo em memoria
		BufferedReader br = null;
		String linha = "";
		try {
			br = new BufferedReader(new FileReader(caminho + "//"
					+ arquivo.getName()));
			while ((linha = br.readLine()) != null) {
				fileLinhas.add(linha);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(idLog, 0, "TrataLogAutomata: Erro: " + e);
		}

		retorno = new ArquivoAutomata(log, fileLinhas);
		retorno.setNomeArquivo(arquivo.getName());
		retorno.setPathArquivo(caminho);

		return retorno;
	}

	
}
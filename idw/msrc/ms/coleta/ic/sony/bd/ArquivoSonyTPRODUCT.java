package ms.coleta.ic.sony.bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.model.dto.EventoColetado;

public class ArquivoSonyTPRODUCT extends ArquivoSony {

	private IdwLogger log;

	// private List<String> linhas = new ArrayList<>();

	// public ArquivoSonyTPRODUCT(IdwLogger log, List<String> linhas) {
	public ArquivoSonyTPRODUCT(IdwLogger log) {
		super(log);
		this.log = log;
	}

	public List<EventoColetado> obtemEvento(ICSony ic) {
		// Source
		// File arq = new File(getPathArquivo() + "//" + getNomeArquivo());
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(getPathArquivo() + "//" + getNomeArquivo()));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			log.info("Excessao: ", e1);
		}

		// Eventos e controle
		boolean isEncontrouLinha = false;
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		int numeroLinhasLidas = 0;

		// --

		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;

		try {			
			scanner.useDelimiter("\r\n");
			while (scanner.hasNext()) {
				String line = scanner.next();
				numeroLinhasLidas++;
				
				line = line.replace("\r", "");
				
				if (!line.contains("DDATETIME")) { // Se a linha nao e cabecalho
					if (isEncontrouLinha) {
						processarLinha(ic, retorno, line);
						ultimaLinhaProcessada = line;
					}
					if (line.equals(ultimaLinhaProcessada))
						isEncontrouLinha = true;
				}
			}

			log.info("Numero de linhas enquanto procurava a ultimaLinhaProcessada: " + numeroLinhasLidas);
			log.info("isEncontrouLinha = " + isEncontrouLinha);
			
			if(scanner != null)
				scanner.close();
			
			// Reabre o arquivo
			try {
				scanner = new Scanner(new File(getPathArquivo() + "//" + getNomeArquivo()));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				log.info("Excessao: ", e1);
			}

			// Se a ultima linha nunca foi encontrada, entao processar todo
			// arquivo
			if (isEncontrouLinha == false) {
				// Modificar pra ler todo o arquivo
				scanner.useDelimiter("\r\n");
				while (scanner.hasNext()) {
					String line = scanner.next();
					line = line.replace("\r", "");
					
					if (!line.contains("DDATETIME")) { // Se a linha nao e cabecalho
						processarLinha(ic, retorno, line);
						ultimaLinhaProcessada = line;
					}
				}
			}
		} catch (Exception e) {
			log.info("Excessao: ", e);
			e.printStackTrace();
		} finally {
			/* Salvara a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
			// Fechamento do acesso a arquivo
			if(scanner != null)
				scanner.close();
		}
		return retorno;
	}

	protected void processarLinha(ICSony ic, List<EventoColetado> retorno, String linha) {
		LinhaArquivoSonyTPRODUCT linhaTratada = new LinhaArquivoSonyTPRODUCT(log, linha, ic, getIcUpDTO());
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
		}
	}

	protected String getUltimaLinha(ICSony ic, String cdUp) {
		// Controle
		int attempts = 0;

		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo()
				+ "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		String retorno = null;

		if (ic.getUltimasLinhasProcessadas().containsKey(cdUp)) {
			LinhaArquivoSonyTPRODUCT la = ic.getUltimasLinhasProcessadas().get(cdUp);
			log.info("ArquivoSony: Ultima linha obtida por get por getUltimaLinha metodo 1 : "
					+ la.getLinha());
			return la.getLinha();
		}
		for (attempts = 0; attempts <= 3; attempts++) {
			if (arq.exists()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(
							arquivoUltimaLinha));
					String linha;
					while ((linha = br.readLine()) != null) {
						retorno = linha;
					}
					br.close();
					// Debug
					log.info("ArquivoSony: Ultima linha obtida por get por getUltimaLinha metodo 2: "
							+ retorno);

				} catch (FileNotFoundException e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: "
							+ e.toString());
					retorno = null;
				} catch (IOException e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: "
							+ e.toString());
					retorno = null;
				} catch (Exception e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: "
							+ e.toString());
					retorno = null;
				}

				if (retorno != null)
					break;
				else {
					try {
						// Adormece thread por 30 segundos
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						log.error("ArquivoLogSony: Erro ao dar sleep entre os obter ultima linha: "
								+ e.toString());
					}
				}
			} // Fim do IF
		} // Fim do For

		return retorno;
	}
}

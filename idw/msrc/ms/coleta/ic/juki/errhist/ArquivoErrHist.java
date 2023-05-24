package ms.coleta.ic.juki.errhist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import idw.util.IdwLogger;
import ms.coleta.ic.juki.ArquivoJuki;
import ms.coleta.ic.juki.ICJuki;
import ms.model.dto.EventoColetado;

public class ArquivoErrHist extends ArquivoJuki{

	public ArquivoErrHist(IdwLogger log) {
		super(log);
	}

	public List<EventoColetado> obtemEvento(ICJuki ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		int forIndex = 0;
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		try {
			forIndex = 0;
			for (String linha : linhas) {
				if (isEncontrouLinha) {
					processarLinha(ic, retorno, linha, forIndex);
					ultimaLinhaProcessada = linha;
					forIndex++;
				}
				if (linha.equals(ultimaLinhaProcessada))
					isEncontrouLinha = true;
			}
			
			// Se a ultima linha nunca foi encontrada, entao processar todo arquivo
			if (isEncontrouLinha == false) {
				forIndex = 0;
				for (String linha : linhas) {
					processarLinha(ic, retorno, linha, forIndex);
					ultimaLinhaProcessada = linha;
					forIndex++;
				}
			}
		} catch (Exception e) {
			log.info("Excessao: ", e);
			e.printStackTrace();
		} finally {
			/* Salva a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}		
		return retorno;
	}

	@Override
	protected void processarLinha(ICJuki ic, List<EventoColetado> retorno, String linha, int forIndex) {
		LinhaArquivoJukiErrHist linhaTratada = new LinhaArquivoJukiErrHist(log, linha, ic, getIcUpDTO(), getDataUltimaModificacao());
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
		}
	}

	@Override
	protected String getUltimaLinha(ICJuki ic, String cdUp) {
		// Controle
				int attempts = 0;

				String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo() + "-ultimalinhaprocessada.txt";
				File arq = new File(arquivoUltimaLinha);
				String retorno = null;

				if (ic.getUltimasLinhasProcessadasErrHist().containsKey(cdUp)) {
					LinhaArquivoJukiErrHist la = ic.getUltimasLinhasProcessadasErrHist().get(cdUp);
					return la.getLinha();
				}
				for (attempts = 0; attempts <= 3; attempts++) {
					if (arq.exists()) {
						try {
							BufferedReader br = new BufferedReader(new FileReader(arquivoUltimaLinha));
							String linha;
							while ((linha = br.readLine()) != null) {
								retorno = linha;
							}
							br.close();
							// Debug
							log.info("ArquivoErrLog: Ultima linha obtida por get por getUltimaLinha: " + retorno);

						} catch (FileNotFoundException e) {
							log.error("ArquivoErrLog: Erro ao obter ultima linha: " + e.toString());
							retorno = null;
						} catch (IOException e) {
							log.error("ArquivoErrLog: Erro ao obter ultima linha: " + e.toString());
							retorno = null;
						} catch (Exception e) {
							log.error("ArquivoErrLog: Erro ao obter ultima linha: " + e.toString());
							retorno = null;
						}

						if (retorno != null)
							break;
						else {
							try {
								// Adormece thread por 30 segundos
								Thread.sleep(30000);
							} catch (InterruptedException e) {
								log.error("ArquivoLogSony: Erro ao dar sleep entre os obter ultima linha: " + e.toString());
							}
						}
					} // Fim do IF
				} // Fim do For
				return retorno;
	}

}

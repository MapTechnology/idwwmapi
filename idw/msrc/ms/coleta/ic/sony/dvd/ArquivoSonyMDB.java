package ms.coleta.ic.sony.dvd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.model.dto.EventoColetado;

public class ArquivoSonyMDB extends ArquivoSony{
	
	private List<String> linhas;
	
	public ArquivoSonyMDB(IdwLogger log, List<String> linhas) {
		//super(log, linhas);
		super(log);
		this.linhas = linhas;
	}

	private IdwLogger log = getLog();

	@Override
	public List<EventoColetado> obtemEvento(ICSony ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		
		try {
			for (String linha : getLinhas()) {
				if (isEncontrouLinha) {
					processarLinha(ic, retorno, linha);
					ultimaLinhaProcessada = linha;
				}
				if (linha.equals(ultimaLinhaProcessada))
					isEncontrouLinha = true;
			}
			
			// Se a ultima linha nunca foi encontrada, entao processar todo arquivo
			if (isEncontrouLinha == false) {
				for (String linha : getLinhas()) {
					processarLinha(ic, retorno, linha);
					ultimaLinhaProcessada = linha;
				}
			}
		} catch (Exception e) {
			log.info("Excessao:", e);
			e.printStackTrace();
		} finally {
			/* Salvara a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}
		
		return retorno;
	}

	@Override
	protected void processarLinha(ICSony ic, List<EventoColetado> retorno, String linha) {
		LinhaArquivoSonyMDB linhaTratada = new LinhaArquivoSonyMDB(log, linha, ic, getIcUpDTO());
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			log.info("Processando linha: " + linhaTratada.toString());
			retorno.addAll(linhaTratada.obtemEvento());
		}

	}


	protected String getUltimaLinha(ICSony ic, String cdUp) {
		// Controle
		int attempts = 0;
		
		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo() + "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		String retorno = null;
		
		
		if (ic.getUltimasLinhasProcessadasMDB().containsKey(cdUp)) {
			LinhaArquivoSonyMDB la = ic.getUltimasLinhasProcessadasMDB().get(cdUp);
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
					log.info("ArquivoSony: Ultima linha obtida por get por getUltimaLinha: " + retorno);
	
				} catch (FileNotFoundException e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: " + e.toString());
					retorno = null;
				} catch (IOException e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: " + e.toString());
					retorno = null;
				} catch (Exception e) {
					log.error("ArquivoLogSony: Erro ao obter ultima linha: " + e.toString());
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

	public List<String> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<String> linhas) {
		this.linhas = linhas;
	}

}

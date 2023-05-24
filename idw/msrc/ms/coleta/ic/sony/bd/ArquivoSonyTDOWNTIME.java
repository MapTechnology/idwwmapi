package ms.coleta.ic.sony.bd;

import idw.util.IdwLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.model.dto.EventoColetado;

public class ArquivoSonyTDOWNTIME extends ArquivoSony{
	
	private IdwLogger log;
	
	private List<String> linhas = new ArrayList<>();

	public ArquivoSonyTDOWNTIME(IdwLogger log) {
		super(log);
		this.log = log;
	}

	@Override
	public List<EventoColetado> obtemEvento(ICSony ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		
		// Carrega arquivo em memoria
		carregarLinhas();
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		
		try {
			for (String linha : linhas) {
				if (isEncontrouLinha) {
					processarLinha(ic, retorno, linha);
					ultimaLinhaProcessada = linha;
				}
				if (linha.equals(ultimaLinhaProcessada))
					isEncontrouLinha = true;
			}
			
			// Se a ultima linha nunca foi encontrada, entao processar todo arquivo
			if (isEncontrouLinha == false) {
				for (String linha : linhas) {
					processarLinha(ic, retorno, linha);
					ultimaLinhaProcessada = linha;
				}
			}
		} catch (Exception e) {
			log.info("ArquivoSonyTDOWNTIME: Excessao em obtemEvento: ", e);
			e.printStackTrace();
		} finally {
			/* Salvara a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}		
		return retorno;
	}

	@Override
	protected void processarLinha(ICSony ic, List<EventoColetado> retorno, String linha) {
		LinhaArquivoSonyTDOWNTIME linhaTratada = new LinhaArquivoSonyTDOWNTIME(log, ic, getIcUpDTO(), linha);
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
		}
	}
	
	private void carregarLinhas() {
		File arquivo = new File(getPathArquivo() + "//" + getNomeArquivo());
		
		if (arquivo.exists()) {
			BufferedReader br = null;
			String linha = "";
			try {
				br = new BufferedReader(new FileReader(getPathArquivo() + "//" + getNomeArquivo()));
				linha = br.readLine();
				while (linha != null) {
					linhas.add(linha);
					linha = br.readLine();
				}
				br.close();
				
				// Remove cabecalho
				linhas.remove(0);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("ArquivoSonyTDOWNTIME: Erro ao carregar as linhas do arquivo: " + e);
			}
		} else {
			log.error("ArquivoSonyTDOWNTIME: Erro ao carregar as linhas do arquivo, arquivo nao encontrado: " 
		+ getPathArquivo() + "//" + getNomeArquivo() );
		}
	}


	protected String getUltimaLinha(ICSony ic, String cdUp) {
		// Controle
		int attempts = 0;

		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo()
				+ "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		String retorno = null;
		// Checando em memoria
		if (ic.getUltimasLinhasProcessadasTDOWNTIME().containsKey(cdUp)) {
			LinhaArquivoSonyTDOWNTIME ultimaLinhaObtida = ic.getUltimasLinhasProcessadasTDOWNTIME().get(cdUp);
			log.info("ArquivoSony: Ultima linha obtida por get por getUltimaLinha metodo 1 : "
					+ ultimaLinhaObtida.getLinha());
			return ultimaLinhaObtida.getLinha();
		}
		// Checando em arquivo
		for (attempts = 0; attempts <= 3; attempts++) {
			if (arq.exists()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(arquivoUltimaLinha));
					String linha;
					while ((linha = br.readLine()) != null) {
						retorno = linha;
					}
					br.close();
					
					log.info("ArquivoSony: Ultima linha obtida por get por getUltimaLinha metodo 2: "
							+ retorno);

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
						log.error("ArquivoLogSony: Erro ao dar sleep entre os obter ultima linha: "
								+ e.toString());
					}
				}
			} // Fim do IF
		} // Fim do For

		return retorno;
	}
	
} // Fim da classe

package ms.coleta.ic.sony.bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import ms.coleta.ic.sony.ArquivoSony;
import ms.coleta.ic.sony.ICSony;
import ms.model.dto.EventoColetado;
// import ms.model.dto.IcUpDTO;

public class ArquivoSonyTALARM extends ArquivoSony{
	
	private IdwLogger log;
	private List<String> linhas = new ArrayList<>();
	// private String nomeArquivo;
	// private IcUpDTO icUpDTO;
	
	public ArquivoSonyTALARM(IdwLogger log, List<String> linhas) {
		//super(log, linhas);
		super(log);
		this.log = log;
		this.linhas = linhas;
	}

	@Override
	public List<EventoColetado> obtemEvento(ICSony ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		
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
			log.info("Excessao: ", e);
			e.printStackTrace();
		} finally {
			/* Salvara a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}		
		return retorno;
	}

	@Override
	protected void processarLinha(ICSony ic, List<EventoColetado> retorno, String linha) {
		LinhaArquivoSonyTALARM linhaTratada = new LinhaArquivoSonyTALARM(log, linha, ic, getIcUpDTO());
		List<EventoColetado> eventosObtidos = null;
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			eventosObtidos = linhaTratada.obtemEvento();
			retorno.addAll(eventosObtidos);
//			if(!eventosObtidos.isEmpty())
//				ultimaParadaPorMachineID.put(linhaTratada.getsMachineId(), linhaTratada);
		}
		
	}

	protected String getUltimaLinha(ICSony ic, String cdUp) {
		// Controle
		int attempts = 0;
		
		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo() + "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		String retorno = null;
		
		
		if (ic.getUltimasLinhasProcessadasTALARM().containsKey(cdUp)) {
			LinhaArquivoSonyTALARM la = ic.getUltimasLinhasProcessadasTALARM().get(cdUp);
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
}

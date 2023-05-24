package ms.coleta.ic.fornos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class ArquivoData {
	private IdwLogger log;
	// nomeArquivoDestino
	private String nomeArquivo;
	// pathDestino
	private String pathArquivo;
	
	private IcUpDTO icUpDTO;
	private Date dataUltimaModificacao;
	
	protected List<String> linhas = new ArrayList<>();

	public ArquivoData(IdwLogger log, String nomeArquivoDestino, String pathDestino) {
		this.log = log;
		this.nomeArquivo = nomeArquivoDestino;
		this.pathArquivo = pathDestino;
	}

	public List<EventoColetado> obtemEvento(ICForno ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, icUpDTO.getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		int numeroLinhasLidas = 0;
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		try {
			for (String linha : linhas) {
				if (isEncontrouLinha) {
					processarLinha(ic, retorno, linha, numeroLinhasLidas);
					ultimaLinhaProcessada = linha;	
					
				} else if (linha.equals(ultimaLinhaProcessada))
					isEncontrouLinha = true;
				numeroLinhasLidas++;
			}
			
			 numeroLinhasLidas = 0;
			// Se a ultima linha nunca foi encontrada, entao processar todo arquivo
			if (isEncontrouLinha == false) {
				for (String linha : linhas) {
					processarLinha(ic, retorno, linha, numeroLinhasLidas);
					ultimaLinhaProcessada = linha;	
					numeroLinhasLidas++;
				}
			}
		} catch (Exception e) {
			log.error("ArquivoData: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
			e.printStackTrace();
		} finally {
			/* Salva a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}	
		
		return retorno;
	}
	
	protected void processarLinha(ICForno ic, List<EventoColetado> retorno, String linha, int forIndex) {
		LinhaArquivoData linhaTratada = new LinhaArquivoData(log, ic, icUpDTO, linha, forIndex);
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
		}
	}
	
	private String getUltimaLinha(ICForno ic, String cdUp) {
		// Checando em memoria
		if (ic.getUltimasLinhasProcessadasData().containsKey(cdUp)) {
			LinhaArquivoData ultimaLinhaObtida = ic.getUltimasLinhasProcessadasData().get(cdUp);
			log.info("ArquivoData: Ultima linha obtida por getUltimaLinha metodo 1 : "
					+ ultimaLinhaObtida.getLinha());
			return ultimaLinhaObtida.getLinha();
		}

		// Checa em arquivo
		String retorno = null;
		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo()
				+ "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		if (arq.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(arquivoUltimaLinha));
				String linha = null;
				while ((linha = br.readLine()) != null) {
					retorno = linha;
				}
				br.close();
				log.info("ArquivoData: Ultima linha obtida por getUltimaLinha metodo 2: " + retorno);
				return retorno;
			} catch (Exception e) {
				log.error("ArquivoData: Erro ao obter ultima linha, metodo 2: " + e.toString());
				retorno = null;
			}
		} else {
				log.error("ArquivoData: Nao existe arquivo ultimalinhaprocessada: " + arquivoUltimaLinha);
		} // Fim do IF

		return null;
	}
	
	protected void setUltimaLinha(String novaUltimaLinha) {
		// Controle
		int attempts = 0;
		boolean noErro = true;
		String arquivoUltimaLinha = pathArquivo + "//" + nomeArquivo + "-ultimalinhaprocessada.txt";
		
		for (attempts = 0; attempts <= 3; attempts++) { 
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter(arquivoUltimaLinha));
				br.append(novaUltimaLinha);
				br.close();
				
				// Debug
				log.info("ArquivoData: Ultima linha processada setada por setUltimaLinha: " + novaUltimaLinha);
			} catch (FileNotFoundException e) {
				noErro = false;
				log.error("ArquivoData: Erro ao dar setUltimaLinha na ultima linha: " + e.toString());
			} catch (IOException e) {
				noErro = false;
				log.error("ArquivoData: Erro ao dar setUltimaLinha na ultima linha: " + e.toString());
			}
			
			if (noErro)
				break;
			else {
				try {
					// Adormece thread por 30 segundos
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					log.error("ArquivoData: Erro ao dar sleep entre os setUltimaLinha: " + e.toString());
				}
			}
		} // Fim do for
	}

	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setLinhas(List<String> retorno) {
		this.linhas = retorno;
		
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
	}

	public void setDataUltimaModificacao(Date dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

}

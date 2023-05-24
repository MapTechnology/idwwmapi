package ms.coleta.ic.fuji;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public abstract class ArquivoFuji {
	private String pathArquivo;
	private String nomeArquivo;
	private IcUpDTO icUpDTO;
	private Date dataUltimaModificacao;
	
	protected IdwLogger log;
	protected List<String> linhas = new ArrayList<>();

	public ArquivoFuji(IdwLogger log) {
		super();
		this.log = log;
	}
	
	public abstract List<EventoColetado> obtemEvento(ICFuji ic);
	protected abstract void processarLinha(ICFuji ic, List<EventoColetado> retorno, String linha, int forIndex);
	protected abstract String getUltimaLinha(ICFuji ic, String cdUp);
	
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
				log.info("ArquivoFuji: Ultima linha processada setada por setUltimaLinha: " + novaUltimaLinha);
			} catch (FileNotFoundException e) {
				noErro = false;
				log.error("ArquivoFuji: Erro ao dar setUltimaLinha na ultima linha: " + e.toString());
			} catch (IOException e) {
				noErro = false;
				log.error("ArquivoFuji: Erro ao dar setUltimaLinha na ultima linha: " + e.toString());
			}
			
			if (noErro)
				break;
			else {
				try {
					// Adormece thread por 30 segundos
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					log.error("ArquivoFuji: Erro ao dar sleep entre os setUltimaLinha: " + e.toString());
				}
			}
		} // Fim do for
	}
	
	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

	protected IdwLogger getLog() {
		return log;
	}

	protected void setLog(IdwLogger log) {
		this.log = log;
	}

	public Date getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Date dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}
	public List<String> getLinhas() {
		return linhas;
	}
	public void setLinhas(List<String> linhas) {
		this.linhas = linhas;
	}
}

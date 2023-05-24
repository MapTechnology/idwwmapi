package ms.coleta.ic.automata;

import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class ArquivoAutomata {
	
	public final static String URL_DIRETORIO = "//ColetaAutomata//";
	public final static String EXTENSAO_ARQUIVO_ACEITO = "csv";
		
	private IdwLogger log;
	private List<String> linhas = new ArrayList<>();
	private String pathArquivo;
	private String nomeArquivo;
	private IcUpDTO icUpDTO;
	
	private ArquivoTXT txt;
	
	public ArquivoAutomata(IdwLogger log, List<String> linhas) {
		this.log = log;
		this.linhas = linhas;
		
		txt = new ArquivoTXT(log, getPathArquivo());
	}
	
	public List<EventoColetado> obtemEvento(ICAutomata ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = txt.getUltimaLinhaProcessada(nomeArquivo);
		boolean isEncontrouLinha = false;
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		
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
		
		/* Salvara a ultima linha processada */
		txt.setUltimaLinhaProcessada(nomeArquivo, ultimaLinhaProcessada);
		txt.setUltimoArquivoLido(nomeArquivo);
		return retorno;
	}
	
	protected void processarLinha(ICAutomata ic, List<EventoColetado> retorno, String linha) {
		LinhaArquivoAutomata linhaTratada = new LinhaArquivoAutomata(log, linha, ic, getIcUpDTO());
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
			
			if(linhaTratada.isParada()) {
				ic.getParadas().put(linhaTratada.getOp(), linhaTratada);
			}
		}
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public List<String> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<String> linhas) {
		this.linhas = linhas;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
		txt = new ArquivoTXT(log, getPathArquivo());
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
	
	
}

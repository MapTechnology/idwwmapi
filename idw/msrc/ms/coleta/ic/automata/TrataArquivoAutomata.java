package ms.coleta.ic.automata;

import idw.util.IdwLogger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

import org.apache.commons.vfs2.FileChangeEvent;

public class TrataArquivoAutomata {
	
	private String diretorioDestino;

	private int idLog;
	private IdwLogger log;
	
	private ICAutomata ic;
	private List<IcUpDTO> icUpDTOList;
	
	public TrataArquivoAutomata(
			IdwLogger log,
			ICAutomata ic,
			List<IcUpDTO> icUpDTOList) {
		
		this.log = log;
		this.idLog = log.getIdAleatorio();
		
		this.ic = ic;
		this.icUpDTOList = icUpDTOList;
		
		File catalinaBase = new File(System.getProperty("catalina.base"))
			.getAbsoluteFile();
		this.diretorioDestino = catalinaBase.getAbsolutePath() + ArquivoAutomata.URL_DIRETORIO;
		log.info("DIRETORIO DESTINO " + diretorioDestino);
	}
	
	public synchronized void sincronizarArquivosGerandoEventos(String caminho) {
		IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(caminho);
		
		if(icUpDTO == null) {
			return;
		}
		
		log.info("SINCRONIZANDO ARQUIVOS DO CAMINHO =" + caminho);
					
		criaDiretorioSeNaoExistir(diretorioDestino);
		List<String> arquivosCopiados;
		arquivosCopiados = copiarTodosArquivos(caminho, diretorioDestino);
		
		for(String nomeArquivo : arquivosCopiados) {
			log.info("   ARQUIVO COPIADO =" + nomeArquivo);
			
			String pathname = diretorioDestino + nomeArquivo;
			
			File arquivo = new File(pathname);
			ArquivoAutomata arquivoCopia = lerArquivo(arquivo, diretorioDestino, log);
			
			// Trata as linhas do arquivo copiado
			if (arquivoCopia != null) {
				arquivoCopia.setIcUpDTO(icUpDTO);
				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
				ic.getBufferEventos().addEventos((eventos));
			} else {
				log.error("TrataArquivoGerandoEventos: arquivoCopia nao foi criado com sucesso");
			}
		}
		
	}

	public synchronized void trataArquivoGerandoEventos(FileChangeEvent arg0) {

		if (!arg0.getFile().getName().getExtension().equals(ArquivoAutomata.EXTENSAO_ARQUIVO_ACEITO)) {
			return;
		}

		log.info("LENDO ARQUIVO =" + arg0.getFile().getName().getBaseName());

		File arquivo = new File(arg0.getFile().getName().getPath());
		String urlConexao = arg0.getFile().getName().getURI();

		IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(urlConexao);
		if (icUpDTO != null) {
			
			criaDiretorioSeNaoExistir(diretorioDestino);
			copiarArquivo(icUpDTO.getUrlConexao(), arquivo, diretorioDestino);
			ArquivoAutomata arquivoCopia = lerArquivo(arquivo, diretorioDestino, log);

			// Trata as linhas do arquivo copiado
			if (arquivoCopia != null) {
				arquivoCopia.setIcUpDTO(icUpDTO);
				List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
				ic.getBufferEventos().addEventos((eventos));
			} else {
				log.error("TrataArquivoGerandoEventos: arquivoCopia nao foi criado com sucesso");
			}
		}
	}
	
	private void criaDiretorioSeNaoExistir(String urlDiretorio) {
		File dir = new File(urlDiretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
	
	private List<String> copiarTodosArquivos(String urlConexao, String pathDestino) {
		ArquivoTXT txt = new ArquivoTXT(log, pathDestino);
		CopiaArquivoFTP copiaArquivoFTP = new CopiaArquivoFTP(txt, urlConexao, pathDestino);
		try {
			copiaArquivoFTP.copiarArquivo();
			return copiaArquivoFTP.getArquivosCopiados();
		} catch (IOException e) {
			log.error(
					idLog,
					0,
					"TrataArquivoAutomata: Erro ao copiar arquivos de uma pasta. Erro foi: "
							+ e.toString());
		}
		return new ArrayList<String>();
	}
	
	private void copiarArquivo(String urlConexao, File arquivoOrigem, String pathDestino) {
		if (arquivoOrigem != null) {
			CopiaArquivoFTP copiaArquivoFTP = new CopiaArquivoFTP(urlConexao, arquivoOrigem.getName(), pathDestino);
			try {
				copiaArquivoFTP.copiarArquivo();
			} catch (IOException e) {
				log.error(
						idLog,
						0,
						"TrataArquivoAutomata: Erro ao copiar arquivo: "
								+ arquivoOrigem.getName() + " Erro foi: "
								+ e.toString());
			}
		}
	}
	
	private ArquivoAutomata lerArquivo(File arquivo, String caminho, IdwLogger log) {
		LerArquivo lerArquivo = new LerArquivo(arquivo, caminho, log);
		return lerArquivo.lerGerandoArquivoAutomata();
	}
	
	private IcUpDTO getIcUpDTOFromUrlConexao(String urlConexao) {
		for (IcUpDTO icUpDTOAux : icUpDTOList) {
			if(urlConexao.startsWith(icUpDTOAux.getUrlConexao())) {
				return icUpDTOAux;
			}
		}
		return null;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}
}

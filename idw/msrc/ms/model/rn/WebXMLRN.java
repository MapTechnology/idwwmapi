package ms.model.rn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ms.model.MsFacade;
import ms.model.dto.WebXMLDTO;
import ms.util.ArquivoTexto;
import idw.util.IdwLogger;

public class WebXMLRN {
	private IdwLogger log = new IdwLogger("CONFIGURAÇÃO WEB.XML");

	public boolean configuraWebXML(WebXMLDTO webDTO) {
		log.iniciaAvaliacao("configura webxml");
		StringBuilder linha = null;
		String aux = null;
		boolean controle = false;
		
		ArquivoTexto arquivoTexto = null;
		
		try {
			arquivoTexto = new ArquivoTexto(MsFacade.getInstancia().getCaminhoRelativo() + "\\WEB-INF\\web.xml");
		} catch (FileNotFoundException e) {
			log.paraAvaliacao();
			log.novaMensagem();
			log.addMensagem("Erro, arquivo não encontrado :");
			log.addMensagem(log.getAvaliacaoCompleta());
			log.info();
			return false;
		}

		BufferedReader leitor = new BufferedReader(arquivoTexto.getFileReader());
		List<StringBuilder> linhas = new ArrayList<StringBuilder>();
		linha = new StringBuilder();

		while (linha != null) {
			try {
				String linhaLida = leitor.readLine();
				
				if (linhaLida != null && linhaLida.equals("") == false){
					linha = null;
					linha = new StringBuilder(linhaLida);
				} else
					break;
				
				configuraVersao(linha, leitor, webDTO);

				configuraClassesNaoInicializaveis(linha, leitor, aux, controle, webDTO);

				configuraClassesInicializaveis(linha, leitor, aux, controle, webDTO);
			} catch (IOException e) {
				log.paraAvaliacao();
				log.novaMensagem();
				log.addMensagem("Erro de leitura do arquivo");
				log.addMensagem(arquivoTexto.getFile().getName());
				log.addMensagem(log.getAvaliacaoCompleta());
				log.info();
				arquivoTexto.setErro(true);
				break;
			}

			log.info(linha);
			aux = null;
			linha.append("\n");
			linhas.add(linha);
			controle = false;
		}
		try {
			arquivoTexto.close();
		} catch (IOException e) {
			log.novaMensagem();
			log.addMensagem("Erro no fechamento do arquivo");
			log.addMensagem(arquivoTexto.getFile().getName());
			log.addMensagem(log.getAvaliacaoCompleta());
			log.info();
			arquivoTexto.setErro(true);
		}
		
		if (arquivoTexto.isErro() == false){
			log.info("salvando as configurações...");
			try {
				salvarConfiguracoes(arquivoTexto.getFile(), linhas);
			} catch (IOException e) {
				log.paraAvaliacao();
				log.novaMensagem();
				log.addMensagem("Não foi possivel salvar alteracoes no arquivo");
				log.addMensagem(arquivoTexto.getFile().getName());
				log.addMensagem(log.getAvaliacaoCompleta());
				log.info();
				return false;
			}
	
			log.paraAvaliacao();
			log.novaMensagem();
			log.info("FIM CONFIGURAÇÃO WEB XML :");
			log.addMensagem(arquivoTexto.getFile().getName());
			log.addMensagem(log.getAvaliacaoCompleta());
			log.info();
		}
		
		return !arquivoTexto.isErro();
	}

	private void salvarConfiguracoes(File arquivo, List<StringBuilder> linhas) throws IOException {
		FileWriter writer = new FileWriter(arquivo);
		BufferedWriter escritor = new BufferedWriter(writer);
		StringBuilder lineTemp = null;
		try {
			for (StringBuilder line : linhas) {
				lineTemp = line;
				escritor.write(line.toString());
			}
		} catch (IOException e){
			log.novaMensagem();
			log.info("Nao foi possivel salvar a linha ");
			log.addMensagem(lineTemp.toString());
			log.addMensagem(log.getAvaliacaoCompleta());
			log.info();
			throw new IOException(e);
		} finally {
			try {
				escritor.close();
			} catch (IOException e){
				log.novaMensagem();
				log.info("Nao foi possivel fechar o arquivo");
				log.addMensagem(arquivo.getName());
				log.addMensagem(log.getAvaliacaoCompleta());
				log.info();
				throw new IOException(e);
			}
		}
	}

	private void configuraClassesInicializaveis(StringBuilder linha,
			BufferedReader leitor, String aux, boolean controle,
			WebXMLDTO webDTO) throws IOException {
		
		if (linha.indexOf("<listener>") < 0 && linha.indexOf("<!--") < 0 && (aux == null)) {

			aux = leitor.readLine();

			if (webDTO.getClassesInicializaveis() != null
					&& webDTO.getClassesInicializaveis().size() > 0) {
				for (String c : webDTO.getClassesInicializaveis()) {
					if (aux.contains(c)) {
						controle = true;
					}
				}

				if (controle) {
					linha.append("\n");
					linha.append(aux);
					linha.append("\n");
					linha.append(leitor.readLine());

					linha.delete(0, linha.indexOf("<!--") + 4);
					linha.delete(linha.indexOf("-->"), linha.length());
				} else {
					linha.append("\n");
					linha.append(aux);
					linha.append("\n");
					linha.append(leitor.readLine());
				}
			} else {
				linha.append("\n" + aux + "\n" + leitor.readLine());
			}

		}
	}

	private void configuraClassesNaoInicializaveis(StringBuilder linha,
			BufferedReader leitor, String aux, boolean controle,
			WebXMLDTO webDTO) throws IOException {
		if (linha.toString().contains("<listener>")
				&& !linha.toString().contains("<!--")) {
			aux = leitor.readLine();

			if (webDTO.getClassesNaoInicializaveis() != null
					&& webDTO.getClassesNaoInicializaveis().size() > 0) {
				for (String c : webDTO.getClassesNaoInicializaveis()) {
					if (aux.contains(c)) {
						controle = true;

					}
				}
				if (controle) {
					linha.append("<!--");
					linha.append("\n");
					linha.append(aux);
					linha.append("\n");
					linha.append(leitor.readLine());
					linha.append("-->");					
				} else {
					linha.append("\n");
					linha.append(aux);
					linha.append("\n");
					linha.append(leitor.readLine());
				}

			} else {
				linha.append("\n");
				linha.append(aux);
				linha.append("\n");
				linha.append(leitor.readLine());
			}

		}
	}

	private void configuraVersao(StringBuilder linha, BufferedReader leitor,
			WebXMLDTO webDTO) throws IOException {
		if (linha.toString().contains("<param-name>versaomobile")) {
			leitor.readLine();
			linha.append("\n");
			linha.append("<param-value>");
			linha.append(webDTO.getVersaoMobile());
			linha.append("</param-value>");

		}
	}

	public WebXMLDTO getPropriedadesWebXml() {
		log.iniciaAvaliacao("configura webxml");
		log.info("IINICIO CARREGAR CONFIGURAÇÕES WEB XML");
		WebXMLDTO retorno = new WebXMLDTO();

		StringBuilder linha = null;
		List<StringBuilder> linhas = new ArrayList<StringBuilder>();
		BufferedReader leitor = null;
		FileReader fileReader = null;
		File arquivo = null;
		
		arquivo = new File(MsFacade.getInstancia().getCaminhoRelativo() + "\\WEB-INF\\web.xml");
		linha = new StringBuilder();

		try {
			fileReader = new FileReader(arquivo.getAbsolutePath());
		} catch (FileNotFoundException e1) {
			linha = null;
		}

		leitor = new BufferedReader(fileReader);

		while (linha != null) {

			// Lê uma linha do arquivo xml
			linha = null;
			try {
				String linhaLida = leitor.readLine();
				if (linhaLida != null)
					linha = new StringBuilder(linhaLida);
			} catch (IOException e) {
				linha = null;
			}

			if (linha == null)
				continue;
			
			// A linha lida contem a string, ler a linha seguinte para obter o conteudo
			if (linha.indexOf("<param-name>versaomobile") >= 0) {
				linha = null;
				try {
					String linhaLida = leitor.readLine();
					if (linhaLida != null)
						linha = new StringBuilder(linhaLida);
				} catch (IOException e) {
					linha = null;
				}
				if (linha == null)
					continue;
				
				linha.delete(0, linha.indexOf(">") + 1 );
				linha.delete(linha.indexOf("<"), linha.length());
				retorno.setVersaoMobile(linha.toString());
			}

			if (linha.indexOf("<listener>") >= 0 && linha.indexOf("<!--") < 0) {
				linha = null;
				try {
					String linhaLida = leitor.readLine();
					if (linhaLida != null)
						linha = new StringBuilder(linhaLida);
				} catch (IOException e) {
					linha = null;
				}
				if (linha == null)
					continue;
				
				if (linha.indexOf("MSListener") >= 0) {
					retorno.getClassesInicializaveis().add("MSListener");
				} else if (linha.indexOf("ImportacaoParaPdba") >= 0) {
					retorno.getClassesInicializaveis().add("ImportacaoParaPdba");
				}

			}

			if (linha.indexOf("<listener>") >= 0 && linha.indexOf("<!--") >= 0) {
				linha = null;
				try {
					String linhaLida = leitor.readLine();
					if (linhaLida != null)
						linha = new StringBuilder(linhaLida);
				} catch (IOException e) {
					linha = null;
				}
				if (linha == null)
					continue;
				
				if (linha.indexOf("MSListener") >= 0) {
					retorno.getClassesNaoInicializaveis().add("MSListener");
				} else if (linha.indexOf("ImportacaoParaPdba") >= 0) {
					retorno.getClassesNaoInicializaveis().add("ImportacaoParaPdba");
				}

			}
			linha.append("\n");
			linhas.add(linha);
		}
		linha = null;
		arquivo = null;

		try {
			leitor.close();
		} catch (IOException e) {
			log.info("Erro no fechamento do arquivo leitor", e);
		}
		

		try {
			if (fileReader != null)
				fileReader.close();
		} catch (IOException e) {
			log.info("Erro no fechamento do arquivo fileReader", e);
		}

		
		log.paraAvaliacao();
		log.info("FIM CARREGAR CONFIGURAÇÕES WEB XML");
		return retorno;
	}

}

package ms.coleta.ic.fornos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileSystemException;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.ArquivoFuji;

public class TCopiaArquivoData {
	protected IdwLogger log;
	protected String nomeMaquina;
	protected String pathDestino = "";
	
	public TCopiaArquivoData(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
	}
	
	public ArquivoData doJob(File arquivo) {
		if (isData(arquivo))
			return trataArquivoData(arquivo);
		return null;
	}
	
	public ArquivoData doJob(File arquivo, FileChangeEvent arg0) {
		if (isData(arquivo))
			return trataArquivoData(arquivo, arg0);
		return null;
	}
	
	
	
	public boolean isData(File arquivoOrigem) {
		if (arquivoOrigem.getName().contains("data"))
			return true;
		return false;
	}
	
	private ArquivoData trataArquivoData(File arquivoOrigem, FileChangeEvent arg0){
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		
		Path arquivoOrigemFixed = null;
		
		try {
			arquivoOrigemFixed = (new File(arg0.getFile().getURL().getFile())).toPath();
			//Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(arquivoOrigemFixed, pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			log.error("Excecao em TCopiaArquivoData no método trataArquivoData:" + e);
			return null;
		}
	
		ArquivoData retorno = new ArquivoData(log, nomeArquivoDestino, pathDestino);
		carregaLinhasTratadas(retorno);
		
		retorno.setDataUltimaModificacao(new Date());
		log.info("TCopiaArquivoFujiFlexa: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}
	
	private ArquivoData trataArquivoData(File arquivoOrigem){
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		
		try {
			
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			log.error("Excecao em TCopiaArquivoData no método trataArquivoData:" + e);
			return null;
		}
	
		ArquivoData retorno = new ArquivoData(log, nomeArquivoDestino, pathDestino);
		carregaLinhasTratadas(retorno);
		
		retorno.setDataUltimaModificacao(new Date());
		log.info("TCopiaArquivoFujiFlexa: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}
	
	private void carregaLinhasTratadas(ArquivoData arquivo) {
		List<String> retorno = new ArrayList<String>();
		String loc = arquivo.getPathArquivo() + arquivo.getNomeArquivo();
		File arq = new File(loc);
		FileInputStream fis = null;
		InputStreamReader isr = null;
		String encodingName;
		if (arq.exists()) {
			BufferedReader br = null;
			String linha = "";

			try {
				// Obtencao do encoding utilizado no arquivo
				fis = new FileInputStream(loc);
				isr = new InputStreamReader(fis);
				encodingName = isr.getEncoding();
				br = new BufferedReader(new FileReader(loc));
				
				// Os arquivos de log podem ter dois padroes (ate agora) diferentes
				// para encodar as strings
				// Apesar da  codificacao aparecer como ucs-2 no Notepad++,
				// o encondigName aparece como cp1252
				// if (encodingName != null && encodingName.contains("ucs-2")) {
				
				// Ailton 2018-07-23: foi verificado que na verdade a ocorrencia de arquivos com
				// codificacao utf-8 é devida a presenca de arquivos em branco. Ou seja,
				// apenas os arquivos vazios sao utf-8, os demais sao ucs-2 LE
				if (encodingName != null && encodingName.toLowerCase().contains("cp1252")) {
					while ((linha = br.readLine()) != null) {
						linha = ucs2ToUTF8(linha.getBytes());
						if (!linha.equals("\r\n") && !linha.equals("")
								&& !linha.equals("ï¿½")) {
							retorno.add(linha);
						}
					}
				} else {
					while ((linha = br.readLine()) != null) {
						if (!linha.equals("\r\n") && !linha.equals("")
								&& !linha.equals("ï¿½")) {
							retorno.add(linha);
						}
					}
				}
			} catch (Exception e) {
				//retorno = null;
				log.error("TCopiaArquivoData: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
						+ " " + e);
			} finally {
				try {
					br.close();
					if (fis != null)
						fis.close();
					if (isr != null)
						isr.close();
				} catch (IOException e) {
					log.error("TCopiaArquivoData: Excecao ao fechar handler de arquivos: " + arquivo.getNomeArquivo()
					+ " " + e);
				}
			}
		}
		arquivo.setLinhas(retorno);
	}
	
	public String ucs2ToUTF8(byte[] ucs2Bytes){
		  
	    String unicode = null;
	    String utf8 = null;
		try {
			unicode = new String(ucs2Bytes, "UTF-16");
			utf8 = new String(unicode.getBytes("UTF-8"), "Cp1252");
		} catch (Exception e) {
			log.error("Excecao em TCopiaArquivoData ao converter linha; ucs2ToUTF8: " + e);
			return "";
		}  
	     
	     
	    return utf8;  
	}
	
}
	
	
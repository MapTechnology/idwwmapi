package ms.coleta.ic.aoi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.vfs2.FileChangeEvent;

import idw.util.IdwLogger;


public class TCopiaArquivoAoiTri7500 {
	protected IdwLogger log;
	protected String nomeMaquina;
	protected String pathDestino = "";
	
	public TCopiaArquivoAoiTri7500(String nomeMaquina, String diretorioDestino, IdwLogger log) {
		this.nomeMaquina = nomeMaquina;
		this.pathDestino = diretorioDestino;
		this.log = log;
	}
	
	public ArquivoAoiTri7500 doJob(File arquivo) {
		if (isAoi(arquivo))
			return trataArquivoAoiTri7500(arquivo);
		return null;
	}
	
	public ArquivoAoiTri7500 doJob(File arquivo, FileChangeEvent arg0) {
		if (isAoi(arquivo))
			return trataArquivoAoiTri7500(arquivo, arg0);
		return null;
	}
	
	public boolean isAoi(File arquivoOrigem) {
		if (arquivoOrigem.getName().contains("AOI"))
			return true;
		return false;
	}
	
	private ArquivoAoiTri7500 trataArquivoAoiTri7500(File arquivoOrigem, FileChangeEvent arg0){
		String nomeArquivoDestino = arquivoOrigem.getName() + "-" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		
		Path arquivoOrigemFixed = null;
		
		try {
			arquivoOrigemFixed = (new File(arg0.getFile().getURL().getFile())).toPath();
			Files.copy(arquivoOrigemFixed, pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			log.error("Excecao em TCopiaArquivoAoiTri7500 no método trataArquivoAoiTri7500:" + e);
			return null;
		}
	
		ArquivoAoiTri7500 retorno = new ArquivoAoiTri7500(log, nomeArquivoDestino, pathDestino);
		carregaLinhasTratadas(retorno);
		
		log.info("TCopiaArquivoAoiTri7500: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}
	
	private ArquivoAoiTri7500 trataArquivoAoiTri7500(File arquivoOrigem){
		if(arquivoOrigem.getName().contains(".dat") == false) {
			return null;
		}
		String nomeArquivoDestino = arquivoOrigem.getName() + "--" + nomeMaquina + ".txt";
		String arquivoDestino = pathDestino + "//" + nomeArquivoDestino;
		Path pathArquivoDestino = Paths.get(arquivoDestino);
		
		try {
			
			Files.copy(arquivoOrigem.toPath(), pathArquivoDestino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			log.error("Excecao em TCopiaArquivoAoiTri7500 no método trataArquivoAoiTri7500:" + e);
			return null;
		}
		ArquivoAoiTri7500 retorno = new ArquivoAoiTri7500(log, nomeArquivoDestino, pathDestino);
		retorno.setArquivoDestino(pathArquivoDestino);
		retorno.setNomeOriginal(arquivoOrigem.toPath());
		carregaLinhasTratadas(retorno);
		
		log.info("TCopiaArquivoAoiTri7500: Arquivo: " + arquivoOrigem.getName() + " copiado com sucesso para a maquina: " 
				+ nomeMaquina + " as:"  + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		
		return retorno;
	}
	
	private void carregaLinhasTratadas(ArquivoAoiTri7500 arquivo) {
		List<String> retorno = new ArrayList<String>();
		String loc = arquivo.getPathArquivo() + arquivo.getNomeArquivo();
		
		File arq = new File(loc);
		
		if (arq.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			//String linha = "";

			try {
				
				fr = new FileReader(loc);
				br = new BufferedReader(fr);
							
				String linhaAtual = "";
			
				while((linhaAtual = br.readLine()) != null) {
				
					retorno.add(linhaAtual);
				}
			
			} catch (IOException e) {
			
				log.error("TCopiaArquivoAoiTri7500: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
				+ " " + e);
		
			} finally {
			
				try {
				
					if (br != null) {
					br.close();
					}
				
					if (fr != null) {
					fr.close();
					}
				} catch (IOException ex) {
				
					log.error("TCopiaArquivoAoiTri7500: Excecao ao ler arquivo: " + arquivo.getNomeArquivo()
					+ " " + ex);
				}
			}

			

		}
		arquivo.setLinhas(retorno);
	}

}

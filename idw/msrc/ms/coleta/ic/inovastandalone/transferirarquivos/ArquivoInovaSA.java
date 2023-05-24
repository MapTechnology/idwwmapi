package ms.coleta.ic.inovastandalone.transferirarquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import idw.util.ArquivoEscrita;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

public class ArquivoInovaSA {

	private String dirPath = null;
	private String fileName = null;
	private IdwLogger log = null;
	private ArquivoEscrita arquivo = null;
	private LinkedList<String> lines= null;
	
	public ArquivoInovaSA(String dirPath, String fileName, IdwLogger log) {
		this.dirPath = dirPath;
		this.fileName = fileName;
		this.log = log;
		this.lines = null;
		this.arquivo = null;
	}
	
	public boolean openOrCreateFile() {
		if(fileName == null || dirPath == null || log == null)
			return false;
		
		// Se o arquivo nao existir, criar
		try{
			ArquivosDiretorios.criarDiretorioSeNaoexistir(dirPath);
		} catch(Exception e) {
			log.debug("Nao conseguiu criar diretorio [" + dirPath + "]");
			return false;
		}
		
		try {
			arquivo = new ArquivoEscrita(new FileWriter(new File(dirPath + fileName), false));
		} catch (Exception e) {
			try {
				log.debug("Falhou criacao de arquivo = " + dirPath + fileName);
			} catch(Exception e1) {
				if(log != null)
					log.info("Falhou criacao de arquivo", e);
			}
			return false;
		} 
		
		return true;
	}
	
	public void addLineToBeWritten(String line) {
		if(lines == null)
			lines = new LinkedList<String>();
		lines.add(line);
	}
	
	public boolean writeLinesToFile() {
		if(arquivo == null || lines == null || fileName == null || dirPath == null || log == null)
			return false;
		
		try {
			while(lines.isEmpty() == false) {
				String lineToBeWritten = null;
				try {
					lineToBeWritten = lines.removeFirst();
				} catch(NoSuchElementException e) {
					break;
				}
				if(lineToBeWritten != null)
					arquivo.writeLine(lineToBeWritten);
			}
		} catch (IOException e) {
			log.debug("Falhou escrita de arquivo = " + dirPath + fileName);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				arquivo.flush();
			} catch (IOException e) {
				log.debug("Falhou flush de arquivo = " + dirPath + fileName);
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public boolean close() {
		if(arquivo == null || log == null || dirPath == null || fileName == null)
			return false;
		try {
			arquivo.close();
		} catch (IOException e) {
			log.debug("Falhou close de arquivo = " + dirPath + fileName);
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

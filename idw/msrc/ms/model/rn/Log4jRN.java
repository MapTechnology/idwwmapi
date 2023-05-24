package ms.model.rn;

import idw.util.IdwLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ms.model.MsFacade;
import ms.model.dto.Log4jDTO;

public class Log4jRN {
    
	public boolean salvar(Log4jDTO logDTO){
		IdwLogger logger = new IdwLogger("configuracao do log4j");
		logger.iniciaAvaliacao("configura log4j");
		File arquivo = new File(MsFacade.getInstancia().getCaminhoRelativo() + "/WEB-INF/classes/log4j.properties");
	    
		boolean retorno;
		try {
			logger.info("caminho do arquivo" + arquivo.getAbsolutePath());
			FileInputStream inputStream = new FileInputStream(arquivo);
			Properties log = new Properties();
			logger.info("carregando os dados do log4j");
			log.load(inputStream);
			logger.info("dados carregados com sucesso");
			logger.info("alterando os dados do log4j");
			if (logDTO.isDesabilitarLog()){
				log.setProperty("log4j.rootLogger", "stdout");
			}else{
				log.setProperty("log4j.rootLogger",logDTO.getNivel() + ", fileLog, stdout");
				log.setProperty("log4j.appender.fileLog.File", logDTO.getDiretorio());
				log.setProperty("log4j.appender.fileLog.MaxFileSize", logDTO.getTamanho());
				log.setProperty("log4j.appender.fileLog.MaxBackupIndex", logDTO.getQtdeArquivos());
			}
			logger.info("salvando os dados");
			FileOutputStream outputStream = new FileOutputStream(arquivo);
			log.store(outputStream, null);
			inputStream.close();
			outputStream.close();
			log = null;
			logger.info("dados salvos com sucesso");
			
			retorno = true;
		} catch (FileNotFoundException e) {
		    
		    logger.info("ERRO, Arquivo do log4j.properties não foi encontrado");
			retorno = false;
			e.printStackTrace();
		} catch (IOException e) {
			
		    logger.info("ERRO, Arquivo do log4j.properties não foi encontrado");
			retorno = false;
			e.printStackTrace();
		}finally{
			logger.paraAvaliacao();
			logger.info("FIM CONFIGURACAO LOG4J :" + logger.getAvaliacaoCompleta());
		}
		return retorno;
	}
	
  public Log4jDTO carregarPropriedades(){
	  IdwLogger logger = new IdwLogger("configuracao do log4j");
	  logger.iniciaAvaliacao("carrega propriedades do log4j.properties");
	  File arquivo = new File(MsFacade.getInstancia().getCaminhoRelativo() + "/WEB-INF/classes/log4j.properties");
	  
	  Log4jDTO retorno = new Log4jDTO();
		try {
			
			FileInputStream inputStream = new FileInputStream(arquivo);
			Properties log = new Properties();
			logger.info("carregando os dados do arquivo log4j.properties");
			log.load(inputStream);
			logger.info("dados carregados com sucesso");
			boolean desabilitaLog = false;
			String nivel;
			String aux = null;
			aux = log.getProperty("log4j.rootLogger");
			
			
			if (aux!= null && !aux.contains("fileLog")){
			  desabilitaLog = true;	
			  retorno.setDesabilitarLog(desabilitaLog);
			}else{
				if (aux!=null){
					nivel = aux.substring(0,aux.indexOf(","));	
				}else{
					nivel = "";
				}
				
				retorno.setDesabilitarLog(desabilitaLog);
				retorno.setNivel(nivel);
				retorno.setDiretorio(log.getProperty("log4j.appender.fileLog.File"));
				retorno.setTamanho(log.getProperty("log4j.appender.fileLog.MaxFileSize"));
				retorno.setQtdeArquivos(log.getProperty("log4j.appender.fileLog.MaxBackupIndex"));
			}
			
			inputStream.close();
			
			log = null;
		   logger.info("operação realizada com sucesso");
		} catch (FileNotFoundException e) {
	        retorno = null; 	
	        logger.info("erro ao abrir o arquivo :" + MsFacade.getInstancia().getCaminhoRelativo() + "/WEB-INF/classes/log4j.properties");
			e.printStackTrace();
		} catch (IOException e) {
		    retorno = null;
			logger.info("erro de I/O");
		    e.printStackTrace();
		}finally{
			logger.paraAvaliacao();
			logger.info("FIM CARREGAR PROPRIEDADES DO log4j.properties : " + logger.getAvaliacaoCompleta());
		}
		
	  return retorno;
  }
	
  public String getDiretorioLog(){
	  Log4jDTO logDTO = null;
	  
	  logDTO = carregarPropriedades();
	  if (logDTO == null){
		  return "";
	  }
	  
	  String retorno = logDTO.getDiretorio();
	  
	  retorno = retorno.substring(0,(retorno.length() - 7));
	  return retorno;
  }
  
  
	
}

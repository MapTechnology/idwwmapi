package ms.coleta.ic.drivercoleta;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.util.UtilsString;

public abstract class ArquivoMonitorado {

	/************************************************************************** 
	 ** Variaveis genericas para todos os tipos de coletas                   **
	 ** Essas variaveis sao utilizadas por todas as coletas                  **
	 **************************************************************************/
	protected IdwLogger log = new IdwLogger("ArquivoMonitorado-newInstance"); // acrescentei esse arquivo default para evitar erro na construcao da classe que ainda nao teve um log definido
	protected long _ACTUAL_SIZE = 0;
	protected long _LAST_CPY_DTHR = 0;
	protected int idLog;
	
	private String urlConexao 	= "";
	private String urlDestino 	= "";
	private String nomeMaquina 	= "";
	private ColetaFileType fileType	= ColetaFileType.UNKOWN;
	private Thread tCopiaArquivo;
	private boolean firstRun 			= true;
	private boolean isSalvandoArquivo 	= true;
	//private int qntMaxArq = 200;
	private int qntMaxArq = 200000;
	private Runnable runnableFiscal = new Runnable() {
		@Override
		public void run() {
			threadFiscal();
		}
	};
	
	private class MyFileInfo {
		public long size;
		public long lastModified;
	}
	
	/************************************************************************** 
	 ** Filtros e ordenacoes para facilitar a decisao                        **
	 ** Toda ordenacao e filtro deve ser colocado aqui para reutilização     **
	 **************************************************************************/
	
	protected Comparator<File> ordenaUltimaModificacaoDesc = new Comparator<File>(){
	    public int compare(File f1, File f2) {
	    	//desc order(maior para o menor)
	        return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
	    } 
	};
	
	protected Comparator<File> ordenaUltimaModificacaoAsc = new Comparator<File>() {
	    public int compare(File f1, File f2) {
	    	//asc order(menor para o maior)
	        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
	    } 
	};
	
	protected Comparator<File> ordenaUltimaModificacaoDirAsc = new Comparator<File>(){
	    public int compare(File f1, File f2) {
	        return Long.valueOf(folderLastModified(f1)).compareTo(folderLastModified(f2));
	    } 
	};
	
	protected Comparator<File> ordenaAlfabeticaAsc = new Comparator<File>(){
	    public int compare(File f1, File f2) {
	        return f1.getName().compareTo(f2.getName());
	    } 
	};
	
	protected FileFilter onlyDirectories = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
	};
	
	protected FileFilter onlyNewFiles = new FileFilter() {
		@Override
		public boolean accept(File file) {
			boolean res = !file.isDirectory() && (_LAST_CPY_DTHR < file.lastModified());
			if(res == true) {
				log.info(idLog, 0, file.getName() + "arquivo aceito isDir=" + file.isDirectory() + " LASTCPY=" + 
						DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date(_LAST_CPY_DTHR)) + " dthr=" + 
						DataHoraRN.dateToStringYYYYMMDDHHMMSS(new Date(file.lastModified())));
			} else {
				log.info(idLog, 0, file.getName() + "arquivo NAO ACEITO");
			}
			return res;
		}
	};
	
	protected FileFilter onlyNews = new FileFilter() {
		@Override
		public boolean accept(File file) {
			boolean res = _LAST_CPY_DTHR < file.lastModified();
			log.info(file.getName());
			log.info("\t_LAST_CPY_DTHR("+_LAST_CPY_DTHR +") < file.lastModified("+file.lastModified()+") = " + res);
			if(res == true) log.info("\tNewFile!");
			return res;
		}
	};
	
	/************************************************************************** 
	 ** Funcoes GENERICAS estao abaixo desse ponto                           **
	 ** Essas funcoes sao as mesmas utilizadas por todos os tipos de coletas **
	 **************************************************************************/

	public ArquivoMonitorado(String urlDestino, ColetaFileType fileType) {
		this.fileType = fileType;
		this.urlDestino=urlDestino;
		if(this.urlDestino != null && !this.urlDestino.isEmpty())
		{
			if(this.urlDestino.endsWith("/") == false)
			{
				this.urlDestino += "/";
			}
		}
	}
	
	public boolean criarFiscalDeArquivo(String urlConexao, String nomeMaquina)
	{
		boolean retorno = false;

		this.log = new IdwLogger("ArquivoMonitorado"+nomeMaquina);
		idLog = this.log.getIdAleatorio();

		try
		{
			this.firstRun = false;
			this.urlConexao = urlConexao;
			this.nomeMaquina = nomeMaquina;
		
			this.tCopiaArquivo = new Thread(runnableFiscal);
			this.tCopiaArquivo.start();
			retorno = true;
			log.info(idLog, 0, "Watcher thread criada com sucesso para " + urlConexao);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.log.info(idLog, 0, "Nao foi possivel criar watcher para " + urlConexao);
		}
		return retorno;
	}

	public void pararExecucaoDaThreadFiscal()
	{    	
		try
		{
			this.tCopiaArquivo.interrupt();
		}
		catch (Exception e)
		{
			this.log.info(idLog, 0, "Erro ao finalizar thread fiscal para " + urlConexao + " - " + e.getMessage());
			e.printStackTrace();
		}

		this.log.info(idLog, 0, "Thread fiscal de arquivo finalizada para " + urlConexao);
	}

	public void checkFiscal()
	{
		this.log.info(idLog, 0, "Checkando thread para maquina " + this.nomeMaquina);

		if (this.tCopiaArquivo.isAlive() == false && this.firstRun == false)
		{
			this.log.info(idLog, 0, "Thread morreu para maquina " + this.nomeMaquina);

			try
			{
				this.tCopiaArquivo.interrupt();
			}
			catch(Exception e)
			{
				this.log.info(idLog, 0, "Nao foi possivel abortar thread para maquina " + this.nomeMaquina + " - " + e.getMessage());
				e.printStackTrace();
			}

			try
			{
				this.tCopiaArquivo = new Thread(runnableFiscal);
				this.tCopiaArquivo.start();

				this.log.info(idLog, 0, "Thread reiniciada para maquina " + this.nomeMaquina);
			}
			catch (Exception e)
			{
				this.log.info(idLog, 0, "Erro ao reiniciar thread para maquina " + this.nomeMaquina + " - " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private void threadFiscal()
	{
		this.log.info(idLog, 0, "Thread de fiscalizacao de arquivo iniciada para maquina " + this.nomeMaquina);

		while (true)
		{
			try
			{
				File fileOrDirOrigem = new File(this.urlConexao + "/");

				String destinoDiretorio = this.urlDestino + this.nomeMaquina + "/";
				
				String origem = this.urlConexao + "/";
				
				//System.out.println("Olhando destino("+destinoDiretorio+")");
				
				File fileDestinoDiretorio = new File(destinoDiretorio);
				
				boolean isEstadoValido = true;
				
				if(fileOrDirOrigem.exists() == false) {
					isEstadoValido = false;
				}
				
				if (isEstadoValido == true && fileDestinoDiretorio.exists() == true)
				{
					int qtArq = fileOrDirOrigem.list().length;
					if (qtArq > qntMaxArq)
					{
						isEstadoValido = false;
					}
				}
				

				
				if(isEstadoValido == false) {
					if (isSalvandoArquivo == true)
					{
						this.log.info(idLog, 0, "DiretorioOrigem("+destinoDiretorio+") nao existe OU Muitos arquivos para serem tratados no diretorioDestino(" + destinoDiretorio + ").");
						this.log.info(idLog, 0, "Parando captura do arquivo");
						isSalvandoArquivo = false;
					}
					return;
				}

				isSalvandoArquivo = true;
				try
				{
					File dirOrFileOrigem = new File(origem);
					//System.out.println("Olhando diretorioOrigem("+origem+")");
					if (dirOrFileOrigem.exists())
					{
						fileDestinoDiretorio.mkdirs();
						
						String destino = this.urlDestino + this.nomeMaquina + "/" + this.fileType.name();
						
						MyFileInfo dirOrFileInfo = folderInfo(dirOrFileOrigem);
						
						// Se size for zero, ou a pasta esta vazia, ou so tem pastas dentro
						if (dirOrFileInfo.size == 0) {
							dirOrFileInfo = folderInfoFull(dirOrFileOrigem);
						}
						
						if (_ACTUAL_SIZE != dirOrFileInfo.size || _LAST_CPY_DTHR != dirOrFileInfo.lastModified)
						{
							log.info("dirOrFileInfo.size=" + dirOrFileInfo.size);
							log.info("dirOrFileInfo.lastModified=" + dirOrFileInfo.lastModified);
							log.info("PEGUEI ALTERACAO NA PASTA ORIGEM");
							
							trataFiscal(dirOrFileOrigem, destino, dirOrFileInfo, fileType);
						}
					}
				}
				catch (Exception e)
				{
					this.log.info(idLog, 0, "Erro ao copiar arquivo " + origem + " - " + e.getMessage());
					e.printStackTrace();
					this.log.info(e);
				}
				// Thread.sleep(500);
				Thread.sleep(15000);
			}
			catch (Exception e)
			{
				this.log.info(idLog, 0, "Erro threadFiscal() - " + e.getMessage());
				e.printStackTrace();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	//Esse trecho define qual funcao chamar para tratar os arquivos e diretorios baixados
	private void trataFiscal(File dirOrFileOrigem, String destination, MyFileInfo dirOrFileInfo, ColetaFileType fileType) {
		try {
			trataFiscalCustom(dirOrFileOrigem, destination);
			_ACTUAL_SIZE = dirOrFileInfo.size;
			_LAST_CPY_DTHR = dirOrFileInfo.lastModified;
			log.info("Atualizando Dados internos!");
			log.info("\tACTUAL_SIZE = " + _ACTUAL_SIZE + "\t" + "LAST_CPY_DTHR = " + _LAST_CPY_DTHR);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getSufixoDthr() {
		Calendar data = Calendar.getInstance();
		String sufixoArquivo =
				UtilsString.adicionaZero(String.valueOf(data.get(Calendar.YEAR)), 4) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.MONTH) + 1), 2) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.DAY_OF_MONTH)), 2) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.HOUR_OF_DAY)), 2) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.MINUTE)), 2) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.SECOND)), 2) + "-" +
						UtilsString.adicionaZero(String.valueOf(data.get(Calendar.MILLISECOND)), 3);
		return sufixoArquivo;
	}
	
	protected Path getPathComSufixo(String destination, String ext) {
		String destinoCompleto = destination + getSufixoDthr() + ext;
		Path filePath = new File(destinoCompleto).toPath();
		return filePath;
	}
	
	protected long folderLastModified(File directory) {
	    long maxLastModified = 0;
	    for (File file : directory.listFiles()) {
	    	long lastModified = 0;
	        if (file.isFile()) {
	        	lastModified = file.lastModified();
	        }else {
	        	lastModified = folderLastModified(file);
	        }
        	if(lastModified > maxLastModified)
            	maxLastModified = lastModified;
	    }
	    return maxLastModified;
	}
	
	private MyFileInfo folderInfo(File directory) {
	    MyFileInfo fileInfo = new MyFileInfo();
	    for (File file : directory.listFiles()) {
	        if (file.isFile()) {
	        	//log.info(file.getName()+".lastModified="+file.lastModified());
	            fileInfo.size += file.length();
	            if(file.lastModified() > fileInfo.lastModified)
	            	fileInfo.lastModified = file.lastModified();
	        } else {
	        	// MyFileInfo auxFileInfo = folderInfo(file);
	        	//log.info(file.getName()+".lastModified="+auxFileInfo.lastModified);
	            // fileInfo.size += auxFileInfo.size;
	            // Ailton: 11/04/17
	            // Se for diretorio, nao pegar data de ultima modificacao
//	            if(auxFileInfo.lastModified > fileInfo.lastModified)
//	            	fileInfo.lastModified = auxFileInfo.lastModified;
	        }
	    }
	    return fileInfo;
	}
	
	private MyFileInfo folderInfoFull(File directory) {
	    MyFileInfo fileInfo = new MyFileInfo();
	    for (File file : directory.listFiles()) {
	        if (file.isFile()) {
	        	//log.info(file.getName()+".lastModified="+file.lastModified());
	            fileInfo.size += file.length();
	            if(file.lastModified() > fileInfo.lastModified)
	            	fileInfo.lastModified = file.lastModified();
	        } else {
	        	MyFileInfo auxFileInfo = folderInfoFull(file);
	        	//log.info(file.getName()+".lastModified="+auxFileInfo.lastModified);
	            fileInfo.size += auxFileInfo.size;
	            if(auxFileInfo.lastModified > fileInfo.lastModified)
	            	fileInfo.lastModified = auxFileInfo.lastModified;
	        }
	    }
	    return fileInfo;
	}
	
	public boolean isEquals(String urlConexao)
	{
		return this.urlConexao.equals(urlConexao);
	}

	/**************************************************************************
	 ** Funcoes especificas/customizadas estao abaixo desse ponto            **
	 ** Estas funcoes devem ser implementadas de acordo com o tipo de coleta **
	 **************************************************************************/
	
	protected abstract void trataFiscalCustom(File dirOrFileOrigem, String destination) throws IOException;

	public String getUrlDestino() {
		return urlDestino;
	}

	public void setUrlDestino(String urlDestino) {
		this.urlDestino = urlDestino;
	}

	public String getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}
	
}

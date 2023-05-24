/**
 * (c) Melexis Telecom and/or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp.server; 

import idw.model.rn.DataHoraRN;
import idw.util.ArquivoEscrita;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.util.ZipDirectory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import ms.model.MsFacade;
import tftp.TFTPDefines;
import tftp.common.FRQ;
import tftp.common.RRQ;
import tftp.common.TFTPPacket;
import tftp.common.VirtualFileSystem;
import tftp.common.WRQ;

/**
 *
 * @author  marco
 */
public class TFTPServerSocket implements Runnable {
    private VirtualFileSystem vfs = null;
    private EventListener listener = null;    
    private String pathRelativo=null;

    /** Creates a new instance of TFTPServerSocket */
    @SuppressWarnings("rawtypes")
	public TFTPServerSocket(int serverPort, int poolSize, VirtualFileSystem vfs, EventListener listener,IdwLogger log,String pathRelativo) {
        this.vfs = vfs;
    	this.log=log;
    	this.pathRelativo=pathRelativo;
        this.listener = listener;
		this.serverPort = serverPort;
		this.poolSize = poolSize;
			/** Creates a new queue for receiving packets to wait for handling by a worker thread
			 *  Creates a new pool and fill with new workerthreads */
		newConnects = new Hashtable();        
		workers = new TFTPPool(poolSize, newConnects, vfs, this.listener,log);
		}

    public void setPoolSize(int poolSize) {
      this.poolSize = poolSize;
		workers.resize(poolSize);
    }
    
    public int getPoolSize() {
      return poolSize;
    }
    
  /* This internal function helps to verify the fileContent on the request.
   * If the WRQ or RRQ packet does not contain valid fileContent, the request
   * is denied. It would be possible to delegate a check to rosmcp too.*/
//  private boolean fileContentOK () {
    /* filename should not be empty, else send ERROR and say goodbye */
//    if (fileContent == null || Array.getLength(fileContent) == 0) {
//      sendErrPacket (ERR_NOT_DEFINED, "Invalid ROS-MCP content, GO AWAY!" + fileName);
//      tftplog.info(destAddrStr + ":" + destPort + 
//        " Client sent RRQ/WRQ without valid content!");
//      return false;
//    }
//    return true;
//  }
  
  @Override
public void run() {
    int bufSize = 528;    
    InetAddress clientAddress;
    int clientPort;
		try {
		  serverSocket = new DatagramSocket(serverPort);
		  serverSocket.setSoTimeout(TFTPDefines.timoutSOSocket);
		} catch (SocketException e) {
         log.info("Could not create socket on port: " + serverPort + ", shutting down!");
         // OK here we should inform the main thread that is is of no use to continue
         stop();
		  return;
		}
		
    log.info("TFTPServerSocket is started");
    
    for (;abort != true;) {
      byte[] buffer = new byte[bufSize];
      DatagramPacket packet = new DatagramPacket(buffer, bufSize);
      try {
        serverSocket.receive (packet);
      } catch (IOException ioe) {
        //log.debug("Tftp:"+ioe.getMessage()); //Este log está gerando problemas nos clientes
        continue;
      }
      clientAddress = packet.getAddress();
      clientPort = packet.getPort();
      log.info("server received request for file from " + clientAddress.toString());

      // copy the data from udp packet      
      byte[] tftpP = new byte[packet.getLength()];
      System.arraycopy(packet.getData(), packet.getOffset(), tftpP, 0, packet.getLength());
      
      FRQ frq;
      int opcode = TFTPPacket.fetchOpCode(tftpP);
      try {
        switch (opcode) {
          case RRQ.OPCODE: frq = new RRQ(tftpP,log); break;
          case WRQ.OPCODE: frq = new WRQ(tftpP,log); break;
          default: continue;
        }
      } catch (InstantiationException e) {
            log.info("InstantiationException: " + e.getMessage());
				continue;
      }
      String enderecoIP=clientAddress.getHostAddress();
      
      /* This internal function helps to verify the filename on the request.
       * If the WRQ or RRQ packet contains not a valid filename, the request
       * is ignored. It would be possible to delegate a check to rosmcp too.*/     
      if (frq.getFileName() == null || frq.getFileName().length() == 0) continue;
      
      boolean devefazer=true;
      frq.setPathRelativo(pathRelativo);
      frq.setEnderecoIP(enderecoIP);
      // Senoj: Verifica se o Nome do Arquivo � INOVAFIRMWARE.snj
      if(frq.getFileName().equals("INOVAFIRMWARE.snj") &&(opcode==RRQ.OPCODE) ){    	     	  
    	  String filename= MsFacade.getInstancia().obtemFileToUpload(enderecoIP);
    	  // Obtem o arquivo e passa para o performWork.
    	  if(filename!=null && filename.length()>0)
    		  frq.setFileName("firmware/"+filename);
    	  else//Se n�o houver nada cadastrado carrega o c�digo Default no INOVA
    		  frq.setFileName("firmware/INOVADEFAULT.elf");
    	  //Verifica se arquivo existe
    	  
    	 if(vfs.fileExist("firmware/"+filename)==false){    	 
    		  log.info(" Arquivo n�o encontrado, usando firmware/INOVADEFAULT.elf "+frq.getFileName()+" para "+enderecoIP);    		  
    		  frq.setFileName("firmware/INOVADEFAULT.elf");
    	  }
      }
      if(frq.getFileName().equals("INOVAFIRMWARE1778.snj") &&(opcode==RRQ.OPCODE) ){    	     	  
    	  String filename= MsFacade.getInstancia().obtemFileToUpload(enderecoIP);
    	  // Obtem o arquivo e passa para o performWork.
    	  if(filename!=null && filename.length()>0)
    		  frq.setFileName("firmware/"+filename);
    	  else//Se n�o houver nada cadastrado carrega o c�digo Default no INOVA
    		  frq.setFileName("firmware/INOVADEFAULT1778.elf");
    	  //Verifica se arquivo existe
    	  
    	 if(vfs.fileExist("firmware/"+filename)==false){    	 
    		  log.info(" Arquivo nao encontrado, usando firmware/INOVADEFAULT1778.elf "+frq.getFileName()+" para "+enderecoIP);    		  
    		  frq.setFileName("firmware/INOVADEFAULT1778.elf");
    	  }
      }
      if(frq.getFileName().equals("InovaSA") &&(opcode==RRQ.OPCODE) ){    	     	  
    	  String filename= MsFacade.getInstancia().obtemFileToUpload(enderecoIP);
    	  // Obtem o arquivo e passa para o performWork.
    	  if(filename!=null && filename.length()>0)
    		  frq.setFileName("firmware/"+filename);
    	  else//Se n�o houver nada cadastrado carrega o c�digo Default no INOVA
    		  frq.setFileName("firmware/InovaSA");
    	  //Verifica se arquivo existe
    	  
    	 if(vfs.fileExist("firmware/"+filename)==false){    	 
    		  log.info(" Arquivo n�o encontrado, usando firmware/InovaSA "+frq.getFileName()+" para "+enderecoIP);    		  
    		  frq.setFileName("firmware/InovaSA");
    	  }
      }    
      if(frq.getFileName().equals("uImage") &&(opcode==RRQ.OPCODE) ){    	     	  
    	  // Obtem o arquivo e passa para o performWork.
    	  frq.setFileName("firmware/uCLinux/uImage");   
      }    
      
      log.info("Carregando "+frq.getFileName()+" para "+enderecoIP);
      
      if(frq.getFileName().equals("FirmwareUNO"))
      {
    	  if( frq instanceof RRQ)
    		  frq.setFileName("firmware/FirmwareUNO");
    	  else if (frq instanceof WRQ)
    		  frq.setFileName("firmware/FirmwareUNO.tmp");
      }
      if(frq.getFileName().equals("Dados.zip") &&  (frq instanceof RRQ))
      {
    	  
    	  if(MsFacade.getInstancia().isICCadastrado(enderecoIP) == false || MsFacade.getInstancia().existeUPParaIC(enderecoIP) == false) {
      	  	try {
      	  		
      	  		String dirLimpeza = frq.getPathRelativo()+enderecoIP;
      	  		ArquivosDiretorios.criarDiretorioSeNaoexistir(dirLimpeza);
      	  		
      	  		if(ArquivosDiretorios.isExisteArquivo(dirLimpeza+"/limpeza") == false){
      	  			ArquivoEscrita arqSinc = new ArquivoEscrita(new FileWriter(new File(dirLimpeza+"/limpeza").getPath(), false));
      	  			arqSinc.close(); 
      	  		}
      	  		
				log.info("Compactando " + frq.getPathRelativo()+enderecoIP);
				
				List<File> fileList = new ArrayList<File>();
				File fil = new File(frq.getPathRelativo() + "/" + enderecoIP );
				if (fil != null && fileList != null) {
					ZipDirectory.getAllFiles(fil, fileList);
					ZipDirectory.writeZipFile(fil, fileList, false);
				} else {
					log.info("NAO GEROU ZIP fil=" + fil + " fileList=" + fileList);
				System.out.println("NAO GEROU ZIP fil=" + fil + " fileList=" + fileList);
				}

				frq.setFileName(enderecoIP+".zip"); 

  			} catch (IOException e) {
  				return;
  			}
    	  } else {
    	  
	    	  frq.setFileName(enderecoIP+".zip");    	 
	    	  
	    	 if(vfs.fileExist(frq.getFileName())==false){    	 
	    		  frq.setFileName("nope");
	    	  }else{
		  		 log.info("Enviando dados "+frq.getFileName()+" para "+enderecoIP);
		  	 }
    	 }
      }
	  if(frq.getFileName().equals("GETDTHRSINC") &&  (frq instanceof RRQ))
      {
    	  	frq.setFileName(enderecoIP+".sinc"); 
    	  	try {
	    	  if(ArquivosDiretorios.isExisteArquivo(frq.getPathRelativo()+frq.getFileName())){
	    		  ArquivosDiretorios.delete(frq.getPathRelativo()+frq.getFileName()); 	 
	    	  }    	 
	    	  ArquivoEscrita arqSinc = new ArquivoEscrita(new FileWriter(new File(frq.getPathRelativo()+frq.getFileName()).getPath(), false));
	    	  arqSinc.writeLine(DataHoraRN.dateToString(DataHoraRN.getDataHoraAtual(), "yyyy-MM-dd HH:mm:ss"));
			  arqSinc.close();
			} catch (IOException e) {
				return;
			}			
			
    	 if(vfs.fileExist(frq.getFileName())==false){    	 
    		  frq.setFileName("nope");
    	  }else{
	  		 log.info("Enviando dados "+frq.getFileName()+" para "+enderecoIP);
	  	 }
      }
	  
      if(frq.getFileName().equals("Evento.zip") && (frq instanceof WRQ))
      { 
	   	 if(vfs.fileExist(enderecoIP+"-eventos.zip")==true){ 
	   		log.info("Evento local pendente de processamento "+enderecoIP+"-eventos.zip ");
    		devefazer=false;
    	 }else{    		 
    		 frq.setFileName(enderecoIP+"-eventos.tmp");    		 
    		 if(vfs.fileExist(frq.getFileName())==true){   
				if(ArquivosDiretorios.delete(frq.getPathRelativo()+frq.getFileName())==true){
					log.info("-- "+frq.getFileName()+" Excluido ");
				}else{
					log.info("-- "+frq.getFileName()+" Falha ao excluir ERRO!");
					devefazer=false;
				}
				log.info("Lendo Eventos "+frq.getFileName()+" de "+enderecoIP);
    		 }
    	 }
      }
      if(devefazer==true)
    	  workers.performWork(frq, clientAddress, clientPort); 
			
    }
    log.info("TFTPServerSocket is stopped");
  }

  public void stop() {
      workers.resize(0);
      abort = true;
		if (serverSocket != null) serverSocket.close();
  }
    
    /* poolSize stores the number of workers with sockets to handle of incoming
     * requests on master TFTP socket, for now this size is only affected when
     * set before the socket is connected */
    private int poolSize;
    
    private TFTPPool workers;
    @SuppressWarnings("rawtypes")
	private Hashtable newConnects;

    DatagramSocket serverSocket;
    int serverPort;
    boolean abort;
    
  private IdwLogger log;
}

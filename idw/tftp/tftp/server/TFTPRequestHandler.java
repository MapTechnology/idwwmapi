/**
 * (c) Melexis Telecom and/or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp.server;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.Path;

import javax.naming.Context;
import javax.naming.InitialContext;

import tftp.TFTPDefines;
import tftp.common.ERROR;
import tftp.common.FRQ;
import tftp.common.RRQ;
import tftp.common.VirtualFile;
import tftp.common.VirtualFileImpl;
import tftp.common.VirtualFileSystem;
import tftp.common.WRQ;

/**
 * class:   TFTPRequestHandler
 * package: tftp.server
 * project: tftp4java
 */
/**
 * @author  marco
 */

/*
 * This class handles off one TFTP write or read request
 * in future time this could be improved to handle more than one
 * request on same socket.
 * Thus the maximum of 65534 ports could be overcome
 * if capacity on NIC and processor would allow. */
public class TFTPRequestHandler
{
    /**
     * store reference to file system for later use
     */
    private VirtualFileSystem vfs = null;

    /**
     * event listener on which we can fire events
     */
    private EventListener listener = null;

    /** Creates a new instance of TFTPRequestHandler */
    public TFTPRequestHandler(VirtualFileSystem vfs, EventListener listener,IdwLogger log) throws SocketException
    {
    	this.log = log;
        this.vfs = vfs;
        this.listener = listener;
        tftpClient = new ClientHandler(log);
        //		mcpq = new MCPStream();
        /* would like to replace with dynamic array! */
        try
        {
            ctx = new InitialContext();
        }
        catch (javax.naming.NamingException e)
        {
            log.info("Could not create InitialContext! " + e.toString());
            throw new SocketException("Cannot get new InitialContext for TFTPRequesHandler, run would fail!");
        }
    }

    /** 
     * This method is called when a client sends another WRQ or RRQ while
     * this TFTPRequestHandler is already working on a previous WRQ or RRQ
     * from the client
     */
    public boolean waitingForNewRequest(FRQ frq)
    {
        if (tftpClient.waitingForNewRequest())
        {
            tftpClient.newRequest();
            return true;
        }
        else
        {
            return false;
        }
    }

    // This run is called as main for TFTPWorkerThread it is passed a packet
    // received on the TFTPServerSocket
    public void run(FRQ frq, InetAddress clientAddress, int clientPort)
    {
    	
        if (frq == null)
        {
            log.error("TFTPRequestHandler run is called with null packet!");
            return;
        }
        if (clientAddress == null)
        {
            log.error("TFTPRequestHandler run is called with invalid client address!");
            return;
        }
        if (clientPort == 0)
        {
            log.error("TFTPRequestHandler run is called with invalid client port!");
            return;
        }

        // prepare the tftpClient to send packages to the new client
        tftpClient.connect(clientAddress, clientPort);

        // get timeout otherwise set default to 5 secs
        int timeout = frq.getTimeout();
        if (timeout <= 0)
            timeout = TFTPDefines.timoutTFTP;
        tftpClient.setTimeout(timeout);

        // get tsize otherwise set default to half megabyte
        int tsize = frq.getTransferSize();
        if (tsize < 0)
            tsize = TFTPDefines.DEFAULT_TSIZE;
        tftpClient.setTransferSize(tsize);
        
        // get tsize otherwise set default to half megabyte
        String auxiliar = frq.getAuxiliar();
        if (auxiliar == null)
        	auxiliar = TFTPDefines.DEFAULT_AUX;
        tftpClient.setAuxiliar(auxiliar);

        thisThread = Thread.currentThread();

        if (frq instanceof RRQ)
        {
            RRQ rrq = (RRQ) frq;
            log.info(tftpClient.getClient() + " RRQ " + rrq.getFileName());
            boolean sendOK = false;
            VirtualFile file = new VirtualFileImpl(rrq.getFileName());

            InputStream is = null;
            try
            {
                // get an InputStream from VirtualFileSystem and read
                // within the ClientHandler from this stream
                is = vfs.getInputStream(file);
            }
            catch (FileNotFoundException e)
            {
                log.info("FileNotFoundException: " + e.getMessage());
                tftpClient.sendErrPacket(ERROR.ERR_FILE_NOT_FOUND, "Arquivo nao encontrado!");

                return;
            }

            // at this point we have valid pizza stream

            // retrieve mcp data sa fileContent from mcpServer
            sendOK = tftpClient.sendFileToClient(is /*fileContent*/
            , clientAddress, clientPort, frq.hasOptions());

            // Generate after download event
            if (listener != null)
                listener.onAfterDownload(clientAddress, clientPort, rrq.getFileName(), sendOK);

            try
            {
                is.close();
            }
            catch (IOException e)
            {
                log.info("This is sad but true, we cannot close the inputStream for " + rrq.getFileName());

                return;
            }
            try{

            	//Alexandre 07/03/2016 -
            	//Comentei esses trechos pois estavam deletando a pasta de sessao em construcao,
            	//fazendo a sessao ser criada "pela metade" e faltando informacoes.
            	//Agora so deleta o proprio arquivo solicitado.
            	if(rrq.getFileName().contains(frq.getEnderecoIP()+".zip")){
            		log.info("--Excluindo: " + rrq.getFileName());
            		if(ArquivosDiretorios.delete(rrq.getPathRelativo()+rrq.getFileName())==true){
            			log.info("-- "+rrq.getFileName()+" Excluido ");
            		} else{
            			log.info("-- "+rrq.getFileName()+" Falha ao excluir ");
            		}
            		/*log.info("--Excluindo diretório: " + rrq.getEnderecoIP());
            		if(ArquivosDiretorios.delete(rrq.getPathRelativo()+rrq.getEnderecoIP())==true){
            			log.info("-- "+rrq.getEnderecoIP()+" Excluido ");
            		}else{
            			log.info("-- "+rrq.getEnderecoIP()+" Falha ao excluir ");
            		}*/
            	}
            }catch(Exception err){
            	log.info("--Erro ao exluir" + rrq.getFileName());
            	
            	err.printStackTrace();
            }
        }
        else if (frq instanceof WRQ)
        {
            WRQ wrq = (WRQ) frq;
            log.info(tftpClient.getClient() + " WRQ " + wrq.getFileName());
            VirtualFile file = new VirtualFileImpl(wrq.getFileName());
            log.info(tftpClient.getClient() + " WRQ " + wrq.getFileName()+" Apos VFS");
            // retrieve file from client
            OutputStream os = null;
            boolean receiveOK = false;
            try {
            	os = vfs.getOutputStream(file);
            	log.info(tftpClient.getClient() + " WRQ " + wrq.getFileName()+" Apos Instanciar OutputStream");
                receiveOK = tftpClient.receiveFileFromClient(os, clientAddress, clientPort , frq.hasOptions());
                // Alessandre em 17-7-15 comentei a linha abaixo visto que em receiveFileFromCliente ja fecha o arquivo
                //os.close();
            } catch (Exception e) {
            	e.printStackTrace();
            	receiveOK = false;
            } finally {
            	if (os != null)
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
						receiveOK = false;
					}
            }
            
            try {
                if (listener != null){
					listener.onAfterUpload(clientAddress, clientPort, wrq.getFileName(), receiveOK);
                    log.info("WRQ FILENAME : " + wrq.getFileName());
                    if(receiveOK==true){
                    	log.info("SUCESSO NO RECEBIMENTO");
    	                String novo = null;
    	            	if(wrq.getFileName().equals("firmware/FirmwareUNO.tmp")){
    	            		novo="firmware/FirmwareUNO";            		
    	            	}
    	            	if(wrq.getFileName().contains("InovaSA") && wrq.getFileName().contains(".tmp")){
    	            		novo=wrq.getFileName().replace(".tmp", "");            		
    	            	}
    	            	if(wrq.getFileName().contains("-eventos.tmp")){
    	            		novo=wrq.getFileName().replaceAll(".tmp", ".zip");
    	            	}
    	            	if(novo!=null) {
    	            		log.info("Vou renomear " + wrq.getPathRelativo()+wrq.getFileName() + " PARA " + wrq.getPathRelativo()+novo);
    	            		Path isSucesso =  ArquivosDiretorios.renameFilePath(wrq.getPathRelativo()+wrq.getFileName(),wrq.getPathRelativo()+novo,true);
    	            		if (isSucesso == null) {
    	            			log.info("Falha ao renomear " + wrq.getPathRelativo()+wrq.getFileName() + " PARA " + wrq.getPathRelativo()+novo);
    	            		}
    	            	}
                    } else {
                    	log.info("FALHA NO RECEBIMENTO");
                    }
                }else {
                	log.info("Listener Null para:"+ wrq.getFileName());
                }
            }
            catch (Exception e)
            {
                log.info("Exception occurred in tftp.run " + e);
                e.printStackTrace();
            }
        }
    }

    public void stop()
    {
        // disconnect the client from here that no strange packets are sent to client
        tftpClient.disconnect();
    }
    
    Thread thisThread;
    Context ctx;
    ClientHandler tftpClient;
    //	MCPStream mcpq;
    private IdwLogger log ;
}

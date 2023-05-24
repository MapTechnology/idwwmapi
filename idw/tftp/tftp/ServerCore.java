/**
 * (c) Melexis Telecom and or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp;

import idw.util.IdwLogger;

import java.io.File;
import java.net.InetAddress;

import tftp.server.EventListener;
import tftp.server.TFTPServer;
import tftp.common.VirtualFileSystem;
import tftp.TftpFileSystem;


/**
 * @author marco
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ServerCore implements EventListener
{
   /**
    * logger
    */
   private IdwLogger log;


   private TFTPServer tftpServer;

	/**
	 * Constructor for Server.
	 */
	public ServerCore(IdwLogger log,String pathRelativo)
	{
      VirtualFileSystem vfs = new TftpFileSystem(pathRelativo,log);
      tftpServer = new TFTPServer(vfs, this,log);
      tftpServer.setPathRelativo(pathRelativo+File.separator);
      tftpServer.setPoolSize(TFTPDefines.POOL_SIZE);
      tftpServer.setPort(TFTPDefines.TFTP_PORT);
      this.log=log;
	}

   public void connect() throws Exception
   {
      if (tftpServer == null) return;
      tftpServer.start();
   }

   public void disconnect()
   {
      if (tftpServer == null) return;
      tftpServer.stop();
   }
   
   @Override
   public void onAfterDownload(InetAddress a, int p, String fileName, boolean ok)
   {
            if (ok) log.info("Send " + fileName + " sucessfully to client: " + a.getHostAddress() + " port: " +p);
            else log.info("Send " + fileName + " file not sucessfully to client: " + a.getHostAddress() + " port: " +p);     
   }
   
   @Override
   public void onAfterUpload(InetAddress a, int p, String fileName, boolean ok)
   {
            if (ok){
            	log.info("received " + fileName + " sucessfully from client: " + a.getHostAddress() + " port: " +p);
            }
            else{
            	log.info("received " + fileName + " file not sucessfully from client: " + a.getHostAddress() + " port: " +p);     
            }
   }    

}

/**
 * (c) Melexis Telecom and or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp;

import idw.util.IdwLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import tftp.common.VirtualFile;
import tftp.common.VirtualFileSystem;


/**
 * @author marco
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class TftpFileSystem implements VirtualFileSystem
{
   /**
    * logger
    */
   private IdwLogger log;

   /**
    * TFTP home dir
    */
   private File home;

	/**
	 * Constructor for FileSystem.
	 */
	public TftpFileSystem(String home,IdwLogger log)
	{
      this.home = new File(home);
      this.log=log;
	}
	
	@Override
	public boolean fileExist(String location){
		boolean retorno=false;
		File iofile= new File(home, location);;
		retorno=iofile.exists();
		return retorno;
	}

   /**
    * This method always try to find file within home
    * if not than home location is prepended because location is relative
    * If it is, check if location is within home otherwise throw an exception
    * that indicates an access violation
    * 
    * Please check also for tricks with .. , .
    * 
    */
   public File expand(String location) throws FileNotFoundException
   {
      if (location.indexOf("..") > -1){
    	  log.info("Tentativa Maliciosa de Explorar diretório.");
         throw new FileNotFoundException("No tricks with .. allowed");
      }
      
      return new File(home, location);
   }
   
	/**
    * 
	 * @see tftp.common.VirtualFileSystem#getInputStream(VirtualFile)
    * 
	 */
   @Override
	public InputStream getInputStream(VirtualFile file) throws FileNotFoundException
	{
      return new FileInputStream ( expand(file.getFileName()) );
	}

	/**
	 * @see tftp.common.VirtualFileSystem#getOutputStream(VirtualFile)
	 */
   @Override
	public OutputStream getOutputStream(VirtualFile file) throws FileNotFoundException
	{
		return new FileOutputStream( expand(file.getFileName()));
	}

}

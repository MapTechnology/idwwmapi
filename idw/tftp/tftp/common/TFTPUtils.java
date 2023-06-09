/**
 * Title:        TFTPUtils.java<p>
 * Description:  <p>
 * Copyright:    (c) Roses B.V. 2003<p>
 * Company:      Roses B.V.<p>
 *
 * @author      Kinshuk
 * Created:      4-jul-2003
 */
package tftp.common;

import idw.util.IdwLogger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;


import tftp.TFTPDefines;
import tftp.common.TFTPSocket;

/**
 * class:   TFTPUtils
 * package: tftp.common
 * project: tftp4java
 * 
 * This class is intended to provide common functionality for the TFTP module.
 * 
 */
public class TFTPUtils
{
   /**
    *  IdwLogger object
    */
   private static final IdwLogger log=new IdwLogger("TFTPUtils");

   private TFTPUtils()
   {
      // this class should never be instantiated!!!
   }

   /**
    * 
    * dataTransfer
    * @param tftpSock
    * @param send
    * @param recv
    * @return
    */
   public static ACK dataTransfer(TFTPSocket tftpSock, ACK send, ACK recv)
      throws IOException
   {
      int retransmits = 0;
      int spamcount = 0;

      /** 
       * Boolean flag that is used internally to indicate we might have stuffed
       * the connection to the client with resent packages. This flag is cleared
       * when we duplicate the timeout with the next  data package sent which 
       * should help to clean up the channel that did get stuffed
       */
      boolean stuffedLink = false;

      // send the packet....
      tftpSock.write(send);
      TFTPPacket tftpP;
      boolean receiving = true;
      // wait for successful acknowledgement!.....
      while (receiving)
      {
    	
    	 tftpP = tftpSock.read();
    	 
         // case we did not receive any packet
         if (tftpP == null)
         {
            // and we are not expecting a packet because we send last acknowledgement
            // and only need to verify if this one arrived and so wait friendly for a possible
            // resend of the data in case our ack got lost.
            if (recv == null)
               return null;
            
            // If too many retries, give up.
            if (retransmits++ > TFTPDefines.MAXIMUM_RETRANSMIT)
               throw new IOException(
                  getClient(tftpSock) + " Maximum retransmit count exceeded");
                  
            // resend the packet and wait again!
            log.info(
               getClient(tftpSock)
                  + " expected packet before time out, sending ACK/DATA again");
            tftpSock.write(send);
            // set the flag to indicate that we might be stuffing the pipe for the
            // client, next packet needs to have longer timeout to give client some
            // time to clean up the pipe
            stuffedLink = true;
            try
            {      
               tftpSock.setSocketTimeOut(TFTPDefines.timoutSOSocket * 2);
              
               log.info("Timout tftpSock: "+ tftpSock.getSocketTimeOut()+"ms");
            } catch (SocketException e)
            {
               log.info(
                  getClient(tftpSock)
                     + "Could not change timeout on socket. "
                     + e.getMessage());
               // just conitnue
            }
            continue;
         }

         // case we received error
         if (tftpP instanceof ERROR)
         {
            throw new IOException(
               getClient(tftpSock) + " " + ((ERROR) tftpP).getErrorMessage());
         }

         // case we did receive expected
         if ((tftpP instanceof ACK) && correctAnswer(recv, (ACK) tftpP))
         {
            try
            {
               if (stuffedLink)
               {
                  stuffedLink = false;
                  tftpSock.setSocketTimeOut(TFTPDefines.timoutSOSocket);
               }
            } catch (SocketException e)
            {
               log.info(
                  getClient(tftpSock)
                     + "Could not change timeout on socket. "
                     + e.getMessage());
               // just conitnue
            }
            return (ACK) tftpP;
         }

         // all other is spam and when too many of this crap is give up, and do not signal
         if (spamcount++ > 5)
         {
            return null;
         }
      }
      return null;
   }

   public static void sendErrPacket(
      TFTPSocket tftpSock,
      int errorCode,
      String errorMsg)
   {
      try
      {
         TFTPPacket tftpP = new ERROR(errorCode, errorMsg);
         tftpSock.write(tftpP);
      } catch (Exception e)
      {
         log.info(getClient(tftpSock) + " UDP send ERROR packet failure.");
         log.info(e.toString());
         return;
      }
      log.info(
         "SEND ERROR"
            + " ["
            + getClient(tftpSock)
            + "] EC = ["
            + errorCode
            + "] "
            + errorMsg);
   }

   /**
    * This method returns the IP address and port number of the 
    * client this class is talking to.
    */
   public static String getClient(TFTPSocket tftpSock)
   {
      String client = "";
      InetAddress addr = tftpSock.getAddress();
      int port = tftpSock.getPort();
      if (addr != null)
         client += addr.getHostAddress();
      if (port != 0)
      {
         client += ":";
         client += port;
      }
      return client;
   }

   /**
    * This method is an internal helper function that checks if the
    * received ack packet matches the expectations. That means
    * that the opcode and blocknumbers are expected.
    * 
    * @param expecting The expected acknowledgement
    * @param received   The received acknowledgement
    * @return true if received matched the expectations
    */
   public static boolean correctAnswer(ACK expecting, ACK received)
   {
      if (expecting == null)
         return false;
      if (received == null)
         return false;
      if (expecting.getOpCode() != received.getOpCode())
         return false;
      if (expecting.getBlockNr() != received.getBlockNr())
         return false;
      return true;
   }
}

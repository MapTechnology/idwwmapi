/**
 * (c) Melexis Telecom and/or Remote Operating Services B.V.
 * 
 * Distributable under LGPL license
 * See terms of license at gnu.org
 */
package tftp.server;

import idw.util.IdwLogger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;

import tftp.TFTPDefines;
import tftp.common.ACK;
import tftp.common.DATA;
import tftp.common.ERROR;
import tftp.common.OACK;
import tftp.common.TFTPOptions;
import tftp.common.TFTPPacket;
import tftp.common.TFTPSocket;
import tftp.common.TFTPUtils;

/**
 * However this class is called ClientHandler it is meant to be the
 * class that handles the actual client tftp transfers. 
 * 
 * @author  marco
 */
public class ClientHandler
{
    
    /**
     * The private field for storage of the timeout setting for the communication
     * with the client
     */
    private int timeout = TFTPDefines.timoutTFTP;

    /**
     * Creates a new instance of TFTPSocket 
     */
    public ClientHandler(IdwLogger log) throws SocketException    
    {
    	this.log=log;
        tftpSock = new TFTPSocket(timeout,log);

        /* would like to replace with dynamic array! */
        /*    fileContent = new byte[MAX_FILE_SIZE]; */
    }

    /**
     * 
     * Connects the clienthandler to the client, packages send do not need to contain a 
     * address. If they do they are overwritten by the ones of the connected socket.
     * 
     * @return
     */
    public void connect(InetAddress inetAddress, int clientPort)
    {
        tftpSock.connect(inetAddress, clientPort);
    }

    /**
     * 
     * disconnects from the client, any packet send after a disconnect needs to contain a 
     * destination address and port, because nne is available on the socket. 
     *
     */
    public void disconnect()
    {
        tftpSock.disconnect();
    }

    /**
     * This method returns the IP address and port number of the 
     * client this class is talking to.
     */
    public String getClient()
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
//    private boolean correctAnswer(ACK expecting, ACK received)
//    {
//    	if (expecting == null)
//    		return false;
//    	if (received == null)
//    		return false;
//    	if (expecting.getOpCode() != received.getOpCode())
//    		return false;
//    	if (expecting.getBlockNr() != received.getBlockNr())
//    		return false;
//    	return true;
//    }

    //	public ACK DataTransfer(ACK send, ACK recv)
    //	{
    //		int retransmits = 0;
    //		int spamcount = 0;
    //
    //		// send the packet....
    //		try
    //		{
    //			tftpSock.write(send);
    //			// if stuffed use duplicate timeout
    //			if (stuffedLink)
    //				tftpSock.setSocketTimeOut(timeout * 2);
    //		}
    //		catch (Exception e)
    //		{
    //			log.info(getClient() + " UDP send packet failure.");
    //			log.info(e.toString());
    //		}
    //
    //		TFTPPacket tftpP;
    //		boolean receiving = true;
    //		// wait for succesfull acknowledgement!.....
    //		while (receiving)
    //		{
    //			try
    //			{
    //				tftpP = tftpSock.read();
    //				// set timout back because we gave enough time to clean up stuffed channel
    //				if (stuffedLink)
    //				{
    //					tftpSock.setSocketTimeOut(timeout);
    //					stuffedLink = false;
    //				}
    //			}
    //			catch (IOException ios)
    //			{
    //            log.info("IOException: " + ios.getMessage());
    //				return null;
    //			}
    //
    //			// case we did not receive any packet
    //			if (tftpP == null)
    //			{
    //				if (retransmits++ > 5)
    //				{
    //					// Too many retries, give up.
    //					sendErrPacket(
    //						ERROR.ERR_NOT_DEFINED,
    //						"Retransmit limit exceeded");
    //					log.info(
    //						getClient() + " Maximum retransmit count exceeded");
    //					return null;
    //				}
    //				else
    //				{
    //					// resend the packet and wait again!
    //					log.info(
    //						getClient()
    //							+ " expected packet before time out, sending ACK/DATA again");
    //					try
    //					{
    //						tftpSock.write(send);
    //						// set the flag to indicate that we might be stuffing the pipe for the
    //						// client, next packet needs to have longer timeout to give client some
    //						// time to clean up the pipe
    //						stuffedLink = true;
    //					}
    //					catch (Exception e)
    //					{
    //						log.info(getClient() + " UDP send packet failure.");
    //						log.info(e.toString());
    //					}
    //					continue;
    //				}
    //			}
    //
    //			// case we received error
    //			if (tftpP instanceof ERROR)
    //			{
    //				log.info(
    //					getClient() + " " + ((ERROR) tftpP).getErrorMessage());
    //				return null;
    //			}
    //
    //			// case we did receive expected
    //			if ((tftpP instanceof ACK) && correctAnswer(recv, (ACK) tftpP))
    //			{
    //				return (ACK) tftpP;
    //			}
    //
    //			// all other is spam and when too many of this crap is give up, and do not signal
    //			if (spamcount++ > 5)
    //			{
    //				return null;
    //			}
    //		}
    //		return null;
    //	}

    public boolean receiveFileFromClient(OutputStream os, InetAddress clientAddress, int clientPort, boolean useOptions)
    {
        /* filename should not be empty, else send ERROR and say goodbye */
        tftpSock.connect(clientAddress, clientPort);
        //Vector dataBlocks = new Vector(10);
        // not expecting more then 10 * 512 bytes

        // Send the first ackowledgement on received WRQ
        int blockNumber = 0;
        byte[] data = new byte[1];
        int totalSize = 0;
        boolean retorno=true;

        ACK send;
        DATA receive=null;
        DATA expect;

        // if frq has options then we oack instead of ack to receive data
        if (useOptions)
        {
            TFTPOptions options = new TFTPOptions();
            options.setTimeout(getTimeout());
            options.setTransferSize(getTransferSize());
            options.setAuxiliar(getAuxiliar());
            send = new OACK(0, options);
        }
        else
        {
            send = new ACK(blockNumber);
        }

        do
        {
            try
            {            	
                expect = new DATA(blockNumber + 1, data);
                receive = (DATA) TFTPUtils.dataTransfer(tftpSock, send, expect);
            }
            catch (ClassCastException e)
            {
                log.info("CODING ERROR? this case should be fetched in DataTransfer!");
                retorno=false;
            }
            catch (InstantiationException e)
            {
                log.info("CODING ERROR? cannot construct DATA and ACK packets in receiveFileFromClient");
                retorno= false;
            }
            catch (IOException e)
            {            	
            	e.printStackTrace();
                sendErrPacket(ERROR.ERR_NOT_DEFINED, e.getMessage());
                log.info(getClient() + e.getMessage());
                retorno= false;
            }
            catch (Throwable t)
            {
                t.printStackTrace();
                log.info("Some unrecoverable error occured. cannot continue with client: " + t);
                retorno= false;
            }

           
            if (receive == null)
            	retorno = false;        	
          
            
            if(retorno!=false){
	            data = receive.getData();
	            totalSize += data.length;
	            log.info("totalSize of receiveid packets in receiveFileFromClient: " + totalSize);
	
	            // check that maximum file size
	            if (totalSize > getTransferSize())
	            {
	                sendErrPacket(ERROR.ERR_NOT_DEFINED, "Exceed MFY buffer size");
	                log.info(getClient() + " Client tries to write file and exceed buffer size!");
	                retorno= false;
	            }
            }
            if(retorno!=false){
	            try
	            {
	                os.write(data);
	                blockNumber = receive.getBlockNr();
		            send = new ACK(blockNumber);
	            }
	            catch (IOException e)
	            {
	                sendErrPacket(ERROR.ERR_ILLEGAL_OP, e.getMessage());
	                log.info("OutputStream got closed in receiveFileFromClient: " + e.getMessage() + " caused by: " + e.getCause());
	                retorno= false;
	            }	           
            }
            if(retorno==false){
            	break;
            }
        }
        while (data.length == TFTPSocket.BLOCK_SIZE);

		// Because the sendLastAckForDataPacket call can take ages, we close the output stream before sending this ack
		try
		{
			os.close(); 
		}
		catch (IOException e)
		{
			log.info("problem while closing OutputStream in receiveFileFromClient: " + e.getMessage() + " caused by: " + e.getCause());
			retorno= false;
		}
        // send last packet and wait if the last data is transmitted
        // if so resent the last ACK.
        // what if an ERROR packet is received at this point?
        // we still flag sucessfull datatransfer
		if(retorno!=false) {

			sendLastAckForDataPacket(receive);
		}

        return retorno;
    }

    /**
     * This method will send a file to the client after a read request
     * Because the client buffers are slow to process the package
     * in case of the LSDM it will set a special flag when a package
     * is resent, as soon as the data is acknowledge the next data
     * packet will be sent, it will check and see the special flag, clear the flag
     * and sent for once the new data packet with a doubled time out
     * this gives the LSDM time to also process the possibly delayed
     * data package
     */
    public boolean sendFileToClient(
    /*		byte[] fileContent,*/
    InputStream is, InetAddress clientAddress, int clientPort, boolean useOptions)
    {
        // If file content is null or {}, nothing to send
        /*		if (fileContent == null || fileContent.length == 0)
        		{
        			return false;
        		} */
        if (clientAddress == null || clientPort == 0)
        {
            return false;
        }
        tftpSock.connect(clientAddress, clientPort);

        log.info("clearing socket buffer");
        // clear any duplicate packages in socket queue before processing the new request
        tftpSock.clear();

 //       int offset = 0;
        byte[] data = new byte[TFTPSocket.BLOCK_SIZE];
        InputStream bis = new BufferedInputStream(is);
        int read = 0;

        int blockNumber = 0;

        ACK send; //filled with OACK or DATA
        ACK expect;
        ACK receive;

        try
        {
            // if frq has options then we first OACK and receive ACK 
            if (useOptions)
            {
                TFTPOptions options = new TFTPOptions();
                options.setTimeout(getTimeout());
                options.setPorta(getPorta());
                options.setTransferSize(getTransferSize());
                options.setAuxiliar(getAuxiliar());
                send = new OACK(0, options);
//                System.out.println("Timeout: " + options.getTimeout() + 
//                		"\nPorta: " + options.getPorta() + 
//                		"\nTransferSize: " + options.getTransferSize() +
//                		"\nAuxiliar: " + options.getAuxiliar());
            }
            else
            {
                // try to read TFTPSocket.BLOCK_SIZE of data from the stream
                read = bis.read(data);
                // if -1 is returned stream is closed,
                if (read <= 0)
                    return false;
                send = new DATA(++blockNumber, data, 0, read);
            }
            expect = new ACK(blockNumber);
            receive = (ACK) TFTPUtils.dataTransfer(tftpSock, send, expect);
            if (receive == null)
                return false;
            if (!useOptions && (read < TFTPSocket.BLOCK_SIZE))
                return true;
        }
        catch (ClassCastException e)
        {
            log.info("CODING ERRO? this case should be fetched in DataTransfer!");
            return false;
        }
        catch (InstantiationException e)
        {
            log.info("CODING ERROR: Could not create DATA and ACK packet in sendFileToClient");
            return false;
        }
        catch (IOException e)
        {
            sendErrPacket(ERROR.ERR_NOT_DEFINED, e.getMessage());
            log.info(getClient() + e.getMessage());
            return false;
        }
        catch (Throwable t)
        {
            t.printStackTrace();
            log.info("Some unrecoverable error occured. cannot continue with client: " + t);
            return false;
        }

        do
        {
            try
            {
                read = bis.read(data);
                // when eof is encountered and last block equaled BLOCK_SIZE we need to
                // send zero block
                if (read < 0)
                    read = 0;

                send = new DATA(++blockNumber, data, 0, read);
                expect = new ACK(blockNumber);
                receive = (ACK) TFTPUtils.dataTransfer(tftpSock, send, expect);
                if (receive == null)
                    return false;
            }
            catch (ClassCastException e)
            {
                log.info("CODING ERROR? this case should be fetched in DataTransfer!");
                return false;
            }
            catch (InstantiationException e)
            {
                log.info("CODING ERROR: Could not create DATA and ACK packet in sendFileToClient");
                return false;
            }
            catch (IOException e)
            {
                sendErrPacket(ERROR.ERR_NOT_DEFINED, e.getMessage());
                log.info(getClient() + e.getMessage());
                return false;
            }
            catch (Throwable t)
            {
                t.printStackTrace();
                log.info("Some unrecoverable error occured. Cannot continue with client: " + t);
                return false;
            }
        }
        while (read == TFTPSocket.BLOCK_SIZE);
        return true;
    }

    void sendDataPacket(int blocknumber, byte[] data, int offset, int dataSize)
    {
        try
        {
            TFTPPacket tftpP = new DATA(blocknumber, data, offset, dataSize);
            tftpSock.write(tftpP);
        }
        catch (Exception e)
        {
            log.info(getClient() + " UDP send DATA packet failure.");
            log.info(e.toString());
        }
        log.info("SEND DATA" + " [" + getClient() + "] BN=[" + blocknumber + "]");
    }

    void sendAckPacket(int blocknumber)
    {
        try
        {
            TFTPPacket tftpP = new ACK(blocknumber);
            tftpSock.write(tftpP);
        }
        catch (Exception e)
        {
            log.info(getClient() + " UDP send ACK packet failure.");
            log.info(e.toString());
        }
        log.info("SEND ACK" + " [" + getClient() + "] BN=[" + blocknumber + "]");
    }

    void sendErrPacket(int errorCode, String errorMsg)
    {
        try
        {
            TFTPPacket tftpP = new ERROR(errorCode, errorMsg);
            tftpSock.write(tftpP);
        }
        catch (Exception e)
        {
            log.info(getClient() + " UDP send ERROR packet failure.");
            log.info(e.toString());
            return;
        }
        log.info("SEND ERROR" + " [" + getClient() + "] EC = [" + errorCode + "] " + errorMsg);
    }

    // for now this is constant, in future this will become settable per product
    
    private int tsize = TFTPDefines.DEFAULT_TSIZE;

    TFTPSocket tftpSock;

    private IdwLogger log;

    /**
     * Returns the timeout to wait for package in seconds
     * @return timeout in seconds
     */
    public int getTimeout()
    {
        return timeout;
    }    

    /**
     * Sets the timeout to wait for package in seconds
     * @param timeout The timeout to set
     */
    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
        try
        {
            if (tftpSock != null)
                tftpSock.setSocketTimeOut(timeout);
        }
        catch (SocketException e)
        {
            log.info("Could not set socket timeout on worker socket!");
        }
    }
    
    /**
     * Returns the porta to wait for package
     * @return porta 
     */
    public int getPorta()
    {
    	 if (tftpSock != null)
                return tftpSock.getLocalPort();
    	 else
            log.info("Could not get socket port on worker socket!");
    	 return -1;       
    }    

  

    /**
     * Returns the tsize.
     * @return int
     */
    public int getTransferSize()
    {
        return tsize;
    }

    /**
     * Sets the tsize.
     * @param tsize The tsize to set
     */
    public void setTransferSize(int tsize)
    {
        this.tsize = tsize;
    }

    private boolean ackReceived = true;
    /**
     * Use this method to see if the last ack was sucessfully sent and the data
     * does not need to be resent. If it seems that a new request comes in from
     * the same client we know that the ack was received successfully
     */
    public void sendLastAckForDataPacket(DATA data)
    {
        try
        {
            setAckReceived(false);
            sendAckPacket(data.getBlockNr());

            // wait for a period of timeout for resend of DATA or new RRQ
            tftpSock.setSockTimeoutMSec(TFTPDefines.timoutSOSocket);
           
            int count = 10;// = *1000/100
            while ((!getAckReceived()) && (count > 0))
            {
                count--;
                TFTPPacket tftpP = tftpSock.read();
                if (tftpP == null) {
                    continue;
                }
                if (tftpP instanceof DATA)
                {
                    sendAckPacket(data.getBlockNr());
                }
                if (tftpP instanceof ERROR)
                {
                    // this is theoraticly possible, what to do with it????
                }
            }
            // for sure client received packet
        }
        catch (Throwable t)
        {
            log.info("Could not wait to check if last ack was received by client!");
        }
        finally
        {
            // time passed that client could retrieve resent of last data packet
            setAckReceived(true);
            setTimeout(timeout);
        }
    }

    public synchronized void setAckReceived(boolean ackReceived)
    {
        this.ackReceived = ackReceived;
    }

    public synchronized boolean getAckReceived()
    {
        return ackReceived;
    }

    public void newRequest()
    {
        setAckReceived(true);
        try
        {
            Thread.sleep(150);
        }
        catch (InterruptedException e)
        {}
    }

    public boolean waitingForNewRequest()
    {
        return !getAckReceived();
    }
    
    private String auxiliar = TFTPDefines.DEFAULT_AUX;

    /**
     * Returns the timeout to wait for package in seconds
     * @return timeout in seconds
     */
    public String getAuxiliar()
    {
        return auxiliar;
    }    

    /**
     * Sets the timeout to wait for package in seconds
     * @param timeout The timeout to set
     */
    public void setAuxiliar(String auxiliar)
    {
        this.auxiliar = auxiliar;
    }

}

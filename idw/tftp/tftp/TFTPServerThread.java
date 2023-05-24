package tftp;

import idw.util.IdwLogger;


import idw.model.rn.DataHoraRN;
import ms.util.UtilsThreads;

public class TFTPServerThread extends Thread{
	private IdwLogger log;
	private boolean isThreadExecutando = true;
	private String pathRelativo="";
		
	public TFTPServerThread(String pathRelativo,IdwLogger log) {
		this.log=log;
		this.setName("TFTPServerThread-" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(DataHoraRN.getDataHoraAtual()));
		this.pathRelativo=pathRelativo;
		
	}

	@Override
	public void run() {	
		ServerCore server = new ServerCore(log,pathRelativo);
		try
		{
			server.connect();
		}
		catch (Exception e)
		{
			log.info("Exception occured: " + e);
			e.printStackTrace();
		}
		while (this.isThreadExecutando == true){ 
			UtilsThreads.pausaNaThread(10000);
		}
		try
		{
			server.disconnect();
		}
		catch (Exception e)
		{
			log.info("Exception occured: " + e);
			e.printStackTrace();
		}
	}

	public void pararThread(){
		this.isThreadExecutando = false;
	}
}
